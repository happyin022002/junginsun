/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0112Event.java
*@FileTitle : EDI Submission
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.14
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.12.14 [CHM-201006644] 최도순 NIKE, Invoice EDI 신규 개발 요청
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.event;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.EDI310InputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.EDI310InvoiceVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0112 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0112HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Do Soon
 * @see FNS_INV_0112HTMLAction 참조
 * @since J2EE 1.6
 */
 
public class FnsInv0112Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String cntcTpCd = null;
	
	private String scRfaNo = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EDI310InputVO edi310InputVO = null;
	
	private EDI310InvoiceVO[] edi310InvoiceVOs = null;

	public FnsInv0112Event(){}
	
	
	public String getCntcTpCd() {
		return cntcTpCd;
	}

	public void setCntcTpCd(String cntcTpCd) {
		this.cntcTpCd = cntcTpCd;
	}
	
	public String getScRfaNo() {
		return scRfaNo;
	}

	public void setScRfaNo(String scRfaNo) {
		this.scRfaNo = scRfaNo;
	}
	
	public EDI310InputVO getEDI310InputVO() {
		return edi310InputVO;
	}

	public void setEDI310InputVO(EDI310InputVO edi310InputVO) {
		this.edi310InputVO = edi310InputVO;
	}
	
	public EDI310InvoiceVO[] getEDI310InvoiceVOs() {
		EDI310InvoiceVO[] rtnVOs = null;
		if (this.edi310InvoiceVOs != null) {
			rtnVOs = new EDI310InvoiceVO[edi310InvoiceVOs.length];
			System.arraycopy(edi310InvoiceVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setEDI310InvoiceVOs(EDI310InvoiceVO[] edi310InvoiceVOs) {
		if (edi310InvoiceVOs != null) {
			EDI310InvoiceVO[] tmpVOs = new EDI310InvoiceVO[edi310InvoiceVOs.length];
			System.arraycopy(edi310InvoiceVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.edi310InvoiceVOs = tmpVOs;
		}
	}

}