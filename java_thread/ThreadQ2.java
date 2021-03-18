
package java_thread;

import java.time.LocalTime;

/* Thread responsavel por imprimir mensagens */
public class ThreadQ2 implements Runnable {

    private String nome;
    private Object comunic;
    
    public ThreadQ2(String nome,Object comunic){
        this.nome = nome;
        this.comunic = comunic;
    }

    
    @Override
    public void run() {
       
        
       for(int i = 0; i<4;i++){ 
           
           System.out.println(this.nome+" diz Olá Mundo!");
       }
       
       synchronized(this.comunic){
           Quest02.pos = Quest02.pos+1;
           System.out.println("Em "+Quest02.pos+"º Lugar: " + this.nome);
           comunic.notifyAll();
        }
       
       
       
       
    }
    
    
   
   
     public String getNome() {
        return nome;
    }
    
}
