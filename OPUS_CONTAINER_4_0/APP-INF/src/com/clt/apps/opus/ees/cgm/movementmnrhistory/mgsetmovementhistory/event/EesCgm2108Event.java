/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm2108Event.java
*@FileTitle : Bare Chassis Movement Manual Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.06.29 최민회
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.event;

import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.vo.MGSMvmtBareMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.vo.MGSMvmtINVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_1108 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1108HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI MIN HOI
 * @see EES_CGM_2108HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm2108Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MGSMvmtINVO mGSMvmtINVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MGSMvmtBareMGTVO mgsMvmtBareMGTVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MGSMvmtBareMGTVO[] mgsMvmtBareMGTVOs = null;
	
	/**
	 * @return the chsMvmtBareMGTVO
	 */
	public MGSMvmtBareMGTVO getMgsMvmtBareMGTVO() {
		return mgsMvmtBareMGTVO;
	}

	/**
	 * @param chsMvmtBareMGTVO the chsMvmtBareMGTVO to set
	 */
	public void setMgsMvmtBareMGTVO(MGSMvmtBareMGTVO mgsMvmtBareMGTVO) {
		this.mgsMvmtBareMGTVO = mgsMvmtBareMGTVO;
	}

	/**
	 * @return the chsMvmtBareMGTVOs
	 */
	public MGSMvmtBareMGTVO[] getMgsMvmtBareMGTVOs() {
		MGSMvmtBareMGTVO[] rtnVOs = null;
		if (this.mgsMvmtBareMGTVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(mgsMvmtBareMGTVOs, mgsMvmtBareMGTVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param chsMvmtBareMGTVOs the chsMvmtBareMGTVOs to set
	 */
	public void setMgsMvmtBareMGTVOs(MGSMvmtBareMGTVO[] mgsMvmtBareMGTVOs){
		if(mgsMvmtBareMGTVOs != null){
			MGSMvmtBareMGTVO[] tmpVOs = java.util.Arrays.copyOf(mgsMvmtBareMGTVOs, mgsMvmtBareMGTVOs.length);
			this.mgsMvmtBareMGTVOs = tmpVOs;
		}
	}

	public EesCgm2108Event(){}

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
	

}