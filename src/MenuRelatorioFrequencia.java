import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class MenuRelatorioFrequencia {
	
	private static JFrame janela;
	private static Panel jp;
	private static JTabbedPane tPane;
	public  static JLabel j1 = null;
	public  static JLabel j2 = null;
	//public static JLabel j3 = null;
	public  static JLabel t1 = null;
	public  static JLabel t2 = null;
	public  static JLabel t3 = null;
	private static JButton c;
	private static JComboBox<String> alunoList;
	
	public static void apresentarGUIExibir(Aluno a, Turma t) {
		
		tPane = new JTabbedPane();
		tPane.setLayout(new GridLayout(0, 3));
		tPane.setSize(600, 200);
		tPane.setVisible(true);
	    tPane.setMnemonicAt(0, KeyEvent.VK_1);

		JComponent panel1 = new JComponent() {
		
		};
		tPane.addTab("Tab 1", panel1);
		
	}
}
