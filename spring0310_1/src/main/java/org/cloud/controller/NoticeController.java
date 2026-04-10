package org.cloud.controller;

import org.cloud.dto.NoticeDTO;
import org.cloud.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/notice")  //localhost:8080/notice
public class NoticeController {

	@Autowired
	NoticeService noticeService;
	
	@GetMapping("/list")  //localhost:8080/notice/list
	public String noticeList(Model model) {
		model.addAttribute("list", noticeService.noticeList());
		return "noticeList";
	}
	
	@GetMapping("/writeui")
	public String noticeWriteUI() {
		return "noticeWrite";
	}
	
	@PostMapping("/write")
	public String noticeWrite(NoticeDTO notice) {
		noticeService.noticeWrite(notice);
		return "redirect:/notice/list";
	}
	
	@GetMapping("/detail")
	public String noticeDetail(@RequestParam("id") int id, Model model) {
		model.addAttribute("notice", noticeService.noticeDetail(id));
		return "noticeDetail";
	}
	
	@GetMapping("/updateui")
	public String noticeUpdateUI(@RequestParam("id") int id, Model model) {
		model.addAttribute("notice", noticeService.noticeDetailNoCnt(id));
		return "noticeUpdate";
	}
	
	@PostMapping("/update")
	public String noticeUpdate(NoticeDTO notice) {
		noticeService.noticeUpdate(notice);
		return "redirect:/notice/detail?id=" + notice.getId();
	}
	
	@PostMapping("/delete")
	public String noticeDelete(@RequestParam("id") int id) {
		noticeService.noticeDelete(id);
		return "redirect:/notice/list";
	}
}




