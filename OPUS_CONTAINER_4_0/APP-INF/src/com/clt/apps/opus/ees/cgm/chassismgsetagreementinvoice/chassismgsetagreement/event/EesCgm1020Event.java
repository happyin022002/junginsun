/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm102001Event.java
*@FileTitle : Lease Agreement Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.05.26 김창식
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event;

import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSAgreementINVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ees_cgm_1020_01 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_cgm_1020_01HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM CHANG SIK
 * @see ees_cgm_1020_01HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1020Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSAgreementINVO chsAgreementINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CHSAgreementINVO[] chsAgreementINVOS = null;
	private CHSAgreementINVO[] chsAgreementINVOS1 = null;
	private CHSAgreementINVO[] chsAgreementINVOS2 = null;
	private CHSAgreementINVO[] chsAgreementINVOS3 = null;
	private CHSAgreementINVO[] chsAgreementINVOS4 = null;
	private CHSAgreementINVO[] chsAgreementINVOS5 = null;

	public EesCgm1020Event(){}

	public CHSAgreementINVO getChsAgreementINVO() {
		return chsAgreementINVO;
	}

	public void setChsAgreementINVO(CHSAgreementINVO chsAgreementINVO) {
		this.chsAgreementINVO = chsAgreementINVO;
	}

	public CHSAgreementINVO[] getChsAgreementINVOS() {
		CHSAgreementINVO[] rtnVOs = null;
		if (this.chsAgreementINVOS != null) {
			rtnVOs = java.util.Arrays.copyOf(chsAgreementINVOS, chsAgreementINVOS.length);
		}
		return rtnVOs;
	}

	public void setChsAgreementINVOS(CHSAgreementINVO[] chsAgreementINVOS){
		if(chsAgreementINVOS != null){
			CHSAgreementINVO[] tmpVOs = java.util.Arrays.copyOf(chsAgreementINVOS, chsAgreementINVOS.length);
			this.chsAgreementINVOS = tmpVOs;
		}
	}

	public CHSAgreementINVO[] getChsAgreementINVOS1() {
		CHSAgreementINVO[] rtnVOs = null;
		if (this.chsAgreementINVOS1 != null) {
			rtnVOs = java.util.Arrays.copyOf(chsAgreementINVOS1, chsAgreementINVOS1.length);
		}
		return rtnVOs;
	}

	public void setChsAgreementINVOS1(CHSAgreementINVO[] chsAgreementINVOS1){
		if(chsAgreementINVOS1 != null){
			CHSAgreementINVO[] tmpVOs = java.util.Arrays.copyOf(chsAgreementINVOS1, chsAgreementINVOS1.length);
			this.chsAgreementINVOS1 = tmpVOs;
		}
	}

	public CHSAgreementINVO[] getChsAgreementINVOS2() {
		CHSAgreementINVO[] rtnVOs = null;
		if (this.chsAgreementINVOS2 != null) {
			rtnVOs = java.util.Arrays.copyOf(chsAgreementINVOS2, chsAgreementINVOS2.length);
		}
		return rtnVOs;
	}

	public void setChsAgreementINVOS2(CHSAgreementINVO[] chsAgreementINVOS2){
		if(chsAgreementINVOS2 != null){
			CHSAgreementINVO[] tmpVOs = java.util.Arrays.copyOf(chsAgreementINVOS2, chsAgreementINVOS2.length);
			this.chsAgreementINVOS2 = tmpVOs;
		}
	}

	public CHSAgreementINVO[] getChsAgreementINVOS3() {
		CHSAgreementINVO[] rtnVOs = null;
		if (this.chsAgreementINVOS3 != null) {
			rtnVOs = java.util.Arrays.copyOf(chsAgreementINVOS3, chsAgreementINVOS3.length);
		}
		return rtnVOs;
	}

	public void setChsAgreementINVOS3(CHSAgreementINVO[] chsAgreementINVOS3){
		if(chsAgreementINVOS3 != null){
			CHSAgreementINVO[] tmpVOs = java.util.Arrays.copyOf(chsAgreementINVOS3, chsAgreementINVOS3.length);
			this.chsAgreementINVOS3 = tmpVOs;
		}
	}

	public CHSAgreementINVO[] getChsAgreementINVOS4() {
		CHSAgreementINVO[] rtnVOs = null;
		if (this.chsAgreementINVOS4 != null) {
			rtnVOs = java.util.Arrays.copyOf(chsAgreementINVOS4, chsAgreementINVOS4.length);
		}
		return rtnVOs;
	}

	public void setChsAgreementINVOS4(CHSAgreementINVO[] chsAgreementINVOS4){
		if(chsAgreementINVOS4 != null){
			CHSAgreementINVO[] tmpVOs = java.util.Arrays.copyOf(chsAgreementINVOS4, chsAgreementINVOS4.length);
			this.chsAgreementINVOS4 = tmpVOs;
		}
	}

	public CHSAgreementINVO[] getChsAgreementINVOS5() {
		CHSAgreementINVO[] rtnVOs = null;
		if (this.chsAgreementINVOS5 != null) {
			rtnVOs = java.util.Arrays.copyOf(chsAgreementINVOS5, chsAgreementINVOS5.length);
		}
		return rtnVOs;
	}

	public void setChsAgreementINVOS5(CHSAgreementINVO[] chsAgreementINVOS5){
		if(chsAgreementINVOS5 != null){
			CHSAgreementINVO[] tmpVOs = java.util.Arrays.copyOf(chsAgreementINVOS5, chsAgreementINVOS5.length);
			this.chsAgreementINVOS5 = tmpVOs;
		}
	}

	
	
}