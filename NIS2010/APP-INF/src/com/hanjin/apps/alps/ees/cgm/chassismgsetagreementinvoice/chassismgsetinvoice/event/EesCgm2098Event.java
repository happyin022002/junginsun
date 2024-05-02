/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1098Event.java
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
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSConfirmPayableAmountINVO;

/**
 * ees_cgm_1098 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_cgm_1098HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM CHANG SIK
 * @see ees_cgm_1098HTMLAction 참조
 * @since J2EE 1.4 
 */

public class EesCgm2098Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MGSConfirmPayableAmountINVO mgsConfirmPayableAmountINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MGSConfirmPayableAmountINVO[] mgsConfirmPayableAmountINVOS = null;
	private MGSConfirmPayableAmountINVO[] mgsConfirmPayableAmountINVOS1 = null;
	private MGSConfirmPayableAmountINVO[] mgsConfirmPayableAmountINVOS2 = null;
	private MGSConfirmPayableAmountINVO[] mgsConfirmPayableAmountINVOS3 = null;

	public MGSConfirmPayableAmountINVO getMgsConfirmPayableAmountINVO() {
		return mgsConfirmPayableAmountINVO;
	}

	public void setMgsConfirmPayableAmountINVO(
			MGSConfirmPayableAmountINVO mgsConfirmPayableAmountINVO) {
		this.mgsConfirmPayableAmountINVO = mgsConfirmPayableAmountINVO;
	}

	public MGSConfirmPayableAmountINVO[] getMgsConfirmPayableAmountINVOS() {
		return mgsConfirmPayableAmountINVOS;
	}

	public void setMgsConfirmPayableAmountINVOS(
			MGSConfirmPayableAmountINVO[] mgsConfirmPayableAmountINVOS) {
		this.mgsConfirmPayableAmountINVOS = mgsConfirmPayableAmountINVOS;
	}

	public MGSConfirmPayableAmountINVO[] getMgsConfirmPayableAmountINVOS1() {
		return mgsConfirmPayableAmountINVOS1;
	}

	public void setMgsConfirmPayableAmountINVOS1(
			MGSConfirmPayableAmountINVO[] mgsConfirmPayableAmountINVOS1) {
		this.mgsConfirmPayableAmountINVOS1 = mgsConfirmPayableAmountINVOS1;
	}

	public MGSConfirmPayableAmountINVO[] getMgsConfirmPayableAmountINVOS2() {
		return mgsConfirmPayableAmountINVOS2;
	}

	public void setMgsConfirmPayableAmountINVOS2(
			MGSConfirmPayableAmountINVO[] mgsConfirmPayableAmountINVOS2) {
		this.mgsConfirmPayableAmountINVOS2 = mgsConfirmPayableAmountINVOS2;
	}

	public MGSConfirmPayableAmountINVO[] getMgsConfirmPayableAmountINVOS3() {
		return mgsConfirmPayableAmountINVOS3;
	}

	public void setMgsConfirmPayableAmountINVOS3(
			MGSConfirmPayableAmountINVO[] mgsConfirmPayableAmountINVOS3) {
		this.mgsConfirmPayableAmountINVOS3 = mgsConfirmPayableAmountINVOS3;
	}
	
	
}