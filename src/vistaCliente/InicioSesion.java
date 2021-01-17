package vistaCliente;
import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import vistaAdmin.InicioSesionAdmin;
import db.DBManager;
import model.Cliente;
/**
 * Ventana de Inicio de Sesion para clientes
 * @author alex
 *
 */
public class InicioSesion {

	public JFrame frame;
	public JTextField textField;
	public JPasswordField passwordField;
	public static Logger log;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		//Creacion del Logger
		try {
			log = Logger.getLogger("logger");
			Handler h = new FileHandler("Datosprograma.xml");
			log.addHandler(h);
			//log.setUseParentHandlers(false);
			log.setLevel(Level.FINEST);
			h.setLevel(Level.FINEST);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			log.log(Level.INFO, "Inicio del programa " + new Date());
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					try {
						InicioSesion window = new InicioSesion();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}catch(Exception e) {
			log.log(Level.SEVERE, "Error en el inicio de la aplicacion",e);
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error grave", "ERROR",JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * Create the application.
	 */
	public InicioSesion() {
		super();
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setResizable(false);
		frame.setForeground(Color.DARK_GRAY);
		frame.getContentPane().setForeground(Color.DARK_GRAY);
		frame.setBounds(600, 300, 491, 356);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Usuario\r\n");
		lblNewLabel.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setBounds(85, 105, 91, 20);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Contraseña");
		lblNewLabel_1.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setBounds(85, 137, 128, 20);
		frame.getContentPane().add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(254, 104, 146, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(254, 135, 146, 26);
		frame.getContentPane().add(passwordField);

		JButton btnNewButton = new JButton("Cancelar\r\n");
		btnNewButton.setOpaque(true);
		btnNewButton.setBorderPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setForeground(Color.GRAY);
		btnNewButton.setBounds(254, 194, 142, 29);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Aceptar\r\n");
		btnNewButton_1.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		btnNewButton_1.setOpaque(true);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();

				ingresar();

			}
		});
		btnNewButton_1.setForeground(Color.GRAY);
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.setBounds(85, 194, 141, 29);
		frame.getContentPane().add(btnNewButton_1);

		JLabel lblIntroduceTusDatos = new JLabel("CINE DEUSTO");
		lblIntroduceTusDatos.setForeground(Color.ORANGE);
		lblIntroduceTusDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduceTusDatos.setBackground(Color.WHITE);
		lblIntroduceTusDatos.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 28));
		lblIntroduceTusDatos.setBounds(43, 24, 398, 50);
		frame.getContentPane().add(lblIntroduceTusDatos);

		JButton btnNuevaCuenta = new JButton("Inicia Sesión como Admin\r\n");
		btnNuevaCuenta.setForeground(Color.ORANGE);
		btnNuevaCuenta.setOpaque(true);
		btnNuevaCuenta.setBorderPainted(false);


		btnNuevaCuenta.setActionCommand("Open");
		btnNuevaCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();

				if(cmd.equals("Open"))
				{
					frame.dispose();
					new InicioSesionAdmin();

				}
			}
		});
		btnNuevaCuenta.setToolTipText("");
		btnNuevaCuenta.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
		btnNuevaCuenta.setBackground(Color.GRAY);
		btnNuevaCuenta.setBounds(125, 283, 261, 32);
		frame.getContentPane().add(btnNuevaCuenta);

		JLabel lblNewLabel_2 = new JLabel("¿No tienes cuenta?");
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(85, 244, 168, 16);
		frame.getContentPane().add(lblNewLabel_2);

		JButton btnNewButton_2 = new JButton("Registrarse");
		btnNewButton_2.setBackground(Color.ORANGE);
		btnNewButton_2.setOpaque(true);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setActionCommand("Open"); 
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();

				if(cmd.equals("Open"))
				{
					frame.dispose();
					new Registro();

				}
			}
		}); 





		btnNewButton_2.setForeground(Color.GRAY);
		btnNewButton_2.setBackground(Color.ORANGE);
		btnNewButton_2.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		btnNewButton_2.setBounds(254, 242, 138, 29);
		frame.getContentPane().add(btnNewButton_2);
	}

	//Método para iniciar sesion
	protected void ingresar() {
		String usuario = textField.getText();
		String contraseña = String.valueOf(passwordField.getPassword());

		DBManager db = new DBManager();
		Cliente cl2 = new Cliente();
		cl2.setUsername(usuario);
		cl2.setPassword(contraseña);

		Cliente usu = db.obtenerusuario(cl2);

		if(usu!=null) {
			frame.dispose();
			JOptionPane.showMessageDialog(frame, "BIENVENIDO");

			CambiarImagen cam= new CambiarImagen();
			cam.main();

			InicioSesion.log.log(Level.FINER,"Usuario conectado: " + usuario);

		}else{
			JOptionPane.showMessageDialog(frame, "Datos no validos", "error", JOptionPane.ERROR_MESSAGE);
		}

	}




}