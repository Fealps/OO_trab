
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.sun.imageio.stream.StreamCloser.CloseAction;

public class MenuCadastrar {
	
	static Aluno alunoNovo ;
	private static JFrame janela;
	private static JTextField JTFnome, JTFmatricula;
	private static JLabel JLnome, JLmatricula;
	private static JButton confirmar;
	

	public static void apresentarGUICadastrar (Aluno aluno){
		
		janela = new JFrame("Cadastro de alunos");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTFnome = new JTextField(20);
		JTFmatricula = new JTextField(10);
		
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
		janela.setLayout(new GridLayout(4, 2, 5, 5));
		
		confirmar.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String nome = JTFnome.getText();
            	String matricula = JTFmatricula.getText();
            	
            	alunoNovo = new Aluno(nome,matricula);
            	aluno.cadastrar(alunoNovo);
            	
            	//JOptionPane.showMessageDialog(null, "Eu estou testando", "teste", JOptionPane.PLAIN_MESSAGE);
            	janela.dispose();
            }
		});
		
		
		janela.pack();
		janela.setVisible(true);
		
	
		
	}
	

}
