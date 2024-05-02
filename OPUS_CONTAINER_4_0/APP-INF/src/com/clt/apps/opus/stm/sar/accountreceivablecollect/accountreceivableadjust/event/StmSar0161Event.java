/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StmSar0161Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.event;

import com.clt.framework.support.layer.event.EventSupport;

/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableCommonSC로 실행요청<br>
 * - AccountReceivableCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see StmSar0161Event 참조
 * @since J2EE 1.4
 */

public class StmSar0161Event extends EventSupport {

	private static final long serialVersionUID = 1L;
		
	private String lu_cd;
	private String lu_desc;
	
	private String[] arr_lu_cd = null;
	
	public String getLu_cd() {
		return lu_cd;
	}
	public void setLu_cd(String lu_cd) {
		this.lu_cd = lu_cd;
	}
	public String getLu_desc() {
		return lu_desc;
	}
	public void setLu_desc(String lu_desc) {
		this.lu_desc = lu_desc;
	}

	public String[] getArr_lu_cd() {
		String[] rtnVOs = null;
		if (this.arr_lu_cd != null) {
			rtnVOs = new String[arr_lu_cd.length];
			System.arraycopy(arr_lu_cd, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setArr_lu_cd(String[] arr_lu_cd) {
		if (arr_lu_cd != null) {
			String[] tmpVOs = new String[arr_lu_cd.length];
			System.arraycopy(arr_lu_cd, 0, tmpVOs, 0, tmpVOs.length);
			this.arr_lu_cd = tmpVOs;
		}
	}
}