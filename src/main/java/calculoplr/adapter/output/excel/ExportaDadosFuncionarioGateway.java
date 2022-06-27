package calculoplr.adapter.output.excel;

import calculoplr.core.domains.funcionario.Funcionario;
import calculoplr.core.usecase.ports.ExportaDadosFuncionarioPortOut;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ExportaDadosFuncionarioGateway implements ExportaDadosFuncionarioPortOut {

    private static final String FILE_NAME = "FUNC_%s.xlsx";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmSS");
    private String path;

    public ExportaDadosFuncionarioGateway(String path) {
        this.path = path;
    }

    @Override
    public void exportar(List<Funcionario> funcionarios) throws IllegalAccessException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();

        criarHeaders(sheet.createRow(0));

        int rowCount = 0;

        for (Funcionario funcionario : funcionarios) {
            Row row = sheet.createRow(++rowCount);
            novaLinha(funcionario, row);
        }

        try (FileOutputStream outputStream = new FileOutputStream(path
                .concat("/")
                .concat(String.format(FILE_NAME, LocalDateTime.now()
                                                              .format(FORMATTER))))) {
            workbook.write(outputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void criarHeaders(Row header) {
        Class c = Funcionario.class;
        Field[] fields = c.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            novaCelula(i + 1, header, fields[i].getName());
        }
    }

    private void novaLinha(Funcionario funcionario, Row row) throws IllegalAccessException {
        int i = 0;
        novaCelula(++i, row, funcionario.getNome());
        novaCelula(++i, row, String.valueOf(funcionario.getMesesTrabalhados()));
        novaCelula(++i, row, funcionario.getCargo()
                                        .getFamilia()
                                        .concat(" - ")
                                        .concat(funcionario.getCargo()
                                                           .getTitulo()));
        novaCelula(++i, row, funcionario.getClassificacao());
        novaCelula(++i, row, funcionario.getAvaliacao());
        novaCelula(++i, row, funcionario.getSalario()
                                        .toPlainString());
        novaCelula(++i, row, funcionario.getValorAReceber()
                                        .toPlainString());
    }

    private void novaCelula(int i, Row row, String value) {
        Cell cell = row.createCell(i);
        cell.setCellValue(value);
    }

}
