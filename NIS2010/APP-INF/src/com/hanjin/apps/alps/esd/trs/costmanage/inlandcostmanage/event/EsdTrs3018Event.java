/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsdTrs3018Event.java
*@FileTitle : Inland Cost Management - Location Group
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2012.05.29 변종건 [CHM-201217633] Inland Cost Management - Location Group 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.event;

import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo.InlandCostConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TRS_3018 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TRS_3018HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESD_TRS_3018HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTrs3018Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	private InlandCostConditionVO inlandCostConditionVO = null;
	private InlandCostConditionVO[] inlandCostConditionVOs = null;
	
	public InlandCostConditionVO getInlandCostConditionVO() {
		return inlandCostConditionVO;
	}
	public void setInlandCostConditionVO(InlandCostConditionVO inlandCostConditionVO) {
		this.inlandCostConditionVO = inlandCostConditionVO;
	}
	public InlandCostConditionVO[] getInlandCostConditionVOs() {
		return inlandCostConditionVOs;
	}
	public void setInlandCostConditionVOs(
			InlandCostConditionVO[] inlandCostConditionVOs) {
		this.inlandCostConditionVOs = inlandCostConditionVOs;
	}
	
}
