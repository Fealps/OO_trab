
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class Menu {
	
	private static JFrame janela;
	private static JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;
	
	static MenuRelatorioAluno  	  menuRA  = new MenuRelatorioAluno();
	static MenuCadastrarAluno  	  menuC   = new MenuCadastrarAluno();
	static MenuCadastrarTurma     menuT   = new MenuCadastrarTurma();
	static MenuRelatorioTurma     menuRT  = new MenuRelatorioTurma();
	static MenuMatricularAluno	  menuMA  = new MenuMatricularAluno();
	static MenuCadastrarAvaliacao menuCA  = new MenuCadastrarAvaliacao();


	public static void apresentarGUI(Aluno a,Turma t) {

		janela = new JFrame("Gerenciador Acadêmico");

		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btn1 = new JButton("Cadastro de Alunos");
		btn2 = new JButton("Relatorio Alunos");
		btn3 = new JButton("Cadastro de Turmas");
		btn4 = new JButton("Relatorio Turmas");
		btn5 = new JButton("Cadastro de Atividades");
		btn6 = new JButton("Relatorio de Notas");
		btn7 = new JButton("Matricular Alunos");
		btn8 = new JButton("Lista de presença");

		janela.getContentPane().add(btn1);
		janela.getContentPane().add(btn2);
		janela.getContentPane().add(btn3);
		janela.getContentPane().add(btn4);
		janela.getContentPane().add(btn5);
		janela.getContentPane().add(btn6);
		janela.getContentPane().add(btn7);
		janela.getContentPane().add(btn8);

		janela.setMinimumSize(new Dimension(400, 600));
		janela.setLayout(new GridLayout(4, 2, 5, 5));
		
		btn1.addActionListener( new ActionListener() {
			
            public void actionPerformed(ActionEvent e) {         	
            	menuC.apresentarGUICadastrarAluno(a);
            }
            
		});
		
		btn2.addActionListener( new ActionListener() {
			
            public void actionPerformed(ActionEvent e) {            	    
            	menuRA.apresentarGUIExibir(a);                     	
            }
            
		});
		
		btn3.addActionListener( new ActionListener() {
			
            public void actionPerformed(ActionEvent e) {            	
            	menuT.apresentarGUICadastrarTurma(t);            	
            }
            
		});
		
		btn4.addActionListener( new ActionListener() {
			
            public void actionPerformed(ActionEvent e) {
            	menuRT.apresentarGUIExibir(t);	
            }
            
		});
		
		btn5.addActionListener( new ActionListener() {
			
            public void actionPerformed(ActionEvent e) {         	
            	menuCA.apresentarGUICadastrarAvaliacao(t);
            }
            
		});
		
		btn6.addActionListener( new ActionListener() {
			
            public void actionPerformed(ActionEvent e) {         	
            	
            }
            
		});
		
		btn7.addActionListener( new ActionListener() {
            
			public void actionPerformed(ActionEvent e) {
            	menuMA.apresentarGUIMatricularAluno(a,t);
            }
            
		});
		
		btn8.addActionListener( new ActionListener() {
			
            public void actionPerformed(ActionEvent e) {         	
            	
            }
            
		});

		janela.pack();
		janela.setVisible(true);

	}

}
