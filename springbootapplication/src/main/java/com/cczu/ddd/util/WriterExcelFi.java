package com.cczu.ddd.util;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import pojo.Internalcontrol;
import pojo.Monthbusiness;
import pojo.Monthcheck;
import pojo.Quarterbusiness;
import pojo.Quartercheck;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * ����ȡ�������ݿ�����д��Excelģ����У���������Ҫ
 */
public class WriterExcelFi {

	
    private static final Logger LOGGER = Logger.getLogger(WriterExcelFi.class.getName());

    /**
     * ������д��ָ��path�µ�Excel�ļ���
     *      �������һ����������:������˳���������ݵĴ洢˳��һ��,�������ɻ���;���ǵ�һ��,�Ժ��ٸĽ����
     * @param path �ļ��洢·��
     * @param name sheet��
     * @param style Excel����
     * @param titles ���⴮
     * @param values ���ݼ�
     * @return T\F
     */    
    public static boolean generateWorkbookForQuarterCheck(String name,List<Quartercheck> listmonth,HttpServletRequest request) {
        Workbook workbook;
        workbook = new XSSFWorkbook();

      // ����һ�����
      Sheet sheet = workbook.createSheet(name);
      // ���ñ��Ĭ���п��Ϊ15���ֽ�
      sheet.setDefaultColumnWidth((short) 15);
      // ������ʽ
      Map<String, CellStyle> styles = createStyles(workbook);
      /*
       * ����������
       */
      Row row = sheet.createRow(0);
          Cell cell1 = row.createCell(0);
          cell1.setCellStyle(styles.get("header"));
          cell1.setCellValue("��");
          cell1 = row.createCell(1);
          cell1.setCellStyle(styles.get("header"));
          cell1.setCellValue("����");
          cell1 = row.createCell(2);
          cell1.setCellStyle(styles.get("header"));
          cell1.setCellValue("Ӫҵ��");
          cell1 = row.createCell(3);
          cell1.setCellStyle(styles.get("header"));
          cell1.setCellValue("Ӫҵ����");
          cell1 = row.createCell(4);
          cell1.setCellStyle(styles.get("header"));
          cell1.setCellValue("�ؿ���");
          cell1 = row.createCell(5);
          cell1.setCellStyle(styles.get("header"));
          cell1.setCellValue("�����");
          cell1 = row.createCell(6);
          cell1.setCellStyle(styles.get("header"));
          cell1.setCellValue("������");

      /*
       * д������
       */
      int index = 0;
      for (Quartercheck Quartercheck : listmonth) {
      	 index++;
      	 	row = sheet.createRow(index);
               Cell cell = row.createCell(0);
               cell.setCellStyle(styles.get("cell"));
               cell.setCellValue(Quartercheck.getYear());
               cell = row.createCell(1);
               cell.setCellStyle(styles.get("cell"));
               cell.setCellValue(Quartercheck.getQcdate());
               cell = row.createCell(2);
               cell.setCellStyle(styles.get("cell"));
               cell.setCellValue(Quartercheck.getQctu());
               cell = row.createCell(3);
               cell.setCellStyle(styles.get("cell"));
               cell.setCellValue(Quartercheck.getQcoe());
               cell = row.createCell(4);
               cell.setCellStyle(styles.get("cell"));
               cell.setCellValue(Quartercheck.getQcrm());
               cell = row.createCell(5);
               cell.setCellStyle(styles.get("cell"));
               cell.setCellValue(Quartercheck.getQcst());
               cell = row.createCell(6);
               cell.setCellStyle(styles.get("cell"));
               cell.setCellValue(Quartercheck.getQcpr());
           
		}
     
      /*
       * д�뵽�ļ���
       */
      boolean isCorrect = false;
      File file = new File(request.getSession().getServletContext().getRealPath("/").toString()+"/Excl/DateForQuaterCheck.xlsx");
      // ����ļ�����,��ɾ�����е��ļ�,���´���һ���µ�
      if (file.exists()) {
          file.deleteOnExit();
          file = new File(request.getSession().getServletContext().getRealPath("/").toString()+"/Excl/DateForQuaterCheck.xlsx");
      }
      OutputStream outputStream = null;
      try {
          outputStream = new FileOutputStream(file);
          workbook.write(outputStream);
          isCorrect = true;
      } catch (IOException e) {
          LOGGER.error(e.getMessage());
      } finally {
          try {
              if (null != outputStream) {
                  outputStream.close();
              }
          } catch (IOException e) {
              LOGGER.error(e.getMessage());
          }
      }
      return isCorrect;
  }

    
    public static boolean generateWorkbookForMonthCheck(String name,List<Monthcheck> listmonth,HttpServletRequest request) {
        Workbook workbook;
        workbook = new XSSFWorkbook();

      // ����һ�����
      Sheet sheet = workbook.createSheet(name);
      // ���ñ��Ĭ���п��Ϊ15���ֽ�
      sheet.setDefaultColumnWidth((short) 15);
      // ������ʽ
      Map<String, CellStyle> styles = createStyles(workbook);
      /*
       * ����������
       */
      Row row = sheet.createRow(0);
          Cell cell1 = row.createCell(0);
          cell1.setCellStyle(styles.get("header"));
          cell1.setCellValue("��");
          cell1 = row.createCell(1);
          cell1.setCellStyle(styles.get("header"));
          cell1.setCellValue("��");
          cell1 = row.createCell(2);
          cell1.setCellStyle(styles.get("header"));
          cell1.setCellValue("֧����");
          cell1 = row.createCell(3);
          cell1.setCellStyle(styles.get("header"));
          cell1.setCellValue("��Ʒ��");
          cell1 = row.createCell(4);
          cell1.setCellStyle(styles.get("header"));
          cell1.setCellValue("ҽҩ��");
          cell1 = row.createCell(5);
          cell1.setCellStyle(styles.get("header"));
          cell1.setCellValue("�ڿ��ۺϳɱ�");
          cell1 = row.createCell(6);
          cell1.setCellStyle(styles.get("header"));
          cell1.setCellValue("�ֳ�����");

      /*
       * д������
       */
      int index = 0;
      for (Monthcheck Monthcheck : listmonth) {
      	 index++;
      	 	row = sheet.createRow(index);
               Cell cell = row.createCell(0);
               cell.setCellStyle(styles.get("cell"));
               cell.setCellValue(Monthcheck.getYear());
               cell = row.createCell(1);
               cell.setCellStyle(styles.get("cell"));
               cell.setCellValue(Monthcheck.getMcdate());
               cell = row.createCell(2);
               cell.setCellStyle(styles.get("cell"));
               cell.setCellValue(Monthcheck.getMcde());
               cell = row.createCell(3);
               cell.setCellStyle(styles.get("cell"));
               cell.setCellValue(Monthcheck.getMcpr());
               cell = row.createCell(4);
               cell.setCellStyle(styles.get("cell"));
               cell.setCellValue(Monthcheck.getMcmc());
               cell = row.createCell(5);
               cell.setCellStyle(styles.get("cell"));
               cell.setCellValue(Monthcheck.getMcip());
               cell = row.createCell(6);
               cell.setCellStyle(styles.get("cell"));
               cell.setCellValue(Monthcheck.getMcfc());
           
		}
     
      /*
       * д�뵽�ļ���
       */
      boolean isCorrect = false;
      File file = new File(request.getSession().getServletContext().getRealPath("/").toString()+"/Excl/DateForMonthlyCheck.xlsx");
      // ����ļ�����,��ɾ�����е��ļ�,���´���һ���µ�
      if (file.exists()) {
          file.deleteOnExit();
          file = new File(request.getSession().getServletContext().getRealPath("/").toString()+"/Excl/DateForMonthlyCheck.xlsx");
      }
      OutputStream outputStream = null;
      try {
          outputStream = new FileOutputStream(file);
          workbook.write(outputStream);
          isCorrect = true;
      } catch (IOException e) {
          LOGGER.error(e.getMessage());
      } finally {
          try {
              if (null != outputStream) {
                  outputStream.close();
              }
          } catch (IOException e) {
              LOGGER.error(e.getMessage());
          }
      }
      return isCorrect;
  }

   
    
