//
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        TresEnRaya juego = new TresEnRaya();
//        Scanner scanner = new Scanner(System.in);
//        boolean juegoTerminado = false;
//
//        while (!juegoTerminado) {
//            juego.imprimirTablero();
//            System.out.println("Turno del jugador " + juego.getJugadorActual() + ", ingresa tu movimiento (fila [1-3] y columna [1-3]):");
//            int fila = scanner.nextInt() - 1;
//            int columna = scanner.nextInt() - 1;
//
//            if (juego.colocarMarca(fila, columna)) {
//                juegoTerminado = juego.comprobarGanador();
//                if (juegoTerminado) {
//                    juego.imprimirTablero();
//                    System.out.println("El jugador " + juego.getJugadorActual() + " ha ganado!");
//                } else {
//                    juego.cambiarJugador();
//                }
//            } else {
//                System.out.println("Movimiento inválido, intenta de nuevo.");
//            }
//        }
//
//        scanner.close();
//    }
//}
