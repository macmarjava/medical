package com.example.demo.bd;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "institution")
public class Belong implements Serializable {

    private static final long serialVersionUID = -3009157732242241606L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    public Belong() {

    }

}