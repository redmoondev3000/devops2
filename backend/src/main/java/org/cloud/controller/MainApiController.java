package org.cloud.controller;

import org.cloud.dto.MemberDTO;
import org.cloud.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/member")
public class MainApiController {

	@Autowired
	private MemberService memberService;
	
	
	@PostMapping("/login") //localhost:8080/api/member/login 
	public ResponseEntity<?> login(@RequestBody MemberDTO member, HttpSession session) {
		MemberDTO user = memberService.memberLoginCheck(member);
		if (user != null) {
			session.setAttribute("user", user);
			return ResponseEntity.ok(user);
		}
		return ResponseEntity.status(401).body("아이디 또는 비밀번호가 일치하지 않습니다.");
	}

	
	@PostMapping("/join")
	public ResponseEntity<String> memberJoin(@RequestBody MemberDTO member) {
		System.out.println("넘어온 데이터: " + member); 
		memberService.memberJoin(member);
		return ResponseEntity.ok("join success");
	}
	
	@GetMapping("/idCheck")
	public int idCheck(@RequestParam("userid") String userId) {
		return memberService.idCheck(userId);
	}
	
	@GetMapping("/logout")
	public ResponseEntity<String> memberLogout(HttpSession session) {
		session.invalidate();
		return ResponseEntity.ok("logout success");
	}
}
