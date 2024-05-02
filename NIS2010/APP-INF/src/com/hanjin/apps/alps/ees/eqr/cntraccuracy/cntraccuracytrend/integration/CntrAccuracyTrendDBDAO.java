/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName 		: CntrAccuracyTrendDBDAO.java
*@FileTitle 	: Accuracy
*Open Issues 	:
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1     1.0      	SHIN DONG IL			2013.07.11		 Creation
*
*@LastModifyDate : 2013.07.11
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2013.07.11 SHIN DONG IL
* 1.0 Creation
=========================================================*/
 
package com.hanjin.apps.alps.ees.eqr.cntraccuracy.cntraccuracytrend.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.eqr.cntraccuracy.cntraccuracytrend.basic.CntrAccuracyTrendBCImpl;
import com.hanjin.apps.alps.ees.eqr.cntraccuracy.cntraccuracytrend.vo.EesEqr1025ConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntraccuracy.cntraccuracytrend.vo.EesEqr1026ConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntraccuracy.cntraccuracytrend.vo.EesEqr1066ConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntrcommon.Utils;
import com.hanjin.apps.alps.ees.eqr.cntrcommon.eqrcommon.vo.CommonVO;
import com.hanjin.apps.alps.ees.eqr.cntrcommon.vo.CommonRsVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS CntrAccuracyTrendDBDAO <br>
 * - ALPS-Accuracy system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * @author 	SHIN DONG IL
 * @see 	CntrAccuracyTrendBCImpl.java 참조
 * @since 	J2EE 1.6
 */
