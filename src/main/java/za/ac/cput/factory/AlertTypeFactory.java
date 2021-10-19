/* Alert.java
   Factory for AlertType
   Author: Melisa Bhixa (217131085)
   Date: 11 June 2021
 */

package za.ac.cput.factory;

import za.ac.cput.entity.AlertType;

public class AlertTypeFactory {

    public static AlertType CreateAlertType(String alertTypeNumber, String description, String severity){
        AlertType alertType = null;

        if(alertTypeNumber.trim().isEmpty()){
            System.out.println("Please enter alert type number");

        }else if(description.trim().isEmpty()){
            System.out.println("Please enter alert description");

        }else if(severity.trim().isEmpty()){
            System.out.println("Please enter alert severity");

        }else {
            alertType = new AlertType.AlertTypeBuilder().setAlertTypeNumber(alertTypeNumber)
                                                        .setDescription(description)
                                                        .setSeverity(description)
                                                        .build();
        }
        return alertType;
    }
}
