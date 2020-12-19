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

import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Toihir
 */
public class DataBase {
    public static Document document;
    public static Element racine;
    public static String pracine = "games";
    public static String fichier = "games.txt";
    
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
    public static boolean saveGame(Node [][] nodes){
        initialize();
        
        return true;
    }
    
    public static Node [][] getGame(int N){
        initialize();
        
        return null;
    }
}
