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

    public Node() { }
    
    public Node(int value, Color color, String rowConstraint, String columnConstraint) {
        this.value = value;
        this.color = color;
        this.rowConstraint = rowConstraint;
        this.columnConstraint = columnConstraint;
    }
    
    public Node(int value, Color color) {
        this.value = value;
        this.color = color;
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
        if(this.color != Color.black){
            this.color = color;
        }
    }

    public String getRowConstraint() {
        return rowConstraint;
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
    
    @Override
    public String toString() {
        String col = this.color==Color.red ? "r" : this.color==Color.green ? "g" : "b";
        
        return "" + value + "color: " + col;
    }
    
}
