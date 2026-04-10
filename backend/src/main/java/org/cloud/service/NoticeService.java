package org.cloud.service;

import java.util.List;

import org.cloud.dto.NoticeDTO;

public interface NoticeService {
	List<NoticeDTO> noticeList();
	void noticeWrite(NoticeDTO notice);
	NoticeDTO noticeDetail(int id);
	NoticeDTO noticeDetailNoCnt(int id);
	void noticeUpdate(NoticeDTO notice);
	void noticeDelete(int id);
}
