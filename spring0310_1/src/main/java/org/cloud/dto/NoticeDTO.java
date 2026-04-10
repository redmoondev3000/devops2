package org.cloud.dto;

import lombok.Data;

@Data
public class NoticeDTO {

	private int id;
	private String title;
	private String content;
	private String writer;
	private String regDate;
	private int hit;
}
