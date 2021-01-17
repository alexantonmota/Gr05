package vistaAdmin;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import db.Conexion;
import model.Administrador;
/**
 * Ventana donde se gestionan los Admins con una Tabla que se conecta a la base de datos para añadir o eliminar uno de estos, 
 * una vez seleccionados de la tabla se mostarán en sus respectivos campos, he añadido un campo para hacer una búsqueda filtrando por cualquiera de sus atributos
 * @author alex
 *
 */
public class GestionAdministrador extends JDialog {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblGA;
	private JTextField textUsu;
	private JTextField textCont;
	private static JTextField textBus;
	private static  JTable table;
	static DefaultTableModel modelo;
	DefaultListModel<String> listmodel1 = new DefaultListModel<String>();
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
		textBus.setForeground(Color.GRAY);
		textBus.setBackground(Color.ORANGE);
		textBus.addKeyListener(new KeyAdapter() {
			//barra de búsqueda en funcion del nombre de usuario y de la contraseña
			@Override
			public void keyPressed(KeyEvent e) {
				String[]titulos= {"Nombre de usuario","Contraseña"};
				String[]datos= new String[50];


				String sql= "SELECT *FROM Admin WHERE username LIKE '%"+ textBus.getText()+ "%'" +
						"OR contr LIKE '%"+ textBus.getText()+"%'";
				modelo= new DefaultTableModel(null,titulos);
				Conexion cc= new Conexion();
				Connection conect= cc.conectar();



				try {
					Statement stmt= (Statement) conect.createStatement();
					ResultSet rs= stmt.executeQuery(sql);
					while(rs.next()) {
						datos[0]= rs.getString("username");
						datos[1]= rs.getString("contr");
						modelo.addRow(datos);



					}
					table.setModel(modelo);
				} catch (Exception ex) {
					System.out.println("error en búsqueda");
				}
			}
		});
		textBus.setColumns(10);


