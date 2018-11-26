package application;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Estudante;
import entities.Quarto;

public class exercicio12 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner in = new Scanner(System.in);
		int quantidadeEstudante;
		// -------------------------------------------------
		List<Quarto> quartos = new ArrayList<Quarto>();
		List<Estudante> estudantes = new ArrayList<Estudante>();
		// -------------------------------------------------
		for (int i = 0; i < 10; i++) {
			Quarto quarto = new Quarto();
			quarto.setNumeroQuarto(i);
			quarto.setAlugado(false);
			quartos.add(quarto);
		}
		// -------------------------------------------------
		System.out.println("Digite a quantidade de estudante! (entre 1 a 10)");
		quantidadeEstudante = in.nextInt();
		// -------------------------------------------------
		for (int i = 0; i < quantidadeEstudante; i++) {
			in.nextLine();
			Estudante estudante = new Estudante();
			System.out.println("Digite o nome do estudante: ");
			String nome = in.nextLine();
			estudante.setNome(nome);
			// -------------------------------------------------
			System.out.println("Digite o email do estudante: ");
			String email = in.nextLine();
			estudante.setEmail(email);
			// -------------------------------------------------
			System.out.println("Digite o quarto a ser alugado: ");
			int numero = in.nextInt();
			if (quartos.get(numero).isAlugado()) {
				System.out.println("Quarto já está alugado!!");
				while (quartos.get(numero).isAlugado()) {
					System.out.println("Escolha outro quarto. ");
					numero = in.nextInt();
				}
				Quarto quarto = new Quarto();
				quarto.setNumeroQuarto(numero);
				estudante.setQuarto(quarto);
				quartos.get(numero).setAlugado(true);
				estudantes.add(estudante);
			} else {
				Quarto quarto = new Quarto();
				quarto.setNumeroQuarto(numero);
				estudante.setQuarto(quarto);
				quartos.get(numero).setAlugado(true);
				estudantes.add(estudante);
			}
		}
		System.out.println("##################################################");
		System.out.println("Foram alugados " + estudantes.size() + " quartos.");
		System.out.println("##################################################");
		for (int i = 0; i < estudantes.size(); i++) {
			Estudante estudante = estudantes.get(i);
			System.out.println("O estudante " + estudante.getNome() + " com e-mail " + estudante.getEmail());
			System.out.println("alugou o quarto " + estudante.getQuarto().getNumeroQuarto());
		}
		System.out.println("");
	}
}
