/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0110Event.java
*@FileTitle : (DXBBB) INV B/L List
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.19
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.10.30 최우석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.GeneralInvoiceVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0110 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0110HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Woo-Seok
 * @see FNS_INV_0110HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0110Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private GeneralInvoiceVO generalInvoiceVO = null;
	
	public FnsInv0110Event(){}
	
	public void setGeneralInvoiceVO(GeneralInvoiceVO generalInvoiceVO){
		this. generalInvoiceVO = generalInvoiceVO;
	}
	
	public GeneralInvoiceVO getGeneralInvoiceVO(){
		return generalInvoiceVO;
	}
}