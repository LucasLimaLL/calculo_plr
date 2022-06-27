package calculoplr.core.usecase.ports;

import calculoplr.core.domains.funcionario.Funcionario;

import java.util.List;

public interface ExportaDadosFuncionarioPortOut {

    void exportar(List<Funcionario> funcionarios) throws IllegalAccessException;
}
