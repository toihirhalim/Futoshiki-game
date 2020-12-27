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

/*
    cette classe represente une case du jeu 
    il contien en generale  une valeur 
    et la possibilité d avoir 2 contraintes a droite ou en bas 
*/

public class Node {
    
    public static String sup = ">";
    public static String inf = "<";
    
    private int value;                      // valeur de la case
    private Color color;                    // couleur de la case
    private Color rowConstraintColor;       // contrainte en bas
    private Color columnConstraintColor;    // couleur du contrainte en bas
    private String rowConstraint;           // contrainte a droite
    private String columnConstraint;        // couleur du contrainte a droite
    private boolean initial = false;        // si la case contient une valeure initiale

    
    // constructeurs, getters et setters et quelques fonction de test sur les  contraintes
    public Node() { }   
    public Node(String value, String rowConstraint, String columnConstraint, String initial) {
        int val;
        try{
            val = Integer.parseInt(value);
        }catch(Exception e){
            val = 0;
        }
        this.value = val;
        this.rowConstraint = rowConstraint;
        this.columnConstraint = columnConstraint;
        this.initial = initial != null ? initial.equals("true"): false;
        this.color = this.initial ? Color.black : Color.green;
    }   
    public Node(int value, String rowConstraint, String columnConstraint) {
        this.value = value;
        this.color = Color.black;
        this.rowConstraint = rowConstraint;
        this.columnConstraint = columnConstraint;
        this.initial = true;
    }    
    public Node(String rowConstraint, String columnConstraint) {
        this.rowConstraint = rowConstraint;
        this.columnConstraint = columnConstraint;
        this.color = Color.green;
        this.value = 0;
    }
    public Color getRowConstraintColor() {
        return rowConstraintColor;
    }
    public void setRowConstraintColor(Color rowConstraintColor) {
        this.rowConstraintColor = rowConstraintColor;
    }
    public Color getColumnConstraintColor() {
        return columnConstraintColor;
    }
    public void setColumnConstraintColor(Color columnConstraintColor) {
        this.columnConstraintColor = columnConstraintColor;
    }
    public int getValue() {
        return value;
    }    
    public String getValueString() {
        return "" + value;
    }
    public void setValue(int value) {
        this.value = value;
    }   
    public void setDefaultValue(int value){
        this.value = value;
        this.initial = true;
        this.color = Color.black;
    }
    public Color getColor() {
        return color;
    }    
    public String getColorName() {
        return this.color==Color.red ? "r" : this.color==Color.green ? "g" : "b";
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public String getRowConstraint() {
        return rowConstraint;
    }
    public boolean isInitial() {
        return initial;
    }   
    public String getInitial() {
        return "" + initial;
    }    
    public void setInitial(boolean val) {
        this.initial = val;
    }    
    public void setRowConstraint(String rowConstraint) {
        if(rowConstraint.equals(inf) || rowConstraint.equals(sup)) this.rowConstraint = rowConstraint;
        else this.rowConstraint = null;
    }
    public String getColumnConstraint() {
        return columnConstraint;
    }
    public void setColumnConstraint(String columnConstraint) {
        if(columnConstraint.equals(inf) || columnConstraint.equals(sup)) this.columnConstraint = columnConstraint;
        else this.columnConstraint = null;
    }    
    public boolean hasRowConstraint(){
        return this.rowConstraint != null && (this.rowConstraint.equals(sup) || this.rowConstraint.equals(inf));
    }    
    public boolean hasColumnConstraint(){
        return this.columnConstraint != null && (this.columnConstraint.equals(sup) || this.columnConstraint.equals(inf));
    }    
    public boolean hasConstraint(){
        return this.hasColumnConstraint() || this.hasRowConstraint();
    }    
    
    // fonction qui valide la contrainte sur l 'element de la ligne suivante
    public boolean checkNextRowValue(int nextVal){
        if(this.hasRowConstraint() && nextVal != 0){
            return this.rowConstraint.equals(inf) ? this.value < nextVal : this.value > nextVal;
        }
        return true;
    }    
    
    // fonction qui valide la contrainte sur l 'element de la colone suivante
    public boolean checkNextColumnValue(int nextVal){
        if(this.hasColumnConstraint() && nextVal != 0){
            return this.columnConstraint.equals(inf) ? this.value < nextVal : this.value > nextVal;
        }
        return true;
    }    
    
    // fonction qui valide les contraintes sur tous les cotés d une case
    public boolean validConstraint(Node top, Node left, Node bottom, Node right,int val){
        boolean test = true;
        
        if(top != null && top.getValue() != 0 && top.hasRowConstraint()){
            test =  top.rowConstraint.equals(inf)? top.value < val : top.value > val;
            if(!test) return test;
        }
        
        if(left != null && left.getValue() != 0 && left.hasColumnConstraint()){
            test = left.columnConstraint.equals(inf) ? left.value < val : left.value > val;
            if(!test) return test;
        }
        
        if(bottom != null && bottom.getValue() != 0 && this.hasRowConstraint()){
            test = this.rowConstraint.equals(inf) ? val < bottom.getValue() : val > bottom.getValue();
            if(!test) return test;
        }
        
        if(right != null && right.getValue() != 0 && this.hasColumnConstraint()){
            test = this.columnConstraint.equals(inf) ? val < right.getValue() : val > right.getValue();
            if(!test) return test;
        }
        
        return test;
    }    
    @Override
    public String toString() {
        String c = columnConstraint != null ? columnConstraint : " ";
        String val = value != 0 ? "" + value : " ";
        return "" + val + " " + getColorName() + " " + c;
    }
    
}
