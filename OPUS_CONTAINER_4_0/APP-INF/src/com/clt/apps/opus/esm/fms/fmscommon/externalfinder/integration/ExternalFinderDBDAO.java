/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExternalfinderDBDAO.java
*@FileTitle : Vessel Code
*Open Issues :
*Change history :
*@LastModifyDate : 2009.03.24
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.03.24 정윤태
* 1.0 Creation
* 2010.08.16 윤진영 CHM-201005318 searchMdmAccountCodeList
=========================================================*/
package com.clt.apps.opus.esm.fms.fmscommon.externalfinder.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.basic.ExternalFinderBCImpl;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.FmsCodeInfoVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.FmsCodeParamVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.FmsCommonVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.OtherCodeListVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchCarrierCodeListVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchCenterCodeVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchContractInfoVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchContractNoVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchDefaultDateVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchFlagVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchLaneCodeListVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchMdmAccountCodeListVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchPaymenetOfficeCodeListVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchVesselVO;
import com.clt.apps.opus.esm.fms.fmscommonutil.BizComFmsUtil;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS ExternalfinderDAO <br>
 * - OPUS-FMSCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Yoon-Tae, Jung
 * @see ExternalFinderBCImpl 참조
 * @since J2EE 1.5
 */
public class ExternalFinderDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Vessel Code를 가져온다<br>
	 * 
	 * @param searchVesselVO SearchVesselVO
	 * @return List<SearchVesselVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	 
	 public List<SearchVesselVO> searchVesselCodeList(SearchVesselVO searchVesselVO) throws DAOException {
		 
		 DBRowSet dbRowset = null;
		 
		 List<SearchVesselVO> searchVesselVOList = null;
		
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try {
			 if(searchVesselVO != null){
				 Map<String, String> mapVO = searchVesselVO.getColumnValues();
			
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExternalFinderDAOExternalFinderRSQL(), param, velParam);
			
			 searchVesselVOList = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchVesselVO.class);
			
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler("FMS01329",new String[]{}).getUserMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		
		 return searchVesselVOList;
	 }
	 
	/**
	 * Vessel Code 에 대한 Vessel Name 조회<br>
	 * 
	 * @param vslCd String
	 * @return List<SearchVesselVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	 public List<SearchVesselVO> searchVesselCodeName(String vslCd) throws DAOException {
		
		 DBRowSet dbRowset = null;
		 
		 List<SearchVesselVO> searchVesselVO = null;
		
		 try{
			 Map<String, Object> param = new HashMap<String, Object>();
			 param.put("vsl_cd", vslCd); 
			
			 dbRowset = new SQLExecuter().executeQuery(new ExternalFinderDAOSelectVesselNameRSQL(), param, null);
			 
			 searchVesselVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchVesselVO.class);
			 
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return searchVesselVO;
	 }
	 
	/**
	 * Location Code 에 대한 Location Name 조회<br>
	 * 
	 * @param locCd String
	 * @return String
	 * @throws DAOException
	 */
	 public String searchLocCdName(String locCd) throws DAOException {
		 
		 DBRowSet dbRowset = null;
		 String locNm = "";
		
		 try{
			 Map<String, Object> param = new HashMap<String, Object>();
			 param.put("loc_cd", locCd); 
			
			 dbRowset = new SQLExecuter().executeQuery(new ExternalFinderDBDAOSearchLocCdNameRSQL(), param, null);
			 if(dbRowset.next()) {
				 locNm = dbRowset.getString("loc_nm");
			 }
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return locNm;
	 }
	 
	/**
	 * Flag 코드에 해당하는 Name 정보 조회<br>
	 * 
	 * @param vslCntCd String
	 * @return String
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	 public String searchFlag(String vslCntCd) throws DAOException {
		 
		 String dbVslCntCd = "";
		 
		 DBRowSet dbRowset = null;
		 
		 List<SearchFlagVO> searchFlagVO = null;
		
		 try{
			 Map<String, Object> param = new HashMap<String, Object>();
			 param.put("cnt_cd", vslCntCd); 
			
			 dbRowset = new SQLExecuter().executeQuery(new ExternalFinderDAOSearchFlagRSQL(), param, null);
			 
			 searchFlagVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchFlagVO.class);
			 
			 dbVslCntCd = searchFlagVO.get(0).getCntNm();
			 
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return dbVslCntCd;
	 }

	/**
	 * Mdm Account Code를 가져온다<br>
	 * 
	 * @param acctCd String
	 * @param acctGb String
	 * @return List<SearchMdmAccountCodeListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchMdmAccountCodeListVO> searchMdmAccountCodeList(String acctCd,String acctGb) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMdmAccountCodeListVO> searchMdmAccountCodeListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{

			param.put("acct_cd", acctCd);
			velParam.put("acct_gb",acctGb);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExternalFinderDAOSearchMdmAccountCodeListVORSQL(), param, velParam);
			searchMdmAccountCodeListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMdmAccountCodeListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchMdmAccountCodeListVO;
	}

	/**
	 * Location Code를 가져온다<br>
	 * 
	 * @param locCd String
	 * @return String
	 * @throws DAOException
	 */
	public String searchCheckLocCode(String locCd) throws DAOException {
		DBRowSet dbRowset = null;
		String result = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			param.put("loc_cd", locCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExternalFinderDAOCheckLocCodeRSQL(), param, null);
			if(dbRowset.next()) {
				result = dbRowset.getString("dck_loc_cd");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * Lane Code를 가져온다<br>
	 * 
	 * @param laneCd String
	 * @return String
	 * @throws DAOException
	 */
	public String searchCheckLaneCode(String laneCd) throws DAOException {
		DBRowSet dbRowset = null;
		String result = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			
			param.put("lane_cd", laneCd);					//Account Code
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExternalFinderDAOCheckLaneCodeRSQL(), param, velParam);
			if(dbRowset.next()) {
				result = dbRowset.getString("vsl_slan_cd");
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * Mdm Vvd를 가져온다<br>
	 * 
	 * @param vvdCd String
	 * @return String
	 * @throws DAOException
	 */
	public String searchCheckMdmVvdCode(String vvdCd) throws DAOException {
		DBRowSet dbRowset = null;
		String result = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			param.put("vvd_cd", vvdCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExternalFinderDBDAOArMstRevVvdRSQL(), param, null);
			if(dbRowset.next()) {
				result = dbRowset.getString("CHK_VVD");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * Carrier Code를 가져온다<br>
	 * 
	 * @param carrNm String
	 * @return List<SearchCarrierCodeListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchCarrierCodeListVO> searchCarrierCodeList(String carrNm) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCarrierCodeListVO> searchCarrierCodeListVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			param.put("crr_full_nm", carrNm.toUpperCase());
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExternalFinderDBDAOSearchCarrierCodeListVORSQL(), param, null);
			searchCarrierCodeListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCarrierCodeListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchCarrierCodeListVO;
	}

	/**
	 * Lane Code를 조회한다<br>
	 * 
	 * @param searchLaneCodeListVO SearchLaneCodeListVO
	 * @return List<SearchLaneCodeListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchLaneCodeListVO> searchLaneCodeList(SearchLaneCodeListVO searchLaneCodeListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchLaneCodeListVO> resultLaneCodeListVO = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();

		 try {
			 if(searchLaneCodeListVO != null){
				 Map<String, String> mapVO = searchLaneCodeListVO.getColumnValues();
			
				 param.putAll(mapVO);
			 
				 //velocity parameter
				 Map<String, Object> velParam = new HashMap<String, Object>();
				 velParam.put("vsl_svc_tp_cd", searchLaneCodeListVO.getVslSvcTpCd());
			
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExternalFinderDBDAOSearchLaneCodeListVORSQL(), param, velParam);
				 resultLaneCodeListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchLaneCodeListVO .class);
			 }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return resultLaneCodeListVO;
	}

	/**
	 * RevenueLaneCode를 조회한다<br>
	 * 
	 * @param laneCd String
	 * @return String
	 * @throws DAOException
	 */
	public String searchCheckRevenueLaneCode(String laneCd) throws DAOException {
		DBRowSet dbRowset = null;
		String result = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			
			param.put("rlane_cd", laneCd);					//Account Code
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExternalFinderDBDAOCheckRevenueLaneCodeRSQL(), param, null);
			if(dbRowset.next()) {
				result = dbRowset.getString("rlane_cd");
			}
	
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * Carrier Code를 조회한다.<br>
	 * 
	 * @param crrCd String
	 * @return String
	 * @throws DAOException
	 */
	public String searchCheckCarrierCode(String crrCd) throws DAOException {
		DBRowSet dbRowset = null;
		String dbCrrCd = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			
			param.put("crr_cd", crrCd);					//Account Code
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExternalFinderDBDAOSearchCheckCarrierCodeRSQL(), param, null);
			if(dbRowset.next()) {
				dbCrrCd = dbRowset.getString("crr_cd");
			}
	
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbCrrCd;
	}
	/**
	 * 회계일자 검사한다.<br>
	 * 
	 * @param slpOfcCd String
	 * @param effDt String
	 * @param csrType String
	 * @return SearchDefaultDateVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SearchDefaultDateVO searchCheckEffectiveDate(String slpOfcCd, String effDt, String csrType) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchDefaultDateVO> list = null;
		SearchDefaultDateVO searchDefaultDateVO = new SearchDefaultDateVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			
			param.put("eff_yrmon", effDt);		//Effective Date
			param.put("slp_ofc_cd", slpOfcCd);					//Account Code
			param.put("csr_type", csrType);					//CSR Type (AP/AR)
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExternalFinderDBDAOCheckEffectiveDateRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchDefaultDateVO.class);

			if (list.isEmpty()) {
				searchDefaultDateVO.setVvdCxlFlg("E");
			} else {
				searchDefaultDateVO = list.get(0);
			}
	
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchDefaultDateVO;
	}
	
	/**
	 * Center Code를 조회한다.<br>
	 * 
	 * @param slpOfcCd String
	 * @return List<SearchCenterCodeVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchCenterCodeVO> searchCenterCode(String slpOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCenterCodeVO> searchCenterCodeVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			
			param.put("ofc_cd", slpOfcCd);					//Account Code
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExternalFinderDAOSearchCenterCodeRSQL(), param, null);
			searchCenterCodeVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCenterCodeVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchCenterCodeVO;
	}
	 
	/**
	 * Payment Office Code를 조회한다.<br>
	 * 
	 * @return List<SearchPaymenetOfficeCodeListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchPaymenetOfficeCodeListVO> searchPaymenetOfficeCodeList() throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchPaymenetOfficeCodeListVO> searchPaymenetOfficeCodeListVO = null;
	
		try{
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExternalFinderDAOSearchPaymenetOfficeCodeListRSQL(), null, null);
			searchPaymenetOfficeCodeListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchPaymenetOfficeCodeListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchPaymenetOfficeCodeListVO;
	}	 
 
	/**
	 * 환율을 가져온다<br>
	 * 
	 * @param acctXchRtYrmon String
	 * @return String
	 * @throws DAOException
	 */
	public String searchExchangeRate(String acctXchRtYrmon) throws DAOException {
		DBRowSet dbRowset = null;
		String result = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			
			param.put("acct_xch_rt_yrmon", acctXchRtYrmon);		//Effective Date
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExternalFinderDBDAOSearchExchangeRateRSQL(), param, null);
			if(dbRowset.next()) {
				result = dbRowset.getString("usd_locl_xch_rt");
			}
	
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * 항차 레벨을 가져온다.<br>
	 * 
	 * @param acctCd String
	 * @param vvdCd String
	 * @return String
	 * @throws DAOException
	 */
	public String searchCheckAcctCdVvdLevel(String acctCd, String vvdCd) throws DAOException {
		DBRowSet dbRowset = null;
		String result = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			param.put("vvd_cd", vvdCd);
			param.put("acct_cd", acctCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExternalFinderDBDAOSearchCheckAcctCdVvdLevelRSQL(), param, null);
			if(dbRowset.next()) {
				result = dbRowset.getString("vsl_cd");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * Retrieve Other Code List <br>
	 * 
	 * @param  String codeTp
	 * @return List<OtherCodeListVO>
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<OtherCodeListVO> searchOtherCodeList(String codeTp) throws DAOException {
		DBRowSet dbRowset = null;
		List<OtherCodeListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("code_tp", codeTp);
			velParam.put("code_tp", codeTp);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExternalFinderDAOSearchOtherCodeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OtherCodeListVO.class);
			return list;
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}

	/**
	 * Insert Other Code  <br>
	 * 
	 * @param otherCodeListVO List<OtherCodeListVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addOtherCode(List<OtherCodeListVO> otherCodeListVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(otherCodeListVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ExternalFinderDAOAddOtherCodeCSQL(), otherCodeListVO,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * Update Other Code  <br>
	 * 
	 * @param otherCodeListVO List<OtherCodeListVO>
	 * @throws DAOException
	 */
	public void modifyOtherCode(List<OtherCodeListVO> otherCodeListVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(otherCodeListVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ExternalFinderDAOUpdateOtherCodeUSQL(), otherCodeListVO,null);
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
	 * Delete Other Code  <br>
	 * 
	 * @param otherCodeListVO List<OtherCodeListVO>
	 * @throws DAOException
	 */
	public void removeOtherCode(List<OtherCodeListVO> otherCodeListVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(otherCodeListVO.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ExternalFinderDAORemoveOtherCodeDSQL(), otherCodeListVO,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
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
	 * Default Eff Date <br>
	 * 
	 * @param vo SearchDefaultDateVO
	 * @return List<SearchDefaultDateVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchDefaultDateVO> searchDefaultDateInfo(SearchDefaultDateVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchDefaultDateVO> voList = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExternalFinderDAOSearchDefaultDateInfoRSQL(), param, velParam);
			voList = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchDefaultDateVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return voList;
		
	}
	
	/**
	 * Default Eff Date <br>
	 * 
	 * @param vo SearchContractNoVO
	 * @return List<SearchContractNoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchContractNoVO> searchContractNoInfo(SearchContractNoVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchContractNoVO> voList = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String strTypeFlag = vo.getTypeFlag();
				
				velParam.put("type_flag", (strTypeFlag == null || strTypeFlag.equals("") || strTypeFlag.equals("null")) ? "" : strTypeFlag);
				List<String> listTypeFlag = new ArrayList<String>();
				
				if(strTypeFlag != null && !strTypeFlag.equals("")) {
					listTypeFlag = BizComFmsUtil.getSeperationParameter(strTypeFlag, "|");
				}
				
				velParam.put("list_type_flag", listTypeFlag.iterator());
				
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExternalFinderDBDAOSearchContractNoVORSQL(), param, velParam);
			voList = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchContractNoVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return voList;
		
	}

	/**
	 * FMS Contract Info Search. <br>
	 * 
	 * @param vo SearchContractInfoVO
	 * @return List<SearchContractInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchContractInfoVO> searchContractInfo(SearchContractInfoVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchContractInfoVO> voList = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExternalFinderDBDAOSearchContractInfoVORSQL(), param, velParam);
			voList = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchContractInfoVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return voList;
		
	}

	/**
	 * Search FMS Vendor By Contract no.<br>
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchContractInfoVO> searchVendorByContractNo(SearchContractInfoVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchContractInfoVO> voList = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExternalFinderDBDAOSearchVendorInfoByContractNoRSQL(), param, velParam);
			voList = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchContractInfoVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return voList;
		
	}

	/**
	 * Search Custmer By Vendor.<br>
	 * @param vo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchContractInfoVO> searchCustomerListByVendor(SearchContractInfoVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchContractInfoVO> voList = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExternalFinderDBDAOSearchCustomerListByVendorRSQL(), param, velParam);
			voList = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchContractInfoVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return voList;
		
	}

	/**
	 * Common Tax Type 조회
	 * @param FmsCodeParamVO fmsCodeParamVO
	 * @return List<FmsCodeInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<FmsCodeInfoVO> searchTaxTypeList(FmsCodeParamVO fmsCodeParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FmsCodeInfoVO>  codeList = new ArrayList();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (fmsCodeParamVO != null) {
				 Map<String, String> mapVO = fmsCodeParamVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ExternalFinderDAOTaxTypeRSQL(),	param, velParam);
			codeList = (List) RowSetUtil.rowSetToVOs(dbRowset, FmsCodeInfoVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return codeList;
	}
	
	/**
	 * TI/TO 공통에 땨란 VVD 조회.<br>
	 * 
	 * @param FmsCommonVO fmsCommonVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchFmsVvdByFletCtrtNo(FmsCommonVO fmsCommonVO) throws DAOException {
		DBRowSet dbRowset = null;
		String  result = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if (fmsCommonVO != null) {
				 Map<String, String> mapVO = fmsCommonVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExternalFinderDBDAOSearchFmsVvdByFletCtrtNoRSQL(), param, null);
			if(dbRowset.next()) {
				result = dbRowset.getString("VVD_CD");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * AR_FIN_DIR_CONV 에 존재 여부.<br>
	 * 
	 * @param FmsCommonVO fmsCommonVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchArFincDirConvUsedFlag(FmsCommonVO fmsCommonVO) throws DAOException {
		DBRowSet dbRowset = null;
		String  result = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if (fmsCommonVO != null) {
				 Map<String, String> mapVO = fmsCommonVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExternalFinderDBDAOCheckArFincDirConvUsedFlagRSQL(), param, velParam);
			if(dbRowset.next()) {
				result = dbRowset.getString("USED_YN");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * Service Lane direction 에 조회.<br>
	 * 
	 * @param FmsCommonVO fmsCommonVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchServiceLaneDirection(FmsCommonVO fmsCommonVO) throws DAOException {
		DBRowSet dbRowset = null;
		String  result = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if (fmsCommonVO != null) {
				 Map<String, String> mapVO = fmsCommonVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExternalFinderDBDAOSearchServiceLaneDirectionRSQL(), param, velParam);
			if(dbRowset.next()) {
				result = dbRowset.getString("SLAN_DIR_CD");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * Fin direction 에 조회.<br>
	 * 
	 * @param FmsCommonVO fmsCommonVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchFinDirection(FmsCommonVO fmsCommonVO) throws DAOException {
		DBRowSet dbRowset = null;
		String  result = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if (fmsCommonVO != null) {
				 Map<String, String> mapVO = fmsCommonVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExternalFinderDBDAOSearchFinDirectionRSQL(), param, velParam);
			if(dbRowset.next()) {
				result = dbRowset.getString("RLANE_DIR_CD");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

}
