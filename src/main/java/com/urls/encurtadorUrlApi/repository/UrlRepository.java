package com.urls.encurtadorUrlApi.repository;

import com.urls.encurtadorUrlApi.models.Url;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Marcus
 */
public interface UrlRepository extends JpaRepository<Url, Long> {
        
    Url findById(long id);
    
    @Query("SELECT u FROM Url u WHERE u.urlEncurtada=?1")
    Url findByUrlEncurtada(String urlEncurtada);
    
    @Query("SELECT u FROM Url u WHERE u.urlReal=?1")
    Url findByUrlReal(String urlReal);
    
    @Query("SELECT u FROM Url u WHERE u.dataHoraExpiracao > NOW()")            
    List<Url> naoExpiradas();
}
