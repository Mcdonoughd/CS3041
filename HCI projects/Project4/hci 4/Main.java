package sample;
import javafx.application.Application;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main extends Application {
    //xml input file
    static String url = "xml.xml";
    public static void main(String[] args) {
        //launch app
    Application.launch(Main.class,args);
}

    @Override
    public void start(Stage window) throws Exception {
        //load base fxml
        Parent root = FXMLLoader.load(Main.class.getResource("/view/BasicApplication.fxml"));
        Scene scene = new Scene(root, 1404, 800);
        //load css
        scene.getStylesheets().add(getClass().getResource("/view/BasicApplication.css").toExternalForm() );
        window.setTitle("Unix Manual");
        window.setScene(scene);
        window.show();
    }
}
