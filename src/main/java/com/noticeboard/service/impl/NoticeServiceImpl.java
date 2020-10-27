package com.noticeboard.service.impl;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noticeboard.domain.Notice;
import com.noticeboard.repository.NoticeRepository;
import com.noticeboard.service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeRepository noticeRepository;

	@Override
	public Notice createNotice(Notice notice) {
		Calendar dateNow = new GregorianCalendar();
		notice.setPublishDate(dateNow.getTime());
		return noticeRepository.save(notice);
	}

	@Override
	public Optional<Notice> findNotice(Long id) {
		Optional<Notice> notice = noticeRepository.findById(id);
		
		return notice;
	}

	@Override
	public List<Notice> findAllNotices() {
		List<Notice> notices = noticeRepository.findAll();		
		return notices;
	}

	@Override
	public Notice updateNotice(Long id, Notice notice) {
		Optional<Notice> noticeDomain = this.findNotice(id);
		
		if(noticeDomain.isPresent()) {
			Notice presentNotice = noticeDomain.get();
			
			presentNotice.setTitle(notice.getTitle());
			presentNotice.setDescription(notice.getDescription());
			presentNotice.setPublishDate(notice.getPublishDate());
			presentNotice.setVisualizationDate(notice.getVisualizationDate());
			
			final Notice updatedNotice = noticeRepository.save(presentNotice);
			
			return updatedNotice;
		}
		
		return null;
	}

	@Override
	public boolean deleteNotice(Long id) {
		Optional<Notice> noticeDomain = this.findNotice(id);
		
		if(noticeDomain.isPresent()) {
			noticeRepository.delete(noticeDomain.get());
			return true;
		}
		
		return false;
	}
	
	
}
