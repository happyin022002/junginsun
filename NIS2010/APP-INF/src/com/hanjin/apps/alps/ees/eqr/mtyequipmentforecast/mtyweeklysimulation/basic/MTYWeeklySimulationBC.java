/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MTYWeeklySimulationBC.java
*@FileTitle : MTY Weekly Simulation Report
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.27
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2009.07.23 나상보
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyweeklysimulation.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyweeklysimulation.vo.MtyWeeklySimulationOptionVO;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyweeklysimulation.vo.MtyWeeklySimulationVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-MTYWeeklySimulation Business Logic Command Interface<br>
 * - ALPS-MTYWeeklySimulation 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author la sang bo
 * @see Ees_cim_5010EventResponse 참조
 * @since J2EE 1.6
 */

public interface MTYWeeklySimulationBC {

	/**
	 *  지점별로 향후 -1~+4 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력된 MTY Balance Data를 조회한다.<br>
	 * 
	 * @param MtyWeeklySimulationOptionVO mtyWeeklySimulationOptionVO
	 * @return List<MtyWeeklySimulationVO>
	 * @throws DAOException
	 */
	public List<MtyWeeklySimulationVO> searchMtyWeeklySimulation(MtyWeeklySimulationOptionVO mtyWeeklySimulationOptionVO) throws EventException;
	 
	/**
	 * User의 Office level을 체크
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String checkMtyBalanceRepoOutYard(String ofcCd) throws EventException;
	 
	/**
	 * 해당 셀의 원래 값을 조회<br>
	 * 
	 * @param MtyWeeklySimulationOptionVO mtyWeeklySimulationOptionVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchMtyWeeklySimulationOrigin(MtyWeeklySimulationOptionVO mtyWeeklySimulationOptionVO) throws EventException;
	 
	 /**
	 * mty weekly data를 신규 입력/수정<br>
	 * 
	 * @param MtyWeeklySimulationOptionVO[] mtyWeeklySimulationOptionVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageMtyWeeklySimulation(MtyWeeklySimulationOptionVO[] mtyWeeklySimulationOptionVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 *  지점별로 이전 수 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력된 MTY Balance Data를 조회한다.<br>
	 * 
	 * @param MtyWeeklySimulationOptionVO mtyWeeklySimulationOptionVO
	 * @return String
	 * @throws EventException
	 */
	public String searchMtyWeeklySimulationReportTitle(MtyWeeklySimulationOptionVO mtyWeeklySimulationOptionVO) throws EventException; 

	/**
	 *  지점별로 이전 수 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력된 MTY Balance Data를 조회한다.<br>
	 * 
	 * @param MtyWeeklySimulationOptionVO mtyWeeklySimulationOptionVO
	 * @param String rptTtl
	 * @return CommonRsVO
	 * @throws EventException
	 */
	public CommonRsVO searchMtyWeeklySimulationReport(MtyWeeklySimulationOptionVO mtyWeeklySimulationOptionVO, String rptTtl) throws EventException;
	
	/**
	 * 입력 받은 rcc/lcc/ecc가 해당 rcc에 속하는지 체크
	 * 
	 * @param MtyWeeklySimulationOptionVO mtyWeeklySimulationOptionVO
	 * @return String
	 * @exception EventException
	 */
	 @SuppressWarnings("unchecked")
	public String checkSubLocCd(MtyWeeklySimulationOptionVO mtyWeeklySimulationOptionVO) throws EventException;
}