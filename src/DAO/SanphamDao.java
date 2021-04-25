/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import helper.JDBCHP;
import CLASS.Loaisanpham;
import CLASS.Nhanvien_1;
import CLASS.Sanpham_1;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class SanphamDao {

    public static void insert(Sanpham_1 model) {
        String sql = "INSERT INTO SANPHAM(TENSP,HINHANH,GIANHAP,GIABAN,SIZE,SOLUONGTON,MOTA,IDLOAISP) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";

        JDBCHP.executeUpdate(sql, model.getTensp(), model.getHinhanh(), model.getGianhap(), model.getGiaban(), model.getSize(), model.getSoluongton(), model.getMota(), model.getIdloaisp());
    }

    public static void update(Sanpham_1 model) {
        String sql = "UPDATE SANPHAM SET  TENSP=?, HINHANH=?, GIANHAP=?, GIABAN=?, SIZE=?, SOLUONGTON=?, MOTA= ?,IDLOAISP=? WHERE IDSANPHAM=?";
        JDBCHP.executeUpdate(sql,
                model.getTensp(),
                model.getHinhanh(),
                model.getGianhap(),
                model.getGiaban(),
                model.getSize(),
                model.getSoluongton(),
                model.getMota(),
                model.getIdloaisp(),
                model.getIDsanpham());

    }

    public static void delete(String MaSP) {
        String sql = "DELETE FROM SANPHAM WHERE IDSANPHAM=?";
        JDBCHP.executeUpdate(sql, MaSP);
    }

    public static List<Sanpham_1> select() {
        String sql = "SELECT * FROM SANPHAM";
        return select(sql);
    }
  

    public List<Sanpham_1> selectmacd() {
        String sql = "SELECT IDLOAISP FROM SanPham";
        return select(sql);
    }

    public static Sanpham_1 findById(String manv) {
        String sql = "SELECT * FROM SANPHAM WHERE IDSANPHAM=?";
        List<Sanpham_1> list = select(sql, manv);
        return list.size() > 0 ? list.get(0) : null;
    }
     public static List<Sanpham_1> findbang(String MaSP) {
        String sql = "select SANPHAM.IDSANPHAM,SANPHAM.TENSP,SANPHAM.HINHANH,SANPHAM.GIANHAP,SANPHAM.GIABAN,SANPHAM.SIZE,SANPHAM.SOLUONGTON,SANPHAM.MOTA,LOAISP.IDLOAISP\n" +
"from LOAISP join SANPHAM on SANPHAM.IDLOAISP=LOAISP.IDLOAISP  where LOAISP.TENLOAISP = ?";
        return select(sql,MaSP);
    }

    private static List<Sanpham_1> select(String sql, Object... args) {
        List<Sanpham_1> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JDBCHP.executeQuery(sql, args);
                while (rs.next()) {
                    Sanpham_1 model = readFromResultSet(rs);
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

    private static Sanpham_1 readFromResultSet(ResultSet rs) throws SQLException {
        Sanpham_1 model = new Sanpham_1();
        model.setIDsanpham(rs.getString("IDSANPHAM"));
        model.setTensp(rs.getString("TENSP"));
        model.setGiaban(rs.getDouble("GIABAN"));
        model.setGianhap(rs.getDouble("GIANHAP"));
        model.setHinhanh(rs.getString("HINHANH"));
        model.setIdloaisp(rs.getInt("IDLOAISP"));
        model.setSoluongton(rs.getInt("SOLUONGTON"));
        model.setMota(rs.getString("MOTA"));
        model.setSize(rs.getString("SIZE"));
        return model;
    }

    public static List<Sanpham_1> find(String masp, String tensp) {
        List<Sanpham_1> list = new ArrayList<>();
        String sql = "SELECT * FROM SANPHAM WHERE IDSANPHAM LIKE N'%" + masp + "%' OR TENSP LIKE N'%" + tensp + "%'";
        try {
            ResultSet rs = null;
            try {
                rs = JDBCHP.find(sql);
                while (rs.next()) {
                    Sanpham_1 model = readFromResultSet(rs);
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
 
}
