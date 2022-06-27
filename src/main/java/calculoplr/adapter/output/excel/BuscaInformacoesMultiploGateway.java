package calculoplr.adapter.output.excel;

import calculoplr.adapter.output.excel.mapper.MapperExcel;
import calculoplr.adapter.output.excel.mapper.MultiploExcelMapper;
import calculoplr.core.domains.multiplo.Multiplo;
import calculoplr.core.usecase.ports.BuscaInformacoesMultiploPortOut;

import java.util.List;

public class BuscaInformacoesMultiploGateway implements BuscaInformacoesMultiploPortOut {

    private String path;
    private MapperExcel mapperExcel = new MapperExcel();

    public BuscaInformacoesMultiploGateway(String path) {
        this.path = path;
    }

    @Override
    public List<Multiplo> buscarMultiplos() {
        return (List<Multiplo>) mapperExcel.mapper(path, 1, new MultiploExcelMapper());
    }
}
