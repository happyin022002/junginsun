/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0088Event.java
*@FileTitle : (Vietnam)Multi B/L List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.30
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.10.30 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.GeneralInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.VIECombineInvoiceVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0088 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0088HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Woo-Seok
 * @see FNS_INV_0088HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0088Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private GeneralInvoiceVO generalInvoiceVO = null;
	
	private  VIECombineInvoiceVO  vIECombineInvoiceVO = null;
	
	private  VIECombineInvoiceVO[]  vIECombineInvoiceVOs = null;
	
	public FnsInv0088Event(){}
	
	public void setGeneralInvoiceVO(GeneralInvoiceVO generalInvoiceVO){
		this. generalInvoiceVO = generalInvoiceVO;
	}
	
	public GeneralInvoiceVO getGeneralInvoiceVO(){
		return generalInvoiceVO;
	}
	
	public VIECombineInvoiceVO getVIECombineInvoiceVO(){
		return vIECombineInvoiceVO;
	}
	
	public void setVIECombineInvoiceVO(VIECombineInvoiceVO vIECombineInvoiceVO){
		this. vIECombineInvoiceVO = vIECombineInvoiceVO;
	}

	public VIECombineInvoiceVO[] getVIECombineInvoiceVOS(){
		return vIECombineInvoiceVOs;
	}

	public void setVIECombineInvoiceVOS(VIECombineInvoiceVO[] vIECombineInvoiceVOs){
		this. vIECombineInvoiceVOs = vIECombineInvoiceVOs;
	}
}