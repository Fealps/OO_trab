import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenuRelatorioAluno {
	
	private static JFrame janela;
	public static JLabel j1 = null;
	public static JLabel j2 = null;
	public static JLabel t1 = null;
	public static JLabel t2 = null;
	private static JButton c;
	

	
	
	public static void apresentarGUIExibir (Aluno a){
		
		c = new JButton();
		t1 = new JLabel("Nome");
		t2 = new JLabel("Matrícula");
		janela = new JFrame("Relatorio de alunos");
		
	
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setText("Fechar");
		
		janela.getContentPane().setBackground(Color.ORANGE);
		janela.getContentPane().add(t1);
		janela.getContentPane().add(t2);
		
		for(int i = 0; i < a.alunos.size(); i++) {
			j1 = new JLabel(a.alunos.get(i).getNome().toString());
			j2 = new JLabel(a.alunos.get(i).getMatricula().toString());
			janela.getContentPane().add(j1);
			janela.getContentPane().add(j2);
		}
		
		janela.getContentPane().add(c);
		
		janela.setMinimumSize(new Dimension(200, 300));
		janela.setLayout(new GridLayout(0, 2));
	
		
		
		janela.pack();
		janela.setVisible(true);
		
		c.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	janela.dispose();
            }
		});

		
	}
	

}
