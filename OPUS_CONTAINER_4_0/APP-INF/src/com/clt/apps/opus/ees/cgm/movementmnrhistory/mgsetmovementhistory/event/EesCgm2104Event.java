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
package com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.event;

import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.vo.MGSMvmtINVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.vo.MGSMvmtMGTVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_1104 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1104HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI MIN HOI
 * @see EES_CGM_2104HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm2104Event extends EventSupport {

	private static final long serialVersionUID = 1L;


	public EesCgm2104Event(){}
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MGSMvmtINVO mgsMvmtINVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MGSMvmtMGTVO mgsMvmtMGTVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MGSMvmtMGTVO[] mgsMvmtMGTVOs = null;

	/**
	 * @return the chsMvmtMGTVO
	 */
	public MGSMvmtMGTVO getMgsMvmtMGTVO() {
		return mgsMvmtMGTVO;
	}

	/**
	 * @param chsMvmtMGTVO the chsMvmtMGTVO to set
	 */
	public void setMgsMvmtMGTVO(MGSMvmtMGTVO mgsMvmtMGTVO) {
		this.mgsMvmtMGTVO = mgsMvmtMGTVO;
	}

	/**
	 * @return the chsMvmtMGTVOs
	 */
	public MGSMvmtMGTVO[] getMgsMvmtMGTVOs() {
		MGSMvmtMGTVO[] rtnVOs = null;
		if (this.mgsMvmtMGTVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(mgsMvmtMGTVOs, mgsMvmtMGTVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param chsMvmtMGTVOs the chsMvmtMGTVOs to set
	 */
	public void setMgsMvmtMGTVOs(MGSMvmtMGTVO[] mgsMvmtMGTVOs){
		if(mgsMvmtMGTVOs != null){
			MGSMvmtMGTVO[] tmpVOs = java.util.Arrays.copyOf(mgsMvmtMGTVOs, mgsMvmtMGTVOs.length);
			this.mgsMvmtMGTVOs = tmpVOs;
		}
	}

	/**
	 * @return the chsMvmtINVO
	 */
	public MGSMvmtINVO getMgsMvmtINVO() {
		return mgsMvmtINVO;
	}

	/**
	 * @param chsMvmtINVO the chsMvmtINVO to set
	 */
	public void setMgsMvmtINVO(MGSMvmtINVO mgsMvmtINVO) {
		this.mgsMvmtINVO = mgsMvmtINVO;
	}

}