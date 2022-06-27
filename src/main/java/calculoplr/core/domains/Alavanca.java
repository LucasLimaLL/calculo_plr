package calculoplr.core.domains;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Alavanca {

    private BigDecimal minimo;
    private BigDecimal maximo;
    private BigDecimal resultado;

    @Builder(toBuilder = true)
    public Alavanca(BigDecimal minimo, BigDecimal maximo, BigDecimal resultado) {
        this.minimo = minimo;
        this.maximo = maximo;
        this.resultado = resultado;
    }

    public boolean atingido(BigDecimal valor) {

        if (valor.compareTo(this.minimo) >= 0
            && valor.compareTo(this.maximo) < 0) {
            return true;
        }

        return false;
    }
}
