	package Pruebajuego;
	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.KeyEvent;
	import java.awt.event.KeyListener;
	import java.awt.image.BufferedImage;
	import java.io.File;
	import java.io.IOException;
	import javax.imageio.ImageIO;
	
	public class JumpGame extends JPanel implements ActionListener, KeyListener {
	
	    private int playerX = 50;  // Posición inicial del personaje en X
	    private int playerY = 300; // Posición inicial del personaje en Y
	    private int playerWidth = 50;  // Ancho del personaje
	    private int playerHeight = 50; // Altura del personaje
	    private int groundY = 300;  // Nivel del suelo
	
	    private boolean jumping = false;  // Indica si el personaje está saltando
	    private boolean falling = false;  // Indica si el personaje está cayendo
	    private boolean moveLeft = false;
	    private boolean moveRight = false;
	
	    private int jumpSpeed = 15;  // Velocidad inicial del salto
	    private int fallSpeed = 0;   // Velocidad de la caída (gravedad)
	
	    private BufferedImage playerImage;
	    private BufferedImage backgroundImage;
	
	    private Timer timer;
	
	    public JumpGame() {
	        setFocusable(true);
	        setPreferredSize(new Dimension(800, 400));
	        addKeyListener(this);
	
	        // Cargar imágenes
	        try {
	        	playerImage = ImageIO.read(getClass().getResource("/resources/character.png"));
	        	backgroundImage = ImageIO.read(getClass().getResource("/resources/background.png"));
	        } catch (IOException e) {
	            System.out.println("Error cargando imágenes: " + e.getMessage());
	        }
	
	        timer = new Timer(20, this);
	        timer.start();
	    }
	
	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	
	        // Dibujar fondo
	        if (backgroundImage != null) {
	            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
	        } else {
	            g.setColor(Color.CYAN);
	            g.fillRect(0, 0, getWidth(), getHeight());
	        }
	
	        // Dibujar el personaje
	        if (playerImage != null) {
	            g.drawImage(playerImage, playerX, playerY, playerWidth, playerHeight, null);
	        } else {
	            g.setColor(Color.BLUE);
	            g.fillRect(playerX, playerY, playerWidth, playerHeight);
	        }
	
	        // Dibujar el suelo si el fondo no lo cubre
	        g.setColor(Color.GREEN);
	        g.fillRect(0, groundY + playerHeight, getWidth(), getHeight() - groundY);
	    }
	
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        if (jumping) {
	            playerY -= jumpSpeed;
	            jumpSpeed -= 1;
	
	            // Si la velocidad del salto es 0 o negativa, empieza a caer
	            if (jumpSpeed <= 0) {
	                jumping = false;
	                falling = true;
	            }
	        }
	
	        if (falling) {
	            playerY += fallSpeed;
	            fallSpeed += 1;
	
	            // Cuando el personaje toca el suelo, deja de caer
	            if (playerY >= groundY) {
	                playerY = groundY;
	                falling = false;
	                fallSpeed = 0;
	                jumpSpeed = 15; // Reiniciar velocidad de salto
	            }
	        }
	
	        // Movimiento lateral
	        if (moveLeft && playerX > 0) {
	            playerX -= 5;
	        }
	        if (moveRight && playerX + playerWidth < getWidth()) {
	            playerX += 5;
	        }
	
	        repaint();
	    }
	
	    @Override
	    public void keyPressed(KeyEvent e) {
	        int key = e.getKeyCode();
	
	        // Movimiento izquierda/derecha
	        if (key == KeyEvent.VK_LEFT) {
	            moveLeft = true;
	        } else if (key == KeyEvent.VK_RIGHT) {
	            moveRight = true;
	        }
	
	        // Saltar
	        if (key == KeyEvent.VK_SPACE && !jumping && !falling) {
	            jumping = true;
	        }
	    }
	
	    @Override
	    public void keyReleased(KeyEvent e) {
	        int key = e.getKeyCode();
	
	        if (key == KeyEvent.VK_LEFT) {
	            moveLeft = false;
	        } else if (key == KeyEvent.VK_RIGHT) {
	            moveRight = false;
	        }
	    }
	
	    @Override
	    public void keyTyped(KeyEvent e) {
	        // No se necesita
	    }
	
	    public static void main(String[] args) {
	        JFrame frame = new JFrame("Jumping Game with Sprite and Background");
	        JumpGame game = new JumpGame();
	        frame.add(game);
	        frame.pack();
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);
	    }
	}
	
