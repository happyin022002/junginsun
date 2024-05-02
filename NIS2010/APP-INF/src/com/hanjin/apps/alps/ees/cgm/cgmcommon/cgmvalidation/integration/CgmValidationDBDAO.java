/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CgmValidationDBDAO.java
*@FileTitle : cgm_validation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.05.21 김창식
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.basic.CgmValidationBCImpl;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.AgrementINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.AgrementMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.CgmChssPoolINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.CgmChssPoolMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.ChsMasterMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.LocationMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.MdmCurrencyMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.MdmVendorMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.OfficeINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.OfficeMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.TpSzDupChkINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.TpSzDupChkMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.YardINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.vo.YardMGTVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS CgmValidationDBDAO <br>
 * - ALPS-CgmCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author KIM CHANG SIK
 * @see CgmValidationBCImpl 참조
 * @since J2EE 1.4
 */
public class CgmValidationDBDAO extends DBDAOSupport {

	/**
	 * 입력한 Office code 가 유효한지 체크 .  <br>
	 * 
	 * @param officeINVO OfficeINVO 
	 * @return List<OfficeMGTVO>
	 * @exception SQLException
	 * @exception Exception 
	 */
	 @SuppressWarnings("unchecked")
	public List<OfficeMGTVO> checkOfficeData(OfficeINVO officeINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OfficeMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(officeINVO != null){
				Map<String, String> mapVO = officeINVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            CgmValidationDBDAOCheckOfficeDataRSQL template = new CgmValidationDBDAOCheckOfficeDataRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OfficeMGTVO .class);
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
	}
	 
	/**
	 * 입력 yard code 가 valid 한지 체크 .  <br>
	 * 
	 * @param yardINVO YardINVO 
	 * @return List<OfficeMGTVO>
	 * @exception SQLException
	 * @exception Exception 
	 */
	 @SuppressWarnings("unchecked")
	public List<YardMGTVO> checkYardData(YardINVO yardINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<YardMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(yardINVO != null){
				Map<String, String> mapVO = yardINVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            CgmValidationDBDAOCheckYardDataRSQL template = new CgmValidationDBDAOCheckYardDataRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, YardMGTVO .class);
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
	}
	 
	/**
	 * 입력 Available yard code 가 valid 한지 체크 .  <br>
	 * 
	 * @param yardINVO YardINVO 
	 * @return List<OfficeMGTVO>
	 * @exception SQLException
	 * @exception Exception 
	 */
	 @SuppressWarnings("unchecked")
	public List<YardMGTVO> checkYardAvailableYardData(YardINVO yardINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<YardMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(yardINVO != null){
				Map<String, String> mapVO = yardINVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            CgmValidationDBDAOCheckAvailableYardDataRSQL template = new CgmValidationDBDAOCheckAvailableYardDataRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, YardMGTVO .class);
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
	}	 
	/**
	 * Agreement 가 등록되어있는지 체크한다 .  <br>
	 * 
	 * @param agrementINVO AgrementINVO 
	 * @return List<AgrementMGTVO>
	 * @exception SQLException
	 * @exception Exception 
	 */
	@SuppressWarnings("unchecked") 
	public List<AgrementMGTVO> checkAgreementData(AgrementINVO agrementINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgrementMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(agrementINVO != null){
				Map<String, String> mapVO = agrementINVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            CgmValidationDBDAOCheckAgreementDataRSQL template = new CgmValidationDBDAOCheckAgreementDataRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgrementMGTVO .class);
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
	}
		 
	/**
	 * CGM EQUIPMENT 테이블로부터  Chassis 마스터 정보를 조회한다.  <br>
	 * 
	 * @param chsMasterMGTVO ChsMasterMGTVO 
	 * @return List<ChsMasterMGTVO>
	 * @exception SQLException
	 * @exception Exception 
	 */
	 @SuppressWarnings("unchecked") 
	public List<ChsMasterMGTVO> searchCGMMasterData(ChsMasterMGTVO chsMasterMGTVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChsMasterMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(chsMasterMGTVO != null){
				Map<String, String> mapVO = chsMasterMGTVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            CgmValidationDBDAOsearchCGMMasterDataRSQL template = new CgmValidationDBDAOsearchCGMMasterDataRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChsMasterMGTVO .class);
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
	}
	 
