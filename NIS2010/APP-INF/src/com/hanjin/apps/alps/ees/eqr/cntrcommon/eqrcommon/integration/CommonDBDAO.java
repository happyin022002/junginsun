/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : CommonDBDAO.java
 *@FileTitle : Common
 *Open Issues :
 *Change history :
*@LastModifyDate : 2013-05-27
*@LastModifier :  SHIN DONG IL
*@LastVersion : 1.0
* 2013-05-27  SHIN DONG IL
* 1.0 Creation
 =========================================================*/

package com.hanjin.apps.alps.ees.eqr.cntrcommon.eqrcommon.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.eqr.cntrcommon.Utils;
import com.hanjin.apps.alps.ees.eqr.cntrcommon.eqrcommon.basic.CommonBCImpl;
import com.hanjin.apps.alps.ees.eqr.cntrcommon.eqrcommon.event.EesCommonEvent;
import com.hanjin.apps.alps.ees.eqr.cntrcommon.eqrcommon.vo.CommonVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil; 
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * alps-Common에 대한 DB 처리를 담당<br> - alps-Common Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author SHIN DONG IL
 * @see CommonBCImpl 참조
 * @since J2EE 1.4
 */

public class CommonDBDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = 1L;
	
	private String strDs = "";
	public CommonDBDAO() {}
	/**
	 * modified : R200803265677 :XA JDBC Driver 적용 및 WTC Application 적용
	 * @param strDs String
	 */
	public CommonDBDAO(String strDs) {
		//super(strDs);
		this.strDs = strDs;
	}
	
	/**
	 * Lane List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked") 
	public DBRowSet searchSLaneComboList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		

		String locSubTrdCd 	= params.get("locSubTrdCd")==null?"":((String[])params.get("locSubTrdCd"))[0];
		String locTrdCd 	= params.get("locTrdCd")   ==null?"":((String[])params.get("locTrdCd"))[0];
		
		List arrTrdCd = Utils.replaceStrToList(locTrdCd);
		List arrSubTrdCd = Utils.replaceStrToList(locSubTrdCd);
		
		
		try {

			if(!locTrdCd.equals("")){
				param.put("locSubTrdCd", locTrdCd);
				param.put("arrTrdCd", arrTrdCd);
				velParam.put("locTrdCd", locTrdCd);
				velParam.put("arrTrdCd", arrTrdCd);
			}
			
			if(!locSubTrdCd.equals("")){
				param.put("locSubTrdCd", locSubTrdCd);
				param.put("arrSubTrdCd", arrSubTrdCd);
				velParam.put("locSubTrdCd", locSubTrdCd);
				velParam.put("arrSubTrdCd", arrSubTrdCd);
			}

			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSLaneComboListRSQL(), param, velParam);
				
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return dRs;
	}	
	
//	/**
//	 * HashMap에 있는 key값을 조회한다.<br>
//	 * 
//	 * @param param
//	 * @param key
//	 * @param idx
//	 * @return String
//	 */
//	@SuppressWarnings("unchecked")
//	private String getParameterValue(HashMap param, String key, int idx) {
//		String[] strs = ((String[]) param.get(key));
//		if (strs == null)
//			return "";
//		if (strs.length <= idx)
//			return "";
//		return strs[idx];
//	}
//
//	/**
//	 * HashMap에 있는 key값을 조회한다.<br>
//	 * 
//	 * @param param
//	 * @param key
//	 * @return String
//	 */
//	@SuppressWarnings("unchecked")
//	private String getParameterValue(HashMap param, String key) {
//		return getParameterValue(param, key, 0);
//	}
	
	/**
	 * Trade List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException 
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchTradeComboList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {

			param.putAll(params);
			velParam.putAll(params);

			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchTradeComboListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return dRs;
	}	

	/**
	 * Trade List를 조회한다. <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException 
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchSubTradeComboList(HashMap params) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String multi_trdCd = "";
		if ( params.get("trdCd") == null ) {
			multi_trdCd = "";
		} else {
			multi_trdCd = params.get("trdCd").toString();
		}
		String multi_subTrdCd = "";
		if ( params.get("multi_subTrdCd") == null ) {
			multi_subTrdCd = "";
		} else {
			params.get("subTrdCd").toString();
		}
		
		if(multi_trdCd != null && !multi_trdCd.equals("")){		// =포함 in 조건조회로 수정
			multi_trdCd = "'"+multi_trdCd.replaceAll(",", "','")+"'";
			params.put("trdCd", multi_trdCd);

			if ( params.get("trdCd") != null && !params.get("trdCd").equals("")) {
				velParam.put("trdCd", multi_trdCd);	// SHKIM 
			}

		}	
		if(multi_subTrdCd != null && !multi_subTrdCd.equals("")){		// =포함 in 조건조회로 수정
			multi_subTrdCd = "'"+multi_subTrdCd.replaceAll(",", "','")+"'";
			params.put("subTrdCd", multi_subTrdCd);
		}	

		try {
			param.putAll(params);
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSubTradeComboListRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return dRs;
	}	
	
	/**
	 * eqr_wk_prd 에서 현재 일자에 대한 주차정보를 조회한다.
	 * 
	 * @param
	 * @return CommonVO getResultString()
	 * @exception DAOException
	 */
	public CommonVO todayWeekly() throws DAOException {		
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		String todayWeekly = "";
		
		try {
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOTodayWeeklyRSQL(), null, null);
			
			if (dbRowset.next()) {
				todayWeekly = dbRowset.getString(1);
			}			 
			retVO.setResultString(todayWeekly);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return retVO;
	}	
	
	/**
	 * VSL, INLAND(WATER)의 EXECUTE ROW 생성하면서 YARD 정보를 검색
	 * item --> VSL(059)           = 'V'
	 *          INLAND(WATER)(080) = 'W' + VVD 입력한 경우
	 *          COMBINED(108)      = 'V'
	 *          COMBINED(108)      = 'W' + VVD 입력한 경우
	 * @param ecc
	 * @param vslCd
	 * @param skdVoyNo
	 * @param skdDirCd
	 * @param tmp
	 * @return CommonVO
	 * @throws DAOException
	 */
	public CommonVO searchLocVesselYardInitialInfo(String ecc, String vslCd, String skdVoyNo, String skdDirCd, String tmp) throws DAOException {
		
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();		
		Map<String, Object> param = new HashMap<String, Object>();    //query parameter		
		Map<String, Object> velParam = new HashMap<String, Object>(); //velocity parameter
		
		String[] result     = new String[2];
		StringBuffer inStr  = new StringBuffer();
		StringBuffer inStr1	= new StringBuffer();
		
		int j			= 0;
		int rowcount    = 0;
		
		try {
			
    		param.put("ecc", ecc);
			param.put("vslCd", vslCd);
			param.put("skdVoyNo", skdVoyNo);
			param.put("skdDirCd", skdDirCd);
			velParam.put("tmp", tmp); 

			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOSearchLocVesselYardInitialInfoRSQL(), param, velParam);

			// row가 몇개인지확인 (1개이면  CODE 만 가져감, 2개이상이면 CODE-NAME, CODE 로 가져감)
			// 1개는 dtData, 2개 이상은 dtCombo형식으로 표현함(중요)
			rowcount = dbRowset.getRowCount(); 
						
			if(rowcount > 1) { // 검색결과 2개 이상
				while(dbRowset.next()) {
					inStr.append( ((j == 0) ? "" : "|") + dbRowset.getString("YD_CD").replaceAll("&","&amp;")+" \t " + dbRowset.getString("YD_NM").replaceAll("&","&amp;"));   // NAME
					inStr1.append(((j == 0) ? "" : "|") + dbRowset.getString("YD_CD"));                                                               // CODE 
					j++;
				}
			}else { // 검색결과 1 이거나 없거나
				while(dbRowset.next()) {
					inStr.append(((j == 0) ? "" : "|") + dbRowset.getString("YD_CD"));   
					j++;
				}			
			}
			
			result[0] = inStr.toString();
			result[1] = inStr1.toString();			
			retVO.setResultStrArray(result);
				
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		
		return retVO;
	}
	
	/**
	 * LOC Yard(vessel) combo box 정보를 검색<br>
	 * 059에서 사용
	 * @param locyard_searchword
	 * @return CommonVO getResultStrArray()
	 * @see EesCommonEvent
	 * @exception DAOException	 
	*/
	public CommonVO searchLocYardVesselInfo(String locyard_searchword) throws DAOException {
		
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();	
		
		String[] result     = new String[2];
		StringBuffer inStr  = new StringBuffer();	
		StringBuffer inStr1	= new StringBuffer();
		
		int j			= 0;
		String delt_flg = "Y";
		
		
		// 5개 이상인 경우 잘라서 표현
		if(locyard_searchword.length() > 5) {			
			locyard_searchword = locyard_searchword.substring(0,5);
		}

		try {
			
			log.debug("BC 20 searchLocYardVesselInfo======");
			param.put("locyard_searchword", locyard_searchword + "%");
			param.put("delt_flg", delt_flg);
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOSearchLocYardVesselInfoRSQL(), param, null);
			
			while(dbRowset.next()) {
				inStr.append( ((j == 0) ? "" : "|") + dbRowset.getString("YD_CD").replaceAll("&","&amp;")+" \t " + dbRowset.getString("YD_NM").replaceAll("&","&amp;"));   // NAME
				inStr1.append(((j == 0) ? "" : "|") + dbRowset.getString("YD_CD"));                                                               // CODE
				j++;
			}
			
			result[0] = inStr.toString();
			result[1] = inStr1.toString();		
			retVO.setResultStrArray(result);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		
		return retVO;
	}	
	
	/**
	 * 기준 week의 다음주(nextNum) 정보를 가져옵니다.
	 * ex) nextNum = 1 --> 기준주의 1주 다음
	 *     nextNum = 2 --> 기준주의 2주 다음
	 * ex) direction --> NEXT : 미래주차
	 *     direction --> PREV : 과거주차
	 *     
	 * @param yyyyww
	 * @param nextNum
	 * @param direction
	 * @return CommonVO getResultString() String nextWeek
	 * @exception DAOException
	 */
	public CommonVO getNextPrevWeek(String yyyyww ,int nextNum, String direction) throws DAOException {
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		// 2015.02.25 CHM-201534210 EQR 소스 보안
		String result 	     = new String();
								
		try {
			param.put("yyyyww", yyyyww);
			param.put("nextNum", nextNum);
			velParam.put("direction", direction);
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOGetNextPrevWeekRSQL(), param, velParam);
			
			while (dbRowset.next()){
				result = dbRowset.getString ("WEEK");
				break;
			}
			retVO.setResultString(result);
//			log.debug("\n-------------------->0000 result : "+result );
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		
		return retVO;
	}		
	
	/**
	 * LOC Yard 가 사용해도 되는것인지 확인
	 * 
	 * @param locyard String
	 * @param ecc String
	 * @return CommonVO getResultString()
	 * @exception DAOException
	 */
	public CommonVO searchLocYardExist(String locyard, String ecc) throws DAOException {
		
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String result   = "";
		
		log.debug("------------------- COMMON DB DAO");
		try {
			param.put("locyard", locyard);
			param.put("ecc", ecc);
			velParam.put("ecc", JSPUtil.getNull(ecc));
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOCheckExistLocYardRSQL(), param, velParam);
			
			while(dbRowset.next()) {
				result = dbRowset.getString("YD_CD");				
			}
			retVO.setResultString(result);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		
		return retVO;
	}	
	
}