		JLabel lblUsu = new JLabel("Nombre de usuario");
		lblUsu.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));
		lblUsu.setForeground(Color.ORANGE);


		JLabel lblCont = new JLabel("Contraseña");
		lblCont.setForeground(Color.ORANGE);
		lblCont.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));

		JLabel lblBus = new JLabel("Buscar");
		lblBus.setHorizontalAlignment(SwingConstants.CENTER);
		lblBus.setForeground(Color.ORANGE);
		lblBus.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));
		lblBus.setBorder(BorderFactory.createLineBorder(Color.ORANGE,2));


		JButton btnAny = new JButton("Guardar");

		btnAny.setBackground(Color.ORANGE);
		btnAny.setForeground(Color.ORANGE);
		btnAny.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
		btnAny.setOpaque(true);
		btnAny.setBorderPainted(false);

		//Boton que al pulsar una fila de datos de la tabla y clickar en el elimina de la tabla y a su vez de la base de datos los valores seleccionador
		JLabel lblEli = new JLabel("");
		lblEli.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Conexion cc= new Conexion();
				Connection conect= cc.conectar();

				int fila= table.getSelectedRow();
				String codigo= table.getValueAt(fila, 0).toString();


				if(fila>0) {
					PreparedStatement ps=null;

					try {

						ps= conect.prepareStatement("Delete from Admin where username=?");
						ps.setString(1, codigo);
						ps.execute();
						JOptionPane.showMessageDialog(null, "Administrador Eliminado");

					} catch (Exception e2) {
						System.out.println(e2);					}
					modelo.removeRow(fila);

				}else {

				}
			}
		});
		lblEli.setIcon(new ImageIcon("./Imagenes/dsjn.png"));
		lblEli.setOpaque(true);
		lblEli.setBackground(Color.orange);
		lblEli.setBorder(new LineBorder(new Color(255, 200, 0), 3, true));

		JLabel lblAny = new JLabel("");
		lblAny.addMouseListener(new MouseAdapter() {
			@Override
			//Al pulsar habilito edicion de los campos y se verá botón guardar
			public void mouseClicked(MouseEvent e) {


			}
			@Override
			public void mousePressed(MouseEvent e) {
				textUsu.setEditable(true);
				textCont.setEditable(true);
				btnAny.setBackground(Color.GRAY);
			}
		});
		lblAny.setIcon(new ImageIcon("./Imagenes/vbalsd.png"));
		lblAny.setOpaque(true);
		lblAny.setBackground(Color.orange);
		lblAny.setBorder(new LineBorder(new Color(255, 200, 0), 3, true));

		JLabel lblAnyA = new JLabel("Añadir Admin");
		lblAnyA.setForeground(Color.ORANGE);
		lblAnyA.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));

		JLabel lblEliA = new JLabel("Eliminar Admin");
		lblEliA.setForeground(Color.ORANGE);
		lblEliA.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));


		//Botón que al pulsar añade un administrador a la tabla (JTable) y a su vez en la base datos mediante un hilo y se añade a una lista
		btnAny.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				Thread t= new Thread(new Runnable() {
					@Override
					public void run() {
						Conexion conexion1 = new Conexion();
						Connection cn1 = conexion1.conectar();

						String username= textUsu.getText();
						String contra= textCont.getText();
						int esAdmin= 1;
						String sql= "INSERT INTO Admin (username, contr, isAdmin) VALUES(?,?,?)";
						PreparedStatement ps1= null;
						try {
							PreparedStatement pst1 = cn1.prepareStatement(sql);

							pst1.setString(1, username);
							pst1.setString(2, contra);
							pst1.setInt(3, esAdmin);


							int n = pst1.executeUpdate();
							if(n>0) {
								JOptionPane.showMessageDialog(null, "Administrador añadido");
								if(!textUsu.getText().isEmpty() && !textCont.getText().isEmpty()) {
									listmodel1.addElement("Nombre de usuario:"+textUsu.getText()+","+"Contraseña:"+textCont.getText());
								}
							}

							//Una vez pulsado el boton de añadir deshabilitamos la edición de los campos y ocultamos el boton de añadir
							mostrarTabla();
							textUsu.setEditable(false);
							textCont.setEditable(false);
							btnAny.setBackground(Color.ORANGE);

						}catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "ERROR");
						}
					}}
						);
				t.start();


			}

		});

		//Creación de una Tabla

		table = new JTable();

		table.setSelectionBackground(Color.ORANGE);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Edicion de anchura de columnas
				int seleccion= table.rowAtPoint(e.getPoint());
				textUsu.setText(String.valueOf(table.getValueAt(seleccion, 0)));
				textCont.setText(String.valueOf(table.getValueAt(seleccion, 1)));
			}

		});

		//Labels que uso como cabeceras para las columnas de las tablas

		JLabel lblNewLabel = new JLabel("Nombre de usuario");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));

		JLabel lblNewLabel_1 = new JLabel("Contraseña");
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));


		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
				gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addGap(184)
										.addComponent(lblUsu)
										.addGap(93)
										.addComponent(textUsu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(186)
										.addComponent(lblCont)
										.addPreferredGap(ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
										.addComponent(textCont, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(92))
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addGap(147)
										.addComponent(table, GroupLayout.PREFERRED_SIZE, 636, GroupLayout.PREFERRED_SIZE)
										.addGap(66)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
												.addComponent(lblEli, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
												.addComponent(lblAny, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGap(50)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
												.addComponent(lblAnyA)
												.addComponent(lblEliA))
										.addGap(94))
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addGap(361)
										.addComponent(lblGA, GroupLayout.PREFERRED_SIZE, 502, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addGap(465)
										.addComponent(lblNewLabel_1)
										.addGap(176))
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addGap(162)
										.addComponent(lblNewLabel)))
						.addContainerGap())
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addContainerGap(395, Short.MAX_VALUE)
						.addComponent(lblBus, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
						.addGap(37)
						.addComponent(textBus, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
						.addGap(398))
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
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel)
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addGap(80)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
												.addComponent(textBus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblBus))
										.addPreferredGap(ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
										.addComponent(lblNewLabel_1)))
						.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addComponent(lblAnyA)
										.addGap(99)
										.addComponent(lblEliA)
										.addGap(101))
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(table, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_contentPanel.createSequentialGroup()
														.addGap(56)
														.addComponent(lblAny, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(lblEli, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
														.addGap(56)))
										.addGap(11)))
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
				buttonPane.add(btnAny);
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
	//Se obtienes los administradores
	public Administrador obteneradministrador(Administrador admin) {
		Administrador administrador = null;

		Conexion conexion1 = new Conexion();
		PreparedStatement pst = null;
		ResultSet rs = null;


		try {
			Connection cn1 = Conexion.conectar();
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

	//Método en el que se muestra en la tabla (JTable) el contenido de la tabla Administrador de la base de datos

	public static void mostrarTabla() {
		String[] titulos= {"Nombre de usuario", "Contraseña"};
		String[] datos= new String[50];

		String sql= "SELECT username, contr from Admin";
		modelo= new DefaultTableModel(null,titulos);
		Conexion cc= new Conexion();
		Connection conect= Conexion.conectar();
		try {
			Statement stmt= (Statement) conect.createStatement();
			ResultSet rs= stmt.executeQuery(sql);
			while(rs.next()) {
				datos[0]= rs.getString("username");
				datos[1]= rs.getString("contr");

				modelo.addRow(datos);
			}
			table.setModel(modelo);



		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
