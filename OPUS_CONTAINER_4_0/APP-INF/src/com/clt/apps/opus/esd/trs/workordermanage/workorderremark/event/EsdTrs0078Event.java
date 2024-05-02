/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ESD_TRS_078Event.java
 *@FileTitle : Office별로 Cost/Trans Mode 및 IN/OUT Bound 별 W/O에 공통 적용할 비고 사항을 관리하는 화면
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-11-08
 *@LastModifier : poong_yeon
 *@LastVersion : 1.0
 * 2006-11-08 poong_yeon
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderremark.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.trs.workordermanage.workorderremark.vo.WorkOrderRemarkVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESD_TRS_078 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_078HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author poong_yeon
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0078Event extends EventSupport {
	private static final long serialVersionUID = 1762503351987143665L;

	private WorkOrderRemarkVO workOrderRemarkVO = null;

	private WorkOrderRemarkVO[] workOrderRemarkVOs = null;

	public EsdTrs0078Event() {

	}

	public WorkOrderRemarkVO getWorkOrderRemarkVO() {
		return workOrderRemarkVO;
	}

	public void setWorkOrderRemarkVO(WorkOrderRemarkVO workOrderRemarkVO) {
		this.workOrderRemarkVO = workOrderRemarkVO;
	}

	public WorkOrderRemarkVO[] getWorkOrderRemarkVOs() {
		WorkOrderRemarkVO[] rtnVOs = null;
		if (this.workOrderRemarkVOs != null) {
			rtnVOs = Arrays.copyOf(this.workOrderRemarkVOs, this.workOrderRemarkVOs.length);
		}
		return rtnVOs;
	}

	public void setWorkOrderRemarkVOs(WorkOrderRemarkVO[] workOrderRemarkVOs) {
		if (workOrderRemarkVOs != null) {
			WorkOrderRemarkVO[] tmpVOs = Arrays.copyOf(workOrderRemarkVOs, workOrderRemarkVOs.length);
			this.workOrderRemarkVOs = tmpVOs;
		}
	}

	public String getEventName() {
		return "EsdTrs0078Event";
	}

	public String toString() {
		return "EsdTrs0078Event";
	}

}
