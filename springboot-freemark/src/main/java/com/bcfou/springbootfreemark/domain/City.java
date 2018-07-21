package com.bcfou.springbootfreemark.domain;

public class City {
    private Long id;
    private int province_id;
    private String city_name;
    private String description;

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", province_id=" + province_id +
                ", city_name='" + city_name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public City(Long id, int province_id, String city_name, String description) {
        this.id = id;
        this.province_id = province_id;
        this.city_name = city_name;
        this.description = description;
    }

    public City() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getProvince_id() {
        return province_id;
    }

    public void setProvince_id(int province_id) {
        this.province_id = province_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
