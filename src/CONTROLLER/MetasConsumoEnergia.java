
package CONTROLLER;

import MODEL.ConsumoEnergia;
import javax.swing.JOptionPane;

public class MetasConsumoEnergia {
    
    public double metaConsumo;
    
    //cálculo para definir qual o valor que o usuário deve gastar por mês, conforme sua meta
    public double calcularMetaMensalkWh(ConsumoEnergia dados) {
        this.metaConsumo = dados.consumoMensal - (dados.consumoMensal * (dados.metaMensalPerc / 100));
        return this.metaConsumo;
    }

    //Condição para definir se o usuário atingiu ou não a meta
    
    //Condição - Meta não atingida 
    public boolean condicaoMetaNOk(ConsumoEnergia dados) {
        boolean retorno = false;


        for (int i = 0; i < 12; i++) {
            if (dados.consumokWhMensal[i] > this.metaConsumo) {
                JOptionPane.showMessageDialog(null, "Infelizmente você não conseguiu atingir sua meta de " + dados.metaMensalPerc + "% por mês!");
                retorno = true;
                break;
            }

        }
        return retorno;
    }

    //Condição - Meta atingida 
    public void condicaoMetaOk(ConsumoEnergia dados) {
      
        for (int i = 0; i < 12; i++) {
            if (dados.consumokWhMensal[i] <= this.metaConsumo) {
                JOptionPane.showMessageDialog(null, "Parabéns, você conseguiu atingir sua meta de " + dados.metaMensalPerc + "% por mês!");
                break;
            }
        }

    }
}
