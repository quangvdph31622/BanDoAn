/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package View;

import Model.DoiHang;
import Service.DBContext1;
import Service.DoiTraSevice;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public class FormTaoYeuCau extends javax.swing.JDialog {

    DoiTraSevice sv = new DoiTraSevice();
    DefaultTableModel tblModel = new DefaultTableModel();
    int index = 0;

    /**
     * Creates new form FormTaoYeuCau
     */
    public FormTaoYeuCau(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        DoiHang dh = new DoiHang();
        txtMapd.setText(dh.getMaPD());
        txtMaKhachHang.setText(dh.getMaKH());
        fillTable();
        txtMapd.setEditable(false);
    }

    FormTaoYeuCau() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void fillTable() {
        tblModel = (DefaultTableModel) tblyeucau.getModel();
        ArrayList<DoiHang> list = sv.getAllDoiHang();
        tblModel.setRowCount(0);
        for (DoiHang dh : list) {
            tblModel.addRow(new Object[]{
                dh.getMaPD(),
                dh.getMaHD(),
                dh.getMaKH(),
                dh.getMaSP(),
                dh.getNgayDoi(),
                dh.getTrangThai(),
                dh.getSoLuong(),
                dh.getTongTien(),
                dh.getLiDo()
            });
        }

    }

    private void suaDuLieu() {
        int selectedRow = tblyeucau.getSelectedRow();
        if (selectedRow != -1) {
            String maPhieuDoiTra = tblyeucau.getValueAt(selectedRow, 0).toString();

            // Lấy dữ liệu mới từ người dùng
            try {
                Connection connection = DBContext1.getConnection();

                // 1. Sửa dữ liệu trong bảng ChiTietPhieuDoiTra
                String sql = "UPDATE ChiTietPhieuDoiTra SET SoLuong = ?, LiDo = ? WHERE MaPhieuDoiTra = ?";
                PreparedStatement pstm = connection.prepareStatement(sql);
                pstm.setString(1, txtsoluong.getText());
                pstm.setString(2, txtLiDo.getText());
                pstm.setString(3, maPhieuDoiTra);

                pstm.executeUpdate();
                pstm.close();

                // 2. Sửa dữ liệu trong bảng PhieuDoiTra
                String sql1 = "UPDATE PhieuDoiTra SET NgayDoiTra = ?, TrangThai = ? WHERE MaPhieuDoiTra = ?";
                PreparedStatement pstm1 = connection.prepareStatement(sql1);
                pstm1.setString(1, txtNgayDoiTra.getText());
                pstm1.setString(2, (String) cboTrangThai.getSelectedItem());
                pstm1.setString(3, maPhieuDoiTra);

                pstm1.executeUpdate();
                pstm1.close();

                connection.close();

                // Cập nhật lại dữ liệu trên JTable
                tblModel.setValueAt(txtsoluong.getText(), selectedRow, 6);
                tblModel.setValueAt(txtLiDo.getText(), selectedRow, 7);
                tblModel.setValueAt(txtNgayDoiTra.getText(), selectedRow, 4);
                tblModel.setValueAt((String) cboTrangThai.getSelectedItem(), selectedRow, 5);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để sửa.");
        }

    }

    private void xoaDuLieu() {
        int selectedRow = tblyeucau.getSelectedRow();
        if (selectedRow != -1) {
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa dòng này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                String maPhieuDoiTra = tblyeucau.getValueAt(selectedRow, 0).toString();

                try {
                    Connection connection = DBContext1.getConnection();

                    // 1. Xóa dữ liệu từ bảng ChiTietPhieuDoiTra
                    String sql = "DELETE FROM ChiTietPhieuDoiTra WHERE MaPhieuDoiTra = ?";
                    PreparedStatement pstm = connection.prepareStatement(sql);
                    pstm.setString(1, maPhieuDoiTra);
                    pstm.executeUpdate();
                    pstm.close();

                    // 2. Xóa dữ liệu từ bảng PhieuDoiTra
                    String sql1 = "DELETE FROM PhieuDoiTra WHERE MaPhieuDoiTra = ?";
                    PreparedStatement pstm1 = connection.prepareStatement(sql1);
                    pstm1.setString(1, maPhieuDoiTra);
                    pstm1.executeUpdate();
                    pstm1.close();

                    connection.close();

                    // Xóa dòng khỏi JTable
                    tblModel.removeRow(selectedRow);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để xóa.");
        }
    }

//    public DoiHang validatedoitra() {
//        String maPD = txtMapd.getText().trim();
//        String maKhachHang = txtMaKhachHang.getText().trim();
//        String tenYeuCau = (String) cboYeuCau.getSelectedItem();
//        String trangThai = (String) cboTrangThai.getSelectedItem();
//        String ngayDoiTra = txtNgayDoiTra.getText().trim();
//        String maSanPham = txtMaSanPham.getText().trim();
//        String MaNV = txtnv.getText().trim();
//        String soLuong = txtsoluong.getText().trim();
//        String liDo = txtLiDo.getText().trim();
//
//        if (maKhachHang.isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Không được để trống mã khách hàng");
//            return null;
//        }
//        if (tenYeuCau.isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Không được để trống tên yêu cầu");
//            return null;
//        }
//        if (trangThai.isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Không được để trống trạng thái");
//            return null;
//        }
//        if (ngayDoiTra.isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Không được để trống ngày đổi trả");
//            return null;
//        }
//        if (maSanPham.isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Không được để trống mã sản phẩm");
//            return null;
//        }
//        if (MaNV.isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Không được để trống mã nhân viên");
//            return null;
//        }
//        if (liDo.isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Không được để trống lý do");
//            return null;
//        }
//        DoiHang dh = new DoiHang(maPD, maKhachHang, MaNV, tenYeuCau, trangThai,  ngayDoiTra, maSanPham, soLuong,liDo);
//        return dh;
//    }
    public void setModel() {
        txtMapd.setText(tblyeucau.getValueAt(index, 0).toString());
        txtmahd.setText(tblyeucau.getValueAt(index, 1).toString());
        txtMaKhachHang.setText(tblyeucau.getValueAt(index, 2).toString());
        txtMaSanPham.setText(tblyeucau.getValueAt(index, 3).toString());
        txtNgayDoiTra.setText(tblyeucau.getValueAt(index, 4).toString());

        String tentrangthai = (String) tblyeucau.getValueAt(index, 5);
        if (tentrangthai.equalsIgnoreCase("Đang xử lí")) {
            cboTrangThai.setSelectedIndex(0);
        } else if (tentrangthai.equalsIgnoreCase("Chờ xác nhận")) {
            cboTrangThai.setSelectedIndex(1);
        } else if (tentrangthai.equalsIgnoreCase("Hoàn Thành")) {
            cboTrangThai.setSelectedIndex(2);
        } else if (tentrangthai.equalsIgnoreCase("Hủy")) {
            cboTrangThai.setSelectedIndex(3);
        }
        String soluong = tblyeucau.getValueAt(index, 6) != null ? tblyeucau.getValueAt(index, 6).toString() : "1";
        txtsoluong.setText(soluong);

        String tongtien = tblyeucau.getValueAt(index, 7) != null ? tblyeucau.getValueAt(index, 7).toString() : "1";
        txttongtien.setText(tongtien);

        String lido = tblyeucau.getValueAt(index, 8) != null ? tblyeucau.getValueAt(index, 8).toString() : "1";
        txtLiDo.setText(lido);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMaKhachHang = new javax.swing.JTextField();
        txtMaSanPham = new javax.swing.JTextField();
        cboTrangThai = new javax.swing.JComboBox<>();
        txtMapd = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtNgayDoiTra = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtLiDo = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        txtmahd = new javax.swing.JTextField();
        btnxoa = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtsoluong = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txttongtien = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblyeucau = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(51, 255, 255));

        jLabel2.setText("MA HD");

        jLabel3.setText("TEN KHACH HANG");

        jLabel5.setText("MA SAN PHAM");

        jLabel6.setText("NGAY TAO");

        jLabel7.setText("TRANG THAI");

        jLabel8.setText("LI DO");

        txtMaKhachHang.setBackground(new java.awt.Color(223, 223, 223));

        txtMaSanPham.setBackground(new java.awt.Color(223, 223, 223));

        cboTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang xử lí", "Chờ xác nhận", "Hoàn thành", "Hủy" }));

        txtMapd.setBackground(new java.awt.Color(223, 223, 223));

        txtLiDo.setColumns(20);
        txtLiDo.setRows(5);
        jScrollPane1.setViewportView(txtLiDo);

        jLabel10.setText("MA PD");

        txtmahd.setBackground(new java.awt.Color(223, 223, 223));
        txtmahd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmahdActionPerformed(evt);
            }
        });

        btnxoa.setText("XÓA");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        jLabel11.setText("SO LUONG");

        jButton1.setText("CẬP NHẬT ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel12.setText("TONG TIEN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(btnxoa, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(199, 199, 199))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(579, 579, 579))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtsoluong))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMapd, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                    .addComponent(txtMaKhachHang)
                                    .addComponent(txtNgayDoiTra)))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtmahd, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                            .addComponent(txtMaSanPham)
                            .addComponent(cboTrangThai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txttongtien))))
                .addGap(17, 17, 17))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMapd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel2)
                            .addComponent(txtmahd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(txtMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNgayDoiTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txttongtien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(txtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(118, 118, 118)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnxoa)
                            .addComponent(jButton1)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("TẠO YÊU CẦU ĐỔI");

        tblyeucau.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "MA YEU CAU", "MA HD", "MA KHACH HANG", "MA SAN PHAM", "NGAY YEU CAU", "TRANG THAI", "SO LUONG", "TONG TIEN", "LI DO"
            }
        ));
        tblyeucau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblyeucauMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblyeucau);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtmahdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmahdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmahdActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
