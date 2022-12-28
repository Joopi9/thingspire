package com.thingspire.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.thingspire.demo.model.BoardVO;
import com.thingspire.demo.model.Criteria;

@Mapper
public interface BoardXmlRepository {
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
	 * @return
	 */
	List<BoardVO> selectBoardList(Criteria cri);
	
	int selectBoardListCnt();

	/**
	 * 게시글 상세조회
	 * @param boardVo
	 * @return boardVo
	 */
	BoardVO selectBoard(BoardVO boardVo);

	/**
	 * 게시글 수정
	 * @param boardVo
	 * @return
	 */
	int updateBoard(BoardVO boardVo);

	/**
	 * 게시글 삭제
	 * @param boardVo
	 * @return
	 */
	int deleteBoard(BoardVO boardVo);

}
