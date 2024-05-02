/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1016Event.java
*@FileTitle : Chassis Status를 조회하고 수정하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.06.11 최민회
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event;

import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSStatusInfoINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSStatusInfoMGTVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_1016 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1016HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI MIN HOI
 * @see EES_CGM_1016HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1016Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSStatusInfoMGTVO chsStatusInfoMGTVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSStatusInfoINVO chsStatusInfoINVO = null;
	
	/**
	 * @return the chsStatusInfoMGTVO
	 */
	public CHSStatusInfoMGTVO getChsStatusInfoMGTVO() {
		return chsStatusInfoMGTVO;
	}

	/**
	 * @param chsStatusInfoMGTVO the chsStatusInfoMGTVO to set
	 */
	public void setChsStatusInfoMGTVO(CHSStatusInfoMGTVO chsStatusInfoMGTVO) {
		this.chsStatusInfoMGTVO = chsStatusInfoMGTVO;
	}

	/**
	 * @return the chsStatusInfoINVO
	 */
	public CHSStatusInfoINVO getChsStatusInfoINVO() {
		return chsStatusInfoINVO;
	}

	/**
	 * @param chsStatusInfoINVO the chsStatusInfoINVO to set
	 */
	public void setChsStatusInfoINVO(CHSStatusInfoINVO chsStatusInfoINVO) {
		this.chsStatusInfoINVO = chsStatusInfoINVO;
	}

	/**
	 * @return the chsStatusInfoMGTVOs
	 */
	public CHSStatusInfoMGTVO[] getChsStatusInfoMGTVOs() {
		CHSStatusInfoMGTVO[] rtnVOs = null;
		if (this.chsStatusInfoMGTVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(chsStatusInfoMGTVOs, chsStatusInfoMGTVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param chsStatusInfoMGTVOs the chsStatusInfoMGTVOs to set
	 */
	public void setChsStatusInfoMGTVOs(CHSStatusInfoMGTVO[] chsStatusInfoMGTVOs){
		if(chsStatusInfoMGTVOs != null){
			CHSStatusInfoMGTVO[] tmpVOs = java.util.Arrays.copyOf(chsStatusInfoMGTVOs, chsStatusInfoMGTVOs.length);
			this.chsStatusInfoMGTVOs = tmpVOs;
		}
	}

	/** Table Value Object Multi Data 처리 */
	private CHSStatusInfoMGTVO[] chsStatusInfoMGTVOs = null;

	public EesCgm1016Event(){}
	
	}