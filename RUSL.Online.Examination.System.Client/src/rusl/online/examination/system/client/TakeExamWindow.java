/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rusl.online.examination.system.client;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import rusl.online.examination.system.client.utility.*;
import rusl.online.examination.system.server.bean.Question;
import rusl.online.examination.system.server.bean.Student;

/**
 *
 * @author Kasun Kodagoda
 */
public class TakeExamWindow extends javax.swing.JFrame {
    Student loggedin = new Student();
    LinkedList<Question> questions = Client.requestQuestionList(); 
    LinkedList<Answer> answerList = new LinkedList<>();
    ArrayList<Question> questionAry = new ArrayList<>();
    
    
    int count = 0;
    int questionIdx = 0;
    public TakeExamWindow(Student std) {
        loggedin = std;
        initComponents();
        setIcon();  
        
        CountdownTimer.start(lblTimer, 600);
        
        
        Question initQustion = questions.get(questionIdx);
        count++;
        lblquesNo.setText(String.valueOf(count));
        txtAreaQuestion.setText(initQustion.getQuestion());
        lblAns1.setText(initQustion.getAnswer1());
        lblAns2.setText(initQustion.getAnswer2());
        lblAns3.setText(initQustion.getAnswer3());
        lblAns4.setText(initQustion.getAnswer4());
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ansGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnNext = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        radAns2 = new javax.swing.JRadioButton();
        lblquesNo = new javax.swing.JLabel();
        radAns3 = new javax.swing.JRadioButton();
        radAns1 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        radAns4 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaQuestion = new javax.swing.JTextArea();
        lblAns1 = new javax.swing.JLabel();
        lblAns2 = new javax.swing.JLabel();
        lblAns3 = new javax.swing.JLabel();
        lblAns4 = new javax.swing.JLabel();
        lblTimer = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnFinish = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RUSL Examination Center - Take Examination");
        setBounds(new java.awt.Rectangle(300, 100, 0, 0));
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnNext.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rusl/online/examination/system/client/images/next.png"))); // NOI18N
        btnNext.setText("  Next Question");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Question"));

        ansGroup.add(radAns2);
        radAns2.setText("2");

        lblquesNo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblquesNo.setText("#");

        ansGroup.add(radAns3);
        radAns3.setText("3");

        ansGroup.add(radAns1);
        radAns1.setText("1");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel1.setText("Question");

        ansGroup.add(radAns4);
        radAns4.setText("4");

        txtAreaQuestion.setBackground(javax.swing.UIManager.getDefaults().getColor("Label.background"));
        txtAreaQuestion.setColumns(20);
        txtAreaQuestion.setEditable(false);
        txtAreaQuestion.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtAreaQuestion.setLineWrap(true);
        txtAreaQuestion.setRows(5);
        txtAreaQuestion.setAutoscrolls(false);
        txtAreaQuestion.setBorder(null);
        txtAreaQuestion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtAreaQuestion.setFocusable(false);
        txtAreaQuestion.setHighlighter(null);
        jScrollPane1.setViewportView(txtAreaQuestion);

        lblAns1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblAns1.setText("jLabel2");

        lblAns2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblAns2.setText("jLabel2");

        lblAns3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblAns3.setText("jLabel3");

        lblAns4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblAns4.setText("jLabel4");

        lblTimer.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lblTimer.setText("00:00");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(radAns3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblAns3))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(radAns4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblAns4))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(radAns2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(radAns1, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblAns2)
                                            .addComponent(lblAns1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 13, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblquesNo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTimer)
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {radAns3, radAns4});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblAns1, lblAns2, lblAns3, lblAns4});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblquesNo)))
                    .addComponent(lblTimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radAns1)
                    .addComponent(lblAns1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radAns2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAns2))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radAns3)
                    .addComponent(lblAns3))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radAns4)
                    .addComponent(lblAns4))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {radAns1, radAns2, radAns3, radAns4});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblAns1, lblAns2, lblAns3, lblAns4});

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNext, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnBack.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rusl/online/examination/system/client/images/back.png"))); // NOI18N
        btnBack.setText("  Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnFinish.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnFinish.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rusl/online/examination/system/client/images/tick.png"))); // NOI18N
        btnFinish.setText("   Finish Test");
        btnFinish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinishActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnFinish, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFinish, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnBack, btnFinish});

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rusl/online/examination/system/client/images/QuestionWindow.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        
        
        if(Helper.isRadioButtonSelected(ansGroup)) {
            questionIdx++;
            count++;
            if (count > 5) {
                JOptionPane.showMessageDialog(null, "You tried all the questions for this examination.", "Take Examination", JOptionPane.INFORMATION_MESSAGE);            
                questionIdx--;
            } else {
                // Create Answer object to store the questionID and answer
                Answer ans = new Answer();
                ans.setQuestionId(questions.get(questionIdx - 1).getQuestionId());
                ans.setAnswer(Integer.parseInt(Helper.getSelectedButtonText(ansGroup)));
                ans.setStdId(loggedin.getStudentId());
                answerList.push(ans);
                
                // pop a question and display it 
                Question question = questions.get(questionIdx);
                
                lblquesNo.setText(String.valueOf(count));
                txtAreaQuestion.setText(question.getQuestion());
                lblAns1.setText(question.getAnswer1());
                lblAns2.setText(question.getAnswer2());
                lblAns3.setText(question.getAnswer3());
                lblAns4.setText(question.getAnswer4());
                
                // clear the previous selection
                ansGroup.clearSelection();
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Please select an answer before you move to the next question.", "Take Examination", JOptionPane.INFORMATION_MESSAGE);            
        }
   }//GEN-LAST:event_btnNextActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        CountdownTimer.getTimer().cancel();
        this.dispose();
        new ClientWindow(loggedin).setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnFinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinishActionPerformed
        CountdownTimer.getTimer().cancel();
        
        questionIdx++;
        count++;
        Answer ans = new Answer();
        ans.setQuestionId(questions.get(questionIdx - 1).getQuestionId());
        ans.setAnswer(Integer.parseInt(Helper.getSelectedButtonText(ansGroup)));
        ans.setStdId(loggedin.getStudentId());
        answerList.push(ans);
        
        Result fromServer = Client.sendAnswerstoServer(answerList);
        if (fromServer != null) {
            this.dispose();
            new ResultWindow(fromServer, loggedin).setVisible(true);
        }
        
    }//GEN-LAST:event_btnFinishActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TakeExamWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TakeExamWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TakeExamWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TakeExamWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TakeExamWindow(null).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup ansGroup;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnFinish;
    private javax.swing.JButton btnNext;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAns1;
    private javax.swing.JLabel lblAns2;
    private javax.swing.JLabel lblAns3;
    private javax.swing.JLabel lblAns4;
    private javax.swing.JLabel lblTimer;
    private javax.swing.JLabel lblquesNo;
    private javax.swing.JRadioButton radAns1;
    private javax.swing.JRadioButton radAns2;
    private javax.swing.JRadioButton radAns3;
    private javax.swing.JRadioButton radAns4;
    private javax.swing.JTextArea txtAreaQuestion;
    // End of variables declaration//GEN-END:variables
    
    private void setIcon() {
            try {
                setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));                
            } catch (Exception e) {
            }
    }
    
    /*NOT USED*/
    private int[] getTime(String timeString) {
        String[] time = timeString.split(":");                
        int[] timeVals = new int[2];
        timeVals[0] = Integer.parseInt(time[0]);
        timeVals[1] = Integer.parseInt(time[1]);
        return timeVals;
    }
}
