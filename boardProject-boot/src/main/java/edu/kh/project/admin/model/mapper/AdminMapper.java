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

	/** 탈퇴한 회원목록 조회
	 * @return
	 */
	List<Member> selectWithdrawnMemberList();

	/** 삭제된 게시글 목록 조회
	 * @return
	 */
	List<Board> selectDeleteBoardList();

	/** 탈퇴한 회원 복구
	 * @param memberNo
	 * @return
	 */
	int restoreMember(int memberNo);

	/** 삭제된 게시글 복구
	 * @param boardNo
	 * @return
	 */
	int restoreBoard(int boardNo);

	/** 관리자 이메일 중복 여부 검사 
	 * @param memberEmail
	 * @return
	 */
	int checkEmail(String memberEmail);

	/** 관리자 계정 발급
	 * @param member
	 * @return
	 */
	int createAdminAccount(Member member);

	/** 관리자 계정 목록 조회
	 * @return
	 */
	List<Member> getAdminList();	

}
