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
public class DataBase {
    static Document document;
    static Element racine;
    static String pracine = "games";
    static String fichier = "games.xml";
    static String game = "game";
    
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
    static void enregistre() {
        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            sortie.output(document, new FileOutputStream(fichier));
        } catch (java.io.IOException e) {}
    }
    static void lireFichier() throws Exception {
        SAXBuilder sxb = new SAXBuilder();
        document = sxb.build(new File(fichier));
        racine = document.getRootElement();
    }
    static boolean ajouterGame(Node [][] nodes) {
        try {
            String Id = "" + nodes.length;
            Element game = getGame(Id);
            if(game != null){
                racine.removeContent(game);
            }
            game = new Element("game");
            Attribute id = new Attribute("id", "" + nodes.length);
            game.setAttribute(id);
            for(int i = 0; i  < nodes.length ; i++){
                for(int j = 0; j < nodes.length; j++){
                    Element node = new Element("node");
                    game.addContent(node);
                    Attribute x = new Attribute("x", "" + i);
                    Attribute y = new Attribute("y", "" + j);
                    node.setAttribute(x);
                    node.setAttribute(y);
                    Element value = new Element("value");
                    Element color = new Element("color");
                    Element rowConstraint = new Element("rowConstraint");
                    Element columnConstraint = new Element("columnConstraint");
                    Element initial = new Element("initial");
                    value.setText(nodes[i][j].getValueString());
                    color.setText(nodes[i][j].getColorName());
                    rowConstraint.setText(nodes[i][j].getRowConstraint());
                    columnConstraint.setText(nodes[i][j].getColumnConstraint());
                    columnConstraint.setText(nodes[i][j].getColumnConstraint());
                    initial.setText(nodes[i][j].getInitial());
                    node.addContent(value);
                    node.addContent(color);
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
        return last;
    }
    static Node [][] toGame(Element game) {
        try{
            List<Element> nodesElement = game.getChildren("node");
            Iterator<Element> i = nodesElement.iterator();
            
            String n = game.getAttributeValue("id");
            int N = Integer.parseInt(n);
            Node [][] nodes = new Node[N][N];
            
            while (i.hasNext()) {
                Element courant = (Element) i.next();
                String x = courant.getAttributeValue("x");
                String y = courant.getAttributeValue("y");
                String value = courant.getChild("value").getText();
                String color = courant.getChild("color").getText();
                String rowConstraint = courant.getChild("rowConstraint").getText();
                String columnConstraint = courant.getChild("columnConstraint").getText();
                String initial = courant.getChild("initial").getText();
                
                int row = Integer.parseInt(x);
                int col = Integer.parseInt(y);

                nodes[row][col] = new Node(value, color, rowConstraint, columnConstraint, initial);
            }
            return nodes;
        }catch(Exception e){
            return null;
        }
    }
    
    
    
    public static boolean saveGame(Node [][] nodes){
        initialize();
        ajouterGame(nodes);
        enregistre();
        return true;
    }
    
    public static Node [][] getGame(int N){
        initialize();
        String Id = "" + N;
        Element game = getGame(Id);
        
        if(game != null){
            return toGame(game);
        }
        return null;
    }
    
    public static Node [][] getLastGame(){
        initialize();
        Element game = getGame("0");
        
        if(game != null){
            return toGame(game);
        }
        return null;
    }
}
