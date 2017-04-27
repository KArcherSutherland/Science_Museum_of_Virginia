package org.smv.smvguide.rest.models;

/**
 * Created by root on 2/22/17.
 */
import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

@Parcel
public class Acf {

    public String estimote;
    public String paragraph1head;
    public String paragraph2head;
    public String paragraph3head;
    public String paragraph4head;
    public String paragraph5head;
    public String photo1;
    public String photo2;
    public String photo3;
    public String photo4;
    public String photo5;
    public String featuredappimage;
    public String postexerpt;
    public String textbody1;
    public String textbody2;
    public String textbody3;
    public String textbody4;
    public String textbody5;


    @ParcelConstructor
    public Acf(String estimote, String paragraph1head, String paragraph2head, String paragraph3head, String paragraph4head, String paragraph5head, String photo1, String photo2, String photo3, String photo4, String photo5, String postexerpt, String textbody1, String textbody2, String textbody3, String textbody4, String textbody5, String featuredappimage) {
        this.estimote = estimote;
        this.paragraph1head = paragraph1head;
        this.paragraph2head = paragraph2head;
        this.paragraph3head = paragraph3head;
        this.paragraph4head = paragraph4head;
        this.paragraph5head = paragraph5head;
        this.photo1 = photo1;
        this.photo2 = photo2;
        this.photo3 = photo3;
        this.photo4 = photo4;
        this.photo5 = photo5;
        this.featuredappimage = featuredappimage;
        this.postexerpt = postexerpt;
        this.textbody1 = textbody1;
        this.textbody2 = textbody2;
        this.textbody3 = textbody3;
        this.textbody4 = textbody4;
        this.textbody5 = textbody5;
    }

    public String getEstimote() {
        return estimote;
    }

    public void setEstimote(String estimote) {
        this.estimote = estimote;
    }

    public String getParagraph1head() {
        return paragraph1head;
    }

    public void setParagraph1head(String paragraph1head) {
        this.paragraph1head = paragraph1head;
    }

    public String getParagraph2head() {
        return paragraph2head;
    }

    public void setParagraph2head(String paragraph2head) {
        this.paragraph2head = paragraph2head;
    }

    public String getParagraph3head() {
        return paragraph3head;
    }

    public void setParagraph3head(String paragraph3head) {
        this.paragraph3head = paragraph3head;
    }

    public String getParagraph4head() {
        return paragraph4head;
    }

    public void setParagraph4head(String paragraph4head) {
        this.paragraph4head = paragraph4head;
    }

    public String getParagraph5head() {
        return paragraph5head;
    }

    public void setParagraph5head(String paragraph5head) {
        this.paragraph5head = paragraph5head;
    }

    public String getPhoto1() {
        return photo1;
    }

    public void setPhoto1(String photo1) {
        this.photo1 = photo1;
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

    public String getPhoto4() {
        return photo4;
    }

    public void setPhoto4(String photo4) {
        this.photo4 = photo4;
    }

    public String getPhoto5() {
        return photo5;
    }

    public void setPhoto5(String photo5) {
        this.photo5 = photo5;
    }

    public String getPostexerpt() {
        return postexerpt;
    }

    public void setPostexerpt(String postexerpt) {
        this.postexerpt = postexerpt;
    }

    public String getTextbody1() {
        return textbody1;
    }

    public void setTextbody1(String textbody1) {
        this.textbody1 = textbody1;
    }

    public String getTextbody2() {
        return textbody2;
    }

    public void setTextbody2(String textbody2) {
        this.textbody2 = textbody2;
    }

    public String getTextbody3() {
        return textbody3;
    }

    public void setTextbody3(String textbody3) {
        this.textbody3 = textbody3;
    }

    public String getTextbody4() {
        return textbody4;
    }

    public void setTextbody4(String textbody4) {
        this.textbody4 = textbody4;
    }

    public String getTextbody5() {
        return textbody5;
    }

    public void setTextbody5(String textbody5) {
        this.textbody5 = textbody5;
    }

    public String getFeaturedappimage() {
        return featuredappimage;
    }

    public void setFeaturedappimage(String featuredappimage) {
        this.featuredappimage = featuredappimage;
    }
}
