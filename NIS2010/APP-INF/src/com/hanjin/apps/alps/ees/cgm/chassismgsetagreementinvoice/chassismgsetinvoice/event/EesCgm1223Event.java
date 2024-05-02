/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EesCgm1223Event.java
*@FileTitle : COPS Co-Op Pool Payable Charge Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.19
*@LastModifier : Chang Young Kim
*@LastVersion : 1.0
* 2014.11.19 Chang Young Kim
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCoPoolChargeINVO;

/**
 * ees_cgm_1223 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_cgm_1223HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM CHANG SIK
 * @see ees_cgm_1223HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesCgm1223Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSCoPoolChargeINVO chsCoPoolChargeINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CHSCoPoolChargeINVO[] chsCoPoolChargeINVOS = null;

	public EesCgm1223Event(){}

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