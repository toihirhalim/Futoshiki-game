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
public class Node {
    
    public static String sup = ">";
    public static String inf = "<";
    
    private int value;
    private Color color;
    private String rowConstraint;
    private String columnConstraint;
    private boolean initial = false;

    public Node() { }
    
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
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Color getColor() {
        return color;
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
    
    public boolean checkNextRowValue(int nextVal){
        if(this.hasRowConstraint()){
            return this.rowConstraint.equals(inf) ? this.value < nextVal : this.value > nextVal;
        }
        return true;
    }
    
    public boolean checkNextColumnValue(int nextVal){
        if(this.hasColumnConstraint()){
            return this.columnConstraint.equals(inf) ? this.value < nextVal : this.value > nextVal;
        }
        return true;
    }
    
    @Override
    public String toString() {
        String col = this.color==Color.red ? "r" : this.color==Color.green ? "g" : "b";
        
        return "" + value + "color: " + col;
    }
    
}
