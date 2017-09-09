package com.quanglinhit.filehandle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileHandle {

	public static void main(String[] args) {
		try {
			FileInputStream fis=new FileInputStream("hello.txt");
			InputStreamReader isr=new InputStreamReader(fis);
			BufferedReader bis=new BufferedReader(isr);
			String tmp;
			while ((tmp=bis.readLine())!=null) {
				System.out.println(tmp);
			}
			fis.close();
		} 
		catch (FileNotFoundException e) {
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
