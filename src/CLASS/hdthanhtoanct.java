/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASS;

/**
 *
 * @author Admin
 */
public class hdthanhtoanct {
    private int idhoadontt;
    private int idsanpham;
    private int soluong;

    public hdthanhtoanct(int idhoadontt, int idsanpham, int soluong) {
        this.idhoadontt = idhoadontt;
        this.idsanpham = idsanpham;
        this.soluong = soluong;
    }

    public hdthanhtoanct() {
    }

    public int getIdhoadontt() {
        return idhoadontt;
    }

    public void setIdhoadontt(int idhoadontt) {
        this.idhoadontt = idhoadontt;
    }

    public int getIdsanpham() {
        return idsanpham;
    }

    public void setIdsanpham(int idsanpham) {
        this.idsanpham = idsanpham;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
    
    
}
