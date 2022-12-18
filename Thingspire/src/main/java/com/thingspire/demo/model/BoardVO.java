package com.thingspire.demo.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardVO {
	@ApiModelProperty(value="배상Id")
	private int boardId;
	@ApiModelProperty(value="작성자")
	private String boardWriter;
	@ApiModelProperty(value="제목")
	private String boardTitle;
	@ApiModelProperty("내용")
	private String boardContent;
	@ApiModelProperty("등록일")
	private String regDate;
	@ApiModelProperty("수정일")
	private String modDate;
}
