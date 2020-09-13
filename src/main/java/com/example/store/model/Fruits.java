package com.example.store.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "fruits")
public class Fruits {

    @Id
    private String id;
    private String name;
    private String description;

    @ManyToOne
    public Produce produce;

}
