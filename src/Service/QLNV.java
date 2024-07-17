/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.ChucVu;
import Model.NhanVien;
import Model.NhanVienFull;
import Model.TaiKhoan;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class QLNV {

    NhanVien nv = new NhanVien();
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void add(NhanVienFull nv) throws SQLException {
        String sql = "Insert NhanVien VALUES(?,?,?,?,?,?,?) ";
        String sql2 = "Insert TaiKhoan(TaiKhoan,MatKhau,MaNhanVien,NgayTao) VALUES(?,?,?,?)";
        Connection con = DBContext1.getConnection();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, nv.getNv().getMaNV());
            ps.setString(2, nv.getNv().getTenNV());
            ps.setBoolean(3, nv.getNv().isGioiTinh());
            ps.setString(4, nv.getNv().getDiaChi());
            ps.setDate(5, new Date(nv.getNv().getNgaySinh().getTime()));
            ps.setString(6, nv.getNv().getC().getMaCV());
            ps.setString(7, nv.getNv().getImage());
            ps.executeUpdate();

            PreparedStatement pstk = con.prepareStatement(sql2);
            pstk.setString(1, nv.getTk().getTaiKhoan());
            pstk.setString(2, nv.getTk().getMatKhau());
            pstk.setInt(3, nv.getNv().getMaNV());
            pstk.setDate(4, new Date(nv.getTk().getNgayTao().getTime()));
            pstk.executeUpdate();
            con.commit();
        } catch (Exception e) {
            // In thông báo lỗi hoặc xử lý ngoại lệ theo cách khác
            e.printStackTrace();
            // Nếu có lỗi, rollback giao dịch
            con.rollback();
        }
    }

    public void update(NhanVienFull nv) {
        String sql = "Update NhanVien set TenNhanVien=?,GioiTinh=?,DiaChi=?,NgaySinh=?,MaChucVu=?,ImageNV=? WHERE MaNhanVien=?";
        String sql2 = "Update TaiKhoan SET MatKhau=?,NgayTao=? WHERE TaiKhoan = ? AND MaNhanVien =?";
        Connection con = DBContext1.getConnection();
        try {

            con.setAutoCommit(false);
            ps = con.prepareStatement(sql);
            ps.setString(1, nv.getNv().getTenNV());
            ps.setBoolean(2, nv.getNv().isGioiTinh());
            ps.setString(3, nv.getNv().getDiaChi());
            ps.setDate(4, new Date(nv.getNv().getNgaySinh().getTime()));
            ps.setString(5, nv.getNv().getC().getMaCV());
            ps.setString(6, nv.getNv().getImage());
            ps.setInt(7, nv.getNv().getMaNV());
            ps.executeUpdate();
            PreparedStatement ps1 = con.prepareStatement(sql2);
            ps1.setString(1, nv.getTk().getMatKhau());
            ps1.setDate(2, new Date(nv.getTk().getNgayTao().getTime()));
            ps1.setString(3, nv.getTk().getTaiKhoan());
            ps1.setInt(4, nv.getNv().getMaNV());
            ps1.executeUpdate();
            con.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (con != null) {
                    con.setAutoCommit(true);
                    con.close();
                }
            } catch (SQLException CloseException) {
                CloseException.printStackTrace();
            }
        }

    }

    public void delete(int maNhanVien) {
        String deleteNhanVienSql = "DELETE FROM NhanVien WHERE MaNhanVien=?";
        String deleteTaiKhoanSql = "DELETE FROM TaiKhoan WHERE MaNhanVien=?";
        Connection con = DBContext1.getConnection();
        try {

            con.setAutoCommit(false);

            // Xóa bảng TaiKhoan
            try (PreparedStatement psTaiKhoan = con.prepareStatement(deleteTaiKhoanSql)) {
                psTaiKhoan.setInt(1, maNhanVien);
                psTaiKhoan.executeUpdate();
            }

            // Xóa bảng NhanVien
            try (PreparedStatement psNhanVien = con.prepareStatement(deleteNhanVienSql)) {
                psNhanVien.setInt(1, maNhanVien);
                psNhanVien.executeUpdate();
            }

            // Commit giao dịch
            con.commit();
        } catch (SQLException e) {
            // Rollback nếu có lỗi
            try {
                if (con != null) {
                    con.rollback();
                    con.setAutoCommit(true);
                    con.close();
                }
            } catch (SQLException rollbackException) {
                rollbackException.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            // Đóng connection
            try {
                if (con != null) {
                    con.setAutoCommit(true);
                    con.close();
                }
            } catch (SQLException closeException) {
                closeException.printStackTrace();
            }
        }
    }

    public List<NhanVienFull> getAllNhanVien(String keyword) {
        List<NhanVienFull> searchResult = new ArrayList<>();
        String sql = "SELECT * FROM NhanVien INNER JOIN ChucVu ON NhanVien.maChucVu = ChucVu.maChucVu JOIN TaiKhoan ON NhanVien.MaNhanVien = TaiKhoan.MaNhanVien WHERE NhanVien.tenNhanVien LIKE ? ";
        Connection con = DBContext1.getConnection();
        try (
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ChucVu chucVu = new ChucVu(rs.getString(8), rs.getString(9), rs.getFloat(10), rs.getInt(11));
                NhanVien nhanVien = new NhanVien(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getString(4), rs.getDate(5), chucVu, rs.getString(7));
                TaiKhoan taiKhoan = new TaiKhoan(rs.getString(12), rs.getString(13), rs.getInt(14), rs.getString(15), rs.getString(16), rs.getDate(17));
                NhanVienFull fullInfo = new NhanVienFull(chucVu, nhanVien, taiKhoan);
                searchResult.add(fullInfo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return searchResult;

    }

    public TaiKhoan selectById(String taikhoan) {
        String sql = "SELECT * FROM TaiKhoan WHERE TaiKhoan = ?";
        List<TaiKhoan> list = new ArrayList<>();
        Connection con = DBContext1.getConnection();
        try ( PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, taikhoan);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    TaiKhoan tk = new TaiKhoan(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getDate(6));

                    // Các trường khác của đối tượng TaiKhoan
                    list.add(tk);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (list.isEmpty()) {
            return null;
        }

        return list.get(0);
    }

    public NhanVien SelectNhanVienId(Integer id) {
        String sql = "Select * from NhanVien JOIN ChucVu ON NhanVien.MaChucVu = ChucVu.MaChucVu WHERE MaNhanVien = ?";
        List<NhanVien> listnv = new ArrayList<>();
        Connection con = DBContext1.getConnection();
        try {
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                ChucVu cv = new ChucVu(rs.getString(8), rs.getString(9), rs.getFloat(10), rs.getInt(11));
                NhanVien nv = new NhanVien(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getString(4), rs.getDate(5), cv, rs.getString(7));
                listnv.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (listnv.isEmpty()) {
            System.out.println("Không tìm thấy thông tin nhân viên với ID: " + id);
            return null;
        }

        return listnv.get(0);
    }

    public TaiKhoan selectByMa(Integer manv) {
        String sql = "SELECT * FROM NhanVien INNER JOIN ChucVu ON NhanVien.maChucVu = ChucVu.maChucVu JOIN TaiKhoan ON NhanVien.MaNhanVien = TaiKhoan.MaNhanVien WHERE TaiKhoan.MaNhanVien = ?";
        List<TaiKhoan> list = new ArrayList<>();
        Connection con = DBContext1.getConnection();
        try ( PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, manv);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ChucVu chucVu = new ChucVu(rs.getString(8), rs.getString(9), rs.getFloat(10), rs.getInt(11));
                    NhanVien nhanVien = new NhanVien(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getString(4), rs.getDate(5), chucVu, rs.getString(7));
                    TaiKhoan tk = new TaiKhoan(rs.getString(12), rs.getString(13), rs.getInt(14), rs.getString(15), rs.getString(16), rs.getDate(17));

                    // Các trường khác của đối tượng TaiKhoan
                    list.add(tk);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (list.isEmpty()) {
            return null;
        }

        return list.get(0);
    }

    public void updateTaiKhoan(TaiKhoan tk) {
        String sql = "Update TaiKhoan SET MatKhau=? WHERE TaiKhoan = ?";
        Connection con = DBContext1.getConnection();
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, tk.getMatKhau());
            ps.setString(2, tk.getTaiKhoan());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
