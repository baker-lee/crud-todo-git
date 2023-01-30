package com.example.crudtodogit.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    @Id
    private Long id;

    private String title;

    private Long order;

    private Boolean completed;
}
