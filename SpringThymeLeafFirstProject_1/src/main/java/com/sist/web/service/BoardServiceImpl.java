package com.sist.web.service;

import java.util.*;
import org.springframework.stereotype.Service;
import com.sist.web.entity.BoardEntity;
import com.sist.web.repository.*;

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
	public List<BoardEntity> boardListData(int start) {
		return dao.boardListData(start);
	}

	@Override
	public void boardUpdate(BoardEntity vo) {
		dao.save(vo); // no에 값이 있는 경우 UPDATE
	}

	@Override
	public void boardInsert(BoardEntity vo) {
		dao.save(vo); // no에 값이 없는 경우  INSERT
	}

	@Override
	public void boardDelete(BoardEntity vo) {
		dao.delete(vo);
	}

	@Override
	public int boardRowCount() {
		return (int)dao.count();
	}

}
