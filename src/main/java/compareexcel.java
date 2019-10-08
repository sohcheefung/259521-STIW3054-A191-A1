import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL; // for .xlsx files online
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * Compares Multiple Spreadsheets
 * @imports Apache POI, Apache Commons, W3C libraries
 * @author Rebecca Ramnauth
 * Date: 3-20-2017
 */
public class compareexcel {
    private static Workbook output;
    
    private static int rowNum;

    private final static int TITLE_NUM_COLUMN = 0;
    private final static int TITLE_SUBJECT = 1;
    private final static int TITLE_PARTS = 2;
    private final static int TITLE_REVISION_DATE = 3;
    private final static int TITLE_CONTAINS = 4;
    private final static int TITLE_DATE_PUBLISHED = 5;  
    private final static int SUBTITLE_NAME_COLUMN = 6;
    private final static int SUBPART_COLUMN = 7;
    private final static int SECTION_NUM_COLUMN = 8;
    private final static int SECTION_NAME_COLUMN = 9;
    private final static int SUBREQ_PARA_COLUMN = 10;
    private final static int CFR_COLUMN = 11;
    private final static int CITA_COLUMN = 12;
    

    public static void main(String[] args) throws Exception {
    	FileInputStream raw = new FileInputStream(new File("D:\\Excel.xls"));
        FileInputStream given = new FileInputStream(new File("D:\\Excel1.xls"));
    	
    	createOutput();
    	compareFiles(raw, given);
    		//copy(); - copy matching row to the output file
    		//citation(); - automatically creates CFR citation for each requirement
		//QUESTION: Should I pull only according to matching section numbers? Or almost similar sub-requirements? 
    }

