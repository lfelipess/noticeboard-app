package com.noticeboard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.noticeboard.domain.Notice;

public interface NoticeService {
	
	Notice createNotice(Notice notice);	
	Optional<Notice> findNotice(Long id);	
	List<Notice> findAllNotices();	
	Notice updateNotice(Long id, Notice notice);	
	boolean deleteNotice(Long id);
}
