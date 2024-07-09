package kr.co.ubcn.tmsbatch.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.ubcn.tmsbatch.model.Owner;
import kr.co.ubcn.tmsbatch.service.DataBaseService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class OwnerTask {

	@Autowired
	DataBaseService dataBaseService;

	public void jobStart() {
		
		log.info("=======================================================");
		log.info("  02.owner start  ");
		log.info("=======================================================");
		
		List<Owner> ownerList = null;
		ownerList = dataBaseService.selectOwnerList();
		log.info("Select CNT : " + String.valueOf(ownerList.size()));
		int res = dataBaseService.mergeOwnerList(ownerList);

		log.info("=============================================================================");
		log.info("  02.owner end  ");
		log.info("=============================================================================");

	}
}
