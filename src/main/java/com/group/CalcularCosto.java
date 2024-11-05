package com.group;

import java.util.Scanner;

public class CalcularCosto {

    private double costoFinal; 
    private int miembros;

    public CalcularCosto(double costoActual){
        this.costoFinal =costoActual;
        this.miembros=1;
    }

    public double getcostoFinal(){
        return costoFinal;
    }

    public int getMiembros(){
        return miembros;
    }
    public void mostrraInfoo(){
        System.out.println(costoFinal);
    }
    public void CalcularCostoFinal(int CantMiembros, String Categoria, double costoActual, double CostoFuncAdicional){

        costoFinal*=CostoFuncAdicional;

        if (Categoria== "Premium"){
            costoFinal *= 1.15;
        }
        if (costoFinal > 400) {
            System.out.println("Descuento especial aplicado: $50");
            costoFinal -= 50;
        } else if (costoFinal > 200) {
            System.out.println("Descuento especial aplicado: $20");
            costoFinal -= 20;
        }
        if (CantMiembros>1){
            costoFinal *= CantMiembros;
            costoFinal = costoFinal*0.9;
        }
        System.out.println("El Costo final de su membresia seria: $ "+costoFinal);
    }
    public void InfoDescuento(){
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
