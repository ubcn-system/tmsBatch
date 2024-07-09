package kr.co.ubcn.tmsbatch.task;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.ubcn.tmsbatch.model.Issuer;
import kr.co.ubcn.tmsbatch.service.DataBaseService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class IssuerTask {

	@Autowired
	DataBaseService dataBaseService;

	public void jobStart() {
		
		log.info("=======================================================");
		log.info("  01.issuer start  ");
		log.info("=======================================================");
		
		List<Issuer> issuerList = null;
		issuerList = dataBaseService.selectIssuerList();
		log.info("Select CNT : " + String.valueOf(issuerList.size()));
		int res = dataBaseService.mergeIssuerList(issuerList);

		log.info("=============================================================================");
		log.info("  01.issuer end  ");
		log.info("=============================================================================");

	}
}
