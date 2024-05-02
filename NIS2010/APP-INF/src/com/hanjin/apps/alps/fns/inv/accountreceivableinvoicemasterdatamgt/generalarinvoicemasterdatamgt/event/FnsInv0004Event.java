/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0004Event.java
*@FileTitle : Bank Code Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.05.06 정휘택
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvArBankListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.InvArBankVO;


/**
 * FNS_INV_0004 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0004HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Hwi Taek
 * @see FNS_INV_0004HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0004Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvArBankListVO invArBankListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvArBankVO[] bAcctVOs = null;

	private String arOfc = "";
	
	private String saleOfc = "";	
	
	public FnsInv0004Event(){}
	
	public void setInvArBankListVO(InvArBankListVO invArBankListVO){
		this. invArBankListVO = invArBankListVO;
	}

	public void setInvArBankVOS(InvArBankVO[] bAcctVOs){
		this. bAcctVOs = bAcctVOs;
	}

	public InvArBankListVO getInvArBankListVO(){
		return invArBankListVO;
	}

	public InvArBankVO[] getInvArBankVOS(){
		return bAcctVOs;
	}
	
	public String getArOfc() {
		return arOfc;
	}

	public void setArOfc(String arOfc) {
		this.arOfc = arOfc;
	}

	public String getSaleOfc() {
		return saleOfc;
	}

	public void setSaleOfc(String saleOfc) {
		this.saleOfc = saleOfc;
	}

}