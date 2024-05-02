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
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event;

import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSConfirmPayableAmountINVO;
import com.clt.framework.support.layer.event.EventSupport;

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
		CHSConfirmPayableAmountINVO[] rtnVOs = null;
		if (this.chsConfirmPayableAmountINVOS != null) {
			rtnVOs = java.util.Arrays.copyOf(chsConfirmPayableAmountINVOS, chsConfirmPayableAmountINVOS.length);
		}
		return rtnVOs;
	}

	public void setChsConfirmPayableAmountINVOS(CHSConfirmPayableAmountINVO[] chsConfirmPayableAmountINVOS){
		if(chsConfirmPayableAmountINVOS != null){
			CHSConfirmPayableAmountINVO[] tmpVOs = java.util.Arrays.copyOf(chsConfirmPayableAmountINVOS, chsConfirmPayableAmountINVOS.length);
			this.chsConfirmPayableAmountINVOS = tmpVOs;
		}
	}

	public CHSConfirmPayableAmountINVO[] getChsConfirmPayableAmountINVOS1() {
		CHSConfirmPayableAmountINVO[] rtnVOs = null;
		if (this.chsConfirmPayableAmountINVOS1 != null) {
			rtnVOs = java.util.Arrays.copyOf(chsConfirmPayableAmountINVOS1, chsConfirmPayableAmountINVOS1.length);
		}
		return rtnVOs;
	}

	public void setChsConfirmPayableAmountINVOS1(CHSConfirmPayableAmountINVO[] chsConfirmPayableAmountINVOS1){
		if(chsConfirmPayableAmountINVOS1 != null){
			CHSConfirmPayableAmountINVO[] tmpVOs = java.util.Arrays.copyOf(chsConfirmPayableAmountINVOS1, chsConfirmPayableAmountINVOS1.length);
			this.chsConfirmPayableAmountINVOS1 = tmpVOs;
		}
	}

	public CHSConfirmPayableAmountINVO[] getChsConfirmPayableAmountINVOS2() {
		CHSConfirmPayableAmountINVO[] rtnVOs = null;
		if (this.chsConfirmPayableAmountINVOS2 != null) {
			rtnVOs = java.util.Arrays.copyOf(chsConfirmPayableAmountINVOS2, chsConfirmPayableAmountINVOS2.length);
		}
		return rtnVOs;
	}

	public void setChsConfirmPayableAmountINVOS2(CHSConfirmPayableAmountINVO[] chsConfirmPayableAmountINVOS2){
		if(chsConfirmPayableAmountINVOS2 != null){
			CHSConfirmPayableAmountINVO[] tmpVOs = java.util.Arrays.copyOf(chsConfirmPayableAmountINVOS2, chsConfirmPayableAmountINVOS2.length);
			this.chsConfirmPayableAmountINVOS2 = tmpVOs;
		}
	}

	public CHSConfirmPayableAmountINVO[] getChsConfirmPayableAmountINVOS3() {
		CHSConfirmPayableAmountINVO[] rtnVOs = null;
		if (this.chsConfirmPayableAmountINVOS3 != null) {
			rtnVOs = java.util.Arrays.copyOf(chsConfirmPayableAmountINVOS3, chsConfirmPayableAmountINVOS3.length);
		}
		return rtnVOs;
	}

	public void setChsConfirmPayableAmountINVOS3(CHSConfirmPayableAmountINVO[] chsConfirmPayableAmountINVOS3){
		if(chsConfirmPayableAmountINVOS3 != null){
			CHSConfirmPayableAmountINVO[] tmpVOs = java.util.Arrays.copyOf(chsConfirmPayableAmountINVOS3, chsConfirmPayableAmountINVOS3.length);
			this.chsConfirmPayableAmountINVOS3 = tmpVOs;
		}
	}
	
}