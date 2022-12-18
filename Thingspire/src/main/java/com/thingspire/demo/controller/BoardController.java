package com.thingspire.demo.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thingspire.demo.config.Response;
import com.thingspire.demo.model.BoardVO;
import com.thingspire.demo.model.Criteria;
import com.thingspire.demo.model.Paging;
import com.thingspire.demo.service.BoardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Api(tags = {"게시판 API"},
value = "게시판"
)
@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService boardService;
	
	/**
	 * 게시글 등록
	 * @param boardVo
	 * @return
	 */
	@PostMapping
	public Response insertBoard(@RequestBody BoardVO boardVo) {
		return new Response(boardService.insertBoard(boardVo));
	}
	/**
	 * 게시판 목록 조회
	 * @return List<BoardVO>
	 */
	@GetMapping("/list")
	@ApiOperation(value="게시판 목록 조회", notes="게시판 목록")
	public Response selectBoardList(Criteria cri){
		Map<String,Object> map = new HashMap<>();
		//게시글 개수
		int boardListCnt = boardService.selectBoardListCnt();
		
		Paging paging = new Paging();
		paging.setCri(cri);
		paging.setTotalCount(boardListCnt);
		
		List<BoardVO> list = boardService.selectBoardList(cri);
		map.put("boardList", list);
		map.put("paging", paging);
		
		return new Response(map);
	}
	/**
	 * 게시글 상세 조회
	 * @param boardVo
	 * @return boardVo
	 */
	@GetMapping
	public Response selectBoard(BoardVO boardVo) {
		return new Response(boardService.selectBoard(boardVo));
	}
	
	/**
	 * 게시글 수정
	 * @param boardVo
	 * @return
	 */
	@PatchMapping
	public Response updateBoard(@RequestBody BoardVO boardVo) {
		return new Response(boardService.updateBoard(boardVo));
	}
}
