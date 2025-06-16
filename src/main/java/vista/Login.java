package vista;

import javax.swing.*;
import java.awt.*;
import controlador.LoginControlador;
import modelo.Empleado;

// Ventana de inicio de sesión para la aplicación Cafeina
public class Login extends JFrame {
    // Campo de texto para el usuario
    private JTextField usuarioField;
    // Campo de contraseña
    private JPasswordField contraseniaField;
    // Botón para iniciar sesión
    private JButton loginButton;

    // Constructor de la ventana Login
    public Login() {
        setTitle("Cafeina - Login"); // Título de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Cierra la app al cerrar ventana
        setSize(430, 320); // Tamaño de la ventana
        setLocationRelativeTo(null); // Centra la ventana
        setResizable(false); // No permite redimensionar
        // Panel principal con color café y fondo degradado
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
        mainPanel.setLayout(null); // Layout absoluto
        setContentPane(mainPanel);

        // Logo de café
        JLabel iconLabel = new JLabel();
        iconLabel.setBounds(30, 20, 80, 80);
        ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/Adobe Express - file.png"));
        Image img = icon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        iconLabel.setIcon(new ImageIcon(img));
        mainPanel.add(iconLabel);

        // Título de la ventana
        JLabel titulo = new JLabel("Bienvenido a Cafeina");
        titulo.setBounds(120, 30, 260, 30);
        titulo.setFont(new Font("Serif", Font.BOLD, 22));
        titulo.setForeground(Color.WHITE);
        mainPanel.add(titulo);

        // Subtítulo
        JLabel subtitulo = new JLabel("Inicia sesión para continuar");
        subtitulo.setBounds(120, 60, 260, 20);
        subtitulo.setFont(new Font("SansSerif", Font.PLAIN, 14));
        subtitulo.setForeground(Color.WHITE);
        mainPanel.add(subtitulo);

        // Etiqueta y campo de usuario
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

        // Etiqueta y campo de contraseña
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

        // Botón de inicio de sesión
        loginButton = new JButton("Iniciar sesión");
        loginButton.setBounds(140, 210, 150, 35);
        loginButton.setBackground(new Color(111, 78, 55));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        loginButton.setFocusPainted(false);
        loginButton.setBorder(BorderFactory.createLineBorder(new Color(78, 43, 14), 2));
        mainPanel.add(loginButton);

        // Acción al presionar el botón de inicio de sesión
        loginButton.addActionListener(e -> login());
    }

    // Método para iniciar sesión
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
