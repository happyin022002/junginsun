/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName 		: EesCgm1220Event.java
*@FileTitle 	: Chassis S/C Exception Inquiry
*Open Issues 	:
*Change history :
*@LastModifyDate: 2014.03.21
*@LastModifier 	: 정운
*@LastVersion 	: 1.0
* 2014.03.21 정운
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event;

import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSScExceptionINVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ees_cgm_1220 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_cgm_1220HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Un Jeong
 * @see EES_CGM_1220HTMLAction 참조
 * @since J2EE 1.4 
 */

public class EesCgm1220Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSScExceptionINVO cHSScExceptionINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CHSScExceptionINVO[] cHSScExceptionINVOS = null;

	public EesCgm1220Event(){}

	public CHSScExceptionINVO getCHSScExceptionINVO() {
		return cHSScExceptionINVO;
	}

	public void setCHSScExceptionINVO(
			CHSScExceptionINVO cHSScExceptionINVO) {
		this.cHSScExceptionINVO = cHSScExceptionINVO;
	}

	public CHSScExceptionINVO[] getCHSScExceptionINVOS() {
		return cHSScExceptionINVOS;
	}
	public void setCHSScExceptionINVOS(
			CHSScExceptionINVO[] cHSScExceptionINVOS) {
		this.cHSScExceptionINVOS = cHSScExceptionINVOS;
	}
	
	
}