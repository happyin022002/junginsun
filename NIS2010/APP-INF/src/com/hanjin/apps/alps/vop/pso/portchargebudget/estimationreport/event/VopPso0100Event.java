/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopPso0100Event.java
*@FileTitle : Estimation Report
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.18
*@LastModifier : S.K.Y
*@LastVersion : 1.0
* 2013.03.18 S.K.Y
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.event;

import com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.vo.EstimationByVvdVO;
import com.hanjin.framework.support.layer.event.EventSupport;



/**
 * VOP_PSO-0100 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - VOP_PSO-0100HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author S.K.Y
 * @see VOP_PSO-0009HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopPso0100Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
		
	/** EstimationByVvdVO*/

	private EstimationByVvdVO estimationByVvdVO = null;


	/**
	 * @return the estimationByVvdVO
	 */
	public EstimationByVvdVO getEstimationByVvdVO() {
		return estimationByVvdVO;
	}


	/**
	 * @param estimationByVvdVO the estimationByVvdVO to set
	 */
	public void setEstimationByVvdVO(EstimationByVvdVO estimationByVvdVO) {
		
		this.estimationByVvdVO = estimationByVvdVO;
	}


	
	
	

	
	


}