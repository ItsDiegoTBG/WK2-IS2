package com.group;

import java.util.ArrayList;
import java.util.List;

public class PlanMembresia {
    private String nombre;
    private double costoBase;
    private String beneficios;
    private TypeMember typeMember;
    private List<FuncionAdicional> funcionesAdicionales;

    // Constructor
    public PlanMembresia(String nombre, double costoBase, String beneficios,List<FuncionAdicional> funcionesAdicionales,TypeMember typeMember) {
        this.nombre = nombre;
        this.costoBase = costoBase;
        this.beneficios = beneficios;
        this.funcionesAdicionales = funcionesAdicionales;
        this.typeMember = typeMember;
    }

    public PlanMembresia(String nombre , double costoBase ,TypeMember typeMember){
        this.nombre = nombre;
        this.costoBase = costoBase;
        this.typeMember = typeMember;
        this.funcionesAdicionales = new ArrayList<>();
        this.beneficios="";
    }

    public TypeMember getTypeMember() {
        return typeMember;
    }

    public void setTypeMember(TypeMember typeMember) {
        this.typeMember = typeMember;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public double getCostoBase() {
        return costoBase;
    }

    public void setCostoBase(double costoBase) {
        this.costoBase = costoBase;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public List<FuncionAdicional> getFuncionesAdicionales() {
        return funcionesAdicionales;
    }

    public void setFuncionesAdicionales(List<FuncionAdicional> funcionesAdicionales) {
        this.funcionesAdicionales = funcionesAdicionales;
    }

    // Método para mostrar la información del plan
    public void mostrarInfo() {
        System.out.println("Plan: " + nombre);
        System.out.println("Costo: $" + costoBase);
        System.out.println("Beneficios: " + beneficios);

    }

    public void mostrarFuncionalidadesAdicionales(){
        System.out.println("Funciona Adicionales que puede tener:");
        for (FuncionAdicional funcionAdicional : funcionesAdicionales) {
            System.out.println("*"+funcionAdicional.getNombre() + "$ "+funcionAdicional.getCosto());
        }
    }
}