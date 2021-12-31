package Controller;/*
Author-:dilus
Date:-31/12/2021
*/

import Dao.Student_DataDao;
import Dao.Student_DataDaoImpl;
import Entity.Student_Data;
import dto.Student_DataDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.List;

public class ViewStudentDataController {
    public AnchorPane stuDataContext;
    public TableView TableViewContext;
    public TableColumn colStid;
    public TableColumn colPid;
    public TableColumn colRegDate;
    public TableColumn colPaidAmount;
    Student_DataDao student_data=new Student_DataDaoImpl();

    public void initialize() throws IOException {
        loadDataToTable();
        colStid.setCellValueFactory(new PropertyValueFactory<>("st_id"));
        colPid.setCellValueFactory(new PropertyValueFactory<>("p_id"));
        colRegDate.setCellValueFactory(new PropertyValueFactory<>("reg_date"));
        colPaidAmount.setCellValueFactory(new PropertyValueFactory<>("paid_amount"));

    }

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

    public void assignCourseOnAction(ActionEvent actionEvent) throws IOException {
        stuDataContext.getScene().getWindow().hide();
        Parent load = FXMLLoader.load(getClass().getResource("../View/AssignCourse.fxml"));
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        stage.show();
    }
    public void loadDataToTable() throws IOException {
        List<Student_Data> Data = student_data.readData();
        ObservableList<Student_DataDTO> observableList= FXCollections.observableArrayList();
        for (Student_Data std:Data) {
            observableList.add(new Student_DataDTO(std.getSt_id(),std.getP_id(),std.getReg_date(),std.getPaid_amount()));
        }
        TableViewContext.setItems(observableList);
    }
}
