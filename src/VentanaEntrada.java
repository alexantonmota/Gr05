import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
/**
 * Ventana donde se visualiza los datos de la entrada
 * @author alex
 *
 */
public class VentanaEntrada extends JDialog {


	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textCod;
	private JTextField txtPrecU;
	private JTextField txtPel;
	private JTextField txtSala;
	private JTextField txtPrecT;
	public int numAleatorio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaEntrada dialog = new VentanaEntrada();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaEntrada() {
		setResizable(false);
		setForeground(Color.ORANGE);
		setBackground(Color.GRAY);
		getContentPane().setBackground(Color.GRAY);
		setBounds(320, 150, 1000, 700);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JLabel lblPos = new JLabel("");
		lblPos.setBorder(BorderFactory.createLineBorder(Color.ORANGE,4));


		JLabel lblCod = new JLabel("Código");
		lblCod.setForeground(Color.ORANGE);
		lblCod.setBorder(BorderFactory.createLineBorder(Color.ORANGE,2));
		lblCod.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));

		JLabel lblHor = new JLabel("Horario");
		lblHor.setForeground(Color.ORANGE);
		lblHor.setBorder(BorderFactory.createLineBorder(Color.ORANGE,2));
		lblHor.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));

		JLabel lblCant = new JLabel("Cantidad");
		lblCant.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblCant.setBorder(BorderFactory.createLineBorder(Color.ORANGE,2));
		lblCant.setForeground(Color.ORANGE);

		JLabel lblPrecU = new JLabel("Precio/Entrada");
		lblPrecU.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblPrecU.setForeground(Color.ORANGE);
		lblPrecU.setBorder(BorderFactory.createLineBorder(Color.ORANGE,2));

		textCod = new JTextField();
		textCod.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		textCod.setEditable(false);
		textCod.setColumns(10);

		//Genera un código aleatorio para la entrada
		numAleatorio = (int)(Math.random()*10000+1);
		textCod.setText(String.valueOf(numAleatorio));

		txtPrecU = new JTextField();
		txtPrecU.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		txtPrecU.setEditable(false);
		txtPrecU.setColumns(10);

		JLabel lblPel = new JLabel("Película");
		lblPel.setForeground(Color.ORANGE);
		lblPel.setBorder(BorderFactory.createLineBorder(Color.ORANGE,2));
		lblPel.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));

		txtPel = new JTextField();
		txtPel.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
		txtPel.setEditable(false);
		txtPel.setColumns(10);


		//Seleccion de horario
		JComboBox comboHor = new JComboBox();
		comboHor.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		comboHor.setModel(new DefaultComboBoxModel(new String[] {"16:00", "18:00", "20:00", "22:00"}));

		//Seleccion de número de entradas entre 1 y 10
		JSpinner spinnerCant = new JSpinner();
		SpinnerNumberModel modeloSpinner = new SpinnerNumberModel();
		modeloSpinner.setMaximum(10);
		modeloSpinner.setMinimum(1);
		spinnerCant.setModel(modeloSpinner);
		spinnerCant.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));


		//Se mostrará la sala
		JLabel lblSala = new JLabel("Sala");
		lblSala.setForeground(Color.ORANGE);
		lblSala.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblSala.setBorder(BorderFactory.createLineBorder(Color.ORANGE,2));

		txtSala = new JTextField();
		txtSala.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		txtSala.setColumns(10);

		JLabel lblAsiento = new JLabel("Asiento");
		lblAsiento.setForeground(Color.ORANGE);
		lblAsiento.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblAsiento.setBorder(BorderFactory.createLineBorder(Color.ORANGE,2));

		JLabel lblPrecT = new JLabel("PRECIO TOTAL");
		lblPrecT.setForeground(Color.ORANGE);
		lblPrecT.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 20));
		lblPrecT.setBorder(BorderFactory.createLineBorder(Color.ORANGE,2));

		txtPrecT = new JTextField();
		txtPrecT.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 20));
		txtPrecT.setEditable(false);
		txtPrecT.setColumns(10);

		JButton btnAsiento = new JButton("Seleccionar");
		btnAsiento.setBackground(Color.ORANGE);
		btnAsiento.setOpaque(true);
		btnAsiento.setBorderPainted(false);
		btnAsiento.setForeground(Color.GRAY);
		btnAsiento.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));

		JLabel lblE2 = new JLabel("€");
		lblE2.setForeground(Color.ORANGE);
		lblE2.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 23));

		JLabel lblE1 = new JLabel("€");
		lblE1.setForeground(Color.ORANGE);
		lblE1.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 23));

		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblPos, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(spinnerCant, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addComponent(txtPrecU, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(lblE1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblPel)
								.addComponent(lblHor)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPanel.createSequentialGroup()
												.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
														.addComponent(lblAsiento, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
														.addComponent(btnAsiento)
														.addComponent(lblPrecU))
												.addGap(238)
												.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
														.addGroup(gl_contentPanel.createSequentialGroup()
																.addComponent(txtPrecT, 237, 237, 237)
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addComponent(lblE2)
																.addGap(26))
														.addGroup(gl_contentPanel.createSequentialGroup()
																.addComponent(lblPrecT, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
																.addGap(88))))
										.addGroup(gl_contentPanel.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
														.addComponent(txtPel, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
														.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
																.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
																		.addComponent(textCod, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
																		.addComponent(lblCod))
																.addGap(570)))))
								.addComponent(lblCant)
								.addComponent(comboHor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(txtSala, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
										.addComponent(lblSala, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)))
						.addGap(26))
				);
		gl_contentPanel.setVerticalGroup(
				gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addGap(18)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_contentPanel.createSequentialGroup()
														.addComponent(lblCod)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(textCod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(lblPel)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(txtPel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addGap(18)
														.addComponent(lblHor)
														.addGap(18)
														.addComponent(comboHor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addGap(12)
														.addComponent(lblCant)
														.addGap(20)
														.addComponent(spinnerCant, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addGap(18)
														.addComponent(lblSala, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(txtSala, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addGap(18)
														.addComponent(lblAsiento, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
												.addComponent(lblPrecT, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
														.addComponent(lblE2)
														.addComponent(txtPrecT, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
														.addComponent(lblE1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
														.addGroup(gl_contentPanel.createSequentialGroup()
																.addComponent(btnAsiento)
																.addGap(17)
																.addComponent(lblPrecU)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(txtPrecU, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
								.addComponent(lblPos, GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE))
						.addContainerGap())
				);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.ORANGE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{

				//Accede a Pago
				JButton okButton = new JButton("Pagar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						Pago pago= new Pago();
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
		}
	}
}
