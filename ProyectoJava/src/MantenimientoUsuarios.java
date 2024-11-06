import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

public class MantenimientoUsuarios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUser;
	private JTextField txtPass;
	private ConexionBaseDeDatos conexion;
	private JTextField txtSearch;
	private DefaultTableModel modelo;
	private JTable table;
	private JTextField txtEmail;
	private JTextField txtCiudad;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MantenimientoUsuarios frame = new MantenimientoUsuarios();
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
	public MantenimientoUsuarios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 877, 515);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 240, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(531, 27, 320, 170);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "USUARIOS", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USER");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Gill Sans MT", Font.PLAIN, 17));
		lblNewLabel.setBounds(20, 24, 51, 14);
		panel.add(lblNewLabel);
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Gill Sans MT", Font.PLAIN, 11));
		txtUser.setBounds(91, 23, 161, 20);
		panel.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblPass = new JLabel("PASS");
		lblPass.setForeground(Color.WHITE);
		lblPass.setFont(new Font("Gill Sans MT", Font.PLAIN, 17));
		lblPass.setBounds(20, 56, 51, 14);
		panel.add(lblPass);
		
		txtPass = new JTextField();
		txtPass.setFont(new Font("Gill Sans MT", Font.PLAIN, 11));
		txtPass.setColumns(10);
		txtPass.setBounds(91, 55, 161, 20);
		panel.add(txtPass);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Gill Sans MT", Font.PLAIN, 17));
		lblEmail.setBounds(20, 87, 51, 14);
		panel.add(lblEmail);
		
		JLabel lblCiudad = new JLabel("CIUDAD");
		lblCiudad.setForeground(Color.WHITE);
		lblCiudad.setFont(new Font("Gill Sans MT", Font.PLAIN, 17));
		lblCiudad.setBounds(10, 124, 71, 14);
		panel.add(lblCiudad);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Gill Sans MT", Font.PLAIN, 11));
		txtEmail.setColumns(10);
		txtEmail.setBounds(91, 86, 161, 20);
		panel.add(txtEmail);
		
		txtCiudad = new JTextField();
		txtCiudad.setFont(new Font("Gill Sans MT", Font.PLAIN, 11));
		txtCiudad.setColumns(10);
		txtCiudad.setBounds(91, 123, 161, 20);
		panel.add(txtCiudad);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(531, 206, 320, 149);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "ACCIONES", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		//********************************MODIFICAR*******************************************
			JButton btnMod = new JButton("Modificar");
			btnMod.setBackground(new Color(255, 240, 0));
			btnMod.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String user = txtUser.getText().toString();
					String pass = txtPass.getText().toString();
					String pass_encriptada = Hash.sha1(pass);
					String email = txtEmail.getText().toString();
					String ciudad = txtCiudad.getText().toString();
					
					if(!(user.isEmpty() || pass.isEmpty() || email.isEmpty() || ciudad.isEmpty())) {
						String sql = "UPDATE usuarios SET pass='" + pass_encriptada + "', email='" + email + "', ciudad='" + ciudad + "' WHERE username='" + user + "'";
						ActualizarDatos(sql,"Actualizado");
						txtUser.setText("");
						txtPass.setText("");
						txtEmail.setText("");
						txtCiudad.setText("");
					}
					else {
						System.out.println("asdfasdfasdfasdfa");
					}
				
			}
		});
		btnMod.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		btnMod.setBounds(112, 24, 89, 23);
		panel_1.add(btnMod);
		//********************************DELETE*******************************************
		JButton btnDel = new JButton("Eliminar");
		btnDel.setBackground(new Color(255, 240, 0));
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = txtUser.getText().toString();
				String pass = txtPass.getText().toString();
				String email = txtEmail.getText().toString();
				String ciudad = txtCiudad.getText().toString();
				if(!(user.isEmpty() || pass.isEmpty())) {
					// Se instancia y configura JOptionPane
					int confirmado = JOptionPane.showConfirmDialog(null,
							"¿Desea eliminar el registro:" + user + "?");

					if (JOptionPane.OK_OPTION == confirmado) {
					
						String sql="DELETE FROM `usuarios` WHERE `username`='"+user+"'";
						ActualizarDatos(sql,"Eliminado");
						txtUser.setText("");
						txtPass.setText("");
						txtEmail.setText("");
						txtCiudad.setText("");
					}	
				}
			}
		});
		btnDel.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		btnDel.setBounds(214, 24, 89, 23);
		panel_1.add(btnDel);
		//********************************INSERTAR*******************************************
		JButton btnNew = new JButton("Nuevo");
		btnNew.setBackground(new Color(255, 240, 0));
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = txtUser.getText().toString();
				String pass = txtPass.getText().toString();
				String pass_encriptada = Hash.sha1(pass);
				String email = txtEmail.getText().toString();
				String ciudad = txtCiudad.getText().toString();
				if (usuarioExiste(user)) {
					JOptionPane.showMessageDialog(null, "El usuario ya existe", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
				String sql="INSERT INTO `usuarios` (`username`, `pass`,`email`,`ciudad`) "
						+ "VALUES ('"+ user+"', '"+pass_encriptada+"','"+email+"','"+ciudad+"');";
				ActualizarDatos(sql,"Grabado");
				txtUser.setText("");
				txtPass.setText("");
				txtEmail.setText("");
				txtCiudad.setText("");
			}
		}
	});
		btnNew.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		btnNew.setBounds(10, 24, 89, 23);
		panel_1.add(btnNew);
		
		txtSearch = new JTextField();
		txtSearch.setFont(new Font("Gill Sans MT", Font.PLAIN, 11));
		txtSearch.setBounds(21, 104, 229, 23);
		panel_1.add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.setBackground(new Color(255, 240, 0));
		btnBuscar.setForeground(new Color(255, 240, 0));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = txtSearch.getText().toString();
				String sql = "SELECT * FROM `usuarios` WHERE `username`='" +user+ "';";
				buscarDatos(sql);
				txtSearch.setText("");
			}

			
		});
		btnBuscar.setIcon(new ImageIcon("src\\assets\\lupa.png"));
		btnBuscar.setBounds(261, 92, 42, 43);
		panel_1.add(btnBuscar);
		
		JButton btnBan = new JButton("Banear");
		btnBan.setBackground(new Color(255, 240, 0));
		btnBan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = txtUser.getText().toString();
				
				if(!(user.isEmpty())) {
					String sql="UPDATE `usuarios` SET `estado`='Baneado' WHERE `username`='"+ user+"'";
					ActualizarDatos(sql,"Baneado");
					txtUser.setText("");
					txtPass.setText("");
					txtEmail.setText("");
					txtCiudad.setText("");
				}
				else {
					System.out.println("Faltan datos");
				}
			}
		});
		btnBan.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		btnBan.setBounds(60, 58, 89, 23);
		panel_1.add(btnBan);
		
		JButton btnUnban = new JButton("Desbanear");
		btnUnban.setBackground(new Color(255, 240, 0));
		btnUnban.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = txtUser.getText().toString();
				
				if(!(user.isEmpty())) {
					String sql="UPDATE `usuarios` SET `estado`='Activo' WHERE `username`='"+ user+"'";
					ActualizarDatos(sql,"Desbaneado");
					txtUser.setText("");
					txtPass.setText("");
					txtEmail.setText("");
					txtCiudad.setText("");
				}
				else {
					System.out.println("Faltan datos");
				}
				
			}
		});
		btnUnban.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		btnUnban.setBounds(175, 58, 97, 23);
		panel_1.add(btnUnban);
		
		// datos para el modelo de la tabla
		modelo = new DefaultTableModel();

		modelo.addColumn("username");
		modelo.addColumn("pass");
		modelo.addColumn("email");
		modelo.addColumn("ciudad");
		modelo.addColumn("estado");
		rellenartabla();
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.white);
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "LISTADO DE USUARIOS", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel_2.setBounds(9, 11, 512, 457);
		contentPane.add(panel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane);
        scrollPane.getViewport().setBackground(new Color(255,240,0));

        // Cambiamos el color de la letra del JTextArea

		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent raton) {
				int fila = table.rowAtPoint(raton.getPoint());
				int columna = table.columnAtPoint(raton.getPoint());
				if ((fila > -1) && (columna > -1)) {

					// JOptionPane.showMessageDialog(null, "fila: " + fila + "
					// columna: " + columna);

					txtUser.setText(modelo.getValueAt(fila,0).toString());
					txtPass.setText(modelo.getValueAt(fila,1).toString());
					txtEmail.setText(modelo.getValueAt(fila,2).toString());
					txtCiudad.setText(modelo.getValueAt(fila,3).toString());
				}
			}
		});
		table.setEnabled(false);
		table.setBounds(0, 0, 1, 1);
		
		table.setModel(modelo);
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(Color.black); // Color de fondo en RGB
        headerRenderer.setForeground(Color.white); // Color del texto en RGB
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setDefaultRenderer(headerRenderer);
		table.setBackground(new Color(255, 240, 0)); // Amarillo claro
		table.setForeground(Color.black); 
		table.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
				
	}
	

	//********************************FUNCIÓN ACCESO A BASE DE DATOS*******************************************
	//+++++++++++++++++++++++CONSULTAS DE ACCIÓN+++++++++++++++++++++++++++++++
	public void ActualizarDatos(String sql,String accion) {
		//Conectamos con la Base de datos
		Connection conn;
		conexion = new ConexionBaseDeDatos();
		conn = conexion.conectarMySQL();
		
		// OPERACIONES CON BASE DE DATOS
		try {
			// Statement necesario para ir a la base Datos
			Statement alguienquesabesql = conn.createStatement();
			
			// ResultSet Almacena el resultado de nuestra consulta
			alguienquesabesql.executeUpdate(sql);
			conn.close(); //Cerramos la Conexión
			String msg = "El Registro ha sido "+ accion +" con éxito";
			JOptionPane.showMessageDialog(null, msg, "Registro", JOptionPane.INFORMATION_MESSAGE);
			conn.close();
	    }
		catch (SQLException e1) {//CASO de que falle el registro
			// ERRORES
			 int errorCode = e1.hashCode();
			 String msg="";
			 txtPass.setText(String.valueOf(errorCode));
			 msg = "No ha sido posible realizar la operación.";
			JOptionPane.showMessageDialog(null, msg, 
					"Error Base de Datos!!!", JOptionPane.ERROR_MESSAGE);
		}
		catch (Exception e3) {
			JOptionPane.showMessageDialog(null, "Revisar servidor", 
					"Error al conectar!!!", JOptionPane.ERROR_MESSAGE);
		}
		refrescarModelo();
		
	}
	//+++++++++++++++++++++++++CONSULTAS E BUSQUEDA++++++++++++++++++++++++++++++++++
	public void buscarDatos(String consulta) {
		//Conectamos con la Base de datos
		conexion = new ConexionBaseDeDatos(); 
		Connection conn = conexion.conectarMySQL();
		
		//Statement necesario para ir a la base Datos
		PreparedStatement comando;
		try {
			comando = conn.prepareStatement(consulta);
			//ResultSet Almacena el resultado de nuestra consulta
			ResultSet registro;//Bolsa vacia para cargar con los registros
			registro = comando.executeQuery(consulta);
			if (registro.next()) { //¿hay registros?
				txtUser.setText(registro.getString("user"));
				txtPass.setText(registro.getString("pass"));
				
			}else {
				JOptionPane.showMessageDialog(null,"No se encontraron registros",
						"Sin Coincidencias!!!",JOptionPane.ERROR_MESSAGE);
				txtUser.setText("");
				txtPass.setText("");
				txtEmail.setText("");
				txtCiudad.setText("");
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	//+++++++++++++++++++++++++RELLENAR TABLA CON DATOS ++++++++++++++++++++++++++++++++++
	
	/**
	 * refrescarModelo() Método que refresca el JTable cuando realizamos una
	 * operación sobre la Base de datos(Insert,Update o Delete)
	 */
	private void refrescarModelo() {
		int filas = modelo.getRowCount();

		for (int i = 0; i < filas; i++) {
			modelo.removeRow(0);
		}
		rellenartabla();
	}

	/**
	 * rellenarTabla() Método que rellena el JTable con los datos obtenidos de
	 * la Base de Datos
	 */
	private void rellenartabla() {

		try {
			conexion = new ConexionBaseDeDatos(); 
			Connection conn = conexion.conectarMySQL();
			
			String sql = "Select * from usuarios";
			
			Statement comando = conn.prepareStatement(sql);
			ResultSet registro = comando.executeQuery(sql);
			 
			Object[] fila = new Object[5];
			while (registro.next()) {
				//JLabel lblfoto = new JLabel("Foto");
				//ImageIcon imagenLupa = new ImageIcon("assets/lupa.jpg");
				//lblfoto.setIcon(imagenLupa);
				// Lo que hay entre comillas son los campos de la base de datos
				fila[0] = registro.getString("username");
				fila[1] = registro.getString("pass");
				fila[2] = registro.getString("email");
				fila[3] = registro.getString("ciudad");
				fila[4] = registro.getString("estado");	
				//fila[4] = lblfoto.getIcon();
				// Añade una fila al final del modelo de la tabla
				modelo.addRow(fila);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.toString());
		}
	}
	private boolean usuarioExiste(String user) {
	    boolean existe = false;
	    try {
	        Connection conn = conexion.conectarMySQL();
	        user = txtUser.getText().toString();
	        String sql = "SELECT COUNT(*) AS total FROM `usuarios` WHERE `username`='" + user + "'";
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            int total = rs.getInt("total");
	            existe = (total > 0);
	        }
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return existe;
	}
}