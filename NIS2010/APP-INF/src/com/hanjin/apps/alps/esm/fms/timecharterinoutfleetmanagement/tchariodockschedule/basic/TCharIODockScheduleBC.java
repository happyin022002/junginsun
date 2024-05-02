/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharIODockScheduleBC.java
*@FileTitle : D/dock Schedule Input
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.04.24 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.vo.CondDryDockScheduleVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.vo.CustomDckSkdVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.vo.SearchDryDockScheduleGraphListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.vo.SearchDryDockScheduleListVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * NIS2010-Timecharterinoutfleetmanagement Business Logic Command Interface<br>
 * - NIS2010-Timecharterinoutfleetmanagement에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Yoon Seyeong
 * @see Esm_fms_0054-1EventResponse 참조
 * @since J2EE 1.4
 */

public interface TCharIODockScheduleBC {
	
	/**
	 * D/Dock Estimated Schedules 데이터를 저장한다<br>
	 * 
	 * @param customDckSkdVOs CustomDckSkdVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageDockEstimatedSchedule(CustomDckSkdVO[] customDckSkdVOs,String usrId) throws EventException;
	
	/**
	 * D/Dock Estimated Schedules 데이터를 조회한다<br>
	 * 
	 * @param vslCd String
	 * @param dckSelCd String
	 * @return List<CustomDckSkdVO>
	 * @exception EventException
	 */
	public List<CustomDckSkdVO> searchDockEstimatedScheduleList(String vslCd ,String dckSelCd) throws EventException;
	
	/**
	 * D/Dock Recommend Schedules 데이터를 조회한다<br>
	 * 
	 * @param vslCd String
	 * @param dckSelCd String
	 * @return List<CustomDckSkdVO>
	 * @exception EventException
	 */
	public List<CustomDckSkdVO> searchDockRecommendScheduleList(String vslCd ,String dckSelCd) throws EventException;
	
	/**
	 * D/Dock Recommend Schedules 데이터를 저장한다<br>
	 * 
	 * @param customDckSkdVOs CustomDckSkdVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageDockRecommendSchedule(CustomDckSkdVO[] customDckSkdVOs,String usrId) throws EventException;

	/**
	 * Dry Dock Schedule List 데이터를 조회한다<br>
	 * 
	 * @param condDryDockScheduleVO CondDryDockScheduleVO
	 * @return List<SearchDryDockScheduleListVO>
	 * @exception EventException
	 */
	public List<SearchDryDockScheduleListVO> searchDryDockScheduleList(CondDryDockScheduleVO condDryDockScheduleVO) throws EventException ;
	
	/**
	 * Dry Dock Schedule Graph List 데이터를 조회한다.<br>
	 * 
	 * @param condDryDockScheduleVO CondDryDockScheduleVO
	 * @return List<SearchDryDockScheduleGraphListVO>
	 * @exception EventException
	 */
	public List<SearchDryDockScheduleGraphListVO> searchDryDockScheduleGraphList(CondDryDockScheduleVO condDryDockScheduleVO) throws EventException ;
}