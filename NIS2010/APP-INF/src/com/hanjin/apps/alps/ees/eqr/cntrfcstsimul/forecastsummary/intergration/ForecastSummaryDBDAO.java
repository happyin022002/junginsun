/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EQCOrgChartDBDAO.java
*@FileTitle : EQC Organization Chart
*Open Issues :
*Change history :
*@LastModifyDate : 2013-06-03
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastsummary.intergration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastsummary.basic.ForecastSummaryBCImpl;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastsummary.vo.EQBalanceSheetListVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastsummary.vo.EQForecastSummaryINVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastsummary.vo.EQForecastSummaryListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * eNIS-BIZCOMMON에 대한 DB 처리를 담당<br>
 * - eNIS-BIZCOMMON Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jeong Min, Park
 * @see ForecastSummaryBCImpl 참조
 * @since J2EE 1.4
 */
@SuppressWarnings("serial")
public class ForecastSummaryDBDAO extends DBDAOSupport {
	
	
	/**
	 * EQCOrgChart의 모든 목록을 가져온다.<br>
	 * @param eQForecastSummaryINVO
	 * @return List<EQBalanceSheetListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EQBalanceSheetListVO> searchEQBalanceSheetList(EQForecastSummaryINVO eQForecastSummaryINVO) throws DAOException {
		DBRowSet dbRowset    = null;
    	//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		//List
		List<EQBalanceSheetListVO> list = null; 
		try {
			Map<String, String> mapVO = eQForecastSummaryINVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
				
	        dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ForecastSummaryDBDAOsearchEQBalanceSheetListRSQL(), param, velParam);
	        list = (List)RowSetUtil.rowSetToVOs(dbRowset, EQBalanceSheetListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	 /**
	 * EQ Forecast Summary 수정/입력<br>
	 * 
	 * @param EQBalanceSheetListVO eQBalanceSheetListVO
	 * @exception DAOException
	 */
	public void manageEQForecastSummaryFilter(EQBalanceSheetListVO eQBalanceSheetListVO)  throws DAOException {
    	//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			Map<String, String> mapVO = eQBalanceSheetListVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			int insertCnt = 0;
			
			insertCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ForecastSummaryDBDAOmanageEQForecastSummaryFilterUSQL(), param, velParam);
			
			if(insertCnt ==  Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * EQ Forecast Summary Filter 중복데이터 검증
	 * @param eQBalanceSheetListVO
	 * @return int
	 * @throws DAOException
	 */
	public int checkEQForecastSummaryFilter(EQBalanceSheetListVO eQBalanceSheetListVO) throws DAOException {
		DBRowSet dbRowset = null;
    	//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		//List
		int count = 0; 
		try {
			Map<String, String> mapVO = eQBalanceSheetListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
	        dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ForecastSummaryDBDAOcheckEQForecastSummaryFilterRSQL(), param, velParam);
	        
	        if(dbRowset != null){
	        	if(dbRowset.next()){
	        		count = Integer.parseInt(dbRowset.getString("CNT"));
	        	}
	        }
	        
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return count;
	}
	
	
	/**
	 * EES_EQR_1101 : [이벤트]<br>
	 * RCC_CD, LOC_GRP_CD에 따른 LOCATION코드 조회 <br>
	 * GRID COMBO에 사용
	 * @param eQForecastSummaryINVO
	 * @return count
	 * @exception DAOException
	 */
	public int checkLocationByGroupCode(EQForecastSummaryINVO eQForecastSummaryINVO) throws DAOException {
		DBRowSet dbRowset = null;
    	//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		//List
		int count = 0; 
		try {
			Map<String, String> mapVO = eQForecastSummaryINVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
	        dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ForecastSummaryDBDAOsearchLocationCodeByTypeRSQL(), param, velParam);
	        
	        if(dbRowset != null){
	        	if(dbRowset.next()){
	        		count = Integer.parseInt(dbRowset.getString("CNT"));
	        	}
	        }
	        
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return count;
	}
	
	/**
	 * EQ Forecast Summary의 모든 목록을 가져온다.<br>
	 * @param eQForecastSummaryINVO
	 * @return List<EQForecastSummaryListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EQForecastSummaryListVO> searchEQForecastSummaryList(EQForecastSummaryINVO eQForecastSummaryINVO) throws DAOException {
		DBRowSet dbRowset = null;
    	//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		DBRowSet dbRowsetCim = null;		
		String cimMatchbackWeek = null;
		
		//List
		List<EQForecastSummaryListVO> list = null; 
		try {
			Map<String, String> mapVO = eQForecastSummaryINVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			// 현재주차, 미래주차이면 -2주차 week
			// 과거 1주차 이면 -1주차 week
			// 과거 2주차 이상이면, 입력된 주차
			dbRowsetCim = new SQLExecuter("").executeQuery((ISQLTemplate)new ForecastSummaryDBDAOsearchCIMMatchBackWeekRSQL(), param, velParam);
			while(dbRowsetCim.next()){
				cimMatchbackWeek = dbRowsetCim.getString(1);
            }
			param.put("cim_matchback_week", cimMatchbackWeek); // cim matchback week
			velParam.put("cim_matchback_week", cimMatchbackWeek); // cim matchback week								
			
	        dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ForecastSummaryDBDAOsearchEQForecastSummaryListRSQL(), param, velParam);
	        list = (List)RowSetUtil.rowSetToVOs(dbRowset, EQForecastSummaryListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	

}