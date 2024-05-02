/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopPso0006Event.java
*@FileTitle : Lane/Port Expense Ratio Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 박명종
*@LastVersion : 1.0
* 2009.05.27 박명종
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portchargebudget.laneexpenseratiomgt.event;

import com.clt.apps.opus.vop.pso.portchargebudget.laneexpenseratiomgt.vo.ServiceLaneListVO;
import com.clt.apps.opus.vop.pso.portchargebudget.laneexpenseratiomgt.vo.SvcLaneVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * VOP_PSO_0006 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_PSO_0006HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author myoungjong park
 * @see VOP_PSO_0006HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopPso0006Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private String vslSlanCd  = ""; //Lane CD
	private ServiceLaneListVO[] serviceLaneListVOs = null;
	private SvcLaneVO[] svcLaneVO = null;
	private ServiceLaneListVO serviceLaneListVO = null;

	public VopPso0006Event(){}


	/**
	 * @param vsl_slan_cd the vsl_slan_cd to set
	 */
	public void setVsl_slan_cd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}


	/**
	 * @return the vsl_slan_cd
	 */
	public String getVsl_slan_cd() {
		return vslSlanCd;
	}


	/**
	 * @param serviceLaneListVO the serviceLaneListVO to set
	 */
	public void setServiceLaneListVOS(ServiceLaneListVO[] serviceLaneListVOs) {
		if (serviceLaneListVOs != null) {
			ServiceLaneListVO[] tmpVOs = new ServiceLaneListVO[serviceLaneListVOs.length];
			System.arraycopy(serviceLaneListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.serviceLaneListVOs = tmpVOs;
		}
	}


	/**
	 * @return the serviceLaneListVO
	 */
	public ServiceLaneListVO[] getServiceLaneListVOS() {
		ServiceLaneListVO[] tmpVOs = null;
		if (this.serviceLaneListVOs != null) {
			tmpVOs = new ServiceLaneListVO[serviceLaneListVOs.length];
			System.arraycopy(serviceLaneListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}


	/**
	 * @param svcLaneVO the svcLaneVO to set
	 */
	public void setSvcLaneVO(SvcLaneVO[] svcLaneVO) {
		if (svcLaneVO != null) {
			SvcLaneVO[] tmpVOs = new SvcLaneVO[svcLaneVO.length];
			System.arraycopy(svcLaneVO, 0, tmpVOs, 0, tmpVOs.length);
			this.svcLaneVO = tmpVOs;
		}
	}


	/**
	 * @return the svcLaneVO
	 */
	public SvcLaneVO[] getSvcLaneVO() {
		SvcLaneVO[] tmpVOs = null;
		if (this.svcLaneVO != null) {
			tmpVOs = new SvcLaneVO[svcLaneVO.length];
			System.arraycopy(svcLaneVO, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}


	/**
	 * @return the serviceLaneListVO
	 */
	public ServiceLaneListVO getServiceLaneListVO() {
		return serviceLaneListVO;
	}


	/**
	 * @param serviceLaneListVO the serviceLaneListVO to set
	 */
	public void setServiceLaneListVO(ServiceLaneListVO serviceLaneListVO) {
		this.serviceLaneListVO = serviceLaneListVO;
	}
	


}