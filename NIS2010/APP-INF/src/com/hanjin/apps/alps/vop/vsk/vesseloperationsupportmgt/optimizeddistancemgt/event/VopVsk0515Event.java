/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0515Event.java
*@FileTitle : Optimized Distance Table
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.12
*@LastModifier : 정운
*@LastVersion : 1.0
* 2014.02.12 정운
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.event;

import java.util.List;

import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.vo.OptimizedDistanceVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.vo.VesselInformationMgtConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VOP_VSK_0515 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0515HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeong Un
 * @see VOP_VSK_0515HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopVsk0515Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	 
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OptimizedDistanceVO optimizedDistanceVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private OptimizedDistanceVO[] optimizedDistanceVOs = null;

	private List<String> keys = null;
	
	private VesselInformationMgtConditionVO vesselInformationMgtConditionVO = null;
	


 

	
	public VopVsk0515Event(){}

	public OptimizedDistanceVO getOptimizedDistanceVO() {
		return optimizedDistanceVO;
	}

	public void setOptimizedDistanceVO(OptimizedDistanceVO optimizedDistanceVO) {
		this.optimizedDistanceVO = optimizedDistanceVO;
	}

	public OptimizedDistanceVO[] getOptimizedDistanceVOs() {
		OptimizedDistanceVO[] rtnVOs =  null;
		if(this.optimizedDistanceVOs != null){
			rtnVOs = new OptimizedDistanceVO[optimizedDistanceVOs.length];
			System.arraycopy(optimizedDistanceVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return optimizedDistanceVOs;
	}

	public void setOptimizedDistanceVOs(OptimizedDistanceVO[] optimizedDistanceVOs) {
		if(optimizedDistanceVOs != null){
			OptimizedDistanceVO[] tmpVOs = new OptimizedDistanceVO[optimizedDistanceVOs.length];
			System.arraycopy(optimizedDistanceVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.optimizedDistanceVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.optimizedDistanceVOs = optimizedDistanceVOs;
	}
	
	public List<String> getKeys() {
		return keys;
	}

	public void setKeys(List<String> keys) {
		this.keys = keys;
	}
	
	public void setVesselInformationMgtConditionVO(VesselInformationMgtConditionVO vesselInformationMgtConditionVO) {
		this.vesselInformationMgtConditionVO = vesselInformationMgtConditionVO;
	}
	
	public VesselInformationMgtConditionVO getVesselInformationMgtConditionVO() {
		return vesselInformationMgtConditionVO;
	}
	 
	

}