import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class MenuRelatorioFrequencia {

	private static JFrame janela;
	private static JTabbedPane jTPane;
	public static String textT = null;
	public static JComponent tPanels = null;
	// public static JLabel j3 = null;
	public static JLabel t1 = null;
	static ImageIcon icon = null;
	private static JButton c;
	private static JComboBox<String> alunoList;

	public static void apresentarGUIExibir(Aluno a, Turma t) {

		janela = new JFrame();
		janela.setVisible(true);
		janela.setMinimumSize(new Dimension(600, 300));
		janela.setTitle("Relatório de frequência de alunos");

		jTPane = new JTabbedPane();
		jTPane.setMinimumSize(new Dimension(600, 100));
		
		for (int i = 0; i < t.getTurmas().size();i ++) {

			
			tPanels = new JComponent() {
				
			} ;
			tPanels.setVisible(true);
			tPanels.setLayout(new BorderLayout());
			tPanels = makeTextPanel("Panel #"+i+1);
			
			textT = t.getTurmas().get(i).getDisciplina().toString();
			jTPane.addTab(textT, null, tPanels, "nome da disciplina");
			jTPane.setMnemonicAt(0, KeyEvent.VK_1);
			
		}
		janela.getContentPane().add(jTPane, BorderLayout.CENTER);


	}

	private static JComponent makeTextPanel(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
