/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0059Event.java
*@FileTitle : e-mail / Auto FAX Invoice Sent Result
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.05.04 김세일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.FaxEmailSentDateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.FaxEmailSentResultVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0059 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0059HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author saeil kim
 * @see FNS_INV_0059HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0059Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private FaxEmailSentDateVO faxEmailSentDateVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private FaxEmailSentResultVO[] faxEmailSentResultVOs = null;

	public FnsInv0059Event(){}

	public FaxEmailSentDateVO getFaxEmailSentDateVO() {
		return faxEmailSentDateVO;
	}

	public void setFaxEmailSentDateVO(FaxEmailSentDateVO faxEmailSentDateVO) {
		this.faxEmailSentDateVO = faxEmailSentDateVO;
	}

	public FaxEmailSentResultVO[] getFaxEmailSentResultVOs() {
		return faxEmailSentResultVOs;
	}

	public void setFaxEmailSentResultVOs(FaxEmailSentResultVO[] faxEmailSentResultVOs) {
		this.faxEmailSentResultVOs = faxEmailSentResultVOs;
	}
}