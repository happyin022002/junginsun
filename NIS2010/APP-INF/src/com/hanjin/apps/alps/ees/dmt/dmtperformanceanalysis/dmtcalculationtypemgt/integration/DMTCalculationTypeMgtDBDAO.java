/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCalculationTypeMgtDBDAO.java
*@FileTitle : Tariff Type Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.05.13 황효근
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.basic.DMTCalculationTypeMgtBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.CalculationTypeParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.DmtOfcUsrTrfOptVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.DmtTrfTpVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * NIS2010 DMTCalculationTypeMgtDBDAO <br>
 * - NIS2010-DMTPerformanceAnalysis system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Hwang Hyo Keun
 * @see DMTCalculationTypeMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class DMTCalculationTypeMgtDBDAO extends DBDAOSupport {

	/**
	 * Tariff Type List 정보를 조회한다.
	 * 
	 * @param DmtTrfTpVO dmtTrfTpVO
	 * @return List<DmtTrfTpVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DmtTrfTpVO> searchTariffTypeList(DmtTrfTpVO dmtTrfTpVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DmtTrfTpVO> list = null;
		//query parameter
		//Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationTypeMgtDBDAODmtTariffTypeVORSQL(), null, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DmtTrfTpVO .class);
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
	 * Calculation Type List 정보를 조회한다.
	 * 
	 * @param CalculationTypeParmVO calculationTypeParmVO
	 * @return List<CalculationTypeParmVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CalculationTypeParmVO> searchCalculationTypeList(CalculationTypeParmVO calculationTypeParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CalculationTypeParmVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(calculationTypeParmVO != null){
				Map<String, String> mapVO = calculationTypeParmVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationTypeMgtDBDAOCalculationTypeParmVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CalculationTypeParmVO.class);
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
	 * User Tariff Type Setup 정보의 존재 여부를 조회한다.
	 * 
	 * @param DmtOfcUsrTrfOptVO dmtOfcUsrTrfOptVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchTariffTypeSetup(DmtOfcUsrTrfOptVO dmtOfcUsrTrfOptVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(dmtOfcUsrTrfOptVO != null){
				//Map<String, String> mapVO = dmtOfcUsrTrfOptVO.getColumnValues();
				//param.putAll(mapVO);
				//velParam.putAll(mapVO);
				param.put("ofc_cd", dmtOfcUsrTrfOptVO.getOfcCd());
				param.put("usr_id", dmtOfcUsrTrfOptVO.getUsrId());
			}
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DMTCalculationTypeMgtDBDAODmtOfcUsrTrfOptVORSQL(), param, null);
			
			String result = null;
			if(dbRowset.next()){
				result = dbRowset.getString("exist_yn");
			}
			return result;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
		 
	/**
	 * User Tariff Type Setup 정보를 추가한다.
	 * 
	 * @param DmtOfcUsrTrfOptVO dmtOfcUsrTrfOptVO
	 * @throws DAOException
	 */
	public void addTariffTypeSetup(DmtOfcUsrTrfOptVO dmtOfcUsrTrfOptVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = dmtOfcUsrTrfOptVO.getColumnValues();
			param.putAll(mapVO);
			//velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int result = sqlExe.executeUpdate((ISQLTemplate)new DMTCalculationTypeMgtDBDAODmtOfcUsrTrfOptVOCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
		 
	
	/**
	 * User Tariff Type Setup 정보를 수정한다.
	 * 
	 * @param DmtOfcUsrTrfOptVO dmtOfcUsrTrfOptVO
	 * @throws DAOException
	 */
	public void modifyTariffTypeSetup(DmtOfcUsrTrfOptVO dmtOfcUsrTrfOptVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = dmtOfcUsrTrfOptVO.getColumnValues();
			param.putAll(mapVO);
			//velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
			int result = sqlExe.executeUpdate((ISQLTemplate)new DMTCalculationTypeMgtDBDAODmtOfcUsrTrfOptVOUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
		 
}
