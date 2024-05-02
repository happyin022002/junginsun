/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : CommonDBDAO.java
 *@FileTitle : Common
 *Open Issues :
 *Change history :
*@LastModifyDate : 
*@LastModifier :  
*@LastVersion : 1.0
 =========================================================*/

package com.clt.apps.opus.ees.eqr.cntrcommon.eqrcommon.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.eqr.cntrcommon.Utils;
import com.clt.apps.opus.ees.eqr.cntrcommon.eqrcommon.basic.CommonBCImpl;
import com.clt.apps.opus.ees.eqr.cntrcommon.eqrcommon.event.EesCommonEvent;
import com.clt.apps.opus.ees.eqr.cntrcommon.eqrcommon.vo.CommonVO;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.integration.CommonDBDAOSearchTradeRSQL;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.EqrCommonVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 *opus-Common Business Logic<br>
 * 
 * @author 
 * @see CommonBCImpl 
 * @since J2EE 1.4
 */

public class CommonDBDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = 1L;
	
	private String strDs = "";
	public CommonDBDAO() {}
	/**
	 * @param strDs String
	 */
	public CommonDBDAO(String strDs) {
		//super(strDs);
		this.strDs = strDs;
	}
	
	/**
	 * Lane List<br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked") 
	public DBRowSet searchSLaneComboList(HashMap params) throws DAOException {
		DBRowSet dRs = null; 
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
	
	/**
	 * Trade List <br>
	 * 
	 * @param params
	 * @return DBRowSet
	 * @throws DAOException 
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchTradeComboList(HashMap params) throws DAOException {
		DBRowSet dRs = null; 
		
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
	 * Trade List. <br>
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
		
		if(multi_trdCd != null && !multi_trdCd.equals("")){		
			multi_trdCd = "'"+multi_trdCd.replaceAll(",", "','")+"'";
			params.put("trdCd", multi_trdCd);

			if ( params.get("trdCd") != null && !params.get("trdCd").equals("")) {
				velParam.put("trdCd", multi_trdCd);	// SHKIM 
			}

		}	
		if(multi_subTrdCd != null && !multi_subTrdCd.equals("")){		
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
	 * eqr_wk_prd 
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
	 * VSL, INLAND(WATER) EXECUTE ROW YARD 
	 * @param ecc
	 * @param vslCd
	 * @param skdVoyNo
	 * @param skdDirCd
	 * @return CommonVO
	 * @throws DAOException
	 */
	public CommonVO searchLocVesselYardInitialInfo(String ecc, String vslCd, String skdVoyNo, String skdDirCd) throws DAOException {
		
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

			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOSearchLocVesselYardInitialInfoRSQL(), param, velParam);

			rowcount = dbRowset.getRowCount(); 
						
			if(rowcount > 1) { 
				while(dbRowset.next()) {
					inStr.append( ((j == 0) ? "" : "|") + dbRowset.getString("YD_CD").replaceAll("&","&amp;")+" \t " + dbRowset.getString("YD_NM").replaceAll("&","&amp;"));   // NAME
					inStr1.append(((j == 0) ? "" : "|") + dbRowset.getString("YD_CD"));                                                               // CODE 
					j++;
				}
			}else { 
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
	 * LOC Yard(vessel) combo box <br>
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

		if(locyard_searchword.length() > 5) {			
			locyard_searchword = locyard_searchword.substring(0,5);
		}

		try {
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
	 * week 
	 * ex) nextNum = 1
	 *     nextNum = 2
	 * ex) direction --> NEXT 
	 *     direction --> PREV 
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
		String result 	     = null;
								
		try {
			param.put("yyyyww", yyyyww);
			param.put("nextNum", nextNum);
			velParam.put("direction", direction);
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOGetNextPrevWeekRSQL(), param, velParam);
			
			while (dbRowset.next()){
				result = dbRowset.getString ("WEEK");
				break;
			}
			if(result != null) {
				retVO.setResultString(result);
			}

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
	 * Trade 조회
	 * 
	 * @return List<EqrCommonVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked" })
	public List<EqrCommonVO> searchTradeList() throws DAOException {
		 
		DBRowSet dbRowset = null;
		List<EqrCommonVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		try {
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchTradeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EqrCommonVO.class);
			
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
		return list;
	}
	
}