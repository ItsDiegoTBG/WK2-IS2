package com.group;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Membresia {
    private final PlanMembresia planMembresia;
    private int miembros;
    private double costoFuncionesAdicionales;
    public Membresia (PlanMembresia planMembresia) {
        this.planMembresia = planMembresia;
    }

    public double getCostoFuncionesAdicionales() {
        return costoFuncionesAdicionales;
    }

    public void setCostoFuncionesAdicionales(double costoFuncionesAdicionales) {
        this.costoFuncionesAdicionales = costoFuncionesAdicionales;
    }

    public double calcularCostoTotal() {
        double costoTotal = this.planMembresia.getCostoBase() * this.miembros ;
         if (this.planMembresia.getTypeMember().equals(TypeMember.PREMIUM)) {
            costoTotal += costoTotal * 0.15; // 15% de recargo para planes premium
        }
        return costoTotal + this.costoFuncionesAdicionales;
    }
    public void calcularCostoFinal(int cantMiembros, String categoria, double costoActual, double costoFuncAdicional){
         double costoFinal = costoActual + costoFuncAdicional;
        if (cantMiembros>=2){
            costoFinal *= cantMiembros;
            costoFinal = costoFinal *0.9;
        }

        if (categoria.equalsIgnoreCase("Premium")){
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
         String resultado = String.format("%.2f", costoFinal);
        System.out.println("El Costo final de su membresia seria: $ "+ resultado); //redondea en dos decimales
    }

    public void setMiembros(int miembros) {
        this.miembros = miembros;
    }

    public void InfoDescuento(){
        if (this.planMembresia.getTypeMember().equals(TypeMember.FAMILY)){
            System.out.println("Plan familiar seleccionado, no hay descuentos disponibles.");
        }else{
            System.out.println("Recuerde que si se registran 2 o mas personas a la vez, obtendran un descuento del 10%");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Deseas agregarte con mas miembros?(cualquier respuesta distinta a 'si' sera tomada como un no)");
            String respuesta = scanner.next();;
            if (respuesta.equalsIgnoreCase("si")){
                System.out.println("Cuantos miembros van a registrarse en total (incluyendo a usted): ");
                int miembros= scanner.nextInt();
                this.miembros=miembros;
            }
           // scanner.close();
            System.out.println("¿Quieres agregar una funcion adicional a tu plan (si/no)?");
            String responseAddFunction = scanner.next();
            while (responseAddFunction.equalsIgnoreCase("si")) {
                System.out.println("Funciones adicionales disponibles:");
                for (FuncionAdicional funcion : planMembresia.getFuncionesAdicionales()) {
                    System.out.println("* " + funcion.getNombre() + " - $ " + funcion.getCosto());
                }

                System.out.println("Ingresa el número de la función adicional que deseas agregar:");
                String funcionAdicional = scanner.next();

                // Selecciona la función adicional según el número ingresado
                FuncionAdicional funcionAdicional1 = this.planMembresia.getFuncionesAdicionales().get(Integer.parseInt(funcionAdicional)-1);
                // Agrega el costo de la función adicional solo una vez
                this.costoFuncionesAdicionales += funcionAdicional1.getCosto();

                // Preguntar nuevamente si quiere agregar otra función adicional
                System.out.println("¿Quieres agregar otra función adicional a tu plan (si/no)?");
                responseAddFunction = scanner.next();
            }

        }
        // this.planMembresia.setCostoBase(this.planMembresia.getCostoBase());
        

    }
    public boolean confirmarMembresia(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("*******************************");
        System.out.println("Detalles del proceso a seguir:");
        System.out.println("********************************");

        System.out.println("Plan:"+this.planMembresia.getNombre());
        System.out.println("Costo base: $"+this.planMembresia.getCostoBase());
        System.out.println("Cantidad de miembros: "+this.miembros);
        System.out.println("Costo de funciones adicionales: $"+this.costoFuncionesAdicionales);
        System.out.println("Costo  Total : $"+this.calcularCostoTotal());

        System.out.print("¿Desea confirmar el plan de membresía? (si/no): ");
        String confirmacion = scanner.next();

        if (confirmacion.equalsIgnoreCase("si")) {
            return true;
        } else {
            System.out.println("Operación cancelada por el usuario.");
            return false;
        }
    }
    public int getMiembros(){
        return miembros;
    }


}
