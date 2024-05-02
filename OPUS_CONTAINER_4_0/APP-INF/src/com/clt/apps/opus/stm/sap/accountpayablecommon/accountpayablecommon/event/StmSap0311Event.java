/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : StmSap0311Event.java
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

import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.CreditCardListVO;
import com.clt.framework.support.layer.event.EventSupport;



/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceMasterDataMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Han Dong Hoon
 * @see AccountReceivableInvoiceMasterDataMgtEvent 참조
 * @since J2EE 1.4
 */

public class StmSap0311Event extends EventSupport {

	private static final long  serialVersionUID = 1L;
	
	private CreditCardListVO   creditCardlistVO;
	private CreditCardListVO[] creditCardlistVOs;
	
	public CreditCardListVO getCreditCardlistVO() {
		return creditCardlistVO;
	}
	public void setCreditCardlistVO(CreditCardListVO creditCardlistVO) {
		this.creditCardlistVO = creditCardlistVO;
	}
	
	public CreditCardListVO[] getCreditCardlistVOs() {
		CreditCardListVO[] rtnVOs = null;
		if(this.creditCardlistVOs != null) {
			rtnVOs = new CreditCardListVO[creditCardlistVOs.length];
			System.arraycopy(creditCardlistVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;

	}
	public void setCreditCardlistVOs(CreditCardListVO[] creditCardlistVOs) {
		if(creditCardlistVOs != null) {
			CreditCardListVO[] tmpVOs = new CreditCardListVO[creditCardlistVOs.length];
			System.arraycopy(creditCardlistVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.creditCardlistVOs = tmpVOs;
		}

	}
}