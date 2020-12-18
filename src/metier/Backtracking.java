/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

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
 
        
 
        return true;
    }
}
