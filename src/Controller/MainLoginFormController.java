package Controller;/*
Author-:dilus
Date:-30/12/2021
*/

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainLoginFormController {
    public AnchorPane mainViewContext;
    public JFXTextField uNameTxt;
    public JFXPasswordField passTxt;

    public void closebtnOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) mainViewContext.getScene().getWindow();
        stage.close();
    }

    public void loginBtnOnAction(ActionEvent actionEvent) {
    }

    public void loginAsAdminOnAction(ActionEvent actionEvent) {
    }
}
