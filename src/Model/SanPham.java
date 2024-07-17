/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.math.BigDecimal;

/**
 *
 * @author nguyen dinh kien
 */
public class SanPham {
  private int ma;
  private String ten;
  private String tenLoai;
  private String  size;
  private float gia;
  private String moTa;
  private String trangThai;

    public SanPham() {
    }

    public SanPham(int ma, String ten, String tenLoai, String size, float gia, String moTa, String trangThai) {
        this.ma = ma;
        this.ten = ten;
        this.tenLoai = tenLoai;
        this.size = size;
        this.gia = gia;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
  

}
