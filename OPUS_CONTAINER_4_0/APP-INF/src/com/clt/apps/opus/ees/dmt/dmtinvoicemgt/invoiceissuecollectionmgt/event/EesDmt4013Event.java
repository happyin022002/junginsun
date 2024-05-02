/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt4013Event.java
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


import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ChargeBookingInvoiceVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ConfirmChargeListVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceGroupParamVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.IssuedInvoiceParamVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetOptionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_DMT_4013 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_4013HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Tae Kyun
 * @see EES_DMT_4013HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt4013Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SheetOptionVO sheetOptionVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvoiceGroupParamVO invoiceGroupParamVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ConfirmChargeListVO[] confirmChargeListVOs = null;
	
	private IssuedInvoiceParamVO issuedInvoiceParamVO = null;
	
	public EesDmt4013Event(){}
	
	public void setSheetOptionVO(SheetOptionVO sheetOptionVO){
		this. sheetOptionVO = sheetOptionVO;
	}

	public SheetOptionVO getSheetOptionVO(){
		return sheetOptionVO;
	}
	
	public void setInvoiceGroupParamVO(InvoiceGroupParamVO invoiceGroupParamVO){
		this.invoiceGroupParamVO = invoiceGroupParamVO;
	}
	
	public InvoiceGroupParamVO getInvoiceGroupParamVO(){
		return invoiceGroupParamVO;
	}
	
	public void setConfirmChargeListVOs(ConfirmChargeListVO[] confirmChargeListVOs){
		if (confirmChargeListVOs != null) {
			ConfirmChargeListVO[] tmpVOs = new ConfirmChargeListVO[confirmChargeListVOs.length];
			System.arraycopy(confirmChargeListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.confirmChargeListVOs = tmpVOs;
		}
	}
	
	public ConfirmChargeListVO[] getConfirmChargeListVOs(){
		ConfirmChargeListVO[] tmpVOs = null;
		if (this.confirmChargeListVOs != null) {
			tmpVOs = new ConfirmChargeListVO[confirmChargeListVOs.length];
			System.arraycopy(confirmChargeListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public void setIssuedInvoiceParamVO(IssuedInvoiceParamVO issuedInvoiceParamVO){
		this.issuedInvoiceParamVO = issuedInvoiceParamVO;
	}
	
	public IssuedInvoiceParamVO getIssuedInvoiceParamVO() {
		return issuedInvoiceParamVO;
	}
	
}