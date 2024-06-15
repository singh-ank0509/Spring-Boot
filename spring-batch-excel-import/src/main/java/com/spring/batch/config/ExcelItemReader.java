package com.spring.batch.config;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.batch.item.ItemReader;

import com.spring.batch.entity.FeederDetails;

public class ExcelItemReader implements ItemReader<FeederDetails> {
    private Iterator<Row> rowIterator;
    private Workbook workbook;
  
    public ExcelItemReader(String filepath) throws IOException {
        workbook = new XSSFWorkbook(new FileInputStream(filepath));
        Sheet sheet = workbook.getSheetAt(0);
        rowIterator = sheet.iterator();
        // Skip header
        if (rowIterator.hasNext()) {
            rowIterator.next();
        }
    }
    
    @Override
    public FeederDetails read() throws Exception {
    	DataFormatter dataFormatter = new DataFormatter();
        if (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            FeederDetails fdrDetail = new FeederDetails();
            Iterator<Cell> cellIterator = row.iterator();
            int cellIndex = 0;
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                setMeterProperty(fdrDetail, dataFormatter, cellIndex, cell);
                cellIndex++;
            }
            return fdrDetail;
        } else {
            workbook.close();
            return null;
        }
    }
	
	private void setMeterProperty(FeederDetails fdrDetail, DataFormatter dataFormatter, int cellIndex, Cell cell) {
        switch (cellIndex) {        
        	case 0:
        		fdrDetail.setMeterSrNo(dataFormatter.formatCellValue(cell));
            	break;
        	case 1:
        		fdrDetail.setMeterMake(dataFormatter.formatCellValue(cell));
        		break;
        	case 2:
            	fdrDetail.setMakeCode(dataFormatter.formatCellValue(cell));	
            	break;
            case 3:
            	fdrDetail.setModemType(dataFormatter.formatCellValue(cell));
                break;
            case 4:
            	fdrDetail.setModemTechnology(dataFormatter.formatCellValue(cell));
                break;
            case 5:
            	fdrDetail.setInstallPoint(dataFormatter.formatCellValue(cell));
            	break;
        	case 6:
        		fdrDetail.setFeederBu(dataFormatter.formatCellValue(cell));
        		break;
            case 7:
            	fdrDetail.setFeederCode(dataFormatter.formatCellValue(cell));
                break;
            case 8:
            	fdrDetail.setFeederName(dataFormatter.formatCellValue(cell));
                break;    
            case 9:
            	fdrDetail.setSubstationCode(dataFormatter.formatCellValue(cell));
                break;
            case 10:
            	fdrDetail.setSubstationName(dataFormatter.formatCellValue(cell));
                break;    
            default:
                break;
        }
    }
}
