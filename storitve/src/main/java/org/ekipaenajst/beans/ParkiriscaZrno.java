package org.ekipaenajst.beans;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.*;
import org.ekipaenajst.entitete.Oddaljenost;
import org.ekipaenajst.entitete.Parkirisce;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.logging.Logger;



@ApplicationScoped
public class ParkiriscaZrno {

    @PersistenceContext(unitName = "external-jpa")
    private EntityManager em;

    private GeoApiContext geoApiContext;

    private HttpClient httpClient;

    private String externaldataURL;

    private ObjectMapper objectMapper;

    private Logger log = Logger.getLogger(UporabnikiZrno.class.getName());

    @PostConstruct
    void init() {
//        geoApiContext = new GeoApiContext.Builder().apiKey(System.getenv("GOOGLE_API_KEY")).build();
        geoApiContext = new GeoApiContext.Builder().apiKey("AIzaSyDTN3M__gwIQfcZ1K7tKGdAoPif61kGMg8").build();

        Map<String,String> env = System.getenv();

        objectMapper = new ObjectMapper();

        httpClient = HttpClient.newBuilder().build();

        externaldataURL = env.get("EXTERNALDATA_URL");//"http://172.17.0.3:8080/v1/parkirisca/";
    }

    public Parkirisce[] getParkirisca(String lokacija) {

        try {
            Parkirisce[] parkirisca = getParkirisca();
            LatLng[] locations = new LatLng[parkirisca.length];
            for (int i = 0; i < parkirisca.length; i++) {
                System.out.println(parkirisca[i]);

                locations[i] = stringToLatLng(parkirisca[i].getLokacija());
            }

            DistanceMatrixApiRequest request = DistanceMatrixApi.newRequest(geoApiContext);
            request.mode(TravelMode.DRIVING);
            request.origins(stringToLatLng(lokacija));
            request.destinations(locations);

            DistanceMatrix distanceMatrix = request.await();

            Oddaljenost[] oddaljenosti = new Oddaljenost[distanceMatrix.rows[0].elements.length];

            for (DistanceMatrixRow row : distanceMatrix.rows) {
                System.out.println(row.elements.length);
                for (int i = 0; i < row.elements.length; i++) {
                    Oddaljenost o = new Oddaljenost();

                    Duration dur = row.elements[i].durationInTraffic;

                    if (dur==null) dur = row.elements[i].duration;

                    o.setRazdaljaSekunde(dur.inSeconds);
                    o.setRazdaljaMetri(row.elements[i].distance.inMeters);
                    parkirisca[i].setOddaljenost(o);
                }
            }
            return parkirisca;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    public Oddaljenost[] getOddaljenosti(String lokacija) {

        try {
            Parkirisce[] parkirisca = getParkirisca();
            LatLng[] locations = new LatLng[parkirisca.length];
            for (int i = 0; i < parkirisca.length; i++) {
                System.out.println(parkirisca[i]);

                locations[i] = stringToLatLng(parkirisca[i].getLokacija());
            }

            DistanceMatrixApiRequest request = DistanceMatrixApi.newRequest(geoApiContext);
            request.mode(TravelMode.DRIVING);
            request.origins(stringToLatLng(lokacija));
            request.destinations(locations);

            DistanceMatrix distanceMatrix = request.await();

            Oddaljenost[] oddaljenosti = new Oddaljenost[distanceMatrix.rows[0].elements.length];

            for (DistanceMatrixRow row : distanceMatrix.rows) {
                System.out.println(row.elements.length);
                for (int i=0; i < row.elements.length; i++) {
                    DistanceMatrixElement element = row.elements[i];
                    System.out.println(element);
                    Oddaljenost o = new Oddaljenost();
                    Duration dur = row.elements[i].durationInTraffic;

                    if (dur==null) dur = row.elements[i].duration;

                    o.setRazdaljaSekunde(dur.inSeconds);
                    o.setRazdaljaMetri(row.elements[i].distance.inMeters);
                    oddaljenosti[i] = o;
                }
            }
            return oddaljenosti;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Parkirisce[] getParkirisca() {

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(externaldataURL))
                    .headers("Content-Type", "application/json")
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            Parkirisce[] parkirisca = objectMapper.readValue(response.body(), Parkirisce[].class);
            return parkirisca;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    private LatLng stringToLatLng(String lokacija) {
        String[] stringFloats = lokacija.split(",");

        Double latitude = Double.parseDouble(stringFloats[0]);
        Double longitude = Double.parseDouble(stringFloats[1]);



        return new LatLng(latitude, longitude);
    }







}
