/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1204Event.java
*@FileTitle : CPS Invoice Import & Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.21
*@LastModifier : 조경완
*@LastVersion : 1.0
* 2013.03.21 조경완
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSInvoiceImportAuditINVO;

/**
 * ees_cgm_1204 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_cgm_1204HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Cho Kyoung Wan
 * @see ees_cgm_1204HTMLAction 참조
 * @since J2EE 1.4 
 */

public class EesCgm1204Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSInvoiceImportAuditINVO chsInvoiceImportAuditINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CHSInvoiceImportAuditINVO[] chsInvoiceImportAuditINVOS = null;

	public EesCgm1204Event(){}

	public CHSInvoiceImportAuditINVO getChsInvoiceImportAuditINVO() {
		return chsInvoiceImportAuditINVO;
	}

	public void setChsInvoiceImportAuditINVO(
			CHSInvoiceImportAuditINVO chsInvoiceImportAuditINVO) {
		this.chsInvoiceImportAuditINVO = chsInvoiceImportAuditINVO;
	}

	public CHSInvoiceImportAuditINVO[] getChsInvoiceImportAuditINVOS() {
		return chsInvoiceImportAuditINVOS;
	}

	public void setChsInvoiceImportAuditINVOS(
			CHSInvoiceImportAuditINVO[] chsInvoiceImportAuditINVOS) {
		this.chsInvoiceImportAuditINVOS = chsInvoiceImportAuditINVOS;
	}
	
	
	
}