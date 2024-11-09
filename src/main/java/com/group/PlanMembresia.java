package com.group;

public class PlanMembresia {
    private String nombre;
    private double costoBase;
    private String beneficios;

    // Constructor
    public PlanMembresia(String nombre, double costoBase, String beneficios) {
        this.nombre = nombre;
        this.costoBase = costoBase;
        this.beneficios = beneficios;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public double getCostoBase() {
        return costoBase;
    }

    public String getBeneficios() {
        return beneficios;
    }

    // Método para mostrar la información del plan
    public void mostrarInfo() {
        System.out.println("Plan: " + nombre);
        System.out.println("Costo: $" + costoBase);
        System.out.println("Beneficios: " + beneficios);
    }
}