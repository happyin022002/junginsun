/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EesCgm1211Event.java
*@FileTitle : Audit Result Update(PopUp)
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.27
*@LastModifier : 김창영
*@LastVersion : 1.0
* 2014.05.27 김창영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event;

import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSConfirmPayableAmountINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCpsAuditResultUpdateINVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ees_cgm_1211 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_cgm_1211HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Chang Young Kim
 * @see ees_cgm_1211HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1211Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	
	private CHSCpsAuditResultUpdateINVO chsCpsAuditResultUpdateINVO = null;
	
	private CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CHSCpsAuditResultUpdateINVO[] chsCpsAuditResultUpdateINVOS = null;
	
	
	public CHSCpsAuditResultUpdateINVO getChsCpsAuditResultUpdateINVO() {
		return chsCpsAuditResultUpdateINVO;
	}
	
	public void setChsCpsAuditResultUpdateINVO(
			CHSCpsAuditResultUpdateINVO chsCpsAuditResultUpdateINVO) {
		this.chsCpsAuditResultUpdateINVO = chsCpsAuditResultUpdateINVO;
	}
	
	public CHSCpsAuditResultUpdateINVO[] getChsCpsAuditResultUpdateINVOS() {
		return chsCpsAuditResultUpdateINVOS;
	}
	
	public void setChsCpsAuditResultUpdateINVOS(
			CHSCpsAuditResultUpdateINVO[] chsCpsAuditResultUpdateINVOS) {
		this.chsCpsAuditResultUpdateINVOS = chsCpsAuditResultUpdateINVOS;
	}
	
	public CHSConfirmPayableAmountINVO getChsConfirmPayableAmountINVO() {
		return chsConfirmPayableAmountINVO;
	}
	
	public void setChsConfirmPayableAmountINVO(
			CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO) {
		this.chsConfirmPayableAmountINVO = chsConfirmPayableAmountINVO;
	}
}