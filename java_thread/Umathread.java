
package java_thread;

import java.util.Scanner;

/* Arquivo utiliza uma thread para imprimir um vetor normal e sua versao ordenada*/

public class Umathread {

    
    public static void main(String[] args) throws InterruptedException {
        int[] vetor = new int[10];
        Scanner input = new Scanner(System.in);
        String cont = "s";
     
     while(!cont.equals("n")){
       
         for(int i=0; i<10; i++){
           System.out.println("Valor: ");
           vetor[i] = input.nextInt();
       }
       
       ThreadQ1 threadQ1 = new ThreadQ1("thread 1", vetor);
       
       Thread th = new Thread(threadQ1);
       th.start();
       th.join();
       
       
       System.out.println("continuar(n/s):");
       cont = input.next();
       
      }
    }
}
    

