/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0057Event.java
*@FileTitle : D/dock Schedule Review
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.07
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.05.07 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.event;

import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.vo.CondDryDockScheduleVO;


/**
 * ESM_FMS_0057 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0057HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yoon Seyeong
 * @see ESM_FMS_0057HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmFms0057Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CondDryDockScheduleVO condDryDockScheduleVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CondDryDockScheduleVO[] condDryDockScheduleVOs = null;

	public EsmFms0057Event(){}
	
	public void setCondDryDockScheduleVO(CondDryDockScheduleVO condDryDockScheduleVO){
		this. condDryDockScheduleVO = condDryDockScheduleVO;
	}

	public void setCondDryDockScheduleVOS(CondDryDockScheduleVO[] condDryDockScheduleVOs){
		if (condDryDockScheduleVOs != null) {
			CondDryDockScheduleVO[] tmpVOs = Arrays.copyOf(condDryDockScheduleVOs, condDryDockScheduleVOs.length);
			this.condDryDockScheduleVOs = tmpVOs;
		}
	}

	public CondDryDockScheduleVO getCondDryDockScheduleVO(){
		return condDryDockScheduleVO;
	}

	public CondDryDockScheduleVO[] getCondDryDockScheduleVOS(){
		CondDryDockScheduleVO[] rtnVOs = null;
		if (this.condDryDockScheduleVOs != null) {
			rtnVOs = Arrays.copyOf(condDryDockScheduleVOs, condDryDockScheduleVOs.length);
		}
		return rtnVOs;
	}

}