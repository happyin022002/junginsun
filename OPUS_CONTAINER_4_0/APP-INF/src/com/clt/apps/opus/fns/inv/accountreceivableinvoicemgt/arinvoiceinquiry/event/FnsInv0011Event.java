/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0011Event.java
*@FileTitle : Invoice Inquiry by I/F No
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.06.16 박정진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceCorrectionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0011 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0011HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Jin Park
 * @see FNS_INV_0011HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0011Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	/* Column Info */
	private String ifNo = null;
	/* Column Info */
	private String office = null;

	
	/** Table Value Object Multi Data 처리 */
	private ARInvoiceCorrectionVO[] aRInvoiceByBLNoVOs = null;

	public FnsInv0011Event(){}

	public void setARInvoiceByBLNoVOS(ARInvoiceCorrectionVO[] aRInvoiceByBLNoVOs){
		if(aRInvoiceByBLNoVOs != null){
			ARInvoiceCorrectionVO[] tmpVOs = new ARInvoiceCorrectionVO[aRInvoiceByBLNoVOs.length];
			System.arraycopy(aRInvoiceByBLNoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.aRInvoiceByBLNoVOs = tmpVOs;
		}
	}

	public ARInvoiceCorrectionVO[] getARInvoiceByBLNoVOS(){
		ARInvoiceCorrectionVO[] rtnVOs = null;
		if (this.aRInvoiceByBLNoVOs != null) {
			rtnVOs = new ARInvoiceCorrectionVO[aRInvoiceByBLNoVOs.length];
			System.arraycopy(aRInvoiceByBLNoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public String getIfNo() {
		return ifNo;
	}

	public void setIfNo(String ifNo) {
		this.ifNo = ifNo;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

}