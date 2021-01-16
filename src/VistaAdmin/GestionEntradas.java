package VistaAdmin;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Conexion.Conexion;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**
 * Ventana donde se gestionan las entradas
 * @author alex
 *
 */
public class GestionEntradas extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JTextField textCod;
	private JTextField textPel;
	private JTextField textSala;
	private JTextField txtPrec;
	private JTextField txtPrecT;
	private JTextField textBus;
	private JTextField textNombre;
	static DefaultTableModel modelo;
	private static  JTable table;
	private JTextField textHor;
	private JTextField textCant;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GestionEntradas dialog = new GestionEntradas();
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
	public GestionEntradas() {
		setBounds(250,50,1200,900);
		contentPanel.setBackground(Color.GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		JLabel lblGE = new JLabel("Gestión Entradas - CineDeusto");
		lblGE.setForeground(Color.ORANGE);
		lblGE.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 25));

		//Boton guardar escondido
		JButton btnAny = new JButton("Añadir");
		btnAny.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				Thread t= new Thread(new Runnable() {
					@Override
					public void run() {
						Conexion conexion1 = new Conexion();
						Connection cn1 = conexion1.conectar();

						String nombre= textNombre.getText();
						String id= textCod.getText();
						String horario= textHor.getText();
						String cantidad= textCant.getText();
						String titulo= textPel.getText();
						String precioU= txtPrec.getText();
						String precioT= txtPrecT.getText();
						String sala= textSala.getText();

						String sql= "INSERT INTO Entrada (idEntrada, titulo, horario, cantidad, sala, precioU, precioT, nombre) VALUES(?,?,?,?,?,?,?,?)";
						PreparedStatement ps1= null;

						try {
							PreparedStatement pst1 = cn1.prepareStatement(sql);

							pst1.setString(1, id);
							pst1.setString(2, titulo);
							pst1.setString(3, horario);
							pst1.setString(4, cantidad);
							pst1.setString(5, sala);
							pst1.setString(6, precioU);
							pst1.setString(7, precioT);
							pst1.setString(8, nombre);



							int n = pst1.executeUpdate();
							if(n>0) {
								JOptionPane.showMessageDialog(null, "Entrada añadida");

								mostrarTabla();
							}
							//Una vez añadidos los campos se deshabilitarán y el botón se ocultará
							textNombre.setEditable(false);
							textCod.setEditable(false);
							txtPrec.setEditable(false);
							txtPrecT.setEditable(false);
							textSala.setEditable(false);
							textHor.setEditable(false);
							textPel.setEditable(false);
							textCant.setEditable(false);

							btnAny.setBackground(Color.ORANGE);
							btnAny.setEnabled(false);

						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "ERROR");
						}
					}});
				t.start();
			}

		});
		btnAny.setBackground(Color.ORANGE);
		btnAny.setForeground(Color.ORANGE);
		btnAny.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
		btnAny.setOpaque(true);
		btnAny.setBorderPainted(false);

		JLabel lblAny = new JLabel("");
		lblAny.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textCod.setEditable(true);
				textPel.setEditable(true);
				textSala.setEditable(true);
				textNombre.setEditable(true);
				txtPrec.setEditable(true);
				txtPrecT.setEditable(true);

				btnAny.setBackground(Color.GRAY);
			}
		});
		lblAny.setHorizontalAlignment(SwingConstants.CENTER);
		lblAny.setBackground(Color.ORANGE);
		lblAny.setOpaque(true);
		lblAny.setIcon(new ImageIcon("./Imagenes/gafuk.png"));
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

							ps3= cn1.prepareStatement("UPDATE Entrada SET nombre='"+textNombre.getText()+"',titulo='"+textPel.getText()+"',cantidad='"+textCant.getText()+"',horario='"+textHor.getText()+"',sala='"+textSala.getText()+"'where IdEntrada='"+textCod.getText()+"'");

							mostrarTabla();
							int n= ps3.executeUpdate();
							if(n>0) {
								JOptionPane.showMessageDialog(null, "Entrada Modificada");
							}

						} catch (Exception e) {
							System.out.println(e);
							// TODO: handle exception
						}

						//Una vez clickado se deshabilitarán las ediciones de los campos y el botón se ocultará
						textNombre.setEditable(false);
						textSala.setEditable(false);
						txtPrecT.setEditable(false);
						textHor.setEditable(false);
						textCant.setEditable(false);
						textPel.setEditable(false);
						;
						btnModificar.setBackground(Color.ORANGE);

					}
				});
				t.start();

			}
		});
		btnModificar.setBackground(Color.ORANGE);
		btnModificar.setForeground(Color.ORANGE);
		btnModificar.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
		btnModificar.setOpaque(true);

		btnModificar.setBorderPainted(false);

		JLabel lblMod = new JLabel("");
		lblMod.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textPel.setEditable(true);
				textSala.setEditable(true);
				textNombre.setEditable(true);
				txtPrecT.setEditable(true);
				textCant.setEditable(true);
				textHor.setEditable(true);

				btnModificar.setBackground(Color.GRAY);
			}
		});
		lblMod.setHorizontalAlignment(SwingConstants.CENTER);
		lblMod.setIcon(new ImageIcon("./Imagenes/ckvbn.png"));
		lblMod.setBackground(Color.ORANGE);
		lblMod.setOpaque(true);


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

						ps= conect.prepareStatement("Delete from Entrada where idEntrada=?");
						ps.setString(1, codigo);
						int n= ps.executeUpdate();

						if(n>0) {
							JOptionPane.showMessageDialog(null, "Entrada Eliminada");
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
		lblEli.setBackground(Color.ORANGE);
		lblEli.setOpaque(true);
		lblEli.setIcon(new ImageIcon("./Imagenes/dsjn.png"));

		JLabel lblAnyE = new JLabel("Añadir Entrada");
		lblAnyE.setForeground(Color.ORANGE);
		lblAnyE.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));

		JLabel lblModE = new JLabel("Modificar Entrada");
		lblModE.setForeground(Color.ORANGE);
		lblModE.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));

		JLabel lblEliE = new JLabel("Eliminar Entrada");
		lblEliE.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));
		lblEliE.setForeground(Color.ORANGE);

		JLabel lblCod = new JLabel("Código");
		lblCod.setForeground(Color.ORANGE);
		lblCod.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));

		JLabel lblPel = new JLabel("Película");
		lblPel.setForeground(Color.ORANGE);
		lblPel.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));

		JLabel lblHor = new JLabel("Horario");
		lblHor.setForeground(Color.ORANGE);
		lblHor.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));

		JLabel lblCant = new JLabel("Cantidad");
		lblCant.setForeground(Color.ORANGE);
		lblCant.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));

		JLabel lblSala = new JLabel("Sala");
		lblSala.setForeground(Color.ORANGE);
		lblSala.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));

		JLabel lblPrec = new JLabel("Precio");
		lblPrec.setForeground(Color.ORANGE);
		lblPrec.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));

		JLabel lblPrecT = new JLabel("TOTAL");
		lblPrecT.setForeground(Color.ORANGE);
		lblPrecT.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));

		textCod = new JTextField();
		textCod.setEditable(false);
		textCod.setColumns(10);

		textPel = new JTextField();
		textPel.setEditable(false);
		textPel.setColumns(10);

		textSala = new JTextField();
		textSala.setEditable(false);
		textSala.setColumns(10);

		txtPrec = new JTextField();
		txtPrec.setEditable(false);
		txtPrec.setColumns(10);

		txtPrecT = new JTextField();
		txtPrecT.setEditable(false);
		txtPrecT.setColumns(10);
		SpinnerNumberModel modeloSpinner = new SpinnerNumberModel();
		modeloSpinner.setMaximum(10);
		modeloSpinner.setMinimum(1);

		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setColumns(10);
		textHor = new JTextField();
		textHor.setColumns(10);
		textHor.setEditable(false);

		textCant = new JTextField();
		textCant.setColumns(10);
		textCant.setEditable(false);

		textBus = new JTextField();
		textBus.setBackground(Color.ORANGE);
		textBus.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				String[] titulos= {"ID", "Nombre","Título", "Horario", "Sala", "Cantidad", "Precio Unidad", "Precio Total"};
				String[] datos= new String[50];


				String sql= "SELECT *FROM Entrada WHERE nombre LIKE '%"+ textBus.getText()+ "%'" + "OR IdEntrada like '%"+textBus.getText()+"%'"+
						"OR titulo LIKE '%"+ textBus.getText()+"%'"+	"OR cantidad LIKE '%"+ textBus.getText()+"%'" +
						"OR precioT LIKE '%"+ textBus.getText()+"%'"+
						"OR horario LIKE '%"+ textBus.getText()+"%'"+
						"OR sala LIKE '%"+ textBus.getText()+"%'";
				modelo= new DefaultTableModel(null,titulos);
				Conexion cc= new Conexion();
				Connection conect= cc.conectar();



				try {
					Statement stmt= (Statement) conect.createStatement();
					ResultSet rs= stmt.executeQuery(sql);
					while(rs.next()) {
						datos[0]= rs.getString("idEntrada");
						datos[1]= rs.getString("nombre");
						datos[2]= rs.getString("titulo");
						datos[3]= rs.getString("horario");
						datos[4]= rs.getString("sala");
						datos[5]= rs.getString("cantidad");
						datos[6]= rs.getString("precioU");
						datos[7]= rs.getString("precioT");

						modelo.addRow(datos);



					}
					table.setModel(modelo);
					TableColumnModel columnmodel= table.getColumnModel();
					columnmodel.getColumn(0).setPreferredWidth(30);
					columnmodel.getColumn(1).setPreferredWidth(20);
					columnmodel.getColumn(2).setPreferredWidth(120);
					columnmodel.getColumn(3).setPreferredWidth(80);
					columnmodel.getColumn(7).setPreferredWidth(20);

				} catch (Exception ex) {
					System.out.println(ex);
				}

			}
		});
		textBus.setColumns(10);

		JLabel lblBus = new JLabel("Buscar");
		lblBus.setForeground(Color.ORANGE);
		lblBus.setFont(new Font("Lucida Grande", Font.PLAIN, 18));

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.ORANGE);
		lblNombre.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));



		table =new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int seleccion= table.rowAtPoint(e.getPoint());
				textCod.setText(String.valueOf(table.getValueAt(seleccion, 0)));
				textPel.setText(String.valueOf(table.getValueAt(seleccion, 2)));
				textSala.setText(String.valueOf(table.getValueAt(seleccion, 5)));
				txtPrec.setText(String.valueOf(table.getValueAt(seleccion, 6)));
				txtPrecT.setText(String.valueOf(table.getValueAt(seleccion, 7)));
				textNombre.setText(String.valueOf(table.getValueAt(seleccion, 1)));
				textCant.setText(String.valueOf(table.getValueAt(seleccion, 4)));
				textHor.setText(String.valueOf(table.getValueAt(seleccion, 3)));



			}

		});

		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));

		JLabel lblNewLabel_2 = new JLabel("Título");
		lblNewLabel_2.setForeground(Color.ORANGE);

		JLabel lblNewLabel_3 = new JLabel("Horario");
		lblNewLabel_3.setForeground(Color.ORANGE);
		lblNewLabel_3.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));

		JLabel lblNewLabel_4 = new JLabel("Cantidad");
		lblNewLabel_4.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		lblNewLabel_4.setForeground(Color.ORANGE);

		JLabel lblNewLabel_5 = new JLabel("Precio Entrada");
		lblNewLabel_5.setForeground(Color.ORANGE);
		lblNewLabel_5.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));

		JLabel lblNewLabel_6 = new JLabel("Total");
		lblNewLabel_6.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		lblNewLabel_6.setForeground(Color.ORANGE);

		JLabel lblNewLabel_7 = new JLabel("Sala");
		lblNewLabel_7.setForeground(Color.ORANGE);
		lblNewLabel_7.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));



		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
				gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addGap(158)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
												.addComponent(lblCant)
												.addComponent(lblHor)
												.addGroup(gl_contentPanel.createSequentialGroup()
														.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
																.addComponent(lblCod)
																.addComponent(lblPel)
																.addComponent(lblSala))
														.addGap(61)
														.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
																.addComponent(textSala, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																.addGroup(gl_contentPanel.createSequentialGroup()
																		.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
																				.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
																						.addComponent(textCod, Alignment.TRAILING)
																						.addComponent(textPel, Alignment.TRAILING))
																				.addComponent(textHor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																				.addComponent(textCant, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(ComponentPlacement.RELATED, 281, Short.MAX_VALUE)
																		.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
																				.addComponent(lblPrecT)
																				.addComponent(lblPrec)
																				.addComponent(lblNombre)))
																.addGroup(gl_contentPanel.createSequentialGroup()
																		.addComponent(lblNewLabel_2)
																		.addGap(66)
																		.addComponent(lblNewLabel_3)
																		.addGap(32)
																		.addComponent(lblNewLabel_4)
																		.addGap(18)
																		.addComponent(lblNewLabel_7)
																		.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
																		.addComponent(lblNewLabel_5)
																		.addGap(26)
																		.addComponent(lblNewLabel_6)
																		.addGap(4)))))
										.addGap(45)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
												.addComponent(txtPrec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtPrecT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addGap(478)
										.addComponent(lblGE))
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addGap(138)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPanel.createSequentialGroup()
														.addComponent(lblNewLabel)
														.addGap(46)
														.addComponent(lblNewLabel_1))
												.addGroup(gl_contentPanel.createSequentialGroup()
														.addComponent(table, GroupLayout.PREFERRED_SIZE, 664, GroupLayout.PREFERRED_SIZE)
														.addGap(96)
														.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
																.addComponent(lblAny, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(lblEli, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(lblMod, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
						.addGap(48)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEliE)
								.addComponent(lblModE)
								.addComponent(lblAnyE))
						.addGap(31))
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addContainerGap(455, Short.MAX_VALUE)
						.addComponent(lblBus)
						.addGap(29)
						.addComponent(textBus, GroupLayout.PREFERRED_SIZE, 364, GroupLayout.PREFERRED_SIZE)
						.addGap(286))
				);
		gl_contentPanel.setVerticalGroup(
				gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addGap(42)
						.addComponent(lblGE)
						.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblCod)
												.addComponent(textCod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPanel.createSequentialGroup()
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
																.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																.addComponent(lblNombre))
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
																.addComponent(lblPrec)
																.addComponent(txtPrec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
														.addGap(22)
														.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
																.addComponent(lblPrecT)
																.addComponent(txtPrecT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
												.addGroup(gl_contentPanel.createSequentialGroup()
														.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
																.addGroup(gl_contentPanel.createSequentialGroup()
																		.addPreferredGap(ComponentPlacement.UNRELATED)
																		.addComponent(lblPel)
																		.addPreferredGap(ComponentPlacement.UNRELATED)
																		.addComponent(lblHor))
																.addGroup(gl_contentPanel.createSequentialGroup()
																		.addGap(4)
																		.addComponent(textPel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.UNRELATED)
																		.addComponent(textHor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
																.addComponent(textCant, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																.addComponent(lblCant))))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblSala)
												.addComponent(textSala, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(77)
										.addComponent(textBus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblBus))
						.addGap(81)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_4)
								.addComponent(lblNewLabel_6)
								.addComponent(lblNewLabel_5)
								.addComponent(lblNewLabel_7))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addComponent(lblAny, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(lblMod, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
										.addGap(27)
										.addComponent(lblEli, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
								.addComponent(table, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(45, Short.MAX_VALUE))
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addContainerGap(528, Short.MAX_VALUE)
						.addComponent(lblAnyE)
						.addGap(75)
						.addComponent(lblModE)
						.addGap(80)
						.addComponent(lblEliE)
						.addGap(80))
				);
		contentPanel.setLayout(gl_contentPanel);
		{
			buttonPane = new JPanel();
			buttonPane.setBackground(Color.ORANGE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{

				JButton cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}

				});


				buttonPane.add(btnModificar);


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
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, 1200, GroupLayout.PREFERRED_SIZE)
				.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, 1200, GroupLayout.PREFERRED_SIZE)
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, 839, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
		getContentPane().setLayout(groupLayout);
	}

	public static void mostrarTabla() {
		String[] titulos= {"ID", "Nombre","Título", "Horario", "Sala", "Cantidad", "Precio Unidad", "Precio Total"};
		String[] datos= new String[50];

		String sql= "SELECT idEntrada, titulo, horario,cantidad, sala,precioU,precioT, nombre from Entrada";
		modelo = new DefaultTableModel(null,titulos);
		Conexion cc= new Conexion();
		Connection conect= Conexion.conectar();
		try {
			Statement stmt= (Statement) conect.createStatement();
			ResultSet rs= stmt.executeQuery(sql);
			while(rs.next()) {
				datos[0]= String.valueOf(rs.getInt("idEntrada"));
				datos[1]= rs.getString("Nombre");
				datos[2]= rs.getString("titulo");
				datos[3]= rs.getString("horario");
				datos[4]= rs.getString("cantidad");
				datos[5]= rs.getString("sala");
				datos[6]= rs.getString("precioU");
				datos[7]= rs.getString("precioT");

				modelo.addRow(datos);
			}
			table.setModel(modelo);
			TableColumnModel columnmodel= table.getColumnModel();
			columnmodel.getColumn(0).setPreferredWidth(30);
			columnmodel.getColumn(1).setPreferredWidth(20);
			columnmodel.getColumn(2).setPreferredWidth(120);
			columnmodel.getColumn(3).setPreferredWidth(80);
			columnmodel.getColumn(7).setPreferredWidth(20);



		} catch (Exception e) {
			System.out.println(e);
		}
		// TODO: handle exception
	}
}
