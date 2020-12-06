package VistaAdmin;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.ResultSetMetaData;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Administrador;
import Conexion.Conexion;
/**
 * Ventana donde se gestionan los Admins
 * @author alex
 *
 */
public class GestionAdministrador extends JDialog {


	private final JPanel contentPanel = new JPanel();
	private JLabel lblGA;
	private JTextField textUsu;
	private JTextField textCont;
	private JTextField textBus;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GestionAdministrador dialog = new GestionAdministrador();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			mostrarTabla();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GestionAdministrador() {
		getContentPane().setBackground(Color.GRAY);
		setBounds(250, 50, 1200, 900);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		{
			lblGA = new JLabel("Gestión Administrador - Cine Deusto");
			lblGA.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 25));
			lblGA.setForeground(Color.ORANGE);
		}

		//Lista donde se mostraran los datos de  la base de datos de Administradores
		


		textUsu = new JTextField();
		textUsu.setEditable(false);
		textUsu.setColumns(10);


		textCont = new JTextField();
		textCont.setEditable(false);
		textCont.setColumns(10);


		textBus = new JTextField();
		textBus.setColumns(10);


		JLabel lblUsu = new JLabel("Nombre de usuario");
		lblUsu.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));
		lblUsu.setForeground(Color.ORANGE);


		JLabel lblCont = new JLabel("Contraseña");
		lblCont.setForeground(Color.ORANGE);
		lblCont.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));

		JLabel lblBus = new JLabel("Buscar");
		lblBus.setForeground(Color.ORANGE);
		lblBus.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));


		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(Color.ORANGE);
		btnGuardar.setForeground(Color.ORANGE);
		btnGuardar.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
		btnGuardar.setOpaque(true);
		btnGuardar.setBorderPainted(false);


		JLabel lblMod = new JLabel("");
		lblMod.addMouseListener(new MouseAdapter() {
			@Override

			//Al pulsar habilito edicion de los campos y se verá botón guardar
			public void mouseClicked(MouseEvent e) {

				textUsu.setEditable(true);
				textCont.setEditable(true);
				
				btnGuardar.setBackground(Color.GRAY);
			}
		});
		lblMod.setIcon(new ImageIcon("/Users/alex/eclipse-workspace5/CineDeusto/Imagenes/ckvbn.png"));
		lblMod.setOpaque(true);
		lblMod.setBackground(Color.orange);
		lblMod.setBorder(new LineBorder(new Color(255, 200, 0), 3, true));

		JLabel lblEli = new JLabel("");
		lblEli.setIcon(new ImageIcon("/Users/alex/eclipse-workspace5/CineDeusto/Imagenes/dsjn.png"));
		lblEli.setOpaque(true);
		lblEli.setBackground(Color.orange);
		lblEli.setBorder(new LineBorder(new Color(255, 200, 0), 3, true));

		JLabel lblAny = new JLabel("");
		lblAny.addMouseListener(new MouseAdapter() {
			@Override
			//Al pulsar habilito edicion de los campos y se verá botón guardar
			public void mouseClicked(MouseEvent e) {

				textUsu.setEditable(true);
				textCont.setEditable(true);
				btnGuardar.setBackground(Color.GRAY);
			}
		});
		lblAny.setIcon(new ImageIcon("/Users/alex/eclipse-workspace5/CineDeusto/Imagenes/vbalsd.png"));
		lblAny.setOpaque(true);
		lblAny.setBackground(Color.orange);
		lblAny.setBorder(new LineBorder(new Color(255, 200, 0), 3, true));

		JLabel lblAnyA = new JLabel("Añadir Admin");
		lblAnyA.setForeground(Color.ORANGE);
		lblAnyA.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));

		JLabel lblModA = new JLabel("Modificar Admin");
		lblModA.setForeground(Color.ORANGE);
		lblModA.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));

		JLabel lblEliA = new JLabel("Eliminar Admin");
		lblEliA.setForeground(Color.ORANGE);
		lblEliA.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));
		

		
		
		
		table = new JTable();
		
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(184)
							.addComponent(lblUsu)
							.addGap(93)
							.addComponent(textUsu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(186)
							.addComponent(lblCont)
							.addPreferredGap(ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
							.addComponent(textCont, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(92))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(147)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 636, GroupLayout.PREFERRED_SIZE)
							.addGap(115)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblAny, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblMod, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblEli, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAnyA)
								.addComponent(lblEliA)
								.addComponent(lblModA)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(365)
							.addComponent(lblBus)
							.addGap(36)
							.addComponent(textBus, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(361)
							.addComponent(lblGA, GroupLayout.PREFERRED_SIZE, 502, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(33, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(28)
					.addComponent(lblGA)
					.addGap(120)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblUsu)
							.addComponent(textUsu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(textCont, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCont))))
					.addGap(28)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(114)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblBus)
								.addComponent(textBus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(190)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblAnyA)
									.addGap(69)
									.addComponent(lblModA)
									.addGap(78)
									.addComponent(lblEliA)
									.addGap(36))
								.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
										.addComponent(table, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPanel.createSequentialGroup()
											.addGap(66)
											.addComponent(lblAny, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblMod, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(lblEli, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)))
									.addGap(11)))))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.ORANGE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			{
				//Cierra ventana
				JButton cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});


				buttonPane.add(btnGuardar);
				cancelButton.setForeground(Color.ORANGE);
				cancelButton.setBackground(Color.GRAY);
				cancelButton.setOpaque(true);
				cancelButton.setBorderPainted(false);
				cancelButton.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}

		}

	}
	
	public Administrador obteneradministrador(Administrador admin) {
		Administrador administrador = null;

		Conexion conexion1 = new Conexion();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		
		try {
			Connection cn1 = conexion1.conectar();
			String sql = "select * from admin where Username = ? and contr = ?";
			pst = cn1.prepareStatement(sql);
			pst.setString(1, admin.getUsername());
			pst.setString(2, admin.getPassword());
			rs = pst.executeQuery();
			
			
		
			

			while(rs.next()) {
				administrador = new Administrador(rs.getString(1), rs.getString(2), rs.getBoolean(3));
			
			}

		}catch (Exception e) {
			System.out.println("Error en obtener Administrador");
		}
		return administrador;
	}
	
	private static void mostrarTabla() {
		DefaultTableModel modelo= new DefaultTableModel();
		ResultSet rs= Conexion.getTabla("select username, contr from Admin");
		modelo.addColumn("Nombre de usuario");
		modelo.addColumn("Contraseña");
		
		
		
		try {
			while(rs.next()) {
				modelo.addRow(new Object[] {rs.getString("username"),rs.getString("contr")});
			}
			table.setModel(modelo);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
