package dad.javafx.imc;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class Aplicacion extends Application {
	private TextField pesoText, alturaText;
	private Label pesoLabel1, pesoLabel2, alturaLabel1, alturaLabel2, imcLabel1, imcLabel2, pesoLabel;
	private IMC imc = new IMC();

	public void start(Stage primaryStage) throws Exception {

		// Campo de texto Peso
		pesoLabel1 = new Label("Peso:");
		pesoLabel1.setAlignment(Pos.CENTER_LEFT);
		pesoText = new TextField();
		pesoText.setPrefColumnCount(4);
		pesoLabel2 = new Label("kg");
		pesoLabel2.setAlignment(Pos.CENTER_RIGHT);

		// HBOX Peso
		HBox pesoBox = new HBox();
		pesoBox.setAlignment(Pos.BASELINE_CENTER);
		pesoBox.setSpacing(5);
		pesoBox.getChildren().addAll(pesoLabel1, pesoText, pesoLabel2);

		// Campo de texto Altura
		alturaLabel1 = new Label("Altura:");
		alturaLabel1.setAlignment(Pos.CENTER_LEFT);
		alturaText = new TextField();
		alturaText.setPrefColumnCount(4);
		alturaLabel2 = new Label("cm");
		alturaLabel2.setAlignment(Pos.CENTER_LEFT);

		// HBOX Altura
		HBox alturaBox = new HBox();
		alturaBox.setAlignment(Pos.BASELINE_CENTER);
		alturaBox.setSpacing(5);
		alturaBox.getChildren().addAll(alturaLabel1, alturaText, alturaLabel2);

		// label imc
		imcLabel1 = new Label("IMC: ");
		imcLabel2 = new Label("(peso/altura^2)");

		// HBOX resultadoNum
		HBox resultadoNumBox = new HBox(imcLabel1, imcLabel2);
		resultadoNumBox.setAlignment(Pos.BASELINE_CENTER);

		// label peso
		pesoLabel = new Label("Bajo Peso | Normal | Sobrepeso | Obeso");

		// HBOX resultadoPeso
		HBox resultadoPeso = new HBox(pesoLabel);
		resultadoPeso.setAlignment(Pos.BASELINE_CENTER);
		
		// Caja principal
		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(pesoBox, alturaBox, resultadoNumBox, resultadoPeso);

		Scene escena = new Scene(root, 320, 200);

		primaryStage.setScene(escena);
		primaryStage.setTitle("Calcular IMC");
		primaryStage.show();

		// bind de peso
		pesoText.textProperty().bindBidirectional(imc.pesoProperty(), new NumberStringConverter());

		// bind de altura
		alturaText.textProperty().bindBidirectional(imc.alturaProperty(), new NumberStringConverter());

		//imc
		
		imc.imcProperty().bind(imc.pesoProperty().divide((imc.alturaProperty().divide(100)).multiply(imc.alturaProperty().divide(100))));
		
		// bind imc
		imcLabel2.textProperty().bind(imc.imcProperty().asString("%.2f"));
		
		//Listener Resultado peso
		imcLabel2.textProperty().addListener(e -> {
			if (imc.imcProperty().doubleValue() < 18.5)
				pesoLabel.setText(Pesos.BAJOPESO.getString());
			else if (imc.imcProperty().doubleValue() >= 18.5 && imc.imcProperty().doubleValue() < 25)
				pesoLabel.setText(Pesos.NORMAL.getString());
			else if (imc.imcProperty().doubleValue() >= 25 && imc.imcProperty().doubleValue() < 30)
				pesoLabel.setText(Pesos.SOBREPESO.getString());
			else if (imc.imcProperty().doubleValue() > 30)
				pesoLabel.setText(Pesos.OBESO.getString());
		});

	}

	public static void main(String[] args) {
		launch(args);
	}

}