package gui;

import controller.LoginStaffController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Staff;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private TextField txtUser;

    @FXML
    private PasswordField txtPassword;

    private Stage dialogStage = new Stage();
    private Scene scene;
    private LoginStaffController loginStaffController;


    public LoginController() {
        loginStaffController = new LoginStaffController();
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        String user = txtUser.getText().toString();
        String password = txtPassword.getText().toString();

        Staff staff = new Staff();
        staff.setUsername(user);
        staff.setPassword(password);

        boolean userValidated = loginStaffController.validateStaff(staff);


        try {
            //HERE YOU COMPARE USER AND PASSWORD FROM DATABASE - TABLE STAFF
            //if (user.equals("1") && password.equals("1")) {
            if(userValidated) {
                infoBox("Login Successfull", "Success", null);
                Node source = (Node) event.getSource();
                dialogStage = (Stage) source.getScene().getWindow();
                dialogStage.close();
                scene = new Scene(FXMLLoader.load(getClass().getClassLoader().getResource("gui/menu.fxml" )));
                dialogStage.setScene(scene);
                dialogStage.show();

            } else {
                infoBox("Enter Correct Email and Password", "Failed", null);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void infoBox(String infoMessage, String titleBar, String headerMessage) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
