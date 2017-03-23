package com.example.kmendozamendoza.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * Created by k.mendoza.mendoza on 13/03/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {
    private Integer id;

    private Date date;

    private String user;

    private Double total;

    public Order(){

    }

    public Order(Integer id, Date date, String user, Double total) {
        this.id = id;
        this.date = date;
        this.user = user;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", user='" + user + '\'' +
                ", total=" + total +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
