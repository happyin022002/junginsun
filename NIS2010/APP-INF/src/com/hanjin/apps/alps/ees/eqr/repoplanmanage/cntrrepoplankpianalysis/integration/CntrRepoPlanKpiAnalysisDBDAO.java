/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoPlanKpiAnalysisDBDAO.java
*@FileTitle : 컨테이너 이송 계획 KPI 요약 조회
*Open Issues :
*Change history :
* No.	Ver.		Modifier           					modifier date    explanation
* 1		1.0		Se-Hoon Park					2006-11-01		1.0 최초 생성
* 2      	1.128  	chae chang ho    			2008.02.29       CSR No : N200801230019 - Forecasted Sea Inventory 화면 재개발
* 3      	1.130  	chae chang ho    			2008.05.19       project_name : 신규 장비(F5-40ft H/C Flat rack) 발주에 따른 NIS 상에 F5 등록
* 4      	1.131  	chae chang ho    			2008.06.25       CSR No : N200806030017 - Match-Back Performance Inquiry
* 5      	1.132  	chae chang ho    			2008.06.25       CSR No : R200807047819 - Match Back Performance Inquiry 조회 항목 추가
*                                                 					Match Back Performance Inquiry 수행시 Full,Empty수량을 구할시에 TRADE 조건을 추가가 하여 해당 TRADE 별 결과값이 옳게 가져오기 위한 조건 추가
* 6      	1.136  	Haeng-ji, Lee    			2009-04-03       CSR No : R200903240002 - Cntr Tpsz 자동화
* 7      	1.0     Lee Byoung Hun				2009.09.16		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.09.16
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.09.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.eqr.common.Constants;
import com.hanjin.apps.alps.ees.eqr.common.Utils;
import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.basic.CntrRepoPlanKpiAnalysisBCImpl;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.vo.EesEqr0071ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.vo.EesEqr0072ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.vo.EesEqr0074ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.vo.EesEqr0136ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.vo.GetForecastedSeaInventoryVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.vo.SearchCntrPlanKPISummaryVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS CntrRepoPlanKpiAnalysisDBDAO <br>
 * - ALPS-RepoPlanManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see CntrRepoPlanKpiAnalysisBCImpl 참조
 * @since J2EE 1.6
 */
public class CntrRepoPlanKpiAnalysisDBDAO extends DBDAOSupport {

