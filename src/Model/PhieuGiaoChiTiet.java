/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author 84904
 */
public class PhieuGiaoChiTiet {
    private int MaPhieuGiaoHangChiTiet;//10
    private int MaSanPham;
    private int SoLuong;
    private int MaKhachHang;

    public PhieuGiaoChiTiet() {
    }

    public PhieuGiaoChiTiet(int MaPhieuGiaoHangChiTiet, int MaSanPham, int SoLuong, int MaKhachHang) {
        this.MaPhieuGiaoHangChiTiet = MaPhieuGiaoHangChiTiet;
        this.MaSanPham = MaSanPham;
        this.SoLuong = SoLuong;
        this.MaKhachHang = MaKhachHang;
    }

    public int getMaPhieuGiaoHangChiTiet() {
        return MaPhieuGiaoHangChiTiet;
    }

    public void setMaPhieuGiaoHangChiTiet(int MaPhieuGiaoHangChiTiet) {
        this.MaPhieuGiaoHangChiTiet = MaPhieuGiaoHangChiTiet;
    }

    public int getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(int MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(int MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    @Override
    public String toString() {
        return "PhieuGiaoChiTiet{" + "MaPhieuGiaoHangChiTiet=" + MaPhieuGiaoHangChiTiet + ", MaSanPham=" + MaSanPham + ", SoLuong=" + SoLuong + ", MaKhachHang=" + MaKhachHang + '}';
    }
    
}