//         TODO add your handling code here:
//        try {
//            int check = JOptionPane.showConfirmDialog(this, "ban co chac chan muon xoa");
//            if (check != JOptionPane.YES_OPTION) {
//                return;
//            }
//            String ma = txtMapd.getText();
//            if (sv.deleteNhanVien(ma) != null) {
//                JOptionPane.showMessageDialog(this, "xoa thanh cong");
//            } else {
//                JOptionPane.showMessageDialog(this, "xoa that bai");
//            }
//
//        } catch (Exception e) {
//        }
        xoaDuLieu();
        fillTable();
    }//GEN-LAST:event_btnxoaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        suaDuLieu();
        fillTable();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblyeucauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblyeucauMouseClicked
        //TODO add your handling code here:
        try {
            index = tblyeucau.getSelectedRow();
            setModel();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "loi index");
        }
    }//GEN-LAST:event_tblyeucauMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormTaoYeuCau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTaoYeuCau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTaoYeuCau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTaoYeuCau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormTaoYeuCau dialog = new FormTaoYeuCau(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnxoa;
    private javax.swing.JComboBox<String> cboTrangThai;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblyeucau;
    private javax.swing.JTextArea txtLiDo;
    private javax.swing.JTextField txtMaKhachHang;
    private javax.swing.JTextField txtMaSanPham;
    private javax.swing.JTextField txtMapd;
    private javax.swing.JTextField txtNgayDoiTra;
    private javax.swing.JTextField txtmahd;
    private javax.swing.JTextField txtsoluong;
    private javax.swing.JTextField txttongtien;
    // End of variables declaration//GEN-END:variables
}
