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
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import exceptionpac.ExistAlunoException;
import exceptionpac.FullClassException;

public class MenuMatricularAluno {

	private static JFrame janela;
	private static JButton matricular;
	private static JComboBox<String> alunoList;
	private static JComboBox<String> materiaList;
	private static JList<String> alunosListJ;
	public static JLabel t1 = null;
	public static JLabel t2 = null;
	private static int k;
	private static boolean state ;

	public static void apresentarGUIMatricularAluno(Aluno a, Turma t) {
		
		int tamanhoAlunos = a.alunos.size();
		int tamanhoTurma = t.getTurmas().size();


		if (tamanhoAlunos == 0) {

			JOptionPane.showMessageDialog(null, "Nenhuma aluno cadastrado " + ", cadastre um aluno primeiramente");

			
			MenuCadastrarAluno.apresentarGUICadastrarAluno(a);
			janela.setVisible(false);
			

		}
		
		if (tamanhoTurma == 0) {

			JOptionPane.showMessageDialog(null, "Nenhuma turma cadastrada " + ", cadastre uma turma primeiramente");
			
			MenuCadastrarTurma.apresentarGUICadastrarTurma(t);
			janela.setVisible(false);

		}
		
		

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
		// janela.getContentPane().add(alunoList);
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
		
		state = true;

		matricular.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				k = materiaList.getSelectedIndex();

				System.out.println("Turma selecionada: " + t.getTurmas().get(k).getDisciplina());

				int b = alunosListJ.getSelectedIndex();
				System.out.println("ÍNDICE DO NÚMERO SELECIONADO: " + b);
				// String n = alunosListJ.getSelectedValuesList().get(b);
				String m = alunosListJ.getSelectedValue();
				System.out.println("Aluno nome: " + m);

				for (int w = 0; w < t.getTurmas().size(); w++) {

					System.out.println("aaaaaaaaaaaaaaaaaaaaaa");

					for (int f = 0; f < t.getTurmas().get(w).getAlunos().size(); f++) {

						System.out.println("bbbbbbbbbbbbbbb");

						Aluno aa = t.getTurmas().get(w).getAlunos().get(f);

						if (aa.getNome().equals(m)) {
							//JOptionPane.showMessageDialog(null, "O aluno já está matriuculado");
							System.out.println("O aluno tem nome igual");
						state = false;
						}

					}

				}

				for (int i = 0; i < a.alunos.size(); i++) {
					System.out.println(t.getTurmas().get(k).getVagas());
					if (a.alunos.get(i).getNome().toString().equals(m)) {

						System.out.println("item selecionado: " + b);
						/*
						 * for(int k = 0; k < a.alunos.size();k++) {
						 * if(t.getAlunos().get(k).pesquisar(t.getAlunos().get(i))) {
						 * System.out.println("OK"); } }
						 */
						

						if (t.getTurmas().get(k).getVagas() > 0 && state==true) {
							t.getTurmas().get(k).matricular(a.alunos.get(i));
							t.getTurmas().get(k).reduzVagas();
							String message = "Aluno:" + a.alunos.get(i).getNome() + " matriculado em:"
									+ t.getTurmas().get(k).getDisciplina();
							JOptionPane.showMessageDialog(null, message, "Aluno cadastrado", JOptionPane.PLAIN_MESSAGE);
						} else if(!(t.getTurmas().get(k).getVagas() > 0) && state == true){
							try {
								throw new FullClassException("Turma lotada");
							} catch (FullClassException e1) {
								String message = "Não foi possivel matricular o aluno " + a.alunos.get(i).getNome()
										+ " na turma " + t.getTurmas().get(k).getDisciplina()
										+ " por insuficiencia de vagas.";
								JOptionPane.showMessageDialog(null, message, "ERRO", JOptionPane.ERROR_MESSAGE);
								e1.printStackTrace();
							}

						}
						else if(t.getTurmas().get(k).getVagas() > 0 && state == false){
							try {
								throw new ExistAlunoException("Aluno já matriculado");
							} catch (ExistAlunoException e2) {
								String message = "O aluno " + a.alunos.get(i).getNome()
										+ " já pertence a turma " + t.getTurmas().get(k).getDisciplina()
										+ " .";
								JOptionPane.showMessageDialog(null, message, "ERRO", JOptionPane.ERROR_MESSAGE);
								e2.printStackTrace();
							}

						}

						// System.out.println("Turma
						// selecionada:"+t.getTurmas().get(k).getDisciplina());

					}
					System.out.println(t.getTurmas().get(k).getVagas());
					// System.out.println("Aluno nome:"+a.alunos.get(i).getNome().toString());
					System.out.println("TESTE 2-ÍNDICE DO NÚMERO SELECIONADO: " + b);
					// System.out.println("item selecionado" +b);

				}

				System.out.println("Teste 3: Item selecionado " + m + " e  indice " + b);
				state = true;
			}
	
			
		});

		janela.setVisible(true);
		janela.pack();

	}

}
