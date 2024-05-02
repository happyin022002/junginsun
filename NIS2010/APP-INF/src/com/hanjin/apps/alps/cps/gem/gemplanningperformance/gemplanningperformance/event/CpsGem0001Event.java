/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsGem0001Event.java
 *@FileTitle : Expense Request tab 메인페이지
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.22
 *@LastModifier : 최정미
 *@LastVersion : 1.0
 * 2009.04.22 최정미
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.event;


import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * [UI_GEM-0001] Expense Request tab 메인페이지
 * @author choijungmi
 * @see CPS_GEM_0001HTMLAction
 * @since J2EE 1.5
 */
public class CpsGem0001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String authFlg = "";

	public String getAuthFlg() {
		return authFlg;
	}

	public void setAuthFlg(String authFlg) {
		this.authFlg = authFlg;
	}

}