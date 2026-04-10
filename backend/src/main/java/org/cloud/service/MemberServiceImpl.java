package org.cloud.service;

import org.cloud.dto.MemberDTO;
import org.cloud.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper memberMapper;
	
	@Override
	public MemberDTO memberLoginCheck(MemberDTO member) {
		// TODO Auto-generated method stub
		return memberMapper.memberLoginCheck(member);
	}
	
	@Override
	public void memberJoin(MemberDTO member) {
		// TODO Auto-generated method stub
		memberMapper.memberJoin(member);
	}
	
	@Override
	public int idCheck(String userId) {
		// TODO Auto-generated method stub
		return memberMapper.idCheck(userId);
	}
}







