package com.naver.s4.util;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.springframework.web.multipart.MultipartFile;

public class FileSaver {
	
	public String save(String realpath, MultipartFile multipartFile) throws Exception {
		File file = new File(realpath);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		Calendar ca = Calendar.getInstance();
		String time = String.valueOf(ca.getTimeInMillis());
		
		
		String filename = time +"_"+multipartFile.getOriginalFilename();
		
		file = new File(realpath, filename);
		
		//1.
		/* FileCopyUtils.copy(multipartFile.getBytes(), file); */
		
		//2.
		multipartFile.transferTo(file);
		
		//3.
		/*
		 * FileOutputStream fo = new FileOutputStream(file);
		 * fo.write(multipartFile.getBytes()); fo.close();
		 */
		
		
		return filename;
	}

}
