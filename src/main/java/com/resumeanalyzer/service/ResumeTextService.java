package com.resumeanalyzer.service;
import org.springframework.stereotype.Service;import org.springframework.web.multipart.MultipartFile;import org.apache.pdfbox.Loader;import org.apache.pdfbox.text.PDFTextStripper;import org.apache.poi.xwpf.usermodel.XWPFDocument;import java.io.IOException;
@Service public class ResumeTextService {
 public String extract(MultipartFile f)throws IOException{String n=f.getOriginalFilename()==null?"":f.getOriginalFilename().toLowerCase();
 if(n.endsWith(".pdf")){try(var d=Loader.loadPDF(f.getBytes())){return new PDFTextStripper().getText(d);}}
 if(n.endsWith(".docx")){try(var d=new XWPFDocument(f.getInputStream())){StringBuilder b=new StringBuilder();d.getParagraphs().forEach(p->b.append(p.getText()).append("\n"));return b.toString();}}
 throw new IllegalArgumentException("Please upload PDF or DOCX.");}
}
