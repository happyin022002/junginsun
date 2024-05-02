/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1124Event.java
*@FileTitle : Neutral Pool Payable Charge Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.08.21 김창식
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event;

import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSNuPoolChargeINVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ees_cgm_1124 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_cgm_1124HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM CHANG SIK
 * @see ees_cgm_1124HTMLAction 참조
 * @since J2EE 1.4 
 */

public class EesCgm1124Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSNuPoolChargeINVO chsNuPoolChargeINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CHSNuPoolChargeINVO[] chsNuPoolChargeINVOS = null;

	public CHSNuPoolChargeINVO getChsNuPoolChargeINVO() {
		return chsNuPoolChargeINVO;
	}

	public void setChsNuPoolChargeINVO(CHSNuPoolChargeINVO chsNuPoolChargeINVO) {
		this.chsNuPoolChargeINVO = chsNuPoolChargeINVO;
	}

	public CHSNuPoolChargeINVO[] getChsNuPoolChargeINVOS() {
		CHSNuPoolChargeINVO[] rtnVOs = null;
		if (this.chsNuPoolChargeINVOS != null) {
			rtnVOs = java.util.Arrays.copyOf(chsNuPoolChargeINVOS, chsNuPoolChargeINVOS.length);
		}
		return rtnVOs;
	}

	public void setChsNuPoolChargeINVOS(CHSNuPoolChargeINVO[] chsNuPoolChargeINVOS){
		if(chsNuPoolChargeINVOS != null){
			CHSNuPoolChargeINVO[] tmpVOs = java.util.Arrays.copyOf(chsNuPoolChargeINVOS, chsNuPoolChargeINVOS.length);
			this.chsNuPoolChargeINVOS = tmpVOs;
		}
	}

}