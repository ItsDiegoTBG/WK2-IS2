package com.group;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SeleccionMembresia {
    private List<PlanMembresia> planes;

    // Constructor
    public SeleccionMembresia() {
        planes = new ArrayList<>();
        inicializarPlanes();
    }

    // Método para inicializar los planes de membresía
    private void inicializarPlanes() {
        FuncionAdicional entrenamientoPersonal = new FuncionAdicional("Entrenamiento Personal", 30.0);
        FuncionAdicional clasesGrupales = new FuncionAdicional("Clases Grupales", 20.0);
        FuncionAdicional masajeRecuperacion = new FuncionAdicional("Masaje de Recuperación", 40.0);
        List<FuncionAdicional> funcionAdicionals = new ArrayList<>();
        funcionAdicionals.add(entrenamientoPersonal);
        funcionAdicionals.add(clasesGrupales);
        funcionAdicionals.add(masajeRecuperacion);

        planes.add(new PlanMembresia("Básico", 50.0, "Acceso al gimnasio y uso de máquinas",funcionAdicionals,TypeMember.BASIC));
        planes.add(new PlanMembresia("Premium", 100.0, "Acceso a instalaciones exclusivas, clases grupales y piscina",funcionAdicionals,TypeMember.PREMIUM));
        planes.add(new PlanMembresia("Familiar", 150.0, "Acceso para 4 personas, incluye clases grupales y áreas recreativas",funcionAdicionals,TypeMember.FAMILY));
    }

    // Método para mostrar los planes de membresía disponibles
    public void mostrarPlanes() {
        System.out.println("Planes de Membresía Disponibles:");
        for (int i = 0; i < planes.size(); i++) {
            System.out.println((i + 1) + ". ");
            planes.get(i).mostrarInfo();
            System.out.println();
        }
    }


    // Método para seleccionar un plan de membresía
    public PlanMembresia seleccionarPlan() {
        mostrarPlanes();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Seleccione el número del plan de membresía que desea: ");
        int opcion = scanner.nextInt();

        if (opcion >= 1 && opcion <= planes.size()) {
            return planes.get(opcion - 1);
        } else {
            System.out.println("Opción no válida, por favor intente de nuevo.");
            return null;
        }
    }
}