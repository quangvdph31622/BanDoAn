/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Service.DBContext1;
import Model.ComBo;
import Service.DBContext1;
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
public class ComBoService {
     private Connection conn;
    private ArrayList<ComBo> listNV = new ArrayList<>();

    public ComBoService() {
          try {
            conn = DBContext1.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

  

   public ArrayList<ComBo> getAllComBo() {
    ArrayList<ComBo> listCB = new ArrayList<>();

    try {
        String query = "SELECT MaComBo, TenComBo, Size, TrangThai, Gia, MoTa FROM ComBo";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int ma = rs.getInt("MaComBo");
            String ten = rs.getString("TenComBo");
            String size = rs.getString("Size");
            float gia = Float.valueOf(rs.getString("Gia"));
            String moTa = rs.getString("MoTa");
            String trangThai = rs.getString("TrangThai");

            ComBo cb = new ComBo(ma, ten, size, gia, moTa, trangThai);
            listCB.add(cb);
        }

    } catch (SQLException e) {
        e.printStackTrace(); // Handle the exception according to your application's needs
    }

    return listCB;
}


    public void them(ComBo cb) throws Exception {
        String query = "INSERT INTO SanPham (TenComBo,Size,TrangThai,Gia,MoTa) VALUES (?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setString(1, cb.getTen());
        
        ps.setString(2, cb.getSize());
        ps.setString(3, cb.getTrangThai());
        ps.setString(4, cb.getGia() + "");
        ps.setString(5, cb.getMoTa());
        ps.execute();
        listNV.add(cb);
    }

   public void xoa(int id, int index) throws SQLException{
    String query = "DELETE FROM SanPham WHERE MaComBo=?";
    
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


    public void update(ComBo sp, int index) throws Exception {
      String query = "UPDATE SanPham SET TenComBo=?, Size=?, TrangThai=?, Gia=?, MoTa=?";

        PreparedStatement ps = conn.prepareStatement(query);

        ps.setString(1, sp.getTen());
        ps.setString(2, sp.getSize());
        ps.setString(3, sp.getTrangThai());
        ps.setString(4, sp.getGia()+"");
        ps.setString(5, sp.getMoTa());

        ps.executeUpdate();
        listNV.set(index, sp);

    }

    public List<ComBo> search(String tenSearch) {
        String query = "SELECT * FROM SanPham WHERE TenSanPham LIKE ?";

        List<ComBo> listSearch = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "%" + tenSearch + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int ma = rs.getInt("MaComBo");
                String ten = rs.getString("TenComBo");
                
                String size = rs.getString("Size");
                float gia = Float.valueOf(rs.getString("Gia"));
                String moTa = rs.getString("MoTa");
                String trangThai = rs.getString("TrangThai");

                ComBo cb = new ComBo(ma, ten, size, gia, moTa, trangThai);
                listSearch.add(cb);
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception according to your application's needs
        }

       return listSearch;
    }
}
