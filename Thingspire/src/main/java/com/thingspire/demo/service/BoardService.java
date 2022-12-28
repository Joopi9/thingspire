package com.thingspire.demo.service;

import java.util.List;

import com.thingspire.demo.model.BoardVO;
import com.thingspire.demo.model.Criteria;

public interface BoardService {
	/**
	 * 게시글 등록
	 * @param boardVo
	 * @return
	 */
	int insertBoard(BoardVO boardVo);
	
	/**
	 * 게시판 목록 조회
	 * @param cri 
	 * @param boardVo
	 * @return list
	 */
	List<BoardVO> selectBoardList(Criteria cri);
	
	/**
	 * 게시글 개수 조회
	 * @return
	 */
	int selectBoardListCnt();

	/**
	 * 게시글 상세 조회
	 * @param boardVo
	 * @return boardVo
	 */
	BoardVO selectBoard(BoardVO boardVo);

	/**
	 * @param boardVo
	 * @return
	 */
	int updateBoard(BoardVO boardVo);

	int deleteBoard(BoardVO boardVo);
}
