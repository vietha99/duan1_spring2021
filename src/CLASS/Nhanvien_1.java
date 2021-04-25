/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASS;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Nhanvien_1 {
    private String MaNV;
    private String hoten;
    private Date NgaySinh;
    private String hinh;
    private String diachi;
    private boolean Gioitinh;
    private String Email;
    private String SDT;
    private String matkhau;
    private int machucvu;
    private Double Luong;

    @Override
    public String toString() {
        return "Nhanvien{" + "MaNV=" + MaNV + ", hoten=" + hoten + ", NgaySinh=" + NgaySinh + ", hinh=" + hinh + ", diachi=" + diachi + ", Gioitinh=" + Gioitinh + ", Email=" + Email + ", SDT=" + SDT + ", matkhau=" + matkhau + ", machucvu=" + machucvu + ", Luong=" + Luong + '}';
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public boolean isGioitinh() {
        return Gioitinh;
    }

    public void setGioitinh(boolean Gioitinh) {
        this.Gioitinh = Gioitinh;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public int getMachucvu() {
        return machucvu;
    }

    public void setMachucvu(int machucvu) {
        this.machucvu = machucvu;
    }

    public Double getLuong() {
        return Luong;
    }

    public void setLuong(Double Luong) {
        this.Luong = Luong;
    }

    public Nhanvien_1() {
    }

    public Nhanvien_1(String MaNV, String hoten, Date NgaySinh, String hinh, String diachi, boolean Gioitinh, String Email, String SDT, String matkhau, int machucvu, Double Luong) {
        this.MaNV = MaNV;
        this.hoten = hoten;
        this.NgaySinh = NgaySinh;
        this.hinh = hinh;
        this.diachi = diachi;
        this.Gioitinh = Gioitinh;
        this.Email = Email;
        this.SDT = SDT;
        this.matkhau = matkhau;
        this.machucvu = machucvu;
        this.Luong = Luong;
    }


}