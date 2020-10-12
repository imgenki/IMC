package dad.javafx.imc;

public enum Pesos {
	BAJOPESO("Bajo Peso"),
	NORMAL("Normal"), 
	SOBREPESO("Sobrepeso"), 
	OBESO("Obeso");
	private final String string;
	
	Pesos(String st){
		this.string = st;
	}
	
	public String getString() {
		return string;
	}
}
