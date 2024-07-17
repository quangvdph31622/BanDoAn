/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Objects;

/**
 *
 * @author Admin
 */
public class ChucVu {
    private String maCV;
    private String tenCV;
    private float luong;
    private int soGio;

    public ChucVu() {
    }

    public ChucVu(String maCV, String tenCV, float luong, int soGio) {
        this.maCV = maCV;
        this.tenCV = tenCV;
        this.luong = luong;
        this.soGio = soGio;
    }

    public String getMaCV() {
        return maCV;
    }

    public void setMaCV(String maCV) {
        this.maCV = maCV;
    }

    public String getTenCV() {
        return tenCV;
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
    }

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }

    public int getSoGio() {
        return soGio;
    }

    public void setSoGio(int soGio) {
        this.soGio = soGio;
    }

    @Override
    public String toString() {
        return tenCV;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ChucVu chucVu = (ChucVu) obj;
        return Objects.equals(tenCV, chucVu.tenCV);
    }
}
