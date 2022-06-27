package calculoplr.adapter.output.excel;

import calculoplr.adapter.output.excel.mapper.AlavancaExcelMapper;
import calculoplr.adapter.output.excel.mapper.MapperExcel;
import calculoplr.core.domains.Alavanca;
import calculoplr.core.usecase.ports.BuscaItensAlavancaPortOut;

import java.util.List;

public class BuscaItensAlavancaGateway implements BuscaItensAlavancaPortOut {

    private String path;
    private MapperExcel<Alavanca> mapperExcel = new MapperExcel<Alavanca>();

    public BuscaItensAlavancaGateway(String path) {
        this.path = path;
    }

    @Override
    public List<Alavanca> buscar() {
        return (List<Alavanca>) mapperExcel.mapper(path, 2, new AlavancaExcelMapper());

    }
}
