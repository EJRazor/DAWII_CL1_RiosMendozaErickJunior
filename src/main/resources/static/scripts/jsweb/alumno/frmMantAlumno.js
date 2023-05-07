$(document).on("click", "#btnagregar", function(){
    $("#txtidalumno").val("");
    $("#txtnomalumno").val("");
    $("#txtapealumno").val("");
    $("#hddidalumno").val("0");
    $("#cboespecialidad").empty();
    $("#txtproce").val("");
    $.ajax({
        type: "GET",
        url: "/Especialidad/listarEsp",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cboespecialidad").append(
                    `<option value="${value.idesp}">${value.nomesp}</option>`
                )
            })
        }
    })
    $("#modalNuevo").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#txtidalumno").val($(this).attr("data-idalumno"));
    $("#txtnomalumno").($(this).attr("data-nomalumno"));
    $("#txtapealumno").($(this).attr("data-apealumno"));
    $("#hddidalumno").val($(this).attr("data-idalumno"));
    $("#cboespecialidad").empty();
    $("#txtproce").val($(this).attr("data-proce"));
    var idesp = $(this).attr("data-idesp");
    $.ajax({
        type: "GET",
        url: "/Especialidad/listarEsp",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cboespecialidad").append(
                    `<option value="${value.idesp}">${value.nomesp}</option>`
                )
            })
            $("#cboespecialidad").val(idesp);
        }
    })
    $("#modalNuevo").modal("show");
});


$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/Alumno/registrarAlu",
        contentType: "application/json",
        data: JSON.stringify({
            idalumno: $("#hddidalumno").val(),
            apealumno: $("#txtapealumno").val(),
            nomalumno: $("#txtnomalumno").val(),
            idesp: $("#cboespecialidad").val(),
            proce: $("#txtproce").val()
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarAlu();
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalNuevo").modal("hide");
});

$(document).on("click", ".btneliminar", function(){
    var idsala = $(this).attr("data-idalumno");
    $.ajax({
        type: "DELETE",
        url: "/Alumno/eliminarAlu",
        contentType: "application/json",
        data: JSON.stringify({
            idalumno: idalumno,
            apealumno: apealumno,
            nomalumno: nomalumno,
            idesp: idesp,
            proce: proce
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarAlu();
            }
            alert(resultado.mensaje);
        }
    });
});

function listarAlu(){
    $.ajax({
        type: "GET",
        url: "/Alumno/eliminarAlu",
        dataType: "json",
        success: function(resultado){
            $("#tblalumno > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblalumno > tbody").append("<tr>"+
                    "<td>"+value.idalumno+"</td>"+
                    "<td>"+value.nomalumno+"</td>"+
                    "<td>"+value.apealumno+"</td>"+
                    "<td>"+value.proce+"</td>"+
                    "<td>"+
                        "<button type='button' class='btn btn-info btnactualizar'"+
                                     "data-idalumno='"+value.idalumno+"'"+
                                     "data-nomalumno='"+value.nomalumno+"'"+
                                     "data-apealumno='"+value.apealumno+"'"+
                                     "data-idesp='"+value.idesp+"'"+
                                     "data-proce='"+value.proce+"'>Actualizar</button>"+
                    "</td>"+
                    "<td>"+
                        "<button type='button' class='btn btn-danger btneliminar'"+
                                     "data-idalumno='"+value.idalumno+"'"+
                                     "data-nomalumno='"+value.nomalumno+"'"+
                                     "data-apealumno='"+value.apealumno+"'"+
                                     "data-idesp='"+value.idesp+"'"+
                                     "data-proce='"+value.proce+"'>Eliminar</button>"+
                    "</td></tr>");
            })
        }
    })
}