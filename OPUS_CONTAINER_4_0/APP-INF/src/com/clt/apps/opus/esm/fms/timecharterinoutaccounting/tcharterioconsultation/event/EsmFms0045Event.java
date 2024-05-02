/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0045Event.java
*@FileTitle : Sublet Revenue Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.07.23 최우석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event;

import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CondSearchSubletRevenueVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0045 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0045HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi, WooSeok
 * @see ESM_FMS_0045HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmFms0045Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private CondSearchSubletRevenueVO condSearchSebletRevenueVO = null;
	
	private String toInvNo = "";
	private String csrNo = "";
	
	public void setCondSearchSebletRevenueVO(CondSearchSubletRevenueVO condSearchSebletRevenueVO){
		this. condSearchSebletRevenueVO = condSearchSebletRevenueVO;
	}

	public CondSearchSubletRevenueVO getCondSearchSebletRevenueVO(){
		return condSearchSebletRevenueVO;
	}
	
	public void setToInvNo(String toInvNo) {
		this.toInvNo = toInvNo;
	}

	public String getToInvNo() {
		return toInvNo;
	}

	public String getCsrNo() {
		return csrNo;
	}

	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}
	
}