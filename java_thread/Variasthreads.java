package java_thread;

import java.time.LocalTime;

/* Arquivo cria quatro threads e imprime as mensagens associadas a elas */


public class Variasthreads {
    public static int pos = 0;
    public static void main(String[] args) throws InterruptedException {
        
        Object comunic = new Object();
	
       
	ThreadQ2 thread_M = new ThreadQ2("Michelangelo", comunic);
        ThreadQ2 thread_R = new ThreadQ2("Raphael", comunic);
        ThreadQ2 thread_D = new ThreadQ2("Donatello", comunic);
        ThreadQ2 thread_L = new ThreadQ2("Leonardo", comunic);
	
       	Thread thread_Mich = new Thread(thread_M);
        Thread thread_Rafa = new Thread(thread_R);
        Thread thread_Doni = new Thread(thread_D);
        Thread thread_Leo = new Thread(thread_L);
        
        thread_Mich.start();
        thread_Rafa.start();
        thread_Doni.start();
        thread_Leo.start();
        
       
        
        for(int i=0; i<10;i++){
            
            synchronized(comunic){
                System.out.println("- Parando thread principal...");
                System.out.println();
                comunic.wait(1000);
            }
         System.out.println("- Voltando para thread principal...");
         System.out.println();
         boolean cond = thread_Mich.isAlive() || thread_Rafa.isAlive();
         cond =  cond ||thread_Leo.isAlive()||thread_Doni.isAlive();  
         
         if(!cond){
            System.out.println("Horário de termino das Threads: "+LocalTime.now());
            break;
         }
           
        }
        
       
        
        
        
        
    }
}
