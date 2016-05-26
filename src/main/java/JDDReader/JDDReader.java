package JDDReader;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import model.AssociatedParts;
import model.EventDetails;
import model.EventRecord;

public class JDDReader {
	public static final String OUT_FILE = "data/1_year_JDD.json";
	
	public static void main(String[] args) throws FileNotFoundException, IOException {

		Workbook wb = new XSSFWorkbook(new FileInputStream("data/1_year_JDD.xlsx"));    
        Sheet sheet = (Sheet) wb.getSheetAt(0);
        //String worksheetName = wb.getSheetName(0);
        
        // process all of the rows of the worksheet, only caring about the cell that contains the 
        // "Site:" string
        String cellValue = null;
        for (Row row : sheet) {
        	if (row.getCell(0) != null) {
        		cellValue = row.getCell(0).toString();
        		
        		// look for the beginning of a EventRecord
        		if (cellValue.trim().equalsIgnoreCase("Site:")) {
        			int startRow = row.getRowNum() + 1;
        			String site = row.getCell(1).toString();
        			processEventRecord(startRow, sheet, site);
        		}
        	}
        }
        
        wb.close();
	}
	
	public static void processEventRecord(final int start, final Sheet sheet, final String site) throws IOException {
		EventRecord eRecord = new EventRecord();
		eRecord.setSite(site);
		
		for (int i = start; i < sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			
			
			if (row.getCell(0) != null) {
				String valType = row.getCell(0).toString().trim();
				String cellValue = row.getCell(1).toString().trim();
				
				// we hit a new site, bail out of this loop
				if (valType.equalsIgnoreCase("Site:")) {
					break;
				} else if (valType.equalsIgnoreCase("Event ID:")) {
					eRecord.setEventId(cellValue);
				} else if (valType.equalsIgnoreCase("Event Type:")) {
					eRecord.setEventType(cellValue);
				} else if (valType.equalsIgnoreCase("Event Details:")) {
					int detailsStart = i + 1;
					processEventDetails(detailsStart, sheet, eRecord);
				} else if (valType.equalsIgnoreCase("Associated Parts:")) {
					int partsStart = i + 1;
					processAssociatedParts(partsStart, sheet, eRecord);
				}
			}
		}
		
		printJsonToFile(eRecord.toJsonString());
		//System.out.println(eRecord.toJsonString());
		//System.exit(0);
	}
	
	public static void processAssociatedParts(final int start, final Sheet sheet, EventRecord eRecord) {
		for (int i = start; i < sheet.getLastRowNum(); i++) {
			AssociatedParts parts = new AssociatedParts();
			
			for (Cell cell: sheet.getRow(i)) {
				String cellVal = cell.toString().trim();
				
				// bail out of the function if we hit a new site
				if (cellVal.equalsIgnoreCase("Site:")) {
					return;
				}
				
				//System.out.println(cell.getColumnIndex() + " | " + cellVal);
			
				switch (cell.getColumnIndex()) {
					case 1: if (cellVal.equalsIgnoreCase("")) {
								// bail out on the separator between event entries
								return;
							} else {
								parts.setPartNumber(cellVal);
								break;
							}
					case 2: parts.setFsc(cellVal);
							break;
					case 3: parts.setWuc(cellVal);
							break;
					case 4: parts.setRefSymbol(cellVal);
							break;
					case 5: parts.setHmc(cellVal);
							break;
					case 6: parts.setSerialNumber(cellVal);
							break;
					case 7: parts.setOpTime(cellVal);
							break;
					case 8: parts.setTagNumber(cellVal);
							break;
					case 9: parts.setQty(cellVal);
							break;
				}
			}
			
			eRecord.getAssociatedParts().add(parts);
		}
	}
	
	public static void processEventDetails(final int start, final Sheet sheet, EventRecord eRecord) {
		for (int i = start;	 i < sheet.getLastRowNum(); i++) {
			EventDetails eDetails = new EventDetails();
			
			for (Cell cell: sheet.getRow(i)) {
				String cellVal = cell.toString().trim();
				
				// bail out of the function if we hit the parts section
				if (cellVal.equalsIgnoreCase("Associated Parts:")) {
					return;
				}
				
				//System.out.println(cell.getColumnIndex() + " | " + cellVal);
				
				switch (cell.getColumnIndex()) {
					case 1: eDetails.setDiscrepancy(cellVal);
							break;
					case 2: eDetails.setPwc(cellVal);
							break;
					case 3: eDetails.setWuc(cellVal);
							break;
					case 4: eDetails.setEventNarrative(cellVal);
							break;
					case 5: eDetails.setTmc(cellVal);
							break;
					case 6: eDetails.setAtc(cellVal);
							break;
					case 7: eDetails.setWdc(cellVal);
							break;
					case 8: eDetails.setHmc(cellVal);
							break;
					case 9: eDetails.setUnits(cellVal);
							break;
					case 10: eDetails.setStartDate(cellVal);
							break;
					case 11: eDetails.setStopDate(cellVal);
							break;
					case 12: eDetails.setUser(cellVal);
							break;
					case 13: eDetails.setCorrectiveAction(cellVal);
							break;
				}
			}
			
			eRecord.getEventDetails().add(eDetails);
		}
	}
	
	public static void printJsonToFile(String json) throws IOException {
		FileWriter fw = new FileWriter(OUT_FILE, true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter out = new PrintWriter(bw);
		
		out.println(json);
		out.close();
	}
}
