/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : StmSap0080Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.30
*@LastModifier : sangyoung cha
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event;

import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.BankBranchVO;
import com.clt.framework.support.layer.event.EventSupport;



/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceMasterDataMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Han Dong Hoon
 * @see AccountReceivableInvoiceMasterDataMgtEvent 참조
 * @since J2EE 1.4
 */

public class StmSap0081Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private BankBranchVO bankBranchVO;
	private BankBranchVO[] bankBranchVOs;
	
	public BankBranchVO getBankBranchVO() {
		return bankBranchVO;
	}
	public void setBankBranchVO(BankBranchVO bankBranchVO) {
		this.bankBranchVO = bankBranchVO;
	}
	public BankBranchVO[] getBankBranchVOs() {
		BankBranchVO[] rtnVOs = null;
		if(this.bankBranchVOs != null) {
			rtnVOs = new BankBranchVO[bankBranchVOs.length];
			System.arraycopy(bankBranchVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	public void setBankBranchVOs(BankBranchVO[] bankBranchVOs) {
		if(bankBranchVOs != null) {
			BankBranchVO[] tmpVOs = new BankBranchVO[bankBranchVOs.length];
			System.arraycopy(bankBranchVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bankBranchVOs = tmpVOs;
		}

	}
}