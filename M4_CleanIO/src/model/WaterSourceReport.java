package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class WaterSourceReport {
    private static int reportNumber = 1;
    private String date, time, nameOfReporter;
    private Double latitude, longitude;
    private TypeOfWater typeOfWater;
    private ConditionOfWater conditionOfWater;
    private final IntegerProperty thisInstanceReportNumber = new SimpleIntegerProperty();

    public WaterSourceReport(String date, String time, String nameOfReporter, Double latitude, Double longitude, TypeOfWater typeOfWater, ConditionOfWater conditionOfWater) {
        this.date = date;
        this.time = time;
        this.nameOfReporter = nameOfReporter;
        this.latitude = latitude;
        this.longitude = longitude;
        this.typeOfWater = typeOfWater;
        this.conditionOfWater = conditionOfWater;
        this.thisInstanceReportNumber.setValue(reportNumber);

        reportNumber++;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNameOfReporter() {
        return nameOfReporter;
    }

    public void setNameOfReporter(String nameOfReporter) {
        this.nameOfReporter = nameOfReporter;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public static int getReportNumber() {
        return reportNumber;
    }

    public static void setReportNumber(int reportNumber) {
        WaterSourceReport.reportNumber = reportNumber;
    }

    public TypeOfWater getTypeOfWater() {
        return typeOfWater;
    }

    public void setTypeOfWater(TypeOfWater typeOfWater) {
        this.typeOfWater = typeOfWater;
    }

    public ConditionOfWater getConditionOfWater() {
        return conditionOfWater;
    }

    public void setConditionOfWater(ConditionOfWater conditionOfWater) {
        this.conditionOfWater = conditionOfWater;
    }

    public int getThisInstanceReportNumber() {
        return thisInstanceReportNumber.get();
    }

    public void setThisInstanceReportNumber(int thisInstanceReportNumber) {
        this.thisInstanceReportNumber.setValue(thisInstanceReportNumber);
    }

    public IntegerProperty getThisReportNumberProperty() {
        return thisInstanceReportNumber;
    }

}
