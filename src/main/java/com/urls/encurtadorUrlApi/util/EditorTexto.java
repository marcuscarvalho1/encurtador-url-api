/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urls.encurtadorUrlApi.util;

/**
 *
 * @author Marcus
 */
public class EditorTexto {
    
    public static String editaOutputTeste(int numeroTeste, String nomeTeste, String texto, String valorRetorno){ //Exibe o output de testes formatado
        return "\n\n-----------------------------------------------------------------------------------------------------------------------------------"
                + "-------------------------------------------\n" 
                + "Teste #" + numeroTeste + ": " + nomeTeste + " --> " +  texto + " " + valorRetorno +
               "\n-------------------------------------------------------------------------------------------------------------------------------------"
                + "-----------------------------------------\n\n";
    }
    
}
