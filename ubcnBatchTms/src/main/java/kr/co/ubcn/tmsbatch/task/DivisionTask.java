package kr.co.ubcn.tmsbatch.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.ubcn.tmsbatch.model.Division;
import kr.co.ubcn.tmsbatch.model.Owner;
import kr.co.ubcn.tmsbatch.service.DataBaseService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DivisionTask {

	@Autowired
	DataBaseService dataBaseService;

	public void jobStart() {
		
		log.info("=======================================================");
		log.info("  03.division start  ");
		log.info("=======================================================");
		
		List<Division> divisionList = null;
		divisionList = dataBaseService.selectDivisionList();
		log.info("Select CNT : " + String.valueOf(divisionList.size()));
		int res = dataBaseService.mergeDivisionList(divisionList);

		log.info("=============================================================================");
		log.info("  03.division end  ");
		log.info("=============================================================================");

	}
}
