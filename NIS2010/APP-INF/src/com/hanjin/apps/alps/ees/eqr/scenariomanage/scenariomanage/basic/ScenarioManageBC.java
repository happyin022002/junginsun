/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScenarioManageBC.java
*@FileTitle : Inquire Scenario ID List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.07.22 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.vo.EesEqr0002ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.vo.EesEqr0111ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.vo.SearchScenarioIDListVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.vo.SearchVesselScheduleInfoVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.EqrScnrMstVO;
import com.hanjin.syscommon.common.table.EqrScnrVslSkdVO;

/**
 * ALPS-Scenariomanage Business Logic Command Interface<br>
 * - ALPS-Scenariomanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Haeng-ji,Lee
 * @see Ees_eqr_0002EventResponse 참조
 * @since J2EE 1.6
 */

public interface ScenarioManageBC {

	/**
	 * [EES_EQR_0002 : Scenario - Create/Update 조회]<br>
	 * 
	 * @param eesEqr0002ConditionVO	EesEqr0002ConditionVO
	 * @return List<SearchScenarioIDListVO>
	 * @exception EventException
	 */
	public List<SearchScenarioIDListVO> searchScenarioIDList(EesEqr0002ConditionVO eesEqr0002ConditionVO) throws EventException;
	
	/**
	 * [EES_EQR_0002 : Scenario - Create/Update - 시나리오 Copy ]<br>
	 * 
	 * @param eesEqr0002ConditionVO EesEqr0002ConditionVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createNewScenarioID(EesEqr0002ConditionVO eesEqr0002ConditionVO,SignOnUserAccount account) throws EventException;
	
	
	/**
	 * [EES_EQR_0002 : Scenario - Create/Update 삭제 ]<br>
	 * 
	 * @param eqrScnrMstVO EqrScnrMstVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void removeScenarioID(EqrScnrMstVO[] eqrScnrMstVO,SignOnUserAccount account) throws EventException;
	/**
	 * 조회 이벤트 처리<br>
	 * EES_EQR_111 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO EesEqr0111ConditionVO
	 * @return List<SearchVesselScheduleInfoVO>
	 * @exception EventException
	 */
    public List<SearchVesselScheduleInfoVO> searchVesselScheduleInfo(EesEqr0111ConditionVO conditionVO) throws EventException;
    
    //  CSRNO : N200811110008 로 추가 시작 
    /**
	 * 멀티 이벤트 처리<br>
	 * EES_EQR_111 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO EesEqr0111ConditionVO
	 * @param vos EqrScnrVslSkdVO[]
	 * @param account SignOnUserAccount
	 * @return List<EqrScnrVslSkdVO>
	 * @exception EventException
	 */
    public List<EqrScnrVslSkdVO> modifyVesselSchedulePortInfo(EesEqr0111ConditionVO conditionVO ,EqrScnrVslSkdVO[] vos ,SignOnUserAccount account) throws EventException;
    
    /**
	 * 멀티 이벤트 처리<br>
	 * EES_EQR_111 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO EesEqr0111ConditionVO
	 * @param vos EqrScnrVslSkdVO[]
	 * @param account SignOnUserAccount
	 * @return List<EqrScnrVslSkdVO>
	 * @exception EventException
	 */
    public List<EqrScnrVslSkdVO> modifyNisCurrentVesselSchedulePortInfo(EesEqr0111ConditionVO conditionVO ,EqrScnrVslSkdVO[] vos ,SignOnUserAccount account) throws EventException;
    
    //  CSRNO : N200811110008 로 추가 시작 
	/**
	 * 조회 이벤트 처리<br>
	 * EES_EQR_111 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO EesEqr0111ConditionVO
	 * @return List<EqrScnrVslSkdVO>
	 * @exception EventException
	 */
    public List<EqrScnrVslSkdVO> searchVesselSchedulePortInfo(EesEqr0111ConditionVO conditionVO) throws EventException;
    
    /**
	 *  CSR No : N200904200110 - VVD Add 추가
	 *  EES_EQR_111 화면에 대한 VVD Add 저장 처리<br>
	 * 
	 * @param conditionVO EesEqr0111ConditionVO
	 * @param vos EqrScnrVslSkdVO[]
	 * @param account SignOnUserAccount
	 * @return List<EqrScnrVslSkdVO>
	 * @exception EventException
	 */
    public List<EqrScnrVslSkdVO> modifyVesselSchedulePortInfoAdd(EesEqr0111ConditionVO conditionVO ,EqrScnrVslSkdVO[] vos , SignOnUserAccount account) throws EventException;
}