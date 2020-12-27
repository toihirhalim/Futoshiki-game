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

/**
 * cette classe va appliquer l'algorithme du backtracking 
 * pour resoudre un game FUTOSHIKI
 */

public class Backtracking {
    
    //fonction qui verifie si une game contien une solution
    public static boolean solve(Node [][] nodes, int row, int col){
        // si on a pas des nodes on return false
        if(nodes == null) return false;
        
        //si on termine tous les nodes sans aucune contrainte racontré  on retourne true
        if (row == nodes.length - 1 && col == nodes.length)
            return true;
 
        // si on arrive a la fin de la ligne on passe a la ligne suivante
        if (col == nodes.length) {
            row++;
            col = 0;
        }
        
        /*
        un node de type initiale ne va pas etre changé 
        on passe dirrectement au colone suivant
        */
        if (nodes[row][col].isInitial())
            return solve(nodes, row, col + 1);
 
        //on teste tout les valeurs [1 - N]
        for (int num = 1; num <= nodes.length ; num++) {
            
            //on teste les valeurs si c est possible(aucune contraite) on passe a la case suivate 
            if (isSafe(nodes, row, col, num)) {
                nodes[row][col].setValue(num);
                if (solve(nodes, row, col + 1))
                    return true;
            }
            
            //si non on remet la case a vide  (0 represente vide)
            nodes[row][col].setValue(0);
        }
        return false;
    }
    
    //fonction qui verifie la possibilité de plaver une valeur dans une case
    static boolean isSafe(Node [][] nodes, int row, int col, int num)
    {
        //si la valeur est repeté dans la meme ligne on retourne false
        for (int x = 0; x < nodes.length; x++)
            if (nodes[row][x].getValue() == num)
                return false;
 
        
        //si la valeur est repeté dans la meme colone on retourne false
        for (int x = 0; x < nodes.length; x++)
            if (nodes[x][col].getValue() == num)
                return false;
 
        Node top = row - 1 >= 0 ? nodes[row -1][col] : null;
        Node left = col - 1 >= 0 ? nodes[row][col -1] : null;
        Node bottom = row + 1 < nodes.length ? nodes[row +1][col] : null;
        Node right = col + 1 < nodes.length ? nodes[row][col +1] : null;
        
        // on valide la case avec les 4 autres entourant avec leurs contraintes si ils existent
        if(!nodes[row][col].validConstraint(top, left, bottom, right, num)){
            return false;
        }
 
        return true;
    }
}
