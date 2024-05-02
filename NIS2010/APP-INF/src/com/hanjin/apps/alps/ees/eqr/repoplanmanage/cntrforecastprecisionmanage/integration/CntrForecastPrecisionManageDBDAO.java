/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrForecastPrecisionManageDBDAO.java
*@FileTitle : MTY Rail Arrival Inquiry
*Open Issues :
*Change history :
*-----------------------------------------------------------------------------
*	No.		Ver.	Modifier		Modifier Date		Explanation
*-----------------------------------------------------------------------------
*					chae chang ho	2007-11-13			CSR No : R200711054305 - Based on  1st Week와 4 weeks Ago 로 반영 (현재는 4주전 Forcast와 실적 비교)
*					chae chang ho	2008-05-19			Project_name :신규 장비(F5-40ft H/C Flat rack) 발주에 따른 NIS 상에 F5 등록
* 					Haeng-ji, Lee   2009-05-18			CSR No : R200905150001 - 컨테이너 타입사이즈 조건을 All, Dry 이외의 항목으로 조회했을 때의 에러수정
*-----------------------------------------------------------------------------
*@LastModifyDate : 2009.10.07
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.10.07 
* 1.0 Creation
* =======================================================
* 2011.06.13 나상보 [CHM-201111518-01] [EQR]  MTY Rail Trans. 화면의 CNTR List 조회 기능 추가
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrforecastprecisionmanage.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.eqr.common.Utils;
import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.ForecastAccuracyListVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrforecastprecisionmanage.basic.CntrForecastPrecisionManageBCImpl;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrforecastprecisionmanage.vo.EesEqr0037ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrforecastprecisionmanage.vo.MtyRailConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrforecastprecisionmanage.vo.MtyRailDetailVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS CntrForecastPrecisionManageDBDAO <br>
 * - ALPS-RepoPlanManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Haeng-ji,Lee
 * @see CntrForecastPrecisionManageBCImpl 참조
 * @since J2EE 1.6
 */
