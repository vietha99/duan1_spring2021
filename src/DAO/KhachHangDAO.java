/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import CLASS.khachhang;
import helper.JDBCHP;
import java.sql.ResultSet;

/**
 *
 * @author NiQuang
 */
import java.sql.SQLException;import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author NiQuang
 */
public class KhachHangDAO {
    public void insert(khachhang model){
        String sql = "INSERT INTO KHACHHANG(TENKH,SDT) VALUES(?,?)";
        JDBCHP.executeUpdate(sql, model.getHotenkhach(), model.getSdt());
    }
    
    public void update(khachhang model){
        String sql = "UPDATE KHACHHANG SET TENKH = ? , SDT = ? WHERE IDKHACHHANG = ?";
        JDBCHP.executeUpdate(sql,  model.getHotenkhach(), model.getSdt(), model.getIdkhachhang());
    }
    
    public void delete(int idKhachHang){
        String sql ="DELETE FROM KHACHHANG WHERE IDKHACHHANG = ?";
        JDBCHP.executeUpdate(sql, idKhachHang);
    }
    
    public List<khachhang> select(){
        String sql = "SELECT * FROM KHACHHANG";
        return select(sql);
    }
    
    
    
    private List<khachhang> select(String sql, Object... args){
        List<khachhang> list = new ArrayList<>();
        try{
            ResultSet rs = null;
            try{
                rs = JDBCHP.executeQuery(sql, args);
                while(rs.next()){
                    khachhang model = readFromRs(rs);
                    list.add(model);
                }
            }finally{
                rs.getStatement().getConnection().close();
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return list;
    }
    
    public List<khachhang> findByName(String name){
        List<khachhang> list = select();
        List<khachhang> list2 = new ArrayList<>();
        for (khachhang kh : list) {
            if((kh.getHotenkhach().toLowerCase()).contains(name.toLowerCase())){
                list2.add(kh);
            }
        }
        return list2;
    }
    
    private khachhang readFromRs(ResultSet rs) throws SQLException{
        khachhang model = new khachhang();
        model.setIdkhachhang(rs.getInt("IDKHACHHANG"));
        model.setHotenkhach(rs.getString("TenKH"));
        model.setSdt(rs.getString("sdt"));
        return model;
    }
}
