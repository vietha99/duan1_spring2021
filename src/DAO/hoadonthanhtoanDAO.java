/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import CLASS.hdthanhtoan;
import CLASS.hdthanhtoanct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author diepd
 */
public class hoadonthanhtoanDAO {
//    public void inserthd(hoadonthanhtoan hdtt){
//        String sql = "Set dateformat DMY INSERT INTO HOADONTT () "
//    }
        public void insert(hdthanhtoan model){
        String sql = "INSERT INTO HOADONTT(NGAYTAOHD,IDNHANVIEN,IDKHACHHANG,TONGTIEN)VALUES(?,?,?,?)";
        helper.JDBCHP.executeUpdate(sql, model.getNgaytao(), model.getIDNHANVIEN(), model.getIDkhach() ,model.getTONGTIEN());
    }
         public void insertHDCT(hdthanhtoanct hdct){
        String sql = "INSERT INTO HOADONTTCT(IDHOADONTT,IDSANPHAM,SOLUONG )VALUES(?,?,?)";
        helper.JDBCHP.executeUpdate(sql, hdct.getIdhoadontt(), hdct.getIdsanpham(), hdct.getSoluong());
    }
    public void updatesp(CLASS.sanpham sp){
        String sql = "UPDATE SANPHAM set SOLUONGTON = SOLUONGTON - ? where IDSANPHAM = ?";
        helper.JDBCHP.executeUpdate(sql,  sp.getA() , sp.getMaSP());
    }
//    
//    public void delete(int idKhachHang){
//        String sql ="DELETE FROM KHACHHANG WHERE IDKHACHHANG = ?";
//        JDBCHelper.executeUpdate(sql, idKhachHang);
//    }
    
//    public List<hdthanhtoan> select(){
//        String sql = "SELECT * FROM KHACHHANG";
//        return select(sql);
//    }
//    
    
    
//    private List<hdthanhtoan> select(String sql, Object... args){
//        List<hdthanhtoan> list = new ArrayList<>();
//        try{
//            ResultSet rs = null;
//            try{
//                rs = helper.JDBCHP.executeQuery(sql, args);
//                while(rs.next()){
//                    hdthanhtoan model = readFromRs(rs);
//                    list.add(model);
//                }
//            }finally{
//                rs.getStatement().getConnection().close();
//            }
//        }catch(SQLException e){
//            throw new RuntimeException(e);
//        }
//        return list;
//    }
//    
//    public List<KhachHan> findByName(String name){
//        List<KhachHang> list = select();
//        List<KhachHang> list2 = new ArrayList<>();
//        for (KhachHang kh : list) {
//            if(kh.getHoTen().contains(name)){
//                list2.add(kh);
//            }
//        }
//        return list2;
//    }
//    
//    private KhachHang readFromRs(ResultSet rs) throws SQLException{
//        KhachHang model = new KhachHang();
//        model.setIdKhachHang(rs.getInt("IDKHACHHANG"));
//        model.setHoTen(rs.getString("TenKH"));
//        model.setSdt(rs.getString("sdt"));
//        return model;
//    }
}
