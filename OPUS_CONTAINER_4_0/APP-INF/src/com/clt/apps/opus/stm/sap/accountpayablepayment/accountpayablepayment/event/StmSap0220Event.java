/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StmSap0220Event.java
*@FileTitle : Create Accounting Event
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.event;


import com.clt.framework.support.layer.event.EventSupport;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.AccountingCondVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.APAccountingListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.SapCommonVO;


/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountPayablePaymentSC로 실행요청<br>
 * - AccountPayablePaymentSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author ORKIM
 * @see StmSap0220Event 참조
 * @since J2EE 1.6
 */
public class StmSap0220Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	private SapCommonVO sapCommonVO = null;
	private SapCommonVO[] sapCommonVOs = null;
	
	private AccountingCondVO accountingCondVO = null;
	
	private APAccountingListVO aPAccountingListVO = null;
	private APAccountingListVO[] aPAccountingListVOs = null;

	String functionalCurrency = null;
	String capturePeriod = null;
	String backEndJobKey = null;
	String csrNo = null;
	
	public SapCommonVO getSapCommonVO() {
		return sapCommonVO;
	}
	public void setSapCommonVO(SapCommonVO sapCommonVO) {
		this.sapCommonVO = sapCommonVO;
	}
	
	public SapCommonVO[] getSapCommonVOs() {
		SapCommonVO[] rtnVOs = null;
		if(this.sapCommonVOs != null) {
			rtnVOs = new SapCommonVO[sapCommonVOs.length];
			System.arraycopy(sapCommonVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setSapCommonVOs(SapCommonVO[] sapCommonVOs) {
		if(sapCommonVOs != null) {
			SapCommonVO[] tmpVOs = new SapCommonVO[sapCommonVOs.length];
			System.arraycopy(sapCommonVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.sapCommonVOs = tmpVOs;
		}
	}
	
	public AccountingCondVO getAccountingCondVO() {
		return accountingCondVO;
	}
	public void setAccountingCondVO(AccountingCondVO accountingCondVO) {
		this.accountingCondVO = accountingCondVO;
	}
	public APAccountingListVO getaPAccountingListVO() {
		return aPAccountingListVO;
	}
	public void setaPAccountingListVO(APAccountingListVO aPAccountingListVO) {
		this.aPAccountingListVO = aPAccountingListVO;
	}
	public APAccountingListVO[] getaPAccountingListVOs() {
		APAccountingListVO[] rtnVOs = null;
		if(this.aPAccountingListVOs != null) {
			rtnVOs = new APAccountingListVO[aPAccountingListVOs.length];
			System.arraycopy(aPAccountingListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setaPAccountingListVOs(APAccountingListVO[] aPAccountingListVOs) {
		if(aPAccountingListVOs != null) {
			APAccountingListVO[] tmpVOs = new APAccountingListVO[aPAccountingListVOs.length];
			System.arraycopy(aPAccountingListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.aPAccountingListVOs = tmpVOs;
		}
	}

	public String getFunctionalCurrency() {
		return functionalCurrency;
	}
	public void setFunctionalCurrency(String functionalCurrency) {
		this.functionalCurrency = functionalCurrency;
	}
	public String getCapturePeriod() {
		return capturePeriod;
	}
	public void setCapturePeriod(String capturePeriod) {
		this.capturePeriod = capturePeriod;
	}
	public String getBackEndJobKey() {
		return backEndJobKey;
	}
	public void setBackEndJobKey(String backEndJobKey) {
		this.backEndJobKey = backEndJobKey;
	}
	public String getCsrNo() {
		return csrNo;
	}
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}

}
