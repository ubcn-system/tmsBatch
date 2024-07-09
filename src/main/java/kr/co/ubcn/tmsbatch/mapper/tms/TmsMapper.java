package kr.co.ubcn.tmsbatch.mapper.tms;

import java.util.List;

import kr.co.ubcn.tmsbatch.model.Division;
import kr.co.ubcn.tmsbatch.model.Group;
import kr.co.ubcn.tmsbatch.model.Issuer;
import kr.co.ubcn.tmsbatch.model.Merchant;
import kr.co.ubcn.tmsbatch.model.Operator;
import kr.co.ubcn.tmsbatch.model.Owner;
import kr.co.ubcn.tmsbatch.model.Terminal;


public interface TmsMapper {

	public int mergeIssuerList(List<Issuer> issuerList);
	public int mergeOwnerList(List<Owner> ownerList);
	public int mergeDivisionList(List<Division> divisionList);
	public int mergeMerchantList(List<Merchant> merchantList);
	public int mergeOperatorList(List<Operator> operatorList);
	public int mergeGroupList(List<Group> groupList);
	public int mergeTerminalList(List<Terminal> terminalList);
	
}
