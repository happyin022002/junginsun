/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0025Event.java
*@FileTitle : Compensation Agreement Rate Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.02
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.05.02 김영오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmagreement.spclcmpnagreement.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.acm.acmagreement.spclcmpnagreement.vo.SCompAgreementVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_ACM_0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0025HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Young-Oh
 * @see ESM_ACM_0025HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm0025Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SCompAgreementVO scompAgreementVO = null;

	/** Table Value Object Multi Data 처리 */
	private SCompAgreementVO[] scompAgreementVOs = null;


	public EsmAcm0025Event() {}


	public SCompAgreementVO getScompAgreementVO() {
		return scompAgreementVO;
	}


	public void setScompAgreementVO(SCompAgreementVO scompAgreementVO) {
		this.scompAgreementVO = scompAgreementVO;
	}


	public SCompAgreementVO[] getScompAgreementVOs() {
		SCompAgreementVO[] rtnVOs = null;
		if (this.scompAgreementVOs != null) {
			rtnVOs = Arrays.copyOf(scompAgreementVOs, scompAgreementVOs.length);
		}
		return rtnVOs;
	}


	public void setScompAgreementVOs(SCompAgreementVO[] scompAgreementVOs) {
		if(scompAgreementVOs != null){
			SCompAgreementVO[] tmpVOs = Arrays.copyOf(scompAgreementVOs, scompAgreementVOs.length);
			this.scompAgreementVOs  = tmpVOs;
		}
	}


}