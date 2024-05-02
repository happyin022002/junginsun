/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DailyForecastInquiryBCImpl.java
*@FileTitle : dailyforecastinquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.08.03 한상훈
* 1.0 Creation
* 2014.11.14 신자영 [CHM-201432770] T/S Booking Report 개선 - 기존 quiry copy하여 Old로 복원
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.integration.DailyForecastInquiryDBDAO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.vo.SearchTSBookingListConditionVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.vo.SearchTSBookingListVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.vo.SearchTSBookingNewListRSQLVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.vo.SpcFcastBkgListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-DailyForecast Business Logic Basic Command implementation<br>
 * - ALPS-DailyForecast에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Han Sang Hoon
 * @see ESM_SPC_105EventResponse,DailyForecastInquiryBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class DailyForecastInquiryBCImpl extends BasicCommandSupport implements DailyForecastInquiryBC {

	// Database Access Object
	private transient DailyForecastInquiryDBDAO dbDao = null;

	/**
	 * DailyForecastInquiryBCImpl 객체 생성<br>
	 * DailyForecastInquiryDBDAO를 생성한다.<br>
	 */
	public DailyForecastInquiryBCImpl() {
		dbDao = new DailyForecastInquiryDBDAO();
	}
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchTSBookingListConditionVO searchTSBookingListConditionVO
	 * @return List<SearchTSBookingNewListRSQLVO>
	 * @exception EventException
	 */
	public List<SearchTSBookingNewListRSQLVO> searchTSBookingList(SearchTSBookingListConditionVO searchTSBookingListConditionVO) throws EventException {
		try {
			return dbDao.searchTSBookingList(searchTSBookingListConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchTSBookingListConditionVO searchTSBookingListConditionVO
	 * @return List<SearchTSBookingListVO>
	 * @exception EventException
	 */
	public List<SearchTSBookingListVO> searchTSBookingListOld(SearchTSBookingListConditionVO searchTSBookingListConditionVO) throws EventException {
		try {
			return dbDao.searchTSBookingListOld(searchTSBookingListConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchTSBookingListConditionVO searchTSBookingListConditionVO
	 * @return List<SearchTSBookingListVO>
	 * @exception EventException
	 */
	public List<SpcFcastBkgListVO> searchBookingList(SearchTSBookingListConditionVO searchTSBookingListConditionVO) throws EventException {
		try {
			return dbDao.searchBookingList(searchTSBookingListConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
}