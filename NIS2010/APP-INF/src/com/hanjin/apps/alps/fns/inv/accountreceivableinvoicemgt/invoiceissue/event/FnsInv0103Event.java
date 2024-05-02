/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0103Event.java
*@FileTitle : CPR Download History Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.08.18 한동훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.CPRTListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.CPRTMainVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0103 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0103HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Dong Hoon
 * @see FNS_INV_0103HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0103Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CPRTMainVO cPRTMainVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CPRTMainVO[] cPRTMainVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CPRTListVO[] cPRTListVOs = null;
	
	private CPRTListVO cPRTListVO = null;
	
	private String custRptId = null;

	public FnsInv0103Event(){}
	
	public void setCPRTMainVO(CPRTMainVO cPRTMainVO){
		this. cPRTMainVO = cPRTMainVO;
	}

	public void setCPRTMainVOS(CPRTMainVO[] cPRTMainVOs){
		this. cPRTMainVOs = cPRTMainVOs;
	}

	public CPRTMainVO getCPRTMainVO(){
		return cPRTMainVO;
	}

	public CPRTMainVO[] getCPRTMainVOS(){
		return cPRTMainVOs;
	}

	public CPRTListVO[] getCPRTListVOs() {
		return cPRTListVOs;
	}

	public void setCPRTListVOs(CPRTListVO[] listVOs) {
		cPRTListVOs = listVOs;
	}

	public CPRTListVO getCPRTListVO() {
		return cPRTListVO;
	}

	public void setCPRTListVO(CPRTListVO listVO) {
		cPRTListVO = listVO;
	}

	public String getCustRptId() {
		return custRptId;
	}

	public void setCustRptId(String custRptId) {
		this.custRptId = custRptId;
	}


	
}