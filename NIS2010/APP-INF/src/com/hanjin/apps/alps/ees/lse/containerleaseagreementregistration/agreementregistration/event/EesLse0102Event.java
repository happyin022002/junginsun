/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EesLse0102Event.java
*@FileTitle : Interest calculation
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.09
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2011.03.09 박명신
* 1.0 Creation
* 
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.event;

import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.vo.InInterrstServiceVO;
import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.vo.InterrstServiceVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES_LSE_0102 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0102HTMLAction 에서 작성<br>	
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *	
 * @author myoung sin park	
 * @see EES_LSE_0102HTMLAction 참조
 * @since J2EE 1.4
 */	

public class EesLse0102Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private InInterrstServiceVO inInterrstServiceVO = null;
	
	public InterrstServiceVO[] interrstServiceVOS = null;
	
	public InInterrstServiceVO getInInterrstServiceVO() {
		return inInterrstServiceVO;
	}

	public void setInInterrstServiceVO(InInterrstServiceVO inInterrstServiceVO) {
		this.inInterrstServiceVO = inInterrstServiceVO;
	}

	public InterrstServiceVO[] getInterrstServiceVOS() {
		return interrstServiceVOS;
	}

	public void setInterrstServiceVOS(InterrstServiceVO[] interrstServiceVOS) {
		this.interrstServiceVOS = interrstServiceVOS;
	}
}