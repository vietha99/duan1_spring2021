/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASS;

/**
 *
 * @author ADMIN
 */
public class Sanpham_1 {
    public String Tensp;
    public String Hinhanh;
    public double Gianhap;

    @Override
    public String toString() {
        return "Sanpham{" + "Tensp=" + Tensp + ", Hinhanh=" + Hinhanh + ", Gianhap=" + Gianhap + ", Giaban=" + Giaban + ", Size=" + Size + ", Soluongton=" + Soluongton + ", IDsanpham=" + IDsanpham + ", Mota=" + Mota + ", Idloaisp=" + Idloaisp + '}';
    }
    public double Giaban;
    public String Size;
    public int Soluongton;
    public String IDsanpham;

     public String Mota;
    public int Idloaisp;

    public Sanpham_1() {
    }

    public Sanpham_1(String Tensp, String Hinhanh, double Gianhap, double Giaban, String Size, int Soluongton, String IDsanpham, String Mota, int Idloaisp) {
        this.Tensp = Tensp;
        this.Hinhanh = Hinhanh;
        this.Gianhap = Gianhap;
        this.Giaban = Giaban;
        this.Size = Size;
        this.Soluongton = Soluongton;
        this.IDsanpham = IDsanpham;
        this.Mota = Mota;
        this.Idloaisp = Idloaisp;
    }

    public String getTensp() {
        return Tensp;
    }

    public void setTensp(String Tensp) {
        this.Tensp = Tensp;
    }

    public String getHinhanh() {
        return Hinhanh;
    }

    public void setHinhanh(String Hinhanh) {
        this.Hinhanh = Hinhanh;
    }

    public double getGianhap() {
        return Gianhap;
    }

    public void setGianhap(double Gianhap) {
        this.Gianhap = Gianhap;
    }

    public double getGiaban() {
        return Giaban;
    }

    public void setGiaban(double Giaban) {
        this.Giaban = Giaban;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String Size) {
        this.Size = Size;
    }

    public int getSoluongton() {
        return Soluongton;
    }

    public void setSoluongton(int Soluongton) {
        this.Soluongton = Soluongton;
    }

    public String getIDsanpham() {
        return IDsanpham;
    }

    public void setIDsanpham(String IDsanpham) {
        this.IDsanpham = IDsanpham;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String Mota) {
        this.Mota = Mota;
    }

    public int getIdloaisp() {
        return Idloaisp;
    }

    public void setIdloaisp(int Idloaisp) {
        this.Idloaisp = Idloaisp;
    }

 
}
