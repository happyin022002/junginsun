/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1028Event.java
*@FileTitle : Agreement Matching
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.29
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.04.29 김창식
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSLessorAgmtMatchingINVO;


/**
 * ees_cgm_1028 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_cgm_1028HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM CHANG SIK
 * @see ees_cgm_1028HTMLAction 참조
 * @since J2EE 1.4 
 */

public class EesCgm1028Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSLessorAgmtMatchingINVO chsLessorAgmtMatchingINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CHSLessorAgmtMatchingINVO[] chsLessorAgmtMatchingINVOS = null;

	public EesCgm1028Event(){}

	public CHSLessorAgmtMatchingINVO getChsLessorAgmtMatchingINVO() {
		return chsLessorAgmtMatchingINVO;
	}

	public void setChsLessorAgmtMatchingINVO(
			CHSLessorAgmtMatchingINVO chsLessorAgmtMatchingINVO) {
		this.chsLessorAgmtMatchingINVO = chsLessorAgmtMatchingINVO;
	}

	public CHSLessorAgmtMatchingINVO[] getChsLessorAgmtMatchingINVOS() {
		return chsLessorAgmtMatchingINVOS;
	}

	public void setChsLessorAgmtMatchingINVOS(
			CHSLessorAgmtMatchingINVO[] chsLessorAgmtMatchingINVOS) {
		this.chsLessorAgmtMatchingINVOS = chsLessorAgmtMatchingINVOS;
	}
	
	
}