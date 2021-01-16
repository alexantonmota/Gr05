package vistaCliente;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import db.Conexion;
import db.DBManager;
import model.Pelicula;
/**
 * Ventana donde se visualiza los datos de la entrada
 * @author alex
 *
 */
public class VentanaEntrada extends JDialog {


	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public JTextField txtPrecU;
	private JTextField txtPel;
	public JTextField txtSala;
	public JTextField txtPrecT;
	public int numAleatorio;
	public String n;
	public String totalstring= "";
	public JComboBox comboHor;
	protected static int valor;
	public List<Integer> almacenar;
	public List<Integer> guardar;
	public int spinnerValue = -1;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the dialog.
	 */
	public VentanaEntrada(Pelicula p) {
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
		Image fotomenu;
		 fotomenu= getToolkit().getImage(p.getRutaFoto());
		fotomenu= fotomenu.getScaledInstance(300, 600, Image.SCALE_DEFAULT);
		
		
		lblPos.setIcon(new ImageIcon(fotomenu));

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

		//Genera un código aleatorio para la entrada
		numAleatorio = (int)(Math.random()*10000+1);
		
		
		

		txtPrecU = new JTextField();
		txtPrecU.setHorizontalAlignment(SwingConstants.CENTER);
		txtPrecU.setText("9");
		txtPrecU.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		txtPrecU.setEditable(false);
		txtPrecU.setColumns(10);

		JLabel lblPel = new JLabel("Película");
		lblPel.setForeground(Color.ORANGE);
		lblPel.setBorder(BorderFactory.createLineBorder(Color.ORANGE,2));
		lblPel.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));

		txtPel = new JTextField(p.getTitulo());
		txtPel.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
		txtPel.setEditable(false);
		txtPel.setColumns(10);


		//Seleccion de horario
		comboHor = new JComboBox();
		comboHor.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		comboHor.setModel(new DefaultComboBoxModel(new String[] {"16:00", "18:00", "20:00", "22:00"}));

		//Seleccion de número de entradas entre 1 y 10
		JSpinner spinnerCant = new JSpinner();
		SpinnerNumberModel modeloSpinner = new SpinnerNumberModel();
		modeloSpinner.setMaximum(10);
		modeloSpinner.setMinimum(1);
		modeloSpinner.setValue(1);
		
		spinnerCant.setModel(modeloSpinner);
		spinnerCant.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
		
		
		
		
		//Se mostrará la sala
		JLabel lblSala = new JLabel("Sala");
		lblSala.setForeground(Color.ORANGE);
		lblSala.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblSala.setBorder(BorderFactory.createLineBorder(Color.ORANGE,2));

		txtSala = new JTextField(String.valueOf(p.getSala()));
		txtSala.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		txtSala.setColumns(10);
		
		

		JLabel lblAsiento = new JLabel("Ver sala");
		lblAsiento.setForeground(Color.ORANGE);
		lblAsiento.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblAsiento.setBorder(BorderFactory.createLineBorder(Color.ORANGE,2));

		JLabel lblPrecT = new JLabel("PRECIO TOTAL");
		lblPrecT.setForeground(Color.ORANGE);
		lblPrecT.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 20));
		lblPrecT.setBorder(BorderFactory.createLineBorder(Color.ORANGE,2));
		
		txtPrecT = new JTextField();
		txtPrecT.setHorizontalAlignment(SwingConstants.CENTER);
		int precio=9;
		valor = (Integer)spinnerCant.getValue();
		int total= precio*valor;
		totalstring= String.valueOf(total);
		txtPrecT.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 20));
		txtPrecT.setText(totalstring);
		txtPrecT.setEditable(false);
		txtPrecT.setColumns(10);

		JButton btnAsiento = new JButton("Previsualización");
		btnAsiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Asientos as= new Asientos();
				as.main();
			}
		});
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
		
		JButton btnNewButton = new JButton(">");
		almacenar= new ArrayList<Integer>();
		guardar= new ArrayList<Integer>();
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				valor = (Integer)spinnerCant.getValue();
				double total= precio*valor;
				String horario=comboHor.getSelectedItem().toString();
				
				String sql= "DELETE FROM Otros";
				String sql1= "INSERT INTO Otros(cantidad,preciototal,horario) values(?,?,?)"; 
				Conexion conexion1 = new Conexion();
				Connection cn1 = conexion1.conectar();
				PreparedStatement ps1= null;
				
				
				try {
					PreparedStatement pst1 = cn1.prepareStatement(sql);
					PreparedStatement ps2=cn1.prepareStatement(sql);
					pst1.executeUpdate();
					
					try {
						PreparedStatement pst2 = cn1.prepareStatement(sql1);
						pst2.setInt(1,valor);
						pst2.setDouble(2,total);
						pst2.setString(3,horario);
						
						pst2.executeUpdate();
						
						
						
					} catch (Exception e) {
						System.out.println(e);
					}
				
					
				} catch (Exception e) {
					System.out.println(e);
				}
			
				
				
				totalstring= String.valueOf(total);
				txtPrecT.setText(totalstring);
				
				
				
				
				
			}
		});
		
		btnNewButton.setForeground(Color.ORANGE);

		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPos, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAsiento, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPel, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPel)
								.addComponent(lblHor)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(lblCant, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(comboHor, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(spinnerCant, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSala, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtSala, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblPrecU)
									.addPreferredGap(ComponentPlacement.RELATED, 310, Short.MAX_VALUE)
									.addComponent(txtPrecT, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
									.addGap(54))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(btnAsiento)
									.addGap(156)
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblPrecT, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPanel.createSequentialGroup()
											.addGap(139)
											.addComponent(lblE2))))))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(47)
							.addComponent(txtPrecU, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblE1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)))
					.addGap(83))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(42)
					.addComponent(lblPel)
					.addGap(18)
					.addComponent(txtPel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblHor)
					.addGap(18)
					.addComponent(comboHor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblCant)
					.addGap(18)
					.addComponent(spinnerCant, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(lblSala, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtSala, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblAsiento, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAsiento)
						.addComponent(lblPrecT)
						.addComponent(btnNewButton))
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(18)
							.addComponent(lblPrecU)
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(txtPrecU, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(270)
									.addComponent(lblE2))
								.addComponent(lblE1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(26)
							.addComponent(txtPrecT, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPos, GroupLayout.PREFERRED_SIZE, 615, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(236, Short.MAX_VALUE))
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

						Pago pago= new Pago(p);
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
