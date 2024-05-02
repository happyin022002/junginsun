/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1031Event.java
*@FileTitle : Payable Charge Audit Result & Payable Amount Confirm
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.08.21 김창식
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSConfirmPayableAmountINVO;

/**
 * ees_cgm_1031 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_cgm_1031HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM CHANG SIK
 * @see ees_cgm_1031HTMLAction 참조
 * @since J2EE 1.4 
 */

public class EesCgm1031Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CHSConfirmPayableAmountINVO[] chsConfirmPayableAmountINVOS = null;
	private CHSConfirmPayableAmountINVO[] chsConfirmPayableAmountINVOS1 = null;
	private CHSConfirmPayableAmountINVO[] chsConfirmPayableAmountINVOS2 = null;
	private CHSConfirmPayableAmountINVO[] chsConfirmPayableAmountINVOS3 = null;
	
	public CHSConfirmPayableAmountINVO getChsConfirmPayableAmountINVO() {
		return chsConfirmPayableAmountINVO;
	}

	public void setChsConfirmPayableAmountINVO(
			CHSConfirmPayableAmountINVO chsConfirmPayableAmountINVO) {
		this.chsConfirmPayableAmountINVO = chsConfirmPayableAmountINVO;
	}

	public CHSConfirmPayableAmountINVO[] getChsConfirmPayableAmountINVOS() {
		return chsConfirmPayableAmountINVOS;
	}

	public void setChsConfirmPayableAmountINVOS(
			CHSConfirmPayableAmountINVO[] chsConfirmPayableAmountINVOS) {
		this.chsConfirmPayableAmountINVOS = chsConfirmPayableAmountINVOS;
	}

	public CHSConfirmPayableAmountINVO[] getChsConfirmPayableAmountINVOS1() {
		return chsConfirmPayableAmountINVOS1;
	}

	public void setChsConfirmPayableAmountINVOS1(
			CHSConfirmPayableAmountINVO[] chsConfirmPayableAmountINVOS1) {
		this.chsConfirmPayableAmountINVOS1 = chsConfirmPayableAmountINVOS1;
	}

	public CHSConfirmPayableAmountINVO[] getChsConfirmPayableAmountINVOS2() {
		return chsConfirmPayableAmountINVOS2;
	}

	public void setChsConfirmPayableAmountINVOS2(
			CHSConfirmPayableAmountINVO[] chsConfirmPayableAmountINVOS2) {
		this.chsConfirmPayableAmountINVOS2 = chsConfirmPayableAmountINVOS2;
	}

	public CHSConfirmPayableAmountINVO[] getChsConfirmPayableAmountINVOS3() {
		return chsConfirmPayableAmountINVOS3;
	}

	public void setChsConfirmPayableAmountINVOS3(
			CHSConfirmPayableAmountINVO[] chsConfirmPayableAmountINVOS3) {
		this.chsConfirmPayableAmountINVOS3 = chsConfirmPayableAmountINVOS3;
	}
	
}