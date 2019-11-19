package com.naver.s4.util;

import java.io.File;
import java.util.Calendar;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;


public class FileSaver {
	
	//1. Spring에서 제공하는 fileCopyUtils라는 클래스의 copy메서드를 사용함.
	public void Save(String realPath, MultipartFile multipartFile) throws Exception {
		//realPath 받기
		File file = new File(realPath);
		//System.out.println(file.exists());
		//true면 존재, false면 부존재
		
		if(!file.exists()) {
			file.mkdirs();
			//없는거 다 만들어준다.			
		}
		
		//file.mkdir();
		//마지막의 폴더만 만든다.
		//System.out.println(file.exists());
		//System.out.println(file.isDirectory());
		
		//시간으로 파일명 바꾸기 
		Calendar calendar =  Calendar.getInstance();
		Long name = calendar.getTimeInMillis();
		
		String tree = multipartFile.getOriginalFilename();
		System.out.println(tree); 
		
		System.out.println(tree.indexOf(".")); 
		
		System.out.println( tree.substring(tree.indexOf(".")));
		
		String end =  tree.substring(tree.indexOf("."));
		
		/*
		 * String [] trees = tree.split(".");
		 * 
		 * for(int i =0;i<trees.length;i++) { System.out.println(trees[i]); }
		 */
		
		file = new File(realPath, String.valueOf(name)+end);
		FileCopyUtils.copy( multipartFile.getBytes(), file);
		


	}
	

	
	

}
