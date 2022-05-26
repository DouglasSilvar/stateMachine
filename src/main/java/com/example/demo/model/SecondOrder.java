package com.example.demo.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tb_second_order")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SecondOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "state")
    private String orderStates;

}
