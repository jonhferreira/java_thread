
package java_thread;

import java.io.File;

/* Responsavel por coletar a lista de imagens contidas no diretorio */

public class Lista_Arquivo {
    
    private String caminho;
    private File pasta;
    private File[] lista_file;
    private int tamanho;


    
    public Lista_Arquivo(String caminho){
        this.caminho = caminho;
        pasta = new File(this.caminho);
        lista_file = pasta.listFiles();
        tamanho = lista_file.length;
    }
    
    public File getArquivo(int i){
        return this.lista_file[i];
    }
    
    public int getTamanho() {
        return tamanho;
    }
    
}
