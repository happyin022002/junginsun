/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : FnsInv0136Event.java
*@FileTitle : China Region VAT Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.24
*@LastModifier : 임옥영
*@LastVersion : 1.0
* 2013.09.24 임옥영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ChinaVATInvoiceCreationVO;


/**
 * FNS_INV_0136 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0136HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Okyoung Im
 * @see FNS_INV_0136HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0136Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ChinaVATInvoiceCreationVO chinaVATInvoiceCreationVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ChinaVATInvoiceCreationVO[] chinaVATInvoiceCreationVOs = null;

	public FnsInv0136Event(){}
	
	public void setChinaVATInvoiceCreationVO(ChinaVATInvoiceCreationVO chinaVATInvoiceCreationVO){
		this.chinaVATInvoiceCreationVO = chinaVATInvoiceCreationVO;
	}

	public void setChinaVATInvoiceCreationVOS(ChinaVATInvoiceCreationVO[] chinaVATInvoiceCreationVOs){
		this.chinaVATInvoiceCreationVOs = chinaVATInvoiceCreationVOs;
	}

	public ChinaVATInvoiceCreationVO getChinaVATInvoiceCreationVO(){
		return chinaVATInvoiceCreationVO;
	}

	public ChinaVATInvoiceCreationVO[] getChinaVATInvoiceCreationVOS(){
		return chinaVATInvoiceCreationVOs;
	}
	
}