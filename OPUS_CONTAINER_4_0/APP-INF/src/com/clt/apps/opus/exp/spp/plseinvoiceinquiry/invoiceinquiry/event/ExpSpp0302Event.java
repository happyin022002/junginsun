/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExpSpp0302Event.java
*@FileTitle : Rental payable invoice inquiry by Lessee via SPP
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 김성광
*@LastVersion : 1.0
* 2009.08.18 김성광
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.exp.spp.plseinvoiceinquiry.invoiceinquiry.event;

import com.clt.apps.opus.ees.lse.containercostanalysis.onoffhireaudit.vo.OnOffHireAuditDetailVO;
import com.clt.apps.opus.ees.lse.containercostanalysis.onoffhireaudit.vo.OnOffHireAuditSearchVO;
import com.clt.apps.opus.exp.spp.plseinvoiceinquiry.invoiceinquiry.vo.PayableInvoiceDataVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EXP_SPP_0302 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EXP_SPP_0302HTMLAction 에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Seong Kwang
 * @see EXP_SPP_0302HTMLAction 참조
 * @since J2EE 1.6 
 */

public class ExpSpp0302Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PayableInvoiceDataVO payableInvoiceDataVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PayableInvoiceDataVO[] payableInvoiceDataVOs = null;		
	
	public ExpSpp0302Event(){}
	
	public void setPayableInvoiceDataVO(PayableInvoiceDataVO payableInvoiceDataVO){
		this. payableInvoiceDataVO = payableInvoiceDataVO;
	}

	public void setPayableInvoiceDataVOS(PayableInvoiceDataVO[] payableInvoiceDataVOs){
		if (payableInvoiceDataVOs != null) {
			PayableInvoiceDataVO[] tmpVOs = new PayableInvoiceDataVO[payableInvoiceDataVOs.length];
			System.arraycopy(payableInvoiceDataVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.payableInvoiceDataVOs = tmpVOs;
		}		
	}	

	public PayableInvoiceDataVO getPayableInvoiceDataVO(){
		return payableInvoiceDataVO;
	}

	public PayableInvoiceDataVO[] getPayableInvoiceDataVOS(){
		PayableInvoiceDataVO[] tmpVOs = null;
		if (this.payableInvoiceDataVOs != null) {
			tmpVOs = new PayableInvoiceDataVO[payableInvoiceDataVOs.length];
			System.arraycopy(payableInvoiceDataVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}

}