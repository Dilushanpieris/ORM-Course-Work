package Controller;/*
Author-:dilus
Date:-30/12/2021
*/

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainLoginFormController {
    public AnchorPane mainViewContext;
    public JFXTextField uNameTxt;
    public JFXPasswordField passTxt;
    public JFXCheckBox loginAsAdminChk;

    public void closebtnOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) mainViewContext.getScene().getWindow();
        stage.close();
    }

    public void loginBtnOnAction(ActionEvent actionEvent) throws IOException {
        if(loginAsAdminChk.isSelected()){
            mainViewContext.getScene().getWindow().hide();
            Parent load = FXMLLoader.load(getClass().getResource("../View/ManageCourses.fxml"));
            Scene scene = new Scene(load);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            scene.setFill(Color.TRANSPARENT);
            stage.show();
        }
        else{
            mainViewContext.getScene().getWindow().hide();
            Parent load = FXMLLoader.load(getClass().getResource("../View/ManageStudent.fxml"));
            Scene scene = new Scene(load);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            scene.setFill(Color.TRANSPARENT);
            stage.show();
        }
    }

}
