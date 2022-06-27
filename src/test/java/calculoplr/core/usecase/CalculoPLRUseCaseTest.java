package calculoplr.core.usecase;

import calculoplr.core.domains.cargo.Cargo;
import calculoplr.core.domains.funcionario.Funcionario;
import calculoplr.core.domains.multiplo.Multiplo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CalculoPLRUseCaseTest {

    @Mock
    private AlavancaUseCase alavancaUseCase;
    private CalculoPLRUseCase calculoPLRUseCase;

    @BeforeEach
    void setUp() {
        this.calculoPLRUseCase = new CalculoPLRUseCase(alavancaUseCase);
    }

    @Test
    void testeCenarioMultiploUmSucesso() {
        when(this.alavancaUseCase.getValorAlavanca(Mockito.any())).thenReturn(BigDecimal.valueOf(80L));

        BigDecimal valor = this.calculoPLRUseCase.calcular(
                Funcionario.builder()
                           .nome("Fulano X")
                           .mesesTrabalhados(12)
                           .salario(BigDecimal.valueOf(2000))
                           .cargo(Cargo.builder()
                                       .familia("Operacional")
                                       .titulo("Assistente")
                                       .build())
                           .classificacao("UN")
                           .avaliacao("C")
                           .build(),
                Multiplo.builder()
                        .familia("Operacional")
                        .classificacao("UN")
                        .pgdd("C")
                        .base(BigDecimal.valueOf(1))
                        .build(),
                BigDecimal.valueOf(100));

        assertEquals(valor.setScale(2, RoundingMode.HALF_DOWN), BigDecimal.valueOf(1600)
                                                                          .setScale(2, RoundingMode.HALF_DOWN));
    }

    @Test
    void testeCenarioMultiploAcimadeUmSucesso() {
        when(this.alavancaUseCase.getValorAlavanca(Mockito.any())).thenReturn(BigDecimal.valueOf(80L));

        BigDecimal valor = this.calculoPLRUseCase.calcular(
                Funcionario.builder()
                           .nome("Fulano X")
                           .mesesTrabalhados(12)
                           .salario(BigDecimal.valueOf(2000))
                           .cargo(Cargo.builder()
                                       .familia("Estratégico")
                                       .titulo("Gerente II")
                                       .build())
                           .classificacao("UN")
                           .avaliacao("C")
                           .build(),
                Multiplo.builder()
                        .familia("Estratégico")
                        .classificacao("UN")
                        .pgdd("C")
                        .base(BigDecimal.valueOf(5))
                        .build(),
                BigDecimal.valueOf(100));

        assertEquals(valor.setScale(2, RoundingMode.HALF_DOWN), BigDecimal.valueOf(8000)
                                                                          .setScale(2, RoundingMode.HALF_DOWN));
    }

    @Test
    void testeCenarioMultiploUmComMenosDeUmAnoSucesso() {
        when(this.alavancaUseCase.getValorAlavanca(Mockito.any())).thenReturn(BigDecimal.valueOf(80L));

        BigDecimal valor = this.calculoPLRUseCase.calcular(
                Funcionario.builder()
                           .nome("Fulano X")
                           .mesesTrabalhados(10)
                           .salario(BigDecimal.valueOf(2000))
                           .cargo(Cargo.builder()
                                       .familia("Operacional")
                                       .titulo("Assistente")
                                       .build())
                           .classificacao("UN")
                           .avaliacao("C")
                           .build(),
                Multiplo.builder()
                        .familia("Operacional")
                        .classificacao("UN")
                        .pgdd("C")
                        .base(BigDecimal.valueOf(1))
                        .build(),
                BigDecimal.valueOf(100));

        assertEquals(valor.setScale(2, RoundingMode.HALF_DOWN), BigDecimal.valueOf(1333.33)
                                                                          .setScale(2, RoundingMode.HALF_DOWN));
    }

    @Test
    void testeCenarioMultiploAcimadeUmComMenosDeUmAnoSucesso() {
        when(this.alavancaUseCase.getValorAlavanca(Mockito.any())).thenReturn(BigDecimal.valueOf(80L));

        BigDecimal valor = this.calculoPLRUseCase.calcular(
                Funcionario.builder()
                           .nome("Fulano X")
                           .mesesTrabalhados(10)
                           .salario(BigDecimal.valueOf(2000))
                           .cargo(Cargo.builder()
                                       .familia("Estratégico")
                                       .titulo("Gerente II")
                                       .build())
                           .classificacao("UN")
                           .avaliacao("C")
                           .build(),
                Multiplo.builder()
                        .familia("Estratégico")
                        .classificacao("UN")
                        .pgdd("C")
                        .base(BigDecimal.valueOf(5))
                        .build(),
                BigDecimal.valueOf(100));

        assertEquals(valor.setScale(2, RoundingMode.HALF_DOWN), BigDecimal.valueOf(6666.67)
                                                                          .setScale(2, RoundingMode.HALF_DOWN));
    }
}