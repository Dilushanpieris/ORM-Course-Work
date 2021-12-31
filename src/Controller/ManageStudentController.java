package Controller;/*
Author-:dilus
Date:-31/12/2021
*/

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ManageStudentController {
    public AnchorPane manageStudentContext;
    public Label genStuIDlbl;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtTel;
    public Label lblName;
    public Label lblAddress;
    public Label lblTel;
    public JFXComboBox cmbBoxSelectStudent;

    public void closeWindowOnAction(ActionEvent actionEvent) throws IOException {
        manageStudentContext.getScene().getWindow().hide();
        Parent load = FXMLLoader.load(getClass().getResource("../View/MainLoginForm.fxml"));
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        stage.show();
    }

    public void btnGenarateNewIDOnAction(ActionEvent actionEvent) {
    }

    public void saveNewStuOnAction(ActionEvent actionEvent) {
    }

    public void cmbBoxSelectStuOnAction(ActionEvent actionEvent) {
    }

    public void deleteStuOnAction(ActionEvent actionEvent) {
    }

    public void ViewStuDataOnAction(ActionEvent actionEvent) throws IOException {
        manageStudentContext.getScene().getWindow().hide();
        Parent load = FXMLLoader.load(getClass().getResource("../View/ViewStudentData.fxml"));
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        stage.show();
    }
}
