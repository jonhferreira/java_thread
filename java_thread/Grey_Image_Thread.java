
package java_thread;

import java.awt.image.BufferedImage;
import java.util.Scanner;

/* Tranforma um conjunto de imagens coloridas em preto e branco
   utilizando varias threads no preocesso(cada imagem tem sua respectiva thread)
*/

public class Grey_Image_Thread {
    public static void main(String[] args){
    
    String caminho;
    Scanner entrada = new Scanner(System.in);
    
    System.out.println("Diretório:");
    caminho = entrada.next();
    
    Lista_Arquivo lista_fil = new Lista_Arquivo(caminho);
    int tamanho = lista_fil.getTamanho();
    
    for(int i = 0; i<tamanho-1;i++){
        ThreadQ3 tread = new ThreadQ3(caminho,lista_fil.getArquivo(i),i);
        new Thread(tread).start();
    }
    
    
    }
}
