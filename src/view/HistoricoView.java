/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;
import spotfei.dao.UsuarioDAO;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import spotfei.model.Usuario; 
/**
 * Classe responsável por exibir a interface gráfica com três abas:
 * Histórico de músicas buscadas, músicas curtidas e músicas descurtidas.
 * Cada aba contém uma tabela com os dados respectivos e um botão para retornar ao menu principal.
 * 
 * A classe utiliza o padrão Swing para criar a interface, e se comunica com a camada DAO
 * para recuperar os dados do usuário logado.
 * 
 * Requer a classe {@link spotfei.dao.UsuarioDAO} e o modelo {@link spotfei.model.Usuario}.
 * 
 * @author joaog
 */


public class HistoricoView extends javax.swing.JFrame {
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    /**
     * Carrega as últimas 10 buscas realizadas pelo usuário logado.
     * Os dados são exibidos na tabela da aba "Histórico".
     */    
public void carregarHistorico() {
    Usuario usuario = Usuario.UsuarioLogado.getUsuarioLogado();
    if (usuario == null) {
        System.out.println("Nenhum usuário logado.");
        return;
    }
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    List<String> musicasHistorico = usuarioDAO.obterUltimas10Buscas(usuario.getId());

    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0); 
    for (String nomeMusica : musicasHistorico) {
        model.addRow(new Object[]{nomeMusica});
    }
}

    /**
     * Carrega as músicas curtidas pelo usuário logado.
     * Os dados são exibidos na tabela da aba "Curtidas".
     */
public void carregarCurtidas() {
    Usuario usuario = Usuario.UsuarioLogado.getUsuarioLogado();
    if (usuario != null) {
        List<String> musicasCurtidas = new UsuarioDAO().buscarMusicasCurtidas(usuario.getId());
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        for (String nomeMusica : musicasCurtidas) {
            model.addRow(new Object[]{nomeMusica});
        }
    }
}

    /**
     * Carrega as músicas descurtidas pelo usuário logado.
     * Os dados são exibidos na tabela da aba "Descurtidas".
     */
public void carregarDescurtidas() {
    Usuario usuario = Usuario.UsuarioLogado.getUsuarioLogado();
    if (usuario != null) {
        List<String> musicasDescurtidas = new UsuarioDAO().buscarMusicasDescurtidas(usuario.getId());
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        model.setRowCount(0);
        for (String nomeMusica : musicasDescurtidas) {
            model.addRow(new Object[]{nomeMusica});
        }
    }
}


    /**
     * Construtor da interface gráfica HistoricoView.
     * Inicializa os componentes da tela e carrega os dados das abas.
     */
    public HistoricoView() {
        initComponents();
        carregarHistorico();
        carregarCurtidas();
        carregarDescurtidas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Titulo"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTabbedPane3.addTab("historico", jScrollPane1);

        jButton1.setText("Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jTabbedPane3.addTab("voltar", jButton1);

        jTabbedPane2.addTab("Historico", jTabbedPane3);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Nome da Música"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jTabbedPane4.addTab("curtidas", jScrollPane2);

        jButton2.setText("Menu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jTabbedPane4.addTab("voltar", jButton2);

        jTabbedPane2.addTab("Curtidas", jTabbedPane4);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Nome da Música"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jTabbedPane5.addTab("descurtidas", jScrollPane3);

        jButton3.setText("Menu");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jTabbedPane5.addTab("voltar", jButton3);

        jTabbedPane2.addTab("Descurtidas", jTabbedPane5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    Menu menu = new Menu(); 
    this.dispose(); 
    menu.setVisible(true);    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    Menu menu = new Menu(); 
    this.dispose(); 
    menu.setVisible(true);    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    Menu menu = new Menu(); 
    this.dispose(); 
    menu.setVisible(true);    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}