	/**
	 * EES_EQR_0071Event ()의 조회주차 차이 값을 불러온다.<br>
	 * 
	 * @param fmPlnYrWk String
	 * @param toPlnYrWk String
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	public CommonRsVO searchWeekTerm(String fmPlnYrWk, String toPlnYrWk) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO rsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String data [] = new String[2];
		
		try{
			param.put("fmPlnYrWk", fmPlnYrWk);
			param.put("toPlnYrWk", toPlnYrWk);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanKpiAnalysisDBDAOGetWeekTermRSQL(), param, velParam);
			
			if (dbRowset.next()) {
				data[0] = dbRowset.getString("TERM");
				data[1] = dbRowset.getString("CHECKYRWK");
			}
			
			rsVO.setResultStrArray(data);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVO;
	}
	
	/**
	 * EES_EQR_0071Event ()의 조회주차 first dt 값을 불러온다.<br>
	 * 
	 * @param fmPlnYrWk String
	 * @param toPlnYrWk String
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	public CommonRsVO searchWeekFirstDt(String fmPlnYrWk, String toPlnYrWk) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO rsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String[] result = new String[1];
		StringBuffer data = new StringBuffer();
		int j = 0;
		
		try{
			param.put("fmPlnYrWk", fmPlnYrWk);
			param.put("toPlnYrWk", toPlnYrWk);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanKpiAnalysisDBDAOGetWeekFirstDateRSQL(), param, velParam);
			
			while (dbRowset.next()) {
				data.append(((j == 0) ? "" : "/") + "'"+ dbRowset.getString ("WK_ST_DT") + "'" );
				j++;
			} 
			result[0] = data.toString();
			
			rsVO.setResultStrArray(result);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVO;
	}
	
	/**
	 * EES_EQR_0071Event<br>
	 * 
	 * @param fmPlnYrWk String
	 * @param toPlnYrWk String
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	public CommonRsVO searchWeekStr(String fmPlnYrWk, String toPlnYrWk) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO rsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		StringBuffer rtnStr = new StringBuffer();
		StringBuffer rtnStr_1 = new StringBuffer();
		String [] rtn = new String[2];
		int j = 0;
		
		try{
			param.put("fmPlnYrWk", fmPlnYrWk);
			param.put("toPlnYrWk", toPlnYrWk);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanKpiAnalysisDBDAOGetWeekStrRSQL(), param, velParam);
			
			while (dbRowset.next()) {
				rtnStr.append(((j == 0) ? "" : ",") + dbRowset.getString("YRWK")); 
				rtnStr_1.append(((j == 0) ? "" : ",") + dbRowset.getString("YRWK_1")); 
	      		j++;
			} 
			
			rtn[0] = rtnStr.toString();
			rtn[1] = rtnStr_1.toString();
			
			rsVO.setResultStrArray(rtn);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVO;
	}
	
	/**
	 * 컨테이너 이송 계획 KPI 요약 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO EesEqr0071ConditionVO 
	 * @return List<SearchCntrPlanKPISummaryVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchCntrPlanKPISummaryVO> searchCntrRepoPlanKPISummary(EesEqr0071ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCntrPlanKPISummaryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = conditionVO .getColumnValues();
			String repo_pln_id = Constants.REPO_WORD+conditionVO.getYyyyww()+Constants.REPO_WEEK+conditionVO.getSeq();
			String [] data = new String [1];
			String [] rtn = new String [2];
			String weekStrArr_1[] = null;
			ArrayList arrMtyPerfStr = new ArrayList();
			ArrayList arrAtEccCd = (ArrayList) Utils.replaceStrToList(conditionVO.getEcccd());
			String prefFrom = conditionVO.getPerffmplnyr() + conditionVO.getPerffmplnwk();
			String prefTo = conditionVO.getPerftoplnyr() + conditionVO.getPerftoplnwk();
			String plnFrom = conditionVO.getPlnfmplnyr() + conditionVO.getPlnfmplnwk();
			String plnTo = conditionVO.getPlntoplnyr() + conditionVO.getPlntoplnwk();
			String weekStrArr_1_0 = "";
			String weekStrArr_1_1 = "";
			String weekStrArr_1_2 = "";
			
			if ("0".equals(conditionVO.getRadioopr())) {//perf
				//조회주차의 term 조회.
				data = searchWeekTerm(prefFrom, prefTo).getResultStrArray();
				rtn = searchWeekStr(prefFrom, prefTo).getResultStrArray();
				//조회주차의 첫날 조회(pref)
				String [] perfData = searchWeekFirstDt(prefFrom, prefTo).getResultStrArray();
				if(perfData.length > 0){
					String[] arrStr = perfData[0].split("/");
					for(int k = 0; k < arrStr.length; k++ ){
						arrMtyPerfStr.add(arrStr[k]);
					}
				}
			} else {//pln
				//조회주차의 term 조회.
				data = searchWeekTerm(plnFrom, plnTo).getResultStrArray();
				rtn = searchWeekStr(plnFrom, plnTo).getResultStrArray();
			}
			weekStrArr_1 = rtn[1].toString().split(",");// 전주차
			
			weekStrArr_1_0 = weekStrArr_1[0];
			if(weekStrArr_1.length >= 2){
				weekStrArr_1_1 = weekStrArr_1[1];
			}
			if(weekStrArr_1.length >= 3){
				weekStrArr_1_2 = weekStrArr_1[2];
			}
		
			param.putAll(mapVO);
			param.put("repo_pln_id", repo_pln_id);
			param.put("data0", data[0]);
			param.put("prefFrom", prefFrom);
			param.put("prefTo", prefTo);
			param.put("plnFrom", plnFrom);
			param.put("plnTo", plnTo);
			param.put("weekStrArr_1_0", weekStrArr_1_0);
			param.put("weekStrArr_1_1", weekStrArr_1_1);
			param.put("weekStrArr_1_2", weekStrArr_1_2);
			
			velParam.putAll(mapVO);
			velParam.put("prefFrom", prefFrom);
			velParam.put("prefTo", prefTo);
			velParam.put("plnFrom", plnFrom);
			velParam.put("plnTo", plnTo);
			velParam.put("weekStrArrSize", weekStrArr_1.length);
			velParam.put("arrAtEccCd", arrAtEccCd);
			velParam.put("arrMtyPerfStr", arrMtyPerfStr);
			
			if ("0".equals(conditionVO.getRadioopr())) {//perf
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanKpiAnalysisDBDAOSearchCntrPlanKPISummaryPrefRSQL(), param, velParam);
			} else {//pln
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanKpiAnalysisDBDAOSearchCntrPlanKPISummaryPlnRSQL(), param, velParam);
			}
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCntrPlanKPISummaryVO .class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	 /**
	  * Forecasted M/B 조회 이벤트 처리<br>
	  * 
	  * @param conditionVO EesEqr0136ConditionVO
	  * @return List<GetForecastedSeaInventoryVO>
	  * @exception DAOException
	  */
	@SuppressWarnings("unchecked")
	public List<GetForecastedSeaInventoryVO> searchForecastedSeaInventory(EesEqr0136ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<GetForecastedSeaInventoryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			String repo_pln_Id = Constants.REPO_WORD+conditionVO.getYyyyww()+Constants.REPO_WEEK+conditionVO.getSeq();
			String fmPlnYrwk = conditionVO.getFmplnyr() + conditionVO.getFmplnwk();
			String toPlnYrwk = conditionVO.getToplnyr() + conditionVO.getToplnwk();
			ArrayList arrFmEccCd = (ArrayList) Utils.replaceStrToList(conditionVO.getFmecccd());
			ArrayList arrVvd = (ArrayList) Utils.replaceStrToList(conditionVO.getVvd1());
			ArrayList arrVslSlanCd = (ArrayList) Utils.replaceStrToList(conditionVO.getVslslancd());
		
			param.put("repo_pln_Id", repo_pln_Id);
			param.put("fmPlnYrwk", fmPlnYrwk);
			param.put("toPlnYrwk", toPlnYrwk);
			
			velParam.put("fmtype", conditionVO.getFmtype());
			velParam.put("arrFmEccCd", arrFmEccCd);
			velParam.put("arrVvd", arrVvd);
			velParam.put("arrVslSlanCd", arrVslSlanCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanKpiAnalysisDBDAOGetForecastedSeaInventoryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, GetForecastedSeaInventoryVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * EES_EQR_0074Event<br>
	 * 
	 * @param conditonVO EesEqr0074ConditionVO
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	public CommonRsVO searchKPILoadFactor(EesEqr0074ConditionVO conditonVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO rsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String fr_Week   = conditonVO.getFrYyyy() + conditonVO.getFrWeek();
		String to_Week   = conditonVO.getToYyyy() + conditonVO.getToWeek();
		
		String locType    = conditonVO.getLoctype();   
	
	
		try{
			
			String locList  =Utils.convertStr(conditonVO.getLoclist()) ; 
			String lane     = Utils.convertStr(conditonVO.getLane()) ;       
			String  vvd      = Utils.convertStr(conditonVO.getVvd()) ;	
			String trade      =Utils.convertStr(conditonVO.getTrade()) ;
		   
			log.debug("lane" + lane);
			
		    param.put("fr_week" ,fr_Week);
			param.put("to_week", to_Week);
			velParam.put("loccd", locList);
			velParam.put("loctype", locType);
			velParam.put("lane", lane);
			velParam.put("vvd" ,vvd);
			velParam.put("trade", trade);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanKpiAnalysisDBDAOSearchKPILoadFactorRSQL(), param, velParam);
			rsVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVO;
	}
	
	/**
	 * EES_EQR_0074Event<br>
	 * 
	 * @param conditonVO EesEqr0074ConditionVO
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	public CommonRsVO searchKPIVesselUtilization(EesEqr0074ConditionVO conditonVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO rsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String fr_Week   = conditonVO.getFrYyyy() + conditonVO.getFrWeek();
		String to_Week   = conditonVO.getToYyyy() + conditonVO.getToWeek();
		
		String locType    = conditonVO.getLoctype();   
		String locList  =Utils.convertStr(conditonVO.getLoclist()) ; 
		String lane     = Utils.convertStr(conditonVO.getLane()) ;       
		String  vvd      = Utils.convertStr(conditonVO.getVvd()) ;	
		String trade      =Utils.convertStr(conditonVO.getTrade()) ;
	  
	
		try{
		    param.put("fr_week" ,fr_Week);
			param.put("to_week", to_Week);
			velParam.put("loccd", locList);
			velParam.put("loctype", locType);
			velParam.put("lane", lane);
			velParam.put("vvd" ,vvd);
			velParam.put("trade", trade);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanKpiAnalysisDBDAOSearchKPIVesselUtilizationRSQL(), param, velParam);
			rsVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVO;
	}
	/**
     * CntrRepoPlanKpiAnalysis의 Forecasted M/B 정보 조회
     * 
     * @param conditonVO EesEqr0072ConditionVO
     * @return CommonRsVO
     * @exception DAOException
    */
	public CommonRsVO searchForecastedMatchBackInfo(EesEqr0072ConditionVO conditonVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO rsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//REPO_ID---------------------------------
		//String repo_pln_Id = Constants.REPO_WORD + conditonVO.getYyyyww()+ Constants.REPO_WEEK + conditonVO.getSeq();	
		
    	String report   	= conditonVO.getReport();
    	//String company     	= conditonVO.getCompany();
 		String locOrTrade  	= conditonVO.getLocortrade();

    	String fmPlnYr   	= conditonVO.getFmplnyr();
    	String fmPlnWk     	= conditonVO.getFmplnwk();
 		String toPlnYr  	= conditonVO.getToplnyr();
 		String toPlnWk  	= conditonVO.getToplnwk();

		//String typeStr    	= "";
    	String atStatus   	= conditonVO.getAtstatus();
    	String atLocation  	= conditonVO.getAtlocation();
 		String byLocation  	= conditonVO.getBylocation();
 		
    	//String ts     		= event.getTs();

		// Trace
    	String trade   		= conditonVO.getTrade();
		String arrTradeStr	= Utils.convertStr(trade, true); 
		// Lane
		String vslSlanCd    = conditonVO.getLane();
		String arrVslSlanCdStr = Utils.convertStr(vslSlanCd, true); 
		// VVD
		String vvd      = conditonVO.getVvd();
		String arrVvdStr = Utils.convertStr(vvd, true); 
		
		//조회주차
//		String fmPlnYrWk = fmPlnYr + fmPlnWk;
//		String toPlnYrWk = toPlnYr + toPlnWk;
	
		String fmPlnYrWk = fmPlnYr + fmPlnWk;  // fm이 큰 주차이기 때문에  조회를 값을 바꾸어 대입한다.
		String toPlnYrWk = toPlnYr + toPlnWk;
		
		String fromEccArrStr 	= "";
		String toEccArrStr	 	= "";
		String eccArrStr		= "";
		try{
			if("1".equals(locOrTrade)){	
		    	// from loc 검색조건
		    	if(!atStatus.equals("") && !atLocation.trim().equals("")) {
		    		fromEccArrStr = Utils.convertStr(atLocation, true); 
		    	}
		    	   
		    	// to loc 검색조건
		    	if(!atStatus.equals("") && !atLocation.trim().equals("")) {
		    		toEccArrStr = Utils.convertStr(atLocation, true); 
		    	}
		
		    	// ecc loc 검색조건
		    	if(!atStatus.equals("") && !atLocation.trim().equals("")) {
		    		eccArrStr = Utils.convertStr(atLocation, true); 
		    	}
			}
		    param.put("fmPlnYrWk" ,fmPlnYrWk);
			param.put("toPlnYrWk", toPlnYrWk);
			velParam.put("atStatus", atStatus);
			velParam.put("atLocation", atLocation);
			velParam.put("locOrTrade", locOrTrade);
			velParam.put("report", report);
			velParam.put("fmPlnYr", fmPlnYr);
			velParam.put("fmPlnWk", fmPlnWk);
			velParam.put("toPlnYr", toPlnYr);
			velParam.put("toPlnWk", toPlnWk);
			velParam.put("byLocation", byLocation);
			velParam.put("trade", trade);
			velParam.put("arrTradeStr", arrTradeStr);
			velParam.put("vslSlanCd", vslSlanCd);
			velParam.put("arrVslSlanCdStr", arrVslSlanCdStr);
			velParam.put("vvd", vvd);
			velParam.put("arrVvdStr", arrVvdStr);
			velParam.put("fmPlnYrWk" ,fmPlnYrWk);
			velParam.put("toPlnYrWk", toPlnYrWk);
			//velParam.put("typeStr", typeStr);
			velParam.put("fromEccArrStr", fromEccArrStr);
			velParam.put("toEccArrStr", toEccArrStr);
			velParam.put("eccArrStr", eccArrStr);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanKpiAnalysisDBDAOSearchForecastedMatchBackInfoRSQL(), param, velParam);
			rsVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVO;
	}
}