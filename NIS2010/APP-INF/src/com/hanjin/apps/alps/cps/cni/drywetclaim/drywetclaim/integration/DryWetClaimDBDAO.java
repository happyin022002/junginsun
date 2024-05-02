/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DryWetClaimDBDAO.java
*@FileTitle : DW Claim Main
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.10.12 윤세영
* 1.0 Creation
* ------------------------------------------------------------------------------- 
* Histroy
* 2011.08.08 이준범[CHM-201112635-01]
* 제목 : Dry Wet Claim 등록 시 알림 Mail Auto 발송 요청
* 내용 : DW Claim Main 에서 최초 등록하여 Case No가 부여 될 때, 자동으로 Auto-Notice(Web Mail) 되도록 보완)
=========================================================*/
package com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.HandlerHistoryVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.ManagerHistoryVO;
import com.hanjin.apps.alps.cps.cni.common.CniConst;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.integration.ClaimMainDBDAOAddTransferCSQL;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.integration.ClaimMainDBDAORemoveTransferDSQL;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmTrnsVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.basic.DryWetClaimBCImpl;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.CondSearchStatusListVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.CustomDryWetClaimVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.CustomHandlingCostVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.SearchAgentVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.SearchDryWetClaimCodeListVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.SearchDryWetClaimVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.SearchHandlingCostListVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.SearchHandlingCostVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.SearchRoeListVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.SearchStatusListVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.SearchVesselListVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.SearchVesselVvdListVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.TransferCondVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.TransferVO;
import com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.vo.CniDwTrnsVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS DryWetClaimDBDAO <br>
 * - ALPS-DryWetClaim system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Yoon, Seyeong
 * @see DryWetClaimBCImpl 참조
 * @since J2EE 1.6
 */
public class DryWetClaimDBDAO extends DBDAOSupport {

