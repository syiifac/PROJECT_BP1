/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectbp1_apkkasirrestoran;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ACER
 */
public class menu_transaksi extends javax.swing.JFrame {
    private DefaultTableModel model = null;
    private PreparedStatement stat;
    private ResultSet rs;
    koneksi k = new koneksi();
    /**
     * Creates new form menu_makanan
     */
    public menu_transaksi() {
        initComponents();
        k.connect();
        refreshTable();
        refreshCombo();
    }
    
    class transaksi extends menu_transaksi {
        int id_transaksi, id_makanan, harga, jumlah_beli, total_bayar;
        String nama_pelanggan, tanggal, nama_makanan;
        
        public transaksi(){
            this.nama_pelanggan = namaPelanggan.getText();
            String combo = combo_idmakanan.getSelectedItem().toString();
            String []arr = combo.split(":");
            this.id_makanan = Integer.parseInt(arr[0]);
            try {
                Date date = textTgl.getDate();
                DateFormat dateformat = new SimpleDateFormat("YYYY-MM-dd");
                this.tanggal = dateformat.format(date);
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
            this.nama_makanan = arr[1];
            this.harga = Integer.parseInt(arr[2]);
            this.jumlah_beli = Integer.parseInt(jumlahBeli.getText());
            this.total_bayar = this.harga * this.jumlah_beli;
            
        }
        
    }
    
    public void refreshTable (){
        model = new DefaultTableModel();
        model.addColumn("ID Transaksi");
        model.addColumn("Nama Pelanggan");
        model.addColumn("ID Makanan");
        model.addColumn("Tanggal");
        model.addColumn("Nama Makanan");
        model.addColumn("Harga");
        model.addColumn("Jumlah Beli");
        model.addColumn("Total Bayar");
        tableTransaksi.setModel(model);
        try {
           this.stat = k.getCon().prepareStatement("select * from transaksi");
           this.rs = this.stat.executeQuery();
           while (rs.next()){
               Object[] data = {
                   rs.getString(1),
                   rs.getString(2),
                   rs.getString(3),
                   rs.getString(4),
                   rs.getString(5),
                   rs.getString(6),
                   rs.getString(7),
                   rs.getString(8),       
               };
               model.addRow(data);
           }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        idTransaksi.setText("");
        namaPelanggan.setText("");
        jumlahBeli.setText("");
        totalBayar.setText("");
    }
    
    public void refreshCombo(){
        try {
            this.stat = k.getCon().prepareStatement("select * from makanan "
                    + "where status='Tersedia'");
            this.rs = this.stat.executeQuery();
            while (rs.next()){
                combo_idmakanan.addItem(rs.getString("id_makanan")+":"+ 
                rs.getString("nama_makanan")+":"+rs.getString("harga"));
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
    }
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
        idTransaksi = new javax.swing.JTextField();
        namaPelanggan = new javax.swing.JTextField();
        combo_idmakanan = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        tombol_input = new javax.swing.JButton();
        tombol_update = new javax.swing.JButton();
        tombol_delete = new javax.swing.JButton();
        tombol_cetaklaporan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTransaksi = new javax.swing.JTable();
        logout = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        textTgl = new com.toedter.calendar.JDateChooser();
        tombol_lihatmenu = new javax.swing.JButton();
        jumlahBeli = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        totalBayar = new javax.swing.JTextField();

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("TRANSAKSI");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("ID TRANSAKSI");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("NAMA PELANGGAN");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("ID MAKANAN");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("JUMLAH BELI");

        idTransaksi.setEnabled(false);
        idTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTransaksiActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tombol_input.setText("INPUT");
        tombol_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombol_inputActionPerformed(evt);
            }
        });

