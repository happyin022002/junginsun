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
package com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.event;

import com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementRegistrationVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EES_LSE_0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Nho Jung Yong
 * @see EES_LSE_0001HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0001Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Agreement City Code */
	private String agmtCtyCd  = "";

	/** Agreement Sequence */
	private String agmtSeq    = "";

	/** Agreement Version Sequence */
	private String agmtVerSeq = "";

	/** Table Value Object 조회 조건 및 단건 처리  */
	private AgreementRegistrationVO agreementRegistrationVO = null;

	public EesLse0001Event(){}

	public void setAgreementRegistrationVO(AgreementRegistrationVO agreementRegistrationVO) {
		this.agreementRegistrationVO = agreementRegistrationVO;
	}

	public AgreementRegistrationVO getAgreementRegistrationVO() {
		return agreementRegistrationVO;
	}

	public void setAgmtCtyCd(String agmtCtyCd) {
		this.agmtCtyCd = agmtCtyCd;
	}

	public String getAgmtCtyCd() {
		return agmtCtyCd;
	}

	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}

	public String getAgmtSeq() {
		return agmtSeq;
	}

	public void setAgmtVerSeq(String agmtVerSeq) {
		this.agmtVerSeq = agmtVerSeq;
	}

	public String getAgmtVerSeq() {
		return agmtVerSeq;
	}
}