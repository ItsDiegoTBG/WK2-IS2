package com.group;

public class Membership {
    private static final double BASIC_PLAN_COST = 30.0;
    private static final double STANDARD_PLAN_COST = 50.0;
    private static final double PREMIUM_PLAN_COST = 70.0;

    public double getMembershipCost(int planChoice) {
        switch (planChoice) {
            case 1:
                return BASIC_PLAN_COST;
            case 2:
                return STANDARD_PLAN_COST;
            case 3:
                return PREMIUM_PLAN_COST;
            default:
                System.out.println("Opción no válida. Se seleccionará el plan básico.");
                return BASIC_PLAN_COST;
        }
    }
}
