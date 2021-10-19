/* Alert.java
   Entity for AlertType
   Author: Melisa Bhixa (217131085)
   Date: 11 June 2021
 */

package za.ac.cput.entity;

public class AlertType {
    private String alertTypeNumber, description, severity;

    public AlertType(AlertTypeBuilder alertTypeBuilder) {
        this.alertTypeNumber = alertTypeBuilder.alertTypeNumber;
        this.description = alertTypeBuilder.description;
        this.severity = alertTypeBuilder.severity;
    }

    public String getAlertTypeNumber() {
        return alertTypeNumber;
    }

    public String getDescription() {
        return description;
    }

    public String getSeverity() {
        return severity;
    }

    public static class AlertTypeBuilder{
        private String alertTypeNumber, description, severity;

        public AlertTypeBuilder setAlertTypeNumber(String alertTypeNumber) {
            this.alertTypeNumber = alertTypeNumber;
            return this;
        }

        public AlertTypeBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public AlertTypeBuilder setSeverity(String severity) {
            this.severity = severity;
            return this;
        }

        public AlertTypeBuilder copy(AlertType alertType){
            this.alertTypeNumber = alertType.alertTypeNumber;
            this.description = alertType.description;
            this.severity = alertType.severity;
            return this;
        }

        public AlertType build(){
            return new AlertType(this);
        }
    }
}
