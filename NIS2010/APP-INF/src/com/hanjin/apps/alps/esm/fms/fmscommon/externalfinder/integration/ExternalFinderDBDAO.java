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
package com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.basic.ExternalFinderBCImpl;
import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.vo.SearchCarrierCodeListVO;
import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.vo.SearchCenterCodeVO;
import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.vo.SearchContractNoVO;
import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.vo.SearchFlagVO;
import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.vo.SearchLaneCodeListVO;
import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.vo.SearchMdmAccountCodeListVO;
import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.vo.SearchPaymenetOfficeCodeListVO;
import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.vo.SearchSplRgstNoVO;
import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.vo.SearchVesselVO;
import com.hanjin.apps.alps.esm.fms.fmscommonutil.BizComFmsUtil;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * NIS2010 ExternalfinderDAO <br>
 * - NIS2010-FMSCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Yoon-Tae, Jung
 * @see ExternalFinderBCImpl 참조
 * @since J2EE 1.5 
 */
public class ExternalFinderDBDAO extends DBDAOSupport {

	/**
	 * Vessel Code를 가져온다<br>
	 * 
	 * @param searchVesselVO SearchVesselVO
	 * @return List<SearchVesselVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	 
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
	 @SuppressWarnings("unchecked")
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
	 @SuppressWarnings("unchecked")
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
	 @SuppressWarnings("unchecked")
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
	 * Carrier Code를 가져온다<br>
	 * 
	 * @param carrNm String
	 * @return List<SearchCarrierCodeListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
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
	 @SuppressWarnings("unchecked")
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
	 * @return String
	 * @throws DAOException
	 */
	public String searchCheckEffectiveDate(String slpOfcCd, String effDt) throws DAOException {
		DBRowSet dbRowset = null;
		String result = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			
			param.put("eff_yrmon", effDt.substring(0,6));		//Effective Date
			param.put("slp_ofc_cd", slpOfcCd);					//Account Code
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExternalFinderDBDAOCheckEffectiveDateRSQL(), param, null);
			if(dbRowset.next()) {
				result = dbRowset.getString("eff_yrmon");
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
	 * Center Code를 조회한다.<br>
	 * 
	 * @param slpOfcCd String
	 * @return List<SearchCenterCodeVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
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
	 @SuppressWarnings("unchecked")
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
	 * 사업자 등록번호를 가져온다.<br>
	 * @param String splRgstNo
	 * @return List<SearchSplRgstNoVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchSplRgstNoVO> searchSplRgstNo(String splRgstNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSplRgstNoVO> searchSplRgstNoVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			param.put("rgst_no", splRgstNo);	
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExternalFinderDAOSearchSplRgstNoRSQL(), param, null);
			searchSplRgstNoVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSplRgstNoVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchSplRgstNoVO;
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
	 * Contract 존재하는 체크를 합니다 (Notice 에서 사용).<br>
	 * 
	 * @param String agmtNo
	 * @return String
	 * @throws DAOException
	 */
 	public String searchContractCtrtNtcInfo(String agmtNo) throws DAOException {
		DBRowSet dbRowset = null;
		String agmt_nm = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{			
			if (agmtNo != null) {
				param.put("agmt_no", agmtNo);
			    velParam.put("agmt_no", agmtNo);
			}					
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExternalFinderDBDAOSearchContractNtcInfoRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		agmt_nm = dbRowset.getString("AGMT_NO");
	    	}			
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return agmt_nm;
 	}
 	
 	/**
	 * Contract No Search <br>
	 * 
	 * @param vo SearchContractNoVO
	 * @return List<SearchContractNoVO>
	 * @throws DAOException
	 */
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
	 * Pay Term Search by Supplier <br>
	 * 
	 * @param String sValue
	 * @return String
	 * @throws DAOException
	 */
	public String searchPayTermByVndrSeq(String sValue) throws DAOException {
		DBRowSet dbRowset = null;
		String rsStr = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("s_value", sValue);
			velParam.putAll(param);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExternalFinderDBDAOSearchPayTermByVndrSeqRSQL(), param, velParam);
			
			if(dbRowset.next()){
				rsStr = dbRowset.getString("GEN_PAY_TERM_CD");
				rsStr = rsStr + ":" + dbRowset.getString("VNDR_LGL_ENG_NM");
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rsStr;
		
	}
	
	/**
	 * Rgst No Search by Supplier <br>
	 * 
	 * @param String sValue
	 * @return String
	 * @throws DAOException
	 */
	public String searchRgstNoByVndrSeq(String sValue) throws DAOException {
		DBRowSet dbRowset = null;
		String rsStr = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("s_value", sValue);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExternalFinderDBDAOSearchRgstNoByVndrSeqRSQL(), param, null);
			
			if(dbRowset.next()){
				rsStr = dbRowset.getString("rgst_no");
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rsStr;
		
	}
}
