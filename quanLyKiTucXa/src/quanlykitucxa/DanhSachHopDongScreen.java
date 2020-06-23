/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlykitucxa;

import Process.HopDong;
import Process.Phong;
import Process.SinhVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hieuuu
 */
public class DanhSachHopDongScreen extends javax.swing.JFrame {

    /**
     * Creates new form DanhSachHopDongScreen
     */
    private int demSua = 0;
    private final HopDong hd = new HopDong();
    private final Phong phong = new Phong();
    private boolean cothem = true;
    private int loaiBang = -1;//1 la bang danh sach yeu cau dang ky, 2 là tất cả hợp đồng, 3 là danh sách hợp đồng sắp hết hạn
    private final SinhVien sv = new SinhVien();

    void setEdi(boolean bl) {
        tf_maHD.setEditable(bl);
        tf_maSV.setEditable(bl);
        dp_ngayBatDau.setEditable(bl);
        dp_ngayKetThuc.setEditable(bl);
        btn_chuaBiet.setEnabled(bl);
        btn_chuaCo.setEnabled(bl);
        btn_kyHD.setEnabled(bl);
        btn_xoaHD.setEnabled(bl);
        btn_timTheoMSV.setEnabled(bl);
    }

    public void setTenNutDanhSachYeuCauDangKy() {
        try {
            ResultSet rs1 = sv.DemSoLuongSVYeuCauKyHopDong();
            if (rs1.next()) {
                btn_danhSachYeuCauDangKy.setText("Danh sách yêu cầu đăng ký (" + rs1.getString("Tong") + ")");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhSachHopDongScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setTenNutTatCaHopDong() {
        try {
            ResultSet rs2 = hd.DemSoLuongHopDong();
            if (rs2.next()) {
                btn_tatCaHopDong.setText("Tất cả hợp đồng (" + rs2.getString("Tong") + ")");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhSachHopDongScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setTenNutHopDongSapHetHan() {
        try {
            ResultSet rs1 = hd.ShowDanhSachHopDong();

            int dem = 0;
            while (rs1.next()) {

                SimpleDateFormat ngay = new SimpleDateFormat("dd");
                SimpleDateFormat thang = new SimpleDateFormat("MM");
                SimpleDateFormat nam = new SimpleDateFormat("yyyy");

                java.util.Date KetThuc = rs1.getDate("NgayKetThuc");
                Date HienTai = new Date();

                int namHienTai = Integer.parseInt(nam.format(HienTai));
                int thangHienTai = Integer.parseInt(thang.format(HienTai));
                int ngayHienTai = Integer.parseInt(ngay.format(HienTai));

                int namKT = Integer.parseInt(nam.format(KetThuc));
                int thangKT = Integer.parseInt(thang.format(KetThuc));
                int ngayKT = Integer.parseInt(ngay.format(KetThuc));

                if (namKT == namHienTai && thangKT - thangHienTai <= 1) {

                    dem++;
                }
            }
            btn_hetHan.setText("Danh sách hợp đồng sắp hết hạn (" + dem + ")");
        } catch (SQLException ex) {
            Logger.getLogger(DanhSachHopDongScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setTenNutYeuCauGiaHan() {
        try {
            ResultSet rs2 = sv.DemSinhVienYeuCauGiaHan();
            if (rs2.next()) {
                btn_yeuCauGiaHan.setText("Danh sách yêu cầu gia hạn hợp đồng (" + rs2.getString("Tong") + ")");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhSachHopDongScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void showHopDongSapHetHan() {
        try {
            ResultSet rs1 = hd.ShowDanhSachHopDong();
            DefaultTableModel tableModel = new DefaultTableModel();
            String colsName[] = {"STT", "Mã hợp đồng", "Mã sinh viên", "Ngày bắt đầu", "Ngày kết thúc"};
            tableModel.setColumnIdentifiers(colsName);
            int dem = 0;
            while (rs1.next()) {

                SimpleDateFormat ngay = new SimpleDateFormat("dd");
                SimpleDateFormat thang = new SimpleDateFormat("MM");
                SimpleDateFormat nam = new SimpleDateFormat("yyyy");

                java.util.Date KetThuc = rs1.getDate("NgayKetThuc");
                Date HienTai = new Date();

                int namHienTai = Integer.parseInt(nam.format(HienTai));
                int thangHienTai = Integer.parseInt(thang.format(HienTai));
                int ngayHienTai = Integer.parseInt(ngay.format(HienTai));

                int namKT = Integer.parseInt(nam.format(KetThuc));
                int thangKT = Integer.parseInt(thang.format(KetThuc));
                int ngayKT = Integer.parseInt(ngay.format(KetThuc));

                if (namKT == namHienTai && thangKT - thangHienTai <= 1) {

                    String row[] = new String[5];
                    row[0] = ++dem + "";
                    row[1] = rs1.getString("MaHD");
                    row[3] = rs1.getDate("NgayBatDau").toString();
                    row[4] = rs1.getDate("NgayKetThuc").toString();
                    row[2] = rs1.getString("MaSV");
                    tableModel.addRow(row);
                }
            }
            jTable1.setModel(tableModel);
        } catch (SQLException ex) {
            Logger.getLogger(DanhSachHopDongScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DanhSachHopDongScreen() throws SQLException {
        initComponents();

        setTitle("Quản lý kí túc xá");
        this.setLocationRelativeTo(null);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        dp_ngayBatDau.setFormats(format);
        //  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        dp_ngayKetThuc.setFormats(format);
        tf_maHD.setEditable(false);
        tf_maSV.setEditable(false);
        dp_ngayBatDau.setEditable(false);
        dp_ngayKetThuc.setEditable(false);
        setEdi(false);
        setTenNutTatCaHopDong();
        setTenNutHopDongSapHetHan();
        setTenNutDanhSachYeuCauDangKy();
        setTenNutYeuCauGiaHan();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        try {
            jPanel1 =(javax.swing.JPanel)java.beans.Beans.instantiate(getClass().getClassLoader(), "quanlykitucxa.DanhSachHopDongScreen_jPanel1");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf_maSV = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        dp_ngayBatDau = new org.jdesktop.swingx.JXDatePicker();
        jLabel7 = new javax.swing.JLabel();
        dp_ngayKetThuc = new org.jdesktop.swingx.JXDatePicker();
        btn_kyHD = new javax.swing.JButton();
        btn_yeuCauGiaHan = new javax.swing.JButton();
        btn_chuaBiet = new javax.swing.JButton();
        btn_tatCaHopDong = new javax.swing.JButton();
        btn_hetHan = new javax.swing.JButton();
        btn_timTheoMSV = new javax.swing.JButton();
        btn_chuaCo = new javax.swing.JButton();
        btn_xoaHD = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        tf_maHD = new javax.swing.JTextField();
        btn_danhSachYeuCauDangKy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlykitucxa/images/logo_login.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 90, 1040, 150);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Quản lý hợp đồng thuê phòng ký túc xá");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 10, 1040, 70);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlykitucxa/images/bg_big.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(0, -30, 1040, 220);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1036, 260);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Mã hợp đồng:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 280, 78, 17);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Mã sinh viên:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(260, 280, 75, 17);
        getContentPane().add(tf_maSV);
        tf_maSV.setBounds(340, 270, 175, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 480, 1036, 180);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Ngày bắt đầu:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(520, 280, 78, 17);
        getContentPane().add(dp_ngayBatDau);
        dp_ngayBatDau.setBounds(600, 270, 164, 30);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Ngày kết thúc:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(770, 280, 83, 17);
        getContentPane().add(dp_ngayKetThuc);
        dp_ngayKetThuc.setBounds(860, 270, 173, 30);

        btn_kyHD.setText("Ký hợp đồng");
        btn_kyHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kyHDActionPerformed(evt);
            }
        });
        getContentPane().add(btn_kyHD);
        btn_kyHD.setBounds(30, 370, 320, 39);

        btn_yeuCauGiaHan.setText("Yêu cầu ra hạn");
        btn_yeuCauGiaHan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_yeuCauGiaHanActionPerformed(evt);
            }
        });
        getContentPane().add(btn_yeuCauGiaHan);
        btn_yeuCauGiaHan.setBounds(370, 370, 320, 39);
        getContentPane().add(btn_chuaBiet);
        btn_chuaBiet.setBounds(710, 420, 290, 40);

        btn_tatCaHopDong.setText("Tất cả hợp đồng");
        btn_tatCaHopDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tatCaHopDongActionPerformed(evt);
            }
        });
        getContentPane().add(btn_tatCaHopDong);
        btn_tatCaHopDong.setBounds(370, 320, 320, 40);

        btn_hetHan.setText("Danh sách hợp đồng sắp hết hạn");
        btn_hetHan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hetHanActionPerformed(evt);
            }
        });
        getContentPane().add(btn_hetHan);
        btn_hetHan.setBounds(710, 320, 290, 40);

        btn_timTheoMSV.setText("Tìm kiếm theo mã sinh viên");
        btn_timTheoMSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timTheoMSVActionPerformed(evt);
            }
        });
        getContentPane().add(btn_timTheoMSV);
        btn_timTheoMSV.setBounds(30, 420, 320, 39);

        btn_chuaCo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chuaCoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_chuaCo);
        btn_chuaCo.setBounds(370, 420, 320, 39);

