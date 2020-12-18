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
    static int N = 4;
    
    public static boolean solve(Node [][] nodes, int row, int col){
        if (row == N - 1 && col == N)
            return true;
 
        if (col == N) {
            row++;
            col = 0;
        }
 
        if (nodes[row][col].getValue() != 0)
            return solve(nodes, row, col + 1);
 
        for (int num = 1; num <= N ; num++) {
 
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
 
        int i = row;
        int j = col;
        
        if(i < nodes.length - 1 && nodes[i][j].hasRowConstraint() && !nodes[i][j].checkNextRowValue(nodes[i+1][j].getValue())){
            return false;
        }
        if(j < nodes.length - 1  && nodes[i][j].hasColumnConstraint() && !nodes[i][j].checkNextColumnValue(nodes[i][j+1].getValue())){
            return false;
        }
        
        i = row -1;
        j = col;
        
        if(i >= 0 && nodes[i][j].hasRowConstraint() && !nodes[i][j].checkNextRowValue(nodes[i+1][j].getValue())){
            return false;
        }
        
        i = row;
        j = col -1;
        
        if(j >= 0  && nodes[i][j].hasColumnConstraint() && !nodes[i][j].checkNextColumnValue(nodes[i][j+1].getValue())){
            return false;
        }
 
        return true;
    }
}
