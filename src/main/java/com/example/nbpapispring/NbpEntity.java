package com.example.nbpapispring;

import jakarta.persistence.*;

@Entity
@Table(name = "nbp_data")
public class NbpEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data")
    private String data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "NbpEntity{" +
                "id=" + id +
                ", data='" + data + '\'' +
                '}';
    }
}
