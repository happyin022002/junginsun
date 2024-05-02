/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0023Event.java
*@FileTitle : FF Compensation Agreement Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.02
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.05.02 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmagreement.ffcmpnagreement.event;

import com.hanjin.apps.alps.esm.acm.acmagreement.ffcmpnagreement.vo.FFAgreementVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_ACM_0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0023HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Young-Oh
 * @see ESM_ACM_0023HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm0023Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private FFAgreementVO ffagreementVO = null;

	/** Table Value Object Multi Data 처리 */
	private FFAgreementVO[] ffagreementVOs = null;


	public EsmAcm0023Event() {}


	public FFAgreementVO getFfagreementVO() {
		return ffagreementVO;
	}


	public void setFfagreementVO(FFAgreementVO ffagreementVO) {
		this.ffagreementVO = ffagreementVO;
	}


	public FFAgreementVO[] getFfagreementVOs() {
		return ffagreementVOs;
	}


	public void setFfagreementVOs(FFAgreementVO[] ffagreementVOs) {
		this.ffagreementVOs = ffagreementVOs;
	}


}