    /**
     * Downloads/Finds specified Excel files, reads the contents and then writes them to rows on a new excel file.
     * @throws Exception
     */
    private static void compareFiles(FileInputStream raw, FileInputStream given) throws Exception{
        Sheet opt = output.getSheetAt(0);
        
        System.out.println("------------------------------------------------------");
        System.out.println("COMPLETED READ OF FILES. STARTING COMPARISON ... ...  ");
        System.out.println("------------------------------------------------------");
        
        int count = 0;
        int matches = 0;
        
        HSSFWorkbook workbook = new HSSFWorkbook(raw);
        HSSFWorkbook workbook1 = new HSSFWorkbook(given);
        
        Sheet sheet1 = workbook.getSheetAt(0);
        Sheet sheet2 = workbook1.getSheetAt(0);
		
		Row one = sheet1.getRow(0);
		int length = one.getPhysicalNumberOfCells();
		//System.out.println(length);
		
		for (Row row1 : sheet1){
			Cell pointer = row1.getCell(SECTION_NUM_COLUMN);
			String value = pointer.toString();
			String num1 = value.replaceAll("[^0-9.]", "");
			count++;
			//find(Sheet sheet2, String num);
			System.out.println("Row: " + count + "; Section: " + num1);
			
			//READ GIVEN EXCEL FILE			
	    	for (Row row2 : sheet2){
				Cell pointer2 = row2.getCell(8); //change based on column for section#
				String value2 = pointer2.toString();
				String num2 = value2.replaceAll("[^0-9.]", "");
				//System.out.print("		" + num2);
				
				if (num1.equals(num2)){
					//System.out.println("Found matching: " + num2 + " & " + num1);
					//WRITE TO OUTPUT FILE
					Row optRow = opt.createRow(rowNum++);
					Cell optCell;
					matches++;
					
					for (int i = 0; i < length - 1; i++){
					    /*	private final static int TITLE_NUM_COLUMN = 0;
						    private final static int TITLE_SUBJECT = 1;
						    private final static int TITLE_PARTS = 2;
						    private final static int TITLE_REVISION_DATE = 3;
						    private final static int TITLE_CONTAINS = 4;
						    private final static int TITLE_DATE_PUBLISHED = 5;  
						    private final static int SUBTITLE_NAME_COLUMN = 6;
						    private final static int SUBPART_COLUMN = 7;
						    private final static int SECTION_NUM_COLUMN = 8;
						    private final static int SECTION_NAME_COLUMN = 9;
						    private final static int SUBREQ_PARA_COLUMN = 10;
						    private final static int CITA_COLUMN = 11;
					    */
					    optCell = optRow.createCell(TITLE_NUM_COLUMN);
					    try {
                    		optCell.setCellValue((row1.getCell(TITLE_NUM_COLUMN)).getStringCellValue());
                    	}
                    	catch (NullPointerException e){
                    		optCell.setCellValue("");
                    	}
					    
					    optCell = optRow.createCell(TITLE_SUBJECT);
					    try {
                    		optCell.setCellValue((row1.getCell(TITLE_SUBJECT)).getStringCellValue());
                    	}
                    	catch (NullPointerException e){
                    		optCell.setCellValue("");
                    	}
					    
					    optCell = optRow.createCell(TITLE_PARTS);
					    try {
                    		optCell.setCellValue((row1.getCell(TITLE_PARTS)).getStringCellValue());
                    	}
                    	catch (NullPointerException e){
                    		optCell.setCellValue("");
                    	}
					    
					    optCell = optRow.createCell(TITLE_REVISION_DATE);
					    try {
                    		optCell.setCellValue((row1.getCell(TITLE_REVISION_DATE)).getStringCellValue());
                    	}
                    	catch (NullPointerException e){
                    		optCell.setCellValue("");
                    	}
					    
					    optCell = optRow.createCell(TITLE_CONTAINS);
					    try {
                    		optCell.setCellValue((row1.getCell(TITLE_CONTAINS)).getStringCellValue());
                    	}
                    	catch (NullPointerException e){
                    		optCell.setCellValue("");
                    	}
					    
					    optCell = optRow.createCell(TITLE_DATE_PUBLISHED);
					    try {
                    		optCell.setCellValue((row1.getCell(TITLE_DATE_PUBLISHED)).getStringCellValue());
                    	}
                    	catch (NullPointerException e){
                    		optCell.setCellValue("");
                    	}
					    
					    optCell = optRow.createCell(SUBTITLE_NAME_COLUMN);
					    try {
                    		optCell.setCellValue((row1.getCell(SUBTITLE_NAME_COLUMN)).getStringCellValue());
                    	}
                    	catch (NullPointerException e){
                    		optCell.setCellValue("");
                    	}
					    
					    optCell = optRow.createCell(SUBPART_COLUMN);
					    try {
                    		optCell.setCellValue((row1.getCell(SUBPART_COLUMN)).getStringCellValue());
                    	}
                    	catch (NullPointerException e){
                    		optCell.setCellValue("");
                    	}
					    
						optCell = optRow.createCell(SECTION_NUM_COLUMN);
                    	try {
                    		optCell.setCellValue((row1.getCell(SECTION_NUM_COLUMN)).getStringCellValue());
                    	}
                    	catch (NullPointerException e){
                    		optCell.setCellValue("");
                    	}
                    	
						optCell = optRow.createCell(SECTION_NAME_COLUMN);
                    	try {
                    		optCell.setCellValue((row1.getCell(SECTION_NAME_COLUMN)).getStringCellValue());
                    	}
                    	catch (NullPointerException e){
                    		optCell.setCellValue("");
                    	}
                    	
                    	optCell = optRow.createCell(SUBREQ_PARA_COLUMN);
					    try {
                    		optCell.setCellValue((row1.getCell(SUBREQ_PARA_COLUMN)).getStringCellValue());
                    	}
                    	catch (NullPointerException e){
                    		optCell.setCellValue("");
                    	}
					    
						optCell = optRow.createCell(CITA_COLUMN);
                    	try {
                    		optCell.setCellValue((row1.getCell(CITA_COLUMN - 1)).getStringCellValue()); // - 1 to make way for the CFR citation column (11)
                    	}
                    	catch (NullPointerException e){
                    		System.out.println("");
                    	}
                    	                    	
                    	//CREATE CITATION
                    	optCell = optRow.createCell(CFR_COLUMN);
                    	// get section
                    	String citation = "";
                    	// get title
                    	Cell titleCell = row1.getCell(0); //change based on column for section#
						String citationRaw = titleCell.toString();
						String title = citationRaw.replaceAll("[^0-9.]", "");
                    	//include paragraph level citation?
                    	
                    	try {
                    		optCell.setCellValue(title + " CFR §" + num1);
                    	}
                    	catch (NullPointerException e){
                    		optCell.setCellValue("");
                    	}
					}
				}
	    	}
	    	//System.out.println("******************* BATCH COMPLETED *******************");
		}
		//opt.removeRow(opt.getRow(1)); - does not shift remaining rows up
		removeRow (opt, 1);
		
        FileOutputStream fileOut = new FileOutputStream("D:\\output.xls");
        output.write(fileOut);
        output.close();
        fileOut.close();
		
        System.out.println("------------------------------------------------------");
        System.out.println("MATCHING COMPLETED: " + matches + " MATCHES FOUND.");
        System.out.println("------------------------------------------------------");
    }
    
