/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CntrPlanGuidelineManageDBDAO.java
*@FileTitle : Container Guideline Manage
*Open Issues :
*Change history :
* No.	Ver.		Modifier       	modifier date    explanation
* 1     1.0      	SHIN DONG IL	2013.05.27		 Creation
* 2		1.6     	YONGCHAN SHIN	2014.01.06		 Guideline Recipient Set-up 신규생성(CSR ID : CHM-201328003) 
*@LastModifyDate : 2013.05.27
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2013.05.27 SHIN DONG IL
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelinemanage.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.eqr.cntrcommon.Utils;

import com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelinemanage.vo.EesEqr1008ConditionVO;
import com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelinemanage.vo.EesEqr1009ConditionVO;

import com.clt.syscommon.common.table.EqrCtrlGlineHdrVO;
import com.clt.syscommon.common.table.EqrCtrlLodgGlineVO;
import com.clt.syscommon.common.table.EqrCtrlDchgGlineVO;
import com.clt.syscommon.common.table.EqrCtrlDchgGlineValVO;

import com.clt.apps.opus.ees.eqr.cntrcommon.eqrcommon.vo.CommonVO;
import com.clt.apps.opus.ees.eqr.cntrcommon.vo.CommonRsVO;

import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * OPUS CntrPlanGuidelineManageDBDAO <br>
 * - OPUS-CntrPlanGuide system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 	SHIN DONG IL
 * @see 	CntrPlanGuidelineManageBCImpl.java 참조
 * @since 	J2EE 1.6
 */
