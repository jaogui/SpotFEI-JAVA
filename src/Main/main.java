/**
 * Classe principal do programa que inicia a aplicação.
 * Aqui é onde a interface de login e registro é aberta.
 */
package Main;

import view.Login_Registro;

public class main {

    public static void main(String[] args) {
        Login_Registro lf = new Login_Registro();
        lf.setVisible(true); // Exibe a tela de login 
    }
    
}