        btn_xoaHD.setText("Xóa hợp đồng");
        btn_xoaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaHDActionPerformed(evt);
            }
        });
        getContentPane().add(btn_xoaHD);
        btn_xoaHD.setBounds(710, 370, 290, 39);

        jButton9.setText("Quay lại");
        getContentPane().add(jButton9);
        jButton9.setBounds(480, 670, 90, 23);
        getContentPane().add(tf_maHD);
        tf_maHD.setBounds(90, 270, 157, 30);

        btn_danhSachYeuCauDangKy.setText("Danh sách yêu cầu của sinh viên");
        btn_danhSachYeuCauDangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_danhSachYeuCauDangKyActionPerformed(evt);
            }
        });
        getContentPane().add(btn_danhSachYeuCauDangKy);
        btn_danhSachYeuCauDangKy.setBounds(30, 320, 320, 40);

        setBounds(0, 0, 1052, 778);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
        if (loaiBang == 1 || loaiBang == 4) {
            int row = this.jTable1.getSelectedRow();
            String maSV = (String) jTable1.getModel().getValueAt(row, 1);
            tf_maSV.setText(maSV);
            int x = JOptionPane.showConfirmDialog(this, "Xem thông tin sinh viên này?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (x == 0) {
                try {
                    // TODO add your handling code here:

                    ThongTinSinhVienScreen a = new ThongTinSinhVienScreen(maSV, 2);
                    a.setVisible(true);

                } catch (SQLException ex) {
                    Logger.getLogger(DanhSachHopDongScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if (loaiBang == 2 || loaiBang == 3) {
            int row = this.jTable1.getSelectedRow();
            String maSV = (String) jTable1.getModel().getValueAt(row, 2);
            tf_maSV.setText(maSV);
            String[] options = {"Thông tin sinh viên", "Thông tin hợp đồng"};
            int x = JOptionPane.showOptionDialog(null, "Bạn muốn xem thông tin nào?",
                    "Thông báo",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            if (x == 0) {
                try {
                    ThongTinSinhVienScreen a = new ThongTinSinhVienScreen(maSV, 2);
                    a.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(DanhSachHopDongScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (x == 1){
                JOptionPane.showMessageDialog(this, "hợp đồng", "Thông báo", JOptionPane.PLAIN_MESSAGE);
            }
        }


    }//GEN-LAST:event_jTable1MouseClicked

    private void btn_tatCaHopDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tatCaHopDongActionPerformed
        loaiBang = 2;
        try {
            ResultSet rs1 = hd.ShowDanhSachHopDong();
            DefaultTableModel tableModel = new DefaultTableModel();
            String colsName[] = {"STT", "Mã hợp đồng", "Mã sinh viên", "Ngày bắt đầu", "Ngày kết thúc"};
            tableModel.setColumnIdentifiers(colsName);
            int dem = 0;
            while (rs1.next()) {

                String row[] = new String[5];
                row[0] = ++dem + "";
                row[1] = rs1.getString("MaHD");
                row[3] = rs1.getDate("NgayBatDau").toString();
                row[4] = rs1.getDate("NgayKetThuc").toString();
                row[2] = rs1.getString("MaSV");
                tableModel.addRow(row);

            }
            jTable1.setModel(tableModel);
        } catch (SQLException ex) {
            Logger.getLogger(DanhSachHopDongScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_tatCaHopDongActionPerformed

    private void btn_danhSachYeuCauDangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_danhSachYeuCauDangKyActionPerformed
        loaiBang = 1;
        try {
            // TODO add your handling code here:
            ResultSet rs1 = sv.ShowSinhVienChuaKyHopDong();
            DefaultTableModel tableModel = new DefaultTableModel();
            String colsName[] = {"STT", "Mã sinh viên", "Tên sinh viên"};
            tableModel.setColumnIdentifiers(colsName);
            int dem = 0;
            while (rs1.next()) {
                String[] row = new String[3];
                row[0] = ++dem + "";
                row[1] = rs1.getString("MaSV");
                row[2] = rs1.getString("HoTen");
                tableModel.addRow(row);
            }

            jTable1.setModel(tableModel);
        } catch (SQLException ex) {
            Logger.getLogger(DanhSachHopDongScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_danhSachYeuCauDangKyActionPerformed

    private void btn_timTheoMSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timTheoMSVActionPerformed

        // TODO add your handling code here:
        if (loaiBang == -1) {
            JOptionPane.showMessageDialog(this, "Chưa chọn loại danh sách muốn xem!", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
        if (loaiBang == 1) {

            tf_maSV.setEditable(true);
            btn_kyHD.setText("Tìm");
            if (tf_maSV.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Hãy nhập mã sinh viên cần tìm!", "Thông báo", JOptionPane.PLAIN_MESSAGE);
            } else {
                try {
                    // TODO add your handling code here:
                    ResultSet rs1 = sv.ShowSinhVienTheoMaSV(tf_maSV.getText());
                    DefaultTableModel tableModel = new DefaultTableModel();
                    String colsName[] = {"STT", "Mã sinh viên", "Tên sinh viên"};
                    tableModel.setColumnIdentifiers(colsName);
                    int dem = 0;
                    while (rs1.next()) {
                        String[] row = new String[3];
                        row[0] = ++dem + "";
                        row[1] = rs1.getString("MaSV");
                        row[2] = rs1.getString("HoTen");
                        tableModel.addRow(row);
                    }

                    jTable1.setModel(tableModel);
                } catch (SQLException ex) {
                    Logger.getLogger(DanhSachHopDongScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
                int x = JOptionPane.showConfirmDialog(this, "Bạn còn muốn tiếp tục tìm kiếm thông tin?", "Thông báo", JOptionPane.YES_NO_OPTION);
                if (x == 1) {
                    tf_maSV.setEditable(false);
                    btn_kyHD.setText("Tìm kiếm theo mã sinh viên");
                }
            }

        }
    }//GEN-LAST:event_btn_timTheoMSVActionPerformed

    private void btn_chuaCoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chuaCoActionPerformed
        // TODO add your handling code here:
        btn_danhSachYeuCauDangKy.setEnabled(false);
        demSua++;
        if (demSua % 2 == 1) {
            setEdi(true);
            btn_chuaCo.setText("Lưu");
        } else {
            int x = JOptionPane.showConfirmDialog(this, "Bạn đã chắc chắn sửa đúng thông tin?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (x == 0) {
                toast t = new toast("Sửa thành công!", 600, 650);

                // call the method 
                btn_chuaCo.setText("Sửa hợp đồng");
                t.showtoast();
                setEdi(false);

            }
        }
    }//GEN-LAST:event_btn_chuaCoActionPerformed

    private void btn_hetHanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hetHanActionPerformed
        // TODO add your handling code here:
        /* demHetHan++;
        if (demHetHan % 2 == 1) {
            btn_hetHan.setText("Gửi thông báo");

        } else {
            toast t = new toast("Gửi thành công!", 600, 650);

            // call the method
            btn_hetHan.setText("Hiển thị danh sách hợp đồng sắp hết hạn");
            t.showtoast();

        }*/
        loaiBang = 3;
        showHopDongSapHetHan();
    }//GEN-LAST:event_btn_hetHanActionPerformed

    private void btn_xoaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaHDActionPerformed
        // TODO add your handling code here:
        int x = JOptionPane.showConfirmDialog(this, "Đồng ý xóa hợp đồng?", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (x == 0) {
            toast t = new toast("Xóa thành công!", 600, 650);

            // call the method 
            t.showtoast();
        }

        //setEdi(false);

    }//GEN-LAST:event_btn_xoaHDActionPerformed

    private void btn_kyHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kyHDActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btn_kyHDActionPerformed

    private void btn_yeuCauGiaHanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_yeuCauGiaHanActionPerformed
        // TODO add your handling code here:
        loaiBang = 4;
        try {
            // TODO add your handling code here:
            ResultSet rs1 = sv.ShowSinhVienYeuCauGiaHan();
            DefaultTableModel tableModel = new DefaultTableModel();
            String colsName[] = {"STT", "Mã sinh viên", "Tên sinh viên", "Số tháng muốn gia hạn"};
            tableModel.setColumnIdentifiers(colsName);
            int dem = 0;
            while (rs1.next()) {
                String[] row = new String[4];
                row[0] = ++dem + "";
                row[1] = rs1.getString("MaSV");
                row[2] = rs1.getString("HoTen");
                row[3] = rs1.getInt("YeuCauGiaHan") + "";
                tableModel.addRow(row);
            }

            jTable1.setModel(tableModel);
        } catch (SQLException ex) {
            Logger.getLogger(DanhSachHopDongScreen.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btn_yeuCauGiaHanActionPerformed

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
            java.util.logging.Logger.getLogger(DanhSachHopDongScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DanhSachHopDongScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DanhSachHopDongScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DanhSachHopDongScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new DanhSachHopDongScreen().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(DanhSachHopDongScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_chuaBiet;
    private javax.swing.JButton btn_chuaCo;
    private javax.swing.JButton btn_danhSachYeuCauDangKy;
    private javax.swing.JButton btn_hetHan;
    private javax.swing.JButton btn_kyHD;
    private javax.swing.JButton btn_tatCaHopDong;
    private javax.swing.JButton btn_timTheoMSV;
    private javax.swing.JButton btn_xoaHD;
    private javax.swing.JButton btn_yeuCauGiaHan;
    private org.jdesktop.swingx.JXDatePicker dp_ngayBatDau;
    private org.jdesktop.swingx.JXDatePicker dp_ngayKetThuc;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField tf_maHD;
    private javax.swing.JTextField tf_maSV;
    // End of variables declaration//GEN-END:variables
}
