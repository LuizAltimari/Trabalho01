import java.util.ArrayList;
import java.util.Scanner;

public class Exercicio2 {
	
	private double nota1;
	private double nota2;
	private double nota3;
	private double media;
	private int matricula;
	private int frequencia;	
	private String situacao;
	
	public double calculaMedia() {
		this.media = (this.nota1 + this.nota2  + this.nota3)/3;
		return this.media;
	}
	
	public void aprovacao() {
		if (this.media >= 6 && this.frequencia >= 40) {
			this.situacao =  "APROVADO";
		} else if (this.media < 6) {
			this.situacao = "REPROVADO POR NOTA";
		}else if (this.frequencia < 40){
			this.situacao = "REPROVADO POR INFREQUÊNCIA";
		}
	}
	
	public double maiorNota(double notas[]) {
		double maior = 0;
		
		for(int i = 0; i < notas.length; i++) {
			if(i == 0) {
				maior = notas[i];
			}
			else if (notas[i] > maior) {
					maior = notas[i];
			} 
		}				
		
		return maior;
	}
	
	public double menorNota(double notas[]) {
		double menor = 0;
		
		for(int i = 0; i < notas.length; i++) {
			if(i == 0) {
				menor = notas[i];
			}
			else if (notas[i] < menor) {
				menor = notas[i];
			} 
		}				
		
		return menor;
	}
	
	public double mediaDaTurma(double [] notas) {
		double soma = 0;
		for(int i = 0; i < notas.length; i++) {
			soma+=notas[i];
		}
		return soma / notas.length;
	}
	
	public static void main(String[] args) {
		Exercicio2 geral = new Exercicio2();
		Scanner sc = new Scanner(System.in);
		double notas [] = new double [5];
		ArrayList<Exercicio2> alunos = new ArrayList<Exercicio2>();
		
		for (int i = 0; i < 5; i++) {
			alunos.add(new Exercicio2());
			System.out.print("Informe a matrícula do aluno: ");
			alunos.get(i).matricula = sc.nextInt();
			System.out.print("Informe a primeira nota do aluno: ");
			alunos.get(i).nota1 = sc.nextDouble();
			System.out.print("Informe a segunda nota do aluno: ");
			alunos.get(i).nota2 = sc.nextDouble();
			System.out.print("Informe a terceira nota do aluno: ");
			alunos.get(i).nota3 = sc.nextDouble();
			System.out.print("Informe a frequencia do aluno: ");
			alunos.get(i).frequencia = sc.nextInt();
			
			System.out.println("\n+------------------------+ \n" + 
								"+------------------------+ \n");
		}
		
		int contReprovados = 0;
		int contReprovadosPorInfrequencia = 0;
		double porcetagemReprovadosInfrequencia;
		
		for (int i = 0; i < alunos.size(); i++) {
			alunos.get(i).calculaMedia();
			alunos.get(i).aprovacao();
			if(!alunos.get(i).situacao.equals("APROVADO")){
				contReprovados++;
				if(alunos.get(i).situacao.equals("REPROVADO POR INFREQUÊNCIA")) {
					contReprovadosPorInfrequencia++;
				}
			}
			
			System.out.println("Matrícula: " + alunos.get(i).matricula);
			System.out.println("Frequencia: " + alunos.get(i).frequencia);
			System.out.println("Nota final: " + alunos.get(i).media);
			System.out.println("Situacao: " + alunos.get(i).situacao);
			
			System.out.println("\n+------------------------+ \n" + 
					"+------------------------+ \n");
		}
		porcetagemReprovadosInfrequencia = (contReprovadosPorInfrequencia * 100)/ alunos.size();
		for(int i = 0; i < alunos.size(); i++) {
			notas[i] = alunos.get(i).media;
		}
		
		System.out.println("Maior nota: " + geral.maiorNota(notas)); 
		System.out.println("Menor nota: " + geral.menorNota(notas));
		System.out.println("Média da turma: " + geral.mediaDaTurma(notas));
		System.out.println("Qtd. de reprovados: " + contReprovados);
		System.out.println("Porcentagem de reprovados por infrequência: " + porcetagemReprovadosInfrequencia + "%");
		sc.close();
		
	}
}
