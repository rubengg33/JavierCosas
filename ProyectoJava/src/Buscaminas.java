import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Buscaminas extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel cronometrolbl;
    private int contador_tiempo = 0;
    private Timer timer;
    private Bombas mapa;
    //private String textoperdido="HAS PERDIDO";
    private int filas = 14;
    private int columnas = 18;
    private int numeroBombas = 40;
    //public JLabel lblTitulo;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Buscaminas frame = new Buscaminas();
                    frame.setVisible(true);
                    frame.setResizable(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Buscaminas() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 857, 684);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 240, 0));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        //PARTE SUPERIOR***********************************************************************************************
        
        JLabel lblTitulo = new JLabel("BUSCAMINAS");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
        lblTitulo.setBounds(285, 20, 310, 14);
        contentPane.add(lblTitulo);

        JLabel flag = new JLabel();
        flag.setIcon(new ImageIcon(Buscaminas.class.getResource("/resources/bandera2.png")));
        flag.setBounds(23, 20, 41, 38);
        contentPane.add(flag);

        JLabel num_flags = new JLabel("40");
        num_flags.setFont(new Font("Gill Sans MT", Font.BOLD, 23));
        num_flags.setBounds(56, 30, 35, 29);
        contentPane.add(num_flags);

        cronometrolbl = new JLabel("0000");
        cronometrolbl.setFont(new Font("Gill Sans MT", Font.PLAIN, 23));
        cronometrolbl.setBounds(772, 30, 59, 29);
        contentPane.add(cronometrolbl);

        //crear el temporizador para actualizar el cronómetro por segundo
        timer = new Timer(1000, new ActionListener() { //genera un evento cada 1000 ms(1 segundo), y el actionlistener se cumple cada vez que cumpla el tiempo
            public void actionPerformed(ActionEvent e) {
                contador_tiempo++;
                cronometrolbl.setText(actualizarTiempo(contador_tiempo));
            }
        });
        // Iniciar el temporizador
        timer.start();
        
      //PARTE SUPERIOR***********************************************************************************************
   
      //PARTE JUEGO**************************************************************************************************
        mapa = new Bombas(filas, columnas, numeroBombas);
        creacionTablero();
      //PARTE JUEGO**************************************************************************************************
    }
    
    private void creacionTablero() {
    	JPanel tablero = new JPanel();
    	tablero.setBounds(10,69,821,565);
    	contentPane.add(tablero);
    	tablero.setLayout(new GridLayout(filas, columnas));
    	
    	
    	for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				JButton boton = new JButton();
				int fila = i;
				int columna = j;
			boton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					if (mapa.hayBombas(fila, columna)) {
						boton.setBackground(new Color(255, 240, 0));
						boton.setText("B");
						timer.stop();
						//lblTitulo.setText(textoperdido);
					} else {
						boton.setText(" ");
						boton.setBackground(new Color(255, 240, 0));
						System.out.println("asdfasdfasdfs");
						
					}
				}
			});
			tablero.add(boton);
			}
		}
    }
    private String actualizarTiempo(int contador) {
        return String.format("%04d", contador);
        //especifica que los numeros tienen que tener como minimo 4 cifras, seguido de la d (decimal), 001, 002
    }
}