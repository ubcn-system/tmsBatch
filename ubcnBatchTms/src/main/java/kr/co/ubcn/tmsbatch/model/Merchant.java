package kr.co.ubcn.tmsbatch.model;

import lombok.Data;

@Data
public class Merchant {
	public String business_no;
	public String division_no;
	public String issuer_code;
	public String account_no;
	public String eddc_yn;
	public String open_date;
	public String close_date;
	public String fee_rate;
	public String commission_rate;
	public String created_at;
	public String modified_at;
	public String status;
	 
}

 