public class CntrAccuracyTrendDBDAO extends DBDAOSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
     * [ EES_EQR_1025 :  Loading Trend By Lane List ]
     * 화면 Loading시 기본 설정 데이터 조회
     * @param EesEqr1025ConditionVO condVO
     * @return  CommonVO
     * @exception DAOException
    */
	public CommonVO searchLoadingTrendByLaneDefault(EesEqr1025ConditionVO condVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		Map<String, String> mapVO = condVO.getColumnValues();
		
		param.putAll(mapVO);
		CommonVO retVO = new CommonVO();
		String[] returnStr = new String[6];
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrAccuracyTrendDBDAOSearchLoadingTrendByLaneDefaultRSQL(), param, param);
			while(dbRowset.next()) {
				 if(dbRowset.getString("ETA_FM_DT")==null){
					 returnStr[0]="";
				 }else{
					 returnStr[0]=dbRowset.getString("ETA_FM_DT");
				 }
				 
				 if(dbRowset.getString("ETA_TO_DT")==null){
					 returnStr[1]="";
				 }else{
					 returnStr[1]=dbRowset.getString("ETA_TO_DT");
				 }
				 
				 if(dbRowset.getString("FM_WK")==null){
					 returnStr[2]="";
				 }else{
					 returnStr[2]=dbRowset.getString("FM_WK");
				 }
				 
				 if(dbRowset.getString("TO_WK")==null){
					 returnStr[3]="";
				 }else{
					 returnStr[3]=dbRowset.getString("TO_WK");
				 }
				 
				 if(dbRowset.getString("RCC_CD")==null){
					 returnStr[4]="";
				 }else{
					 returnStr[4]=dbRowset.getString("RCC_CD");
				 }
				 
				 if(dbRowset.getString("OFC_TP_CD")==null){
					 returnStr[5]="";
				 }else{
					 returnStr[5]=dbRowset.getString("OFC_TP_CD");
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
     * [ EES_EQR_1025 : Loading Trend By Lane Search ]<br>
     * @param EesEqr1025ConditionVO condVO
     * @return  CommonRsVO
     * @exception DAOException
    */
	public CommonRsVO searchLoadingTrendByLaneList(EesEqr1025ConditionVO condVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		Map<String, String> mapVO = condVO.getColumnValues();
		
//		if(!(condVO.getLane()).equals("")){//Lane 입력하였을 경우
//			condVO.setTrade("");
//			condVO.setSubtrade("");
//		}else if(!(condVO.getSubtrade()).equals("")){//Sub Trade 입력하였을 경우
//			condVO.setTrade("");
//		}
		
		if(!(condVO.getSubtrade()).equals("")){//Sub Trade 입력하였을 경우
			condVO.setTrade("");
		}		
		
		List arr_trd_cd 		= Utils.replaceStrToList(condVO.getTrade());
		List arr_sub_trd_cd 	= Utils.replaceStrToList(condVO.getSubtrade());
		List arr_lane 			= Utils.replaceStrToList(condVO.getLane());
		List arr_cntr_tpsz_cd	= Utils.replaceStrToList(condVO.getCntrTpszCd());
		
		param.putAll(mapVO);
		velParam.put("dt_tp_cd",condVO.getDtTpCd());
		velParam.put("fm_wk", condVO.getFmWk());
		velParam.put("to_wk", condVO.getToWk());
		velParam.put("eta_fm_dt", condVO.getEtaFmDt());
		velParam.put("eta_to_dt", condVO.getEtaToDt());
		velParam.put("rcc_cd", condVO.getRccCd());
		velParam.put("loc_tp_cd",condVO.getLocTpCd());
		velParam.put("loc_cd", condVO.getLocCd());
		velParam.put("vvd_cd", condVO.getVvdCd());
		velParam.put("trade", condVO.getTrade());
		velParam.put("subtrade", condVO.getSubtrade());
		velParam.put("lane", condVO.getLane());
		velParam.put("cntr_tpsz_cd",condVO.getCntrTpszCd());
		velParam.put("arr_trd_cd", arr_trd_cd);
		velParam.put("arr_sub_trd_cd", arr_sub_trd_cd);
		velParam.put("arr_lane", arr_lane);
		velParam.put("arr_cntr_tpsz_cd", arr_cntr_tpsz_cd);
		

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrAccuracyTrendDBDAOSearchLoadingTrendByLaneListRSQL(), param, velParam);
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
	 * 입력 받은 Loaction Code가 LCC/ECC/SCC에 해당하는지 체크<br>
	 * @param EesEqr1025ConditionVO condVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchCheckLocCd(EesEqr1025ConditionVO condVO)  throws DAOException {
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

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrAccuracyTrendDBDAOSearchCheckLocCdRSQL(), param, velParam);
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
	 * 입력 받은 VVD CD 유효성 체크<br>
	 * @param EesEqr1025ConditionVO condVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchCheckVvdCd(EesEqr1025ConditionVO condVO)  throws DAOException {
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

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrAccuracyTrendDBDAOSearchCheckVvdCdRSQL(), param, velParam);
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
     * [ EES_EQR_1066 :  Loading Trend By Port List ]
     * 화면 Loading시 기본 설정 데이터 조회
     * @param EesEqr1066ConditionVO condVO
     * @return  CommonVO
     * @exception DAOException
     */
	public CommonVO searchLoadingTrendByPortDefault(EesEqr1066ConditionVO condVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		Map<String, String> mapVO = condVO.getColumnValues();
		
		param.putAll(mapVO);
		CommonVO retVO = new CommonVO();
		String[] returnStr = new String[6];
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrAccuracyTrendDBDAOSearchLoadingTrendByPortDefaultRSQL(), param, param);
			while(dbRowset.next()) {
				 if(dbRowset.getString("ETA_FM_DT")==null){
					 returnStr[0]="";
				 }else{
					 returnStr[0]=dbRowset.getString("ETA_FM_DT");
				 }
				 
				 if(dbRowset.getString("ETA_TO_DT")==null){
					 returnStr[1]="";
				 }else{
					 returnStr[1]=dbRowset.getString("ETA_TO_DT");
				 }
				 
				 if(dbRowset.getString("FM_WK")==null){
					 returnStr[2]="";
				 }else{
					 returnStr[2]=dbRowset.getString("FM_WK");
				 }
				 
				 if(dbRowset.getString("TO_WK")==null){
					 returnStr[3]="";
				 }else{
					 returnStr[3]=dbRowset.getString("TO_WK");
				 }
				 
				 if(dbRowset.getString("RCC_CD")==null){
					 returnStr[4]="";
				 }else{
					 returnStr[4]=dbRowset.getString("RCC_CD");
				 }
				 
				 if(dbRowset.getString("OFC_TP_CD")==null){
					 returnStr[5]="";
				 }else{
					 returnStr[5]=dbRowset.getString("OFC_TP_CD");
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
     * [ EES_EQR_1066 : Loading Trend By Port Search ]<br>
     * @param EesEqr1066ConditionVO condVO
     * @return  CommonRsVO
     * @exception DAOException
    */
	public CommonRsVO searchLoadingTrendByPortList(EesEqr1066ConditionVO condVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		Map<String, String> mapVO = condVO.getColumnValues();
		
//		if(!(condVO.getLane()).equals("")){//Lane 입력하였을 경우
//			condVO.setTrade("");
//			condVO.setSubtrade("");
//		}else if(!(condVO.getSubtrade()).equals("")){//Sub Trade 입력하였을 경우
//			condVO.setTrade("");
//		}
		
		if(!(condVO.getSubtrade()).equals("")){//Sub Trade 입력하였을 경우
			condVO.setTrade("");
		}		
		
		List arr_trd_cd 		= Utils.replaceStrToList(condVO.getTrade());
		List arr_sub_trd_cd 	= Utils.replaceStrToList(condVO.getSubtrade());
		List arr_lane 			= Utils.replaceStrToList(condVO.getLane());
		List arr_cntr_tpsz_cd	= Utils.replaceStrToList(condVO.getCntrTpszCd());
		
		param.putAll(mapVO);
		velParam.put("dt_tp_cd",condVO.getDtTpCd());
		velParam.put("fm_wk", condVO.getFmWk());
		velParam.put("to_wk", condVO.getToWk());
		velParam.put("eta_fm_dt", condVO.getEtaFmDt());
		velParam.put("eta_to_dt", condVO.getEtaToDt());
		velParam.put("rcc_cd", condVO.getRccCd());
		velParam.put("loc_tp_cd",condVO.getLocTpCd());
		velParam.put("loc_cd", condVO.getLocCd());
		velParam.put("vvd_cd", condVO.getVvdCd());
		velParam.put("trade", condVO.getTrade());
		velParam.put("subtrade", condVO.getSubtrade());
		velParam.put("lane", condVO.getLane());
		velParam.put("cntr_tpsz_cd",condVO.getCntrTpszCd());
		velParam.put("arr_trd_cd", arr_trd_cd);
		velParam.put("arr_sub_trd_cd", arr_sub_trd_cd);
		velParam.put("arr_lane", arr_lane);
		velParam.put("arr_cntr_tpsz_cd", arr_cntr_tpsz_cd);
		

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrAccuracyTrendDBDAOSearchLoadingTrendByPortListRSQL(), param, velParam);
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
     * [ EES_EQR_1026 :  Discharge Result ]
     * 화면 Loading시 기본 설정 데이터 조회
     * @param EesEqr1026ConditionVO condVO
     * @return  CommonVO
     * @exception DAOException
    */
	public CommonVO searchDischargeResultDefault(EesEqr1026ConditionVO condVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		Map<String, String> mapVO = condVO.getColumnValues();
		
		param.putAll(mapVO);
		CommonVO retVO = new CommonVO();
		String[] returnStr = new String[4];
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrAccuracyTrendDBDAOSearchDischargeResultDefaultRSQL(), param, param);
			while(dbRowset.next()) {
				 
				 if(dbRowset.getString("FM_WK")==null){
					 returnStr[0]="";
				 }else{
					 returnStr[0]=dbRowset.getString("FM_WK");
				 }
				 
				 if(dbRowset.getString("TO_WK")==null){
					 returnStr[1]="";
				 }else{
					 returnStr[1]=dbRowset.getString("TO_WK");
				 }
				 
				 if(dbRowset.getString("RCC_CD")==null){
					 returnStr[2]="";
				 }else{
					 returnStr[2]=dbRowset.getString("RCC_CD");
				 }
				 
				 if(dbRowset.getString("OFC_TP_CD")==null){
					 returnStr[3]="";
				 }else{
					 returnStr[3]=dbRowset.getString("OFC_TP_CD");
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
     * [ EES_EQR_1026 : Discharge Result Search List ]<br>
     * @param EesEqr1026ConditionVO condVO
     * @return  CommonRsVO
     * @exception DAOException
    */
	@SuppressWarnings("rawtypes")
	public CommonRsVO searchDischargeResultList(EesEqr1026ConditionVO condVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		Map<String, String> mapVO = condVO.getColumnValues();
		
//		if(!(condVO.getLane()).equals("")){//Lane 입력하였을 경우
//			condVO.setTrade("");
//			condVO.setSubtrade("");
//		}else if(!(condVO.getSubtrade()).equals("")){//Sub Trade 입력하였을 경우
//			condVO.setTrade("");
//		}
		
		if(!(condVO.getSubtrade()).equals("")){//Sub Trade 입력하였을 경우
			condVO.setTrade("");
		}			
		
		List arr_trd_cd 		= Utils.replaceStrToList(condVO.getTrade());
		List arr_sub_trd_cd 	= Utils.replaceStrToList(condVO.getSubtrade());
		List arr_lane 			= Utils.replaceStrToList(condVO.getLane());
		List arr_cntr_tpsz_cd	= Utils.replaceStrToList(condVO.getCntrTpszCd());
		
		param.putAll(mapVO);
		velParam.put("fm_wk", 			condVO.getFmWk());
		velParam.put("to_wk", 			condVO.getToWk());
		velParam.put("rcc_cd", 			condVO.getRccCd());
		velParam.put("loc_tp_cd",		condVO.getLocTpCd());
		velParam.put("loc_cd", 			condVO.getLocCd());
		velParam.put("vvd_cd", 			condVO.getVvdCd());
		velParam.put("trade", 			condVO.getTrade());
		velParam.put("subtrade", 		condVO.getSubtrade());
		velParam.put("lane", 			condVO.getLane());
		velParam.put("cntr_tpsz_cd",	condVO.getCntrTpszCd());
		velParam.put("arr_trd_cd", 		arr_trd_cd);
		velParam.put("arr_sub_trd_cd", 	arr_sub_trd_cd);
		velParam.put("arr_lane", 		arr_lane);
		velParam.put("arr_cntr_tpsz_cd",arr_cntr_tpsz_cd); 
		

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrAccuracyTrendDBDAOSearchDischargeResultListRSQL(), param, velParam);
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
	
}