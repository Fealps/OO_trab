import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenuRelatorioTurma {

	private static JFrame janela;
	public static JLabel j1 = null;
	public static JLabel t1 = null;
	private static JButton c;

	public static void apresentarGUIExibir(Turma t) {

		c = new JButton();
		t1 = new JLabel("Nome");
		janela = new JFrame("Relatorio de alunos");

		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setText("Fechar");

		//janela.getContentPane().setBackground(Color.ORANGE);
		janela.getContentPane().add(t1);

		for (int i = 0; i < t.getTurmas().size(); i++) {
			j1 = new JLabel(t.getTurmas().get(i).getDisciplina().toString());
			janela.getContentPane().add(j1);
		}

		janela.getContentPane().add(c);

		janela.setMinimumSize(new Dimension(200, 300));
		janela.setLayout(new GridLayout(0, 1));

		janela.pack();
		janela.setVisible(true);

		c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				janela.dispose();
			}
		});

	}

}
