/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DailyForecastInquiryBC.java
*@FileTitle : dailyforecastinquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.08.03 한상훈
* 1.0 Creation
* 2014.11.14 신자영 [CHM-201432770] T/S Booking Report 개선 
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.vo.SearchTSBookingListConditionVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.vo.SearchTSBookingListVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.vo.SearchTSBookingNewListRSQLVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.vo.SpcFcastBkgListVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-Dailyforecast Business Logic Command Interface<br>
 * - ALPS-Dailyforecast에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Han Sang Hoon
 * @see Esm_spc_105EventResponse 참조
 * @since J2EE 1.6
 */

public interface DailyForecastInquiryBC {

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchTSBookingListConditionVO searchTSBookingListConditionVO
	 * @return List<SearchTSBookingNewListRSQLVO>
	 * @exception EventException
	 */
	public List<SearchTSBookingNewListRSQLVO> searchTSBookingList(SearchTSBookingListConditionVO searchTSBookingListConditionVO) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchTSBookingListConditionVO searchTSBookingListConditionVO
	 * @return List<SearchTSBookingListVO>
	 * @exception EventException
	 */
	public List<SearchTSBookingListVO> searchTSBookingListOld(SearchTSBookingListConditionVO searchTSBookingListConditionVO) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchTSBookingListConditionVO searchTSBookingListConditionVO
	 * @return List<SpcFcastBkgListVO>
	 * @exception EventException
	 */
	public List<SpcFcastBkgListVO> searchBookingList(SearchTSBookingListConditionVO searchTSBookingListConditionVO) throws EventException;
}