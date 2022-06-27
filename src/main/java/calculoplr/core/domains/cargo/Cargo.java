package calculoplr.core.domains.cargo;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Cargo {

    private String titulo;
    private String familia;

    @Builder(toBuilder = true)
    public Cargo(String titulo, String familia) {
        this.titulo = titulo;
        this.familia = familia;
    }
}