    public static boolean generateWorkbookForQarter(String name,List<Quarterbusiness> listmonth,HttpServletRequest request) {
         Workbook workbook;
         workbook = new XSSFWorkbook();

       // ����һ�����
       Sheet sheet = workbook.createSheet(name);
       // ���ñ��Ĭ���п��Ϊ15���ֽ�
       sheet.setDefaultColumnWidth((short) 15);
       // ������ʽ
       Map<String, CellStyle> styles = createStyles(workbook);
       /*
        * ����������
        */
       Row row = sheet.createRow(0);
           Cell cell1 = row.createCell(0);
           cell1.setCellStyle(styles.get("header"));
           cell1.setCellValue("��");
           cell1 = row.createCell(1);
           cell1.setCellStyle(styles.get("header"));
           cell1.setCellValue("����");
           cell1 = row.createCell(2);
           cell1.setCellStyle(styles.get("header"));
           cell1.setCellValue("Ӫҵ��");
           cell1 = row.createCell(3);
           cell1.setCellStyle(styles.get("header"));
           cell1.setCellValue("Ӫҵ����");
           cell1 = row.createCell(4);
           cell1.setCellStyle(styles.get("header"));
           cell1.setCellValue("�ؿ��");
           cell1 = row.createCell(5);
           cell1.setCellStyle(styles.get("header"));
           cell1.setCellValue("�����");
           cell1 = row.createCell(6);
           cell1.setCellStyle(styles.get("header"));
           cell1.setCellValue("�����");

       /*
        * д������
        */
       int index = 0;
       for (Quarterbusiness Quarterbusiness : listmonth) {
       	 index++;
       	 	row = sheet.createRow(index);
                Cell cell = row.createCell(0);
                cell.setCellStyle(styles.get("cell"));
                cell.setCellValue(Quarterbusiness.getYear());
                cell = row.createCell(1);
                cell.setCellStyle(styles.get("cell"));
                cell.setCellValue(Quarterbusiness.getQmonth());
                cell = row.createCell(2);
                cell.setCellStyle(styles.get("cell"));
                cell.setCellValue(Quarterbusiness.getQtu());
                cell = row.createCell(3);
                cell.setCellStyle(styles.get("cell"));
                cell.setCellValue(Quarterbusiness.getQoe());
                cell = row.createCell(4);
                cell.setCellStyle(styles.get("cell"));
                cell.setCellValue(Quarterbusiness.getQrm());
                cell = row.createCell(5);
                cell.setCellStyle(styles.get("cell"));
                cell.setCellValue(Quarterbusiness.getQst());
                cell = row.createCell(6);
                cell.setCellStyle(styles.get("cell"));
                cell.setCellValue(Quarterbusiness.getQpr());
            
		}
      
       /*
        * д�뵽�ļ���
        */
       boolean isCorrect = false;
       File file = new File(request.getSession().getServletContext().getRealPath("/").toString()+"/Excl/DateForQuarterbusiness.xlsx");
       // ����ļ�����,��ɾ�����е��ļ�,���´���һ���µ�
       if (file.exists()) {
           file.deleteOnExit();
           file = new File(request.getSession().getServletContext().getRealPath("/").toString()+"/Excl/DateForQuarterbusiness.xlsx");
       }
       OutputStream outputStream = null;
       try {
           outputStream = new FileOutputStream(file);
           workbook.write(outputStream);
           isCorrect = true;
       } catch (IOException e) {
           LOGGER.error(e.getMessage());
       } finally {
           try {
               if (null != outputStream) {
                   outputStream.close();
               }
           } catch (IOException e) {
               LOGGER.error(e.getMessage());
           }
       }
       return isCorrect;
   }

    
    public static boolean generateWorkbookFormonthly(String name,List<Monthbusiness> listmonth,HttpServletRequest request) {
        Workbook workbook;
          workbook = new XSSFWorkbook();

        // ����һ�����
        Sheet sheet = workbook.createSheet(name);
        // ���ñ��Ĭ���п��Ϊ15���ֽ�
        sheet.setDefaultColumnWidth((short) 15);
        // ������ʽ
        Map<String, CellStyle> styles = createStyles(workbook);
        /*
         * ����������
         */
        Row row = sheet.createRow(0);
            Cell cell1 = row.createCell(0);
            cell1.setCellStyle(styles.get("header"));
            cell1.setCellValue("��");
            cell1 = row.createCell(1);
            cell1.setCellStyle(styles.get("header"));
            cell1.setCellValue("��");
            cell1 = row.createCell(2);
            cell1.setCellStyle(styles.get("header"));
            cell1.setCellValue("Ӫҵ��");
            cell1 = row.createCell(3);
            cell1.setCellStyle(styles.get("header"));
            cell1.setCellValue("Ӫҵ����");
            cell1 = row.createCell(4);
            cell1.setCellStyle(styles.get("header"));
            cell1.setCellValue("�ؿ��");
            cell1 = row.createCell(5);
            cell1.setCellStyle(styles.get("header"));
            cell1.setCellValue("�����");
            cell1 = row.createCell(6);
            cell1.setCellStyle(styles.get("header"));
            cell1.setCellValue("�����");

        /*
         * д������
         */
        int index = 0;
        for (Monthbusiness monthbusiness : listmonth) {
        	 index++;
        	 	row = sheet.createRow(index);
                 Cell cell = row.createCell(0);
                 cell.setCellStyle(styles.get("cell"));
                 cell.setCellValue(monthbusiness.getYear());
                 cell = row.createCell(1);
                 cell.setCellStyle(styles.get("cell"));
                 cell.setCellValue(monthbusiness.getMdate());
                 cell = row.createCell(2);
                 cell.setCellStyle(styles.get("cell"));
                 cell.setCellValue(monthbusiness.getMtu());
                 cell = row.createCell(3);
                 cell.setCellStyle(styles.get("cell"));
                 cell.setCellValue(monthbusiness.getMoe());
                 cell = row.createCell(4);
                 cell.setCellStyle(styles.get("cell"));
                 cell.setCellValue(monthbusiness.getMrm());
                 cell = row.createCell(5);
                 cell.setCellStyle(styles.get("cell"));
                 cell.setCellValue(monthbusiness.getMst());
                 cell = row.createCell(6);
                 cell.setCellStyle(styles.get("cell"));
                 cell.setCellValue(monthbusiness.getMpr());
             
		}
       
        /*
         * д�뵽�ļ���
         */
        boolean isCorrect = false;
        File file = new File(request.getSession().getServletContext().getRealPath("/").toString()+"/Excl/DateForMonthly.xlsx");
        // ����ļ�����,��ɾ�����е��ļ�,���´���һ���µ�
        if (file.exists()) {
            file.deleteOnExit();
            file = new File(request.getSession().getServletContext().getRealPath("/").toString()+"/Excl/DateForMonthly.xlsx");
        }
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            workbook.write(outputStream);
            isCorrect = true;
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        } finally {
            try {
                if (null != outputStream) {
                    outputStream.close();
                }
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
            }
        }
        return isCorrect;
    }

    
    public static boolean generateWorkbookForinternal(String name,List<Internalcontrol> listmonth,HttpServletRequest request) {
        Workbook workbook;
        workbook = new XSSFWorkbook();

      // ����һ�����
      Sheet sheet = workbook.createSheet(name);
      // ���ñ��Ĭ���п��Ϊ15���ֽ�
      sheet.setDefaultColumnWidth((short) 15);
      // ������ʽ
      Map<String, CellStyle> styles = createStyles(workbook);
      /*
       * ����������
       */
      Row row = sheet.createRow(0);
          Cell cell1 = row.createCell(0);
          cell1.setCellStyle(styles.get("header"));
          cell1.setCellValue("¼��ʱ��");
          cell1 = row.createCell(1);
          cell1.setCellStyle(styles.get("header"));
          cell1.setCellValue("��������");
          cell1 = row.createCell(2);
          cell1.setCellStyle(styles.get("header"));
          cell1.setCellValue("������");
          cell1 = row.createCell(3);
          cell1.setCellStyle(styles.get("header"));
          cell1.setCellValue("������(��Ԫ)");
          cell1 = row.createCell(4);
          cell1.setCellStyle(styles.get("header"));
          cell1.setCellValue("�ƻ�����");
          cell1 = row.createCell(5);
          cell1.setCellStyle(styles.get("header"));
          cell1.setCellValue("ʵ������");
          cell1 = row.createCell(6);
          cell1.setCellStyle(styles.get("header"));
          cell1.setCellValue("������");
          cell1 = row.createCell(7);
          cell1.setCellStyle(styles.get("header"));
          cell1.setCellValue("Ŀ���Ʒ��");
          cell1 = row.createCell(8);
          cell1.setCellStyle(styles.get("header"));
          cell1.setCellValue("Ŀ����Ԫ�ɱ�");
          cell1 = row.createCell(9);
          cell1.setCellStyle(styles.get("header"));
          cell1.setCellValue("Ŀ��ҽҩ��");
          cell1 = row.createCell(10);
          cell1.setCellStyle(styles.get("header"));
          cell1.setCellValue("Ŀ�������Ϸ�����");
          cell1 = row.createCell(11);
          cell1.setCellStyle(styles.get("header"));
          cell1.setCellValue("ʵ����Ԫ�ɱ�");
          cell1 = row.createCell(12);
          cell1.setCellStyle(styles.get("header"));
          cell1.setCellValue("ʵ��ҽҩ��");
          cell1 = row.createCell(13);
          cell1.setCellStyle(styles.get("header"));
          cell1.setCellValue("ʵ�ʹ��������");

      /*
       * д������
       */
      int index = 0;
      for (Internalcontrol Internalcontrol : listmonth) {
      	 index++;
      	 	row = sheet.createRow(index);
               Cell cell = row.createCell(0);
               cell.setCellStyle(styles.get("cell"));
               cell.setCellValue(Internalcontrol.getTime());
               cell = row.createCell(1);
               cell.setCellStyle(styles.get("cell"));
               cell.setCellValue(Internalcontrol.getIdate());
               cell = row.createCell(2);
               cell.setCellStyle(styles.get("cell"));
               cell.setCellValue(Internalcontrol.getIno());
               cell = row.createCell(3);
               cell.setCellStyle(styles.get("cell"));
               cell.setCellValue(Internalcontrol.getMoney());
               cell = row.createCell(4);
               cell.setCellStyle(styles.get("cell"));
               cell.setCellValue(Internalcontrol.getIexcept());
               cell = row.createCell(5);
               cell.setCellStyle(styles.get("cell"));
               cell.setCellValue(Internalcontrol.getIactual());
               cell = row.createCell(6);
               cell.setCellStyle(styles.get("cell"));
               cell.setCellValue(Internalcontrol.getIdone());
               cell = row.createCell(7);
               cell.setCellStyle(styles.get("cell"));
               cell.setCellValue(Internalcontrol.getIyield());
               cell = row.createCell(8);
               cell.setCellStyle(styles.get("cell"));
               cell.setCellValue(Internalcontrol.getIcost());
               cell = row.createCell(9);
               cell.setCellStyle(styles.get("cell"));
               cell.setCellValue(Internalcontrol.getIme());
               cell = row.createCell(10);
               cell.setCellStyle(styles.get("cell"));
               cell.setCellValue(Internalcontrol.getIen());
               cell = row.createCell(11);
               cell.setCellStyle(styles.get("cell"));
               cell.setCellValue(Internalcontrol.getAcicost());
               cell = row.createCell(12);
               cell.setCellStyle(styles.get("cell"));
               cell.setCellValue(Internalcontrol.getAcime());
               cell = row.createCell(13);
               cell.setCellStyle(styles.get("cell"));
               cell.setCellValue(Internalcontrol.getAcien());
 
           
		}
     
      /*
       * д�뵽�ļ���
       */
      boolean isCorrect = false;
      File file = new File(request.getSession().getServletContext().getRealPath("/").toString()+"/Excl/DateForinternalcontrol.xlsx");
      // ����ļ�����,��ɾ�����е��ļ�,���´���һ���µ�
      if (file.exists()) {
          file.deleteOnExit();
          file = new File(request.getSession().getServletContext().getRealPath("/").toString()+"/Excl/DateForinternalcontrol.xlsx");
      }
      OutputStream outputStream = null;
      try {
          outputStream = new FileOutputStream(file);
          workbook.write(outputStream);
          isCorrect = true;
      } catch (IOException e) {
          LOGGER.error(e.getMessage());
      } finally {
          try {
              if (null != outputStream) {
                  outputStream.close();
              }
          } catch (IOException e) {
              LOGGER.error(e.getMessage());
          }
      }
      return isCorrect;
  }

    /**
     * Create a library of cell styles
     */
    private static Map<String, CellStyle> createStyles(Workbook wb) {
        Map<String, CellStyle> styles = new HashMap<String, CellStyle>();
        DataFormat dataFormat = wb.createDataFormat();

        // ������ʽ
        CellStyle titleStyle = wb.createCellStyle();
        titleStyle.setAlignment(HorizontalAlignment.CENTER); // ˮƽ����
        titleStyle.setVerticalAlignment(VerticalAlignment.CENTER); // ��ֱ����
        titleStyle.setLocked(true);
        titleStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        titleStyle.setFillBackgroundColor(IndexedColors.YELLOW.getIndex());
        Font titleFont = wb.createFont();
        titleFont.setFontHeightInPoints((short) 16);
        titleFont.setBold(true);
        titleFont.setFontName("΢���ź�");
        titleStyle.setFont(titleFont);
        styles.put("title", titleStyle);

        // �ļ�ͷ��ʽ
        CellStyle headerStyle = wb.createCellStyle();
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        headerStyle.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerStyle.setWrapText(true);
        Font headerFont = wb.createFont();
        headerFont.setFontHeightInPoints((short) 12);
        headerFont.setColor(IndexedColors.WHITE.getIndex());
        titleFont.setFontName("΢���ź�");
        headerStyle.setFont(headerFont);
        styles.put("header", headerStyle);

        // ������ʽ
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setWrapText(true);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        styles.put("cell", cellStyle);

        return styles;
    }
}
