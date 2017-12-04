
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class MenuMatricularAluno {
	
	private static JFrame janela;
	private static JButton matricular;
	
	public static void apresentarGUIMatricularAluno (Aluno a , Turma t) {
		
		janela = new JFrame("Matricular aluno");
		matricular = new JButton();
		
		matricular.setText("Matricular");
		matricular.setBounds(0, 0, 30, 15);
		
		janela.setMinimumSize(new Dimension(300, 200));
		//janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLayout(new GridLayout(4, 2, 5, 5));
				
		
		janela.getContentPane().add(matricular);
		
		matricular.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				janela.dispose();
			}
		});
		
		
		janela.setVisible(true);
		janela.pack();
		

	}
	
	

}