public class CntrPlanGuidelineManageDBDAO extends DBDAOSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * Search Guideline Creation Config <br>
     * EES_EQR_1008.do
     * @param EesEqr1008ConditionVO condVO
     * @return  CommonVO
     * @exception DAOException
    */
	public CommonVO searchGuidelineConfig(EesEqr1008ConditionVO condVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		Map<String, String> mapVO = condVO.getColumnValues();
		
		param.putAll(mapVO);
		CommonVO retVO = new CommonVO();
		String[] returnStr = new String[1];
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrPlanGuidelineManageDBDAOGuidelineConfigRSQL(), param, param);
			while(dbRowset.next()) {
				 if(dbRowset.getString("LCL_DT")==null){
					 returnStr[0]="";
				 }else{
					 returnStr[0]=dbRowset.getString("LCL_DT");
				 }
			}
			retVO.setResultStrArray(returnStr);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVO;
	}

	/**
     * Search Guideline Add/Amend Config <br>
     * EES_EQR_1009.do
     * @param EesEqr1009ConditionVO conditionVO
     * @return CommonVO
     * @exception DAOException
    */
	public CommonVO searchAddGuidelineConfig(EesEqr1009ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		Map<String, String> mapVO = conditionVO.getColumnValues();
		
		param.putAll(mapVO);
		CommonVO retVO = new CommonVO();
		String[] returnStr = new String[4];
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrPlanGuidelineManageDBDAOSearchAddGuidelineConfigRSQL(), param, param);
			
			while(dbRowset.next()) {
				 if(dbRowset.getString("VVD")==null)		returnStr[0]="";
				 else										returnStr[0]=dbRowset.getString("VVD");
				 
				 if(dbRowset.getString("POL_CD")==null)		returnStr[1]="";
				 else										returnStr[1]=dbRowset.getString("POL_CD");
				 
				 if(dbRowset.getString("EFF_ST_DT")==null)	returnStr[2]="";
				 else										returnStr[2]=dbRowset.getString("EFF_ST_DT");				 
				 
				 if(dbRowset.getString("ETA_DT")==null) 	returnStr[3]="";
				 else										returnStr[3]=dbRowset.getString("ETA_DT");
				 
			}
			
			retVO.setResultStrArray(returnStr);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVO;
	}	
	

	/**
     * Search Guideline Add시 VVD 조회 <br>
     * EES_EQR_1009.do
     * @param EesEqr1009ConditionVO conditionVO
     * @return CommonVO
     * @exception DAOException
    */
	public CommonVO searchAddGlineVvd(EesEqr1009ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		Map<String, String> mapVO = conditionVO.getColumnValues();
		
		param.putAll(mapVO);
		CommonVO retVO = new CommonVO();
		String[] returnStr = new String[3];
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrPlanGuidelineManageDBDAOSearchAddGlineVvdRSQL(), param, param);
			while(dbRowset.next()) {
				 if(dbRowset.getString("VVD_CD")==null){
					 returnStr[0]="";
				 }else{
					 returnStr[0]=dbRowset.getString("VVD_CD");
				 }
			}
			retVO.setResultStrArray(returnStr);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVO;
	}	
	
	
	/**
     * Search Guideline Add시 VVD 조회 <br>
     * EES_EQR_1009.do
     * @param EesEqr1009ConditionVO conditionVO
     * @return CommonVO
     * @exception DAOException
    */
	public CommonVO searchAddGlineEtaDt(EesEqr1009ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		Map<String, String> mapVO = conditionVO.getColumnValues();
		
		param.putAll(mapVO);
		CommonVO retVO = new CommonVO();
		String[] returnStr = new String[2];
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrPlanGuidelineManageDBDAOSearchAddGlineEtaDtRSQL(), param, param);
			while(dbRowset.next()) {
				 if(dbRowset.getString("ETA_DT")==null){
					 returnStr[0]="";
				 }else{
					 returnStr[0]=dbRowset.getString("ETA_DT");
				 }
				 
				 if(dbRowset.getString("EFF_ST_DT")==null){
					 returnStr[1]="";
				 }else{
					 returnStr[1]=dbRowset.getString("EFF_ST_DT");
				 }
			}
			retVO.setResultStrArray(returnStr);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVO;
	}	
	
	
	/**
     * Search Guideline Add/Amend Config <br>
     * EES_EQR_1009.do
     * @param EesEqr1009ConditionVO conditionVO
     * @return CommonVO
     * @exception DAOException
    */
	public CommonVO searchPolCdList(EesEqr1009ConditionVO conditionVO) throws DAOException {
 		DBRowSet dbRowset = null;
 		StringBuilder sb = new StringBuilder();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		Map<String, String> mapVO = conditionVO.getColumnValues();
		
		param.putAll(mapVO);
		CommonVO retVO = new CommonVO();
		String[] returnStr = new String[1];
		String  str_pol_cd = "";
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrPlanGuidelineManageDBDAOSearchPolCdListRSQL(), param, param);
			while(dbRowset.next()) {
				sb.append(dbRowset.getString("POL_CD")).append("|");
				//str_pol_cd = str_pol_cd +dbRowset.getString("POL_CD")+"|";
			}
			str_pol_cd = sb.toString();
			if(str_pol_cd.equals("")){
				returnStr[0] ="";
			}else{
				returnStr[0]= str_pol_cd.substring(0, str_pol_cd.length()-1);
			}
			retVO.setResultStrArray(returnStr);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVO;
	}	
	
	
	/**
     * Search Guideline Creation <br>
     * EES_EQR_1008.do
     * @param EesEqr1008ConditionVO condVO
     * @return CommonRsVO
     * @exception DAOException
    */
	@SuppressWarnings("rawtypes")
	public CommonRsVO searchGuidelineList(EesEqr1008ConditionVO condVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		Map<String, String> mapVO = condVO.getColumnValues();
		
		if(!(condVO.getLane()).equals("")){//Lane 입력하였을 경우
			condVO.setTrade("");
			condVO.setSubtrade("");
		}else if(!(condVO.getSubtrade()).equals("")){//Sub Trade 입력하였을 경우
			condVO.setTrade("");
		}
		
		List arr_trd_cd 	= Utils.replaceStrToList(condVO.getTrade());
		List arr_sub_trd_cd = Utils.replaceStrToList(condVO.getSubtrade());
		List arr_lane 		= Utils.replaceStrToList(condVO.getLane());
		
		param.put("s_cfm_flg", JSPUtil.getNull(condVO.getSCfmFlg()));
		param.putAll(mapVO);
		
		velParam.put("s_dt_tp_cd",condVO.getSDtTpCd());
		velParam.put("s_eta_dt", condVO.getSEtaDt());
		velParam.put("s_eff_st_dt", condVO.getSEffStDt());
		velParam.put("s_eff_end_dt", condVO.getSEffEndDt());
		velParam.put("s_loc_cd", condVO.getSLocCd());
		velParam.put("s_sub_loc_cd", condVO.getSSubLocCd());
		velParam.put("s_cfm_flg", condVO.getSCfmFlg());
		velParam.put("trade", condVO.getTrade());
		velParam.put("subtrade", condVO.getSubtrade());
		velParam.put("lane", condVO.getLane());	
		velParam.put("lane_direct", condVO.getLaneDirect());	// lane 직접입력 조회값		
		velParam.put("arr_trd_cd", arr_trd_cd);
		velParam.put("arr_sub_trd_cd", arr_sub_trd_cd);
		velParam.put("arr_lane", arr_lane);

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrPlanGuidelineManageDBDAOSearchGuidelineListRSQL(), param, velParam);
			commonRsVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonRsVO;
	}
	
	
	/**
     * Search Guideline AmendPortion <br>
     * EES_EQR_1008.do
     * @param EesEqr1009ConditionVO condVO
     * @return CommonRsVO
     * @exception DAOException
    */
	public CommonRsVO searchAmendPortion(EesEqr1009ConditionVO condVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		Map<String, String> mapVO = condVO.getColumnValues();
		
		param.putAll(mapVO);

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrPlanGuidelineManageDBDAOSearchAmendPortionRSQL(), param, velParam);
			commonRsVO.setDbRowset(dbRowset);

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonRsVO;
	}
	
	
	
	
	/**
     * Guideline SEQ 생성<br>
     * EES_EQR_1008.do
     * @param EqrCtrlGlineHdrVO eqrCtrlGlineHdrVO
     * @return String
     * @exception DAOException
    */
	public String makeGuidelineSeq(EqrCtrlGlineHdrVO eqrCtrlGlineHdrVO) throws DAOException {
	    String eq_glne_seq  = "";
		
	    try {
			DBRowSet dbRowset = null;

			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, String> mapVO = eqrCtrlGlineHdrVO.getColumnValues();
			param.putAll(mapVO);

	    	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrPlanGuidelineManageDBDAONewGuidelineSeqRSQL(), param, param);
	        
	        if(dbRowset.next()){
	        	eq_glne_seq = dbRowset.getString("EQ_GLINE_SEQ");
	        }
	        
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	    
	    return eq_glne_seq;
	}
	
	/**
     * Guideline SEQ 생성<br>
     * EES_EQR_1008.do
     * @param EqrCtrlGlineHdrVO eqrCtrlGlineHdrVO
     * @return String
     * @exception DAOException
    */
	public String searchOldConfirmFlg(EqrCtrlGlineHdrVO eqrCtrlGlineHdrVO) throws DAOException {
	    String old_cfm_flg  = "";
		
	    try {
			DBRowSet dbRowset = null;

			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, String> mapVO = eqrCtrlGlineHdrVO.getColumnValues();
			param.putAll(mapVO);

	    	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrPlanGuidelineManageDBDAOSearchOldConfirmFlgRSQL(), param, param);
	        
	        if(dbRowset.next()){
	        	old_cfm_flg = dbRowset.getString("OLD_CFM_FLG");
	        }
	        
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	    
	    return old_cfm_flg;
	}	
	/**
     * Guideline Header PK Check<br>
     * EES_EQR_1008.do
     * @param String table_name
     * @param String trd_cd
     * @param String sub_trd_cd
     * @param String vsl_lane_cd
     * @param String ins_gline_seq
     * @param String cntr_tpsz_cd
     * @param String pod_cd      
     * @return String
     * @exception DAOException
    */
	public String checkGuidelineKey(String table_name,String trd_cd, String sub_trd_cd, String vsl_lane_cd, String ins_gline_seq, String cntr_tpsz_cd, String pod_cd) throws DAOException {
		  
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
	    String check_key  = "";

	    
	    try {
	    	velParam.put("table_name",	table_name);
	    	velParam.put("cntr_tpsz_cd",cntr_tpsz_cd);
	    	velParam.put("pod_cd",		pod_cd);
	    	param.put("trd_cd",			trd_cd);
	    	param.put("sub_trd_cd",		sub_trd_cd);
	    	param.put("vsl_lane_cd",	vsl_lane_cd);
	    	param.put("eq_gline_seq",	ins_gline_seq);
	    	param.put("cntr_tpsz_cd",	cntr_tpsz_cd);
	    	param.put("pod_cd",			pod_cd);

	    	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrPlanGuidelineManageDBDAOCheckGuidelineKeyRSQL(), param, velParam);
	        
	        if(dbRowset.next()){
	        	if(dbRowset.getString("CHECK_FLG")==null){
	        		check_key = "N";
	        	}else{
	        		check_key = "Y";
	        	}
	        }else{
	        	check_key = "N";
	        }
	        
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	    
	    return check_key;
	}
	
	/**
	 * [ EES_EQR_1008 : EQR_CTRL_GLINE_HDR TABLE INSERT]<br>
	 * @param eqrCtrlGlineHdrVO EqrCtrlGlineHdrVO
	 * @exception DAOException
	 */
	public void addGuidelineHeader(EqrCtrlGlineHdrVO eqrCtrlGlineHdrVO) throws DAOException,Exception {

		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, String> mapVO = eqrCtrlGlineHdrVO.getColumnValues();
			param.putAll(mapVO);

			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrPlanGuidelineManageDBDAOAddGuidelineHeaderCSQL(), param, null);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [ EES_EQR_1008 : EQR_CTRL_GLINE_HDR TABLE REMARK UPDATE]<br>
	 * @param eqrCtrlGlineHdrVO EqrCtrlGlineHdrVO
	 * @exception DAOException
	 */
	public void modifyGuidelineHeader(EqrCtrlGlineHdrVO eqrCtrlGlineHdrVO) throws DAOException,Exception {

		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, String> mapVO = eqrCtrlGlineHdrVO.getColumnValues();
			param.putAll(mapVO);

			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrPlanGuidelineManageDBDAOModifyGuidelineHeaderUSQL(), param, null);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [ EES_EQR_1008 : EQR_CTRL_GLINE_HDR TABLE UPDATE]<br>
	 * @param eqrCtrlGlineHdrVO EqrCtrlGlineHdrVO
	 * @exception DAOException
	 */
	public void modifyGuidelineEffEndDt(EqrCtrlGlineHdrVO eqrCtrlGlineHdrVO) throws DAOException,Exception {

		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, String> mapVO = eqrCtrlGlineHdrVO.getColumnValues();
			param.putAll(mapVO);

			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrPlanGuidelineManageDBDAOModifyGuidelineEffEndDtUSQL(), param, param);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * [ EES_EQR_1008 : EQR_CTRL_LODG_GLINE TABLE INSERT]<br>
	 * @param eqrCtrlLodgGlineVO EqrCtrlLodgGlineVO 
	 * @exception DAOException
	 */
	public void addLoadingGuideline(EqrCtrlLodgGlineVO eqrCtrlLodgGlineVO) throws DAOException,Exception {
	
		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, String> mapVO = eqrCtrlLodgGlineVO.getColumnValues();

			param.putAll(mapVO);
				
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrPlanGuidelineManageDBDAOAddLoadingGuidelineCSQL(), param, null);

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * [ EES_EQR_1008 : EQR_CTRL_LODG_GLINE TABLE INSERT]<br>
	 * @param eqrCtrlDchgGlineVO EqrCtrlDchgGlineVO
	 * @exception DAOException
	 */
	public void addDischargingGuideline(EqrCtrlDchgGlineVO eqrCtrlDchgGlineVO) throws DAOException,Exception {

		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, String> mapVO = eqrCtrlDchgGlineVO.getColumnValues();
			param.putAll(mapVO);
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrPlanGuidelineManageDBDAOAddDischargingGuidelineCSQL(), param, null);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	
	/**
	 * [ EES_EQR_1008 : EQR_CTRL_LODG_GLINE TABLE INSERT]<br>
	 * @param eqrCtrlDchgGlineValVO EqrCtrlDchgGlineValVO
	 * @exception DAOException
	 */
	public void addDischargingValueGuideline(EqrCtrlDchgGlineValVO eqrCtrlDchgGlineValVO) throws DAOException,Exception {
		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, String> mapVO = eqrCtrlDchgGlineValVO.getColumnValues();

			param.putAll(mapVO);

			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrPlanGuidelineManageDBDAOAddDischargingValueGuidelineCSQL(), param, null);

			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * [ EES_EQR_1008 : EQR_CTRL_LODG_GLINE TABLE UPDATE]<br>
	 * @param eqrCtrlLodgGlineVO EqrCtrlLodgGlineVO
	 * @exception DAOException
	 */
	public void modifyLoadingGuideline(EqrCtrlLodgGlineVO eqrCtrlLodgGlineVO) throws DAOException,Exception {
	
		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, String> mapVO = eqrCtrlLodgGlineVO.getColumnValues();

			param.putAll(mapVO);
	
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrPlanGuidelineManageDBDAOModifyLoadingGuidelineUSQL(), param, null);

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ EES_EQR_1008 : EQR_CTRL_LODG_GLINE TABLE UPDATE]<br>
	 * @param eqrCtrlDchgGlineValVO EqrCtrlDchgGlineValVO
	 * @exception DAOException
	 */
	public void modifyDischargingValueGuideline(EqrCtrlDchgGlineValVO eqrCtrlDchgGlineValVO) throws DAOException,Exception {
		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, String> mapVO = eqrCtrlDchgGlineValVO.getColumnValues();

			param.putAll(mapVO);
	
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrPlanGuidelineManageDBDAOModifyDischargingValueGuidelineUSQL(), param, null);

			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}		
	
	
	/**
	 * [ EES_EQR_1008 : EQR_CTRL_LODG_GLINE TABLE DELETE]<br>
	 * @param eqrCtrlLodgGlineVO EqrCtrlLodgGlineVO
	 * @exception DAOException
	 */
	public void delLoadGuideline(EqrCtrlLodgGlineVO eqrCtrlLodgGlineVO) throws DAOException,Exception {
	
		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, String> mapVO = eqrCtrlLodgGlineVO.getColumnValues();

			param.putAll(mapVO);
	
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrPlanGuidelineManageDBDAODelLoadGuidelineDSQL(), param, null);

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [ EES_EQR_1008 : EQR_CTRL_LODG_GLINE TABLE DELETE]<br>
	 * @param eqrCtrlDchgGlineVO EqrCtrlDchgGlineVO
	 * @exception DAOException
	 */
	public void delDischargingValueGuideline(EqrCtrlDchgGlineVO eqrCtrlDchgGlineVO) throws DAOException,Exception {
	
		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, String> mapVO = eqrCtrlDchgGlineVO.getColumnValues();

			param.putAll(mapVO);
	
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrPlanGuidelineManageDBDAODelDischargingValueGuidelineDSQL(), param, null);

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * [ EES_EQR_1008 : EQR_CTRL_LODG_GLINE TABLE DELETE]<br>
	 * @param eqrCtrlDchgGlineValVO EqrCtrlDchgGlineValVO
	 * @exception DAOException
	 */
	public void delDischargingGuideline(EqrCtrlDchgGlineValVO eqrCtrlDchgGlineValVO) throws DAOException,Exception {
	
		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, String> mapVO = eqrCtrlDchgGlineValVO.getColumnValues();

			param.putAll(mapVO);
	
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrPlanGuidelineManageDBDAODelDischargingGuidelineDSQL(), param, null);

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * [ EES_EQR_1008 : EQR_CTRL_LODG_GLINE TABLE DELETE]<br>
	 * @param eqrCtrlGlineHdrVO EqrCtrlGlineHdrVO
	 * @exception DAOException
	 */
	public void delGuidelineHdr(EqrCtrlGlineHdrVO eqrCtrlGlineHdrVO) throws DAOException,Exception {
	
		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, String> mapVO = eqrCtrlGlineHdrVO.getColumnValues();

			param.putAll(mapVO);
	
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrPlanGuidelineManageDBDAODelGuidelineHdrDSQL(), param, null);

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [ EES_EQR_1008 : EQR_CTRL_LODG_GLINE TABLE DELETE]<br>
	 * @param eqrCtrlDchgGlineValVO EqrCtrlDchgGlineValVO
	 * @exception DAOException
	 */
	public void delPodDischargingValue(EqrCtrlDchgGlineValVO eqrCtrlDchgGlineValVO) throws DAOException,Exception {
	
		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, String> mapVO = eqrCtrlDchgGlineValVO.getColumnValues();

			param.putAll(mapVO);
	
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrPlanGuidelineManageDBDAODelPodDischargingValueDSQL(), param, null);

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [ EES_EQR_1008 : EQR_CTRL_LODG_GLINE TABLE DELETE]<br>
	 * @param eqrCtrlDchgGlineVO EqrCtrlDchgGlineVO
	 * @exception DAOException
	 */
	public void delPodDischarging(EqrCtrlDchgGlineVO eqrCtrlDchgGlineVO) throws DAOException,Exception {
	
		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, String> mapVO = eqrCtrlDchgGlineVO.getColumnValues();

			param.putAll(mapVO);
	
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrPlanGuidelineManageDBDAODelPodDischargingDSQL(), param, null);

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
     * Search Guideline Add <br>
     * EES_EQR_1009.do
     * @param EesEqr1009ConditionVO condVO
     * @return  CommonRsVO
     * @exception DAOException
    */
	@SuppressWarnings("rawtypes")
	public CommonRsVO searchAddGuidelineList(EesEqr1009ConditionVO condVO) throws DAOException {
		DBRowSet dbRowset = null;


		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		Map<String, String> mapVO = condVO.getColumnValues();
		
		List arr_cntr_tpsz_cd = Utils.replaceStrToList(condVO.getCntrTpszCd().toUpperCase());
		
		param.putAll(mapVO);
		
		param.put("arr_cntr_tpsz_cd", 	arr_cntr_tpsz_cd);
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrPlanGuidelineManageDBDAOSearchAddGuidelineListRSQL(), param, param);
			commonRsVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonRsVO;
	}
	
	/**
     * Search Guideline Creation Check VvdCd <br>
     * EES_EQR_1008.do
     * @param EesEqr1009ConditionVO conditionVO
     * @return  String
     * @exception DAOException
    */
	public String searchCheckVvdCd(EesEqr1009ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		Map<String, String> mapVO = conditionVO.getColumnValues();
		
		param.putAll(mapVO);
		
		String check_vvd_cd = "";
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrPlanGuidelineManageDBDAOSearchCheckVvdCdRSQL(), param, param);
			while(dbRowset.next()) {
				 if(dbRowset.getString("VVD_CHECK")==null){
					 check_vvd_cd="";
				 }else{
					 check_vvd_cd=dbRowset.getString("VVD_CHECK");
				 }
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return check_vvd_cd;
	}
	
	/**
     * Search Guideline Add/Amend Config <br>
     * EES_EQR_1009.do
     * @param EesEqr1009ConditionVO conditionVO
     * @return CommonVO
     * @exception DAOException
    */
	public CommonVO searchVvdCd(EesEqr1009ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		Map<String, String> mapVO = conditionVO.getColumnValues();
		
		param.putAll(mapVO);
		CommonVO retVO = new CommonVO();
		String[] returnStr = new String[4];
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrPlanGuidelineManageDBDAOSearchVvdCdRSQL(), param, param);
			while(dbRowset.next()) {
				
				if(dbRowset.getString("VVD_CD")==null){
					 returnStr[0]="";
				 }else{
					 returnStr[0]=dbRowset.getString("VVD_CD");
				 }
				
				 if(dbRowset.getString("POL_CD")==null){
					 returnStr[1]="";
				 }else{
					 returnStr[1]=dbRowset.getString("POL_CD");
				 }
				 
				 if(dbRowset.getString("EFF_ST_DT")==null){
					 returnStr[2]="";
				 }else{
					 returnStr[2]=dbRowset.getString("EFF_ST_DT");
				 }
				 
				 if(dbRowset.getString("ETA_DT")==null){
					 returnStr[3]="";
				 }else{
					 returnStr[3]=dbRowset.getString("ETA_DT");
				 }
			}
			retVO.setResultStrArray(returnStr);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVO;
	}
	
	/**
	 * 입력 받은 rcc/lcc/ecc가 해당 rcc에 속하는지 체크 <br>
	 * @param EesEqr1008ConditionVO condVO
	 * @return String
	 * @exception DAOException
	 */
	public String checkSubLocCd(EesEqr1008ConditionVO condVO)  throws DAOException {
		DBRowSet dbRowset = null;
		String check = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(condVO != null){
				Map<String, String> mapVO = condVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrPlanGuidelineManageDBDAOCheckSubLocCdRSQL(), param, velParam);
            while(dbRowset.next()){
            	check = dbRowset.getString(1);
            }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return check;
	}
	 
	 
	/**
	 * Guideline Amend시 마지막 차수인지 체크 <br>
	 * @param EesEqr1008ConditionVO condVO 
	 * @return String
	 * @exception DAOException
	 */
	public String checkMaxEqGlineSeq(EesEqr1008ConditionVO condVO)  throws DAOException {
		DBRowSet dbRowset = null;
		String check = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(condVO != null){
				Map<String, String> mapVO = condVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrPlanGuidelineManageDBDAOCheckMaxEqGlineSeqRSQL(), param, velParam);
            while(dbRowset.next()){
            	check = dbRowset.getString(1);
            }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return check;
	}
	 
	/**
	 * Guideline POL Add시 마지막 Validation 체크 <br>
	 * @param EesEqr1008ConditionVO condVO
	 * @return String
	 * @exception DAOException
	 */
	public String checkPodCd(EesEqr1008ConditionVO condVO)  throws DAOException {
		DBRowSet dbRowset = null;
		String check = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(condVO != null){
				Map<String, String> mapVO = condVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrPlanGuidelineManageDBDAOCheckPodCdRSQL(), param, velParam);
            while(dbRowset.next()){
            	check = dbRowset.getString(1);
            }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return check;
	} 
	 
	 
	/**
	 * Guideline POL Add시 마지막 Validation 체크 <br>
	 * @param EesEqr1009ConditionVO conditionVO
	 * @return String
	 * @exception DAOException
	 */
	public String checkGline(EesEqr1009ConditionVO conditionVO)  throws DAOException {
		DBRowSet dbRowset = null;
		String check = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrPlanGuidelineManageDBDAOCheckGlineRSQL(), param, velParam);
            while(dbRowset.next()){
            	check = dbRowset.getString(1);
            }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return check;
	} 
	 
	
}