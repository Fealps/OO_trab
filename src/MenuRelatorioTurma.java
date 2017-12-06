import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenuRelatorioTurma {

	private static JFrame janela;
	public static JLabel j1 = null;
	public static JLabel j2 = null;
	public static JLabel j3 = null;
	public static JLabel t1 = null;
	public static JLabel t2 = null;
	public static JLabel t3 = null;
	private static JButton c;
	private static JComboBox<String> avaList;
	private static String[] lista;

	public static void apresentarGUIExibir(Turma t) {

		janela = new JFrame("Relatorio de Turmas");
		janela.setLayout(new GridLayout(0, 3));
		janela.pack();
		// janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(600, 200);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);

		c = new JButton();
		c.setText("Fechar");

		t1 = new JLabel("Nome");
		t2 = new JLabel("Avaliações cadastradas");
		t3 = new JLabel("Alunos matriculados");
		
		avaList = new JComboBox<String>();

		janela.getContentPane().add(t1);
		janela.getContentPane().add(t2);
		janela.getContentPane().add(t3);
		
		for (int i = 0; i < t.getTurmas().size(); i++) {
			
			j1 = new JLabel(t.getTurmas().get(i).getDisciplina().toString());
			janela.getContentPane().add(j1);
			avaList = new JComboBox<String>();
				for (int j = 0; j < t.getTurmas().get(i).getAval().getSize(); j++) {
					avaList.addItem(t.getTurmas().get(i).getAval().getAvaliacoes().get(j).getNome().toString());
				}
			janela.getContentPane().add(avaList);
			j3 = new JLabel();
			janela.getContentPane().add(j3);
		}

		avaList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		janela.getContentPane().add(c);

		c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				janela.dispose();
			}
		});

	}

}
