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
}
