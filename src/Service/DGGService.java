/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.DotGiamGia;
import Service.DBContext1;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hùng Nguyễn
 */
public class DGGService {

    Connection conn;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<DotGiamGia> getAll() {
        ArrayList<DotGiamGia> list = new ArrayList<>();
        String sql = "SELECT * FROM DotGiamGia";
        try {
            conn = DBContext1.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                DotGiamGia dgg = new DotGiamGia(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getDate(6),
                        rs.getBoolean(7),
                        rs.getString(8)
                );
                list.add(dgg);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public void add(DotGiamGia dgg) {
        String sql = "INSERT INTO DotGiamGia (TenDotGiamGia, PhanTramGiam, TenSanPham, NgayBatDau, NgayKetThuc, TrangThai, MoTa)\n"
                + "VALUES(?,?,?,?,?,?,?)";
        try {
            conn = new DBContext1().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setObject(1, dgg.getTenDotGiamGia());
            ps.setObject(2, dgg.getPTGGia());
            ps.setObject(3, dgg.getTenSP());
            ps.setObject(4, dgg.getNgayBD());
            ps.setObject(5, dgg.getNgayKT());
            ps.setObject(6, dgg.isTrangThai());
            ps.setObject(7, dgg.getMoTa());
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
        }
    }

    public void Update(DotGiamGia dgg) {
        String sql = "UPDATE DotGiamGia SET PhanTramGiam = ?, TenSanPham = ?, NgayBatDau = ?, NgayKetThuc = ?, TrangThai = ?, MoTa = ? where TenDotGiamGia = ?";
        try {
            conn = new DBContext1().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setObject(1, dgg.getPTGGia());
            ps.setObject(2, dgg.getTenSP());
            ps.setObject(3, dgg.getNgayBD());
            ps.setObject(4, dgg.getNgayKT());
            ps.setObject(5, dgg.isTrangThai());
            ps.setObject(6, dgg.getMoTa());
            ps.setObject(7, dgg.getTenDotGiamGia());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void Delete(String ten){
        String sql = "DELETE FROM DotGiamGia WHERE TenDotGiamGia = ?";
        try {
            conn = new DBContext1().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, ten);
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
        }
    }
    
    public List<DotGiamGia> Search(String tenSearch){
        String sql = "SELECT * FROM DotGiamGia WHERE TenDotGiamGia LIKE ?";
        List<DotGiamGia> listSearch = new ArrayList<>();
        try {
            conn = new DBContext1().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + tenSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {                
                DotGiamGia dgg = new DotGiamGia(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getDate(6),
                        rs.getBoolean(7),
                        rs.getString(8)
                );
                listSearch.add(dgg);
            }
            conn.close();
        } catch (Exception e) {
        }
        return listSearch;
    }
}
