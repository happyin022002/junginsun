/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0024Event.java
*@FileTitle : FAC Agreement Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.03
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.05.03 김봉균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmagreement.facommagreement.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.acm.acmagreement.facommagreement.vo.FACAgreementVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_ACM_0024 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0024HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Bong-Gyoon
 * @see ESM_ACM_0024HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm0024Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private FACAgreementVO facagreementVO = null;

	/** Table Value Object Multi Data 처리 */
	private FACAgreementVO[] facagreementVOs = null;


	public EsmAcm0024Event() {}


	public FACAgreementVO getFacAgreementVO() {
		return facagreementVO;
	}


	public void setFacAgreementVO(FACAgreementVO facagreementVO) {
		this.facagreementVO = facagreementVO;
	}


	public FACAgreementVO[] getFacAgreementVOs() {
		FACAgreementVO[] rtnVOs = null;
		if (this.facagreementVOs != null) {
			rtnVOs = Arrays.copyOf(facagreementVOs, facagreementVOs.length);
		}
		return rtnVOs;
	}


	public void setFacAgreementVOs(FACAgreementVO[] facagreementVOs) {
		if(facagreementVOs != null){
			FACAgreementVO[] tmpVOs = Arrays.copyOf(facagreementVOs, facagreementVOs.length);
			this.facagreementVOs  = tmpVOs;
		}
	}


}