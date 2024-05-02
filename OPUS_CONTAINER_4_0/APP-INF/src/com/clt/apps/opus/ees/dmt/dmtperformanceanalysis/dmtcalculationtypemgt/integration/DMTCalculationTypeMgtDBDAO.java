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
package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.basic.DMTCalculationTypeMgtBCImpl;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.CalculationTypeParmVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.DmtCmbSetVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.DmtOfcUsrTrfOptVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.DmtSkpLocVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.DmtTrfTpVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.WeekendVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * DMTCalculationTypeMgtDBDAO <br>
 * - DMTPerformanceAnalysis system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DMTCalculationTypeMgtDBDAODmtTariffTypeVORSQL(), null, null);
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DMTCalculationTypeMgtDBDAOCalculationTypeParmVORSQL(), param, velParam);
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DMTCalculationTypeMgtDBDAODmtOfcUsrTrfOptVORSQL(), param, null);
			
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
	 * weekend 정보를 수정한다.
	 * 
	 * @param weekendVO WeekendVO
	 * @return List<WeekendVO>
	 * @throws DAOException
	 */
	public List<WeekendVO> searchWeekendList(WeekendVO weekendVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<WeekendVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(weekendVO != null){
				Map<String, String> mapVO = weekendVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DMTCalculationTypeMgtDBDAODmtWeekendListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, WeekendVO.class);
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
	 * Add Weekend. <br>
	 * 
	 * @param List<WeekendVO> weekendVOs
	 * @exception DAOException
	 */
	public void addWeekend(List<WeekendVO> weekendVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (weekendVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new DMTCalculationTypeMgtDBDAODmtWeekendVOCSQL(), weekendVOs, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Dual Type Exception을 수정 합니다. <br>
	 * 
	 * @param List<WeekendVO> weekendVOs
	 * @exception DAOException
	 */
	public void modifyWeekend(List<WeekendVO> weekendVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (weekendVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new DMTCalculationTypeMgtDBDAODmtWeekendVOUSQL(), weekendVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Dual Type Exception을 삭제 합니다. <br>
	 * 
	 * @param List<WeekendVO> weekendVOs
	 * @exception DAOException
	 */
	public void removeWeekend(List<WeekendVO> weekendVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(weekendVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new DMTCalculationTypeMgtDBDAODmtWeekendVODSQL(), weekendVOs, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED)
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
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
	
	/**
	 * Calculation Type Entry을 생성 합니다. <br>
	 * 
	 * @param List<CalculationTypeParmVO> calculationTypeParmVOs
	 * @exception DAOException
	 */
	public void addCalculationTypeEntry(List<CalculationTypeParmVO> calculationTypeParmVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (calculationTypeParmVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new DMTCalculationTypeMgtDBDAOCalculationTypeParmVOCSQL(), calculationTypeParmVOs, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Calculation Type Entry을 수정 합니다. <br>
	 * 
	 * @param List<CalculationTypeParmVO> calculationTypeParmVOs
	 * @exception DAOException
	 */
	public void modifyCalculationTypeEntry(List<CalculationTypeParmVO> calculationTypeParmVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (calculationTypeParmVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new DMTCalculationTypeMgtDBDAOCalculationTypeParmVOUSQL(), calculationTypeParmVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Calculation Type Entry을 삭제 합니다. <br>
	 * 
	 * @param List<CalculationTypeParmVO> calculationTypeParmVOs
	 * @exception DAOException
	 */
	public void removeCalculationTypeEntry(List<CalculationTypeParmVO> calculationTypeParmVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(calculationTypeParmVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new DMTCalculationTypeMgtDBDAOCalculationTypeParmVODSQL(), calculationTypeParmVOs, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED)
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
	 * 등록할 Calculation Type Entry 기등록된 것인지 조회 합니다.<br>
	 * 
	 * @param CalculationTypeParmVO calculationTypeParmVO
	 * @return CalculationTypeParmVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public CalculationTypeParmVO checkDuplicateCalculationTypeEntry(CalculationTypeParmVO calculationTypeParmVO) throws DAOException {
		List<CalculationTypeParmVO> list = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(calculationTypeParmVO != null){
				Map<String, String> mapVO = calculationTypeParmVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
					new DMTCalculationTypeMgtDBDAOCheckDuplicateCalculationTypeEntryVORSQL(), param, velParam);

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CalculationTypeParmVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	 /**
	 * Retrieving Combination Set Information
	 * 
	 * @return List<DmtCmbSetVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DmtCmbSetVO> searchCombinationSet() throws DAOException {
		DBRowSet dbRowset = null;
		List<DmtCmbSetVO> list = null;

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DMTCalculationTypeMgtDBDAOSearchCombinationSetRSQL(), null, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DmtCmbSetVO.class);
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
	 * Adding Combination Set Information
	 * 
	 * @param List<DmtCmbSetVO> dmtCmbSetVOs
	 * @exception DAOException
	 */
	public void addCombinationSet(List<DmtCmbSetVO> dmtCmbSetVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (dmtCmbSetVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new DMTCalculationTypeMgtDBDAOAddCombinationSetCSQL(), dmtCmbSetVOs, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Deleting Combination Set Information
	 * 
	 * @param List<DmtCmbSetVO> dmtCmbSetVOs
	 * @exception DAOException
	 */
	public void deleteCombinationSet(List<DmtCmbSetVO> dmtCmbSetVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (dmtCmbSetVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new DMTCalculationTypeMgtDBDAORemoveCombinationSetDSQL(), dmtCmbSetVOs, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
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
	 * Retrieving Skip Location Set Information
	 * 
	 * @return List<DmtSkpLocVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DmtSkpLocVO> searchSkipLocation() throws DAOException {
		DBRowSet dbRowset = null;
		List<DmtSkpLocVO> list = null;
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DMTCalculationTypeMgtDBDAOSearchSkipLocationRSQL(), null, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DmtSkpLocVO.class);
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
	 * Adding Skip Location Set Information
	 * 
	 * @param List<DmtSkpLocVO> dmtSkpLocVOs
	 * @exception DAOException
	 */
	public void addSkipLocation(List<DmtSkpLocVO> dmtSkpLocVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (dmtSkpLocVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new DMTCalculationTypeMgtDBDAOAddSkipLocationCSQL(), dmtSkpLocVOs, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Deleting Skip Location Set Information
	 * 
	 * @param List<DmtSkpLocVO> dmtSkpLocVOs
	 * @exception DAOException
	 */
	public void deleteSkipLocation(List<DmtSkpLocVO> dmtSkpLocVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (dmtSkpLocVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new DMTCalculationTypeMgtDBDAORemoveSkipLocationDSQL(), dmtSkpLocVOs, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
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
	 * Adding Tariff Type Information<br>
	 * 
	 * @param List<DmtTrfTpVO> dmtTrfTpVOs
	 * @exception DAOException
	 */
	public void addTariffType(List<DmtTrfTpVO> dmtTrfTpVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (dmtTrfTpVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new DMTCalculationTypeMgtDBDAOAddTariffTypeCSQL(), dmtTrfTpVOs, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Modifying Tariff Type Information<br>
	 * 
	 * @param List<DmtTrfTpVO> dmtTrfTpVOs
	 * @exception DAOException
	 */
	public void modifyTariffType(List<DmtTrfTpVO> dmtTrfTpVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (dmtTrfTpVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new DMTCalculationTypeMgtDBDAOModifyTariffTypeUSQL(), dmtTrfTpVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Deleting Tariff Type Information<br>
	 * 
	 * @param List<DmtTrfTpVO> dmtTrfTpVOs
	 * @exception DAOException
	 */
	public void deleteTariffType(List<DmtTrfTpVO> dmtTrfTpVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (dmtTrfTpVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new DMTCalculationTypeMgtDBDAORemoveTariffTypeDSQL(), dmtTrfTpVOs, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
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
