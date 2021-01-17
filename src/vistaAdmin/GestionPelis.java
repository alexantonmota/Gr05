package vistaAdmin;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import db.Conexion;
/**
 * Ventana para gestionar peliculas
 * @author alex
 *
 */
public class GestionPelis extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblGP;
	private JTextField txtTit;
	private JTextField txtAny;
	private JTextField txtDur;
	private JTextField txtTrailer;
	private JTextField txtBus;
	private JTextField textPos;
	private JTextField textPosM;
	static DefaultTableModel modelo;
	private static JTable table;
	private JTextField txtGenero;
	private JTextField textSala;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GestionPelis dialog = new GestionPelis();
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
	public GestionPelis() {
		setBounds(250, 50, 1200, 900);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.EAST);
		{
			lblGP = new JLabel("Gestión Películas - Cine Deusto");
			lblGP.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 25));
			lblGP.setForeground(Color.ORANGE);
		}





		txtTit = new JTextField();
		txtTit.setEditable(false);
		txtTit.setColumns(10);

		txtAny = new JTextField();
		txtAny.setEditable(false);
		txtAny.setColumns(10);

		txtDur = new JTextField();
		txtDur.setEditable(false);
		txtDur.setColumns(10);

		txtTrailer = new JTextField();
		txtTrailer.setEditable(false);
		txtTrailer.setColumns(10);



		txtBus = new JTextField();
		txtBus.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				String[]titulos= {"ID","Título","Año","Género","Sinopsis","Duracion", "Trailer","Ruta Poster","Ruta Cartel", "Sala"};
				String[]datos= new String[50];
			    modelo= new DefaultTableModel(null,titulos);


				String sql= "SELECT *FROM Pelicula WHERE titulo LIKE '%"+ txtBus.getText()+ "%'" +
						"OR genero LIKE '%"+ txtBus.getText()+"%'"+
								"OR anyo LIKE '%"+ txtBus.getText()+"%'"+
										"OR duracion LIKE '%"+ txtBus.getText()+"%'";
				
				Conexion cc= new Conexion();
				Connection conect= cc.conectar();



				try {
					Statement stmt= (Statement) conect.createStatement();
					ResultSet rs= stmt.executeQuery(sql);
					while(rs.next()) {
						datos[0]= rs.getString("id");
						datos[1]= rs.getString("titulo");
						datos[2]= rs.getString("anyo");
						datos[3]= rs.getString("genero");
						datos[4]= rs.getString("sinopsis");
						datos[5]= String.valueOf(rs.getInt("duracion"));			
						datos[6]= rs.getString("trailer");
						datos[7]= rs.getString("nomPoster");
						datos[8]= rs.getString("nomPMenu");		
						datos[9]= String.valueOf(rs.getInt("sala"));
						
						
						modelo.addRow(datos);



					}
					table.setModel(modelo);
					table.setSelectionBackground(Color.ORANGE);
					TableColumnModel columnmodel= table.getColumnModel();
					columnmodel.getColumn(0).setPreferredWidth(20);
					columnmodel.getColumn(1).setPreferredWidth(140);
					
					
				} catch (Exception ex) {
					System.out.println(ex);
				}
			
			}
			
			
		});
		
		txtBus.setBackground(Color.ORANGE);
		txtBus.setColumns(10);

		JLabel lblTit = new JLabel("Titulo");
		lblTit.setForeground(Color.ORANGE);
		lblTit.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));

		JLabel lblGen = new JLabel("Género");
		lblGen.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));
		lblGen.setForeground(Color.ORANGE);

		JLabel lblAnyo = new JLabel("Año");
		lblAnyo.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));
		lblAnyo.setForeground(new Color(255, 200, 0));

		JLabel lblDur = new JLabel("Duración");
		lblDur.setForeground(Color.ORANGE);
		lblDur.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));

		JLabel lblNomU = new JLabel("Sinopsis");
		lblNomU.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));
		lblNomU.setForeground(Color.ORANGE);

		JLabel lblContr = new JLabel("");
		lblContr.setForeground(Color.ORANGE);
		lblContr.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));

		JLabel lblTrai = new JLabel("Tráiler");
		lblTrai.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));
		lblTrai.setForeground(Color.ORANGE);

		JLabel lblBus = new JLabel("Buscar");
		lblBus.setForeground(Color.ORANGE);
		lblBus.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));

		JLabel lblEli = new JLabel("");
		lblEli.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				Conexion cc= new Conexion();
				Connection conect= cc.conectar();

				int fila= table.getSelectedRow();
				int codigo= Integer.parseInt(table.getValueAt(fila, 0).toString());


				if(fila>0) {
					PreparedStatement ps=null;

					try {

						ps= conect.prepareStatement("Delete from Pelicula where id=?");
						ps.setInt(1, codigo);
						ps.execute();
						JOptionPane.showMessageDialog(null, "Película Eliminada");

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

		JLabel lblAny = new JLabel("");
		lblAny.setHorizontalAlignment(SwingConstants.CENTER);
		lblAny.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GestionPelicula gestionpeli= new GestionPelicula();
				gestionpeli.setVisible(true);


			}
		});
		lblAny.setIcon(new ImageIcon("./Imagenes/gafuk.png"));
		lblAny.setOpaque(true);
		lblAny.setBackground(Color.orange);
		lblAny.setBorder(new LineBorder(new Color(255, 200, 0), 3, true));



		JLabel lblAnyP = new JLabel("Añadir Película");
		lblAnyP.setForeground(Color.ORANGE);
		lblAnyP.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));

		JLabel lblEliP = new JLabel("Eliminar Película");
		lblEliP.setForeground(Color.ORANGE);
		lblEliP.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));

		JTextPane textSinopsis = new JTextPane();
		textSinopsis.setEditable(false);

		JLabel lblPos = new JLabel("");
		lblPos.setBorder(BorderFactory.createLineBorder(Color.ORANGE,4));

		JLabel lblPosMenu = new JLabel("");
		lblPosMenu.setBorder(BorderFactory.createLineBorder(Color.ORANGE,4));

		JButton btnSPos = new JButton("");
		btnSPos.setEnabled(false);
		btnSPos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				//Filtrar solo imagenes 

				/**
				 * Seleccion de imagen con filtro de archivos de imagen
				 */
				FileNameExtensionFilter filtroImagen=new FileNameExtensionFilter("JPG, PNG & GIF","jpg","png","gif");
				JFileChooser archivo= new JFileChooser();
				archivo.setFileFilter(filtroImagen);
				int r=archivo.showOpenDialog(null);
				if(r == JFileChooser.APPROVE_OPTION) {

					File file = archivo.getSelectedFile();
					textPos.setText(String.valueOf(file));
					Image foto= getToolkit().getImage(textPos.getText());
					foto= foto.getScaledInstance(100, 130, Image.SCALE_DEFAULT);
					lblPos.setIcon(new ImageIcon(foto));
				}

			}
		});
		btnSPos.setBackground(Color.ORANGE);
		btnSPos.setOpaque(true);
		btnSPos.setBorderPainted(false);
		btnSPos.setIcon(new ImageIcon("./Imagenes/fnnn.png"));

		JButton btnSubPMenu = new JButton("");
		btnSubPMenu.setEnabled(false);
		btnSubPMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Filtrar solo imagenes 
				FileNameExtensionFilter filtroImagen=new FileNameExtensionFilter("JPG, PNG & GIF","jpg","png","gif");
				JFileChooser archivo= new JFileChooser();
				archivo.setFileFilter(filtroImagen);
				int r=archivo.showOpenDialog(null);
				if(r == JFileChooser.APPROVE_OPTION) {

					File file = archivo.getSelectedFile();
					textPosM.setText(String.valueOf(file));
					Image foto= getToolkit().getImage(textPosM.getText());
					foto= foto.getScaledInstance(200, 78, Image.SCALE_DEFAULT);
					lblPosMenu.setIcon(new ImageIcon(foto));
				}

			}
		});
		//Habilitar edición de campos al pulsar modificar

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(Color.ORANGE);
		btnGuardar.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
		btnGuardar.setForeground(Color.ORANGE);
		btnGuardar.setOpaque(true);
		btnGuardar.setBorderPainted(false);

		btnSubPMenu.setBackground(Color.ORANGE);
		btnSubPMenu.setOpaque(true);
		btnSubPMenu.setBorderPainted(false);
		btnSubPMenu.setIcon(new ImageIcon("./Imagenes/fnnn.png"));

		textPos = new JTextField();
		textPos.setEditable(false);
		textPos.setColumns(10);

		textPosM = new JTextField();
		textPosM.setEditable(false);
		textPosM.setColumns(10);

		JLabel lblRutaP = new JLabel("Póster");
		lblRutaP.setForeground(Color.ORANGE);
		lblRutaP.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));

		JLabel lblRPostM = new JLabel("Póster Menú");
		lblRPostM.setForeground(Color.ORANGE);
		lblRPostM.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));
		
		table = new JTable();
		table.setForeground(Color.BLACK);
		table.addMouseListener(new MouseAdapter() {
			@Override
			//Autorrelleno de los campos al seccionar fila de la tabla
			public void mouseClicked(MouseEvent e) {
				int seleccion= table.rowAtPoint(e.getPoint());
				txtTit.setText(String.valueOf(table.getValueAt(seleccion, 1)));
				txtAny.setText(String.valueOf(table.getValueAt(seleccion, 2)));
				txtGenero.setText(String.valueOf(table.getValueAt(seleccion, 3)));
				textSinopsis.setText(String.valueOf(table.getValueAt(seleccion, 4)));
				txtDur.setText(String.valueOf(table.getValueAt(seleccion, 5)));
				txtTrailer.setText(String.valueOf(table.getValueAt(seleccion, 6)));
				textPos.setText(String.valueOf(table.getValueAt(seleccion, 7)));
				textPosM.setText(String.valueOf(table.getValueAt(seleccion, 8)));
				textSala.setText(String.valueOf(table.getValueAt(seleccion, 9)));
				ImageIcon image = new ImageIcon((String.valueOf(table.getValueAt(seleccion, 7))));
				
				Image img=image.getImage();
				ImageIcon img2=new ImageIcon(img.getScaledInstance(98, 150, Image.SCALE_SMOOTH));
				
				lblPos.setIcon(img2);
				
				ImageIcon image2 = new ImageIcon((String.valueOf(table.getValueAt(seleccion, 8))));
				
				Image img3=image2.getImage();
				ImageIcon img4=new ImageIcon(img3.getScaledInstance(200, 120, Image.SCALE_SMOOTH));
				
				lblPosMenu.setIcon(img4);
				
				
				
				
				
			}
		});
		
		txtGenero = new JTextField();
		txtGenero.setEditable(false);
		txtGenero.setColumns(10);
		
		JLabel lblSala = new JLabel("Sala");
		lblSala.setForeground(Color.ORANGE);
		lblSala.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));
		
		textSala = new JTextField();
		textSala.setEditable(false);
		textSala.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		
		JLabel lblNewLabel_1 = new JLabel("Título");
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		
		JLabel lblNewLabel_2 = new JLabel("Género");
		lblNewLabel_2.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		lblNewLabel_2.setForeground(Color.ORANGE);
		
		JLabel lblNewLabel_3 = new JLabel("Año");
		lblNewLabel_3.setForeground(Color.ORANGE);
		lblNewLabel_3.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		
		JLabel lblNewLabel_4 = new JLabel("Sinopsis");
		lblNewLabel_4.setForeground(Color.ORANGE);
		lblNewLabel_4.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		
		JLabel lblNewLabel_5 = new JLabel("Duracion");
		lblNewLabel_5.setForeground(Color.ORANGE);
		lblNewLabel_5.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		
		JLabel lblNewLabel_6 = new JLabel("Trailer");
		lblNewLabel_6.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		lblNewLabel_6.setForeground(Color.ORANGE);
		
		JLabel lblNewLabel_7 = new JLabel("Ruta P");
		lblNewLabel_7.setForeground(Color.ORANGE);
		lblNewLabel_7.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		
		JLabel lblNewLabel_8 = new JLabel("Ruta M");
		lblNewLabel_8.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		lblNewLabel_8.setForeground(Color.ORANGE);
		
		JLabel lblNewLabel_9 = new JLabel("Sala");
		lblNewLabel_9.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		lblNewLabel_9.setForeground(Color.ORANGE);


		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(table, GroupLayout.PREFERRED_SIZE, 658, GroupLayout.PREFERRED_SIZE)
									.addGap(31)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblEli, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblAny, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
									.addGap(32)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblAnyP)
										.addComponent(lblEliP)))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblPosMenu, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPanel.createSequentialGroup()
											.addComponent(lblNewLabel)
											.addGap(18)
											.addComponent(lblNewLabel_1)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblNewLabel_3)
											.addGap(37)))
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPanel.createSequentialGroup()
											.addGap(14)
											.addComponent(btnSubPMenu, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPanel.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblNewLabel_2)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(lblNewLabel_4)
											.addGap(18)
											.addComponent(lblNewLabel_5)
											.addGap(26)
											.addComponent(lblNewLabel_6)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(lblNewLabel_7)
											.addGap(18)
											.addComponent(lblNewLabel_8)
											.addGap(18)
											.addComponent(lblNewLabel_9)))))
							.addGap(60))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap(239, Short.MAX_VALUE)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblPos, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
									.addGap(42))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(btnSPos, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
									.addGap(81)))
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblGen)
										.addComponent(lblTit)
										.addComponent(lblDur))
									.addGap(47)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(txtGenero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblContr)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
											.addComponent(txtTit, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(txtAny, 140, 140, 140))
										.addComponent(txtDur, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addComponent(lblAnyo))
							.addGap(170)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNomU)
								.addComponent(lblTrai)
								.addComponent(lblRutaP)
								.addComponent(lblSala))
							.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(textSala, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(Alignment.TRAILING, gl_contentPanel.createParallelGroup(Alignment.LEADING)
									.addComponent(txtTrailer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPanel.createSequentialGroup()
											.addComponent(textPos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
											.addComponent(lblRPostM)
											.addGap(18)
											.addComponent(textPosM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(textSinopsis, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 416, GroupLayout.PREFERRED_SIZE))))))
					.addGap(49))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(347)
					.addComponent(lblGP, GroupLayout.PREFERRED_SIZE, 432, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(607, Short.MAX_VALUE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap(608, Short.MAX_VALUE)
					.addComponent(lblBus)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtBus, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
					.addGap(427))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(31)
					.addComponent(lblGP)
					.addGap(55)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblContr)
									.addComponent(lblDur)
									.addComponent(txtDur, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(16))
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
									.addComponent(lblPos, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_contentPanel.createSequentialGroup()
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
											.addComponent(lblTit)
											.addComponent(txtTit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblNomU))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
											.addComponent(lblGen)
											.addComponent(txtGenero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
											.addComponent(lblAnyo)
											.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
												.addComponent(txtAny, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblTrai)))))
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPanel.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(btnSPos))
									.addGroup(gl_contentPanel.createSequentialGroup()
										.addGap(11)
										.addComponent(lblSala)))))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(textSinopsis, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(txtTrailer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textPos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textPosM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblRutaP)
								.addComponent(lblRPostM))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textSala, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(26)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addGap(39)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
									.addComponent(txtBus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblBus)))
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addGap(30)
								.addComponent(lblPosMenu, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(btnSubPMenu)
							.addGap(53)))
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGap(92)
									.addComponent(lblAny, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 79, Short.MAX_VALUE))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblAnyP)
									.addGap(103)))
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGap(35)
									.addComponent(lblEliP))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblEli, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
							.addGap(49))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(39)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_4)
								.addComponent(lblNewLabel_6)
								.addComponent(lblNewLabel_7)
								.addComponent(lblNewLabel_8)
								.addComponent(lblNewLabel_9)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_5))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.ORANGE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			{
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

	//Creamos la tabla de peliculas
	static void mostrarTabla() {
		

		String[]titulos= {"ID","Título","Año","Género","Sinopsis","Duracion", "Trailer","Ruta Poster","Ruta Cartel", "Sala"};
		String[]datos= new String[50];
	    modelo= new DefaultTableModel(null,titulos);
	  

		String sql="select id,titulo, anyo, genero,sinopsis,duracion, trailer, nomPoster, nomPMenu,sala from pelicula";

		Conexion cc= new Conexion();
		Connection conect= cc.conectar();


		try {
			Statement stmt= (Statement) conect.createStatement();
			ResultSet rs= stmt.executeQuery(sql);
			while(rs.next()) {
				datos[0]= String.valueOf(rs.getInt("id"));
				datos[1]= rs.getString("titulo");
				datos[2]= String.valueOf(rs.getInt("anyo"));
				datos[3]= rs.getString("genero");
				datos[4]= rs.getString("sinopsis");
				datos[5]= String.valueOf(rs.getInt("duracion"));			
				datos[6]= rs.getString("trailer");
				datos[7]= rs.getString("nomPoster");
				datos[8]= rs.getString("nomPMenu");		
				datos[9]= String.valueOf(rs.getInt("sala"));
				modelo.addRow(datos);




			}
			table.setModel(modelo);
			table.setSelectionBackground(Color.ORANGE);
			TableColumnModel columnmodel= table.getColumnModel();
			columnmodel.getColumn(0).setPreferredWidth(20);
			columnmodel.getColumn(1).setPreferredWidth(140);
			
			
		} catch (Exception e) {
			System.out.println(e);
		}



	}
}
