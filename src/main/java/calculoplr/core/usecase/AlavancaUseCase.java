package calculoplr.core.usecase;

import calculoplr.core.domains.Alavanca;
import calculoplr.core.usecase.ports.BuscaItensAlavancaPortOut;
import org.apache.commons.collections4.CollectionUtils;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * <p>Classe AlavancaUseCase responsável por</p>
 *
 * @author Lucas Lima
 * @since 22/06/2022
 **/
public class AlavancaUseCase {

    private BuscaItensAlavancaPortOut buscaItensAlavancaPortOut;
    private List<Alavanca> itensAlavanca;

    public AlavancaUseCase(BuscaItensAlavancaPortOut buscaItensAlavancaPortOut) {
        this.buscaItensAlavancaPortOut = buscaItensAlavancaPortOut;
    }

    public BigDecimal getValorAlavanca(BigDecimal resultado) {

        if (CollectionUtils.isEmpty(itensAlavanca)) {
            itensAlavanca = this.buscaItensAlavancaPortOut.buscar();
        }

        Alavanca item = itensAlavanca.stream()
                                     .filter(itemAlavanca -> itemAlavanca.atingido(resultado))
                                     .findFirst()
                                     .orElse(null);

        if (Objects.isNull(item)) {
            return BigDecimal.valueOf(0);
        }

        return item.getResultado();
    }
}
