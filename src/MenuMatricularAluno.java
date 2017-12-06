import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

public class MenuMatricularAluno {

	private static JFrame janela;
	private static JButton matricular;
	private static JComboBox<String> alunoList;
	private static JComboBox<String> materiaList;
	private static JList<String> alunosListJ;
	private static ArrayList<String> lista;
	public static JLabel t1 = null;
	public static JLabel t2 = null;
	private static int k ;

	public static void apresentarGUIMatricularAluno(Aluno a, Turma t) {

		janela = new JFrame("Matricular aluno");
		matricular = new JButton();
		alunoList = new JComboBox<String>();
		materiaList = new JComboBox<String>();
		
		DefaultListModel model = new DefaultListModel();        
		
		

		t1 = new JLabel("Nome");
		t2 = new JLabel("Matérias disponíveis");

		matricular.setText("Matricular");
		matricular.setBounds(0, 0, 30, 15);

		janela.setMinimumSize(new Dimension(300, 200));
		// janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLayout(new GridLayout(4, 2, 5, 5));

		for (int i = 0; i < a.alunos.size(); i++) {
			model.addElement(a.alunos.get(i).getNome().toString());
			alunoList.addItem(a.alunos.get(i).getNome().toString());
			
		}

		for (int i = 0; i < t.getTurmas().size(); i++) {

			materiaList.addItem(t.getTurmas().get(i).getDisciplina().toString());

		}
		
		alunosListJ = new JList<String>(model);
		
		janela.getContentPane().add(t1);
		janela.getContentPane().add(t2);
		janela.getContentPane().add(new JScrollPane(alunosListJ));
		//janela.getContentPane().add(alunoList);
		janela.getContentPane().add(materiaList);
		janela.getContentPane().add(matricular);
		
		alunosListJ.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		alunosListJ.setVisibleRowCount(5);
		
		materiaList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				

			}
		});
		
		
		
		matricular.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				k = materiaList.getSelectedIndex();
				
				System.out.println("Turma selecionada: "+t.getTurmas().get(k).getDisciplina());

				int b = alunosListJ.getSelectedIndex();
				System.out.println("ÍNDICE DO NÚMERO SELECIONADO: " +b);
				//String n = alunosListJ.getSelectedValuesList().get(b);
				String m = alunosListJ.getSelectedValue();
				System.out.println("Aluno nome: "+m);
				
				for(int i = 0; i < a.alunos.size();i++) {					
				
					if(a.alunos.get(i).getNome().toString().equals(m)){
						
						t.getTurmas().get(k).matricular(a.alunos.get(i));
						//System.out.println("Turma selecionada:"+t.getTurmas().get(k).getDisciplina());
						System.out.println("item selecionado: " +b);

						
					}
					//System.out.println("Aluno nome:"+a.alunos.get(i).getNome().toString());
					System.out.println("TESTE 2-ÍNDICE DO NÚMERO SELECIONADO: "+b);
					//System.out.println("item selecionado" +b);

				}
				
				System.out.println("Teste 3: Item selecionado "+m+" e  indice "+b);
				
				janela.dispose();
			}
		});

		janela.setVisible(true);
		janela.pack();

	}

}
