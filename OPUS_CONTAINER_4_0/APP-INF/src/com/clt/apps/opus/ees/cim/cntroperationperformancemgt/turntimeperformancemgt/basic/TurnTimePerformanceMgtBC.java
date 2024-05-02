/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ITurnTimePerformanceFinderBC.java
*@FileTitle : Turn Time by Port
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.basic;

import java.util.List;

import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo.TTSearchOptionInGereralVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo.TurnAroundTimeInGeneralVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo.TurnAroundTimeSearchOptionVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo.TurnTimeByMonthlyWeeklyTrendSetVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo.TurnTimeByTypeSizeVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * OPUS-Cntroperationperformancemgt Business Logic Command Interface
 *
 * @author Prak Kwang Seok
 * @see CNTROperatioNPerformanceMgtSC reference
 * @since J2EE 1.4
 */

public interface TurnTimePerformanceMgtBC {
	/**
	 * retrieving PortTurnTimeListByPort Detail Tab
	 * 
	 * @param tTSearchOptionIngereralVo
	 * @return List<TurnTimeByTypeSizeVO>
	 * @exception EventException
	 */
	public List<TurnTimeByTypeSizeVO> searchPortTurnTimeListByPortDetail(TTSearchOptionInGereralVO tTSearchOptionIngereralVo) throws EventException;
	/**
	 * retrieving PortTurnTimeListByPort Summary Tab
	 * 
	 * @param tTSearchOptionIngereralVo
	 * @return  List<TurnTimeByTypeSizeVO>
	 * @exception EventException
	 */
	public List<TurnTimeByTypeSizeVO> searchPortTurnTimeListByPortSummary(TTSearchOptionInGereralVO tTSearchOptionIngereralVo) throws EventException;
	/**
	 * retrieving TurnTimeListByLaneVVD Summary Tab
	 * 
	 * @param tTSearchOptionIngereralVo
	 * @return List<TurnTimeByTypeSizeVO>
	 * @exception EventException
	 */
	public List<TurnTimeByTypeSizeVO> searchPortTurnTimeListByLaneVVDSummary(TTSearchOptionInGereralVO tTSearchOptionIngereralVo) throws EventException;
	/**
	 * retrieving TurnTimeListByLaneVVD Detail Tab
	 * 
	 * @param tTSearchOptionIngereralVo
	 * @return List<TurnTimeByTypeSizeVO>
	 * @exception EventException
	 */
	public List<TurnTimeByTypeSizeVO> searchPortTurnTimeListByLaneVVDDetail(TTSearchOptionInGereralVO tTSearchOptionIngereralVo) throws EventException;

	/**
	 * retrieving PortTurnTimeLane List
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
	 * retrieving PortTurnTimeVVD List
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
	 * retrieving LocationTurnTime Detail Tab
	 * 
	 * @param tTSearchOptionInGereralVO
	 * @return TurnTimeByMonthlyWeeklyTrendSetVO
	 * @exception EventException
	 */
	public TurnTimeByMonthlyWeeklyTrendSetVO searchLocationTurnTimeDetail(TTSearchOptionInGereralVO tTSearchOptionInGereralVO) throws EventException;
	/**
	 * retrieving LocationTurnTime Summary Tab
	 * 
	 * @param tTSearchOptionInGereralVO
	 * @return TurnTimeByMonthlyWeeklyTrendSetVO
	 * @exception EventException
	 */
	public TurnTimeByMonthlyWeeklyTrendSetVO searchLocationTurnTimeSummary(TTSearchOptionInGereralVO tTSearchOptionInGereralVO) throws EventException;
	
	/**
	 * retrieving TurnAroundTimeByTradeLane Tab
	 * 
	 * @param turnAroundTimeSearchOptionVO
	 * @return List<TurnAroundTimeInGeneralVO>
	 * @exception EventException
	 */
	public List<TurnAroundTimeInGeneralVO> searchTurnAroundTimeByTradeLane(TurnAroundTimeSearchOptionVO turnAroundTimeSearchOptionVO) throws EventException;


	/**
	 * retrieving TurnAroundTimeByTPSZTrade Tab
	 * 
	 * @param turnAroundTimeSearchOptionVO
	 * @return List<TurnAroundTimeInGeneralVO>
	 * @exception EventException
	 */
	public List<TurnAroundTimeInGeneralVO> searchTurnAroundTimeByTPSZTrade(TurnAroundTimeSearchOptionVO turnAroundTimeSearchOptionVO) throws EventException;


	/**
	 * retrieving TurnAroundTimeByLocation Tab
	 * 
	 * @param turnAroundTimeSearchOptionVO
	 * @return List<TurnAroundTimeInGeneralVO>
	 * @exception EventException
	 */
	public List<TurnAroundTimeInGeneralVO> searchTurnAroundTimeByLocation(TurnAroundTimeSearchOptionVO turnAroundTimeSearchOptionVO) throws EventException;

	/**
	 * retrieving TurnTimeByMovement
	 *  
	 * @param tTSearchOptionIngereralVo
	 * @return List<TurnTimeByTypeSizeVO>
	 * @exception EventException
	 */
	public List<TurnTimeByTypeSizeVO> searchTurnTimeByMovement(TTSearchOptionInGereralVO tTSearchOptionIngereralVo) throws EventException;

	
	/**
	 * retrieving TurnTimeByMovementDetail Tab
	 * 
	 * @param tTSearchOptionIngereralVo
	 * @return List<TurnTimeByTypeSizeVO>
	 * @exception EventException
	 */
	public List<TurnTimeByTypeSizeVO> searchTurnTimeByMovementDetail(TTSearchOptionInGereralVO tTSearchOptionIngereralVo) throws EventException;

}