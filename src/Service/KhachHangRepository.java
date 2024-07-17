/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;


import Model.KhachHang;
import Model.LichSuMuaHang;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author PTC
 */
public class KhachHangRepository {
    Connection conn = DBContext1.getConnection();

    public ArrayList<KhachHang> getAll(){
        String sql = "SELECT * FROM KhachHang";
        ArrayList<KhachHang> list = new ArrayList<>();
        try (Connection conn = DBContext1.getConnection();
                PreparedStatement pst = conn.prepareStatement(sql)){
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                 Integer maKH = rs.getInt("MaKhachHang");
                 String hoTen = rs.getString("HoTen");
                 String gioiTinh = rs.getString("GioiTinh");
                 String ngaySinh = rs.getString("NgaySinh");
                 String diaChi = rs.getString("DiaChi");
                 String Email = rs.getString("Email");
                 String dienThoai = rs.getString("DienThoai");
                 String loaiKH = rs.getString("LoaiKhachHang");
                 KhachHang khachHang = new KhachHang(maKH, hoTen, gioiTinh, ngaySinh, diaChi, Email, dienThoai, loaiKH);
                 list.add(khachHang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<LichSuMuaHang> getAllLs(){
        String sql = "SELECT * from LichSuMuaHang join KhachHang on LichSuMuaHang.MaKhachHang = KhachHang.MaKhachHang";
        ArrayList<LichSuMuaHang> listLs = new ArrayList<>();
        try (Connection conn = DBContext1.getConnection();
                PreparedStatement pst = conn.prepareStatement(sql)){
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                 Integer maLS = rs.getInt("MaLichSu");
                 Integer maKH = rs.getInt("MaKhachHang");
                 String tenKH = rs.getString("TenKhachHang");
                 String ngayMuaHang = rs.getString("NgayMuaHang");
                 Integer maSP = rs.getInt("MaSanPham");
                 String tenSP = rs.getString("TenSanPham");
                 Integer soLuong = rs.getInt("SoLuong");
                 Integer tongTien = rs.getInt("TongTien");
                 LichSuMuaHang ls = new LichSuMuaHang(maLS, maKH, tenKH, ngayMuaHang, maSP, tenSP, soLuong, tongTien);
                 listLs.add(ls);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listLs;
    }
    public Boolean addNew(KhachHang kh){
        String sql = "INSERT INTO KhachHang (HoTen, GioiTinh, NgaySinh, DiaChi, Email, DienThoai, LoaiKhachHang) VALUES (?,?,?,?,?,?,?)";
        try (Connection conn = DBContext1.getConnection();
                PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setObject(1, kh.getHoTen());
            pst.setObject(2, kh.getGioiTinh());
            pst.setObject(3, kh.getNgaySinh());
            pst.setObject(4, kh.getDiaChi());
            pst.setObject(5, kh.getEmail());
            pst.setObject(6, kh.getSoDienThoai());
            pst.setObject(7, kh.getLoaiKhachHang());
            int kq = pst.executeUpdate();
            return kq > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }   
    public Boolean Delete(Integer MaKhachHang){
        String sql = "DELETE FROM KhachHang WHERE MaKhachHang = ?";
        try (Connection conn = DBContext1.getConnection();
                PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setObject(1, MaKhachHang);
            int kq = pst.executeUpdate();
            return kq > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public Boolean Update(KhachHang kh){
        String sql = "UPDATE KhachHang SET HoTen = ?, GioiTinh = ?, NgaySinh = ?, DiaChi = ?, Email = ?, DienThoai = ?, LoaiKhachHang = ? WHERE MaKhachHang = ?";
        try (Connection conn = DBContext1.getConnection();
                PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setObject(1, kh.getHoTen());
            pst.setObject(2, kh.getGioiTinh());
            pst.setObject(3, kh.getNgaySinh());
            pst.setObject(4, kh.getDiaChi());
            pst.setObject(5, kh.getEmail());
            pst.setObject(6, kh.getSoDienThoai());
            pst.setObject(7, kh.getLoaiKhachHang());
            pst.setObject(8, kh.getMaKhachHang());
            int kq = pst.executeUpdate();
            return kq > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public ArrayList<KhachHang> searchKH(String name){
        String sql = "SELECT * FROM KhachHang WHERE HoTen LIKE '%" + name + "%'";
        ArrayList<KhachHang> list = new ArrayList<>();
        try (Connection conn = DBContext1.getConnection();
                PreparedStatement pst = conn.prepareStatement(sql)){
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                Integer maKH = rs.getInt("MaKhachHang");
                 String hoTen = rs.getString("HoTen");
                 String gioiTinh = rs.getString("GioiTinh");
                 String ngaySinh = rs.getString("NgaySinh");
                 String diaChi = rs.getString("DiaChi");
                 String Email = rs.getString("Email");
                 String dienThoai = rs.getString("DienThoai");
                 String loaiKH = rs.getString("LoaiKhachHang");
                 KhachHang khachHang = new KhachHang(maKH, hoTen, gioiTinh, ngaySinh, diaChi, Email, dienThoai, loaiKH);
                 list.add(khachHang);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<LichSuMuaHang> searchLS(String name){
        String sql = "SELECT * FROM LichSuMuaHang WHERE TenKhachHang LIKE '%" + name + "%'";
        ArrayList<LichSuMuaHang> list = new ArrayList<>();
        try (Connection conn = DBContext1.getConnection();
                PreparedStatement pst = conn.prepareStatement(sql)){
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                Integer maLS = rs.getInt("MaLichSu");
                 Integer maKH = rs.getInt("MaKhachHang");
                 String tenKH = rs.getString("TenKhachHang");
                 String ngayMuaHang = rs.getString("NgayMuaHang");
                 Integer maSP = rs.getInt("MaSanPham");
                 String tenSP = rs.getString("TenSanPham");
                 Integer soLuong = rs.getInt("SoLuong");
                 Integer tongTien = rs.getInt("TongTien");
                 LichSuMuaHang ls = new LichSuMuaHang(maLS, maKH, tenKH, ngayMuaHang, maSP, tenSP, soLuong, tongTien);
                 list.add(ls);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
