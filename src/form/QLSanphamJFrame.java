/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import DAO.LoaiSanphamDAO;
import DAO.SanphamDao;
import helper.DateHP;
import helper.DialogHP;
import helper.ShareHelper;
import helper.Validate;
import CLASS.Loaisanpham;
import CLASS.Nhanvien_1;
import CLASS.Sanpham_1;
import java.io.File;
import static java.lang.System.exit;
import java.util.List;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class QLSanphamJFrame extends javax.swing.JFrame {

    /**
     * Creates new form QLSanphamJFrame
     */
    JFileChooser jFileChooser = new JFileChooser("Ảnh sản phẩm\\");
    StringBuilder sb = new StringBuilder();
    helper.Validate validate = new Validate();

    public QLSanphamJFrame() {
        initComponents();
        setLocationRelativeTo(null);
        fillcbsp();

        setidloaisp();
        load();

        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        btnInsert.setEnabled(false);
    }
    int index = 0;

    public void fillcbsp() { 
        try {
            cbxLoaisp.removeAllItems();
            cbxsearch.removeAllItems();
            this.cbxsearch.addItem("Chọn loại sản phẩm");
            String username = "sa";
            String password = "11";

            String dburl = "jdbc:sqlserver://localhost:1433;databaseName=QLBANHANG;integratedSecurity=true";
            Connection conn = DriverManager.getConnection(dburl);
            String sql = "SELECT * FROM LoaiSP";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                this.cbxLoaisp.addItem(rs.getString("TENLOAISP"));
                this.cbxsearch.addItem(rs.getString("TENLOAISP"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private Sanpham_1 getModel() {
        Sanpham_1 model = new Sanpham_1();
        model.setIDsanpham(Lblmasp.getText());
        model.setIdloaisp(Integer.valueOf(txtmaloaisp.getText()));
        model.setTensp(txttensp.getText());
        model.setMota(txtMota.getText());
        model.setHinhanh(lblhinh.getToolTipText());
        model.setGiaban(Double.valueOf(txtGiaban.getText()));
        model.setGianhap(Double.valueOf(txtGianhap.getText()));
        model.setSize(String.valueOf(cbxSize.getSelectedItem()));
        model.setSoluongton(Integer.valueOf(txtSoluongton.getText()));
        return model;
    }

    public void setidloaisp() {
        try {
            String username = "sa";
            String password = "11";

            String dburl = "jdbc:sqlserver://localhost:1433;databaseName=QLBANHANG;integratedSecurity=true";
            Connection conn = DriverManager.getConnection(dburl);
            String sql = "SELECT IDLOAISP FROM LOAISP WHERE TENLOAISP = ? ";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cbxLoaisp.getSelectedItem().toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                txtmaloaisp.setText(rs.getString("IDLOAISP"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void settenloaisp() {
        try {
            String username = "sa";
            String password = "11";

            String dburl = "jdbc:sqlserver://localhost:1433;databaseName=QLBANHANG;integratedSecurity=true";
            Connection conn = DriverManager.getConnection(dburl);
            String sql = "SELECT TENLOAISP FROM LOAISP WHERE IDLOAISP = ? ";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, txtmaloaisp.getText());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cbxLoaisp.setSelectedItem(rs.getString("TENLOAISP"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void load() {
        DefaultTableModel model = (DefaultTableModel) tblGridView.getModel();
        model.setColumnIdentifiers(new Object[]{"ID Sản phẩm", "Tên SP", "Hình", "Giá nhập", "Giá bán", "Size", "Số lượng tồn", "Mô tả", "ID loại SP"});
        model.setRowCount(0);
        try {
            List<Sanpham_1> list = SanphamDao.select();
            for (Sanpham_1 nv : list) {
                Object[] row = {
                    nv.getIDsanpham(),
                    nv.getTensp(),
                    nv.getHinhanh(),
                    nv.getGianhap(),
                    nv.getGiaban(),
                    nv.getSize(),
                    nv.getSoluongton(),
                    nv.getMota(),
                    nv.getIdloaisp(),};
                model.addRow(row);
            }
        } catch (Exception e) {
            DialogHP.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    private void findbang() {
        DefaultTableModel model = (DefaultTableModel) tblGridView.getModel();
        model.setColumnIdentifiers(new Object[]{"ID Sản phẩm", "Tên SP", "Hình", "Giá nhập", "Giá bán", "Size", "Số lượng tồn", "Mô tả", "ID loại SP"});
        model.setRowCount(0);
        try {
            if (cbxsearch.getSelectedItem().equals("Chọn loại sản phẩm")) {
                load();
            } else {
                List<Sanpham_1> list = SanphamDao.findbang(cbxsearch.getSelectedItem().toString());
                for (Sanpham_1 nv : list) {
                    Object[] row = {
                        nv.getIDsanpham(),
                        nv.getTensp(),
                        nv.getHinhanh(),
                        nv.getGianhap(),
                        nv.getGiaban(),
                        nv.getSize(),
                        nv.getSoluongton(),
                        nv.getMota(),
                        nv.getIdloaisp(),};
                    model.addRow(row);
                }
            }
        } catch (Exception e) {

        }
    }

    private void search() {
        DefaultTableModel model = (DefaultTableModel) tblGridView.getModel();
        model.setColumnIdentifiers(new Object[]{"ID Sản phẩm", "Tên SP", "Hình", "Giá nhập", "Giá bán", "Size", "Số lượng tồn", "Mô tả", "ID loại SP"});
        model.setRowCount(0);
        try {
            List<Sanpham_1> list = SanphamDao.find(txtFind.getText(), txtFind.getText());
            for (Sanpham_1 nv : list) {
                Object[] row = {
                    nv.getIDsanpham(),
                    nv.getTensp(),
                    nv.getHinhanh(),
                    nv.getGianhap(),
                    nv.getGiaban(),
                    nv.getSize(),
                    nv.getSoluongton(),
                    nv.getMota(),
                    nv.getIdloaisp(),};
                model.addRow(row);
            }
        } catch (Exception e) {
            DialogHP.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void selectImage() {
        if (jFileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser.getSelectedFile();
            if (ShareHelper.saveLogo(file)) {
                lblhinh.setIcon(new ImageIcon(ShareHelper.resize(file.getPath(), 150, 150)));
                lblhinh.setToolTipText(file.getName());
            }
        }
    }

    private void setModel(Sanpham_1 model) {

        txttensp.setText(model.getTensp());
        txtGiaban.setText(model.getGiaban() + "");
        txtGianhap.setText(model.getGianhap() + "");
        cbxSize.setSelectedItem(model.getSize());
        txtMota.setText(model.getMota());
        txtmaloaisp.setText(model.getIdloaisp() + "");
        Lblmasp.setText(model.getIDsanpham());
        txtSoluongton.setText(model.getSoluongton() + "");
        lblhinh.setToolTipText(model.getHinhanh());
        if (model.getHinhanh() != null) {
            lblhinh.setIcon(ShareHelper.readLogo(model.getHinhanh()));
        }
        if (model.getHinhanh() == null) {
            lblhinh.setIcon(ShareHelper.readLogo("aodefault.png"));
            lblhinh.setToolTipText("aodefault.png");
        }

    }

    void insert() {
        StringBuilder sb = new StringBuilder();
        try {
            if (!validate.checkNull(txttensp.getText())) {
                sb.append("Vui lòng nhập tên sản phẩm \n");
            }
            if (!validate.checkNull(txtGianhap.getText())) {
               
                sb.append("Vui lòng nhập giá nhập \n");
            }
            if (!validate.checkNull(txtGiaban.getText())) {
           
                sb.append("Vui lòng nhập giá bán \n");
            }
            if (!validate.checkNull(txtSoluongton.getText())) {
           
                sb.append("Vui lòng nhập số lượng tồn \n");
            }
             if (!validate.checkNull(txtGiaban.getText())) {
           
                sb.append("Vui lòng nhập giá bán \n");
            } if (!validate.checkSo(txtGiaban.getText())) {
           
                sb.append("Giá bán phải là số \n");
            }
             if (!validate.checkSo(txtGianhap.getText())) {
           
                sb.append("Giá nhập phải là số \n");
            }
              if (!validate.checkSoint(txtSoluongton.getText())) {
           
                sb.append("Số lượng tồn phải là số nguyên dương \n");
            }
            if (sb.toString().isBlank()) {
                System.out.println("donene");
                Sanpham_1 model = getModel();

                SanphamDao.insert(model);
                this.load();
                this.clear();
                DialogHP.alert(this, "Thêm mới thành công!");
            } else {
                JOptionPane.showMessageDialog(this, sb.toString());
                 sb.setLength(0);

                return;
            }

        } catch (Exception e) {
            DialogHP.alert(this, "Thêm mới thất bại!");
            e.printStackTrace();
        }
    }

    private void clear() {
        this.setModel(new Sanpham_1());
        this.setStatus(true);
        cbxSize.setSelectedIndex(0);
        cbxLoaisp.setSelectedIndex(0);
        btnInsert.setEnabled(true);
        setidloaisp();

    }

    void setStatus(boolean insertable) {

        btnUpdate.setEnabled(insertable);
        btnUpdate.setEnabled(!insertable);
        btnDelete.setEnabled(!insertable);
        boolean first = this.index > 0;
        boolean last = this.index < tblGridView.getRowCount() - 1;
        btnFirst.setEnabled(!insertable && first);
        btnPrev.setEnabled(!insertable && first);
        btnLast.setEnabled(!insertable && last);
        btnNext.setEnabled(!insertable && last);
    }

    void delete() {
        if (DialogHP.confirm(this, "Bạn có muốn xóa hay không?")) {
            String macd = Lblmasp.getText();
            try {
                SanphamDao.delete(macd);
                this.load();
                this.clear();
                DialogHP.alert(this, "Xóa thành công!");
            } catch (Exception e) {
                DialogHP.alert(this, "Xóa thất bại!");
                e.printStackTrace();
            }
        }
    }

    void edit() {
        try {
            String macd = (String) tblGridView.getValueAt(this.index, 0);
            Sanpham_1 model = SanphamDao.findById(macd);
            if (model != null) {
                this.setModel(model);
                this.setStatus(false);
            }
        } catch (Exception e) {
            DialogHP.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void update() {
        
        try {
             if (!validate.checkNull(txttensp.getText())) {
                sb.append("Vui lòng nhập tên sản phẩm \n");
            }
            if (!validate.checkNull(txtGianhap.getText())) {
               
                sb.append("Vui lòng nhập giá nhập \n");
            }
            if (!validate.checkNull(txtGiaban.getText())) {
           
                sb.append("Vui lòng nhập giá bán \n");
            }
            if (!validate.checkNull(txtSoluongton.getText())) {
           
                sb.append("Vui lòng nhập số lượng tồn \n");
            }
             if (!validate.checkNull(txtGiaban.getText())) {
           
                sb.append("Vui lòng nhập giá bán \n");
            } if (!validate.checkSo(txtGiaban.getText())) {
           
                sb.append("Giá bán phải là số \n");
            }
             if (!validate.checkSo(txtGianhap.getText())) {
           
                sb.append("Giá nhập phải là số \n");
            }
              if (!validate.checkSoint(txtSoluongton.getText())) {
           
                sb.append("Số lượng tồn phải là số nguyên dương \n");
            }
            if (sb.toString().isBlank()) {
                System.out.println("donene");
                Sanpham_1 model = getModel();

                SanphamDao.update(model);
                this.load();
                this.clear();
                DialogHP.alert(this, "Cập nhật thành công!");
            } else {
                JOptionPane.showMessageDialog(this, sb.toString());
                sb.setLength(0);
                return;
               
            }
        } catch (Exception e) {
            DialogHP.alert(this, "Cập nhật thất bại!");
            e.printStackTrace();
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

        jLabel1 = new javax.swing.JLabel();
        tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblhinh = new javax.swing.JLabel();
        txttensp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbxSize = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtGianhap = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtGiaban = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSoluongton = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbxLoaisp = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMota = new javax.swing.JTextArea();
        btnInsert = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        Lblmasp = new javax.swing.JLabel();
        themloaisp = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtmaloaisp = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtFind = new javax.swing.JTextField();
        cbxsearch = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGridView = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 255));
        jLabel1.setText("Quản lý sản phẩm");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setText("Tên sản phẩm");

        jPanel3.setPreferredSize(new java.awt.Dimension(150, 150));

        lblhinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblhinhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblhinh, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblhinh, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel4.setText("Size");

        cbxSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S", "M", "L", "XL" }));
        cbxSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSizeActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel5.setText("Giá nhập");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel6.setText("Giá bán");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel7.setText("Số lượng tồn");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel8.setText("Loại sản phẩm");

        cbxLoaisp.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxLoaispItemStateChanged(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel9.setText("Mô tả");

        txtMota.setColumns(20);
        txtMota.setRows(5);
        jScrollPane1.setViewportView(txtMota);

        btnInsert.setText("Thêm");
        btnInsert.setPreferredSize(new java.awt.Dimension(60, 23));
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnDelete.setText("Xóa");
        btnDelete.setMinimumSize(new java.awt.Dimension(60, 23));
        btnDelete.setPreferredSize(new java.awt.Dimension(60, 23));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnNew.setText("Mới");
        btnNew.setPreferredSize(new java.awt.Dimension(60, 23));
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnUpdate.setText("Sửa");
        btnUpdate.setPreferredSize(new java.awt.Dimension(60, 23));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnFirst.setText("|<");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPrev.setText("<<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnNext.setText(">>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setText(">|");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        Lblmasp.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        Lblmasp.setText("ID sản phẩm");

        themloaisp.setText("Thêm loại sản phẩm");
        themloaisp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themloaispActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setText("Mã loại sản phẩm");

        txtmaloaisp.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtmaloaisp.setText("1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFirst)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPrev)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNext)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLast)
                .addGap(39, 39, 39))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(jLabel8)
                                .addGap(26, 26, 26)
                                .addComponent(cbxLoaisp, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(themloaisp))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)
                                .addGap(164, 164, 164)
                                .addComponent(txtmaloaisp, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))
                                        .addGap(34, 34, 34))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(41, 41, 41)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGianhap)
                                    .addComponent(cbxSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txttensp)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1)
                                    .addComponent(txtGiaban)
                                    .addComponent(txtSoluongton))))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Lblmasp)
                        .addGap(53, 53, 53))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Lblmasp))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cbxLoaisp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(themloaisp))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtmaloaisp))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txttensp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(cbxSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 41, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtGianhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGiaban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoluongton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFirst)
                    .addComponent(btnLast)
                    .addComponent(btnNext)
                    .addComponent(btnPrev))
                .addContainerGap())
        );

        tabs.addTab("Cập nhật", jPanel1);

        txtFind.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFindFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFindFocusLost(evt);
            }
        });
        txtFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFindActionPerformed(evt);
            }
        });
        txtFind.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFindKeyReleased(evt);
            }
        });

        cbxsearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxsearch.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxsearchItemStateChanged(evt);
            }
        });
        cbxsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxsearchActionPerformed(evt);
            }
        });

        tblGridView.setModel(new javax.swing.table.DefaultTableModel(
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
        tblGridView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGridViewMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblGridView);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(cbxsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs.addTab("Danh sách", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabs)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(252, 252, 252)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tabs))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxSizeActionPerformed

    private void lblhinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblhinhMouseClicked
        selectImage();
    }//GEN-LAST:event_lblhinhMouseClicked

    private void themloaispActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themloaispActionPerformed
        try {
            String sc = JOptionPane.showInputDialog("Nhập tên Loại sản phẩm mới");
            LoaiSanphamDAO.insert(sc);
            fillcbsp();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_themloaispActionPerformed

    private void cbxLoaispItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxLoaispItemStateChanged
        setidloaisp();
    }//GEN-LAST:event_cbxLoaispItemStateChanged

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        try {
            insert();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
//           
            update();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        clear();
    }//GEN-LAST:event_btnNewActionPerformed

    private void tblGridViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGridViewMouseClicked
        try {
            if (evt.getClickCount() == 1) {
                this.index = tblGridView.rowAtPoint(evt.getPoint());
                if (this.index >= 0) {
                    this.edit();
                    tabs.setSelectedIndex(0);
                }
                btnInsert.setEnabled(false);
                settenloaisp();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblGridViewMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            delete();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        this.index = 0;
        this.edit();
        settenloaisp();
        
        
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        this.index--;
        this.edit();
        settenloaisp();
       
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        this.index++;
        this.edit();
       settenloaisp();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        this.index = tblGridView.getRowCount() - 1;
        this.edit();
        settenloaisp();
    }//GEN-LAST:event_btnLastActionPerformed

    private void txtFindFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFindFocusGained
        if (txtFind.getText().equals(" Tìm theo tên, mã sản phẩm")) {
            txtFind.setText("");
        }
    }//GEN-LAST:event_txtFindFocusGained

    private void txtFindFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFindFocusLost
        if (txtFind.getText().equals("")) {
            txtFind.setText(" Tìm theo tên, mã sản phẩm");
        }
    }//GEN-LAST:event_txtFindFocusLost

    private void txtFindKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindKeyReleased
        search();
    }//GEN-LAST:event_txtFindKeyReleased

    private void txtFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFindActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFindActionPerformed

    private void cbxsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxsearchActionPerformed

    }//GEN-LAST:event_cbxsearchActionPerformed

    private void cbxsearchItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxsearchItemStateChanged
        findbang();

    }//GEN-LAST:event_cbxsearchItemStateChanged

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
            java.util.logging.Logger.getLogger(QLSanphamJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLSanphamJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLSanphamJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLSanphamJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLSanphamJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lblmasp;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbxLoaisp;
    private javax.swing.JComboBox<String> cbxSize;
    private javax.swing.JComboBox<String> cbxsearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblhinh;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblGridView;
    private javax.swing.JButton themloaisp;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtGiaban;
    private javax.swing.JTextField txtGianhap;
    private javax.swing.JTextArea txtMota;
    private javax.swing.JTextField txtSoluongton;
    private javax.swing.JLabel txtmaloaisp;
    private javax.swing.JTextField txttensp;
    // End of variables declaration//GEN-END:variables

}
