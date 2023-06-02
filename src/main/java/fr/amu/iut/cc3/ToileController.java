package fr.amu.iut.cc3;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

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
    @FXML
    Label erreur;
    @FXML
    Label typeErreur;
    @FXML
    Line line1;
    @FXML
    Line line2;
    @FXML
    Line line3;
    @FXML
    Line line4;
    @FXML
    Line line5;
    @FXML
    Line line6;

    public Double[] valueList = {0.0,0.0,0.0,0.0,0.0,0.0};
    public int[] xValues = {0,0,0,0,0,0};
    public int[] yValues = {0,0,0,0,0,0};

    //DoubleProperty note = new SimpleDoubleProperty();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tracer.setOnAction(e -> {
            tracerValeur();
        });
        vider.setOnAction(e -> {
            vider();
        });
    }

    void tracerValeur(){
        valueList [0] = Double.valueOf(comp1.getText());
        valueList [1] = Double.valueOf(comp2.getText());
        valueList [2] = Double.valueOf(comp3.getText());
        valueList [3] = Double.valueOf(comp4.getText());
        valueList [4] = Double.valueOf(comp5.getText());
        valueList [5] = Double.valueOf(comp6.getText());
        if (verifNote()) {
            for (int index = 0; index < valueList.length; index++) {
                xValues[index] = getXRadarChart(valueList[index], index + 1);
                yValues[index] = getYRadarChart(valueList[index], index + 1);
                initDots();
                initLines();
            }
        }else{
            erreur.setStyle("-fx-text-fill: RED");
            typeErreur.setStyle("-fx-text-fill: RED");
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

    void initLines(){
        line1.setStartX(xValues[0]);
        line1.setEndX(xValues[1]);
        line1.setStartY(yValues[0]);
        line1.setEndY(yValues[1]);

        line2.setStartX(xValues[1]);
        line2.setEndX(xValues[2]);
        line2.setStartY(yValues[1]);
        line2.setEndY(yValues[2]);

        line3.setStartX(xValues[2]);
        line3.setEndX(xValues[3]);
        line3.setStartY(yValues[2]);
        line3.setEndY(yValues[3]);

        line4.setStartX(xValues[3]);
        line4.setEndX(xValues[4]);
        line4.setStartY(yValues[3]);
        line4.setEndY(yValues[4]);

        line5.setStartX(xValues[4]);
        line5.setEndX(xValues[5]);
        line5.setStartY(yValues[4]);
        line5.setEndY(yValues[5]);

        line6.setStartX(xValues[5]);
        line6.setEndX(xValues[0]);
        line6.setStartY(yValues[5]);
        line6.setEndY(yValues[0]);
        }


    boolean verifNote(){
        boolean verif = true;
        for(int index =0;index < valueList.length; index++){
            if (valueList[index] > 20){
                verif = false;
            }
        }
        return verif;
    }

    void vider(){
        point1.setRadius(0);
        point2.setRadius(0);
        point3.setRadius(0);
        point4.setRadius(0);
        point5.setRadius(0);
        point6.setRadius(0);
        erreur.setStyle("-fx-text-fill: rgb(188,208,251);");
        typeErreur.setStyle("-fx-text-fill: rgb(188,208,251);");
        comp1.setText("");
        comp2.setText("");
        comp3.setText("");
        comp4.setText("");
        comp5.setText("");
        comp6.setText("");
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
