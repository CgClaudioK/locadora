package model.bean;

public class Cliente {
	
		private int idCliente;
		private String nome;
		private long cpf;	
		private boolean sexo;
		private String endereco;
		
		public String getNome() {
			return nome;
		}
		public int getIdCliente() {
			return idCliente;
		}
		public void setIdCliente(int idCliente) {
			this.idCliente = idCliente;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public long getCpf() {
			return cpf;
		}
		public void setCpf(long cpf) {
			this.cpf = cpf;
		}
		public boolean isSexo() {
			return sexo;
		}
		public void setSexo(boolean sexo) {
			this.sexo = sexo;
		}
		public String getEndereco() {
			return endereco;
		}
		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}
		public void setMasculino(boolean sexo) {
			this.sexo = false;
			
			
		}
		public void setFeminino(boolean sexo) {
			this.sexo = true;
			
		}
		
	
			
		}
		
	
		
		
		
		


