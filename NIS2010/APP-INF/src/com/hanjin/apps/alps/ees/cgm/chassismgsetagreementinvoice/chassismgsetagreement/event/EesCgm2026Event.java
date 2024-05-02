/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm2026Event.java
*@FileTitle : Lease Term Change
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.06.29 김창식
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSTermStatusINVO;


/**
 * ees_cgm_2026 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_cgm_2026HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM CHANG SIK
 * @see ees_cgm_2026HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm2026Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MGSTermStatusINVO mgsTermStatusINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MGSTermStatusINVO[] mgsTermStatusINVOS = null;

	public EesCgm2026Event(){}

	public MGSTermStatusINVO getMgsTermStatusINVO() {
		return mgsTermStatusINVO;
	}

	public void setMgsTermStatusINVO(MGSTermStatusINVO mgsTermStatusINVO) {
		this.mgsTermStatusINVO = mgsTermStatusINVO;
	}

	public MGSTermStatusINVO[] getMgsTermStatusINVOS() {
		return mgsTermStatusINVOS;
	}

	public void setMgsTermStatusINVOS(MGSTermStatusINVO[] mgsTermStatusINVOS) {
		this.mgsTermStatusINVOS = mgsTermStatusINVOS;
	}
	
	
	
}