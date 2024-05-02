/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt4008Event.java
*@FileTitle : Issued Invoice Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.10.22 황효근
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event;

import java.util.List;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChrgDtlVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ChargeBookingInvoiceVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.IssuedInvoiceParamVO;


/**
 * EES_DMT_4008 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_4008HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Tae Kyun
 * @see EES_DMT_4008HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt4016Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private IssuedInvoiceParamVO issuedInvoiceParamVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private IssuedInvoiceParamVO[] issuedInvoiceParamVOs = null;
	
	private ChargeBookingInvoiceVO chargeBookingInvoiceVO = null;
	
	private InvoiceIssueVO[] invoiceIssueVOs = null;
	
	private ChrgDtlVO[] chrgDtlVOs = null;
	

	public EesDmt4016Event(){}
	
	public void setIssuedInvoiceParamVO(IssuedInvoiceParamVO issuedInvoiceParamVO){
		this. issuedInvoiceParamVO = issuedInvoiceParamVO;
	}

	public void setIssuedInvoiceParamVOS(IssuedInvoiceParamVO[] issuedInvoiceParamVOs){
		this. issuedInvoiceParamVOs = issuedInvoiceParamVOs;
	}

	public IssuedInvoiceParamVO getIssuedInvoiceParamVO(){
		return issuedInvoiceParamVO;
	}

	public IssuedInvoiceParamVO[] getIssuedInvoiceParamVOS(){
		return issuedInvoiceParamVOs;
	}

	/**
	 * @return the chargeBookingInvoiceVO
	 */
	public ChargeBookingInvoiceVO getChargeBookingInvoiceVO() {
		return chargeBookingInvoiceVO;
	}

	/**
	 * @param chargeBookingInvoiceVO the chargeBookingInvoiceVO to set
	 */
	public void setChargeBookingInvoiceVO(
			ChargeBookingInvoiceVO chargeBookingInvoiceVO) {
		this.chargeBookingInvoiceVO = chargeBookingInvoiceVO;
	}

	/**
	 * @return the invoiceIssueVOs
	 */
	public InvoiceIssueVO[] getInvoiceIssueVOs() {
		return invoiceIssueVOs;
	}

	/**
	 * @param invoiceIssueVOs the invoiceIssueVOs to set
	 */
	public void setInvoiceIssueVOs(InvoiceIssueVO[] invoiceIssueVOs) {
		this.invoiceIssueVOs = invoiceIssueVOs;
	}

	/**
	 * @return the chrgDtlVOs
	 */
	public ChrgDtlVO[] getChrgDtlVOs() {
		return chrgDtlVOs;
	}

	/**
	 * @param chrgDtlVOs the chrgDtlVOs to set
	 */
	public void setChrgDtlVOs(ChrgDtlVO[] chrgDtlVOs) {
		this.chrgDtlVOs = chrgDtlVOs;
	}

}