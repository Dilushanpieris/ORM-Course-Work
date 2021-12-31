package Controller;/*
Author-:dilus
Date:-31/12/2021
*/

import Dao.StudentDao;
import Dao.StudentDaoImpl;
import Entity.Student;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.StudentDTO;
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
import java.util.ArrayList;

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
    StudentDao student= new StudentDaoImpl();
    public void initialize() throws IOException {
        ArrayList<String> studentIds=student.getAllIds();
        ObservableList<String> oblist= FXCollections.observableArrayList();
        for (String tempId:studentIds) {
            oblist.add(tempId);
        }
        cmbBoxSelectStudent.setItems(oblist);
    }

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

    public void btnGenarateNewIDOnAction(ActionEvent actionEvent) throws IOException {
        String id = student.gearateNewID();
        genStuIDlbl.setText(id);
    }

    public void saveNewStuOnAction(ActionEvent actionEvent) throws IOException {
        if(student.isExists(genStuIDlbl.getText())){
            new Alert(Alert.AlertType.WARNING,"ID Already Exists").show();
            return;
        }
        if(txtName.getText().isEmpty()&&txtAddress.getText().isEmpty()&&txtTel.getText().isEmpty()){
            new Alert(Alert.AlertType.WARNING,"Please Add Data Before Saving").show();
            return;
        }
        String nameText = txtName.getText();
        String addressText = txtAddress.getText();
        String telText = txtTel.getText();
        String idTxt=genStuIDlbl.getText();
        StudentDTO studentDTO = new StudentDTO(idTxt, nameText, addressText, telText);
        boolean isSaved = student.saveNewStudent(new Student(studentDTO.getSt_id(), studentDTO.getName(), studentDTO.getAddress(), studentDTO.getTelephone()));
        if(isSaved==true){
            new Alert(Alert.AlertType.CONFIRMATION,"Successfully Saved").showAndWait();
            refresh();
        }
        else{
            new Alert(Alert.AlertType.CONFIRMATION,"Database_error").showAndWait();
        }
    }
    public void refresh() throws IOException {
        manageStudentContext.getScene().getWindow().hide();
        Parent load = FXMLLoader.load(getClass().getResource("../View/ManageStudent.fxml"));
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        stage.show();
    }

    public void cmbBoxSelectStuOnAction(ActionEvent actionEvent) throws IOException {
        //load Data
        Student readData = this.student.readData((String) cmbBoxSelectStudent.getSelectionModel().getSelectedItem());
        lblName.setText(readData.getName());
        lblAddress.setText(readData.getAddress());
        lblTel.setText(readData.getTelephone());
    }

    public void deleteStuOnAction(ActionEvent actionEvent) throws IOException {
        boolean selected = cmbBoxSelectStudent.getSelectionModel().isEmpty();
        if(selected==true){
            new Alert(Alert.AlertType.WARNING,"Please Select ID To Delete").showAndWait();
            return;
        }
        boolean b = student.deleteData((String) cmbBoxSelectStudent.getSelectionModel().getSelectedItem());
        if(b==true){
            new Alert(Alert.AlertType.CONFIRMATION,"Successfully_Deleted.").showAndWait();
            refresh();
        }
        else{
            new Alert(Alert.AlertType.WARNING,"Error In Database.").showAndWait();
        }
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
