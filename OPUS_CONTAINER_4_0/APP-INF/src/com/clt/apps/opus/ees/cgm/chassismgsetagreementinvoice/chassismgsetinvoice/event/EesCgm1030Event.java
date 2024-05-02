/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1030Event.java
*@FileTitle : Invoice Import & Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.08.21 김창식
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event;

import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSInvoiceImportAuditINVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ees_cgm_1030 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_cgm_1030HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM CHANG SIK
 * @see ees_cgm_1030HTMLAction 참조
 * @since J2EE 1.4 
 */

public class EesCgm1030Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSInvoiceImportAuditINVO chsInvoiceImportAuditINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CHSInvoiceImportAuditINVO[] chsInvoiceImportAuditINVOS = null;

	public EesCgm1030Event(){}

	public CHSInvoiceImportAuditINVO getChsInvoiceImportAuditINVO() {
		return chsInvoiceImportAuditINVO;
	}

	public void setChsInvoiceImportAuditINVO(
			CHSInvoiceImportAuditINVO chsInvoiceImportAuditINVO) {
		this.chsInvoiceImportAuditINVO = chsInvoiceImportAuditINVO;
	}

	public CHSInvoiceImportAuditINVO[] getChsInvoiceImportAuditINVOS() {
		CHSInvoiceImportAuditINVO[] rtnVOs = null;
		if (this.chsInvoiceImportAuditINVOS != null) {
			rtnVOs = java.util.Arrays.copyOf(chsInvoiceImportAuditINVOS, chsInvoiceImportAuditINVOS.length);
		}
		return rtnVOs;
	}

	public void setChsInvoiceImportAuditINVOS(CHSInvoiceImportAuditINVO[] chsInvoiceImportAuditINVOS){
		if(chsInvoiceImportAuditINVOS != null){
			CHSInvoiceImportAuditINVO[] tmpVOs = java.util.Arrays.copyOf(chsInvoiceImportAuditINVOS, chsInvoiceImportAuditINVOS.length);
			this.chsInvoiceImportAuditINVOS = tmpVOs;
		}
	}
	
	
	
}