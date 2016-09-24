package br.sceweb.teste;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.EmpresaDAO;

public class UC02ConsultarEmpresa {

	static Empresa resultadoEsperado;
	static Empresa resultadoObtido;
	static EmpresaDAO EmpresaDAO;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		resultadoEsperado = new Empresa();
		resultadoEsperado.setCnpj("26239390000140");
		resultadoEsperado.setNomeDaEmpresa("Bahia's HOUSE");
		resultadoEsperado.setNomeFantasia("TESTE");
		resultadoEsperado.setTelefone("12341234");
		EmpresaDAO = new EmpresaDAO();
		EmpresaDAO.adiciona(resultadoEsperado);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@After
	public void excluiEmpresa(){
		EmpresaDAO.exclui("26239390000140");
	}

	@Test
	public void CT01UC02FBConsultarEmpresaComSucesso() {
		resultadoObtido = EmpresaDAO.consulta("26239390000140");
		assertTrue("J·È", resultadoEsperado.equals(resultadoObtido));
	}

}
