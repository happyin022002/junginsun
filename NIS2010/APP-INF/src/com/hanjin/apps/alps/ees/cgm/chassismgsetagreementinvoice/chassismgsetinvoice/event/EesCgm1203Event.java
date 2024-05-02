/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1203Event.java
*@FileTitle : CPS Payable Charge Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.11
*@LastModifier : 조경완
*@LastVersion : 1.0
* 2013.03.11 조경완 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event;

import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSChargeCreationINVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ees_cgm_1203 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_cgm_1203HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHO KYOUNG WAN
 * @see ees_cgm_1203HTMLAction 참조
 * @since J2EE 1.4 
 */

public class EesCgm1203Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSChargeCreationINVO chsChargeCreationINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CHSChargeCreationINVO[] chsChargeCreationINVOS = null;

	public EesCgm1203Event(){}

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