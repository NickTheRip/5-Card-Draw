package poker;

public class GameSetup extends javax.swing.JFrame {
    static int p1pot,  cpupot;
    public GameSetup() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        startButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        player1name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        DifficultyComboBox = new javax.swing.JComboBox<>();
        TableName = new javax.swing.JLabel();
        exitButton = new javax.swing.JButton();
        tableImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 630));

        jPanel1.setBackground(new java.awt.Color(255, 204, 51));
        jPanel1.setMaximumSize(new java.awt.Dimension(1280, 630));
        jPanel1.setMinimumSize(new java.awt.Dimension(1280, 630));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 630));
        jPanel1.setLayout(null);

        startButton.setText("START");
        startButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startButtonMouseClicked(evt);
            }
        });
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        jPanel1.add(startButton);
        startButton.setBounds(590, 110, 79, 23);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 255, 255));
        jLabel2.setText("ENTER YOUR NAME:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(430, 440, 170, 17);

        player1name.setText("Player 1");
        jPanel1.add(player1name);
        player1name.setBounds(430, 480, 140, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 255, 255));
        jLabel3.setText("CHOOSE DIFFICULTY:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(670, 440, 170, 17);

        DifficultyComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AVERAGE", "HARDER" }));
        jPanel1.add(DifficultyComboBox);
        DifficultyComboBox.setBounds(670, 480, 100, 20);

        TableName.setFont(new java.awt.Font("Mongolian Baiti", 1, 48)); // NOI18N
        TableName.setText("Classic 5 Card Draw");
        jPanel1.add(TableName);
        TableName.setBounds(400, 280, 490, 80);

        exitButton.setText("EXIT GAME");
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitButtonMouseClicked(evt);
            }
        });
        jPanel1.add(exitButton);
        exitButton.setBounds(580, 160, 100, 23);

        tableImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poker/Images/Classic_HoldEm_8_GREEN.jpeg"))); // NOI18N
        tableImage.setMaximumSize(new java.awt.Dimension(1280, 630));
        tableImage.setMinimumSize(new java.awt.Dimension(1280, 630));
        tableImage.setPreferredSize(new java.awt.Dimension(1280, 630));
        jPanel1.add(tableImage);
        tableImage.setBounds(0, 0, 1280, 630);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startButtonMouseClicked
        //retrieves each players name, difficulty, # of players
        
        String C = DifficultyComboBox.getSelectedItem().toString();
        String player1Name = player1name.getText();
        
        
        
        /*FIXED SO IF STEMENTS HAVE DIFFERENT RESULTS
            finish after betting is complete*/

        //Choice one PLAYER 1 VS CPU VS CPU2 & Average play
        
            GameTable gt = new GameTable(player1Name, C);
            gt.setVisible(true);
            dispose();
        
        
        
    }//GEN-LAST:event_startButtonMouseClicked

    private void exitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseClicked
        dispose();//exits the game
    }//GEN-LAST:event_exitButtonMouseClicked

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startButtonActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameSetup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> DifficultyComboBox;
    private javax.swing.JLabel TableName;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField player1name;
    private javax.swing.JButton startButton;
    private javax.swing.JLabel tableImage;
    // End of variables declaration//GEN-END:variables
}
