package sample.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.DatabaseHandler;
import sample.User;

public class
SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField SignUpSurname;

    @FXML
    private Button SignUpButton;

    @FXML
    private PasswordField password_field;

    @FXML
    private TextField SignUpName;

    @FXML
    private TextField login_field;

    @FXML
    private TextField SignUpCountry;

    @FXML
    private CheckBox SignUpCheckBoxMale;

    @FXML
    private CheckBox SignUpCheckBoxFemale;

    @FXML
    void initialize() {


        SignUpButton.setOnAction(event->{

            signUpNewUser();
            openNewScene("/sample/views/sample.fxml");


        });
    }

    private void signUpNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String firstName = SignUpName.getText().replace(" ","");
        String lastName = SignUpSurname.getText().replace(" ","");
        String userName = login_field.getText().replace(" ","");
        String password = password_field.getText().replace(" ","");
        String location = SignUpCountry.getText().replace(" ","");
        String gender = "";
        if(SignUpCheckBoxMale.isSelected())
            gender = "Мужской";
        else if(SignUpCheckBoxFemale.isSelected())
            gender = "Женский";
        else if(SignUpCheckBoxMale.isSelected()&&SignUpCheckBoxFemale.isSelected())
            gender = "none";
        else
            gender = "none";
        if (!firstName.equals("")&&!lastName.equals("")&&!userName.equals("")&&!password.equals("")&&
                !location.equals("")&&!gender.equals("none")&&!gender.equals("")){
            User user = new User(firstName, lastName, userName, password, location, gender);

            dbHandler.signUpUser(user);
        }
        else{
            System.out.println("Don't left empty fields");
        }
    }
    public void openNewScene(String window) {
        SignUpButton.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
}
