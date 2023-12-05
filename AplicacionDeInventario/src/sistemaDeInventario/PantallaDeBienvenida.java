package sistemaDeInventario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class PantallaDeBienvenida extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaDeBienvenida frame = new PantallaDeBienvenida();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PantallaDeBienvenida() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 128, 128));
		panel.setBounds(0, 0, 436, 263);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido");
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		lblNewLabel.setBounds(147, 10, 129, 44);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Por favor selecciona la opción deseada");
		lblNewLabel_1.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(82, 48, 266, 34);
		panel.add(lblNewLabel_1);

	}

}
