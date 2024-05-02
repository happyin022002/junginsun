/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0010Event.java
*@FileTitle : Invoice Inquiry by B/L No (History Pop-up)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.06.11 박정진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceByBLNoVO;


/**
 * FNS_INV_0010 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0010HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Jin Park
 * @see FNS_INV_0010HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0010Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ARInvoiceByBLNoVO aRInvoiceByBLNoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ARInvoiceByBLNoVO[] aRInvoiceByBLNoVOs = null;

	public FnsInv0010Event(){}
	
	public void setARInvoiceByBLNoVO(ARInvoiceByBLNoVO aRInvoiceByBLNoVO){
		this. aRInvoiceByBLNoVO = aRInvoiceByBLNoVO;
	}

	public void setARInvoiceByBLNoVOS(ARInvoiceByBLNoVO[] aRInvoiceByBLNoVOs){
		this. aRInvoiceByBLNoVOs = aRInvoiceByBLNoVOs;
	}

	public ARInvoiceByBLNoVO getARInvoiceByBLNoVO(){
		return aRInvoiceByBLNoVO;
	}

	public ARInvoiceByBLNoVO[] getARInvoiceByBLNoVOS(){
		return aRInvoiceByBLNoVOs;
	}

}