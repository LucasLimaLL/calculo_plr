package calculoplr.adapter.output.excel.mapper;

import calculoplr.core.domains.cargo.Cargo;
import calculoplr.core.domains.funcionario.Funcionario;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>Classe FuncionarioExcelMapper responsável por</p>
 *
 * @author Lucas Lima
 * @since 27/06/2022
 **/
public class FuncionarioExcelMapper implements ExcelMapper<Funcionario> {

    @Override
    public Funcionario mapper(Row row) {

        if (row.getRowNum() == 0) {
            return null;
        }

        return Funcionario.builder()
                          .nome(row.getCell(5)
                                   .getStringCellValue())
                          .salario(BigDecimal.valueOf(row.getCell(12)
                                                         .getNumericCellValue()))
                          .mesesTrabalhados(Integer.valueOf((int) row.getCell(13)
                                                                     .getNumericCellValue()))
                          .avaliacao(row.getCell(14)
                                        .getStringCellValue())
                          .classificacao(row.getCell(10)
                                            .getStringCellValue())
                          .cargo(Cargo.builder()
                                      .titulo(row.getCell(6)
                                                 .getStringCellValue())
                                      .familia(row.getCell(11)
                                                  .getRichStringCellValue()
                                                  .getString())
                                      .build())
                          .build();
    }
}
