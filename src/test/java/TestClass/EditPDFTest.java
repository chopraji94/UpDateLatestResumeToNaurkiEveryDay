package TestClass;

import com.aventstack.chaintest.plugins.ChainTestListener;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EditPDFTest {

    @Test(priority = 0)
    public void EditAPdf(){
        ChainTestListener.log("----------------------Edit PDF to latest Date-----------------------");
        String inputPath = System.getProperty("user.dir")+"\\InputResume\\Resume.pdf";
        String outputPath = System.getProperty("user.dir")+"\\ResumeFile\\Resume.pdf";

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
        String formattedDate = currentDate.format(formatter);
        String updatedDate = currentDate.format(formatter);

        try (PDDocument document = PDDocument.load(new File(inputPath))) {
            // Get the last page
            int lastPageIndex = document.getNumberOfPages() - 1;
            PDPage lastPage = document.getPage(lastPageIndex);
            PDRectangle mediaBox = lastPage.getMediaBox();

            // Coordinates for overlay (adjust these values)
            float x = 50; // X position
            float y = 50; // Y position; adjust to where the original date is located

            // Optionally, draw a white rectangle to cover the old date
            try (PDPageContentStream contentStream = new PDPageContentStream(document, lastPage, PDPageContentStream.AppendMode.APPEND, true, true)) {
                // Draw white rectangle (change width and height to cover the old date)
                contentStream.setNonStrokingColor(1.0f); // White
                float rectWidth = 200; // Adjust as needed
                float rectHeight = 20; // Adjust as needed
                contentStream.addRect(x, y, rectWidth, rectHeight);
                contentStream.fill();

                // Write the new date on top
                contentStream.beginText();
                contentStream.setNonStrokingColor(0.0f); // Black text
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
                contentStream.newLineAtOffset(x, y + 5); // Adjust y offset as needed
                contentStream.showText(updatedDate);
                contentStream.endText();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            // Save the updated document
            document.save(outputPath);
            System.out.println("PDF updated successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