        tombol_update.setText("UPDATE");
        tombol_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombol_updateActionPerformed(evt);
            }
        });

        tombol_delete.setText("DELETE");
        tombol_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombol_deleteActionPerformed(evt);
            }
        });

        tombol_cetaklaporan.setText("CETAK LAPORAN");
        tombol_cetaklaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombol_cetaklaporanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tombol_input, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tombol_update, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tombol_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tombol_cetaklaporan, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tombol_input, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tombol_update, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tombol_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tombol_cetaklaporan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        tableTransaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        tableTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTransaksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableTransaksi);

        logout.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        logout.setText("LOGOUT");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("TANGGAL");

        tombol_lihatmenu.setText("LIHAT MENU");
        tombol_lihatmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombol_lihatmenuActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("TOTAL BAYAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3)
                                .addComponent(jLabel7)
                                .addComponent(jLabel5))
                            .addGap(55, 55, 55)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jumlahBeli)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(41, 41, 41)
                                            .addComponent(jLabel1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(logout))
                                        .addComponent(idTransaksi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                                        .addComponent(namaPelanggan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                                        .addComponent(textTgl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(combo_idmakanan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tombol_lihatmenu)))
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(totalBayar, javax.swing.GroupLayout.Alignment.TRAILING)))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(logout))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel1)))
                        .addGap(44, 44, 44)
                        .addComponent(idTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(namaPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combo_idmakanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(tombol_lihatmenu))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textTgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jumlahBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(totalBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tombol_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombol_updateActionPerformed
        // TODO add your handling code here:
    try {
        transaksi tran = new transaksi();
        tran.id_transaksi = Integer.parseInt(idTransaksi.getText());
        this.stat = k.getCon().prepareStatement("update transaksi set nama_pelanggan=?,"
                + "id_makanan=?,tanggal=?,nama_makanan=?,harga=?,jumlah_beli=?,total_bayar=? "
                + "where id_transaksi=?");
        this.stat.setString(1, tran.nama_pelanggan);
        this.stat.setInt(2, tran.id_makanan);
        this.stat.setString(3, tran.tanggal);
        this.stat.setString(4, tran.nama_makanan);
        this.stat.setInt(5, tran.harga);
        this.stat.setInt(6, tran.jumlah_beli);
        this.stat.setInt(7, tran.total_bayar);
        this.stat.setInt(8, tran.id_transaksi);
        this.stat.executeUpdate();
        refreshTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
      }
    }//GEN-LAST:event_tombol_updateActionPerformed

    private void idTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTransaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idTransaksiActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        Login l = new Login ();
        l.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_logoutActionPerformed

    private void tombol_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombol_inputActionPerformed
        // TODO add your handling code here:
        try {
            transaksi tran = new transaksi();
            totalBayar.setText(""+tran.total_bayar);
            this.stat = k.getCon().prepareStatement("insert into transaksi values(?,?,?,?,?,?,?,?)");
            this.stat.setInt(1,0);
            this.stat.setString(2, tran.nama_pelanggan);
            this.stat.setInt(3, tran.id_makanan);
            this.stat.setString(4, tran.tanggal);
            this.stat.setString(5, tran.nama_makanan);
            this.stat.setInt(6, tran.harga);
            this.stat.setInt(7, tran.jumlah_beli);
            this.stat.setInt(8, tran.total_bayar);
            int pilihan = JOptionPane.showConfirmDialog(null,
                    "Tanggal: "+tran.tanggal+
                    "\nNama Pelanggan: "+tran.nama_pelanggan+
                    "\nPembelian: "+tran.jumlah_beli+" "+tran.nama_makanan+
                    "\nTotal Bayar: "+tran.total_bayar+"\n",
                    "Tambahkan Transaksi?",
                    JOptionPane.YES_NO_OPTION);
            if (pilihan ==JOptionPane.YES_OPTION){
                this.stat.executeUpdate();
                refreshTable();
            } else if (pilihan == JOptionPane.NO_OPTION){
                refreshTable();
            }
            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_tombol_inputActionPerformed

    private void tableTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTransaksiMouseClicked
        // TODO add your handling code here:
    idTransaksi.setText(model.getValueAt(tableTransaksi.getSelectedRow(), 0).toString());
    namaPelanggan.setText(model.getValueAt(tableTransaksi.getSelectedRow(), 1).toString());
    jumlahBeli.setText(model.getValueAt(tableTransaksi.getSelectedRow(), 6).toString());
    totalBayar.setText(model.getValueAt(tableTransaksi.getSelectedRow(), 7).toString());
    
    }//GEN-LAST:event_tableTransaksiMouseClicked

    private void tombol_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombol_deleteActionPerformed
        // TODO add your handling code here:
        try {
            transaksi tran = new transaksi();
            tran.id_transaksi = Integer.parseInt(idTransaksi.getText());
            this.stat = k.getCon().prepareStatement("delete from transaksi "
                   + "where id_transaksi=?");
            this.stat.setInt(1, tran.id_transaksi);
            this.stat.executeUpdate();
            refreshTable();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_tombol_deleteActionPerformed

    private void tombol_lihatmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombol_lihatmenuActionPerformed
        // TODO add your handling code here:
        menu_makanan makanan = new menu_makanan();
        makanan.setVisible(true);
        this.setVisible(false);
        makanan.tombol_delete.setEnabled(true);
        makanan.tombol_input.setEnabled(true);
        makanan.tombol_update.setEnabled(true);
        makanan.menu_transaksi.setEnabled(true);
        
    }//GEN-LAST:event_tombol_lihatmenuActionPerformed

    private void tombol_cetaklaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombol_cetaklaporanActionPerformed
        // TODO add your handling code here:
      try{
         File namaFile = new File("src/laporan/laporan_transaksi.jasper");
         JasperPrint jp = JasperFillManager.fillReport(namaFile.getPath(), null, k.getCon());
         JasperViewer.viewReport(jp,false);
      }  catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
      }
    }//GEN-LAST:event_tombol_cetaklaporanActionPerformed

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
            java.util.logging.Logger.getLogger(menu_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu_transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_idmakanan;
    private javax.swing.JTextField idTransaksi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jumlahBeli;
    public javax.swing.JButton logout;
    private javax.swing.JTextField namaPelanggan;
    private javax.swing.JTable tableTransaksi;
    private com.toedter.calendar.JDateChooser textTgl;
    public javax.swing.JButton tombol_cetaklaporan;
    public javax.swing.JButton tombol_delete;
    public javax.swing.JButton tombol_input;
    private javax.swing.JButton tombol_lihatmenu;
    public javax.swing.JButton tombol_update;
    private javax.swing.JTextField totalBayar;
    // End of variables declaration//GEN-END:variables
}
