package Controller;/*
Author-:dilus
Date:-31/12/2021
*/

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ViewStudentDataController {
    public AnchorPane stuDataContext;
    public TableView TableViewContext;
    public TableColumn colStid;
    public TableColumn colPid;
    public TableColumn colRegDate;
    public TableColumn colPaidAmount;

    public void backToStudentManagement(ActionEvent actionEvent) throws IOException {
        stuDataContext.getScene().getWindow().hide();
        Parent load = FXMLLoader.load(getClass().getResource("../View/ManageStudent.fxml"));
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        stage.show();
    }
}
