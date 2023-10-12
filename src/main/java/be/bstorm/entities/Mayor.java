package be.bstorm.entities;

import jakarta.persistence.*;
import lombok.*;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Mayor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;

    @OneToOne
    @JoinColumn(name = "municipality_id")
    private Municipality municipality;

}
