/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urls.encurtadorUrlApi.resources;

import com.urls.encurtadorUrlApi.models.Url;
import com.urls.encurtadorUrlApi.repository.UrlRepository;
import com.urls.encurtadorUrlApi.util.CalculaDatas;
import com.urls.encurtadorUrlApi.util.Randomizador;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Marcus
 */
@RestController
@RequestMapping(value = "/api")
@Api(value = "Encurtador de URL's API Rest")
@CrossOrigin(origins = "*")
public class UrlResource {
    
    @Autowired
    UrlRepository urlRepository1;
    
    @GetMapping("/urls")
    @ApiOperation(value = "Exibe a lista completa de URL's")
    public List<Url>listaUrls(){
        return urlRepository1.findAll();
    }
    
    @GetMapping("/nao_expiradas")
    @ApiOperation(value = "Exibe a lista de URL's que não ultrapassaram o prazo de expiração")
    public List<Url>listaUrlsNaoExpiradas(){
        return urlRepository1.naoExpiradas();
    }
    
    @GetMapping("/url_id/{id}")
    @ApiOperation(value = "Retorna o objeto URL correspondente ao id")
    public Url consultaUrlPorId(@PathVariable(value = "id") long id){
        return urlRepository1.findById(id);
    }        
    
    @GetMapping("/url_encurtada/{url_encurtada}")
    @ApiOperation(value = "Retorna o objeto URL que contenha a URL encurtada entrada como parâmetro")
    public Url consultaUrlEncurtada(@PathVariable(value = "url_encurtada") String urlEncurtada){
        return urlRepository1.findByUrlEncurtada(urlEncurtada);
    }
    
    @PostMapping("/url_real")
    @ApiOperation(value = "Retorna o objeto URL que contenha a URL real entrada como parâmetro")
    public Url consultaUrlReal(@RequestBody Url url1){        
        return urlRepository1.findByUrlReal(url1.getUrlReal());
    }
    
    @PostMapping("/encurtar")
    @ApiOperation(value = "Cria uma URL encurtada a partir da url real enviada no corpo do POST")
    public Url insereUrl(@RequestBody Url url1){
        url1.setUrlEncurtada(Randomizador.randomStr());
        return urlRepository1.save(url1);
    }
    
    @PutMapping("/encurtar")
    @ApiOperation(value = "Alterar a url encurtada que perdeu sua validade")
    public Url sobrescreveUrl(@RequestBody Url url1){
        url1.setUrlEncurtada(Randomizador.randomStr());
        Date dataHoraAgora = new Date();
        url1.setDataHoraCriacao(new Timestamp(dataHoraAgora.getTime()));
        Date novaDataHoraExpiracao = CalculaDatas.calculaDataHoraExpiracao(dataHoraAgora);
        url1.setDataHoraExpiracao(new Timestamp(novaDataHoraExpiracao.getTime()));
        return urlRepository1.save(url1);
    }
}
