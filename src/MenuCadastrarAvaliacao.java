
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class MenuCadastrarAvaliacao {
	static Avaliacao aval ;
	private Turma turma;
	private static JFrame janela;
	private static ButtonGroup bg = new ButtonGroup();
	private static JTextField JTFnome, JTFpeso;
	private static JLabel JLnome, JLpeso, JLbotao;
	private static JButton confirmar;
	private static int size;
	private static JToggleButton buttons[];

	
public static void apresentarGUICadastrarAvaliacao (Turma turma){
		size = turma.getSize();
		buttons = new JToggleButton[size];
		
		janela = new JFrame("Cadastro de avaliacoes");
		//janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTFnome = new JTextField();
		JTFpeso = new JTextField();
		
		JLnome = new JLabel("Nome:");
		//JLnome.setHorizontalTextPosition(SwingConstants.CENTER);
		//JLnome.setHorizontalTextPosition(SwingConstants.TOP);
		JLpeso= new JLabel("Peso:");
		
		janela.getContentPane().add(JLnome);
		janela.getContentPane().add(JTFnome);
		janela.getContentPane().add(JLpeso);
		janela.getContentPane().add(JTFpeso);
		
		janela.setMinimumSize(new Dimension(200, 300));
		janela.setLayout(new GridLayout(6, 2, 3, 3));
		
		for (int i = 0; i < buttons.length; ++i)
		{
			JLbotao = new JLabel(turma.getTurmas().get(i).getDisciplina().toString());

			JToggleButton btn = new JToggleButton(turma.getTurmas().get(i).getDisciplina().toString());
			btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//Açoes dos botoes
				}
			});
			bg.add(btn);
			
			janela.getContentPane().add(btn);
			buttons[i] = btn;
		}
		
		confirmar = new JButton("cadastrar");
		janela.getContentPane().add(confirmar);
		
		confirmar.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            	String nome = JTFnome.getText();
            	float peso = Float.parseFloat(JTFpeso.getText());
            	
            	aval = new Avaliacao();
            	aval.setNome(nome);
            	aval.setPeso(peso);
            	aval.criarAvaliacao();
            	janela.dispose();
            }
		});
		
		
		janela.pack();
		janela.setVisible(true);
		
	
		
	}

}
