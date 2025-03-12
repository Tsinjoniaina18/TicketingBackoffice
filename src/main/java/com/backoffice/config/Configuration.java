package com.backoffice.config;

import jakarta.persistence.*;

@Entity
@Table(name = "config_enfant")
public class Configuration {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_config_enfant")
    @SequenceGenerator(name = "seq_config_enfant", sequenceName = "seq_config_enfant", allocationSize = 1)
    private String id;

    @Column(name = "age")
    private int age;

    @Column(name = "pourcentage_prix")
    private double pourcentage_prix;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Double getPourcentage_prix() {
        return pourcentage_prix;
    }

    public void setPourcentage_prix(double pourcentage_prix) {
        this.pourcentage_prix = pourcentage_prix;
    }
}
