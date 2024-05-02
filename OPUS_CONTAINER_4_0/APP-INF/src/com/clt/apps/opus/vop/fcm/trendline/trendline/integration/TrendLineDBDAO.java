/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TrendLineDBDAO.java
*@FileTitle : TrendLineDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.15
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.11.15 진마리아
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.fcm.trendline.trendline.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.vop.fcm.trendline.trendline.basic.TrendLineBCImpl;
import com.clt.apps.opus.vop.fcm.trendline.trendline.vo.CalcTrndLineFormulaVO;
import com.clt.apps.opus.vop.fcm.trendline.trendline.vo.FcmTrndLineRptMtchVO;
import com.clt.apps.opus.vop.fcm.trendline.trendline.vo.FcmTrndLineVO;
import com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo.FcmNoonRptVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS TrendLineDBDAO<br>
 * ALPS TEMP1 Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Maria Chin
 * @see TrendLineBCImpl 참조
 * @since J2EE 1.6
 */

public class TrendLineDBDAO extends DBDAOSupport {

	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Trend Line 정보를 조회한다.
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @return List<FcmTrndLineVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<FcmTrndLineVO> searchFcmTrndLineList(FcmTrndLineVO fcmTrndLineVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FcmTrndLineVO> fcmTrndLineVOs = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(fcmTrndLineVO != null){
				Map<String, String> mapVO = fcmTrndLineVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TrendLineDBDAOFcmTrndLineVORSQL(), param, velParam);
			fcmTrndLineVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, FcmTrndLineVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return fcmTrndLineVOs;
	}
	
	
	/**
	 * Trend Line 과 관련있는 Noon Report Matching 정보를 조회한다.
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @return List<FcmNoonRptVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<FcmNoonRptVO> searchFcmTrndLineRptMtchList(FcmTrndLineVO fcmTrndLineVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FcmNoonRptVO> fcmNoonRptVOs = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(fcmTrndLineVO != null){
				Map<String, String> mapVO = fcmTrndLineVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TrendLineDBDAOFcmNoonRptVOByMatchRSQL(), param, velParam);
			fcmNoonRptVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, FcmNoonRptVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return fcmNoonRptVOs;
	}
	
	/**
	 * Trend Line 생성을 위한 정보를 조회한다.
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @return List<FcmTrndLineVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<FcmNoonRptVO> searchNoonRptForTrndLine(FcmTrndLineVO fcmTrndLineVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FcmNoonRptVO> fcmNoonRptVOs = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(fcmTrndLineVO != null){
				Map<String, String> mapVO = fcmTrndLineVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TrendLineDBDAOSearchNoonRptForTrndLineRSQL(), param, velParam);
			fcmNoonRptVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, FcmNoonRptVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return fcmNoonRptVOs;
	}

	/**
	 * 해당 기간의 Noon Rpt에 존재하는 Lane을 조회한다.
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchLaneByNoonRpt(FcmTrndLineVO fcmTrndLineVO) throws DAOException {
		DBRowSet dbRowset = null;
		String[] arrLane = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(fcmTrndLineVO != null){
				Map<String, String> mapVO = fcmTrndLineVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TrendLineDBDAOSearchLaneByNoonRptRSQL(), param, velParam);
			int i = 0;
			while (dbRowset.next()) {
				if (i == 0) {
					arrLane = new String[dbRowset.getRowCount()];
				}
				arrLane[i] = dbRowset.getString(1);
				i++;
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return arrLane;
	}
	
	/**
	 * 해당 기간의 Noon Rpt에 존재하는 Vessel을 조회한다.
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchVslByNoonRpt(FcmTrndLineVO fcmTrndLineVO) throws DAOException {
		DBRowSet dbRowset = null;
		String[] arrVsl = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(fcmTrndLineVO != null){
				Map<String, String> mapVO = fcmTrndLineVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TrendLineDBDAOSearchVslByNoonRptRSQL(), param, velParam);
			int i = 0;
			while (dbRowset.next()) {
				if (i == 0) {
					arrVsl = new String[dbRowset.getRowCount()];
				}
				arrVsl[i] = dbRowset.getString(1);
				i++;
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return arrVsl;
	}
	
	/**
	 * 해당 기간의 Noon Rpt에 존재하는 VVD의 Direction Code를 조회한다.
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchDirCdByNoonRpt(FcmTrndLineVO fcmTrndLineVO) throws DAOException {
		DBRowSet dbRowset = null;
		String[] arrDirCd = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(fcmTrndLineVO != null){
				Map<String, String> mapVO = fcmTrndLineVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TrendLineDBDAOSearchDirCdByNoonRptRSQL(), param, velParam);
			int i = 0;
			while (dbRowset.next()) {
				if (i == 0) {
					arrDirCd = new String[dbRowset.getRowCount()];
				}
				arrDirCd[i] = dbRowset.getString(1);
				i++;
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return arrDirCd;
	}
	
	/**
	 * 해당 기간의 Noon Rpt에 존재하는 Vessel의 Design Capa을 조회한다. sub class가 조건에 들어가는 경우, rgst 테이블에 존재하는 vsl의 capa
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchDznCapaByNoonRpt(FcmTrndLineVO fcmTrndLineVO) throws DAOException {
		DBRowSet dbRowset = null;
		String[] arrCapa = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{ 
			if(fcmTrndLineVO != null){
				Map<String, String> mapVO = fcmTrndLineVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TrendLineDBDAOSearchDznCapaByNoonRptRSQL(), param, velParam);
			int i = 0;
			while (dbRowset.next()) {
				if (i == 0) {
					arrCapa = new String[dbRowset.getRowCount()];
				}
				arrCapa[i] = dbRowset.getString(1);
				i++;
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return arrCapa;
	}
	
	/**
	 * 해당 기간의 Noon Rpt에 존재하는 Vessel의 RGST에 등록되어 있는 SubClass를 조회한다.
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchSubClassByNoonRpt(FcmTrndLineVO fcmTrndLineVO) throws DAOException {
		DBRowSet dbRowset = null;
		String[] arrSubClass = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(fcmTrndLineVO != null){
				Map<String, String> mapVO = fcmTrndLineVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TrendLineDBDAOSearchSubClassByNoonRptRSQL(), param, velParam);
			int i = 0;
			while (dbRowset.next()) {
				if (i == 0) {
					arrSubClass = new String[dbRowset.getRowCount()];
				}
				arrSubClass[i] = dbRowset.getString(1);
				i++;
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return arrSubClass;
	}
	
	/**
	 * 조회조건에 맞는 데이터의 AVRRAGE SPIP을 구한다.
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @return String
	 * @exception EventException
	 */
	public String searchAverageSlpVal(FcmTrndLineVO fcmTrndLineVO) throws DAOException {
		DBRowSet dbRowset = null;
		String slpVal = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(fcmTrndLineVO != null){
				Map<String, String> mapVO = fcmTrndLineVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TrendLineDBDAOSearchAverageSlpValRSQL(), param, velParam);
			if(dbRowset != null){
				if(dbRowset.next()){
					slpVal = dbRowset.getString("AVG_SLP_RT");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return slpVal;
	}
	
	/**
	 * Trnd Line 정보를 생성합니다.<br>
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @exception DAOException
	 */
	public void addTrndLine(FcmTrndLineVO fcmTrndLineVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt = 0;
			
			if(fcmTrndLineVO != null){
				Map<String, String> mapVO = fcmTrndLineVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			insCnt = sqlExe.executeUpdate((ISQLTemplate)new TrendLineDBDAOAddTrndLineCSQL(), param, velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Trnd Line Rpt Mtch 정보(xcld 데이터 생성)를 생성합니다.<br>
	 * 
	 * @param List<FcmTrndLineRptMtchVO> fcmTrndLineRptMtchVOs
	 * @exception DAOException
	 */
	public void addTrndLineRptMtch(List<FcmTrndLineRptMtchVO> fcmTrndLineRptMtchVOs) throws DAOException {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt = 0;
			
			for(int i=0; i<fcmTrndLineRptMtchVOs.size();i++){
				FcmTrndLineRptMtchVO vo = fcmTrndLineRptMtchVOs.get(i);
				Map<String, String> mapVO = vo .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				insCnt = sqlExe.executeUpdate((ISQLTemplate)new TrendLineDBDAOAddTrndLineRptMtchCSQL(), param, velParam);
				if(insCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 새로 생성할 Trnd Line의 TRND_LINE_TP_SUB_CD를 구한다.
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @return String
	 * @exception EventException
	 */
	public String searchMaxTrndLineTpSubCd(FcmTrndLineVO fcmTrndLineVO) throws DAOException {
		DBRowSet dbRowset = null;
		String trndLineTpSubCd = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(fcmTrndLineVO != null){
				Map<String, String> mapVO = fcmTrndLineVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TrendLineDBDAOSearchMaxTrndLineTpSubCdRSQL(), param, velParam);
			if(dbRowset != null){
				if(dbRowset.next()){
					trndLineTpSubCd = dbRowset.getString("TRND_LINE_TP_SUB_CD");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return trndLineTpSubCd;
	}
	
	/**
	 * Trend Line 정보를 조회한다.
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @return List<FcmTrndLineVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<FcmTrndLineVO> searchFcmTrndLinePopupList(FcmTrndLineVO fcmTrndLineVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FcmTrndLineVO> fcmTrndLineVOs = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(fcmTrndLineVO != null){
				Map<String, String> mapVO = fcmTrndLineVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TrendLineDBDAOFcmTrndLineVOPopupRSQL(), param, velParam);
			fcmTrndLineVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, FcmTrndLineVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return fcmTrndLineVOs;
	}
	
	/**
	 * 기생성된 Trend Line 정보를 조회한다.
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @return List<FcmTrndLineVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<FcmTrndLineVO> searchFcmTrndLineForInq(FcmTrndLineVO fcmTrndLineVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FcmTrndLineVO> fcmTrndLineVOs = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(fcmTrndLineVO != null){
				Map<String, String> mapVO = fcmTrndLineVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TrendLineDBDAOSearchFcmTrndLineForInqRSQL(), param, velParam);
			fcmTrndLineVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, FcmTrndLineVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return fcmTrndLineVOs;
	}
	
	
	/**
	 * 기생성된 Trend Line 의 raw data를 조회한다.
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @return List<FcmTrndLineVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<FcmNoonRptVO> searchFcmTrndLineRawDataForInq(FcmTrndLineVO fcmTrndLineVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FcmNoonRptVO> fcmNoonRptVOs = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(fcmTrndLineVO != null){
				Map<String, String> mapVO = fcmTrndLineVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TrendLineDBDAOSearchFcmTrndLineRawDataForInqRSQL(), param, velParam);
			fcmNoonRptVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, FcmNoonRptVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return fcmNoonRptVOs;
	}
	
	/**
	 * 삭제할 Trnd Line의 rpt mtch 정보를 삭제합니다.<br>
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @exception DAOException
	 */
	public void removeTrndLineRptMtch(FcmTrndLineVO fcmTrndLineVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			if(fcmTrndLineVO != null){
				Map<String, String> mapVO = fcmTrndLineVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				int rtnCnt = sqlExe.executeUpdate((ISQLTemplate)new TrendLineDBDAORemoveTrndLineRptMtchDSQL(), param, velParam);
				
				if(rtnCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to Delete SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Trnd Line 정보를 삭제합니다.<br>
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @exception DAOException
	 */
	public void removeTrndLine(FcmTrndLineVO fcmTrndLineVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			if(fcmTrndLineVO != null){
				Map<String, String> mapVO = fcmTrndLineVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				int rtnCnt = sqlExe.executeUpdate((ISQLTemplate)new TrendLineDBDAORemoveTrndLineDSQL(), param, velParam);
				
				if(rtnCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to Delete SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 기존재하는 Trnd Line의 정보를 수정합니다.<br>
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @exception DAOException
	 */
	public void modifyTrndLine(FcmTrndLineVO fcmTrndLineVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt = 0;
			
			if(fcmTrndLineVO != null){
				Map<String, String> mapVO = fcmTrndLineVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			insCnt = sqlExe.executeUpdate((ISQLTemplate)new TrendLineDBDAOModifyTrndLineUSQL(), param, velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 수정할 TRND LINE의 SEQ를 구한다.
	 * 
	 * @param FcmTrndLineVO fcmTrndLineVO
	 * @return String
	 * @exception EventException
	 */
	public String searchTrndLineSeq(FcmTrndLineVO fcmTrndLineVO) throws DAOException {
		DBRowSet dbRowset = null;
		String trndLineSeq = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(fcmTrndLineVO != null){
				Map<String, String> mapVO = fcmTrndLineVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TrendLineDBDAOSearchTrndLineSeqRSQL(), param, velParam);
			if(dbRowset != null){
				if(dbRowset.next()){
					trndLineSeq = dbRowset.getString("TRND_LINE_SEQ");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return trndLineSeq;
	}
	
	/**
	 * 기존재하는 trnd line의 Trnd Line Rpt Mtch 정보(xcld 데이터 생성)를 생성합니다.<br>
	 * 
	 * @param List<FcmTrndLineRptMtchVO> fcmTrndLineRptMtchVOs
	 * @exception DAOException
	 */
	public void addTrndLineRptMtchUpd(List<FcmTrndLineRptMtchVO> fcmTrndLineRptMtchVOs) throws DAOException {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt = 0;
			
			for(int i=0; i<fcmTrndLineRptMtchVOs.size();i++){
				FcmTrndLineRptMtchVO vo = fcmTrndLineRptMtchVOs.get(i);
				Map<String, String> mapVO = vo .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				insCnt = sqlExe.executeUpdate((ISQLTemplate)new TrendLineDBDAOAddTrndLineRptMtchUpdCSQL(), param, velParam);
				if(insCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 해당 Trnd Line의 rpt mtch 정보를 모두 삭제합니다.<br>
	 * 
	 * @param String trndLineSeq
	 * @exception DAOException
	 */
	public void removeTrndLineRptMtchUpd(String trndLineSeq) throws DAOException {

		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			int insCnt=0;
			if(trndLineSeq != null){
				param.put("trnd_line_seq", trndLineSeq);
				velParam.put("trnd_line_seq", trndLineSeq);
				insCnt = sqlExe.executeUpdate((ISQLTemplate)new TrendLineDBDAORemoveTrndLineRptMtchUpdDSQL(), param, velParam);
				if(insCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * VSL에 해당하는 MIN, MAX SPD를 구한다.(VSL이 여러 종류인 경우, 가장 작은 MAX & 가장 큰 MIN)
	 * 
	 * @param String vslCd
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchMinMaxSpd(String vslCd) throws DAOException {
		DBRowSet dbRowset = null;
		String[] minMax = new String[2];
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(vslCd != null && !vslCd.equals("")){
				String[] arrVslCd = vslCd.split(",");
				List<String> vslCdList  = new ArrayList<String>();
				for(int i=0; i<arrVslCd.length; i++){
					vslCdList.add(arrVslCd[i]);
				}
				
				param.put("arr_vsl_cd", vslCdList);
				velParam.put("arr_vsl_cd", vslCdList);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TrendLineDBDAOSearchMinMaxSpdRSQL(), param, velParam);
			if(dbRowset != null){
				if(dbRowset.next()){
					minMax[0] = dbRowset.getString("MIN_SPD");
					minMax[1] = dbRowset.getString("MAX_SPD");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return minMax;
	}
	
	/**
	 * Trend Line 수식을 이용하여 결과값을 구한다.
	 * 
	 * @param CalcTrndLineFormulaVO calcTrndLineFormulaVO
	 * @return List<CalcTrndLineFormulaVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CalcTrndLineFormulaVO> calcTrndLineFormula(CalcTrndLineFormulaVO calcTrndLineFormulaVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CalcTrndLineFormulaVO> calcTrndLineFormulaVOs = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(calcTrndLineFormulaVO != null){
				Map<String, String> mapVO = calcTrndLineFormulaVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TrendLineDBDAOFcmTrndLineVORSQL(), param, velParam);
			calcTrndLineFormulaVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, CalcTrndLineFormulaVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return calcTrndLineFormulaVOs;
	}
}
