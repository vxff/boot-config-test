package com.springboot.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 *
 * @author  chengfan
 * @version 2018年9月19日
 */
public class ValidateUtil {
	
	public String getCertPic(int width, int height, OutputStream os){
		//在内存中创建图像
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//获取画笔
		Graphics g = image.getGraphics();
		//设置画笔颜色
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		//开始生成验证码,这里用加法求和
		Random r = new Random();
		String vCode = getVcode(6);

		//将验证码存入session
		//将验证码显示到图像中
		g.setColor(Color.BLACK);
		g.setFont(new Font("", Font.PLAIN, 20));
		g.drawString(vCode, (int) (Math.random() * 30), (int) (Math.random() * 20) + 18);
		//随即产生5条直线
		for (int i = 0; i < 5; i++) {
			int x = r.nextInt(width);
			int y = r.nextInt(height);
			g.setColor(Color.RED);
			g.drawLine(width/(x+1), height/(y+1), x, y);
		}
		//产生200个点
		for(int i=0;i<200;i++) {
			int x = r.nextInt(width);
			int y = r.nextInt(height);
			g.setColor(Color.BLUE);
			g.drawOval(x, y, 1, 1);
		}

		try {
			ImageIO.write(image, "png", os);
		} catch (IOException e) {
			return "";
		}
		return String.valueOf(vCode);
	}
	
	/**
	 * 密码强度
	 * 
	 * @author zhangrui
	 * @param passwordStr
	 * @return
	 */
	public static int checkPassword(String passwordStr) {
		String str1 = "^[0-9]{6,64}$"; // 不超过20位的数字组合
		String str2 = "^[a-zA-Z]{6,64}$"; // 由字母不超过20位
		String str3 = "^[0-9|a-z|A-Z]{6,64}$"; // 由字母、数字组成，不超过20位

		if (passwordStr.matches(str1)) {
			return 1;
		}
		if (passwordStr.matches(str2)) {
			return 2;
		}
		if (passwordStr.matches(str3)) {
			return 3;
		}
		return 3;
	}
	
	public static void main(String[] args) {
		System.out.println(checkPassword("abc123"));
	}
	
	private static String getVcode(int length) {
		String vCode = "";
		Random random = new Random();
		int temp = 0;
		String tempStr = "";
		try {
			for (int i = 0; i < length; i++) {
				switch (random.nextInt(3)) {
				case 1:// A~Z
					temp = random.nextInt(26) + 65;
					tempStr = String.valueOf((char) temp);
					if ("I".equals(tempStr))
						tempStr = "A";
					else if ("O".equals(tempStr))
						tempStr = "B";
					vCode += tempStr;

					break;

				case 2:// a~z
					temp = random.nextInt(26) + 97;
					tempStr = String.valueOf((char) temp);
					if ("l".equals(tempStr))
						tempStr = "c";
					else if ("o".equals(tempStr))
						tempStr = "d";
					vCode += tempStr;

					break;

				case 3:// 汉字
					String[] rBase = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
					int r1 = random.nextInt(3) + 11; // 生成第1位的区码
					String strR1 = rBase[r1]; // 生成11～14的随机数
					int r2; // 生成第2位的区码
					if (r1 == 13)
						r2 = random.nextInt(7); // 生成0～7的随机数
					else
						r2 = random.nextInt(16); // 生成0～16的随机数
					String strR2 = rBase[r2];
					int r3 = random.nextInt(6) + 10; // 生成第1位的位码
					String strR3 = rBase[r3];
					int r4; // 生成第2位的位码
					if (r3 == 10)
						r4 = random.nextInt(15) + 1; // 生成1～16的随机数
					else if (r3 == 15)
						r4 = random.nextInt(15); // 生成0～15的随机数
					else
						r4 = random.nextInt(16); // 生成0～16的随机数
					String strR4 = rBase[r4];
					// 将生成的机内码转换成数字
					byte[] bytes = new byte[2];
					String strR12 = strR1 + strR2; // 将生成的区码保存到字节数组的第1个元素中
					int tempLow = Integer.parseInt(strR12, 16);
					bytes[0] = (byte) tempLow;
					String strR34 = strR3 + strR4; // 将生成的区码保存到字节数组的第2个元素中
					int tempHigh = Integer.parseInt(strR34, 16);
					bytes[1] = (byte) tempHigh;
					vCode += new String(bytes);

					break;

				default:// 数字
					temp = random.nextInt(10) + 48;
					tempStr = String.valueOf((char) temp);
					if ("0".equals(tempStr))
						tempStr = "2";
					else if ("1".equals(tempStr))
						tempStr = "3";
					vCode += tempStr;

					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return vCode;
	}

}
