package dad.javafx.imc;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class IMC {
	private DoubleProperty altura = new SimpleDoubleProperty();
	private DoubleProperty peso = new SimpleDoubleProperty();
	private DoubleProperty imc = new SimpleDoubleProperty();
	public final DoubleProperty alturaProperty() {
		return this.altura;
	}
	
	public final double getAltura() {
		return this.alturaProperty().get();
	}
	
	public final void setAltura(final double altura) {
		this.alturaProperty().set(altura);
	}
	
	public final DoubleProperty pesoProperty() {
		return this.peso;
	}
	
	public final double getPeso() {
		return this.pesoProperty().get();
	}
	
	public final void setPeso(final double peso) {
		this.pesoProperty().set(peso);
	}
	
	public final DoubleProperty imcProperty() {
		return this.imc;
	}
	
	public final double getImc() {
		return this.imcProperty().get();
	}
	
	public final void setImc(final double imc) {
		this.imcProperty().set(imc);
	}
	
	
}
