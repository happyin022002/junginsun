/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EesEqr1041Event.java
*@FileTitle : LT ST OW Plan & Approval
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrfcstsimul.onhirebalance.event;

import com.clt.apps.opus.ees.eqr.cntrfcstsimul.onhirebalance.vo.PlanAndApprovalConditionVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.onhirebalance.vo.PlanAndApprovalVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_1041 PDTO(Data Transfer Object including Parameters)<br>
 * @author 
 * @see EES_EQR_1041HTMLAction 
 * @since J2EE 1.6
 */

public class EesEqr1041Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object   */
	private PlanAndApprovalVO planAndApprovalVO = null;
	
	/** Table Value Object Multi Data  */
	private PlanAndApprovalVO[] planAndApprovalVOs = null;

	/** Table Value Object  */
	private PlanAndApprovalConditionVO planAndApprovalConditionVO = null;
	
	/** Table Value Object Multi Data  */
	private PlanAndApprovalConditionVO[] planAndApprovalConditionVOs = null;
	
	public EesEqr1041Event(){}
	
	public void setPlanAndApprovalVO(PlanAndApprovalVO planAndApprovalVO){
		this. planAndApprovalVO = planAndApprovalVO;
	}

	public void setPlanAndApprovalVOS(PlanAndApprovalVO[] planAndApprovalVOs){
		if (planAndApprovalVOs != null) {
			PlanAndApprovalVO[] tmpVOs = new PlanAndApprovalVO[planAndApprovalVOs.length];
			System.arraycopy(planAndApprovalVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.planAndApprovalVOs = tmpVOs;
		}
	}

	public PlanAndApprovalVO getPlanAndApprovalVO(){
		return planAndApprovalVO;
	}

	public PlanAndApprovalVO[] getPlanAndApprovalVOS(){
		PlanAndApprovalVO[] tmpVOs = null;
		if (this.planAndApprovalVOs != null) {
			tmpVOs = new PlanAndApprovalVO[planAndApprovalVOs.length];
			System.arraycopy(planAndApprovalVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public void setPlanAndApprovalConditionVO(PlanAndApprovalConditionVO planAndApprovalConditionVO){
		this. planAndApprovalConditionVO = planAndApprovalConditionVO;
	}

	public void setPlanAndApprovalConditionVOS(PlanAndApprovalConditionVO[] planAndApprovalConditionVOs){
		if (planAndApprovalConditionVOs != null) {
			PlanAndApprovalConditionVO[] tmpVOs = new PlanAndApprovalConditionVO[planAndApprovalConditionVOs.length];
			System.arraycopy(planAndApprovalConditionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.planAndApprovalConditionVOs = tmpVOs;
		}
	}

	public PlanAndApprovalConditionVO getPlanAndApprovalConditionVO(){
		return planAndApprovalConditionVO;
	}

	public PlanAndApprovalConditionVO[] getPlanAndApprovalConditionVOS(){
		PlanAndApprovalConditionVO[] tmpVOs = null;
		if (this.planAndApprovalConditionVOs != null) {
			tmpVOs = new PlanAndApprovalConditionVO[planAndApprovalConditionVOs.length];
			System.arraycopy(planAndApprovalConditionVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}