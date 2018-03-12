package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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
    ListView sec1list,sec2list,sec3list,sec4list,sec5list,sec6list,sec7list,sec8list;
    @FXML
    TextArea tut,desc;
    @FXML
    TextField srcBar;
    @FXML
    Button searchbtn;
    @FXML
    Button helpbtn;

    ObservableList<String> list1 = FXCollections.observableArrayList ();
    ObservableList<String> list2 = FXCollections.observableArrayList ();
    ObservableList<String> list3 = FXCollections.observableArrayList ();
    ObservableList<String> list4 = FXCollections.observableArrayList ();
    ObservableList<String> list5 = FXCollections.observableArrayList ();
    ObservableList<String> list6 = FXCollections.observableArrayList ();
    ObservableList<String> list7 = FXCollections.observableArrayList ();
    ObservableList<String> list8 = FXCollections.observableArrayList ();
    HashMap<String,String> descList = new HashMap<String,String>(); //id = key desc = value
    HashMap<String,String> tutList = new HashMap<String,String>(); // id = key tut = value

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //System.out.println("");
        desc.setEditable(false);
        tut.setEditable(false);
        //tut.setDisable(true);
        //desc.setDisable(true);

       String tuttext =  "Welcome to the Unix Man page helper! \n On the right you will see 8 sections based on the general \nfunctions of the commands: \n " +
                "introduction to user commands\n" +
                "introduction to system calls\n" +
                "introduction to library functions\n" +
                "introduction to special files\n" +
                "introduction to file formats and filesystems\n" +
                "introduction to games\n" +
                "introduction to overview, conventions, and miscellany section\n" +
                "introduction to administration and privileged commands\n" +
                "Each section has a drop down list of all the commands. \nIf you hover over the command you can read a brief \ndescription on the command in the box above. \n" +
                "If you select the command you can view an in depth \ntutorial on what the command does and how to implement it.\n " +
                "To quickly search a command you can type it into the search bar and \nhit search to receive a tutorial on it as well. \n(If it doesn't pop up you are propably spelling the command wrong) \n" +
                "When ever you need help hit the 'help' button";
        String desctext = "All descriptions and tutorials are from https://www.freebsd.org/";

        desc.setText(desctext);

        tut.setText(tuttext);
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


                    switch(section){
                        case("1"):
                            list1.add(id);
                            sec1list.setItems(list1);
                            sec1list.setCellFactory(lv -> {
                                ListCell<String> cell = new ListCell<String>(){

                                    //super();
                                    @Override
                                    public void updateItem(String string, boolean empty) {
                                        super.updateItem(string, empty);
                                        if (empty) {
                                            setText(null);
                                        } else {
                                            setText(id);
                                        }
                                    }
                                };
                                cell.hoverProperty().addListener((obs, wasHovered, isNowHovered) -> {
                                    if (isNowHovered && !cell.isEmpty()) {
                                        desc.setText(descList.get(cell.getText()));
                                    } else {
                                        //desc.setText("NONE");
                                    }
                                });
                                return cell ;
                            });
                            break;
                        case("2"):
                            list2.add(id);
                            sec2list.setItems(list2);
                            sec2list.setCellFactory(lv -> {
                                ListCell<String> cell = new ListCell<String>(){

                                    //super();
                                    @Override
                                    public void updateItem(String string, boolean empty) {
                                        super.updateItem(string, empty);
                                        if (empty) {
                                            setText(null);
                                        } else {
                                            setText(id);
                                        }
                                    }
                                };
                                cell.hoverProperty().addListener((obs, wasHovered, isNowHovered) -> {
                                    if (isNowHovered && !cell.isEmpty()) {
                                        desc.setText(descList.get(cell.getText()));
                                    } else {
                                       // desc.setText("NONE");
                                    }
                                });
                                return cell ;
                            });
                            break;
                        case("3"):
                            //section3.getChildren().add(anode);
                            list3.add(id);
                            sec3list.setItems(list3);
                            sec3list.setCellFactory(lv -> {
                                ListCell<String> cell = new ListCell<String>(){

                                    //super();
                                    @Override
                                    public void updateItem(String string, boolean empty) {
                                        super.updateItem(string, empty);
                                        if (empty) {
                                            setText(null);
                                        }
                                        else {
                                            setText(id);
                                        }
                                    }
                                };
                                cell.hoverProperty().addListener((obs, wasHovered, isNowHovered) -> {
                                    if (isNowHovered && !cell.isEmpty()) {
                                        desc.setText(descList.get(cell.getText()));
                                    } else {
                                       // desc.setText("NONE");
                                    }
                                });
                                return cell ;
                            });
                            break;
                        case("4"):
                            list4.add(id);
                            sec4list.setItems(list4);
                            sec4list.setCellFactory(lv -> {
                                ListCell<String> cell = new ListCell<String>(){
                                    @Override
                                    public void updateItem(String string, boolean empty) {
                                        super.updateItem(string, empty);
                                        if (empty) {
                                            setText(null);
                                        } else {
                                            setText(id);
                                        }
                                    }
                                };
                                cell.hoverProperty().addListener((obs, wasHovered, isNowHovered) -> {
                                    if (isNowHovered && !cell.isEmpty()) {
                                        desc.setText(descList.get(cell.getText()));
                                    } else {
                                       // desc.setText("NONE");
                                    }
                                });
                                return cell ;
                            });
                            break;
                        case("5"):
                            list5.add(id);
                            sec5list.setItems(list5);
                            sec5list.setCellFactory(lv -> {
                                ListCell<String> cell = new ListCell<String>(){

                                    //super();
                                    @Override
                                    public void updateItem(String string, boolean empty) {
                                        super.updateItem(string, empty);
                                        if (empty) {
                                            setText(null);
                                        } else {
                                            setText(id);
                                        }
                                    }
                                };
                                cell.hoverProperty().addListener((obs, wasHovered, isNowHovered) -> {
                                    if (isNowHovered && !cell.isEmpty()) {
                                        desc.setText(descList.get(cell.getText()));
                                    } else {
                                       // desc.setText("NONE");
                                    }
                                });
                                return cell ;
                            });
                            break;
                        case("6"):
                            list6.add(id);
                            sec6list.setItems(list6);
                            sec6list.setCellFactory(lv -> {
                                ListCell<String> cell = new ListCell<String>(){

                                    //super();
                                    @Override
                                    public void updateItem(String string, boolean empty) {
                                        super.updateItem(string, empty);
                                        if (empty) {
                                            setText(null);
                                        } else {
                                            setText(id);
                                        }
                                    }
                                };
                                cell.hoverProperty().addListener((obs, wasHovered, isNowHovered) -> {
                                    if (isNowHovered && !cell.isEmpty()) {
                                        desc.setText(descList.get(cell.getText()));
                                    } else {
                                        //desc.setText("NONE");
                                    }
                                });
                                return cell ;
                            });
                            break;
                        case("7"):
                            list7.add(id);
                            sec7list.setItems(list7);
                            sec7list.setCellFactory(lv -> {
                                ListCell<String> cell = new ListCell<String>(){

                                    //super();
                                    @Override
                                    public void updateItem(String string, boolean empty) {
                                        super.updateItem(string, empty);
                                        if (empty) {
                                            setText(null);
                                        } else {
                                            setText(id);
                                        }
                                    }
                                };
                                cell.hoverProperty().addListener((obs, wasHovered, isNowHovered) -> {
                                    if (isNowHovered && !cell.isEmpty()) {
                                        desc.setText(descList.get(cell.getText()));
                                    } else {
                                       // desc.setText("NONE");
                                    }
                                });
                                return cell ;
                            });
                            break;
                        case("8"):
                            list8.add(id);
                            sec8list.setItems(list8);
                            sec8list.setCellFactory(lv -> {
                                ListCell<String> cell = new ListCell<String>(){

                                    //super();
                                    @Override
                                    public void updateItem(String string, boolean empty) {
                                        super.updateItem(string, empty);
                                        if (empty) {
                                            setText(null);
                                        } else {
                                            setText(id);
                                        }
                                    }
                                };
                                cell.hoverProperty().addListener((obs, wasHovered, isNowHovered) -> {
                                    if (isNowHovered && !cell.isEmpty()) {
                                        desc.setText(descList.get(cell.getText()));
                                    } else {
                                       // desc.setText("NONE");
                                    }
                                });
                                return cell ;
                            });
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
                        }
                    }
                }
            }
            //error handlers
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        helpbtn.setOnAction((event -> {
            desc.setText(desctext);
            tut.setText(tuttext);
        }));

        searchbtn.setOnAction((event -> {
            if(srcBar.getText().equals("")){
                desc.setText(desctext);
                tut.setText(tuttext);
            }
            else if(!descList.containsKey(srcBar.getText())){
                desc.setText("Sorry That Command Doesn't Exist.");
            }
            else{
                desc.setText(descList.get(srcBar.getText()));
                tut.setText(tutList.get(srcBar.getText()));
            }
        }));
    }


    public void mouseClicklist1(MouseEvent mouseEvent ){
        tut.setText(tutList.get(sec1list.getSelectionModel().getSelectedItem()));
    }

    public void mouseClicklist2(MouseEvent mouseEvent ){
        tut.setText(tutList.get(sec2list.getSelectionModel().getSelectedItem()));
    }

    public void mouseClicklist3(MouseEvent mouseEvent ){
        tut.setText(tutList.get(sec3list.getSelectionModel().getSelectedItem()));
    }

    public void mouseClicklist4(MouseEvent mouseEvent ){
            tut.setText(tutList.get(sec4list.getSelectionModel().getSelectedItem()));
    }

    public void mouseClicklist5(MouseEvent mouseEvent ){
            tut.setText(tutList.get(sec5list.getSelectionModel().getSelectedItem()));
    }

    public void mouseClicklist6(MouseEvent mouseEvent ){
            tut.setText(tutList.get(sec6list.getSelectionModel().getSelectedItem()));
    }

    public void mouseClicklist7(MouseEvent mouseEvent ){
            tut.setText(tutList.get(sec7list.getSelectionModel().getSelectedItem()));
    }

    public void mouseClicklist8(MouseEvent mouseEvent ){
            tut.setText(tutList.get(sec8list.getSelectionModel().getSelectedItem()));
    }



}
