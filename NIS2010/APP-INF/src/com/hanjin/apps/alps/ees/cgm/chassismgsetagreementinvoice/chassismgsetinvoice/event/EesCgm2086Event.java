/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm2086Event.java
*@FileTitle : Agreement Matching
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.07.06 김창식
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSLessorAgmtMatchingINVO;

/**
 * ees_cgm_2086 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_cgm_2086HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM CHANG SIK
 * @see ees_cgm_2086HTMLAction 참조
 * @since J2EE 1.4 
 */

public class EesCgm2086Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MGSLessorAgmtMatchingINVO mgsLessorAgmtMatchingINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MGSLessorAgmtMatchingINVO[] mgsLessorAgmtMatchingINVOS = null;

	public EesCgm2086Event(){}

	public MGSLessorAgmtMatchingINVO getMgsLessorAgmtMatchingINVO() {
		return mgsLessorAgmtMatchingINVO;
	}

	public void setMgsLessorAgmtMatchingINVO(
			MGSLessorAgmtMatchingINVO mgsLessorAgmtMatchingINVO) {
		this.mgsLessorAgmtMatchingINVO = mgsLessorAgmtMatchingINVO;
	}

	public MGSLessorAgmtMatchingINVO[] getMgsLessorAgmtMatchingINVOS() {
		return mgsLessorAgmtMatchingINVOS;
	}

	public void setMgsLessorAgmtMatchingINVOS(
			MGSLessorAgmtMatchingINVO[] mgsLessorAgmtMatchingINVOS) {
		this.mgsLessorAgmtMatchingINVOS = mgsLessorAgmtMatchingINVOS;
	}

	
}