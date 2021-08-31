package agenda;

/**
 * Uma agenda que mantém uma lista de contatos e favoritos com posições. Podem existir 100 contatos e 10 favoritos. 
 * 
 * @author nazareno
 *
 */
public class Agenda {
	
	/**
	 * Tamanho da agenda.
	 */
	private static final int TAMANHO_AGENDA = 100;
	/**
	 * Tamanho da lista de favoritos.
	 */
	private static final int TAMANHO_FAVORITOS = 10;
	
	/**
	 * Array dos contatos.
	 */
	private Contato[] contatos;
	/**
	 * Array dos favoritos.
	 */
	private Contato[] favoritos;

	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.favoritos = new Contato[TAMANHO_FAVORITOS];
	}
	
	/**
	 * Acessa a lista de contatos mantida e os lista.
	 * @return String do array da lista contatos.
	 */
	public String listarContatos() {
		Contato[] contatos = this.contatos.clone();
		String retorno = "";
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				retorno = retorno + (i+1) + " - " + contatos[i].getNome() + " " + contatos[i].getSobrenome() + "\n"; 	 
			}
		}
		return retorno;
	}
	
	/**
	 * Acessa a lista de favoritos mantida e os lista.
	 * @return String do array da lista favoritos.
	 */
	public String listarFavoritos() {
		Contato[] favoritos = this.favoritos.clone();
		String retorno = "";
		for (int i = 0; i < favoritos.length; i++) {
			if (favoritos[i] != null) {
				retorno = retorno + (i+1) + " - " + favoritos[i].getNome() + " " + favoritos[i].getSobrenome() + "\n";
			}
		}
		return retorno;
	}
	
	/**
	 * Acessa a lista de favoritos mantida e retorna se um contato ja está favoritado.
	 * @param contato O contato a ser comparado.
	 * @param favoritos A lista que vão ter seus contatos comparados.
	 * @return Variável booleana indicando se o contato ja esta na lista de favoritos ou não.
	 */
	public boolean jaFavoritado(Contato contato) {
		boolean jaFavoritado = false;
		for(int i = 0; i < favoritos.length; i++) {
			if(contato.equals(favoritos[i]) == true) {
				jaFavoritado = true;
				break;
			}
		}
		return jaFavoritado;
	}
	
	/**
	 * Acessa a lista de contatos mantida e retorna se um contato ja está cadastrado.
	 * @param contato O contato a ser comparado.
	 * @param contatos A lista que vão ter seus contatos comparados.
	 * @return Variável booleana indicando se o contato já esta na lista de favoritos ou não.
	 */
	public boolean jaCadastrado(Contato contato) {
		boolean jaCadastrado = false;
		for(int i = 0; i < contatos.length; i++) {
			if(contato.equals(contatos[i]) == true) {
				jaCadastrado = true;
				break;
			}
		}
		return jaCadastrado;
	}

	/**
	 * Acessa os dados de um contato específico.
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Null se não há contato na posição.
	 */
	public String getContato(int posicao) {
		if(jaFavoritado(contatos[posicao-1]) == true){
			return "❤️ " + contatos[posicao-1].dados();
		}else {
			return contatos[posicao-1].dados();
		}
	}

	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior. 
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone1 Primeiro número.
	 * @param telefone2 Segundo número.
	 * @param telefone3 Número adicional.
	 * @param prioritario Indica qual dos telefones é o prioritário.
	 * @param whatsapp Indica qual dos telefones é o prioritário.
	 * @return Retorna se o cadastro foi realizado com sucesso.
	 */
	public boolean cadastraContato(int posicao, String nome, String sobrenome, String telefone1, String telefone2, String telefone3, int prioritario, int whatsapp) {
		boolean cadastro;
		String numPrioritario;
		if(prioritario == 1) {
			numPrioritario = telefone1;
		}else{
			numPrioritario = telefone2;
		}
		String numWhatsapp;
		if(whatsapp == 1) {
			numWhatsapp = telefone1;
		}else{
			numWhatsapp = telefone2;
		}
		Contato contatoTeste = new Contato(nome, sobrenome, numPrioritario, numWhatsapp, telefone3);
		if(jaCadastrado(contatoTeste) == false) {
			contatos[posicao-1] = new Contato(nome, sobrenome, numPrioritario, numWhatsapp, telefone3);
			cadastro = true;
		}else {
			cadastro = false;
		}
		return cadastro;
	}
	
	/**
	 * Adiciona um contato em uma posição da lista de favoritos. Adicionar em uma posição que já existe sobrescreve o anterior. 
	 * @param contato Posição do contato.
	 * @param posicao Posição na lista de favoritos.
	 * @return Uma variável booleana que indica se o contato foi favoritado ou não.
	 */
	public boolean adicionaFavorito(int contato, int posicao) {
		boolean favoritado;
		if(jaFavoritado(contatos[contato-1]) == true) {
			favoritado = false;
		} else {
			favoritos[posicao-1] = contatos[contato-1];
			favoritado = true;
		}
		return favoritado;
	}
}