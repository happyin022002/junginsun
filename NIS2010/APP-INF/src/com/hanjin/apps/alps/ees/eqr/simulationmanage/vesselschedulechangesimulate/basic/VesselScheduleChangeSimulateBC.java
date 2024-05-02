/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselScheduleChangeSimulateBC.java
*@FileTitle : Vessel Schedule 변경 Simulation 조회/수정
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.14 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.simulationmanage.vesselschedulechangesimulate.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.eqr.simulationmanage.vesselschedulechangesimulate.vo.EesEqr0011ConditionVO;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.vesselschedulechangesimulate.vo.SearchVesselPlanCompareVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.vo.EesEqr0049ConditionVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.EqrScnrVslSkdVO;

/**
 * ENIS-EQR Business Logic Command Interface<br>
 * - ENIS-EQR에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author sangyool pak
 * @see EES_EQR_011EventResponse 참조
 * @since J2EE 1.4
 */
public interface VesselScheduleChangeSimulateBC  {

	// Change Vessel Schedule - Data Analysis
    /**
     * 조회 이벤트 처리<br>
     * EES_EQR_0011 화면에 대한 조회 이벤트 처리<br>
     * 
     * @param condiVO	EesEqr0011ConditionVO
     * @return List<SearchVesselPlanCompareVO>
     * @exception EventException
     */
	public List<SearchVesselPlanCompareVO> searchVesselPlanCompare(EesEqr0011ConditionVO condiVO) throws EventException;
    /**
     * 멀티 이벤트 처리<br>
     * EES_EQR_0101 화면에 대한 멀티 이벤트 처리<br>
     * 
     * @param condiVO	EesEqr0011ConditionVO
     * @param vos		EqrScnrVslSkdVO[]
     * @param account	SignOnUserAccount
     * @exception EventException
     */
	public void createNewVesselPlan(EesEqr0011ConditionVO condiVO ,EqrScnrVslSkdVO[] vos , SignOnUserAccount account) throws EventException;
    /**
     * 멀티 이벤트 처리<br>
     * EES_EQR_0011 화면에 대한 멀티 이벤트 처리<br>
     * 
     * @param condiVO	EesEqr0049ConditionVO
     * @param userid	String
     * @exception EventException
     */
	 public void reRunVesselPlan( EesEqr0049ConditionVO condiVO ,String userid) throws EventException;
	/**
     * 멀티 이벤트 처리<br>
     * EES_EQR_0011 화면에 대한 멀티 이벤트 처리<br>
     * 
     * @param e EES_EQR_011Event
     * @return EventResponse EES_EQR_002EventResponse
     * @exception EventException
     */
	//public void receiveEqr0011Rerun(String str) throws EventException;
	/**
     * 멀티 이벤트 처리<br>
     * EES_EQR_0011 화면에 대한 멀티 이벤트 처리<br>
     * 
     * @param condiVO		EesEqr0011ConditionVO
     * @param repoPlanId	String
     * @param account		SignOnUserAccount
     * @exception EventException
     */
	public void reRunCallJMS(EesEqr0011ConditionVO condiVO , String repoPlanId , SignOnUserAccount account) throws EventException;

}