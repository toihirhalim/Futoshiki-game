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
    
    Node [][] nodes;
    
    public Game(){}
    
    // creer un game de N
    public Node [][] getGame(int N){
        //on reprend la partie enregistré
        Node [][] nodes = DataBase.getGame(N);
        
        // on retourne celui par defaut
        
        if(nodes == null){
            nodes = Default.getGame(N);
        }
        return nodes;
    }
    
    public Node [][] getLastGame(){
        //on prend la derniere partie joué
        Node [][] nodes = DataBase.getLastGame();
        
        //si non on retourne celui par defaut de 4*4 cases
        if(nodes == null){
            nodes = Default.getGame(4);
        }
        return nodes;
    }
    public Node [][] random(int N){
        Node [][] nodes = new Node[N][N];
        for(int i = 0; i  < nodes.length ; i++){
            for(int j = 0; j < nodes.length; j++){
                nodes[i][j] = new Node();
            }
        }
        
        /*
            generate here random constraint
        */
        return nodes;
        /*Node [][] copy = nodes;
        if(Backtracking.solve(copy, 0, 0)){
            return nodes;
        }
        return null;*/
    }
    public void getInitialGame(Node [][] nodes){
        /*
        prendre la partie initiale en eliminant tous les cases qui ne sont pas initiales
        */
        for(int i = 0; i  < nodes.length ; i++){
            for(int j = 0; j < nodes.length; j++){
                if(!nodes[i][j].isInitial()){
                    nodes[i][j].setValue(0);
                }
            }
        }
    }
    public void saveGame(Node [][] nodes){
        //enregistrer une partie 
        DataBase.saveGame(nodes);
    }
    public boolean solve(Node [][] nodes){
        //resoudre une partie
        return Backtracking.solve(nodes, 0, 0);
    }
    
    //fonction d assistance d une partie en montrant les erreurs (contraintes)
    public boolean checkGame(Node [][] nodes){
        boolean valid = true;
        if(nodes == null) return true;
        for(int i = 0; i < nodes.length; i++){
            for(int j = 0;  j < nodes.length; j++){
                //on colore tous les cases initiales en noir et les restes en vert
                if(nodes[i][j].isInitial()) nodes[i][j].setColor(Color.black);
                else nodes[i][j].setColor(Color.green);
                
                nodes[i][j].setColumnConstraintColor(Color.black);
                nodes[i][j].setRowConstraintColor(Color.black);
            }
        }
        
        for(int i = 0; i < nodes.length; i++){
            for(int j = 0;  j < nodes.length; j++){
                int val = nodes[i][j].getValue();
                if(val < 1 || val > nodes.length){
                    valid = false;
                }else{
                    //pour chaque case on colore tous les cases a valeurs repeté dans la meme ligne en rouge
                    for(int k = j + 1; k < nodes.length; k++){
                        if(nodes[i][j].getValue() == nodes[i][k].getValue()){
                            nodes[i][j].setColor(Color.red);
                            nodes[i][k].setColor(Color.red);
                            valid = false;
                        }
                    }
                    //pour chaque case on colore tous les cases a valeurs repeté dans la meme colone en rouge
                    for(int k = i + 1; k < nodes.length; k++){
                        if(nodes[i][j].getValue() == nodes[k][j].getValue()){
                            nodes[i][j].setColor(Color.red);
                            nodes[k][j].setColor(Color.red);
                            valid = false;
                        }
                    }
                    
                    //si une case contient une contraine non valide avec la valeur suivant en bas on colore sa contraine en rouge 
                    if(i < nodes.length - 1 && nodes[i][j].hasRowConstraint() && !nodes[i][j].checkNextRowValue(nodes[i+1][j].getValue())){
                        nodes[i][j].setRowConstraintColor(Color.red);
                    }
                    //si une case contient une contraine non valide avec la valeur suivant a droite on colore sa contraine en rouge 
                    if(j < nodes.length - 1  && nodes[i][j].hasColumnConstraint() && !nodes[i][j].checkNextColumnValue(nodes[i][j+1].getValue())){
                        nodes[i][j].setColumnConstraintColor(Color.red);
                    }
                }
            }
        }
        return valid;
    } 
    public void print(Node [][] nodes){
        
        //afiche d une partie a la console
        if(nodes == null) return;
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
