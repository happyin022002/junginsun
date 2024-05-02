/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LocationDAO.java
*@FileTitle : Location Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.04.28 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.location.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.location.basic.LocationBCImpl;
import com.hanjin.apps.alps.esm.pri.primasterdata.location.vo.RsltCntListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.location.vo.RsltGrpLocDtlListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.location.vo.RsltGrpLocListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.location.vo.RsltLocListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.location.vo.RsltRgnListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.location.vo.RsltSteListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * NIS2010 LocationDAO <br>
 * - NIS2010-PRIMasterData system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author CHOI SUNG MIN
 * @see LocationBCImpl 참조
 * @since J2EE 1.4
 */
public class LocationDBDAO extends DBDAOSupport {

	/**
	 * COUNTRY CODE를 조회한다.<br>
	 * 
	 * @param RsltCntListVO rsltCntListVO
	 * @return List<RsltCntListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltCntListVO> searchCountryList(RsltCntListVO rsltCntListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCntListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltCntListVO != null){
				Map<String, String> mapVO = rsltCntListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAORsltCntListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltCntListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	/**
	 * LOCATION CODE를 조회한다.<br>
	 * 
	 * @param RsltLocListVO rsltLocListVO
	 * @return List<RsltLocListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltLocListVO> searchLocationList(RsltLocListVO rsltLocListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltLocListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltLocListVO != null){
				Map<String, String> mapVO = rsltLocListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAORsltLocListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltLocListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * STATE CODE를 조회한다.<br>
	 * 
	 * @param RsltSteListVO rsltSteListVO
	 * @return List<RsltSteListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltSteListVO> searchStateList(RsltSteListVO rsltSteListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltSteListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltSteListVO != null){
				Map<String, String> mapVO = rsltSteListVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAORsltSteListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltSteListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	/**
	 * S/C PROPOSAL의 GROUP LOCATION CODE를 조회한다.<br>
	 * 
	 * @param RsltGrpLocListVO rsltGrpLocListVO
	 * @return List<RsltGrpLocListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltGrpLocListVO> searchSpScpGroupLocationList(RsltGrpLocListVO rsltGrpLocListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpLocListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltGrpLocListVO != null){
				Map<String, String> mapVO = rsltGrpLocListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAORsltSpScpGrpLocListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpLocListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	/**
	 * S/C GUIDELINE의 GROUP LOCATION CODE를 조회한다.<br>
	 * 
	 * @param RsltGrpLocListVO rsltGrpLocListVO
	 * @return List<RsltGrpLocListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltGrpLocListVO> searchSgGroupLocationList(RsltGrpLocListVO rsltGrpLocListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpLocListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltGrpLocListVO != null){
				Map<String, String> mapVO = rsltGrpLocListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAORsltSgGrpLocListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpLocListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	/**
	 * RFA GUIDELINE의 GROUP LOCATION CODE를 조회한다.<br>
	 * 
	 * @param RsltGrpLocListVO rsltGrpLocListVO
	 * @return List<RsltGrpLocListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltGrpLocListVO> searchRgGroupLocationList(RsltGrpLocListVO rsltGrpLocListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpLocListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltGrpLocListVO != null){
				Map<String, String> mapVO = rsltGrpLocListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAORsltRgGrpLocListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpLocListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	/**
	 * RFA PROPOSAL의 GROUP LOCATION CODE를 조회한다.<br>
	 * 
	 * @param RsltGrpLocListVO rsltGrpLocListVO
	 * @return List<RsltGrpLocListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltGrpLocListVO> searchRpScpGroupLocationList(RsltGrpLocListVO rsltGrpLocListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpLocListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltGrpLocListVO != null){
				Map<String, String> mapVO = rsltGrpLocListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAORsltRpScpGrpLocListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpLocListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 
	/**
	 * SURCHARGE의 GROUP LOCATION CODE를 조회한다.<br>
	 * 
	 * @param RsltGrpLocListVO rsltGrpLocListVO
	 * @return List<RsltGrpLocListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltGrpLocListVO> searchScgGroupLocationList(RsltGrpLocListVO rsltGrpLocListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpLocListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltGrpLocListVO != null){
				Map<String, String> mapVO = rsltGrpLocListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAORsltScgGrpLocListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpLocListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
 
	/**
	 * CMPB의 GROUP LOCATION CODE를 조회한다.<br>
	 * 
	 * @param RsltGrpLocListVO rsltGrpLocListVO
	 * @return List<RsltGrpLocListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltGrpLocListVO> searchCMPBGroupLocationList(RsltGrpLocListVO rsltGrpLocListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpLocListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltGrpLocListVO != null){
				Map<String, String> mapVO = rsltGrpLocListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAORsltCmpbGrpLocListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpLocListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 
	/**
	 * REGION CODE를 조회한다.<br>
	 * 
	 * @param RsltRgnListVO rsltRgnListVO
	 * @return List<RsltRgnListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltRgnListVO> searchRegionList(RsltRgnListVO rsltRgnListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRgnListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltRgnListVO != null){
				Map<String, String> mapVO = rsltRgnListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAORsltRgnListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltRgnListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 
	/**
	 * RFA GUIDELINE의 GROUP LOCATION DETAIL CODE를 조회한다.<br>
	 * 
	 * @param RsltGrpLocDtlListVO rsltGrpLocDtlListVO
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltGrpLocDtlListVO> searchRgGroupLocationDetailList(RsltGrpLocDtlListVO rsltGrpLocDtlListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpLocDtlListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltGrpLocDtlListVO != null){
				Map<String, String> mapVO = rsltGrpLocDtlListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAORsltRgGrpLocDtlListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpLocDtlListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
		
	/**
	 * S/C GUIDELINE의 GROUP LOCATION DETAIL CODE를 조회한다.<br>
	 * 
	 * @param RsltGrpLocDtlListVO rsltGrpLocDtlListVO
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltGrpLocDtlListVO> searchSgGroupLocationDetailList(RsltGrpLocDtlListVO rsltGrpLocDtlListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpLocDtlListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltGrpLocDtlListVO != null){
				Map<String, String> mapVO = rsltGrpLocDtlListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAORsltSgGrpLocDtlListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpLocDtlListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 
	/**
	 * SURCHARGE의 GROUP LOCATION DETAIL CODE를 조회한다.<br>
	 * 
	 * @param RsltGrpLocDtlListVO rsltGrpLocDtlListVO
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltGrpLocDtlListVO> searchScgGroupLocationDetailList(RsltGrpLocDtlListVO rsltGrpLocDtlListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpLocDtlListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltGrpLocDtlListVO != null){
				Map<String, String> mapVO = rsltGrpLocDtlListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAORsltScgGrpLocDtlListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpLocDtlListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 
	/**
	 * RFA PROPOSAL의 GROUP LOCATION DETAIL CODE를 조회한다.<br>
	 * 
	 * @param RsltGrpLocDtlListVO rsltGrpLocDtlListVO
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltGrpLocDtlListVO> searchRpScpGroupLocationDetailList(RsltGrpLocDtlListVO rsltGrpLocDtlListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpLocDtlListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltGrpLocDtlListVO != null){
				Map<String, String> mapVO = rsltGrpLocDtlListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAORsltRpScpGrpLocDtlListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpLocDtlListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 
	/**
	 * CMPB의 GROUP LOCATION DETAIL CODE를 조회한다.<br>
	 * 
	 * @param RsltGrpLocDtlListVO rsltGrpLocDtlListVO
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltGrpLocDtlListVO> searchCMPBGroupLocationDetailList(RsltGrpLocDtlListVO rsltGrpLocDtlListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpLocDtlListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltGrpLocDtlListVO != null){
				Map<String, String> mapVO = rsltGrpLocDtlListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAORsltCmpbGrpLocDtlListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpLocDtlListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * S/C PROPOSAL의 GROUP LOCATION DETAIL CODE를 조회한다.<br>
	 * 
	 * @param RsltGrpLocDtlListVO rsltGrpLocDtlListVO
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltGrpLocDtlListVO> searchSpScpGroupLocationDetailList(RsltGrpLocDtlListVO rsltGrpLocDtlListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpLocDtlListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltGrpLocDtlListVO != null){
				Map<String, String> mapVO = rsltGrpLocDtlListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAORsltSpScpGrpLocDtlListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpLocDtlListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * COUNTRY CODE를 조회한다.<br>
	 * 
	 * @param RsltCdListVO rsltCobCntListVO
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchComboCountryList(RsltCdListVO rsltCobCntListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltCobCntListVO != null){
				Map<String, String> mapVO = rsltCobCntListVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAORsltCobCntListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
		 
	/**
	 * SQ GROUP LOCATION DETAIL CODE를 조회한다.<br>
	 * 
	 * @param RsltGrpLocDtlListVO rsltGrpLocDtlListVO
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltGrpLocDtlListVO> searchSQGroupLocationDetailList(RsltGrpLocDtlListVO rsltGrpLocDtlListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpLocDtlListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltGrpLocDtlListVO != null){
				Map<String, String> mapVO = rsltGrpLocDtlListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAORsltSqGrpLocDtlListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpLocDtlListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 
	/**
	 * SQ의 GROUP LOCATION CODE를 조회한다.<br>
	 * 
	 * @param RsltGrpLocListVO rsltGrpLocListVO
	 * @return List<RsltGrpLocListVO>
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltGrpLocListVO> searchSQGroupLocationList(RsltGrpLocListVO rsltGrpLocListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpLocListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltGrpLocListVO != null){
				Map<String, String> mapVO = rsltGrpLocListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAORsltSqGrpLocListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpLocListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 
	/**
	 * PRI_RQ_GRP_LOC를 조회한다.<br>
	 * 
	 * @param RsltGrpLocDtlListVO rsltGrpLocDtlListVO
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltGrpLocDtlListVO> searchRQGroupLocationDetailList(RsltGrpLocDtlListVO rsltGrpLocDtlListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpLocDtlListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltGrpLocDtlListVO != null){
				Map<String, String> mapVO = rsltGrpLocDtlListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAORsltRqGrpLocDtlListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpLocDtlListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 
	/**
	 * PRI_RQ_GRP_LOC_DTL을 조회한다.<br>
	 * 
	 * @param RsltGrpLocListVO rsltGrpLocListVO
	 * @return List<RsltGrpLocListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltGrpLocListVO> searchRQGroupLocationList(RsltGrpLocListVO rsltGrpLocListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGrpLocListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltGrpLocListVO != null){
				Map<String, String> mapVO = rsltGrpLocListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LocationDBDAORsltRqGrpLocListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltGrpLocListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
		 
}
