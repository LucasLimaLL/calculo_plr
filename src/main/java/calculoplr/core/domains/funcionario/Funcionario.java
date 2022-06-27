package calculoplr.core.domains.funcionario;

import calculoplr.core.domains.cargo.Cargo;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class Funcionario {

    private String nome;
    private Integer mesesTrabalhados;
    private Cargo cargo;
    private String classificacao;
    private String avaliacao;
    private BigDecimal salario;
    private BigDecimal valorAReceber;

    @Builder(toBuilder = true)
    public Funcionario(String nome, Integer mesesTrabalhados, Cargo cargo, String classificacao, String avaliacao,
                       BigDecimal salario) {
        this.nome = nome;
        this.mesesTrabalhados = mesesTrabalhados;
        this.cargo = cargo;
        this.classificacao = classificacao;
        this.avaliacao = avaliacao;
        this.salario = salario;
    }

    public void informarValorAReceber(BigDecimal valorAReceber) {
        this.valorAReceber = valorAReceber;
    }
}
