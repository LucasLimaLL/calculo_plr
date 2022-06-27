package calculoplr.core.usecase;

import calculoplr.core.domains.funcionario.Funcionario;
import calculoplr.core.usecase.ports.LeituraFuncionarioPortOut;

import java.util.List;

public class BuscaFuncionarioUseCase {

    private LeituraFuncionarioPortOut leituraFuncionarioPortOut;

    public BuscaFuncionarioUseCase(LeituraFuncionarioPortOut leituraFuncionarioPortOut) {
        this.leituraFuncionarioPortOut = leituraFuncionarioPortOut;
    }

    public List<Funcionario> buscar() {
        return this.leituraFuncionarioPortOut.buscar();
    }
}
