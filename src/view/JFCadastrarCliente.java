package view;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.bean.Cliente;
import model.dao.ClienteDAO;


import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFCadastrarCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtCPF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFCadastrarCliente frame = new JFCadastrarCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFCadastrarCliente() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 561, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CADASTRO DE CLIENTES : LOCADORA");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 350, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NOME");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 40, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 65, 416, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("ENDERE\u00C7O");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 139, 109, 14);
		contentPane.add(lblNewLabel_2);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(10, 164, 416, 20);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("SEXO");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(10, 195, 65, 14);
		contentPane.add(lblNewLabel_4);
		
		JRadioButton rdbtnF = new JRadioButton("FEMININO");
		rdbtnF.setBounds(127, 216, 120, 23);
		contentPane.add(rdbtnF);
		
		JRadioButton rdbtnM = new JRadioButton("MASCULINO");
		rdbtnM.setBounds(0, 216, 119, 23);
		contentPane.add(rdbtnM);
		
		ButtonGroup imagem = new ButtonGroup();
		imagem.add(rdbtnF);
		imagem.add(rdbtnM);
		
		JLabel lblNewLabel_3 = new JLabel("CPF");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(10, 91, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		txtCPF = new JTextField();
		txtCPF.setBounds(11, 116, 109, 20);
		contentPane.add(txtCPF);
		txtCPF.setColumns(15);
		
	
		
		
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente c = new Cliente();
				ClienteDAO dao = new ClienteDAO();
				c.setNome(txtNome.getText());
				c.setEndereco(txtEndereco.getText());
				c.setCpf(Integer.parseInt(txtCPF.getText()));
				if(rdbtnM.isSelected()) {
					c.setMasculino(false);
				}else if (rdbtnF.isSelected()) {
					c.setFeminino(true);
				}
				
				dao.create(c);
				dispose();
			}
			
		});
		 btnCadastrar.setBounds(10, 273, 109, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText(null);
				txtCPF.setText(null);
				txtEndereco.setText(null);
				imagem.clearSelection();
				
			}
		});
		btnLimpar.setBounds(158, 273, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(337, 273, 116, 23);
		contentPane.add(btnCancelar);
		
		dispose();
		
	}
}