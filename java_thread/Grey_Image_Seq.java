
package java_thread;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;

/* transforma um conjunto de imagens coloridas em preto e branco
   somente usando uma thread
*/
public class Grey_Image_Seq {
    public static void main(String[] args){
    
    String caminho;
    Scanner entrada = new Scanner(System.in);
    
    System.out.println("Diretório:");
    caminho = entrada.next();
    
    Lista_Arquivo lista_fil = new Lista_Arquivo(caminho);
    int tamanho = lista_fil.getTamanho();
    BufferedImage imagem;
    
    for(int i=0; i < tamanho-1; i++){
        try {
            
            imagem = ImageIO.read(lista_fil.getArquivo(i));
            int tam_x = imagem.getWidth();
            int tam_y = imagem.getHeight();
            
            for(int x = 0; x < tam_x; x++){
                for(int y = 0; y < tam_y; y++){
                    
                    Color pixelColor = new Color(imagem.getRGB(x, y));
                    int numeroBrancoEPreto = (int) (pixelColor.getRed()*0.3 + pixelColor.getGreen()*0.59 + pixelColor.getBlue()*0.11);
                    Color escalaCinzaPixel = new Color(numeroBrancoEPreto,numeroBrancoEPreto,numeroBrancoEPreto);
                    
                    imagem.setRGB(x, y, escalaCinzaPixel.getRGB());
                }
                
                }
            
            ImageIO.write(imagem,"jpeg",lista_fil.getArquivo(i));
            
        } catch (IOException ex) {
            System.out.println("Erro!");
        }
    }
    
    
    }
}
