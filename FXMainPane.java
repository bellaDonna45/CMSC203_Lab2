package guilabpackage;




import javafx.application.Platform;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	Button btnHello, btnHowdy, btnChinese, btnClear, btnExit, btnJapanese;
    Label lab;
    TextField txt;
	//  declare two HBoxes
    HBox hBox1, hBox2;

	//student Task #4:
	//  declare an instance of DataManager
    DataManager data;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		//  instantiate the HBoxes
		btnHello = new Button("Hello");
        btnHowdy = new Button("Howdy");
        btnChinese = new Button("Chinese");
        btnClear = new Button("Clear");
        btnExit = new Button("Exit");
        btnJapanese = new Button("Japanese");

        lab = new Label("Feedback:");

        txt = new TextField();

        hBox1 = new HBox();
        hBox2 = new HBox();

		//student Task #4:
		//  instantiate the DataManager instance
		//  set margins and set alignment of the components
        data = new DataManager();
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		//  add the buttons to the other HBox
		//  add the HBoxes to this FXMainPanel (a VBox)
        hBox1.getChildren().addAll(btnHello, btnHowdy, btnChinese, btnClear, btnExit, btnJapanese);
        hBox2.getChildren().addAll(lab, txt);
        this.getChildren().addAll(hBox1, hBox2);
        
        Insets inset = new Insets(10);
        HBox.setMargin(btnHello, inset);
        HBox.setMargin(btnHowdy, inset);
        HBox.setMargin(btnChinese, inset);
        HBox.setMargin(btnClear, inset);
        HBox.setMargin(btnExit, inset);
        HBox.setMargin(btnJapanese, inset);

        btnHello.setOnAction(new ButtonHandler());
        btnHowdy.setOnAction(new ButtonHandler());
        btnChinese.setOnAction(new ButtonHandler());
        btnClear.setOnAction(new ButtonHandler());
        btnExit.setOnAction(new ButtonHandler());
        btnJapanese.setOnAction(new ButtonHandler());
		
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	private class ButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            Object source = event.getTarget(); // Get the button that was clicked

            if (source == btnHello) {
                txt.setText(data.getHello());
            } else if (source == btnHowdy) {
                txt.setText(data.getHowdy());
            } else if (source == btnChinese) {
                txt.setText(data.getChinese());
            } else if (source == btnClear) {
                txt.setText(""); // Clear the text field
            } else if (source == btnExit) {
                Platform.exit(); // Exit JavaFX application
                System.exit(0);  // Exit the program
            }
            else if (source == btnJapanese) {
                txt.setText(data.getJapanese());
            }
        }
    }
}
	
