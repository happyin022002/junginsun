/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm2028Event.java
*@FileTitle : Lease Term Change Summary Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.07.03 김창식
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event;

import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSTermChangeResultINVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ees_cgm_1118 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_cgm_1118HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM CHANG SIK
 * @see ees_cgm_1118HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm2028Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MGSTermChangeResultINVO mgsTermChangeResultINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MGSTermChangeResultINVO[] mgsTermChangeResultINVOS = null;

	public EesCgm2028Event(){}

	public MGSTermChangeResultINVO getMgsTermChangeResultINVO() {
		return mgsTermChangeResultINVO;
	}

	public void setMgsTermChangeResultINVO(
			MGSTermChangeResultINVO mgsTermChangeResultINVO) {
		this.mgsTermChangeResultINVO = mgsTermChangeResultINVO;
	}

	public MGSTermChangeResultINVO[] getMgsTermChangeResultINVOS() {
		MGSTermChangeResultINVO[] rtnVOs = null;
		if (this.mgsTermChangeResultINVOS != null) {
			rtnVOs = java.util.Arrays.copyOf(mgsTermChangeResultINVOS, mgsTermChangeResultINVOS.length);
		}
		return rtnVOs;
	}

	public void setMgsTermChangeResultINVOS(MGSTermChangeResultINVO[] mgsTermChangeResultINVOS){
		if(mgsTermChangeResultINVOS != null){
			MGSTermChangeResultINVO[] tmpVOs = java.util.Arrays.copyOf(mgsTermChangeResultINVOS, mgsTermChangeResultINVOS.length);
			this.mgsTermChangeResultINVOS = tmpVOs;
		}
	}

	
}