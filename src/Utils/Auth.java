/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import Model.NhanVien;
import Model.TaiKhoan;
import Service.QLNV;
/**
 *
 * @author Admin
 */
public class Auth {
    /**
     * Đối tượng này chứa thông tin người sử dụng sau khi đăng nhập
     */
    public static TaiKhoan user = null;
// ... (thiết lập thông tin cho taiKhoan)
    public static void clear() {
        Auth.user = null;
    }

    public static boolean isLogin() {
        return Auth.user != null;

    }

    /**
     * Kiểm tra xem có phải là trưởng phòng hay không
     */
public static boolean isManager() {
    QLNV qlnv = new QLNV();
    TaiKhoan tk = qlnv.selectByMa(Auth.user.getMaNhanVien());
    NhanVien nv = qlnv.SelectNhanVienId(tk.getMaNhanVien());
    tk.setNhanVien(nv);
    return Auth.isLogin() && "QL".equals(tk.getNhanVien().getC().getMaCV());
}

}





