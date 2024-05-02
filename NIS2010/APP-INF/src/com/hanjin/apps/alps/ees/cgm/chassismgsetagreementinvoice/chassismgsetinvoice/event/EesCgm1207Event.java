/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : EesCgm1207Event.java
 *@FileTitle : Neutral Pool(ZP) Invoice Creation
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
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSPayableInvoiceCreationINVO;

/**
 * ees_cgm_1207 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_cgm_1207HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author LEE YOUNG HEON
 * @see ees_cgm_1207HTMLAction 참조
 * @since J2EE 1.4 
 */

public class EesCgm1207Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSPayableInvoiceCreationINVO chsPayableInvoiceCreationINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CHSPayableInvoiceCreationINVO[] chsPayableInvoiceCreationINVOS = null;

	public CHSPayableInvoiceCreationINVO getChsPayableInvoiceCreationINVO() {
		return chsPayableInvoiceCreationINVO;
	}

	public void setChsPayableInvoiceCreationINVO(
			CHSPayableInvoiceCreationINVO chsPayableInvoiceCreationINVO) {
		this.chsPayableInvoiceCreationINVO = chsPayableInvoiceCreationINVO;
	}

	public CHSPayableInvoiceCreationINVO[] getChsPayableInvoiceCreationINVOS() {
		return chsPayableInvoiceCreationINVOS;
	}

	public void setChsPayableInvoiceCreationINVOS(
			CHSPayableInvoiceCreationINVO[] chsPayableInvoiceCreationINVOS) {
		this.chsPayableInvoiceCreationINVOS = chsPayableInvoiceCreationINVOS;
	}
}