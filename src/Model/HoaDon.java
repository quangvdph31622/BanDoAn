/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class HoaDon {
    private String maHD;
    private String tenKH;
    private String maSP;
    private String soLuong;
    private String ngayMua;
    private String tongTien;
    private String trangThai;

    public HoaDon() {
    }

    public HoaDon(String maHD, String tenKH, String maSP, String soLuong, String ngayMua, String tongTien, String trangThai) {
        this.maHD = maHD;
        this.tenKH = tenKH;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.ngayMua = ngayMua;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    public HoaDon(String maHD, String tenKH, String maSP, String soLuong) {
        this.maHD = maHD;
        this.tenKH = tenKH;
        this.maSP = maSP;
        this.soLuong = soLuong;
    }
    
    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public String getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(String ngayMua) {
        this.ngayMua = ngayMua;
    }

    public String getTongTien() {
        return tongTien;
    }

    public void setTongTien(String tongTien) {
        this.tongTien = tongTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
    
    
    
}
