package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainViewController {

	
	@FXML
	private Button ingresarBut;
	
	@FXML
	private TextField no_estados;
	
	public void ingresarBut() throws IOException
	{
		Main.ingresarMaquina(no_estados.getText());
	}
}
