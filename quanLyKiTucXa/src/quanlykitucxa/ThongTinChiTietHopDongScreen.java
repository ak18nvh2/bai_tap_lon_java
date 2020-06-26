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
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author hieuuu
 */
public class ThongTinChiTietHopDongScreen extends javax.swing.JFrame {

    /**
     * Creates new form ThongTinChiTietHopDongScreen
     */
    private final SinhVien sv = new SinhVien();
    private final Phong p = new Phong();
    private final HopDong hd = new HopDong();
    private String maSV;
    private String tenPhong;
    private String ngayBD, ngayKT;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public void showw(String maSV) throws ParseException, SQLException {
        ResultSet rs3 = hd.ShowHopDongTheoMaSV(maSV);
        if (noiDen==9 && rs3.next()) {
            ResultSet rs1 = sv.ShowSinhVienTheoMaSV(maSV);
            while (rs1.next()) {
                lb_benB.setText("Bên B: " + rs1.getString("HoTen"));
                lb_kyTen.setText(rs1.getString("HoTen"));
                lb_loaiPhong.setText("Loại phòng đăng ký: " + rs1.getString("LoaiPhong"));
                dp_ngayBd.setDate(rs3.getDate("NgayBatDau"));
                dp_ngayKt.setDate(rs3.getDate("NgayKetThuc"));
                lb_tenPhong.setText("Tên phòng: " + rs1.getString("TenPhong"));
                SimpleDateFormat thang = new SimpleDateFormat("MM");
                SimpleDateFormat nam = new SimpleDateFormat("yyyy");
                int namHienTai = Integer.parseInt(nam.format(rs3.getDate("NgayBatDau")));
                int thangHienTai = Integer.parseInt(thang.format(rs3.getDate("NgayBatDau")));
                int thangkt = Integer.parseInt(thang.format(rs3.getDate("NgayKetThuc")));
                int namkt = Integer.parseInt(nam.format(rs3.getDate("NgayKetThuc")));
                int thangDki= (namkt-namHienTai)*12 + (thangkt-thangHienTai);
                System.out.println(namkt+" "+namHienTai);
                System.out.println(thangkt+" "+thangHienTai);
                ResultSet rs2= p.ShowPhongConTrongTheoLoaiPhong(rs1.getString("LoaiPhong"));
                if(rs2.next()){
                    DecimalFormat df = new DecimalFormat("#,###,##0.000 VNĐ");
                    System.out.println(rs2.getInt("DonGia") + " "+thangDki);
                    lb_giaTien.setText("Đơn giá: " + df.format(rs2.getInt("DonGia")*thangDki));
                }
            }
        } else {
            try {
                ResultSet rs1 = sv.ShowSinhVienTheoMaSV(maSV);
                while (rs1.next()) {
                    lb_benB.setText("Bên B: " + rs1.getString("HoTen"));
                    lb_kyTen.setText(rs1.getString("HoTen"));
                    lb_loaiPhong.setText("Loại phòng đăng ký: " + rs1.getString("LoaiPhong"));
                    Date HienTai = new Date();
                    dp_ngayBd.setDate(HienTai);
                    this.ngayBD = this.format.format(HienTai).toString();
                    SimpleDateFormat ngay = new SimpleDateFormat("dd");
                    SimpleDateFormat thang = new SimpleDateFormat("MM");
                    SimpleDateFormat nam = new SimpleDateFormat("yyyy");

                    int namHienTai = Integer.parseInt(nam.format(HienTai));
                    int thangHienTai = Integer.parseInt(thang.format(HienTai));
                    int ngayHienTai = Integer.parseInt(ngay.format(HienTai));
                    int thangThue = rs1.getInt("YeuCauGiaHan");

                    int thangkt = 0;
                    int namkt = 0;
                    if (thangThue + thangHienTai >= 12) {
                        thangkt = (thangThue + thangHienTai) % 12;
                        namkt = namHienTai + (thangThue + thangHienTai) / 12;
                    } else {
                        thangkt = thangThue + thangHienTai;
                        namkt = namHienTai;
                    }
                    String kthuc = namkt + "-" + thangkt + "-" + ngayHienTai;
                    this.ngayKT = kthuc;
                    Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(kthuc);
                    dp_ngayKt.setDate(date1);

                    ResultSet rs2 = p.ShowPhongConTrongTheoLoaiPhong(rs1.getString("LoaiPhong"));
                    if (rs2.next()) {
                        lb_tenPhong.setText("Tên phòng: " + rs2.getString("TenPhong"));
                        this.tenPhong = rs2.getString("TenPhong");
                    }
                    DecimalFormat df = new DecimalFormat("#,###,##0.000 VNĐ");
                    lb_giaTien.setText("Đơn giá: " + df.format(rs2.getInt("DonGia") * thangThue));

                }
            } catch (SQLException ex) {
                Logger.getLogger(ThongTinChiTietHopDongScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    private int noiDen;

    public ThongTinChiTietHopDongScreen(String maSV, int noiDen) throws ParseException, SQLException {
        initComponents();
        setTitle("Quản lý kí túc xá");
        this.setLocationRelativeTo(null);
        this.maSV = maSV;
        showw(maSV);
        this.noiDen = noiDen;
        if (noiDen == 1 || noiDen==9) {
            btn_kyHD.setEnabled(false);
        }
        dp_ngayBd.setFormats(format);
        //  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        dp_ngayKt.setFormats(format);
        dp_ngayBd.setEditable(false);
        dp_ngayKt.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lb_benB = new javax.swing.JLabel();
        lb_loaiPhong = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dp_ngayBd = new org.jdesktop.swingx.JXDatePicker();
        jLabel8 = new javax.swing.JLabel();
        dp_ngayKt = new org.jdesktop.swingx.JXDatePicker();
        lb_tenPhong = new javax.swing.JLabel();
        lb_giaTien = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lb_kyTen = new javax.swing.JLabel();
        btn_kyHD = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlykitucxa/images/logo_login.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(240, 140, 160, 170);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Thông tin chi tiết hợp đồng");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 60, 660, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlykitucxa/images/bg_big.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, -20, 660, 250);

        jLabel4.setText("Bên A: Trường Đại học Công Nghiệp Hà Nội");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 340, 360, 20);

        lb_benB.setText("Bên B: Nguyễn Trung Minh Hiếu");
        getContentPane().add(lb_benB);
        lb_benB.setBounds(410, 340, 210, 20);

        lb_loaiPhong.setText("Loại phòng đăng ký: Chất lượng cao");
        getContentPane().add(lb_loaiPhong);
        lb_loaiPhong.setBounds(30, 380, 290, 20);

        jLabel7.setText("Ngày bắt đầu: ");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(30, 420, 80, 14);
        getContentPane().add(dp_ngayBd);
        dp_ngayBd.setBounds(110, 420, 210, 22);

        jLabel8.setText("Ngày kết thúc:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(30, 460, 80, 20);
        getContentPane().add(dp_ngayKt);
        dp_ngayKt.setBounds(110, 460, 210, 22);

        lb_tenPhong.setText("Tên phòng: ");
        getContentPane().add(lb_tenPhong);
        lb_tenPhong.setBounds(30, 500, 290, 14);

        lb_giaTien.setText("Giá tiền: ");
        getContentPane().add(lb_giaTien);
        lb_giaTien.setBounds(30, 540, 290, 14);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Ký tên");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(20, 570, 170, 14);

        jLabel12.setText("Trường đại học Công Nghiệp Hà Nội");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(20, 600, 220, 14);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Ký tên");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(440, 570, 170, 14);

        lb_kyTen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_kyTen.setText("Nguyễn Trung Minh Hiếu");
        getContentPane().add(lb_kyTen);
        lb_kyTen.setBounds(440, 600, 170, 14);

        btn_kyHD.setText("Ký hợp đồng");
        btn_kyHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kyHDActionPerformed(evt);
            }
        });
        getContentPane().add(btn_kyHD);
        btn_kyHD.setBounds(80, 650, 190, 23);

        jButton2.setText("Quay lại");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(360, 650, 200, 23);

        setBounds(0, 0, 673, 758);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        this.dispose();
        if(noiDen!=9){
        DanhSachHopDongScreen a = new DanhSachHopDongScreen(noiDen);
        a.setVisible(true);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_kyHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kyHDActionPerformed
        try {
            // TODO add your handling code here:
            int x = JOptionPane.showConfirmDialog(this, "Đồng ý ký hợp đồng?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (x == 0) {

                hd.InsertNewData(maSV, ngayBD, ngayKT);

                sv.setHoanThanhDangKy(this.tenPhong, this.maSV);
                p.TangThanhVienTrongPhong(this.tenPhong);
                JOptionPane.showMessageDialog(this, "Ký hợp đồng thành công!", "Thông báo", JOptionPane.PLAIN_MESSAGE);
                this.dispose();
                DanhSachHopDongScreen a = new DanhSachHopDongScreen(1);
                a.setVisible(true);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ThongTinChiTietHopDongScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_kyHDActionPerformed

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
            java.util.logging.Logger.getLogger(ThongTinChiTietHopDongScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongTinChiTietHopDongScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongTinChiTietHopDongScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongTinChiTietHopDongScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ThongTinChiTietHopDongScreen("2017600000", 1).setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(ThongTinChiTietHopDongScreen.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(ThongTinChiTietHopDongScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_kyHD;
    private org.jdesktop.swingx.JXDatePicker dp_ngayBd;
    private org.jdesktop.swingx.JXDatePicker dp_ngayKt;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lb_benB;
    private javax.swing.JLabel lb_giaTien;
    private javax.swing.JLabel lb_kyTen;
    private javax.swing.JLabel lb_loaiPhong;
    private javax.swing.JLabel lb_tenPhong;
    // End of variables declaration//GEN-END:variables
}
