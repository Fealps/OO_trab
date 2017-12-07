import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class MenuRelatorioFrequencia {

	private static JFrame janela;
	private static JTabbedPane jTPane;
	public static String textT = null;
	public static JComponent tPanels = null;
	// public static JLabel j3 = null;
	public static JPanel tab;
	public static JLabel t1 = null;
	static ImageIcon icon = null;
	private static JButton c;
	private static JComboBox<String> alunoList;

	public static void apresentarGUIExibir(Aluno a, Turma t) {

		janela = new JFrame();
		janela.setVisible(true);
		janela.setMinimumSize(new Dimension(600, 300));
		janela.setTitle("Relatório de frequência de alunos");
		//janela.pack();

		jTPane = new JTabbedPane();
		jTPane.setMinimumSize(new Dimension(600, 100));
		
		for (int i = 0; i < t.getTurmas().size();i ++) {
			
			tab = new JPanel();		
			tab.setVisible(true);
			tab.setLayout(new BorderLayout());
			
			tab.add(new JLabel("teste"));			


			
			textT = t.getTurmas().get(i).getDisciplina().toString();
			jTPane.addTab(textT, null, tab, "nome da disciplina");
			jTPane.setMnemonicAt(0, KeyEvent.VK_1);
			
		}
		janela.getContentPane().add(jTPane, BorderLayout.CENTER);


	}

	private static JComponent makeTextPanel(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
