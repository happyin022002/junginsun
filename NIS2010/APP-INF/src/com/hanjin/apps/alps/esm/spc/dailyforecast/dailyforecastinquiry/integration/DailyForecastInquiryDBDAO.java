/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DailyForecastInquiryDBDAO.java
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
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.basic.DailyForecastInquiryBCImpl;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.vo.SearchTSBookingListConditionVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.vo.SearchTSBookingListVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.vo.SearchTSBookingNewListRSQLVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.vo.SpcFcastBkgListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS DailyForecastInquiryDBDAO <br>
 * - ALPS-DailyForecast system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Han Sang Hoon
 * @see DailyForecastInquiryBCImpl 참조
 * @since J2EE 1.6
 */
public class DailyForecastInquiryDBDAO extends DBDAOSupport {

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchTSBookingListConditionVO searchTSBookingListConditionVO
	 * @return List<SearchTSBookingNewListRSQLVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchTSBookingNewListRSQLVO> searchTSBookingList(SearchTSBookingListConditionVO searchTSBookingListConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchTSBookingNewListRSQLVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchTSBookingListConditionVO != null){
				Map<String, String> mapVO = searchTSBookingListConditionVO .getColumnValues();
			    param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				if(searchTSBookingListConditionVO.getType().equals("D")){
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DailyForecastInquiryDBDAOSpcFcastOfcPolDelMapgVORSQL(), param, velParam);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchTSBookingNewListRSQLVO .class);
				}else if(searchTSBookingListConditionVO.getType().equals("T")){
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DailyForecastInquiryDBDAOSpcFcastOfcPolMapgVORSQL(), param, velParam);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchTSBookingNewListRSQLVO .class);
				}
			}
			
		}catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchTSBookingListConditionVO searchTSBookingListConditionVO
	 * @return List<SearchTSBookingListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchTSBookingListVO> searchTSBookingListOld(SearchTSBookingListConditionVO searchTSBookingListConditionVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SearchTSBookingListVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 if(searchTSBookingListConditionVO != null){
				 Map<String, String> mapVO = searchTSBookingListConditionVO .getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DailyForecastInquiryDBDAOSpcFcastOfcPolMapgVOOldRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchTSBookingListVO .class);
		 }catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 	 return list;
	}
	
	/**
	* [처리대상] 정보를 [행위] 합니다.<br>
	* 
	* @param SearchTSBookingListConditionVO searchTSBookingListConditionVO
	* @return List<SpcFcastBkgListVO>
	* @throws DAOException
	*/
	@SuppressWarnings("unchecked")
	public List<SpcFcastBkgListVO> searchBookingList(SearchTSBookingListConditionVO searchTSBookingListConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SpcFcastBkgListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(searchTSBookingListConditionVO != null){
			Map<String, String> mapVO = searchTSBookingListConditionVO .getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DailyForecastInquiryDBDAOSpcFcastBkgListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SpcFcastBkgListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	 
}