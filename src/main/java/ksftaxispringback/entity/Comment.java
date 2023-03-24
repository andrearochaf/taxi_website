package ksftaxispringback.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int generalRating;
    private int cleanRating;
    private String description;
    private LocalDate commentCreationDate;
    private LocalDate commentValidationDate;
    private LocalDate commentRefusalDate;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Client client;
}
