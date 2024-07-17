/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DTO.DotGiamGiaDTO;
import DTO.KhachHangDTO;
import DTO.PhieuGiaoHangDTO;
import DTO.PhieuGiaoHangDTO1;
import DTO.SanPhamDTO;
import Model.PhieuGiaoChiTiet;
import Model.PhieuGiaoHang;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 84904
 */
public class PhieuGiaoHang_SV {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    PhieuGiaoHang pgh;
    DotGiamGiaDTO dggDTO;

    public List<PhieuGiaoHang> getAllPhieuGiaoHang() {
        List<PhieuGiaoHang> ldsv1 = new ArrayList<>();
        String sql = "	SELECT\n"
                + "    PhieuGiaoHang.MaPhieuGiaoHang,\n"
                + "    KhachHang.HoTen,\n"
                + "    PhieuGiaoHang.MaNhanVien,\n"
                + "    PhieuGiaoHang.MaNhanVien1,\n"
                + "    ChiTietPhieuGiaoHang.MaSanPham,\n"
                + "    ChiTietPhieuGiaoHang.SoLuong,\n"
                + "    PhieuGiaoHang.DiaChiGiaoHang,\n"
                + "    PhieuGiaoHang.GiaoDuKien,\n"
                + "    PhieuGiaoHang.GiaoThucTe,\n"
                + "    PhieuGiaoHang.TrangThai,\n"
                + "    PhieuGiaoHang.KhachHangXacNhan,\n"
                + "    PhieuGiaoHang.GhiChu,\n"
                + "    PhieuGiaoHang.TongTien,\n"
                + "    PhieuGiaoHang.TienKhachDua, -- Added field\n"
                + "    PhieuGiaoHang.PhiVanChuyen -- Added field\n"
                + "FROM\n"
                + "    PhieuGiaoHang\n"
                + "    INNER JOIN ChiTietPhieuGiaoHang ON PhieuGiaoHang.MaPhieuGiaoHang = ChiTietPhieuGiaoHang.MaPhieuGiaoHang\n"
                + "    INNER JOIN KhachHang ON PhieuGiaoHang.MaKhachHang = KhachHang.MaKhachHang;";
        try {
            conn =  DBContext1.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ldsv1.add(new PhieuGiaoHang(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getDate(8),
                        rs.getDate(9),
                        rs.getString(10),
                        rs.getInt(11),
                        rs.getString(12),
                        rs.getBigDecimal(13),
                        rs.getBigDecimal(14),
                        rs.getBigDecimal(15)
                ));
            }
            return ldsv1;
        } catch (Exception e) {
        }
        return null;
    }

    public void DeletePhieuGiaoHang(int ma, int ma1) {
        String sqlDeleteGrade = "DELETE FROM ChiTietPhieuGiaoHang\n"
                + "WHERE MaPhieuGiaoHang = ?\n"
                + "DELETE FROM PhieuGiaoHang\n"
                + "WHERE MaPhieuGiaoHang = ?";

        try (Connection conn =  DBContext1.getConnection(); PreparedStatement psGrade = conn.prepareStatement(sqlDeleteGrade)) {

            psGrade.setInt(1, ma);
            psGrade.setInt(2, ma1);
            psGrade.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UpdatePhieuGiaoHang(String ma, int ma1) {
        String sqlDeleteGrade = "UPDATE PhieuGiaoHang \n"
                + "		SET       TrangThai = ?\n"
                + "		WHERE MaPhieuGiaoHang = ?\n"
                + "		UPDATE PhieuGiaoHang \n"
                + "		SET       GiaoThucTe = GETDATE()\n"
                + "		WHERE (MaPhieuGiaoHang = ? and TrangThai = 'Đã Giao Hàng') ";

        try (Connection conn = DBContext1.getConnection(); PreparedStatement psGrade = conn.prepareStatement(sqlDeleteGrade)) {

            psGrade.setString(1, ma);
            psGrade.setInt(2, ma1);
            psGrade.setInt(3, ma1);
            psGrade.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<KhachHangDTO> getAllKhachHang() {
        List<KhachHangDTO> listkhdto = new ArrayList<>();
        String sql = "SELECT MaKhachHang, HoTen, DiaChi, DienThoai FROM   KhachHang";
        try {
            conn = DBContext1.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                listkhdto.add(new KhachHangDTO(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                ));
            }
            return listkhdto;
        } catch (Exception e) {
        }
        return null;
    }

    public List<KhachHangDTO> getAlltkKhachHang(String Ten) {
        List<KhachHangDTO> listkhdto = new ArrayList<>();
        String sql = "SELECT MaKhachHang, HoTen, DiaChi, DienThoai FROM   KhachHang where HoTen = ?";
        try {
            conn = DBContext1.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, Ten);
            rs = ps.executeQuery();
            while (rs.next()) {
                listkhdto.add(new KhachHangDTO(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                ));
            }
            return listkhdto;
        } catch (Exception e) {
        }
        return null;
    }

    public List<DotGiamGiaDTO> getAllcboPhieuGiam() {
        List<DotGiamGiaDTO> liss = new ArrayList<>();
        String sql = "SELECT TenDotGiamGia, PhanTramGiam FROM   DotGiamGia";
        try {
            conn = DBContext1.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                liss.add(new DotGiamGiaDTO(
                        rs.getString(1),
                        rs.getInt(2)
                ));
            }
            return liss;
        } catch (Exception e) {
        }
        return null;

    }

    public List<SanPhamDTO> getAllSanPham() {
        List<SanPhamDTO> listsp = new ArrayList<>();
        String sql = "SELECT * FROM SanPham;";
        try {
            conn = DBContext1.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                listsp.add(new SanPhamDTO(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getFloat(6),
                        rs.getString(7)
                ));
            }
            return listsp;
        } catch (Exception e) {
        }
        return null;
    }

    public void insertTaoPhieuGiao(PhieuGiaoHangDTO pghdto) {
        String sql = "INSERT INTO PhieuGiaoHang (MaKhachHang, MaNhanVien,TrangThai)\n"
                + "		VALUES (?,?,?);";
        try {
            conn = DBContext1.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pghdto.getMaKhachHang());
            ps.setInt(2, pghdto.getMaNhanVien());
            ps.setString(3, pghdto.getTrangThai());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void insertTaoPhieuGiao1(PhieuGiaoChiTiet pgct) {
        String sql = "INSERT INTO ChiTietPhieuGiaoHang\n"
                + "             (MaPhieuGiaoHang ,MaSanPham, SoLuong, MaKhachHang)\n"
                + "VALUES (?, ?, ?, ?)";
        try {
            conn = DBContext1.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pgct.getMaPhieuGiaoHangChiTiet());
            ps.setInt(2, pgct.getMaSanPham());
            ps.setInt(3, pgct.getSoLuong());
            ps.setInt(4, pgct.getMaKhachHang());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<PhieuGiaoHangDTO1> getAllTaoDSPG() {
        List<PhieuGiaoHangDTO1> pghdto1 = new ArrayList<>();
        String sql = "select MaPhieuGiaoHang, KhachHang.HoTen ,MaNhanVien , TrangThai  from PhieuGiaoHang \n"
                + "		JOIN KhachHang ON PhieuGiaoHang.MaKhachHang = KhachHang.MaKhachHang";
        try {
            conn = DBContext1.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pghdto1.add(new PhieuGiaoHangDTO1(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4)
                ));
            }
            return pghdto1;
        } catch (Exception e) {
        }
        return null;
    }

    public List<PhieuGiaoChiTiet> getAllPhieuChiTiet(int ma) {
        List<PhieuGiaoChiTiet> listpgct = new ArrayList<>();
        String sql = "Select * from ChiTietPhieuGiaoHang where MaPhieuGiaoHang = ?";
        try {
            conn = DBContext1.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, ma);
            rs = ps.executeQuery();
            while (rs.next()) {
                listpgct.add(new PhieuGiaoChiTiet(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4)
                ));
            }
            return listpgct;
        } catch (Exception e) {
        }
        return null;
    }

    public List<PhieuGiaoChiTiet> selectAllPhieuChiTiet() {
        List<PhieuGiaoChiTiet> listpgct = new ArrayList<>();
        String sql = "SELECT MaSanPham, MaPhieuGiaoHang, SoLuong, MaKhachHang\n"
                + "FROM   ChiTietPhieuGiaoHang ";
        try {
            conn = DBContext1.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                listpgct.add(new PhieuGiaoChiTiet(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4)
                ));
            }
            return listpgct;
        } catch (Exception e) {
        }
        return null;
    }

    public void updateTaoPhieuGiao(PhieuGiaoHang lpgh1) {
        String sql = "Update PhieuGiaoHang\n"
                + "		SET MaNhanVien1 = ?,\n"
                + "			NgayTaoPhieu = GETDATE(),\n"
                + "			GiaoDuKien = GETDATE(),\n"
                + "			GiaoThucTe = null ,\n"
                + "			DiaChiGiaoHang = ?,\n"
                + "			TrangThai = ?,\n"
                + "			KhachHangXacNhan = null ,\n"
                + "			GhiChu = ?,\n"
                + "			TongTien = ?,\n"
                + "			TienKhachDua = ?,\n"
                + "			PhiVanChuyen = ?\n"
                + "		WHERE MaPhieuGiaoHang = ?";
        try {
            conn = DBContext1.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, lpgh1.getMaNhanVien1());// ship
            ps.setString(2, lpgh1.getDiaChiGiaoHang());
            ps.setString(3, lpgh1.getTrangThai());
            ps.setString(4, lpgh1.getGhiChu());
            ps.setBigDecimal(5, lpgh1.getTongTien());
            ps.setBigDecimal(6, lpgh1.getTienKhachDua());
            ps.setBigDecimal(7, lpgh1.getPhiVanChuyen());
            ps.setInt(8, lpgh1.getMaPhieuGiao());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void insertTaoPhieuGiaoChiTiet(PhieuGiaoChiTiet pgct) {
        String sql = "INSERT INTO ChiTietPhieuGiaoHang (MaPhieuGiaoHang, MaSanPham, SoLuong,MaKhachHang)\n"
                + "		VALUES \n"
                + "		(?, ?, ?,?)";
        try {
            conn = DBContext1.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pgct.getMaPhieuGiaoHangChiTiet());
            ps.setInt(2, pgct.getMaSanPham());
            ps.setInt(3, pgct.getSoLuong());
            ps.setInt(4, pgct.getMaKhachHang());

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
