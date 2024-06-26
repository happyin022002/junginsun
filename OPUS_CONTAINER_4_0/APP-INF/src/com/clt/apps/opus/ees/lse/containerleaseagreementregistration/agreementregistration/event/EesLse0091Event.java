/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0091Event.java
*@FileTitle : Agreement No. Selection
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.04.28 노정용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.event;

import com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_LSE_0091 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0091HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Nho Jung Yong
 * @see EES_LSE_0091HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesLse0091Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AgreementVO agreementVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private AgreementVO[] agreementVOs = null;

	public EesLse0091Event(){}
	
	public void setAgreementVO(AgreementVO agreementVO){
		this. agreementVO = agreementVO;
	}

	public void setAgreementVOS(AgreementVO[] agreementVOs){
		if (agreementVOs != null) {
			AgreementVO[] tmpVOs = new AgreementVO[agreementVOs.length];
			System.arraycopy(agreementVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.agreementVOs = tmpVOs;
		}
	}

	public AgreementVO getAgreementVO(){
		return agreementVO;
	}

	public AgreementVO[] getAgreementVOS(){
		AgreementVO[] tmpVOs = null;
		if (this.agreementVOs != null) {
			tmpVOs = new AgreementVO[agreementVOs.length];
			System.arraycopy(agreementVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}