/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EES_CGM_1202HTMLAction.java
*@FileTitle : EES_CGM_1202
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.15
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2013.03.15 이영헌
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event;

import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSCpsAgreementINVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_1202 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1202HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author LEE YOUNG HEON
 * @see EES_CGM_1202HTMLAction 참조
 * @since J2EE 1.4 
 */

public class EesCgm1202Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSCpsAgreementINVO chsCpsAgreementINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CHSCpsAgreementINVO[] chsCpsAgreementINVOS = null;
	private CHSCpsAgreementINVO[] chsCpsAgreementINVOS1 = null;
	private CHSCpsAgreementINVO[] chsCpsAgreementINVOS2 = null;
	private CHSCpsAgreementINVO[] chsCpsAgreementINVOS3 = null;

	public EesCgm1202Event(){}

	public CHSCpsAgreementINVO getChsCpsAgreementINVO() {
		return chsCpsAgreementINVO;
	}

	public void setChsCpsAgreementINVO(CHSCpsAgreementINVO chsCpsAgreementINVO) {
		this.chsCpsAgreementINVO = chsCpsAgreementINVO;
	}

	public CHSCpsAgreementINVO[] getChsCpsAgreementINVOS() {
		return chsCpsAgreementINVOS;
	}

	public void setChsCpsAgreementINVOS(CHSCpsAgreementINVO[] chsCpsAgreementINVOS) {
		this.chsCpsAgreementINVOS = chsCpsAgreementINVOS;
	}

	public CHSCpsAgreementINVO[] getChsCpsAgreementINVOS1() {
		return chsCpsAgreementINVOS1;
	}

	public void setChsCpsAgreementINVOS1(CHSCpsAgreementINVO[] chsCpsAgreementINVOS1) {
		this.chsCpsAgreementINVOS1 = chsCpsAgreementINVOS1;
	}

	public CHSCpsAgreementINVO[] getChsCpsAgreementINVOS2() {
		return chsCpsAgreementINVOS2;
	}

	public void setChsCpsAgreementINVOS2(CHSCpsAgreementINVO[] chsCpsAgreementINVOS2) {
		this.chsCpsAgreementINVOS2 = chsCpsAgreementINVOS2;
	}

	public CHSCpsAgreementINVO[] getChsCpsAgreementINVOS3() {
		return chsCpsAgreementINVOS3;
	}

	public void setChsCpsAgreementINVOS3(CHSCpsAgreementINVO[] chsCpsAgreementINVOS3) {
		this.chsCpsAgreementINVOS3 = chsCpsAgreementINVOS3;
	}
}