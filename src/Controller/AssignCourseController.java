package Controller;/*
Author-:dilus
Date:-31/12/2021
*/

import Dao.*;
import Entity.Program;
import Entity.Student;
import Entity.Student_Data;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.Student_DataDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AssignCourseController {
    public JFXComboBox cmbStudent;
    public JFXComboBox cmbCourseId;
    public Label lblStuName;
    public Label lblStuAddress;
    public Label lblStuTel;
    public Label lblCourseName;
    public Label lblCourseDuration;
    public Label lblCourseFee;
    public AnchorPane assignCourseContext;
    public JFXTextField txtPaidAmount;
    StudentDao student= new StudentDaoImpl();
    ProgramDao program=new ProgramDaoImpl();
    Student_DataDao student_data=new Student_DataDaoImpl();

    public void initialize() throws IOException {
        ArrayList<String> studentIds=student.getAllIds();
        ObservableList<String> oblist= FXCollections.observableArrayList();
        for (String tempId:studentIds) {
            oblist.add(tempId);
        }
        cmbStudent.setItems(oblist);

        ArrayList<String> programIds=program.getAllIds();
        ObservableList<String> oblist2= FXCollections.observableArrayList();
        for (String tempId:programIds) {
            oblist2.add(tempId);
        }
        cmbCourseId.setItems(oblist2);
    }

    public void cmbStudentOnAction(ActionEvent actionEvent) throws IOException {
        Student readData = this.student.readData((String) cmbStudent.getSelectionModel().getSelectedItem());
        lblStuName.setText(readData.getName());
        lblStuAddress.setText(readData.getAddress());
        lblStuTel.setText(readData.getTelephone());
    }

    public void cmbCourseIdOnAction(ActionEvent actionEvent) throws IOException {
        String selectedItem = (String) cmbCourseId.getSelectionModel().getSelectedItem();
        Program readData = program.readData(selectedItem);
        lblCourseName.setText(readData.getP_name());
        lblCourseDuration.setText(readData.getDurarion());
        lblCourseFee.setText(readData.getFee());
    }

    public void AssignForCourseOnAction(ActionEvent actionEvent) throws IOException {
        if(cmbCourseId.getSelectionModel().isEmpty()||cmbStudent.getSelectionModel().isEmpty()||txtPaidAmount.getText().isEmpty()){
            new Alert(Alert.AlertType.WARNING,"Please Select Data To Assign").show();
            return;
        }
        if(student_data.isExists((String) cmbStudent.getSelectionModel().getSelectedItem(),(String) cmbCourseId.getSelectionModel().getSelectedItem())){
            new Alert(Alert.AlertType.WARNING,"Student Already Added...").show();
            return;
        }
        //code
        Student_DataDTO dataDTO = new Student_DataDTO((String) cmbStudent.getSelectionModel().getSelectedItem(), (String) cmbCourseId.getSelectionModel().getSelectedItem(), DateNow(), txtPaidAmount.getText());
        boolean b = student_data.saveNewData(new Student_Data(dataDTO.getSt_id(), dataDTO.getP_id(), dataDTO.getReg_date(), dataDTO.getPaid_amount()));
        if(b==true){
            new Alert(Alert.AlertType.CONFIRMATION,"Student Assigned").show();
        }
        else {
            new Alert(Alert.AlertType.WARNING,"Database Error").show();
        }
    }

    public String DateNow(){
        Date date=new Date();
        SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
        return f.format(date);
    }

    public void resignFromCourseOnAction(ActionEvent actionEvent) throws IOException {
        if(cmbCourseId.getSelectionModel().isEmpty()||cmbStudent.getSelectionModel().isEmpty()){
            new Alert(Alert.AlertType.WARNING,"Please Select Data To Assign").show();
            return;
        }
        boolean exists = student_data.isExists((String) cmbStudent.getSelectionModel().getSelectedItem(),(String) cmbCourseId.getSelectionModel().getSelectedItem());
        if(exists==false){
            new Alert(Alert.AlertType.CONFIRMATION,"Student Already Resigned...").show();
            return;
        }
        //code
        boolean b = student_data.deleteData((String) cmbStudent.getSelectionModel().getSelectedItem(), (String) cmbCourseId.getSelectionModel().getSelectedItem());
        if(b==true){
            new Alert(Alert.AlertType.CONFIRMATION,"Successfully Resigned").showAndWait();
            refresh();
        }
        else{
            new Alert(Alert.AlertType.WARNING,"Persistence Error").show();
        }
    }

    public void closeOnAction(ActionEvent actionEvent) throws IOException {
        assignCourseContext.getScene().getWindow().hide();
        Parent load = FXMLLoader.load(getClass().getResource("../View/ViewStudentData.fxml"));
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        stage.show();
    }
    public void refresh() throws IOException {
        assignCourseContext.getScene().getWindow().hide();
        Parent load = FXMLLoader.load(getClass().getResource("../View/AssignCourse.fxml"));
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        stage.show();
    }
}
