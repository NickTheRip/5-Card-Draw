package poker;

public class RulesPage extends javax.swing.JFrame {

    public RulesPage() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        RulesLink = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tableImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setMaximumSize(new java.awt.Dimension(1280, 630));
        jPanel1.setMinimumSize(new java.awt.Dimension(1280, 630));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 630));
        jPanel1.setLayout(null);

        jButton2.setText("START GAME");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(530, 550, 120, 23);

        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(680, 550, 93, 23);

        RulesLink.setFont(new java.awt.Font("Mongolian Baiti", 0, 24)); // NOI18N
        RulesLink.setText("http://pokermistery.com/five-card-draw-rules");
        jPanel1.add(RulesLink);
        RulesLink.setBounds(420, 220, 460, 80);

        jLabel1.setFont(new java.awt.Font("Mongolian Baiti", 1, 48)); // NOI18N
        jLabel1.setText("Rules");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(570, 170, 140, 56);

        jLabel2.setFont(new java.awt.Font("Mongolian Baiti", 0, 36)); // NOI18N
        jLabel2.setText("Poker Hands");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(540, 350, 200, 42);

        jLabel3.setFont(new java.awt.Font("Mongolian Baiti", 0, 24)); // NOI18N
        jLabel3.setText("https://www.partypoker.com/en/how-to-play/hand-rankings");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(350, 410, 580, 29);

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        //starts second Gui
        GameSetup gs = new GameSetup();
        gs.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2MouseClicked
  
     private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {                                      
        //starts second Gui
        StartScreen ss = new StartScreen();
        ss.setVisible(true);
        dispose();
    } 
     
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RulesPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel RulesLink;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel tableImage;
    // End of variables declaration//GEN-END:variables
}
