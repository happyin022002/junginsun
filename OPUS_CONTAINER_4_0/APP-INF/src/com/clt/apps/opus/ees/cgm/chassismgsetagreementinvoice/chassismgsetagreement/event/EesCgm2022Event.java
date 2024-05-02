/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm2022Event.java
*@FileTitle : Lease Agreement List Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.05.26 김창식
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event;

import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSAgreementListINVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ees_cgm_2022 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_cgm_2022HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM CHANG SIK
 * @see ees_cgm_2022HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesCgm2022Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MGSAgreementListINVO mgsAgreementListINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MGSAgreementListINVO[] mgsAgreementListINVOS = null;

	public EesCgm2022Event(){}

	public MGSAgreementListINVO getMgsAgreementListINVO() {
		return mgsAgreementListINVO;
	}

	public void setMgsAgreementListINVO(MGSAgreementListINVO mgsAgreementListINVO) {
		this.mgsAgreementListINVO = mgsAgreementListINVO;
	}

	public MGSAgreementListINVO[] getMgsAgreementListINVOS() {
		MGSAgreementListINVO[] rtnVOs = null;
		if (this.mgsAgreementListINVOS != null) {
			rtnVOs = java.util.Arrays.copyOf(mgsAgreementListINVOS, mgsAgreementListINVOS.length);
		}
		return rtnVOs;
	}

	public void setMgsAgreementListINVOS(MGSAgreementListINVO[] mgsAgreementListINVOS){
		if(mgsAgreementListINVOS != null){
			MGSAgreementListINVO[] tmpVOs = java.util.Arrays.copyOf(mgsAgreementListINVOS, mgsAgreementListINVOS.length);
			this.mgsAgreementListINVOS = tmpVOs;
		}
	}

	
}