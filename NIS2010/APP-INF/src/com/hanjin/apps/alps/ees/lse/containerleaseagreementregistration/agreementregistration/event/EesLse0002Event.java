/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0002Event.java
*@FileTitle : Lease Agreement Version – Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.06.02 노정용
* 1.0 Creation
* 
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementVO;


/**
 * EES_LSE_0002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Nho Jung Yong
 * @see EES_LSE_0002HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0002Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AgreementVO agreementVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public AgreementVO[] agreementVOs = null;

	public EesLse0002Event(){}
	
	public void setAgreementVO(AgreementVO agreementVO){
		this. agreementVO = agreementVO;
	}

	public void setAgreementVOS(AgreementVO[] agreementVOs){
		this. agreementVOs = agreementVOs;
	}

	public AgreementVO getAgreementVO(){
		return agreementVO;
	}

	public AgreementVO[] getAgreementVOS(){
		return agreementVOs;
	}

}