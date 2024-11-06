
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
import javax.swing.JComboBox;
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
import java.awt.Dimension;

import javax.swing.DefaultComboBoxModel;
import javax.swing.border.EtchedBorder;

public class InsertarJuegos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JComboBox cmbTipo;
	private ConexionBaseDeDatos conexion;
	private JTextField txtSearch;
	private DefaultTableModel modelo;
	private JTable table;
	private JComboBox cmbTipo2;
	private JTextField txtPlataforma;
	private JTextField txtPrecio;
	private JComboBox cmbEstado;
	private JTextField txtOfertas;
	private JTextField txtDescripcion;
	private JTextField txtImagen;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertarJuegos frame = new InsertarJuegos();
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
	public InsertarJuegos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1301, 730);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 240, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(918, 51, 357, 569);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "JUEGOS", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Gill Sans MT", Font.PLAIN, 17));
		lblNombre.setBounds(31, 31, 67, 14);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Gill Sans MT", Font.PLAIN, 11));
		txtNombre.setBounds(137, 30, 209, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo 1");
		lblTipo.setForeground(Color.WHITE);
		lblTipo.setFont(new Font("Gill Sans MT", Font.PLAIN, 17));
		lblTipo.setBounds(31, 83, 51, 14);
		panel.add(lblTipo);
		
		cmbTipo = new JComboBox();
		cmbTipo.setModel(new DefaultComboBoxModel(new String[] {"Accion", "Aventura", "Estrategia", "Rol", "Deportes", "Puzzle", "Simulacion", "Plataforma", "Multijugador", "Indie", "Realidad Virtual", "Sandbox", "Musical", "Terror", "Casual", "Arcade", "Educacional", "Otros"}));
		cmbTipo.setFont(new Font("Gill Sans MT", Font.PLAIN, 15));
		cmbTipo.setBounds(137, 82, 209, 20);
		panel.add(cmbTipo);
		
		JLabel lblTipo2 = new JLabel("Tipo 2");
		lblTipo2.setForeground(Color.WHITE);
		lblTipo2.setFont(new Font("Gill Sans MT", Font.PLAIN, 17));
		lblTipo2.setBounds(31, 134, 51, 14);
		panel.add(lblTipo2);
		
		JLabel lblPlataforma = new JLabel("Plataforma");
		lblPlataforma.setForeground(Color.WHITE);
		lblPlataforma.setFont(new Font("Gill Sans MT", Font.PLAIN, 17));
		lblPlataforma.setBounds(24, 184, 89, 14);
		panel.add(lblPlataforma);
		
		cmbTipo2 = new JComboBox();
		cmbTipo2.setModel(new DefaultComboBoxModel(new String[] {"Accion", "Aventura", "Estrategia", "Rol", "Deportes", "Puzzle", "Simulacion", "Plataforma", "Multijugador", "Indie", "Realidad Virtual", "Sandbox", "Musical", "Terror", "Casual", "Arcade", "Educacional", "Otros"}));
		cmbTipo2.setFont(new Font("Gill Sans MT", Font.PLAIN, 15));
		cmbTipo2.setBounds(137, 133, 209, 20);
		panel.add(cmbTipo2);
		
		txtPlataforma = new JTextField();
		txtPlataforma.setFont(new Font("Gill Sans MT", Font.PLAIN, 15));
		txtPlataforma.setColumns(10);
		txtPlataforma.setBounds(137, 183, 209, 20);
		panel.add(txtPlataforma);
		
		txtImagen = new JTextField();
		txtImagen.setFont(new Font("Gill Sans MT", Font.PLAIN, 15));
		txtImagen.setColumns(10);
		txtImagen.setBounds(137, 233, 209, 20);
		panel.add(txtImagen);
		
		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Gill Sans MT", Font.PLAIN, 15));
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(137, 282, 209, 20);
		panel.add(txtPrecio);
		
		JLabel lblImagen = new JLabel("url Imagen");
		lblImagen.setForeground(Color.WHITE);
		lblImagen.setFont(new Font("Gill Sans MT", Font.PLAIN, 17));
		lblImagen.setBounds(24, 234, 89, 14);
		panel.add(lblImagen);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setFont(new Font("Gill Sans MT", Font.PLAIN, 17));
		lblPrecio.setBounds(24, 283, 89, 14);
		panel.add(lblPrecio);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setForeground(Color.WHITE);
		lblDescripcion.setFont(new Font("Gill Sans MT", Font.PLAIN, 17));
		lblDescripcion.setBounds(24, 334, 89, 14);
		panel.add(lblDescripcion);
		
		txtOfertas = new JTextField();
		txtOfertas.setFont(new Font("Gill Sans MT", Font.PLAIN, 11));
		txtOfertas.setColumns(10);
		txtOfertas.setBounds(137, 472, 209, 20);
		panel.add(txtOfertas);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setForeground(Color.WHITE);
		lblEstado.setFont(new Font("Gill Sans MT", Font.PLAIN, 17));
		lblEstado.setBounds(24, 415, 89, 14);
		panel.add(lblEstado);
		
		JLabel lblOfertas = new JLabel("Ofertas");
		lblOfertas.setForeground(Color.WHITE);
		lblOfertas.setFont(new Font("Gill Sans MT", Font.PLAIN, 17));
		lblOfertas.setBounds(24, 473, 89, 14);
		panel.add(lblOfertas);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setFont(new Font("Gill Sans MT", Font.PLAIN, 15));
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(137, 334, 209, 44);
		panel.add(txtDescripcion);
		
		cmbEstado = new JComboBox();
		cmbEstado.setModel(new DefaultComboBoxModel(new String[] {"En Stock", "Agotado"}));
		cmbEstado.setFont(new Font("Gill Sans MT", Font.PLAIN, 15));
		cmbEstado.setBounds(137, 414, 209, 20);
		panel.add(cmbEstado);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(9, 0, 686, 149);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "ACCIONES", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		//********************************MODIFICAR*******************************************
			JButton btnMod = new JButton("Modificar");
			btnMod.setBackground(new Color(255, 240, 0));
			btnMod.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String name = txtNombre.getText().toString();
					String tipo_1 =  cmbTipo.getSelectedItem().toString();
					String tipo_2 =  cmbTipo2.getSelectedItem().toString();
					String plataforma = txtPlataforma.getText().toString();
					String Imagen = txtImagen.getText().toString();
					String precio = txtPrecio.getText().toString();
					String descripcion = txtDescripcion.getText().toString();
					String estado = cmbEstado.getSelectedItem().toString();
					String ofertas = txtOfertas.getText().toString();
					if(!(name.isEmpty() || plataforma.isEmpty() || Imagen.isEmpty() || precio.isEmpty() || descripcion.isEmpty()  )) {
						String sql = "UPDATE juegos SET tipo='" + tipo_1 + "', tipo2='" + tipo_2 + "', plataforma='" + plataforma + "', imagen='" + Imagen + "', precio='" + precio +"', descripcion='" + descripcion +"', estado_producto='" + estado + "', fk_stock='" + ofertas + "'WHERE nombre='" + name + "'";
						ActualizarDatos(sql,"Actualizado");
						txtNombre.setText("");
						cmbTipo.setSelectedIndex(0);
						cmbTipo2.setSelectedIndex(0);
						txtPlataforma.setText("");
						txtImagen.setText("");
						txtPrecio.setText("");
						txtDescripcion.setText("");
						cmbEstado.setSelectedIndex(0);
						txtOfertas.setText("");
						
					}
					else {
						System.out.println("asdfasdfasdfasdfa");
					}
				
			}
		});
		btnMod.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		btnMod.setBounds(288, 33, 113, 32);
		panel_1.add(btnMod);
		//********************************DELETE*******************************************
		JButton btnDel = new JButton("Eliminar");
		btnDel.setBackground(new Color(255, 240, 0));
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtNombre.getText().toString();
				
				if(!(name.isEmpty())) {
					// Se instancia y configura JOptionPane
					int confirmado = JOptionPane.showConfirmDialog(null,
							"¿Desea eliminar el registro:" + name + "?");

					if (JOptionPane.OK_OPTION == confirmado) {
					
						String sql="DELETE FROM `juegos` WHERE `nombre`='"+name+"'";
						ActualizarDatos(sql,"Eliminado");
						txtNombre.setText("");
						cmbTipo.setSelectedIndex(0);
						cmbTipo2.setSelectedIndex(0);
						txtPlataforma.setText("");
						txtImagen.setText("");
						txtPrecio.setText("");
						txtDescripcion.setText("");
						cmbEstado.setSelectedIndex(0);
						txtOfertas.setText("");
					}	
				}
			}
		});
		btnDel.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		btnDel.setBounds(538, 33, 113, 32);
		panel_1.add(btnDel);
		//********************************INSERTAR*******************************************
		JButton btnNew = new JButton("Nuevo");
		btnNew.setBackground(new Color(255, 240, 0));
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtNombre.getText().toString();
				String tipo_1 = cmbTipo.getSelectedItem().toString();
				String tipo_2 = cmbTipo2.getSelectedItem().toString();
				String plataforma = txtPlataforma.getText().toString();
				String Imagen = txtImagen.getText().toString();
				String precio = txtPrecio.getText().toString();
				String descripcion = txtDescripcion.getText().toString();
				String estado = cmbEstado.getSelectedItem().toString();
				String ofertas = txtOfertas.getText().toString();
				if (nombreExiste(name)) {
					JOptionPane.showMessageDialog(null, "El juego ya existe", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					String sql="INSERT INTO `juegos` (`nombre`, `tipo`,`tipo2`,`plataforma`,`imagen`,`precio`,`descripcion`,`estado_producto`,`fk_stock`) "
							+ "VALUES ('"+ name+"', '"+tipo_1+"','"+tipo_2+"','"+plataforma+"','"+Imagen+"','"+precio+"','"+descripcion+"','"+estado+"','"+ofertas+"');";
					ActualizarDatos(sql,"Grabado");
					txtNombre.setText("");
					cmbTipo.setSelectedIndex(0);
					cmbTipo2.setSelectedIndex(0);
					txtPlataforma.setText("");
					txtImagen.setText("");
					txtPrecio.setText("");
					txtDescripcion.setText("");
					cmbEstado.setSelectedIndex(0);
					txtOfertas.setText("");
				}
			}
		});
				
		btnNew.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		btnNew.setBounds(31, 34, 120, 30);
		panel_1.add(btnNew);
		
		txtSearch = new JTextField();
		txtSearch.setFont(new Font("Gill Sans MT", Font.PLAIN, 15));
		txtSearch.setBounds(174, 101, 347, 23);
		panel_1.add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.setBackground(new Color(255, 240, 0));
		btnBuscar.setForeground(new Color(255, 255, 255));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtSearch.getText().toString();
				String sql = "SELECT * FROM `juegos` WHERE `nombre`='" +name+ "';";
				buscarDatos(sql);
				txtSearch.setText("");
			}

			
		});
		btnBuscar.setIcon(new ImageIcon("src\\assets\\lupa.png"));
		btnBuscar.setBounds(565, 76, 61, 63);
		panel_1.add(btnBuscar);
		
		// datos para el modelo de la tabla
		modelo = new DefaultTableModel();

		modelo.addColumn("nombre");
		modelo.addColumn("tipo");
		modelo.addColumn("tipo2");
		modelo.addColumn("plataforma");
		modelo.addColumn("imagen");
		modelo.addColumn("precio");
		modelo.addColumn("descripcion");
		modelo.addColumn("estado");
		modelo.addColumn("ofertas");
		rellenartabla();
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.white);
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "LISTADO DE JUEGOS", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel_2.setBounds(0, 156, 915, 530);
		contentPane.add(panel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane);
        scrollPane.getViewport().setBackground(new Color(255,240,0));
        scrollPane.setPreferredSize(new Dimension(850, 500));
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

					txtNombre.setText(modelo.getValueAt(fila, 0).toString());
                    cmbTipo.setSelectedItem(modelo.getValueAt(fila, 1).toString());
                    cmbTipo2.setSelectedItem(modelo.getValueAt(fila, 2).toString());
                    txtPlataforma.setText(modelo.getValueAt(fila, 3).toString());
                    txtImagen.setText(modelo.getValueAt(fila, 4).toString());
                    txtPrecio.setText(modelo.getValueAt(fila, 5).toString());
                    txtDescripcion.setText(modelo.getValueAt(fila, 6).toString());
                    cmbEstado.setSelectedItem(modelo.getValueAt(fila, 7).toString());
                    txtOfertas.setText(modelo.getValueAt(fila, 8).toString());
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
			 txtNombre.setText(String.valueOf(errorCode));
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
				 txtNombre.setText(registro.getString("nombre"));
			        cmbTipo.setSelectedItem(registro.getString("tipo"));
			        cmbTipo2.setSelectedItem(registro.getString("tipo2"));
			        txtPlataforma.setText(registro.getString("plataforma"));
			        txtImagen.setText(registro.getString("imagen"));
			        txtPrecio.setText(registro.getString("precio"));
			        txtDescripcion.setText(registro.getString("descripcion"));
			        cmbEstado.setSelectedItem(registro.getString("estado_producto"));
			        txtOfertas.setText(registro.getString("fk_stock"));
			}else {
				JOptionPane.showMessageDialog(null,"No se encontraron registros",
						"Sin Coincidencias!!!",JOptionPane.ERROR_MESSAGE);
				txtNombre.setText("");
				cmbTipo.setSelectedIndex(0);
				cmbTipo2.setSelectedIndex(0);
				txtPlataforma.setText("");
				txtImagen.setText("");
				txtPrecio.setText("");
				txtDescripcion.setText("");
				cmbEstado.setSelectedIndex(0);
				txtOfertas.setText("");
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
			
			String sql = "Select * from juegos";
			
			Statement comando = conn.prepareStatement(sql);
			ResultSet registro = comando.executeQuery(sql);
			 
			Object[] fila = new Object[9];
			while (registro.next()) {
				//JLabel lblfoto = new JLabel("Foto");
				//ImageIcon imagenLupa = new ImageIcon("assets/lupa.jpg");
				//lblfoto.setIcon(imagenLupa);
				// Lo que hay entre comillas son los campos de la base de datos
				fila[0] = registro.getString("nombre");
				fila[1] = registro.getString("tipo");
				fila[2] = registro.getString("tipo2");
				fila[3] = registro.getString("plataforma");
				fila[4] = registro.getString("imagen");
				fila[5] = registro.getString("precio");
				fila[6] = registro.getString("descripcion");
				fila[7] = registro.getString("estado_producto");
				fila[8] = registro.getString("fk_stock");
				//fila[4] = lblfoto.getIcon();
				// Añade una fila al final del modelo de la tabla
				modelo.addRow(fila);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.toString());
		}
	}
	private boolean nombreExiste(String name) {
	    boolean existe = false;
	    try {
	        Connection conn = conexion.conectarMySQL();
	        name = txtNombre.getText().toString();
	        String sql = "SELECT COUNT(*) AS total FROM `juegos` WHERE `nombre`='" + name + "'";
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
