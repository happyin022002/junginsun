/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : StmSap0010Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.event;


import com.clt.framework.support.layer.event.EventSupport;

import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.SapCommonVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceEntryCondVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceEntryLineListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceEntryListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoicePayScheduleListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoicePrintVO;


/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceMasterDataMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Han Dong Hoon
 * @see AccountReceivableInvoiceMasterDataMgtEvent 참조
 * @since J2EE 1.4
 */

public class StmSap0010Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String invSeq = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvoiceEntryCondVO invoiceEntryCondVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvoiceEntryLineListVO invoiceEntryLineListVO = null;

	/** Table Value Object Multi Data 처리 */
	private InvoiceEntryLineListVO[] invoiceEntryLineListVOs = null;


	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvoiceEntryListVO invoiceEntryListVO = null;

	/** Table Value Object Multi Data 처리 */
	private InvoiceEntryListVO[] invoiceEntryListVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvoicePayScheduleListVO invoicePayScheduleListVO = null;

	/** Table Value Object Multi Data 처리 */
	private InvoicePayScheduleListVO[] invoicePayScheduleListVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvoicePrintVO[] invoicePrintVOs = null;	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SapCommonVO sapCommonVO = null;

	/** Table Value Object Multi Data 처리 */
	private SapCommonVO[] sapCommonVOs = null;
	

	public StmSap0010Event() {}

	public String getInvSeq() {
		return invSeq;
	}

	public void setInvSeq(String invSeq) {
		this.invSeq = invSeq;
	}

	public InvoiceEntryCondVO getInvoiceEntryCondVO() {
		return invoiceEntryCondVO;
	}

	public void setInvoiceEntryCondVO(InvoiceEntryCondVO invoiceEntryCondVO) {
		this.invoiceEntryCondVO = invoiceEntryCondVO;
	}

	public InvoiceEntryLineListVO getInvoiceEntryLineListVO() {
		return invoiceEntryLineListVO;
	}

	public void setInvoiceEntryLineListVO(
			InvoiceEntryLineListVO invoiceEntryLineListVO) {
		this.invoiceEntryLineListVO = invoiceEntryLineListVO;
	}

	public InvoiceEntryLineListVO[] getInvoiceEntryLineListVOs() {
		InvoiceEntryLineListVO[] rtnVOs = null;
		if(this.invoiceEntryLineListVOs != null) {
			rtnVOs = new InvoiceEntryLineListVO[invoiceEntryLineListVOs.length];
			System.arraycopy(invoiceEntryLineListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;

	}

	public void setInvoiceEntryLineListVOs( InvoiceEntryLineListVO[] invoiceEntryLineListVOs) {
		if(invoiceEntryLineListVOs != null) {
			InvoiceEntryLineListVO[] tmpVOs = new InvoiceEntryLineListVO[invoiceEntryLineListVOs.length];
			System.arraycopy(invoiceEntryLineListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.invoiceEntryLineListVOs = tmpVOs;
		}

	}

	public InvoiceEntryListVO getInvoiceEntryListVO() {
		return invoiceEntryListVO;
	}

	public void setInvoiceEntryListVO(InvoiceEntryListVO invoiceEntryListVO) {
		this.invoiceEntryListVO = invoiceEntryListVO;
	}

	public InvoiceEntryListVO[] getInvoiceEntryListVOs() {
		InvoiceEntryListVO[] rtnVOs = null;
		if(this.invoiceEntryListVOs != null) {
			rtnVOs = new InvoiceEntryListVO[invoiceEntryListVOs.length];
			System.arraycopy(invoiceEntryListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;

	}

	public void setInvoiceEntryListVOs(InvoiceEntryListVO[] invoiceEntryListVOs) {
		if(invoiceEntryListVOs != null) {
			InvoiceEntryListVO[] tmpVOs = new InvoiceEntryListVO[invoiceEntryListVOs.length];
			System.arraycopy(invoiceEntryListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.invoiceEntryListVOs = tmpVOs;
		}

	}

	public InvoicePayScheduleListVO getInvoicePayScheduleListVO() {
		return invoicePayScheduleListVO;
	}

	public void setInvoicePayScheduleListVO( InvoicePayScheduleListVO invoicePayScheduleListVO) {
		this.invoicePayScheduleListVO = invoicePayScheduleListVO;
	}

	public InvoicePayScheduleListVO[] getInvoicePayScheduleListVOs() {
		InvoicePayScheduleListVO[] rtnVOs = null;
		if(this.invoicePayScheduleListVOs != null) {
			rtnVOs = new InvoicePayScheduleListVO[invoicePayScheduleListVOs.length];
			System.arraycopy(invoicePayScheduleListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setInvoicePayScheduleListVOs(InvoicePayScheduleListVO[] invoicePayScheduleListVOs) {
		if(invoicePayScheduleListVOs != null) {
			InvoicePayScheduleListVO[] tmpVOs = new InvoicePayScheduleListVO[invoicePayScheduleListVOs.length];
			System.arraycopy(invoicePayScheduleListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.invoicePayScheduleListVOs = tmpVOs;
		}

	}

	public InvoicePrintVO[] getInvoicePrintVOs() {
		InvoicePrintVO[] rtnVOs = null;
		if(this.invoicePrintVOs != null) {
			rtnVOs = new InvoicePrintVO[invoicePrintVOs.length];
			System.arraycopy(invoicePrintVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;

	}

	public void setInvoicePrintVOs(InvoicePrintVO[] invoicePrintVOs) {
		if(invoicePrintVOs != null) {
			InvoicePrintVO[] tmpVOs = new InvoicePrintVO[invoicePrintVOs.length];
			System.arraycopy(invoicePrintVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.invoicePrintVOs = tmpVOs;
		}

	}

	public SapCommonVO getSapCommonVO() {
		return sapCommonVO;
	}

	public void setSapCommonVO(SapCommonVO sapCommonVO) {
		this.sapCommonVO = sapCommonVO;
	}

	public SapCommonVO[] getSapCommonVOs() {
		SapCommonVO[] rtnVOs = null;
		if(this.sapCommonVOs != null) {
			rtnVOs = new SapCommonVO[sapCommonVOs.length];
			System.arraycopy(sapCommonVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setSapCommonVOs(SapCommonVO[] sapCommonVOs) {
		if(sapCommonVOs != null) {
			SapCommonVO[] tmpVOs = new SapCommonVO[sapCommonVOs.length];
			System.arraycopy(sapCommonVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.sapCommonVOs = tmpVOs;
		}
	}

}