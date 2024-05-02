/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0082Event.java
*@FileTitle : (Brazil) Agent Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.11
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.12.11 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.InvSubAgnCustCdVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0082 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0082HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author saeil kim
 * @see FNS_INV_0082HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0082Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvSubAgnCustCdVO invSubAgnCustCdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvSubAgnCustCdVO[] invSubAgnCustCdVOs = null;

	private String arOfcCd = null;

	public FnsInv0082Event(){}
	
	public void setInvSubAgnCustCdVO(InvSubAgnCustCdVO invSubAgnCustCdVO){
		this. invSubAgnCustCdVO = invSubAgnCustCdVO;
	}

	public InvSubAgnCustCdVO getInvSubAgnCustCdVO(){
		return invSubAgnCustCdVO;
	}

	public void setInvSubAgnCustCdVOS(InvSubAgnCustCdVO[] invSubAgnCustCdVOs){
		this. invSubAgnCustCdVOs = invSubAgnCustCdVOs;
	}
	
	public InvSubAgnCustCdVO[] getInvSubAgnCustCdVOS(){
		return invSubAgnCustCdVOs;
	}

	public String getArOfcCd() {
		return arOfcCd;
	}

	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}

	
	
}