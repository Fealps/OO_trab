import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.*;



public class MenuRelatorioFrequencia {

	private static JFrame janela;
	private static JTabbedPane tabela;
	public static String textT = null;
	public static ButtonGroup radioGrupo;
	public static JRadioButton presente;
	public static ArrayList<ButtonGroup> gruposButtonGroup = new ArrayList<>();
	public static JRadioButton faltoso;
	public static JPanel tabelaContent;
	public static JLabel alunoNome = null;
	public static JButton salvarFreq;
	public static JButton fechar;
	public static JLabel alunoMatricula = null;
	static ImageIcon icon = null;

	public static void apresentarGUIExibir(Aluno a, Turma t) {

		janela = new JFrame();
		janela.setVisible(true);
		janela.setMinimumSize(new Dimension(400, 300));
		janela.setMaximumSize(new Dimension(600, 300));
		janela.setTitle("Relatório de frequência de alunos");
		// janela.pack();

		tabela = new JTabbedPane();
		tabela.setMinimumSize(new Dimension(600, 100));

		salvarFreq = new JButton("Salvar Chamada");
		fechar = new JButton("Fechar");

		for (int i = 0; i < t.getTurmas().size(); i++) {

			tabelaContent = new JPanel();
			tabelaContent.setVisible(true);
			tabelaContent.setLayout(new GridLayout(0, 4, 5, 5));

			textT = t.getTurmas().get(i).getDisciplina().toString();

			tabelaContent.add(new JLabel("Nomes"));
			tabelaContent.add(new JLabel("Matriculas"));
			tabelaContent.add(new JLabel("P"));
			tabelaContent.add(new JLabel("A"));

			for (int j = 0; j < t.getTurmas().get(i).getAlunos().size(); j++) {

				alunoNome = new JLabel(t.getTurmas().get(i).getAlunos().get(j).getNome());
				alunoMatricula = new JLabel(t.getTurmas().get(i).getAlunos().get(j).getMatricula());

				// tabelaContent.add(new
				// JLabel(t.getTurmas().get(i).getAlunos().get(j).getNome()));
				tabelaContent.add(alunoNome);
				// tabelaContent.add(new
				// JLabel(t.getTurmas().get(i).getAlunos().get(j).getMatricula()));
				tabelaContent.add(alunoMatricula);

				presente = new JRadioButton();
				faltoso = new JRadioButton();
				
				presente.setText("Presente");
				faltoso.setText("Ausente");


				radioGrupo = new ButtonGroup();

				radioGrupo.add(presente);
				radioGrupo.add(faltoso);

				gruposButtonGroup.add(radioGrupo);

				tabelaContent.add(presente);
				tabelaContent.add(faltoso);

			}

			salvarFreq.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					// TODO Auto-generated method stub

					for (int i = 0; i < t.getTurmas().size(); i++) {

						for (int w = 0; w < t.getTurmas().get(i).getAlunos().size(); w++) {

							System.out.println("grupo " + w);

							for (int y = 0; y < gruposButtonGroup.get(w).getButtonCount(); y++) {

								System.out.println("teste:" + y);

								if (gruposButtonGroup.get(w).isSelected(presente.getModel())) {

									System.out.println("Estou presente");
									//JOptionPane.showMessageDialog(null, "Teste", "Teste", JOptionPane.PLAIN_MESSAGE);

								}
								if (gruposButtonGroup.get(w).isSelected(faltoso.getModel())) {

									System.out.println("Estou faltoso");

								}

							}

						}

					}
				}
			});
			
			
			tabela.addTab(textT, null, tabelaContent, "nome da disciplina");
			tabela.setMnemonicAt(0, KeyEvent.VK_1);

		}
		janela.add(salvarFreq, BorderLayout.SOUTH);
		janela.getContentPane().add(tabela, BorderLayout.PAGE_START);

	}

}
