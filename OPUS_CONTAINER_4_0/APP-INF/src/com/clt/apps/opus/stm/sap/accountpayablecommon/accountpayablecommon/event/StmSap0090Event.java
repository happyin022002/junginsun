/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StmSap0090Event.java
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


import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.BankAccountListVO;
import com.clt.framework.support.layer.event.EventSupport;



/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceMasterDataMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Han Dong Hoon
 * @see AccountReceivableInvoiceMasterDataMgtEvent 참조
 * @since J2EE 1.4
 */

public class StmSap0090Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private BankAccountListVO bankAccountListVO;
	private BankAccountListVO[] bankAccountListVOs;
	
	public BankAccountListVO getBankAccountListVO() {
		return bankAccountListVO;
	}
	public void setBankAccountListVO(BankAccountListVO bankAccountListVO) {
		this.bankAccountListVO = bankAccountListVO;
	}
	public BankAccountListVO[] getBankAccountListVOs() {
		BankAccountListVO[] rtnVOs = null;
		if(this.bankAccountListVOs != null) {
			rtnVOs = new BankAccountListVO[bankAccountListVOs.length];
			System.arraycopy(bankAccountListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;

	}
	public void setBankAccountListVOs(BankAccountListVO[] bankAccountListVOs) {
		if(bankAccountListVOs != null) {
			BankAccountListVO[] tmpVOs = new BankAccountListVO[bankAccountListVOs.length];
			System.arraycopy(bankAccountListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bankAccountListVOs = tmpVOs;
		}

	}
	
}