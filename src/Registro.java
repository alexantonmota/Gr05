import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
/**
 * Ventana de registro para clientes
 * @author alex
 *
 */
public class Registro {

	public JFrame frame1;
	private JTextField txtUser;
	private JTextField txtEmail;
	private JTextField txtApe1;
	private JTextField txtApe2;
	private JTextField txtNombre;
	private JTextField txtFecha;
	private JPasswordField passContr;
	static PrintStream log;
	HashMap<String, String> clientes = new HashMap<String, String>();
	private static final String EMAIL_PATTER = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro window = new Registro();
					window.frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registro() {
		super();
		initialize();
		frame1.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame1 = new JFrame();
		frame1.getContentPane().setBackground(Color.GRAY);
		frame1.setBackground(Color.GRAY);
		frame1.setBounds(600, 250, 450, 500);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(null);

		JLabel lblUser = new JLabel("Username\r\n");
		lblUser.setForeground(Color.ORANGE);
		lblUser.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblUser.setBounds(46, 87, 115, 20);
		frame1.getContentPane().add(lblUser);

		JLabel lblApe1 = new JLabel("1er Apellido");
		lblApe1.setForeground(Color.ORANGE);
		lblApe1.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblApe1.setBounds(46, 191, 115, 20);
		frame1.getContentPane().add(lblApe1);

		JLabel lblApe2 = new JLabel("2ndo Apellido");
		lblApe2.setForeground(Color.ORANGE);
		lblApe2.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblApe2.setBounds(46, 227, 135, 20);
		frame1.getContentPane().add(lblApe2);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.ORANGE);
		lblEmail.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblEmail.setBounds(46, 123, 69, 20);
		frame1.getContentPane().add(lblEmail);



		JButton btnCancelar = new JButton("Cancelar\r\n");
		btnCancelar.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
		btnCancelar.setBackground(Color.ORANGE);
		btnCancelar.setForeground(Color.GRAY);
		btnCancelar.setOpaque(true);
		btnCancelar.setBorderPainted(false);

		btnCancelar.setActionCommand("Open70");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();

