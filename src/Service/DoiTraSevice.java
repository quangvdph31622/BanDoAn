/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.DoiHang;
import Model.HoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DoiTraSevice {

    public ArrayList<DoiHang> getAllDoiHang() {
        ArrayList<DoiHang> list = new ArrayList<>();
        try {
            Connection connection = DBContext1.getConnection();
            Statement statement = connection.createStatement();

            // Truy vấn dữ liệu từ cả hai bảng và tính tổng tiền
            String sql = "SELECT\n"
                    + "    PhieuDoiTra.MaPhieuDoiTra,\n"
                    + "    HoaDon.MaHoaDon,\n"
                    + "    HoaDon.TenKhachHang,\n"
                    + "    ChiTietPhieuDoiTra.MaSanPham,\n"
                    + "    PhieuDoiTra.NgayDoiTra,\n"
                    + "    PhieuDoiTra.TrangThai,\n"
                    + "	ChiTietPhieuDoiTra.SoLuong,\n"
                    + "	HoaDon.TongTien,\n"
                    + "    ChiTietPhieuDoiTra.LiDo\n"
                    + "FROM\n"
                    + "    PhieuDoiTra\n"
                    + "JOIN\n"
                    + "    HoaDon ON PhieuDoiTra.MaHoaDon = HoaDon.MaHoaDon\n"
                    + "JOIN\n"
                    + "    ChiTietPhieuDoiTra ON PhieuDoiTra.MaPhieuDoiTra = ChiTietPhieuDoiTra.MaPhieuDoiTra;";
             ResultSet rs = statement.executeQuery(sql);

            // Đổ dữ liệu vào model
            while (rs.next()) {
                DoiHang dh = new DoiHang();
                dh.setMaPD(rs.getString("MaPhieuDoiTra"));
                dh.setMaHD(rs.getString("MaHoaDon"));
                dh.setMaKH(rs.getString("TenKhachHang"));
                dh.setMaSP(rs.getString("MaSanPham"));
                dh.setNgayDoi(rs.getString("NgayDoiTra"));
                dh.setTrangThai(rs.getString("TrangThai"));
                dh.setSoLuong(rs.getString("SoLuong"));
                dh.setTongTien(rs.getString("TongTien"));
                dh.setLiDo(rs.getString("LiDo"));
                list.add(dh);
            }

            // Đóng kết nối và statement
            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public ArrayList<HoaDon> getAllHoaDon() {
        ArrayList<HoaDon> list = new ArrayList<>();
        Connection cn = DBContext1.getConnection();
        String sql = "SELECT \n"
                + "    HoaDon.MaHoaDon,\n"
                + "    HoaDon.TenKhachHang,\n"
                + "    ChiTietHoaDon.MaSanPham,\n"
                + "    ChiTietHoaDon.SoLuong,\n"
                + "    HoaDon.NgayMua,\n"
                + "    HoaDon.TongTien,\n"
                + "    HoaDon.TrangThai\n"
                + "FROM \n"
                + "    HoaDon\n"
                + "JOIN \n"
                + "    ChiTietHoaDon ON HoaDon.MaHoaDon = ChiTietHoaDon.MaHoaDon;";

        Statement stm;
        try {
            stm = cn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getString("MaHoaDon"));
                hd.setTenKH(rs.getString("TenKhachHang"));
                hd.setMaSP(rs.getString("MaSanPham"));
                hd.setSoLuong(rs.getString("SoLuong"));
                hd.setNgayMua(rs.getString("NgayMua"));;
                hd.setTongTien(rs.getString("TongTien"));
                hd.setTrangThai(rs.getString("TrangThai"));
                list.add(hd);
            }

        } catch (Exception e) {
        }
        return list;
    }

    

//    public Integer addN(DoiHang dh) {
//        Integer row = null;
//        String sql = "INSERT INTO PhieuDoiTra (MaKhachHang, MaNhanVien, TenYeuCau, TrangThai, NgayDoiTra, MaSanPham, SoLuong, LiDo)\n"
//                + "VALUES (?,?,?,?,?,?,?,?)";
//        Connection cn = DBContext1.getConnection();
//        try {
//            PreparedStatement pstm = cn.prepareStatement(sql);
//            pstm.setString(1, dh.getMaKH());
//            pstm.setString(2, dh.getMaNV());
//            pstm.setString(3, dh.getTenYC());
//            pstm.setString(4, dh.getTrangThai());
//            pstm.setString(5, dh.getNgayDoi());
//            pstm.setString(6, dh.getMaSP());
//            pstm.setString(7, dh.getSoLuong());
//            pstm.setString(8, dh.getLiDo());
//
//            row = pstm.executeUpdate();
//        } catch (Exception e) {
//        }
//        return row;
//    }
    public Integer add(DoiHang dh) {

        Integer row = null;
        Connection cn = DBContext1.getConnection();

        String query = "INSERT INTO PhieuDoiTra (MaPhieuDoiTra, MaKhachHang, MaNhanVien, TenYeuCau, TrangThai, NgayDoiTra, MaSanPham, SoLuong, LiDo) "
                + "VALUES (newid(), ?, ?, ?, ?, ?, ?, ?, ?)";
        try {

            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setString(1, dh.getMaPD());
            preparedStatement.setString(2, dh.getMaKH());
            preparedStatement.setString(3, dh.getMaNV());
            preparedStatement.setString(4, dh.getTenYC());
            preparedStatement.setString(5, dh.getTrangThai());
            preparedStatement.setString(6, dh.getNgayDoi());
            preparedStatement.setString(7, dh.getMaSP());
            preparedStatement.setString(8, dh.getSoLuong());
            preparedStatement.setString(9, dh.getLiDo());

            row = preparedStatement.executeUpdate();

        } catch (Exception e) {
        }
        return row;
    }

    public Integer update(DoiHang dh) {

        Integer row = null;
        String sql = "UPDATE PhieuDoiTra\n"
                + "SET MaKhachHang = ?, \n"
                + "    MaNhanVien = ?, \n"
                + "    TenYeuCau = ?, \n"
                + "    TrangThai = ?, \n"
                + "    NgayDoiTra = ?, \n"
                + "    MaSanPham = ?, \n"
                + "    SoLuong = ?, \n"
                + "    LiDo = ?\n"
                + "WHERE MaPhieuDoiTra = ?;";
        Connection cn = DBContext1.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);

            pstm.setString(1, dh.getMaKH());
            pstm.setString(2, dh.getMaNV());
            pstm.setString(3, dh.getTenYC());
            pstm.setString(4, dh.getTrangThai());
            pstm.setString(5, dh.getNgayDoi());
            pstm.setString(6, dh.getMaSP());
            pstm.setString(7, dh.getSoLuong());
            pstm.setString(8, dh.getLiDo());
            pstm.setString(9, dh.getMaPD());
            row = pstm.executeUpdate();
        } catch (Exception e) {
        }
        return row;
    }

    public Integer deleteNhanVien(String ma) {
        Integer row = null;
        String sql = "delete from PhieuDoiTra \n"
                + "where MaPhieuDoiTra = ?";
        Connection cn = DBContext1.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, ma);
            row = pstm.executeUpdate();
        } catch (Exception e) {
        }
        return row;
    }

    public ArrayList<HoaDon> timPD(String ma) {
        ArrayList<HoaDon> list = new ArrayList<>();
        Connection cn = DBContext1.getConnection();
        String sql = "select * from HoaDon where MaHoaDon = ?";
        Statement stm;
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, ma);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getString("MaHoaDon"));
                hd.setTenKH(rs.getString("TenKhachHang"));
                hd.setMaSP(rs.getString("MaSanPham"));
                hd.setSoLuong(rs.getString("SoLuong"));
                hd.setNgayMua(rs.getString("NgayMua"));;
                hd.setTongTien(rs.getString("TongTien"));
                hd.setTrangThai(rs.getString("TrangThai"));
                list.add(hd);
            }

        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<DoiHang> timPDngay(String ngay) {
        ArrayList<DoiHang> list = new ArrayList<>();
        Connection cn = DBContext1.getConnection();
        String sql = "select * from PhieuDoiTra where NgayDoiTra = ?";
        Statement stm;
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, ngay);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                DoiHang dh = new DoiHang();
                dh.setMaPD(rs.getString("MaPhieuDoiTra"));
                dh.setMaKH(rs.getString("MaKhachHang"));
                dh.setTenYC(rs.getString("TenYeuCau"));
                dh.setMaSP(rs.getString("MaSanPham"));
                dh.setNgayDoi(rs.getString("NgayDoiTra"));;
                dh.setTrangThai(rs.getString("TrangThai"));
                dh.setLiDo(rs.getString("LiDo"));
                list.add(dh);
            }

        } catch (Exception e) {
        }
        return list;
    }
}
