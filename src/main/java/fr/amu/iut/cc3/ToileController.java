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
    public Button vider;
    @FXML
    public Button tracer;
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
    Circle point1;
    @FXML
    Circle point2;
    @FXML
    Circle point3;
    @FXML
    Circle point4;
    @FXML
    Circle point5;
    @FXML
    Circle point6;

    public Double[] valueList = {0.0,0.0,0.0,0.0,0.0,0.0};
    public int[] xValues = {0,0,0,0,0,0};
    public int[] yValues = {0,0,0,0,0,0};

    //DoubleProperty note = new SimpleDoubleProperty();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tracer.setOnAction(e -> {
            tracerValeur();
            System.out.print("test");
        });
    }

    void tracerValeur(){
        valueList [0] = Double.valueOf(comp1.getText());
        valueList [1] = Double.valueOf(comp2.getText());
        valueList [2] = Double.valueOf(comp3.getText());
        valueList [3] = Double.valueOf(comp4.getText());
        valueList [4] = Double.valueOf(comp5.getText());
        valueList [5] = Double.valueOf(comp6.getText());
        for(int index =0;index <6; index++){
                xValues[index] = getXRadarChart(valueList[index], index + 1);
                yValues[index] = getYRadarChart(valueList[index], index + 1);
                initDots();
        }
    }

    void initDots(){
        point1.setCenterY(yValues[0]);
        point1.setCenterX(xValues[0]);
        point1.setRadius(5);
        point2.setCenterY(yValues[1]);
        point2.setCenterX(xValues[1]);
        point2.setRadius(5);
        point3.setCenterY(yValues[2]);
        point3.setCenterX(xValues[2]);
        point3.setRadius(5);
        point4.setCenterY(yValues[3]);
        point4.setCenterX(xValues[3]);
        point4.setRadius(5);
        point5.setCenterY(yValues[4]);
        point5.setCenterX(xValues[4]);
        point5.setRadius(5);
        point6.setCenterY(yValues[5]);
        point6.setCenterX(xValues[5]);
        point6.setRadius(5);

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
