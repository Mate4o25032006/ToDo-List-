package com.example.ToDoList;

import com.example.ToDoList.Models.Tareas;
import com.example.ToDoList.Services.TareasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToDoListApplication implements CommandLineRunner {

	private final TareasService tareasService;

	@Autowired
	public ToDoListApplication(TareasService tareasService) {
		this.tareasService = tareasService;
	}

	public static void main(String[] args) {
		SpringApplication.run(ToDoListApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Precargar tareas al iniciar la aplicación
		Tareas tarea1 = new Tareas(1, "Lavar cocina", 23);
		Tareas tarea2 = new Tareas(2, "Hacer envío", 30);

		tareasService.agregarTareas(tarea1);
		tareasService.agregarTareas(tarea2);
	}

}
