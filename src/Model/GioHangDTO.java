/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


/**
 *
 * @author 84904
 */
public class GioHangDTO {
    private int MaSanPham;
    private String LoaiSanPham;
    private String TenSanPham;
    private String MoTa;
    private double Gia;
    private int SoLuong;
    private String Images;
    public GioHangDTO() {
    }

    public GioHangDTO(int MaSanPham, String LoaiSanPham, String TenSanPham, String MoTa, double Gia, int SoLuong, String Images) {
        this.MaSanPham = MaSanPham;
        this.LoaiSanPham = LoaiSanPham;
        this.TenSanPham = TenSanPham;
        this.MoTa = MoTa;
        this.Gia = Gia;
        this.SoLuong = SoLuong;
        this.Images = Images;
    }

    public int getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(int MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public String getLoaiSanPham() {
        return LoaiSanPham;
    }

    public void setLoaiSanPham(String LoaiSanPham) {
        this.LoaiSanPham = LoaiSanPham;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public double getGia() {
        return Gia;
    }

    public void setGia(double Gia) {
        this.Gia = Gia;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getImages() {
        return Images;
    }

    public void setImages(String Images) {
        this.Images = Images;
    }

    @Override
    public String toString() {
        return "SanPham{" + "MaSanPham=" + MaSanPham + ", LoaiSanPham=" + LoaiSanPham + ", TenSanPham=" + TenSanPham + ", MoTa=" + MoTa + ", Gia=" + Gia + ", SoLuong=" + SoLuong + ", Images=" + Images + '}';
    }
}
