/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : FnsInv0031Event.java
 *@FileTitle : Invoice Inquiry by Good Date
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.04
 *@LastModifier : 김세일
 *@LastVersion : 1.0
 * 2009.05.04 김세일
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceInquiryInPutVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceListByIFDateVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * FNS_INV_0031 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - FNS_INV_0031HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author saeil kim
 * @see FNS_INV_0031HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0031Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private ARInvoiceInquiryInPutVO invByGoodVO = null;

	/** Table Value Object Multi Data 처리 */
	private ARInvoiceListByIFDateVO[] aRInvoiceListByIFDateVOs = null;
	
	/* Column Info */
	private String actCustCntCd = null;

	/* Column Info */
	private String actCustSeq = null;

	public FnsInv0031Event() {
	}

	public void setARInvoiceListByIFDateVOS(ARInvoiceListByIFDateVO[] aRInvoiceListByIFDateVOs){
		if(aRInvoiceListByIFDateVOs != null){
			ARInvoiceListByIFDateVO[] tmpVOs = new ARInvoiceListByIFDateVO[aRInvoiceListByIFDateVOs.length];
			System.arraycopy(aRInvoiceListByIFDateVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.aRInvoiceListByIFDateVOs = tmpVOs;
		}
	}

	public ARInvoiceListByIFDateVO[] getARInvoiceListByIFDateVOS() {
		ARInvoiceListByIFDateVO[] rtnVOs = null;
		if (this.aRInvoiceListByIFDateVOs != null) {
			rtnVOs = new ARInvoiceListByIFDateVO[aRInvoiceListByIFDateVOs.length];
			System.arraycopy(aRInvoiceListByIFDateVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public ARInvoiceInquiryInPutVO getInvByGoodVO() {
		return invByGoodVO;
	}

	public void setInvByGoodVO(ARInvoiceInquiryInPutVO invByGoodVO) {
		this.invByGoodVO = invByGoodVO;
	}

	public String getActCustCntCd() {
		return actCustCntCd;
	}

	public void setActCustCntCd(String actCustCntCd) {
		this.actCustCntCd = actCustCntCd;
	}

	public String getActCustSeq() {
		return actCustSeq;
	}

	public void setActCustSeq(String actCustSeq) {
		this.actCustSeq = actCustSeq;
	}

}