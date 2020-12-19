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
    
    public Node(String value, String color, String rowConstraint, String columnConstraint, String initial) {
        int val;
        try{
            val = Integer.parseInt(value);
        }catch(Exception e){
            val = 0;
        }
        this.value = val;
        this.color = color != null ? color.equals("r") ? Color.red : color.equals("g") ? Color.green : Color.black : Color.black;
        this.rowConstraint = rowConstraint;
        this.columnConstraint = columnConstraint;
        this.initial = initial != null ? initial.equals("true") ? true : false : false;
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
    
    public boolean checkNextRowValue(int nextVal){
        if(this.hasRowConstraint() && nextVal != 0){
            return this.rowConstraint.equals(inf) ? this.value < nextVal : this.value > nextVal;
        }
        return true;
    }
    
    public boolean checkNextColumnValue(int nextVal){
        if(this.hasColumnConstraint() && nextVal != 0){
            return this.columnConstraint.equals(inf) ? this.value < nextVal : this.value > nextVal;
        }
        return true;
    }
    
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
