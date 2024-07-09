package kr.co.ubcn.tmsbatch.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.ubcn.tmsbatch.task.DivisionTask;
import kr.co.ubcn.tmsbatch.task.GroupTask;
import kr.co.ubcn.tmsbatch.task.IssuerTask;
import kr.co.ubcn.tmsbatch.task.MerchantTask;
import kr.co.ubcn.tmsbatch.task.OperatorTask;
import kr.co.ubcn.tmsbatch.task.OwnerTask;
import kr.co.ubcn.tmsbatch.task.TerminalTask;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@PropertySource("file:../config/ubcnBatchTms.properties")
@RestController
@RequestMapping("/tmsbatch")
@Component
public class Scheduler {

	@Autowired
	IssuerTask issuerTask;
	@Autowired
	OwnerTask ownerTask;
	@Autowired
	DivisionTask divisionTask;
	@Autowired
	MerchantTask merchantTask;
	@Autowired
	OperatorTask operatorTask;
	@Autowired
	GroupTask groupTask;
	@Autowired
	TerminalTask terminalTask;
	
	@RequestMapping(method= {RequestMethod.GET, RequestMethod.POST})
	@Scheduled(cron = "${spring.batch.TmsBatch.cron}")
	public void TmsBatch() {
		issuerTask.jobStart();
		ownerTask.jobStart();
		divisionTask.jobStart();
		merchantTask.jobStart();
		operatorTask.jobStart();
		groupTask.jobStart();
		terminalTask.jobStart();
	}


}
