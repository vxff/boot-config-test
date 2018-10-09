package com.springboot.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLDecoder;

/**
 *
 * @author  chengfan
 * @version 2018年9月29日
 */
public class CommonFile {
	
	/**
	 * 读取txt文本文件内容
	 * 
	 * @param filePathAndName
	 *            带有完整绝对路径的文件名
	 * @param encoding
	 *            文本文件打开的编码方式
	 * @return 返回文本文件的内容
	 */
	public static String readTxt(String filePathAndName, String encoding) throws IOException {
		encoding = encoding.trim();

		BufferedReader br = null;
		StringBuffer sb = new StringBuffer("");
		String st = "";

		try {
			FileInputStream fs = new FileInputStream(filePathAndName);
			InputStreamReader isr;

			if (encoding.equals("")) {
				isr = new InputStreamReader(fs);
			} else {
				isr = new InputStreamReader(fs, encoding);
			}

			br = new BufferedReader(isr);

			try {
				String data = "";
				while ((data = br.readLine()) != null) {
					sb.append(data + " ");
				}
			} catch (Exception e) {
				sb.append(e.toString());
			}
			st = sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null)
				br.close();
		}

		return st;
	}

	/**
	 * 创建txt文件
	 * 
	 * @param filePath
	 *            文本文件完整绝对路径
	 * @param fileName
	 *            文件名
	 * @param fileContent
	 *            文本文件内容
	 * @param codingType
	 *            编码类型
	 * @return
	 */
	public static void createFile(String filePath, String fileName, String fileContent,String codingType) {
		try {
			File saveDir = new File(filePath);
			if (!saveDir.exists())
				saveDir.mkdirs();

			File saveFile = new File(saveDir, fileName);
			if (!saveFile.exists())
				saveFile.createNewFile();

			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(saveFile), codingType));
			bufferedWriter.write(fileContent);

			if (bufferedWriter != null) {
				bufferedWriter.flush();
				bufferedWriter.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//示例
	public static void main(String[] args) {
		URL url = Thread.currentThread().getContextClassLoader().getResource("11111.txt");
		String path = url.getPath();
		try {
			String readTxt = CommonFile.readTxt(URLDecoder.decode(path, "UTF-8"), "UTF-8");
			System.out.println(readTxt);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
