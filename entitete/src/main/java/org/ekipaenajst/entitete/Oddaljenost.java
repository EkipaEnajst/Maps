package org.ekipaenajst.entitete;

import java.io.Serializable;

public class Oddaljenost implements Serializable {
    private int razdaljavKM;
    private int razdaljaSekunde;

    public int getRazdaljavKM() {
        return razdaljavKM;
    }

    public void setRazdaljavKM(int razdaljavKM) {
        this.razdaljavKM = razdaljavKM;
    }

    public int getRazdaljaSekunde() {
        return razdaljaSekunde;
    }

    public void setRazdaljaSekunde(int razdaljaSekunde) {
        this.razdaljaSekunde = razdaljaSekunde;
    }
}
