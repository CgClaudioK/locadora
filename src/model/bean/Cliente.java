package model.bean;

public class Cliente {
	
		private String nome;
		private int cpf;	
		private boolean sexo;
			
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String setEndereco(String endereco) {
			return endereco;
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
		public void setMasculino(boolean b) {
			// TODO Auto-generated method stub
			
		}
		public void setFeminino(boolean b) {
			// TODO Auto-generated method stub
			
		}
		public String getEndereco() {
			// TODO Auto-generated method stub
			return null;
		}
		
		
		
		

}
