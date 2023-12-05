package sistemaDeInventario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class PantallaDeRegistro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField TNombreDeUsuario;
	private JTextField TContrasena;
	private JTextField TCorreoElectronico;
	
	File f = new File("C:\\Users\\Juan Pablo\\Documents\\TecMilenio\\Carpeta de Usuarios");
	
	int linea;
	
	String Usuario, Contrasena, Correo;
	
	
	
	void crearCarpeta() {
		if(!f.exists()) {
			f.mkdirs();
		}
	}
	
	void leerArchivo() {
		try {
			FileReader fr = new FileReader("C:\\Users\\Juan Pablo\\Documents\\TecMilenio\\Carpeta de Usuarios\\Usuarios.txt");
			System.err.println("El archivo ya existe");
		} catch (FileNotFoundException e) {
			try {
				FileWriter fw = new FileWriter("C:\\Users\\Juan Pablo\\Documents\\TecMilenio\\Carpeta de Usuarios\\Usuarios.txt");
				System.out.println("Archivo creado");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
		
		
	}
	
	void agregarDatos(String usr, String pwd, String email) {
		try {
			RandomAccessFile raf = new RandomAccessFile("C:\\\\Users\\\\Juan Pablo\\\\Documents\\\\TecMilenio\\\\Carpeta de Usuarios\\\\Usuarios.txt", "rw");
			for(int i=0; i<linea; i++) {
				raf.readLine();
			}
			raf.writeBytes("\r\n");
			raf.writeBytes("\r\n");
			raf.writeBytes("Usuario: "+usr+"\r\n");
			raf.writeBytes("Contrasena: "+pwd+"\r\n");
			raf.writeBytes("Correo: "+email);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	void checarDatos(String usr, String pwd) {
		try {
			RandomAccessFile raf = new RandomAccessFile("C:\\Users\\Juan Pablo\\Documents\\TecMilenio\\Carpeta de Usuarios\\Usuarios.txt", "rw");
			String line = raf.readLine();
			Usuario=line.substring(9);
			Contrasena=raf.readLine().substring(12);
			Correo= raf.readLine().substring(8);
			
			if(usr.equals(Usuario) & pwd.equals(Contrasena)) {
				JOptionPane.showMessageDialog(null, "Contraseña coincide");				
			} else {
				JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");					
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void contarLineas() {
		try {
			linea=1;
			RandomAccessFile raf = new RandomAccessFile("C:\\\\Users\\\\Juan Pablo\\\\Documents\\\\TecMilenio\\\\Carpeta de Usuarios\\\\Usuarios.txt", "rw");
			for(int i=0; raf.readLine() !=null;i++) {
				linea++;
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaDeRegistro frame = new PantallaDeRegistro();
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
	public PantallaDeRegistro() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 128, 128));
		panel.setBounds(0, 0, 436, 263);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel LNombreDeUsuario = new JLabel("Nombre De Usuario");
		LNombreDeUsuario.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
		LNombreDeUsuario.setBounds(10, 45, 176, 30);
		panel.add(LNombreDeUsuario);
		
		JLabel LContrasena = new JLabel("Contraseña");
		LContrasena.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
		LContrasena.setBounds(10, 85, 141, 30);
		panel.add(LContrasena);
		
		JLabel LCorreoElectronico = new JLabel("Correo Electrónico");
		LCorreoElectronico.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
		LCorreoElectronico.setBounds(10, 125, 176, 30);
		panel.add(LCorreoElectronico);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaDeConfirmacion pdc = new PantallaDeConfirmacion();
				crearCarpeta();
				leerArchivo();
				contarLineas();
				agregarDatos(TNombreDeUsuario.getText(), TContrasena.getText(), TCorreoElectronico.getText() );
				pdc.show();
				dispose();
				
				//checarDatos("Juan", "1234");
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		btnNewButton.setBounds(273, 207, 121, 30);
		panel.add(btnNewButton);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaDeInicio pdi = new PantallaDeInicio();
				pdi.show();
				
				dispose();
			}
		});
		btnRegresar.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		btnRegresar.setBounds(48, 207, 121, 30);
		panel.add(btnRegresar);
		
		TNombreDeUsuario = new JTextField();
		TNombreDeUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		TNombreDeUsuario.setColumns(10);
		TNombreDeUsuario.setBounds(203, 40, 177, 30);
		panel.add(TNombreDeUsuario);
		
		TContrasena = new JTextField();
		TContrasena.setColumns(10);
		TContrasena.setBounds(203, 84, 177, 30);
		panel.add(TContrasena);
		
		TCorreoElectronico = new JTextField();
		TCorreoElectronico.setColumns(10);
		TCorreoElectronico.setBounds(203, 124, 177, 30);
		panel.add(TCorreoElectronico);

	}

}
