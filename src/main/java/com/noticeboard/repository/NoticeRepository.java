package com.noticeboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.noticeboard.domain.Notice;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long>{

}
