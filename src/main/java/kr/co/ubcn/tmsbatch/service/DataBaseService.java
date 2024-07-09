package kr.co.ubcn.tmsbatch.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.ubcn.tmsbatch.mapper.vanbt.VanbtMapper;
import kr.co.ubcn.tmsbatch.mapper.tms.TmsMapper;
import kr.co.ubcn.tmsbatch.model.Division;
import kr.co.ubcn.tmsbatch.model.Group;
import kr.co.ubcn.tmsbatch.model.Issuer;
import kr.co.ubcn.tmsbatch.model.Merchant;
import kr.co.ubcn.tmsbatch.model.Operator;
import kr.co.ubcn.tmsbatch.model.Owner;
import kr.co.ubcn.tmsbatch.model.Terminal;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class DataBaseService {

	@Autowired
	VanbtMapper vanbtMapper;

	@Autowired
	TmsMapper tmsMapper;

	public List<Issuer> selectIssuerList() {
		return vanbtMapper.selectIssuerList();
	}
	
	public int mergeIssuerList(List<Issuer> issuerList) {
		return tmsMapper.mergeIssuerList(issuerList);
	}
	
	public List<Owner> selectOwnerList() {
		return vanbtMapper.selectOwnerList();
	}
	
	public int mergeOwnerList(List<Owner> ownerList) {
		return tmsMapper.mergeOwnerList(ownerList);
	}
	
	public List<Division> selectDivisionList() {
		return vanbtMapper.selectDivisionList();
	}
	
	public int mergeDivisionList(List<Division> divisionList) {
		return tmsMapper.mergeDivisionList(divisionList);
	}
	
	public List<Merchant> selectMerchantList() {
		return vanbtMapper.selectMerchantList();
	}
	
	public int mergeMerchantList(List<Merchant> merchantList) {
		return tmsMapper.mergeMerchantList(merchantList);
	}
	
	public List<Operator> selectOperatorList() {
		return vanbtMapper.selectOperatorList();
	}
	
	public int mergeOperatorList(List<Operator> operatorList) {
		return tmsMapper.mergeOperatorList(operatorList);
	}
	
	public List<Group> selectGroupList() {
		return vanbtMapper.selectGroupList();
	}
	
	public int mergeGroupList(List<Group> groupList) {
		return tmsMapper.mergeGroupList(groupList);
	}
	
	public List<Terminal> selectTerminalList() {
		return vanbtMapper.selectTerminalList();
	}
	
	public int mergeTerminalList(List<Terminal> terminalList) {
		
		for(int i = 0; i < terminalList.size()/10000 + 1; i++) {
			List<Terminal> subList = new ArrayList<Terminal>(terminalList.subList((i==0) ? 0 : i*10000, 
																					terminalList.size() > (i+1)*10000-1 ? (i+1)*10000-1 : terminalList.size()));
			log.info(((i==0) ? 0 : i*10000) + " ~ " + (terminalList.size() > (i+1)*10000-1 ? (i+1)*10000-1 : terminalList.size()));
			tmsMapper.mergeTerminalList(subList);
		}
		
		return 0;
	}


}
