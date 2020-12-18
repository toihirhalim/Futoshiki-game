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
        Game game = new Game();
        
        for(int i = 0; i < nodes.length; i++){
            for(int j = 0; j < nodes.length; j++){
                nodes[i][j] = new Node(sc.nextInt(4)+1, null, null);
                nodes[i][j].setInitial(false);
            }
        }
        for(int j = 0; j < 3; j++){
            nodes[sc.nextInt(3)][sc.nextInt(3)].setRowConstraint("<");
        }
        for(int j = 0; j < 3; j++){
            nodes[sc.nextInt(3)][sc.nextInt(3)].setColumnConstraint(">");
        }
        game.checkGame(nodes);
        for(int i = 0; i < nodes.length; i++){
            for(int j = 0; j < nodes.length; j++){
                System.out.print(nodes[i][j] + "\t");
            }
            System.out.println();
            for(int j = 0; j < nodes.length; j++){
                String col = nodes[i][j].getRowConstraint() != null ? nodes[i][j].getRowConstraint() : " ";
                System.out.print(col + "\t");
            }
            System.out.println();
        }
    }
    
}
