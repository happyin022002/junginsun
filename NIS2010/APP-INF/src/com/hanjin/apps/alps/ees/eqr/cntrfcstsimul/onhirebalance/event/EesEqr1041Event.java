/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EesEqr1041Event.java
*@FileTitle : LT ST OW Plan & Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.13
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.08.13 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.onhirebalance.event;

import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.onhirebalance.vo.PlanAndApprovalConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.onhirebalance.vo.PlanAndApprovalVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_1041 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_1041HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dong-sun Moon
 * @see EES_EQR_1041HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr1041Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PlanAndApprovalVO planAndApprovalVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public PlanAndApprovalVO[] planAndApprovalVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PlanAndApprovalConditionVO planAndApprovalConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public PlanAndApprovalConditionVO[] planAndApprovalConditionVOs = null;
	
	public EesEqr1041Event(){}
	
	public void setPlanAndApprovalVO(PlanAndApprovalVO planAndApprovalVO){
		this. planAndApprovalVO = planAndApprovalVO;
	}

	public void setPlanAndApprovalVOS(PlanAndApprovalVO[] planAndApprovalVOs){
		this. planAndApprovalVOs = planAndApprovalVOs;
	}

	public PlanAndApprovalVO getPlanAndApprovalVO(){
		return planAndApprovalVO;
	}

	public PlanAndApprovalVO[] getPlanAndApprovalVOS(){
		return planAndApprovalVOs;
	}
	
	public void setPlanAndApprovalConditionVO(PlanAndApprovalConditionVO planAndApprovalConditionVO){
		this. planAndApprovalConditionVO = planAndApprovalConditionVO;
	}

	public void setPlanAndApprovalConditionVOS(PlanAndApprovalConditionVO[] planAndApprovalConditionVOs){
		this. planAndApprovalConditionVOs = planAndApprovalConditionVOs;
	}

	public PlanAndApprovalConditionVO getPlanAndApprovalConditionVO(){
		return planAndApprovalConditionVO;
	}

	public PlanAndApprovalConditionVO[] getPlanAndApprovalConditionVOS(){
		return planAndApprovalConditionVOs;
	}

}