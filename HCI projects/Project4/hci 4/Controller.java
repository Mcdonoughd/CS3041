package sample;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import static sample.Main.url;

/**
 * Created by dannm on 4/5/2017.
 */
public class Controller implements Initializable {
    @FXML
    TreeView<String> treeview;
    @FXML
    Text tut;
    @FXML
    Text desc;
    TreeItem<String> root;
    TreeItem<String> section1;
    TreeItem<String> section2;
    TreeItem<String> section3;
    TreeItem<String> section4;
    TreeItem<String> section5;
    TreeItem<String> section6;
    TreeItem<String> section7;
    TreeItem<String> section8;
    HashMap<String,String> descList = new HashMap<String,String>(); //id = key desc = value
    HashMap<String,String> tutList = new HashMap<String,String>(); // id = key tut = value

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        TreeItem<String> root = new TreeItem<>("root");
        TreeItem<String> section1 = new TreeItem("General Commands");
        TreeItem<String> section2 = new TreeItem("System Calls");
        TreeItem<String> section3 = new TreeItem("Library Functions");
        TreeItem<String> section4 = new TreeItem("Special Files");
        TreeItem<String> section5 = new TreeItem("File Formats");
        TreeItem<String> section6 = new TreeItem("Games & Screensavers");
        TreeItem<String> section7 = new TreeItem("Miscellanea");
        TreeItem<String> section8 = new TreeItem("System Administration");
        root.getChildren().addAll(section1,section2,section3,section4,section5,section6,section7,section8);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            //reads XML and adds description and tutorials into a hashmap
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document D = db.parse(url);
            //get all elements labled by command
            NodeList CommandList = D.getElementsByTagName("command");
            //get their id & section
            for (int i = 0; i < CommandList.getLength(); i++) {
                Node acommand = CommandList.item(i);
                if (acommand.getNodeType() == Node.ELEMENT_NODE) {
                    Element command = (Element) acommand;
                    String id = command.getAttribute("id"); //name of command
                    String section = command.getAttribute("Section"); //command section
                    TreeItem<String> anode = new TreeItem(id);
                    switch(section){
                        case("1"):
                            section1.getChildren().add(anode);
                            break;
                        case("2"):
                            section2.getChildren().add(anode);
                            break;
                        case("3"):
                            section3.getChildren().add(anode);
                            break;
                        case("4"):
                            section4.getChildren().add(anode);
                            break;
                        case("5"):
                            section5.getChildren().add(anode);
                            break;
                        case("6"):
                            section6.getChildren().add(anode);
                            break;
                        case("7"):
                            section7.getChildren().add(anode);
                            break;
                        case("8"):
                            section8.getChildren().add(anode);
                            break;
                        default:
                            System.out.println("Please Add a Valid Section Attribute to "+ id);
                            break;
                    }
                    //get description and tutorial
                    NodeList namelist = command.getChildNodes();
                    for (int j = 0; j < namelist.getLength(); j++) {
                        Node n = namelist.item(j);
                        if (n.getNodeType() == Node.ELEMENT_NODE) {
                            Element name = (Element) n;

                            if(name.getTagName().equals("description")){
                                descList.put(id,name.getTextContent());
                            }
                            else if(name.getTagName().equals("tutorial")){
                                tutList.put(id,name.getTextContent());
                            }
                            else{
                                System.out.println("ERROR UNKNOWN ELEMENT");
                            }
                            //text = name.getTextContent();
                            //System.out.println("Command " + id + ":" + name.getTagName() + "=" + name.getTextContent());
                        }
                    }
                }
                treeview.setRoot(root);
                treeview.setShowRoot(false);
            }
            //error handlers
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public void mouseClick(MouseEvent mouseEvent ){
        TreeItem<String> item = treeview.getSelectionModel().getSelectedItem();
        if(mouseEvent.getClickCount()==2) {
            System.out.println(item.getValue());
            tut.setText(tutList.get(item.getValue()));
            desc.setText(descList.get(item.getValue()));
        }
    }
}
