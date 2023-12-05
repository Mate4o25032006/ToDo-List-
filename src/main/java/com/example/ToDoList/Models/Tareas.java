package com.example.ToDoList.Models;

public class Tareas {
    private int id;
    private String descripcion;
    private int tiempo;
    private boolean completado;

    public Tareas(int id, String descripcion, int tiempo) {
        this.id = id;
        this.descripcion = descripcion;
        this.tiempo = tiempo;
        this.completado = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    @Override
    public String toString() {
        return "Tareas{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", tiempo=" + tiempo +
                ", completado=" + completado +
                '}';
    }
}
