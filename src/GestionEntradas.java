import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerNumberModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
	private JTextField textAsi;
	private JTextField txtPrec;
	private JTextField txtPrecT;
	private JTextField textBus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GestionEntradas dialog = new GestionEntradas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
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

		//Lista donde se mostraran los datos de  la base de datos de Entradas
		JList listEntr = new JList();

		//Boton guardar escondido
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(Color.ORANGE);
		btnGuardar.setForeground(Color.ORANGE);
		btnGuardar.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
		btnGuardar.setOpaque(true);
		btnGuardar.setBorderPainted(false);

		JLabel lblAny = new JLabel("");
		lblAny.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				textPel.setEditable(true);
				textSala.setEditable(true);
				textAsi.setEditable(true);
				txtPrec.setEditable(true);
				txtPrecT.setEditable(true);

				btnGuardar.setBackground(Color.GRAY);
			}
		});
		lblAny.setHorizontalAlignment(SwingConstants.CENTER);
		lblAny.setBackground(Color.ORANGE);
		lblAny.setOpaque(true);
		lblAny.setIcon(new ImageIcon("/Users/alex/eclipse-workspace5/CineDeusto/Imagenes/gafuk.png"));

		JLabel lblMod = new JLabel("");
		lblMod.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textPel.setEditable(true);
				textSala.setEditable(true);
				textAsi.setEditable(true);
				txtPrec.setEditable(true);
				txtPrecT.setEditable(true);

				btnGuardar.setBackground(Color.GRAY);
			}
		});
		lblMod.setHorizontalAlignment(SwingConstants.CENTER);
		lblMod.setIcon(new ImageIcon("/Users/alex/eclipse-workspace5/CineDeusto/Imagenes/ckvbn.png"));
		lblMod.setBackground(Color.ORANGE);
		lblMod.setOpaque(true);


		JLabel lblEli = new JLabel("");
		lblEli.setHorizontalAlignment(SwingConstants.CENTER);
		lblEli.setBackground(Color.ORANGE);
		lblEli.setOpaque(true);
		lblEli.setIcon(new ImageIcon("/Users/alex/eclipse-workspace5/CineDeusto/Imagenes/dsjn.png"));

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

		JLabel lblAsi = new JLabel("Asiento");
		lblAsi.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblAsi.setForeground(Color.ORANGE);

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

		textAsi = new JTextField();
		textAsi.setEditable(false);
		textAsi.setColumns(10);

		txtPrec = new JTextField();
		txtPrec.setEditable(false);
		txtPrec.setColumns(10);

		txtPrecT = new JTextField();
		txtPrecT.setEditable(false);
		txtPrecT.setColumns(10);

		//ComboBox con los horarios disponibles
		JComboBox comboHor = new JComboBox();
		comboHor.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		comboHor.setModel(new DefaultComboBoxModel(new String[] {"16:00 pm", "18:00 pm", "20:00 pm", "22:00 pm"}));

		// Spinner para determinar número de entradas entre 1 y 10
		JSpinner spinnerCant = new JSpinner();
		SpinnerNumberModel modeloSpinner = new SpinnerNumberModel();
		modeloSpinner.setMaximum(10);
		modeloSpinner.setMinimum(1);
		spinnerCant.setModel(modeloSpinner);
		spinnerCant.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));

		textBus = new JTextField();
		textBus.setColumns(10);

		JLabel lblBus = new JLabel("Buscar");
		lblBus.setForeground(Color.ORANGE);
		lblBus.setFont(new Font("Lucida Grande", Font.PLAIN, 18));

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
																.addComponent(lblSala)
																.addComponent(lblAsi))
														.addGap(61)
														.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
																.addComponent(textAsi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
																		.addComponent(textSala, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																		.addGroup(gl_contentPanel.createSequentialGroup()
																				.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
																						.addComponent(textCod, Alignment.TRAILING)
																						.addComponent(textPel, Alignment.TRAILING)
																						.addComponent(comboHor, Alignment.TRAILING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																						.addComponent(spinnerCant, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
																				.addPreferredGap(ComponentPlacement.RELATED, 290, Short.MAX_VALUE)
																				.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
																						.addComponent(lblPrec)
																						.addComponent(lblPrecT)))))))
										.addGap(45)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
												.addComponent(txtPrecT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtPrec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addGap(478)
										.addComponent(lblGE))
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addGap(149)
										.addComponent(listEntr, GroupLayout.PREFERRED_SIZE, 712, GroupLayout.PREFERRED_SIZE)
										.addGap(37)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
												.addComponent(lblAny, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblEli, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblMod, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
						.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblCod)
												.addComponent(textCod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPanel.createSequentialGroup()
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
																.addGroup(gl_contentPanel.createSequentialGroup()
																		.addComponent(lblPel)
																		.addPreferredGap(ComponentPlacement.UNRELATED)
																		.addComponent(lblHor))
																.addComponent(txtPrec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																.addComponent(lblPrec))
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
																.addComponent(lblCant)
																.addComponent(spinnerCant, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																.addComponent(lblPrecT)
																.addComponent(txtPrecT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
												.addGroup(gl_contentPanel.createSequentialGroup()
														.addGap(4)
														.addComponent(textPel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addGap(18)
														.addComponent(comboHor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblSala)
												.addComponent(textSala, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblAsi)
												.addComponent(textAsi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(39)
										.addComponent(textBus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblBus))
						.addGap(98)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addGap(11)
										.addComponent(lblAny, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(lblMod, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
										.addGap(27)
										.addComponent(lblEli, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
								.addComponent(listEntr, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(37, Short.MAX_VALUE))
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
}
