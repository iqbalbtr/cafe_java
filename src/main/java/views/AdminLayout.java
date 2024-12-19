package views;

import model.*;
import javax.swing.JTable;
import java.awt.Color;
import views.Dashboard;
import views.Dashboard;
import views.ItemPanel;
import views.ItemPanel;
import views.LoginForm;
import views.RequestPanel;
import views.RequestPanel;
import views.TransactionPanel;
import views.TransactionPanel;
import views.UserPanel;
import views.UserPanel;

public class AdminLayout extends javax.swing.JFrame {

    Color DefaultColor, ClickedColor;
    private User session;

    public AdminLayout(User session) {
        this.session = session;
        DefaultColor = new Color(13, 36, 51);
        ClickedColor = new Color(240, 151, 57);
        initComponents();
        Dashboard panel = new Dashboard();
        MainContainer.add(panel).setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        RequestBtn = new javax.swing.JLabel();
        ItemBtn = new javax.swing.JLabel();
        TransBtn = new javax.swing.JLabel();
        UserBtn = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        DashboardBtn = new javax.swing.JLabel();
        OutBtn = new javax.swing.JLabel();
        MainContainer = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        MenuName = new javax.swing.JLabel();
        userInfo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(12, 47, 38));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        RequestBtn.setBackground(new java.awt.Color(255, 255, 255));
        RequestBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        RequestBtn.setForeground(new java.awt.Color(245, 245, 220));
        RequestBtn.setText("Pesan");
        RequestBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RequestBtnMouseClicked(evt);
            }
        });

        ItemBtn.setBackground(new java.awt.Color(255, 255, 255));
        ItemBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ItemBtn.setForeground(new java.awt.Color(245, 245, 220));
        ItemBtn.setText("Items");
        ItemBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ItemBtnMouseClicked(evt);
            }
        });

        TransBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TransBtn.setForeground(new java.awt.Color(245, 245, 220));
        TransBtn.setText("Transaksi");
        TransBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TransBtnMouseClicked(evt);
            }
        });

        UserBtn.setBackground(new java.awt.Color(0, 0, 0));
        UserBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        UserBtn.setForeground(new java.awt.Color(245, 245, 220));
        UserBtn.setText("User");
        UserBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UserBtnMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(254, 197, 28));
        jLabel6.setText("Cafe TJJ");

        DashboardBtn.setBackground(new java.awt.Color(0, 0, 0));
        DashboardBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DashboardBtn.setForeground(new java.awt.Color(245, 245, 220));
        DashboardBtn.setText("Dashboard");
        DashboardBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DashboardBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardBtnMouseClicked(evt);
            }
        });

        OutBtn.setBackground(new java.awt.Color(0, 0, 0));
        OutBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        OutBtn.setForeground(new java.awt.Color(245, 245, 220));
        OutBtn.setText("Keluar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UserBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TransBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ItemBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RequestBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(DashboardBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(OutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(DashboardBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RequestBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TransBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 391, Short.MAX_VALUE)
                .addComponent(OutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        MainContainer.setBackground(new java.awt.Color(251, 248, 241));
        MainContainer.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout MainContainerLayout = new javax.swing.GroupLayout(MainContainer);
        MainContainer.setLayout(MainContainerLayout);
        MainContainerLayout.setHorizontalGroup(
            MainContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        MainContainerLayout.setVerticalGroup(
            MainContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(251, 248, 241));

        MenuName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        MenuName.setForeground(new java.awt.Color(12, 47, 38));
        MenuName.setText("Dashboard");

        userInfo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        userInfo.setForeground(new java.awt.Color(12, 47, 38));
        userInfo.setText(this.session.getNama());
        userInfo.setToolTipText("");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(MenuName, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 375, Short.MAX_VALUE)
                .addComponent(userInfo)
                .addGap(73, 73, 73))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MenuName, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userInfo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MainContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MainContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DashboardBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardBtnMouseClicked
        MainContainer.removeAll();
        Dashboard panel = new Dashboard();
        MainContainer.add(panel).setVisible(true);
        MenuName.setText("Dashboard");
    }//GEN-LAST:event_DashboardBtnMouseClicked

    private void RequestBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RequestBtnMouseClicked
        MainContainer.removeAll();
        MenuName.setText("Pesan");
        RequestPanel panel = new RequestPanel();
        MainContainer.add(panel).setVisible(true);
    }//GEN-LAST:event_RequestBtnMouseClicked

    private void ItemBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ItemBtnMouseClicked
        MainContainer.removeAll();
        MenuName.setText("Item");
        ItemPanel panel = new ItemPanel();
        MainContainer.add(panel).setVisible(true);
    }//GEN-LAST:event_ItemBtnMouseClicked

    private void TransBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TransBtnMouseClicked
        MainContainer.removeAll();
        TransactionPanel panel = new TransactionPanel();
        MainContainer.add(panel).setVisible(true);
        MenuName.setText("Transaksi");
    }//GEN-LAST:event_TransBtnMouseClicked

    private void UserBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserBtnMouseClicked
        MainContainer.removeAll();
        MenuName.setText("Users");
        UserPanel panel = new UserPanel();
        MainContainer.add(panel).setVisible(true);
    }//GEN-LAST:event_UserBtnMouseClicked

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        this.dispose();
        new LoginForm().setVisible(true);
    }//GEN-LAST:event_jPanel2MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DashboardBtn;
    private javax.swing.JLabel ItemBtn;
    private javax.swing.JPanel MainContainer;
    private javax.swing.JLabel MenuName;
    private javax.swing.JLabel OutBtn;
    private javax.swing.JLabel RequestBtn;
    private javax.swing.JLabel TransBtn;
    private javax.swing.JLabel UserBtn;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel userInfo;
    // End of variables declaration//GEN-END:variables
}
