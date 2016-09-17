package br.sceweb.teste;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.EmpresaDAO;

public class UC01CadastrarEMpresa {

	static Empresa empresa;
	static EmpresaDAO empresaDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresaDAO = new EmpresaDAO();
		empresa = new Empresa();
		empresa.setNomeDaEmpresa("empresa x");
		empresa.setCnpj("89424232000180");
		empresa.setNomeFantasia("empresa x");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("2222");
	}
	
	@BeforeClass
	public static void excluiCNPJ(){
		empresaDAO.exclui("89424232000180");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void CT01UC01FBCadastrarEmpresa_com_sucesso() {
		assertEquals(1, empresaDAO.adiciona(empresa));
	}

	
	@Test(expected=RuntimeException.class)
	public void CT02UC01FBCadastrarEmpresa_com_CNPJ_invalido() {
		empresaDAO.adiciona(empresa);
		empresaDAO.adiciona(empresa);
	}
}
