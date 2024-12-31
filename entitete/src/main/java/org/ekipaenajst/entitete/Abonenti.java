package org.ekipaenajst.entitete;



import java.io.Serializable;

public class Abonenti implements Serializable {
//    @JsonProperty("total_spaces")
    private int naVoljo;
//    @JsonProperty("reserved_spaces")
    private int rezervirana;
//    @JsonProperty("free_spaces")
    private int prosta;
//    @JsonProperty("waiting_queue")
    private int dolzinaVrste;

//    @JsonGetter("total_spaces")
    public int getNaVoljo() {
        return naVoljo;
    }

//    @JsonSetter("total_spaces")
    public void setNaVoljo(int naVoljo) {
        this.naVoljo = naVoljo;
    }

//    @JsonGetter("reserved_spaces")
    public int getRezervirana() {
        return rezervirana;
    }

//    @JsonSetter("reserved_spaces")
    public void setRezervirana(int rezervirana) {
        this.rezervirana = rezervirana;
    }

//    @JsonGetter("free_spaces")
    public int getProsta() {
        return prosta;
    }

//    @JsonSetter("free_spaces")
    public void setProsta(int prosta) {
        this.prosta = prosta;
    }

//    @JsonGetter("waiting_queue")
    public int getDolzinaVrste() {
        return dolzinaVrste;
    }

//    @JsonSetter("waiting_queue")
    public void setDolzinaVrste(int dolzinaVrste) {
        this.dolzinaVrste = dolzinaVrste;
    }
}
