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
    }
}
