/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futoshiki;

import java.util.Random;
import metier.*;

/**
 *
 * @author Toihir
 */
public class Futoshiki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("hello world");
        Random sc = new Random();
        Node [][] nodes = new Node[4][4];
        
        for(int i = 0; i < nodes.length; i++){
            for(int j = 0; j < nodes.length; j++){
                nodes[i][j] = new Node(sc.nextInt(5)+1, null, null);
            }
        }
        
        for(int i = 0; i < nodes.length; i++){
            String [] columnConstaint = new String[4];
            for(int j = 0; j < nodes.length; j++){
                System.out.print(nodes[i][j] + "\t");
                columnConstaint[i] = nodes[i][j].getColumnConstraint();
            }
            System.out.println();
            for(int j = 0; j < nodes.length; j++){
                System.out.print(columnConstaint[j] + "\t\t");
            }
            System.out.println();
        }
    }
    
}
