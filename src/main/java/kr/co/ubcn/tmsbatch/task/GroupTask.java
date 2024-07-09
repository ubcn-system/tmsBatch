package kr.co.ubcn.tmsbatch.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.ubcn.tmsbatch.model.Group;
import kr.co.ubcn.tmsbatch.service.DataBaseService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class GroupTask {

	@Autowired
	DataBaseService dataBaseService;

	public void jobStart() {
		
		log.info("=======================================================");
		log.info("  06.group start  ");
		log.info("=======================================================");
		
		List<Group> groupList = null;
		groupList = dataBaseService.selectGroupList();
		log.info("Select CNT : " + String.valueOf(groupList.size()));
		int res = dataBaseService.mergeGroupList(groupList);

		log.info("=============================================================================");
		log.info("  06.group end  ");
		log.info("=============================================================================");

	}
}
