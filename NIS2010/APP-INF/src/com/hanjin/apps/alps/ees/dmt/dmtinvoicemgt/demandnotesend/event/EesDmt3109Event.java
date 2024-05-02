/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt4002Event.java
*@FileTitle : Demand Note Issue  - Booking
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.09.25 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.event;

import java.util.List;

import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ExchangeRateParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNoteByBookingVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNoteParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ChargeBookingInvoiceVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_DMT_3109 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_3109HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI SUNG HWAN
 * @see EES_DMT_3109HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt3109Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DemandNoteParmVO demandNoteParmVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DemandNoteParmVO[] demandNoteParmVOs = null;
	
	private ChargeBookingInvoiceVO chargeBookingInvoiceVO = null;
	
	private List<InvoiceIssueVO> invoiceIssueVOList = null;
	
	private InvoiceIssueVO[] invoiceIssueVOs = null;
	
	private DemandNoteByBookingVO demandNoteByBookingVO = null;
	
	private ExchangeRateParmVO exchangeRateParamVO = null;
	
	public EesDmt3109Event(){}
	
	public void setDemandNoteParmVO(DemandNoteParmVO demandNoteParmVO){
		this. demandNoteParmVO = demandNoteParmVO;
	}

	public void setDemandNoteParmVOS(DemandNoteParmVO[] demandNoteParmVOs){
		this. demandNoteParmVOs = demandNoteParmVOs;
	}
	
	public void setDemandNoteByBookingVO(DemandNoteByBookingVO demandNoteByBookingVO){
		this.demandNoteByBookingVO = demandNoteByBookingVO;
	}
	
	public void setChargeBookingInvoiceVO(ChargeBookingInvoiceVO chargeBookingInvoiceVO) {
		this.chargeBookingInvoiceVO = chargeBookingInvoiceVO;
	}

	public void setInvoiceIssueVOList(List<InvoiceIssueVO> invoiceIssueVOList) {
		this.invoiceIssueVOList = invoiceIssueVOList;
	}

	public void setInvoiceIssueVOs(InvoiceIssueVO[] invoiceIssueVOs) {
		this.invoiceIssueVOs = invoiceIssueVOs;
	}
	
	public void setExchangeRateParamVO(ExchangeRateParmVO exchangeRateParamVO) {
		this.exchangeRateParamVO = exchangeRateParamVO;
	}

	public DemandNoteParmVO getDemandNoteParmVO(){
		return demandNoteParmVO;
	}

	public DemandNoteParmVO[] getDemandNoteParmVOS(){
		return demandNoteParmVOs;
	}
	
	public DemandNoteByBookingVO getDemandNoteByBookingVO(){
		return demandNoteByBookingVO;
	}

	public ChargeBookingInvoiceVO getChargeBookingInvoiceVO() {
		return chargeBookingInvoiceVO;
	}

	public List<InvoiceIssueVO> getInvoiceIssueVOList() {
		return invoiceIssueVOList;
	}

	public InvoiceIssueVO[] getInvoiceIssueVOs() {
		return invoiceIssueVOs;
	}

	public ExchangeRateParmVO getExchangeRateParamVO() {
		return exchangeRateParamVO;
	}
	
	


}