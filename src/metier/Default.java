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
public class Default {
    
    public static Node [][] getGame(int N){
        Node [][] nodes = new Node[N][N];
        
        for(int i = 0; i < nodes.length; i++){
            for(int j = 0; j < nodes.length; j++){
                nodes[i][j] = new Node(null, null);
                nodes[i][j].setInitial(false);
            }
        }
        switch(N){
            case 4: 
                nodes[0][3].setDefaultValue(3);
                nodes[2][2].setDefaultValue(3);
                nodes[0][3].setDefaultValue(3);
                nodes[0][0].setRowConstraint(">");
                nodes[1][1].setRowConstraint(">");
                nodes[2][1].setRowConstraint(">");
                nodes[1][2].setColumnConstraint("<");
            break;
            case 5: 
                nodes[0][4].setDefaultValue(4);
                nodes[0][1].setColumnConstraint("<");
                nodes[0][2].setColumnConstraint("<");
                nodes[2][1].setColumnConstraint("<");
                nodes[2][2].setRowConstraint(">");
                nodes[3][0].setColumnConstraint("<");
                nodes[4][2].setDefaultValue(3);
                nodes[4][2].setColumnConstraint(">");
                nodes[4][3].setColumnConstraint(">");
                break;
            case 6: 
                nodes[0][2].setDefaultValue(4);
                nodes[0][5].setDefaultValue(6);
                nodes[1][3].setDefaultValue(4);
                nodes[4][4].setDefaultValue(4);
                nodes[0][3].setColumnConstraint(">");
                nodes[1][2].setColumnConstraint(">");
                nodes[1][3].setColumnConstraint(">");
                nodes[2][0].setColumnConstraint(">");
                nodes[2][2].setColumnConstraint(">");
                nodes[5][1].setColumnConstraint(">");
                nodes[3][0].setColumnConstraint("<");
                nodes[3][1].setColumnConstraint("<");
                nodes[3][5].setRowConstraint(">");
                nodes[4][4].setRowConstraint(">");
                nodes[0][1].setRowConstraint(">");
                nodes[2][3].setRowConstraint("<");
                nodes[2][4].setRowConstraint("<");
                nodes[4][2].setRowConstraint("<");
                break;
            case 7: 
                nodes[1][1].setDefaultValue(2);
                nodes[2][3].setDefaultValue(3);
                nodes[3][3].setDefaultValue(4);
                nodes[4][4].setDefaultValue(4);
                nodes[5][0].setDefaultValue(6);
                nodes[5][2].setDefaultValue(1);
                nodes[6][0].setDefaultValue(5);
                nodes[6][6].setDefaultValue(3);
                nodes[0][0].setRowConstraint(">");
                nodes[4][6].setRowConstraint(">");
                nodes[0][3].setRowConstraint("<");
                nodes[2][0].setRowConstraint("<");
                nodes[4][1].setRowConstraint("<");
                nodes[5][1].setRowConstraint("<");
                nodes[5][3].setRowConstraint("<");
                nodes[0][2].setColumnConstraint("<");
                nodes[4][0].setColumnConstraint("<");
                nodes[1][2].setColumnConstraint(">");
                nodes[2][3].setColumnConstraint(">");
                nodes[4][5].setColumnConstraint(">");
                nodes[6][4].setColumnConstraint(">");
                break;
            case 8: 
                nodes[0][2].setDefaultValue(3);
                nodes[0][7].setDefaultValue(2);
                nodes[1][1].setDefaultValue(2);
                nodes[1][3].setDefaultValue(6);
                nodes[2][7].setDefaultValue(4);
                nodes[4][6].setDefaultValue(6);
                nodes[5][0].setDefaultValue(4);
                nodes[5][2].setDefaultValue(8);
                nodes[1][5].setRowConstraint(">");
                nodes[2][7].setRowConstraint(">");
                nodes[5][5].setRowConstraint(">");
                nodes[5][7].setRowConstraint(">");
                nodes[0][4].setRowConstraint("<");
                nodes[1][0].setRowConstraint("<");
                nodes[1][7].setRowConstraint("<");
                nodes[3][2].setRowConstraint("<");
                nodes[3][0].setRowConstraint("<");
                nodes[3][6].setRowConstraint("<");
                nodes[4][0].setRowConstraint("<");
                nodes[5][6].setRowConstraint("<");
                nodes[0][0].setColumnConstraint("<");
                nodes[1][5].setColumnConstraint("<");
                nodes[5][0].setColumnConstraint("<");
                nodes[5][3].setColumnConstraint("<");
                nodes[5][4].setColumnConstraint("<");
                nodes[7][0].setColumnConstraint("<");
                nodes[7][5].setColumnConstraint("<");
                nodes[1][1].setColumnConstraint(">");
                nodes[1][3].setColumnConstraint(">");
                nodes[2][5].setColumnConstraint(">");
                nodes[3][2].setColumnConstraint(">");
                nodes[3][4].setColumnConstraint(">");
                nodes[4][4].setColumnConstraint(">");
                nodes[6][1].setColumnConstraint(">");
                nodes[6][2].setColumnConstraint(">");
                nodes[7][2].setColumnConstraint(">");
                break;
            case 9: 
                /*
                nodes[0][5].setDefaultValue(8);
                nodes[1][7].setDefaultValue(6);
                nodes[2][0].setDefaultValue(9);
                nodes[3][1].setDefaultValue(5);
                nodes[3][5].setDefaultValue(6);
                nodes[5][3].setDefaultValue(8);
                */
                nodes[3][8].setDefaultValue(7);
                nodes[4][8].setDefaultValue(5);
                nodes[5][1].setDefaultValue(3);
                nodes[5][5].setDefaultValue(9);
                nodes[6][1].setDefaultValue(8);
                nodes[6][3].setDefaultValue(3);
                nodes[8][8].setDefaultValue(1);
                nodes[0][4].setRowConstraint(">");
                nodes[0][8].setRowConstraint(">");
                nodes[1][6].setRowConstraint(">");
                nodes[1][7].setRowConstraint(">");
                nodes[2][7].setRowConstraint(">");
                nodes[3][5].setRowConstraint(">");
                nodes[3][6].setRowConstraint(">");
                nodes[3][7].setRowConstraint(">");
                nodes[4][6].setRowConstraint(">");
                nodes[7][6].setRowConstraint(">");
                nodes[0][0].setRowConstraint("<");
                nodes[0][7].setRowConstraint("<");
                nodes[3][1].setRowConstraint("<");
                nodes[5][8].setRowConstraint("<");
                nodes[6][0].setRowConstraint("<");
                nodes[6][5].setRowConstraint("<");
                nodes[6][7].setRowConstraint("<");
                nodes[6][8].setRowConstraint("<");
                nodes[7][1].setRowConstraint("<");
                nodes[0][1].setColumnConstraint(">");
                nodes[0][2].setColumnConstraint(">");
                nodes[0][5].setColumnConstraint(">");
                nodes[1][2].setColumnConstraint(">");
                nodes[1][4].setColumnConstraint(">");
                nodes[2][1].setColumnConstraint(">");
                nodes[3][1].setColumnConstraint(">");
                nodes[4][2].setColumnConstraint(">");
                nodes[4][4].setColumnConstraint(">");
                nodes[6][1].setColumnConstraint(">");
                nodes[7][1].setColumnConstraint(">");
                nodes[8][2].setColumnConstraint(">");
                nodes[0][4].setColumnConstraint("<");
                nodes[1][7].setColumnConstraint("<");
                nodes[2][3].setColumnConstraint("<");
                nodes[3][0].setColumnConstraint("<");
                nodes[3][3].setColumnConstraint("<");
                nodes[5][0].setColumnConstraint("<");
                nodes[6][3].setColumnConstraint("<");
                nodes[8][1].setColumnConstraint("<");
                break;
            default: 
                return null;
        }
        
        return nodes;
    }
    
}
