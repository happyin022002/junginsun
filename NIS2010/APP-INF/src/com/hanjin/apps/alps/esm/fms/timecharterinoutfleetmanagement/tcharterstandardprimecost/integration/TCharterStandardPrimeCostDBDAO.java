/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterStandardPrimeCostDAO.java
*@FileTitle : TEU Range Target
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.15
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.04.15 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.basic.TCharterStandardPrimeCostBCImpl;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.vo.CustomMktRtVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.vo.CustomStndHirVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.vo.CustomTeuRngVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.vo.SearchHireBaseListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.vo.SearchStandardHireBaseListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.vo.SearchStandardHireListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.vo.SearchTeuRangeListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * NIS2010 TCharterStandardPrimeCostDAO <br>
 * - NIS2010-TimeCharterInOutFleetManagement system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Choi Woo-Seok
 * @see TCharterStandardPrimeCostBCImpl 참조
 * @since J2EE 1.4
 */
public class TCharterStandardPrimeCostDBDAO extends DBDAOSupport {

	/**
	 * 선박의 평균값을 산출할 각 선박 크기 별 범위(군)을 조회한다<br>
	 * 
	 * @param rngYr String
	 * @return List<SearchTeuRangeListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchTeuRangeListVO> searchTeuRangeList(String rngYr) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchTeuRangeListVO> searchTeuRangeListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("rng_yr", rngYr);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterStandardPrimeCostDAOFmsTeuRngRSQL(), param, null);
			searchTeuRangeListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomTeuRngVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchTeuRangeListVO;
	}

	/**
	 * 선박의 평균값을 산출할 각 선박 크기 별 범위(군)을 생성한다<br>
	 * 
	 * @param customTeuRngVO List<CustomTeuRngVO>
	 * @throws DAOException
	 */
	public void addTeuRngs(List<CustomTeuRngVO> customTeuRngVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customTeuRngVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterStandardPrimeCostDAOFmsTeuRngCSQL(), customTeuRngVO,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
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
	 * 선박의 평균값을 산출할 각 선박 크기 별 범위(군)을 변경한다<br>
	 * 
	 * @param customTeuRngVO List<CustomTeuRngVO>
	 * @throws DAOException
	 */
	public void modifyTeuRngs(List<CustomTeuRngVO> customTeuRngVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(customTeuRngVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterStandardPrimeCostDAOFmsTeuRngUSQL(), customTeuRngVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
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
	 * 선박의 평균값을 산출할 각 선박 크기 별 범위(군)을 삭제한다<br>
	 * 
	 * @param customTeuRngVO List<CustomTeuRngVO>
	 * @throws DAOException
	 */
	public void modifyTeuRngDeleteFlags(List<CustomTeuRngVO> customTeuRngVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(customTeuRngVO.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterStandardPrimeCostDAOFmsTeuRngDSQL(), customTeuRngVO,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
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
	 * 선박의 평균값을 산출할 각 선박 크기 별 범위(군)을 전체 삭제한다<br>
	 * 
	 * @param rngYr String
	 * @return int
	 * @throws DAOException
	 */
	public int removeAllTeuRange(String rngYr) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		int result = 0;
		try {
			param.put("rng_yr", rngYr);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TCharterStandardPrimeCostDAOFmsTeuRngAllDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * 선박의 평균값을 산출할 각 선박 크기 별 범위(군)을 조회한다<br>
	 * 
	 * @param mktRtYrmon String
	 * @return List<SearchHireBaseListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchHireBaseListVO> searchHireBaseList(String mktRtYrmon) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchHireBaseListVO> searchHireBaseListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("mkt_rt_yrmon", mktRtYrmon);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterStandardPrimeCostDAOFmsMktRtRSQL(), param, null);
			searchHireBaseListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchHireBaseListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchHireBaseListVO;
	}
	
	/**
	 * Standard Hire 설정 중, 현 Market rate를 반영할 Hire의 범위를 생성한다<br>
	 * 
	 * @param customMktRtVO List<CustomMktRtVO>
	 * @throws DAOException
	 */
    public void addMktRts(List<CustomMktRtVO> customMktRtVO) throws DAOException,Exception {
    	try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customMktRtVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterStandardPrimeCostDAOFmsMktRtCSQL(), customMktRtVO,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
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
	 * Standard Hire 설정 중, 현 Market rate를 반영할 Hire의 범위를 변경한다<br>
	 * 
	 * @param customMktRtVO List<CustomMktRtVO>
	 * @throws DAOException
	 */
	public void modifyMktRts(List<CustomMktRtVO> customMktRtVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(customMktRtVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterStandardPrimeCostDAOFmsMktRtUSQL(), customMktRtVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
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
	 * Standard Hire 설정 중, 현 Market rate를 반영할 Hire의 범위를 삭제한다<br>
	 * 
	 * @param customMktRtVO List<CustomMktRtVO>
	 * @throws DAOException
	 */
	public void modifyMktRtDeleteFlags(List<CustomMktRtVO> customMktRtVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(customMktRtVO.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterStandardPrimeCostDAOFmsMktRtDSQL(), customMktRtVO,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
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
	 * Standard Hire 설정 중, 현 Market rate를 반영할 Hire의 범위를 전체 삭제한다<br>
	 * 
	 * @param mktRtYrmon String
	 * @return int
	 * @throws DAOException
	 */
	public int removeAllHireBase(String mktRtYrmon) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		int result = 0;
		try {
			param.put("mkt_rt_yrmon", mktRtYrmon);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TCharterStandardPrimeCostDAOFmsMktRtAllDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * 월간 Standard Hire (표준 용선료)를 조회한다<br>
	 * 
	 * @param rngYr String
	 * @return List<SearchStandardHireListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchStandardHireListVO> searchStandardHireList(String rngYr) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchStandardHireListVO> searchStandardHireListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("hb_yrmon", rngYr);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterStandardPrimeCostDAOFmsStndHirRSQL(), param, null);
			searchStandardHireListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchStandardHireListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchStandardHireListVO;
	}
	 
	/**
	 * 월간 Standard Hire (표준 용선료)를 변경한다<br>
	 * 
	 * @param customStndHirVO List<CustomStndHirVO>
	 * @throws DAOException
	 */
	public void modifyStandardHires(List<CustomStndHirVO> customStndHirVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(customStndHirVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterStandardPrimeCostDAOFmsStndHirUSQL(), customStndHirVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
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
	 * 월간 Standard Hire (표준 용선료)를 삭제한다<br>
	 * 
	 * @param rngYr String
	 * @return int
	 * @throws DAOException
	 */
	public int removeAllStandardHire(String rngYr) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		int result = 0;
		try {
			param.put("hb_yrmon", rngYr);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TCharterStandardPrimeCostDAOFmsStndHirAllDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * 월간 Standard Hire (표준 용선료)를 산출한다<br>
	 * 
	 * @param rngYr String
	 * @return List<SearchStandardHireBaseListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchStandardHireBaseListVO> searchStandardHireBaseList(String rngYr) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchStandardHireBaseListVO> searchStandardHireBaseListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("hb_yrmon", rngYr);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterStandardPrimeCostDAOFmsStndHirBseRSQL(), param, null);
			searchStandardHireBaseListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchStandardHireBaseListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchStandardHireBaseListVO;
	}
	 
	/**
	 * 월간 Standard Hire Base (표준 용선료)를 등록한다<br>
	 * 
	 * @param rngYr String
	 * @param usrid String
	 * @return int
	 * @throws DAOException
	 */
	public int addStandardHireBases(String rngYr, String usrid) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		int result = 0;
		try {
			param.put("hb_yrmon", rngYr);
			param.put("cre_usr_id", usrid);
			param.put("upd_usr_id", usrid);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TCharterStandardPrimeCostDAOFmsStndHirBseCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * 월간 Standard Hire Base (표준 용선료)를 삭제한다<br>
	 * 
	 * @param rngYr String
	 * @return int
	 * @throws DAOException
	 */
	public int reomveStandardHireBase(String rngYr) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		int result = 0;
		try {
			param.put("hb_yrmon", rngYr);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TCharterStandardPrimeCostDAOFmsStndHirBseDSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
}
