/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StmSap0110Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event;

import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.BankAccountSupplierListVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceMasterDataMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Han Dong Hoon
 * @see AccountReceivableInvoiceMasterDataMgtEvent 참조
 * @since J2EE 1.4
 */

public class StmSap0110Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건  */
	private String schBankAcctNo  = "";
	private String bankAcctSeq  = "";
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BankAccountSupplierListVO bankAccountSupplierListVO = null;
	/** Table Value Object Multi Data 처리 */
	private BankAccountSupplierListVO[] bankAccountSupplierListVOs = null;
	
	public String getSchBankAcctNo() {
		return schBankAcctNo;
	}
	public void setSchBankAcctNo(String schBankAcctNo) {
		this.schBankAcctNo = schBankAcctNo;
	}
	public String getBankAcctSeq() {
		return bankAcctSeq;
	}
	public void setBankAcctSeq(String bankAcctSeq) {
		this.bankAcctSeq = bankAcctSeq;
	}
	public BankAccountSupplierListVO getBankAccountSupplierListVO() {
		return bankAccountSupplierListVO;
	}
	public void setBankAccountSupplierListVO(
			BankAccountSupplierListVO bankAccountSupplierListVO) {
		this.bankAccountSupplierListVO = bankAccountSupplierListVO;
	}
	public BankAccountSupplierListVO[] getBankAccountSupplierListVOs() {
		BankAccountSupplierListVO[] rtnVOs = null;
		if(this.bankAccountSupplierListVOs != null) {
			rtnVOs = new BankAccountSupplierListVO[bankAccountSupplierListVOs.length];
			System.arraycopy(bankAccountSupplierListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	public void setBankAccountSupplierListVOs( BankAccountSupplierListVO[] bankAccountSupplierListVOs) {
		if(bankAccountSupplierListVOs != null) {
			BankAccountSupplierListVO[] tmpVOs = new BankAccountSupplierListVO[bankAccountSupplierListVOs.length];
			System.arraycopy(bankAccountSupplierListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bankAccountSupplierListVOs = tmpVOs;
		}

	}


}