/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : StmSap0040Event.java
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

import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.SapCommonVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceEntryListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceReceiptCondVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceReceiptListVO;
import com.clt.framework.support.layer.event.EventSupport;



/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceMasterDataMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author CLT
 * @see AccountReceivableInvoiceMasterDataMgtEvent 참조
 * @since J2EE 1.4
 */

public class StmSap0040Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건  */
	private String lginUsrApOfc  = "";
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvoiceEntryListVO invoiceEntryListVO = null;
	/** Table Value Object Multi Data 처리 */
	private InvoiceEntryListVO[] invoiceEntryListVOs = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvoiceReceiptListVO invoiceReceiptListVO = null;
	/** Table Value Object Multi Data 처리 */
	private InvoiceReceiptListVO[] invoiceReceiptListVOs = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvoiceReceiptCondVO invoiceReceiptCondVO = null;
	/** Table Value Object Multi Data 처리 */
	private InvoiceReceiptCondVO[] invoiceReceiptCondVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SapCommonVO sapCommonVO = null;

	/** Table Value Object Multi Data 처리 */
	private SapCommonVO[] sapCommonVOs = null;
	
	public String getLginUsrApOfc() {
		return lginUsrApOfc;
	}
	public void setLginUsrApOfc(String lginUsrApOfc) {
		this.lginUsrApOfc = lginUsrApOfc;
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
	public InvoiceReceiptListVO getInvoiceReceiptListVO() {
		return invoiceReceiptListVO;
	}
	public void setInvoiceReceiptListVO(InvoiceReceiptListVO invoiceReceiptListVO) {
		this.invoiceReceiptListVO = invoiceReceiptListVO;
	}
	public InvoiceReceiptListVO[] getInvoiceReceiptListVOs() {
		InvoiceReceiptListVO[] rtnVOs = null;
		if(this.invoiceReceiptListVOs != null) {
			rtnVOs = new InvoiceReceiptListVO[invoiceReceiptListVOs.length];
			System.arraycopy(invoiceReceiptListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;

	}
	public void setInvoiceReceiptListVOs(InvoiceReceiptListVO[] invoiceReceiptListVOs) {
		if(invoiceReceiptListVOs != null) {
			InvoiceReceiptListVO[] tmpVOs = new InvoiceReceiptListVO[invoiceReceiptListVOs.length];
			System.arraycopy(invoiceReceiptListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.invoiceReceiptListVOs = tmpVOs;
		}

	}
	public InvoiceReceiptCondVO getInvoiceReceiptCondVO() {
		return invoiceReceiptCondVO;
	}
	public void setInvoiceReceiptCondVO(InvoiceReceiptCondVO invoiceReceiptCondVO) {
		this.invoiceReceiptCondVO = invoiceReceiptCondVO;
	}
	public InvoiceReceiptCondVO[] getInvoiceReceiptCondVOs() {
		InvoiceReceiptCondVO[] rtnVOs = null;
		if(this.invoiceReceiptCondVOs != null) {
			rtnVOs = new InvoiceReceiptCondVO[invoiceReceiptCondVOs.length];
			System.arraycopy(invoiceReceiptCondVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;

	}
	public void setInvoiceReceiptCondVOs(InvoiceReceiptCondVO[] invoiceReceiptCondVOs) {
		if(invoiceReceiptCondVOs != null) {
			InvoiceReceiptCondVO[] tmpVOs = new InvoiceReceiptCondVO[invoiceReceiptCondVOs.length];
			System.arraycopy(invoiceReceiptCondVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.invoiceReceiptCondVOs = tmpVOs;
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