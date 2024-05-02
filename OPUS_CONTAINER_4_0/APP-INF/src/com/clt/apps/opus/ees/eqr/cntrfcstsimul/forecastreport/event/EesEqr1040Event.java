/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr1040Event.java
*@FileTitle : Planned Repo In
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrfcstsimul.forecastreport.event;

import com.clt.apps.opus.ees.eqr.cntrfcstsimul.forecastreport.vo.EesEqr1048ConditionVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.forecastreport.vo.PlannedRepoInVO;
import com.clt.framework.support.layer.event.EventSupport;

 
/**
 * EES_EQR_1040 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_1040HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_EQR_1040HTMLAction 참조
 * @since J2EE 1.6 
 */

public class EesEqr1040Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr1048ConditionVO eesEqr1048ConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private EesEqr1048ConditionVO[] eesEqr1048ConditionVOs = null;

	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PlannedRepoInVO plannedRepoInVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PlannedRepoInVO[] plannedRepoInVOs = null;

	public EesEqr1040Event(){}
	
	public void setEesEqr1048ConditionVO(EesEqr1048ConditionVO eesEqr1048ConditionVO){
		this. eesEqr1048ConditionVO = eesEqr1048ConditionVO;
	}

	public void setEesEqr1048ConditionVOS(EesEqr1048ConditionVO[] eesEqr1048ConditionVOs){
		if (eesEqr1048ConditionVOs != null) {
			EesEqr1048ConditionVO[] tmpVOs = new EesEqr1048ConditionVO[eesEqr1048ConditionVOs.length];
			System.arraycopy(eesEqr1048ConditionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eesEqr1048ConditionVOs = tmpVOs;
		}
	}
	public EesEqr1048ConditionVO getEesEqr1048ConditionVO(){
		return eesEqr1048ConditionVO;
	}

	public EesEqr1048ConditionVO[] getEesEqr1048ConditionVOS(){
		EesEqr1048ConditionVO[] tmpVOs = null;
		if (this.eesEqr1048ConditionVOs != null) {
			tmpVOs = new EesEqr1048ConditionVO[eesEqr1048ConditionVOs.length];
			System.arraycopy(eesEqr1048ConditionVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	
	public void setPlannedRepoInVO(PlannedRepoInVO plannedRepoInVO){
		this. plannedRepoInVO = plannedRepoInVO;
	}

	public void setPlannedRepoInVOS(PlannedRepoInVO[] plannedRepoInVOs){
		if (plannedRepoInVOs != null) {
			PlannedRepoInVO[] tmpVOs = new PlannedRepoInVO[plannedRepoInVOs.length];
			System.arraycopy(plannedRepoInVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.plannedRepoInVOs = tmpVOs;
		}
	}
	public PlannedRepoInVO getPlannedRepoInVO(){
		return plannedRepoInVO;
	}

	public PlannedRepoInVO[] getPlannedRepoInVOS(){
		PlannedRepoInVO[] tmpVOs = null;
		if (this.plannedRepoInVOs != null) {
			tmpVOs = new PlannedRepoInVO[plannedRepoInVOs.length];
			System.arraycopy(plannedRepoInVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}	
}