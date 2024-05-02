/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0053Event.java
*@FileTitle : Invoice Issue Inquiry by Invoice No
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.05.27 박정진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceByBLNoVO;


/**
 * fns_inv_0053 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  fns_inv_0053HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Jin Park
 * @see fns_inv_0053HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0053Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String ofc = null;
	
	/** Table Value Object Multi Data 처리 */
	private ARInvoiceByBLNoVO[] aRInvoiceByBLNoVOs = null;

	public FnsInv0053Event(){}
	
	public void setARInvoiceByBLNoVOS(ARInvoiceByBLNoVO[] aRInvoiceByBLNoVOs){
		this. aRInvoiceByBLNoVOs = aRInvoiceByBLNoVOs;
	}

	public ARInvoiceByBLNoVO[] getARInvoiceByBLNoVOS(){
		return aRInvoiceByBLNoVOs;
	}

	public String getInvNo() {
		return invNo;
	}

	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}

	public String getOfc() {
		return ofc;
	}

	public void setOfc(String ofc) {
		this.ofc = ofc;
	}

}