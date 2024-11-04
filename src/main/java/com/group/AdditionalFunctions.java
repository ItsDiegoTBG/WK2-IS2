package com.group;

public class AdditionalFunctions {
  
    private static final double PERSONAL_TRAINING_COST = 20.0; 
    private static final double GROUP_CLASS_COST = 15.0; 
    private static final double SPA_ACCESS_COST = 25.0; 

 
    public double calculateAdditionalCost(int personalTrainingSessions, int groupClasses, int spaAccess) {
        double personalTrainingTotal = personalTrainingSessions * PERSONAL_TRAINING_COST;
        double groupClassesTotal = groupClasses * GROUP_CLASS_COST;
        double spaTotal = (spaAccess == 1) ? SPA_ACCESS_COST : 0.0;

        return personalTrainingTotal + groupClassesTotal + spaTotal;
    }
}
