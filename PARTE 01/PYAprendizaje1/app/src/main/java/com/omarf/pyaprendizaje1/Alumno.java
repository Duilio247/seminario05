package com.omarf.pyaprendizaje1;

import java.io.Serializable;

public class Alumno implements Serializable {
    private String nombre;
    private String edad;
    private String id;
    private String horaEntrada;
    private String horaSalida;

    // Constructor
    public Alumno(String nombre, String edad, String id, String horaEntrada, String horaSalida) {
        this.nombre = nombre;
        this.edad = edad;
        this.id = id;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getEdad() { return edad; }
    public String getId() { return id; }
    public String getHoraEntrada() { return horaEntrada; }
    public String getHoraSalida() { return horaSalida; }

    // Setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEdad(String edad) { this.edad = edad; }
    public void setId(String id) { this.id = id; }
    public void setHoraEntrada(String horaEntrada) { this.horaEntrada = horaEntrada; }
    public void setHoraSalida(String horaSalida) { this.horaSalida = horaSalida; }

    // Función que indica si el alumno está activo (sin hora de salida)
    public boolean estaActivo() {
        return horaSalida == null;
    }

    // Función que devuelve el estado del alumno (Activo o Finalizado)
    public String getEstado() {
        return estaActivo() ? "ACTIVO" : "FINALIZADO";
    }

    // Función que devuelve un texto de la clase similar a la de Visita
    @Override
    public String toString() {
        String salida = (horaSalida != null) ? "HORA DE SALIDA: " + horaSalida : "HORA DE SALIDA: N/A";
        return "NOMBRE: " + nombre.toUpperCase() + "\n" +
                "EDAD: " + edad.toUpperCase() + "\n" +
                "ID: " + id.toUpperCase() + "\n" +
                "HORA DE ENTRADA: " + horaEntrada.toUpperCase() + "\n" +
                salida;
    }
}
