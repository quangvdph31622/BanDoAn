/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


/**
 *
 * @author PTC
 */
public class KhachHang {
    private Integer MaKhachHang;
    private String HoTen;
    private String GioiTinh;
    private String NgaySinh;
    private String DiaChi;
    private String Email;
    private String SoDienThoai;
    private String LoaiKhachHang;


    public KhachHang() {
    }

    public KhachHang(Integer MaKhachHang, String HoTen, String GioiTinh, String NgaySinh, String DiaChi, String Email, String SoDienThoai, String LoaiKhachHang) {
        this.MaKhachHang = MaKhachHang;
        this.HoTen = HoTen;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.DiaChi = DiaChi;
        this.Email = Email;
        this.SoDienThoai = SoDienThoai;
        this.LoaiKhachHang = LoaiKhachHang;
    }

    

    public Integer getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(Integer MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public String getLoaiKhachHang() {
        return LoaiKhachHang;
    }

    public void setLoaiKhachHang(String LoaiKhachHang) {
        this.LoaiKhachHang = LoaiKhachHang;
    }
    
    
    public String LichSuMuaHang(){
        return "Xem";
    }
}