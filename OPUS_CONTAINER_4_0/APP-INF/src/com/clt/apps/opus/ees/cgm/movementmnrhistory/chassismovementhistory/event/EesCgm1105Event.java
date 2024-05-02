/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1105Event.java
*@FileTitle : 개별 Chassis Movement 조회 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.06.26 최민회
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.event;

import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSMvmtHistoryMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.vo.CHSMvmtINVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_1105 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1105HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI MIN HOI
 * @see EES_CGM_1105HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1105Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSMvmtINVO cHSMvmtINVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSMvmtHistoryMGTVO cHSMvmtHistoryMGTVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSMvmtHistoryMGTVO[] cHSMvmtHistoryMGTVOs = null;
	
 

	public EesCgm1105Event(){}
	
	/**
	 * @return the cHSMvmtHistoryMGTVO
	 */
	public CHSMvmtHistoryMGTVO getCHSMvmtHistoryMGTVO() {
		return cHSMvmtHistoryMGTVO;
	}

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

	/**
	 * @param mvmtHistoryMGTVO the cHSMvmtHistoryMGTVO to set
	 */
	public void setCHSMvmtHistoryMGTVO(CHSMvmtHistoryMGTVO mvmtHistoryMGTVO) {
		cHSMvmtHistoryMGTVO = mvmtHistoryMGTVO;
	}

	/**
	 * @return the cHSMvmtHistoryMGTVOs
	 */
	public CHSMvmtHistoryMGTVO[] getCHSMvmtHistoryMGTVOs() {
		CHSMvmtHistoryMGTVO[] rtnVOs = null;
		if (this.cHSMvmtHistoryMGTVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(cHSMvmtHistoryMGTVOs, cHSMvmtHistoryMGTVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param mvmtHistoryMGTVOs the cHSMvmtHistoryMGTVOs to set
	 */
	public void setCHSMvmtHistoryMGTVOs(CHSMvmtHistoryMGTVO[] mvmtHistoryMGTVOs){
		if(mvmtHistoryMGTVOs != null){
			CHSMvmtHistoryMGTVO[] tmpVOs = java.util.Arrays.copyOf(mvmtHistoryMGTVOs, mvmtHistoryMGTVOs.length);
			this.cHSMvmtHistoryMGTVOs = tmpVOs;
		}
	}


 
}