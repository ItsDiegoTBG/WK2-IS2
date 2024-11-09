package com.group;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Membresia {
private String nombrePlan;
    private double costoBase;
    private List<PlanMembresia> funcionesAdicionales;
    private boolean esPremium;
    private double costoFinal; 
    private int miembros;
    
    public Membresia(String nombrePlan, double costoBase, boolean esPremium) {
        this.nombrePlan = nombrePlan;
        this.costoBase = costoBase;
        this.esPremium = esPremium;
        this.funcionesAdicionales = new ArrayList<>();
    }


    public void agregarPlanMembresia(PlanMembresia funcion) {
        this.funcionesAdicionales.add(funcion);
    }

      public double calcularCostoTotal() {
        double costoTotal = this.costoBase;

         for (PlanMembresia funcion : funcionesAdicionales) {
            costoTotal += funcion.getCostoBase();
        }

         if (esPremium) {
            costoTotal += costoTotal * 0.15; // 15% de recargo para planes premium
        }

        return costoTotal;
    }


     public void CalcularCostoFinal(int CantMiembros, String Categoria, double costoActual, double CostoFuncAdicional){

        costoFinal*=CostoFuncAdicional;
        if (CantMiembros>1){
            costoFinal *= CantMiembros;
            costoFinal = costoFinal*0.9;
        }

        if (Categoria.equalsIgnoreCase("Premium")){
            System.out.println("Recargo aplicado por categoria: 15%");
            costoFinal *= 1.15;
        }
        if (costoFinal > 400) {
            System.out.println("Descuento especial aplicado: $50");
            costoFinal -= 50;
        } else if (costoFinal > 200) {
            System.out.println("Descuento especial aplicado: $20");
            costoFinal -= 20;
        }

        System.out.println("El Costo final de su membresia seria: $ "+costoFinal);
    }
    public void InfoDescuento(String Categoria){
        if (Categoria.equalsIgnoreCase("Familiar")){
            System.out.println("   ");
        }else{
            System.out.println("Recuerde que si se registran 2 o mas personas a la vez, obtendran un descuento del 10%");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Deseas agregarte con mas miembros?(cualquier respuesta distinta a 'si' sera tomada como un no)");
            String respuesta = scanner.next();;
            if (respuesta.equalsIgnoreCase("si")){
                System.out.println("Cuantos miembros van a registrarse en total (incluyendo a usted): ");
                int miembroos= scanner.nextInt();
                this.miembros=miembroos;
            }
            scanner.close();
        }
        

    }

    public String getNombrePlan() {
        return nombrePlan;
    }

    public double getCostoBase() {
        return costoBase;
    }

    public List<PlanMembresia> getFuncionesAdicionales() {
        return funcionesAdicionales;
    }

    public boolean esPremium() {
        return esPremium;
    }

    public int getMiembros(){
        return miembros;
    }


}
