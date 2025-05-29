package edu.kh.project.admin.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.board.model.dto.Board;
import edu.kh.project.member.model.dto.Member;



@Mapper
public interface AdminMapper {

	Member login(String memberEmail);

	Board maxReadCount();
	
	Board maxLikeCount();

	Board maxCommentCount();

	List<Member> getUserJoin();	

}
