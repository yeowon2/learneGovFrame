package egovframework.let.board.service.impl;

import java.util.List;

import egovframework.let.board.service.BoardVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;

//자바파일이 mapper를 annotation을 지정해주도록 적어야함
@Mapper("boardMapper")

public interface BoardMapper {
	
	// 게시판 목록 가져오기
	List<EgovMap> selectBoardList(BoardVO vo) throws Exception;
	
	// 게시물 목록 수
	int selectBoardListCnt(BoardVO vo) throws Exception;
	
	// 게시물 등록하기
	void insertBoard(BoardVO vo) throws Exception;
	
	// 게시물 상세 정보
	BoardVO selectBoard(BoardVO vo) throws Exception;
	
	// 조회수 업
	void updateViewCnt(BoardVO vo) throws Exception;
	
	// 게시글 수정하기 
	void updateBoard(BoardVO vo) throws Exception;
	
	// 게시글 삭제하기 
	void deleteBoard(BoardVO vo) throws Exception;
}
