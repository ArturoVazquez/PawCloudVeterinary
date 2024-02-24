package application;

import java.awt.AlphaComposite;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.RoundRectangle2D;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JPanel;

import UISwing.recursos.GradientPanel2;
import UISwing.recursos.RoundedPanel;
import UISwing.ventanas.PanelCitas;
import UISwing.ventanas.PanelHome;

import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;


public class MainFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private CardLayout cardLayout = new CardLayout(); // CardLayout para gestionar paneles intercambiables
    private JPanel cardPanel; // Panel que contiene los diferentes paneles intercambiables
    private JLabel lblNombreUsuario;
    private JLabel lblRealTime;



    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MainFrame frame = new MainFrame();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public MainFrame() {
    	getContentPane().setBackground(Color.decode("#DAE7F7"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1367, 768);
        setLocationRelativeTo(null);
        setUndecorated(true);
        getContentPane().setLayout(null);
        // Configuración de cardPanel
        cardPanel = new JPanel(cardLayout);
        cardPanel.setOpaque(false); // Si quieres transparencia
        cardPanel.setBounds(234, 104, 1112, 653);
        getContentPane().add(cardPanel);
        
        // Inicialización y adición de PanelHome al cardPanel
        PanelHome panelHome = new PanelHome(); // Asume que esta clase ya está definida correctamente
        cardPanel.add(panelHome, "PanelHome");

        // Inicialización y adición de PanelCitas al cardPanel
        PanelCitas panelCitas = new PanelCitas(); // Asume que esta clase ya está definida correctamente
        cardPanel.add(panelCitas, "PanelCitas");

        // Muestra inicialmente el PanelHome
        cardLayout.show(cardPanel, "PanelHome");
        
        GradientPanel2 gradientPanel = new GradientPanel2();
        gradientPanel.setBounds(0, 0, 215, 768);
        getContentPane().add(gradientPanel);
        gradientPanel.setLayout(null);
        
        JPanel panelMenu = new JPanel();
        panelMenu.setBounds(0, 0, 215, 768);
        gradientPanel.add(panelMenu);
        panelMenu.setLayout(null);
        panelMenu.setOpaque(false);
        
        JLabel lblnombreLogo = new JLabel("");
        lblnombreLogo.setIcon(new ImageIcon(getClass().getResource("/imagenes/logo_horizontal.png")));
        lblnombreLogo.setFont(new Font("Dialog", Font.BOLD, 21));
        lblnombreLogo.setForeground(new Color(255, 255, 255));
        lblnombreLogo.setBounds(25, 19, 165, 63);
        panelMenu.add(lblnombreLogo);
        
        JLabel lblHome = new JLabel("Home");
        lblHome.setForeground(new Color(255, 255, 255));
        lblHome.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblHome.setBounds(55, 105, 75, 28);
        panelMenu.add(lblHome);
        lblHome.addMouseListener(new MouseAdapter() {
        	
        	public void mouseClicked(MouseEvent e) {
        		cardLayout.show(cardPanel,  "PanelHome"); //Cambia al panel Home
        	}
		});
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/imagenes/logoHome.png")));
        lblNewLabel.setBounds(25, 105, 20, 28);
        panelMenu.add(lblNewLabel);
        
        JLabel lblclientemascotas = new JLabel("Cliente/Mascotas");
        lblclientemascotas.setForeground(new Color(255, 255, 255));
        lblclientemascotas.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblclientemascotas.setBounds(55, 144, 130, 28);
        panelMenu.add(lblclientemascotas);
        
        JLabel lblLogoCliente = new JLabel("");
        lblLogoCliente.setIcon(new ImageIcon(getClass().getResource("/imagenes/logoMascotas.png")));
        lblLogoCliente.setBounds(25, 144, 20, 28);
        panelMenu.add(lblLogoCliente);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(getClass().getResource("/imagenes/logoCitas.png")));
        lblNewLabel_1.setBounds(25, 183, 20, 28);
        panelMenu.add(lblNewLabel_1);
        
        //Para el menu de citas
        JLabel lblCitas = new JLabel("Citas");
        lblCitas.setForeground(new Color(255, 255, 255));
        lblCitas.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblCitas.setBounds(55, 183, 130, 28);
        panelMenu.add(lblCitas);
        lblCitas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(cardPanel, "PanelCitas"); // Cambiar al PanelCitas
            }
        });
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(getClass().getResource("/imagenes/logoVentas.png")));
        lblNewLabel_2.setBounds(25, 222, 20, 28);
        panelMenu.add(lblNewLabel_2);
        
        JLabel lblcalendario = new JLabel("Calendario");
        lblcalendario.setForeground(new Color(255, 255, 255));
        lblcalendario.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblcalendario.setBounds(55, 222, 102, 28);
        panelMenu.add(lblcalendario);
        
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon(getClass().getResource("/imagenes/logoAlmacen.png")));
        lblNewLabel_3.setBounds(25, 261, 20, 28);
        panelMenu.add(lblNewLabel_3);
        
        JLabel lblventas = new JLabel("Ventas");
        lblventas.setForeground(new Color(255, 255, 255));
        lblventas.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblventas.setBounds(55, 261, 46, 28);
        panelMenu.add(lblventas);
        
        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setIcon(new ImageIcon(getClass().getResource("/imagenes/logoConfiguracion.png")));
        lblNewLabel_4.setBounds(25, 300, 20, 28);
        panelMenu.add(lblNewLabel_4);
        
        JLabel lblconfiguracion = new JLabel("Configuración");
        lblconfiguracion.setForeground(new Color(255, 255, 255));
        lblconfiguracion.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblconfiguracion.setBounds(55, 300, 102, 28);
        panelMenu.add(lblconfiguracion);
        
        JLabel lbllogoLogout = new JLabel("");
        lbllogoLogout.setIcon(new ImageIcon(getClass().getResource("/imagenes/logoLogout.png")));
        lbllogoLogout.setBounds(30, 712, 20, 28);
        panelMenu.add(lbllogoLogout);
        
        JLabel lbllogout = new JLabel("Logout");
        lbllogout.setForeground(new Color(255, 255, 255));
        lbllogout.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lbllogout.setBounds(50, 712, 75, 28);
        panelMenu.add(lbllogout);
        lbllogout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0); // Cierra la aplicación
            }
        });
        
        RoundedPanel panelHeader = new RoundedPanel(20);  // Redondeado del panel
        panelHeader.setBounds(234, 11, 1112, 82);
        panelHeader.setBackground(new Color(255, 255, 255, 123)); // Establece el color de fondo y la opacidad
        getContentPane().add(panelHeader);
        panelHeader.setLayout(null);
        
        lblNombreUsuario = new JLabel("Usuario");
        lblNombreUsuario.setBounds(1042, 11, 60, 60);
        panelHeader.add(lblNombreUsuario);
        
        
        lblRealTime = new JLabel("");
        lblRealTime.setBounds(20, 11, 200, 60);
        lblRealTime.setForeground(Color.decode("#909090"));
        lblRealTime.setFont(new Font("Segoe UI", Font.BOLD, 16));
        panelHeader.add(lblRealTime);
        // Formateador de fecha y hora
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        // Timer para actualizar la fecha y hora cada segundo
        new Timer(1000, e -> lblRealTime.setText(LocalDateTime.now().format(dtf))).start();
        
        
        JLabel lbllogoHeader = new JLabel("");
        lbllogoHeader.setBounds(1000, 11, 35, 60);
        panelHeader.add(lbllogoHeader);
        lbllogoHeader.setIcon(new ImageIcon(getClass().getResource("/imagenes/logoHeader.png")));
        

        // Hacer las esquinas del JFrame ligeramente redondeadas
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
        
        JPanel centerPanel1 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                // Personaliza aquí tu componente
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setComposite(AlphaComposite.SrcOver.derive(0.5f)); // Ajusta la opacidad aquí
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30); // Puedes ajustar el radio de las esquinas si es necesario
                g2.dispose();
                super.paintComponent(g);
            }
        };
        centerPanel1.setBackground(new Color(255, 255, 255, 80)); // Color de fondo con opacidad
        centerPanel1.setOpaque(false); // Hace que el panel no pinte todos sus píxeles, lo que permite que se vea el fondo.
        centerPanel1.setBounds(10, 11, 195, 746);
        gradientPanel.add(centerPanel1);
        
        
    }
	 // Método para actualizar el nombre del usuario en el JLabel
	    public void setNombreUsuario(String nombreUsuario) {
	        lblNombreUsuario.setText(nombreUsuario);
	    }
}