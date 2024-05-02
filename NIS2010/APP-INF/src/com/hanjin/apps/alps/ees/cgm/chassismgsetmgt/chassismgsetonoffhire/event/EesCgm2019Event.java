/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm2019Event.java
*@FileTitle : M.G Set Sstus Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.06.08 최민회
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event;

import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSFoundLostINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSFoundLostMGTVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_2019 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_2019HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI MIN HOI
 * @see EES_CGM_2019HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm2019Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MGSFoundLostMGTVO mgsFoundLostMGTVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MGSFoundLostMGTVO[] mgsFoundLostMGTVOs = null;
	
	/** Table Value Object 조회 조건   */
	private MGSFoundLostINVO mgsFoundLostINVO = null;

	/**
	 * @return the mgsFoundLostINVO
	 */
	public MGSFoundLostINVO getMgsFoundLostINVO() {
		return mgsFoundLostINVO;
	}

	/**
	 * @param mgsFoundLostINVO the mgsFoundLostINVO to set
	 */
	public void setMgsFoundLostINVO(MGSFoundLostINVO mgsFoundLostINVO) {
		this.mgsFoundLostINVO = mgsFoundLostINVO;
	}

	public EesCgm2019Event(){}

	/**
	 * @return the mgsFoundLostMGTVO
	 */
	public MGSFoundLostMGTVO getMgsFoundLostMGTVO() {
		return mgsFoundLostMGTVO;
	}

	/**
	 * @param mgsFoundLostMGTVO the mgsFoundLostMGTVO to set
	 */
	public void setMgsFoundLostMGTVO(MGSFoundLostMGTVO mgsFoundLostMGTVO) {
		this.mgsFoundLostMGTVO = mgsFoundLostMGTVO;
	}

	/**
	 * @return the mgsFoundLostMGTVOs
	 */
	public MGSFoundLostMGTVO[] getMgsFoundLostMGTVOs() {
		return mgsFoundLostMGTVOs;
	}

	/**
	 * @param mgsFoundLostMGTVOs the mgsFoundLostMGTVOs to set
	 */
	public void setMgsFoundLostMGTVOs(MGSFoundLostMGTVO[] mgsFoundLostMGTVOs) {
		this.mgsFoundLostMGTVOs = mgsFoundLostMGTVOs;
	}
	

}