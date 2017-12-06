import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class MenuMatricularAluno {
	
	private static JFrame janela;
	private static JButton matricular;
	private static JComboBox<String> alunoList;
	private static JComboBox<String> materiaList;
	private static String[] lista;
	public static JLabel t1 = null;
	public static JLabel t2 = null;
	
	public static void apresentarGUIMatricularAluno (Aluno a , Turma t) {
		
		janela = new JFrame("Matricular aluno");
		matricular = new JButton();
		alunoList = new JComboBox<String>();
		materiaList = new JComboBox<String>();
		
		t1 = new JLabel("Nome");
		t2 = new JLabel("Matérias disponíveis");

		matricular.setText("Matricular");
		matricular.setBounds(0, 0, 30, 15);
		
		janela.setMinimumSize(new Dimension(300, 200));
		//janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLayout(new GridLayout(4, 2, 5, 5));
		
		for (int i = 0; i < t.getTurmas().size(); i++) {

			try {
				for (int j = 0; j < t.getTurmas().get(i).getAval().getSize(); j++) {
					alunoList.addItem(t.getTurmas().get(i).getAval().getAvaliacoes().get(j).getNome().toString());
					materiaList.addItem(t.getTurmas().get(i).getAval().getAvaliacoes().get(j).getNome().toString());

				}
			} catch (NullPointerException e) {
				System.out.println("Está vazio");
			}
			
			
		}
		
				
		janela.getContentPane().add(t1);
		janela.getContentPane().add(t2);
		janela.getContentPane().add(alunoList);
		janela.getContentPane().add(materiaList);
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
