package pe.edu.cibertec.DAWII_CL1_RiosMendozaErickJunior.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.DAWII_CL1_RiosMendozaErickJunior.model.bd.Alumno;
import pe.edu.cibertec.DAWII_CL1_RiosMendozaErickJunior.model.bd.Especialidad;
import pe.edu.cibertec.DAWII_CL1_RiosMendozaErickJunior.model.request.AlumnoRequest;
import pe.edu.cibertec.DAWII_CL1_RiosMendozaErickJunior.model.response.ResultadoResponse;
import pe.edu.cibertec.DAWII_CL1_RiosMendozaErickJunior.service.AlumnoService;

import java.util.List;

@Controller
@RequestMapping("/Alumno")
public class AlumnoController {

    @Autowired
    private AlumnoService aluService;

    @GetMapping("/frmMantAlumno")
    public String frmMantAlumno(Model model){
        model.addAttribute("listarAlu", aluService.listarAlu());
        return "Alumno/frmMantAlumno";
    }

    @PostMapping("/resgitrarAlu")
    @ResponseBody
    public ResultadoResponse registrarAlu(@RequestBody AlumnoRequest alurequest){

        String mensaje = "Alumno registrado correctamente";
        Boolean respuesta = true;
        try {
            Alumno objAlu = new Alumno();
            if(alurequest.getIdalumno()!=null){
                objAlu.setIdalumno(alurequest.getIdalumno());
            }
            objAlu.setApealumno(alurequest.getApealumno());
            objAlu.setNomalumno(alurequest.getNomalumno());
            objAlu.setProce(alurequest.getProce());
            Especialidad objEsp = new Especialidad();
            objEsp.setIdesp(alurequest.getIdesp());
            objAlu.setEspecialidad(objEsp);
            aluService.registrarAlu(objAlu);
        }catch (Exception ex){
            mensaje="Alumno no registrado";
            respuesta = false;
        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }

    @DeleteMapping("/eliminarAlu")
    @ResponseBody
    public ResultadoResponse eliminarAlu(@RequestBody AlumnoRequest alurequest){
        String mensaje = "Alumno eliminado exitosamente";
        Boolean respuesta = true;
        try {
            Alumno objAlu = new Alumno();
            if(alurequest.getIdalumno()!=null){
                objAlu.setIdalumno(alurequest.getIdalumno());
            }
            objAlu.setApealumno(alurequest.getApealumno());
            objAlu.setNomalumno(alurequest.getNomalumno());
            objAlu.setProce(alurequest.getProce());
            Especialidad objEsp = new Especialidad();
            objEsp.setIdesp(alurequest.getIdesp());
            objAlu.setEspecialidad(objEsp);
            aluService.eliminarAlu(objAlu);
        }catch (Exception ex){
            mensaje="Error al elimianr Alumno";
            respuesta = false;
        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }

    @GetMapping("/listarAlu")
    @ResponseBody
    public List<Alumno> listarAlu(){
        return aluService.listarAlu();
    }
}
