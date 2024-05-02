/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueMgtVO.java
*@FileTitle : Invoice Issue을 생성하는 VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 8. 21.
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009. 8. 21. 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChrgDtlVO;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김태균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class InvoiceIssueMgtVO {
	
	private ChargeBookingInvoiceVO chargeBookingInvoiceVO = null;
	
	private List<InvoiceIssueVO> invoiceIssueVOs = null;
	
	private List<ManualKeyByChargeVO> manualKeyByChargeVOS = null;
	
	private List<ManualKeyByBookingVO> manualKeyByBookingVOS = null;
	
	private	List<DmtInvMnVO> dmtInvMnVOS = null;
	
	private	List<DmtInvDtlVO> dmtInvDtlVOS = null;
	
	private List<DmtInvRtVO> dmtInvRtVOS = null;
	
	private List<ChrgDtlVO> chrgDtlVOs = null;
	
	private List<String> chargeCurrency = null;

	public ChargeBookingInvoiceVO getChargeBookingInvoiceVO() {
		return chargeBookingInvoiceVO;
	}

	public List<InvoiceIssueVO> getInvoiceIssueVOs() {
		return invoiceIssueVOs;
	}
	
	public List<ManualKeyByChargeVO> getManualKeyByChargeVOS() {
		return manualKeyByChargeVOS;
	}	
	
	public List<ManualKeyByBookingVO> getManualKeyByBookingVOS() {
		return manualKeyByBookingVOS;
	}
	
	public List<DmtInvMnVO> getDmtInvMnVOS() {
		return dmtInvMnVOS;
	}

	public List<DmtInvDtlVO> getDmtInvDtlVOS() {
		return dmtInvDtlVOS;
	}

	public List<DmtInvRtVO> getDmtInvRtVOS() {
		return dmtInvRtVOS;
	}
	
	public List<String> getChargeCurrency() {
		return chargeCurrency;
	}
	
	public void setChargeBookingInvoiceVO(
			ChargeBookingInvoiceVO chargeBookingInvoiceVO) {
		this.chargeBookingInvoiceVO = chargeBookingInvoiceVO;
	}

	public void setInvoiceIssueVOs(InvoiceIssueVO[] invoiceIssueList) {
		if(invoiceIssueList != null && invoiceIssueList.length > 0) {
			invoiceIssueVOs = new ArrayList<InvoiceIssueVO>();
			for(int i = 0 ; i < invoiceIssueList.length ; i++ ) {
				invoiceIssueVOs.add(invoiceIssueList[i]);
			}
		}
	}
	
	public void setInvoiceIssueList(List<InvoiceIssueVO> invoiceIssueList) {
		this.invoiceIssueVOs = invoiceIssueList;
	}
	
	public void setManualKeyByChargeVOS(List<ManualKeyByChargeVO> manualKeyByChargeVOS) {
		this.manualKeyByChargeVOS = manualKeyByChargeVOS;
	}	
	
	public void setManualKeyByBookingVOS(List<ManualKeyByBookingVO> manualKeyByBookingVOS) {
		this.manualKeyByBookingVOS = manualKeyByBookingVOS;
	}	
	
	public void setDmtInvMnVOS(List<DmtInvMnVO> dmtInvMnVOS) {
		this.dmtInvMnVOS = dmtInvMnVOS;
	}

	public void setDmtInvDtlVOS(List<DmtInvDtlVO> dmtInvDtlVOS) {
		this.dmtInvDtlVOS = dmtInvDtlVOS;
	}
	
	public void setDmtInvRtVOS(List<DmtInvRtVO> dmtInvRtVOS) {
		this.dmtInvRtVOS = dmtInvRtVOS;
	}

	public List<ChrgDtlVO> getChrgDtlVOs() {
		return chrgDtlVOs;
	}
	
	public void setChrgDtlVOs(List<ChrgDtlVO> chrgDtlVOs) {
		this.chrgDtlVOs = chrgDtlVOs;
	}
	
	public void setChrgDtlVOs(ChrgDtlVO[] chrgDtlVOList) {
		if(chrgDtlVOList != null && chrgDtlVOList.length > 0) {
			chrgDtlVOs = new ArrayList<ChrgDtlVO>();
			for(int i = 0 ; i < chrgDtlVOList.length ; i++ ) {
				chrgDtlVOs.add(chrgDtlVOList[i]);
			}
		}
	}
	
	public void setChargeCurrency(String currency) {
		if (chargeCurrency == null) {
			chargeCurrency = new ArrayList<String>();
		}
		chargeCurrency.add(currency);
	}
}
