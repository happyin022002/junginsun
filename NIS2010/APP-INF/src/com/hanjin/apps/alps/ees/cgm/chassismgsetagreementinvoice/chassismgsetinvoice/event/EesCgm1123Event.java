/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1123Event.java
*@FileTitle : Co-Op Pool Payable Charge Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.08
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.05.08 김창식
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCoPoolChargeINVO;

/**
 * ees_cgm_1123 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_cgm_1123HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM CHANG SIK
 * @see ees_cgm_1123HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesCgm1123Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSCoPoolChargeINVO chsCoPoolChargeINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CHSCoPoolChargeINVO[] chsCoPoolChargeINVOS = null;

	public EesCgm1123Event(){}

	public CHSCoPoolChargeINVO getChsCoPoolChargeINVO() {
		return chsCoPoolChargeINVO;
	}

	public void setChsCoPoolChargeINVO(CHSCoPoolChargeINVO chsCoPoolChargeINVO) {
		this.chsCoPoolChargeINVO = chsCoPoolChargeINVO;
	}

	public CHSCoPoolChargeINVO[] getChsCoPoolChargeINVOS() {
		return chsCoPoolChargeINVOS;
	}

	public void setChsCoPoolChargeINVOS(CHSCoPoolChargeINVO[] chsCoPoolChargeINVOS) {
		this.chsCoPoolChargeINVOS = chsCoPoolChargeINVOS;
	}
	
	
	
}