package com.thingspire.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thingspire.demo.model.BoardVO;
import com.thingspire.demo.model.Criteria;
import com.thingspire.demo.repository.BoardXmlRepository;
import com.thingspire.demo.service.BoardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
	
	private final BoardXmlRepository boardXmlRepository;
	/**
	 * 게시글 등록
	 */
	@Override
	public int insertBoard(BoardVO boardVo) {
		return boardXmlRepository.insertBoard(boardVo);
	}

	/**
	 * 게시판 목록
	 * @param boardVo
	 * @return list
	 */
	@Override
	public List<BoardVO> selectBoardList(Criteria cri) {
		return boardXmlRepository.selectBoardList(cri);
	}
	
	/**
	 * 게시글 개수 조회
	 */
	public int selectBoardListCnt() {
		return boardXmlRepository.selectBoardListCnt();
	}
	
	/**
	 * 게시글 상세 조회
	 */
	@Override
	public BoardVO selectBoard(BoardVO boardVo) {
		return boardXmlRepository.selectBoard(boardVo);
	}

	/**
	 * 게시글 삭제
	 */
	@Override
	public int updateBoard(BoardVO boardVo) {
		return boardXmlRepository.updateBoard(boardVo);
	}

	@Override
	public int deleteBoard(BoardVO boardVo) {
		return boardXmlRepository.deleteBoard(boardVo);
	}

}