public class CntrForecastPrecisionManageDBDAO extends DBDAOSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5286258241547689347L;

	/**
	 * [EES_EQR_0141 : MTY Rail Arrival Inquiry }<br>
	 * 
	 * @param MtyRailConditionVO mtyRailConditionVO
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	public CommonRsVO searchMtyRailArrival(MtyRailConditionVO mtyRailConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mtyRailConditionVO != null){
				Map<String, String> mapVO = mtyRailConditionVO .getColumnValues();
				
				String tpszText =  Utils.convertStr(mtyRailConditionVO.getTpsztype());
				ArrayList<Integer> arrday = new ArrayList<Integer>();
				int diff_date = Integer.parseInt(mtyRailConditionVO.getDiffDate());
				
				for( int i=0; i <= diff_date; i++){
					arrday.add(i);
				}
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("tpszText", tpszText);
				velParam.put("arrday", arrday);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrForecastPrecisionManageDBDAOSearchMtyRailArrivalRSQL(), param, velParam);
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
	 * [EES_EQR_0141 : MTY Rail Arrival Inquiry }<br>
	 * 
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	public CommonRsVO searchMtyRailArrivalUSTime() throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String usTime ="";
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrForecastPrecisionManageDBDAOSearchMtyRailArrivalUStimeRSQL(), param, velParam);
			if(dbRowset.next()){
			usTime =dbRowset.getString("CURRENT_TIME").trim();
			}
			commonRsVO.setResultString(usTime);
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
	 * [EES_EQR_0142 : MTY Rail Trans Result }<br>
	 * 
	 * @param MtyRailConditionVO mtyRailConditionVO
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	public CommonRsVO searchMtyRailResult(MtyRailConditionVO mtyRailConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mtyRailConditionVO != null){
				Map<String, String> mapVO = mtyRailConditionVO .getColumnValues();
			
				List<String> arrtpsz = Utils.replaceStrToList(mtyRailConditionVO.getTpsztype());
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("arrtpsz", arrtpsz);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrForecastPrecisionManageDBDAOSearchMtyRailResultRSQL(), param, velParam);
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
	 * 컨테이너 수급 예측실적 및 정확도 조회 이벤트 처리<br>
	 * 
	 * @param EesEqr0037ConditionVO conditionVO
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CommonRsVO searchCntrForecastPerformance(EesEqr0037ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO rsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = conditionVO .getColumnValues();
			
			//조회주차 4주전 주차 알아오기.
			String wkResult[] = null;
			if("1".equals(conditionVO.getFmtoat())) {
				if(!"".equals(conditionVO.getFmfmplnyr())){
					wkResult = searchWeekBefore4Wk(
							conditionVO.getFmfmplnyr()+conditionVO.getFmfmplnwk()
							, conditionVO.getFmtoplnyr()+conditionVO.getFmtoplnwk()).getResultStrArray();
				}else{
					wkResult = searchWeekBefore4Wk(
							conditionVO.getTofmplnyr()+conditionVO.getTofmplnwk()
							, conditionVO.getTotoplnyr()+conditionVO.getTotoplnwk()).getResultStrArray();
				}
			}else{
				wkResult = searchWeekBefore4Wk(
						conditionVO.getAtfmplnyr()+conditionVO.getAtfmplnwk()
						, conditionVO.getAttoplnyr()+conditionVO.getAttoplnwk()).getResultStrArray();
			}
			
			String[] bef4Wk = wkResult[0].split(",");
			String[] cur4Wk = wkResult[1].split(",");
			
			//DEMAND FORECAST 일 경우 조회주차 4주전 SCNR_WK 알아오기.
			String scnrWkResult[] = null;
			String[] scnr4Wk =new String[bef4Wk.length];
			
			if("D".equals(conditionVO.getDataselect1()) || "D".equals(conditionVO.getDataselect2())) {
				scnrWkResult = searchScnrWk(wkResult[0]).getResultStrArray();
				scnr4Wk = scnrWkResult[0].split(",");
			}
			
			// velParam에 세팅해주기 위한 데이터 작성
			ArrayList arrWkResult = new ArrayList();
			ArrayList wk = null;
			for (int i = 0; i < bef4Wk.length; i++) {
				wk = new ArrayList();
				wk.add(bef4Wk[i]);
				wk.add(cur4Wk[i]);
				wk.add(scnr4Wk[i]);
				wk.add(searchAfter4Wk(cur4Wk[i] , 4).getResultString());
				arrWkResult.add(wk);
			}
			
			ArrayList arrFmEccCd = (ArrayList) Utils.replaceStrToList(conditionVO.getFmecccd());
			ArrayList arrToEccCd = (ArrayList) Utils.replaceStrToList(conditionVO.getToecccd());
			ArrayList arrAtEccCd = (ArrayList) Utils.replaceStrToList(conditionVO.getAtecccd());
			ArrayList arrCntrTpszCd = (ArrayList) Utils.replaceStrToList(conditionVO.getCntrtpszcd());
			
			velParam.putAll(mapVO);
			velParam.put("arrWkResult", arrWkResult);
			velParam.put("arrFmEccCd", arrFmEccCd);
			velParam.put("arrToEccCd", arrToEccCd);
			velParam.put("arrAtEccCd", arrAtEccCd);
			velParam.put("arrCntrTpszCd", arrCntrTpszCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrForecastPrecisionManageDBDAOSearchCntrForecastPerformanceRSQL(), param, velParam);
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
	 * EES_EQR_0037Event ()의 조회주차  4주 전주차 값을 불러온다.<br>
	 * 
	 * @param fmPlnYrWk
	 * @param toPlnYrWk
	 * @return
	 * @exception DAOException
	 */
	public CommonRsVO searchWeekBefore4Wk(String fmPlnYrWk, String toPlnYrWk) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO rsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		StringBuffer data_bef = new StringBuffer();
		StringBuffer data_cur = new StringBuffer();

		try{
			param.put("fmPlnYrWk", fmPlnYrWk);
			param.put("toPlnYrWk", toPlnYrWk);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrForecastPrecisionManageDBDAOSearchWeekBefore4WkRSQL(), param, velParam);
			
			int j = 0;
			String result [] = new String[2];
			while (dbRowset.next()) {
				data_bef.append(((j == 0) ? "" : ",") + dbRowset.getString ("YRWK_BEF"));
				data_cur.append(((j == 0) ? "" : ",") + dbRowset.getString ("YRWK_CUR"));
				j++;
			}
			
			result[0] = data_bef.toString();
			result[1] = data_cur.toString();
			
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
	 * EES_EQR_0037Event ()의 DEMAND FORECAST 조회시 조회주차  4주전 SCNR WK 값을 불러온다.<br>
	 * 
	 * @param bef4Wk
	 * @return
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CommonRsVO searchScnrWk(String bef4Wk) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO rsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		StringBuffer data_scnrWk = new StringBuffer();

		try{
			ArrayList bef4WkArr = (ArrayList) Utils.replaceStrToList(bef4Wk);
			velParam.put("bef4WkArr", bef4WkArr);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrForecastPrecisionManageDBDAOSearchScnrWkRSQL(), param, velParam);
			
			String result [] = new String[1];
			
			while (dbRowset.next()) {
				for(int k = 0; k < bef4WkArr.size(); k++){
					data_scnrWk.append(((k == 0) ? "" : ","));
					if ("".equals(dbRowset.getString (k+1))) {
						data_scnrWk.append("null");
					} else {
						data_scnrWk.append(dbRowset.getString (k+1));
					}
				}
			} 
			
			result[0] = data_scnrWk.toString();
			
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
	 * EES_EQR_0037Event ()의 해당주차를 입력시  조회주차  4주후 WEEK정보를 가져 온다.<br>
	 * 
	 * @param bef4Wk
	 * @param gap
	 * @return
	 * @exception DAOException
	 */
	public CommonRsVO searchAfter4Wk(String bef4Wk , int gap) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO rsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String result = "";

		try{
			param.put("bef4Wk", bef4Wk);
			param.put("gap", String.valueOf(gap));
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrForecastPrecisionManageDBDAOSearchAfterWeekRSQL(), param, velParam);
			
			if (dbRowset.next()) {
				result = dbRowset.getString("WEEK");
			} 
			
			rsVO.setResultString(result);
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
	 * [EES_EQR_0141 : MTY Rail Arrival Inquiry }<br>
	 * 
	 * @param MtyRailConditionVO mtyRailConditionVO
	 * @return List<MtyRailDetailVO>
	 * @exception DAOException
	 */
	public List<MtyRailDetailVO> searchMtyRailArrivalDetail(MtyRailConditionVO mtyRailConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MtyRailDetailVO> list = new ArrayList<MtyRailDetailVO>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mtyRailConditionVO != null){
				Map<String, String> mapVO = mtyRailConditionVO.getColumnValues();
				
				String tpszText =  Utils.convertStr(mtyRailConditionVO.getTpsztype());

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("tpszText", tpszText);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrForecastPrecisionManageDBDAOSearchMtyRailArrivalDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MtyRailDetailVO .class);
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
	 * [EES_EQR_0142 : MTY Rail Trans Result }<br>
	 * 
	 * @param MtyRailConditionVO mtyRailConditionVO
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	public List<MtyRailDetailVO> searchMtyRailResultDetail(MtyRailConditionVO mtyRailConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MtyRailDetailVO> list = new ArrayList<MtyRailDetailVO>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mtyRailConditionVO != null){
				Map<String, String> mapVO = mtyRailConditionVO .getColumnValues();
			
				List<String> arrtpsz = Utils.replaceStrToList(mtyRailConditionVO.getTpsztype());
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("arrtpsz", arrtpsz);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrForecastPrecisionManageDBDAOSearchMtyRailResultDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MtyRailDetailVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) { 
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
}