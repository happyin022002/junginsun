/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm2036Event.java
*@FileTitle : Invoice Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.28
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.12.28 조재성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event;

import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSInvoiceInquiryINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSInvoiceInquiryMGTVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_2036 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_2036HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author ChaeShung Cho
 * @see EES_CGM_2036HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm2036Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MGSInvoiceInquiryINVO mGSInvoiceInquiryINVO = null;
	private MGSInvoiceInquiryINVO[] mGSInvoiceInquiryINVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private MGSInvoiceInquiryMGTVO mGSInvoiceInquiryMGTVO = null;
	private MGSInvoiceInquiryMGTVO[] mGSInvoiceInquiryMGTVOs = null;

	public EesCgm2036Event(){}
	
	public void setMGSInvoiceInquiryINVO(MGSInvoiceInquiryINVO mGSInvoiceInquiryINVO){
		this. mGSInvoiceInquiryINVO = mGSInvoiceInquiryINVO;
	}

	public void setMGSInvoiceInquiryINVOS(MGSInvoiceInquiryINVO[] mGSInvoiceInquiryINVOs){
		if(mGSInvoiceInquiryINVOs != null){
			MGSInvoiceInquiryINVO[] tmpVOs = java.util.Arrays.copyOf(mGSInvoiceInquiryINVOs, mGSInvoiceInquiryINVOs.length);
			this.mGSInvoiceInquiryINVOs = tmpVOs;
		}
	}

	public MGSInvoiceInquiryINVO getMGSInvoiceInquiryINVO(){
		return mGSInvoiceInquiryINVO;
	}

	public MGSInvoiceInquiryINVO[] getMGSInvoiceInquiryINVOS(){
		MGSInvoiceInquiryINVO[] rtnVOs = null;
		if (this.mGSInvoiceInquiryINVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(mGSInvoiceInquiryINVOs, mGSInvoiceInquiryINVOs.length);
		}
		return rtnVOs;
	}

	public MGSInvoiceInquiryINVO[] getMGSInvoiceInquiryINVOs() {
		MGSInvoiceInquiryINVO[] rtnVOs = null;
		if (this.mGSInvoiceInquiryINVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(mGSInvoiceInquiryINVOs, mGSInvoiceInquiryINVOs.length);
		}
		return rtnVOs;
	}

	public void setMGSInvoiceInquiryINVOs(MGSInvoiceInquiryINVO[] invoiceInquiryINVOs){
		if(invoiceInquiryINVOs != null){
			MGSInvoiceInquiryINVO[] tmpVOs = java.util.Arrays.copyOf(invoiceInquiryINVOs, invoiceInquiryINVOs.length);
			this.mGSInvoiceInquiryINVOs = tmpVOs;
		}
	}

	public MGSInvoiceInquiryMGTVO getMGSInvoiceInquiryMGTVO() {
		return mGSInvoiceInquiryMGTVO;
	}

	public void setMGSInvoiceInquiryMGTVO(MGSInvoiceInquiryMGTVO invoiceInquiryMGTVO) {
		mGSInvoiceInquiryMGTVO = invoiceInquiryMGTVO;
	}

	public MGSInvoiceInquiryMGTVO[] getMGSInvoiceInquiryMGTVOs() {
		MGSInvoiceInquiryMGTVO[] rtnVOs = null;
		if (this.mGSInvoiceInquiryMGTVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(mGSInvoiceInquiryMGTVOs, mGSInvoiceInquiryMGTVOs.length);
		}
		return rtnVOs;
	}

	public void setMGSInvoiceInquiryMGTVOs(MGSInvoiceInquiryMGTVO[] invoiceInquiryMGTVOs){
		if(invoiceInquiryMGTVOs != null){
			MGSInvoiceInquiryMGTVO[] tmpVOs = java.util.Arrays.copyOf(invoiceInquiryMGTVOs, invoiceInquiryMGTVOs.length);
			this.mGSInvoiceInquiryMGTVOs = tmpVOs;
		}
	}
	

}