package pe.edu.cibertec.DAWII_CL1_RiosMendozaErickJunior.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWII_CL1_RiosMendozaErickJunior.model.bd.Especialidad;
import pe.edu.cibertec.DAWII_CL1_RiosMendozaErickJunior.repository.EspecialidadRepository;

import java.util.List;

@Service
public class EspecialidadService {

    @Autowired
    private EspecialidadRepository espRepo;

    public List<Especialidad> listarEsp(){
       return espRepo.findAll();
    }

    public void registrarEsp(Especialidad esp){
        espRepo.save(esp);
    }

    public void eliminarEsp(Especialidad esp){
        espRepo.delete(esp);
    }
}
