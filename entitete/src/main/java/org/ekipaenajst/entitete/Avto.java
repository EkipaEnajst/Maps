package org.ekipaenajst.entitete;

import javax.persistence.*;

@Entity
@Table(name="avto")
@NamedQueries(value = {
        @NamedQuery(name = "Avto.findAll", query="SELECT a FROM Avto a"),
        @NamedQuery(name = "Avto.findId", query="SELECT a from Avto a WHERE a.id= :idParam"),
        @NamedQuery(name = "Avto.findByBrand", query="SELECT a FROM Avto a WHERE a.znamka= :brandParam ORDER BY a.znamka"),
        @NamedQuery(name = "Avto.findByModel", query="SELECT a FROM Avto a WHERE a.model= :modelParam ORDER BY a.model"),
        @NamedQuery(name = "Avto.findByOwner", query="SELECT a FROM Avto a WHERE a.lastnikID= :ownerParam"),
        @NamedQuery(name = "Avto.findByTimeframe",
                query="SELECT a FROM Avto a WHERE a.letnik>= :beforeParam AND a.letnik<= :beforeParam")
})
public class Avto {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="znamka")
    private String znamka;

    @Column(name="letnik")
    private String letnik;

    @Column(name="model")
    private String model;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lastnik")
    private Uporabnik lastnikID;
}
