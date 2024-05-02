/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneExpenseRatioMgtBC.java
*@FileTitle : Bank Information 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.04.30 김진일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portchargebudget.laneexpenseratiomgt.basic;

import java.util.List;

import com.clt.apps.opus.vop.pso.portchargebudget.laneexpenseratiomgt.vo.ServiceLaneListVO;
import com.clt.apps.opus.vop.pso.portchargebudget.laneexpenseratiomgt.vo.SvcLaneVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-Portchargebudget Business Logic Command Interface<br>
 *
 * @author
 * @see Reference Vso_pso_0006EventResponse 
 * @since J2EE 1.6
 */

public interface LaneExpenseRatioMgtBC {

	/**
	 * Show Service Lane List registered by PSO_PORT_EXPN_DIV table standard <br>
	 * @return List<SvcLaneVO>
	 * @throws EventException 
	 */
	public List<SvcLaneVO> searchLaneExpenseRatioKeyValue() throws EventException;

	/**
	 * PSO PORT EXPENSE DIVISION table Select<br>
	 * @param vslSlanCd
	 * @return List<ServiceLaneListVO>
	 */
	public List<ServiceLaneListVO> searchPsoPortExpenseDivision(String vslSlanCd) throws EventException;

	/**
	 * Retrieve Standard P/F SKD Detail info created by lane code input <br>
	 * @param vslSlanCd
	 * @return List<ServiceLaneListVO>
	 */
	public List<ServiceLaneListVO> searchPfSkdDetail(String vslSlanCd) throws EventException;

	/**
	 * Retrieve Standard P/F Type Code and service separator on Service Lane Code input <br>
	 * @param vslSlanCd
	 * @return List<SvcLaneVO>
	 */
	public List<SvcLaneVO> searchPfLaneTypeList(String vslSlanCd) throws EventException;

	/**
	 * save Lane/Port Expense Ratio Creation 
	 * @param svcLaneVO
	 * @param serviceLaneListVO
	 * @param account
	 */
	public void manageLaneExpnRto(SvcLaneVO[] svcLaneVO, ServiceLaneListVO[] serviceLaneListVO, SignOnUserAccount account) throws EventException;

	/**
	 * Rev.Lane & Rev.direction, Direction 존채 하는지 조회.
	 * 
	 * @param ServiceLaneListVO serviceLaneListVO
	 * @return String
	 * @throws EventException
	 */
	public String searchRevenueDirection(ServiceLaneListVO serviceLaneListVO) throws EventException;

	/**
	 * Rev.direction by Rev.Lane , Direction 조회.
	 * 
	 * @param ServiceLaneListVO serviceLaneListVO
	 * @return String
	 * @throws EventException
	 */
	public String searchRevenueDirectionByRevLane(ServiceLaneListVO serviceLaneListVO) throws EventException;
}