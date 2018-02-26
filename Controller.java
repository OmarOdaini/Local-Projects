package sample;

import java.awt.*;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.event.*;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;



public class Controller {
    @FXML
    private TextField zipInput;

    @FXML
    private Button search;

    @FXML
    private TextField resultLabel;

    public void btnSearch(){
        String zipCode = zipInput.getText();
        String[] result = new String[2];
        result = excel_read.readExcelFile(Integer.parseInt(zipCode));
        resultLabel.setText(result[0] + ", " + result[1]);

    }




}
