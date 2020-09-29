package com.example.saffy.a2travel;

public class OfferClass {
    private int get_image;
    private String get_place_name;
    private String get_information;

    public OfferClass() {
    }

    public OfferClass(int get_image, String get_place_name, String get_information) {
        this.get_image = get_image;
        this.get_place_name = get_place_name;
        this.get_information = get_information;
    }

    public int getGet_image() {
        return get_image;
    }

    public void setGet_image(int get_image) {
        this.get_image = get_image;
    }

    public String getGet_place_name() {
        return get_place_name;
    }

    public void setGet_place_name(String get_place_name) {
        this.get_place_name = get_place_name;
    }

    public String getGet_information() {
        return get_information;
    }

    public void setGet_information(String get_information) {
        this.get_information = get_information;
    }
}
