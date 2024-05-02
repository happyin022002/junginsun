/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StmSap0120Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.event;


import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.BankBalanceAdjustmentListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.BankAccountAdjustmentListVO;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo.BankBalanceByOfficeCondVO;
import com.clt.framework.support.layer.event.EventSupport;



/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceMasterDataMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author CLT
 * @see AccountReceivableInvoiceMasterDataMgtEvent 참조
 * @since J2EE 1.4
 */

public class StmSap0120Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private BankBalanceByOfficeCondVO bankBalanceByOfficeCondVO = null;
	private BankBalanceByOfficeCondVO[] bankBalanceByOfficeCondVOs = null;
	private BankBalanceAdjustmentListVO bankBalanceAdjustmentListVO = null;
	private BankBalanceAdjustmentListVO[] bankBalanceAdjustmentListVOs = null;
	private BankAccountAdjustmentListVO bankAccountAdjustmentListVO = null;
	private BankAccountAdjustmentListVO[] bankAccountAdjustmentListVOs = null;	
	
	public BankBalanceByOfficeCondVO getBankBalanceByOfficeCondVO() {
		return bankBalanceByOfficeCondVO;
	}
	public void setBankBalanceByOfficeCondVO(BankBalanceByOfficeCondVO bankBalanceByOfficeCondVO) {
		this.bankBalanceByOfficeCondVO = bankBalanceByOfficeCondVO;
	}
	public BankBalanceByOfficeCondVO[] getBankBalanceByOfficeCondVOs() {
		BankBalanceByOfficeCondVO[] rtnVOs = null;
		if(this.bankBalanceByOfficeCondVOs != null) {
			rtnVOs = new BankBalanceByOfficeCondVO[bankBalanceByOfficeCondVOs.length];
			System.arraycopy(bankBalanceByOfficeCondVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setBankBalanceByOfficeCondVOs(BankBalanceByOfficeCondVO[] bankBalanceByOfficeCondVOs) {
		if(bankBalanceByOfficeCondVOs != null) {
			BankBalanceByOfficeCondVO[] tmpVOs = new BankBalanceByOfficeCondVO[bankBalanceByOfficeCondVOs.length];
			System.arraycopy(bankBalanceByOfficeCondVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bankBalanceByOfficeCondVOs = tmpVOs;
		}
	}

	public BankBalanceAdjustmentListVO getBankBalanceAdjustmentListVO() {
		return bankBalanceAdjustmentListVO;
	}
	
	public void setBankBalanceAdjustmentListVO(	BankBalanceAdjustmentListVO bankBalanceAdjustmentListVO) {
		this.bankBalanceAdjustmentListVO = bankBalanceAdjustmentListVO;
	}
	
	public BankBalanceAdjustmentListVO[] getBankBalanceAdjustmentListVOs() {
		BankBalanceAdjustmentListVO[] rtnVOs = null;
		if(this.bankBalanceAdjustmentListVOs != null) {
			rtnVOs = new BankBalanceAdjustmentListVO[bankBalanceAdjustmentListVOs.length];
			System.arraycopy(bankBalanceAdjustmentListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setBankBalanceAdjustmentListVOs(BankBalanceAdjustmentListVO[] bankBalanceAdjustmentListVOs) {
		if(bankBalanceAdjustmentListVOs != null) {
			BankBalanceAdjustmentListVO[] tmpVOs = new BankBalanceAdjustmentListVO[bankBalanceAdjustmentListVOs.length];
			System.arraycopy(bankBalanceAdjustmentListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bankBalanceAdjustmentListVOs = tmpVOs;
		}
	}

	public BankAccountAdjustmentListVO getBankAccountAdjustmentListVO() {
		return bankAccountAdjustmentListVO;
	}
	
	public void setBankAccountAdjustmentListVO(BankAccountAdjustmentListVO bankAccountAdjustmentListVO) {
		this.bankAccountAdjustmentListVO = bankAccountAdjustmentListVO;
	}
	
	public BankAccountAdjustmentListVO[] getBankAccountAdjustmentListVOs() {
		BankAccountAdjustmentListVO[] rtnVOs = null;
		if(this.bankAccountAdjustmentListVOs != null) {
			rtnVOs = new BankAccountAdjustmentListVO[bankAccountAdjustmentListVOs.length];
			System.arraycopy(bankAccountAdjustmentListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setBankAccountAdjustmentListVOs(BankAccountAdjustmentListVO[] bankAccountAdjustmentListVOs) {
		if(bankAccountAdjustmentListVOs != null) {
			BankAccountAdjustmentListVO[] tmpVOs = new BankAccountAdjustmentListVO[bankAccountAdjustmentListVOs.length];
			System.arraycopy(bankAccountAdjustmentListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bankAccountAdjustmentListVOs = tmpVOs;
		}
	}

}