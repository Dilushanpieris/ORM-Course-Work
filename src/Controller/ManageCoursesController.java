package Controller;/*
Author-:dilus
Date:-30/12/2021
*/

import Dao.ProgramDao;
import Dao.ProgramDaoImpl;
import Entity.Program;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.ProgramDTO;
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
import java.util.Observable;

public class ManageCoursesController{
    public JFXComboBox selectCourseIdCmbBox;
    public Label cNameLbl;
    public Label cDurationLbl;
    public Label cFeeLbl;
    public JFXTextField txtCourseName;
    public JFXTextField txtCourseDuration;
    public JFXTextField txtCourseFee;
    public AnchorPane ManageCourseContext;
    public Label GenCourseIdTxt;
    ProgramDao program=new ProgramDaoImpl();



    public void initialize() throws IOException {
        ArrayList<String> programIds=program.getAllIds();
        ObservableList<String> oblist= FXCollections.observableArrayList();
        for (String tempId:programIds) {
            oblist.add(tempId);
        }
        selectCourseIdCmbBox.setItems(oblist);

    }

    public void selectCourseCmbBoxAction(ActionEvent actionEvent) throws IOException {
        String selectedItem = (String) selectCourseIdCmbBox.getSelectionModel().getSelectedItem();
        Program readData = program.readData(selectedItem);
        cNameLbl.setText(readData.getP_name());
        cDurationLbl.setText(readData.getDurarion());
        cFeeLbl.setText(readData.getFee());
    }

    public void deleteCourseOnAction(ActionEvent actionEvent) throws IOException {
        boolean selected = selectCourseIdCmbBox.getSelectionModel().isEmpty();
        if(selected==true){
            new Alert(Alert.AlertType.WARNING,"Please Select ID To Delete").showAndWait();
            return;
        }
        boolean b = program.deleteData((String) selectCourseIdCmbBox.getSelectionModel().getSelectedItem());
        if(b==true){
            new Alert(Alert.AlertType.CONFIRMATION,"Successfully_Deleted.").showAndWait();
            refresh();
        }
        else{
            new Alert(Alert.AlertType.WARNING,"Error In Database.").showAndWait();
        }
    }

    public void refresh() throws IOException {
        ManageCourseContext.getScene().getWindow().hide();
        Parent load = FXMLLoader.load(getClass().getResource("../View/ManageCourses.fxml"));
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        stage.show();
    }

    public void genNewIdOnAction(ActionEvent actionEvent) throws IOException {
        String s =program.gearateNewID();
        GenCourseIdTxt.setText(s);
    }

    public void saveNewCourseOnAction(ActionEvent actionEvent) throws IOException {
        if(program.isExists(GenCourseIdTxt.getText())){
            new Alert(Alert.AlertType.WARNING,"ID Already Exists").show();
            return;
        }
        if(txtCourseName.getText().isEmpty()&&txtCourseDuration.getText().isEmpty()&&txtCourseFee.getText().isEmpty()){
            new Alert(Alert.AlertType.WARNING,"Please Add Data Before Saving").show();
            return;
        }
        String courseNameText = txtCourseName.getText();
        String courseDurationText = txtCourseDuration.getText();
        String courseFeeText = txtCourseFee.getText();
        String idTxt = GenCourseIdTxt.getText();
        ProgramDTO programDTO = new ProgramDTO(idTxt, courseNameText, courseDurationText, courseFeeText);
        boolean isSaved = program.saveNewProgram(new Program(programDTO.getP_id(), programDTO.getP_name(), programDTO.getDurarion(), programDTO.getFee()));
        if(isSaved==true){
            new Alert(Alert.AlertType.CONFIRMATION,"Successfully Saved").showAndWait();
            refresh();
        }
        else {
            new Alert(Alert.AlertType.WARNING,"Database Error").show();
        }
    }
    public void closeWindowOnAction(ActionEvent actionEvent) throws IOException {
        ManageCourseContext.getScene().getWindow().hide();
        Parent load = FXMLLoader.load(getClass().getResource("../View/MainLoginForm.fxml"));
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        stage.show();
    }
}
