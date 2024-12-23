package org.ekipaenajst.entitete;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="naslov")
@NamedQueries(value = {
        @NamedQuery(name = "Naslov.findAll", query="SELECT n FROM Naslov n"),
        @NamedQuery(name = "Naslov.findId", query="SELECT n from Naslov n WHERE n.id= :idParam"),
        @NamedQuery(name = "Naslov.findByCity", query="SELECT n FROM Naslov n WHERE n.mesto= :cityParam ORDER BY n.mesto"),
        @NamedQuery(name = "Naslov.findByStreet", query="SELECT n FROM Naslov n WHERE n.ulica= :streetParam ORDER BY n.ulica"),
        @NamedQuery(name = "Naslov.findByZipcode", query="SELECT n FROM Naslov n WHERE n.postnaSt= :zipcodeParam"),
        @NamedQuery(name = "Naslov.findByFullAddress",
                query="SELECT n FROM Naslov n WHERE n.mesto= :cityParam AND n.ulica= :streetParam AND n.hisnaSt= :houseParam AND n.postnaSt= :zipcodeParam")
})
public class Naslov {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="mesto")
    private String mesto;

    @Column(name="ulica")
    private String ulica;

    @Column(name="hisnaSt")
    private String hisnaSt;

    @Column(name="postnaSt")
    private String postnaSt;
}
