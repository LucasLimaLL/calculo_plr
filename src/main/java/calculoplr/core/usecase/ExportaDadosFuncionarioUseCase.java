package calculoplr.core.usecase;

import calculoplr.core.domains.funcionario.Funcionario;
import calculoplr.core.usecase.ports.ExportaDadosFuncionarioPortOut;

import java.util.List;

/**
 * <p>Classe ExportaDadosFuncionarioUseCase responsável por</p>
 *
 * @author Lucas Lima
 * @since 23/06/2022
 **/
public class ExportaDadosFuncionarioUseCase {

    private ExportaDadosFuncionarioPortOut exportaDadosFuncionarioPortOut;

    public ExportaDadosFuncionarioUseCase(ExportaDadosFuncionarioPortOut exportaDadosFuncionarioPortOut) {
        this.exportaDadosFuncionarioPortOut = exportaDadosFuncionarioPortOut;
    }

    public void exportar(List<Funcionario> funcionarios) throws IllegalAccessException {
        this.exportaDadosFuncionarioPortOut.exportar(funcionarios);
    }

}
