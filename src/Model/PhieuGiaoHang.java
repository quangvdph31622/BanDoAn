/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author 84904
 */
public class PhieuGiaoHang {
    private int MaPhieuGiao;
    private String TenKH;
    private int MaNhanVien;
    private int MaNhanVien1;
    private int MaSanPham;
    private int SoLuong;
    private String DiaChiGiaoHang;
    private Date GiaoDuKien;
    private Date GiaoThucTe;
    private String TrangThai;
    private int KhachHangXacNhan;
    private String GhiChu;
    private BigDecimal TongTien;
    private BigDecimal TienKhachDua;
    private BigDecimal PhiVanChuyen;
    public PhieuGiaoHang() {
    }

    public PhieuGiaoHang(int MaPhieuGiao, String TenKH, int MaNhanVien, int MaNhanVien1, int MaSanPham, int SoLuong, String DiaChiGiaoHang, Date GiaoDuKien, Date GiaoThucTe, String TrangThai, int KhachHangXacNhan, String GhiChu, BigDecimal TongTien, BigDecimal TienKhachDua, BigDecimal PhiVanChuyen) {
        this.MaPhieuGiao = MaPhieuGiao;
        this.TenKH = TenKH;
        this.MaNhanVien = MaNhanVien;
        this.MaNhanVien1 = MaNhanVien1;
        this.MaSanPham = MaSanPham;
        this.SoLuong = SoLuong;
        this.DiaChiGiaoHang = DiaChiGiaoHang;
        this.GiaoDuKien = GiaoDuKien;
        this.GiaoThucTe = GiaoThucTe;
        this.TrangThai = TrangThai;
        this.KhachHangXacNhan = KhachHangXacNhan;
        this.GhiChu = GhiChu;
        this.TongTien = TongTien;
        this.TienKhachDua = TienKhachDua;
        this.PhiVanChuyen = PhiVanChuyen;
    }

    public int getMaPhieuGiao() {
        return MaPhieuGiao;
    }

    public void setMaPhieuGiao(int MaPhieuGiao) {
        this.MaPhieuGiao = MaPhieuGiao;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public int getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(int MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public int getMaNhanVien1() {
        return MaNhanVien1;
    }

    public void setMaNhanVien1(int MaNhanVien1) {
        this.MaNhanVien1 = MaNhanVien1;
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

    public String getDiaChiGiaoHang() {
        return DiaChiGiaoHang;
    }

    public void setDiaChiGiaoHang(String DiaChiGiaoHang) {
        this.DiaChiGiaoHang = DiaChiGiaoHang;
    }

    public Date getGiaoDuKien() {
        return GiaoDuKien;
    }

    public void setGiaoDuKien(Date GiaoDuKien) {
        this.GiaoDuKien = GiaoDuKien;
    }

    public Date getGiaoThucTe() {
        return GiaoThucTe;
    }

    public void setGiaoThucTe(Date GiaoThucTe) {
        this.GiaoThucTe = GiaoThucTe;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public int getKhachHangXacNhan() {
        return KhachHangXacNhan;
    }

    public void setKhachHangXacNhan(int KhachHangXacNhan) {
        this.KhachHangXacNhan = KhachHangXacNhan;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public BigDecimal getTongTien() {
        return TongTien;
    }

    public void setTongTien(BigDecimal TongTien) {
        this.TongTien = TongTien;
    }

    public BigDecimal getTienKhachDua() {
        return TienKhachDua;
    }

    public void setTienKhachDua(BigDecimal TienKhachDua) {
        this.TienKhachDua = TienKhachDua;
    }

    public BigDecimal getPhiVanChuyen() {
        return PhiVanChuyen;
    }

    public void setPhiVanChuyen(BigDecimal PhiVanChuyen) {
        this.PhiVanChuyen = PhiVanChuyen;
    }

    @Override
    public String toString() {
        return "PhieuGiaoHang{" + "MaPhieuGiao=" + MaPhieuGiao + ", TenKH=" + TenKH + ", MaNhanVien=" + MaNhanVien + ", MaNhanVien1=" + MaNhanVien1 + ", MaSanPham=" + MaSanPham + ", SoLuong=" + SoLuong + ", DiaChiGiaoHang=" + DiaChiGiaoHang + ", GiaoDuKien=" + GiaoDuKien + ", GiaoThucTe=" + GiaoThucTe + ", TrangThai=" + TrangThai + ", KhachHangXacNhan=" + KhachHangXacNhan + ", GhiChu=" + GhiChu + ", TongTien=" + TongTien + ", TienKhachDua=" + TienKhachDua + ", PhiVanChuyen=" + PhiVanChuyen + '}';
    }

    public void setgetMaNhanVien1(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
    
}
