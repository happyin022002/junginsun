/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_TRS_029Event.java
*@FileTitle : W/O BFI Management 를 조회하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2014-11-17
*@LastModifier : P.K.S
*@LastVersion : 1.0
* 2014-11-17 P.K.S
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workordermanagement.event;

import com.clt.apps.opus.esd.trs.workordermanage.workordermanagement.vo.WorkOrderBFIManagementVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TrsTrspWrkOrdVO;

/**
 * ESD_TRS_025 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_025HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author poong_yeon
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0029Event extends EventSupport {

	WorkOrderBFIManagementVO [] workOrderBFIManagementVOs =	null;
	WorkOrderBFIManagementVO workOrderBFIManagementVO = null;
	
	public String getEventName() {
		return "EsdTrs0029Event";
	}
	
	public String toString() {
		return "EsdTrs0029Event";
	}

	public WorkOrderBFIManagementVO[] getWorkOrderBFIManagementVOs() {
		return workOrderBFIManagementVOs;
	}

	public void setWorkOrderBFIManagementVOs(
			WorkOrderBFIManagementVO[] workOrderBFIManagementVOs) {
		this.workOrderBFIManagementVOs = workOrderBFIManagementVOs;
	}

	public WorkOrderBFIManagementVO getWorkOrderBFIManagementVO() {
		return workOrderBFIManagementVO;
	}

	public void setWorkOrderBFIManagementVO(
			WorkOrderBFIManagementVO workOrderBFIManagementVO) {
		this.workOrderBFIManagementVO = workOrderBFIManagementVO;
	}
	

}
