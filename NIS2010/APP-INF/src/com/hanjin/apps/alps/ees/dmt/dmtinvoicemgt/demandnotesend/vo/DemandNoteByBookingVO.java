/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DemandNoteByBookingVO.java
*@FileTitle : DemandNoteByBookingVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.09.24 최성환 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.vo;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ChargeBookingInvoiceVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueVO;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최성환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DemandNoteByBookingVO  {

private ChargeBookingInvoiceVO chargeBookingInvoiceVO = null;
	
	private List<InvoiceIssueVO> invoiceIssueVOs = null;

	public ChargeBookingInvoiceVO getChargeBookingInvoiceVO() {
		return chargeBookingInvoiceVO;
	}

	public List<InvoiceIssueVO> getInvoiceIssueVOs() {
		return invoiceIssueVOs;
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
}