    private static void removeRow (Sheet sheet, int index){
    	int last = sheet.getLastRowNum();
    	if (index >= 0 && index < last)
    		sheet.shiftRows(index + 1, last, -1);
    	if (index == last){
    		Row removee = sheet.getRow(index);
    		if (removee != null)
    			sheet.removeRow(removee);
    	}
    }

    /**
     * Initializes the POI output and writes the header row
     */
    private static void createOutput() {
        output = new HSSFWorkbook();

        CellStyle style = output.createCellStyle();
        Font boldFont = output.createFont();
        boldFont.setBold(true);
      

        Sheet sheet = output.createSheet();
        rowNum = 0;
        Row row = sheet.createRow(rowNum++);
        
        Cell cell = row.createCell(TITLE_NUM_COLUMN);
        cell.setCellValue("TITLE");
        cell.setCellStyle(style);
		
		cell = row.createCell(TITLE_SUBJECT);
        cell.setCellValue("SUBJECT");
        cell.setCellStyle(style);
        
        cell = row.createCell(TITLE_PARTS);
        cell.setCellValue("SCOPE");
        cell.setCellStyle(style);
        
        cell = row.createCell(TITLE_REVISION_DATE);
        cell.setCellValue("LAST REVISION");
        cell.setCellStyle(style);
        
        cell = row.createCell(TITLE_CONTAINS);
        cell.setCellValue("DESCRIPTION");
        cell.setCellStyle(style);
        
        cell = row.createCell(TITLE_DATE_PUBLISHED);
        cell.setCellValue("DATE PUBLISHED");
        cell.setCellStyle(style);
                
        //SUBTITLE COLUMNS
        cell = row.createCell(SUBTITLE_NAME_COLUMN);
        cell.setCellValue("SUBTITLE");
        cell.setCellStyle(style);
        
        //SUBPART COLUMNS
		cell = row.createCell(SUBPART_COLUMN);
        cell.setCellValue("SUBPART");
        cell.setCellStyle(style);
        
        //SECTION COLUMNS
        cell = row.createCell(SECTION_NUM_COLUMN);
        cell.setCellValue("SECTION#");
        cell.setCellStyle(style);

        cell = row.createCell(SECTION_NAME_COLUMN);
        cell.setCellValue("SECTION");
        cell.setCellStyle(style);

        cell = row.createCell(SUBREQ_PARA_COLUMN);
        cell.setCellValue("SUB-REQUIREMENT");
        cell.setCellStyle(style);
        
        cell = row.createCell(CFR_COLUMN);
        cell.setCellValue("CFR CITATION");
        cell.setCellStyle(style);

        cell = row.createCell(CITA_COLUMN);
        cell.setCellValue("FR CITATION");
        cell.setCellStyle(style);
    }
}