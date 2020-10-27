package com.noticeboard.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.noticeboard.domain.Notice;
import com.noticeboard.service.NoticeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@PostMapping("/notice")
	public ResponseEntity<Notice> createNotice(@Valid @RequestBody Notice notice) {
		Notice newNotice = this.noticeService.createNotice(notice);		
		return ResponseEntity.status(HttpStatus.CREATED).body(newNotice);
	}
	
	@GetMapping("/notice/{id}")
	public ResponseEntity<Notice> getNotice(@PathVariable(value = "id") Long id) {
		
		Optional<Notice> notice = this.noticeService.findNotice(id);
		
		if(notice.isPresent()) {
			return ResponseEntity.ok().body(notice.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping("/notice")
	public ResponseEntity<List<Notice>> getAllNotices() {
		List<Notice> notices = this.noticeService.findAllNotices();
		
		if(notices.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.ok().body(notices);		
	}
	
	@PutMapping("/notice/{id}")
	public ResponseEntity<Notice> updateNotice(@PathVariable(value = "id") Long id, @Valid @RequestBody Notice notice) {
		Notice updatedNotice = this.noticeService.updateNotice(id, notice);
		
		if(updatedNotice != null) {
			return ResponseEntity.ok().body(updatedNotice);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(updatedNotice);
		}
		
	}
	
	@DeleteMapping("/notice/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteNotice(@PathVariable(value = "id") Long id) {
		boolean noticeDeleted = this.noticeService.deleteNotice(id);
		
		Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", noticeDeleted);
        
        return ResponseEntity.ok().body(response);
	}
}
