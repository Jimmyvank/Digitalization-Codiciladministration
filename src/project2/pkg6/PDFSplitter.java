package project2.pkg6;

/*
 * java PDFSplitter file.pdf
 *
 * gives   file-001.pdf ... file-nnn.pdf
 *
 * itext-2.1.5.jar

 */

import java.io.FileOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import java.io.IOException;

public class PDFSplitter
{

    //public void main(String[] args)
    {
        //PSplit();
        /*FileBrowser FB = new FileBrowser();
        try
        {
            String inFile = FB.def;//"C:\\Users\\Jimmy\\Desktop\\Sample.pdf";
            System.out.println ("Reading " + inFile);
            PdfReader reader = new PdfReader(inFile);
            int n = reader.getNumberOfPages();
            System.out.println ("Number of pages : " + n);
            int i = 0;
            while ( i < n ) {
                String outFile = inFile.substring(0, inFile.indexOf(".pdf"))
                    + "-" + String.format("%03d", i + 1) + ".pdf";
                System.out.println ("Writing " + outFile);
                Document document = new Document(reader.getPageSizeWithRotation(1));
                PdfCopy writer = new PdfCopy(document, new FileOutputStream(outFile));
                document.open();
                PdfImportedPage page = writer.getImportedPage(reader, ++i);
                writer.addPage(page);
                document.close();
                writer.close();
            }
        }
        catch (DocumentException | IOException e) {
        }

         /**example :
            java SplitPDFFile C:/Users/Jimmy/Desktop/sample.pdf;

            Reading C:\temp\x\tx.pdf;
            Number of pages : 10;
            Writing d:\temp\x\tx-001.pdf;
            Writing d:\temp\x\tx-002.pdf;
            Writing d:\temp\x\tx-003.pdf;
            Writing d:\temp\x\tx-004.pdf;
            Writing d:\temp\x\tx-005.pdf;
            Writing d:\temp\x\tx-006.pdf;
            Writing d:\temp\x\tx-007.pdf;
            Writing d:\temp\x\tx-008.pdf;
            Writing d:\temp\x\tx-009.pdf;
            Writing d:\temp\x\tx-010.pdf;
         */
    }
    public void main(String path)
    {
        FileBrowser FB = new FileBrowser();
        try
        {
            String inFile = path;//"C:\\Users\\Jimmy\\Desktop\\Sample.pdf";
            System.out.println ("Reading " + inFile);
            PdfReader reader = new PdfReader(inFile);
            int n = reader.getNumberOfPages();
            System.out.println ("Number of pages : " + n);
            int i = 0;
            while ( i < n ) {
                String outFile = ("C:\\Users\\Jimmy\\Desktop\\")/*inFile.substring(0, inFile.indexOf(".pdf"))
                   */ + "-" + String.format("%03d", i + 1) + ".pdf";
                System.out.println ("Writing " + outFile);
                Document document = new Document(reader.getPageSizeWithRotation(1));
                PdfCopy writer = new PdfCopy(document, new FileOutputStream(outFile));
                document.open();
                PdfImportedPage page = writer.getImportedPage(reader, ++i);
                writer.addPage(page);
                document.close();
                writer.close();
            }
        }
        catch (DocumentException | IOException e) {
        }
    }
}