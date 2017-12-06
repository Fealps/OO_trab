import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

import exceptionpac.BlankException;

public class Aluno {

	private String nome;
	private String matricula;
	static ArrayList<Aluno> alunos = new ArrayList<>();
		
	 
	
	  public Aluno(String nome, String matricula) { 
	
		  this.setNome(nome) ;
		  this.setMatricula(matricula);
	  }
	 
	
	  public Aluno() {
		// TODO Auto-generated constructor stub
	}


	static void cadastrar(Aluno a) {
		
		
		alunos.add(a);
		
		String message = 
				String.format("O aluno %s com a matrícula %s"
						+ " foi matriculado com sucesso ", a.getNome(),a.getMatricula());
		
		JOptionPane.showMessageDialog(null, message,"Cadastro de alunos", JOptionPane.PLAIN_MESSAGE);
	System.out.printf("O aluno %s com a matrícula %s"
	+ " foi matriculado com sucesso ", a.getNome(),a.getMatricula());
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
				nome = JOptionPane.showInputDialog("Informe o nome novamente: ");
				setNome(nome);
				e.printStackTrace();
			}
		}

		this.nome = nome;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		if (matricula.equals("  /       "))
			try {
				throw new BlankException("A matrícula não pode estar vazia");
			} catch (BlankException e) {
				JOptionPane.showMessageDialog(null, "Matriculas em branco nao sao permitidas. Insira a matricula novamente.", "ATENCAO", JOptionPane.ERROR_MESSAGE);
				//System.exit(-1);
				setMatricula(matricula);
				e.printStackTrace();
			 }
		this.matricula = matricula;
	}
		
	/*
	 * public static Aluno getAlunos() { return alunos; }
	 * 
	 * public static void setAlunos(Aluno alunos) { Aluno.alunos = alunos; }
	 */
}
