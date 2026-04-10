package org.cloud.controller;

import org.cloud.dto.MemberDTO;
import org.cloud.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Controller

public class MainController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String loginForm() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(MemberDTO member, HttpSession session, RedirectAttributes rttr) {
		MemberDTO user = memberService.memberLoginCheck(member);
		if (user != null) {
			session.setAttribute("user", user);
			return "redirect:/";
		}
		rttr.addFlashAttribute("errorMsg", "아이디 또는 비밀번호가 일치하지 않습니다.");
		return "redirect:/login?error=true";
	}
	
	@GetMapping("/join")
	public String memberJoinUI() {
		return "join";
	}
	
	@PostMapping("/join")
	public String memberJoin(MemberDTO member) {
		memberService.memberJoin(member);
		return "redirect:/login";
	}
	
	@ResponseBody
	@GetMapping("/idCheck")
	public int idCheck(@RequestParam("userid") String userId) {
		return memberService.idCheck(userId);
	}
	
	@GetMapping("/logout")
	public String memberLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}





