/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import helper.JDBCHP;
import CLASS.Nhanvien_1;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class NhanvienDAO1 {

    public void insert(Nhanvien_1 model) {
        String sql = "INSERT INTO NHANVIEN(HOTEN, HINHANH, GIOITINH,NGAYSINH,DIACHI,SDT,EMAIL,MATKHAU,IDCHUCVU,LUONG) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int gt;
        if (model.isGioitinh()) {
            gt = 1;
        } else {
            gt = 0;
        }
        JDBCHP.executeUpdate(sql, model.getHoten(), model.getHinh(), gt, model.getNgaySinh(), model.getDiachi(), model.getSDT(), model.getEmail(), model.getMatkhau(), model.getMachucvu(),model.getLuong());
    }

    public void update(Nhanvien_1 model) {
        int gt;
        if (model.isGioitinh()) {
            gt = 1;
        } else {
            gt = 0;
        }
        String sql = "UPDATE NHANVIEN SET  HOTEN=?, HINHANH=?, GIOITINH=?, NGAYSINH=?, DIACHI=?, SDT=?, EMAIL= ?, MATKHAU=?, IDCHUCVU=?,LUONG=? WHERE IDNHANVIEN=?";
        JDBCHP.executeUpdate(sql,
                model.getHoten(),
                model.getHinh(),
                gt,
                model.getNgaySinh(),
                model.getDiachi(),
                model.getSDT(),
                model.getEmail(),
                model.getMatkhau(),
                model.getMachucvu(),
                model.getLuong(),
                model.getMaNV());
    }

    public void delete(String MaCD) {
        String sql = "DELETE FROM NHANVIEN WHERE IDNHANVIEN=?";
        JDBCHP.executeUpdate(sql, MaCD);
    }

    public List<Nhanvien_1> select() {
        String sql = "SELECT * FROM NHANVIEN";
        return select(sql);
    }

    public List<Nhanvien_1> selectmacd() {
        String sql = "SELECT IDNHANVIEN FROM NHANVIEN";
        return select(sql);
    }

    public Nhanvien_1 findById(String manv) {
        String sql = "SELECT * FROM NHANVIEN WHERE IDNHANVIEN=?";
        List<Nhanvien_1> list = select(sql, manv);
        return list.size() > 0 ? list.get(0) : null;
    }
public  List<Nhanvien_1> find(String manv,String tennv){
          List<Nhanvien_1> list = new ArrayList<>();
          String sql = "SELECT * FROM NHANVIEN WHERE HOTEN LIKE N'%" + manv + "%' OR IDNHANVIEN LIKE N'%" + tennv + "%'";
            try {
            ResultSet rs = null;
            try {
                rs = JDBCHP.find(sql);
                while (rs.next()) {
                    Nhanvien_1 model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
          
    
   


    private List<Nhanvien_1> select(String sql, Object... args) {
        List<Nhanvien_1> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JDBCHP.executeQuery(sql, args);
                while (rs.next()) {
                    Nhanvien_1 model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
    

    private Nhanvien_1 readFromResultSet(ResultSet rs) throws SQLException {
        Nhanvien_1 model = new Nhanvien_1();
        model.setMaNV(rs.getString("IDNHANVIEN"));
        model.setDiachi(rs.getString("DIACHI"));
        model.setHoten(rs.getString("HOTEN"));
        model.setHinh(rs.getString("HINHANH"));
        model.setNgaySinh(rs.getDate("NGAYSINH"));
        model.setSDT(rs.getString("SDT"));
        model.setMachucvu(rs.getInt("IDCHUCVU"));
        model.setMatkhau(rs.getString("MATKHAU"));
        model.setEmail(rs.getString("EMAIL"));
        model.setLuong(rs.getDouble("LUONG"));
        if (rs.getInt("gioitinh") == 1) {
            model.setGioitinh(true);
        } else {
            model.setGioitinh(false);
        }

        return model;
    }
}
