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
public class Backtracking {
    static int a = 1;
    
    public static boolean solve(Node [][] nodes, int row, int col){
        if (row == nodes.length - 1 && col == nodes.length)
            return true;
 
        if (col == nodes.length) {
            row++;
            col = 0;
        }
 
        if (nodes[row][col].getValue() != 0)
            return solve(nodes, row, col + 1);
 
        for (int num = 1; num <= nodes.length ; num++) {
 
            if (isSafe(nodes, row, col, num)) {
                nodes[row][col].setValue(num);
                if (solve(nodes, row, col + 1))
                    return true;
            }
            
            nodes[row][col].setValue(0);
        }
        return false;
    }
    
    static boolean isSafe(Node [][] nodes, int row, int col, int num)
    {
 
        for (int x = 0; x < nodes.length; x++)
            if (nodes[row][x].getValue() == num)
                return false;
 
        
        for (int x = 0; x < nodes.length; x++)
            if (nodes[x][col].getValue() == num)
                return false;
 
        Node top = row - 1 >= 0 ? nodes[row -1][col] : null;
        Node left = col - 1 >= 0 ? nodes[row][col -1] : null;
        Node bottom = row + 1 < nodes.length ? nodes[row +1][col] : null;
        Node right = col + 1 < nodes.length ? nodes[row][col +1] : null;
        
        if(!nodes[row][col].validConstraint(top, left, bottom, right, num)){
            return false;
        }
 
        return true;
    }
}
