/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1021Event.java
*@FileTitle : Lease Agreement List Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.05.19 김창식
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event;

import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSAgreementListINVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ees_cgm_1021 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_cgm_1021HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM CHANG SIK
 * @see ees_cgm_1021HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesCgm1021Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSAgreementListINVO chsAgreementListINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CHSAgreementListINVO[] chsAgreementListINVOS = null;

	public EesCgm1021Event(){}

	public CHSAgreementListINVO getChsAgreementListINVO() {
		return chsAgreementListINVO;
	}

	public void setChsAgreementListINVO(CHSAgreementListINVO chsAgreementListINVO) {
		this.chsAgreementListINVO = chsAgreementListINVO;
	}

	public CHSAgreementListINVO[] getChsAgreementListINVOS() {
		CHSAgreementListINVO[] rtnVOs = null;
		if (this.chsAgreementListINVOS != null) {
			rtnVOs = java.util.Arrays.copyOf(chsAgreementListINVOS, chsAgreementListINVOS.length);
		}
		return rtnVOs;
	}

	public void setChsAgreementListINVOS(CHSAgreementListINVO[] chsAgreementListINVOS){
		if(chsAgreementListINVOS != null){
			CHSAgreementListINVO[] tmpVOs = java.util.Arrays.copyOf(chsAgreementListINVOS, chsAgreementListINVOS.length);
			this.chsAgreementListINVOS = tmpVOs;
		}
	}
}