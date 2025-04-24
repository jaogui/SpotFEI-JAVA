/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

package view;

import controller.UsuarioController;
import spotfei.model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView extends JFrame {
    private JTextField nomeField;
    private JTextField emailField;
    private JPasswordField senhaField;
    private JButton cadastrarButton;
    private JButton loginButton;
    private JLabel statusLabel;

    private UsuarioController usuarioController;

    public MainView() {
        super("Spotifei - Login/Cadastro");
        usuarioController = new UsuarioController();
        configurarJanela();
    }
    private void configurarJanela() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridLayout(6, 2));

        nomeField = new JTextField();
        emailField = new JTextField();
        senhaField = new JPasswordField();
        cadastrarButton = new JButton("Cadastrar");
        loginButton = new JButton("Login");
        statusLabel = new JLabel(" ", SwingConstants.CENTER);

        add(new JLabel("Nome:"));
        add(nomeField);
        add(new JLabel("Email:"));
        add(emailField);
        add(new JLabel("Senha:"));
        add(senhaField);
        add(cadastrarButton);
        add(loginButton);
        add(new JLabel()); 
        add(statusLabel);

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String email = emailField.getText();
                String senha = new String(senhaField.getPassword());

                boolean sucesso = usuarioController.cadastrarUsuario(nome, email, senha);
                statusLabel.setText(sucesso ? "Cadastro realizado!" : "Erro ao cadastrar");
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String senha = new String(senhaField.getPassword());

                Usuario usuario = usuarioController.login(email, senha);
                statusLabel.setText(usuario != null ? "Login bem-sucedido!" : "Email ou senha incorretos");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new MainView();
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
