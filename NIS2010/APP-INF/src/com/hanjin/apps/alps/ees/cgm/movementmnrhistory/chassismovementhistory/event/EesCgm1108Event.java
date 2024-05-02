/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1108Event.java
*@FileTitle : Bare Chassis Movement Manual Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.06.29 최민회
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.event;

import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSMvmtBareMGTVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSMvmtINVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_1108 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1108HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI MIN HOI
 * @see EES_CGM_1108HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1108Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSMvmtINVO cHSMvmtINVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSMvmtBareMGTVO chsMvmtBareMGTVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSMvmtBareMGTVO[] chsMvmtBareMGTVOs = null;
	
	/**
	 * @return the chsMvmtBareMGTVO
	 */
	public CHSMvmtBareMGTVO getChsMvmtBareMGTVO() {
		return chsMvmtBareMGTVO;
	}

	/**
	 * @param chsMvmtBareMGTVO the chsMvmtBareMGTVO to set
	 */
	public void setChsMvmtBareMGTVO(CHSMvmtBareMGTVO chsMvmtBareMGTVO) {
		this.chsMvmtBareMGTVO = chsMvmtBareMGTVO;
	}

	/**
	 * @return the chsMvmtBareMGTVOs
	 */
	public CHSMvmtBareMGTVO[] getChsMvmtBareMGTVOs() {
		return chsMvmtBareMGTVOs;
	}

	/**
	 * @param chsMvmtBareMGTVOs the chsMvmtBareMGTVOs to set
	 */
	public void setChsMvmtBareMGTVOs(CHSMvmtBareMGTVO[] chsMvmtBareMGTVOs) {
		this.chsMvmtBareMGTVOs = chsMvmtBareMGTVOs;
	}

	public EesCgm1108Event(){}

	/**
	 * @return the cHSMvmtINVO
	 */
	public CHSMvmtINVO getCHSMvmtINVO() {
		return cHSMvmtINVO;
	}

	/**
	 * @param mvmtINVO the cHSMvmtINVO to set
	 */
	public void setCHSMvmtINVO(CHSMvmtINVO mvmtINVO) {
		cHSMvmtINVO = mvmtINVO;
	}
	

}