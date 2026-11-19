package organograma;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrganogramaTest {

    @Test
    public void testCustoFuncionario() {
        Funcionario f = new Funcionario("Ana", "Analista", 5000.0);
        assertEquals(5000.0, f.getCusto(), 0.001);
    }

    @Test
    public void testFuncionarioContaUmaPessoa() {
        Funcionario f = new Funcionario("Ana", "Analista", 5000.0);
        assertEquals(1, f.getQuantidadePessoas());
    }

    @Test
    public void testCustoDepartamentoSoma() {
        Departamento d = new Departamento("TI");
        d.adicionar(new Funcionario("Bruno", "Dev", 7000.0));
        d.adicionar(new Funcionario("Carla", "Dev", 8000.0));
        assertEquals(15000.0, d.getCusto(), 0.001);
    }

    @Test
    public void testDepartamentoVazio() {
        Departamento d = new Departamento("Vazio");
        assertEquals(0.0, d.getCusto(), 0.001);
        assertEquals(0, d.getQuantidadePessoas());
    }

    @Test
    public void testCustoRecursivoAninhado() {
        Departamento interno = new Departamento("Interno");
        interno.adicionar(new Funcionario("X", "Dev", 3000.0));
        interno.adicionar(new Funcionario("Y", "Dev", 4000.0));

        Departamento raiz = new Departamento("Raiz");
        raiz.adicionar(new Funcionario("Z", "Gerente", 10000.0));
        raiz.adicionar(interno);

        assertEquals(17000.0, raiz.getCusto(), 0.001);
    }

    @Test
    public void testQuantidadePessoasRecursiva() {
        Departamento interno = new Departamento("Interno");
        interno.adicionar(new Funcionario("X", "Dev", 3000.0));
        interno.adicionar(new Funcionario("Y", "Dev", 4000.0));

        Departamento raiz = new Departamento("Raiz");
        raiz.adicionar(new Funcionario("Z", "Gerente", 10000.0));
        raiz.adicionar(interno);

        assertEquals(3, raiz.getQuantidadePessoas());
    }

    @Test
    public void testFolhaECompostoTratadosIgual() {
        Departamento raiz = new Departamento("Raiz");
        ComponenteOrg funcionario = new Funcionario("Ana", "Analista", 5000.0);
        ComponenteOrg subdept = new Departamento("Sub");
        raiz.adicionar(funcionario);
        raiz.adicionar(subdept);
        assertEquals(2, raiz.getQuantidadeMembros());
    }

    @Test
    public void testExibirFuncionarioTemFormato() {
        Funcionario f = new Funcionario("Ana", "Analista", 5000.0);
        assertEquals("- Ana (Analista, R$ 5000.0)\n", f.exibir(""));
    }

    @Test
    public void testExibirDepartamentoIncluiMembros() {
        Departamento d = new Departamento("TI");
        d.adicionar(new Funcionario("Bruno", "Dev", 7000.0));
        String saida = d.exibir("");
        assertTrue(saida.contains("+ TI"));
        assertTrue(saida.contains("- Bruno (Dev, R$ 7000.0)"));
    }

    @Test
    public void testExibirMostraCustoEPessoasNoDepartamento() {
        Departamento d = new Departamento("TI");
        d.adicionar(new Funcionario("Bruno", "Dev", 7000.0));
        d.adicionar(new Funcionario("Carla", "Dev", 8000.0));
        assertTrue(d.exibir("").contains("TI [2 pessoas, R$ 15000.0]"));
    }

    @Test
    public void testExibirIndentacaoAninhada() {
        Departamento interno = new Departamento("Sub");
        interno.adicionar(new Funcionario("X", "Dev", 3000.0));
        Departamento raiz = new Departamento("Raiz");
        raiz.adicionar(interno);
        String saida = raiz.exibir("");
        assertTrue(saida.contains("   + Sub"));
        assertTrue(saida.contains("      - X"));
    }
}
