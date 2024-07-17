/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Service.DBContext1;
import Model.SanPham;
import Service.DBContext1;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguyen dinh kien
 */
public class sanPhamService {

    private Connection conn;
    private ArrayList<SanPham> listNV = new ArrayList<>();

    public sanPhamService() {
        try {
            conn = DBContext1.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<SanPham> getAll() {
        try {
            String query = "Select  MaSanPham,TenSanPham,TenLoai,Size,TrangThai,Gia,MoTa from SanPham";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            
            while (rs.next()) {
               

                String ten = rs.getString("TenSanPham");
                String tenLoai = rs.getString("TenLoai");
                String size = rs.getString("Size");
                float gia = Float.valueOf(rs.getString("Gia"));
                String moTa = rs.getString("MoTa");
                String trangThai = rs.getString("TrangThai");

                SanPham nv = new SanPham(0, ten, tenLoai, size, gia, moTa, trangThai);
                

                listNV.add(nv);
            }

        } catch (Exception e) {
        }
        return listNV;
    }

    public void them(SanPham sp) throws Exception {
        String query = "INSERT INTO SanPham (TenSanPham,TenLoai,Size,TrangThai,Gia,MoTa) VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setString(1, sp.getTen());
        ps.setString(2, sp.getTenLoai());
        ps.setString(3, sp.getSize());
        ps.setString(4, sp.getTrangThai());
        ps.setString(5, sp.getGia() + "");
        ps.setString(6, sp.getMoTa());
        ps.execute();
        listNV.add(sp);
    }

   public void xoa(int id, int index) throws SQLException{
    String query = "DELETE FROM SanPham WHERE MaSanPham=?";
    
    try (PreparedStatement ps = conn.prepareStatement(query)) {
        ps.setString(1, String.valueOf(id));
        ps.executeUpdate(); // Use executeUpdate() for DELETE operations
        
        // Check if the index is within the bounds of the list
        if (index >= 0 && index < listNV.size()) {
            listNV.remove(index);
        } else {
            // Handle index out of bounds gracefully or log a warning
            System.out.println("Index out of bounds: " + index);
        }
    } catch (SQLException e) {
        // Handle specific SQL exceptions, log or rethrow as needed
        e.printStackTrace();
        throw e;
    }
}


   public void update(SanPham sp, int MaSanPham) throws Exception {
    String query = "UPDATE SanPham SET TenSanPham=?, TenLoai=?, Size=?, TrangThai=?, Gia=?, MoTa=? WHERE MaSanPham=?" ;

    try (PreparedStatement ps = conn.prepareStatement(query)) {
        ps.setString(1, sp.getTen());
        ps.setString(2, sp.getTenLoai());
        ps.setString(3, sp.getSize());
        ps.setString(4, sp.getTrangThai());
        ps.setString(5, sp.getGia() + "");
        ps.setString(6, sp.getMoTa());
        ps.setString(7, sp.getMa()+""); // Provide the value for the WHERE clause

        ps.executeUpdate();
        listNV.set(MaSanPham, sp);
        
    } catch (SQLException e) {
        e.printStackTrace();
        throw e;
    }
}


    public List<SanPham> search(String tenSearch) {
        String query = "SELECT * FROM SanPham WHERE TenSanPham LIKE ?";

        List<SanPham> listSearch = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "%" + tenSearch + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int ma = rs.getInt("MaSanPham");
                String ten = rs.getString("TenSanPham");
                String tenLoai = rs.getString("TenLoai");
                String size = rs.getString("Size");
                float gia = Float.valueOf(rs.getString("Gia"));
                String moTa = rs.getString("MoTa");
                String trangThai = rs.getString("TrangThai");

                SanPham sp = new SanPham(ma, ten, tenLoai, size, gia, moTa, trangThai);
                listSearch.add(sp);
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception according to your application's needs
        }

        return listSearch;
    }

}
