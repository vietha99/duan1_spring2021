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
public class LoaiSanphamDAO {
     public static void insert(String model) {
        String sql = "INSERT INTO LOAISP(TENLOAISP) VALUES (?)";
        JDBCHP.executeUpdate(sql,model );
    }
    public List<Loaisanpham> select() {
        String sql = "SELECT * FROM LOAISP";
        return select(sql);
    }
    public static List<Loaisanpham> selectten() {
        String sql = "SELECT TENLOAISP FROM LOAISP";
        return select(sql);
    }
     private static List<Loaisanpham>  select(String sql, Object... args) {
        List<Loaisanpham> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JDBCHP.executeQuery(sql, args);
                while (rs.next()) {
                    Loaisanpham model = readFromResultSet(rs);
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
    

    private static Loaisanpham readFromResultSet(ResultSet rs) throws SQLException {
        Loaisanpham model = new Loaisanpham();
        model.setLoaisanpham(rs.getString("TenLOAISP"));
        return model;
    }
}

