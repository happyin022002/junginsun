/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1019Event.java
*@FileTitle : Lost Chassis Summary Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.06.09 최민회
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event;

import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSLostResultINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSLostResultMGTVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_1019 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1019HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI MIN HOI
 * @see EES_CGM_1019HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1019Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSLostResultINVO chsLostResultINVO = null;
	
	/**
	 * @return the chsLostResultINVO
	 */
	public CHSLostResultINVO getChsLostResultINVO() {
		return chsLostResultINVO;
	}
	
	/**
	 * @param chsLostResultINVO the chsLostResultINVO to set
	 */
	public void setChsLostResultINVO(CHSLostResultINVO chsLostResultINVO) {
		this.chsLostResultINVO = chsLostResultINVO;
	}

	/**
	 * @return the chsLostResultMGTVO
	 */
	public CHSLostResultMGTVO getChsLostResultMGTVO() {
		return chsLostResultMGTVO;
	}

	/**
	 * @param chsLostResultMGTVO the chsLostResultMGTVO to set
	 */
	public void setChsLostResultMGTVO(CHSLostResultMGTVO chsLostResultMGTVO) {
		this.chsLostResultMGTVO = chsLostResultMGTVO;
	}

	/**
	 * @return the chsLostResultMGTVOs
	 */
	public CHSLostResultMGTVO[] getChsLostResultMGTVOs() {
		return chsLostResultMGTVOs;
	}

	/**
	 * @param chsLostResultMGTVOs the chsLostResultMGTVOs to set
	 */
	public void setChsLostResultMGTVOs(CHSLostResultMGTVO[] chsLostResultMGTVOs) {
		this.chsLostResultMGTVOs = chsLostResultMGTVOs;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSLostResultMGTVO chsLostResultMGTVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CHSLostResultMGTVO[] chsLostResultMGTVOs = null;

	public EesCgm1019Event(){}
	

}