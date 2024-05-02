/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1035Event.java
*@FileTitle : Invoice Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.21
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.12.21 조재성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event;

import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSInvoiceInquiryINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSInvoiceInquiryMGTVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_1035 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1035HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author ChaeShung Cho
 * @see EES_CGM_1035HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1035Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSInvoiceInquiryINVO cHSInvoiceInquiryINVO = null;
	private CHSInvoiceInquiryMGTVO cHSInvoiceInquiryMGTVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CHSInvoiceInquiryINVO[] cHSInvoiceInquiryINVOs = null;
	private CHSInvoiceInquiryMGTVO[] cHSInvoiceInquiryMGTVOs = null;
	
	public EesCgm1035Event(){}
	
	public void setCHSInvoiceInquiryINVO(CHSInvoiceInquiryINVO cHSInvoiceInquiryINVO){
		this. cHSInvoiceInquiryINVO = cHSInvoiceInquiryINVO;
	}

	public void setCHSInvoiceInquiryINVOS(CHSInvoiceInquiryINVO[] cHSInvoiceInquiryINVOs){
		if(cHSInvoiceInquiryINVOs != null){
			CHSInvoiceInquiryINVO[] tmpVOs = java.util.Arrays.copyOf(cHSInvoiceInquiryINVOs, cHSInvoiceInquiryINVOs.length);
			this.cHSInvoiceInquiryINVOs = tmpVOs;
		}
	}

	public CHSInvoiceInquiryINVO getCHSInvoiceInquiryINVO(){
		return cHSInvoiceInquiryINVO;
	}

	public CHSInvoiceInquiryINVO[] getCHSInvoiceInquiryINVOS(){
		CHSInvoiceInquiryINVO[] rtnVOs = null;
		if (this.cHSInvoiceInquiryINVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(cHSInvoiceInquiryINVOs, cHSInvoiceInquiryINVOs.length);
		}
		return rtnVOs;
	}

	public CHSInvoiceInquiryMGTVO getCHSInvoiceInquiryMGTVO() {
		return cHSInvoiceInquiryMGTVO;
	}

	public void setCHSInvoiceInquiryMGTVO(CHSInvoiceInquiryMGTVO invoiceInquiryMGTVO) {
		cHSInvoiceInquiryMGTVO = invoiceInquiryMGTVO;
	}

	public CHSInvoiceInquiryINVO[] getCHSInvoiceInquiryINVOs() {
		CHSInvoiceInquiryINVO[] rtnVOs = null;
		if (this.cHSInvoiceInquiryINVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(cHSInvoiceInquiryINVOs, cHSInvoiceInquiryINVOs.length);
		}
		return rtnVOs;
	}

	public void setCHSInvoiceInquiryINVOs(CHSInvoiceInquiryINVO[] invoiceInquiryINVOs){
		if(invoiceInquiryINVOs != null){
			CHSInvoiceInquiryINVO[] tmpVOs = java.util.Arrays.copyOf(invoiceInquiryINVOs, invoiceInquiryINVOs.length);
			this.cHSInvoiceInquiryINVOs = tmpVOs;
		}
	}

	public CHSInvoiceInquiryMGTVO[] getCHSInvoiceInquiryMGTVOs() {
		CHSInvoiceInquiryMGTVO[] rtnVOs = null;
		if (this.cHSInvoiceInquiryMGTVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(cHSInvoiceInquiryMGTVOs, cHSInvoiceInquiryMGTVOs.length);
		}
		return rtnVOs;
	}

	public void setCHSInvoiceInquiryMGTVOs(CHSInvoiceInquiryMGTVO[] invoiceInquiryMGTVOs){
		if(invoiceInquiryMGTVOs != null){
			CHSInvoiceInquiryMGTVO[] tmpVOs = java.util.Arrays.copyOf(invoiceInquiryMGTVOs, invoiceInquiryMGTVOs.length);
			this.cHSInvoiceInquiryMGTVOs = tmpVOs;
		}
	}

}