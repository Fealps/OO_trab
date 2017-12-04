import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MenuRelatorioAluno {
	
	private static JFrame janela;
	public static JLabel j1 = null;
	private static JButton c;
	

	
	
	public static void apresentarGUIExibir (Aluno a){
		
		c = new JButton();
	
		janela = new JFrame("Relatorio de alunos");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		for(int i =0; i < a.alunos.size(); i++) {
			j1 = new JLabel(a.alunos.get(i).getNome().toString());
		}
		
		janela.getContentPane().add(j1);
		janela.getContentPane().add(c);
		
		janela.setMinimumSize(new Dimension(200, 300));
		janela.setLayout(new GridLayout(4, 2, 5, 5));
	
		
		
		janela.pack();
		janela.setVisible(true);
		
		c.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	janela.dispose();
            }
		});

		
	}
	

}
