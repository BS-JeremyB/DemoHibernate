package be.bstorm.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Instrument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String marque;

    @ManyToMany(mappedBy = "instruments")
    private List<Musician> musicians = new ArrayList<>();

    public void ajouter(Musician musician){
        this.musicians.add(musician);
    }
    public void supprimer(Musician musician){
        this.musicians.remove(musician);
    }
}
