/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : FnsInv0121Event.java
*@FileTitle : Revenue & Processing VVD Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.12
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.05.06 김태균
* 1.0 Creation
* 2011.05.12 김태균 [CHM-201110564-01] AR Invoice - VVD 조회 기능 개발 요청 - 신규
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.RevenueProcessParamVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0004 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0004HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Hwi Taek
 * @see FNS_INV_0004HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0121Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RevenueProcessParamVO revenueProcessParamVO = null;
	
	public FnsInv0121Event(){}

	public RevenueProcessParamVO getRevenueProcessParamVO() {
		return revenueProcessParamVO;
	}

	public void setRevenueProcessParamVO(RevenueProcessParamVO revenueProcessParamVO) {
		this.revenueProcessParamVO = revenueProcessParamVO;
	}


}