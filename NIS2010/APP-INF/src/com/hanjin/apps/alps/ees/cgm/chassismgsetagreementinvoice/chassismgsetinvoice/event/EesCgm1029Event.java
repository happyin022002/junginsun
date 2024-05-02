/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1029Event.java
*@FileTitle : Leased Chassis Charge Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.07.20 김창식
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSChargeCreationINVO;

/**
 * ees_cgm_1029 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_cgm_1029HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM CHANG SIK
 * @see ees_cgm_1029HTMLAction 참조
 * @since J2EE 1.4 
 */

public class EesCgm1029Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSChargeCreationINVO chsChargeCreationINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CHSChargeCreationINVO[] chsChargeCreationINVOS = null;

	public EesCgm1029Event(){}

	public CHSChargeCreationINVO getChsChargeCreationINVO() {
		return chsChargeCreationINVO;
	}

	public void setChsChargeCreationINVO(CHSChargeCreationINVO chsChargeCreationINVO) {
		this.chsChargeCreationINVO = chsChargeCreationINVO;
	}

	public CHSChargeCreationINVO[] getChsChargeCreationINVOS() {
		return chsChargeCreationINVOS;
	}

	public void setChsChargeCreationINVOS(
			CHSChargeCreationINVO[] chsChargeCreationINVOS) {
		this.chsChargeCreationINVOS = chsChargeCreationINVOS;
	}
	
}