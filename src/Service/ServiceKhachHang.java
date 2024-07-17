/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.KhachHang;
import Model.LichSuMuaHang;
import Service.KhachHangRepository;
import java.util.ArrayList;

/**
 *
 * @author PTC
 */
public class ServiceKhachHang {
    KhachHangRepository khachHangRepository = new KhachHangRepository();
    
    public ArrayList<KhachHang> getList(){
        return khachHangRepository.getAll();
    }
    public ArrayList<LichSuMuaHang> getListLs(){
        return khachHangRepository.getAllLs();
    }
    
    public String addNew(KhachHang kh) {
        if(khachHangRepository.addNew(kh) == true){
        return "Them thanh cong";
    } else {
            return "Them that bai";
        }
    }
    
    public String Delete(Integer MaKhachHang){
        Boolean check = khachHangRepository.Delete(MaKhachHang);
        if(check) {
            return "Xoa thanh cong";
        } else {
            return "Xoa thanh cong";
        }
    }
    
    public String Update(KhachHang kh) {
        if(khachHangRepository.Update(kh) == true){
        return "Update thanh cong";
    } else {
            return "Update that bai";
        }
    }
    public ArrayList<KhachHang> searchKH(String name){
        ArrayList<KhachHang> kq = khachHangRepository.searchKH(name);
        return kq;
    }
    public ArrayList<LichSuMuaHang> searchLS(String name){
        ArrayList<LichSuMuaHang> kq = khachHangRepository.searchLS(name);
        return kq;
    }
}
