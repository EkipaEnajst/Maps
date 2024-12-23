package org.ekipaenajst.beans;

import org.ekipaenajst.entitete.Uporabnik;

import javax.enterprise.context.RequestScoped;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;


@ApplicationScoped // probably... mogoče treba spremeniti
public class UporabnikiZrno {

    @PersistenceContext(unitName = "accounts-jpa")
    private EntityManager em;

    private Logger log = Logger.getLogger(UporabnikiZrno.class.getName());



// INICIALIZACIJA IN DEINICIALIZACIJA MORDA NEPOTREBNA, KER ENTITYMANAGER UPRAVLJA ŽE JTA CONTAINER
//    @PostConstruct
//    private void init() {
//        log.info("Inicializacija zrna " + UporabnikiZrno.class.getSimpleName());
//
//        emf = Persistence.createEntityManagerFactory(
//                "accounts-jpa"
//        );
//
//        em = emf.createEntityManager();
//
//
//    }
//
//    @PreDestroy
//    private void destroy() {
//        log.info("Deinicializacija zrna " + UporabnikiZrno.class.getSimpleName());
//
//        em.close();
//        emf.close();
//    }



    @Transactional // DEBUG
    public List<Uporabnik> getUporabniki() {



        Query q = em.createNamedQuery("Uporabnik.findAll", Uporabnik.class);

        List<Uporabnik> resultList = (List<Uporabnik>)q.getResultList();

        return resultList;
    }

    @Transactional //DEBUG
    public Uporabnik getUporabnik(int id) {
        return em.find(Uporabnik.class, id);
    }

    @Transactional //DEBUG
    public Uporabnik getUporabnikByName(String firstName, String lastName) {
        Query q = em.createNamedQuery("Uporabnik.findByName", Uporabnik.class);
        q.setParameter("firstNameParam", firstName);
        q.setParameter("lastNameParam", lastName);

        List<Uporabnik> resultList = (List<Uporabnik>)q.getResultList();

        return resultList.isEmpty() ? null : resultList.get(0);
    }
    @Transactional //DEBUG
    public void updateUporabnik(Uporabnik uporabnik) {

        //EntityTransaction et = em.getTransaction();

        //et.begin();
        em.merge(uporabnik);
        //et.commit();

    }
    @Transactional //DEBUG
    public void deleteUporabnik(Uporabnik uporabnik) {


        Uporabnik u = em.find(Uporabnik.class, uporabnik.getId());
        em.remove(u);
    }

    @Transactional //DEBUG
    public void createUporabnik(Uporabnik uporabnik) {
        //EntityTransaction et = em.getTransaction();

       // et.begin();
        try {
            //Uporabnik u = em.merge(uporabnik);
            em.persist(uporabnik);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("Creating not work");
        }
        //et.commit();
    }


}
