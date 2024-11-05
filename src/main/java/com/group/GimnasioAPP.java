package com.group;


public class GimnasioApp {
    public static void main(String[] args) {
        SeleccionMembresia seleccionMembresia = new SeleccionMembresia();
        PlanMembresia planSeleccionado = null;

        // Bucle para seleccionar un plan válido
        while (planSeleccionado == null) {
            planSeleccionado = seleccionMembresia.seleccionarPlan();
        }

        // Muestra la selección realizada por el usuario
        System.out.println("Usted ha seleccionado el plan de membresía:");
        planSeleccionado.mostrarInfo();

        //cOSTO FUNCIONES ADICIONALES
        double costoFuncionesAdicionales =1;
        CalcularCosto costo= new CalcularCosto(planSeleccionado.getCostoBase());
        //Se le menciona al cliente que puede acceder a descuentos si acceden mas miembros
        costo.InfoDescuento(planSeleccionado.getNombre());
        //Calcula y muestra el costo final de la membresia
        costo.CalcularCostoFinal(costo.getMiembros(), planSeleccionado.getNombre(), costo.getcostoFinal(),costoFuncionesAdicionales);
    }
}