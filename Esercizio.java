import java.util.*;
import java.lang.Math;

class Program {
    private static Random random = new Random();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int n, i, c0, c1, c2;

        System.out.println("Inserisci la grandezza del vettore: ");
        n = input.nextInt();
        int[] v = new int[n];
        int[] w = new int[n];

        for (i = 0; i <= n - 1; i++) {
            v[i] = random.nextInt(n * 10);
        }
        System.out.println("Vettore non ordinato");
        visualizzaVettore(v, n);
        copiaVettore(v, n, w);
        c0 = bubbleSort(v, n);
        copiaVettore(w, n, v);
        c1 = bsOttimizzazionePassi(v, n);
        copiaVettore(w, n, v);
        c2 = bsSentinelle(v, n);
        // System.out.println(Espressione);
        visualizzaVettore(v, n);
        System.out.println("Numero di confronti con il metodo non ottimzzato: " + c0);
        System.out.println("Numero di confronti con il metodo ottimzzato 1: " + c1);
        System.out.println("Numero di confronti con il metodo ottimzzato 2: " + c2);
        if (c2 < c1 && c2 < c0) {
            System.out.println("Il programma funziona");
        }
    }
    
    public static int bsOttimizzazionePassi(int[] v, int n) {
        int cont, i, j, temp;

        cont = 0;
        for (i = 0; i <= n - 1; i++) {
            for (j = 0; j <= n - 2 - i; j++) {
                if (v[j] > v[j + 1]) {
                    temp = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = temp;
                }
                cont = cont + 1;
            }
        }
        
        return cont;
    }
    
    public static int bsSentinelle(int[] v, int n) {
        int cont, i, j, temp;
        boolean scambio;

        cont = 0;
        i = 0;
        scambio = true;
        while (i < n && scambio) {
            j = 0;
            scambio = false;
            while (j < n - 1 - i) {
                if (v[j] > v[j + 1]) {
                    temp = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = temp;
                    scambio = true;
                }
                cont = cont + 1;
                j = j + 1;
            }
            i = i + 1;
        }
        
        return cont;
    }
    
    public static int bubbleSort(int[] v, int n) {
        int cont, i, j, temp;

        cont = 0;
        for (i = 0; i <= n - 1; i++) {
            for (j = 0; j <= n - 2; j++) {
                if (v[j] > v[j + 1]) {
                    temp = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = temp;
                }
                cont = cont + 1;
            }
        }
        
        return cont;
    }
    
    public static void copiaVettore(int[] v1, int n, int[] v2) {
        int i;

        for (i = 0; i <= n - 1; i++) {
            v2[i] = v1[i];
        }
    }
    
    public static void visualizzaVettore(int[] v, int n) {
        int i;

        for (i = 0; i <= n - 1; i++) {
            System.out.println(v[i]);
        }
    }
}