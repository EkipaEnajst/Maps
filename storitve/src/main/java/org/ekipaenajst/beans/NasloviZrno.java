package org.ekipaenajst.beans;

import org.ekipaenajst.entitete.Naslov;
import org.ekipaenajst.entitete.Uporabnik;

import javax.enterprise.context.RequestScoped;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class NasloviZrno implements Serializable { //me when i copypaste

    @PersistenceContext(unitName = "accounts-jpa")
    private EntityManager em;

    private Logger log = Logger.getLogger(NasloviZrno.class.getName());

    public List<Naslov> getNaslovi() {

        //em.getTransaction().begin();
        Query q = em.createNamedQuery("Naslov.findAll", Naslov.class);

        List<Naslov> resultList = (List<Naslov>)q.getResultList();

        return resultList;
    }
}
