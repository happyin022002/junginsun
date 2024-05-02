/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ITurnTimePerformanceFinderBC.java
*@FileTitle : Turn Time by Port
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.04.24 박광석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo.TTSearchOptionInGereralVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo.TurnAroundTimeInGeneralVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo.TurnAroundTimeSearchOptionVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo.TurnTimeByMonthlyWeeklyTrendSetVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo.TurnTimeByTypeSizeVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo.TurnTimeByMvmtCntrListVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-Cntroperationperformancemgt Business Logic Command Interface<br>
 * - ALPS-Cntroperationperformancemgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Prak Kwang Seok
 * @see CNTROperatioNPerformanceMgtSC 참조
 * @since J2EE 1.4
 */

public interface TurnTimePerformanceMgtBC {
	/**
	 * PortTurnTimeListByPort Detail Tab을 조회합니다.<br>
	 * 
	 * @param tTSearchOptionIngereralVo
	 * @return List<TurnTimeByTypeSizeVO>
	 * @exception EventException
	 */
	public List<TurnTimeByTypeSizeVO> searchPortTurnTimeListByPortDetail(TTSearchOptionInGereralVO tTSearchOptionIngereralVo) throws EventException;
	/**
	 * PortTurnTimeListByPort Summary Tab을 조회합니다.<br>
	 * 
	 * @param tTSearchOptionIngereralVo
	 * @return  List<TurnTimeByTypeSizeVO>
	 * @exception EventException
	 */
	public List<TurnTimeByTypeSizeVO> searchPortTurnTimeListByPortSummary(TTSearchOptionInGereralVO tTSearchOptionIngereralVo) throws EventException;
	/**
	 * TurnTimeListByLaneVVD Summary Tab을 조회합니다.<br>
	 * 
	 * @param tTSearchOptionIngereralVo
	 * @return List<TurnTimeByTypeSizeVO>
	 * @exception EventException
	 */
	public List<TurnTimeByTypeSizeVO> searchPortTurnTimeListByLaneVVDSummary(TTSearchOptionInGereralVO tTSearchOptionIngereralVo) throws EventException;
	/**
	 * TurnTimeListByLaneVVD Detail Tab을 조회합니다.<br>
	 * 
	 * @param tTSearchOptionIngereralVo
	 * @return List<TurnTimeByTypeSizeVO>
	 * @exception EventException
	 */
	public List<TurnTimeByTypeSizeVO> searchPortTurnTimeListByLaneVVDDetail(TTSearchOptionInGereralVO tTSearchOptionIngereralVo) throws EventException;

	/**
	 * PortTurnTimeLane List을 조회합니다.<br>
	 * 
	 * @param pol
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchYardList(String pol) throws EventException;	

	/**
	 * Yard List을 조회합니다.<br>
	 * 
	 * @param period
	 * @param from
	 * @param to
	 * @param pol
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchPortTurnTimeLaneList(String period,String from,String to,String pol) throws EventException;	

	
	/**
	 * PortTurnTimeVVD List을 조회합니다.<br>
	 * 
	 * @param period
	 * @param from
	 * @param to
	 * @param pol
	 * @param lane
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchPortTurnTimeVVDList(String period,String from,String to,String pol,String lane) throws EventException;	
	
	/**
	 * LocationTurnTime Detail Tab 을 조회합니다.<br>
	 * 
	 * @param tTSearchOptionInGereralVO
	 * @return TurnTimeByMonthlyWeeklyTrendSetVO
	 * @exception EventException
	 */
	public TurnTimeByMonthlyWeeklyTrendSetVO searchLocationTurnTimeDetail(TTSearchOptionInGereralVO tTSearchOptionInGereralVO) throws EventException;
	/**
	 * LocationTurnTime Summary Tab 을 조회합니다.<br>
	 * 
	 * @param tTSearchOptionInGereralVO
	 * @return TurnTimeByMonthlyWeeklyTrendSetVO
	 * @exception EventException
	 */
	public TurnTimeByMonthlyWeeklyTrendSetVO searchLocationTurnTimeSummary(TTSearchOptionInGereralVO tTSearchOptionInGereralVO) throws EventException;
	
	/**
	 * TurnAroundTimeByTradeLane Tab 을 조회합니다.<br>
	 * 
	 * @param turnAroundTimeSearchOptionVO
	 * @return List<TurnAroundTimeInGeneralVO>
	 * @exception EventException
	 */
	public List<TurnAroundTimeInGeneralVO> searchTurnAroundTimeByTradeLane(TurnAroundTimeSearchOptionVO turnAroundTimeSearchOptionVO) throws EventException;


	/**
	 * TurnAroundTimeByTPSZTrade Tab 을 조회합니다.<br>
	 * 
	 * @param turnAroundTimeSearchOptionVO
	 * @return List<TurnAroundTimeInGeneralVO>
	 * @exception EventException
	 */
	public List<TurnAroundTimeInGeneralVO> searchTurnAroundTimeByTPSZTrade(TurnAroundTimeSearchOptionVO turnAroundTimeSearchOptionVO) throws EventException;


	/**
	 * TurnAroundTimeByLocation Tab 을 조회합니다.<br>
	 * 
	 * @param turnAroundTimeSearchOptionVO
	 * @return List<TurnAroundTimeInGeneralVO>
	 * @exception EventException
	 */
	public List<TurnAroundTimeInGeneralVO> searchTurnAroundTimeByLocation(TurnAroundTimeSearchOptionVO turnAroundTimeSearchOptionVO) throws EventException;

	/**
	 * TurnTimeByMovement 를 조회합니다.<br>
	 *  
	 * @param tTSearchOptionIngereralVo
	 * @return List<TurnTimeByTypeSizeVO>
	 * @exception EventException
	 */
	public List<TurnTimeByTypeSizeVO> searchTurnTimeByMovement(TTSearchOptionInGereralVO tTSearchOptionIngereralVo) throws EventException;

	
	/**
	 * TurnTimeByMovementDetail Tab 을 조회합니다.<br>
	 * 
	 * @param tTSearchOptionIngereralVo
	 * @return List<TurnTimeByTypeSizeVO>
	 * @exception EventException
	 */
	public List<TurnTimeByTypeSizeVO> searchTurnTimeByMovementDetail(TTSearchOptionInGereralVO tTSearchOptionIngereralVo) throws EventException;

	/**
	 * T/Time by MVMT CNTR (Detail) 을 조회합니다.<br>
	 * 
	 * @param tTSearchOptionIngereralVo
	 * @return List<TurnTimeByMvmtCntrListVO>
	 * @exception EventException
	 */
	public List<TurnTimeByMvmtCntrListVO> searchTurnTimeByMvmtCntrList(TTSearchOptionInGereralVO tTSearchOptionIngereralVo) throws EventException;

}