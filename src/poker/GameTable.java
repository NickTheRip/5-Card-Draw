/*
    Note: Any reference to player 2 and cpu2 are interchangeable.  cpu2 takes 
    the player 2s characteristics when selecting "PLAYER 1 VS CPU VS CPU2" over 
    "PLAYER 1 VS PLAYER2 VS CPU" in game setup.
*/
package poker;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import java.util.Random;

public class GameTable extends javax.swing.JFrame {
    static String player1name,  //Player's name(s) from setup screen
                  card11, card12, card13, card14, card15,   //Player1's cards
                  card31, card32, card33, card34, card35,   //CPU's cards
            difficulty; //difficulty declaration
    ArrayList<Card> selectedCards;
    static int defaultY = 510;
    int intAIDifficulty = 0;
    static Engine engine;
    Random rng;
    
    private void updateMoney(){
        pot1.setText("$ " + engine.getPlayer().money);
        pot3.setText("$ " + engine.getAIMoney());
        tablePotLabel.setText("$$ " + engine.getPot());
    }
    public GameTable(String player1, String difficulty) //Work On: Difficulty Settings
    {
        initComponents();
        lblPlayerHand.setVisible(false);
        lblAIHand.setVisible(false);
        rng = new Random();
        if(difficulty.equals("HARDER"))
        {
            intAIDifficulty = 1;
        }
        this.engine = new Engine(intAIDifficulty);
        selectedCards = new ArrayList<>();
        this.difficulty=difficulty;
        
        //updates to current pot name from Engine.java
        Player1PotName.setText(player1 + "'s POT:");       
       
        updateMoney();
        
        // used (above) to make each name static
        player1name = player1;
        
        //sets the names to screen
        p1name.setText(player1name);
        
        
        //*hide cards displaying on screen made true when needed to be seen*
        
        hideCards();
      
        //hides betting buttons until needed
        HideAll();
              
        //sets the image for player
        updateCardImages();
    }
    
