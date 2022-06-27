package calculoplr.core.usecase.ports;

import calculoplr.core.domains.Alavanca;

import java.util.List;

/**
 * <p>Interface BuscaItensAlavancaPortOut responsável por abstrair</p>
 *
 * @author Lucas Lima
 * @since 22/06/2022
 **/
public interface BuscaItensAlavancaPortOut {

    List<Alavanca> buscar();
}
