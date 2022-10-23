package com.example.testspringsecurity.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
