package be.bstorm.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Province {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;

    @OneToMany(mappedBy = "province")
    private List<Municipality> municipalities = new ArrayList<>();


    public void ajouter(Municipality municipality){
        this.municipalities.add(municipality);
    }
    public void supprimer(Municipality municipality){
        this.municipalities.remove(municipality);
    }

}
