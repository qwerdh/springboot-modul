package com.cczu.ddd.util;

import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	// Ĭ�ϵ�Ԫ������Ϊ����ʱ��ʽ
	private static DecimalFormat df = new DecimalFormat("0");
	// Ĭ�ϵ�Ԫ���ʽ�������ַ���
	private static SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	// ��ʽ������
	private static DecimalFormat nf = new DecimalFormat("0.00");

	public static ArrayList<ArrayList<Object>> readExcel(File file) {
		if (file == null) {
			return null;
		}
		if (file.getName().endsWith("xlsx")) {
			// ����ecxel2007
			return readExcel2013(file);
		} else {
			// ����ecxel2013
			return readExcel2003(file);
		}
	}

	/*
	 * @return �����ؽ���洢��ArrayList�ڣ��洢�ṹ���λ��������
	 * lists.get(0).get(0)��ʾ��ȥExcel��0��0�е�Ԫ��
	 */
	public static ArrayList<ArrayList<Object>> readExcel2003(File file) {
		try {
			ArrayList<ArrayList<Object>> rowList = new ArrayList<ArrayList<Object>>();
			ArrayList<Object> colList;
			HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(file));
			HSSFSheet sheet = wb.getSheetAt(0);
			HSSFRow row;
			HSSFCell cell;
			Object value;
			for (int i = sheet.getFirstRowNum(), rowCount = 0; rowCount < sheet
					.getPhysicalNumberOfRows(); i++) {
				row = sheet.getRow(i);
				colList = new ArrayList<Object>();
				if (row == null) {
					// ����ȡ��Ϊ��ʱ
					if (i != sheet.getPhysicalNumberOfRows()) {// �ж��Ƿ������һ��
						rowList.add(colList);
					}
					continue;
				} else {
					rowCount++;
				}
				for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
					cell = row.getCell(j);
					if (cell == null
							|| cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
						// ���õ�Ԫ��Ϊ��
						if (j != row.getLastCellNum()) {// �ж��Ƿ��Ǹ��������һ����Ԫ��
							colList.add("");
						}
						continue;
					}
					switch (cell.getCellType()) {
					case XSSFCell.CELL_TYPE_STRING:

						value = cell.getStringCellValue();
						break;
					case XSSFCell.CELL_TYPE_NUMERIC:
						if ("@".equals(cell.getCellStyle()
								.getDataFormatString())) {
							value = df.format(cell.getNumericCellValue());
						} else if ("General".equals(cell.getCellStyle()
								.getDataFormatString())) {
							value = nf.format(cell.getNumericCellValue());
						} else {
							value = sdf.format(HSSFDateUtil.getJavaDate(cell
									.getNumericCellValue()));
						}
						break;
					case XSSFCell.CELL_TYPE_BOOLEAN:
						value = Boolean.valueOf(cell.getBooleanCellValue());
						break;
					case XSSFCell.CELL_TYPE_BLANK:
						value = "";
						break;
					default:
						value = cell.toString();
					}// end switch
					colList.add(value);
				}// end for j
				rowList.add(colList);
			}// end for i

			return rowList;
		} catch (Exception e) {
			return null;
		}
	}

	public static ArrayList<ArrayList<Object>> readExcel2013(File file) {
		try {
			ArrayList<ArrayList<Object>> rowList = new ArrayList<ArrayList<Object>>();
			ArrayList<Object> colList;
			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));
			XSSFSheet sheet = wb.getSheetAt(0);
			XSSFRow row;
			XSSFCell cell;
			Object value;
			for (int i = sheet.getFirstRowNum(), rowCount = 0; rowCount < sheet
					.getPhysicalNumberOfRows(); i++) {
				row = sheet.getRow(i);
				colList = new ArrayList<Object>();
				if (row == null) {
					// ����ȡ��Ϊ��ʱ
					if (i != sheet.getPhysicalNumberOfRows()) {// �ж��Ƿ������һ��
						rowList.add(colList);
					}
					continue;
				} else {
					rowCount++;
				}
				for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
					cell = row.getCell(j);
					if (cell == null
							|| cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
						// ���õ�Ԫ��Ϊ��
						if (j != row.getLastCellNum()) {// �ж��Ƿ��Ǹ��������һ����Ԫ��
							colList.add("");
						}
						continue;
					}
					switch (cell.getCellType()) {
					case XSSFCell.CELL_TYPE_STRING:

						value = cell.getStringCellValue();
						break;
					case XSSFCell.CELL_TYPE_NUMERIC:
						if ("@".equals(cell.getCellStyle()
								.getDataFormatString())) {
							value = df.format(cell.getNumericCellValue());
						} else if ("General".equals(cell.getCellStyle()
								.getDataFormatString())) {
							value = nf.format(cell.getNumericCellValue());
						} else {
							value = sdf.format(HSSFDateUtil.getJavaDate(cell
									.getNumericCellValue()));
						}

						break;
					case XSSFCell.CELL_TYPE_BOOLEAN:

						value = Boolean.valueOf(cell.getBooleanCellValue());
						break;
					case XSSFCell.CELL_TYPE_BLANK:

						value = "";
						break;
					default:

						value = cell.toString();
					}// end switch
					colList.add(value);
				}// end for j
				rowList.add(colList);
			}// end for i

			return rowList;
		} catch (Exception e) {
			System.out.println("exception");
			return null;
		}
	}
}