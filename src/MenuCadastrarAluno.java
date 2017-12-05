
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MenuCadastrarAluno {
	
	static Aluno alunoNovo ;
	private static JFrame janela;
	private static JTextField JTFnome, JTFmatricula;
	private static JLabel JLnome, JLmatricula;
	private static JButton confirmar;
	

	public static void apresentarGUICadastrarAluno (Aluno aluno){
		
		janela = new JFrame("Cadastro de alunos");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTFnome = new JTextField();
		JTFmatricula = new JTextField();
		
		JLnome = new JLabel("Nome:");
		//JLnome.setHorizontalTextPosition(SwingConstants.CENTER);
		//JLnome.setHorizontalTextPosition(SwingConstants.TOP);
		JLmatricula = new JLabel("Matricula:");
		
		confirmar = new JButton("cadastrar");
		
		janela.getContentPane().add(JLnome);
		janela.getContentPane().add(JTFnome);
		janela.getContentPane().add(JLmatricula);
		janela.getContentPane().add(JTFmatricula);
		janela.getContentPane().add(confirmar);
		
		janela.setMinimumSize(new Dimension(200, 300));
		janela.setLayout(new GridLayout(6, 2, 3, 3));
		
		confirmar.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String nome = JTFnome.getText();
            	String matricula = JTFmatricula.getText();
            	
            	alunoNovo = new Aluno();
            	alunoNovo.setNome(nome);
            	alunoNovo.setMatricula(matricula);
            	aluno.cadastrar(alunoNovo);
            
            	//JOptionPane.showMessageDialog(null, "Eu estou testando", "teste", JOptionPane.PLAIN_MESSAGE);
            	janela.dispose();
            }
		});
		
		
		janela.pack();
		janela.setVisible(true);
		
	
		
	}
	

}
