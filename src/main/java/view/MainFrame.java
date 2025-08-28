package view;

import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;


public class MainFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;

    public MainFrame() {
        setTitle("Quản Lý Tiệm Giặt Là");
        setSize(900, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo menu bar
        JMenuBar menuBar = new JMenuBar();

        // Menu Khách hàng
        JMenu menuKhachHang = new JMenu("Khách hàng");
        JMenuItem qlKhachHang = new JMenuItem("Quản lý khách hàng");

        // Menu Đơn hàng
        JMenu menuDonHang = new JMenu("Đơn hàng");
        JMenuItem qlDonHang = new JMenuItem("Quản lý đơn hàng");

        // Menu Dịch vụ
        JMenu menuDichVu = new JMenu("Dịch vụ");
        JMenuItem qlDichVu = new JMenuItem("Quản lý dịch vụ");

        // Menu Thống kê
        JMenu menuThongKe = new JMenu("Thống kê");
        JMenuItem tkDoanhThu = new JMenuItem("Doanh thu");
        JMenuItem tkDonHang = new JMenuItem("Đơn hàng theo ngày");
        
        // Menu Thanh toán
        JMenu menuThanhToan = new JMenu("Thanh toán");
        JMenuItem thanhToanHoaDon = new JMenuItem("Thanh toán hóa đơn");
        
        // Menu Tra cứu
        JMenu menuTraCuu = new JMenu("Tra cứu");
        JMenuItem traCuuDonHang = new JMenuItem("Tra cứu đơn hàng");

        // Gắn item vào menu
        menuKhachHang.add(qlKhachHang);
        menuDonHang.add(qlDonHang);
        menuDichVu.add(qlDichVu);
        menuThongKe.add(tkDoanhThu);
        menuThongKe.add(tkDonHang);
        menuThanhToan.add(thanhToanHoaDon);
        menuTraCuu.add(traCuuDonHang);

        // Gắn menu vào menu bar
        menuBar.add(menuKhachHang);
        menuBar.add(menuDonHang);
        menuBar.add(menuDichVu);
        menuBar.add(menuThongKe);
        menuBar.add(menuThanhToan);
        menuBar.add(menuTraCuu);
        setJMenuBar(menuBar);

        // Panel chính dùng CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Thêm các panel chức năng (cần tạo các class Panel tương ứng)
        mainPanel.add(new QuanLyKhachHang(), "QL_KHACHHANGDAO");
        mainPanel.add(new QuanLyDonHang(), "QL_DONHANG");
        mainPanel.add(new QuanLyDichVu(), "QL_DICHVU");
        mainPanel.add(new ThongKeDoanhThu(), "TK_DOANHTHU");
        mainPanel.add(new ThongKeDonHang(), "TK_DONHANG");
        mainPanel.add(new ThanhToanHoaDon(), "TT_HOADON");
        mainPanel.add(new TraCuuDonHang(), "TC_DONHANG");


        add(mainPanel, BorderLayout.CENTER);

        // Xử lý sự kiện menu
        qlKhachHang.addActionListener(e -> cardLayout.show(mainPanel, "QL_KHACHHANG"));
        qlDonHang.addActionListener(e -> cardLayout.show(mainPanel, "QL_DONHANG"));
        qlDichVu.addActionListener(e -> cardLayout.show(mainPanel, "QL_DICHVU"));
        tkDoanhThu.addActionListener(e -> cardLayout.show(mainPanel, "TK_DOANHTHU"));
        tkDonHang.addActionListener(e -> cardLayout.show(mainPanel, "TK_DONHANG"));
        thanhToanHoaDon.addActionListener(e -> cardLayout.show(mainPanel, "TT_HoaDon"));
        traCuuDonHang.addActionListener(e -> cardLayout.show(mainPanel, "TC_DONHANG"));


        // Mặc định hiển thị panel khách hàng
        cardLayout.show(mainPanel, "QL_KHACHHANG");
    }

    public static void main(String[] args) {
        new MainFrame().setVisible(true);
    }
}
