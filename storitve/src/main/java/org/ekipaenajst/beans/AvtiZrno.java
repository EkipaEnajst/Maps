package org.ekipaenajst.beans;

import org.ekipaenajst.entitete.Avto;

import javax.enterprise.context.RequestScoped;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;


@RequestScoped // js literally sam kradem kodo iz UporabnikiZrno
public class AvtiZrno implements Serializable { // BAJE JE DOBRO DA ZRNA IMPLEMENTIRAJO SERIALIZABLE, TAKO DA SEM DODAL

    @PersistenceContext(unitName = "accounts-jpa")
    private EntityManager em;


    private Logger log = Logger.getLogger(AvtiZrno.class.getName());

    public List<Avto> getAvti() {

        //em.getTransaction().begin();
        Query q = em.createNamedQuery("Avto.findAll", Avto.class);

        List<Avto> resultList = (List<Avto>)q.getResultList();

        return resultList;
    }
}
