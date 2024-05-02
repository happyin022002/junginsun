/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StmSar0005Event.java
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

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.ReceiptBankListCondVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.event.EventSupport;



/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableCommonSC로 실행요청<br>
 * - AccountReceivableCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see StmSar0005Event 참조
 * @since J2EE 1.4
 */

public class StmSar0005Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String rctTpCd = null;
	
	private String rctOfcCd = null;
	
	private String bankCtrlCd = null;
	
	private String bankAcctNm = null;
	
	private String uiType = null;
	
	private String localCurrCd = null;
	
	private ReceiptBankListCondVO receiptBankListCondVO = null;
	
	public StmSar0005Event() {}
	
	
	public String getRctTpCd() {
		return rctTpCd;
	}
	
	public void setRctTpCd(String rctTpCd) {
		this.rctTpCd = rctTpCd;	
	}
	
	public String getRctOfcCd() {
		return rctOfcCd;
	}
	
	public void setRctOfcCd(String rctOfcCd) {
		this.rctOfcCd = rctOfcCd;	
	}
	
	public String getBankCtrlCd() {
		return bankCtrlCd;
	}
	
	public void setBankCtrlCd(String bankCtrlCd) {
		this.bankCtrlCd = bankCtrlCd;	
	}
	
	public String getBankAcctNm() {
		return bankAcctNm;
	}
	
	public void setBankAcctNm(String bankAcctNm) {
		this.bankAcctNm = bankAcctNm;	
	}
	
	public String getUiType() {
		return uiType;
	}
	
	public void setUiType(String uiType) {
		this.uiType = uiType;	
	}
	
	public String getLocalCurrCd() {
		return localCurrCd;
	}


	public void setLocalCurrCd(String localCurrCd) {
		this.localCurrCd = localCurrCd;
	}


	public ReceiptBankListCondVO getReceiptBankListCondVO() {
		return receiptBankListCondVO;
	}

	public void setReceiptBankListCondVO(ReceiptBankListCondVO receiptBankListCondVO) {
		this.receiptBankListCondVO = receiptBankListCondVO;
	}
}