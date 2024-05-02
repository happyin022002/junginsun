/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StmSap0020Event.java
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
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceApprovalInfoListVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.InvoiceEntryListVO;
import com.clt.framework.support.layer.event.EventSupport;



/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceMasterDataMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author CLT
 * @see AccountReceivableInvoiceMasterDataMgtEvent 참조
 * @since J2EE 1.4
 */

public class StmSap0020Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건  */
	private String ofcCd         = "";
	private String vndrNo        = "";
	private String creDt         = "";
	private String invNo         = "";
	private String lginUsrApOfc  = "";
	private String lginUsrNm     = "";
	private String lginUsrId     = "";
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvoiceEntryListVO invoiceEntryListVO = null;
	/** Table Value Object Multi Data 처리 */
	private InvoiceEntryListVO[] invoiceEntryListVOs = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvoiceApprovalInfoListVO invoiceApprovalInfoListVO = null;
	/** Table Value Object Multi Data 처리 */
	private InvoiceApprovalInfoListVO[] invoiceApprovalInfoListVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SapCommonVO sapCommonVO = null;

	/** Table Value Object Multi Data 처리 */
	private SapCommonVO[] sapCommonVOs = null;
	
	public String getOfcCd() {
		return ofcCd;
	}
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	public String getVndrNo() {
		return vndrNo;
	}
	public void setVndrNo(String vndrNo) {
		this.vndrNo = vndrNo;
	}
	public String getCreDt() {
		return creDt;
	}
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	public String getInvNo() {
		return invNo;
	}
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	public String getLginUsrApOfc() {
		return lginUsrApOfc;
	}
	public void setLginUsrApOfc(String lginUsrApOfc) {
		this.lginUsrApOfc = lginUsrApOfc;
	}
	public String getLginUsrNm() {
		return lginUsrNm;
	}
	public void setLginUsrNm(String lginUsrNm) {
		this.lginUsrNm = lginUsrNm;
	}
	public String getLginUsrId() {
		return lginUsrId;
	}
	public void setLginUsrId(String lginUsrId) {
		this.lginUsrId = lginUsrId;
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
	public InvoiceApprovalInfoListVO getInvoiceApprovalInfoListVO() {
		return invoiceApprovalInfoListVO;
	}
	public void setInvoiceApprovalInfoListVO(InvoiceApprovalInfoListVO invoiceApprovalInfoListVO) {
		this.invoiceApprovalInfoListVO = invoiceApprovalInfoListVO;
	}
	public InvoiceApprovalInfoListVO[] getInvoiceApprovalInfoListVOs() {
		InvoiceApprovalInfoListVO[] rtnVOs = null;
		if(this.invoiceApprovalInfoListVOs != null) {
			rtnVOs = new InvoiceApprovalInfoListVO[invoiceApprovalInfoListVOs.length];
			System.arraycopy(invoiceApprovalInfoListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;

	}
	public void setInvoiceApprovalInfoListVOs(InvoiceApprovalInfoListVO[] invoiceApprovalInfoListVOs) {
		if(invoiceApprovalInfoListVOs != null) {
			InvoiceApprovalInfoListVO[] tmpVOs = new InvoiceApprovalInfoListVO[invoiceApprovalInfoListVOs.length];
			System.arraycopy(invoiceApprovalInfoListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.invoiceApprovalInfoListVOs = tmpVOs;
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