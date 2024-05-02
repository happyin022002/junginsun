/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StmSar0003Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.event;

import com.clt.framework.support.layer.event.EventSupport;

/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableCommonSC로 실행요청<br>
 * - AccountReceivableCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see StmSar0003Event 참조
 * @since J2EE 1.4
 */

public class StmSar0003Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * popup office code select 
	 */
	private  String[] selOfcCds ;

	/**
	 * Office level type 
	 * 'QUERY'=> Inquery authorize  or EMPTY ==> entry authorize   
	 */
	private String ofcLvlTp = "";	
	
	/**
	 * @return the selOfcCds
	 */
	public String[] getSelOfcCds() {
		String[] rtnVOs = null;
		if (this.selOfcCds != null) {
			rtnVOs = new String[selOfcCds.length];
			System.arraycopy(selOfcCds, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param selOfcCds the selOfcCds to set
	 */
	public void setSelOfcCds(String[] selOfcCds) {
		if (selOfcCds != null) {
			String[] tmpVOs = new String[selOfcCds.length];
			System.arraycopy(selOfcCds, 0, tmpVOs, 0, tmpVOs.length);
			this.selOfcCds = tmpVOs;
		}
	}

	public String getOfcLvlTp() {
		return ofcLvlTp;
	}

	public void setOfcLvlTp(String ofcLvlTp) {
		this.ofcLvlTp = ofcLvlTp;
	}
	
	

	
	
	
	
	

}