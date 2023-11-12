package com.github.misisisisi.JungleBuddy.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="plants")
@Getter @Setter @ToString @EqualsAndHashCode (of = "id")
@NoArgsConstructor @AllArgsConstructor @Builder
public class PlantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String plantName;

}
