package calculoplr.core.usecase.ports;

import calculoplr.core.domains.funcionario.Funcionario;

import java.util.List;

/**
 * <p>Interface LeituraFuncionarioPortOut responsável por abstrair</p>
 *
 * @author Lucas Lima
 * @since 23/06/2022
 **/
public interface LeituraFuncionarioPortOut {

    List<Funcionario> buscar();
}
