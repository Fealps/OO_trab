
public class MencaoAluno {
	private float notaFinal;
	private String mencaoFinal;
	private AvaliacaoAluno nota = new AvaliacaoAluno();
	
	public float calcularNotaFinal() {
		float soma = 0;
		for(int i = 0; i < this.nota.size(); i++) {
			soma += this.nota.getNota();
		}
		return soma/this.nota.size();
	}
	public String calcularMencaoFinal() {
		float n = calcularNotaFinal();
		
		if(n == 0) {
			setMencaoFinal("SR");
		}else if(n > 0 && n < 3.0) {
			setMencaoFinal("II");
		}else if(n >= 3.0 && n < 5.0) {
			setMencaoFinal("MI");
		}else if(n >= 5.0 && n < 7.0) {
			setMencaoFinal("MM");
		}else if(n >= 7.0 && n < 9.0) {
			setMencaoFinal("MS");
		}else if(n >= 9.0) {
			setMencaoFinal("SS");
		}
		if(n < 0) {
			try {
				
			} catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("Nao é possivel adicionar nota negativa");
			}
		}
		
		return mencaoFinal;
	}
	public float getNotaFinal() {
		return notaFinal;
	}
	public AvaliacaoAluno getNota() {
		return nota;
	}
	public void setNota(AvaliacaoAluno nota) {
		this.nota = nota;
	}
	public void setNotaFinal(float notaFinal) {
		this.notaFinal = notaFinal;
	}
	public String getMencaoFinal() {
		return mencaoFinal;
	}
	public void setMencaoFinal(String mencaoFinal) {
		//incluir erro caso input seja invalido
		this.mencaoFinal = mencaoFinal;
	}
}
