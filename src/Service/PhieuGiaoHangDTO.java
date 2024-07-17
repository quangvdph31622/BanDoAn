/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author 84904
 */
public class PhieuGiaoHangDTO {
    private int MaKhachHang;
    private int MaNhanVien;
    private String TrangThai;

    public PhieuGiaoHangDTO() {
    }

    public PhieuGiaoHangDTO(int MaKhachHang, int MaNhanVien, String TrangThai) {
        this.MaKhachHang = MaKhachHang;
        this.MaNhanVien = MaNhanVien;
        this.TrangThai = TrangThai;
    }

    public int getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(int MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
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
        return "PhieuGiaoHangDTO{" + "MaKhachHang=" + MaKhachHang + ", MaNhanVien=" + MaNhanVien + ", TrangThai=" + TrangThai + '}';
    }

   

    
}
