/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FnsJoo0079Event.java
*@FileTitle : Authority Office Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.15
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.01.15 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.event;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.vo.ConsultationConditionVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.vo.InvoiceDetailVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.vo.InvoiceVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * FNS_JOO_0079 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0088HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see FNS_JOO_0101HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0107Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ConsultationConditionVO consultationConditionVO = null;
	
	private InvoiceVO invoiceVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvoiceVO[] invoiceVOs = null;	

	private InvoiceDetailVO invoiceDetailVO = null;

	private InvoiceDetailVO[] invoiceDetailVOs = null;


	public FnsJoo0107Event(){}
	
	public void setConsultationConditionVO(ConsultationConditionVO consultationConditionVO){
		this.consultationConditionVO = consultationConditionVO;
	}
	
	public void setInvoiceVO(InvoiceVO invoiceVO){
		this.invoiceVO = invoiceVO;
	}
	
	public void setInvoiceDetailVO(InvoiceDetailVO invoiceDetailVO){
		this.invoiceDetailVO = invoiceDetailVO;
	}

	public void setInvoiceVOS(InvoiceVO[] invoiceVOs){
		if (invoiceVOs != null) {
			InvoiceVO[] tmpVOs = new InvoiceVO[invoiceVOs.length];
			System.arraycopy(invoiceVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.invoiceVOs = tmpVOs;
		}
	}

	public void setInvoiceDetailVOS(InvoiceDetailVO[] invoiceDetailVOs){
		if (invoiceDetailVOs != null) {
			InvoiceDetailVO[] tmpVOs = new InvoiceDetailVO[invoiceDetailVOs.length];
			System.arraycopy(invoiceDetailVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.invoiceDetailVOs = tmpVOs;
		}
	}

	public ConsultationConditionVO getConsultationConditionVO(){
		return consultationConditionVO;
	}

	public InvoiceVO getInvoiceVO(){
		return invoiceVO;
	}

	public InvoiceDetailVO getInvoiceDetailVO(){
		return invoiceDetailVO;
	}
	
	public InvoiceVO[] getInvoiceVOS(){
		InvoiceVO[] tmpVOs = null;
		if (this.invoiceVOs != null) {
			tmpVOs = new InvoiceVO[invoiceVOs.length];
			System.arraycopy(invoiceVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public InvoiceDetailVO[] getInvoiceDetailVOS(){
		InvoiceDetailVO[] tmpVOs = null;
		if (this.invoiceDetailVOs != null) {
			tmpVOs = new InvoiceDetailVO[invoiceDetailVOs.length];
			System.arraycopy(invoiceDetailVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}