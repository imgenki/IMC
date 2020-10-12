package dad.javafx.imc;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class IMC {
	private DoubleProperty altura = new SimpleDoubleProperty();
	private DoubleProperty peso = new SimpleDoubleProperty();
	private DoubleProperty imc = new SimpleDoubleProperty();
	
	public final DoubleProperty alturaProperty() {
		return altura;
	}
	
	public final double getAltura() {
		return this.alturaProperty().get();
		
	}
	
	public final void setAltura(double altura) {
		this.alturaProperty().set(altura/100);
	}
	
	public final DoubleProperty pesoProperty() {
		return peso;
	}
	
	public final double getPeso() {
		return this.pesoProperty().get();
	}
	
	public final void setPeso(double peso) {
		this.pesoProperty().set(peso);
	}
	
	public final DoubleProperty imcProperty() {
		return imc;
	}
	
	public final double getIMC() {
		return this.imcProperty().get();
	}
	public final void setIMC() {
		this.imcProperty().set(getPeso()/(Math.pow(getAltura(), 2)));
	}
}
