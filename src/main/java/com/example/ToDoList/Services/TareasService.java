package com.example.ToDoList.Services;

import com.example.ToDoList.Models.Tareas;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TareasService {
    LinkedList<Tareas> listaTareas;

    public TareasService() {
        this.listaTareas = new LinkedList<>();
    }

    //Agregar
    public Tareas agregarTareas(Tareas tarea){
        this.listaTareas.add(tarea);
        return tarea;
    }

    //Completar
    public Optional<Tareas> completarTareas(int id, int tiempo){
        Optional<Tareas> tarea = buscarTareaPorId(id);

        if (tarea.isPresent()) {
            tarea.get().setTiempo(tiempo);
            tarea.get().setCompletado(true);
        }

        return tarea;
    }

    //Listar Pendientes
    public List<Tareas> listaTareasPendientes() {
        return listaTareas.stream()
                .filter(tarea -> !tarea.isCompletado())
                .collect(Collectors.toList());
    }

    //Listar Completos
    public List<Tareas> listaTareasCompletas() {
        return listaTareas.stream()
                .filter(Tareas::isCompletado)
                .collect(Collectors.toList());
    }

    //Listar Todo
    public List<String> listaTodo() {
        return listaTareas.stream()
                .map(Tareas::toString)
                .collect(Collectors.toList());
    }

    //Eliminar Tarea
    public Tareas eliminarTarea(int id) {
        List<Tareas> tareaEliminada = listaTareas.stream()
                .filter(tarea -> tarea.getId() == id)
                .collect(Collectors.toList());

        listaTareas.removeAll(tareaEliminada);
        return null;
    }

    //Actualizar tarea
    public Optional<Tareas> actualizarTarea(int id, String descripcionActualizada){
        Optional<Tareas> tarea = buscarTareaPorId(id);

        if (tarea.isPresent()) {
            tarea.get().setDescripcion(descripcionActualizada);
            return tarea;
        } else {
            return Optional.empty();
        }
    }

    //Busqueda Específica
    public Optional<Tareas> buscarTareaPorId(int id) {
        return listaTareas.stream()
                .filter(tarea -> tarea.getId() == id)
                .findFirst();
    }


}
