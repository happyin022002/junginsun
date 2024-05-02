/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0503Event.java
*@FileTitle : Vessel Information inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.02
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.06.22 김종옥
* 1.0 Creation
* 
* History
* 2012.04.02 진마리아 CHM-201217105-01 Local Vessel name 칼럼 추가 요청건
* 2014.03.17 박다은 	 CHM-201428939-01 vessel particular - performance 
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.VSLPartIVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.VesselInformationMgtConditionVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VesselVO;

/**
 * VOP_VSK_0519 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0519HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jong Ock
 * @see VOP_VSK_0519HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopVsk0519Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	

	/** Table Value Object 조회 조건 및 단건 처리  */
	private VSLPartIVO vSLPartIVO = null;
	
	/** Table Value Object Multi Data 처리 */ 
	private VSLPartIVO[] vSLPartIVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VesselVO vesselVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private VesselVO[] vesselVOs = null;

	private VesselInformationMgtConditionVO vesselInformationMgtConditionVO = null;
	
	public VopVsk0519Event(){}
	

	public void setVSLPartIVO(VSLPartIVO vSLPartIVO){
		this. vSLPartIVO = vSLPartIVO;
	}

	public void setVSLPartIVOS(VSLPartIVO[] vSLPartIVOs){
		if(vSLPartIVOs != null){
			VSLPartIVO[] tmpVOs = new VSLPartIVO[vSLPartIVOs.length];
			System.arraycopy(vSLPartIVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vSLPartIVOs = tmpVOs;
		}
		//소스보안 2015.07.20
		//this. vSLPartIVOs = vSLPartIVOs;
	}
	

	public VSLPartIVO getVSLPartIVO(){
		return vSLPartIVO;
	}

	public VSLPartIVO[] getVSLPartIVOS(){
		VSLPartIVO[] rtnVOs =  null;
		if(this.vSLPartIVOs != null){
			rtnVOs = new VSLPartIVO[vSLPartIVOs.length];
			System.arraycopy(vSLPartIVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.20
		//return vSLPartIVOs;
	}
	

	public void setVesselInformationMgtConditionVO(VesselInformationMgtConditionVO vesselInformationMgtConditionVO) {
		this.vesselInformationMgtConditionVO = vesselInformationMgtConditionVO;
	}
	
	public VesselInformationMgtConditionVO getVesselInformationMgtConditionVO() {
		return vesselInformationMgtConditionVO;
	}

	public VesselVO getVesselVO() {
		return vesselVO;
	}

	public void setVesselVO(VesselVO vesselVO) {
		this.vesselVO = vesselVO;
	}

	public VesselVO[] getVesselVOs() {
		VesselVO[] rtnVOs =  null;
		if(this.vesselVOs != null){
			rtnVOs = new VesselVO[vesselVOs.length];
			System.arraycopy(vesselVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.20
		//return vesselVOs;
	}

	public void setVesselVOs(VesselVO[] vesselVOs) {
		if(vesselVOs != null){
			VesselVO[] tmpVOs = new VesselVO[vesselVOs.length];
			System.arraycopy(vesselVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vesselVOs = tmpVOs;
		}
		//소스보안 2015.07.20
		//this.vesselVOs = vesselVOs;
	}

}