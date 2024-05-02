/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1118Event.java
*@FileTitle : Lease Term Change Summary Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.06.30 김창식
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSTermChangeResultINVO;

/**
 * ees_cgm_1118 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_cgm_1118HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM CHANG SIK
 * @see ees_cgm_1118HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1118Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSTermChangeResultINVO chsTermChangeResultINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CHSTermChangeResultINVO[] chsTermChangeResultINVOS = null;

	public EesCgm1118Event(){}

	public CHSTermChangeResultINVO getChsTermChangeResultINVO() {
		return chsTermChangeResultINVO;
	}

	public void setChsTermChangeResultINVO(
			CHSTermChangeResultINVO chsTermChangeResultINVO) {
		this.chsTermChangeResultINVO = chsTermChangeResultINVO;
	}

	public CHSTermChangeResultINVO[] getChsTermChangeResultINVOS() {
		return chsTermChangeResultINVOS;
	}

	public void setChsTermChangeResultINVOS(
			CHSTermChangeResultINVO[] chsTermChangeResultINVOS) {
		this.chsTermChangeResultINVOS = chsTermChangeResultINVOS;
	}
}