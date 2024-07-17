/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class TaiKhoan {

    private String TaiKhoan;
    private String MatKhau;
    private int MaNhanVien;
    private String email;
    private String soDienThoai;
    private Date NgayTao;
    private NhanVien nhanVien;

    public TaiKhoan() {
    }

    public TaiKhoan(String TaiKhoan, String MatKhau, int MaNhanVien, String email, String soDienThoai, Date NgayTao) {
        this.TaiKhoan = TaiKhoan;
        this.MatKhau = MatKhau;
        this.MaNhanVien = MaNhanVien;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.NgayTao = NgayTao;
    }

    public String getTaiKhoan() {
        return TaiKhoan;
    }

    public void setTaiKhoan(String TaiKhoan) {
        this.TaiKhoan = TaiKhoan;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public int getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(int MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    @Override
    public String toString() {
        return "TaiKhoan{" + "TaiKhoan=" + TaiKhoan + ", MatKhau=" + MatKhau + ", MaNhanVien=" + MaNhanVien + ", email=" + email + ", soDienThoai=" + soDienThoai + ", NgayTao=" + NgayTao + ", nhanVien=" + nhanVien + '}';
    }

    public TaiKhoan(String TaiKhoan, String MatKhau, int MaNhanVien, String email, String soDienThoai, Date NgayTao, NhanVien nhanVien) {
        this.TaiKhoan = TaiKhoan;
        this.MatKhau = MatKhau;
        this.MaNhanVien = MaNhanVien;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.NgayTao = NgayTao;
        this.nhanVien = nhanVien;
    }



}
