/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : StmSap0100Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.02
*@LastModifier : Hannah Lee
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event;

import com.clt.framework.support.layer.event.EventSupport;

import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.APBankAccountByOfficeCondVO;


/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceMasterDataMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Hannah Lee
 * @see AccountReceivableInvoiceMasterDataMgtEvent 참조
 * @since J2EE 1.4
 */

public class StmSap0100Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object Search Parameter VO*/
	private APBankAccountByOfficeCondVO apBankAccountByOfficeCondVO = null;
 
	public StmSap0100Event() {}
	
	public APBankAccountByOfficeCondVO getAPBankAccountByOfficeCondVO() {
		return apBankAccountByOfficeCondVO;
	}

	public void setAPBankAccountByOfficeCondVO(APBankAccountByOfficeCondVO apBankAccountByOfficeCondVO) {
		this.apBankAccountByOfficeCondVO = apBankAccountByOfficeCondVO;
	}
	

}