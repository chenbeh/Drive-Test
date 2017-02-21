package projet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class testfi {
	private double Rxleve;
	private boolean erreur;
	private double RxQual;
	private double RSCP;
	private double EcNo;
	private double duration1, duration2;
	private double debit1, debit2;
	public String str = Fenetre.filename;

	/**
	 * Description
	 * 
	 * @exception FileNotFoundException
	 *                ;IOException
	 */
	public testfi() {
		Rxleve = 0;
		RxQual = 0;
		RSCP = 0;
		EcNo = 0;
		duration1 = 0;
		duration2 = 0;
		debit1 = 0;
		debit2 = 0;
		erreur=false;
		int n1 = 0;
		int n2 = 0;
		int n3 = 0;
		int n4 = 0;
		int n5 = 0;
		int n6 = 0;

		/***************** 2Gvoix ***************/

		try {
			if (str != null) {
				File excel = new File(str);
				FileInputStream excelFile1 = new FileInputStream(excel);
				// Get the workbook instance for XLS file
				if (str.endsWith(".xlsx")) {
					XSSFWorkbook workbook1 = new XSSFWorkbook(excelFile1);

					// Get first sheet from the workbook
					XSSFSheet sheet1 = workbook1.getSheetAt(0);
					// Iterate through each rows from first sheet
					try {
						Iterator<Row> rowIterator1 = sheet1.rowIterator();
						try {
							rowIterator1.next();
						} catch (NoSuchElementException e) {
							erreur = true;
							
						}
						while (rowIterator1.hasNext()) {
							Row row = rowIterator1.next();
							Cell cell;
							cell = row.getCell(12);
							if (cell != null) {
								Rxleve += cell.getNumericCellValue();
								n1++;
							}
						}

						// Get second sheet from the workbook
						XSSFSheet sheet2 = workbook1.getSheetAt(0);
						// Iterate through each rows from second sheet
						Iterator<Row> rowIterator2 = sheet2.rowIterator();
						try {
							rowIterator2.next();
						} catch (NoSuchElementException e) {
							erreur = true;
						}
						while (rowIterator2.hasNext()) {
							Row row = rowIterator2.next();
							Cell cell;
							cell = row.getCell(14);
							if (cell != null) {
								RxQual += cell.getNumericCellValue();
								n2++;
							}
						}
					} catch (NoSuchElementException e) {
						e.printStackTrace();
					}

					workbook1.close();
					excelFile1.close();
				}
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}

		Rxleve = Rxleve / n1;
		RxQual = RxQual / n2;
		// System.out.println("Rxlevel = "+Rxleve/n1);
		// System.out.println("RxQual = "+RxQual/n2);

		/*******************************************************************************************/
		/************************************* 3Gvoix *********************************************/
		try {
			if (str != null) {
				FileInputStream excelFile2 = new FileInputStream(new File(str));
				// Get the workbook instance for XLS file
				if (str.endsWith("xlsx")) {
					XSSFWorkbook workbook2 = new XSSFWorkbook(excelFile2);

					// Get first sheet from the workbook
					XSSFSheet sheet1 = workbook2.getSheetAt(2);
					// Iterate through each rows from first sheet
					Iterator<Row> rowIterator1 = sheet1.rowIterator();
					try{rowIterator1.next();}catch(NoSuchElementException e){erreur=true;}
					while (rowIterator1.hasNext()) {
						Row row = rowIterator1.next();
						Cell cell;
						cell = row.getCell(14);
						if (cell != null) {
							RSCP += (Double.parseDouble(cell
									.getStringCellValue()));
							n3++;
						}
					}

					// Get second sheet from the workbook
					XSSFSheet sheet2 = workbook2.getSheetAt(2);
					// Iterate through each rows from second sheet
					Iterator<Row> rowIterator2 = sheet2.rowIterator();
					try{rowIterator2.next();}catch(NoSuchElementException e){erreur=true;}
					while (rowIterator2.hasNext()) {
						Row row = rowIterator2.next();
						Cell cell;
						cell = row.getCell(13);
						if (cell != null) {
							EcNo += (Double.parseDouble(cell
									.getStringCellValue()));
							n4++;
						}
					}
					workbook2.close();
					excelFile2.close();
				}
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		RSCP = RSCP / n3;
		EcNo = EcNo / n4;
		// System.out.println("RSCP = "+RSCP/n3);
		// System.out.println("EcNo = "+EcNo/n4);
		/***************************************************************************************************/
		/******************************* Durée moyenne de connecxion ****************************************/
		try {
			if (str != null) {
				FileInputStream excelFile1 = new FileInputStream(new File(str));
				// Get the workbook instance for XLS file
				if (str.endsWith("xlsx")) {
					XSSFWorkbook workbook1 = new XSSFWorkbook(excelFile1);

					// Get first sheet from the workbook
					XSSFSheet sheet1 = workbook1.getSheetAt(1);
					// Iterate through each rows from first sheet
					Iterator<Row> rowIterator1 = sheet1.rowIterator();
					try{rowIterator1.next();}catch(NoSuchElementException e){erreur=true;}
					while (rowIterator1.hasNext()) {
						Row row = rowIterator1.next();
						Cell cell;
						cell = row.getCell(11);
						if (cell != null) {
							duration1 += (Double.parseDouble(cell
									.getStringCellValue()));
							n5++;
						}

					}
					duration1 = duration1 / n5;
					// Get second sheet from the workbook
					try{XSSFSheet sheet2 = workbook1.getSheetAt(3);
					// Iterate through each rows from second sheet
					Iterator<Row> rowIterator2 = sheet2.rowIterator();
					try{rowIterator2.next();}catch(NoSuchElementException e){erreur=true;}
					while (rowIterator2.hasNext()) {
						Row row = rowIterator2.next();
						Cell cell;
						cell = row.getCell(11);
						if (cell != null) {
							duration2 += (Double.parseDouble(cell
									.getStringCellValue()));
							n5++;
						}
					}}catch(IllegalArgumentException e){erreur=true;}
					// System.out.println(n5);
					// System.out.println(duration2=duration2/n5);
					workbook1.close();
					excelFile1.close();
				}
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}

		// System.out.println("La durée moyenne de connexion est = "+sduration/n5);
		/****************************************************************************************************/
		/******************************* débit moyen *******************************************************/
		try {
			if (str != null) {
				FileInputStream excelFile1 = new FileInputStream(new File(str));
				// Get the workbook instance for XLS file
				if (str.endsWith("xlsx")) {
					XSSFWorkbook workbook1 = new XSSFWorkbook(excelFile1);

					// Get first sheet from the workbook
					XSSFSheet sheet1 = workbook1.getSheetAt(1);
					// Iterate through each rows from first sheet
					Iterator<Row> rowIterator1 = sheet1.rowIterator();
					try{rowIterator1.next();}catch(NoSuchElementException e){erreur=true;}
					while (rowIterator1.hasNext()) {
						Row row = rowIterator1.next();
						Cell cell;
						cell = row.getCell(12);
						if (cell != null) {
							debit1 += (Double.parseDouble(cell
									.getStringCellValue()));
							n5++;
						}
					}
					debit1 = debit1 / n5;
					// Get second sheet from the workbook
					try{XSSFSheet sheet2 = workbook1.getSheetAt(3);
					// Iterate through each rows from second sheet
					Iterator<Row> rowIterator2 = sheet2.rowIterator();
					try{rowIterator2.next();}catch(NoSuchElementException e){erreur=true;}
					while (rowIterator2.hasNext()) {
						Row row = rowIterator2.next();
						Cell cell;
						cell = row.getCell(13);
						if (cell != null) {
							debit2 += (Double.parseDouble(cell
									.getStringCellValue()));
							n6++;
						}
					}}catch(IllegalArgumentException e){erreur=true;}

					workbook1.close();
					excelFile1.close();
				}
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		debit2 = debit2 / n6;
		// System.out.println("La débit moyenne en downlink est = "+debit/n6);
	}

	public boolean isErreur() {
		return erreur;
	}
	public double getRxleve() {
		return Rxleve;
	}

	public double getRxQual() {
		return RxQual;
	}

	public double getRSCP() {
		return RSCP;
	}

	public double getEcNo() {
		return EcNo;
	}

	public double getDuration1() {
		return duration1;
	}

	public double getDuration2() {
		return duration2;
	}

	public double getDebit1() {
		return debit1;
	}

	public double getDebit2() {
		return debit2;
	}
}
