package com.example.ToDoList.Controllers;

import com.example.ToDoList.Models.Tareas;
import com.example.ToDoList.Services.TareasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TareasController {
    private TareasService tareasService;

    @Autowired
    public TareasController(TareasService tareasService){
        this.tareasService = tareasService;
    }

    //Peticiones GET
    @GetMapping("/tareas/lista-completa")
    public List<String> obtenerTareas() {
        return tareasService.listaTodo();
    }

    @GetMapping("/tareas/lista-completas")
    public List<Tareas> listarTareasCompletas(){
        return tareasService.listaTareasCompletas();
    }

    @GetMapping("/tareas/lista-pendientes")
    public List<Tareas> listarTareasPendientes(){
        return tareasService.listaTareasPendientes();
    }

    //Gestión de tareas
    @GetMapping("/tareas/{id}")
    public Optional<Tareas> buscarTareaPorId(@PathVariable("id") int id) {
        return tareasService.buscarTareaPorId(id);
    }

    @GetMapping("/tareas/lista-pendientes/{id}-{tiempo}")
    public Optional<Tareas> completarTareas(@PathVariable("id") int id, @PathVariable("tiempo") int tiempo){
        return tareasService.completarTareas(id, tiempo);
    }

    @PutMapping("/tareas/lista-completa/{id}/{descripcionActualizada}")
    public Optional<Tareas> actualizarTarea(@PathVariable("id") int id, @PathVariable("descripcionActualizada") String descripcionActualizada){
        return tareasService.actualizarTarea(id, descripcionActualizada);
    }

    //Eliminar Tarea
    @DeleteMapping("/tareas/lista-completa/{id}")
    public Tareas eliminarTarea(@PathVariable("id") int id){
        return tareasService.eliminarTarea(id);
    }

    //Enviar Tarea
    @PostMapping()
    public Tareas agregarTareas(@RequestBody() Tareas tarea){
        Tareas tareaAgregada = tareasService.agregarTareas(tarea);
        return tareaAgregada;
    }


}
