package kr.co.ubcn.tmsbatch.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.ubcn.tmsbatch.model.Terminal;
import kr.co.ubcn.tmsbatch.service.DataBaseService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TerminalTask {

	@Autowired
	DataBaseService dataBaseService;

	public void jobStart() {
		
		log.info("=======================================================");
		log.info("  07.Terminal start  ");
		log.info("=======================================================");
		
		List<Terminal> terminalList = null;
		terminalList = dataBaseService.selectTerminalList();
		log.info("Select CNT : " + String.valueOf(terminalList.size()));
		int res = dataBaseService.mergeTerminalList(terminalList);

		log.info("=============================================================================");
		log.info("  07.Terminal end  ");
		log.info("=============================================================================");

	}
}