    private void updateCardImages(){
        if(engine.getPlayer().hand.size() == 0){
            P1card1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poker/Images/b1fv.png")));
            P1card2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poker/Images/b1fv.png")));
            P1card3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poker/Images/b1fv.png")));
            P1card4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poker/Images/b1fv.png")));
            P1card5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poker/Images/b1fv.png")));
            return;
        }
        ArrayList<Card> cards = engine.getPlayer().hand.getCards();
        P1card1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poker/Images/" + cards.get(0).getResourceName() + ".png")));
        P1card2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poker/Images/" + cards.get(1).getResourceName() + ".png")));
        P1card3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poker/Images/" + cards.get(2).getResourceName() + ".png")));
        P1card4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poker/Images/" + cards.get(3).getResourceName() + ".png")));
        P1card5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poker/Images/" + cards.get(4).getResourceName() + ".png")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        DeckImage = new javax.swing.JLabel();
        cpuhandname = new javax.swing.JLabel();
        CPUcard1 = new javax.swing.JLabel();
        CPUcard2 = new javax.swing.JLabel();
        CPUcard3 = new javax.swing.JLabel();
        CPUcard4 = new javax.swing.JLabel();
        CPUcard5 = new javax.swing.JLabel();
        p1name = new javax.swing.JLabel();
        P1card1 = new javax.swing.JLabel();
        P1card2 = new javax.swing.JLabel();
        P1card3 = new javax.swing.JLabel();
        P1card4 = new javax.swing.JLabel();
        P1card5 = new javax.swing.JLabel();
        TableName = new javax.swing.JLabel();
        mainButton = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        pot3 = new javax.swing.JLabel();
        Player1PotName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tablePotLabel = new javax.swing.JLabel();
        pot1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        p1Raise = new javax.swing.JButton();
        p1Fold = new javax.swing.JButton();
        raiseField = new javax.swing.JTextField();
        lblPlayerHand = new javax.swing.JLabel();
        lblAIHand = new javax.swing.JLabel();
        tableImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        DeckImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poker/Images/b1fv.png"))); // NOI18N
        jPanel1.add(DeckImage);
        DeckImage.setBounds(610, 260, 80, 100);

        cpuhandname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cpuhandname.setText("CPU's HAND");
        jPanel1.add(cpuhandname);
        cpuhandname.setBounds(1000, 460, 90, 17);

        CPUcard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poker/Images/b1fv.png"))); // NOI18N
        jPanel1.add(CPUcard1);
        CPUcard1.setBounds(860, 510, 80, 100);

        CPUcard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poker/Images/b1fv.png"))); // NOI18N
        jPanel1.add(CPUcard2);
        CPUcard2.setBounds(940, 510, 80, 100);

        CPUcard3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poker/Images/b1fv.png"))); // NOI18N
        jPanel1.add(CPUcard3);
        CPUcard3.setBounds(1020, 510, 80, 100);

        CPUcard4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poker/Images/b1fv.png"))); // NOI18N
        jPanel1.add(CPUcard4);
        CPUcard4.setBounds(1100, 510, 80, 100);

        CPUcard5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poker/Images/b1fv.png"))); // NOI18N
        jPanel1.add(CPUcard5);
        CPUcard5.setBounds(1190, 510, 80, 100);

        p1name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        p1name.setText("Hand 1 This changes to name of player one");
        jPanel1.add(p1name);
        p1name.setBounds(50, 460, 170, 17);

        P1card1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poker/Images/b1fv.png"))); // NOI18N
        P1card1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                P1card1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                P1card1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                P1card1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                P1card1MouseReleased(evt);
            }
        });
        jPanel1.add(P1card1);
        P1card1.setBounds(40, 510, 80, 100);

        P1card2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poker/Images/b1fv.png"))); // NOI18N
        P1card2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                P1card2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                P1card2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                P1card2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                P1card2MouseReleased(evt);
            }
        });
        jPanel1.add(P1card2);
        P1card2.setBounds(130, 510, 80, 100);

        P1card3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poker/Images/b1fv.png"))); // NOI18N
        P1card3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                P1card3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                P1card3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                P1card3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                P1card3MouseReleased(evt);
            }
        });
        jPanel1.add(P1card3);
        P1card3.setBounds(220, 510, 80, 100);

        P1card4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poker/Images/b1fv.png"))); // NOI18N
        P1card4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                P1card4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                P1card4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                P1card4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                P1card4MouseReleased(evt);
            }
        });
        jPanel1.add(P1card4);
        P1card4.setBounds(310, 510, 80, 100);

        P1card5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poker/Images/b1fv.png"))); // NOI18N
        P1card5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                P1card5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                P1card5MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                P1card5MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                P1card5MouseReleased(evt);
            }
        });
        jPanel1.add(P1card5);
        P1card5.setBounds(400, 510, 80, 100);

        TableName.setFont(new java.awt.Font("Mongolian Baiti", 1, 36)); // NOI18N
        TableName.setText("5 Card Draw");
        jPanel1.add(TableName);
        TableName.setBounds(10, 10, 197, 43);

        mainButton.setText("START GAME");
        mainButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mainButtonMouseClicked(evt);
            }
        });
        mainButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainButtonActionPerformed(evt);
            }
        });
        jPanel1.add(mainButton);
        mainButton.setBounds(570, 510, 180, 23);

        exit.setText("EXIT TO GAME SETUP");
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });
        jPanel1.add(exit);
        exit.setBounds(570, 590, 180, 23);

        pot3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        pot3.setForeground(new java.awt.Color(255, 255, 255));
        pot3.setText("$$$$$");
        jPanel1.add(pot3);
        pot3.setBounds(1170, 380, 100, 16);

        Player1PotName.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Player1PotName.setForeground(new java.awt.Color(255, 255, 255));
        Player1PotName.setText("PLAYER 1'S POT:");
        jPanel1.add(Player1PotName);
        Player1PotName.setBounds(30, 330, 170, 16);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CPU'S POT:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(1160, 350, 90, 16);

        tablePotLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tablePotLabel.setForeground(new java.awt.Color(255, 255, 255));
        tablePotLabel.setText("$$$$$$$");
        jPanel1.add(tablePotLabel);
        tablePotLabel.setBounds(600, 440, 130, 20);

        pot1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        pot1.setForeground(new java.awt.Color(255, 255, 255));
        pot1.setText("$$$$$");
        jPanel1.add(pot1);
        pot1.setBounds(60, 350, 100, 16);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("TABLE'S POT:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(600, 410, 130, 20);

        p1Raise.setText("BET");
        p1Raise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p1RaiseActionPerformed(evt);
            }
        });
        jPanel1.add(p1Raise);
        p1Raise.setBounds(130, 400, 80, 23);

        p1Fold.setText("FOLD");
        p1Fold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p1FoldActionPerformed(evt);
            }
        });
        jPanel1.add(p1Fold);
        p1Fold.setBounds(50, 400, 70, 23);
        jPanel1.add(raiseField);
        raiseField.setBounds(130, 430, 80, 20);

        lblPlayerHand.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblPlayerHand.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblPlayerHand.setText("jLabel1");
        jPanel1.add(lblPlayerHand);
        lblPlayerHand.setBounds(270, 410, 200, 40);

        lblAIHand.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblAIHand.setText("jLabel2");
        jPanel1.add(lblAIHand);
        lblAIHand.setBounds(860, 420, 200, 20);

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        /*returns you to gameSetup where you can either quit there, change
        preferences or start over*/
        GameSetup gs = new GameSetup();
        gs.setVisible(true);
        dispose();
    }//GEN-LAST:event_exitMouseClicked

    private void resetCardPos(){
        P1card1.setBounds(P1card1.getX(), 510, 80, 100);
        P1card2.setBounds(P1card2.getX(), 510, 80, 100);
        P1card3.setBounds(P1card3.getX(), 510, 80, 100);
        P1card4.setBounds(P1card4.getX(), 510, 80, 100);
        P1card5.setBounds(P1card5.getX(), 510, 80, 100);
    }
    
    private void mainButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainButtonMouseClicked
        updateMoney();
        updateCardImages();
        resetCardPos();
        switch (engine.getState())
        {
            case -1:
                mainButton.setText("DEAL ME IN!");
                engine.start();
                hideAICards();
                break;
                
            case 0:
                mainButton.setText("START BETTING");
                showCards();
                engine.beginRound();
                break;
            
            case 1:  //betting
                betting();
                mainButton.setText("SWAP THESE CARDS!");
                break;
                
            case 2:
                mainButton.setText("BETTING");
                signalAISwaps(engine.changeCards(selectedCards));
                
                break;
                
            case 3:  //dealing hand, view hand cards
                betting();
                mainButton.setText("SHOWDOWN");
                break;

            case 4:  
                clearAISwaps();
                showAICards();
                lblPlayerHand.setVisible(true);
                lblAIHand.setVisible(true);
                lblPlayerHand.setText(engine.getPlayer().hand.determineHand().toString());
                lblAIHand.setText(engine.getAIHand().determineHand().toString());
                mainButton.setText("CONTINUE");
                engine.isPlayerWinner();
                break;
                
            case 5:
                mainButton.setText("CONTINUE");
                hideAICards();
                if(engine.gameInProgress()){
                    engine.start();
                }else{
                    if(engine.getPlayer().money <= 10){
                        JOptionPane.showMessageDialog(null, "You Lose!\nThe truth is, the game was rigged from the start.");
                    }else{
                        JOptionPane.showMessageDialog(null, "You Win!\nQuit while you're ahead. All the best gamblers do.");
                    }
                    mainButton.setVisible(false);
                }
                break;
                
            case 6:
                break;
        }
        updateMoney();
        updateCardImages();
    }//GEN-LAST:event_mainButtonMouseClicked

    private void clearAISwaps(){
        ArrayList<javax.swing.JLabel> cards = new ArrayList<>();
        cards.add(CPUcard1);
        cards.add(CPUcard2);
        cards.add(CPUcard3);
        cards.add(CPUcard4);
        cards.add(CPUcard5);
        for(javax.swing.JLabel lbl : cards){
            lbl.setBounds(lbl.getX(), 510, 80, 100);
        }
    }
    
    private void signalAISwaps(int swaps){
        
        ArrayList<javax.swing.JLabel> cards = new ArrayList<>();
        cards.add(CPUcard1);
        cards.add(CPUcard2);
        cards.add(CPUcard3);
        cards.add(CPUcard4);
        cards.add(CPUcard5);
        Collections.shuffle(cards, rng);
        
        while(swaps > 0){
            javax.swing.JLabel lbl = cards.remove(0);
            lbl.setBounds(lbl.getX(), 500, 80, 100);
            swaps--;
        }
    }
    
    private void showAICards(){
        ArrayList<Card> cards = engine.getAIHand().getCards();
        CPUcard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poker/Images/" + cards.get(0).getResourceName() + ".png")));
        CPUcard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poker/Images/" + cards.get(1).getResourceName() + ".png")));
        CPUcard3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poker/Images/" + cards.get(2).getResourceName() + ".png")));
        CPUcard4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poker/Images/" + cards.get(3).getResourceName() + ".png")));
        CPUcard5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poker/Images/" + cards.get(4).getResourceName() + ".png")));
    }
    
    private void hideAICards(){
            CPUcard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poker/Images/b1fv.png")));
            CPUcard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poker/Images/b1fv.png")));
            CPUcard3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poker/Images/b1fv.png")));
            CPUcard4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poker/Images/b1fv.png")));
            CPUcard5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/poker/Images/b1fv.png")));
    }
    
    private void showCards(){
        CPUcard1.setVisible(true);       CPUcard2.setVisible(true);
        CPUcard3.setVisible(true);       CPUcard4.setVisible(true);
        CPUcard5.setVisible(true);       

        P1card1.setVisible(true);        P1card2.setVisible(true);

        P1card3.setVisible(true);        P1card4.setVisible(true);

        P1card5.setVisible(true);        
    }
    
    private void hideCards(){
        CPUcard1.setVisible(false);       CPUcard2.setVisible(false);
        CPUcard3.setVisible(false);       CPUcard4.setVisible(false);
        CPUcard5.setVisible(false);       

        P1card1.setVisible(false);        P1card2.setVisible(false);

        P1card3.setVisible(false);        P1card4.setVisible(false);

        P1card5.setVisible(false);        
    }
    
    private void P1card2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P1card2MouseReleased

    }//GEN-LAST:event_P1card2MouseReleased

    private void P1card2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P1card2MousePressed
        if(engine.getPhase().equals("Card Swapping")){
            Card c = engine.getPlayer().hand.getCards().get(1);
            if(selectedCards.contains(c)){
                selectedCards.remove(c);
                P1card2.setBounds(P1card2.getX(), P1card2.getY() + 30, 80, 100);
            }else{
                selectedCards.add(c);
                P1card2.setBounds(P1card2.getX(), P1card2.getY() - 30, 80, 100);
            }
        }
    }//GEN-LAST:event_P1card2MousePressed

    private void P1card2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P1card2MouseExited
        P1card2.setBounds(P1card2.getX(), P1card2.getY() + 10, 80, 100);
    }//GEN-LAST:event_P1card2MouseExited

    private void P1card2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P1card2MouseEntered
        P1card2.setBounds(P1card2.getX(), P1card2.getY() - 10, 80, 100);
    }//GEN-LAST:event_P1card2MouseEntered

    private void P1card1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P1card1MouseReleased

    }//GEN-LAST:event_P1card1MouseReleased

    private void P1card1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P1card1MousePressed
        if(engine.getPhase().equals("Card Swapping")){
            Card c = engine.getPlayer().hand.getCards().get(0);
            if(selectedCards.contains(c)){
                selectedCards.remove(c);
                P1card1.setBounds(P1card1.getX(), P1card1.getY() + 30, 80, 100);
            }else{
                selectedCards.add(c);
                P1card1.setBounds(P1card1.getX(), P1card1.getY() - 30, 80, 100);
            }
        }
    }//GEN-LAST:event_P1card1MousePressed

    private void P1card1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P1card1MouseExited
        P1card1.setBounds(P1card1.getX(), P1card1.getY() + 10, 80, 100);
    }//GEN-LAST:event_P1card1MouseExited

    private void P1card1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P1card1MouseEntered
        P1card1.setBounds(P1card1.getX(), P1card1.getY() - 10, 80, 100);
    }//GEN-LAST:event_P1card1MouseEntered

    private void p1RaiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p1RaiseActionPerformed
        String s = raiseField.getText();
        if(!s.matches("[0-9]+")){
            JOptionPane.showMessageDialog(null, "Please enter an integer");
            return;
        }
        int bet = Integer.parseInt(s);
        if (bet > engine.getPlayer().money){
            JOptionPane.showMessageDialog(null, "You cannot bet more than you have.");
            return;
        }
        if (bet > engine.getAIMoney()){
            JOptionPane.showMessageDialog(null, "You cannot bet more than the AI can match.");
            return;
        }
        if(engine.getPhase().equals("First Round Betting")){
            engine.roundOneBet(bet);
        }else{
            engine.roundTwoBet(bet);
        }
        updateMoney();
        HideAll();
        mainButton.setVisible(true);//use to hide main button so they dont continue without betting
    }//GEN-LAST:event_p1RaiseActionPerformed

    private void p1FoldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p1FoldActionPerformed
        HideAll();
        mainButton.setVisible(true);
    }//GEN-LAST:event_p1FoldActionPerformed

    private void P1card3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P1card3MouseEntered
        P1card3.setBounds(P1card3.getX(), P1card3.getY() - 10, 80, 100);
        
    }//GEN-LAST:event_P1card3MouseEntered

    private void P1card3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P1card3MouseExited
        P1card3.setBounds(P1card3.getX(), P1card3.getY() + 10, 80, 100);
    }//GEN-LAST:event_P1card3MouseExited

    private void P1card3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P1card3MousePressed
            if(engine.getPhase().equals("Card Swapping")){
            Card c = engine.getPlayer().hand.getCards().get(2);
            if(selectedCards.contains(c)){
                selectedCards.remove(c);
                P1card3.setBounds(P1card3.getX(), P1card3.getY() + 30, 80, 100);
            }else{
                selectedCards.add(c);
                P1card3.setBounds(P1card3.getX(), P1card3.getY() - 30, 80, 100);
            }
        }
    }//GEN-LAST:event_P1card3MousePressed

    private void P1card3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P1card3MouseReleased

    }//GEN-LAST:event_P1card3MouseReleased

    private void P1card4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P1card4MouseEntered
        P1card4.setBounds(P1card4.getX(), P1card4.getY() - 10, 80, 100);
    }//GEN-LAST:event_P1card4MouseEntered

    private void P1card4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P1card4MouseExited
        P1card4.setBounds(P1card4.getX(), P1card4.getY() + 10, 80, 100);
    }//GEN-LAST:event_P1card4MouseExited

    private void P1card4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P1card4MousePressed
        if(engine.getPhase().equals("Card Swapping")){
            Card c = engine.getPlayer().hand.getCards().get(3);
            if(selectedCards.contains(c)){
                selectedCards.remove(c);
                P1card4.setBounds(P1card4.getX(), P1card4.getY() + 30, 80, 100);
            }else{
                selectedCards.add(c);
                P1card4.setBounds(P1card4.getX(), P1card4.getY() - 30, 80, 100);
            }
        }
    }//GEN-LAST:event_P1card4MousePressed

    private void P1card4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P1card4MouseReleased

    }//GEN-LAST:event_P1card4MouseReleased

    private void P1card5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P1card5MouseEntered
        // TODO add your handling code here:
        P1card5.setBounds(P1card5.getX(), P1card5.getY() - 10, 80, 100);
    }//GEN-LAST:event_P1card5MouseEntered

    private void P1card5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P1card5MouseExited
        P1card5.setBounds(P1card5.getX(), P1card5.getY() + 10, 80, 100);
    }//GEN-LAST:event_P1card5MouseExited

    private void P1card5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P1card5MousePressed
        if(engine.getPhase().equals("Card Swapping")){
            Card c = engine.getPlayer().hand.getCards().get(4);
            if(selectedCards.contains(c)){
                selectedCards.remove(c);
                P1card5.setBounds(P1card5.getX(), P1card5.getY() + 30, 80, 100);
            }else{
                selectedCards.add(c);
                P1card5.setBounds(P1card5.getX(), P1card5.getY() - 30, 80, 100);
            }
        }
    }//GEN-LAST:event_P1card5MousePressed

    private void P1card5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_P1card5MouseReleased

    }//GEN-LAST:event_P1card5MouseReleased

    private void mainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mainButtonActionPerformed
    
    public void betting()
    {
        mainButton.setVisible(false);//use to hide main button so they dont continue without betting
        
        p1Raise.setVisible(true); 
        p1Fold.setVisible(true);  
        raiseField.setVisible(true);
        
    }
    public void HideAll()
    {
        p1Raise.setVisible(false); 
        p1Fold.setVisible(false);  
        raiseField.setVisible(false);
    }
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameTable(player1name, difficulty).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CPUcard1;
    private javax.swing.JLabel CPUcard2;
    private javax.swing.JLabel CPUcard3;
    private javax.swing.JLabel CPUcard4;
    private javax.swing.JLabel CPUcard5;
    private javax.swing.JLabel DeckImage;
    private javax.swing.JLabel P1card1;
    private javax.swing.JLabel P1card2;
    private javax.swing.JLabel P1card3;
    private javax.swing.JLabel P1card4;
    private javax.swing.JLabel P1card5;
    private javax.swing.JLabel Player1PotName;
    private javax.swing.JLabel TableName;
    private javax.swing.JLabel cpuhandname;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAIHand;
    private javax.swing.JLabel lblPlayerHand;
    private javax.swing.JButton mainButton;
    private javax.swing.JButton p1Fold;
    private javax.swing.JButton p1Raise;
    private javax.swing.JLabel p1name;
    private javax.swing.JLabel pot1;
    private javax.swing.JLabel pot3;
    private javax.swing.JTextField raiseField;
    private javax.swing.JLabel tableImage;
    private javax.swing.JLabel tablePotLabel;
    // End of variables declaration//GEN-END:variables
}
