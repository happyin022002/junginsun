/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0076Event.java
*@FileTitle : Revenue Account Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.05.11 정휘택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.InvRevAcctCdVO;


/**
 * FNS_INV_0076 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0076HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Hwi Taek
 * @see FNS_INV_0076HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0076Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvRevAcctCdVO invRevAcctCdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvRevAcctCdVO[] invRevAcctCdVOs = null;

	public FnsInv0076Event(){}
	
	public void setInvRevAcctCdVO(InvRevAcctCdVO invRevAcctCdVO){
		this. invRevAcctCdVO = invRevAcctCdVO;
	}

	public void setInvRevAcctCdVOS(InvRevAcctCdVO[] invRevAcctCdVOs){
		if (invRevAcctCdVOs != null) {
			InvRevAcctCdVO[] tmpVOs = new InvRevAcctCdVO[invRevAcctCdVOs.length];
			System.arraycopy(invRevAcctCdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.invRevAcctCdVOs = tmpVOs;
		}
	}

	public InvRevAcctCdVO getInvRevAcctCdVO(){
		return invRevAcctCdVO;
	}

	public InvRevAcctCdVO[] getInvRevAcctCdVOS(){
		InvRevAcctCdVO[] rtnVOs = null;
		if (this.invRevAcctCdVOs != null) {
			rtnVOs = new InvRevAcctCdVO[invRevAcctCdVOs.length];
			System.arraycopy(invRevAcctCdVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}