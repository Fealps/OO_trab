import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class MenuRelatorioFrequencia {

	private static JFrame janela;
	private static JTabbedPane tabela;
	public static String textT = null;
	// public static JLabel j3 = null;
	public static JPanel tabelaContent;
	public static JLabel alunoNome = null;
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

		for (int i = 0; i < t.getTurmas().size(); i++) {

			tabelaContent = new JPanel();
			tabelaContent.setVisible(true);
			tabelaContent.setLayout(new GridLayout(0, 4,5,5));
			janela.setMinimumSize(new Dimension(400, 300));
			tabelaContent.setMaximumSize(new Dimension(600, 100));


			textT = t.getTurmas().get(i).getDisciplina().toString();
			
			tabelaContent.add(new JLabel("Nomes"));
			tabelaContent.add(new JLabel("Matriculas"));
			tabelaContent.add(new JLabel("P"));
			tabelaContent.add(new JLabel("F"));

			for (int j = 0; j < t.getTurmas().get(i).getAlunos().size(); j++) {

				alunoNome = new JLabel();
				alunoNome.setText(t.getTurmas().get(i).getAlunos().get(j).getNome());

				alunoMatricula = new JLabel();
				alunoNome.setText(t.getTurmas().get(i).getAlunos().get(j).getMatricula());

				tabelaContent.add(alunoNome);
				tabelaContent.add(alunoMatricula);

			}

			tabela.addTab(textT, null, tabelaContent, "nome da disciplina");
			tabela.setMnemonicAt(0, KeyEvent.VK_1);

		}
		janela.getContentPane().add(tabela, BorderLayout.PAGE_START);

	}

}
