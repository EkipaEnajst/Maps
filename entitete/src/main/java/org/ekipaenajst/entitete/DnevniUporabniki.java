package org.ekipaenajst.entitete;



import java.io.Serializable;

public class DnevniUporabniki implements Serializable {

//    @JsonProperty("total_spaces")
    private int naVoljo;

//    @JsonProperty("available_spaces")
    private int prosta;

    @Override
    public String toString() {
        return String.format("Na voljo: %d, Prosta: %d", naVoljo, prosta);
    }

//    @JsonGetter("total_spaces")
    public int getNaVoljo() {
        return naVoljo;
    }

//    @JsonSetter("total_spaces")
    public void setNaVoljo(int naVoljo) {
        this.naVoljo = naVoljo;
    }

//    @JsonGetter("available_spaces")
    public int getProsta() {
        return prosta;
    }

//    @JsonSetter("available_spaces")
    public void setProsta(int prosta) {
        this.prosta = prosta;
    }
}
