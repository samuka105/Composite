package organograma;

import java.util.ArrayList;
import java.util.List;

public class Departamento extends ComponenteOrg {

    private List<ComponenteOrg> membros = new ArrayList<ComponenteOrg>();

    public Departamento(String nome) {
        super(nome);
    }

    public void adicionar(ComponenteOrg componente) {
        membros.add(componente);
    }

    public int getQuantidadeMembros() {
        return membros.size();
    }

    public double getCusto() {
        double total = 0;
        for (ComponenteOrg membro : membros) {
            total += membro.getCusto();
        }
        return total;
    }

    public int getQuantidadePessoas() {
        int total = 0;
        for (ComponenteOrg membro : membros) {
            total += membro.getQuantidadePessoas();
        }
        return total;
    }

    public String exibir(String prefixo) {
        String saida = prefixo + "+ " + getNome() + " [" + getQuantidadePessoas()
                + " pessoas, R$ " + getCusto() + "]\n";
        for (ComponenteOrg membro : membros) {
            saida += membro.exibir(prefixo + "   ");
        }
        return saida;
    }
}
