/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1104Event.java
*@FileTitle : 특정 조회조건의 Chassis Movement 조회 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.06.23 최민회
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.event;

import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSMvmtINVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSMvmtMGTVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_1104 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1104HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI MIN HOI
 * @see EES_CGM_1104HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1104Event extends EventSupport {

	private static final long serialVersionUID = 1L;


	public EesCgm1104Event(){}
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSMvmtINVO chsMvmtINVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSMvmtMGTVO chsMvmtMGTVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSMvmtMGTVO[] chsMvmtMGTVOs = null;

	/**
	 * @return the chsMvmtMGTVO
	 */
	public CHSMvmtMGTVO getChsMvmtMGTVO() {
		return chsMvmtMGTVO;
	}

	/**
	 * @param chsMvmtMGTVO the chsMvmtMGTVO to set
	 */
	public void setChsMvmtMGTVO(CHSMvmtMGTVO chsMvmtMGTVO) {
		this.chsMvmtMGTVO = chsMvmtMGTVO;
	}

	/**
	 * @return the chsMvmtMGTVOs
	 */
	public CHSMvmtMGTVO[] getChsMvmtMGTVOs() {
		return chsMvmtMGTVOs;
	}

	/**
	 * @param chsMvmtMGTVOs the chsMvmtMGTVOs to set
	 */
	public void setChsMvmtMGTVOs(CHSMvmtMGTVO[] chsMvmtMGTVOs) {
		this.chsMvmtMGTVOs = chsMvmtMGTVOs;
	}

	/**
	 * @return the chsMvmtINVO
	 */
	public CHSMvmtINVO getChsMvmtINVO() {
		return chsMvmtINVO;
	}

	/**
	 * @param chsMvmtINVO the chsMvmtINVO to set
	 */
	public void setChsMvmtINVO(CHSMvmtINVO chsMvmtINVO) {
		this.chsMvmtINVO = chsMvmtINVO;
	}

}