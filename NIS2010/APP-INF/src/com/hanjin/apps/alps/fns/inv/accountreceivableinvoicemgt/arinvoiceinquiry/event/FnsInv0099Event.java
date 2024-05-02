/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0099Event.java
*@FileTitle : Invoice Inquiry by IF No (Charge Remark Popup)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.05.04 김세일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceCorrectionVO;


/**
 * FNS_INV_0099 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0099HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author saeil kim
 * @see FNS_INV_0099HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0099Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ARInvoiceCorrectionVO aRInvoiceCorrectionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ARInvoiceCorrectionVO[] aRInvoiceCorrectionVOs = null;

	public FnsInv0099Event(){}
	
	public void setARInvoiceCorrectionVO(ARInvoiceCorrectionVO aRInvoiceCorrectionVO){
		this. aRInvoiceCorrectionVO = aRInvoiceCorrectionVO;
	}

	public void setARInvoiceCorrectionVOS(ARInvoiceCorrectionVO[] aRInvoiceCorrectionVOs){
		this. aRInvoiceCorrectionVOs = aRInvoiceCorrectionVOs;
	}

	public ARInvoiceCorrectionVO getARInvoiceCorrectionVO(){
		return aRInvoiceCorrectionVO;
	}

	public ARInvoiceCorrectionVO[] getARInvoiceCorrectionVOS(){
		return aRInvoiceCorrectionVOs;
	}

}