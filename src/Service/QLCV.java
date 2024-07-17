/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.ChucVu;
import Service.DBContext1;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author Admin
 */
public class QLCV {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<ChucVu> getAll() {
        List<ChucVu> list = new ArrayList<>();
        String sql = "Select * from ChucVu";
        try {
            con = new DBContext1().getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ChucVu c = new ChucVu(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getInt(4));
                list.add(c);

            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }
}
