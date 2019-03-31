/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publico;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andre
 */
public class indexador {

    private final List<File> diretorios = new ArrayList<>();
    private int contador;

    private void iniciar() {

        File caminho = new File(this.getClass().getPackage().toString());
        
        System.out.println("Caminho principal: " + caminho.getAbsolutePath());

        char caracter = caminho.getAbsolutePath().charAt(0);
        String dirPrincipal = String.valueOf(caracter);

        if (dirPrincipal.equals("/")) {
            System.out.println("Sistema Operacional Linux");
            listarArquivos(dirPrincipal);

        } else if (dirPrincipal.equals("C") || dirPrincipal.equals("D") || dirPrincipal.equals("E")) {
            System.out.println("Sistema Operacional Windows");
             listarArquivosWindows(dirPrincipal + ":\\");
        }

    }

    /**
     * Metodo que lista todos arquivos/diretorios de um caminho
     *
     * @param caminho
     */
    private void listarArquivos(String caminho) {
        File file = new File(caminho);
        File lista[];

        if (file.isDirectory()) {
            if (file.canRead()) {
                lista = file.listFiles();
                System.out.println("***************Caminho valido: '" + file.getAbsolutePath() + "'*************");
                imprimirListaArquivos(lista);

            } else {
                System.out.println("Caminho: '" + file.getAbsolutePath() + "' não pode ser lido...");
            }

        } else {
            //System.out.println("Caminho '" + file.getPath() + "' informado não é um diretorio");
            System.out.println(file.getAbsolutePath());
        }

    }
    
    
    
     private void listarArquivosWindows(String caminho) {
        File file = new File(caminho);
        file.setReadable(Boolean.TRUE, Boolean.FALSE);
        File lista[];

        if (file.isDirectory()) {
            if (file.canRead()) {
                lista = file.listFiles();
                System.out.println("***************Caminho valido: '" + file.getAbsolutePath() + "'*************");
                imprimirListaArquivos(lista);

            } else {
                System.out.println("Caminho: '" + file.getAbsolutePath() + "' não pode ser lido...");
            }

        } else {
            //System.out.println("Caminho '" + file.getPath() + "' informado não é um diretorio");
            System.out.println(file.getAbsolutePath());
        }

    }

    /**
     * Metodo que percorre uma matriz de arquivos e imprimi na tela
     *
     * @param arquivos
     */
    private void imprimirListaArquivos(File[] arquivos) {

        System.out.println("Total de arquivos encontratos no diretorio: " + arquivos.length + "\n");

        for (File arquivo : arquivos) {

            if (arquivo.isDirectory()) {
                System.out.println("D - " + arquivo.getAbsolutePath());
                diretorios.add(arquivo.getAbsoluteFile());
                System.out.println("Dir. add a lista: " + arquivo.getAbsolutePath());
            } else {
                System.out.println(arquivo.getAbsoluteFile());
            }

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        indexador index = new indexador();

        List<File> diretorios1 = index.diretorios;
        //index.listarArquivos("/");

        for (int i = 0; i <= index.contador; i++) {

            if (!diretorios1.isEmpty()) {
                index.listarArquivos(diretorios1.get(i).getAbsolutePath());

            } else {
                index.iniciar();
            }
            index.contador++;
        }

    }

}
