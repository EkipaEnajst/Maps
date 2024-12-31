package org.ekipaenajst.entitete;

import java.io.Serializable;

public class Oddaljenost implements Serializable {
    private Long razdaljaMetri;
    private Long razdaljaSekunde;

    @Override
    public String toString() {
        return String.format("Razdalja: %s Sekunde: %s\n", razdaljaMetri, razdaljaSekunde);
    }

    public Long getRazdaljaMetri() {
        return razdaljaMetri;
    }

    public void setRazdaljaMetri(Long razdaljaMetri) {
        this.razdaljaMetri = razdaljaMetri;
    }

    public Long getRazdaljaSekunde() {
        return razdaljaSekunde;
    }

    public void setRazdaljaSekunde(Long razdaljaSekunde) {
        this.razdaljaSekunde = razdaljaSekunde;
    }
}
