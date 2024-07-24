package ru.mattakvshi.SpringBoot.PostgreSQL.RedisCach.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Emergency_type")
public class EmergencyTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "color")
    private String  color;

    @Column(name = "bg_color")
    private String bgColor;

}
