package org.cloud.controller;

import java.util.List;

import org.cloud.dto.NoticeDTO;
import org.cloud.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/notice")
public class NoticeApiController {

	@Autowired
	NoticeService noticeService;
	
	@GetMapping("/list")  //localhost:8080/notice/list
	public List<NoticeDTO> noticeList() {
		return noticeService.noticeList();
	}
	
	@PostMapping("/write")
	public ResponseEntity<String> noticeWrite(@RequestBody NoticeDTO notice) {
		noticeService.noticeWrite(notice);
		return ResponseEntity.ok("write success");
	}
	
	@GetMapping("/detail/{id}")
	public NoticeDTO noticeDetail(@PathVariable("id") int id) {
		return noticeService.noticeDetail(id);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> noticeUpdate(@RequestBody NoticeDTO notice) {
		noticeService.noticeUpdate(notice);
		return ResponseEntity.ok("update success");
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> noticeDelete(@PathVariable("id") int id) {
		noticeService.noticeDelete(id);
		return ResponseEntity.ok("delete success");
	}
}
