/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm2032Event.java
*@FileTitle : Leased M.G Set Charge Creation 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.07.20 김창식
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event;

import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSChargeCreationINVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ees_cgm_2032 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_cgm_2032HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM CHANG SIK
 * @see ees_cgm_2032HTMLAction 참조
 * @since J2EE 1.4 
 */

public class EesCgm2032Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MGSChargeCreationINVO mgsChargeCreationINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MGSChargeCreationINVO[] mgsChargeCreationINVOS = null;

	public EesCgm2032Event(){}

	public MGSChargeCreationINVO getMgsChargeCreationINVO() {
		return mgsChargeCreationINVO;
	}

	public void setMgsChargeCreationINVO(MGSChargeCreationINVO mgsChargeCreationINVO) {
		this.mgsChargeCreationINVO = mgsChargeCreationINVO;
	}

	public MGSChargeCreationINVO[] getMgsChargeCreationINVOS() {
		MGSChargeCreationINVO[] rtnVOs = null;
		if (this.mgsChargeCreationINVOS != null) {
			rtnVOs = java.util.Arrays.copyOf(mgsChargeCreationINVOS, mgsChargeCreationINVOS.length);
		}
		return rtnVOs;
	}

	public void setMgsChargeCreationINVOS(MGSChargeCreationINVO[] mgsChargeCreationINVOS){
		if(mgsChargeCreationINVOS != null){
			MGSChargeCreationINVO[] tmpVOs = java.util.Arrays.copyOf(mgsChargeCreationINVOS, mgsChargeCreationINVOS.length);
			this.mgsChargeCreationINVOS = tmpVOs;
		}
	}
	
	

}