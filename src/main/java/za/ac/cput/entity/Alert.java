/* Alert.java
   Entity for Alert
   Author: Melisa Bhixa (217131085)
   Date: 11 June 2021
 */

package za.ac.cput.entity;

public class Alert {
    private String alertNumber, alertType;

    public Alert(AlertBuilder alertBuilder) {
        this.alertNumber = alertBuilder.alertNumber;
        this.alertType = alertBuilder.alertType;
    }

    public String getAlertNumber() {
        return alertNumber;
    }

    public String getAlertType() {
        return alertType;
    }

    public static class AlertBuilder{
        private String alertNumber, alertType;

        public AlertBuilder setAlertNumber(String alertNumber) {
            this.alertNumber = alertNumber;
            return this;
        }

        public AlertBuilder setAlertType(String alertType) {
            this.alertType = alertType;
            return this;
        }

        public AlertBuilder copy(Alert alert){
            this.alertNumber = alert.alertNumber;
            this.alertNumber = alert.alertNumber;
            return this;
        }

        public Alert build(){
            return new Alert(this);
        }
    }
}
