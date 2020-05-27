/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlykitucxa;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author hieuuu
 */
public class DangNhapScreen extends javax.swing.JFrame {

    /**
     * Creates new form dangKiScreen
     */
    public DangNhapScreen() {
        initComponents();
        setTitle("Quản lý kí túc xá");
        this.setLocationRelativeTo(null);

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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfMatKhau = new javax.swing.JPasswordField();
        tfTaiKhoan = new javax.swing.JTextField();
        btnDangNhap = new javax.swing.JButton();
        btnQuenMatKhau = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlykitucxa/images/logo_login.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(200, 160, 157, 160);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlykitucxa/images/bg_login.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, -30, 540, 330);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("ĐẠI HỌC CÔNG NGHIỆP HÀ NỘI");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(130, 330, 310, 22);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Hanoi University of Industry");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(170, 360, 210, 22);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Tài khoản:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(90, 410, 60, 17);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Mật khẩu:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(90, 440, 70, 17);
        getContentPane().add(tfMatKhau);
        tfMatKhau.setBounds(160, 440, 240, 20);
        getContentPane().add(tfTaiKhoan);
        tfTaiKhoan.setBounds(160, 410, 240, 20);

        btnDangNhap.setBackground(new java.awt.Color(0, 51, 255));
        btnDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        btnDangNhap.setText("ĐĂNG NHẬP");
        getContentPane().add(btnDangNhap);
        btnDangNhap.setBounds(90, 480, 170, 23);

        btnQuenMatKhau.setText("QUÊN MẬT KHẨU");
        btnQuenMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuenMatKhauActionPerformed(evt);
            }
        });
        getContentPane().add(btnQuenMatKhau);
        btnQuenMatKhau.setBounds(260, 480, 160, 23);

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setText("ĐĂNG KÝ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(190, 520, 170, 23);

        setBounds(0, 0, 556, 659);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String[] options = {"Sinh viên", "Cán bộ quản lý"};
        //Integer[] options = {1, 3, 5, 7, 9, 11};
        //Double[] options = {3.141, 1.618};
        //Character[] options = {'a', 'b', 'c', 'd'};
        int x = JOptionPane.showOptionDialog(null, "Bạn là Sinh viên hay Cán bộ quản lý?",
                "Thông báo",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if (x == 0) {
            SinhVienDangKyScreen sv = new SinhVienDangKyScreen();
            sv.setVisible(true);
            this.dispose();
        } else if (x == 1) {
            CanBoDangKyScreen cb = new CanBoDangKyScreen();
            cb.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnQuenMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuenMatKhauActionPerformed
        // TODO add your handling code here:
        String[] options = {"Sinh viên", "Cán bộ quản lý"};
        //Integer[] options = {1, 3, 5, 7, 9, 11};
        //Double[] options = {3.141, 1.618};
        //Character[] options = {'a', 'b', 'c', 'd'};
        int x = JOptionPane.showOptionDialog(null, "Bạn là Sinh viên hay Cán bộ quản lý?",
                "Thông báo",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if (x == 0) {
            //sinh vien

            String s = JOptionPane.showInputDialog(this, "Nhập tài khoản của bạn!",
                    "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            if (s.equals("user01") || s.equals("user02")) {
                String m = JOptionPane.showInputDialog(this, "Nhập số điện thoại bạn đã đăng ký!",
                        "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(this, "Mật khẩu mới đã được gửi về số điện thoại của bạn!", "Thông báo", JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Không tồn tại tài khoản bạn vừa nhập!", "Thông báo", JOptionPane.PLAIN_MESSAGE);
            }
        } else if (x == 1) {
            //can bo
            String s = JOptionPane.showInputDialog(this, "Nhập tài khoản của bạn!",
                    "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            if (s.equals("admin01") || s.equals("admin02")) {
                String m = JOptionPane.showInputDialog(this, "Nhập mã đăng ký của bạn!",
                        "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                if (m.equals("abc123")) {
                    JOptionPane.showMessageDialog(this, "Mật khẩu mới của bạn là np1305!", "Thông báo", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Sai mã đăng ký!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(this, "Không tồn tại tài khoản bạn vừa nhập!", "Thông báo", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnQuenMatKhauActionPerformed

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
            java.util.logging.Logger.getLogger(DangNhapScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangNhapScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangNhapScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhapScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangNhapScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JButton btnQuenMatKhau;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField tfMatKhau;
    private javax.swing.JTextField tfTaiKhoan;
    // End of variables declaration//GEN-END:variables
}
