package pe.edu.cibertec.DAWII_CL1_RiosMendozaErickJunior.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.cibertec.DAWII_CL1_RiosMendozaErickJunior.model.bd.Especialidad;
import pe.edu.cibertec.DAWII_CL1_RiosMendozaErickJunior.service.EspecialidadService;

import java.util.List;

@Controller
@RequestMapping("/Especialidad")
public class EspecialidadController {

    @Autowired
    private EspecialidadService espeService;

    @GetMapping("/listarEsp")
    @ResponseBody
    public List<Especialidad> listarEsp(){
        return espeService.listarEsp();
    }
}
