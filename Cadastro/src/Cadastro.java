import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class Cadastro {

	private JFrame frame;
	private JTextField jTxtNome;
	private JTextField jTxtEmail;
	private JPasswordField jTxtSenha;
	private JTextField jTxtIdade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					final Cadastro window = new Cadastro();
					window.frame.setVisible(true);
				} catch (final Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Cadastro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent e) {
			}
		});
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setAlwaysOnTop(true);
		frame.setBounds(100, 100, 284, 180);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		final JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(10, 14, 27, 14);
		frame.getContentPane().add(lblNewLabel);

		jTxtNome = new JTextField();
		jTxtNome.setHorizontalAlignment(SwingConstants.LEFT);
		jTxtNome.setToolTipText("Nome");
		jTxtNome.setBounds(66, 11, 86, 20);
		frame.getContentPane().add(jTxtNome);
		jTxtNome.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Eae",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(4, 31, 154, 42);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		final JLabel lblNewLabel_1 = new JLabel("E-mail");
		lblNewLabel_1.setBounds(6, 19, 28, 14);
		panel.add(lblNewLabel_1);

		jTxtEmail = new JTextField();
		jTxtEmail.setBounds(62, 16, 86, 20);
		panel.add(jTxtEmail);
		jTxtEmail.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent e) {
			}
		});
		jTxtEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		jTxtEmail.setColumns(10);
		lblNewLabel_1.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent e) {
			}
		});

		final JLabel lblNewLabel_2 = new JLabel("Senha");
		lblNewLabel_2.setBounds(10, 84, 30, 14);
		frame.getContentPane().add(lblNewLabel_2);

		jTxtSenha = new JPasswordField();
		jTxtSenha.setBackground(Color.WHITE);
		jTxtSenha.setBounds(66, 81, 86, 20);
		frame.getContentPane().add(jTxtSenha);

		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setBounds(10, 115, 28, 14);
		frame.getContentPane().add(lblIdade);

		jTxtIdade = new JTextField();
		jTxtIdade.setColumns(10);
		jTxtIdade.setBounds(66, 112, 86, 20);
		frame.getContentPane().add(jTxtIdade);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBackground(UIManager.getColor("Button.background"));
		btnCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Cliente cl = new Cliente();
				cl.setNome(jTxtNome.getText());
				cl.seteMail(jTxtEmail.getText());

				try {
					cl.setIdade(Integer.parseInt(jTxtIdade.getText()));

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Idade deve ser um n�mero inteiro positivo");
					if ((cl.getIdade() < 0) || (cl.getIdade() > 120)) {
						JOptionPane.showMessageDialog(null, "Sobre humano?!");
					}
				}

				cl.setSenha(jTxtSenha.toString());
				JOptionPane.showMessageDialog(null, cl.salvar());
				jTxtEmail.setText(null);
				jTxtIdade.setText(null);
				jTxtNome.setText(null);
				jTxtSenha.setText(null);
			}
		});
		btnCadastrar.setBounds(162, 79, 96, 25);
		frame.getContentPane().add(btnCadastrar);

		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nome = JOptionPane.showInputDialog("Digite seu nome completo");
				try {
					BufferedReader arq = new BufferedReader(new FileReader(nome + ".txt"));
					jTxtNome.setText(arq.readLine());
					jTxtEmail.setText(arq.readLine());
					jTxtIdade.setText(arq.readLine());
					jTxtSenha.setText("");
					arq.close();
				} catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "N�o foi encontrado o usu�rio no sistema");
					e1.printStackTrace();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Falha ao ler dados do arquivo");
					e1.printStackTrace();
				}
			}
		});
		btnProcurar.setBounds(162, 110, 96, 25);
		frame.getContentPane().add(btnProcurar);
	}
}
