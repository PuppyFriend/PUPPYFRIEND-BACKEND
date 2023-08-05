package com.example.puppyfriend.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
public class Puppy {

    @Id
    @GeneratedValue
    private int puppyIdx;

    @ManyToOne
    @JoinColumn(name = "userIdx")
    private User user;

    private LocalDate birth;

    private int goal;

    @Column(length = 45)
    private String name;

    @Enumerated(EnumType.STRING)
    private PuppyType type;

    @Enumerated(EnumType.STRING)
    private PuppyAge age;

    @Enumerated(EnumType.STRING)
    private PuppySize size;

    @Column(length = 45)
    private String personality;


}
