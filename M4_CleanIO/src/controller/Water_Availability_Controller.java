package controller;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.*;
import fxapp.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import model.ConditionOfWater;
import model.Model;
import model.TypeOfWater;
import model.WaterSourceReport;
import netscape.javascript.JSObject;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * controller for the water availability scene
 */
public class Water_Availability_Controller implements Initializable, MapComponentInitializedListener {

    @FXML
    private GoogleMapView mapView;

    private GoogleMap map;

    @FXML
    private TextField latitudeField;

    @FXML
    private TextField longitudeField;

    @FXML
    private TitledPane submitWaterReportPane;

    @FXML
    private ComboBox<TypeOfWater> typeOfWaterComboBox;

    @FXML
    private ComboBox<ConditionOfWater> conditionOfWaterComboBox;

    /** a link back to the main application class */
    private Main mainApplication;

    private Marker lol;

    /**
     * setup the main application link so we can call methods there
     *
     * @param mainFXApplication  a reference (link) to our main class
     */
    public void setMainApp(Main mainFXApplication) {
        mainApplication = mainFXApplication;
    }

    @FXML
    private void handleBackToMainMenuPressed() {
        mainApplication.displayMainInApplicationScene();
    }

    @Override
    public void mapInitialized() {
        MapOptions options = new MapOptions();

        //set up the center location for the map
        LatLong center = new LatLong(33.7756,-84.3963);

        options.center(center)
                .zoom(9)
                .overviewMapControl(false)
                .panControl(false)
                .rotateControl(false)
                .scaleControl(false)
                .streetViewControl(false)
                .zoomControl(false)
                .mapType(MapTypeIdEnum.TERRAIN);

        map = mapView.createMap(options);
        lol = new Marker(new MarkerOptions());

        map.addUIEventHandler(UIEventType.click, (JSObject obj) -> {
            if (submitWaterReportPane.isExpanded()) {
                LatLong hi = new LatLong((JSObject) obj.getMember("latLng"));
                lol.setPosition(hi);
                map.addMarker(lol);
                latitudeField.setText(hi.getLatitude() + "");
                longitudeField.setText(hi.getLongitude() + "");
            }
            int currentZoom = map.getZoom();
            map.setZoom(currentZoom - 1);
            map.setZoom(currentZoom);
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mapView.addMapInializedListener(this);
        typeOfWaterComboBox.getItems().setAll(TypeOfWater.values());
        typeOfWaterComboBox.setValue(TypeOfWater.Bottled);

        conditionOfWaterComboBox.getItems().setAll(ConditionOfWater.values());
        conditionOfWaterComboBox.setValue(ConditionOfWater.Potable);
    }

    /**
     * called when the submit water report tab is clicked
     */
    @FXML
    private void addEventHandler() {
        if (!submitWaterReportPane.isExpanded()) {
            latitudeField.setText("");
            longitudeField.setText("");
            map.removeMarker(lol);
            int currentZoom = map.getZoom();
            map.setZoom(currentZoom - 1);
            map.setZoom(currentZoom);
        }
    }

    /**
     * called when the user clicks submit
     */
    @FXML
    private void handleSubmitButtonPressed() {
        Date yeah = new Date();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a");
        String date = dateFormatter.format(yeah);
        String time = timeFormatter.format(yeah);
        WaterSourceReport waterSourceReport = new WaterSourceReport(date, time);
        waterSourceReport.setNameOfReporter(Model.getInstance().getLoggedInProfile().getUsername());
        waterSourceReport.setLocation(latitudeField.getText() + " " + longitudeField.getText());
        waterSourceReport.setTypeOfWater(typeOfWaterComboBox.getSelectionModel().getSelectedItem());
        waterSourceReport.setConditionOfWater(conditionOfWaterComboBox.getSelectionModel().getSelectedItem());
        Model.getInstance().getWaterSourceReports().add(waterSourceReport);

        Marker marker = new Marker(new MarkerOptions());
        marker.setPosition(new LatLong(Double.parseDouble(latitudeField.getText()), Double.parseDouble(longitudeField.getText())));
        map.addUIEventHandler(marker,
                UIEventType.click,
                (JSObject obj) -> {
                    InfoWindowOptions infoWindowOptions = new InfoWindowOptions();
                    infoWindowOptions.content(waterSourceReport.getConditionOfWater().toString() + " " +
                    waterSourceReport.getTypeOfWater().toString());

                    InfoWindow window = new InfoWindow(infoWindowOptions);
                    window.open(map, marker);
                });

        map.addMarker(marker);
    }

}
