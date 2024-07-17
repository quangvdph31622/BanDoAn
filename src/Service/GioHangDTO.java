/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author 84904
 */
public class GioHangDTO {
    private int MaSanPham;
    private String TenSanPham;
    private String TenLoai;
    private String Size;
    private String TrangThai;
    private float Gia;
    private String MoTa;
    private int SoLuong;
    public GioHangDTO() {
    }

    public GioHangDTO(int MaSanPham, String TenSanPham, String TenLoai, String Size, String TrangThai, float Gia, String MoTa, int SoLuong) {
        this.MaSanPham = MaSanPham;
        this.TenSanPham = TenSanPham;
        this.TenLoai = TenLoai;
        this.Size = Size;
        this.TrangThai = TrangThai;
        this.Gia = Gia;
        this.MoTa = MoTa;
        this.SoLuong = SoLuong;
    }

    public int getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(int MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }

    public String getTenLoai() {
        return TenLoai;
    }

    public void setTenLoai(String TenLoai) {
        this.TenLoai = TenLoai;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String Size) {
        this.Size = Size;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public float getGia() {
        return Gia;
    }

    public void setGia(float Gia) {
        this.Gia = Gia;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    @Override
    public String toString() {
        return "GioHangDTO{" + "MaSanPham=" + MaSanPham + ", TenSanPham=" + TenSanPham + ", TenLoai=" + TenLoai + ", Size=" + Size + ", TrangThai=" + TrangThai + ", Gia=" + Gia + ", MoTa=" + MoTa + ", SoLuong=" + SoLuong + '}';
    }

    public Object getSoLuong(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}
