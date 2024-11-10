package com.group;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
public class MembresiaTest {
  private Membresia membresia;
  private PlanMembresia planPremium;
  private PlanMembresia planFamily;

  @BeforeEach
  public void setUp() {
      planPremium = new PlanMembresia("Premium",100,TypeMember.PREMIUM);
      planFamily = new PlanMembresia("Familiar",100,TypeMember.FAMILY);
  }

  @Test
  public void testCalcularCostroPremium(){
      membresia = new Membresia(planPremium);
      membresia.setMiembros(3);
      double costoTotal = membresia.calcularCostoTotal();
      assertEquals(345.0,costoTotal,"El costo total de los miembros debe ser 345.0");
  }

    @Test
    public void testCalcularCostoTotalFamily() {
        membresia = new Membresia(planFamily);
        membresia.setMiembros(2);
        double costoTotal = membresia.calcularCostoTotal();
        assertEquals(200.0, costoTotal, "El costo total para el plan Family con 2 miembros debería ser 200.0");
    }



    @Test
    public void testEntradaNoValidaMiembros() {
        Scanner mockScanner = new Scanner("abc"); // Entrada no válida
        membresia = new Membresia(planPremium);
        membresia.setMiembros(0); // Miembros por defecto
        assertThrows(NumberFormatException.class, () -> {
            membresia.setMiembros(Integer.parseInt(mockScanner.next())); // Forzamos una excepción
        }, "Se esperaba una excepción por ingresar un valor no numérico.");
    }

    @Test
    public void testAgregarFuncionAdicional() {
        membresia = new Membresia(planPremium);
        membresia.setMiembros(2);
        double costoAntes = membresia.calcularCostoTotal();
        FuncionAdicional funcionAdicional = new  FuncionAdicional("Entrenador personal",50);
        membresia.setCostoFuncionesAdicionales(50);
        double costoDespues = membresia.calcularCostoTotal();
        assertTrue(costoDespues > costoAntes, "El costo total debería aumentar después de agregar una función adicional.");
    }



}