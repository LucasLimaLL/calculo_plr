package calculoplr.adapter.output.excel.mapper;

import calculoplr.adapter.output.excel.mapper.ExcelMapper;
import calculoplr.core.domains.Alavanca;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.math.BigDecimal;

/**
 * <p>Classe AlavancaExcelMapper responsável por</p>
 *
 * @author Lucas Lima
 * @since 27/06/2022
 **/
public class AlavancaExcelMapper implements ExcelMapper<Alavanca> {

    @Override
    public Alavanca mapper(Row row) {

        if (row.getRowNum() == 0) {
            return null;
        }
        return Alavanca.builder()
                       .minimo(BigDecimal.valueOf(row.getCell(0)
                                                     .getNumericCellValue()))
                       .maximo(BigDecimal.valueOf(row.getCell(1)
                                                     .getNumericCellValue()))
                       .resultado(BigDecimal.valueOf(row.getCell(2)
                                                        .getNumericCellValue()))
                       .build();
    }
}
