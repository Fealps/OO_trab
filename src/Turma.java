import java.util.HashSet;
import java.util.Set;

public class Turma {

	private String disciplina;
	private Set<Aluno> alunos;

	
	public Turma(String disciplina) {
		alunos = new HashSet<Aluno>();
	
	}

	public boolean matricular(Aluno a) {
		boolean resposta = false;
		resposta = alunos.add(a);
		return resposta;
	}

	public boolean desmatricular(Aluno a) {
		boolean resposta = false;
		resposta = alunos.remove(a);
		return resposta;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public Set<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(Set<Aluno> alunos) {
		this.alunos = alunos;
	}

	

}
