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
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSInvoiceInquiryINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSInvoiceInquiryMGTVO;


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
		this. cHSInvoiceInquiryINVOs = cHSInvoiceInquiryINVOs;
	}

	public CHSInvoiceInquiryINVO getCHSInvoiceInquiryINVO(){
		return cHSInvoiceInquiryINVO;
	}

	public CHSInvoiceInquiryINVO[] getCHSInvoiceInquiryINVOS(){
		return cHSInvoiceInquiryINVOs;
	}

	public CHSInvoiceInquiryMGTVO getCHSInvoiceInquiryMGTVO() {
		return cHSInvoiceInquiryMGTVO;
	}

	public void setCHSInvoiceInquiryMGTVO(CHSInvoiceInquiryMGTVO invoiceInquiryMGTVO) {
		cHSInvoiceInquiryMGTVO = invoiceInquiryMGTVO;
	}

	public CHSInvoiceInquiryINVO[] getCHSInvoiceInquiryINVOs() {
		return cHSInvoiceInquiryINVOs;
	}

	public void setCHSInvoiceInquiryINVOs(
			CHSInvoiceInquiryINVO[] invoiceInquiryINVOs) {
		cHSInvoiceInquiryINVOs = invoiceInquiryINVOs;
	}

	public CHSInvoiceInquiryMGTVO[] getCHSInvoiceInquiryMGTVOs() {
		return cHSInvoiceInquiryMGTVOs;
	}

	public void setCHSInvoiceInquiryMGTVOs(
			CHSInvoiceInquiryMGTVO[] invoiceInquiryMGTVOs) {
		cHSInvoiceInquiryMGTVOs = invoiceInquiryMGTVOs;
	}

}