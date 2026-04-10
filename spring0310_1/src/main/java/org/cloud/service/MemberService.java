package org.cloud.service;

import org.cloud.dto.MemberDTO;

public interface MemberService {
	MemberDTO memberLoginCheck(MemberDTO member);
	void memberJoin(MemberDTO member);
	int idCheck(String userId);
}
