package com.urls.encurtadorUrlApi.util;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Marcus
 */
public class CalculaDatas {
    
    private static final int SEGUNDOS_PARA_EXPIRAR_URL = 60; //Define a quantidade de segundos de duração de uma URL
    
    public static Date calculaDataHoraExpiracao(Date dataHoraCriacao){
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(dataHoraCriacao);
        calendar1.add(Calendar.SECOND, SEGUNDOS_PARA_EXPIRAR_URL);        
        
        return calendar1.getTime();
    }
    
}
