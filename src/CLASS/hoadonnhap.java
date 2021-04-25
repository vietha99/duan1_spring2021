/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASS;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class hoadonnhap {
    private  int idhoadonnhap;
    private Date ngaytao;
    private int idnhanvien;
    private float tongtien;

    public float getTongtien() {
        return tongtien;
    }

    public void setTongtien(float tongtien) {
        this.tongtien = tongtien;
    }

    public hoadonnhap(int idhoadonnhap, Date ngaytao, int idnhanvien) {
        this.idhoadonnhap = idhoadonnhap;
        this.ngaytao = ngaytao;
        this.idnhanvien = idnhanvien;
    }

    public hoadonnhap() {
        
    }

    public int getIdhoadonnhap() {
        return idhoadonnhap;
    }

    public void setIdhoadonnhap(int idhoadonnhap) {
        this.idhoadonnhap = idhoadonnhap;
    }

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }

    public int getIdnhanvien() {
        return idnhanvien;
    }

    public void setIdnhanvien(int idnhanvien) {
        this.idnhanvien = idnhanvien;
    }
    
    
    
}
