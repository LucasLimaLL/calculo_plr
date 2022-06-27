package calculoplr.adapter.output.excel.mapper;

import calculoplr.adapter.output.excel.mapper.ExcelMapper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>Classe MapperExcel responsável por</p>
 *
 * @author Lucas Lima
 * @since 27/06/2022
 **/
public class MapperExcel<T> {

    public List<T> mapper(String path, int type, ExcelMapper mapper) {

        List<T> objects = new ArrayList<>();
        File file = null;
        FileInputStream fis = null;
        XSSFWorkbook wb = null;
        try {
            file = new File(path);   //creating a new file instance
            fis = new FileInputStream(file);   //obtaining bytes from the file
//creating Workbook instance that refers to .xlsx file
            wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(type);     //creating a Sheet object to retrieve object
            Iterator<Row> itr = sheet.iterator();    //iterating over excel file
            while (itr.hasNext()) {
                Row row = itr.next();
                if (row.getRowNum() >= 30) {
                    System.out.println("oi");
                }
                    if (row.getLastCellNum() <= 1) {
                        break;
                    }

                objects.add((T) mapper.mapper(row));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(fis)) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (Objects.nonNull(wb)) {
                try {
                    wb.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return objects.stream()
                      .filter(object -> Objects.nonNull(object))
                      .collect(Collectors.toList());
    }
}
