
package java_thread;

import java.util.Arrays;

/* Thread responsavel por imprimir um vetor e sua versao ordenada*/

public class ThreadQ1 implements Runnable {
    private int[] entradaT1 = new int[10];
    private String nome;
    
    public ThreadQ1(String nome, int[] entrada){
        this.nome = nome;
        this.entradaT1 = entrada.clone();
    }

    
    public void run() {
        
        int[] entrada_ord = new int[10];
        
        entrada_ord = this.entradaT1.clone();
        Arrays.sort(entrada_ord);
        
        
        System.out.println("Normal:");
        for(int i=0; i < 10;i++){
            System.out.print(" "+this.entradaT1[i]);
        }
        System.out.println();
        System.out.println("Order");
        
        for(int j=0; j < 10;j++){
            System.out.print(" "+entrada_ord[j]);
        }
        System.out.println();
    }
    
    
    
}
