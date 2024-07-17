/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author hieu1
 */
public class PhieuGiamGia {
    private int MaPhieuGiamGia;
    private int MaDotGiamGia;
    private String TenDotGiamGia;
    private int SanPhamApDung;
    private int PhanTramGiam;
    private Date NgayBatDau;
    private Date NgayKetThuc;
    

    public PhieuGiamGia() {
    }

    public PhieuGiamGia(int MaPhieuGiamGia, int MaDotGiamGia, String TenDotGiamGia, int SanPhamApDung, int PhanTramGiam, Date NgayBatDau, Date NgayKetThuc) {
        this.MaPhieuGiamGia = MaPhieuGiamGia;
        this.MaDotGiamGia = MaDotGiamGia;
        this.TenDotGiamGia = TenDotGiamGia;
        this.SanPhamApDung = SanPhamApDung;
        this.PhanTramGiam = PhanTramGiam;
        this.NgayBatDau = NgayBatDau;
        this.NgayKetThuc = NgayKetThuc;
    }

    public PhieuGiamGia(int MaPhieuGiamGia, int MaDotGiamGia, int SanPhamApDung, int PhanTramGiam, Date NgayBatDau, Date NgayKetThuc) {
        this.MaPhieuGiamGia = MaPhieuGiamGia;
        this.MaDotGiamGia = MaDotGiamGia;
        this.SanPhamApDung = SanPhamApDung;
        this.PhanTramGiam = PhanTramGiam;
        this.NgayBatDau = NgayBatDau;
        this.NgayKetThuc = NgayKetThuc;
    }
    public PhieuGiamGia(int MaDotGiamGia, int SanPhamApDung, int PhanTramGiam, Date NgayBatDau, Date NgayKetThuc) {
        this.MaDotGiamGia = MaDotGiamGia;
        this.SanPhamApDung = SanPhamApDung;
        this.PhanTramGiam = PhanTramGiam;
        this.NgayBatDau = NgayBatDau;
        this.NgayKetThuc = NgayKetThuc;
    }

    public PhieuGiamGia(int madgg, boolean spad, int ptgg, LocalDate ngayBatDau, LocalDate ngayKetThuc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public PhieuGiamGia(int madgg, int spad, int ptgg, LocalDate ngayBatDau, LocalDate ngayKetThuc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public PhieuGiamGia(Integer maDotGiamGia, String tdgg, Integer spad, Integer ptGiam, String ngayBatDau, String ngayKetThuc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getMaPhieuGiamGia() {
        return MaPhieuGiamGia;
    }

    public void setMaPhieuGiamGia(int MaPhieuGiamGia) {
        this.MaPhieuGiamGia = MaPhieuGiamGia;
    }

    public int getMaDotGiamGia() {
        return MaDotGiamGia;
    }

    public void setMaDotGiamGia(int MaDotGiamGia) {
        this.MaDotGiamGia = MaDotGiamGia;
    }

    public int getSanPhamApDung() {
        return SanPhamApDung;
    }

    public String getTenDotGiamGia() {
        return TenDotGiamGia;
    }

    public void setTenDotGiamGia(String TenDotGiamGia) {
        this.TenDotGiamGia = TenDotGiamGia;
    }

    

    public void setSanPhamApDung(int SanPhamApDung) {
        this.SanPhamApDung = SanPhamApDung;
    }

    public int getPhanTramGiam() {
        return PhanTramGiam;
    }

    public void setPhanTramGiam(int PhanTramGiam) {
        this.PhanTramGiam = PhanTramGiam;
    }

    public Date getNgayBatDau() {
        return NgayBatDau;
    }

    public void setNgayBatDau(Date NgayBatDau) {
        this.NgayBatDau = NgayBatDau;
    }

    public Date getNgayKetThuc() {
        return NgayKetThuc;
    }

    public void setNgayKetThuc(Date NgayKetThuc) {
        this.NgayKetThuc = NgayKetThuc;
    }

    @Override
    public String toString() {
        return "PhieuGiamGia{" + "MaPhieuGiamGia=" + MaPhieuGiamGia + ", MaDotGiamGia=" + MaDotGiamGia + ", SanPhamApDung=" + SanPhamApDung + ", PhanTramGiam=" + PhanTramGiam + ", NgayBatDau=" + NgayBatDau + ", NgayKetThuc=" + NgayKetThuc + '}';
    }
    
    public Object[] toDataRow(){
        return new Object[]{this.MaPhieuGiamGia,this.MaDotGiamGia,this.SanPhamApDung,this.PhanTramGiam,this.NgayBatDau,this.NgayKetThuc};
    }
    
}
