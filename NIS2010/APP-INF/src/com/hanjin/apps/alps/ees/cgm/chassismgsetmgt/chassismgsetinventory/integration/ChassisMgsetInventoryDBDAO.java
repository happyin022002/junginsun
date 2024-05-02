/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetInventoryDBDAO.java
*@FileTitle : Factor Adjustment by Location
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 박의수
*@LastVersion : 1.0
* 2009.05.13 박의수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.basic.ChassisMgsetInventoryBCImpl;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSAssetsDetailVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSAssetsOptionVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSAssetsSmryVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSEspFactorINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSEspFactorMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSEspReportINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSEspReportMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSHistoricalRptINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSHistoricalRptMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByAgmtINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByAgmtMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByOnhireYearINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByOnhireYearMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByStaydaysINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByStaydaysMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByVariationDtlINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByVariationDtlMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByVariationINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryByVariationMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryDtlINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryDtlMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryGeneralINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSInventoryGeneralMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSLongStaydaysEnvINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSLongStaydaysEnvMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSUtilFactorINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSUtilFactorMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSUtilizationINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.CHSUtilizationMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByLessorAgmtINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByLessorAgmtMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByLessorTermINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByLessorTermMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByLocationLessorINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByLocationLessorMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByOfficeINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryByOfficeMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryDetailINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryDetailMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryDtlINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryDtlMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryGeneralINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSInventoryGeneralMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo.MGSBareMVMTDataVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo.AssetsSmryVO;
import com.hanjin.apps.alps.esd.aoc.common.defaultcurr.integration.DefaultCurrDBDAOMultiCntDefaultCurrCSQL;
import com.hanjin.apps.alps.esd.aoc.common.defaultcurr.integration.DefaultCurrDBDAOMultiCntDefaultCurrDSQL;
import com.hanjin.apps.alps.esd.aoc.common.defaultcurr.integration.DefaultCurrDBDAOMultiCntDefaultCurrUSQL;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * NIS2010 ChassisMgsetInventoryDBDAO <br>
 * - NIS2010-ChassisMgsetMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Eui-su Park
 * @see ChassisMgsetInventoryBCImpl 참조
 * @since J2EE 1.4
 */
public class ChassisMgsetInventoryDBDAO extends DBDAOSupport {

