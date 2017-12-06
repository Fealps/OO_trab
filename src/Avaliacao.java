import java.util.ArrayList;

public class Avaliacao {

	private String nome;
	private float peso;
	private static int sizeOfAval = 0;

	static private ArrayList<Avaliacao> avaliacoes;

	public Avaliacao(String nome2, float peso2) {
		this.setNome(nome2);
		this.setPeso(peso2);
	}

	public Avaliacao() {

	}

	public static void criarAvaliacao(Avaliacao a) {

		avaliacoes.add(a);
		sizeOfAval ++;
	}

	public void deletarAvalicao(Avaliacao a) {
		this.avaliacoes.remove(a);
	}

	public String pesquisarAvaliacao(String a) {

		return a;

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

	public static ArrayList<Avaliacao> getAvaliacoes() {

		return avaliacoes;
	}

	public static void setAvaliacoes(ArrayList<Avaliacao> avaliacoes) {
		Avaliacao.avaliacoes = avaliacoes;
	}

	public int getSize() {
		
		return sizeOfAval;
	}

}
