import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

import exceptionpac.BlankException;
import exceptionpac.WrongFormatException;

public class Aluno {

	private boolean error = false;
	private String nome;
	private String matricula;
	static ArrayList<Aluno> alunos = new ArrayList<>();

	public Aluno(String nome, String matricula) {

		this.setNome(nome);
		this.setMatricula(matricula);
	}

	public Aluno() {
		// TODO Auto-generated constructor stub
	}

	static void cadastrar(Aluno a) {
		alunos.add(a);

		String message = String.format("O aluno %s com a matrícula %s" + " \n foi matriculado com sucesso \n", a.getNome(),
				a.getMatricula());

		JOptionPane.showMessageDialog(null, message, "Cadastro de alunos", JOptionPane.PLAIN_MESSAGE);

		System.out.printf("O aluno %s com a matrícula %s" + " foi matriculado com sucesso ", a.getNome(),
				a.getMatricula());
	}

	static Aluno pesquisar(String n) {

		Aluno resposta = null;

		for (int i = 0; i < alunos.size(); i++) {
			Aluno aluno = alunos.get(i);
			if (n.equals(aluno.nome)) {
				System.out.println("o aluno " + n + ",da matricula " + aluno.getMatricula() + " esta na posiçao " + i);
				break;
			} else {
				System.out.println("Esse aluno nao existe!!");
			}
		}

		return resposta;

	}

	static void excluir(Aluno a) {

		alunos.remove(a);
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		if (nome.equals("")) {
			try {
				throw new BlankException("O nome não pode ser em branco!");
			} catch (BlankException e) {
				JOptionPane.showMessageDialog(null, "Nome em branco nao e permitido. Insira o nome novamente.",
						"ATENCAO", JOptionPane.ERROR_MESSAGE);
				this.setError(true);
				e.printStackTrace();
			}
		} else if (nome.matches(".*\\d+.*")) {
			try {
				throw new WrongFormatException("Nome invalido");
			} catch (WrongFormatException e) {
				JOptionPane.showMessageDialog(null, "Formato invalido. Por favor Insira o nome novamente.", "ATENCAO",
						JOptionPane.ERROR_MESSAGE);

				this.setError(true);
				e.printStackTrace();
			}
		} else
			this.nome = nome;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		if (matricula.equals("  /       ")) {
			try {
				throw new WrongFormatException("A matrícula esta incorreta");
			} catch (WrongFormatException e) {
				JOptionPane.showMessageDialog(null,
						"Formato da matricula incorreto. Por favor insira a matricula novamente.", "ATENCAO",
						JOptionPane.ERROR_MESSAGE);
				this.setError(true);
				e.printStackTrace();
			}
		} else
			this.matricula = matricula;
	}

	public boolean getError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}
	/*
	 * public static Aluno getAlunos() { return alunos; }
	 * 
	 * public static void setAlunos(Aluno alunos) { Aluno.alunos = alunos; }
	 */
}