				if(cmd.equals("Open70"))
				{
					frame1.dispose();
					new InicioSesion();

				}
			}
		});

		btnCancelar.setBounds(254, 362, 155, 29);
		frame1.getContentPane().add(btnCancelar);





		txtUser = new JTextField();
		txtUser.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		txtUser.setBounds(250, 85, 146, 26);
		frame1.getContentPane().add(txtUser);
		txtUser.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		txtEmail.setBounds(250, 121, 146, 26);
		frame1.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);

		txtApe1 = new JTextField();
		txtApe1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		txtApe1.setBounds(250, 189, 146, 26);
		frame1.getContentPane().add(txtApe1);
		txtApe1.setColumns(10);
		txtApe1.addKeyListener(new KeyListener(){

			public void keyTyped(KeyEvent e){
				char c= e.getKeyChar();
				if (!Character.isAlphabetic(c))

					e.consume();

			}

			public void keyPressed(KeyEvent arg0) {
			}

			public void keyReleased(KeyEvent arg0) {
			}
		});


		txtApe2 = new JTextField();
		txtApe2.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		txtApe2.setBounds(250, 225, 146, 26);
		frame1.getContentPane().add(txtApe2);
		txtApe2.setColumns(10);
		txtApe2.addKeyListener(new KeyListener(){

			public void keyTyped(KeyEvent e){
				char c= e.getKeyChar();
				if (!Character.isAlphabetic(c))

					e.consume();

			}

			public void keyPressed(KeyEvent arg0) {
			}

			public void keyReleased(KeyEvent arg0) {
			}
		});


		JLabel lblIntroduceTusDatos = new JLabel("Crea una cuenta nueva");
		lblIntroduceTusDatos.setForeground(Color.ORANGE);
		lblIntroduceTusDatos.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 28));
		lblIntroduceTusDatos.setBounds(46, 17, 398, 52);
		frame1.getContentPane().add(lblIntroduceTusDatos);

		JButton btnVueltaAlLogin = new JButton("Volver a Inicio de Sesión");
		btnVueltaAlLogin.setBackground(Color.GRAY);
		btnVueltaAlLogin.setForeground(Color.ORANGE);
		btnVueltaAlLogin.setOpaque(true);
		btnVueltaAlLogin.setBorderPainted(false);
		btnVueltaAlLogin.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
		btnVueltaAlLogin.setActionCommand("Open1");
		btnVueltaAlLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd1 = e.getActionCommand();

				if(cmd1.equals("Open1"))
				{
					frame1.dispose();
					new InicioSesion();
				}
			}
		});
		btnVueltaAlLogin.setBounds(112, 415, 229, 31);
		frame1.getContentPane().add(btnVueltaAlLogin);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.ORANGE);
		lblNombre.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblNombre.setBounds(46, 155, 87, 20);
		frame1.getContentPane().add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		txtNombre.setBounds(250, 151, 146, 26);
		frame1.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		txtNombre.addKeyListener(new KeyListener(){

			public void keyTyped(KeyEvent e){
				char c= e.getKeyChar();
				if (!Character.isAlphabetic(c))

					e.consume();

			}

			public void keyPressed(KeyEvent arg0) {
			}

			public void keyReleased(KeyEvent arg0) {
			}
		});

		JLabel lblFechaNacimiento = new JLabel("Fecha nacimiento");
		lblFechaNacimiento.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblFechaNacimiento.setForeground(Color.ORANGE);
		lblFechaNacimiento.setBounds(46, 262, 155, 20);
		frame1.getContentPane().add(lblFechaNacimiento);

		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblContrasea.setForeground(Color.ORANGE);
		lblContrasea.setBounds(46, 294, 103, 20);
		frame1.getContentPane().add(lblContrasea);

		txtFecha = new JTextField();
		txtFecha.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		txtFecha.setBounds(250, 262, 146, 26);
		frame1.getContentPane().add(txtFecha);
		txtFecha.setColumns(10);

		passContr = new JPasswordField();
		passContr.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		passContr.setBounds(250, 292, 146, 26);
		frame1.getContentPane().add(passContr);

		JButton btnRegis = new JButton("Registrarse\r\n");
		btnRegis.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
		btnRegis.setBackground(Color.ORANGE);
		btnRegis.setForeground(Color.GRAY);
		btnRegis.setOpaque(true);
		btnRegis.setBorderPainted(false);


		btnRegis.setBounds(46, 362, 155, 29);
		frame1.getContentPane().add(btnRegis);
		btnRegis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conexion conexion = new Conexion();
				Connection cn = conexion.conectar();
				String username;
				String password;
				String nombre;
				String apellido1;
				String apellido2;
				String fecha;
				String email;
				String sql="";

				username=txtUser.getText();
				password=String.valueOf(passContr.getPassword());
				nombre=txtNombre.getText();
				apellido1=txtApe1.getText();
				apellido2=txtApe2.getText();
				fecha=txtFecha.getText();
				email=txtEmail.getText();

				GestionClientes2 gestionusuario2 = new GestionClientes2();
				Cliente cliente2 = new Cliente();
				cliente2.setUsername(username);


				Cliente cli = gestionusuario2.obtenerusuario2(cliente2);

				if(cli!=null) {
					JOptionPane.showMessageDialog(null, "Usuario ya utilizado","ERROR", JOptionPane.ERROR_MESSAGE);
				}else{
					if (!email.matches(EMAIL_PATTER)) {
						JOptionPane.showMessageDialog(null, "Email no valido", "ERROR", JOptionPane.ERROR_MESSAGE);
					}else {
						sql = "INSERT INTO Usuario (Username, contr, nombre, apellido1, apellido2, Fechanac, email) VALUES(?,?,?,?,?,?,?)";
						try {
							PreparedStatement pst = cn.prepareStatement(sql);
							pst.setString(1, username);
							pst.setString(2, password);
							pst.setString(3, nombre);
							pst.setString(4, apellido1);
							pst.setString(5, apellido2);
							pst.setString(6, fecha);
							pst.setString(7, email);
							int n = pst.executeUpdate();
							if(n>0) {
								JOptionPane.showMessageDialog(null, "Usuario registrado");
								InicioSesion.log.log(Level.FINER,"Usuario registrado: "+username);
								clientes.put(txtUser.getText(),String.valueOf(passContr.getPassword()));
								frame1.dispose();
								new InicioSesion();
							}
						}catch (SQLException l) {
							l.printStackTrace();
							JOptionPane.showMessageDialog(null, "Los datos no son validos" +l.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
						}
					}	
				}
			}});


	}
}