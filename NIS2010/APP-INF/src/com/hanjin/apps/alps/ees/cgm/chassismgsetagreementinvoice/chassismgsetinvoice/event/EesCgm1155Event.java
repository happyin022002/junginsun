/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName 		: EesCgm1155Event.java
*@FileTitle 	: Performance by Pool Charge
*Open Issues 	:
*Change history :
*@LastModifyDate: 2014.02.11
*@LastModifier 	: 신용찬
*@LastVersion 	: 1.0
* 2014.02.11 신용찬
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event;

import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSPoolSCCReportINVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ees_cgm_1155 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_cgm_1155HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM CHANG SIK
 * @see EES_CGM_1155HTMLAction 참조
 * @since J2EE 1.4 
 */

public class EesCgm1155Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSPoolSCCReportINVO chsPoolSCCReportINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CHSPoolSCCReportINVO[] chsPoolSCCReportINVOS = null;

	public EesCgm1155Event(){}

	public CHSPoolSCCReportINVO getChsPoolSCCReportINVO() {
		return chsPoolSCCReportINVO;
	}

	public void setChsPoolSCCReportINVO(
			CHSPoolSCCReportINVO chsPoolSCCReportINVO) {
		this.chsPoolSCCReportINVO = chsPoolSCCReportINVO;
	}

	public CHSPoolSCCReportINVO[] getChsPoolSCCReportINVOS() {
		return chsPoolSCCReportINVOS;
	}

	public void setChsPoolSCCReportINVOS(
			CHSPoolSCCReportINVO[] chsPoolSCCReportINVOS) {
		this.chsPoolSCCReportINVOS = chsPoolSCCReportINVOS;
	}
	
	
}