/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author Hùng Nguyễn
 */
public class DotGiamGia {
   private int maDotGiamGia;
   private String tenDotGiamGia;
   private int PTGGia;
   private String tenSP;
   private Date ngayBD;
   private Date ngayKT;
   private boolean trangThai;
   private String moTa;

    public DotGiamGia() {
    }

    public DotGiamGia(int maDotGiamGia, String tenDotGiamGia, int PTGGia, String tenSP, Date ngayBD, Date ngayKT, Boolean trangThai, String moTa) {
        this.maDotGiamGia = maDotGiamGia;
        this.tenDotGiamGia = tenDotGiamGia;
        this.PTGGia = PTGGia;
        this.tenSP = tenSP;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.trangThai = trangThai;
        this.moTa = moTa;
    }
    public DotGiamGia(String tenDotGiamGia, int PTGGia, String tenSP, Date ngayBD, Date ngayKT, boolean trangThai, String moTa) {
        this.tenDotGiamGia = tenDotGiamGia;
        this.PTGGia = PTGGia;
        this.tenSP = tenSP;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.trangThai = trangThai;
        this.moTa = moTa;
    }
   
   

    public int getMaDotGiamGia() {
        return maDotGiamGia;
    }

    public void setMaDotGiamGia(int maDotGiamGia) {
        this.maDotGiamGia = maDotGiamGia;
    }

    public String getTenDotGiamGia() {
        return tenDotGiamGia;
    }

    public void setTenDotGiamGia(String tenDotGiamGia) {
        this.tenDotGiamGia = tenDotGiamGia;
    }

    public int getPTGGia() {
        return PTGGia;
    }

    public void setPTGGia(int PTGGia) {
        this.PTGGia = PTGGia;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public Date getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(Date ngayBD) {
        this.ngayBD = ngayBD;
    }

    public Date getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(Date ngayKT) {
        this.ngayKT = ngayKT;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
   
   
    
}
