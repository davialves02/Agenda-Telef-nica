import static org.junit.jupiter.api.Assertions.*;	

import org.junit.jupiter.api.Test;

import agenda.Agenda;
import agenda.Contato;

class AgendaTest {
	
	@Test
	public void cadastraContatoTeste() {
		Agenda agenda = new Agenda();
		assertTrue(agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002",1,2)); 
	}
	
	@Test
	public void cadastraMesmaPosicaoTeste() {
		Agenda agenda = new Agenda();
		assertTrue(agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002",1,2));
		assertTrue(agenda.cadastraContato(1, "Pedro", "Silva", "(84) 98888-1111", "(84) 98888-1112", "(84) 98888-1113",1,2));
	}
	
	@Test
	public void cadastraMesmaPessoaTeste() {
		Agenda agenda = new Agenda();
		assertTrue(agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002",1,2));
		assertFalse(agenda.cadastraContato(3, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002",1,2));
	}
	
	@Test
	public void cadastraNoLimiteTeste() {
		Agenda agenda = new Agenda();
		assertTrue(agenda.cadastraContato(100, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002",1,2));
	}
	
	@Test
	public void cadastraAcimaLimiteTeste() {
		Agenda agenda = new Agenda();
		try {
			agenda.cadastraContato(101, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002",1,1);
		}catch(IndexOutOfBoundsException npe){
		}
	}
	
	@Test
	public void cadastraAbaixoLimiteTeste() {
		Agenda agenda = new Agenda();
		try {
			agenda.cadastraContato(0, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002",1,2);
		}catch(IndexOutOfBoundsException npe){
		}
	}
	
	@Test
	public void cadastraTelefoneVazio() {
		Agenda agenda = new Agenda();
		assertTrue(agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "",1,2));
	}
	
	@Test
	public void contatoJaCadastradoTeste() {
		Agenda agenda = new Agenda();
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002",1,2);
		agenda.cadastraContato(2, "Pedro", "Silva", "(84) 98888-1111", "(84) 98888-1112", "84) 98888-1113",1,2);
		Contato contatoTeste2 = new Contato("Pedro", "Silva", "(84) 98888-1111", "(84) 98888-1112", "84) 98888-1113");
		Contato contatoTeste = new Contato("Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002");
		assertTrue(agenda.jaCadastrado(contatoTeste));
		assertTrue(agenda.jaCadastrado(contatoTeste2));
	}
	
	@Test
	public void contatoJaCadastradoAcimaLimiteTeste() {
		Agenda agenda = new Agenda();
		try {
			agenda.cadastraContato(101, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002",1,1);
		}catch(IndexOutOfBoundsException npe){
		}
		Contato contatoTeste = new Contato("Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002");
		assertFalse(agenda.jaCadastrado(contatoTeste));
	}
	
	@Test
	public void contatoJaCadastradoAbaixoLimiteTeste() {
		Agenda agenda = new Agenda();
		try {
			agenda.cadastraContato(0, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002",1,1);
		}catch(IndexOutOfBoundsException npe){
		}
		Contato contatoTeste = new Contato("Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002");
		assertFalse(agenda.jaCadastrado(contatoTeste));
	}
	
	@Test
	public void contatoNaoCadastradoTeste() {
		Agenda agenda = new Agenda();
		Contato contatoTeste = new Contato("Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002");
		assertFalse(agenda.jaCadastrado(contatoTeste));
	}
	
	@Test
	public void exibeContatoTeste() {
		Agenda agenda = new Agenda();
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002",1,2);
		assert agenda.getContato(1).equals("Matheus Gaudencio\n" + 
				"(83) 99999-0000 (Prioritário)\n" + 
				"(83) 99999-0001 (Whatsapp)\n" + 
				"(83) 99999-0002 (Adicional)");
	}
	
	@Test
	public void exibeContatoSemAdicionalTeste() {
		Agenda agenda = new Agenda();
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "",1,2);
		assert agenda.getContato(1).equals("Matheus Gaudencio\n" + 
				"(83) 99999-0000 (Prioritário)\n" + 
				"(83) 99999-0001 (Whatsapp)");
	}
	
	@Test
	public void exibeContatoNuloTeste(){
		Agenda agenda = new Agenda();
		try{
			agenda.getContato(1);
		}catch(NullPointerException npe) {
			
		}
	}
	
	@Test
	public void exibeContatoLimiteTeste() {
		Agenda agenda = new Agenda();
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002",1,2);
		agenda.cadastraContato(100, "Pedro", "Silva", "(84) 98888-1111", "(84) 98888-1112", "(84) 98888-1113",1,2);
		assert agenda.getContato(1).equals("Matheus Gaudencio\n" + 
				"(83) 99999-0000 (Prioritário)\n" + 
				"(83) 99999-0001 (Whatsapp)\n" + 
				"(83) 99999-0002 (Adicional)");
		assert agenda.getContato(100).equals("Pedro Silva\n" + 
				"(84) 98888-1111 (Prioritário)\n" + 
				"(84) 98888-1112 (Whatsapp)\n" + 
				"(84) 98888-1113 (Adicional)");
	}
	
	@Test
	public void exibeContatoAbaixoLimiteTeste(){
		Agenda agenda = new Agenda();
		try{
			agenda.cadastraContato(0, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002",1,2);
			agenda.getContato(0);
		}catch(IndexOutOfBoundsException npe) {
			
		}
	}

	@Test
	public void exibeContatoAcimaLimiteTeste(){
		Agenda agenda = new Agenda();
		try{
			agenda.cadastraContato(101, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002",1,2);
			agenda.getContato(101);
		}catch(IndexOutOfBoundsException npe) {
			
		}
	}
	
	@Test
	public void ExibeContatoFavoritadoTeste() {
		Agenda agenda = new Agenda();
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002",1,2);
		agenda.adicionaFavorito(1, 1);
		assert agenda.getContato(1).equals("❤️ Matheus Gaudencio\n" + 
				"(83) 99999-0000 (Prioritário)\n" + 
				"(83) 99999-0001 (Whatsapp)\n" + 
				"(83) 99999-0002 (Adicional)");
	}
	
	@Test
	public void ExibeContatoFavoritadoSemAdicionalTeste() {
		Agenda agenda = new Agenda();
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "",1,2);
		agenda.adicionaFavorito(1, 1);
		assert agenda.getContato(1).equals("❤️ Matheus Gaudencio\n" + 
				"(83) 99999-0000 (Prioritário)\n" + 
				"(83) 99999-0001 (Whatsapp)");
	}
	
	@Test
	public void listaContatosTeste() {
		Agenda agenda = new Agenda();
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002",1,2);
		assert agenda.listarContatos().equals("1 - Matheus Gaudencio\n");
	}
	
	@Test
	public void listaAgendaSemContatos() {
		Agenda agenda = new Agenda();
		assert agenda.listarContatos().equals("");
	}
	
	@Test
	public void listaContatosLimiteTeste() {
		Agenda agenda = new Agenda();
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002",1,2);
		agenda.cadastraContato(100, "Pedro", "Silva", "(84) 98888-1111", "(84) 98888-1112", "84) 98888-1113",1,2);
		assert agenda.listarContatos().equals("1 - Matheus Gaudencio\n" + 
											"100 - Pedro Silva\n");
	}
	
	@Test
	public void listaContatoAcimaLimiteTeste() {
		Agenda agenda = new Agenda();
		try{
			agenda.cadastraContato(101, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002",1,2);
		}catch(IndexOutOfBoundsException npe) {
			
		}
		assert agenda.listarContatos().equals("");
	}
	
	@Test
	public void listaContatoAbaixoLimiteTeste() {
		Agenda agenda = new Agenda();
		try{
			agenda.cadastraContato(0, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002",1,2);
		}catch(IndexOutOfBoundsException npe) {
			
		}
		assert agenda.listarContatos().equals("");
	}
	
	@Test 
	public void  adicionaFavoritosTeste() {
		Agenda agenda = new Agenda();
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002",1,2);
		assertTrue(agenda.adicionaFavorito(1, 1));
	}
	
	@Test 
	public void  adicionaFavoritosMesmaPosicaoTeste() {
		Agenda agenda = new Agenda();
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002",1,2);
		agenda.cadastraContato(2, "Pedro", "Silva", "(84) 98888-1111", "(84) 98888-1112", "84) 98888-1113",1,2);
		assertTrue(agenda.adicionaFavorito(1, 1));
		assertTrue(agenda.adicionaFavorito(2, 1));
		assert agenda.listarFavoritos().equals("1 - Pedro Silva\n");
	}
	
	@Test 
	public void  adicionaFavoritosMesmaPessoaTeste() {
		Agenda agenda = new Agenda();
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002",1,2);
		assertTrue(agenda.adicionaFavorito(1, 1));
		assertFalse(agenda.adicionaFavorito(1, 5));
	}
	
	@Test 
	public void  adicionaFavoritosPosicaoLimite() {
		Agenda agenda = new Agenda();
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002",1,2);
		agenda.cadastraContato(100, "Pedro", "Silva", "(84) 98888-1111", "(84) 98888-1112", "84) 98888-1113",1,2);
		assertTrue(agenda.adicionaFavorito(1, 1));
		assertTrue(agenda.adicionaFavorito(100, 10));
	}
	
	@Test
	public void adicionaFavoritoAcimaLimiteTeste() {
		Agenda agenda = new Agenda();
		try {
			agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002",1,2);
			agenda.adicionaFavorito(1, 11);
		}catch(IndexOutOfBoundsException npe){
		}
	}
	
	@Test
	public void adicionaFavoritoAbaixoLimiteTeste() {
		Agenda agenda = new Agenda();
		try {
			agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002",1,2);
			agenda.adicionaFavorito(1, 0);
		}catch(IndexOutOfBoundsException npe){
		}
	}
	
	@Test
	public void contatoJaFavoritadoTeste() {
		Agenda agenda = new Agenda();
		agenda.cadastraContato(2, "Pedro", "Silva", "(84) 98888-1111", "(84) 98888-1112", "84) 98888-1113",1,2);
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002",1,2);
		agenda.adicionaFavorito(1, 1);
		agenda.adicionaFavorito(2, 10);
		Contato contatoTeste = new Contato("Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002");
		Contato contatoTeste2 = new Contato("Pedro", "Silva", "(84) 98888-1111", "(84) 98888-1112", "84) 98888-1113");
		assertTrue(agenda.jaFavoritado(contatoTeste));
		assertTrue(agenda.jaFavoritado(contatoTeste2));
	}
	
	@Test
	public void contatoJaFavoritadoAcimaLimite() {
		Agenda agenda = new Agenda();
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002",1,2);
		try {
			agenda.adicionaFavorito(1, 11);
		}catch(IndexOutOfBoundsException npe) {
			
		}
		Contato contatoTeste = new Contato("Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002");
		assertFalse(agenda.jaFavoritado(contatoTeste));
	}
	
	@Test
	public void contatoJaFavoritadoAbaixoLimite() {
		Agenda agenda = new Agenda();
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002",1,2);
		try {
			agenda.adicionaFavorito(1, 0);
		}catch(IndexOutOfBoundsException npe) {
			
		}
		Contato contatoTeste = new Contato("Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002");
		assertFalse(agenda.jaFavoritado(contatoTeste));
	}
	
	@Test
	public void contatoNaoFavoritadoTeste() {
		Agenda agenda = new Agenda();
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002",1,2);
		Contato contatoTeste = new Contato("Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002");
		assertFalse(agenda.jaFavoritado(contatoTeste));
	}
	
	@Test
	public void exibeFavoritosTeste() {
		Agenda agenda = new Agenda();
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002",1,2);
		agenda.adicionaFavorito(1, 1);
		assert agenda.listarFavoritos().equals("1 - Matheus Gaudencio\n");
	}
	
	@Test
	public void listaFavoritosLimiteTeste() {
		Agenda agenda = new Agenda();
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002",1,2);
		agenda.cadastraContato(2, "Pedro", "Silva", "(84) 98888-1111", "(84) 98888-1112", "84) 98888-1113",1,2);
		agenda.adicionaFavorito(1, 1);
		agenda.adicionaFavorito(2, 10);
		assert agenda.listarFavoritos().equals("1 - Matheus Gaudencio\n" + 
											"10 - Pedro Silva\n");
	}
	
	@Test
	public void listaFavoritosAcimaLimiteTeste() {
		Agenda agenda = new Agenda();
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002",1,2);
		try{
			agenda.adicionaFavorito(1, 11);
		}catch(IndexOutOfBoundsException npe) {
			
		}
		assert agenda.listarFavoritos().equals("");
	}
	
	@Test
	public void listaFavoritosAbaixoLimiteTeste() {
		Agenda agenda = new Agenda();
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002",1,2);
		try{
			agenda.adicionaFavorito(1, 0);
		}catch(IndexOutOfBoundsException npe) {
			
		}
		assert agenda.listarFavoritos().equals("");
	}
	
	@Test
	public void criaContatoTeste() {
		Contato contatoTeste = new Contato("Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002");
	}
	
	@Test
	public void dadosContatoTeste() {
		Contato contatoTeste = new Contato("Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002");
		assert contatoTeste.dados().equals("Matheus Gaudencio\n" + 
				"(83) 99999-0000 (Prioritário)\n" + 
				"(83) 99999-0001 (Whatsapp)\n" + 
				"(83) 99999-0002 (Adicional)");
	}
	
	@Test
	public void dadosContatoSemAdicionalTeste() {
		Contato contatoTeste = new Contato("Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "");
		assert contatoTeste.dados().equals("Matheus Gaudencio\n" + 
				"(83) 99999-0000 (Prioritário)\n" + 
				"(83) 99999-0001 (Whatsapp)");
	}
	
	@Test
	public void contatoEqualsTeste() {
		Contato contatoTeste = new Contato("Matheus", "Gaudencio", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002");
		Contato contatoTeste2 = new Contato("Matheus", "Gaudencio", "(83) 99999-0003", "(83) 99999-0004", "");
		assertTrue(contatoTeste.equals(contatoTeste2));
	}
	
	@Test
	public void contatoEqualsNomesDiferentesTeste() {
		Contato contatoTeste = new Contato("Pedro", "Silva", "(83) 99999-0000", "(83) 99999-0001", "(83) 99999-0002");
		Contato contatoTeste2 = new Contato("Matheus", "Gaudencio", "(83) 99999-0003", "(83) 99999-0004", "");
		assertFalse(contatoTeste.equals(contatoTeste2));
	}
}

