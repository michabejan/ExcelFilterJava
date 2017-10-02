import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.xmlbeans.StringEnumAbstractBase;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by bejan on 13.02.2017.
 */
public class Main extends Application {

   
    String absolutePath = "";
    private TableView table = new TableView();
    ObservableList<Donator> l = null;

    public static void main(String[] args){

        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) throws Exception{
        primaryStage.setTitle("Huhu");
        TextField filterField = new TextField("Filter");
        Label label2 = new Label();
        label2.setText("lala");
        final FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");



        final Button openButton = new Button("Dateipfad öffner");
      

  
        StackPane layout = new StackPane();
        

        Scene scene = new Scene(new Group());
        primaryStage.setTitle("Table View Sample");
        primaryStage.setWidth(1500);
        primaryStage.setHeight(800);

        final Label label = new Label("Klaus sein Programm");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn<Donator, String> addressCol = new TableColumn<Donator, String>();
        addressCol.setCellValueFactory(new PropertyValueFactory<Donator,String>("address"));
        addressCol.setText("Anrede");
        TableColumn<Donator, String> titleCol = new TableColumn<Donator, String>();
        titleCol.setCellValueFactory(new PropertyValueFactory<Donator,String>("title"));
        titleCol.setText("Titel");
        TableColumn<Donator, String> firstNameCol = new TableColumn<Donator, String>();
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Donator,String>("firstname"));
        firstNameCol.setText("Vorname");

        TableColumn<Donator, String> lastNameCol = new TableColumn<Donator, String>();
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Donator,String>("surname"));
        lastNameCol.setText("Nachname");

        TableColumn<Donator, String> streetCol = new TableColumn<Donator, String>();
        streetCol.setCellValueFactory(new PropertyValueFactory<Donator,String>("street"));
        streetCol.setText("StraÃŸe");

        TableColumn<Donator, String> postalCodeCol = new TableColumn<Donator, String>();
        postalCodeCol.setCellValueFactory(new PropertyValueFactory<Donator,String>("postalcode"));
        postalCodeCol.setText("Postleihzahl");
        TableColumn<Donator, String> locationCol = new TableColumn<Donator, String>();
        locationCol.setCellValueFactory(new PropertyValueFactory<Donator,String>("location"));
        locationCol.setText("Ort");
        TableColumn<Donator, String> whereCol = new TableColumn<Donator, String>();
        whereCol.setCellValueFactory(new PropertyValueFactory<Donator,String>("where"));
        whereCol.setText("Wo");

        TableColumn<Donator, String> howMuchCol = new TableColumn<Donator, String>();
        howMuchCol.setCellValueFactory(new PropertyValueFactory<Donator,String>("howMuch"));
        howMuchCol.setText("Wie viel");
        TableColumn<Donator, String> once = new TableColumn<Donator, String>();
        once.setCellValueFactory(new PropertyValueFactory<Donator,String>("once"));
        once.setText("Einmalig");
        TableColumn<Donator, String> multiple = new TableColumn<Donator, String>();
        multiple.setCellValueFactory(new PropertyValueFactory<Donator,String>("multiple"));
        multiple.setText("mehrmals");
        TableColumn<Donator, String> extra = new TableColumn<Donator, String>();
       extra.setCellValueFactory(new PropertyValueFactory<Donator,String>("extra"));
        extra.setText("Extra");
        TableColumn<Donator, String> emailCol = new TableColumn<Donator, String>();
        emailCol.setCellValueFactory(new PropertyValueFactory<Donator,String>("email"));
        emailCol.setText("Email");
        TableColumn<Donator, String> phoneCol = new TableColumn<Donator, String>();
        phoneCol.setCellValueFactory(new PropertyValueFactory<Donator,String>("phone"));
        phoneCol.setText("Telefon");




      //  absolutePath = "C:/Users/bejan/Desktop/lala.xlsx";
      //  System.out.println(absolutePath);


        openButton.setOnAction(
                new EventHandler<ActionEvent>() {

                    public void handle(final ActionEvent e) {
                        File file = fileChooser.showOpenDialog(primaryStage);
                        absolutePath = file.getAbsolutePath();
                        l = excelToJava.readExcelData(absolutePath);
               


        // 1. Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Donator> filteredData = new FilteredList<>(l, p -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        filterField.setOnKeyReleased(k->
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(donator -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (donator.getFirstname().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } else if (donator.getSurname().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                }else if (donator.getLocation().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }else if (donator.getAddress().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }else if (donator.getPostalcode() != null){if (donator.getPostalcode().toLowerCase().contains(lowerCaseFilter)) 
                    return true;
                }
                else if (donator.getExtra() != null){ if (donator.getExtra().toLowerCase().contains(lowerCaseFilter)) 
                    return true;
                
                }else if(donator.getEmail() != null){if(donator.getEmail().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                } else if(donator.getWhere() != null){
                	if (donator.getWhere().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                }
                }
                return false; // Does not match.
            });
        })  );


        SortedList<Donator> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(table.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.


     

        table.getColumns().addAll(addressCol,titleCol,firstNameCol, lastNameCol,streetCol,postalCodeCol,locationCol, emailCol,phoneCol,whereCol,extra,howMuchCol,once,multiple);
        table.setItems(sortedData);
                    }
                });
        table.setPrefWidth(1800);
        table.setPrefHeight(600);
        final VBox vbox = new VBox();
        vbox.setPrefWidth(1800);
        
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);
        vbox.getChildren().add(filterField);

        vbox.getChildren().add(openButton);
      


        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setScene(scene);
        primaryStage.show();

    }



}
