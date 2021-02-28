package com.urls.encurtadorUrlApi.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Marcus
 */
@Entity
@Table(name = "TB_URL")
public class Url implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String urlEncurtada;
    private String urlReal;
    private Timestamp dataHoraCriacao = new Timestamp(new Date().getTime());
    

    //Getters & setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrlEncurtada() {
        return urlEncurtada;
    }
    
    public void setUrlEncurtada(String urlEncurtada) {
        this.urlEncurtada = urlEncurtada;
    }

    public String getUrlReal() {
        return urlReal;
    }

    public void setUrlReal(String urlReal) {
        this.urlReal = urlReal;
    }

    public Timestamp getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public void setDataHoraCriacao(Timestamp dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
    }        
    
}
