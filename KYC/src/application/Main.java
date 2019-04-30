package application;
	
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.GIC;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {




	private static Stage primaryStage;
	private static BorderPane mainLayout;
	private static GIC grammar;
	
	private static int count;


	
/**
 * Loads the main window
 * @return
 */
	@Override
	public void start(Stage primaryStage) throws IOException, InterruptedException, ClassNotFoundException {
		
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Equivalencia de Máquinas");
		showMain();
	   showMainView();
		
	}
	
	
	public static void showMain() throws IOException
	{
		FXMLLoader loader = new  FXMLLoader();
		loader.setLocation(Main.class.getResource("MainLayout.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	
	}

	public static void showMainView() throws IOException
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("MainView.fxml"));
		BorderPane a = loader.load();
		mainLayout.setCenter(a);
	}
	
	public static void ingresarMaquina(String no_estados) throws IOException
	{
		int num = Integer.parseInt(no_estados);
		grammar = new GIC(num);
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("Insert.fxml"));
		AnchorPane a = loader.load();
		mainLayout.setCenter(a);
	}
	
	public static void addVariable(String name, String production) throws IOException
	{
		count++;
		grammar.addVariable(name, production);
		if(count<grammar.getNo_Variables())
		{
				
		}
		else {
			insertW();
		}
	}
	
	public static String  ejecutar(String chain)
	{
		boolean result = grammar.evaluate(chain);
		String a;
		if(result)
		{
			 a = "La cadena: "+chain+ " es generada por la gramatica";
		}else {
			 a = "La cadena: "+chain+ " no es generada por la gramatica";
		}
		return a;
	}
	
	public static void insertW() throws IOException
	{
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("InsertW.fxml"));
		AnchorPane a = loader.load();
		mainLayout.setCenter(a);
	}
	
	public static String GICtoString()
	{
		return grammar.toString();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
