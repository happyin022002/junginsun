/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt4002Event.java
*@FileTitle : Invoice Creation & Issue - Booking
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.08.05 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event;

import java.util.List;

import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ExchangeRateParmVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ChargeBookingInvoiceVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.FAXEmailByPayerVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueMgtVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.IssuedInvoiceParamVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_DMT_4002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_4002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Tae Kyun
 * @see EES_DMT_4002HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt4002Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private IssuedInvoiceParamVO issuedInvoiceParamVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private IssuedInvoiceParamVO[] issuedInvoiceParamVOs = null;
	
	private ChargeBookingInvoiceVO chargeBookingInvoiceVO = null;
	
	private List<InvoiceIssueVO> invoiceIssueVOList = null;
	
	private InvoiceIssueVO[] invoiceIssueVOs = null;
	
	private InvoiceIssueMgtVO invoiceIssueMgtVO = null;
	
	private ExchangeRateParmVO exchangeRateParamVO = null;
	
	private FAXEmailByPayerVO fAXEmailByPayerVO = null;
	
	public EesDmt4002Event(){}
	
	public void setIssuedInvoiceParamVO(IssuedInvoiceParamVO issuedInvoiceParamVO){
		this. issuedInvoiceParamVO = issuedInvoiceParamVO;
	}

	public void setIssuedInvoiceParamVOS(IssuedInvoiceParamVO[] issuedInvoiceParamVOs){
		if (issuedInvoiceParamVOs != null) {
			IssuedInvoiceParamVO[] tmpVOs = new IssuedInvoiceParamVO[issuedInvoiceParamVOs.length];
			System.arraycopy(issuedInvoiceParamVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.issuedInvoiceParamVOs = tmpVOs;
		}
	}
	
	public void setInvoiceIssueMgtVO(InvoiceIssueMgtVO invoiceIssueMgtVO){
		this.invoiceIssueMgtVO = invoiceIssueMgtVO;
	}
	
	public void setChargeBookingInvoiceVO(ChargeBookingInvoiceVO chargeBookingInvoiceVO) {
		this.chargeBookingInvoiceVO = chargeBookingInvoiceVO;
	}

	public void setInvoiceIssueVOList(List<InvoiceIssueVO> invoiceIssueVOList) {
		this.invoiceIssueVOList = invoiceIssueVOList;
	}

	public void setInvoiceIssueVOs(InvoiceIssueVO[] invoiceIssueVOs) {
		if (invoiceIssueVOs != null) {
			InvoiceIssueVO[] tmpVOs = new InvoiceIssueVO[invoiceIssueVOs.length];
			System.arraycopy(invoiceIssueVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.invoiceIssueVOs = tmpVOs;
		}
	}
	
	public void setExchangeRateParamVO(ExchangeRateParmVO exchangeRateParamVO) {
		this.exchangeRateParamVO = exchangeRateParamVO;
	}
	
	public void setfAXEmailByPayerVO(FAXEmailByPayerVO fAXEmailByPayerVO) {
		this.fAXEmailByPayerVO = fAXEmailByPayerVO;
	}
	
	public IssuedInvoiceParamVO getIssuedInvoiceParamVO(){
		return issuedInvoiceParamVO;
	}

	public IssuedInvoiceParamVO[] getIssuedInvoiceParamVOS(){
		IssuedInvoiceParamVO[] tmpVOs = null;
		if (this.issuedInvoiceParamVOs != null) {
			tmpVOs = new IssuedInvoiceParamVO[issuedInvoiceParamVOs.length];
			System.arraycopy(issuedInvoiceParamVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public InvoiceIssueMgtVO getInvoiceIssueMgtVO(){
		return invoiceIssueMgtVO;
	}

	public ChargeBookingInvoiceVO getChargeBookingInvoiceVO() {
		return chargeBookingInvoiceVO;
	}

	public List<InvoiceIssueVO> getInvoiceIssueVOList() {
		return invoiceIssueVOList;
	}

	public InvoiceIssueVO[] getInvoiceIssueVOs() {
		InvoiceIssueVO[] tmpVOs = null;
		if (this.invoiceIssueVOs != null) {
			tmpVOs = new InvoiceIssueVO[invoiceIssueVOs.length];
			System.arraycopy(invoiceIssueVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public ExchangeRateParmVO getExchangeRateParamVO() {
		return exchangeRateParamVO;
	}
	
	public FAXEmailByPayerVO getFAXEmailByPayerVO() {
		return fAXEmailByPayerVO;
	}


}