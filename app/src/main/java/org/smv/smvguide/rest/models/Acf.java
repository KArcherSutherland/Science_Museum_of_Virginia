package org.smv.smvguide.rest.models;

/**
 * Created by root on 2/22/17.
 */
import java.util.HashMap;
import java.util.Map;

public class Acf {

    private String estimote;
    private String photo;
    private String photo2;
    private String photo3;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getEstimote() {
        return estimote;
    }

    public void setEstimote(String estimote) {
        this.estimote = estimote;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhoto2() {
        return photo2;
    }

    public void setPhoto2(String photo2) {
        this.photo2 = photo2;
    }

    public String getPhoto3() {
        return photo3;
    }

    public void setPhoto3(String photo3) {
        this.photo3 = photo3;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
