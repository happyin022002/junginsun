/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0055Event.java
*@FileTitle : D/Dock Schedule Review - Graph
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.04.30 윤세영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.event;

import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.vo.CondDryDockScheduleVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0055 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0055HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yoon Seyeong
 * @see ESM_FMS_0055HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmFms0055Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CondDryDockScheduleVO condDryDockScheduleVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CondDryDockScheduleVO[] condDryDockScheduleVOs = null;

	public EsmFms0055Event(){}
	
	public void setCondDryDockScheduleVO(CondDryDockScheduleVO condDryDockScheduleVO){
		this. condDryDockScheduleVO = condDryDockScheduleVO;
	}

	public void setCondDryDockScheduleVOS(CondDryDockScheduleVO[] condDryDockScheduleVOs){
		if (condDryDockScheduleVOs != null) {
			CondDryDockScheduleVO[] tmpVOs = new CondDryDockScheduleVO[condDryDockScheduleVOs.length];
			System.arraycopy(condDryDockScheduleVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.condDryDockScheduleVOs = tmpVOs;
		}
	}

	public CondDryDockScheduleVO getCondDryDockScheduleVO(){
		return condDryDockScheduleVO;
	}

	public CondDryDockScheduleVO[] getCondDryDockScheduleVOS(){
		CondDryDockScheduleVO[] tmpVOs = null;
		if (this.condDryDockScheduleVOs != null) {
			tmpVOs = new CondDryDockScheduleVO[condDryDockScheduleVOs.length];
			System.arraycopy(condDryDockScheduleVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}