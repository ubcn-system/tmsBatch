package kr.co.ubcn.tmsbatch.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.ubcn.tmsbatch.model.Operator;
import kr.co.ubcn.tmsbatch.service.DataBaseService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class OperatorTask {

	@Autowired
	DataBaseService dataBaseService;

	public void jobStart() {
		
		log.info("=======================================================");
		log.info("  05.operator start  ");
		log.info("=======================================================");
		
		List<Operator> operatorList = null;
		operatorList = dataBaseService.selectOperatorList();
		log.info("Select CNT : " + String.valueOf(operatorList.size()));
		int res = dataBaseService.mergeOperatorList(operatorList);

		log.info("=============================================================================");
		log.info("  05.operator end  ");
		log.info("=============================================================================");

	}
}
