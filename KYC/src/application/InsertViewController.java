package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class InsertViewController {

	
	@FXML
	private TextField nameTxt;
	
	@FXML
	private TextField productionsTxt;
	
	@FXML
	private TextArea gic;
	
	@FXML
	private Button addBut;
	
	
	public void add() throws IOException
	{
		Main.addVariable(nameTxt.getText(), productionsTxt.getText());
		gic.setText(Main.GICtoString());
		nameTxt.clear();
		productionsTxt.clear();
	}
	
}
