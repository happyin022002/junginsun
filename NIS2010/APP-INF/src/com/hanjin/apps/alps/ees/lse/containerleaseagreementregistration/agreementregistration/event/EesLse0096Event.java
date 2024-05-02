/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0001Event.java
*@FileTitle : Lease Agreement Creation & Update
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.05.22 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.event;

import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementRegistrationVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES_LSE_0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Nho Jung Yong
 * @see EES_LSE_0001HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0096Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AgreementRegistrationVO agreementRegistrationVO = null;

	/**
	 * @param agreementRegistrationVO the agreementRegistrationVO to set
	 */
	public void setAgreementRegistrationVO(AgreementRegistrationVO agreementRegistrationVO) {
		this.agreementRegistrationVO = agreementRegistrationVO;
	}

	/**
	 * @return the agreementRegistrationVO
	 */
	public AgreementRegistrationVO getAgreementRegistrationVO() {
		return agreementRegistrationVO;
	}	
}