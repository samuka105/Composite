package organograma;

public class Main {

    public static void main(String[] args) {
        Departamento empresa = new Departamento("Empresa");
        empresa.adicionar(new Funcionario("Helena", "CEO", 20000.0));

        Departamento ti = new Departamento("TI");
        ti.adicionar(new Funcionario("Rafael", "Gerente", 12000.0));
        ti.adicionar(new Funcionario("Bruno", "Desenvolvedor", 7000.0));
        ti.adicionar(new Funcionario("Carla", "Desenvolvedora", 7000.0));
        empresa.adicionar(ti);

        Departamento rh = new Departamento("RH");
        rh.adicionar(new Funcionario("Mariana", "Gerente", 10000.0));
        rh.adicionar(new Funcionario("Paulo", "Analista", 5000.0));
        empresa.adicionar(rh);

        System.out.print(empresa.exibir(""));
        System.out.println("Custo total: R$ " + empresa.getCusto());
        System.out.println("Total de pessoas: " + empresa.getQuantidadePessoas());
    }
}
