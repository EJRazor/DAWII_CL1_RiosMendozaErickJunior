package pe.edu.cibertec.DAWII_CL1_RiosMendozaErickJunior.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWII_CL1_RiosMendozaErickJunior.model.bd.Alumno;
import pe.edu.cibertec.DAWII_CL1_RiosMendozaErickJunior.repository.AlumnoRepository;

import java.util.List;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository arepo;

    public List<Alumno> listarAlu(){
        return arepo.findAll();
    }

    public void registrarAlu(Alumno alu){
        arepo.save(alu);
    }

    public void eliminarAlu(Alumno alu){
        arepo.delete(alu);
    }
}
