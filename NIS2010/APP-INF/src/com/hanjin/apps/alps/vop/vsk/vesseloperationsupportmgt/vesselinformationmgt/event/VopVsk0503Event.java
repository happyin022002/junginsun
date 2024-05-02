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
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.DockPlanListVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.LoadableListVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.LowestListVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.VSLPartIVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.VesselInformationMgtConditionVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.PerformanceInfoVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VesselVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.VSLPerformanceVO;

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
	private LowestListVO lowestListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private LowestListVO[] lowestListVOs = null;
	
	public PerformanceInfoVO getPerformanceInfoVO() {
		return performanceInfoVO;
	}

	public void setPerformanceInfoVO(PerformanceInfoVO performanceInfoVO) {
		this.performanceInfoVO = performanceInfoVO;
	}

	public PerformanceInfoVO[] getPerformanceInfoVOs() {
		PerformanceInfoVO[] rtnVOs =  null;
		if(this.performanceInfoVOs != null){
			rtnVOs = new PerformanceInfoVO[performanceInfoVOs.length];
			System.arraycopy(performanceInfoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.20
		//return performanceInfoVOs;
	}

	public void setPerformanceInfoVOs(PerformanceInfoVO[] performanceInfoVOs) {
		if(performanceInfoVOs != null){
			PerformanceInfoVO[] tmpVOs = new PerformanceInfoVO[performanceInfoVOs.length];
			System.arraycopy(performanceInfoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.performanceInfoVOs = tmpVOs;
		}
		//소스보안 2015.07.20
		//this.performanceInfoVOs = performanceInfoVOs;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PerformanceInfoVO performanceInfoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PerformanceInfoVO[] performanceInfoVOs = null;
	
	public LoadableListVO getLoadableListVO() {
		return loadableListVO;
	}

	public void setLoadableListVO(LoadableListVO loadableListVO) {
		this.loadableListVO = loadableListVO;
	}

	public LoadableListVO[] getLoadableListVOs() {
		LoadableListVO[] rtnVOs =  null;
		if(this.loadableListVOs != null){
			rtnVOs = new LoadableListVO[loadableListVOs.length];
			System.arraycopy(loadableListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.20
		//return loadableListVOs;
	}

	public void setLoadableListVOs(LoadableListVO[] loadableListVOs) {
		if(loadableListVOs != null){
			LoadableListVO[] tmpVOs = new LoadableListVO[loadableListVOs.length];
			System.arraycopy(loadableListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.loadableListVOs = tmpVOs;
		}
		//소스보안 2015.07.20
		//this.loadableListVOs = loadableListVOs;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private LoadableListVO loadableListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private LoadableListVO[] loadableListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private VSLPartIVO vSLPartIVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private VSLPartIVO[] vSLPartIVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VSLPerformanceVO vSLPerformanceVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private VSLPerformanceVO[] vSLPerformanceVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VesselVO vesselVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private VesselVO[] vesselVOs = null;

	private VesselInformationMgtConditionVO vesselInformationMgtConditionVO = null;
	
	public VopVsk0503Event(){}
	
	public void setDockPlanListVO(DockPlanListVO dockPlanListVO){
		this. dockPlanListVO = dockPlanListVO;
	}

	public void setDockPlanListVOS(DockPlanListVO[] dockPlanListVOs){
		if(dockPlanListVOs != null){
			DockPlanListVO[] tmpVOs = new DockPlanListVO[dockPlanListVOs.length];
			System.arraycopy(dockPlanListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.dockPlanListVOs = tmpVOs;
		}
		//소스보안 2015.07.20
		//this. dockPlanListVOs = dockPlanListVOs;
	}

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
	
	public void setVSLPerformanceVO(VSLPerformanceVO vSLPerformanceVO){
		this. vSLPerformanceVO = vSLPerformanceVO;
	}
	
	public void setVSLPerformanceVOS(VSLPerformanceVO[] vSLPerformanceVOs){
		if(vSLPerformanceVOs != null){
			VSLPerformanceVO[] tmpVOs = new VSLPerformanceVO[vSLPerformanceVOs.length];
			System.arraycopy(vSLPerformanceVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vSLPerformanceVOs = tmpVOs;
		}
		//소스보안 2015.07.20
		//this. vSLPerformanceVOs = vSLPerformanceVOs;
	}

	public DockPlanListVO getDockPlanListVO(){
		return dockPlanListVO;
	}

	public DockPlanListVO[] getDockPlanListVOS(){
		DockPlanListVO[] rtnVOs =  null;
		if(this.dockPlanListVOs != null){
			rtnVOs = new DockPlanListVO[dockPlanListVOs.length];
			System.arraycopy(dockPlanListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.20
		//return dockPlanListVOs;
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
	
	public VSLPerformanceVO getVSLPerformanceVO(){
		return vSLPerformanceVO;
	}
	
	public VSLPerformanceVO[] getVSLPerformanceVOS(){
		VSLPerformanceVO[] rtnVOs =  null;
		if(this.vSLPerformanceVOs != null){
			rtnVOs = new VSLPerformanceVO[vSLPerformanceVOs.length];
			System.arraycopy(vSLPerformanceVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.20
		//return vSLPerformanceVOs;
	}
	
	public LowestListVO getLowestListVO() {
		return lowestListVO;
	}

	public void setLowestListVO(LowestListVO lowestListVO) {
		this.lowestListVO = lowestListVO;
	}

	public LowestListVO[] getLowestListVOs() {
		LowestListVO[] rtnVOs =  null;
		if(this.lowestListVOs != null){
			rtnVOs = new LowestListVO[lowestListVOs.length];
			System.arraycopy(lowestListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.20
		//return lowestListVOs;
	}

	public void setLowestListVOs(LowestListVO[] lowestListVOs) {
		if(lowestListVOs != null){
			LowestListVO[] tmpVOs = new LowestListVO[lowestListVOs.length];
			System.arraycopy(lowestListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.lowestListVOs = tmpVOs;
		}
		//소스보안 2015.07.20
		//this.lowestListVOs = lowestListVOs;
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