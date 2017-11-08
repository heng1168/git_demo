package wordPOI;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;

public class GetPicsDocx {
  public static void main(String[] args) {
    String path ="files\\2007.docx";
    File file = new File(path);
    try {
      FileInputStream fis = new FileInputStream(file);
      XWPFDocument document = new XWPFDocument(fis);
      XWPFWordExtractor xwpfWordExtractor = new XWPFWordExtractor(document);
      
      String text = xwpfWordExtractor.getText();//获取文本内容
      System.out.println(text);
      List<XWPFPictureData> picList = document.getAllPictures(); //获取所有图片
      for (XWPFPictureData pic : picList) {
        System.out.println(pic.getPictureType());
        System.out.println(file.separator);
        System.out.println(pic.suggestFileExtension());
        System.out.println(file.separator+pic.getFileName());
        byte[] bytev = pic.getData();
        FileOutputStream fos = new FileOutputStream("E:\\docxImage\\"+pic.getFileName()); 
        fos.write(bytev);
      }
      fis.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}