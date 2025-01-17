/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futoshiki;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import metier.*;

/**
 *
 * @author Toihir
 */
public class Futoshiki extends javax.swing.JFrame {

    /**
     * Creates new form Futoshiki
     */
    Game game = new Game();
    Node [][] nodes;
    int N;
    int level;
    int sizeBoard;
    boolean printWinText = false;
    
    
    public Futoshiki() {
        this.setTitle("FUTOSHIKI");
        initComponents();
        gamePanel = new JPanel();
        nodes = game.getLastGame();         // prendre la derniere partie arreté ou celui par defaut
        N = nodes.length;
        level = 2;
        jComboBox1.setSelectedIndex(N - 4);
        jComboBox2.setSelectedIndex(level - 2);
        sizeBoard = N * 70;
        jPanel2.add(gamePanel);
        gamePanel.setBounds(20, 20, sizeBoard, sizeBoard);
        gamePanel.setBackground(Color.white);
        print();                            // afficher la partie
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        jButton1.setLabel("Solution");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("New Game");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "4", "5", "6", "7", "8", "9" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Easy", "Normal", "Hard" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Level :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jButton2)
                .addGap(50, 50, 50)
                .addComponent(jButton1)
                .addGap(42, 42, 42)
                .addComponent(jButton3)
                .addGap(61, 61, 61))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setForeground(new java.awt.Color(0, 204, 0));
        jLabel2.setText("Congratulation you did it yay !");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(238, 238, 238)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(634, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //generate new game
        nodes = game.random(N, level);
        print();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // generate Solution
        game.solve(nodes);
        game.checkGame(nodes);
        printWinText = false;
        print();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        int select = jComboBox1.getSelectedIndex() + 4;
        
        if(N != select){
            N = select;
            sizeBoard = N * 70;
            nodes = game.getGame(N);
            print();
            game.saveGame(nodes);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        game.getInitialGame(nodes);
        print();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        level = jComboBox2.getSelectedIndex() + 2;
    }//GEN-LAST:event_jComboBox2ActionPerformed
    
    private void changeValue(int i, int j, int value){
        // changer la valeur d une case si la valeur est valide ( [1 - N] )
        printWinText = true;
        if(value >= 0 && value <= N && value != nodes[i][j].getValue()){
            nodes[i][j].setValue(value);
            print();
            game.saveGame(nodes);
        }
    }
    
    // fonction qui affiche une partie 
    private void print(){
        
        gamePanel.removeAll();
        gamePanel.revalidate();
        gamePanel.repaint();
        Font f = new Font("Verdana",Font.BOLD,30);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        MaskFormatter formatter = null;
        try{
            String allowedNumbers = " ";
            for(int i = 1; i <= N; i++) allowedNumbers += "" + i;
            formatter = new MaskFormatter("*");
            formatter.setValidCharacters(allowedNumbers);
        }catch(Exception e){}
        
        int line = (650 - sizeBoard) /2 + 20;
        gamePanel.setBounds(line, line, sizeBoard, sizeBoard);
        if(nodes != null){
            if(game.checkGame(nodes) && printWinText){// assistance des erreurs a chaque affiche s une partie
                jLabel2.setText("Congratulation you did it yay !");
            }else {
                jLabel2.setText("");
            }
            
            for(int i = 0 ; i < nodes.length; i++){
                for(int j = 0; j < nodes.length; j++){
                    JPanel nodePanel = new JPanel();
                    nodePanel.setLayout(null);
                    
                    JPanel textFieldPanel = new JPanel();
                    JPanel columnConstraintPanel = new JPanel();
                    JPanel rowConstraintPanel = new JPanel();
                    
                    textFieldPanel.setBackground(Color.white);
                    textFieldPanel.setBorder(blackline);
                    textFieldPanel.setBounds(0, 0, 40, 40);
                    textFieldPanel.setLayout(null);
                    
                    columnConstraintPanel.setBounds(40, 0, 30, 40);
                    rowConstraintPanel.setBounds(0, 40, 40, 30);
                    columnConstraintPanel.setBackground(Color.white);
                    rowConstraintPanel.setBackground(Color.white);
                    columnConstraintPanel.setLayout(null);
                    rowConstraintPanel.setLayout(null);
                    
                    //affiche de la contrainte a droite si il existe
                    if(nodes[i][j].hasColumnConstraint()){
                        JLabel columnConstraintLabel = new JLabel(nodes[i][j].getColumnConstraint());
                        columnConstraintLabel.setFont(f);
                        columnConstraintLabel.setBounds(0,0, 30, 40);
                        columnConstraintLabel.setForeground(nodes[i][j].getColumnConstraintColor());
                        columnConstraintPanel.add(columnConstraintLabel);
                    }
                    //affiche de la contrainte en bas si il existe
                    if(nodes[i][j].hasRowConstraint()){
                        JLabel rowConstraintLabel = new RotateLabel(nodes[i][j].getRowConstraint());
                        rowConstraintLabel.setFont(f);
                        rowConstraintLabel.setBounds(2,5, 40, 30);
                        rowConstraintLabel.setForeground(nodes[i][j].getRowConstraintColor());
                        rowConstraintPanel.add(rowConstraintLabel);
                    }
                    
                    try{
                        final int x = i;
                        final int y = j;
                        JFormattedTextField  valeur = new JFormattedTextField(formatter);
                        valeur.setBounds(0, 0, 40, 40);
                        
                        valeur.setText("" + nodes[i][j].getValue());
                        valeur.setFont(f);
                        valeur.setBorder(null);
                        
                        valeur.setForeground(nodes[i][j].getColor());
                        if(nodes[i][j].isInitial()){
                            //les cases initiales sont inchangables
                            valeur.setEditable(false);
                        }else {
                            
                            valeur.getDocument().addDocumentListener(new DocumentListener() {
                                int i = x;
                                int j = y;
                                public void changedUpdate(DocumentEvent e) {
                                  warn();
                                }
                                public void removeUpdate(DocumentEvent e) {
                                  warn();
                                }
                                public void insertUpdate(DocumentEvent e) {
                                  warn();
                                }

                                public void warn() {
                                  changeValue(i, j, val());
                                }
                                public int val(){
                                    if(" ".equals(valeur.getText())) return 0;
                                    try{
                                        return Integer.parseInt(valeur.getText());
                                    }catch(Exception e){
                                        return -1;
                                    }
                                }
                              });
                            
                           
                        }
                             
                        textFieldPanel.add(valeur);
                    }catch(Exception e){
                        JTextField valeur = new JTextField(2);
                        textFieldPanel.add(valeur);
                    }
                    
                    nodePanel.add(textFieldPanel);
                    nodePanel.add(columnConstraintPanel);
                    nodePanel.add(rowConstraintPanel);
                    nodePanel.setBackground(Color.white);
                    
                    gamePanel.add(nodePanel);
                }
            }
            gamePanel.setLayout(new GridLayout(N,N));
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Futoshiki.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Futoshiki.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Futoshiki.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Futoshiki.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //initialiser la base de donne
        DataBase.initialize();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Futoshiki().setVisible(true);
            }
        });
    }
    
    private JPanel gamePanel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    //classe de rotation des contraintes
    private class RotateLabel extends JLabel {
      public RotateLabel(String text) {
         super(text);
      }
      @Override
      public void paintComponent(Graphics g) {
         Graphics2D gx = (Graphics2D) g;
         gx.rotate(1.5708, 20, 15);
         super.paintComponent(g);
      }
   }

}
