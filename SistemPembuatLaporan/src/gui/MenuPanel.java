/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.FlowLayout;

/**
 *
 * @author angelynz95
 */
public class MenuPanel extends javax.swing.JPanel {

    /**
     * Creates new form MenuPanel
     */
    public MenuPanel() {
        initComponents();
        generateReportPanel.setLayout(new FlowLayout());
        generateReportPanel.add(new GenerateReportPanel());
        changePasswordPanel.setLayout(new FlowLayout());
        changePasswordPanel.add(new ChangePasswordPanel());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuTabbedPane = new javax.swing.JTabbedPane();
        generateReportPanel = new javax.swing.JPanel();
        changePasswordPanel = new javax.swing.JPanel();
        logoutLabel = new javax.swing.JLabel();

        menuTabbedPane.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N

        javax.swing.GroupLayout generateReportPanelLayout = new javax.swing.GroupLayout(generateReportPanel);
        generateReportPanel.setLayout(generateReportPanelLayout);
        generateReportPanelLayout.setHorizontalGroup(
            generateReportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1195, Short.MAX_VALUE)
        );
        generateReportPanelLayout.setVerticalGroup(
            generateReportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 527, Short.MAX_VALUE)
        );

        menuTabbedPane.addTab("Buat Laporan", generateReportPanel);

        javax.swing.GroupLayout changePasswordPanelLayout = new javax.swing.GroupLayout(changePasswordPanel);
        changePasswordPanel.setLayout(changePasswordPanelLayout);
        changePasswordPanelLayout.setHorizontalGroup(
            changePasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1195, Short.MAX_VALUE)
        );
        changePasswordPanelLayout.setVerticalGroup(
            changePasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 527, Short.MAX_VALUE)
        );

        menuTabbedPane.addTab("Ubah Kata Sandi", changePasswordPanel);

        logoutLabel.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        logoutLabel.setText("Keluar");
        logoutLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuTabbedPane)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutLabel)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoutLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuTabbedPane)
                .addGap(104, 104, 104))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void logoutLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutLabelMouseClicked
        // TODO add your handling code here:
        MainFrame frame = MainFrame.getInstance();
        frame.setContentPane(new LoginPanel());
        frame.pack();
        frame.setVisible(true);
    }//GEN-LAST:event_logoutLabelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel changePasswordPanel;
    private javax.swing.JPanel generateReportPanel;
    private javax.swing.JLabel logoutLabel;
    private javax.swing.JTabbedPane menuTabbedPane;
    // End of variables declaration//GEN-END:variables
}
