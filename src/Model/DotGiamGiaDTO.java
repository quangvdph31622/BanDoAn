/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;



/**
 *
 * @author 84904
 */
public class DotGiamGiaDTO {
    private String TenDotGiamGia;
    private int PhanTramGiam;

    public DotGiamGiaDTO() {
    }

    public DotGiamGiaDTO(String TenDotGiamGia, int PhanTramGiam) {
        this.TenDotGiamGia = TenDotGiamGia;
        this.PhanTramGiam = PhanTramGiam;
    }

    public String getTenDotGiamGia() {
        return TenDotGiamGia;
    }

    public void setTenDotGiamGia(String TenDotGiamGia) {
        this.TenDotGiamGia = TenDotGiamGia;
    }

    public int getPhanTramGiam() {
        return PhanTramGiam;
    }

    public void setPhanTramGiam(int PhanTramGiam) {
        this.PhanTramGiam = PhanTramGiam;
    }

    @Override
    public String toString() {
        return "DotGiamGiaDTO{" + "TenDotGiamGia=" + TenDotGiamGia + ", PhanTramGiam=" + PhanTramGiam + '}';
    }
}
