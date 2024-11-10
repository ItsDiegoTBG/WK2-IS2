package com.group;

import java.util.Scanner;

public class Membresia {
    private final PlanMembresia planMembresia;
    private int miembros;
    private double costoFuncionesAdicionales;
    private double costoTotal;

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
        if(this.planMembresia.getTypeMember().equals(TypeMember.FAMILY)){
            this.miembros = 1;
        }

        double costoTotal = this.planMembresia.getCostoBase() * this.miembros;
        costoTotal += this.costoFuncionesAdicionales;
        if (this.planMembresia.getTypeMember().equals(TypeMember.PREMIUM)) {
            costoTotal += costoTotal * 0.15; // 15% de recargo para planes premium
        }
        this.costoTotal = costoTotal;
        return costoTotal;
    }
    public void calcularCostoFinal(){
         double costoFinal = this.costoTotal;
        if (this.miembros>=2){
            System.out.println("Descuentro por ser mas de dos miembros: 10% "+ String.format("%.2f",(costoFinal - (costoFinal*0.9))));
            costoFinal = costoFinal *0.9;

        }
        if (costoFinal > 400) {
            System.out.println("Descuento especial aplicado: $50" );
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

    public void infoDescuento(){
        Scanner scanner = new Scanner(System.in);
        if (this.planMembresia.getTypeMember().equals(TypeMember.FAMILY)){
            System.out.println("Plan familiar seleccionado, no hay descuentos disponibles.");
        }else{
            System.out.println("Recuerde que si se registran 2 o mas personas a la vez, obtendran un descuento del 10%");

            System.out.println("Deseas agregarte con mas miembros?(cualquier respuesta distinta a 'si' sera tomada como un no)");
            String respuesta = scanner.next();;
            if (respuesta.equalsIgnoreCase("si")){
                System.out.println("Cuantos miembros van a registrarse en total (incluyendo a usted): ");
                this.miembros= scanner.nextInt();
            }
        }
        System.out.println("¿Quieres agregar una funcion adicional a tu plan (si/no)?");
        String responseAddFunction = scanner.next();
        while (responseAddFunction.equalsIgnoreCase("si")) {
            System.out.println("Funciones adicionales disponibles:");
            int i = 1 ;
            for (FuncionAdicional funcion : planMembresia.getFuncionesAdicionales()) {
                System.out.println(i+".- " + funcion.getNombre() + " - $ " + funcion.getCosto());
                i++;
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
