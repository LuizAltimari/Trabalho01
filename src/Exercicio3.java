import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Exercicio3 {
	
	private int numero;
	private double notaProvisoria;
	private double notaFinal;
	private Date entrega;
	private String dataEntrega;
	
	SimpleDateFormat formato = new SimpleDateFormat("dd/MM");
	
	
	private void calculaNotaFinal() {		
		try {
			Date primeriaData = formato.parse("20/04");
			Date segundaData = formato.parse("02/05"); 
			Date terceiraData = formato.parse("30/05");
			Date quartaData = formato.parse("30/06");
			if(this.entrega.before(primeriaData) || this.entrega.equals(primeriaData)) {
				this.notaFinal = this.notaProvisoria + 10;
			}
			else if(this.entrega.after(primeriaData) && (this.entrega.before(segundaData) || this.entrega.equals(segundaData))) {
				this.notaFinal = this.notaProvisoria;
			} else if (this.entrega.after(segundaData) && (this.entrega.before(terceiraData) || this.entrega.equals(terceiraData))) {
				this.notaFinal = this.notaProvisoria / 2;
			} else if (this.entrega.after(terceiraData) && (this.entrega.before(quartaData) || this.entrega.equals(quartaData))) {
				this.notaFinal = 0;
			} else { this.notaFinal = 0; }
			
		} catch (ParseException e) {		
			e.printStackTrace();
		}				
	}
	
	private double media(double [] notas) {
		double soma = 0;
		
		for(int i = 0; i < notas.length; i++) {
			soma += notas[i];
		}
		
		return soma / notas.length;
	}
	
	
	private double desvioPadrao(double [] notas) {
		double somatorio1 = 0;
		double somatorio2 = 0;
		for(int i = 0; i < notas.length; i++) {
			somatorio1 += Math.pow(notas[i], 2) ;
			somatorio2 += notas[i];
		}
					
		double ds = (somatorio1 - (Math.pow(somatorio2, 2)/notas.length)) / (notas.length -1);
		return Math.sqrt(ds);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			
			SimpleDateFormat f = new SimpleDateFormat("dd/MM");
			ArrayList<Exercicio3> alunos = new ArrayList<Exercicio3>();
			Exercicio3 geral = new Exercicio3();
			double notasProvisorias [] = new double [10];
			double notasFinais [] = new double [10];
			
			for(int i = 0; i < 10; i++) {
				alunos.add(new Exercicio3());
				System.out.print("Informe o número do aluno: ");
				alunos.get(i).numero = sc.nextInt();
				System.out.print("Informe a nota provisória: ");
				alunos.get(i).notaProvisoria = sc.nextDouble();
				System.out.print("Informe data de entrega(dd/MM): ");
				sc.nextLine();
				alunos.get(i).dataEntrega = sc.nextLine();
				alunos.get(i).entrega = f.parse(alunos.get(i).dataEntrega);
				
				alunos.get(i).calculaNotaFinal();
				
				notasFinais[i] = alunos.get(i).notaFinal; 
				notasProvisorias[i] = alunos.get(i).notaProvisoria;
				
				System.out.println("\n+------------------------+ \n" + 
						"+------------------------+ \n");
			}
			System.out.println("+-----------RESULTADOS-------------+ \n");
			for(int i = 0; i < alunos.size(); i++) {
				System.out.println("Número do aluno: " + alunos.get(i).numero);
				System.out.println("Nota final do aluno: " + alunos.get(i).notaFinal);
				
				System.out.println("\n+------------------------+ \n" + 
						"+------------------------+ \n");
			}
			
			System.out.println("Média das notas provisórias: " + geral.media(notasProvisorias));
			System.out.println("Desvio padrão das notas provisórias: " + geral.desvioPadrao(notasProvisorias));
			System.out.println("Média das notas finais: " + geral.media(notasFinais));
			System.out.println("Desvio padrão das notas finais: " + geral.desvioPadrao(notasFinais));
			
			
		} catch (ParseException e) {		
			e.printStackTrace();
		}finally {
			sc.close();
		}	
		                              
	}
}
