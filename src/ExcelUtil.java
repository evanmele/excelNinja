import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by evanm901 on 5/1/17.
 */
public class ExcelUtil {
    public void writeExcel(List<Book> listBook, String excelFilePath) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Java Books");

        int rowCount = 0;

        for (Book aBook : listBook) {
            Row row;
            row = sheet.createRow(++rowCount);
            writeBook(aBook, row);
        }

        try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
            workbook.write(outputStream);
        }
    }

    private List<Book> getListBook() {
        Book book1 = new Book("Head First Java", "Kathy Serria", 79);
        Book book2 = new Book("Effective Java", "Joshua Bloch", 36);
        Book book3 = new Book("Clean Code", "Robert Martin", 42);
        Book book4 = new Book("Thinking in Java", "Bruce Eckel", 35);

        List<Book> listBook = Arrays.asList(book1, book2, book3, book4);

        return listBook;
    }

    private void writeBook(Book aBook, Row row) {
        Cell cell = row.createCell(1);
        cell.setCellValue(aBook.getTitle());

        cell = row.createCell(2);
        cell.setCellValue(aBook.getAuthor());

        cell = row.createCell(3);
        cell.setCellValue(aBook.getPrice());
    }
}
