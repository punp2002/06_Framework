package edu.kh.semiProject.nanumBoard.model.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {

    private Long commentNo; // 댓글 번호
    private String commentContent; // 댓글 내용
    private Date commentWriteDate; // 댓글 작성일
    private String commentDelFl; // 댓글 삭제 여부 (Y/N)
    private Long boardNo; // 게시글 번호
    private Long parentCommentNo; // 부모 댓글 번호
    private Long memberNo; // 작성 회원 번호    
	    
	 // 댓글 조회 시 회원 프로필 , 닉네임
	private String memberNickname;
	private String profileImg;
}
