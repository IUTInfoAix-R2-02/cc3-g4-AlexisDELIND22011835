package fr.amu.iut.cc3;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class ToileController implements Initializable {

    private static int rayonCercleExterieur = 200;
    private static int angleEnDegre = 60;
    private static int angleDepart = 90;
    private static int noteMaximale = 20;

    @FXML
    public Button tracer;

    @FXML
    public Button vider;

    @FXML
    TextField comp1;

    @FXML
    TextField comp2;

    @FXML
    TextField comp3;

    @FXML
    TextField comp4;

    @FXML
    TextField comp5;

    @FXML
    TextField comp6;

    @FXML
    Pane circle;

    public Double[] valueList;

    //DoubleProperty note = new SimpleDoubleProperty();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tracer.setOnAction(e -> tracerValeur());
    }

    void tracerValeur(){
        valueList [0] = Double.valueOf(comp1.getText());
        valueList [1] = Double.valueOf(comp2.getText());
        valueList [2] = Double.valueOf(comp3.getText());
        valueList [3] = Double.valueOf(comp4.getText());
        valueList [4] = Double.valueOf(comp5.getText());
        valueList [5] = Double.valueOf(comp6.getText());

        for(int index =0;index <6; index++){
            int xValue = getXRadarChart(valueList[index],index+1);
            int yValue = getYRadarChart(valueList[index],index+1);
            Circle pointNote = new Circle();
            pointNote.setCenterX(xValue);
            pointNote.setCenterY(yValue);
            circle.getChildren().add(pointNote);
        }
    }


    int getXRadarChart(double value, int axe ){
        return (int) (rayonCercleExterieur + Math.cos(Math.toRadians(angleDepart - (axe-1)  * angleEnDegre)) * rayonCercleExterieur
                *  (value / noteMaximale));
    }

    int getYRadarChart(double value, int axe ){
        return (int) (rayonCercleExterieur - Math.sin(Math.toRadians(angleDepart - (axe-1)  * angleEnDegre)) * rayonCercleExterieur
                *  (value / noteMaximale));
    }

}
