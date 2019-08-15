
public class Exercicio1 {
	
	
	public void farenheitToCelsius(float f1, float f2) {
		System.out.println("Farenheit |  Celsius");		
		for(float i = f1; i <= f2; i++) {
			
			float c =  (i - 32)*5/9;
			System.out.println(i + "\t | \t " + c);
		}
	}
	
	
	public static void main(String[] args) {
		
		Exercicio1 e = new Exercicio1();
		
		e.farenheitToCelsius(50, 150);
		
		
	}

}
