package calculoplr.core.usecase;

import calculoplr.core.domains.funcionario.Funcionario;
import calculoplr.core.domains.multiplo.Multiplo;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>Classe CalculoFuncionarioUseCase responsável por</p>
 *
 * @author Lucas Lima
 * @since 23/06/2022
 **/
public class CalculoFuncionarioUseCase {

    private BuscaFuncionarioUseCase buscaFuncionarioUseCase;
    private BuscaInformacoesMultiploUseCase buscaInformacoesMultiploUseCase;
    private CalculoPLRUseCase calculoPLRUseCase;

    public CalculoFuncionarioUseCase(BuscaFuncionarioUseCase buscaFuncionarioUseCase,
                                     BuscaInformacoesMultiploUseCase buscaInformacoesMultiploUseCase,
                                     CalculoPLRUseCase calculoPLRUseCase) {
        this.buscaFuncionarioUseCase = buscaFuncionarioUseCase;
        this.buscaInformacoesMultiploUseCase = buscaInformacoesMultiploUseCase;
        this.calculoPLRUseCase = calculoPLRUseCase;
    }

    public List<Funcionario> calcular(BigDecimal resultado) {
        List<Funcionario> funcionarios = this.buscaFuncionarioUseCase.buscar();

        funcionarios.stream()
                    .forEach(funcionario -> {
                        Multiplo multiplo = this.buscaInformacoesMultiploUseCase.buscar(funcionario.getCargo(),
                                funcionario.getClassificacao(), funcionario.getAvaliacao());

                        BigDecimal valor = this.calculoPLRUseCase.calcular(funcionario, multiplo, resultado);
                        funcionario.informarValorAReceber(valor);
                    });

        return funcionarios;
    }
}
