/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.DoiHang;
import Model.HoaDon;
import Service.DBContext1;
import Service.DoiTraSevice;
import java.beans.Statement;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class FormDoi extends javax.swing.JFrame {

    DoiTraSevice sv = new DoiTraSevice();
    DefaultTableModel tblModel = new DefaultTableModel();
    int index = 0;

    /**
     * Creates new form FormDoi
     */
    public FormDoi() {
        initComponents();
        fillTableHD();
        fillTable();
    }

    public void fillTable() {
        tblModel = (DefaultTableModel) tbltatca.getModel();
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
                dh.getLiDo()
            });
        }

    }

    public void fillTableHD() {
        tblModel = (DefaultTableModel) tblhoadon.getModel();
        ArrayList<HoaDon> list = sv.getAllHoaDon();
        tblModel.setRowCount(0);
        for (HoaDon hd : list) {
            tblModel.addRow(new Object[]{
                hd.getMaHD(),
                hd.getTenKH(),
                hd.getMaSP(),
                hd.getSoLuong(),
                hd.getNgayMua(),
                hd.getTongTien(),
                hd.getTrangThai()
            });
        }

    }

    public void timPD() {
        tblModel = (DefaultTableModel) tblhoadon.getModel();
        String ma = txttim.getText().trim();
        ArrayList<HoaDon> list = sv.timPD(ma);
        tblModel.setRowCount(0);
        for (HoaDon hd : list) {
            tblModel.addRow(new Object[]{
                hd.getMaHD(),
                hd.getTenKH(),
                hd.getMaSP(),
                hd.getSoLuong(),
                hd.getNgayMua(),
                hd.getTongTien(),
                hd.getTrangThai()
            });
        }
        if (list.size() > 0) {
            JOptionPane.showMessageDialog(this, "Các yêu cấu tìm thấy");
            return;
        } else {
            JOptionPane.showMessageDialog(this, "khong co du lieu phu hop");
        }
    }

    public void timPDngay() {
        String ng = txttimngay.getText().trim();
        ArrayList<DoiHang> list = sv.timPDngay(ng);
        tblModel.setRowCount(0);
        for (DoiHang dh : list) {
            tblModel.addRow(new Object[]{
                dh.getMaPD(),
                dh.getMaKH(),
                dh.getTenYC(),
                dh.getMaSP(),
                dh.getNgayDoi(),
                dh.getTrangThai(),
                dh.getLiDo()
            });
        }
        if (list.size() > 0) {
            JOptionPane.showMessageDialog(this, "Các yêu cấu tìm thấy");
            return;
        } else {
            JOptionPane.showMessageDialog(this, "khong co du lieu phu hop");
        }
    }

    private void themVaoPhieuDoiTra(int selectedRow) {
        // Lấy dữ liệu từ dòng đã chọn trên bảng Hóa Đơn
        String maHD = (String) tblhoadon.getValueAt(selectedRow, 0);
        String tenKH = (String) tblhoadon.getValueAt(selectedRow, 1);
        String maSP = (String) tblhoadon.getValueAt(selectedRow, 2);
        String soLuong = (String) tblhoadon.getValueAt(selectedRow, 3);

        // Tạo đối tượng HoaDon từ dữ liệu
        HoaDon hoaDon = new HoaDon(maHD, tenKH, maSP, soLuong);

        // Thêm vào bảng Phiếu Đổi Trả (bạn cần thay thế bằng thêm vào cơ sở dữ liệu)
        themVaoBangPhieuDoiTra(hoaDon);
    }
