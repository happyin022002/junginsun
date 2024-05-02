/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : EesCgm1208Event.java
 *@FileTitle : Neutral Pool(ZP) Invoice Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.03.26
 *@LastModifier : 이영헌
 *@LastVersion : 1.0
 * 2013.03.26 이영헌
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSInvoiceInquiryINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSInvoiceInquiryMGTVO;


/**
 * EES_CGM_1208 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1208HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author LEE YOUNG HEON
 * @see EES_CGM_1208HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1208Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSInvoiceInquiryINVO cHSInvoiceInquiryINVO = null;
	private CHSInvoiceInquiryMGTVO cHSInvoiceInquiryMGTVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CHSInvoiceInquiryINVO[] cHSInvoiceInquiryINVOs = null;
	private CHSInvoiceInquiryMGTVO[] cHSInvoiceInquiryMGTVOs = null;
	
	public EesCgm1208Event(){}
	
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