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
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
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

    public Oddaljenost[] getOddaljenosti(String lokacija) {

        try {
            Parkirisce[] parkirisca = getParkirisca();
            LatLng[] locations = new LatLng[parkirisca.length];
            for (int i = 0; i < parkirisca.length; i++) {
                locations[i] = stringToLatLng(parkirisca[i].getLokacija());
            }

            DistanceMatrixApiRequest request = DistanceMatrixApi.newRequest(geoApiContext);
            request.mode(TravelMode.DRIVING);
            request.origins(stringToLatLng(lokacija));
            request.destinations(locations);

            DistanceMatrix distanceMatrix = request.await();

            for (DistanceMatrixRow row : distanceMatrix.rows) {
                for (DistanceMatrixElement element : row.elements) {
                    System.out.println(element);
                }
            }
            return null;
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
