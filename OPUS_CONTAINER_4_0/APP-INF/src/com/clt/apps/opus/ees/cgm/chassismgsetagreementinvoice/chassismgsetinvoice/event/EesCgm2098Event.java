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
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event;

import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSConfirmPayableAmountINVO;
import com.clt.framework.support.layer.event.EventSupport;

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
		MGSConfirmPayableAmountINVO[] rtnVOs = null;
		if (this.mgsConfirmPayableAmountINVOS != null) {
			rtnVOs = java.util.Arrays.copyOf(mgsConfirmPayableAmountINVOS, mgsConfirmPayableAmountINVOS.length);
		}
		return rtnVOs;
	}

	public void setMgsConfirmPayableAmountINVOS(MGSConfirmPayableAmountINVO[] mgsConfirmPayableAmountINVOS){
		if(mgsConfirmPayableAmountINVOS != null){
			MGSConfirmPayableAmountINVO[] tmpVOs = java.util.Arrays.copyOf(mgsConfirmPayableAmountINVOS, mgsConfirmPayableAmountINVOS.length);
			this.mgsConfirmPayableAmountINVOS = tmpVOs;
		}
	}

	public MGSConfirmPayableAmountINVO[] getMgsConfirmPayableAmountINVOS1() {
		MGSConfirmPayableAmountINVO[] rtnVOs = null;
		if (this.mgsConfirmPayableAmountINVOS1 != null) {
			rtnVOs = java.util.Arrays.copyOf(mgsConfirmPayableAmountINVOS1, mgsConfirmPayableAmountINVOS1.length);
		}
		return rtnVOs;
	}

	public void setMgsConfirmPayableAmountINVOS1(MGSConfirmPayableAmountINVO[] mgsConfirmPayableAmountINVOS1){
		if(mgsConfirmPayableAmountINVOS1 != null){
			MGSConfirmPayableAmountINVO[] tmpVOs = java.util.Arrays.copyOf(mgsConfirmPayableAmountINVOS1, mgsConfirmPayableAmountINVOS1.length);
			this.mgsConfirmPayableAmountINVOS1 = tmpVOs;
		}
	}

	public MGSConfirmPayableAmountINVO[] getMgsConfirmPayableAmountINVOS2() {
		MGSConfirmPayableAmountINVO[] rtnVOs = null;
		if (this.mgsConfirmPayableAmountINVOS2 != null) {
			rtnVOs = java.util.Arrays.copyOf(mgsConfirmPayableAmountINVOS2, mgsConfirmPayableAmountINVOS2.length);
		}
		return rtnVOs;
	}

	public void setMgsConfirmPayableAmountINVOS2(MGSConfirmPayableAmountINVO[] mgsConfirmPayableAmountINVOS2){
		if(mgsConfirmPayableAmountINVOS2 != null){
			MGSConfirmPayableAmountINVO[] tmpVOs = java.util.Arrays.copyOf(mgsConfirmPayableAmountINVOS2, mgsConfirmPayableAmountINVOS2.length);
			this.mgsConfirmPayableAmountINVOS2 = tmpVOs;
		}
	}

	public MGSConfirmPayableAmountINVO[] getMgsConfirmPayableAmountINVOS3() {
		MGSConfirmPayableAmountINVO[] rtnVOs = null;
		if (this.mgsConfirmPayableAmountINVOS3 != null) {
			rtnVOs = java.util.Arrays.copyOf(mgsConfirmPayableAmountINVOS3, mgsConfirmPayableAmountINVOS3.length);
		}
		return rtnVOs;
	}

	public void setMgsConfirmPayableAmountINVOS3(MGSConfirmPayableAmountINVO[] mgsConfirmPayableAmountINVOS3){
		if(mgsConfirmPayableAmountINVOS3 != null){
			MGSConfirmPayableAmountINVO[] tmpVOs = java.util.Arrays.copyOf(mgsConfirmPayableAmountINVOS3, mgsConfirmPayableAmountINVOS3.length);
			this.mgsConfirmPayableAmountINVOS3 = tmpVOs;
		}
	}
	
	
}