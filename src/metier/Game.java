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
    
    public boolean checkGame(Node [][] nodes){
        boolean valid = true;

        for(int i = 0; i < nodes.length; i++){
            for(int j = 0;  j < nodes.length; j++){
                if(nodes[i][j].isInitial()) nodes[i][j].setColor(Color.black);
                else nodes[i][j].setColor(Color.green);
            }
        }
        
        for(int i = 0; i < nodes.length; i++){
            for(int j = 0;  j < nodes.length; j++){
                int val = nodes[i][j].getValue();
                if(val < 1 || val > nodes.length){
                    valid = false;
                    break;
                }
                for(int k = j + 1; k < nodes.length; k++){
                    if(nodes[i][j].getValue() == nodes[i][k].getValue()){
                        nodes[i][j].setColor(Color.red);
                        nodes[i][k].setColor(Color.red);
                        valid = false;
                    }
                }
                for(int k = i + 1; k < nodes.length; k++){
                    if(nodes[i][j].getValue() == nodes[k][j].getValue()){
                        nodes[i][j].setColor(Color.red);
                        nodes[k][j].setColor(Color.red);
                        valid = false;
                    }
                }
                
                if(i < nodes.length - 1 && nodes[i][j].hasRowConstraint() && !nodes[i][j].checkNextRowValue(nodes[i+1][j].getValue())){
                    nodes[i][j].setColor(Color.red);
                    nodes[i+1][j].setColor(Color.red);
                }
                if(j < nodes.length - 1  && nodes[i][j].hasColumnConstraint() && !nodes[i][j].checkNextColumnValue(nodes[i][j+1].getValue())){
                    nodes[i][j].setColor(Color.red);
                    nodes[i][j+1].setColor(Color.red);
                }
            }
        }
        return valid;
    }
    
    public void print(Node [][] nodes){
        System.out.println("----------------------------------------");
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
        System.out.println("----------------------------------------");
    }
}
