/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import DAO.KhachHangDAO;
import CLASS.khachhang;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import helper.DialogHP;
import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class khachhangform extends javax.swing.JFrame {

    /**
     * Creates new form khachhang
     */
    public khachhangform() {
        initComponents();
        setLocationRelativeTo(null);
         init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_tenKH = new javax.swing.JLabel();
        txt_tenKh = new javax.swing.JTextField();
        lbl_sdt = new javax.swing.JLabel();
        txt_sdt = new javax.swing.JTextField();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_moi = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txt_timTheoTen = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_khachHang = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btn_next = new javax.swing.JButton();
        btn_prev = new javax.swing.JButton();
        btn_last = new javax.swing.JButton();
        btn_first = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("TH??NG TIN KH??CH H??NG"));

        lbl_tenKH.setText("T??n kh??ch h??ng");

        txt_tenKh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tenKhActionPerformed(evt);
            }
        });

        lbl_sdt.setText("S??? ??i???n tho???i");

        txt_sdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sdtActionPerformed(evt);
            }
        });

        btn_them.setText("Th??m");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_sua.setText("S???a");

        btn_moi.setText("M???i");
        btn_moi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_moiActionPerformed(evt);
            }
        });

        btn_xoa.setText("X??a");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(lbl_tenKH))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(lbl_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_moi, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
            .addComponent(txt_sdt)
            .addComponent(txt_tenKh)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lbl_tenKH)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_tenKh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_sdt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_them)
                    .addComponent(btn_moi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_xoa)
                    .addComponent(btn_sua))
                .addGap(26, 26, 26))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_timTheoTen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_timTheoTenKeyPressed(evt);
            }
        });

        tbl_khachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "M?? kh??ch h??ng", "T??n kh??ch h??ng", "S??? ??i???n tho???i"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_khachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_khachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_khachHang);

        jLabel1.setText("T??m ki???m");

        btn_next.setText(">>");
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });

        btn_prev.setText("<<");
        btn_prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prevActionPerformed(evt);
            }
        });

        btn_last.setText(">|");
        btn_last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lastActionPerformed(evt);
            }
        });

        btn_first.setText("|<");
        btn_first.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_firstActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(txt_timTheoTen)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_first)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_prev)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_next)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_last)
                .addGap(139, 139, 139))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_timTheoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_next)
                    .addComponent(btn_prev)
                    .addComponent(btn_last)
                    .addComponent(btn_first))
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 204));
        jLabel2.setText("KH??CH H??NG");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(206, 206, 206))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        if(txt_tenKh.getText().isBlank()){
            DialogHP.alert(this, "Ph???i nh???p t??n kh??ch");
        } else if( txt_sdt.getText().isBlank()){
            DialogHP.alert(this, "Ph???i nh???p s??? ??i???n tho???i");
        }else{
            insert();
        }
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_moiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_moiActionPerformed
        clear();
    }//GEN-LAST:event_btn_moiActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        delete();
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prevActionPerformed
        if (this.index > 0 ) {
            this.index--;
            tbl_khachHang.setRowSelectionInterval(index, index);
            this.setStatus();
            this.edit();
        }
    }//GEN-LAST:event_btn_prevActionPerformed

    private void btn_firstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_firstActionPerformed
        this.index = 0;
        tbl_khachHang.setRowSelectionInterval(index, index);
        this.setStatus();
        this.edit();
    }//GEN-LAST:event_btn_firstActionPerformed

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        if (this.index < tbl_khachHang.getRowCount() -1  ) {
            this.index++;
            tbl_khachHang.setRowSelectionInterval(index, index);
            this.setStatus();
            this.edit();
        }
    }//GEN-LAST:event_btn_nextActionPerformed

    private void btn_lastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lastActionPerformed
        this.index = tbl_khachHang.getRowCount() - 1;
        tbl_khachHang.setRowSelectionInterval(index, index);
        this.setStatus();
        this.edit();
    }//GEN-LAST:event_btn_lastActionPerformed

    private void txt_timTheoTenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_timTheoTenKeyPressed
        findByName(txt_timTheoTen.getText());
    }//GEN-LAST:event_txt_timTheoTenKeyPressed

    private void tbl_khachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_khachHangMouseClicked

        this.index = tbl_khachHang.getSelectedRow();
        if (this.index >= 0) {
            this.edit();
            this.setStatus();
        }
    }//GEN-LAST:event_tbl_khachHangMouseClicked

    private void txt_tenKhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tenKhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tenKhActionPerformed

    private void txt_sdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sdtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sdtActionPerformed

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
            java.util.logging.Logger.getLogger(khachhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(khachhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(khachhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(khachhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new khachhangform().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_first;
    private javax.swing.JButton btn_last;
    private javax.swing.JButton btn_moi;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_prev;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_sdt;
    private javax.swing.JLabel lbl_tenKH;
    private javax.swing.JTable tbl_khachHang;
    private javax.swing.JTextField txt_sdt;
    private javax.swing.JTextField txt_tenKh;
    private javax.swing.JTextField txt_timTheoTen;
    // End of variables declaration//GEN-END:variables
   int index = -1;
    DAO.KhachHangDAO dao = new KhachHangDAO();

    void init() {
        loadTable();
        this.setStatus();
    }

    void loadTable() {
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) tbl_khachHang.getModel();
        model.setRowCount(0);
        try {
            List<khachhang> list = dao.select();
            for (khachhang kh : list) {
                model.addRow(new Object[]{kh.getIdkhachhang(), kh.getHotenkhach(), kh.getSdt()});
            }
        } catch (Exception e) {
            DialogHP.alert(this, "L???i truy v???n d??? li???u");
        }
    }

    void insert() {
        String tenKh = txt_tenKh.getText();
        String sdt = txt_sdt.getText();
        List<khachhang> list = dao.select();
        int a = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getSdt().equalsIgnoreCase(sdt)) {
                DialogHP.alert(this, "S??? ??i???n tho???i ???? ???????c s??? d???ng!");
                a = 1;
                break;
            }
        }
        if (a != 1) {
            khachhang kh = new khachhang();
            kh.setHotenkhach(tenKh);
            kh.setSdt(sdt);
            dao.insert(kh);
            this.loadTable();
            DialogHP.alert(this, "th??m th??nh c??ng");
            this.clear();
        }
    }

    void delete() {
        String tenKh = txt_tenKh.getText();
        String sdt = txt_sdt.getText();
        List<khachhang> list = dao.select();
        int maKh = -1;
        for (khachhang kh : list) {
            if (kh.getHotenkhach().equalsIgnoreCase(tenKh) && kh.getSdt().equalsIgnoreCase(sdt)) {
                maKh = kh.getIdkhachhang();
            }
        }
        if (DialogHP.confirm(this, "X??c nh???n xo??")) {
            dao.delete(maKh);
            DialogHP.alert(this, "Xo?? th??nh c??ng");
            this.clear();
            this.loadTable();
        }
    }

    void edit() {
        int idKhachHang = Integer.parseInt(String.valueOf(tbl_khachHang.getValueAt(index, 0)));
        List<khachhang> list = dao.select();
        khachhang model = null;
        for (khachhang kh : list) {
            if (idKhachHang == kh.getIdkhachhang()) {
                model = kh;
            }
        }
        if (model != null) {
            txt_sdt.setText(model.getSdt());
            txt_tenKh.setText(model.getHotenkhach());
        }
    }

    void clear() {
        txt_sdt.setText("");
        txt_tenKh.setText("");
        this.index = -1;
        this.setStatus();
    }

    void setStatus() {
        if (this.index >= 0) {
            btn_them.setEnabled(false);
            btn_sua.setEnabled(true);
            btn_xoa.setEnabled(true);
        } else {
            btn_sua.setEnabled(false);
            btn_xoa.setEnabled(false);
            btn_them.setEnabled(true);
        }

    }
    
    void findByName(String name){
        List<khachhang> list = dao.findByName(name);
        if (list != null) {
            DefaultTableModel model = (DefaultTableModel) tbl_khachHang.getModel();
            model.setRowCount(0);
            for (khachhang kh : list) {
                model.addRow(new Object[]{kh.getIdkhachhang(), kh.getHotenkhach(),kh.getSdt()});
            }
        }else{
            DialogHP.alert(this, "Kh??ng t??m th???y");
        }
    }
}
