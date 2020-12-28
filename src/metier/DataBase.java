/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.jdom2.Attribute;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Toihir
 */

/*
 cette classe agit comme base de donné de forme xml 
peux enregistrer et reload un game
*/

public class DataBase {
    static Document document;
    static Element racine;
    static String pracine = "games";
    static String fichier = "games.xml";
    static String game = "game";
    
    //prendre le fichier xml s'il existe ou le créer
    public static void initialize() {
        try {
            lireFichier();
        }catch(Exception e) {
            document = new Document();
            racine = new Element(pracine);
            document.addContent(racine);
            enregistre();
        }
    }   
    //enregistrer le fichier
    static void enregistre() {
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            sortie.output(document, new FileOutputStream(fichier));
        } catch (java.io.IOException e) {}
    }   
    //lire le fichier
    static void lireFichier() throws Exception {
        SAXBuilder sxb = new SAXBuilder();
        document = sxb.build(new File(fichier));
        racine = document.getRootElement();
    }
    //ajouter un game au fichier
    static boolean ajouterGame(Node [][] nodes) {
        try {
            String Id = "" + nodes.length; //chaque game est representé par ses nombre de cases
            Element game = getGame(Id);
            
            //supprimer s'il existe deja une avec le meme ID (nombre de cases)
            if(game != null){
                racine.removeContent(game);
            }
            
            game = new Element("game");
            Attribute id = new Attribute("id", "" + nodes.length);
            game.setAttribute(id);
            
            //ajouter tous les nodes a l element (game) 
            for(int i = 0; i  < nodes.length ; i++){
                for(int j = 0; j < nodes.length; j++){
                    
                    /*
                        un element node contient ses position comme attributs (i, j) et valeur , contraintes et initiale comme elements
                    */
                    Element node = new Element("node");
                    game.addContent(node);
                    Attribute x = new Attribute("x", "" + i);
                    Attribute y = new Attribute("y", "" + j);
                    node.setAttribute(x);
                    node.setAttribute(y);
                    Element value = new Element("value");
                    Element rowConstraint = new Element("rowConstraint");
                    Element columnConstraint = new Element("columnConstraint");
                    Element initial = new Element("initial");
                    value.setText(nodes[i][j].getValueString());
                    rowConstraint.setText(nodes[i][j].getRowConstraint());
                    columnConstraint.setText(nodes[i][j].getColumnConstraint());
                    columnConstraint.setText(nodes[i][j].getColumnConstraint());
                    initial.setText(nodes[i][j].getInitial());
                    node.addContent(value);
                    node.addContent(rowConstraint);
                    node.addContent(columnConstraint);
                    node.addContent(initial);
                }
            }
            racine.addContent(game);
        } catch (Exception e) {
            return false;
        }
        return true;
    }   
    //recherche d une element (game) par l'id (nombre de cases)
    static Element getGame(String id) {
        List<Element> games = racine.getChildren(game);
        Iterator<Element> i = games.iterator();
        
        Element last = null;
        while (i.hasNext()) {
            Element courant = (Element) i.next();
            if (id != null && id.equals("0")){
                last = courant;
            }
            String att = courant.getAttributeValue("id");
            if (id != null && id.equals(att)) {
                return courant;
            }
        }
        //par defaut on retourne le deriner
        return last;
    }
    //transformer un element en une game
    static Node [][] toGame(Element game) {
        try{
            List<Element> nodesElement = game.getChildren("node");
            Iterator<Element> i = nodesElement.iterator();
            
            String n = game.getAttributeValue("id");
            int N = Integer.parseInt(n);
            //creation desq nodes
            Node [][] nodes = new Node[N][N];
            
            //on remplit les valeurs et les contraintes des nodes
            while (i.hasNext()) {
                Element courant = (Element) i.next();
                String x = courant.getAttributeValue("x");
                String y = courant.getAttributeValue("y");
                String value = courant.getChild("value").getText();
                String rowConstraint = courant.getChild("rowConstraint").getText();
                String columnConstraint = courant.getChild("columnConstraint").getText();
                String initial = courant.getChild("initial").getText();
                
                int row = Integer.parseInt(x);
                int col = Integer.parseInt(y);

                nodes[row][col] = new Node(value, rowConstraint, columnConstraint, initial);
            }
            return nodes;
        }catch(Exception e){
            return null;
        }
    }
    
    //enregister un game
    public static boolean saveGame(Node [][] nodes){
        initialize();
        ajouterGame(nodes);
        enregistre();
        return true;
    }
    //prendre un game deja enregistré
    public static Node [][] getGame(int N){
        initialize();
        String Id = "" + N;
        Element game = getGame(Id);
        
        if(game != null){
            return toGame(game);
        }
        return null;
    }
    //prendre le dernier game a etre enregistré
    public static Node [][] getLastGame(){
        initialize();
        Element game = getGame("0");
        
        if(game != null){
            return toGame(game);
        }
        return null;
    }
}
