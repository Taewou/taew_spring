package com.taew.jdbc.chap08_1;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.taew.jdbc.chap03.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * p.204 [리스트 8.13]를 Main과 Service로 분리한 Service 부분
 * 
 * @author Jacob
 */
@Service
public class MemberService {

	Logger logger = LogManager.getLogger();

	@Autowired
	MemberDao memberDao;


	public void selectAll() {
		List<Member> members = memberDao.selectAll(0, 100);
		logger.debug(members);
	}

	public void updateMember() {
		Member member = memberDao.selectByEmail("jacob@irafe.com");
		member.setPassword("b");
		memberDao.update(member);
		logger.debug("Update complete.");
	}

	public void insertMember() {
		Member member = new Member();
		member.setEmail("taew@naver.com");
		member.setPassword("박태우");
		member.setName("박태우");
		memberDao.insert(member);
		logger.debug("Insert complete.");
	}
}
