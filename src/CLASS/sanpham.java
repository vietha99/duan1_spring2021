/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASS;

/**
 *IDSanPham
TenSP
LoaiSP
GiaBan
Size
SoLuongTon
MoTa

 * @author diepd
 */
public class sanpham {
    private int maSP;
    private String tensp;
    private float giaban;
    private float gianhap;
    private String size;
    private int soluongton;
    private String mota;
    private int idloaisp;
    private int a;

    public sanpham(int maSP, String tensp, float giaban, float gianhap, String size, int soluongton, String mota, int idloaisp) {
        this.maSP = maSP;
        this.tensp = tensp;
        this.giaban = giaban;
        this.gianhap = gianhap;
        this.size = size;
        this.soluongton = soluongton;
        this.mota = mota;
        this.idloaisp = idloaisp;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public sanpham() {
        
    }

    public float getGianhap() {
        return gianhap;
    }

    public void setGianhap(float gianhap) {
        this.gianhap = gianhap;
    }

    public int getIdloaisp() {
        return idloaisp;
    }

    public void setIdloaisp(int idloaisp) {
        this.idloaisp = idloaisp;
    }


    public sanpham(int maSP, String tensp, float giaban) {
        this.maSP = maSP;
        this.tensp = tensp;
        this.giaban = giaban;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }



    public float getGiaban() {
        return giaban;
    }

    public void setGiaban(float giaban) {
        this.giaban = giaban;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getSoluongton() {
        return soluongton;
    }

    public void setSoluongton(int soluongton) {
        this.soluongton = soluongton;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
    
    
}
