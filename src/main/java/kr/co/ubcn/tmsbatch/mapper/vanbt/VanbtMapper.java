package kr.co.ubcn.tmsbatch.mapper.vanbt;

import java.util.List;

import kr.co.ubcn.tmsbatch.model.Division;
import kr.co.ubcn.tmsbatch.model.Group;
import kr.co.ubcn.tmsbatch.model.Issuer;
import kr.co.ubcn.tmsbatch.model.Merchant;
import kr.co.ubcn.tmsbatch.model.Operator;
import kr.co.ubcn.tmsbatch.model.Owner;
import kr.co.ubcn.tmsbatch.model.Terminal;


public interface VanbtMapper {

	public List<Issuer> selectIssuerList();
	public List<Owner> selectOwnerList();
	public List<Division> selectDivisionList();
	public List<Merchant> selectMerchantList();
	public List<Operator> selectOperatorList();
	public List<Group> selectGroupList();
	public List<Terminal> selectTerminalList();
	

}