		/**
		 * DM_VENDOR 테이블에서 Vendor 정보 조회한다.  <br>
		 * 
		 * @param mdmVendorMGTVO MdmVendorMGTVO 
		 * @return List<MdmVendorMGTVO>
		 * @exception SQLException
		 * @exception Exception 
		 */
		 @SuppressWarnings("unchecked") 
		public List<MdmVendorMGTVO> searchVendorListData(MdmVendorMGTVO mdmVendorMGTVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<MdmVendorMGTVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(mdmVendorMGTVO != null){
					Map<String, String> mapVO = mdmVendorMGTVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				} 
				
	            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
	            CgmValidationDBDAOsearchVendorListDataRSQL template = new CgmValidationDBDAOsearchVendorListDataRSQL();
				dbRowset = sqlExe.executeQuery(template, param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmVendorMGTVO .class);
			}catch(SQLException ex){
				//log.error(ex.getMessage(),ex);
				throw new DAOException(ex.getMessage(), ex);
			}catch(Exception ex){
				//log.error(ex.getMessage(),ex);
				throw new DAOException(ex.getMessage(), ex);
			}
			return list;
		}
		
	/**
	 * CGM_EQ_TP_SZ 테이블로부터  정보를 조회한다.  <br>
	 * 
	 * @param tpSzDupChkINVO TpSzDupChkINVO 
	 * @return List<TpSzDupChkMGTVO>
	 * @exception SQLException
	 * @exception Exception 
	 */
	 @SuppressWarnings("unchecked")
	public List<TpSzDupChkMGTVO> searchEqTpSzDupChkData(TpSzDupChkINVO tpSzDupChkINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TpSzDupChkMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(tpSzDupChkINVO != null){
				Map<String, String> mapVO = tpSzDupChkINVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
         SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
         CgmValidationDBDAOsearchEqTpSzDupChkDataRSQL template = new CgmValidationDBDAOsearchEqTpSzDupChkDataRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TpSzDupChkMGTVO .class);
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
	}
		
	/**
	 * MST_CONTAINER 정보를 조회한다 .  <br>
	 * 
	 * @param chsMasterMGTVO ChsMasterMGTVO 
	 * @return List<ChsMasterMGTVO>
	 * @exception SQLException
	 * @exception Exception 
	 */
	 @SuppressWarnings("unchecked") 
	public List<ChsMasterMGTVO> searchCNTRMasterData(ChsMasterMGTVO chsMasterMGTVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChsMasterMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(chsMasterMGTVO != null){
				Map<String, String> mapVO = chsMasterMGTVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            CgmValidationDBDAOsearchCNTRMasterDataRSQL template = new CgmValidationDBDAOsearchCNTRMasterDataRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChsMasterMGTVO .class);
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
	}

	/**
	 * Location Code가 유효한지 체크한다.  <br>
	 * 
	 * @param locationMGTVO LocationMGTVO 
	 * @return List<LocationMGTVO>
	 * @exception SQLException
	 * @exception Exception 
	 */
	@SuppressWarnings("unchecked")
	public List<LocationMGTVO> checkLocationData(LocationMGTVO locationMGTVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<LocationMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(locationMGTVO != null){
				Map<String, String> mapVO = locationMGTVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            CgmValidationDBDAOcheckLocationDataRSQL template = new CgmValidationDBDAOcheckLocationDataRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LocationMGTVO .class);
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * CGM_CHSS_POOL 테이블 정보를 조회한다 Retrieve. <br>
	 * 
	 * @param cgmChssPoolINVO CgmChssPoolINVO 
	 * @return List<CgmChssPoolMGTVO>
	 * @exception SQLException
	 * @exception Exception 
	 */
	@SuppressWarnings("unchecked")
	public List<CgmChssPoolMGTVO> searchChssPoolData(CgmChssPoolINVO cgmChssPoolINVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<CgmChssPoolMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cgmChssPoolINVO != null){
				Map<String, String> mapVO = cgmChssPoolINVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            CgmValidationDBDAOsearchChssPoolDataRSQL template = new CgmValidationDBDAOsearchChssPoolDataRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CgmChssPoolMGTVO .class);
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
		
	}
	
	
	/**
	 * MDM_CURRENCY 테이블 정보를 조회한다 Retrieve. <br>
	 * 
	 * @param mdmCurrencyMGTVO MdmCurrencyMGTVO 
	 * @return List<MdmCurrencyMGTVO>
	 * @exception SQLException
	 * @exception Exception 
	 */
	@SuppressWarnings("unchecked")
	public List<MdmCurrencyMGTVO> searchMDMCurrencyData(MdmCurrencyMGTVO mdmCurrencyMGTVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<MdmCurrencyMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mdmCurrencyMGTVO != null){
				Map<String, String> mapVO = mdmCurrencyMGTVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            CgmValidationDBDAOsearchMDMCurrencyDataRSQL template = new CgmValidationDBDAOsearchMDMCurrencyDataRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CgmChssPoolMGTVO .class);
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
		
	}
	
	/**
	 * Location Code가 유효한지 체크한다.  <br>
	 * 
	 * @param locationMGTVO LocationMGTVO 
	 * @return List<LocationMGTVO>
	 * @exception SQLException
	 * @exception Exception 
	 */
	@SuppressWarnings("unchecked")
	public List<LocationMGTVO> searchOfficeYardControlOfficeMatchData(LocationMGTVO locationMGTVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<LocationMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(locationMGTVO != null){
				Map<String, String> mapVO = locationMGTVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			} 
			
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            CgmValidationDBDAOsearchOfficeYardControlOfficeMatchDataRSQL template = new CgmValidationDBDAOsearchOfficeYardControlOfficeMatchDataRSQL();
			dbRowset = sqlExe.executeQuery(template, param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LocationMGTVO .class);
		}catch(SQLException ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * CGM 공통 조회 기능 <br>
	 * OFFICE CODE 의 AGMT NO 를 조회하여 CGM AGMT NO 를 리턴<br>
	 * 
	 * @param String agmt_no
	 * @param String ofc_cd
	 * @return String return_agmt_no
	 * @exception DAOException
	 */
	public String searchCgmAgmtNoData(String agmt_no, String ofc_cd) throws DAOException {
		DBRowSet dbRowset 	  = null;
		String return_agmt_no = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		

		try {			
			param.put("agmt_no",     agmt_no);
			param.put("ctrt_ofc_cd", ofc_cd);			
			velParam.put("ctrt_ofc_cd", ofc_cd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CgmValidationDBDAOsearchCgmAgmtNoDataRSQL(), param, velParam);
			
			while (dbRowset.next()){
				return_agmt_no = dbRowset.getString ("agmt_no");
				break;
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return return_agmt_no;
	}	
		
}
