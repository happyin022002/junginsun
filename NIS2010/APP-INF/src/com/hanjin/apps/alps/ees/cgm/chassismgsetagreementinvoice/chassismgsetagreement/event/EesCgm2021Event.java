/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm2021Event.java
*@FileTitle : Lease Agreement Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.06.10 김창식
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSAgreementINVO;


/**
 * ees_cgm_2021 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_cgm_2021HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM CHANG SIK
 * @see ees_cgm_2021HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm2021Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MGSAgreementINVO mgsAgreementINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MGSAgreementINVO[] mgsAgreementINVOS = null;

	public EesCgm2021Event(){}

	public MGSAgreementINVO getMgsAgreementINVO() {
		return mgsAgreementINVO;
	}

	public void setMgsAgreementINVO(MGSAgreementINVO mgsAgreementINVO) {
		this.mgsAgreementINVO = mgsAgreementINVO;
	}

	public MGSAgreementINVO[] getMgsAgreementINVOS() {
		return mgsAgreementINVOS;
	}

	public void setMgsAgreementINVOS(MGSAgreementINVO[] mgsAgreementINVOS) {
		this.mgsAgreementINVOS = mgsAgreementINVOS;
	}
	
	
}