package calculoplr.application;

import calculoplr.adapter.output.excel.BuscaInformacoesMultiploGateway;
import calculoplr.adapter.output.excel.BuscaItensAlavancaGateway;
import calculoplr.adapter.output.excel.ExportaDadosFuncionarioGateway;
import calculoplr.adapter.output.excel.LeituraFuncionarioGateway;
import calculoplr.core.domains.funcionario.Funcionario;
import calculoplr.core.usecase.AlavancaUseCase;
import calculoplr.core.usecase.BuscaFuncionarioUseCase;
import calculoplr.core.usecase.BuscaInformacoesMultiploUseCase;
import calculoplr.core.usecase.CalculoFuncionarioUseCase;
import calculoplr.core.usecase.CalculoPLRUseCase;
import calculoplr.core.usecase.ExportaDadosFuncionarioUseCase;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>Classe calculoplr.application.CalculoPlrApplication responsável por</p>
 *
 * @author Lucas Lima
 * @since 03/06/2022
 **/
public class CalculoPlrApplication {

    public static void main(String[] args) throws IllegalAccessException {

        BuscaInformacoesMultiploUseCase buscaInformacoesMultiploUseCase =
                new BuscaInformacoesMultiploUseCase(new BuscaInformacoesMultiploGateway(args[0]));

        BuscaFuncionarioUseCase buscaFuncionarioUseCase =
                new BuscaFuncionarioUseCase(new LeituraFuncionarioGateway(args[0]));

        AlavancaUseCase alavancaUseCase = new AlavancaUseCase(new BuscaItensAlavancaGateway(args[0]));

        CalculoPLRUseCase calculoPLRUseCase = new CalculoPLRUseCase(alavancaUseCase);

        CalculoFuncionarioUseCase calculoFuncionarioUseCase = new CalculoFuncionarioUseCase(buscaFuncionarioUseCase,
                buscaInformacoesMultiploUseCase, calculoPLRUseCase);

        List<Funcionario> funcionarios = calculoFuncionarioUseCase.calcular(BigDecimal.valueOf(100));
        ExportaDadosFuncionarioUseCase exportaDadosFuncionarioUseCase =
                new ExportaDadosFuncionarioUseCase(new ExportaDadosFuncionarioGateway(args[2]));
        exportaDadosFuncionarioUseCase.exportar(funcionarios);
    }
}
