package model;

import javafx.beans.property.*;

public class WaterSourceReport {
        private final StringProperty _date = new SimpleStringProperty();
        private final StringProperty _time = new SimpleStringProperty();
        private final IntegerProperty _reportNumber = new SimpleIntegerProperty();
        private final StringProperty _nameOfReporter = new SimpleStringProperty();
        private final StringProperty _location = new SimpleStringProperty();
        private final ObjectProperty<TypeOfWater> _typeOfWater = new SimpleObjectProperty<>();
        private final ObjectProperty<ConditionOfWater> _conditionOfWater = new SimpleObjectProperty<>();
        private static int reportNumber = 1;
        public String getDate() {
            return _date.get();
        }

        public void setDate(String _date) {
            this._date.set(_date);
        }

        public StringProperty dateProperty() {
            return _date;
        }

        public String getTime() {
            return _time.get();
        }

        public void setTime(String _time) {
            this._time.set(_time);
        }

        public int getReportNumber() {
            return _reportNumber.get();
        }

        public void setReportNumber(int _reportNumber) {
            this._reportNumber.set(_reportNumber);
        }

        public IntegerProperty reportNumberProperty() {
            return _reportNumber;
        }

        public String getNameOfReporter() {
            return _nameOfReporter.get();
        }

        public void setNameOfReporter(String _nameOfReporter) {
            this._nameOfReporter.set(_nameOfReporter);
        }

        public String getLocation() {
            return _location.get();
        }

        public void setLocation(String _location) {
            this._location.set(_location);
        }

        public TypeOfWater getTypeOfWater() {
            return _typeOfWater.get();
        }

        public void setTypeOfWater(TypeOfWater _typeOfWater) {
            this._typeOfWater.set(_typeOfWater);
        }

        public ConditionOfWater getConditionOfWater() {
            return _conditionOfWater.get();
        }

        public void setConditionOfWater(ConditionOfWater _conditionOfWater) {
            this._conditionOfWater.set(_conditionOfWater);
        }

        public WaterSourceReport(String date, String time) {
            _date.set(date);
            _time.set(time);
            setReportNumber(reportNumber);
            reportNumber++;
        }
}
