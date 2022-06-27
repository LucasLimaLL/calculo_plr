package calculoplr.core.domains.multiplo;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Multiplo {

    private String familia;
    private String classificacao;
    private String pgdd;
    private BigDecimal base;

    @Builder(toBuilder = true)
    public Multiplo(String familia, String classificacao, String pgdd, BigDecimal base) {
        this.familia = familia;
        this.classificacao = classificacao;
        this.pgdd = pgdd;
        this.base = base;
    }

    public String getMix() {
        return String.format("%s%s%s", familia, classificacao, pgdd);
    }

    public BigDecimal getAlanvacador(BigDecimal resultado) {
        return base.multiply(resultado);
    }

}
