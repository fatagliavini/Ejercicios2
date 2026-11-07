import java.util.Arrays;
import java.util.Scanner;
 
public class Ejercicios2 {
 
    // 21. Invertir un arreglo
    static void invertir(int[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            int aux = a[i];
            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = aux;
        }
    }
 
    // 22. Buscar un número en un arreglo
    static boolean buscar(int[] a, int x) {
        for (int v : a) {
            if (v == x) return true;
        }
        return false;
    }
 
    // 23. Ordenar con burbuja (ascendente)
    static void burbuja(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int aux = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = aux;
                }
            }
        }
    }
 
    // 24. Eliminar duplicados
    static int[] eliminarDuplicados(int[] a) {
        int[] tmp = new int[a.length];
        int k = 0;
        for (int v : a) {
            boolean repetido = false;
            for (int j = 0; j < k; j++) {
                if (tmp[j] == v) {
                    repetido = true;
                    break;
                }
            }
            if (!repetido) tmp[k++] = v;
        }
        return Arrays.copyOf(tmp, k);
    }
 
    // 25. Intercalar dos arreglos de igual tamaño
    static int[] intercalar(int[] a, int[] b) {
        int[] c = new int[a.length * 2];
        for (int i = 0; i < a.length; i++) {
            c[2 * i] = a[i];
            c[2 * i + 1] = b[i];
        }
        return c;
    }
 
    // 26. Transponer una matriz n x m
    static int[][] transponer(int[][] A) {
        int n = A.length, m = A[0].length;
        int[][] T = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                T[j][i] = A[i][j];
            }
        }
        return T;
    }
 
    // 27. Suma de matrices n x m
    static int[][] sumaMatrices(int[][] A, int[][] B) {
        int n = A.length, m = A[0].length;
        int[][] S = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                S[i][j] = A[i][j] + B[i][j];
            }
        }
        return S;
    }
 
    // ---------- Utilidades de entrada/salida ----------
 
    static int[] leerArreglo(Scanner sc, int n, String nombre) {
        int[] a = new int[n];
        System.out.println("Ingresa los " + n + " elementos de " + nombre + ":");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        return a;
    }
 
    static int[][] leerMatriz(Scanner sc, int n, int m, String nombre) {
        int[][] M = new int[n][m];
        System.out.println("Ingresa la matriz " + nombre + " (" + n + "x" + m + "):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                M[i][j] = sc.nextInt();
            }
        }
        return M;
    }
 
    static void imprimirMatriz(int[][] M) {
        for (int[] fila : M) {
            for (int v : fila) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
 
        do {
            System.out.println("\n=== Ejercicios 21 - 27 ===");
            System.out.println("21. Invertir un arreglo");
            System.out.println("22. Buscar un número en un arreglo");
            System.out.println("23. Ordenar con burbuja");
            System.out.println("24. Eliminar duplicados");
            System.out.println("25. Intercalar dos arreglos");
            System.out.println("26. Transponer una matriz");
            System.out.println("27. Suma de matrices");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
 
            switch (opcion) {
                case 21: {
                    System.out.print("Tamaño del arreglo: ");
                    int[] a = leerArreglo(sc, sc.nextInt(), "el arreglo");
                    invertir(a);
                    System.out.println("Invertido: " + Arrays.toString(a));
                    break;
                }
                case 22: {
                    System.out.print("Tamaño del arreglo: ");
                    int[] a = leerArreglo(sc, sc.nextInt(), "el arreglo");
                    System.out.print("Número a buscar: ");
                    int x = sc.nextInt();
                    System.out.println(buscar(a, x)
                            ? "El número está en el arreglo"
                            : "El número NO está en el arreglo");
                    break;
                }
                case 23: {
                    System.out.print("Tamaño del arreglo: ");
                    int[] a = leerArreglo(sc, sc.nextInt(), "el arreglo");
                    burbuja(a);
                    System.out.println("Ordenado: " + Arrays.toString(a));
                    break;
                }
                case 24: {
                    System.out.print("Tamaño del arreglo: ");
                    int[] a = leerArreglo(sc, sc.nextInt(), "el arreglo");
                    System.out.println("Sin duplicados: " + Arrays.toString(eliminarDuplicados(a)));
                    break;
                }
                case 25: {
                    System.out.print("Tamaño de los arreglos: ");
                    int n = sc.nextInt();
                    int[] a = leerArreglo(sc, n, "el primer arreglo");
                    int[] b = leerArreglo(sc, n, "el segundo arreglo");
                    System.out.println("Intercalado: " + Arrays.toString(intercalar(a, b)));
                    break;
                }
                case 26: {
                    System.out.print("Filas (n): ");
                    int n = sc.nextInt();
                    System.out.print("Columnas (m): ");
                    int m = sc.nextInt();
                    int[][] A = leerMatriz(sc, n, m, "A");
                    System.out.println("Transpuesta:");
                    imprimirMatriz(transponer(A));
                    break;
                }
                case 27: {
                    System.out.print("Filas (n): ");
                    int n = sc.nextInt();
                    System.out.print("Columnas (m): ");
                    int m = sc.nextInt();
                    int[][] A = leerMatriz(sc, n, m, "A");
                    int[][] B = leerMatriz(sc, n, m, "B");
                    System.out.println("Suma:");
                    imprimirMatriz(sumaMatrices(A, B));
                    break;
                }
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 0);
 
        sc.close();
    }
}
 