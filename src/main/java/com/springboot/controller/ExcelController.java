package com.springboot.controller;

import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.springframework.stereotype.Controller;

/**
 *
 * @author  chengfan
 * @version 2018年9月29日
 */
@Controller
public class ExcelController {
	
	public void exportExcle(HttpServletRequest request, HttpServletResponse response) {
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
		HSSFSheet sheet = null;
		sheet = hssfWorkbook.createSheet("xxx表");
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = sheet.createRow((int)0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = hssfWorkbook.createCellStyle();
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setAlignment(HorizontalAlignment.CENTER); // 创建一个居中格式
        sheet.setColumnWidth(0, 9000);
        sheet.setColumnWidth(1, 9000);
        sheet.setColumnWidth(2, 9000);
        sheet.setColumnWidth(3, 9000);
        sheet.setColumnWidth(4, 9000);
        sheet.setColumnWidth(5, 9000);
        HSSFCell cell1 = row.createCell((short)0);
        cell1.setCellValue("姓名");
        cell1.setCellStyle(style);

        HSSFCell cell2 = row.createCell((short)1);
        cell2.setCellValue("手机号");
        cell2.setCellStyle(style);

        HSSFCell cell3 = row.createCell((short)2);
        cell3.setCellValue("邮箱");
        cell3.setCellStyle(style);
        
        HSSFCell cell4 = row.createCell((short)3);
        cell4.setCellValue("公司");
        cell4.setCellStyle(style);
        
        HSSFCell cell5 = row.createCell((short)4);
        cell5.setCellValue("职位");
        cell5.setCellStyle(style);
        
        HSSFCell cell6 = row.createCell((short)5);
        cell6.setCellValue("地点");
        cell6.setCellStyle(style);
        
        String place = "";
        if (place!=null) {
        	List<Object> lists =new ArrayList<>();
        	if (lists!=null) {
        		for (int i = 0; i < lists.size(); i++) {
        			Object oc = lists.get(i);
        			row = sheet.createRow((int)i+1);
        			HSSFCell cell = row.createCell((short)0);
        			cell.setCellStyle(style);
        			cell.setCellValue("oc.getName()");
        			
        			cell = row.createCell((short)1);
        			cell.setCellStyle(style);
        			cell.setCellValue("oc.getName()");
        			
        		}
        	}
		}
        try {
        	Date date = new Date();
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        	String format = sdf.format(date);
        	String filename = "";
			filename=format+"这里啥都没有.xls";
			
	        /*String filename =UUID.randomUUID().toString().replaceAll("-", "")+".xls";*/
	        /*FileOutputStream fileOutputStream = new FileOutputStream("C:\\"+uuid+".xls");*/
			
			
			
			String uuid = UUID.randomUUID().toString().replaceAll("-", "")+".xls";
            String realPath = request.getSession().getServletContext().getRealPath("/upload");

            ServletOutputStream outputStream = response.getOutputStream();
            System.out.println(outputStream);

            FileOutputStream fileOutputStream = new FileOutputStream(realPath+"\\"+uuid);
            hssfWorkbook.write(fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();

            response.sendRedirect("/upload/"+uuid);
			
	        //浏览器直接下载 response
	        /*response.setContentType("application/vnd.ms-excel;charset=UTF-8");  
	        response.setHeader("Content-Disposition", "attachment;filename="  
                    .concat(String.valueOf(URLEncoder.encode(filename, "UTF-8"))));  
	        ServletOutputStream outputStream = response.getOutputStream();
	        hssfWorkbook.write(outputStream);
	        outputStream.flush();
	        outputStream.close();
	        hssfWorkbook.close();*/
        } catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * //改变字体样式，步骤        
	 * HSSFFont hssfFont = wb.createFont();         
	 * //设置字体,红色        hssfFont.setColor(HSSFFont.COLOR_RED);         
	 * //字体粗体显示        hssfFont.setBold(true);         
	 * hssfFont.setFontName("宋体");         
	 * // 字体大小        
	 * hssfFont.setFontHeightInPoints((short) 22); 
	 * 
	 * //设置样式        
	 * HSSFCellStyle cellStyle = wb.createCellStyle();        
	 * cellStyle.setFont(hssfFont);         
	 * //设置单元格背景色        
	 * cellStyle.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());        
	 * cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);         
	 * //设置居中        
	 * cellStyle.setAlignment(HorizontalAlignment.CENTER);//水平居中        
	 * cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);//垂直居中         
	 * //设置边框        
	 * cellStyle.setBorderBottom(BorderStyle.THIN); //下边框        
	 * cellStyle.setBorderLeft(BorderStyle.DASH_DOT_DOT);//左边框        
	 * cellStyle.setBorderTop(BorderStyle.THIN);//上边框        
	 * cellStyle.setBorderRight(BorderStyle.THIN);//右边框         
	 * //3.单元格使用样式，设置第一行第一列单元格样式        
	 * cell0_1.setCellStyle(cellStyle);        
	 * cell0_2.setCellStyle(cellStyle);

	 */

}