	/**
	 * Dry & Wet Claim을 조회한다.<br>
	 * 
	 * @param String dwClmNo
	 * @return SearchDryWetClaimVO
	 * @throws DAOException
	 */
	public SearchDryWetClaimVO searchDryWetClaim(String dwClmNo) throws DAOException {
		DBRowSet dbRowset = null;
		SearchDryWetClaimVO searchDryWetClaimVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			
			param.put("dw_clm_no", dwClmNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DryWetClaimDBDAOSearchDryWetClaimVORSQL(), param, null);
			if (dbRowset.getRowCount() > 0) {
				searchDryWetClaimVO = (SearchDryWetClaimVO)RowSetUtil.rowSetToVOs(dbRowset, SearchDryWetClaimVO.class ).get(0);
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchDryWetClaimVO;
	}
	
	/**
	 * Dry & Wet Claim를 생성한다.<br>
	 * 
	 * @param CustomDryWetClaimVO customDryWetClaimVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addmanageDryWetClaim(CustomDryWetClaimVO customDryWetClaimVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = customDryWetClaimVO.getColumnValues();
			
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new DryWetClaimDBDAOCustomDryWetClaimVOCSQL(), param, null);
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
	 * Dry & Wet Claim를 변경한다.<br>
	 * 
	 * @param CustomDryWetClaimVO customDryWetClaimVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyDryWetClaim(CustomDryWetClaimVO customDryWetClaimVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			
			String trnsFlg = customDryWetClaimVO.getTrnsFlg();
			if ((trnsFlg == null) ||  trnsFlg.equals("")){
				customDryWetClaimVO.setTrnsFlg("N");
			}
			Map<String, String> mapVO = customDryWetClaimVO.getColumnValues();
			
			param.putAll(mapVO);
			
			velParam.put("modType", "Update");
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new DryWetClaimDBDAOCustomDryWetClaimVOUSQL(), param, velParam);
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
	 * Dry & Wet Claim의 MISCELLANEOUS  코드를 조회한다.<br>
	 * 
	 * @param String typeCd
	 * @return List<SearchDryWetClaimCodeListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchDryWetClaimCodeListVO> searchDryWetClaimCodeList(String typeCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchDryWetClaimCodeListVO> searchDryWetClaimCodeListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
		
			param.put("clss_clm_misc_cd", typeCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DryWetClaimDBDAOSearchDryWetClaimCodeListVORSQL(), param, null);
			searchDryWetClaimCodeListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchDryWetClaimCodeListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchDryWetClaimCodeListVO;
	}

	/**
	 * Handler 코드를 조회한다.<br>
	 * 
	 * @param String handler
	 * @return String
	 * @throws DAOException
	 */
	public String searchDryWetClaimHandler(String handler) throws DAOException {
		String result = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
		
			param.put("usr_id", handler);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DryWetClaimDBDAOSearchDryWetClaimHandlerRSQL(), param, null);

			while (dbRowset.next()) {
				result = dbRowset.getString("usr_id");
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
	 * 통화를 검사한다.<br>
	 * 
	 * @param String currCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchCurrency(String currCd) throws DAOException {
		String result = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
		
			param.put("curr_cd", currCd);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DryWetClaimDBDAOSearchCurrencyRSQL(), param, null);

			while (dbRowset.next()) {
				result = dbRowset.getString("curr_cd");
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
	 * Agent 에 관련된 전화번호, e-Mail 정보를 조회한다.<br>
	 * 
	 * @param String agentCd
	 * @return List<SearchAgentVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchAgentVO> searchAgent(String agentCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchAgentVO> searchAgentVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
		
			param.put("clm_pty_no", agentCd);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DryWetClaimDBDAOSearchAgentVORSQL(), param, null);
			searchAgentVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchAgentVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchAgentVO;
	}

	/**
	 * DW Claim No를 조회한다.<br>
	 * 
	 * @param String dwClmTpCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchDwClmNo(String dwClmTpCd) throws DAOException {
		String result = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
		
			param.put("dw_clm_tp_cd", dwClmTpCd);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DryWetClaimDBDAOSearchDryWetClaimNoRSQL(), param, null);
	
			while (dbRowset.next()) {
				result = dbRowset.getString("dw_clm_no");
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
	 * Dry & Wet Claim의 Status History를 입력한다.<br>
	 * 
	 * @param String dwClmNo
	 * @param String statusCd
	 * @param String usrId
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addDryWetClaimHis(String dwClmNo, String statusCd, String usrId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		int result = 0;
		try {
			
			param.put("dw_clm_no", dwClmNo);
			param.put("dw_clm_sts_cd", statusCd);
			param.put("cre_usr_id", usrId);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new DryWetClaimDBDAOCustomDryWetClaimHisCSQL(), param, null);
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
	 * Dry & Wet Claim를 Close한다.<br>
	 * 
	 * @param String dwClmNo
	 * @param String usrId
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyCloseDryWetClaim(String dwClmNo, String usrId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			
			param.put("dw_clm_no", dwClmNo);
			param.put("dw_clm_sts_cd", "CC");
			param.put("upd_usr_id", usrId);
			
			velParam.put("modType", "Close");
						
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new DryWetClaimDBDAOCustomDryWetClaimVOUSQL(), param, velParam);
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
	 * Dry & Wet Claim를 Reopen한다.<br>
	 * 
	 * @param String dwClmNo
	 * @param String statusCd
	 * @param String usrId
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyReopenDryWetClaim(String dwClmNo, String statusCd, String usrId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			
			param.put("dw_clm_no", dwClmNo);
			param.put("dw_clm_sts_cd", statusCd);
			param.put("upd_usr_id", usrId);
			
			velParam.put("modType", "Reopen");
						
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new DryWetClaimDBDAOCustomDryWetClaimVOUSQL(), param, velParam);
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
	 * Dry & Wet Claim를 취소한다.<br>
	 * 
	 * @param String dwClmNo
	 * @param String usrId
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyCancelDryWetClaim(String dwClmNo, String usrId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			
			param.put("dw_clm_no", dwClmNo);
			param.put("dw_clm_sts_cd", "XX");
			param.put("upd_usr_id", usrId);
			
			velParam.put("modType", "Cancel");
						
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new DryWetClaimDBDAOCustomDryWetClaimVOUSQL(), param, velParam);
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
	 * Status 이력에서 최근 Status Code를 조회한다.<br>
	 * 
	 * @param String dwClmNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchDryWetClaimHis(String dwClmNo) throws DAOException {
		String result = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
		
			param.put("dw_clm_no", dwClmNo);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DryWetClaimDBDAOSearchDryWetClaimHisRSQL(), param, null);
	
			while (dbRowset.next()) {
				result = dbRowset.getString("dw_clm_sts_cd");
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
	 * 선박명를 조회한다.<br>
	 * 
	 * @param String vslCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchVesselName(String vslCd) throws DAOException {
		String result = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
		
			param.put("vsl_cd", vslCd);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DryWetClaimDBDAOSearchVesselNameRSQL(), param, null);
	
			while (dbRowset.next()) {
				result = dbRowset.getString("vsl_eng_nm");
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
	 * Claim 및Incident Case 접수 및 처리 현황 조회한다.<br>
	 * 
	 * @param CondSearchStatusListVO condSearchStatusListVO
	 * @return List<SearchStatusListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchStatusListVO> searchStatusList(CondSearchStatusListVO condSearchStatusListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchStatusListVO> searchStatusListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
		
			Map<String, String> mapVO = condSearchStatusListVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DryWetClaimDBDAOSearchStatusListVORSQL(), param, velParam);
			searchStatusListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchStatusListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchStatusListVO;
	}

	/**
	 * Office Code를 검사한다.<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchDryWetClaimOffice(String ofcCd) throws DAOException {
		String result = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
		
			param.put("ofc_cd", ofcCd);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DryWetClaimDBDAOSearchDryWetClaimOfficeRSQL(), param, null);
	
			while (dbRowset.next()) {
				result = dbRowset.getString("ofc_cd");
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
	 * 선박 항차 정보를 조회한다.<br>
	 * 
	 * @param String vvdCd
	 * @param String vslEngNm
	 * @return List<SearchVesselVvdListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchVesselVvdListVO> searchVesselVvdList(String vvdCd, String vslEngNm) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchVesselVvdListVO> searchVesselVvdListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
		
			if (vvdCd.length() > 3) { 
				param.put("vsl_cd", vvdCd.substring(0,4));
			} else {
				param.put("vsl_cd", "");
			}
			if (vvdCd.length() > 7) {
				param.put("skd_voy_no", vvdCd.substring(4,8));
			} else {
				param.put("skd_voy_no", "");
			}
			if (vvdCd.length() > 8) {
				param.put("skd_dir_cd", vvdCd.substring(8,9));
			} else {
				param.put("skd_dir_cd", "");
			}
			param.put("vsl_eng_nm", vslEngNm.toUpperCase());
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DryWetClaimDBDAOSearchVesselVvdListVORSQL(), param, null);
			searchVesselVvdListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchVesselVvdListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchVesselVvdListVO;
	}

	/**
	 * Vessel Code & Particular Inquiry(Other).<br>
	 * 
	 * @param String vslVvd
	 * @return List<SearchVesselVvdListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchVesselVvdListVO> searchOtherVesselVvdList(String vslVvd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchVesselVvdListVO> searchVesselVvdListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
		
			if (vslVvd.length() > 3) {
				param.put("vsl_cd", vslVvd.substring(0,4));
			}
			if (vslVvd.length() > 7) {
				param.put("skd_voy_no", vslVvd.substring(4,8));
			}
			if (vslVvd.length() > 8) {
				param.put("skd_dir_cd", vslVvd.substring(8,9));
			}
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DryWetClaimDBDAOSearchOtherVesselVvdListVORSQL(), param, null);
			searchVesselVvdListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchVesselVvdListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchVesselVvdListVO;
	}

	/**
	 * 경리환율 정보를 조회한다.<br>
	 * 
	 * @param String fmDt
	 * @param String toDt
	 * @param String currCd
	 * @return List<SearchRoeListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchRoeListVO> searchRoeList(String fmDt, String toDt, String currCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchRoeListVO> searchRoeListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
		
			param.put("fm_dt", fmDt.replaceAll("-", ""));
			param.put("to_dt", toDt.replaceAll("-", ""));
			param.put("curr_cd", currCd);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DryWetClaimDBDAOSearchRoeListVORSQL(), param, null);
			searchRoeListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchRoeListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchRoeListVO;
	}

	/**
	 * 해당 Case 관련 발생된 제 처리비용을 조회한다.<br>
	 * 
	 * @param String dwClmNo
	 * @return List<SearchHandlingCostListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchHandlingCostListVO> searchHandlingCostList(String dwClmNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchHandlingCostListVO> searchHandlingCostListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			
			param.put("dw_clm_no", dwClmNo);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DryWetClaimDBDAOSearchHandlingCostListVORSQL(), param, null);
			searchHandlingCostListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchHandlingCostListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchHandlingCostListVO;
	}

	/**
	 * 해당 Case 관련 발생된 제 처리비용을 생성한다.<br>
	 * 
	 * @param customHandlingCostVO List<CustomHandlingCostVO>
	 * @throws DAOException
	 */
	public void addHandlingCosts(List<CustomHandlingCostVO> customHandlingCostVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customHandlingCostVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new DryWetClaimDBDAOCustomHandlingCostVOCSQL(), customHandlingCostVO,null);
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
	 * 해당 Case 관련 발생된 제 처리비용을 변경한다.<br>
	 * 
	 * @param customHandlingCostVO List<CustomHandlingCostVO>
	 * @throws DAOException
	 */
	public void modifyHandlingCosts(List<CustomHandlingCostVO> customHandlingCostVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(customHandlingCostVO.size() > 0){
	
				updCnt = sqlExe.executeBatch((ISQLTemplate)new DryWetClaimDBDAOCustomHandlingCostVOUSQL(), customHandlingCostVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
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
	 * 해당 Case 관련 발생된 제 처리비용을 삭제한다.<br>
	 * 
	 * @param customHandlingCostVO List<CustomHandlingCostVO>
	 * @throws DAOException
	 */
	public void removeHandlingCosts(List<CustomHandlingCostVO> customHandlingCostVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(customHandlingCostVO.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new DryWetClaimDBDAOCustomHandlingCostVODSQL(), customHandlingCostVO,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
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
	 * 해당 Case 관련 발생된 Claim 내용을 조회한다.<br>
	 * 
	 * @param String dwClmNo
	 * @return SearchHandlingCostVO
	 * @throws DAOException
	 */
	public SearchHandlingCostVO searchHandlingCost(String dwClmNo) throws DAOException {
		DBRowSet dbRowset = null;
		SearchHandlingCostVO searchHandlingCostVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
			
			param.put("dw_clm_no", dwClmNo);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DryWetClaimDBDAOSearchHandlingCostVORSQL(), param, null);
			searchHandlingCostVO = (SearchHandlingCostVO)RowSetUtil.rowSetToVOs(dbRowset, SearchHandlingCostVO.class ).get(0);
	
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchHandlingCostVO;
	}

	/**
	 * Handing Cost 저장시 Payee Code 검사한다.<br>
	 * 
	 * @param String clmPtyNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchCheckPayee(String clmPtyNo) throws DAOException {
		String result = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
		
			param.put("clm_pty_no", clmPtyNo);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DryWetClaimDBDAOSearchCheckPayeeRSQL(), param, null);
	
			while (dbRowset.next()) {
				result = dbRowset.getString("clm_pty_no");
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
	 * 선박 정보를 조회한다.<br>
	 * 
	 * @param String vslCd
	 * @param String vslNm
	 * @return List<SearchVesselListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchVesselListVO> searchVesselList(String vslCd, String vslNm) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchVesselListVO> searchVesselListVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
		
			param.put("vsl_cd", vslCd);
			param.put("vsl_eng_nm", vslNm.toUpperCase());
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DryWetClaimDBDAOSearchVesselListVORSQL(), param, null);
			searchVesselListVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchVesselListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchVesselListVO;
	}
	//====================================================================================
	// 정행룡
	//====================================================================================
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0310] Handler History
	// ---------------------------------------------------------------------------  
	/**
	 * Claim No 별 Handler History 리스트 조회<br>
	 * @author 정행룡
	 * @category CPS_CNI_0310
	 * @category searchHandlerHistoryList 
	 * @param String dwClmNo
	 * @return List<HandlerHistoryVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<HandlerHistoryVO> searchHandlerHistoryList(String dwClmNo) throws DAOException {
	    DBRowSet dbRowset = null;
	        
	    List<HandlerHistoryVO> list = null;        
	       
	    try{    
	        	// query parameter
	            Map<String, Object> param = new HashMap<String, Object>();
	            // velocity parameter
	            Map<String, Object> velParam = new HashMap<String, Object>();
	            
	        	//  DW Claim No
	        	param.put("dw_clm_no", dwClmNo);
	        	
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DryWetClaimDBDAOSearchHandlerHistoryListRSQL(), param, velParam);
	            
	            list = (List)RowSetUtil.rowSetToVOs(dbRowset, HandlerHistoryVO.class);
	                 
	            return list;
	            
	        }catch(SQLException se){
	            log.error(se.getMessage(),se);
	            throw new DAOException(new ErrorHandler(se).getMessage());
	        }catch(Exception ex){
	            log.error(ex.getMessage(),ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage());
	        }
	}
	    
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0311] Manager History
	// ---------------------------------------------------------------------------
	/**
	 * Claim No 별 Manager History 리스트 조회<br>
	 * 
	 * @author 정행룡
	 * @category CPS_CNI_0311
	 * @category searchManagerHistoryList
	 * @param String dwClmNo
	 * @return List<ManagerHistoryVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ManagerHistoryVO> searchManagerHistoryList(String dwClmNo) throws DAOException {
		DBRowSet dbRowset = null;

		List<ManagerHistoryVO> list = null;

		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			// Claim No
			param.put("dw_clm_no", dwClmNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new DryWetClaimDBDAOSearchManagerHistoryListRSQL(),param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset,ManagerHistoryVO.class);

			return list;

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Manager History 데이터를 일괄적으로 등록한다.<br>
	 * 
	 * @author 정행룡
	 * @category CPS_CNI_0311
	 * @category addManagerHistory
	 * @param List<HandlerHistoryVO> addVoList
	 * @throws DAOException
	 */
	public void addManagerHistory(List<HandlerHistoryVO> addVoList) throws DAOException, Exception {
		try {
			int insCnt = 0;

			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			if (addVoList.size() > 0) {
				for (int i = 0; i < addVoList.size(); i++) {
					Map<String, Object> param = new HashMap<String, Object>();
					Map<String, String> dataVO = new HashMap<String, String>();
					HandlerHistoryVO handlerHistoryVO = addVoList.get(i);

					dataVO = handlerHistoryVO.getColumnValues();

					param.putAll(dataVO);
					insCnt = new SQLExecuter("")
							.executeUpdate((ISQLTemplate) new DryWetClaimDBDAOAddManagerHistoryCSQL(),param, velParam);
					if (insCnt == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to Add No" + i + " SQL");
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Manager History 다건의 데이터를 일괄적으로 수정한다.<br>
	 * 
	 * @author 정행룡
	 * @category CPS_CNI_0311
	 * @category modifyManagerHistory
	 * @param List<HandlerHistoryVO> modifyVoList
	 * @throws DAOException
	 */
	public void modifyManagerHistory(List<HandlerHistoryVO> modifyVoList)throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (modifyVoList.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>();
				insCnt = sqlExe.executeBatch((ISQLTemplate) new DryWetClaimDBDAOModifyManagerHistoryUSQL(),modifyVoList, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Manager History 다건의 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @author 정행룡
	 * @category CPS_CNI_0311
	 * @category removeManagerHistory
	 * @param List<HandlerHistoryVO> deleteVoList
	 * @throws DAOException
	 */
	public void removeManagerHistory(List<HandlerHistoryVO> deleteVoList)
			throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (deleteVoList.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>();
				insCnt = sqlExe.executeBatch((ISQLTemplate) new DryWetClaimDBDAORemoveManagerHistoryDSQL(),deleteVoList, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Delete No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Handler History 데이터를 등록한다.<br>
	 * 
	 * @author 정행룡
	 * @category CPS_CNI_0310
	 * @category addHandlerHistory
	 * @param HandlerHistoryVO handlerHistoryVO
	 * @throws DAOException
	 */
	public void addHandlerHistory(HandlerHistoryVO handlerHistoryVO)
			throws DAOException, Exception {
		try {

			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> paramMap = handlerHistoryVO.getColumnValues();
			sqlExe.executeUpdate((ISQLTemplate) new DryWetClaimDBDAOAddHandlerHistoryCSQL(),paramMap, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Handler History 데이터를 수정한다.<br>
	 * 
	 * @author 정행룡
	 * @category CPS_CNI_0310
	 * @category modifyHandlerHistory
	 * @param HandlerHistoryVO handlerHistoryVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public void modifyHandlerHistory(HandlerHistoryVO handlerHistoryVO)
			throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> paramMap = handlerHistoryVO.getColumnValues();
			sqlExe.executeUpdate((ISQLTemplate) new DryWetClaimDBDAOModifyHandlerHistoryUSQL(),paramMap, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * DW Claim Main Transfer 등록<br>
	 * 
	 * @author 정행룡
	 * @category CPS_CNI_0301
	 * @category AddTransfer
	 * @param CniDwTrnsVO cniDwTrnsVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public void addTransfer(CniDwTrnsVO cniDwTrnsVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> paramMap = cniDwTrnsVO.getColumnValues();

			sqlExe.executeUpdate((ISQLTemplate) new DryWetClaimDBDAOAddTransferCSQL(),paramMap, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * DW Claim Main Transfer 삭제<br>
	 * 
	 * @author 정행룡
	 * @category CPS_CNI_0301
	 * @category removeTransfer
	 * @param CniDwTrnsVO cniDwTrnsVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public void removeTransfer(CniDwTrnsVO cniDwTrnsVO) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> paramMap = cniDwTrnsVO.getColumnValues();

			sqlExe.executeUpdate((ISQLTemplate) new DryWetClaimDBDAORemoveTransferDSQL(),					paramMap, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	    
    // ---------------------------------------------------------------------------
    // [CPS_CNI_0312] Transfer
    // ---------------------------------------------------------------------------	
	/**
	 * Transfer 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0312
	 * @category searchTransferList 
	 * @param TransferCondVO transferCondVO
     * @return List<TransferVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<TransferVO> searchTransferList(TransferCondVO transferCondVO) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<TransferVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
            //param
			String pageNo = transferCondVO.getPageNo();
			String schOfcCd = transferCondVO.getSchOfcCd();
			String schUsrId = transferCondVO.getSchUsrId();
			String schDateDiv = transferCondVO.getSchDateDiv();
			String schDateFrom = transferCondVO.getSchDateFrom();
			String schDateTo = transferCondVO.getSchDateTo();
			String schTrnsAuthCd = transferCondVO.getSchTrnsAuthCd();
			
			int currentPage = 0;
			
			if (pageNo != null && !pageNo.equals("")) {
				currentPage = Integer.parseInt(pageNo);
			}
							
			if (currentPage > 0) {
				int startNo     = CniConst.CNI_PAGE_SIZE * (currentPage - 1) + 1;
				int endNo       = CniConst.CNI_PAGE_SIZE * currentPage;					
				param.put("start_page", startNo);
				param.put("end_page", endNo);	
			}
			if (pageNo.equals("")) {//print시 2000건 
				param.put("start_page", 1);
				param.put("end_page", 2000);
			} 
			            
        	// 조회조건
        	param.put("sch_ofc_cd", schOfcCd);
        	param.put("sch_usr_id", schUsrId);
        	param.put("sch_date_div", schDateDiv);
        	param.put("sch_date_from", schDateFrom);
        	param.put("sch_date_to", schDateTo);
        	param.put("sch_trns_auth_cd", schTrnsAuthCd);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DryWetClaimDBDAOSearchTransferListRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, TransferVO.class);
                 
            return list;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }	
    
    /**
	 * Transfer Claim Main수정<br>
	 * @author 양정란
	 * @category CPS_CNI_0312
	 * @category modifyTransferClaimMain
	 * @param String dwClmNo
	 * @param String updUsrId
	 * @param String hdlrUsrId
	 * @param String hdlrOfcCd
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
    public void modifyTransferClaimMain(String dwClmNo , String updUsrId , String hdlrUsrId, String hdlrOfcCd) throws DAOException {    	  
		
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = new HashMap<String , String>();			
			paramMap.put("dw_clm_no", dwClmNo);
			paramMap.put("upd_usr_id", updUsrId);
			paramMap.put("hdlr_usr_id", hdlrUsrId);
			paramMap.put("hdlr_ofc_cd", hdlrOfcCd);
			sqlExe.executeUpdate((ISQLTemplate) new DryWetClaimDBDAOModifyTransferClaimMainUSQL(), paramMap, velParam);  
			
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    	
    }        

	/**
	 * Transfer 수정<br>
	 * @author 양정란
	 * @category CPS_CNI_0312
	 * @category modifyTransfer
	 * @param TransferVO transferVO
	 * @throws DAOException
	 */
    @SuppressWarnings("unchecked")
    public void modifyTransfer(TransferVO transferVO) throws DAOException {    	  
		
        try{    
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = transferVO.getColumnValues();			
			sqlExe.executeUpdate((ISQLTemplate) new DryWetClaimDBDAOModifyTransferUSQL(), paramMap, velParam);  
			
			if(transferVO.getClmTrnsAuthCd().equals("A")){//Accepted 면 Claim Main 에 Update.
				sqlExe.executeUpdate((ISQLTemplate) new DryWetClaimDBDAOModifyClaimMainTrnsFlgUSQL(), paramMap, velParam);  
			}
			
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    	
    }   
    
	/**
	 * USER 명을 조회한다..<br>
	 * 
	 * @param String usrId
	 * @return String
	 * @throws DAOException
	 */
	public String searchUserIdName(String usrId) throws DAOException {
		String result = null;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try{
		
			param.put("usr_id", usrId);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new DryWetClaimDBDAOSearchUserNameRSQL(), param, null);
	
			while (dbRowset.next()) {
				result = dbRowset.getString("usr_nm");
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