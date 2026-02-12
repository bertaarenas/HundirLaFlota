import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tablero = 7;
        char[][] tablero1 = new char[tablero][tablero];
        char[][] tablero2 = new char[tablero][tablero];

        for (int i = 0; i < tablero; i++) {
            for (int j = 0; j < tablero; j++) {
                tablero1[i][j] = '~';
                tablero2[i][j] = '~';
            }
        }

        System.out.println("-- BIENVENIDO A HUNDIR LA FLOTA --");
        System.out.println("En este juego participaran dos jugadores!, a continuación introducir los nombres de cada jugador.");
        System.out.println("Jugador 1: ");
        String jugador1 = sc.nextLine();
        System.out.println("Jugador 2: ");
        String jugador2 = sc.nextLine();
        System.out.println("Genial!");

        // Cada jugador coloca sus barcos

        int barcos = 4;

        //Jugador 1
        System.out.println(jugador1 + " introduce tus " + barcos + " barcos.");
        for (int i = 0; i < barcos; i++) {
            System.out.println("Barco: " + i);
            System.out.print("Fila (0-6)");
            int fila = sc.nextInt();
            System.out.print("Columna (0-6)");
            int col = sc.nextInt();
            if (tablero1[fila][col] == '~') {
                tablero1[fila][col] = 'B';
                System.out.println("Guardado!");
            }
            else {
                System.out.println("Posición ocupada, intenta otra posición.");
            }

        }

        // Jugador 2
        System.out.println("Turno jugador 2:");
        System.out.println(jugador2 + " introduce tus " + barcos + " barcos.");
        for (int i = 0; i < barcos; i++) {
            System.out.println("Barco: " + i);
            System.out.print("Fila (0-6)");
            int fila = sc.nextInt();
            System.out.print("Columna (0-6)");
            int col = sc.nextInt();
            if (tablero2[fila][col] == '~') {
                tablero2[fila][col] = 'B';
                System.out.println("Guardado!");
            }
            else {
                System.out.println("Posición ocupada, intenta otra posición.");
            }

        }
        int jugador = 1;

        // Juego
        while (true) {

            if (jugador == 1) {
                System.out.println("Turno Jugador 1:");
                // tablero enemigo (solo disparos)
                for (int i = 0; i < tablero; i++) {
                    for (int j = 0; j < tablero; j++) {
                        if (tablero2[i][j] == 'B') {
                            System.out.print("~ ");
                        }
                        else {
                            System.out.print(tablero2[i][j] + " ");
                        }
                    }
                    System.out.println();
                }
                System.out.print("Dispara (fila): ");
                int fila = sc.nextInt();
                System.out.print("Dispara (columna): ");
                int col = sc.nextInt();

                if (tablero2[fila][col] == 'B') {
                    tablero2[fila][col] = 'X';
                    System.out.println("Tocado y hundido!");
                } else if (tablero2[fila][col] == '~') {
                    tablero2[fila][col] = 'O';
                    System.out.println("Agua.");
                } else {
                    System.out.println("Ya has disparado ahí.");
                }

                int contadorBarcos = 0;
                for (int i = 0; i < tablero; i++)
                    for (int j = 0; j < tablero; j++)
                        if (tablero2[i][j] == 'B') {
                            contadorBarcos++;
                        }
                if (contadorBarcos == 0) {
                    System.out.println(jugador1 + " gana!");
                    System.exit(0);
                }

                jugador = 2;

            } else {
                System.out.println("Turno Jugador 2");
                for (int i = 0; i < tablero; i++) {
                    for (int j = 0; j < tablero; j++) {
                        if (tablero1[i][j] == 'B') System.out.print("~ ");
                        else System.out.print(tablero1[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.print("Dispara (fila): ");
                int fila = sc.nextInt();
                System.out.print("Dispara (columna): ");
                int col = sc.nextInt();

                if (tablero1[fila][col] == 'B') {
                    tablero1[fila][col] = 'X';
                    System.out.println("Tocado y hundido!");
                } else if (tablero1[fila][col] == '~') {
                    tablero1[fila][col] = 'O';
                    System.out.println("Agua.");
                } else {
                    System.out.println("Ya has disparado ahí.");
                }

                int count = 0;
                for (int i = 0; i < tablero; i++)
                    for (int j = 0; j < tablero; j++)
                        if (tablero1[i][j] == 'B') {
                            count++;
                        }
                if (count == 0) {
                    System.out.println(jugador2 + " gana!");
                    System.exit(0);
                }

            }
        }




    }
}
