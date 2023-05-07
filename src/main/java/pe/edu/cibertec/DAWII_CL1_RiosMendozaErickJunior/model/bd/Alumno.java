package pe.edu.cibertec.DAWII_CL1_RiosMendozaErickJunior.model.bd;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Alumno")
@NoArgsConstructor
@Getter
@Setter
public class Alumno {

  @Id
  private String idalumno;

  @Column(name="apealumno")
  private String apealumno;

  @Column (name="nomalumno")
  private String nomalumno;

  private char proce;

  @JsonBackReference
  @ManyToOne
  @JoinColumn(name="idesp")
  private Especialidad especialidad;
}
