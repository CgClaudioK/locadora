package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.bean.Cliente;
import model.dao.ClienteDAO;

public class JFAtualizarCliente extends JFrame {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	
	
	private static int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFAtualizarCliente frame = new JFAtualizarCliente(id);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return 
	 */
	public JFAtualizarCliente(int id) {
		
		setTitle("Alterar Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ALTERAR CADASTRO DE CLIENTES : LOCADORA");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 350, 20);
		contentPane.add(lblNewLabel);
		
		ClienteDAO cdao = new ClienteDAO();
		Cliente c = cdao.read(id);
		
		JLabel lblNewLabel_7 = new JLabel("ID do Cliente");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(158, 37, 89, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblId = new JLabel("New label");
		lblId.setBounds(246, 38, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblNewLabel_1 = new JLabel("NOME");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 40, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JTextField txtNome = new JTextField();
		txtNome.setBounds(10, 65, 416, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("ENDERE\u00C7O");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 139, 109, 14);
		contentPane.add(lblNewLabel_2);
		
		JTextField txtEndereco = new JTextField();
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
		
		JTextField txtCPF = new JTextField();
		txtCPF.setBounds(11, 116, 109, 20);
		contentPane.add(txtCPF);
		txtCPF.setColumns(15);
		
		lblId.setText(String.valueOf(c.getIdCliente()));
		txtNome.setText(c.getNome());
		txtEndereco.setText(c.getEndereco());
		txtCPF.setText(Long.toString(c.getCpf()));	
		if(rdbtnM.isSelected()) {
			c.setSexo(false);
		}else if (rdbtnF.isSelected()) {
			c.setSexo(true);
		}
		
	
	
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente c = new Cliente();
				ClienteDAO dao = new ClienteDAO();
				c.setIdCliente(Integer.parseInt(lblId.getText()));
				c.setNome(txtNome.getText());
				c.setEndereco(txtEndereco.getText());
				c.setCpf(Integer.parseInt(txtCPF.getText()));
				if(rdbtnM.isSelected()) {
					c.setMasculino(false);
				}else if (rdbtnF.isSelected()) {
					c.setFeminino(true);
				}
		
				dao.update(c);
			}
		
		});
		btnAlterar.setBounds(10, 400, 89, 23);
		contentPane.add(btnAlterar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(137, 400, 89, 23);
		contentPane.add(btnLimpar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(269, 400, 89, 23);
		contentPane.add(btnCancelar);




		
}

}

