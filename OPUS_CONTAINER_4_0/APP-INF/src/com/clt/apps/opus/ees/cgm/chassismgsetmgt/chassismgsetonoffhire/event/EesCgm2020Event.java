/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm2020Event.java
*@FileTitle : Lost M.G Set Summary Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.06.10 최민회
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event;

import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSLostResultINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSLostResultMGTVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_2020 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_2020HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI MIN HOI
 * @see EES_CGM_2020HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm2020Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MGSLostResultINVO mgsLostResultINVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MGSLostResultMGTVO mgsLostResultMGTVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MGSLostResultMGTVO[] mgsLostResultMGTVOs = null;
	

	public EesCgm2020Event(){}


	/**
	 * @return the mgsLostResultINVO
	 */
	public MGSLostResultINVO getMgsLostResultINVO() {
		return mgsLostResultINVO;
	}


	/**
	 * @param mgsLostResultINVO the mgsLostResultINVO to set
	 */
	public void setMgsLostResultINVO(MGSLostResultINVO mgsLostResultINVO) {
		this.mgsLostResultINVO = mgsLostResultINVO;
	}


	/**
	 * @return the mgsLostResultMGTVO
	 */
	public MGSLostResultMGTVO getMgsLostResultMGTVO() {
		return mgsLostResultMGTVO;
	}


	/**
	 * @param mgsLostResultMGTVO the mgsLostResultMGTVO to set
	 */
	public void setMgsLostResultMGTVO(MGSLostResultMGTVO mgsLostResultMGTVO) {
		this.mgsLostResultMGTVO = mgsLostResultMGTVO;
	}


	/**
	 * @return the mgsLostResultMGTVOs
	 */
	public MGSLostResultMGTVO[] getMgsLostResultMGTVOs() {
		MGSLostResultMGTVO[] rtnVOs = null;
		if (this.mgsLostResultMGTVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(mgsLostResultMGTVOs, mgsLostResultMGTVOs.length);
		}
		return rtnVOs;
	}


	/**
	 * @param mgsLostResultMGTVOs the mgsLostResultMGTVOs to set
	 */
	public void setMgsLostResultMGTVOs(MGSLostResultMGTVO[] mgsLostResultMGTVOs){
		if(mgsLostResultMGTVOs != null){
			MGSLostResultMGTVO[] tmpVOs = java.util.Arrays.copyOf(mgsLostResultMGTVOs, mgsLostResultMGTVOs.length);
			this.mgsLostResultMGTVOs = tmpVOs;
		}
	}
	

}