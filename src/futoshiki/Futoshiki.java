/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futoshiki;

import java.awt.Color;
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
        int N = 4;
        Node [][] nodes = new Node[N][N];
        Game game = new Game();
        //Backtracking bct = new Backtracking();
        
        for(int i = 0; i < nodes.length; i++){
            for(int j = 0; j < nodes.length; j++){
                nodes[i][j] = new Node( null, null);
                nodes[i][j].setInitial(false);
            }
        }
        
        /*for(int j = 0; j < 4; j++){
            int rd1 = sc.nextInt(N-1);
            int rd2 = sc.nextInt(N-1);
            int rd3 = sc.nextInt(N)+1;
            nodes[rd1][rd2].setValue(rd3);
            nodes[rd1][rd2].setInitial(true);
            nodes[rd1][rd2].setColor(Color.black);
        }*/
        
        for(int j = 0; j < 1; j++){
            nodes[sc.nextInt(N-1)][sc.nextInt(N-1)].setRowConstraint("<");
        }
        /*for(int j = 0; j < 1; j++){
            nodes[sc.nextInt(N-1)][sc.nextInt(N-1)].setColumnConstraint(">");
        }*/
        //game.checkGame(nodes);
        game.print(nodes);
        //bct.nodes = nodes;
        if (Backtracking.solve(nodes, 0, 0)){
            game.checkGame(nodes);
            game.print(nodes);
        }
        else
            System.out.println("No Solution exists");
    }
    
}