//    private void themVaoBangPhieuDoiTra(HoaDon hoaDon) {
//    try {
//        // Kết nối đến cơ sở dữ liệu (điều này cần được thay đổi tùy thuộc vào loại cơ sở dữ liệu bạn đang sử dụng)
//        Connection connection = DBContext1.getConnection();
//
//        // Chuẩn bị câu lệnh SQL để thêm vào bảng PhieuDoiTra
//        String sql = "INSERT INTO ChiTietPhieuDoiTra (MaPhieuDoiTra, MaSanPham, SoLuong) VALUES (?,?, ?)";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        
//        preparedStatement1.setString(1, );
//        preparedStatement.setString(1, hoaDon.getMaSP());
//        preparedStatement.setString(2, hoaDon.getSoLuong());
//        
//        preparedStatement.executeUpdate();
//        preparedStatement.close();
//        connection.close(); 
//        
//        String sql1 = "INSERT INTO PhieuDoiTra (MaHoaDon, TenKhmachHang) VALUES (?, ?)";
//        PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
//        // Lấy thông tin từ đối tượng HoaDon và thiết lập giá trị cho các tham số trong câu lệnh SQL
////        preparedStatement1.setString(1, );
//        preparedStatement1.setString(1, hoaDon.getMaHD());
//        preparedStatement1.setString(2, hoaDon.getTenKH());
//   
//
//        // Thực hiện câu lệnh SQL để thêm vào bảng PhieuDoiTra
//        preparedStatement1.executeUpdate();
//
//        // Đóng các tài nguyên
//        preparedStatement1.close();
//        connection.close();
//
//        System.out.println("Thêm dữ liệu vào Bảng Phiếu Đổi Trả thành công.");
//    } catch (SQLException e) {
//        e.printStackTrace();
//        System.out.println("Thêm dữ liệu vào Bảng Phiếu Đổi Trả thất bại.");
//    }
//}

    private void themVaoBangPhieuDoiTra(HoaDon hoaDon) {
        String trangThai = "Chờ xác nhận";
        String liDo = JOptionPane.showInputDialog("Nhập lý do:");
        try {
            // Kết nối đến cơ sở dữ liệu (điều này cần được thay đổi tùy thuộc vào loại cơ sở dữ liệu bạn đang sử dụng)
            Connection connection = DBContext1.getConnection();

            // Chuẩn bị câu lệnh SQL để thêm vào bảng PhieuDoiTra
            String sql1 = "INSERT INTO PhieuDoiTra (MaHoaDon, TenKhachHang, NgayDoiTra, TrangThai) VALUES (?, ?, GETDATE(), ?)";
            PreparedStatement preparedStatement1 = connection.prepareStatement(sql1, new String[]{"MaPhieuDoiTra"});

            preparedStatement1.setString(1, hoaDon.getMaHD());
            preparedStatement1.setString(2, hoaDon.getTenKH());
            preparedStatement1.setString(3, trangThai);
//            String sql1 = "INSERT INTO PhieuDoiTra (MaHoaDon, TenKhachHang, NgayDoiTra) VALUES (?, ?, GETDATE())";
//            PreparedStatement preparedStatement1 = connection.prepareStatement(sql1, new String[]{"MaPhieuDoiTra"});
//
//            preparedStatement1.setString(1, hoaDon.getMaHD());
//            preparedStatement1.setString(2, hoaDon.getTenKH());

            // Thực hiện câu lệnh SQL để thêm vào bảng PhieuDoiTra
            preparedStatement1.executeUpdate();

            // Lấy mã tự sinh từ cơ sở dữ liệu
            ResultSet generatedKeys = preparedStatement1.getGeneratedKeys();

            if (generatedKeys.next()) {
                int maPhieuDoiTra = generatedKeys.getInt(1);

                // Chuẩn bị câu lệnh SQL để thêm vào bảng ChiTietPhieuDoiTra
                String sql2 = "INSERT INTO ChiTietPhieuDoiTra (MaPhieuDoiTra, MaSanPham, SoLuong,LiDo) VALUES (?, ?, ?,?)";
                PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);

                preparedStatement2.setInt(1, maPhieuDoiTra);
                preparedStatement2.setString(2, hoaDon.getMaSP());
                preparedStatement2.setString(3, hoaDon.getSoLuong());
                preparedStatement2.setString(4, liDo);

                // Thực hiện câu lệnh SQL để thêm vào bảng ChiTietPhieuDoiTra
                preparedStatement2.executeUpdate();

                // Đóng tài nguyên
                preparedStatement2.close();

                System.out.println("Thêm dữ liệu vào Bảng Phiếu Đổi Trả thành công.");
            } else {
                System.out.println("Thêm dữ liệu vào Bảng Phiếu Đổi Trả thất bại.");
            }

            // Đóng tài nguyên
            generatedKeys.close();
            preparedStatement1.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Thêm dữ liệu vào Bảng Phiếu Đổi Trả thất bại.");
        }
        fillTable();
    }

    void openTHEM() {
//        FormTaoYeuCau Form = new FormTaoYeuCau();
//        Form.setVisible(true);
        new FormTaoYeuCau(this, true).setVisible(true);
    }
