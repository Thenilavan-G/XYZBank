package Report;

import com.itextpdf.html2pdf.HtmlConverter;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class GeneratePdf {

    @Test
    public static void emailPdf() throws IOException {
        HtmlConverter.convertToPdf(new FileInputStream("./test-output/emailable-report.html"),
                new FileOutputStream("TestNG_EmailReport.pdf"));
    }

    @Test
    public static void indexPdf() throws IOException {
        HtmlConverter.convertToPdf(new FileInputStream("./test-output/index.html"),
                new FileOutputStream("TestNG_IndexReport.pdf"));
    }

}
