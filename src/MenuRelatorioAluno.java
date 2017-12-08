import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

public class MenuRelatorioAluno {

	private static JFrame janela;
	public static JLabel j1 = null;
	public static JLabel j2 = null;
	public static JLabel t1 = null;
	public static JLabel t2 = null;
	public static JLabel t3 = null;
	private static JButton c;
	private static JButton editar;
	private static JButton salvar;
	private static JButton cancelarEditar;
	private static JComboBox<String> nomesList;
	private static JComboBox<String> materiasList;
	// private static String[] lista;
	private static JTextField alunoNome;
	private static JTextField alunoMatricula;
	private static MaskFormatter mascaraMatricula;
	private static String novoNome;
	private static String novaMatricula;
	static int k;

	public static void apresentarGUIExibir(Aluno a) {

		int tamanhoAlunos = a.alunos.size();

		if (tamanhoAlunos == 0) {

			JOptionPane.showMessageDialog(null, "Nenhuma aluno cadastrado " + ", cadastre um aluno primeiramente");

			
			MenuCadastrarAluno.apresentarGUICadastrarAluno(a);
			janela.setVisible(false);
			

		}

		janela = new JFrame("Relatorio de alunos");

		t1 = new JLabel("Nome ");
		t2 = new JLabel("Matrícula");
		t3 = new JLabel("Turmas cadastradas");
		c = new JButton();
		salvar = new JButton("salvar alterações");
		editar = new JButton("Editar dados");
		cancelarEditar = new JButton("cancelar edição");

		alunoNome = new JTextField();
		alunoMatricula = new JTextField();

		// janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setText("Fechar");

		janela.getContentPane().add(t1);
		janela.getContentPane().add(t2);
		janela.getContentPane().add(t3);

		alunoNome.setEditable(false);
		alunoNome.setVisible(false);
		alunoMatricula.setEditable(false);

		salvar.setVisible(false);
		cancelarEditar.setVisible(false);

		nomesList = new JComboBox<String>();
		materiasList = new JComboBox<String>();

		try {
			mascaraMatricula = new MaskFormatter("##/#######");

		} catch (ParseException exp) {
			exp.printStackTrace();
			mascaraMatricula.setPlaceholderCharacter('_');

		}
		JFormattedTextField matriculaF = new JFormattedTextField(mascaraMatricula);
		matriculaF.setVisible(false);

		for (int i = 0; i < Aluno.alunos.size(); i++) {
			// j1 = new JLabel(a.alunos.get(i).getNome().toString());
			// j2 = new JLabel(a.alunos.get(i).getMatricula().toString());
			nomesList.addItem(Aluno.alunos.get(i).getNome().toString());
			// janela.getContentPane().add(j1);
			// janela.getContentPane().add(j2);
		}

		j2 = new JLabel();

		// nomesList.setEditable();

		nomesList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				k = nomesList.getSelectedIndex();

				j2.setText(Aluno.alunos.get(k).getMatricula().toString());

			}
		});

		j2 = new JLabel();

		janela.getContentPane().add(nomesList);
		janela.getContentPane().add(j2);
		janela.getContentPane().add(materiasList);
		janela.getContentPane().add(alunoNome);
		janela.getContentPane().add(matriculaF);
		janela.getContentPane().add(salvar);

		janela.getContentPane().add(c);
		janela.getContentPane().add(editar);
		janela.getContentPane().add(cancelarEditar);

		janela.setMinimumSize(new Dimension(400, 200));
		janela.setLayout(new GridLayout(0, 3, 10, 10));

		janela.pack();
		janela.setVisible(true);

		c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				janela.dispose();
			}
		});

		editar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (editar.isEnabled()) {
					alunoNome.setVisible(true);
					alunoNome.setEditable(true);
					matriculaF.setVisible(true);
					salvar.setVisible(true);
					cancelarEditar.setVisible(true);

					alunoNome.setText(Aluno.alunos.get(k).getNome().toString());
					matriculaF.setText(Aluno.alunos.get(k).getMatricula().toString());

				}
			}
		});

		cancelarEditar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (cancelarEditar.isEnabled()) {
					alunoNome.setVisible(false);
					matriculaF.setVisible(false);
					salvar.setVisible(false);
				}
				cancelarEditar.setVisible(false);

			}
		});

		salvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				Aluno.alunos.get(k).setNome(alunoNome.getText());
				Aluno.alunos.get(k).setMatricula(matriculaF.getText());

				janela.dispose();

			}
		});

	}

}
