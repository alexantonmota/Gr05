package vistaAdmin;
import java.awt.BorderLayout;








import java.awt.Color;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URI;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.io.IOException;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.Pelicula;
import vistaCliente.InicioSesion;
import model.Genero;
import db.Conexion;




/**
 * Ventana para añadir peliculas que se accede desde GestionPelis
 * @author alex
 *
 */
public class GestionPelicula extends JDialog {


	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField textTitulo;
	private JTextField textAnyo;
	private JTextField textDuracion;
	private JTextField textNomPoster;
	public static JTextField textTrailer;
	private JTextField txtPosMenu;
	private Image foto;
	private Image fotomenu;
	File file;
	File file2;


	DefaultListModel<String> listmodel = new DefaultListModel<String>();



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GestionPelicula dialog = new GestionPelicula();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public  GestionPelicula() {
		setResizable(false);
		setForeground(Color.ORANGE);
		setBackground(Color.GRAY);
		getContentPane().setBackground(Color.GRAY);
		setBounds(250, 50, 1200, 900);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);




		//Label Imagen seleccionada
		JLabel lblPoster = new JLabel("");
		lblPoster.setBorder(BorderFactory.createLineBorder(Color.ORANGE,4));


		JLabel lblTitulo = new JLabel("Título");
		lblTitulo.setForeground(Color.ORANGE);
		lblTitulo.setBorder(BorderFactory.createLineBorder(Color.ORANGE,2));
		lblTitulo.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));

		JLabel lblNAnyo = new JLabel("Año");
		lblNAnyo.setForeground(Color.ORANGE);
		lblNAnyo.setBorder(BorderFactory.createLineBorder(Color.ORANGE,2));
		lblNAnyo.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));

		JLabel lblSinopsis = new JLabel("Sinopsis");
		lblSinopsis.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblSinopsis.setBorder(BorderFactory.createLineBorder(Color.ORANGE,2));
		lblSinopsis.setForeground(Color.ORANGE);

		JLabel lblDuracion = new JLabel("Duración");
		lblDuracion.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblDuracion.setForeground(Color.ORANGE);
		lblDuracion.setBorder(BorderFactory.createLineBorder(Color.ORANGE,2));

		JLabel lblTrailer = new JLabel("Tráiler");
		lblTrailer.setForeground(Color.ORANGE);
		lblTrailer.setBorder(BorderFactory.createLineBorder(Color.ORANGE,2));
		lblTrailer.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		//TextField que se coloca la url
				textTrailer = new JTextField();
				textTrailer.setColumns(10);

			
				JTextPane textSinopsis = new JTextPane();

		JButton btnTrailer = new JButton("Ver Trailer");
		btnTrailer.addActionListener(new ActionListener() {




			public void actionPerformed(ActionEvent arg0) {
				
			//Ejecución de URL
				try {
				   URL url = new URL(textTrailer.getText());
				    try {
				        Desktop.getDesktop().browse(url.toURI());
				    } catch (IOException e) {
				        e.printStackTrace();
				    } catch (URISyntaxException e) {
				        e.printStackTrace();
				    }
				} catch (MalformedURLException e1) {
				    e1.printStackTrace();
				}
				}

		});
		btnTrailer.setBackground(Color.ORANGE);
		btnTrailer.setForeground(Color.GRAY);
		btnTrailer.setOpaque(true);
		btnTrailer.setBorderPainted(false);

		btnTrailer.setOpaque(true);
		btnTrailer.setBorderPainted(false);

		textTitulo = new JTextField();
		textTitulo.setColumns(10);

		textAnyo = new JTextField();
		textAnyo.setColumns(10);

		textDuracion = new JTextField();
		textDuracion.setColumns(10);

		JLabel lblGenero = new JLabel("Género");
		lblGenero.setForeground(Color.ORANGE);
		lblGenero.setBorder(BorderFactory.createLineBorder(Color.ORANGE,2));
		lblGenero.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));

		//Combo box que toma los valores de la Enum Genero
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		comboBox.setModel(new DefaultComboBoxModel(Genero.values()));

		

		JLabel lblPosMenu = new JLabel("");
		lblPosMenu.setBorder(BorderFactory.createLineBorder(Color.ORANGE,4));

		txtPosMenu = new JTextField();
		txtPosMenu.setColumns(10);

		JLabel lblSelPosMenu = new JLabel("Seleccionar");
		lblSelPosMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {


				/**
				 * Seleccion de Imagen con filtro de archivois
				 */
				//Filtrar solo imagenes 
				FileNameExtensionFilter filtroImagen=new FileNameExtensionFilter("JPG, , JPEG,PNG & GIF","jpg","jpeg","png","gif");
				JFileChooser archivo= new JFileChooser();
				archivo.setFileFilter(filtroImagen);
				int r=archivo.showOpenDialog(null);
				if(r == JFileChooser.APPROVE_OPTION) {

					file2 = archivo.getSelectedFile();
					txtPosMenu.setText(String.valueOf(file2));
					fotomenu= getToolkit().getImage(txtPosMenu.getText());
					fotomenu= fotomenu.getScaledInstance(300, 125, Image.SCALE_DEFAULT);
					lblPosMenu.setIcon(new ImageIcon(fotomenu));
				}
			}
		});
		lblSelPosMenu.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
		lblSelPosMenu.setBackground(Color.ORANGE);
		lblSelPosMenu.setForeground(Color.GRAY);
		lblSelPosMenu.setOpaque(true);


		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblPoster, GroupLayout.PREFERRED_SIZE, 372, GroupLayout.PREFERRED_SIZE)
						.addGap(28)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTrailer)
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addComponent(textTrailer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(btnTrailer))
								.addComponent(lblTitulo)
								.addComponent(textAnyo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDuracion)
								.addComponent(lblSinopsis)
								.addComponent(textSinopsis, GroupLayout.PREFERRED_SIZE, 432, GroupLayout.PREFERRED_SIZE)
								.addComponent(textDuracion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
												.addComponent(lblGenero)
												.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNAnyo))
										.addPreferredGap(ComponentPlacement.RELATED, 203, Short.MAX_VALUE)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
												.addGroup(gl_contentPanel.createSequentialGroup()
														.addComponent(lblSelPosMenu)
														.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(txtPosMenu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addComponent(lblPosMenu, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE))))
						.addGap(153))
				);
		gl_contentPanel.setVerticalGroup(
				gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addGap(20)
										.addComponent(lblTitulo)
										.addGap(18)
										.addComponent(textTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(27)
										.addComponent(lblGenero)
										.addGap(27)
										.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(32)
										.addComponent(lblNAnyo)
										.addGap(29)
										.addComponent(textAnyo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(lblSinopsis))
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addGap(90)
										.addComponent(lblPosMenu, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
												.addComponent(txtPosMenu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblSelPosMenu))))
						.addGap(28)
						.addComponent(textSinopsis, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
						.addGap(43)
						.addComponent(lblDuracion)
						.addGap(18)
						.addComponent(textDuracion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
						.addComponent(lblTrailer)
						.addGap(15)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnTrailer)
								.addComponent(textTrailer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(31))
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblPoster, GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
						.addContainerGap())
				);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.ORANGE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);


			//Seleccion de imagen para poster
			JButton btnSelPos = new JButton("Seleccionar Póster");
			btnSelPos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {


					/**
					 * Seleccion de Imagen con filtro de archivois
					 */
					//Filtrar solo imagenes 
					FileNameExtensionFilter filtroImagen=new FileNameExtensionFilter("JPG, , JPEG,PNG & GIF","jpg","jpeg","png","gif");
					JFileChooser archivo= new JFileChooser();
					archivo.setFileFilter(filtroImagen);
					int r=archivo.showOpenDialog(null);
					if(r == JFileChooser.APPROVE_OPTION) {

						file = archivo.getSelectedFile();
						textNomPoster.setText(String.valueOf(file));
						foto= getToolkit().getImage(textNomPoster.getText());
						foto= foto.getScaledInstance(380, 830, Image.SCALE_DEFAULT);
						lblPoster.setIcon(new ImageIcon(foto));
					}


				}
			});
			btnSelPos.setOpaque(true);


			//Ruta de la imagen seleccionada
			textNomPoster = new JTextField();
			buttonPane.add(textNomPoster);
			textNomPoster.setColumns(10);
			btnSelPos.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
			btnSelPos.setForeground(Color.ORANGE);
			btnSelPos.setBackground(Color.GRAY);
			btnSelPos.setBorderPainted(false);
			buttonPane.add(btnSelPos);


			{
				JButton okButton = new JButton("Guardar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Conexion conexion1 = new Conexion();
						Connection cn1 = conexion1.conectar();

						String titulo;
						String genero;
						String anyo;
						String sinopsis;
						String duracion;
						String url;
						String fotoPoster;
						String fotoPosterMenu;
						Image poster;
						Image posterMenu;




						String sql1 = "";
						titulo = textTitulo.getText();
						genero = comboBox.getSelectedItem().toString();
						anyo = 	textAnyo.getText();
						sinopsis = textSinopsis.getText();
						duracion = textDuracion.getText();
						url = textTrailer.getText();
						fotoPoster= textNomPoster.getText();
						poster= foto;
						fotoPosterMenu= txtPosMenu.getText();
						posterMenu= fotomenu;

						FileInputStream fi= null;
						FileInputStream fi2= null;
						int sala=12;



						

						sql1 = "INSERT INTO pelicula (titulo, anyo, genero, sinopsis, duracion, trailer, nomPoster, poster, nomPMenu, pMenu,sala) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

						PreparedStatement ps1= null;

						try {


							file= new File(fotoPoster);
							file2=  new File(fotoPosterMenu);
							fi= new FileInputStream(file);	
							fi2=new FileInputStream(file2);

							PreparedStatement pst1 = cn1.prepareStatement(sql1);
							pst1.setString(1, titulo);
							pst1.setString(2, anyo);
							pst1.setString(3, genero);
							pst1.setString(4, sinopsis);
							pst1.setString(5, duracion);
							pst1.setString(6, url);
							pst1.setString(7, fotoPoster);
							pst1.setBinaryStream(8, fi);
							pst1.setString(9, fotoPosterMenu);
							pst1.setBinaryStream(10, fi2);
							pst1.setInt(11,sala++);



							int n = pst1.executeUpdate();
							if(n>0) {
								JOptionPane.showMessageDialog(null, "Pelicula añadida");

								if(!textTitulo.getText().isEmpty() && !textAnyo.getText().isEmpty() && !textSinopsis.getText().isEmpty() && !textDuracion.getText().isEmpty() && !textTrailer.getText().isEmpty() && !textNomPoster.getText().isEmpty() && !txtPosMenu.getText().isEmpty()) {
									listmodel.addElement("Titulo:"+textTitulo.getText()+","+"Género:"+comboBox.getSelectedItem().toString()+" ,"+"Año:"+textAnyo.getText()+" ,"+"Sinopsis:"+textSinopsis.getText()+" ,"+"Duración:"+textDuracion.getText()+" ,"+"Tráiler:"+textTrailer.getText());
								}

							}
						} catch (SQLException | FileNotFoundException e) {
							e.printStackTrace();
							JOptionPane.showMessageDialog(null, "Los datos no son validos"+e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
						}


					}	
				});



				okButton.setForeground(Color.ORANGE);
				okButton.setBackground(Color.GRAY);
				okButton.setOpaque(true);
				okButton.setBorderPainted(false);
				okButton.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
				okButton.setActionCommand("");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);


			}
			{
				//Cierre de ventana
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setForeground(Color.ORANGE);
				cancelButton.setBackground(Color.GRAY);
				cancelButton.setOpaque(true);
				cancelButton.setBorderPainted(false);
				cancelButton.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
				cancelButton.setActionCommand("");
				buttonPane.add(cancelButton);
			}
			
			
		


		}}}




