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
 * @author Andre
 */
public class View extends javax.swing.JFrame {

    /**
     * Creates new form View
     */
    public View() {
        initComponents();
        File ca1 = new File("/");
        diretorios.add(ca1);
        String os = System.getProperty("os.name");
        String user = System.getProperty("user.name");
        String dirPrincipal = System.getProperty("user.home");
        String areaTrab = System.getProperty("user.dir");
        System.out.println("OS: " + os);
        System.out.println("usuario: " + user);
        System.out.println("diretorio: " + dirPrincipal);
        System.out.println("Area trabalho: " + areaTrab);
    }

    List<File> diretorios = new ArrayList<>();
    int contador;
    Thread threadLocal;

    private void iniciar() {

        File caminho = new File(this.getClass().getPackage().toString());

        areaImpressao.append("Caminho Principal: " + caminho.getAbsolutePath() + "\n");
        //System.out.println("Caminho principal: " + caminho.getAbsolutePath());

        char caracter = caminho.getAbsolutePath().charAt(0);
        String dirPrincipal = String.valueOf(caracter);

        if (dirPrincipal.equals("/")) {
            areaImpressao.append("Sistema Operacional Linux\n");
            //System.out.println("Sistema Operacional Linux");
            listarArquivos(dirPrincipal);

        } else if (dirPrincipal.equals("C") || dirPrincipal.equals("D") || dirPrincipal.equals("E")) {
            areaImpressao.append("Sistema Operacional Windows\n");
            //System.out.println("Sistema Operacional Windows");
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
                areaImpressao.append("***************Caminho valido: '" + file.getAbsolutePath() + "'*************\n");
                // System.out.println("***************Caminho valido: '" + file.getAbsolutePath() + "'*************");
                imprimirListaArquivos(lista);

            } else {
                areaImpressao.append("Caminho: '" + file.getAbsolutePath() + "' não pode ser lido...\n");
                //System.out.println("Caminho: '" + file.getAbsolutePath() + "' não pode ser lido...");
            }

        } else {
            //System.out.println("Caminho '" + file.getPath() + "' informado não é um diretorio");
            areaImpressao.append(file.getAbsolutePath() + "\n");
            //System.out.println(file.getAbsolutePath());
        }

    }

    private void listarArquivosWindows(String caminho) {
        File file = new File(caminho);
        //file.setReadable(Boolean.TRUE, Boolean.FALSE);
        File lista[];

        if (file.isDirectory()) {
            if (file.canRead()) {
                lista = file.listFiles();
                areaImpressao.append("***************Caminho valido: '" + file.getAbsolutePath() + "'*************" + "\n");
                //System.out.println("***************Caminho valido: '" + file.getAbsolutePath() + "'*************");
                imprimirListaArquivos(lista);

            } else {
                areaImpressao.append("Caminho: '" + file.getAbsolutePath() + "' não pode ser lido...\n");
                //System.out.println("Caminho: '" + file.getAbsolutePath() + "' não pode ser lido...");
            }

        } else {
            //System.out.println("Caminho '" + file.getPath() + "' informado não é um diretorio");
            areaImpressao.append(file.getAbsolutePath() + "\n");
            //System.out.println(file.getAbsolutePath());
        }

    }

    /**
     * Metodo que percorre uma matriz de arquivos e imprimi na tela
     *
     * @param arquivos
     */
    private void imprimirListaArquivos(File[] arquivos) {

        //System.out.println("Total de arquivos encontratos no diretorio: " + arquivos.length + "\n");
        for (File arquivo : arquivos) {

            if (arquivo.isDirectory()) {
                areaImpressao.append("D - " + arquivo.getAbsolutePath() + "\n");
                //System.out.println("D - " + arquivo.getAbsolutePath());
                diretorios.add(arquivo.getAbsoluteFile());
                areaImpressao.append("Dir. add a lista: " + arquivo.getAbsolutePath() + "\n");
                //System.out.println("Dir. add a lista: " + arquivo.getAbsolutePath());
            } else {
                areaImpressao.append(arquivo.getAbsoluteFile() + "\n");
                //System.out.println(arquivo.getAbsoluteFile());
            }

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaImpressao = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        areaImpressao.setColumns(20);
        areaImpressao.setRows(5);
        jScrollPane1.setViewportView(areaImpressao);

        jButton1.setText("Execultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Parar indexador");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jButton1)
                .addGap(34, 34, 34)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        List<File> diretorios1 = this.diretorios;
        //index.listarArquivos("/");
        //listarArquivos("/");

        threadLocal = new Thread(new Runnable() {
            @Override
            public void run() {
                 for (int i = 0; i <= contador; i++) {
                    listarArquivos(diretorios1.get(contador).getAbsolutePath());
                    contador++;
                }
            }
        });
        threadLocal.start();
                /*
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= contador; i++) {
                    listarArquivos(diretorios1.get(contador).getAbsolutePath());
                    contador++;
                }

            }
        }).start(); 
                */
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        threadLocal.stop();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaImpressao;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
