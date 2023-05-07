package pe.edu.cibertec.DAWII_CL1_RiosMendozaErickJunior.model.bd;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Especialidad")
@NoArgsConstructor
@Data
public class Especialidad {

    @Id
    private String idesp;

    @Column(name="nomesp")
    private String nomesp;
    private double costo;

    @JsonManagedReference
    @OneToMany(mappedBy = "especialidad", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alumno> listalumno = new ArrayList<>();
}
