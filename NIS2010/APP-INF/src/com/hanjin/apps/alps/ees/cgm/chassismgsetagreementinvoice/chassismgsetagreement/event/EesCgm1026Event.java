/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1026Event.java
*@FileTitle : Lease Term Change
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.06.22 김창식
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSTermStatusINVO;


/**
 * ees_cgm_1026 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_cgm_1026HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM CHANG SIK
 * @see ees_cgm_1026HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1026Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSTermStatusINVO chsTermStatusINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CHSTermStatusINVO[] chsTermStatusINVOS = null;

	public EesCgm1026Event(){}

	public CHSTermStatusINVO getChsTermStatusINVO() {
		return chsTermStatusINVO;
	}

	public void setChsTermStatusINVO(CHSTermStatusINVO chsTermStatusINVO) {
		this.chsTermStatusINVO = chsTermStatusINVO;
	}

	public CHSTermStatusINVO[] getChsTermStatusINVOS() {
		return chsTermStatusINVOS;
	}

	public void setChsTermStatusINVOS(CHSTermStatusINVO[] chsTermStatusINVOS) {
		this.chsTermStatusINVOS = chsTermStatusINVOS;
	}
	
	

}