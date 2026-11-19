package organograma;

public class Funcionario extends ComponenteOrg {

    private String cargo;
    private double salario;

    public Funcionario(String nome, String cargo, double salario) {
        super(nome);
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public double getCusto() {
        return salario;
    }

    public int getQuantidadePessoas() {
        return 1;
    }

    public String exibir(String prefixo) {
        return prefixo + "- " + getNome() + " (" + cargo + ", R$ " + salario + ")\n";
    }
}
