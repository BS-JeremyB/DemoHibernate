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
public class Musician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;

    @ManyToMany
    @JoinTable(name = "musician_instrument",
    joinColumns = @JoinColumn(name = "musician_id"),
    inverseJoinColumns = @JoinColumn(name ="instrument_id"))
    private List<Instrument> instruments = new ArrayList<>();

    public void ajouter(Instrument instrument){
        this.instruments.add(instrument);
    }
    public void supprimer(Instrument instrument){
        this.instruments.remove(instrument);
    }
}
