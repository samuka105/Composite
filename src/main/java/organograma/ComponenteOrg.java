package organograma;

public abstract class ComponenteOrg {

    private String nome;

    public ComponenteOrg(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public abstract double getCusto();

    public abstract int getQuantidadePessoas();

    public abstract String exibir(String prefixo);
}
