package calculoplr.adapter.output.excel.mapper;

import org.apache.poi.ss.usermodel.Row;

import java.util.List;

/**
 * <p>Interface ExcelMapper responsável por abstrair</p>
 *
 * @author Lucas Lima
 * @since 27/06/2022
 **/
public interface ExcelMapper<T> {

    T mapper(Row row);
}
