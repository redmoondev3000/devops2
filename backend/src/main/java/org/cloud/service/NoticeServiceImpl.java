package org.cloud.service;

import java.util.List;

import org.cloud.dto.NoticeDTO;
import org.cloud.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	NoticeMapper noticeMapper;

	@Override
	public List<NoticeDTO> noticeList() {
		// TODO Auto-generated method stub
		return noticeMapper.noticeList();
	}
	
	@Override
	public void noticeWrite(NoticeDTO notice) {
		// TODO Auto-generated method stub
		noticeMapper.noticeWrite(notice);
	}
	
	@Override
	public NoticeDTO noticeDetail(int id) {
		// TODO Auto-generated method stub
		noticeMapper.updateHit(id);
		return noticeMapper.noticeDetail(id);
	}
	
	@Override
	public NoticeDTO noticeDetailNoCnt(int id) {
		// TODO Auto-generated method stub
		return noticeMapper.noticeDetail(id);
	}
	
	@Override
	public void noticeUpdate(NoticeDTO notice) {
		// TODO Auto-generated method stub
		noticeMapper.noticeUpdate(notice);
	}
	
	@Override
	public void noticeDelete(int id) {
		// TODO Auto-generated method stub
		noticeMapper.noticeDelete(id);
	}
}
