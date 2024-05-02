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
package com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.event;

import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.vo.MGSMvmtHistoryMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.vo.MGSMvmtINVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_1105 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1105HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI MIN HOI
 * @see EES_CGM_2105HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm2105Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MGSMvmtINVO mGSMvmtINVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MGSMvmtHistoryMGTVO mGSMvmtHistoryMGTVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MGSMvmtHistoryMGTVO[] mGSMvmtHistoryMGTVOs = null;
	
 

	public EesCgm2105Event(){}
	
	/**
	 * @return the cHSMvmtHistoryMGTVO
	 */
	public MGSMvmtHistoryMGTVO getMGSMvmtHistoryMGTVO() {
		return mGSMvmtHistoryMGTVO;
	}

	/**
	 * @return the cHSMvmtINVO
	 */
	public MGSMvmtINVO getMGSMvmtINVO() {
		return mGSMvmtINVO;
	}

	/**
	 * @param mvmtINVO the cHSMvmtINVO to set
	 */
	public void setMGSMvmtINVO(MGSMvmtINVO mvmtINVO) {
		mGSMvmtINVO = mvmtINVO;
	}

	/**
	 * @param mvmtHistoryMGTVO the cHSMvmtHistoryMGTVO to set
	 */
	public void setMGSMvmtHistoryMGTVO(MGSMvmtHistoryMGTVO mvmtHistoryMGTVO) {
		mGSMvmtHistoryMGTVO = mvmtHistoryMGTVO;
	}

	/**
	 * @return the cHSMvmtHistoryMGTVOs
	 */
	public MGSMvmtHistoryMGTVO[] getMGSMvmtHistoryMGTVOs() {
		MGSMvmtHistoryMGTVO[] rtnVOs = null;
		if (this.mGSMvmtHistoryMGTVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(mGSMvmtHistoryMGTVOs, mGSMvmtHistoryMGTVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param mvmtHistoryMGTVOs the cHSMvmtHistoryMGTVOs to set
	 */
	public void setMGSMvmtHistoryMGTVOs(MGSMvmtHistoryMGTVO[] mvmtHistoryMGTVOs){
		if(mvmtHistoryMGTVOs != null){
			MGSMvmtHistoryMGTVO[] tmpVOs = java.util.Arrays.copyOf(mvmtHistoryMGTVOs, mvmtHistoryMGTVOs.length);
			this.mGSMvmtHistoryMGTVOs = tmpVOs;
		}
	}


 
}