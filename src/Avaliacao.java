import java.util.ArrayList;

public class Avaliacao {

	private String nome;
	private float peso;
	private int sizeOfAval = 0;
	private ArrayList<Avaliacao> avaliacoes = new ArrayList<>();

	public Avaliacao(String nome2, float peso2) {
		this.setNome(nome2);
		this.setPeso(peso2);
	}

	public Avaliacao() {

	}

	public void criarAvaliacao(Avaliacao a) {

		sizeOfAval ++;
		this.avaliacoes.add(a);
		System.out.println("Avaliacao cadastrada com sucesso");
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

	public ArrayList<Avaliacao> getAvaliacoes() {
		return this.avaliacoes;
	}

	public void setAvaliacoes(ArrayList<Avaliacao> a) {
		this.avaliacoes = a;
	}

	public int getSize() {
		
		return sizeOfAval;
	}

}
