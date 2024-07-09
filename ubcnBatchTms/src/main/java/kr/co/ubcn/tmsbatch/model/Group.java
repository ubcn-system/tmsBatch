package kr.co.ubcn.tmsbatch.model;

import lombok.Data;

@Data
public class Group {
	public String no;
	public String parent_no;
	public String type;
	public String level;
	public String operator_no;
	public String name;
	public String path;
	public String description;
	public String created_at;
	public String modified_at;
	public String status;
	 
}

 