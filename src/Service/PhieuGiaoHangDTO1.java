/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author 84904
 */
public class PhieuGiaoHangDTO1 {
    private int MaPhieuGiaoHang;
    private String TenKhachHang;
    private int MaNhanVien;
    private String TrangThai;

    public PhieuGiaoHangDTO1() {
    }

    public PhieuGiaoHangDTO1(int MaPhieuGiaoHang, String TenKhachHang, int MaNhanVien, String TrangThai) {
        this.MaPhieuGiaoHang = MaPhieuGiaoHang;
        this.TenKhachHang = TenKhachHang;
        this.MaNhanVien = MaNhanVien;
        this.TrangThai = TrangThai;
    }

    public int getMaPhieuGiaoHang() {
        return MaPhieuGiaoHang;
    }

    public void setMaPhieuGiaoHang(int MaPhieuGiaoHang) {
        this.MaPhieuGiaoHang = MaPhieuGiaoHang;
    }

    public String getTenKhachHang() {
        return TenKhachHang;
    }

    public void setTenKhachHang(String TenKhachHang) {
        this.TenKhachHang = TenKhachHang;
    }

    public int getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(int MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    @Override
    public String toString() {
        return "PhieuGiaoHangDTO1{" + "MaPhieuGiaoHang=" + MaPhieuGiaoHang + ", TenKhachHang=" + TenKhachHang + ", MaNhanVien=" + MaNhanVien + ", TrangThai=" + TrangThai + '}';
    }

    

    
}
