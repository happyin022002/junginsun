/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0114Event.java
*@FileTitle : Bank Code Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 이석준
*@LastVersion : 1.0
* 2010.11.21 이석준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvArBankListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.InvEdiIntgCdDtlVO;
import com.hanjin.syscommon.common.table.InvEdiIntgCdVO;

/**
 * FNS_INV_0114 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0114HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Suk Joon LEE
 * @see FNS_INV_0114HTMLAction 참조
 * @since J2EE 1.4
 */
 
public class FnsInv0114Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvEdiIntgCdVO invEdiIntgCdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvEdiIntgCdDtlVO[] invEdiIntgCdDtlVOs = null;

	
	public FnsInv0114Event(){}


	public InvEdiIntgCdVO getInvEdiIntgCdVO() {
		return invEdiIntgCdVO;
	}


	public void setInvEdiIntgCdVO(InvEdiIntgCdVO invEdiIntgCdVO) {
		this.invEdiIntgCdVO = invEdiIntgCdVO;
	}


	public InvEdiIntgCdDtlVO[] getInvEdiIntgCdDtlVOs() {
		return invEdiIntgCdDtlVOs;
	}


	public void setInvEdiIntgCdDtlVOs(InvEdiIntgCdDtlVO[] invEdiIntgCdDtlVOs) {
		this.invEdiIntgCdDtlVOs = invEdiIntgCdDtlVOs;
	}


}