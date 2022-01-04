package com.njy.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Util {
	// 오늘 날짜를 가져 오는 메소드(yyyy-MM-dd)
    public static String getCurrentDate(String fmt) {
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        return sdf.format(new Date());
    }
    
    // 파일 읽어서 화면에 출력(파일 내용을 여기 메소드 밖으로 보내고 싶다)
    public static String readLineFile(String filePath) {
		BufferedReader br = null;
		String retLine = "";
//		StringBuffer sb = new StringBuffer();
		try {
			br = new BufferedReader(new FileReader(filePath));
			while (true) {
				String line = br.readLine();
				if (line == null)
					break;
				
				retLine += line + "\n";  // 문자열을 리턴
//				sb.append(line + "\n");
//				System.out.println(line);   // 화면에 출력
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return retLine;   // sb.toString()
//		return sb.toString(); 
    }
    
    public static ArrayList<String> readLineFileList(String filePath) {
    	ArrayList<String> list = new ArrayList<String>();
		BufferedReader br = null;
		String retLine = "";
//		StringBuffer sb = new StringBuffer();
		try {
			br = new BufferedReader(new FileReader(filePath));
			while (true) {
				String line = br.readLine();
				if (line == null)
					break;
				list.add(line);
//				retLine += line + "\n";  // 문자열을 리턴
//				sb.append(line + "\n");
//				System.out.println(line);   // 화면에 출력
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;   // sb.toString()
    }
    
    
 
    // 파일 쓰기(새파일로 쓰기, 덮어쓰기)
    public static void writeLineFile(ArrayList<String> strList, String filePath) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(filePath);
	        for(String s : strList) {
	            out.println(s);
	        }
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
    }
    
    // 	파일 쓰기(이어 쓰기)
    public static void writeLineFile(ArrayList<String> strList, String filePath, boolean isAppend) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new FileWriter(filePath, isAppend));
	        for(String s : strList) {
	            out.println(s);
	        }
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
    }
    
    // 내가 만든 문자열을 잘라서 데이터 전달
    public static void mySplit(String str, String regex1, String regex2) {
		String[] strArr = str.split(regex1);
		for (String s : strArr) {
//			System.out.println(s);
			String[] tmpArr = s.split(regex2);
//			for (String ss : tmpArr) {
//				System.out.println(ss);
//			}
//			System.out.println(tmpArr.length);
			for (int i = 0; i < tmpArr.length; i++) {
				if (i == tmpArr.length-1) {
					System.out.print(tmpArr[i]);
				} else {
					System.out.print(tmpArr[i] + " / ");
				}
			}
			System.out.println();

		}
    }

}