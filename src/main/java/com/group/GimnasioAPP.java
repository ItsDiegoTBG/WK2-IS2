package com.group;
public class GimnasioAPP {
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
        System.out.println("Tenemos ademas las siguientes funciones");
        planSeleccionado.mostrarFuncionalidadesAdicionales();

        // COSTO FUNCIONES ADICIONALES
        double costoFuncionesAdicionales = 0;
        Membresia membresia = new Membresia(planSeleccionado);
        membresia.InfoDescuento();
        if(membresia.confirmarMembresia()){
            membresia.calcularCostoFinal(membresia.getMiembros(), planSeleccionado.getNombre(),planSeleccionado.getCostoBase(),costoFuncionesAdicionales);
        }else {
            System.out.println("La membresía ha sido cancelada.Adios");
        }

    }
}