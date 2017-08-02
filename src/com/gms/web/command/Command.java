package com.gms.web.command;

import com.gms.web.constant.Extension;
import com.gms.web.constant.Path;

public class Command implements Commandable{
	protected String dir, action, page, view;	//상속 가능하도록 protected로 설정

	public String getView() {
		return view;
	}
	
	public String getDirectory() {
		return dir;
	}

	public void setDirectory(String directory) {
		this.dir = directory;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}
	
	@Override
	public void process() {	//setView 역할
		this.view = Path.VIEW + dir + Path.SEPARATOR + page + Extension.JSP;
		
	}
	
	@Override
	public String toString() {
		return "Command [DEST="+dir+"/"+page+".jsp, ACTION="+action+"]";
	}
}