	/** 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Chassis Inventory 에 count 된 장비별 상세 list 를 조회. [EES_CGM_1091].<br>
	 * 
	 * @param chsInventoryDtlINVO CHSInventoryDtlINVO
	 * @return List<CHSInventoryDtlMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSInventoryDtlMGTVO> searchCHSInventoryGeneralListData(CHSInventoryDtlINVO chsInventoryDtlINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSInventoryDtlMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(chsInventoryDtlINVO != null){
				Map<String, String> mapVO = chsInventoryDtlINVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInventoryDBDAOSearchCHSInventoryGeneralListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSInventoryDtlMGTVO .class);
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
	 * Chassis Inventory 에 count 된 장비별 상세 list 를 조회. [EES_CGM_1091].<br>
	 * 
	 * @param chsInventoryDtlINVO CHSInventoryDtlINVO
	 * @return List<CHSInventoryDtlMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSInventoryDtlMGTVO> searchCHSTermChangeListData(CHSInventoryDtlINVO chsInventoryDtlINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSInventoryDtlMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try{
			if(chsInventoryDtlINVO != null){
				Map<String, String> mapVO = chsInventoryDtlINVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInventoryDBDAOSearchCHSTermChangeListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSInventoryDtlMGTVO .class);
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
	 * MGSet Inventory List 를 가져온다. [EES_CGM_2084]<br>
	 * 
	 * @param mgsInventoryDtlINVO MGSInventoryDtlINVO
	 * @return List<MGSInventoryDtlMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<MGSInventoryDtlMGTVO> searchMGSInventoryGeneralListData(MGSInventoryDtlINVO mgsInventoryDtlINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSInventoryDtlMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try{
			if(mgsInventoryDtlINVO != null){
				Map<String, String> mapVO = mgsInventoryDtlINVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInventoryDBDAOSearchMGSInventoryGeneralListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MGSInventoryDtlMGTVO .class);
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
	 * MGSet Term Change List 를 가져온다. [EES_CGM_2084].<br>
	 * 
	 * @param mgsInventoryDtlINVO MGSInventoryDtlINVO
	 * @return List<MGSInventoryDtlMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<MGSInventoryDtlMGTVO> searchMGSTermChangeListData(MGSInventoryDtlINVO mgsInventoryDtlINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSInventoryDtlMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(mgsInventoryDtlINVO != null){
				Map<String, String> mapVO = mgsInventoryDtlINVO .getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInventoryDBDAOSearchMGSTermChangeListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MGSInventoryDtlMGTVO .class);
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
	 * Chassis General Inventory 를 가져온다. [EES_CGM_1089].<br>
	 * 
	 * @param chsInventoryGeneralINVO CHSInventoryGeneralINVO
	 * @return List<CHSInventoryGeneralMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSInventoryGeneralMGTVO> searchCHSInventoryGeneralData(CHSInventoryGeneralINVO chsInventoryGeneralINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSInventoryGeneralMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(chsInventoryGeneralINVO != null){
				Map<String, String> mapVO = chsInventoryGeneralINVO .getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInventoryDBDAOSearchCHSInventoryGeneralDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSInventoryGeneralMGTVO .class);
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
	 * MGSet Term Change List 를 가져온다. [EES_CGM_1091].<br>
	 * 
	 * @param cHSInventoryDtlINVO CHSInventoryDtlINVO
	 * @return List<CHSInventoryDtlMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSInventoryDtlMGTVO> searchCHSOnOffhireDtlListData(CHSInventoryDtlINVO cHSInventoryDtlINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSInventoryDtlMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(cHSInventoryDtlINVO != null){
				Map<String, String> mapVO = cHSInventoryDtlINVO .getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInventoryDBDAOSearchCHSOnOffhireDtlListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSInventoryDtlMGTVO .class);
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
	 *  Group By 조건에 따라, Staying Days 별 장비 수량 및 %를 보여준다. [EES_CGM_1092]<br>
	 * 
	 * @param chsInventoryByStaydaysINVO CHSInventoryByStaydaysINVO  
	 * @return List<CHSInventoryByStaydaysMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSInventoryByStaydaysMGTVO> searchCHSInventoryByStaydaysData(CHSInventoryByStaydaysINVO chsInventoryByStaydaysINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSInventoryByStaydaysMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(chsInventoryByStaydaysINVO != null){
				Map<String, String> mapVO = chsInventoryByStaydaysINVO .getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInventoryDBDAOsearchInventoryByStaydaysDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSInventoryByStaydaysMGTVO .class);
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
	 * CHASSIS INVENTORY Detail 리스트 데이터를 조회한다. [EES_CGM_1092]<br>
	 * 
	 * @param chsInventoryDtlINVO CHSInventoryDtlINVO 
	 * @return List<CHSInventoryDtlMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */	 
	 @SuppressWarnings("unchecked")
	public List<CHSInventoryDtlMGTVO> searchCHSInventoryByStaydaysListData(CHSInventoryDtlINVO chsInventoryDtlINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSInventoryDtlMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(chsInventoryDtlINVO != null){
				Map<String, String> mapVO = chsInventoryDtlINVO .getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInventoryDBDAOsearchInventoryByStaydaysListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSInventoryDtlMGTVO .class);
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
	 * CHASSIS INVENTORY Detail 리스트 데이터를 조회한다. [EES_CGM_1098]<br>
	 * 
	 * @param chsInventoryDtlINVO CHSInventoryDtlINVO 
	 * @return List<CHSInventoryDtlMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */	 	 
	 @SuppressWarnings("unchecked")
	public List<CHSInventoryDtlMGTVO> searchCHSInventoryByAgmtListData(CHSInventoryDtlINVO chsInventoryDtlINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSInventoryDtlMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(chsInventoryDtlINVO != null){
				Map<String, String> mapVO = chsInventoryDtlINVO .getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInventoryDBDAOsearchCHSInventoryByAgmtListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSInventoryDtlMGTVO .class);
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
	 * CHASSIS INVENTORY Detail 리스트 데이터를 조회한다. [EES_CGM_1100]<br>
	 * 
	 * @param chsInventoryDtlINVO CHSInventoryDtlINVO 
	 * @return List<CHSInventoryDtlMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */	 	 
	 @SuppressWarnings("unchecked")
	public List<CHSInventoryDtlMGTVO> searchCHSInventoryByOnhireYearListData(CHSInventoryDtlINVO chsInventoryDtlINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSInventoryDtlMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(chsInventoryDtlINVO != null){
				Map<String, String> mapVO = chsInventoryDtlINVO .getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInventoryDBDAOsearchCHSInventoryByOnhireYearListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSInventoryDtlMGTVO .class);
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
	 * CGM_LONG_STAY_DYS_ENV 테이블 로부터 USER ID 별 Long Staying Days 정보를 가져와 보여준다. [EES_CGM_1094]<br>
	 * 
	 * @param chsLongStaydaysEnvINVO CHSLongStaydaysEnvINVO 
	 * @return List<CHSLongStaydaysEnvMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */		 
	 @SuppressWarnings("unchecked")
	public List<CHSLongStaydaysEnvMGTVO> searchCHSLongstayEnvData(CHSLongStaydaysEnvINVO chsLongStaydaysEnvINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSLongStaydaysEnvMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(chsLongStaydaysEnvINVO != null){
				Map<String, String> mapVO = chsLongStaydaysEnvINVO .getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInventoryDBDAOsearchCHSLongstayEnvDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSLongStaydaysEnvMGTVO .class);
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
	 * User ID 별 Inventory By Long Staying Days 화면에서 쓰이는 그룹 기준 날짜를 설정한다. [EES_CGM_1094]<br>
	 * 
	 * @param cHSLongStaydaysEnvINVOs List<CHSLongStaydaysEnvINVO>
	 * @exception SQLException
	 * @exception Exception 
	 */			 
	 public void modifyCHSLongstayEnvData(List<CHSLongStaydaysEnvINVO> cHSLongStaydaysEnvINVOs) throws DAOException,Exception {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int insCnt[] = null;
				if(cHSLongStaydaysEnvINVOs.size() > 0){
					insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInventoryDBDAOmanageCHSLongstayEnvDataUSQL(), cHSLongStaydaysEnvINVOs,null);
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
	 * Inventory By Agreement 조회. [EES_CGM_1098]<br>
	 * 
	 * @param cHSInventoryByAgmtINVO CHSInventoryByAgmtINVO 
	 * @return List<CHSInventoryByAgmtMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */		 
	 @SuppressWarnings("unchecked")
	public List<CHSInventoryByAgmtMGTVO> searchCHSInventoryByAgmtData(CHSInventoryByAgmtINVO cHSInventoryByAgmtINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSInventoryByAgmtMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(cHSInventoryByAgmtINVO != null){
				Map<String, String> mapVO = cHSInventoryByAgmtINVO .getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInventoryDBDAOsearchCHSInventoryByAgmtDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSInventoryByAgmtMGTVO .class);
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
	 * GRID header 에 명시된 년도 단위로 Count summary 하여 표현. [EES_CGM_1100]<br>
	 * 
	 * @param cHSInventoryByOnhireYearINVO CHSInventoryByOnhireYearINVO 
	 * @return List<CHSInventoryByOnhireYearMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */			 
	 @SuppressWarnings("unchecked")
	public List<CHSInventoryByOnhireYearMGTVO> searchCHSInventoryByOnhireYearData(CHSInventoryByOnhireYearINVO cHSInventoryByOnhireYearINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSInventoryByOnhireYearMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(cHSInventoryByOnhireYearINVO != null){
				Map<String, String> mapVO = cHSInventoryByOnhireYearINVO.getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInventoryDBDAOsearchCHSInventoryByOnhireYearDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSInventoryByOnhireYearMGTVO .class);
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
	 * Status Change 인벤토리 조회(summary). [EES_CGM_1102]<br>
	 * 
	 * @param cHSInventoryByVariationINVO CHSInventoryByVariationINVO 
	 * @return List<CHSInventoryByVariationMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */			 
	 @SuppressWarnings("unchecked")
	public List<CHSInventoryByVariationMGTVO> searchCHSInventoryByVariationStsData(CHSInventoryByVariationINVO cHSInventoryByVariationINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSInventoryByVariationMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(cHSInventoryByVariationINVO != null){
				Map<String, String> mapVO = cHSInventoryByVariationINVO.getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInventoryDBDAOsearchCHSInventoryByVariationStsDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSInventoryByVariationMGTVO .class);
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
	 * Status Change 인벤토리 조회(detail). [EES_CGM_1103]<br>
	 * 
	 * @param cHSInventoryByVariationDtlINVO CHSInventoryByVariationDtlINVO 
	 * @return List<CHSInventoryByVariationDtlMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */		 
	 @SuppressWarnings("unchecked")
	public List<CHSInventoryByVariationDtlMGTVO> searchCHSInventoryByVariationDtlListData(CHSInventoryByVariationDtlINVO cHSInventoryByVariationDtlINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSInventoryByVariationDtlMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(cHSInventoryByVariationDtlINVO != null){
				Map<String, String> mapVO = cHSInventoryByVariationDtlINVO.getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInventoryDBDAOsearchCHSInventoryByVariationDtlListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSInventoryByVariationDtlMGTVO .class);
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
	 * CGM CHASSIS UTILIZATION EG5 COUNT 테이블로부터 yard 별 EG5 COUNT 조회. [EES_CGM_1111]<br>
	 * 
	 * @param cHSUtilFactorINVO CHSUtilFactorINVO 
	 * @return  List<CHSUtilFactorMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSUtilFactorMGTVO> searchCHSUtilFactortData(CHSUtilFactorINVO cHSUtilFactorINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSUtilFactorMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(cHSUtilFactorINVO != null){
				Map<String, String> mapVO = cHSUtilFactorINVO.getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInventoryDBDAOsearchCHSEg5CountDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSUtilFactorMGTVO .class);
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
	 * CGM CHASSIS UTILIZATION LOCATION USAGE 테이블로부터 데이터 조회한다. [EES_CGM_1111].<br>
	 * 
	 * @param cHSUtilFactorINVO CHSUtilFactorINVO 
	 * @return  List<CHSUtilFactorMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSUtilFactorMGTVO> searchCHSUtilFactortDtlData(CHSUtilFactorINVO cHSUtilFactorINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSUtilFactorMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(cHSUtilFactorINVO != null){
				Map<String, String> mapVO = cHSUtilFactorINVO.getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInventoryDBDAOsearchCHSUtilizationUsageDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSUtilFactorMGTVO .class);
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
	 * CGM CHASSIS UTILIZATION EG5 COUNT 테이블에 Insert. [EES_CGM_1111]<br>
	 * 
	 * @param cHSUtilFactorINVOs List<CHSUtilFactorINVO>
	 * @exception SQLException
	 * @exception Exception 
	 */
	public void addCHSEg5CountData(List<CHSUtilFactorINVO> cHSUtilFactorINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(cHSUtilFactorINVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInventoryDBDAOaddCHSEg5CountDataCSQL(), cHSUtilFactorINVOs,null);
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
	 * CGM CHASSIS UTILIZATION EG5 COUNT 테이블에 Update. [EES_CGM_1111]<br>
	 * 
	 * @param cHSUtilFactorINVOs List<CHSUtilFactorINVO> 
	 * @exception SQLException
	 * @exception Exception
	 */
	
	public void modifyCHSEg5CountData(List<CHSUtilFactorINVO> cHSUtilFactorINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(cHSUtilFactorINVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInventoryDBDAOmodifyCHSEg5CountDataUSQL(), cHSUtilFactorINVOs,null);
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
	 * CGM CHASSIS UTILIZATION LOCATION USAGE 테이블 에 Insert [EES_CGM_1111].<br>
	 * 
	 * @param cHSUtilFactorINVOs List<CHSUtilFactorINVO> 
	 * @exception SQLException
	 * @exception Exception
	 */
	public void addCHSUtilizationUsageData(List<CHSUtilFactorINVO> cHSUtilFactorINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(cHSUtilFactorINVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInventoryDBDAOaddCHSUtilizationUsageDataCSQL(), cHSUtilFactorINVOs,null);
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
	 * CGM CHASSIS UTILIZATION LOCATION USAGE 테이블에 Update [EES_CGM_1111]<br>
	 * 
	 * @param cHSUtilFactorINVOs List<CHSUtilFactorINVO> 
	 * @exception SQLException
	 * @exception Exception
	 */
	public void modifyCHSUtilizationUsageData(List<CHSUtilFactorINVO> cHSUtilFactorINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(cHSUtilFactorINVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInventoryDBDAOmodifyCHSUtilizationUsageDataUSQL(), cHSUtilFactorINVOs,null);
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
	 * Chassis Utilization Report 산출. [EES_CGM_1112]<br>
	 * 
	 * @param cHSUtilizationINVO CHSUtilizationINVO 
	 * @return  List<CHSUtilizationINVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSUtilizationMGTVO> searchCHSUtilizationRptInventoryData (CHSUtilizationINVO cHSUtilizationINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSUtilizationMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(cHSUtilizationINVO != null){
				Map<String, String> mapVO = cHSUtilizationINVO.getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate)new 
					ChassisMgsetInventoryDBDAOsearchCHSUtilizationRptInventoryDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSUtilizationMGTVO .class);
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
	 * Chassis Utilization Report 산출. [EES_CGM_1112]<br>
	 * 
	 * @param cHSUtilizationINVO CHSUtilizationINVO 
	 * @return  List<CHSUtilizationINVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSUtilizationMGTVO> searchCHSUtilizationRptWGData  (CHSUtilizationINVO cHSUtilizationINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSUtilizationMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(cHSUtilizationINVO != null){
				Map<String, String> mapVO = cHSUtilizationINVO.getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInventoryDBDAOsearchCHSUtilizationRptWGDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSUtilizationMGTVO .class);
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
	 * Chassis Utilization Report 산출. [EES_CGM_1112]<br>
	 * 
	 * @param cHSUtilizationINVO CHSUtilizationINVO 
	 * @return  List<CHSUtilizationINVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSUtilizationMGTVO> searchCHSUtilizationRptEtcData  (CHSUtilizationINVO cHSUtilizationINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSUtilizationMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(cHSUtilizationINVO != null){
				Map<String, String> mapVO = cHSUtilizationINVO.getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInventoryDBDAOsearchCHSUtilizationRptEtcDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSUtilizationMGTVO .class);
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
	 * Chassis Inventory. CGM CHASSIS DAILY INVENTORY 엔터티에서 해당 기간동안 Daily 기준 장비 수량을 조회한다. [EES_CGM_1113]<br>
	 * 
	 * @param cHSHistoricalRptINVO CHSHistoricalRptINVO 
	 * @return  List<CHSHistoricalRptMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSHistoricalRptMGTVO> searchCHSHistoricalReportByInvtData   (CHSHistoricalRptINVO cHSHistoricalRptINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSHistoricalRptMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(cHSHistoricalRptINVO != null){
				Map<String, String> mapVO = cHSHistoricalRptINVO.getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInventoryDBDAOsearchCHSHistoricalReportByInvtDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSHistoricalRptMGTVO .class);
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
	 * Container Status.   CGM CHASSIS MOVEMENT DAILY INVENTORY 엔터티에서 해당 기간동안 옵션의 Container status 조건에 맞는 Container status 합산 수량을 보여준다. [EES_CGM_1113]<br>
	 * 
	 * @param cHSHistoricalRptINVO CHSHistoricalRptINVO 
	 * @return  List<CHSHistoricalRptMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSHistoricalRptMGTVO> searchCHSHistoricalReportByCntrStsData   (CHSHistoricalRptINVO cHSHistoricalRptINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSHistoricalRptMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(cHSHistoricalRptINVO != null){
				Map<String, String> mapVO = cHSHistoricalRptINVO.getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInventoryDBDAOsearchCHSHistoricalReportByCntrStsDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSHistoricalRptMGTVO .class);
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
	 * 주석) Available Chassis. x-y 값.  (  x:  CGM CHASSIS DAILY INVENTORY 의 장비 수량,     y:  CGM CHASSIS MOVEMENT DAILY INVENTORY 의 Wheeled 샤시 수량 (사용중인 샤시). [EES_CGM_1113]<br>
	 * 
	 * @param cHSHistoricalRptINVO CHSHistoricalRptINVO 
	 * @return  List<CHSHistoricalRptMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSHistoricalRptMGTVO> searchCHSHistoricalReportByAvailChsData (CHSHistoricalRptINVO cHSHistoricalRptINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSHistoricalRptMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(cHSHistoricalRptINVO != null){
				Map<String, String> mapVO = cHSHistoricalRptINVO.getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInventoryDBDAOsearchCHSHistoricalReportByAvailChsDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSHistoricalRptMGTVO .class);
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
	 * Assigned Days.   Daily Chassis Inventory 의 합산 수량. [EES_CGM_1113]<br>
	 * 
	 * @param cHSHistoricalRptINVO CHSHistoricalRptINVO 
	 * @return  List<CHSHistoricalRptMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSHistoricalRptMGTVO> searchCHSHistoricalReportByAsgnDayData   (CHSHistoricalRptINVO cHSHistoricalRptINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSHistoricalRptMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(cHSHistoricalRptINVO != null){
				Map<String, String> mapVO = cHSHistoricalRptINVO.getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInventoryDBDAOsearchCHSHistoricalReportByAsgnDayDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSHistoricalRptMGTVO .class);
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
	 * Usage Days.    CGM CHASSIS MOVEMENT DAILY INVENTORY 의 Wheeled 샤시 수량 (사용중인 샤시). [EES_CGM_1113]<br>
	 * 
	 * @param cHSHistoricalRptINVO CHSHistoricalRptINVO 
	 * @return  List<CHSHistoricalRptMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSHistoricalRptMGTVO> searchCHSHistoricalReportByUsageDayData  (CHSHistoricalRptINVO cHSHistoricalRptINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSHistoricalRptMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(cHSHistoricalRptINVO != null){
				Map<String, String> mapVO = cHSHistoricalRptINVO.getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInventoryDBDAOsearchCHSHistoricalReportByUsageDayDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSHistoricalRptMGTVO .class);
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
	 * Utilization(%).    x/y*100 값.  (  x:  CGM CHASSIS DAILY INVENTORY 의 장비 수량 ,     y:  CGM CHASSIS MOVEMENT DAILY INVENTORY 의 Wheeled 샤시 수량 (사용중인 샤시) ). [EES_CGM_1113]<br>
	 * 
	 * @param cHSHistoricalRptINVO CHSHistoricalRptINVO 
	 * @return  List<CHSHistoricalRptMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSHistoricalRptMGTVO> searchCHSHistoricalReportByUtilizationData   (CHSHistoricalRptINVO cHSHistoricalRptINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSHistoricalRptMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(cHSHistoricalRptINVO != null){
				Map<String, String> mapVO = cHSHistoricalRptINVO.getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInventoryDBDAOsearchCHSHistoricalReportByUtilizationDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSHistoricalRptMGTVO .class);
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
	 * CGM ESP ADJUST 테이블로부터 SCC 별 ADJUST 정보를 조회한다. [EES_CGM_1114]<br>
	 * 
	 * @param sHSEspFactorINVO CHSEspFactorINVO 
	 * @return  List<CHSEspFactorMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<CHSEspFactorMGTVO> searchCHSEspAdjustData (CHSEspFactorINVO sHSEspFactorINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSEspFactorMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(sHSEspFactorINVO != null){
				Map<String, String> mapVO = sHSEspFactorINVO.getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInventoryDBDAOsearchCHSEspAdjustDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSEspFactorMGTVO .class);
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
	 * CGM ESP ADJUST  테이블 에 Inser 또는 Update 를 수행한다. [EES_CGM_1114].<br>
	 * 
	 * @param cHSEspFactorINVO CHSEspFactorINVO
	 * @exception SQLException
	 * @exception Exception
	 */
	public void addCHSEspAdjustData (CHSEspFactorINVO cHSEspFactorINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//int delCnt[] = null;
			if(cHSEspFactorINVO != null){
				Map<String, String> param = cHSEspFactorINVO.getColumnValues();
				int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInventoryDBDAOaddCHSEspAdjustDataCSQL() , param, null);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Delete SQL");
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
	 * CGM ESP ADJUST  테이블 에 Inser 또는 Update 를 수행한다. [EES_CGM_1114]<br>
	 * 
	 * @param cHSEspFactorINVO CHSEspFactorINVO
	 * @exception SQLException
	 * @exception Exception
	 */
	public void modifyCHSEspAdjustData (CHSEspFactorINVO cHSEspFactorINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//int delCnt[] = null;
			if(cHSEspFactorINVO != null){
				Map<String, String> param = cHSEspFactorINVO.getColumnValues();
			
				int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetInventoryDBDAOmodifyCHSEspAdjustDataUSQL() , param, null);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Delete SQL");
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
	 * 1. Container BOX (Thorughput) 계산 2. Turn Time 계산 3. Domestic Booking 카운트하여 Container BOX (Throughput) 계산 4. ESP Adjust 에서 입력된 변수를 조회. [EES_CGM_1115].<br>
	 * 
	 * @param cHSEspReportINVO CHSEspReportINVO 
	 * @return  List<CHSEspReportMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */	
	@SuppressWarnings("unchecked")
	public List<CHSEspReportMGTVO> searchCHSEspReportData(CHSEspReportINVO cHSEspReportINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSEspReportMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(cHSEspReportINVO != null){
				Map<String, String> mapVO = cHSEspReportINVO.getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInventoryDBDAOsearchCHSEspReportDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSEspReportMGTVO .class);
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
	 * 1. Container BOX (Thorughput) 계산 2. Turn Time 계산 3. Domestic Booking 카운트하여 Container BOX (Throughput) 계산 4. ESP Adjust 에서 입력된 변수를 조회(BackEndJob결과). [EES_CGM_1115].<br>
	 * 
	 * @param key String 
	 * @return  List<CHSUtilFactorMGTVO>
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CHSEspReportMGTVO> searchCHSEspReportDataFile(String key) throws DAOException {
		try {
			return (List<CHSEspReportMGTVO>) BackEndJobResult.loadFromFile(key);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	

	/**
	 *  조회 조건에 설정한 항목별로  TP/SZ 카운트를 GROUP BY 조회. [EES_CGM_2076]<br>
	 * 
	 * @param mGSInventoryGeneralINVO MGSInventoryGeneralINVO  
	 * @return List<MGSInventoryGeneralMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<MGSInventoryGeneralMGTVO> searchMGSInventoryGeneralData(MGSInventoryGeneralINVO mGSInventoryGeneralINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSInventoryGeneralMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(mGSInventoryGeneralINVO != null){
				Map<String, String> mapVO = mGSInventoryGeneralINVO .getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInventoryDBDAOsearchMGSInventoryGeneralDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MGSInventoryGeneralMGTVO .class);
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
	 * [EES_CGM_2075]<br>
	 * 
	 * @param mGSInventoryDetailINVO MGSInventoryDetailINVO
	 * @return List<MGSInventoryDetailMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<MGSInventoryDetailMGTVO> searchMGSInventoryDetailData(MGSInventoryDetailINVO mGSInventoryDetailINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSInventoryDetailMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(mGSInventoryDetailINVO != null){
				Map<String, String> mapVO = mGSInventoryDetailINVO.getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInventoryDBDAOsearchMGSInventoryDetailDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MGSInventoryDetailMGTVO .class);
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
	 *  조회 조건에 설정한 항목별로  TP/SZ 카운트를 GROUP BY 조회. [EES_CGM_2077]<br>
	 * 
	 * @param mGSInventoryByLessorAgmtINVO MGSInventoryByLessorAgmtINVO  
	 * @return List<MGSInventoryByLessorAgmtMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<MGSInventoryByLessorAgmtMGTVO> searchMGSInventoryByLessorAgmtData (MGSInventoryByLessorAgmtINVO mGSInventoryByLessorAgmtINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSInventoryByLessorAgmtMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(mGSInventoryByLessorAgmtINVO != null){
				Map<String, String> mapVO = mGSInventoryByLessorAgmtINVO .getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInventoryDBDAOsearchMGSInventoryByLessorAgmtDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MGSInventoryByLessorAgmtMGTVO .class);
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
	 * 조회 조건에 설정한 항목별로  TP/SZ 카운트 리스트 조회. [EES_CGM_2077]<br>
	 * 
	 * @param mgsInventoryDtlINVO MGSInventoryDtlINVO
	 * @return List<MGSInventoryDtlMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<MGSInventoryDtlMGTVO> searchMGSInventoryByLessorAgmtListData(MGSInventoryDtlINVO mgsInventoryDtlINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSInventoryDtlMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try{
			if(mgsInventoryDtlINVO != null){
				Map<String, String> mapVO = mgsInventoryDtlINVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInventoryDBDAOsearchMGSInventoryByLessorAgmtListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MGSInventoryDtlMGTVO .class);
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
	 *  CGM_EQUIPMENT 엔티티를 group by 하여 Type (UMG/CLG) 별 Summary 합산. [EES_CGM_2078]<br>
	 * 
	 * @param mGSInventoryByLessorTermINVO MGSInventoryByLessorTermINVO  
	 * @return List<MGSInventoryByLessorTermMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<MGSInventoryByLessorTermMGTVO> searchMGSInventoryByLessorTermData (MGSInventoryByLessorTermINVO mGSInventoryByLessorTermINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSInventoryByLessorTermMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(mGSInventoryByLessorTermINVO != null){
				Map<String, String> mapVO = mGSInventoryByLessorTermINVO .getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInventoryDBDAOsearchMGSInventoryByLessorTermDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MGSInventoryByLessorTermMGTVO .class);
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
	 * CGM_EQUIPMENT 엔티티를 group by 하여 Type (UMG/CLG) 별 List. [EES_CGM_2078]<br>
	 * 
	 * @param mgsInventoryDtlINVO MGSInventoryDtlINVO
	 * @return List<MGSInventoryDtlMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<MGSInventoryDtlMGTVO> searchMGSInventoryByLessorTermListData(MGSInventoryDtlINVO mgsInventoryDtlINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSInventoryDtlMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try{
			if(mgsInventoryDtlINVO != null){
				Map<String, String> mapVO = mgsInventoryDtlINVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInventoryDBDAOsearchMGSInventoryByLessorTermListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MGSInventoryDtlMGTVO .class);
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
	 *  Creation Office , Period 항목으로 group by 하여 Type (UMG/CLG) 별 Summary 합산. [EES_CGM_2079]<br>
	 * 
	 * @param mGSInventoryByOfficeINVO MGSInventoryByOfficeINVO  
	 * @return List<MGSInventoryByOfficeMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<MGSInventoryByOfficeMGTVO> searchMGSInventoryByOfficeData (MGSInventoryByOfficeINVO mGSInventoryByOfficeINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSInventoryByOfficeMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(mGSInventoryByOfficeINVO != null){
				Map<String, String> mapVO = mGSInventoryByOfficeINVO .getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInventoryDBDAOsearchMGSInventoryByOfficeDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MGSInventoryByOfficeMGTVO .class);
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
	 * Creation Office , Period 항목으로 group by 하여 Type (UMG/CLG) 별 List. [EES_CGM_2079]<br>
	 * 
	 * @param mgsInventoryDtlINVO MGSInventoryDtlINVO
	 * @return List<MGSInventoryDtlMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<MGSInventoryDtlMGTVO> searchMGSInventoryByOfficeListData(MGSInventoryDtlINVO mgsInventoryDtlINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSInventoryDtlMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try{
			if(mgsInventoryDtlINVO != null){
				Map<String, String> mapVO = mgsInventoryDtlINVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInventoryDBDAOsearchMGSInventoryByOfficeListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MGSInventoryDtlMGTVO .class);
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
	 *  Location& Lessor별 Inventory를 산출. [EES_CGM_2080]<br>
	 * 
	 * @param mGSInventoryByLocationLessorINVO MGSInventoryByLocationLessorINVO  
	 * @return List<MGSInventoryByLocationLessorMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<MGSInventoryByLocationLessorMGTVO> searchMGSInventoryByLocationLessorData  (MGSInventoryByLocationLessorINVO mGSInventoryByLocationLessorINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSInventoryByLocationLessorMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(mGSInventoryByLocationLessorINVO != null){
				Map<String, String> mapVO = mGSInventoryByLocationLessorINVO .getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInventoryDBDAOsearchMGSInventoryByLocationLessorDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MGSInventoryByLocationLessorMGTVO .class);
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
	 * Location& Lessor별 Inventory를 List 산출. [EES_CGM_2080]<br>
	 * 
	 * @param mgsInventoryDtlINVO MGSInventoryDtlINVO
	 * @return List<MGSInventoryDtlMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<MGSInventoryDtlMGTVO> searchMGSInventoryByLocationLessorListData (MGSInventoryDtlINVO mgsInventoryDtlINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSInventoryDtlMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try{
			if(mgsInventoryDtlINVO != null){
				Map<String, String> mapVO = mgsInventoryDtlINVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInventoryDBDAOsearchMGSInventoryByLocationLessorListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MGSInventoryDtlMGTVO .class);
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
	 * Inventory를 List 산출. [EES_CGM_2020][EES_CGM_2012]<br>
	 * 
	 * @param mgsInventoryDtlINVO MGSInventoryDtlINVO
	 * @return List<MGSInventoryDtlMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<MGSInventoryDtlMGTVO> searchMGSInventoryByLostSummaryListData(MGSInventoryDtlINVO mgsInventoryDtlINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSInventoryDtlMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try{
			if(mgsInventoryDtlINVO != null){
				Map<String, String> mapVO = mgsInventoryDtlINVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInventoryDBDAOsearchMGSInventoryByLostSummaryListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MGSInventoryDtlMGTVO .class);
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
	 * Status Change 인벤토리 Back End Job 조회(summary). [EES_CGM_1102].<br>
	 * 
	 * @param key String 
	 * @return  List<CHSInventoryByVariationMGTVO>
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CHSInventoryByVariationMGTVO> searchCHSInventoryByVariationDataFile(String key) throws DAOException {
		try {
			return (List<CHSInventoryByVariationMGTVO>) BackEndJobResult.loadFromFile(key);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	

	/**
	 * Status Change 인벤토리 Back End Job 조회(detail). [EES_CGM_1103].<br>
	 * 
	 * @param key String 
	 * @return  List<CHSInventoryByVariationDtlMGTVO>
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CHSInventoryByVariationDtlMGTVO> searchCHSInventoryByVariationDtlDataFile(String key) throws DAOException {
		try {
			return (List<CHSInventoryByVariationDtlMGTVO>) BackEndJobResult.loadFromFile(key);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 연도별 자산 집계현황을 조회한다.<br>
	 * 
	 * @author J.H
	 * @category EES_CGM_1153
	 * @category searchCHSAssetsSmryListData  
	 *  
	 * @param CHSAssetsOptionVO chsAssetsOptionVO
	 * @return List<CHSAssetsSmryVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")	
	 public List<CHSAssetsSmryVO> searchCHSAssetsSmryListData(CHSAssetsOptionVO chsAssetsOptionVO) throws DAOException {			 						 
			DBRowSet dbRowset = null;
			List<CHSAssetsSmryVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(chsAssetsOptionVO != null){
					Map<String, String> mapVO = chsAssetsOptionVO.getColumnValues();
					
					String sTpsz = chsAssetsOptionVO.getCntrTpszCd();
					
					List<String> tpszCdList = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(sTpsz, ",");							
				
			        while (st.hasMoreTokens()) {
			        	tpszCdList.add(st.nextToken());
			        }
					velParam.put("vel_tpsz_cd", tpszCdList);		

					param.putAll(mapVO);
					velParam.putAll(mapVO);										        
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInventoryDBDAOSearchCHSAssetsSmryListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, AssetsSmryVO.class);
				
			}catch(SQLException se){
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
	 }	
	 
	 /**
		 * 연도별 자산 현황을 장비별로 상세 조회한다.<br>
		 * 
		 * @author J.H
		 * @category EES_CGM_1154
		 * @category searchCHSAssetsDetailListData 
		 * 
		 * @param CHSAssetsSmryVO chsAssetsSmryVO
		 * @return List<CHSAssetsDetailVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		 public List<CHSAssetsDetailVO> searchCHSAssetsDetailListData(CHSAssetsSmryVO chsAssetsSmryVO) throws DAOException {			 						 
				DBRowSet dbRowset = null;
				List<CHSAssetsDetailVO> list = null;
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();

				try{
					if(chsAssetsSmryVO != null){
						Map<String, String> mapVO = chsAssetsSmryVO.getColumnValues();
					
						String sTpsz = chsAssetsSmryVO.getCntrTpszCd();
						
						List<String> tpszCdList = new ArrayList<String>();
						StringTokenizer st = new StringTokenizer(sTpsz, ",");							
					
				        while (st.hasMoreTokens()) {
				        	tpszCdList.add(st.nextToken());
				        }
						velParam.put("vel_tpsz_cd", tpszCdList);		

						param.putAll(mapVO);
						velParam.putAll(mapVO);										        
					}

					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInventoryDBDAOSearchCHSAssetsDetailListRSQL(), param, velParam);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSAssetsDetailVO.class);
					
				}catch(SQLException se){
					throw new DAOException(new ErrorHandler(se).getMessage());
				}catch(Exception ex){
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}
				return list;
		 }


	/**
	 * 메인 그리드 데이터 조회한다.<br>
	 * 
	 * @param MGSBareMVMTDataVO mGSBareMVMTDataVO
	 * @return List<MGSBareMVMTDataVO>
	 * @throws DAOException
	*/			 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<MGSBareMVMTDataVO> searchBareMGSetData(MGSBareMVMTDataVO mGSBareMVMTDataVO)throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSBareMVMTDataVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mGSBareMVMTDataVO != null){
				Map<String, String> mapVO = mGSBareMVMTDataVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInventoryDBDAOSearchBareMGSetDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MGSBareMVMTDataVO.class);
			
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * MGSET No 조회한다.<br>
	 * 
	 * @param MGSBareMVMTDataVO mGSBareMVMTDataVO
	 * @return DBRowSet
	 * @throws DAOException
	*/		
	public DBRowSet searchBareMGSetNoData( MGSBareMVMTDataVO mGSBareMVMTDataVO)throws DAOException {
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mGSBareMVMTDataVO != null){
				Map<String, String> mapVO = mGSBareMVMTDataVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetInventoryDBDAOcheckBareMGSetDataRSQL(), param, velParam);
			
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * MGSET No 의 type 조회한다.<br>
	 * 
	 * @param MGSBareMVMTDataVO mGSBareMVMTDataVO
	 * @return DBRowSet
	 * @throws DAOException
	*/		
	public DBRowSet searchEqTpszCdData(	MGSBareMVMTDataVO mGSBareMVMTDataVO) throws DAOException{
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mGSBareMVMTDataVO != null){
				Map<String, String> mapVO = mGSBareMVMTDataVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetInventoryDBDAOsearchBareMGSetEqTypeDataRSQL(), param, velParam);
			
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * Container No 유효성 검사한다.<br>
	 * 
	 * @param MGSBareMVMTDataVO mGSBareMVMTDataVO
	 * @return DBRowSet
	 * @throws DAOException
	*/			
	public DBRowSet checkBareMGSetContNoData(MGSBareMVMTDataVO mGSBareMVMTDataVO)throws DAOException {
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mGSBareMVMTDataVO != null){
				Map<String, String> mapVO = mGSBareMVMTDataVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetInventoryDBDAOcheckBareMGSetContNoDataRSQL(), param, velParam);
			
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * MGSET CLG 타입의 MVMT, Staydays 조회한다.<br>
	 * 
	 * @param MGSBareMVMTDataVO mGSBareMVMTDataVO
	 * @return DBRowSet
	 * @throws DAOException
	*/			
	public DBRowSet searchBareMGSetCLGData(MGSBareMVMTDataVO mGSBareMVMTDataVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mGSBareMVMTDataVO != null){
				Map<String, String> mapVO = mGSBareMVMTDataVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetInventoryDBDAOsearchBareMGSetCLGDataRSQL(), param, velParam);
			
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * Chassis No 유효성 검사한다.<br>
	 * 
	 * @param MGSBareMVMTDataVO mGSBareMVMTDataVO
	 * @return DBRowSet
	 * @throws DAOException
	*/		
	public DBRowSet checkBareMGSetChsNoData(MGSBareMVMTDataVO mGSBareMVMTDataVO)throws DAOException {
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mGSBareMVMTDataVO != null){
				Map<String, String> mapVO = mGSBareMVMTDataVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetInventoryDBDAOcheckBareMGSetChsNoDataRSQL(), param, velParam);
			
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * MGSET UMG 타입의 MVMT, Staydays 조회한다.<br>
	 * 
	 * @param MGSBareMVMTDataVO mGSBareMVMTDataVO
	 * @return DBRowSet
	 * @throws DAOException
	*/			
	public DBRowSet searchBareMGSetUMGData(MGSBareMVMTDataVO mGSBareMVMTDataVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mGSBareMVMTDataVO != null){
				Map<String, String> mapVO = mGSBareMVMTDataVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetInventoryDBDAOsearchBareMGSetUMGDataRSQL(), param, velParam);
			
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * Bare M.G.Set Grid 의 데이터 입력 한다.<br>
	 * 
	 * @param List<MGSBareMVMTDataVO> insertVoList
	 * @throws DAOException
	*/			
	public void addBareMGSetData(List<MGSBareMVMTDataVO> insertVoList) throws DAOException,Exception {

		@SuppressWarnings("unused")
		int insCnt = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(insertVoList!=null && insertVoList.size()>0){
				for(int i =0;i < insertVoList.size();i++){
					Map<String, String> mapVO = insertVoList.get(i).getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ChassisMgsetInventoryDBDAOaddBareMGSetDataCSQL(), param, velParam);
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
	 * Bare M.G.Set Grid 의 데이터 수정 한다.<br>
	 * 
	 * @param List<MGSBareMVMTDataVO> updateVoList
	 * @throws DAOException
	*/	
	public void modifyCntDefaultCurrS(List<MGSBareMVMTDataVO> updateVoList) throws DAOException,Exception {
		try	{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updateVoList.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInventoryDBDAOmodifyBareMGSetDataUSQL(), updateVoList, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}		
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * GSET MASTER 정보 수정한다.<br>
	 * 
	 * @param List<MGSBareMVMTDataVO> updateVoList
	 * @throws DAOException
	*/	
	public void modifyCgmEquipmentMaster(List<MGSBareMVMTDataVO> updateVoList) throws DAOException,Exception {
		try	{
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			
			if(updateVoList.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInventoryDBDAOmodifyCgmEquipmentUSQL(), updateVoList, null);
				
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}		
		}catch (SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}	

	/**
	 * Bare M.G.Set Grid 의 데이터 삭제 한다.<br>
	 * 
	 * @param List<MGSBareMVMTDataVO> deleteVoList
	 * @throws DAOException
	*/	
	public void removeCntDefaultCurrS(List<MGSBareMVMTDataVO> deleteVoList) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(deleteVoList.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetInventoryDBDAOdeleteBareMGSetDataDSQL(), deleteVoList,null);
				for(int i = 0; i < 1; i++){
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



}
