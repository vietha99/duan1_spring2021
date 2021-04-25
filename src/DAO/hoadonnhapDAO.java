/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import CLASS.hoadonnhap;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class hoadonnhapDAO {

      public void insert(hoadonnhap model) {
        String sql = "INSERT INTO  HOADONNHAP(NGAYTAO,IDNHANVIEN,TONGTIEN) VALUES (?, ?,?)";

        helper.JDBCHP.executeUpdate(sql, model.getNgaytao(), model.getIdnhanvien(),model.getTongtien());
    }
      public void insertct(CLASS.hoadonnhapct model) {
        String sql = "INSERT INTO HOADONNHAPCT (IDHOADONNHAP,IDSANPHAM,SOLUONG) VALUES (?, ?,?)";

        helper.JDBCHP.executeUpdate(sql, model.getIdhoadonnhap(), model.getIdsanpham(),model.getSoluong());
    }
//    public void update(nguoiHoc model) {
//        String sql = "UPDATE NguoiHoc SET HoTen=?, NgaySinh=?, GioiTinh=?, DienThoai=?, Email=?, GhiChu=?, MaNV=? WHERE MaNH=?";
//        JDBCHP.executeUpdate(sql, model.getHoTen(), model.getNgaySinh(), model.getGioiTinh(), model.getDienThoai(), model.getEmail(), model.getGhiChu(), model.getMaNV(), model.getMaNH());
//    }
    public void updatesp(CLASS.sanpham sp){
        String sql = "UPDATE SANPHAM set SOLUONGTON = SOLUONGTON + ? where IDSANPHAM = ?";
        helper.JDBCHP.executeUpdate(sql,  sp.getA() , sp.getMaSP());
    }
    public void delete(String id) {
        String sql = "DELETE FROM HOADONNHAP WHERE MaNH=?";
        helper.JDBCHP.executeUpdate(sql, id);
    }

//    public List<hoadonnhap> select() {
//        String sql = "SELECT * FROM NguoiHoc";
//        return select(sql);
//    }

//    public List<nguoiHoc> selectByKeyword(String keyword) {
//        String sql = "SELECT * FROM NguoiHoc WHERE HoTen LIKE ?";
//        return select(sql, "%" + keyword + "%");
//    }
//
//    public List<nguoiHoc> selectByCourse(Integer makh) {
//        String sql = "SELECT * FROM NguoiHoc WHERE MaNH NOT IN (SELECT MaNH FROM HocVien WHERE MaKH=?)";
//        return select(sql, makh);
//    }
//
//    public nguoiHoc findById(String manh) {
//        String sql = "SELECT * FROM NguoiHoc WHERE MaNH=?";
//        List<nguoiHoc> list = select(sql, manh);
//        return list.size() > 0 ? list.get(0) : null;
//    }

    private List<hoadonnhap> select(String sql, Object... args) {
        List<hoadonnhap> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = helper.JDBCHP.executeQuery(sql, args);
                while (rs.next()) {
                    hoadonnhap model = readFromResultSet(rs);
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

    private hoadonnhap readFromResultSet(ResultSet rs) throws SQLException {
        hoadonnhap model = new hoadonnhap();
        model.setIdhoadonnhap( Integer.parseInt(rs.getString("IDHOADONNHAP")));
        model.setIdnhanvien(Integer.parseInt(rs.getString("IDNHANVIEN")));
        model.setNgaytao(rs.getDate("NGAYTAO"));

        return model;
    }
}
