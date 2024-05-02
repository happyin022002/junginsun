/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0503Event.java
*@FileTitle : Vessel Information inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.06.22 김종옥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.DockPlanListVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.VSLPartIVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.VesselInformationMgtConditionVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * VOP_VSK_0503 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0503HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jong Ock
 * @see VOP_VSK_0503HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopVsk0503Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DockPlanListVO dockPlanListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DockPlanListVO[] dockPlanListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private VSLPartIVO vSLPartIVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private VSLPartIVO[] vSLPartIVOs = null;

	private VesselInformationMgtConditionVO vesselInformationMgtConditionVO = null;
	
	public VopVsk0503Event(){}
	
	public void setDockPlanListVO(DockPlanListVO dockPlanListVO){
		this. dockPlanListVO = dockPlanListVO;
	}

	public void setDockPlanListVOS(DockPlanListVO[] dockPlanListVOs){
		if(dockPlanListVOs != null){
			DockPlanListVO[] tmpVOs = Arrays.copyOf(dockPlanListVOs, dockPlanListVOs.length);
			this.dockPlanListVOs = tmpVOs;
		}
	}

	public void setVSLPartIVO(VSLPartIVO vSLPartIVO){
		this. vSLPartIVO = vSLPartIVO;
	}

	public void setVSLPartIVOS(VSLPartIVO[] vSLPartIVOs){
		if(vSLPartIVOs != null){
			VSLPartIVO[] tmpVOs = Arrays.copyOf(vSLPartIVOs, vSLPartIVOs.length);
			this.vSLPartIVOs = tmpVOs;
		}
	}

	public DockPlanListVO getDockPlanListVO(){
		return dockPlanListVO;
	}

	public DockPlanListVO[] getDockPlanListVOS(){
		DockPlanListVO[] rtnVOs = null;
		if (this.dockPlanListVOs != null) {
			rtnVOs = Arrays.copyOf(dockPlanListVOs, dockPlanListVOs.length);
		}
		return rtnVOs;
	}

	public VSLPartIVO getVSLPartIVO(){
		return vSLPartIVO;
	}

	public VSLPartIVO[] getVSLPartIVOS(){
		VSLPartIVO[] rtnVOs = null;
		if (this.vSLPartIVOs != null) {
			rtnVOs = Arrays.copyOf(vSLPartIVOs, vSLPartIVOs.length);
		}
		return rtnVOs;
	}
	
	public void setVesselInformationMgtConditionVO(VesselInformationMgtConditionVO vesselInformationMgtConditionVO) {
		this.vesselInformationMgtConditionVO = vesselInformationMgtConditionVO;
	}
	
	public VesselInformationMgtConditionVO getVesselInformationMgtConditionVO() {
		return vesselInformationMgtConditionVO;
	}	

}