/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsGem0023Event.java
 *@FileTitle :Request / Initial _ Print
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
 * [CPS_GEM_0023] Request / Initial _ Print

 * @author choijungmi
 * @see
 * @since J2EE 1.4
 */

public class CpsGem0023Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String plnYrmon = "";
	private  String genExpnRqstNo = "";
	private String langDiv = "";
	
	private String genExpnRqstSeq = "";
	
	public String getGenExpnRqstSeq() {
		return genExpnRqstSeq;
	}
	public void setGenExpnRqstSeq(String genExpnRqstSeq) {
		this.genExpnRqstSeq = genExpnRqstSeq;
	}
	public String getPlnYrmon() {
		return plnYrmon;
	}
	public void setPlnYrmon(String plnYrmon) {
		this.plnYrmon = plnYrmon;
	}
	public String getGenExpnRqstNo() {
		return genExpnRqstNo;
	}
	public void setGenExpnRqstNo(String genExpnRqstNo) {
		this.genExpnRqstNo = genExpnRqstNo;
	}
	public String getLangDiv() {
		return langDiv;
	}
	public void setLangDiv(String langDiv) {
		this.langDiv = langDiv;
	}
	


}