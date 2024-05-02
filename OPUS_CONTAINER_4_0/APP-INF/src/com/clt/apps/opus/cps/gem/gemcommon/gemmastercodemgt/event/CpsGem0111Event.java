/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UiGae0006Event.java
 *@FileTitle : Closing Confirmation & Interface Status
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.22
 *@LastModifier : 최정미
 *@LastVersion : 1.0
 * 2009.04.22 최정미
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.event;


import com.clt.framework.support.layer.event.EventSupport;

/**
 *[CPS_GEM_0111] Monthly Accounting Rate Interface
 * CPS_GEM_0009 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - CPS_GEM_0009HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author choijungmi
 * @see CPS_GEM_0009HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsGem0111Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/**
	 *  Currency
	 */
	private String month = "";

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}
	
	
	



}