package vista;

import javax.swing.*;
import java.awt.*;
import controlador.LoginControlador;
import modelo.Empleado;

public class Login extends JFrame {
    private JTextField usuarioField;
    private JPasswordField contraseniaField;
    private JButton loginButton;

    public Login() {
        setTitle("Café - Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(430, 320);
        setLocationRelativeTo(null);
        setResizable(false);
        // Panel principal con color café
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Fondo degradado café
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = new Color(78, 43, 14);
                Color color2 = new Color(193, 154, 107);
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        mainPanel.setLayout(null);
        setContentPane(mainPanel);

        // Logo de café
        JLabel iconLabel = new JLabel();
        iconLabel.setBounds(30, 20, 80, 80);
        ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/Adobe Express - file.png"));
        Image img = icon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        iconLabel.setIcon(new ImageIcon(img));
        mainPanel.add(iconLabel);

        JLabel titulo = new JLabel("Bienvenido a Café Aroma");
        titulo.setBounds(120, 30, 260, 30);
        titulo.setFont(new Font("Serif", Font.BOLD, 22));
        titulo.setForeground(Color.WHITE);
        mainPanel.add(titulo);

        JLabel subtitulo = new JLabel("Inicia sesión para continuar");
        subtitulo.setBounds(120, 60, 260, 20);
        subtitulo.setFont(new Font("SansSerif", Font.PLAIN, 14));
        subtitulo.setForeground(Color.WHITE);
        mainPanel.add(subtitulo);

        JLabel usuarioLabel = new JLabel("Usuario:");
        usuarioLabel.setBounds(60, 120, 80, 25);
        usuarioLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
        usuarioLabel.setForeground(Color.WHITE);
        mainPanel.add(usuarioLabel);

        usuarioField = new JTextField();
        usuarioField.setBounds(150, 120, 200, 28);
        usuarioField.setFont(new Font("SansSerif", Font.PLAIN, 15));
        usuarioField.setBackground(new Color(245, 222, 179));
        usuarioField.setBorder(BorderFactory.createLineBorder(new Color(111, 78, 55)));
        mainPanel.add(usuarioField);

        JLabel contraseniaLabel = new JLabel("Contraseña:");
        contraseniaLabel.setBounds(60, 160, 90, 25);
        contraseniaLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
        contraseniaLabel.setForeground(Color.WHITE);
        mainPanel.add(contraseniaLabel);

        contraseniaField = new JPasswordField();
        contraseniaField.setBounds(150, 160, 200, 28);
        contraseniaField.setFont(new Font("SansSerif", Font.PLAIN, 15));
        contraseniaField.setBackground(new Color(245, 222, 179));
        contraseniaField.setBorder(BorderFactory.createLineBorder(new Color(111, 78, 55)));
        mainPanel.add(contraseniaField);

        loginButton = new JButton("Iniciar sesión");
        loginButton.setBounds(140, 210, 150, 35);
        loginButton.setBackground(new Color(111, 78, 55));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        loginButton.setFocusPainted(false);
        loginButton.setBorder(BorderFactory.createLineBorder(new Color(78, 43, 14), 2));
        mainPanel.add(loginButton);

        loginButton.addActionListener(e -> login());
    }

    private void login() {
        String usuario = usuarioField.getText();
        String contrasenia = new String(contraseniaField.getPassword());
        LoginControlador controlador = new LoginControlador();
        Empleado empleado = controlador.validarEmpleado(usuario, contrasenia);
        if (empleado != null) {
            JOptionPane.showMessageDialog(this, "Bienvenido " + empleado.getNombre1());
            this.dispose();
            new Facturacion().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.");
        }
    }
}
