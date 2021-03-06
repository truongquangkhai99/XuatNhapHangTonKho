/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Util.DBConnection;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class FrmNotify extends javax.swing.JFrame {

    private final DBConnection connection = new DBConnection();
    private DefaultTableModel model;

    /**
     * Creates new form FrmNotify
     */
    public FrmNotify() {
        initComponents();
        fillNotify2();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblNotify = new javax.swing.JTable();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblNotify.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ProductID", "Turnover", "SellNumber", "CategoryName", "ProductName", "CurrentPrice", "RemainingQuantity", "Color", "Size", "IOE"
            }
        ));
        jScrollPane1.setViewportView(tblNotify);

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(613, 613, 613)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClose)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        int hoi = JOptionPane.showConfirmDialog(this, "B???n c?? mu???n tho??t kh??ng", "Exit", JOptionPane.YES_NO_OPTION);
        if (hoi == JOptionPane.YES_OPTION) {
            this.dispose();
            FrmManage manager = new FrmManage();
            manager.setVisible(true);
        }
    }//GEN-LAST:event_btnCloseActionPerformed

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
            java.util.logging.Logger.getLogger(FrmNotify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmNotify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmNotify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmNotify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmNotify().setVisible(true);
            }
        });
    }

    public void fillNotify2() {
        try {
            model = (DefaultTableModel) tblNotify.getModel();
            model.setRowCount(0);
            Connection con = connection.getConnection();
            String notify = "declare @bang table\n"
                    + "(  PRODUCTID INT,\n"
                    + "   PRICE     FLOAT,\n"
                    + "   QUANTITY  INT\n"
                    + ")\n"
                    + "INSERT @BANG \n"
                    + "select TOP 3 PRODUCTID,sum(price),sum(quantity) from\n"
                    + "INVENTORYLOG where ioe=0\n"
                    + "group by PRODUCTID,ABS( MONTH(GETDATE())-MONTH(IEDATE))\n"
                    + "having ABS( MONTH(GETDATE())-MONTH(IEDATE))=0\n"
                    + "ORDER BY sum(price) DESC\n"
                    + "declare @bang2  table\n"
                    + "(\n"
                    + "   PRODUCTID INT,\n"
                    + "   PRICE     money,\n"
                    + "   QUANTITY1  INT,\n"
                    + "   CATEGORYNAME nchar(10),\n"
                    + "   PRODUCTNAME nchar(30),\n"
                    + "   CURRENTPRICE Float,\n"
                    + "   QUANTITY  INT,\n"
                    + "   COLOR    NCHAR(20),\n"
                    + "   SIZE     NCHAR(10),\n"
                    + "   IOE      BIT\n"
                    + "\n"
                    + ")\n"
                    + "INSERT  @bang2\n"
                    + "SELECT B.PRODUCTID,B.PRICE,B.QUANTITY,CG.CATEGORYNAME,CL.PRODUCTNAME,\n"
                    + "CL.CURRENTPRICE,CL.QUANTITY, CL.COLOR,CL.SIZE, IG.IOE FROM CLOTHES CL  \n"
                    + "JOIN @BANG B         ON B.PRODUCTID = CL.ID\n"
                    + "join INVENTORYLOG IG ON B.PRODUCTID =IG.PRODUCTID\n"
                    + "join CATEGORY CG  ON CG.CATEGORYID=CL.CATEGORYID\n"
                    + "where cl.IDLIST=1 and ioe =0\n"
                    + "group by  B.PRODUCTID,B.PRICE,B.QUANTITY,CG.CATEGORYNAME,CL.PRODUCTNAME,\n"
                    + "CL.CURRENTPRICE,CL.QUANTITY, CL.COLOR,CL.SIZE, IG.IOE\n"
                    + "ORDER BY SUM(b.PRICE) DESC\n"
                    + "select*from @bang2 order by PRICE desc";
                    
                    

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(notify);
            String ioe;
            while (rs.next()) {
                Object row[] = new Object[]{
                    rs.getString(1), rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5), rs.getString(6),
                    rs.getString(7), rs.getString(8), rs.getString(9),
                    ioe = rs.getString(10).equalsIgnoreCase("0") ? "Xu???t" : "Nh???p"
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblNotify;
    // End of variables declaration//GEN-END:variables
}
