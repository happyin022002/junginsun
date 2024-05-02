/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm2018Event.java
*@FileTitle : M.G Set 의 Status History 조회및 수정하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.06.16 최민회
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event;

import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSStatusInfoINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSStatusInfoMGTVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_2018 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_2018HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI MIN HOI
 * @see EES_CGM_2018HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm2018Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MGSStatusInfoMGTVO mgsStatusInfoMGTVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MGSStatusInfoINVO mgsStatusInfoINVO = null;
	
	/**
	 * @return the chsStatusInfoMGTVO
	 */
	public MGSStatusInfoMGTVO getMgsStatusInfoMGTVO() {
		return mgsStatusInfoMGTVO;
	}

	/**
	 * @param chsStatusInfoMGTVO the chsStatusInfoMGTVO to set
	 */
	public void setMgsStatusInfoMGTVO(MGSStatusInfoMGTVO mgsStatusInfoMGTVO) {
		this.mgsStatusInfoMGTVO = mgsStatusInfoMGTVO;
	}

	/**
	 * @return the chsStatusInfoINVO
	 */
	public MGSStatusInfoINVO getMgsStatusInfoINVO() {
		return mgsStatusInfoINVO;
	}

	/**
	 * @param chsStatusInfoINVO the chsStatusInfoINVO to set
	 */
	public void setMgsStatusInfoINVO(MGSStatusInfoINVO mgsStatusInfoINVO) {
		this.mgsStatusInfoINVO = mgsStatusInfoINVO;
	}

	/**
	 * @return the chsStatusInfoMGTVOs
	 */
	public MGSStatusInfoMGTVO[] getMgsStatusInfoMGTVOs() {
		MGSStatusInfoMGTVO[] rtnVOs = null;
		if (this.mgsStatusInfoMGTVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(mgsStatusInfoMGTVOs, mgsStatusInfoMGTVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param chsStatusInfoMGTVOs the chsStatusInfoMGTVOs to set
	 */
	public void setMgsStatusInfoMGTVOs(MGSStatusInfoMGTVO[] mgsStatusInfoMGTVOs){
		if(mgsStatusInfoMGTVOs != null){
			MGSStatusInfoMGTVO[] tmpVOs = java.util.Arrays.copyOf(mgsStatusInfoMGTVOs, mgsStatusInfoMGTVOs.length);
			this.mgsStatusInfoMGTVOs = tmpVOs;
		}
	}

	/** Table Value Object Multi Data 처리 */
	private MGSStatusInfoMGTVO[] mgsStatusInfoMGTVOs = null;

	public EesCgm2018Event(){}
	
}