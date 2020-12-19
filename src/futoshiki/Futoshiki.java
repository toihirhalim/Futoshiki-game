/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futoshiki;

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
        Game game = new Game();
        int N = 4;
        Node [][] nodes = game.gameInit(N);
        
        game.print(nodes);
        if (Backtracking.solve(nodes, 0, 0)){
            game.checkGame(nodes);
            game.print(nodes);
        }
        else
            System.out.println("No Solution exists");
        nodes = DataBase.getGame(N);
    }
    
}
