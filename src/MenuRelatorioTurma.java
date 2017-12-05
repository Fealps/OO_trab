import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MenuRelatorioTurma {

	private static JFrame janela;
	public static JLabel j1 = null;
	public static JLabel t1 = null;
	private static JButton c;
   

	public static void apresentarGUIExibir(Turma t) {

		
		janela = new JFrame("Relatorio de alunos");
		janela.setLayout(new GridLayout(0, 1));
		janela.pack();
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(300,200);
        janela.setVisible(true);
        janela.setLocationRelativeTo(null);
		
		c = new JButton();
		c.setText("Fechar");
		
		t1 = new JLabel("Nome");
 
		janela.getContentPane().add(t1);

		for (int i = 0; i < t.getTurmas().size(); i++) {
			j1 = new JLabel(t.getTurmas().get(i).getDisciplina().toString());
			janela.getContentPane().add(j1);
		}

		janela.getContentPane().add(c);

		c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				janela.dispose();
			}
		});

	}

}
