import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class AppLauncher extends Application {
    public Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.window = primaryStage;

        this.window.setMinWidth(360.0D);
        this.window.setMaxWidth(360.0D);
        this.window.setMinHeight(390.0D);
        this.window.setMaxHeight(390.0D);

        GridPane loginGrid = new GridPane();
        loginGrid.setAlignment(Pos.CENTER);
        loginGrid.setHgap(10);
        loginGrid.setVgap(10);
        loginGrid.setPadding(new Insets(5, 10, 5, 10));
        loginGrid.setId("loginPage");

        final Label scenetitle = new Label("Login to Data Collector");
        scenetitle.setMaxWidth(Double.MAX_VALUE);
        scenetitle.setAlignment(Pos.CENTER);
        scenetitle.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        scenetitle.setPadding(new Insets(25, 25, 25, 25));
        loginGrid.add(scenetitle, 0, 0, 2, 1);


        Label userName = new Label("Login");
        final TextField txtUserName = new TextField();
        txtUserName.setId("userNameInput");

        //password field
        // text field to show password as unmasked
        final TextField passTextField = new TextField();
        passTextField.setManaged(false);
        passTextField.setVisible(false);

        // Actual password field
        final PasswordField passwordField = new PasswordField();
        passwordField.setId("passwordField");

        CheckBox checkBox = new CheckBox("Show/Hide password");
        passTextField.managedProperty().bind(checkBox.selectedProperty());
        passTextField.visibleProperty().bind(checkBox.selectedProperty());

        passwordField.managedProperty().bind(checkBox.selectedProperty().not());
        passwordField.visibleProperty().bind(checkBox.selectedProperty().not());

        // Bind the textField and passwordField text values bidirectionally.
        passTextField.textProperty().bindBidirectional(passwordField.textProperty());

        VBox passwordFieldvbox = new VBox(10);
        passwordFieldvbox.getChildren().addAll(passwordField, passTextField);
        Label lblPassword = new Label("Password");

        //Login Button
        Button btnLogin = new Button("Login");
        btnLogin.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_CENTER);
        hbBtn.setPadding(new Insets(10, 5, 5, 5));
        hbBtn.getChildren().add(btnLogin);

        //Optional auth status
        final Label lblMessage = new Label();
        lblMessage.setMaxWidth(Double.MAX_VALUE);
        lblMessage.setAlignment(Pos.CENTER);
        lblMessage.setTextFill(Color.FIREBRICK);

        // Adding nodes to Login grid
        loginGrid.add(userName, 0, 1);
        loginGrid.add(txtUserName, 1, 1);
        loginGrid.add(lblPassword, 0, 2);
        loginGrid.add(passwordFieldvbox, 1, 2);
        loginGrid.add(checkBox, 1, 3);
        loginGrid.add(hbBtn, 1, 4);
        loginGrid.add(lblMessage, 1, 5);

        btnLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Button Clicked");
            }
        });


        //loginGrid.setGridLinesVisible(true);

        this.window.setScene(new Scene(loginGrid));
        this.window.show();


    }
}
