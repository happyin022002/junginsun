/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsGem0104Event.java
 *@FileTitle : Authorized Expense Code
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
 * [CPS_GEM_0104] Assigned Expense
 * CPS_GEM-0104 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - CpsGem0104Event 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author choijungmi
 * @see CPS_GEM_0104HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsGem0104Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String plnYrmon = "";
	private String ofcCd = "";
	private String genExpnCd = "";
	
	public String getPlnYrmon() {
		return plnYrmon;
	}
	public void setPlnYrmon(String plnYrmon) {
		this.plnYrmon = plnYrmon;
	}
	public String getOfcCd() {
		return ofcCd;
	}
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	public String getGenExpnCd() {
		return genExpnCd;
	}
	public void setGenExpnCd(String genExpnCd) {
		this.genExpnCd = genExpnCd;
	}

    
	
	



}