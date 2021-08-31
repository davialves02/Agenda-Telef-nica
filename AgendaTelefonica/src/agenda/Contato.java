package agenda;

/**
 * Um contato que mantém uma série de dados, como:nome, sobrenome, e os seus números. 
 * 
 * @author Davi Alves
 *
 */
public class Contato {
	/**
	 * Nome do contato.
	 */
	private String nome;
	/**
	 * Sobrenome do contato.
	 */
	private String sobrenome;
	/**
	 * Número Prioritário do contato.
	 */
	private String numPrioritario;
	/**
	 * Número do Whatsapp do contato.
	 */
	private String numWhatsapp;
	/**
	 * Número adicional do contato. Ele é opcional.
	 */
	private String numAdicional;
	
	/**
	 * Cria um contato.
	 */
	public Contato(String nome, String sobrenome, String prioritario, String whatsapp, String adicional){
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.numPrioritario = prioritario;
		this.numWhatsapp = whatsapp;
		this.numAdicional = adicional;
		
	}
	
	/**
	 * Retorna o nome do contato.
	 * @return nome.
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Retorna o sobrenome do contato.
	 * @return sobrenome.
	 */
	public String getSobrenome() {
		return this.sobrenome;
	}
	
	/**
	 * Retorna os dados do contato.
	 * @return sobrenome.
	 */
	public String dados() {
		String adicional = this.numAdicional;
		if(adicional.trim().isEmpty() || adicional.equals("")){
			return this.nome + " " + this.sobrenome + "\n" + this.numPrioritario + " (Prioritário)\n" + this.numWhatsapp + " (Whatsapp)";
		}else {
			return this.nome + " " + this.sobrenome + "\n" + this.numPrioritario + " (Prioritário)\n" + this.numWhatsapp + " (Whatsapp)\n" + this.numAdicional + " (Adicional)";
		}
	}
	
	/**
	 * Sobreposicao do método equals.
	 * @return se os contatos são iguais.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if(this.getClass() != obj.getClass()) {
			return false;
		}
		Contato outroContato = (Contato) obj;
		if(this.nome.equals(outroContato.getNome())==true && this.sobrenome.equals(outroContato.getSobrenome())==true) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Sobreposicao do método hashCode.
	 * @return hashCode do nome.
	 */
	@Override
	public int hashCode() {
		return this.nome.hashCode();
	}
}
