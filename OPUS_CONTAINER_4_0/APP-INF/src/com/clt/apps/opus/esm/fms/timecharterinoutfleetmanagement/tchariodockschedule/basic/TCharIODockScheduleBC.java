/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharIODockScheduleBC.java
*@FileTitle : D/dock Schedule Input
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.basic;

import java.util.List;

import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.vo.CondDryDockScheduleVO;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.vo.CustomDckSkdVO;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.vo.SearchDryDockScheduleGraphListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.vo.SearchDryDockScheduleListVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * OPUS-Timecharterinoutfleetmanagement Business Logic Command Interface<br>
 * - OPUS-Timecharterinoutfleetmanagement Biz Logic Interface<br>
 *
 * @author
 * @see Esm_fms_0054-1EventResponse 
 * @since J2EE 1.4
 */

public interface TCharIODockScheduleBC {
	
	/**
	 * Saving D/Dock Estimated Schedules data<br>
	 * 
	 * @param customDckSkdVOs CustomDckSkdVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageDockEstimatedSchedule(CustomDckSkdVO[] customDckSkdVOs,String usrId) throws EventException;
	
	/**
	 * Retrieving D/Dock Estimated Schedules data<br>
	 * 
	 * @param vslCd String
	 * @param dckSelCd String
	 * @return List<CustomDckSkdVO>
	 * @exception EventException
	 */
	public List<CustomDckSkdVO> searchDockEstimatedScheduleList(String vslCd ,String dckSelCd) throws EventException;
	
	/**
	 * Retrieving D/Dock Recommend Schedules data<br>
	 * 
	 * @param vslCd String
	 * @param dckSelCd String
	 * @return List<CustomDckSkdVO>
	 * @exception EventException
	 */
	public List<CustomDckSkdVO> searchDockRecommendScheduleList(String vslCd ,String dckSelCd) throws EventException;
	
	/**
	 * Saving D/Dock Recommend Schedules data<br>
	 * 
	 * @param customDckSkdVOs CustomDckSkdVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageDockRecommendSchedule(CustomDckSkdVO[] customDckSkdVOs,String usrId) throws EventException;

	/**
	 * Retrieving  Dry Dock Schedule List<br>
	 * 
	 * @param condDryDockScheduleVO CondDryDockScheduleVO
	 * @return List<SearchDryDockScheduleListVO>
	 * @exception EventException
	 */
	public List<SearchDryDockScheduleListVO> searchDryDockScheduleList(CondDryDockScheduleVO condDryDockScheduleVO) throws EventException ;
	
	/**
	 * Retrieving Dry Dock Schedule Graph List <br>
	 * 
	 * @param condDryDockScheduleVO CondDryDockScheduleVO
	 * @return List<SearchDryDockScheduleGraphListVO>
	 * @exception EventException
	 */
	public List<SearchDryDockScheduleGraphListVO> searchDryDockScheduleGraphList(CondDryDockScheduleVO condDryDockScheduleVO) throws EventException ;
}