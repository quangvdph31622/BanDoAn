/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.PhieuGiamGia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hieu1
 */
public class PhieuGiamGiaService {

    Connection conn = null;
    PreparedStatement ps = null;

    public List<PhieuGiamGia> getAll() {
        List<PhieuGiamGia> dspgg = new ArrayList<>();
        String sql = "SELECT PhieuGiamGia.*, DotGiamGia.PhanTramGiam, DotGiamGia.NgayBatDau, DotGiamGia.NgayKetThuc\n"
                + "	FROM PhieuGiamGia\n"
                + "	LEFT JOIN DotGiamGia ON PhieuGiamGia.MaPhieuGiamGia = DotGiamGia.MaDotGiamGia;";

        try {
            conn = DBContext1.getConnection();
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PhieuGiamGia pgg = new PhieuGiamGia(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5), rs.getDate(6));
                dspgg.add(pgg);
            }
            return dspgg;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int insert(PhieuGiamGia pgg) {
    String sql = "BEGIN TRANSACTION;\n" +
            "INSERT INTO DotGiamGia (PhanTramGiam, NgayBatDau, NgayKetThuc)\n" +
            "VALUES (?, ?, ?);\n" +
            "DECLARE @DotGiamGiaID INT;\n" +
            "SET @DotGiamGiaID = SCOPE_IDENTITY();\n" +
            "INSERT INTO PhieuGiamGia (MaDotGiamGia, SanPhamApDung)\n" +
            "VALUES (@DotGiamGiaID, ?);\n" +
            "COMMIT TRANSACTION;";
    try {
        conn = DBContext1.getConnection();
        ps = conn.prepareStatement(sql);

        // Thiết lập giá trị cho các tham số trong câu lệnh SQL
        ps.setObject(1, pgg.getPhanTramGiam());
        ps.setObject(2, pgg.getNgayBatDau());
        ps.setObject(3, pgg.getNgayKetThuc());
        ps.setObject(4, pgg.getSanPhamApDung());

        return ps.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
        return 0;
    }
}


    public ArrayList<PhieuGiamGia> timPgg(String ma) {
        ArrayList<PhieuGiamGia> list = new ArrayList<>();
        Connection conn = DBContext1.getConnection();
        String sql = "SELECT PhieuGiamGia.*, DotGiamGia.PhanTramGiam, DotGiamGia.NgayBatDau, DotGiamGia.NgayKetThuc\n"
                + "	FROM PhieuGiamGia\n"
                + "	LEFT JOIN DotGiamGia ON PhieuGiamGia.MaPhieuGiamGia = DotGiamGia.MaDotGiamGia\n"
                + "	where MaPhieuGiamGia = ?";
        Statement stm;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PhieuGiamGia pgg = new PhieuGiamGia();
                pgg.setMaPhieuGiamGia(rs.getInt("MaPhieuGiamGia"));
                pgg.setMaDotGiamGia(rs.getInt("MaDotGiamGia"));
                pgg.setSanPhamApDung(rs.getInt("SanPhamApDung"));
                pgg.setPhanTramGiam(rs.getInt("PhanTramGiam"));
                pgg.setNgayBatDau(rs.getDate("NgayBatDau"));
                pgg.setNgayKetThuc(rs.getDate("NgayKetThuc"));
                list.add(pgg);
            }
        } catch (Exception e) {
        }
        return list;
    }

            public void update(PhieuGiamGia pgg) {
            String sql = "UPDATE DotGiamGia\n"
                    + "SET \n"
                    + "    PhanTramGiam = ?,\n"
                    + "    NgayBatDau = ?,\n"
                    + "    NgayKetThuc = ?\n"
                    + "WHERE MaDotGiamGia = ?";

            String sqlPhieuGiamGia = "UPDATE PhieuGiamGia\n"
                    + "SET \n"
                    + "    SanPhamApDung = ?\n"
                    + "WHERE MaPhieuGiamGia = ?";

            try {
                conn = new DBContext1().getConnection();
                conn.setAutoCommit(false); // Bắt đầu giao dịch

                // Cập nhật DotGiamGia
                ps = conn.prepareStatement(sql);
                ps.setObject(1, pgg.getPhanTramGiam());
                ps.setObject(2, pgg.getNgayBatDau());
                ps.setObject(3, pgg.getNgayKetThuc());
                ps.setObject(4, pgg.getMaDotGiamGia());
                ps.executeUpdate();

                // Cập nhật PhieuGiamGia
                ps = conn.prepareStatement(sqlPhieuGiamGia);
                ps.setObject(1, pgg.getSanPhamApDung());
                ps.setObject(2, pgg.getMaDotGiamGia());
                ps.executeUpdate();

                conn.commit(); 
            } catch (Exception e) {
                try {
                    conn.rollback(); 
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                e.printStackTrace();
            } finally {
                try {
                    conn.setAutoCommit(true); 
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                closeResources(conn, ps, null);
            }
        }

        private void closeResources(Connection conn, PreparedStatement ps, ResultSet rs) {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        
        public int del(int ma) {
    String sql = "BEGIN TRANSACTION;\n" +
            "DELETE FROM PhieuGiamGia WHERE MaDotGiamGia = ?;\n" +
            "DELETE FROM DotGiamGia WHERE MaDotGiamGia = ?;\n" +
            "COMMIT TRANSACTION;";

    try {
        conn = DBContext1.getConnection();
        ps = conn.prepareStatement(sql);
        ps.setObject(1, ma);
        ps.setObject(2, ma);
        return ps.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
        return 0;
    }
}



}
