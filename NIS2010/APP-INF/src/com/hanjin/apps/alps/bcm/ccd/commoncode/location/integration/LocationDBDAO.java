/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : locationsDBDAO.java
*@FileTitle : contient
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.22
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.location.integration;
 
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.ContinentVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.CountryVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.CountryIfVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.DaySavingTimeVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.EqOrgChartVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.LocationMainIfVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.LocationVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.LocationIfVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.LseComYardVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.RegionVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.StateVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.StateIfVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.SubContinentVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.YardMainIfVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.YardVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.YardIfVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.ZoneDtlVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo.ZoneVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
 
 
/**
 * OPUS locationsDBDAO <br>
 * - OPUS-commoncode system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see LocationsBCImpl 참조
 * @since J2EE 1.6
 */
public class LocationDBDAO extends DBDAOSupport {

	/**
	 * Continent를 조회합니다.<br>
	 * 
	 * @param String contiCd
	 * @return ContinentVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public ContinentVO searchContiCode(String contiCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<ContinentVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("conti_cd", contiCd);
			velParam.put("conti_cd", contiCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAOsearchContiCodeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ContinentVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.size()>0?list.get(0):null;
	}
	 
	/**
	 * 신규 Continent 정보를 저장합니다.<br>
	 * 
	 * @param ContinentVO continentVO
	 * @exception DAOException
	 */
	public void addContiCode(ContinentVO continentVO) throws DAOException {
			SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(continentVO != null){
				
				Map<String, String> mapVO = continentVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new LocationDBDAOaddContiCodeCSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to insert SQL");
				}
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
	 * Continent 정보를 수정합니다.<br>
	 * 
	 * @param ContinentVO continentVO
	 * @exception DAOException
	 */
	public void modifyContiCode(ContinentVO continentVO) throws DAOException {
			SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(continentVO != null){
				
				Map<String, String> mapVO = continentVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new LocationDBDAOmodifyContiCodeUSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to update SQL");
				}
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
	 * Sub Continent를 조회합니다.<br>
	 * 
	 * @param String scontiCd
	 * @return SubContinentVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public SubContinentVO searchSubContiCode(String scontiCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SubContinentVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			try{
			param.put("sconti_cd", scontiCd);
			velParam.put("sconti_cd", scontiCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAOsearchSubContiCodeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SubContinentVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.size()>0?list.get(0):null;
	}
	 
	/**
	 * 신규 Sub Continent 정보를 저장합니다.<br>
	 * 
	 * @param SubContinentVO subContinentVO
	 * @exception DAOException
	 */
	public void addSubContiCode(SubContinentVO subContinentVO) throws DAOException {
			SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(subContinentVO != null){
				
				Map<String, String> mapVO = subContinentVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new LocationDBDAOaddSubContiCodeCSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to insert SQL");
				}
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
	 * Sub Continent 정보를 수정합니다.<br>
	 * 
	 * @param SubContinentVO subContinentVO
	 * @exception DAOException
	 */
	public void modifySubContiCode(SubContinentVO subContinentVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(subContinentVO != null){
				
				Map<String, String> mapVO = subContinentVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new LocationDBDAOmodifySubContiCodeUSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to update SQL");
				}
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
	 * Country를 조회합니다.<br>
	 * 
	 * @param String cntCd
	 * @return CountryVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public CountryVO searchCountryCode(String cntCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<CountryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("cnt_cd", cntCd);
			velParam.put("cnt_cd", cntCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAOsearchCountryCodeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CountryVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.size()>0?list.get(0):null;
	}
	 
	/**
	 * 신규 Country 정보를 저장합니다.<br>
	 * 
	 * @param CountryVO countryVO
	 * @exception DAOException
	 */
	public void addCountryCode(CountryVO countryVO) throws DAOException {
			SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(countryVO != null){
				
				Map<String, String> mapVO = countryVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new LocationDBDAOaddCountryCodeCSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to insert SQL");
				}
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
	 * Country 정보를 수정합니다.<br>
	 * 
	 * @param CountryVO countryVO
	 * @exception DAOException
	 */
	public void modifyCountryCode(CountryVO countryVO) throws DAOException {
			SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(countryVO != null){
				
				Map<String, String> mapVO = countryVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new LocationDBDAOmodifyCountryCodeUSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to update SQL");
				}
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
	 * Region를 조회합니다.<br>
	 * 
	 * @param String rgnCd
	 * @return RegionVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public RegionVO searchRegionCode(String rgnCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<RegionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("rgn_cd", rgnCd);
			velParam.put("rgn_cd", rgnCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAOsearchRegionCodeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RegionVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.size()>0?list.get(0):null;
	}
	 
	/**
	 * 신규 Region 정보를 저장합니다.<br>
	 * 
	 * @param RegionVO rgnVO
	 * @exception DAOException
	 */
	public void addRegionCode(RegionVO rgnVO) throws DAOException {
			SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(rgnVO != null){
				
				Map<String, String> mapVO = rgnVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new LocationDBDAOaddRegionCodeCSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to insert SQL");
				}
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
	 * Region 정보를 수정합니다.<br>
	 * 
	 * @param RegionVO rgnVO
	 * @exception DAOException
	 */
	public void modifyRegionCode(RegionVO rgnVO) throws DAOException {
			SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(rgnVO != null){
				
				Map<String, String> mapVO = rgnVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new LocationDBDAOmodifyRegionCodeUSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to update SQL");
				}
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
	 * State을 조회합니다.<br>
	 * 
	 * @param String steCd
	 * @param String cntCd
	 * @return StateVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public StateVO searchStateCode(String steCd, String cntCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<StateVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("ste_cd", steCd);
			param.put("cnt_cd", cntCd);
			velParam.put("ste_cd", steCd);
			velParam.put("cnt_cd", cntCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAOsearchStateCodeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, StateVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.size()>0?list.get(0):null;
	}
	 
	/**
	 * 신규 State 정보를 저장합니다.<br>
	 * 
	 * @param StateVO steVO
	 * @exception DAOException
	 */
	public void addStateCode(StateVO steVO) throws DAOException {
			SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(steVO != null){
				
				Map<String, String> mapVO = steVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new LocationDBDAOaddStateCodeCSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to insert SQL");
				}
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
	 * State 정보를 수정합니다.<br>
	 * 
	 * @param StateVO steVO
	 * @exception DAOException
	 */
	public void modifyStateCode(StateVO steVO) throws DAOException {
			SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(steVO != null){
				
				Map<String, String> mapVO = steVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new LocationDBDAOmodifyStateCodeUSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to update SQL");
				}
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
	 * Location을 조회합니다.<br>
	 * 
	 * @param String locCd
	 * @return LocationVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public LocationVO searchLocCode(String locCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<LocationVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("loc_cd", locCd);
			velParam.put("loc_cd", locCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAOsearchLocCodeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LocationVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.size()>0?list.get(0):null;
	}
	 
	 /**
	 * Location을 조회합니다.<br>
	 * 
	 * @param String rqstNo
	 * @return LocationVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public LocationVO searchLocCodeRqst(String rqstNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<LocationVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("rqst_no", rqstNo);
			velParam.put("rqst_no", rqstNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAOsearchLocCodeRqstRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LocationVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.size()>0?list.get(0):null;
	}
	 
	/**
	 * 신규 Location 정보를 저장합니다.<br>
	 * 
	 * @param LocationVO locVO
	 * @exception DAOException
	 */
	public void addLocCode(LocationVO locVO) throws DAOException {
			SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(locVO != null){
				
				Map<String, String> mapVO = locVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new LocationDBDAOaddLocCodeCSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to insert SQL");
				}
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
	 * 신규 Location 정보를 저장합니다.<br>
	 * 
	 * @param LocationVO locVO
	 * @exception DAOException
	 */
	public void addLocCodeRqst(LocationVO locVO) throws DAOException {
			SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(locVO != null){
				
				Map<String, String> mapVO = locVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new LocationDBDAOaddLocCodeRqstCSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to insert SQL");
				}
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
	 * Location 정보를 수정합니다.<br>
	 * 
	 * @param LocationVO locVO
	 * @exception DAOException
	 */
	public void modifyLocCode(LocationVO locVO) throws DAOException {
			SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(locVO != null){
				
				Map<String, String> mapVO = locVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new LocationDBDAOmodifyLocCodeUSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to update SQL");
				}
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
	 * Location 정보를 수정합니다.<br>
	 * 
	 * @param LocationVO locVO
	 * @exception DAOException
	 */
	public void modifyLocCodeRqst(LocationVO locVO) throws DAOException {
			SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(locVO != null){
				
				Map<String, String> mapVO = locVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new LocationDBDAOmodifyLocCodeRqstUSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to update SQL");
				}
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
	 * Yard를 조회합니다.<br>
	 * 
	 * @param String ydCd
	 * @return YardVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public YardVO searchYardCode(String ydCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<YardVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("yd_cd", ydCd);
			velParam.put("yd_cd", ydCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAOsearchYardCodeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, YardVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.size()>0?list.get(0):null;
	}
	 
	 /**
	 * Yard를 조회합니다.<br>
	 * 
	 * @param String rqstNo
	 * @return YardVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public YardVO searchYardRqst(String rqstNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<YardVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("rqst_no", rqstNo);
			velParam.put("rqst_no", rqstNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAOsearchYardRqstRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, YardVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.size()>0?list.get(0):null;
	}
	 
	/**
	 * 신규 Yard 정보를 저장합니다.<br>
	 * 
	 * @param YardVO ydVO
	 * @exception DAOException
	 */
	public void addYardCode(YardVO ydVO) throws DAOException {
			SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(ydVO != null){
				
				Map<String, String> mapVO = ydVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new LocationDBDAOaddYardCodeCSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to insert SQL");
				}
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
	 * 신규 Yard 정보를 저장합니다.<br>
	 * 
	 * @param YardVO ydVO
	 * @exception DAOException
	 */
	public void addYardRqst(YardVO ydVO) throws DAOException {
			SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(ydVO != null){
				
				Map<String, String> mapVO = ydVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new LocationDBDAOaddYardRqstCSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to insert SQL");
				}
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
	 * Yard 정보를 수정합니다.<br>
	 * 
	 * @param YardVO ydVO
	 * @exception DAOException
	 */
	public void modifyYardCode(YardVO ydVO) throws DAOException {
			SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(ydVO != null){
				
				Map<String, String> mapVO = ydVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new LocationDBDAOmodifyYardCodeUSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to update SQL");
				}
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
	 * Yard 정보를 수정합니다.<br>
	 * 
	 * @param YardVO ydVO
	 * @exception DAOException
	 */
	public void modifyYardRqst(YardVO ydVO) throws DAOException {
			SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(ydVO != null){
				
				Map<String, String> mapVO = ydVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new LocationDBDAOmodifyYardRqstUSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to update SQL");
				}
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
	 * Equipment ORG Chart를 조회합니다.<br>
	 * 
	 * @param String locType
	 * @param String location
	 * @param String deltFlg
	 * @return List<EqOrgChartVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<EqOrgChartVO> searchEqOrgChtList(String locType, String location, String deltFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<EqOrgChartVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			ArrayList<String>  arrLocation = new ArrayList<String>();
			StringTokenizer tokenTpszcd = new StringTokenizer(location, ",");
			while (tokenTpszcd.hasMoreTokens()) {
				arrLocation.add(tokenTpszcd.nextToken());
			}
			
			velParam.put("loc_type", locType);
			velParam.put("arr_location", arrLocation);
			velParam.put("delt_flg", deltFlg);
			param.put("delt_flg", deltFlg);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAOsearchEqOrgChtRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EqOrgChartVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * MDM_EQ_ORZ_CHT Check<br>
	 * 
	 * @param String sccCd
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet checkSccCdMdmEqOrzCht(String sccCd) throws DAOException {
		DBRowSet dbRowset = null;		
		Map<String, Object> param = new HashMap<String, Object>();//parameter		
			try {
				if(sccCd != null){
					param.put("scc_cd",sccCd);
				}				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAOCheckSccCdMdmEqOrzChtRSQL(), param, null);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return dbRowset;
	}
	
	/**
	 * MDM_LOCATION Check<br>
	 * 
	 * @param String sccCd
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet checkSccCdMdmLocation(String sccCd) throws DAOException {
		DBRowSet dbRowset = null;		
		Map<String, Object> param = new HashMap<String, Object>();//parameter		
			try {
				if(sccCd != null){
					param.put("scc_cd",sccCd);
				}				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAOCheckSccCdMdmLocationRSQL(), param, null);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return dbRowset;
	}
	
	/**
	 * MDM_YARD Check<br>
	 * 
	 * @param String sccCd
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet checkSccCdMdmYard(String sccCd) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();//parameter		
			try {
				if(sccCd != null){
					param.put("scc_cd",sccCd);
				}				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAOCheckSccCdMdmYardRSQL(), param, null);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return dbRowset;
	}
	 
	/**
	 * Key Validation<br>
	 * 
	 * @param String sccCd
	 * @return String
	 * @exception DAOException
	 */
	public String checkEqOrgChtKey(String sccCd) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnStr = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("scc_cd", sccCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAOCheckEqOrgChtKeyRSQL(), param, null);
			if(dbRowset != null) {
				while(dbRowset.next()) {
					rtnStr = dbRowset.getString(1);
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnStr;
	}
	
	/**
	 * Loc Validation<br>
	 * 
	 * @param String div
	 * @param EqOrgChartVO eqOrgChartVO
	 * @return String
	 * @exception DAOException
	 */
	public String checkLocValidation(String div, EqOrgChartVO eqOrgChartVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnStr = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(eqOrgChartVO != null) {
				
				Map<String, String> mapVO = eqOrgChartVO.getColumnValues();
				param.putAll(mapVO);
				param.put("div", div);
				velParam.put("div", div);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAOCheckLocValidationRSQL(), param, velParam);
				if(dbRowset != null) {
					while(dbRowset.next()) {
						if(dbRowset.getInt(1) > 0) {
							rtnStr = "F";
						}
					}
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnStr;
	}
	 
	/**
	 * 신규 Equipment ORG Chart 정보를 저장합니다.<br>
	 * 
	 * @param EqOrgChartVO eqOrgChartVO
	 * @exception DAOException
	 */
	public void addEqOrgCht(EqOrgChartVO eqOrgChartVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(eqOrgChartVO != null) {
				
				Map<String, String> mapVO = eqOrgChartVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new LocationDBDAOaddEqOrgChtCSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to insert SQL");
				}
			} 
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	
	/**
	 *  MDM_EQ_ORZ_CHT와 자동 Sync되도록 처리 .<br>
	 * 
	 * @param String user_id
	 * @exception DAOException
	 */
	public void addEqrCreLocLvlPrc(String user_id) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(user_id != null) {
				
				param.put("usr_id", user_id);
				velParam.put("usr_id", user_id);
				
				Map<String, Object> rtnrslt = sqlExe.executeSP((ISQLTemplate) new LocationDBDAOaddEqrEccMstCSQL(), param, velParam);

				if (rtnrslt == null) {
					throw new DAOException("Fail to insert SQL");
				}
			} 
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Equipment ORG Chart 정보를 수정합니다.<br>
	 * 
	 * @param EqOrgChartVO eqOrgChartVO
	 * @exception DAOException
	 */
	public void modifyEqOrgCht(EqOrgChartVO eqOrgChartVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(eqOrgChartVO != null) {
				
				Map<String, String> mapVO = eqOrgChartVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new LocationDBDAOmodifyEqOrgChtUSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to update SQL");
				}
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
	 * Leasing Company Yard를 조회합니다.<br>
	 * 
	 * @param String lseCoYdCd
	 * @return LseComYardVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public LseComYardVO searchLseCoYd(String lseCoYdCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<LseComYardVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("lse_co_yd_cd", lseCoYdCd);
			velParam.put("lse_co_yd_cd", lseCoYdCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAOsearchLseCoYdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LseComYardVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.size()>0?list.get(0):null;
	}
	 
	/**
	 * 신규 Leasing Company Yard 정보를 저장합니다.<br>
	 * 
	 * @param LseComYardVO lseCoYdVO
	 * @exception DAOException
	 */
	public void addLseCoYd(LseComYardVO lseCoYdVO) throws DAOException {
			SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(lseCoYdVO != null){
				
				Map<String, String> mapVO = lseCoYdVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new LocationDBDAOaddLseCoYdCSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to insert SQL");
				}
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
	 * Leasing Company Yard 정보를 수정합니다.<br>
	 * 
	 * @param LseComYardVO lseCoYdVO
	 * @exception DAOException
	 */
	public void modifyLseCoYd(LseComYardVO lseCoYdVO) throws DAOException {
			SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(lseCoYdVO != null){
				
				Map<String, String> mapVO = lseCoYdVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new LocationDBDAOmodifyLseCoYdUSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to update SQL");
				}
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
	 * DayLight Saving Time을 조회합니다.<br>
	 * 
	 * @param String dstId
	 * @return DaySavingTimeVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public DaySavingTimeVO searchDyLgtSavTm(String dstId) throws DAOException {
		DBRowSet dbRowset = null;
		List<DaySavingTimeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("dst_id", dstId);
			velParam.put("dst_id", dstId);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAOsearchDyLgtSavTmRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DaySavingTimeVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.size()>0?list.get(0):null;
	}
	 
	/**
	 * 신규 DayLight Saving Time 정보를 저장합니다.<br>
	 * 
	 * @param DaySavingTimeVO dystVO
	 * @exception DAOException
	 */
	public void addDyLgtSavTm(DaySavingTimeVO dystVO) throws DAOException {
			SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(dystVO != null){
				
				Map<String, String> mapVO = dystVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new LocationDBDAOaddDyLgtSavTmCSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to insert SQL");
				}
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
	 * DayLight Saving Time 정보를 수정합니다.<br>
	 * 
	 * @param DaySavingTimeVO dystVO
	 * @exception DAOException
	 */
	public void modifyDyLgtSavTm(DaySavingTimeVO dystVO) throws DAOException {
			SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(dystVO != null){
				
				Map<String, String> mapVO = dystVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new LocationDBDAOmodifyDyLgtSavTmUSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to update SQL");
				}
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
	 * Zone master 정보를 조회합니다.<br>
	 * 
	 * @param String znCd
	 * @return YardVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public ZoneVO searchZoneCode(String znCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<ZoneVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("zn_cd", znCd);
			velParam.put("zn_cd", znCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAOsearchZoneCodeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ZoneVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.size()>0?list.get(0):null;
	}
	 
	 /**
	 * Zone master 정보를 조회합니다.<br>
	 * 
	 * @param String rqstNo
	 * @return YardVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public ZoneVO searchZoneRqst(String rqstNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<ZoneVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("rqst_no", rqstNo);
			velParam.put("rqst_no", rqstNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAOsearchZoneRqstRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ZoneVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.size()>0?list.get(0):null;
	}
	 
	/**
	 * Zone detail 정보를 조회합니다.<br>
	 * 
	 * @param String znCd
	 * @return YardVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ZoneDtlVO> searchZoneDtlCode(String znCd, String znSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<ZoneDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("zn_cd", znCd);
			velParam.put("zn_cd", znCd);
			param.put("zn_seq", znSeq);
			velParam.put("zn_seq", znSeq);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAOsearchZoneDtlCodeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ZoneDtlVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	 /**
	 * Zone detail 정보를 조회합니다.<br>
	 * 
	 * @param String rqstNo
	 * @return List<ZoneDtlVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ZoneDtlVO> searchZoneDtlRqst(String rqstNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<ZoneDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("rqst_no", rqstNo);
			velParam.put("rqst_no", rqstNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAOsearchZoneDtlRqstRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ZoneDtlVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * 신규 Zone 정보를 저장합니다.<br>
	 * 
	 * @param ZoneVO zoneVO
	 * @exception DAOException
	 */
	public void addZoneCode(ZoneVO zoneVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try {
			if(zoneVO != null){
				
				Map<String, String> mapVO = zoneVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new LocationDBDAOaddZoneCodeCSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to insert SQL");
				}
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
	 * 신규 Zone 정보를 저장합니다.<br>
	 * 
	 * @param ZoneVO zoneVO
	 * @exception DAOException
	 */
	public void addZoneRqst(ZoneVO zoneVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try {
			if(zoneVO != null){
				
				Map<String, String> mapVO = zoneVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new LocationDBDAOaddZoneRqstCSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to insert SQL");
				}
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
	 * Zone 정보를 수정합니다.<br>
	 * 
	 * @param ZoneVO zoneVO
	 * @exception DAOException
	 */
	public void modifyZoneCode(ZoneVO zoneVO) throws DAOException {
			SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(zoneVO != null){
				
				Map<String, String> mapVO = zoneVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new LocationDBDAOmodifyZoneCodeUSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to update SQL");
				}
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
	 * Zone 정보를 수정합니다.<br>
	 * 
	 * @param ZoneVO zoneVO
	 * @exception DAOException
	 */
	public void modifyZoneRqst(ZoneVO zoneVO) throws DAOException {
			SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(zoneVO != null){
				
				Map<String, String> mapVO = zoneVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new LocationDBDAOmodifyZoneRqstUSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to update SQL");
				}
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
	 * 신규 Zone Detail 정보를 저장합니다.<br>
	 * 
	 * @param ZoneDtlVO dtlVO
	 * @exception DAOException
	 */
	public void addZoneDtlCode(ZoneDtlVO dtlVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
      try {
			if(dtlVO != null){
				Map<String, String> mapVO = dtlVO.getColumnValues();
				param.putAll(mapVO);
				int  insCnt = sqlExe.executeUpdate((ISQLTemplate)new LocationDBDAOaddZoneDtlCodeCSQL(), param, null);
				    if(insCnt== Statement.EXECUTE_FAILED)
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
	 * 신규 Zone Detail 정보를 저장합니다.<br>
	 * 
	 * @param ZoneDtlVO  dtlVO
	 * @exception DAOException
	 */
	public void addZoneDtlRqst(ZoneDtlVO  dtlVO) throws DAOException {	
		
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			if(dtlVO != null){
				Map<String, String> mapVO = dtlVO.getColumnValues();
				param.putAll(mapVO);

				int insCnt = sqlExe.executeUpdate((ISQLTemplate)new LocationDBDAOaddZoneDtlRqstCSQL(), param, null);
					if(insCnt== Statement.EXECUTE_FAILED)
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
	 * Zone 정보를 수정합니다.<br>
	 * 
	 * @param List<ZoneDtlVO> zoneDtlVOs
	 * @exception DAOException
	 */
	public void modifyZoneDtlCode(List<ZoneDtlVO> zoneDtlVOs) throws DAOException {
			SQLExecuter sqlExe = new SQLExecuter("");
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int updCnt[] = null;
		
		try {
			if(zoneDtlVOs != null){
				Map<String, String> mapVO = zoneDtlVOs.get(0).getColumnValues();
				velParam.putAll(mapVO);
				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new LocationDBDAOmodifyZoneDtlCodeUSQL(), zoneDtlVOs, velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
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
	 * Zone 정보를 수정합니다.<br>
	 * 
	 * @param List<ZoneDtlVO> zoneDtlVOs
	 * @exception DAOException
	 */
	public void modifyZoneDtlRqst(List<ZoneDtlVO> zoneDtlVOs) throws DAOException {
			SQLExecuter sqlExe = new SQLExecuter("");
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int updCnt[] = null;
		
		try {
			if(zoneDtlVOs != null){
				Map<String, String> mapVO = zoneDtlVOs.get(0).getColumnValues();
				velParam.putAll(mapVO);
				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new LocationDBDAOmodifyZoneDtlRqstUSQL(), zoneDtlVOs, velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
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
	 * zone code detail 정보를 삭제합니다.<br>
	 * 
	 * @param List<ZoneDtlVO> zoneDtlVOs
	 * @exception DAOException
	 */
	 public void removeZoneDtlCode(List<ZoneDtlVO> zoneDtlVOs) throws DAOException {
		int delCnt[] = null;
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(zoneDtlVOs != null){
				Map<String, String> mapVO = zoneDtlVOs.get(0).getColumnValues();
				velParam.putAll(mapVO);
			
				delCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new LocationDBDAOremoveZoneDtlCodeDSQL(), zoneDtlVOs, velParam);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	 
	 /**
	 * zone code detail 정보를 삭제합니다.<br>
	 * 
	 * @param List<ZoneDtlVO> zoneDtlVOs
	 * @exception DAOException
	 */
	 public void removeZoneDtlRqst(List<ZoneDtlVO> zoneDtlVOs) throws DAOException {
		int delCnt[] = null;
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(zoneDtlVOs != null){
				Map<String, String> mapVO = zoneDtlVOs.get(0).getColumnValues();
				velParam.putAll(mapVO);
			
				delCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new LocationDBDAOremoveZoneDtlRqstDSQL(), zoneDtlVOs, velParam);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	 
	/**
	 * Country Info retrieve.<br>
	 * 
	 * @param String rgnCd
	 * @return LocationVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public LocationVO searchCountryInfo(String rgnCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<LocationVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("rgn_cd", rgnCd);
			velParam.put("rgn_cd", rgnCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAOSearchCountryInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LocationVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.size()>0?list.get(0):null;
	}
	 
	/**
	 * Call EQR_CREATE_LOC_LVL_PRC Procedure.
	 *
	 * @param String usrId
	 * @throws DAOException
	 */
	public void callEqrLocLvl(String usrId) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

	    try {
			param.put("usr_id", usrId);
			new SQLExecuter("").executeSP((ISQLTemplate)new LocationDBDAOCallEqrLocLvlCSQL(), param, velParam);
	    } catch (SQLException se) {
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage());
	    } catch(Exception ex) {
	        log.error(ex.getMessage(),ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage());
	    }
	}

	/**
	 * Location EAI I/F 정보를 생성한다.(BCM_CCD_0019) For EAI I/F process<br>
	 *  
	 * @param LocationIfVO locationifVO
	 * @exception DAOException
	 */

	public void addLocIf(LocationIfVO locationifVO) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			if(locationifVO != null){
				Map<String, String> mapVO = locationifVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new LocationDBDAOAddLocIfCSQL(), param,velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");		
		}

		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}
	
	/**
	 * Location IBIS I/F 정보를 생성한다.(BCM_CCD_0019) For IBIS I/F process<br>
	 *  
	 * @param LocationIfVO locationifVO
	 * @exception DAOException
	 */

	public void addLocIbisIf(LocationIfVO locationifVO) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			if(locationifVO != null){
				Map<String, String> mapVO = locationifVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new LocationDBDAOaddLocIbisIfCSQL(), param,velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");		
		}

		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}

	/**
	 * Location EAI I/F 의 테이블(MDM_LOCATION_IF)의 LOC_IF_SEQ 생성값을 조회 합니다.(BCM_CCD_0019)<br>
	 * 
	 * @return 	DBRowSet 
	 * @exception DAOException
	 */
	public DBRowSet searchLocIfSeq() throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		try {		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAOSearchLocIfSeqRSQL(), null, null);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * Yard EAI I/F 정보를 생성한다.(BCM_CCD_0020) For EAI I/F process<br>
	 *  
	 * @param YardIfVO yardifVO
	 * @exception DAOException
	 */

	public void addYardIf(YardIfVO yardifVO) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			if(yardifVO != null){
				Map<String, String> mapVO = yardifVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new LocationDBDAOAddYardIfCSQL(), param,velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");		
		}

		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}
	
	/**
	 * Yard Ibis I/F 정보를 생성한다.(BCM_CCD_0020) For Ibis I/F process<br>
	 *  
	 * @param YardIfVO yardifVO
	 * @exception DAOException
	 */

	public void addYardIbisIf(YardIfVO yardifVO) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			if(yardifVO != null){
				Map<String, String> mapVO = yardifVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new LocationDBDAOAddYardIbisIfCSQL(), param,velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");		
		}

		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}

	/**
	 * Yard EAI I/F 의 테이블(MDM_YARD_IF)의 YD_IF_SEQ 생성값을 조회 합니다.(BCM_CCD_0020)<br>
	 * 
	 * @return 	DBRowSet 
	 * @exception DAOException
	 */
	public DBRowSet searchYardIfSeq() throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		try {		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAOSearchYardIfSeqRSQL(), null, null);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * Country EAI I/F 정보를 생성한다.(BCM_CCD_0016) For EAI I/F process<br>
	 *  
	 * @param CountryIfVO countryifVO
	 * @exception DAOException
	 */

	public void addCountryIf(CountryIfVO countryifVO) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			if(countryifVO != null){
				Map<String, String> mapVO = countryifVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new LocationDBDAOAddCountryIfCSQL(), param,velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");		
		}

		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}
	
	/**
	 * Country IBIS I/F 정보를 생성한다.(BCM_CCD_0016) For IBIS I/F process<br>
	 *  
	 * @param CountryIfVO countryifVO
	 * @exception DAOException
	 */

	public void addCountryIbisIf(CountryIfVO countryifVO) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			if(countryifVO != null){
				Map<String, String> mapVO = countryifVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new LocationDBDAOAddCountryIbisIfCSQL(), param,velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");		
		}

		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}

	/**
	 * Country EAI I/F 의 테이블(MDM_COUNTRY_IF)의 CNT_IF_SEQ 생성값을 조회 합니다.(BCM_CCD_0016)<br>
	 * 
	 * @return 	DBRowSet 
	 * @exception DAOException
	 */
	public DBRowSet searchCountryIfSeq() throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		try {		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAOSearchCountryIfSeqRSQL(), null, null);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * State EAI I/F 정보를 생성한다.(BCM_CCD_0018) For EAI I/F process<br>
	 *  
	 * @param StateIfVO stateifVO
	 * @exception DAOException
	 */

	public void addStateIf(StateIfVO stateifVO) throws DAOException, Exception {
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		
		int result = 0;
		try {
			if(stateifVO != null){
				Map<String, String> mapVO = stateifVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new LocationDBDAOAddStateIfCSQL(), param,velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");		
		}

		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}

	/**
	 * State EAI I/F 의 테이블(MDM_STATE_IF)의 STE_IF_SEQ 생성값을 조회 합니다.(BCM_CCD_0018)<br>
	 *  
	 * @return 	DBRowSet 
	 * @exception DAOException
	 */
	public DBRowSet searchStateIfSeq() throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		try {		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAOSearchStateIfSeqRSQL(), null, null);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * LOCATION & EQ SCC Validation<br>
	 * 
	 * @param String locCd
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet checkLocSccValidation(String locCd) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();//parameter
			try {
				if(locCd != null){
					param.put("loc_cd",locCd);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAOCheckLocSccValidationRSQL(), param, null);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return dbRowset;
	}
	
	/**
	 * DayLight Saving Time <br>
	 * 엑셀 로드후 저장. 160304 추가 
	 * @param DaySavingTimeVO dystVO
	 * @exception DAOException
	 */
	public void excelAddDyLgtSavTm(DaySavingTimeVO dystVO) throws DAOException {
			SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(dystVO != null){
				
				Map<String, String> mapVO = dystVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);		 
				int result = sqlExe.executeUpdate((ISQLTemplate)new LocationDBDAOexcelAddDyLgtSavTmCSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to update SQL");
				}
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
	 * 추가할 Zone Detail Sequence 채번
	 * 
	 * @param znCd
	 * @return
	 * @throws DAOException
	 */
	public String searchZoneDtlSeq(String znCd) throws DAOException {
		DBRowSet dbRowset = null;
		String znDtlSeq = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if(znCd != null) {
				param.put("zn_cd", znCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAOsearchZoneDtlSeqRSQL(), param, null);
			if(dbRowset != null) {
				while(dbRowset.next()) {
					znDtlSeq = dbRowset.getString(1);
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return znDtlSeq;
	}
	
	/**
	 * EAI Interface를 위한 Location Info 조회<br>
	 * 
	 * @param String locCd
	 * @return LocationMainIfVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public LocationMainIfVO searchLocToEai(String locCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<LocationMainIfVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("loc_cd", locCd);
			velParam.put("loc_cd", locCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAOsearchLocToEaiRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LocationMainIfVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.size()>0?list.get(0):null;
	}
	
	/**
	 * EAI Interface를 위한 Yard Info 조회<br>
	 * 
	 * @param String ydCd
	 * @return YardMainVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public YardMainIfVO searchYdToEai(String ydCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<YardMainIfVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("yd_cd", ydCd);
			velParam.put("yd_cd", ydCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAOsearchYardToEaiRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, YardMainIfVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.size()>0?list.get(0):null;
	}
	 
	/**
	 * (BCM_CCD_0024)<br>
	 *  
	 * @return 	DBRowSet 
	 * @exception DAOException
	 */
	public DBRowSet searchNewDstCode(String fnDstId, String dstNotAplySteCd) throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {		
			if(fnDstId != null){
				param.put("fnDstId", fnDstId);
			}
			if(dstNotAplySteCd != null){
				param.put("dstNotAplySteCd", dstNotAplySteCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAOsearchDyLgtSavTmCodeSQL(), param, param);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * 신규 Zone 정보를 Prd Node에 저장합니다.<br>
	 * 
	 * @param ZoneVO zoneVO
	 * @exception DAOException
	 */
	public void addZoneToPrdNode(ZoneVO zoneVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try {
			if(zoneVO != null){
				
				Map<String, String> mapVO = zoneVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new LocationDBDAOaddZoneToPrdNodeCSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to insert SQL");
				}
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
	 * Prd Node의 Zone 정보를 수정합니다.<br>
	 * 
	 * @param ZoneVO zoneVO
	 * @exception DAOException
	 */
	public void modifyZoneToPrdNode(ZoneVO zoneVO) throws DAOException {
			SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(zoneVO != null){
				
				Map<String, String> mapVO = zoneVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new LocationDBDAOmodifyZoneToPrdNodeUSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to update SQL");
				}
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
	 * 신규 Yard 정보를 Prd Node에 저장합니다.<br>
	 * 
	 * @param YardVO ydVO
	 * @exception DAOException
	 */
	public void addYardToPrdNode(YardVO ydVO) throws DAOException {
			SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(ydVO != null){
				
				Map<String, String> mapVO = ydVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new LocationDBDAOaddYardToPrdNodeCSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to insert SQL");
				}
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
	 * Prd Node의 Yard 정보를 수정합니다.<br>
	 * 
	 * @param YardVO ydVO
	 * @exception DAOException
	 */
	public void modifyYardToPrdNode(YardVO ydVO) throws DAOException {
			SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(ydVO != null){
				
				Map<String, String> mapVO = ydVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new LocationDBDAOmodifyYardToPrdNodeUSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to update SQL");
				}
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
	 * Prd Node 중복 체크<br>
	 * 
	 * @param String nodCd
	 * @return String
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public String searchPrdNod(String nodCd) throws DAOException {
		DBRowSet dbRowset = null;
		String nodChk = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("nod_cd", nodCd);
			velParam.put("nod_cd", nodCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAOsearchPrdNodeRSQL(), param, velParam);
			if(dbRowset != null) {
				while(dbRowset.next()) {
					nodChk = dbRowset.getString(1);
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return nodChk;
	}
} 