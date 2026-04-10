package org.cloud.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.cloud.dto.NoticeDTO;

@Mapper
public interface NoticeMapper {

	List<NoticeDTO> noticeList();
	void noticeWrite(NoticeDTO notice);
	NoticeDTO noticeDetail(int id);
	void updateHit(int id);
	void noticeUpdate(NoticeDTO notice);
	void noticeDelete(int id);
}
