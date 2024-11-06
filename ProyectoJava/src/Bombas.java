import java.util.Random;

public class Bombas {
    private int filas;
    private int columnas;
    private int numeroBombas;
    private boolean[][] bombas;

    public Bombas(int filas_juego, int columnas_juego, int numeroBombas_juego) {
        // Asigna los parámetros a las variables de instancia correctamente
        this.filas = filas_juego;
        this.columnas = columnas_juego;
        this.numeroBombas = numeroBombas_juego;

        // Inicializa el array bombas con las dimensiones correctas
        bombas = new boolean[filas][columnas];
        colocar_bombas();
    }

    private void colocar_bombas() {
        int bombasColocadas = 0;
        Random random = new Random();

        while (bombasColocadas < this.numeroBombas) {
            int fila = random.nextInt(this.filas);
            int columna = random.nextInt(this.columnas);

            if (!bombas[fila][columna]) {
                bombas[fila][columna] = true;
                bombasColocadas++;
            }
        }
    }

    public boolean hayBombas(int fila, int columna) {
        //return this.bombas[fila][columna];
    	return true;
    }
}