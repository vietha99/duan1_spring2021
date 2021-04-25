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
public class Loaisanpham {
    public String loaisanpham;
    public int Maloaispa;

    public String getLoaisanpham() {
        return loaisanpham;
    }

    public void setLoaisanpham(String loaisanpham) {
        this.loaisanpham = loaisanpham;
    }

    public int getMaloaispa() {
        return Maloaispa;
    }

    public void setMaloaispa(int Maloaispa) {
        this.Maloaispa = Maloaispa;
    }

    public Loaisanpham() {
    }

    @Override
    public String toString() {
        return "Loaisanpham{" + "loaisanpham=" + loaisanpham + ", Maloaispa=" + Maloaispa + '}';
    }

    public Loaisanpham(String loaisanpham, int Maloaispa) {
        this.loaisanpham = loaisanpham;
        this.Maloaispa = Maloaispa;
    }
}
