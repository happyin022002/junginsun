/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt4003Event.java
*@FileTitle : Invoice Issue Preview
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.08.05 김태균
* 1.0 Creation
* 2011.11.14 권   민[CHM-201114143] [DMT] Manual Invoice with no detail 조건의 Print Preview 개발 
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event;


import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueRDParamVO;


/**
 * EES_DMT_4003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_4003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Tae Kyun
 * @see EES_DMT_4003HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt4003Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvoiceIssueRDParamVO invoiceIssueRDParamVO = null;
	
	private String incCntrDtail	= "";
	
	public EesDmt4003Event(){}
	
	public void setInvoiceIssueRDParamVO(InvoiceIssueRDParamVO invoiceIssueRDParamVO){
		this.invoiceIssueRDParamVO = invoiceIssueRDParamVO;
	}

	public InvoiceIssueRDParamVO getInvoiceIssueRDParamVO(){
		return invoiceIssueRDParamVO;
	}

	public String getIncCntrDtail() {
		return incCntrDtail;
	}

	public void setIncCntrDtail(String incCntrDtail) {
		this.incCntrDtail = incCntrDtail;
	}
	
	
}