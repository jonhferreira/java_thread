
package java_thread;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/* Thread responsavel pela conversao individual da imagem colorida para a escala de cinza */

public class ThreadQ3 implements Runnable {

    private String caminho;
    private File arquivo;
    private BufferedImage imagem;
    private int id;
    
    public ThreadQ3(String caminho, File arquivo, int i){
        this.caminho = caminho;
        this.arquivo = arquivo;
        this.id = i;
    }
    
    
    @Override
    public void run() {
        try {
            System.out.println("id: "+ this.id);
            this.imagem = ImageIO.read(this.arquivo);
            float tam_x = this.imagem.getWidth();
            float tam_y = this.imagem.getHeight();
            
            float tam_x_desejado = (float) (tam_x*0.65);
            float tam_y_desejado = (float) (tam_y*0.65);
            
            for(int x = 0; x < tam_x; x++){
                for(int y = 0; y < tam_y; y++){
                    
                    Color pixelColor = new Color(this.imagem.getRGB(x, y));
                    int numeroBrancoEPreto = (int) (pixelColor.getRed()*0.3 + pixelColor.getGreen()*0.59 + pixelColor.getBlue()*0.11);
                    Color escalaCinzaPixel = new Color(numeroBrancoEPreto,numeroBrancoEPreto,numeroBrancoEPreto);
                    
                    this.imagem.setRGB(x, y, escalaCinzaPixel.getRGB());
                }
                
            }
           
            ImageIO.write(this.imagem,"jpeg",this.arquivo);
            
        } catch (IOException ex) {
            System.out.println("Erro!");
        }
    }
    
}
