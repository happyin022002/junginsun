/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VOP_VSK_9503HTMLAction.java
*@FileTitle : Vessel Loadable Info Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.11
*@LastModifier : 박다은
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.event;

import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.VesselLoadableInfoVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * VOP_VSK_9503 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - VOP_VSK_9503HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park, Da-eun
 * @see VOP_VSK_9503HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopVsk9503Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public VopVsk9503Event(){}
	
	public VesselLoadableInfoVO getVesselLoadableInfoVO() {
		return vesselLoadableInfoVO;
	}

	public void setVesselLoadableInfoVO(VesselLoadableInfoVO vesselLoadableInfoVO) {
		this.vesselLoadableInfoVO = vesselLoadableInfoVO;
	}

	public VesselLoadableInfoVO[] getVesselLoadableInfoVOs() {
		VesselLoadableInfoVO[] rtnVOs =  null;
		if(this.vesselLoadableInfoVOs != null){
			rtnVOs = new VesselLoadableInfoVO[vesselLoadableInfoVOs.length];
			System.arraycopy(vesselLoadableInfoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.20
		//return vesselLoadableInfoVOs;
	}

	public void setVesselLoadableInfoVOs(VesselLoadableInfoVO[] vesselLoadableInfoVOs) {
		if(vesselLoadableInfoVOs != null){
			VesselLoadableInfoVO[] tmpVOs = new VesselLoadableInfoVO[vesselLoadableInfoVOs.length];
			System.arraycopy(vesselLoadableInfoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vesselLoadableInfoVOs = tmpVOs;
		}
		//소스보안 2015.07.20
		//this.vesselLoadableInfoVOs = vesselLoadableInfoVOs;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private VesselLoadableInfoVO vesselLoadableInfoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private VesselLoadableInfoVO[] vesselLoadableInfoVOs = null;
	

}