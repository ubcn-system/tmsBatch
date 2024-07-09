package kr.co.ubcn.tmsbatch.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.ubcn.tmsbatch.model.Division;
import kr.co.ubcn.tmsbatch.model.Merchant;
import kr.co.ubcn.tmsbatch.model.Owner;
import kr.co.ubcn.tmsbatch.service.DataBaseService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MerchantTask {

	@Autowired
	DataBaseService dataBaseService;

	public void jobStart() {
		
		log.info("=======================================================");
		log.info("  04.merchant start  ");
		log.info("=======================================================");
		
		List<Merchant> merchantList = null;
		merchantList = dataBaseService.selectMerchantList();
		log.info("Select CNT : " + String.valueOf(merchantList.size()));
		int res = dataBaseService.mergeMerchantList(merchantList);

		log.info("=============================================================================");
		log.info("  04.merchant end  ");
		log.info("=============================================================================");

	}
}
