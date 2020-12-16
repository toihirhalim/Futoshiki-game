/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.awt.Color;
/**
 *
 * @author Toihir
 */
public class Game {
    public Game(){}
    
    public boolean check(Node [][] nodes){
        boolean valid = true;

        for(int i = 0; i < nodes.length; i++){
            for(int j = 0;  j < nodes.length; j++){
                nodes[i][j].setColor(Color.black);
            }
        }
        
        for(int i = 0; i < nodes.length; i++){
            for(int j = 0;  j < nodes.length; j++){
                for(int k = j + 1; k < nodes.length; k++){
                    if(nodes[i][j].getValue() == nodes[i][k].getValue()){
                        nodes[i][j].setColor(Color.red);
                        nodes[i][k].setColor(Color.red);
                        valid = false;
                    }
                    if(nodes[j][i].getValue() == nodes[k][k].getValue()){
                        nodes[i][j].setColor(Color.red);
                        nodes[i][k].setColor(Color.red);
                        valid = false;
                    }
                }
            }
        }
        return valid;
    }
    
    public static void main(String [] args){
        
    }
}
