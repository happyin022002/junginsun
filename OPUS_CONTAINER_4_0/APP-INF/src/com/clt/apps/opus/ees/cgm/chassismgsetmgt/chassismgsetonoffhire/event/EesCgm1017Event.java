/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1017Event.java
*@FileTitle : 분실 또는 되찾은 Chassis Status를 Creation 하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.06.04 최민회
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event;

import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSFoundLostINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSFoundLostMGTVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_1017 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1017HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI MIN HOI
 * @see EES_CGM_1017HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1017Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSFoundLostMGTVO chsFoundLostMGTVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CHSFoundLostMGTVO[] chsFoundLostMGTVOs = null;
	
	/** Table Value Object 조회 조건   */
	private CHSFoundLostINVO chsFoundLostINVO = null;

	/**
	 * @return the chsFoundLostINVO
	 */
	public CHSFoundLostINVO getChsFoundLostINVO() {
		return chsFoundLostINVO;
	}

	/**
	 * @param chsFoundLostINVO the chsFoundLostINVO to set
	 */
	public void setChsFoundLostINVO(CHSFoundLostINVO chsFoundLostINVO) {
		this.chsFoundLostINVO = chsFoundLostINVO;
	}

	public EesCgm1017Event(){}

	/**
	 * @return the chsFoundLostMGTVO
	 */
	public CHSFoundLostMGTVO getChsFoundLostMGTVO() {
		return chsFoundLostMGTVO;
	}

	/**
	 * @param chsFoundLostMGTVO the chsFoundLostMGTVO to set
	 */
	public void setChsFoundLostMGTVO(CHSFoundLostMGTVO chsFoundLostMGTVO) {
		this.chsFoundLostMGTVO = chsFoundLostMGTVO;
	}

	/**
	 * @return the chsFoundLostMGTVOs
	 */
	public CHSFoundLostMGTVO[] getChsFoundLostMGTVOs() {
		CHSFoundLostMGTVO[] rtnVOs = null;
		if (this.chsFoundLostMGTVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(chsFoundLostMGTVOs, chsFoundLostMGTVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param chsFoundLostMGTVOs the chsFoundLostMGTVOs to set
	 */
	public void setChsFoundLostMGTVOs(CHSFoundLostMGTVO[] chsFoundLostMGTVOs){
		if(chsFoundLostMGTVOs != null){
			CHSFoundLostMGTVO[] tmpVOs = java.util.Arrays.copyOf(chsFoundLostMGTVOs, chsFoundLostMGTVOs.length);
			this.chsFoundLostMGTVOs = tmpVOs;
		}
	}
	


}