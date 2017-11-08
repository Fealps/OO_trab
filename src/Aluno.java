import javax.swing.JOptionPane;

public class Aluno {
	
	private String nome;
	private String matricula;
	static private Aluno alunos;
	
	static void cadastrar() {
		
	}
	static Aluno pesquisar(String m){
		
		return alunos;
		
	}
	static boolean excluir(Aluno a) {
		
		return true;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome.equals(""))
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
		this.matricula = matricula;
	}
	public static Aluno getAlunos() {
		return alunos;
	}
	public static void setAlunos(Aluno alunos) {
		Aluno.alunos = alunos;
	}
	
}
