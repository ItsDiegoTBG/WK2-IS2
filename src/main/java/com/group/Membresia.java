package com.group;

import java.util.ArrayList;
import java.util.List;

public class Membresia {
private String nombrePlan;
    private double costoBase;
    private List<FuncionAdicional> funcionesAdicionales;
    private boolean esPremium;
    
    public Membresia(String nombrePlan, double costoBase, boolean esPremium) {
        this.nombrePlan = nombrePlan;
        this.costoBase = costoBase;
        this.esPremium = esPremium;
        this.funcionesAdicionales = new ArrayList<>();
    }


    public void agregarFuncionAdicional(FuncionAdicional funcion) {
        this.funcionesAdicionales.add(funcion);
    }

      public double calcularCostoTotal() {
        double costoTotal = this.costoBase;

         for (FuncionAdicional funcion : funcionesAdicionales) {
            costoTotal += funcion.getCosto();
        }

         if (esPremium) {
            costoTotal += costoTotal * 0.15; // 15% de recargo para planes premium
        }

        return costoTotal;
    }


    public double aplicarDescuentoGrupo(int cantidadMiembros) {
        double costoTotal = calcularCostoTotal();
        
        if (cantidadMiembros > 1) {
            costoTotal *= 0.90; // Descuento del 10%
            System.out.println("¡Estás ahorrando un 10% por inscribirte con otros miembros!");
        }

        if (costoTotal > 400) {
            costoTotal -= 50; 
            System.out.println("¡Descuento de $50 por exceder los $400 en total!");
        } else if (costoTotal > 200) {
            costoTotal -= 20; 
            System.out.println("¡Descuento de $20 por exceder los $200 en total!");
        }

        return costoTotal;
    }


    public String getNombrePlan() {
        return nombrePlan;
    }

    public double getCostoBase() {
        return costoBase;
    }

    public List<FuncionAdicional> getFuncionesAdicionales() {
        return funcionesAdicionales;
    }

    public boolean esPremium() {
        return esPremium;
    }
}
