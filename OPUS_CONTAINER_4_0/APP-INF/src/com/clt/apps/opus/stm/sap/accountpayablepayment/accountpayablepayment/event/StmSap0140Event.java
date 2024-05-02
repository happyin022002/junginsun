/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : StmSap0140Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* Created by ORKIM
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.event;

import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.APTransactionCondVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountPayablePaymentSC로 실행요청<br>
 * - AccountPayablePaymentSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author ORKIM
 * @see StmSap0140Event 참조
 * @since J2EE 1.4
 */

public class StmSap0140Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object Search Parameter VO*/
	private APTransactionCondVO APTransactionCondVO = null;
	
	public StmSap0140Event() {}

	public APTransactionCondVO getAPTransactionCondVO() {
		return APTransactionCondVO;
	}

	public void setAPTransactionCondVO(APTransactionCondVO aPTransactionCondVO) {
		APTransactionCondVO = aPTransactionCondVO;
	}

}