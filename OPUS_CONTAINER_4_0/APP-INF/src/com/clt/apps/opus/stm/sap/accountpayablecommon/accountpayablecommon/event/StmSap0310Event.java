/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : StmSap0310Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* Created by Hannah Lee
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event;

import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.CreditCardMasterListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountPayableCommonSC로 실행요청<br>
 * - AccountPayableCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author hannah lee
 * @see 
 * @since J2EE 1.4
 */

public class StmSap0310Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object Search Parameter VO*/
	private String crdSeq = "";
	private String crdNo  = "";
	
	private CreditCardMasterListVO creditCardMasterListVO = null;
	private CreditCardMasterListVO[] creditCardMasterListVOs = null;
	
	public StmSap0310Event() {}
	
	public String getCrdSeq() {
		return crdSeq;
	}

	public void setCrdSeq(String crdSeq) {
		this.crdSeq = crdSeq;
	}

	public String getCrdNo() {
		return crdNo;
	}

	public void setCrdNo(String crdNo) {
		this.crdNo = crdNo;
	}

	public CreditCardMasterListVO getCreditCardMasterListVO() {
		return creditCardMasterListVO;
	}

	public void setCreditCardMasterListVO(
			CreditCardMasterListVO creditCardMasterListVO) {
		this.creditCardMasterListVO = creditCardMasterListVO;
	}

	public CreditCardMasterListVO[] getCreditCardMasterListVOs() {
		CreditCardMasterListVO[] rtnVOs = null;
		if(this.creditCardMasterListVOs != null) {
			rtnVOs = new CreditCardMasterListVO[creditCardMasterListVOs.length];
			System.arraycopy(creditCardMasterListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;

	}

	public void setCreditCardMasterListVOs(	CreditCardMasterListVO[] creditCardMasterListVOs) {
		if(creditCardMasterListVOs != null) {
			CreditCardMasterListVO[] tmpVOs = new CreditCardMasterListVO[creditCardMasterListVOs.length];
			System.arraycopy(creditCardMasterListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.creditCardMasterListVOs = tmpVOs;
		}

	}

}