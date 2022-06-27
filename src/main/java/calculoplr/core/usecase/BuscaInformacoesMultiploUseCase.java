package calculoplr.core.usecase;

import calculoplr.core.domains.cargo.Cargo;
import calculoplr.core.domains.multiplo.Multiplo;
import calculoplr.core.usecase.ports.BuscaInformacoesMultiploPortOut;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.List;

public class BuscaInformacoesMultiploUseCase {

    private List<Multiplo> multiplos;
    private BuscaInformacoesMultiploPortOut buscaInformacoesMultiploPortOut;

    public BuscaInformacoesMultiploUseCase(
            BuscaInformacoesMultiploPortOut buscaInformacoesMultiploPortOut) {
        this.buscaInformacoesMultiploPortOut = buscaInformacoesMultiploPortOut;
    }

    public Multiplo buscar(Cargo cargo, String classificacao, String avaliacao) {

        if (CollectionUtils.isEmpty(multiplos)) {
            multiplos = this.buscaInformacoesMultiploPortOut.buscarMultiplos();
        }

        return multiplos.stream()
                        .filter(multiplo -> multiplo.getMix().equals(String.format("%s%s%s", cargo.getFamilia(), classificacao, avaliacao)))
                        .findFirst()
                        .orElse(null);
    }
}
