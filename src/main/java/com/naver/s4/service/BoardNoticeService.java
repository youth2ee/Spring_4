package com.naver.s4.service;

import java.lang.reflect.Member;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.naver.s4.dao.BoardNoticeDAO;
import com.naver.s4.dao.NoticeFilesDAO;
import com.naver.s4.model.BoardNoticeVO;
import com.naver.s4.model.BoardVO;
import com.naver.s4.model.FilesVO;
import com.naver.s4.util.FileSaver;
import com.naver.s4.util.Pager;

@Service
public class BoardNoticeService implements BoardService {

	@Inject
/*	@Qualifier("BoardNoticeDAO")*/
	private BoardNoticeDAO boardNoticeDAO;
	
	@Inject
	private FileSaver fileSaver;
	
	@Inject
	private NoticeFilesDAO noticeFilesDAO;
	
	
	//summer 
	public String summerFile(MultipartFile file, HttpSession session) throws Exception {
		
		String realpath = session.getServletContext().getRealPath("resources/upload/summer");
		
		return fileSaver.save0(realpath, file);
	}
	
	
	
	
	//
	public int fileDelete(FilesVO noticeFilesVO) throws Exception {
		return noticeFilesDAO.fileDelete(noticeFilesVO);
	}
	
	public FilesVO fileSelect(FilesVO noticeFilesVO) throws Exception {
		return noticeFilesDAO.fileSelect(noticeFilesVO);
	}
	
	

	
	//
	
	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {
		pager.makeRow();
		pager.makePager(boardNoticeDAO.boardCount(pager));
		
		return boardNoticeDAO.boardList(pager);
	}

	@Override
	public BoardVO boardSelect(BoardVO boardVO) throws Exception {
		boardVO = boardNoticeDAO.boardSelect(boardVO);
		//BoardNoticeVO boardNoticeVO = (BoardNoticeVO)boardVO;
		//List<NoticeFilesVO> ar = noticeFilesDAO.fileList(boardVO.getNum());
		//boardNoticeVO.setFiles(ar);
		//reselt map이라는 매퍼설정 이후 위가 필요없어짐
		
		//return boardNoticeVO;
		
		return boardVO;
	}

	@Override
	public int boardWrite(BoardVO boardVO, MultipartFile [] file, HttpSession session) throws Exception {
		
		String realpath = session.getServletContext().getRealPath("resources/upload/notice");
		String filename = "";
		
		session.setAttribute("realpath", realpath);
		
		FilesVO noticeFilesVO = new FilesVO();
		
		int result = boardNoticeDAO.boardWrite(boardVO);
		noticeFilesVO.setNum(boardVO.getNum());
		
		
		for(MultipartFile files : file) { 
			if(files.getOriginalFilename() != "") {
				filename = fileSaver.save0(realpath,files); 
				noticeFilesVO.setFname(filename);
				noticeFilesVO.setOname(files.getOriginalFilename());

				result = noticeFilesDAO.fileWrite(noticeFilesVO); 
			}
		}
		  
		 // boardVO.setFilename(filename);
		 // boardVO.setOriginalname(boardVO.getFile().getOriginalFilename());
		  
		 // System.out.println(filename);
		 // System.out.println(boardVO.getFile().getOriginalFilename());
		 // System.out.println(realpath);
		  
		 // boardNoticeDAO.boardWriteFile(boardVO); 
	 	 // boardNoticeDAO.boardWrite(boardVO);
		 
		
		return result;
	}

	@Override
	public int boardUpdate(BoardVO boardVO, MultipartFile [] file, HttpSession session) throws Exception {
		String realpath = session.getServletContext().getRealPath("resources/upload/notice"); 
		String filename = "";
		session.setAttribute("realpath", realpath); 
		
		int result = boardNoticeDAO.boardUpdate(boardVO); 
		boardVO = boardNoticeDAO.boardSelect(boardVO);
		
		BoardNoticeVO bVO = (BoardNoticeVO)boardVO;
		
		System.out.println("원래 :"+ bVO.getFiles().size());
		System.out.println(file);
		System.out.println("추가 :"+file.length);
		
		FilesVO noticeFilesVO = new FilesVO(); 
		noticeFilesVO.setNum(boardVO.getNum());
			
			for(MultipartFile files : file) {
				if(files.getOriginalFilename() != "") {
					//files.getSize() != 0
					filename = fileSaver.save0(realpath, files);
					noticeFilesVO.setFname(filename);
					noticeFilesVO.setOname(files.getOriginalFilename());

					result = noticeFilesDAO.fileWrite(noticeFilesVO);
				}
			}

		return result;
	}

	@Override
	public int boardDelete(BoardVO boardVO) throws Exception {
		return boardNoticeDAO.boardDelete(boardVO);
	}


}
