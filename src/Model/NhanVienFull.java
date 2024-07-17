/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class NhanVienFull {
    private ChucVu cv;
    private NhanVien nv;
    private TaiKhoan tk;

    public NhanVienFull() {
    }

    public NhanVienFull(ChucVu cv, NhanVien nv, TaiKhoan tk) {
        this.cv = cv;
        this.nv = nv;
        this.tk = tk;
    }

    public ChucVu getCv() {
        return cv;
    }

    public void setCv(ChucVu cv) {
        this.cv = cv;
    }

    public NhanVien getNv() {
        return nv;
    }

    public void setNv(NhanVien nv) {
        this.nv = nv;
    }

    public TaiKhoan getTk() {
        return tk;
    }

    public void setTk(TaiKhoan tk) {
        this.tk = tk;
    }

    @Override
    public String toString() {
        return "NhanVienFull{" + "cv=" + cv + ", nv=" + nv + ", tk=" + tk + '}';
    }
    
}