//    void openXuLi() {
//        new FormDoi(this, true).set 
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        btnsuli = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblhoadon = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txttim = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txttimngay = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btndoihang = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbltatca = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 255));
        jLabel9.setText("QUẢN LÍ ĐỔI HÀNG");

        btnsuli.setText("XU LI");
        btnsuli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuliActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Hoa Don"));

        tblhoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "MA HD", "TEN KH", "MA SP", "SO LUONG", "NGAY MUA", "TONG TIEN", "TRẠNG THAI"
            }
        ));
        tblhoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblhoadonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblhoadon);

        jLabel1.setText("MA YEU CAU");

        jLabel2.setText("NGAY YEU CAU");

        txttimngay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttimngayActionPerformed(evt);
            }
        });

        jButton1.setText("TIM KIEM");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("TIM KIEM");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btndoihang.setText("ĐỔI HÀNG");
        btndoihang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndoihangActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Yeu cau doi"));

        tbltatca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "MA YEU CAU", "MA HD", "TEN KHACH HANG", "MA SAN PHAM", "NGAY YEU CAU", "TRANG THAI", "LI DO"
            }
        ));
        tbltatca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbltatcaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbltatcaMouseEntered(evt);
            }
        });
        jScrollPane3.setViewportView(tbltatca);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txttimngay, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txttim, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(408, 408, 408))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(360, 360, 360)
                .addComponent(btndoihang, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txttimngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txttim)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btndoihang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(341, 341, 341)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(360, 360, 360)
                .addComponent(btnsuli, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnsuli)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        timPD();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnsuliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuliActionPerformed
        // TODO add your handling code here:
        openTHEM();
        fillTable();
    }//GEN-LAST:event_btnsuliActionPerformed

    private void tbltatcaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbltatcaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tbltatcaMouseEntered

    private void tbltatcaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbltatcaMouseClicked
        // TODO add your handling code here:
        try {
            index = tbltatca.getSelectedRow();

            //            new FormXuLi(this, true).setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "loi index");
        }
    }//GEN-LAST:event_tbltatcaMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        timPDngay();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txttimngayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttimngayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttimngayActionPerformed

    private void tblhoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblhoadonMouseClicked
        // TODO add your handling code here:
        int selectedRow = tbltatca.getSelectedRow();
        if (selectedRow != -1) {
            String maHoaDon = tbltatca.getValueAt(selectedRow, 0).toString();
            String maKhachHang = tbltatca.getValueAt(selectedRow, 1).toString();
            String maSanPham = tbltatca.getValueAt(selectedRow, 2).toString();

            try {
                // Kết nối đến cơ sở dữ liệu
                Connection cn = DBContext1.getConnection();

                // Thêm vào bảng PhieuDoiTra
                String query = "INSERT INTO PhieuDoiTra (MaHoaDon, MaKhachHang, TenSanPham) VALUES (?, ?, ?)";
                PreparedStatement preparedStatement = cn.prepareStatement(query);

                preparedStatement.setString(1, maHoaDon);
                preparedStatement.setString(2, maKhachHang);
                preparedStatement.setString(3, maSanPham);

                preparedStatement.executeUpdate();

                // Lấy mã tự sinh từ cơ sở dữ liệu
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                int maPhieuDoiTra = -1;
                if (generatedKeys.next()) {
                    maPhieuDoiTra = generatedKeys.getInt(1);
                }

                // Đóng kết nối
                generatedKeys.close();
                preparedStatement.close();
                cn.close();

                // Cập nhật bảng đổi trả
                DefaultTableModel doiTraModel = (DefaultTableModel) tbltatca.getModel();
                Vector<String> rowData = new Vector<>();
                rowData.add(String.valueOf(maPhieuDoiTra));
                rowData.add(maHoaDon);
                rowData.add(maKhachHang);
                rowData.add(maSanPham);
                doiTraModel.addRow(rowData);
                doiTraModel.fireTableDataChanged();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_tblhoadonMouseClicked
    private List<Object[]> doiTraDataList;
    private void btndoihangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndoihangActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblhoadon.getSelectedRow();

        if (selectedRow != -1) {
            // Thực hiện thêm vào Phiếu Đổi Trả khi nhấn nút
            themVaoPhieuDoiTra(selectedRow);
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một dòng từ bảng Hóa Đơn.");
        }
//    int selectedRow = tbltatca.getSelectedRow();
//    if (selectedRow != -1) {
//        String maHoaDon = tbltatca.getValueAt(selectedRow, 0).toString();
//        String maKhachHang = tbltatca.getValueAt(selectedRow, 1).toString();
//        String maSanPham = tbltatca.getValueAt(selectedRow, 2).toString();
//
//        try {
//            // Kết nối đến cơ sở dữ liệu
//            Connection cn = DBContext1.getConnection();
//
//            // Thêm vào bảng PhieuDoiTra
//            String query = "INSERT INTO PhieuDoiTra (MaHoaDon, TenKhachHang, TenSanPham) VALUES (?, ?, ?)";
//            PreparedStatement preparedStatement = cn.prepareStatement(query);
//
//            preparedStatement.setString(1, maHoaDon);
//            preparedStatement.setString(2, maKhachHang);
//            preparedStatement.setString(3, maSanPham);
//
//            preparedStatement.executeUpdate();
//
//            // Lấy mã tự sinh từ cơ sở dữ liệu
//            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
//            int maPhieuDoiTra = -1;
//            if (generatedKeys.next()) {
//                maPhieuDoiTra = generatedKeys.getInt(1);
//            }
//
//            // Đóng kết nối
//            generatedKeys.close();
//            preparedStatement.close();
//            cn.close();
//
//            // Cập nhật bảng đổi trả
//            DefaultTableModel doiTraModel = (DefaultTableModel) tbltatca.getModel();
//            Vector<String> rowData = new Vector<>();
//            rowData.add(String.valueOf(maPhieuDoiTra));
//            rowData.add(maHoaDon);
//            rowData.add(maKhachHang);
//            rowData.add(maSanPham);
//            doiTraModel.addRow(rowData);
//            doiTraModel.fireTableDataChanged();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//        int selectedRow = tblhoadon.getSelectedRow();
//        if (selectedRow != -1) {
//            // Lấy thông tin từ dòng được chọn
//            Object[] rowData = {
//                tblhoadon.getValueAt(selectedRow, 0), // Mã HD
//                tblhoadon.getValueAt(selectedRow, 1), // Tên KH
//                tblhoadon.getValueAt(selectedRow, 2), // Tên SP
//            };
//
//            // Hiển thị thông tin lên bảng đổi trả (có thể làm thêm các xử lý khác)
//            DefaultTableModel doiTraModel = (DefaultTableModel) tbltatca.getModel();
//            doiTraModel.addRow(rowData);
//
////            doiTraDataList.add(rowData);
//            System.out.println(doiTraModel);
//            // Chỉ định vị trí mong muốn cho các cột trong bảng đổi trả
//            int rowIndex = doiTraModel.getRowCount() - 1;
//            tbltatca.setValueAt(rowData[0], rowIndex, 1);  // Mã HD
//            tbltatca.setValueAt(rowData[1], rowIndex, 2);  // Tên KH
//            tbltatca.setValueAt(rowData[2], rowIndex, 3);  // Tên SP
////                        tbltatca.setValueAt(rowData[3], rowIndex, 3);  // Số Lượng
////                        tbltatca.setValueAt(rowData[4], rowIndex, 4);  // Tổng Tiền
////                        tbltatca.setValueAt(rowData[5], rowIndex, 5);  // Trạng Thái
//            try {
//                int generatedKey = -1;
//                Connection cn = DBContext1.getConnection();
//
//                String query = "INSERT INTO PhieuDoiTra (MaHoaDon, TenKhachHang, TenSanPham) "
//                        + "VALUES ( ?, ?, ?)";
//                PreparedStatement preparedStatement = cn.prepareStatement(query);
//
//                preparedStatement.setString(1, rowData[0].toString()); // Tên KH
//                preparedStatement.setString(2, rowData[1].toString()); // Tên KH
//                preparedStatement.setString(3, rowData[2].toString()); // Tên SP
////                preparedStatement.setInt(3, Integer.parseInt(rowData[3].toString())); // Số Lượng
////                preparedStatement.setDouble(4, Double.parseDouble(rowData[4].toString())); // Tổng Tiền
////                preparedStatement.setString(5, rowData[5].toString()); // Trạng Thái
//
//                preparedStatement.executeUpdate();
//                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
//                if (generatedKeys.next()) {
//                    generatedKey = generatedKeys.getInt(1);
//                }
//            } catch (Exception e) {
//            }
//        }
    }//GEN-LAST:event_btndoihangActionPerformed

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
            java.util.logging.Logger.getLogger(FormDoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormDoi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndoihang;
    private javax.swing.JButton btnsuli;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblhoadon;
    private javax.swing.JTable tbltatca;
    private javax.swing.JTextField txttim;
    private javax.swing.JTextField txttimngay;
    // End of variables declaration//GEN-END:variables
}
