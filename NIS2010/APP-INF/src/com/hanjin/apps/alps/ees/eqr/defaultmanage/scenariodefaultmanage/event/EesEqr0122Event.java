/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0122Event.java
*@FileTitle : HJL Domestic
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.07.20 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.event;

import java.util.List;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchDefaultYearDomesticPlanVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0122ConditionVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.ScenarioDefaultManageRsVO;
import com.hanjin.syscommon.common.table.EqrDmstPerfVO;
import com.hanjin.syscommon.common.table.EqrDmstPlnVO;
/**
 * EES_EQR_0122 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0122HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Chae Change Ho
 * @see EES_EQR_0122HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0122Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchDefaultYearDomesticPlanVO searchDefaultYearDomesticPlan = null;
	
	/** Table Value Object Multi Data 처리 */
	public SearchDefaultYearDomesticPlanVO[] searchDefaultYearDomesticPlans = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr0122ConditionVO eesEqr0122ConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EesEqr0122ConditionVO[] eesEqr0122ConditionVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScenarioDefaultManageRsVO scenarioDefaultManageRsVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public ScenarioDefaultManageRsVO[] scenarioDefaultManageRsVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private List<String> month = null;
	

	/** Table Value Object 조회 조건 및 단건 처리  */
	private EqrDmstPerfVO eqrDmstPerfVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EqrDmstPerfVO[] eqrDmstPerfVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EqrDmstPlnVO eqrDmstPlnVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EqrDmstPlnVO[] eqrDmstPlnVOs = null;
   
	
	public EesEqr0122Event(){}
	
	public void setsearchDefaultYearDomesticPlan(SearchDefaultYearDomesticPlanVO searchDefaultYearDomesticPlan){
		this. searchDefaultYearDomesticPlan = searchDefaultYearDomesticPlan;
	}

	public void setsearchDefaultYearDomesticPlanS(SearchDefaultYearDomesticPlanVO[] searchDefaultYearDomesticPlans){
		this. searchDefaultYearDomesticPlans = searchDefaultYearDomesticPlans;
	}

	public SearchDefaultYearDomesticPlanVO getsearchDefaultYearDomesticPlan(){
		return searchDefaultYearDomesticPlan;
	}

	public SearchDefaultYearDomesticPlanVO[] getsearchDefaultYearDomesticPlanS(){
		return searchDefaultYearDomesticPlans;
	}

	/**
	 * @return the eesEqr0122ConditionVO
	 */
	public EesEqr0122ConditionVO getEesEqr0122ConditionVO() {
		return eesEqr0122ConditionVO;
	}

	/**
	 * @param eesEqr0122ConditionVO the eesEqr0122ConditionVO to set
	 */
	public void setEesEqr0122ConditionVO(EesEqr0122ConditionVO eesEqr0122ConditionVO) {
		this.eesEqr0122ConditionVO = eesEqr0122ConditionVO;
	}

	/**
	 * @return the eesEqr0122ConditionVOs
	 */
	public EesEqr0122ConditionVO[] getEesEqr0122ConditionVOs() {
		return eesEqr0122ConditionVOs;
	}

	/**
	 * @param eesEqr0122ConditionVOs the eesEqr0122ConditionVOs to set
	 */
	public void setEesEqr0122ConditionVOs(
			EesEqr0122ConditionVO[] eesEqr0122ConditionVOs) {
		this.eesEqr0122ConditionVOs = eesEqr0122ConditionVOs;
	}

	/**
	 * @return the scenarioDefaultManageRsVO
	 */
	public ScenarioDefaultManageRsVO getScenarioDefaultManageRsVO() {
		return scenarioDefaultManageRsVO;
	}

	/**
	 * @param scenarioDefaultManageRsVO the scenarioDefaultManageRsVO to set
	 */
	public void setScenarioDefaultManageRsVO(ScenarioDefaultManageRsVO scenarioDefaultManageRsVO) {
		this.scenarioDefaultManageRsVO = scenarioDefaultManageRsVO;
	}

	/**
	 * @return the scenarioDefaultManageRsVOs
	 */
	public ScenarioDefaultManageRsVO[] getScenarioDefaultManageRsVOs() {
		return scenarioDefaultManageRsVOs;
	}

	/**
	 * @param scenarioDefaultManageRsVOs the scenarioDefaultManageRsVOs to set
	 */
	public void setScenarioDefaultManageRsVOs(ScenarioDefaultManageRsVO[] scenarioDefaultManageRsVOs) {
		this.scenarioDefaultManageRsVOs = scenarioDefaultManageRsVOs;
	}

	/**
	 * @return the month
	 */
	public List<String> getMonth() {
		return month;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(List<String> month) {
		this.month = month;
	}

	/**
	 * @return the eqrDmstPerfVO
	 */
	public EqrDmstPerfVO getEqrDmstPerfVO() {
		return eqrDmstPerfVO;
	}

	/**
	 * @param eqrDmstPerfVO the eqrDmstPerfVO to set
	 */
	public void setEqrDmstPerfVO(EqrDmstPerfVO eqrDmstPerfVO) {
		this.eqrDmstPerfVO = eqrDmstPerfVO;
	}

	/**
	 * @return the eqrDmstPerfVOs
	 */
	public EqrDmstPerfVO[] getEqrDmstPerfVOs() {
		return eqrDmstPerfVOs;
	}

	/**
	 * @param eqrDmstPerfVOs the eqrDmstPerfVOs to set
	 */
	public void setEqrDmstPerfVOs(EqrDmstPerfVO[] eqrDmstPerfVOs) {
		this.eqrDmstPerfVOs = eqrDmstPerfVOs;
	}

	/**
	 * @return the eqrDmstPlnVO
	 */
	public EqrDmstPlnVO getEqrDmstPlnVO() {
		return eqrDmstPlnVO;
	}

	/**
	 * @param eqrDmstPlnVO the eqrDmstPlnVO to set
	 */
	public void setEqrDmstPlnVO(EqrDmstPlnVO eqrDmstPlnVO) {
		this.eqrDmstPlnVO = eqrDmstPlnVO;
	}

	/**
	 * @return the eqrDmstPlnVOs
	 */
	public EqrDmstPlnVO[] getEqrDmstPlnVOs() {
		return eqrDmstPlnVOs;
	}

	/**
	 * @param eqrDmstPlnVOs the eqrDmstPlnVOs to set
	 */
	public void setEqrDmstPlnVOs(EqrDmstPlnVO[] eqrDmstPlnVOs) {
		this.eqrDmstPlnVOs = eqrDmstPlnVOs;
	}

	
}
