package edu.kh.semiProject.nanumBoard.model.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardImg {

    private Long imgNo; // 이미지 번호 (PK)
    private String imgPath; // 이미지 경로
    private String imgOriginalName; // 이미지 원본 이름
    private String imgRename; // 이미지 변경 이름
    private Integer imgOrder; // 이미지 순서
    private Long boardNo; // 게시글 번호 (FK)
    
	// 게시글 이미지 삽입/수정 할 때 사용
	private MultipartFile uploadFile;

}
