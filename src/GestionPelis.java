import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
/**
 * Ventana para gestionar peliculas
 * @author alex
 *
 */
public class GestionPelis extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblGP;
	private JTextField txtTit;
	private JTextField txtAny;
	private JTextField txtDur;
	private JTextField txtTrailer;
	private JTextField txtBus;
	private JTextField textPos;
	private JTextField textPosM;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GestionPelis dialog = new GestionPelis();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
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
		//Lista donde se mostraran los datos de  la base de datos de Clientes
		JList listPel = new JList();





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
		lblEli.setHorizontalAlignment(SwingConstants.CENTER);
		lblEli.setIcon(new ImageIcon("/Users/alex/eclipse-workspace5/CineDeusto/Imagenes/dsjn.png"));
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
		lblAny.setIcon(new ImageIcon("/Users/alex/eclipse-workspace5/CineDeusto/Imagenes/gafuk.png"));
		lblAny.setOpaque(true);
		lblAny.setBackground(Color.orange);
		lblAny.setBorder(new LineBorder(new Color(255, 200, 0), 3, true));



		JLabel lblAnyP = new JLabel("Añadir Película");
		lblAnyP.setForeground(Color.ORANGE);
		lblAnyP.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));

		JLabel lblModP = new JLabel("Modificar Película");
		lblModP.setForeground(Color.ORANGE);
		lblModP.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));

		JLabel lblEliP = new JLabel("Eliminar Película");
		lblEliP.setForeground(Color.ORANGE);
		lblEliP.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));

		JComboBox comboGen = new JComboBox();
		comboGen.setModel(new DefaultComboBoxModel(Genero.values()));

		JTextPane textSinopsis = new JTextPane();

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
		btnSPos.setIcon(new ImageIcon("/Users/alex/eclipse-workspace5/CineDeusto/Imagenes/fnnn.png"));

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




		JLabel lblMod = new JLabel("");
		lblMod.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				txtTit.setEditable(true);
				txtAny.setEditable(true);
				txtDur.setEditable(true);
				txtTrailer.setEditable(true);
				comboGen.setEditable(true);
				textSinopsis.setEditable(true);
				btnSPos.setEnabled(true);
				btnSubPMenu.setEnabled(true);
				btnGuardar.setBackground(Color.GRAY);

			}
		});
		lblMod.setHorizontalAlignment(SwingConstants.CENTER);
		lblMod.setIcon(new ImageIcon("/Users/alex/eclipse-workspace5/CineDeusto/Imagenes/ckvbn.png"));
		lblMod.setOpaque(true);
		lblMod.setBackground(Color.orange);
		lblMod.setBorder(new LineBorder(new Color(255, 200, 0), 3, true));

		btnSubPMenu.setBackground(Color.ORANGE);
		btnSubPMenu.setOpaque(true);
		btnSubPMenu.setBorderPainted(false);
		btnSubPMenu.setIcon(new ImageIcon("/Users/alex/eclipse-workspace5/CineDeusto/Imagenes/fnnn.png"));

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
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
				gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addContainerGap()
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPanel.createSequentialGroup()
														.addComponent(lblPosMenu, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(btnSubPMenu, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_contentPanel.createSequentialGroup()
														.addComponent(listPel, GroupLayout.PREFERRED_SIZE, 691, GroupLayout.PREFERRED_SIZE)
														.addGap(60)
														.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
																.addComponent(lblMod)
																.addComponent(lblAny)
																.addComponent(lblEli))
														.addGap(32)
														.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
																.addComponent(lblAnyP)
																.addComponent(lblModP)
																.addComponent(lblEliP))))
										.addGap(46))
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
																.addGroup(gl_contentPanel.createSequentialGroup()
																		.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
																				.addComponent(lblContr)
																				.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
																						.addComponent(comboGen, 0, 140, Short.MAX_VALUE)
																						.addComponent(txtTit, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																						.addComponent(txtAny, 140, 140, 140)))
																		.addGap(85))
																.addGroup(gl_contentPanel.createSequentialGroup()
																		.addComponent(txtDur, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																		.addGap(89))))
												.addGroup(gl_contentPanel.createSequentialGroup()
														.addComponent(lblAnyo)
														.addGap(319)))
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNomU)
												.addComponent(lblTrai)
												.addComponent(lblRutaP))
										.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
												.addComponent(txtTrailer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
														.addGroup(gl_contentPanel.createSequentialGroup()
																.addComponent(textPos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
																.addComponent(lblRPostM)
																.addGap(18)
																.addComponent(textPosM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
														.addComponent(textSinopsis, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 416, GroupLayout.PREFERRED_SIZE)))))
						.addGap(49))
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addGap(347)
						.addComponent(lblGP, GroupLayout.PREFERRED_SIZE, 432, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(522, Short.MAX_VALUE))
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addContainerGap(523, Short.MAX_VALUE)
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
																.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
																		.addComponent(lblGen)
																		.addComponent(comboGen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
																.addGap(18)
																.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
																		.addComponent(lblAnyo)
																		.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
																				.addComponent(txtAny, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																				.addComponent(lblTrai)))))
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(btnSPos)
												.addPreferredGap(ComponentPlacement.RELATED)))
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
										.addGap(28)))
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPanel.createSequentialGroup()
														.addGap(39)
														.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
																.addComponent(txtBus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																.addComponent(lblBus)))
												.addGroup(gl_contentPanel.createSequentialGroup()
														.addGap(30)
														.addComponent(lblPosMenu, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE))
								.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnSubPMenu)
										.addGap(53)))
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addGap(18)
										.addComponent(listPel, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
												.addGroup(gl_contentPanel.createSequentialGroup()
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(lblAny, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
														.addGap(26)
														.addComponent(lblMod, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
														.addGap(30))
												.addGroup(gl_contentPanel.createSequentialGroup()
														.addGap(33)
														.addComponent(lblAnyP)
														.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(lblModP)
														.addGap(59)))
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
												.addComponent(lblEli, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_contentPanel.createSequentialGroup()
														.addGap(35)
														.addComponent(lblEliP)))))
						.addGap(61))
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
}
