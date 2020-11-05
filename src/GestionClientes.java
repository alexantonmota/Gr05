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
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
/**
 * Ventana donde se gestionan los clientes
 * @author alex
 *
 */
public class GestionClientes extends JDialog {

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GestionClientes dialog = new GestionClientes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
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
		JList listCli = new JList();
		
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
		lblEli.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEli.setIcon(new ImageIcon("/Users/alex/eclipse-workspace5/CineDeusto/Imagenes/dsjn.png"));
		lblEli.setOpaque(true);
		lblEli.setBackground(Color.orange);
		lblEli.setBorder(new LineBorder(new Color(255, 200, 0), 3, true));
		
		//Añado un botón del color del panel para que no se vea
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(Color.ORANGE);
		btnGuardar.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
		btnGuardar.setForeground(Color.ORANGE);
		btnGuardar.setOpaque(true);
		btnGuardar.setBorderPainted(false);
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
				 btnGuardar.setBackground(Color.GRAY);

				
			}
		});
		lblAny.setIcon(new ImageIcon("/Users/alex/eclipse-workspace5/CineDeusto/Imagenes/vbalsd.png"));
		lblAny.setOpaque(true);
		lblAny.setBackground(Color.orange);
		lblAny.setBorder(new LineBorder(new Color(255, 200, 0), 3, true));
		
		
		
		JLabel lblMod = new JLabel("");
		lblMod.addMouseListener(new MouseAdapter() {
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
				 btnGuardar.setBackground(Color.GRAY);

				
				
			}
		});
		lblMod.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMod.setIcon(new ImageIcon("/Users/alex/eclipse-workspace5/CineDeusto/Imagenes/ckvbn.png"));
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
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(151)
							.addComponent(listCli, GroupLayout.PREFERRED_SIZE, 691, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEli, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
								.addComponent(lblMod, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
								.addComponent(lblAny, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
							.addGap(32)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEliC)
								.addComponent(lblAnyC)
								.addComponent(lblModC))
							.addGap(32))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(202)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblApe1)
								.addComponent(lblApe2)
								.addComponent(lblFecha)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNom)))
							.addGap(27)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtApe1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtApe2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(47)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNomU)
								.addComponent(lblContr)
								.addComponent(lblEmail))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtCont, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNomU, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(49))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(357)
					.addComponent(lblBus)
					.addGap(27)
					.addComponent(txtBus, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(461, Short.MAX_VALUE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(347)
					.addComponent(lblGC, GroupLayout.PREFERRED_SIZE, 432, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(411, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(31)
					.addComponent(lblGC)
					.addGap(55)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNomU, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNomU)
						.addComponent(lblNom))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtApe1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCont, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblApe1)
						.addComponent(lblContr))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtApe2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblApe2)
						.addComponent(lblEmail))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFecha))
					.addGap(101)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtBus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBus))
					.addPreferredGap(ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblAnyC)
							.addGap(81)
							.addComponent(lblModC)
							.addGap(89)
							.addComponent(lblEliC)
							.addGap(89))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(13)
							.addComponent(lblAny, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblMod, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblEli, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addGap(60))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(listCli, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE)
							.addGap(43))))
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
