package vistaAdmin;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.ScrollPane;
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
import javax.swing.table.TableColumnModel;

import db.Conexion;
/**
 * Ventana donde se gestionan los clientes, en la tabla aparecerán los valores que contenga la tabla de usuarios de la base de datos,
 *  con esta se podra: añadir, modificar o eliminar clickando sus respectivos botones,
 *  además de un cambo para búsquedas con cualquier filtro.
 * @author alex
 *
 */
public class GestionClientes extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblGC;
	private JTextField txtNom;
	private JTextField txtApe1;
	private JTextField txtApe2;
	private JTextField txtFecha;
	private JTextField txtNomU;
	private JTextField txtCont;
	private JTextField txtEmail;
	private JTextField txtBus;
	private static JTable table;
	static DefaultTableModel modelo;
	DefaultListModel<String> listmodel2 = new DefaultListModel<String>();
	private JTextField textID;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GestionClientes dialog = new GestionClientes();
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
	public GestionClientes() {
		setBounds(250, 50, 1200, 900);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.EAST);
		{
			lblGC = new JLabel("Gestión Clientes - Cine Deusto");
			lblGC.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 25));
			lblGC.setForeground(Color.ORANGE);
		}
		//Lista donde se mostraran los datos de  la base de datos de Clientes

		txtNom = new JTextField();
		txtNom.setEditable(false);
		txtNom.setColumns(10);

		txtApe1 = new JTextField();
		txtApe1.setEditable(false);
		txtApe1.setColumns(10);

		txtApe2 = new JTextField();
		txtApe2.setEditable(false);
		txtApe2.setColumns(10);

		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setColumns(10);

		txtNomU = new JTextField();
		txtNomU.setEditable(false);
		txtNomU.setColumns(10);

		txtCont = new JTextField();
		txtCont.setEditable(false);
		txtCont.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);

		txtBus = new JTextField();
		txtBus.setBackground(Color.ORANGE);
		txtBus.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				String[]titulos= {"ID","Nombre de usuario","Contraseña","Nombre","Apellido 1","Apellido 2", "Fecha de nacimiento","Email"};
				String[]datos= new String[50];


				String sql= "SELECT *FROM Usuario WHERE username LIKE '%"+ txtBus.getText()+ "%'" + "OR ID like '%"+txtBus.getText()+"%'"+
						"OR contr LIKE '%"+ txtBus.getText()+"%'"+	"OR nombre LIKE '%"+ txtBus.getText()+"%'" +
						"OR apellido1 LIKE '%"+ txtBus.getText()+"%'"+
						"OR apellido2 LIKE '%"+ txtBus.getText()+"%'"+
						"OR Fechanac LIKE '%"+ txtBus.getText()+"%'"+
						"OR email LIKE '%"+ txtBus.getText()+"%'";
				modelo= new DefaultTableModel(null,titulos);

				Conexion cc= new Conexion();
				Connection conect= cc.conectar();



				try {
					Statement stmt= (Statement) conect.createStatement();
					ResultSet rs= stmt.executeQuery(sql);
					while(rs.next()) {
						datos[0]= rs.getString("ID");
						datos[1]= rs.getString("username");
						datos[2]= rs.getString("contr");
						datos[3]= rs.getString("nombre");
						datos[4]= rs.getString("apellido1");
						datos[5]= rs.getString("apellido2");
						datos[6]= rs.getString("Fechanac");
						datos[7]= rs.getString("email");
						modelo.addRow(datos);



					}
					table.setModel(modelo);
					TableColumnModel columnmodel= table.getColumnModel();
					columnmodel.getColumn(0).setPreferredWidth(15);

				} catch (Exception ex) {
					System.out.println("error en búsqueda");

				}
			}});
		txtBus.setColumns(10);

		JLabel lblNom = new JLabel("Nombre");
		lblNom.setForeground(Color.ORANGE);
		lblNom.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));

		JLabel lblApe1 = new JLabel("1er Apellido");
		lblApe1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));
		lblApe1.setForeground(Color.ORANGE);

		JLabel lblApe2 = new JLabel("2ndo Apellido");
		lblApe2.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));
		lblApe2.setForeground(new Color(255, 200, 0));

		JLabel lblFecha = new JLabel("Fecha nacimiento");
		lblFecha.setForeground(Color.ORANGE);
		lblFecha.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));

		JLabel lblNomU = new JLabel("Nombre de usuario");
		lblNomU.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));
		lblNomU.setForeground(Color.ORANGE);

		JLabel lblContr = new JLabel("Contraseña");
		lblContr.setForeground(Color.ORANGE);
		lblContr.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));
		lblEmail.setForeground(Color.ORANGE);

		JLabel lblBus = new JLabel("Buscar");
		lblBus.setForeground(Color.ORANGE);
		lblBus.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));

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

						ps= conect.prepareStatement("Delete from Usuario where ID=?");
						ps.setString(1, codigo);
						int n= ps.executeUpdate();

						if(n>0) {
							JOptionPane.showMessageDialog(null, "Cliente Eliminado");
						}
						mostrarTabla();
					} catch (Exception e2) {
						System.out.println(e2);					}
					modelo.removeRow(fila);

				}else {

				}

			}
		});
		lblEli.setHorizontalAlignment(SwingConstants.CENTER);
		lblEli.setIcon(new ImageIcon("./Imagenes/dsjn.png"));
		lblEli.setOpaque(true);
		lblEli.setBackground(Color.orange);
		lblEli.setBorder(new LineBorder(new Color(255, 200, 0), 3, true));

		//Añado un botón del color del panel para que no se vea, se añadirán valores a la tabla y a la base de datos y se añaden en una lista
		JButton btnAnyadir = new JButton("Añadir");
		btnAnyadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Thread t= new Thread(new Runnable() {
					@Override
					public void run() {
						Conexion conexion1 = new Conexion();
						Connection cn1 = conexion1.conectar();

						String username= txtNomU.getText();
						String contra= txtCont.getText();
						String nombre= txtNom.getText();
						String apellido1= txtApe1.getText();
						String apellido2= txtApe2.getText();
						String fecha= txtFecha.getText();
						String email= txtEmail.getText();

						String sql= "INSERT INTO Usuario (username, contr, nombre, apellido1, apellido2, Fechanac, email) VALUES(?,?,?,?,?,?,?)";
						PreparedStatement ps1= null;

						try {
							PreparedStatement pst1 = cn1.prepareStatement(sql);

							pst1.setString(1, username);
							pst1.setString(2, contra);
							pst1.setString(3, nombre);
							pst1.setString(4, apellido1);
							pst1.setString(5, apellido2);
							pst1.setString(6, fecha);
							pst1.setString(7, email);



							int n = pst1.executeUpdate();
							if(n>0) {
								JOptionPane.showMessageDialog(null, "Cliente añadido");
								if(!txtNomU.getText().isEmpty() && !txtCont.getText().isEmpty() && !txtApe1.getText().isEmpty()&& !txtApe2.getText().isEmpty()&& !txtFecha.getText().isEmpty()&& !txtEmail.getText().isEmpty()) {
									listmodel2.addElement("Nombre de usuario:"+txtNomU.getText()+","+"Contraseña:"+txtCont.getText());
								}}
							mostrarTabla();

							//Una vez añadidos los campos se deshabilitarán y el botón se ocultará
							txtNomU.setEditable(false);
							txtCont.setEditable(false);
							txtApe1.setEditable(false);
							txtApe2.setEditable(false);
							txtFecha.setEditable(false);
							txtEmail.setEditable(false);

							btnAnyadir.setBackground(Color.ORANGE);

						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "ERROR");
						}
					}});
				t.start();
			}

		});
		btnAnyadir.setBackground(Color.ORANGE);
		btnAnyadir.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
		btnAnyadir.setForeground(Color.ORANGE);
		btnAnyadir.setOpaque(true);
		btnAnyadir.setBorderPainted(false);
		JLabel lblAny = new JLabel("");
		lblAny.addMouseListener(new MouseAdapter() {
			@Override

			//Al pulsar se podrán editar los campos y además se verá el boton Guardar
			public void mouseClicked(MouseEvent e) {
				txtNom.setEditable(true);;
				txtApe1.setEditable(true);;
				txtApe2.setEditable(true);;
				txtFecha.setEditable(true);;
				txtNomU.setEditable(true);;
				txtCont.setEditable(true);;
				txtEmail.setEditable(true);;
				txtBus.setEditable(true);;
				btnAnyadir.setBackground(Color.GRAY);



			}
		});
		lblAny.setIcon(new ImageIcon("./Imagenes/vbalsd.png"));
		lblAny.setOpaque(true);
		lblAny.setBackground(Color.orange);
		lblAny.setBorder(new LineBorder(new Color(255, 200, 0), 3, true));


		//Al clickar el botón se modifcará cualquiera de los valores del usuario elegido en base a su id mediante un hilo
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Thread t= new Thread(new Runnable() {
					@Override
					public void run() {
						Conexion conexion1 = new Conexion();
						Connection cn1 = conexion1.conectar();
						PreparedStatement ps3 =null;
						try {

							ps3= cn1.prepareStatement("UPDATE Usuario SET username='"+txtNomU.getText()+"',contr='"+txtCont.getText()+"',nombre='"+txtNom.getText()+"',apellido1='"+txtApe1.getText()+"',apellido2='"+txtApe2.getText()+"',Fechanac='"+txtFecha.getText()+"',email='"+txtEmail.getText()+"'where id='"+textID.getText()+"'");

							mostrarTabla();
							int n= ps3.executeUpdate();
							if(n>0) {
								JOptionPane.showMessageDialog(null, "Cliente Modificado");
							}

						} catch (Exception e) {
							System.out.println(e);
							// TODO: handle exception
						}

						//Una vez clickado se deshabilitarán las ediciones de los campos y el botón se ocultará
						txtNomU.setEditable(false);
						txtCont.setEditable(false);
						txtNom.setEditable(false);
						txtApe1.setEditable(false);
						txtApe2.setEditable(false);
						txtFecha.setEditable(false);
						txtEmail.setEditable(false);
						btnModificar.setBackground(Color.ORANGE);
						mostrarTabla();

					}
				});
				t.start();
			}
		});
		btnModificar.setBackground(Color.ORANGE);
		btnModificar.setForeground(Color.ORANGE);
		btnModificar.setOpaque(true);
		btnModificar.setBorderPainted(false);

		btnModificar.setForeground(Color.ORANGE);
		btnModificar.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));



		JLabel lblMod = new JLabel("");
		lblMod.addMouseListener(new MouseAdapter() {
			@Override
			//Al pulsar se podrán editar los campos y además se verá el boton Modificar
			public void mouseClicked(MouseEvent e) {

				txtNom.setEditable(true);;
				txtApe1.setEditable(true);;
				txtApe2.setEditable(true);;
				txtFecha.setEditable(true);;
				txtNomU.setEditable(true);;
				txtCont.setEditable(true);;
				txtEmail.setEditable(true);;
				txtBus.setEditable(true);;
				btnModificar.setBackground(Color.GRAY);



			}
		});
		lblMod.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMod.setIcon(new ImageIcon("./Imagenes/ckvbn.png"));
		lblMod.setOpaque(true);
		lblMod.setBackground(Color.orange);
		lblMod.setBorder(new LineBorder(new Color(255, 200, 0), 3, true));

		JLabel lblAnyC = new JLabel("Añadir cliente");
		lblAnyC.setForeground(Color.ORANGE);
		lblAnyC.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));

		JLabel lblModC = new JLabel("Modificar cliente");
		lblModC.setForeground(Color.ORANGE);
		lblModC.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));

		JLabel lblEliC = new JLabel("Eliminar cliente");
		lblEliC.setForeground(Color.ORANGE);
		lblEliC.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));
		textID = new JTextField();
		textID.setBackground(Color.GRAY);
		textID.setForeground(Color.GRAY);
		textID.setOpaque(true);
		textID.setBorder(null);

		textID.setEditable(false);
		textID.setColumns(10);

		table= new JTable();
		table.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		table.setSelectionBackground(Color.ORANGE);
		table.addMouseListener(new MouseAdapter() {

			//Al clickar cualquier usuario de la tabla sus valores aparecerán en los campos superiores
			@Override
			public void mouseClicked(MouseEvent e) {

				int seleccion= table.rowAtPoint(e.getPoint());
				txtNomU.setText(String.valueOf(table.getValueAt(seleccion, 1)));
				txtCont.setText(String.valueOf(table.getValueAt(seleccion, 2)));
				txtNom.setText(String.valueOf(table.getValueAt(seleccion, 3)));
				txtApe1.setText(String.valueOf(table.getValueAt(seleccion, 4)));
				txtApe2.setText(String.valueOf(table.getValueAt(seleccion, 5)));
				txtFecha.setText(String.valueOf(table.getValueAt(seleccion, 6)));
				txtEmail.setText(String.valueOf(table.getValueAt(seleccion, 7)));
				textID.setText(String.valueOf(table.getValueAt(seleccion,0)));
				
			}
		});

		

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));

		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));

		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));

		JLabel lblNewLabel_3 = new JLabel("Apellido 1");
		lblNewLabel_3.setForeground(Color.ORANGE);
		lblNewLabel_3.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));

		JLabel lblNewLabel_4 = new JLabel("Apellido 2");
		lblNewLabel_4.setForeground(Color.ORANGE);
		lblNewLabel_4.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));

		JLabel lblNewLabel_5 = new JLabel("Fecha Nacimiento");
		lblNewLabel_5.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		lblNewLabel_5.setForeground(Color.ORANGE);

		JLabel lblNewLabel_6 = new JLabel("Email");
		lblNewLabel_6.setForeground(Color.ORANGE);
		lblNewLabel_6.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));

		JLabel lblNewLabel_7 = new JLabel("Contraseña");
		lblNewLabel_7.setForeground(Color.ORANGE);
		lblNewLabel_7.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addGap(140)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPanel.createSequentialGroup()
														.addComponent(lblNewLabel)
														.addGap(0)
														.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
																.addGroup(gl_contentPanel.createSequentialGroup()
																		.addGap(18)
																		.addComponent(lblNewLabel_1)
																		.addGap(11)
																		.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
																				.addGroup(gl_contentPanel.createSequentialGroup()
																						.addPreferredGap(ComponentPlacement.RELATED)
																						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
																								.addComponent(lblApe1)
																								.addComponent(lblApe2)
																								.addComponent(lblFecha)
																								.addComponent(lblNom))
																						.addGap(27)
																						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
																								.addComponent(txtNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																								.addComponent(txtApe1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																								.addComponent(txtApe2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																								.addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
																				.addGroup(gl_contentPanel.createSequentialGroup()
																						.addGap(30)
																						.addComponent(lblNewLabel_7)
																						.addGap(18)
																						.addComponent(lblNewLabel_2)
																						.addGap(41)
																						.addComponent(lblNewLabel_3)
																						.addGap(27)
																						.addComponent(lblNewLabel_4)))
																		.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
																				.addGroup(gl_contentPanel.createSequentialGroup()
																						.addGap(18)
																						.addComponent(lblNewLabel_5)
																						.addGap(18)
																						.addComponent(lblNewLabel_6))
																				.addGroup(gl_contentPanel.createSequentialGroup()
																						.addGap(88)
																						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
																								.addComponent(lblContr)
																								.addComponent(lblNomU)
																								.addComponent(lblEmail))))
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
																				.addGroup(gl_contentPanel.createSequentialGroup()
																						.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
																						.addComponent(textID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
																				.addGroup(gl_contentPanel.createSequentialGroup()
																						.addGap(18)
																						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
																								.addComponent(txtNomU, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																								.addComponent(txtCont, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																								.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)))))
																.addGroup(gl_contentPanel.createSequentialGroup()
																		.addGap(193)
																		.addComponent(lblBus)
																		.addGap(18)
																		.addComponent(txtBus, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE))))
												.addGroup(gl_contentPanel.createSequentialGroup()
														.addComponent(table, GroupLayout.PREFERRED_SIZE, 686, GroupLayout.PREFERRED_SIZE)
														.addGap(34)
														.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
																.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
																		.addComponent(lblMod, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																		.addComponent(lblEli, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
																.addComponent(lblAny, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
																.addComponent(lblModC)
																.addComponent(lblEliC)
																.addComponent(lblAnyC))))
										.addGap(14))
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addGap(347)
										.addComponent(lblGC, GroupLayout.PREFERRED_SIZE, 432, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		gl_contentPanel.setVerticalGroup(
				gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addGap(31)
						.addComponent(lblGC)
						.addGap(55)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNom)
								.addComponent(lblNomU)
								.addComponent(txtNomU, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtApe1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblApe1)
								.addComponent(lblContr)
								.addComponent(txtCont, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtApe2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblApe2)
								.addComponent(lblEmail)
								.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFecha)
								.addComponent(textID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(55)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(txtBus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblBus))
						.addGap(95)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addComponent(lblAny, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(lblMod, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
										.addGap(97))
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
														.addComponent(lblNewLabel)
														.addComponent(lblNewLabel_7)
														.addComponent(lblNewLabel_2)
														.addComponent(lblNewLabel_1))
												.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
														.addComponent(lblNewLabel_3)
														.addComponent(lblNewLabel_4)
														.addComponent(lblNewLabel_5)
														.addComponent(lblNewLabel_6)))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_contentPanel.createSequentialGroup()
														.addComponent(lblAnyC)
														.addGap(75)
														.addComponent(lblModC)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
																.addGroup(gl_contentPanel.createSequentialGroup()
																		.addGap(41)
																		.addComponent(lblEli, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
																.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
																		.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																		.addComponent(lblEliC)
																		.addGap(39))))
												.addComponent(table, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)))))
				);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.ORANGE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.add(btnModificar);
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});



				buttonPane.add(btnAnyadir);

				cancelButton.setForeground(Color.ORANGE);
				cancelButton.setBackground(Color.GRAY);
				cancelButton.setOpaque(true);
				cancelButton.setBorderPainted(false);
				cancelButton.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		ScrollPane scrollPane = new ScrollPane();
		
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		scrollPane.add(table);
	}

	

	//Creamos la tabla de los clientes
	static void mostrarTabla() {
		DefaultTableModel modelo= new DefaultTableModel();
		ResultSet rs= Conexion.getTabla("select id,Username, contr, nombre, apellido1, apellido2, Fechanac, email from Usuario");
		modelo.addColumn("Id");
		modelo.addColumn("Nombre de usuario");
		modelo.addColumn("Contraseña");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido 1");
		modelo.addColumn("Apellido 2");
		modelo.addColumn("Fecha de Nacimiento");
		modelo.addColumn("Email");



		try {
			while(rs.next()) {
				modelo.addRow(new Object[] {rs.getInt("id"),rs.getString("Username"),rs.getString("contr"),rs.getString("nombre"),rs.getString("apellido1"),
						rs.getString("apellido2"),rs.getString("Fechanac"),rs.getString("email")});
			}
			table.setModel(modelo);
			TableColumnModel columnmodel= table.getColumnModel();
			columnmodel.getColumn(0).setPreferredWidth(15);
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
