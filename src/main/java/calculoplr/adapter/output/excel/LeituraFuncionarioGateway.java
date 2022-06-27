package calculoplr.adapter.output.excel;

import calculoplr.adapter.output.excel.mapper.FuncionarioExcelMapper;
import calculoplr.adapter.output.excel.mapper.MapperExcel;
import calculoplr.core.domains.funcionario.Funcionario;
import calculoplr.core.usecase.ports.LeituraFuncionarioPortOut;

import java.util.List;

/**
 * <p>Classe LeituraFuncionarioGateway responsável por</p>
 *
 * @author Lucas Lima
 * @since 23/06/2022
 **/
public class LeituraFuncionarioGateway implements LeituraFuncionarioPortOut {

    private String path;
    private MapperExcel mapperExcel = new MapperExcel();

    public LeituraFuncionarioGateway(String path) {
        this.path = path;
    }

    @Override
    public List<Funcionario> buscar() {
        return (List<Funcionario>) mapperExcel.mapper(path, 3, new FuncionarioExcelMapper());
    }
}
