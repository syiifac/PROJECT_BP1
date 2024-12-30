/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectbp1_apkkasirrestoran;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class menu_makanan extends javax.swing.JFrame {
    private DefaultTableModel model = null;
    private PreparedStatement stat;
    private ResultSet rs;
    koneksi k = new koneksi();
    

    /**
     * Creates new form menu_makanan
     */
    public menu_makanan() {
        initComponents();
        k.connect();
        refreshTable();
    }

    class makanan extends menu_makanan{
        int id_makanan, harga;
        String nama_makanan, status;
        
        public makanan(){
            this.nama_makanan = namaMakanan.getText();
            this.harga = Integer.parseInt(HARGA.getText());
            this.status = combo_status.getSelectedItem().toString();
        }
    }
    
    public void refreshTable(){
        model = new DefaultTableModel();
        model.addColumn("ID Makanan");
        model.addColumn("Nama Makanan");
        model.addColumn("Harga");
        model.addColumn("Status Makanan");
        table_makanan.setModel(model);
        try {
            this.stat = k.getCon().prepareStatement("select * from makanan");
            this.rs = this.stat.executeQuery();
            while (rs.next()) {
                Object[] data ={
                    rs.getInt("id_makanan"),
                    rs.getString("nama_makanan"),
                    rs.getInt("harga"),
                    rs.getString("status")
                };
                model.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        idMakanan.setText("");
        namaMakanan.setText("");
        HARGA.setText("");   
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        idMakanan = new javax.swing.JTextField();
        namaMakanan = new javax.swing.JTextField();
        HARGA = new javax.swing.JTextField();
        combo_status = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        tombol_input = new javax.swing.JButton();
        tombol_update = new javax.swing.JButton();
        tombol_delete = new javax.swing.JButton();
        tombol_menuReg = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_makanan = new javax.swing.JTable();
        menu_transaksi = new javax.swing.JButton();
        logout = new javax.swing.JButton();

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("MENU MAKANAN");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("ID MAKANAN ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("NAMA MAKANAN");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("HARGA");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("STATUS MAKANAN");

        idMakanan.setEnabled(false);
        idMakanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idMakananActionPerformed(evt);
            }
        });

        HARGA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HARGAActionPerformed(evt);
            }
        });

        combo_status.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        combo_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TERSEDIA", "HABIS", " " }));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tombol_input.setText("INPUT");
        tombol_input.setEnabled(false);
        tombol_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombol_inputActionPerformed(evt);
            }
        });

        tombol_update.setText("UPDATE");
        tombol_update.setEnabled(false);
        tombol_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombol_updateActionPerformed(evt);
            }
        });

        tombol_delete.setText("DELETE");
        tombol_delete.setEnabled(false);
        tombol_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombol_deleteActionPerformed(evt);
            }
        });

        tombol_menuReg.setText("MENU REGISTRASI");
        tombol_menuReg.setEnabled(false);
        tombol_menuReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombol_menuRegActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tombol_input, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tombol_update, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tombol_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tombol_menuReg, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tombol_input, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tombol_update, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tombol_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tombol_menuReg, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        table_makanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_makanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_makananMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_makanan);

        menu_transaksi.setText("MENU TRANSAKSI");
        menu_transaksi.setEnabled(false);
        menu_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_transaksiActionPerformed(evt);
            }
        });

        logout.setText("LOGOUT");
        logout.setEnabled(false);
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(menu_transaksi))
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(combo_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(idMakanan, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(namaMakanan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(HARGA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(logout))
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(238, 238, 238))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logout)
                    .addComponent(menu_transaksi))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(39, 39, 39)
                        .addComponent(idMakanan, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaMakanan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HARGA, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(combo_status, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tombol_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombol_updateActionPerformed
        // TODO add your handling code here:
        try {
            makanan m = new makanan();
             this.stat = k.getCon().prepareStatement("update makanan set nama_makanan=?, "
                     + "harga=?, status=? where id_makanan=?");
            stat.setString(1, m.nama_makanan);
            stat.setInt(2, m.harga);
            stat.setString(3, m.status);
            stat.setInt(4, Integer.parseInt(idMakanan.getText()));
            stat.executeUpdate();
            refreshTable();
        }  catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_tombol_updateActionPerformed

    private void idMakananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idMakananActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idMakananActionPerformed

    private void HARGAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HARGAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HARGAActionPerformed

    private void menu_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_transaksiActionPerformed
        // TODO add your handling code here:
        menu_transaksi tran = new menu_transaksi();
        tran.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menu_transaksiActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        Login l = new Login ();
        l.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_logoutActionPerformed

    private void tombol_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombol_inputActionPerformed
        // TODO add your handling code here:
        try{
            makanan m = new makanan();
            this.stat = k.getCon().prepareStatement("insert into makanan values(?,?,?,?)");
            stat.setInt(1, 0);
            stat.setString(2, m.nama_makanan);
            stat.setInt(3, m.harga);
            stat.setString(4, m.status);
            stat.executeUpdate();
            refreshTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_tombol_inputActionPerformed

    private void table_makananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_makananMouseClicked
        // TODO add your handling code here:
        idMakanan.setText(model.getValueAt(table_makanan.getSelectedRow(), 0).toString());
        namaMakanan.setText(model.getValueAt(table_makanan.getSelectedRow(), 1).toString());
        HARGA.setText(model.getValueAt(table_makanan.getSelectedRow(), 2).toString());
        
    }//GEN-LAST:event_table_makananMouseClicked

    private void tombol_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombol_deleteActionPerformed
        // TODO add your handling code here:
        try {
           this.stat = k.getCon().prepareStatement("delete from makanan where id_makanan=?");
           stat.setInt(1, Integer.parseInt(idMakanan.getText()));
           stat.executeUpdate();
           refreshTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_tombol_deleteActionPerformed

    private void tombol_menuRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombol_menuRegActionPerformed
        // TODO add your handling code here:
        menu_registrasi reg = new menu_registrasi();
        reg.setVisible(true);
        this.setVisible(false);   
    }//GEN-LAST:event_tombol_menuRegActionPerformed

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
            java.util.logging.Logger.getLogger(menu_makanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu_makanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu_makanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu_makanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu_makanan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField HARGA;
    private javax.swing.JComboBox<String> combo_status;
    private javax.swing.JTextField idMakanan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton logout;
    public javax.swing.JButton menu_transaksi;
    private javax.swing.JTextField namaMakanan;
    private javax.swing.JTable table_makanan;
    public javax.swing.JButton tombol_delete;
    public javax.swing.JButton tombol_input;
    public javax.swing.JButton tombol_menuReg;
    public javax.swing.JButton tombol_update;
    // End of variables declaration//GEN-END:variables
}