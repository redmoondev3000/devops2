package org.cloud.mapper;

import org.cloud.dto.MemberDTO;

public interface MemberMapper {
	MemberDTO memberLoginCheck(MemberDTO member);
	void memberJoin(MemberDTO member);
	int idCheck(String userId);
}
