import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuItem Menuinsert;
	private JMenuItem Menumng;
	private JMenuItem MenuMinas;
	private MantenimientoUsuarios Mng;
	private InsertarJuegos insert;
	private Buscaminas buscaminas;
	private JButton hiddenButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 912, 589);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 240, 0));
		setJMenuBar(menuBar);

		JMenu mnuAdministrar = new JMenu("Administrar");
		mnuAdministrar.setBackground(new Color(255, 240, 0));
		mnuAdministrar.setFont(new Font("Gill Sans MT", Font.PLAIN, 18));
		menuBar.add(mnuAdministrar);

		Menuinsert = new JMenuItem("Catalogo Juegos");
		Menuinsert.setBackground(new Color(255, 240, 0));
		Menuinsert.setFont(new Font("Gill Sans MT", Font.PLAIN, 13));
		mnuAdministrar.add(Menuinsert);
		Menuinsert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub
				insert = new InsertarJuegos();
				insert.setVisible(true);
			}
		});

		Menumng = new JMenuItem("Usuarios");
		Menumng.setBackground(new Color(255, 240, 0));
		Menumng.setFont(new Font("Gill Sans MT", Font.PLAIN, 13));
		mnuAdministrar.add(Menumng);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		Menumng.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub
				Mng = new MantenimientoUsuarios();
				Mng.setVisible(true);
			}
		});
		MenuMinas = new JMenuItem("Juego Oculto");
		MenuMinas.setBackground(new Color(255, 240, 0));
		MenuMinas.setFont(new Font("Gill Sans MT", Font.PLAIN, 13));
		mnuAdministrar.add(MenuMinas);
		MenuMinas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub
				buscaminas = new Buscaminas();
				buscaminas.setVisible(true);
			}
		});
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setBounds(0, 0, 896, 522);
		contentPane.add(lblImagen);
		ImageIcon imageIcon = new ImageIcon("src\\resources\\logo.png");
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH);
        lblImagen.setIcon(new ImageIcon(scaledImage));
        JButton btnHover = new JButton("Hover over me");
        btnHover.setFont(new Font("Gill Sans MT", Font.PLAIN, 18));
        btnHover.setBounds(150, 100, 150, 50);
        contentPane.add(btnHover);

        // Crear un botón oculto
        hiddenButton = new JButton("Hidden Button");
        hiddenButton.setFont(new Font("Gill Sans MT", Font.PLAIN, 18));
        hiddenButton.setBounds(150, 160, 150, 50);
        hiddenButton.setVisible(false); // Inicialmente oculto
        contentPane.add(hiddenButton);

        // Añadir MouseListener al botón visible
        btnHover.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btnHover.setBackground(Color.LIGHT_GRAY);
                hiddenButton.setVisible(true); // Mostrar el botón oculto
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnHover.setBackground(null);
                hiddenButton.setVisible(false); // Ocultar el botón oculto
            }
        });

        // Añadir ActionListener al botón oculto
        hiddenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hidden button clicked!");
            }
        });
	}
}

