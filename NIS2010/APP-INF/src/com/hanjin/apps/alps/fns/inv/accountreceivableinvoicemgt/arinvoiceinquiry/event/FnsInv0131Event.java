/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : FnsInv0120Event.java
 *@FileTitle : Other split invioces for BL
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.11.28
 *@LastModifier : Oh-yohan
 *@LastVersion : 1.0
 * 2012.11.28 Oh-yohan
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceByBLNoVO;


/**
 * fns_inv_0131 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  fns_inv_0131HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Jin Park
 * @see fns_inv_0131HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0131Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String ofc = null;
	
	/** Table Value Object Multi Data 처리 */
	private ARInvoiceByBLNoVO[] aRInvoiceByBLNoVOs = null;

	public FnsInv0131Event(){}
	
	public void setARInvoiceByBLNoVOS(ARInvoiceByBLNoVO[] aRInvoiceByBLNoVOs){
		this. aRInvoiceByBLNoVOs = aRInvoiceByBLNoVOs;
	}

	public ARInvoiceByBLNoVO[] getARInvoiceByBLNoVOS(){
		return aRInvoiceByBLNoVOs;
	}

	public String getBlNo() {
		return blNo;
	}

	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	public String getOfc() {
		return ofc;
	}

	public void setOfc(String ofc) {
		this.ofc = ofc;
	}

}