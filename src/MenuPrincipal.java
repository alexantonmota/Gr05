import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Ventana Principal donde se accede a cartelera y peliculas
 * @author alex
 *
 */
public class MenuPrincipal extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public JLabel lblNewLabel_1= new JLabel();

	static int contador=0;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */

	public MenuPrincipal() {
		setBounds(60, 10, 1700, 1000);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblCine = new JLabel("CINE DEUSTO");
		lblCine.setForeground(Color.GRAY);
		lblCine.setOpaque(true);
		lblCine.setBackground(Color.ORANGE);
		lblCine.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 60));
		lblCine.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnCartelera = new JButton("Ir a Cartelera");
		btnCartelera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				dispose();
				Cartelera cartelera = new Cartelera();
				cartelera.setVisible(true);
			}
		});
		btnCartelera.setBackground(Color.ORANGE);
		btnCartelera.setForeground(Color.GRAY);
		btnCartelera.setOpaque(true);
		btnCartelera.setBorderPainted(false);
		btnCartelera.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 24));

		//Label en que apareceran los posterMenu de las peliculas cada x tiempo
		JLabel lblPosM = new JLabel("");

		lblPosM.setBorder(BorderFactory.createLineBorder(Color.ORANGE,5));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addContainerGap()
										.addComponent(lblCine, GroupLayout.DEFAULT_SIZE, 1678, Short.MAX_VALUE))
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addGap(732)
										.addComponent(btnCartelera, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addGap(118)
										.addComponent(lblPosM, GroupLayout.PREFERRED_SIZE, 1445, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap())
				);
		gl_contentPanel.setVerticalGroup(
				gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblCine, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
						.addGap(41)
						.addComponent(lblPosM, GroupLayout.PREFERRED_SIZE, 597, GroupLayout.PREFERRED_SIZE)
						.addGap(61)
						.addComponent(btnCartelera, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(41, Short.MAX_VALUE))
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

						new InicioSesion();

					}
				});
				cancelButton.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));
				cancelButton.setBackground(Color.GRAY);
				cancelButton.setOpaque(true);
				cancelButton.setBorderPainted(false);
				cancelButton.setForeground(Color.ORANGE);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}


	}
	public static void main(String[] args) {
		try {
			MenuPrincipal dialog = new MenuPrincipal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);




		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
