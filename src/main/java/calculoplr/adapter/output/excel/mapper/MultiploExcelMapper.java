package calculoplr.adapter.output.excel.mapper;

import calculoplr.core.domains.funcionario.Funcionario;
import calculoplr.core.domains.multiplo.Multiplo;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import java.math.BigDecimal;

/**
 * <p>Classe MultiploExcelMapper responsável por</p>
 *
 * @author Lucas Lima
 * @since 27/06/2022
 **/
public class MultiploExcelMapper implements ExcelMapper<Multiplo> {
    @Override
    public Multiplo mapper(Row row) {

        if (row.getRowNum() == 0) {
            return null;
        }

        return Multiplo.builder()
                       .familia(row.getCell(0)
                                   .getStringCellValue())
                       .base(BigDecimal.valueOf(row.getCell(3)
                                                   .getNumericCellValue()))
                       .pgdd(row.getCell(2)
                                .getCellType() == CellType.STRING
                               ? row.getCell(2)
                                    .getStringCellValue()
                               : String.valueOf(row.getCell(2)
                                                   .getNumericCellValue()))
                       .classificacao(row.getCell(1)
                                         .getStringCellValue())
                       .build();
    }

    private void print(int index, Row row) {
        Cell cell = row.getCell(index);
        System.out.println(String.format("(%s) - [%s]", index, cell
                .getCellType()));

        switch (cell.getCellType()) {
            case STRING:
                System.out.print(cell.getStringCellValue());
                break;
            case NUMERIC:
                System.out.println(cell.getNumericCellValue());
                break;
            case BOOLEAN:
                System.out.println(cell.getBooleanCellValue());
                break;
            case FORMULA:
                System.out.println("Formula");
                break;
            default:
                System.out.println("Outro");
                break;
        }
    }
}
