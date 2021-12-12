package uz.pdp;

import com.google.gson.Gson;
import org.apache.poi.xwpf.usermodel.*;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Gson gson=new Gson();
        try {
        File sourse=new File("src/main/resources");
        BufferedReader reader=new BufferedReader(new FileReader(sourse));
        Albums[] albums=gson.fromJson(reader,Albums[].class);
        //Document yaratish
        XWPFDocument document =new XWPFDocument();

        //Paragraph yaratish
        XWPFParagraph paragraph = document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run = paragraph.createRun();
        run.setBold(true);
        run.setText("<---Java Development--->");
        paragraph=document.createParagraph();
        run=paragraph.createRun();




        //Jadval yaratish
            XWPFTable table=document.createTable();
            XWPFTableRow tableRow=table.getRow(0);
            XWPFTableCell cell=tableRow.getCell(0);
            cell.setText("id");
            tableRow.createCell().setText("userId");
            tableRow.createCell().setText("title");
            tableRow=table.createRow();













        FileOutputStream fileOutputStream=new FileOutputStream("src/main/resources/MyFirstDoc.docx");
        document.write(fileOutputStream);
        fileOutputStream.close();







        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
