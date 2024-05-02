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
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSAgreementINVO;


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
		return chsAgreementINVOS;
	}

	public void setChsAgreementINVOS(CHSAgreementINVO[] chsAgreementINVOS) {
		this.chsAgreementINVOS = chsAgreementINVOS;
	}

	public CHSAgreementINVO[] getChsAgreementINVOS1() {
		return chsAgreementINVOS1;
	}

	public void setChsAgreementINVOS1(CHSAgreementINVO[] chsAgreementINVOS1) {
		this.chsAgreementINVOS1 = chsAgreementINVOS1;
	}

	public CHSAgreementINVO[] getChsAgreementINVOS2() {
		return chsAgreementINVOS2;
	}

	public void setChsAgreementINVOS2(CHSAgreementINVO[] chsAgreementINVOS2) {
		this.chsAgreementINVOS2 = chsAgreementINVOS2;
	}

	public CHSAgreementINVO[] getChsAgreementINVOS3() {
		return chsAgreementINVOS3;
	}

	public void setChsAgreementINVOS3(CHSAgreementINVO[] chsAgreementINVOS3) {
		this.chsAgreementINVOS3 = chsAgreementINVOS3;
	}

	public CHSAgreementINVO[] getChsAgreementINVOS4() {
		return chsAgreementINVOS4;
	}

	public void setChsAgreementINVOS4(CHSAgreementINVO[] chsAgreementINVOS4) {
		this.chsAgreementINVOS4 = chsAgreementINVOS4;
	}

	public CHSAgreementINVO[] getChsAgreementINVOS5() {
		return chsAgreementINVOS5;
	}

	public void setChsAgreementINVOS5(CHSAgreementINVO[] chsAgreementINVOS5) {
		this.chsAgreementINVOS5 = chsAgreementINVOS5;
	}

	
	
}