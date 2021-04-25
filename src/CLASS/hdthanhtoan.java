/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASS;

import helper.DateHP;
import java.util.Date;

/**
 *HoTenKH	String
SDTKH	String
TenChiNhanh	String
HoTenNV	String
TenSP	String
LoaiSP	String
GiaBan	FLOAT
Size	String
SoLuongBan	INT
ThanhTien	FLOAT
NgayBan	DATETIME

 * @author diepd
 */
public class hdthanhtoan {
  private int IDHOADONTT;
  private Date ngaytao;
  private int IDNHANVIEN;
  private int IDkhach;
  private float TONGTIEN;

    public hdthanhtoan(int IDHOADONTT, Date ngaytao, int IDNHANVIEN, int IDkhach, float TONGTIEN) {
        this.IDHOADONTT = IDHOADONTT;
        this.ngaytao = ngaytao;
        this.IDNHANVIEN = IDNHANVIEN;
        this.IDkhach = IDkhach;
        this.TONGTIEN = TONGTIEN;
    }

    public float getTONGTIEN() {
        return TONGTIEN;
    }

    public void setTONGTIEN(float TONGTIEN) {
        this.TONGTIEN = TONGTIEN;
    }



    public hdthanhtoan() {
    }

    public int getIDHOADONTT() {
        return IDHOADONTT;
    }

    public void setIDHOADONTT(int IDHOADONTT) {
        this.IDHOADONTT = IDHOADONTT;
    }

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }

    public int getIDNHANVIEN() {
        return IDNHANVIEN;
    }

    public void setIDNHANVIEN(int IDNHANVIEN) {
        this.IDNHANVIEN = IDNHANVIEN;
    }

    public int getIDkhach() {
        return IDkhach;
    }

    public void setIDkhach(int IDkhach) {
        this.IDkhach = IDkhach;
    }




  
    
}
