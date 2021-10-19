/* Alert.java
   Factory for Alert
   Author: Melisa Bhixa (217131085)
   Date: 11 June 2021
 */

package za.ac.cput.factory;

import za.ac.cput.entity.Alert;

public class AlertFactory {

    public static Alert CreateAlert(String alertNumber, String alertType){
        Alert alert = null;

        if(alertNumber.trim().isEmpty()){
            System.out.println("Alert number cannot be null");

        }else if(alertType.trim().isEmpty()){
            System.out.println("Please enter alert type");

        }else{
            alert = new Alert.AlertBuilder().setAlertNumber(alertNumber).setAlertType(alertType).build();
        }
        return alert;
    }
}
