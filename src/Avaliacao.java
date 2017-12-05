
public class Avaliacao {
	
	private		String nome;
	private		float  peso;
	
	static private Avaliacao avaliacoes;
	
	public static Avaliacao criarAvaliacao(){
		return avaliacoes;
	}
	public boolean deletarAvalicao() {
		return true;
	}
	public Avaliacao pesquisarAvaliacao() {
		return avaliacoes;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public static Avaliacao getAvaliacoes() {
		return avaliacoes;
	}
	public static void setAvaliacoes(Avaliacao avaliacoes) {
		Avaliacao.avaliacoes = avaliacoes;
	}
	
}
