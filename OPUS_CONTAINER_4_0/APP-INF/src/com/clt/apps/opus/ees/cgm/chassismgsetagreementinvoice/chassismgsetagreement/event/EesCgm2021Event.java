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
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event;

import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSAgreementINVO;
import com.clt.framework.support.layer.event.EventSupport;


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
	
	private MGSAgreementINVO[] mgsAgreementINVOS1 = null;
	private MGSAgreementINVO[] mgsAgreementINVOS2 = null;
	private MGSAgreementINVO[] mgsAgreementINVOS3 = null;	

	public EesCgm2021Event(){}

	public MGSAgreementINVO getMgsAgreementINVO() {
		return mgsAgreementINVO;
	}

	public void setMgsAgreementINVO(MGSAgreementINVO mgsAgreementINVO) {
		this.mgsAgreementINVO = mgsAgreementINVO;
	}

	public MGSAgreementINVO[] getMgsAgreementINVOS() {
		MGSAgreementINVO[] rtnVOs = null;
		if (this.mgsAgreementINVOS != null) {
			rtnVOs = java.util.Arrays.copyOf(mgsAgreementINVOS, mgsAgreementINVOS.length);
		}
		return rtnVOs;
	}

	public void setMgsAgreementINVOS(MGSAgreementINVO[] mgsAgreementINVOS){
		if(mgsAgreementINVOS != null){
			MGSAgreementINVO[] tmpVOs = java.util.Arrays.copyOf(mgsAgreementINVOS, mgsAgreementINVOS.length);
			this.mgsAgreementINVOS = tmpVOs;
		}
	}

	public MGSAgreementINVO[] getMgsAgreementINVOS1() {
		MGSAgreementINVO[] rtnVOs = null;
		if (this.mgsAgreementINVOS1 != null) {
			rtnVOs = java.util.Arrays.copyOf(mgsAgreementINVOS1, mgsAgreementINVOS1.length);
		}
		return rtnVOs;
	}

	public void setMgsAgreementINVOS1(MGSAgreementINVO[] mgsAgreementINVOS1){
		if(mgsAgreementINVOS1 != null){
			MGSAgreementINVO[] tmpVOs = java.util.Arrays.copyOf(mgsAgreementINVOS1, mgsAgreementINVOS1.length);
			this.mgsAgreementINVOS1 = tmpVOs;
		}
	}

	public MGSAgreementINVO[] getMgsAgreementINVOS2() {
		MGSAgreementINVO[] rtnVOs = null;
		if (this.mgsAgreementINVOS2 != null) {
			rtnVOs = java.util.Arrays.copyOf(mgsAgreementINVOS2, mgsAgreementINVOS2.length);
		}
		return rtnVOs;
	}

	public void setMgsAgreementINVOS2(MGSAgreementINVO[] mgsAgreementINVOS2){
		if(mgsAgreementINVOS2 != null){
			MGSAgreementINVO[] tmpVOs = java.util.Arrays.copyOf(mgsAgreementINVOS2, mgsAgreementINVOS2.length);
			this.mgsAgreementINVOS2 = tmpVOs;
		}
	}

	public MGSAgreementINVO[] getMgsAgreementINVOS3() {
		MGSAgreementINVO[] rtnVOs = null;
		if (this.mgsAgreementINVOS3 != null) {
			rtnVOs = java.util.Arrays.copyOf(mgsAgreementINVOS3, mgsAgreementINVOS3.length);
		}
		return rtnVOs;
	}

	public void setMgsAgreementINVOS3(MGSAgreementINVO[] mgsAgreementINVOS3){
		if(mgsAgreementINVOS3 != null){
			MGSAgreementINVO[] tmpVOs = java.util.Arrays.copyOf(mgsAgreementINVOS3, mgsAgreementINVOS3.length);
			this.mgsAgreementINVOS3 = tmpVOs;
		}
	}
	
	
	
}