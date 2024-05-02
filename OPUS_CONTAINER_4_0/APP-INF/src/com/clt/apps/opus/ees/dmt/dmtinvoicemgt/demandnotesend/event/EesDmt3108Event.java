/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt3108Event.java
*@FileTitle : Demand Note Issue - Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.10.05 최성환
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.event;


import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNoteParmVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ChargeBookingInvoiceVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetOptionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_DMT_3108 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_3108HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Sung Hwan
 * @see EES_DMT_3108HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt3108Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DemandNoteParmVO demandNoteParmVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DemandNoteParmVO[] demandNoteParmVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SheetOptionVO sheetOptionVO = null;
	
	private ChargeBookingInvoiceVO chargeBookingInvoiceVO = null;
	
	public EesDmt3108Event(){}
	
	public void setDemandNoteParmVO(DemandNoteParmVO demandNoteParmVO){
		this. demandNoteParmVO = demandNoteParmVO;
	}

	public void setDemandNoteParmVOS(DemandNoteParmVO[] demandNoteParmVOs){
		if (demandNoteParmVOs != null) {
			DemandNoteParmVO[] tmpVOs = new DemandNoteParmVO[demandNoteParmVOs.length];
			System.arraycopy(demandNoteParmVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.demandNoteParmVOs = tmpVOs;
		}
	}
	
	public void setSheetOptionVO(SheetOptionVO sheetOptionVO){
		this. sheetOptionVO = sheetOptionVO;
	}

	public SheetOptionVO getSheetOptionVO(){
		return sheetOptionVO;
	}

	public ChargeBookingInvoiceVO getChargeBookingInvoiceVO() {
		return chargeBookingInvoiceVO;
	}

	public void setChargeBookingInvoiceVO(
			ChargeBookingInvoiceVO chargeBookingInvoiceVO) {
		this.chargeBookingInvoiceVO = chargeBookingInvoiceVO;
	}
	
	public DemandNoteParmVO getDemandNoteParmVO(){
		return demandNoteParmVO;
	}

	public DemandNoteParmVO[] getDemandNoteParmVOs(){
		DemandNoteParmVO[] tmpVOs = null;
		if (this.demandNoteParmVOs != null) {
			tmpVOs = new DemandNoteParmVO[demandNoteParmVOs.length];
			System.arraycopy(demandNoteParmVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}



}