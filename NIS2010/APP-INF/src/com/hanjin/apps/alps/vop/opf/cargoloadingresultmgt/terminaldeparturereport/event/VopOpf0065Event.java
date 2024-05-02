/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopOpf0065Event.java
*@FileTitle : Fleet Status
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0 
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event;

import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.FleetStatusVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrListOptionVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 *  VOP_OPF_0065에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_0065HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi, DukWoo
 * @see VOP_OPF_0065HTMLAction 참조 
 * @since J2EE 1.6 JobCodeAdjustReqGRPVO
 */
public class VopOpf0065Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private FleetStatusVO fleetStatusVO = null;

	/** Table Value Object Multi Data 처리 */
	private FleetStatusVO[] fleetStatusVOs = null;

	public VopOpf0065Event(){}
	

	public FleetStatusVO getFleetStatusVO() {
		return fleetStatusVO;
	}

	public void setFleetStatusVO(FleetStatusVO fleetStatusVO) {
		this.fleetStatusVO = fleetStatusVO;
	}

	public FleetStatusVO[] getFleetStatusVOs() {
		FleetStatusVO[] rtnVOs = null;
 		
 		if (this.fleetStatusVOs != null) {
 			rtnVOs = new FleetStatusVO[fleetStatusVOs.length];
 			System.arraycopy(fleetStatusVOs, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;
	}

	public void setFleetStatusVOs(FleetStatusVO[] fleetStatusVOs) {
		if (fleetStatusVOs != null) {
			FleetStatusVO[] tmpVOs = new FleetStatusVO[fleetStatusVOs.length];
			System.arraycopy(fleetStatusVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.fleetStatusVOs = tmpVOs;
		}
	}

}
