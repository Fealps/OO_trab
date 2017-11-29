import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import exceptionpac.BlankException;

public class Aluno {

	private String nome;
	private String matricula;
	static private ArrayList<Aluno> alunos = new ArrayList<>();

	public Aluno(String nome, String matricula) {
		this.nome = nome;
		this.matricula = matricula;

	}

	static void cadastrar(Aluno a) {
		
		alunos.add(a);
	}

	static Aluno pesquisar(String m) {
		
		Aluno resposta = null;
		
		for (int i = 0; i < alunos.size(); i++) {
		    Aluno aluno = alunos.get(i);
		    if (m.equals(aluno.nome)) {
		        System.out.println("o aluno " + m + " esta na posiçao " + i);
		        break;
		    } else {
		        System.out.println("Esse aluno nao existe!!");
		    }
		}
		
		return resposta;

	}

	static boolean excluir(Aluno a) {

		return true;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome.equals(""))
			try {
				throw new BlankException("O nome não pode ser em branco!");
			} catch (BlankException e) {
				nome = JOptionPane.showInputDialog("Informe o nome novamente: ");
				setNome(nome);
				e.printStackTrace();
			}

		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		if (matricula.equals(""))
			try {
				throw new BlankException("A matrícula não pode estar vazia");
			} catch (BlankException e) {
				matricula = JOptionPane.showInputDialog("Informe a matrícula novamente");
				setMatricula(matricula);
				e.printStackTrace();
			}
	}

	/*public static Aluno getAlunos() {
		return alunos;
	}

	public static void setAlunos(Aluno alunos) {
		Aluno.alunos = alunos;
	}
		*/
}
