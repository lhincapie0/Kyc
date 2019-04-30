package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class InsertWViewController {

	
	@FXML
	private Button ejecutarBut;

	@FXML
	private TextField chainTxt;
	
	@FXML
	private TextArea resultTxt;
	
	
	@FXML
	private Button ingresarGic;
	public void ejecutar()
	{
		resultTxt.setText(Main.ejecutar(chainTxt.getText()));
		chainTxt.clear();
	}
}
