package model.bean;

public class Cliente {
	
		private String nome;
		private int cpf;	
		private boolean sexo;
		private String endereco;
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public int getCpf() {
			return cpf;
		}
		public void setCpf(int cpf) {
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
		
	
		
		
		
		


