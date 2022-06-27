package calculoplr.core.usecase;

import calculoplr.core.domains.funcionario.Funcionario;
import calculoplr.core.domains.multiplo.Multiplo;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculoPLRUseCase {

    private AlavancaUseCase alavancaUseCase;

    public CalculoPLRUseCase(AlavancaUseCase alavancaUseCase) {
        this.alavancaUseCase = alavancaUseCase;
    }

    public BigDecimal calcular(Funcionario funcionario, Multiplo multiplo, BigDecimal resultado) {

        BigDecimal valorAlavanca = this.alavancaUseCase.getValorAlavanca(resultado)
                                                       .divide(BigDecimal.valueOf(100));
        return funcionario.getSalario()
                          .multiply(multiplo.getAlanvacador(valorAlavanca))
                          .divide(BigDecimal.valueOf(12), 12, RoundingMode.HALF_UP)
                          .multiply(BigDecimal.valueOf(funcionario.getMesesTrabalhados()));
    }
}
