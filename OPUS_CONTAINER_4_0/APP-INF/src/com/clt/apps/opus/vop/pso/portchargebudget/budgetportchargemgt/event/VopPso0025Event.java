/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopPso0025Event.java
*@FileTitle : Budget vs Actual
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 박명종
*@LastVersion : 1.0
* 2009.06.08 박명종
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.event;

import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.EstTgtVvdByMonVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * VOP_PSO_0025 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_PSO_0025HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author myoungjong park
 * @see VOP_PSO_0025HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopPso0025Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EstTgtVvdByMonVO estTgtVvdByMonVO = null;
	
	/**
	 * @param estTgtVvdByMonVO the estTgtVvdByMonVO to set
	 */
	public void setEstTgtVvdByMonVO(EstTgtVvdByMonVO estTgtVvdByMonVO) {
		this.estTgtVvdByMonVO = estTgtVvdByMonVO;
	}

	/**
	 * @return the estTgtVvdByMonVO
	 */
	public EstTgtVvdByMonVO getEstTgtVvdByMonVO() {
		return estTgtVvdByMonVO;
	}

}