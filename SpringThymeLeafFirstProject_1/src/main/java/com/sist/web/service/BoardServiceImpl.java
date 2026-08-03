package com.sist.web.service;

import java.util.*;
import org.springframework.stereotype.Service;
import com.sist.web.entity.BoardEntity;
import com.sist.web.repository.*;
import com.sist.web.vo.BoardDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	private final BoardRepository dao;
	@Override
	public BoardEntity findByNo(int no) {
		return dao.findByNo(no);
	}

	@Override
	public List<BoardDTO> boardListData(int start) {
		return dao.boardListData(start);
	}

	@Override
	public boolean boardUpdate(BoardEntity vo) {
		boolean bCheck=false;
		BoardEntity dvo=dao.findByNo(vo.getNo());
		if(dvo.getPwd().equals(vo.getPwd())) {
			bCheck=true;
			vo.setHit(dvo.getHit());
			dao.save(vo); // no에 값이 있는 경우 UPDATE
		}
		return bCheck;
	}

	@Override
	public void boardInsert(BoardEntity vo) {
		dao.save(vo); // no에 값이 없는 경우  INSERT
	}

	@Override
	public boolean boardDelete(BoardEntity vo) {
		boolean bCheck=false;
		BoardEntity dvo=dao.findByNo(vo.getNo());
		if(dvo.getPwd().equals(vo.getPwd())) {
			bCheck=true;
			dao.delete(dvo);
		}
		return bCheck;
	}

	@Override
	public int boardRowCount() {
		return (int)dao.count();
	}

}
