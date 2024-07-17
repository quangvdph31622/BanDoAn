/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author 84904
 */
public class KhachHangDTO {
    private int MaKhachHang;
    private String HoTen;
    private String DiaChi;
    private String DienThoai;

    public KhachHangDTO() {
    }

    public KhachHangDTO(int MaKhachHang, String HoTen, String DiaChi, String DienThoai) {
        this.MaKhachHang = MaKhachHang;
        this.HoTen = HoTen;
        this.DiaChi = DiaChi;
        this.DienThoai = DienThoai;
    }

    public int getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(int MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(String DienThoai) {
        this.DienThoai = DienThoai;
    }

    @Override
    public String toString() {
        return "KhachHangDTO{" + "MaKhachHang=" + MaKhachHang + ", HoTen=" + HoTen + ", DiaChi=" + DiaChi + ", DienThoai=" + DienThoai + '}';
    }
}
