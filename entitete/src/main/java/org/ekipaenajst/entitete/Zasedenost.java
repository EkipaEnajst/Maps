package org.ekipaenajst.entitete;




import java.io.Serializable;


public class Zasedenost implements Serializable{

//    @JsonProperty("title")
    private String title;

//    @JsonProperty("link")
    private String link;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

//    @JsonProperty("daily_users")
    private DnevniUporabniki dnevniUporabniki;
//    @JsonProperty("subscribers")
    private Abonenti abonenti;

    @Override
    public String toString() {
        return String.format("%s: %s\n",this.title,this.dnevniUporabniki);
    }

//    @JsonGetter("daily_users")
    public DnevniUporabniki getDnevniUporabniki() {
        return dnevniUporabniki;
    }

//    @JsonSetter("daily_users")
    public void setDnevniUporabniki(DnevniUporabniki dnevniUporabniki) {
        this.dnevniUporabniki = dnevniUporabniki;
    }

//    @JsonGetter("subscribers")
    public Abonenti getAbonenti() {
        return abonenti;
    }

//    @JsonSetter("subscribers")
    public void setAbonenti(Abonenti abonenti) {
        this.abonenti = abonenti;
    }
}


