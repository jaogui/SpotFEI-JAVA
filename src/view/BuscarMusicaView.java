/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import spotfei.dao.MusicaDAO;
import spotfei.model.Musica;
import spotfei.dao.UsuarioDAO;
import javax.swing.JOptionPane;
import spotfei.model.Usuario;


/**
 *
 * @author joaog
 */
/**
 * Tela para buscar músicas, curtir, descurtir e adicionar músicas à playlist.
 * Exibe uma tabela com músicas filtradas por nome ou gênero.
 * Permite interação com o usuário logado para registrar buscas e gerenciar curtidas.
 * 
 * @author joaog
 */
public class BuscarMusicaView extends javax.swing.JFrame {

    /**
     * Carrega todas as músicas do banco de dados e exibe na tabela.
     */
    private void carregarTodasMusicas() {
        MusicaDAO musicaDAO = new MusicaDAO();
        List<Musica> todasMusicas = musicaDAO.buscarMusicas(""); 

        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0); 

        for (Musica m : todasMusicas) {
            modelo.addRow(new Object[]{
                m.getNome(),
                m.getArtista(),
                m.getGenero()
            });
        }
    }

    
    /**
     * Construtor da classe BuscarMusicaView.
     * Inicializa os componentes da interface e carrega as músicas.
     */
    public BuscarMusicaView() {
        initComponents();
        carregarTodasMusicas();
    }

    /**
     * Inicializa os componentes da interface gráfica.
     * Método gerado automaticamente pelo NetBeans, não modifique manualmente.
     */


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Musica / Genero");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome", "Artista", "Genero"
            }
        ));
        jTable1.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jButton2.setText("❤️ Curtir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("💔 Descurtir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("➕ Adicionar à Playlist");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Menu");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3)
                                    .addComponent(jButton2)
                                    .addComponent(jButton4)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton5)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed
    /**
     * Evento disparado ao clicar no botão "Buscar".
     * Realiza busca de músicas pelo termo informado e atualiza a tabela.
     * Registra a busca do usuário logado no banco de dados.
     * 
     * @param evt evento da ação do botão
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    String termoBusca = jTextField1.getText().toLowerCase();
    Usuario usuario = Usuario.UsuarioLogado.getUsuarioLogado();
    if (usuario != null && !termoBusca.isEmpty()) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.registrarBusca(usuario.getId(), termoBusca);
    }
    MusicaDAO musicaDAO = new MusicaDAO();
    List<Musica> musicasEncontradas = musicaDAO.buscarMusicas(termoBusca);
    DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
    modelo.setRowCount(0);
    for (Musica m : musicasEncontradas) {
        modelo.addRow(new Object[]{
            m.getNome(),
            m.getArtista(),
            m.getGenero(),
        });
    }

    }//GEN-LAST:event_jButton1ActionPerformed
 /**
     * Evento disparado ao clicar no botão "️Curtir".
     * Registra a curtida da música selecionada para o usuário logado.
     * Exibe mensagem de sucesso ou erro.
     * 
     * @param evt evento da ação do botão
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    Musica m = getMusicaSelecionada();
    if (m != null) {
        Usuario usuarioLogado = Usuario.UsuarioLogado.getUsuarioLogado();
        if (usuarioLogado != null) {
            System.out.println("Tentando curtir a música: " + m.getId() + " para o usuário: " + usuarioLogado.getId());
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.curtirMusica(usuarioLogado.getId(), m.getId());
            JOptionPane.showMessageDialog(this, "Música Curtida!");
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao curtir a musica");
        }
    }
    }//GEN-LAST:event_jButton2ActionPerformed
/**
     * Evento disparado ao clicar no botão "Descurtir".
     * Remove a curtida da música selecionada para o usuário logado.
     * Exibe mensagem de sucesso ou erro.
     * 
     * @param evt evento da ação do botão
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    Musica m = getMusicaSelecionada(); 
    if (m != null) {
        Usuario usuarioLogado = Usuario.UsuarioLogado.getUsuarioLogado(); 
        if (usuarioLogado != null) {
            System.out.println("Tentando descurtir a música: " + m.getId() + " para o usuário: " + usuarioLogado.getId());
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.descurtirMusica(usuarioLogado.getId(), m.getId()); 
            JOptionPane.showMessageDialog(this, "Música Descurtida!");
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao descurtir a música");
        }
    }    }//GEN-LAST:event_jButton3ActionPerformed
    /**
     * Evento disparado ao clicar no botão "Adicionar à Playlist".
     * Abre a tela para seleção da playlist para a música selecionada.
     * Fecha a tela atual.
     * 
     * @param evt evento da ação do botão
     */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    Musica m = getMusicaSelecionada();
    if (m != null) {
        new SelecionarPlaylistView(m).setVisible(true);
        this.dispose();  
    }

    }//GEN-LAST:event_jButton4ActionPerformed
    /**
     * Evento disparado ao clicar no botão "Menu".
     * Abre a tela do menu principal e fecha a tela atual.
     * 
     * @param evt evento da ação do botão
     */
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    Menu menu = new Menu(); 
    menu.setVisible(true);

    this.dispose();        
    }//GEN-LAST:event_jButton5ActionPerformed
    /**
     * Obtém a música selecionada na tabela.
     * Caso nenhuma música esteja selecionada, exibe mensagem para o usuário.
     * 
     * @return Objeto Musica selecionado ou null se nenhuma seleção
     */
    private Musica getMusicaSelecionada() {
        int linhaSelecionada = jTable1.getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma música na tabela.");
            return null;
        }

        String nome = (String) jTable1.getValueAt(linhaSelecionada, 0);
        int artista_id = (int) jTable1.getValueAt(linhaSelecionada, 1);
        String genero = (String) jTable1.getValueAt(linhaSelecionada, 2);

        MusicaDAO dao = new MusicaDAO();
        List<Musica> lista = dao.buscarMusicas(nome);
        for (Musica m : lista) {
            if (m.getNome().equals(nome) && m.getArtista() == artista_id) {
                return m;
            }
        }

        return null;
    }



    
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(BuscarMusicaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(BuscarMusicaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(BuscarMusicaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(BuscarMusicaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new BuscarMusicaView().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
