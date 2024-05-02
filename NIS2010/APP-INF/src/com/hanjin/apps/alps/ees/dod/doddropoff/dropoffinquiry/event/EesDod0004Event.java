/*=========================================================
*Copyright(c) 2006 CyberLogitec 
*@FileName : EesDod0004Event.java
*@FileTitle : DOD DropOff Invoice Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2015-11-04
*@LastModifier : Jeong-Min Park
*@LastVersion : 1.0
* 2015-11-04 Jeong-Min Park
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.dod.doddropoff.dropoffinquiry.event;

import com.hanjin.apps.alps.ees.dod.doddropoff.dropoffinquiry.vo.DropOffInvoiceInquiryINVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EesDod0004Event PDTO(Data Transfer Object including Parameters)<br>
 * @author Jeong-Min Park
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class EesDod0004Event extends EventSupport {

	private static final long serialVersionUID = -7655442127499890917L;
	
	private DropOffInvoiceInquiryINVO dropOffInvoiceInquiryINVO = null;

	public DropOffInvoiceInquiryINVO getDropOffInvoiceInquiryINVO() {
		return dropOffInvoiceInquiryINVO;
	}

	public void setDropOffInvoiceInquiryINVO(DropOffInvoiceInquiryINVO dropOffInvoiceInquiryINVO) {
		this.dropOffInvoiceInquiryINVO = dropOffInvoiceInquiryINVO;
	}
}
