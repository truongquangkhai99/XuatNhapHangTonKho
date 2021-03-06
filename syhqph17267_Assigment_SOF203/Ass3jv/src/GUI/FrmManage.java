/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Clothes;
import Util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public final class FrmManage extends javax.swing.JFrame {

    private ArrayList<Clothes> list = new ArrayList<>();
    private DBConnection connection = new DBConnection();
    private DefaultTableModel model;

    /**
     * Creates new form FrmManage
     */
    public FrmManage() {
        initComponents();
        addCategory();
        loadData();
        fillTable();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbbCategory = new javax.swing.JComboBox<>();
        txtName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClothes = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnFindName = new javax.swing.JButton();
        btnNotify = new javax.swing.JButton();
        btnShow = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Manage");

        jLabel2.setText("T??n s???n ph???m");

        jLabel3.setText("Danh m???c");

        tblClothes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "M?? s???n ph???m", "T??n danh m???c", "T??n s???n ph???m", "Gi?? hi???n t???i", "S??? l?????ng", "M??u s???c", "K??ch c???"
            }
        ));
        jScrollPane1.setViewportView(tblClothes);

        btnAdd.setText("Th??m");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("C???p nh???t");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("X??a");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnFindName.setText("T??m ki???m t??n");
        btnFindName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindNameActionPerformed(evt);
            }
        });

        btnNotify.setText("Xem b??o c??o");
        btnNotify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotifyActionPerformed(evt);
            }
        });

        btnShow.setText("Hi???n th???");
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtName))))
                .addGap(209, 209, 209))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnFindName, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNotify)
                            .addComponent(btnShow, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnAdd)
                    .addComponent(btnShow))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnFindName)
                    .addComponent(btnNotify))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(245, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        int hoi = JOptionPane.showConfirmDialog(this, "B???n c?? mu???n th??m kh??ng", "Th??m", JOptionPane.YES_NO_OPTION);
        if (hoi == JOptionPane.YES_OPTION) {
            FrmAddClothes add = new FrmAddClothes();
            add.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int hoi = JOptionPane.showConfirmDialog(this, "B???n mu???n s???a kh??ng", "Update", JOptionPane.YES_NO_OPTION);
        if (hoi == JOptionPane.YES_OPTION) {
            int chon2[] = tblClothes.getSelectedRows();
            if (chon2.length > 0 && chon2.length < 2) {
                FrmUpdate update = new FrmUpdate();
                update.show();
//                update.addCategory();
                update.display(chon2[0]);
                this.dispose();

            } else if (chon2.length >= 2) {
                FrmUpdate update = new FrmUpdate();
                update.show();
                update.display(chon2[0]);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "ch???n 1 s???n ph???m");
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnFindNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindNameActionPerformed
        list.removeAll(list);
        findName();
        fillTable();

    }//GEN-LAST:event_btnFindNameActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        delete();
        loadData();
        fillTable();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnNotifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotifyActionPerformed
        int hoi = JOptionPane.showConfirmDialog(this, "B???n c?? mu???n b??o c??o kh??ng", "Th??m", JOptionPane.YES_NO_OPTION);
        if (hoi == JOptionPane.YES_OPTION) {
            FrmLog log = new FrmLog();
            log.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnNotifyActionPerformed

    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
      list.clear();
        loadData();
        fillTable();
    }//GEN-LAST:event_btnShowActionPerformed

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
            java.util.logging.Logger.getLogger(FrmManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmManage().setVisible(true);
            }
        });
    }

    public void addCategory() {
        try {
            Connection con = connection.getConnection();
            String query = "Select*from category";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                cbbCategory.addItem(rs.getString(2));
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void loadData() {
        try {
            Connection con = connection.getConnection();
            String query = "select  cl.id,ct.CATEGORYNAME,PRODUCTNAME,\n"
                    + "CURRENTPRICE,QUANTITY,COLOR,SIZE  From clothes\n"
                    + "cl join CATEGORY ct on cl.categoryid = ct.CATEGORYID \n"
                    + "where IDLIST=1";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Clothes cl = new Clothes();
                cl.setId(Integer.parseInt(rs.getString(1)));
                cl.setCategoryName(rs.getString(2));
                cl.setProductName(rs.getString(3));
                cl.setCurrentPrice(rs.getBigDecimal(4));
                cl.setQuantity(Integer.parseInt(rs.getString(5)));
                cl.setColor(rs.getString(6));
                cl.setSize(rs.getString(7));
                list.add(cl);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fillTable() {
        model = (DefaultTableModel) tblClothes.getModel();
        model.setRowCount(0);
        for (Clothes clothes : list) {
            Object[] row = new Object[]{
                clothes.getId(), clothes.getCategoryName(), clothes.getProductName(),
                clothes.getCurrentPrice(), clothes.getQuantity(), clothes.getColor(),
                clothes.getSize()
            };
            model.addRow(row);
        }
    }

    public void findCategory() {
        try {
            Connection con = connection.getConnection();
            String query = "select  cl.id,ct.CATEGORYNAME,PRODUCTNAME,\n"
                    + "CURRENTPRICE,QUANTITY,COLOR,SIZE  From clothes\n"
                    + "cl join CATEGORY ct on cl.categoryid = ct.CATEGORYID \n"
                    + "where IDLIST=1 and ct.CATEGORYNAME='" + cbbCategory.getSelectedItem().toString().trim()
                    + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Clothes cl = new Clothes();
                cl.setId(Integer.parseInt(rs.getString(1)));
                cl.setCategoryName(rs.getString(2));
                cl.setProductName(rs.getString(3));
                cl.setCurrentPrice(rs.getBigDecimal(4));
                cl.setQuantity(Integer.parseInt(rs.getString(5)));
                cl.setColor(rs.getString(6));
                cl.setSize(rs.getString(7));
                list.add(cl);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void findName() {
        try {
            Connection con = connection.getConnection();
            String sql = "Select  id,CATEGORYNAME,PRODUCTNAME,CURRENTPRICE,QUANTITY,COLOR,SIZE"
                    + " from clothes cl JOIN CATEGORY CG ON CL.CATEGORYID =CG.CATEGORYID"
                    + " where PRODUCTNAME like N'%" + txtName.getText().trim() + "%' and "
                    + "CATEGORYNAME= '" + cbbCategory.getSelectedItem().toString().trim() + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Clothes cl = new Clothes();
                cl.setId(Integer.parseInt(rs.getString(1)));
                 cl.setCategoryName(rs.getString(2));
                cl.setProductName(rs.getString(3));
                cl.setCurrentPrice(rs.getBigDecimal(4));
                cl.setQuantity(Integer.parseInt(rs.getString(5)));
                cl.setColor(rs.getString(6));
                cl.setSize(rs.getString(7));
                list.add(cl);
            }
            con.close();
        } catch (Exception e) {
        }
    }

    public void delete() {
        int chon[] = tblClothes.getSelectedRows();
        if (chon.length > 0) {
            int hoi = JOptionPane.showConfirmDialog(this, "B???n mu???n x??a kh??ng", "Remove", JOptionPane.YES_NO_OPTION);
            if (hoi == JOptionPane.YES_OPTION) {
                for (int i = chon.length - 1; i >= 0; i--) {
                    Clothes cl = list.get(chon[i]);
                    try {
                        Connection con = connection.getConnection();
                        String delete = "Update clothes set IdList=0 where ID=?";
                        PreparedStatement ps = con.prepareStatement(delete);
                        ps.setString(1, Integer.toString(cl.getId()));
                        ps.executeUpdate();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                JOptionPane.showMessageDialog(this, "X??a th??nh c??ng");
            }
        } else {
            JOptionPane.showMessageDialog(this, "ch???n 1 s???n ph???m");
        }
        list.removeAll(list);
    }

    public Clothes getClothes(int i) {
        return list.get(i);
    }

    public ArrayList<Clothes> getList() {
        return list;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFindName;
    private javax.swing.JButton btnNotify;
    private javax.swing.JButton btnShow;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbbCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClothes;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
