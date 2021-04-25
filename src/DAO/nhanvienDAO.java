/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import CLASS.Nhanvien_1;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import helper.JDBCHP;
import java.util.List;
import CLASS.nhanvien;

/**
 *    private int maNV;
    private float luong;
    private String tenNV;
    private Date ngaysinh;
    private String diachi;
    private String sdt;
    private String email;
    private boolean gioitinh;
    private String matkhau;
    private boolean chucvu = false;
 * @author diepd
 */
public class nhanvienDAO {
//       public void insert(nhanvien nv) {
//        String sql = "INSERT INTO NhanVien (HOTEN,NGAYSINH,DIACHI,SDT,EMAIL,MATKHAU,IDCHUCVU) VALUES (?, ?, ?, ?)";
//        JDBCHP.executeUpdate(sql, nv.getMaNV(), nv.getMatKhau(), nv.getHoTen(), nv.getVaiTro());
//    }
//
//    public void update(nhanvien nv) {
//        String sql = "UPDATE NhanVien SET MatKhau=? WHERE IDNHANVIEN=?";
//        JDBCHP.executeUpdate(sql, nv.getMatKhau(), nv.getHoTen(), nv.getVaiTro(), nv.getMaNV());
//
//    }
    public void delete(String MaNV) {
        String sql = "DELETE FROM NhanVien WHERE IDNHANVIEN=?";
        JDBCHP.executeUpdate(sql, MaNV);
    }

    public List<nhanvien> select() {
        String sql = "SELECT * FROM NhanVien";
        return (List<nhanvien>) select(sql);
    }

    public nhanvien findById(String manv) {
        String sql = "SELECT * FROM NHANVIEN WHERE HOTEN = ?";
        List<nhanvien> list = (List<nhanvien>) select(sql, manv);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<nhanvien> select(String sql, Object... args) {
        List<nhanvien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JDBCHP.executeQuery(sql, args);
                while (rs.next()) {
                    nhanvien nv = readFromResultSet(rs);
                    list.add(nv);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    private nhanvien readFromResultSet(ResultSet rs) throws SQLException {
        nhanvien nv = new nhanvien();
        nv.setIdnhanvien(rs.getInt("IDNHANVIEN"));
        nv.setTenNV(rs.getString("HOTEN"));
        nv.setGioitinh(rs.getBoolean("GIOITINH"));
        nv.setHinhanh(rs.getString("HINHANH"));
        nv.setNgaysinh(rs.getDate("NGAYSINH"));
        nv.setDiachi(rs.getString("DIACHI"));
        nv.setSdt(rs.getString("SDT"));
        nv.setEmail(rs.getString("EMAIL"));
        nv.setMatkhau(rs.getString("MATKHAU"));
        nv.setIdchucvu(rs.getInt("IDCHUCVU"));
        return nv;
    }






}
