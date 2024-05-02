package com.hanjin.apps.alps.ees.dmt.dmtclosing.webdo.vo;

import com.hanjin.framework.support.view.signon.SignOnUserAccount;

public class IfAccountVO extends SignOnUserAccount {

	private static final long serialVersionUID = -2722016948074535361L;
	
	String usr_id	= "";
	String ofc_cd	= "";
	
	public IfAccountVO(String usr_id, String ofc_cd)
    {
        this.usr_id = usr_id;
        this.ofc_cd = ofc_cd;
    }

	public String getUsr_id() {
		return usr_id;
	}

	public void setUsr_id(String usr_id) {
		this.usr_id = usr_id;
	}

	public String getOfc_cd() {
		return ofc_cd;
	}

	public void setOfc_cd(String ofc_cd) {
		this.ofc_cd = ofc_cd;
	}
	
}
