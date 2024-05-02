/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : COACommonDBDAO.java
 *@FileTitle : COA업무 공틍 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-09-18
 *@LastModifier : eunju park
 *@LastVersion : 1.0
 =========================================================*/
package com.clt.apps.opus.esm.coa.common.integration;

import java.sql.SQLException;
import java.sql.Statement;									//SJH.20140818.ADD
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.coa.common.event.CodeInfo;
import com.clt.apps.opus.esm.coa.common.vo.AverageCostVO;
import com.clt.apps.opus.esm.coa.common.vo.BkgSokeupVO;		//SJH.20140818.ADD
import com.clt.apps.opus.esm.coa.common.vo.CommonCoaRsVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchSimNoDescVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.CoaUtCostCreStsVO;

/**
 * OPUS-COA에 대한 DB 처리를 담당<br> - OPUS-COA Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * 2017.01.11 ESM_COA_4013 method : searchYrWkDu, createOperationDays 삭제처리. Defect 소스와 싱크를 맞춤. 
 * 
 * 
 * @author eunju park
 * @see  
 * @since J2EE 1.4
 */
public class CommonDBDAO extends DBDAOSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7068940161299277066L;

	/**
	 * S.Lane의 목록을 가져온다.<br>
	 * MDM_VSL_SVC_LANE
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchSVCLaneList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
			velParam.put("methodname", "searchSVCLaneList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
			} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
		
	}

	/**
	 * service lane의 정보를 가져온다.<br>
	 * MDM_REV_LANE
	 * 
	 * @param trd_cd
	 *            String
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchSLaneList(String trd_cd) throws DAOException {		
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter

		try {
			if(trd_cd != null){
				param.put("trd_cd"    ,trd_cd);
				velParam.put("methodname", "searchSLaneList");
			}
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
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
	 * Trade콤보의 목록을 가져온다.<br>
	 * MDM_TRADE
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchTradeList() throws DAOException {
		
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체		
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
				velParam.put("methodname", "searchTradeList");
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
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
	 * Sub Trade 정보를 가져온다.<br>
	 * MDM_SUB_TRD
	 * 
	 * @param trd_cd
	 *            String
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchSubTradeList(String trd_cd) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
		
				param.put("trd_cd" ,trd_cd);
				velParam.put("methodname", "searchSubTradeList");
	
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
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
	 * Sub Trade 정보를 중복없이 가져온다.<br>
	 * MDM_SUB_TRD
	 * 
	 * @param trd_cd
	 *            String
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 * @author SJH.20141224.ADD
	 */
	public DBRowSet searchSubTradeList2(String trd_cd) throws DAOException { 
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {				
				param.put("trd_cd" ,trd_cd);
				velParam.put("methodname", "searchSubTradeList2");
	
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
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
	 * SMU Sub Trade 정보를 가져온다.<br>
	 * MDM_SUB_TRD
	 * 
	 * @param trd_cd
	 *            String
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchSMUSubTradeList(String trd_cd) throws DAOException {		
		
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
			if(trd_cd != null){
				param.put("trd_cd"    ,trd_cd);
				velParam.put("methodname", "searchSMUSubTradeList");
			}
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
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
	 * COA_VSL_SUB_TRADE 목록을 가져온다.<br>
	 * 
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchVSLSubTradeList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter

		try {
			velParam.put("methodname", "searchVSLSubTradeList");	
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
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
		return dRs;
	}

	/**
	 * revenue lane의 정보를 가져온다.<br>
	 * COA_LANE_RGST
	 * 
	 * @param trd_cd
	 *            String
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchRevLaneList(String trd_cd) throws DAOException {
		
		String[] sTrd = null;		
		
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체

		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		String strTrdCd = "";
		String strSubTrdCd = "";		
		sTrd = trd_cd.split(":", -1);
		
		strTrdCd = sTrd[0];
		
		if (sTrd.length > 1) {
			strSubTrdCd = sTrd[1];
		} else {
			strSubTrdCd = "";
		}		
		try {
			if(trd_cd != null){
				param.put("str_trd_cd"    ,strTrdCd);
				param.put("str_sub_trd_cd",strSubTrdCd);
				velParam.put("methodname", "searchRevLaneList");
			}
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
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
	 * revenue lane의 정보를 가져온다.<br>
	 * COA_LANE_RGST
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchRevLaneList2() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체		
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
			velParam.put("methodname", "searchRevLaneList2");			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
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
	 * revenue lane의 정보를 가져온다.<br>
	 * COA_LANE_RGST
	 * 
	 * @param  String trd_cd
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchRLaneList(String trd_cd) throws DAOException {
		
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체		
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
				param.put("trd_cd"    ,trd_cd);
				velParam.put("methodname", "searchRLaneList");
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
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
	 * Port Class 목록을 조회한다..<br>
	 * COA_VSL_RGST
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchVesselClassList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		

		try {
			velParam.put("methodname", "searchVesselClassList");			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);

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
		return dRs;
	}

	/**
	 * VESSEL CAPA 목록을 조회한다..<br>
	 * COA_VSL_RGST
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchVslCapaList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체		
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
				velParam.put("methodname", "searchVslCapaList");
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
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
	 * Vessel콤보의 목록을 가져온다.<br>
	 * COA_VSL_RGST
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchVesselList() throws DAOException {
		
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체		
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
				velParam.put("methodname", "searchVesselList");
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
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
	 * Vessel콤보의 목록을 가져온다.<br>
	 * COA_VSL_RGST
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchOwnVesselList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter		
		
		try {
			velParam.put("methodname", "searchOwnVesselList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
	}	

	/**
	 * Vessel콤보의 목록을 가져온다.<br>
	 * COA_VSL_RGST
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchChtVesselList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter			

		try {
			velParam.put("methodname", "searchChtVesselList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
			} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
	}
    
	/**
	 * 화물변동비 항목을 가져온다.<br>
	 * COA_MN_GRP_COST, COA_SUB_GRP_COST
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchSIMCostItem() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter

		try {
			velParam.put("methodname", "searchSIMCostItem");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
	}
	
	/**
	 * COA Main Group 항목을 가져온다.<br>
	 * COA_MN_GRP_COST
	 * 
	 * @param code
	 *            String
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */	
	public DBRowSet searchMNGRPCostList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter	

		try {
			param.put("code", code);
			velParam.put("methodname", "searchMNGRPCostList");
			velParam.put("code", code);
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
			} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
	}

	/**
	 * COA Sub Group 항목을 가져온다.<br>
	 * COA_SUB_GRP_COST
	 * 
	 * @param code
	 *            String
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchSubGRPCostList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter	

		try {
			param.put("code", code);
			velParam.put("code", code);
			velParam.put("methodname", "searchSubGRPCostList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
			} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
	}

	//
	/**
	 * 현재주보다 작은 주를 반환한다.<br>
	 * COA_WK_PRD
	 * 
	 * @param year
	 *            String
	 * @param week
	 *            String
	 * @return String (06/53)
	 * @throws DAOException
	 */
	public String searchPreWeek(String year, String week) throws DAOException {
		
		String result = "";
		DBRowSet dbRowSet = null;
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
			
		try {
				param.put("year"    ,year);
				param.put("week"    ,week);
				velParam.put("methodname", "searchPreWeek");
				
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
			if (dbRowSet != null) {
				while (dbRowSet.next()) {
					result = dbRowSet.getString(1);
				}
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return result;		
	}

	/**
	 * 검색 조건에 맞는 DatePriod을 가져온다.<br> - 입력파라메터의 경우의 수 1. Year, Month 2. Year, Week 3. Year, Month, Week : Week가 우선권을
	 * 가진다. 4. Year, FromMonth, ToMonth 5. Year, FromWeek, ToWeek 6. Year, FromMonth, ToMonth, FromWeek, ToWeek
	 * 
	 * @param SearchConditionVO vo
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchDatePeriod(SearchConditionVO vo) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		String year = vo.getFYear();
		String month = vo.getFYearmonth();
		String week = vo.getFYearweek();
		String frmweek = vo.getFFmWk();
		String frmmonth = vo.getFFmMon();
		String toweek = vo.getFToWk();
		String tomonth = vo.getFToMon();
		String gubun ="";
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter	
		
		try {

			year = (year != null) ? year : "";
			month = (month != null) ? month : "";
			week = (week != null) ? week : "";
			frmweek = (frmweek != null) ? frmweek : "";
			frmmonth = (frmmonth != null) ? frmmonth : "";
			toweek = (toweek != null) ? toweek : "";
			tomonth = (tomonth != null) ? tomonth : "";
			gubun ="";
			if(vo != null){
			 
				if(!year.equals("") && !month.equals("") && !week.equals("")) {
				gubun = "1";
			}else if (!year.equals("") && !month.equals("")) {
				gubun = "2";
			} else if (!year.equals("") && !week.equals("")) {
				gubun = "3";
			}
			 if(!year.equals("") && !frmmonth.equals("") && !tomonth.equals("") && !frmweek.equals("") && !toweek.equals("")) {
				gubun = "4";
			}else if (!year.equals("") && !frmmonth.equals("") && !tomonth.equals("")) {
				gubun ="5";
			}else if(!year.equals("") && !frmweek.equals("") && !toweek.equals("")) {				
				gubun = "6";
			}
			param.put("year"    ,year);
			param.put("month"    ,month);
			param.put("week"    ,week);
			param.put("frmweek"    ,frmweek);
			param.put("frmmonth"    ,frmmonth);
			param.put("toweek"    ,toweek);
			param.put("tomonth"    ,tomonth);
			velParam.put("methodname", "searchDatePeriod");				
			velParam.put("gubun", gubun);
			
			log.debug("\n\n\ngubun==["+gubun+"]\n\n\n");
			}		
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
		
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
	 * Rcc 의 목록을 가져온다.<br>
	 * view : coa_location_v(mdm_location, mdm_eq_orz_cht)
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchRccList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter	

		try { 
			 velParam.put("methodname", "searchRccList");						
			 dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;

	}

	/**
	 * LCC의 목록을 가져온다.<br>
	 * view : coa_location_v(mdm_location, mdm_eq_orz_cht)
	 * 
	 * @param code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchLccList(String code) throws DAOException {		
		
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter		
		
			try {
				if(code != null){
					velParam.put("methodname", "searchLccList");
					velParam.put("code", code);
					param.put("code"    ,code);
				}
				
				dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
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
	 * ECC의 목록을 가져온다.<br>
	 * view : coa_location_v(mdm_location, mdm_eq_orz_cht)
	 * 
	 * @param code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchEccList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		try {
			
			if(!code.equals("")){
				String[] value = code.split("[|]");
				param.put("rcc_cd"    ,value[0]);
				param.put("lcc_cd"    ,value[1]);
			}
			velParam.put("code"    ,code);
			velParam.put("methodname", "searchEccList");
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
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
	 * EMU Simulated Cost 계산시 사용 되는 POD ECC의 목록을 가져온다.(Port ECC만)<br>
	 * mdm_location, mdm_eq_orz_cht	  
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchPodEccList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
			velParam.put("methodname", "searchPodEccList");	
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
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
		return dRs;
	}

	/**
	 * SCC의 목록을 가져온다.<br>
	 * view : coa_location_v(mdm_location, mdm_eq_orz_cht)
	 * 
	 * @param code
	 *            String
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchSccList(String code) throws DAOException {
		
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter		
			
			try {
				if(code != null){
					param.put("code"    ,code);
					velParam.put("methodname", "searchSccList");
				}
				
				dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
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
	 * Location Code 목록을 가져온다.<br>
	 * view : coa_location_v(mdm_location, mdm_eq_orz_cht)
	 * 
	 * @param code
	 *            String
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchLocList(String code) throws DAOException {
		
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity paramete
		String[] value = code.split("[|]");
		
		try {
			param.put("param1"    ,value[1].toUpperCase());
			velParam.put("param0"    ,value[0].toUpperCase());		
			velParam.put("methodname", "searchLocList");
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
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
	 * 지역본부 단위의 Office Code 목록을 조회한다..<br>
	 * MDM_ORGANIZATION
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchOFCHQList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity paramete

		try {
			velParam.put("methodname", "searchOFCHQList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
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
		return dRs;
	}

	/**
	 * 컨테이너 Type Size 목록을 조회한다..<br>
	 * COA_SPCL_REPO_CNTR_RGST
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchTpSzList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		try {
			velParam.put("methodname", "searchTpSzList");			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam); 			

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
		return dRs;
	}

	/**
	 * 컨테이너 Reposition Flag가 Y인 Type Size 목록을 조회한다..<br>
	 * COA_SPCL_REPO_CNTR_RGST [EQ Reposition Contribution 메뉴에서 사용하는 Type size]
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchEQRepoTpSzList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		try {
			velParam.put("methodname", "searchEQRepoTpSzList");			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam); 			

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
		return dRs;
	}

	/**
	 * Currency 목록을 조회한다..<br>
	 * MDM_CURRENCY
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchCurrencyList() throws DAOException {
		
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체		
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
				velParam.put("methodname", "searchCurrencyList");
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
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
	 * Commodity List 목록을 조회한다..<br>
	 * MDM_REP_CMDT
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchRepCMDTList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter

		try {
			velParam.put("methodname", "searchRepCMDTList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);

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
		return dRs;
	}

	/**
	 * 공통코드에서 목록을 조회한다..<br>
	 * COM_INTG_CD_DTL
	 * 
	 * @param code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchCommonCodeList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity paramete
		
		try {
			
			param.put("code"    ,code);
			velParam.put("methodname", "searchCommonCodeList");
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
		
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
		return dRs;
	}

	/**
	 * Report Item Infomation 목록을 조회한다..<br>
	 * COA_RPT_ITM_INFO_MST
	 * 
	 * @param code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchReportItem(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter		
			
			try {
				if(code != null){
					param.put("code"    ,code);
					velParam.put("methodname", "searchReportItem");
				}
				
				dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
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
	 * Regional Headquarter: RHQ 목록을 조회한다..<br>
	 * MDM
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchRHQList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter	

		try { 
			velParam.put("methodname", "searchRHQList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
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
		return dRs;
	}

	/**
	 * Report Authority 목록을 조회한다..<br>
	 * COA_RPT_AUTH_MGMT, COM_INTG_CD_DTL
	 * 
	 * @param code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchRPTAuthList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter	
		Map<String, Object> param = new HashMap<String, Object>();//velocity parameter	

		try {
			String[] ofc_lvl = code.split("[|]");
			param.put("ofclvl0", ofc_lvl[0]);
			param.put("ofclvl1", ofc_lvl[1]);
			velParam.put("methodname", "searchRPTAuthList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
			
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
		return dRs;
	}
	
	/**
	 * office Level List 목록을 조회한다..<br>
	 * COA_RPT_AUTH_MGMT
	 * 
	 * @param code
	 *            (office level)
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchOFCLevelList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter		

		try {
			if(code != null){
				param.put("code"    ,code);
				velParam.put("methodname", "searchOFCLevelList");
			}
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
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
	 * 선택한 office Level에 해당하는 office code목록을 조회한다..<br>
	 * coa_ofc_lvl
	 * 
	 * @param code (usr_ofc_cd|usr_ofc_lvl|selected ofc_lvl|cost_yrmon)
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchSubOFCList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter		
			
			try {
				if(code != null){
					
					String[] ofc = code.split("[|]");//0:usr_ofc_cd, 1:usr_ofc_lvl, 2:selected ofc_lvl, 3:cost_yrmon
					
					String usr_ofc_cd = ofc[0];
					String usr_ofc_lvl = ofc[1];
					String sel_ofc_lvl = ofc[2];
					String cost_yr = ofc[3];
					String cost_mon = ofc[4];
					
					param.put("usr_ofc_cd"    ,usr_ofc_cd);
					param.put("usr_ofc_lvl"    ,usr_ofc_lvl);
					param.put("sel_ofc_lvl"    ,sel_ofc_lvl);
					param.put("cost_yr"    ,cost_yr);
					param.put("cost_mon"    ,cost_mon);
					
					velParam.put("methodname", "searchSubOFCList");
					velParam.put("usr_ofc_cd", usr_ofc_cd);
					velParam.put("usr_ofc_lvl", usr_ofc_lvl);
					velParam.put("cost_yr", Integer.parseInt(cost_yr));
					velParam.put("cost_mon", Integer.parseInt(cost_yr));
				}
				
				dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
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
	 * VVD에 해당하는 etd date를 리턴한다.<br>
	 * vsk_vsl_port_skd
	 * 
	 * @param String vsl_cd
	 * @param String skd_voy_no
	 * @param String skd_dir_cd
	 * @return String 처리 결과
	 * @throws DAOException
	 */
	public String searchFirstEtd(String vsl_cd, String skd_voy_no, String skd_dir_cd) throws DAOException {
		String result = "";
		DBRowSet dbRowSet = null;
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter

		try {
				param.put("vsl_cd"    ,vsl_cd);
				param.put("skd_voy_no"    ,skd_voy_no);
				param.put("skd_dir_cd"    ,skd_dir_cd);
				velParam.put("methodname", "searchFirstEtd");				
			
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
			if (dbRowSet != null) {
				while (dbRowSet.next()) {
					result = dbRowSet.getString("etd_dt");
				}
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return result;
	}

	/**
	 * 전주를 구한다.<br>
	 * 
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public String searchPrevWkPrd() throws DAOException {
		String result = "";
		DBRowSet dbRowSet = null;

		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
				velParam.put("methodname", "searchPrevWkPrd");
				
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
			if (dbRowSet != null) {
				while (dbRowSet.next()) {
					result = dbRowSet.getString("cost_wk");
				}
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return result;		
	}
	
	/**
	 * 전주를 구한다.<br>
	 * 
	 * @return DBRowSet
	 * @throws DAOException
	 * @author SJH.20150102.ADD
	 */
	public String[] searchPrevWkPrdYW() throws DAOException {
		String result[] = {"",""};
		DBRowSet dbRowSet = null;

		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
				velParam.put("methodname", "searchPrevWkPrd");
				
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
			if (dbRowSet != null) {
				while (dbRowSet.next()) {
					result[0] = dbRowSet.getString("cost_yr");		//년도가 바뀐경우를 대비하여 년도도 가져와야함.
					result[1] = dbRowSet.getString("cost_wk");
				}
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return result;		
	}			
	
	/**
	 * office code에 해당하는 Level를 리턴한다.<br>
	 * COA_GET_OFC_LEVEL
	 * 
	 * @param ofc_cd
	 * @return String 처리 결과
	 * @throws DAOException
	 */
	public String searchOFCLevel(String ofc_cd) throws DAOException {
		String result = "";
		DBRowSet dbRowSet = null;
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
				param.put("ofc_cd"    ,ofc_cd);
				velParam.put("methodname", "searchOFCLevel");
				
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
			if (dbRowSet != null) {
				while (dbRowSet.next()) {
					result = dbRowSet.getString("ofc_level");
				}
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return result;		
	}
		
	/**
	 * Parent가 HQ Level이고 해당 office가 HQ 직속이라면(ofc kind : 2) HQ의 level 부여됨  <br>
	 * 특정조건에 만족하는 경우 office code에 변경하여 반환한다.
	 * (HQ 산하의 조직이면서 Area가 아닌경우 HQ레벨의 office code를 리턴한다.)
	 * 
	 * @param ofc_cd
	 * @return String 처리 결과
	 * @throws DAOException
	 */
	public String searchChgOffice(String ofc_cd) throws DAOException {
		String result = "";
		DBRowSet dbRowSet = null;
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
				param.put("ofc_cd"    ,ofc_cd);
				velParam.put("methodname", "searchChgOffice");
				
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
			if (dbRowSet != null) {
				while (dbRowSet.next()) {
					result = dbRowSet.getString("prnt_ofc_cd");
				}
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return result;		
	}

	/**
	 * Booking Number 유무를 확인.<br>
	 * 
	 * @param bkg_no String
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet checkBKGNo(String bkg_no) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter		
			
			try {
				if(!bkg_no.equals("")){
					param.put("bkgno"    ,bkg_no);
					velParam.put("methodname", "checkBKGNo");
				}
				
				dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
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
	 * Location Code 유무를 확인.<br>
	 * 
	 * @param loc_cd String
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet checkLocationCode(String loc_cd) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter		
			
			try {
				if(!loc_cd.equals("")){
					param.put("loccd"    ,loc_cd);
					velParam.put("methodname", "checkLocationCode");
				}
				
				dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
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
	 * Vessel Code 유무를 확인.<br>
	 * 
	 * @param vsl_cd String
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet checkVesselCode(String vsl_cd) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter		
			
			try {
				if(!vsl_cd.equals("")){
					param.put("vslcd"    ,vsl_cd);
					velParam.put("methodname", "checkVesselCode");
				}
				
				dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
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
	 * VVD Code 유무를 확인.<br>
	 * 
	 * @param vsl_cd
	 * @param skd_voy_no
	 * @param dir_cd
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet checkVVDCode(String vsl_cd, String skd_voy_no, String dir_cd) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter		
			
			try {
				if(!vsl_cd.equals("")){
					param.put("vslcd"       ,vsl_cd);
					param.put("skdvoyno"    ,skd_voy_no);
					param.put("skddircd"    ,dir_cd);
					velParam.put("methodname", "checkVVDCode");
				}
				
				dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
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
	 * Office Code 유무를 확인.<br>
	 * 
	 * @param ofc_cd
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet checkOfficeCode(String ofc_cd) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter		
			
			try {
				if(!ofc_cd.equals("")){
					param.put("ofc_cd"    ,ofc_cd);
					velParam.put("methodname", "checkOfficeCode");
				}
				
				dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
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
	 * Revenue Lane Code 유무를 확인.<br>
	 * 
	 * @param rlane_cd
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet checkRevLaneCode(String rlane_cd) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter		
			
			try {
				if(!rlane_cd.equals("")){
					param.put("rlanecd"    ,rlane_cd);
					velParam.put("methodname", "checkRevLaneCode");
				}
				
				dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
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
	 * Port or Node Code 유무를 확인.<br>
	 * 
	 * @param tml_cd String
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet checkNodeCode(String tml_cd) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter		

		try {
			if(!tml_cd.equals("")){
				param.put("tmnlcd"    ,tml_cd);
				velParam.put("methodname", "checkNodeCode");
			}
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
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
	 * Service Lane Code 유무를 확인.<br>
	 * 
	 * @param slane_cd
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet checkSLaneCode(String slane_cd) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter		


		try {
			if(!slane_cd.equals("")){
				param.put("slancd"    ,slane_cd);
				velParam.put("methodname", "checkSLaneCode");
			}
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);

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
	 * Direction 항목을 세팅한다.<br>
	 * 
	 * @return Collection
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public Collection setDirList() throws DAOException {
		Collection codeList = new ArrayList();

		try {
			codeList.add(new CodeInfo("E", "E"));
			codeList.add(new CodeInfo("W", "W"));
			codeList.add(new CodeInfo("S", "S"));
			codeList.add(new CodeInfo("N", "N"));

			log.debug(" setDirList() END ");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return codeList;
	}

	/**
	 * Interport/Ocean 항목을 세팅한다.<br>
	 * 
	 * @return Collection
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public Collection setIOCList() throws DAOException {
		Collection codeList = new ArrayList();

		try {
			codeList.add(new CodeInfo("I", "I"));
			codeList.add(new CodeInfo("O", "O"));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return codeList;
	}

	/**
	 * Vessel lane type 항목을 세팅한다.<br>
	 * 
	 * @return Collection
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public Collection setLaneTPList() throws DAOException {
		Collection codeList = new ArrayList();

		try {
			codeList.add(new CodeInfo("JO", "JO"));
			codeList.add(new CodeInfo("SC", "SC"));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return codeList;
	}

	/**
	 * RA Main Group 항목을 가져온다.<br>
	 * com_intg_cd_dtl
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchRAMainGroupList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
			velParam.put("methodname", "searchRAMainGroupList");			
		dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
			} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
	}

	/**
	 * RA Sub Group 항목을 가져온다.<br>
	 * com_intg_cd_dtl
	 * 
	 * @param  String code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchRASubGroupList(String code) throws DAOException {

		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
			param.put("code", code);
			velParam.put("code", code);
			velParam.put("methodname", "searchRASubGroupList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
	}

	/**
	 * COA_STND_ACCT에서 비용항목을 가져온다.<br>
	 * 36. Standard Cost Code : StndCost
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchStndCostList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			velParam.put("methodname", "searchStndCostList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());		
		}
		return dRs;
	}

	/**
	 * PRD_COST_ACT_GRP에서 활동그룹항목을 가져온다.<br>
	 * 41. activity group code : actgrp
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchActGrpList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			velParam.put("methodname", "searchActGrpList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
	}

	/**
	 * mdm_county에서 국가코드항목을 가져온다.<br>
	 * 41. country group code : cnt
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchCntList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			velParam.put("methodname", "searchCntList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
	}

	/**
	 * LOC코드의 ECC를 가져온다.<br>
	 * view : coa_location_v(mdm_location, mdm_eq_orz_cht)
	 * 
	 * @param code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchLoc2EccList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("code", code);
			velParam.put("code", code);
			velParam.put("methodname", "searchLoc2EccList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);		
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
	}

	/**
	 * Cost Srouce Code를 가져온다..<br>
	 * 45. Cost Source Code : srcCd(stnd_cost_cd)<br>
	 * 
	 * @param code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchCostSourceCodeList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter

		try {
			param.put("code", code);
			velParam.put("code", code);
			velParam.put("methodname", "searchCostSourceCodeList");	
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
			} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
	}

	/**
	 * Terminal Triff Detail Codeㄹ를 가져온다<br>
	 * 46. TML Trf Dtl Code : tmlTrfCd <br>
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
//	COA_INTER_TML_IF_MGMT table 삭제에 의한 처리	
	/*
	public DBRowSet searchTerminalTriffDetailcList() throws DAOException {
		Connection con = null; // Connection Interface
		PreparedStatement ps = null; // 정적파싱을 지원하는 SQL Statement
		ResultSet rs = null; // DB ResultSet
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체

		String queryStr = "\n SELECT DISTINCT RPAD(tml_cd, 7, '#') || RPAD(expn_acct_cd, 8, '#') || RPAD(tml_trf_itm_cd, 4, '#') || RPAD(tml_trf_dtl_cd, 4, '#') code"
			+ "\n                , RPAD(tml_cd, 7, '#') || RPAD(expn_acct_cd, 8, '#') || RPAD(tml_trf_itm_cd, 4, '#') || RPAD(tml_trf_dtl_cd, 4, '#') NAME"
			+ "\n            FROM coa_inter_tml_if_mgmt"
			//+ "\n FROM coa_tml_trf_grp"
			+ "\n        ORDER BY RPAD(tml_cd, 7, '#') || RPAD(expn_acct_cd, 8, '#') || RPAD(tml_trf_itm_cd, 4, '#') || RPAD(tml_trf_dtl_cd, 4, '#')"
			;

		try {
			con = getConnection();
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				ps = new LoggableStatement(con, queryStr);
			} else {
				ps = con.prepareStatement(queryStr);
			}

			// Loggable Statement 사용에 의해 추가
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				log.info("\n searchTerminalTriffDetailcList SQL :\n" + ((LoggableStatement) ps).getQueryString());
			} else {
				log.info("\n searchTerminalTriffDetailcList SQL :\n" + queryStr);
			}

			rs = ps.executeQuery();

			// 결과를 DBRowset에 담는다.
			dRs = new DBRowSet();
			dRs.populate(rs);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
			closeConnection(con);
		}
		return dRs;
	}
	*/

	/**
	 * Terminal Code를 가져온다<br>
	 * tmlCd : coa_inter_tml_if_mgmt 테이블의 terminal 코드 <br>
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
//	COA_INTER_TML_IF_MGMT table 삭제에 의한 처리
	/*
	public DBRowSet searchTerminalCodeList() throws DAOException {
		Connection con = null; // Connection Interface
		PreparedStatement ps = null; // 정적파싱을 지원하는 SQL Statement
		ResultSet rs = null; // DB ResultSet
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체

		String queryStr = "\n SELECT DISTINCT tml_cd code " 
				+ "\n       ,tml_cd name "
				+ "\n FROM coa_inter_tml_if_mgmt " 
				+ "\n ORDER BY tml_cd ";
		try {
			con = getConnection();
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				ps = new LoggableStatement(con, queryStr);
			} else {
				ps = con.prepareStatement(queryStr);
			}

			// Loggable Statement 사용에 의해 추가
			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
				log.info("\n searchTerminalCodecList SQL :\n" + ((LoggableStatement) ps).getQueryString());
			} else {
				log.info("\n searchTerminalCodecList SQL :\n" + queryStr);
			}

			rs = ps.executeQuery();

			// 결과를 DBRowset에 담는다.
			dRs = new DBRowSet();
			dRs.populate(rs);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
			closeConnection(con);
		}
		return dRs;
	}
	*/

	/**
	 * Stndard Cost code를 가져온다..<br>
	 * 50. coaCode<br>
	 * 
	 * @param code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchCoaCodeList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
			
		try {	
				String[] arrTmp = null;
				arrTmp = code.split(",");							
				for(int i = 0; i < arrTmp.length; i++){
					param.put("code"+i    ,arrTmp[i]);
					velParam.put("code"+i, arrTmp[i]);
				}
				velParam.put("methodname", "searchCoaCodeList");
				
				dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
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
	 * 공통코드에서 Lobistics KPI 항목을 가져온다.<br>
	 * lgsKPI
	 * 
	 * @param code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchLogisticsKpiList(String code) throws DAOException {
		
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		try {
			param.put("code", code);
			velParam.put("code", code);
			velParam.put("methodname", "searchLogisticsKpiList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
	}
	
	/**
	 * Cost Srouce Code/Stnd Code를 가져온다..<br>
	 * 58. Cost Srouce Code/Stnd Code<br>
	 * 
	 * @param code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchCostSourceCodeStndCodeList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
			param.put("code", code);
			velParam.put("code", code);
			velParam.put("methodname", "searchCostSourceCodeStndCodeList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
	}

	/**
	 * 컨테이너 Reposition Flag가 Y인 Type Size 목록을 조회한다..<br>
	 * costTableTpsz Cost Table 메뉴에서 사용하는 Type size RD4 ->R4, RD2 -> R2로
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchCostTableCntrTpszList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter

		try {
			velParam.put("methodname", "searchCostTableCntrTpszList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
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
		return dRs;
	}

	/**
	 * key account 항목을 가져온다.<br>
	 * MDM_CUSTOMER
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchKeyAccountList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
			velParam.put("methodname", "searchKeyAccountList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
			} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
	}
	
	/**
	 * logistics 에서 사용하는 RHQ 목록을 조회한다..<br>
	 * LOGISTICT RHQ       : lgsRHQ (logistics 에서 사용하는 RHQ)
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchLogisticsRhqCode() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
			velParam.put("methodname", "searchLogisticsRhqCode");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
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
		return dRs;
	}
	
	/**
	 * logistics 에서 사용하는 Office 목록을 조회한다..<br>
	 * LOGISTICT RHQ       : lgsOFC (logistics 에서 사용하는 Office)
	 * 
	 * @param code RHQ CODE
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchLogisticsOfficeCode(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		
		try {
			param.put("code", code);
			velParam.put("code", code);
			velParam.put("methodname", "searchLogisticsOfficeCode");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
			
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
		return dRs;
	}	

	/**
	 * 환율 변환
	 * 
	 * @param cost_yrmon
	 * @param locl_curr_cd
	 * @param lcl_amt
	 * @return usd_amt
	 * @throws DAOException
	 */
	public float getUSDAmt(String cost_yrmon, String locl_curr_cd, float lcl_amt) throws DAOException {
		float result = 0;
		DBRowSet dbRowSet = null;
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
				param.put("cost_yrmon"    ,cost_yrmon);
				param.put("locl_curr_cd"    ,locl_curr_cd);
				param.put("lcl_amt"    ,lcl_amt);	
				velParam.put("methodname", "getUSDAmt");
			
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
			if (dbRowSet != null) {
				while (dbRowSet.next()) {
					result = dbRowSet.getFloat(1);
				}
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return result;
	}	
	/**
	 * 환율 변환
	 * 
	 * @param cost_yrmon
	 * @param locl_curr_cd
	 * @param lcl_amt
	 * @return usd_amt
	 * @throws DAOException
	 */
	public float getUSDAmt2(String cost_yrmon, String locl_curr_cd, float lcl_amt) throws DAOException {
		float result = 0;
		DBRowSet dbRowSet = null;
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
				param.put("cost_yrmon"    ,cost_yrmon);
				param.put("locl_curr_cd"    ,locl_curr_cd);
				param.put("lcl_amt"    ,lcl_amt);	
				velParam.put("methodname", "getUSDAmt2");
			
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
			if (dbRowSet != null) {
				while (dbRowSet.next()) {
					result = dbRowSet.getFloat(1);
				}
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return result;
	}	

	/**
	 * Location Code를 이용해서 Office Code를 반환한다
	 * 
	 * @param loc_cd
	 * @return String 처리 결과
	 * @throws DAOException
	 */
	public String searchLocationToOffice(String loc_cd) throws DAOException {
		//ResultSet rs = null; // DB ResultSet
		String result = "";
		DBRowSet dbRowSet = null;
		
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
			param.put("loc_cd"    ,loc_cd);
			velParam.put("methodname", "searchLocationToOffice");
			
		dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
		if (dbRowSet != null) {
			while (dbRowSet.next()) {
				result = dbRowSet.getString(1);
			}
		}
	} catch(SQLException se){
		log.error(se.getMessage(),se);
		throw new DAOException(new ErrorHandler(se).getMessage());			
	} catch(Exception ex){
		log.error(ex.getMessage(),ex);			
		throw new DAOException(new ErrorHandler(ex).getMessage());
	}

	return result;		
}

	
	/**
	 * 컨테이너 Type Size 목록을 조회한다..<br>
	 * COA_SPCL_REPO_CNTR_RGST
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchOriginalCntrTpszList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter		
		
		try {
			velParam.put("methodname", "searchOriginalCntrTpszList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
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
		return dRs;
	}
	
	
	/**
	 * 모든 Office Code를 반환한다.
	 * (Sales Office, Office 1, Office 2를 조회함)
	 * 
	 * @return String 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchAllOfficeCodeList() throws DAOException {
		
		
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체		
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
				velParam.put("methodname", "searchAllOfficeCodeList");
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
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
	 * Agency Other Commission이 사용하는 Location Code List를 반환.
	 * 
	 * @return String 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchOtrCommLocList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
			velParam.put("methodname", "searchOtrCommLocList");	
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
	}
	
	/**
	 * Agency Other Commission이 사용하는 Location Code List를 반환.
	 * 
	 * @return String 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchCustGrpIdcList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
			velParam.put("methodname", "searchCustGrpIdcList");	
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
	}
	/**
	 * Agency Other Commission이 사용하는 Location Code List를 반환.
	 * 
	 * @return String 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchMltTrdGrpIdcList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
			velParam.put("methodname", "searchMltTrdGrpIdcList");	
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
	}
	/**
	 * Group ID = code인 Key Account List<br>
	 * mdm_customer
	 * 
	 * @param  String code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchKeyAcctInDvlList(String code) throws DAOException {
		String[] keyAcctGrp = null;		
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		String sKeyAcctGrp = "";		
		keyAcctGrp = code.split(":", -1);
		sKeyAcctGrp = keyAcctGrp[0];
		sKeyAcctGrp = sKeyAcctGrp.trim();
		try {
			if(sKeyAcctGrp != null){
				param.put("keyacctgrp"    ,sKeyAcctGrp);
				velParam.put("methodname", "searchKeyAcctInDvlList");
				velParam.put("keyacctgrp", sKeyAcctGrp);
			}
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
	}
	
	/**
	 * Group ID = code인 M/A Account List<br>
	 * mdm_customer
	 * 
	 * @param  String code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchMltTrdInDvlList(String code) throws DAOException {
		String[] keyAcctGrp = null;		
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		String sKeyAcctGrp = "";		
		keyAcctGrp = code.split(":", -1);
		sKeyAcctGrp = keyAcctGrp[0];
		sKeyAcctGrp = sKeyAcctGrp.trim();
		try {
			if(sKeyAcctGrp != null){
				param.put("mlttrdgrp"    ,sKeyAcctGrp);
				velParam.put("methodname", "searchMltTrdInDvlList");
				velParam.put("mlttrdgrp", sKeyAcctGrp);
			}
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
	}
	
	/**
	 * Average SUB GROUP코드항목을 가져온다.<br>
	 * [Operation Fixed Cost , Operation Variable Cost]
	 *         
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchAvgSubGrpList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
				velParam.put("methodname", "searchAvgSubGrpList");			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
    }
	
	/**
	 * Average COA CODE항목을 가져온다.<br>
	 * 
	 * @param String code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchAvgCoaCodeList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
			param.put("code"    ,code);
			velParam.put("methodname", "searchAvgCoaCodeList");
			velParam.put("svcGrpCd", code);
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
    }

	/**
	 * MDM_CHARGE CODE ComboList항목을 가져온다.<br>
	 *            
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	
	public DBRowSet searchMdmChargeList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		try {
			velParam.put("methodname", "searchMdmChargeList");			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
	}
	
	/**
	 * MDM_CHARGE TYPE CODE ComboList항목을 가져온다.<br>
	 *            
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	
	public DBRowSet searchMdmChargeTypeList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		try {
			velParam.put("methodname", "searchMdmChargeTypeList");			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
	}

	/**
	 * TML Expense Account 항목을 가져온다.<br>
	 *            
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */	
	public DBRowSet searchDemDetStandardCdList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		try {
			velParam.put("methodname", "searchDemDetStandardCdList");			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
	}
	
	
	/**
	 * Tariff Item, Tariff Detail 항목을 가져온다.<br>
	 * 
	 * @param String code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchCostSourceGroupCodeList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
			//SJH.20150205.MOD : 쿼리가 달라져야할듯.
			if(!code.equals("")){
				String[] value = code.split("[|]");
				if(value.length <= 1) {
					param.put("code"    ,code);		
					velParam.put("methodname", "searchCostSourceGroupCodeList");
				} else {
					param.put("code"    ,value[0]);
					param.put("cnum"    ,value[1]);
					velParam.put("methodname", "searchCostSourceGroupCodeList2");
				}
			}
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
    }
	
	/**
	 * Vessel 소유구분 항목을 가져온다.<br>
	 * 
	 * @param String code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	
	public DBRowSet searchVslOwnerList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		try {
			velParam.put("code"      , code);
			velParam.put("methodname", "searchVslOwnerList");
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
	}

	/**
	 * MDM Region (CA, US) 항목을 가져온다.<br>
	 *            
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */	
	public DBRowSet searchMdmRegionList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		try {
			velParam.put("methodname", "searchMdmRegionList");			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
	}
	
	/**
	 * 날짜의 Max Simulation No를 조회한다. <br>
	 * coa_sim_info
	 * 
	 * @return String 처리 결과
	 * @throws DAOException
	 */
	public String searchMaxSimNo() throws DAOException {
		String rtnResult = "";
		DBRowSet dbRowSet = null;
		
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
				velParam.put("methodname", "searchMaxSimNo");
				
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
			if (dbRowSet != null) {
				while (dbRowSet.next()) {
					rtnResult = dbRowSet.getString("sim_no");
				}
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return rtnResult;		
	}
	

	/**
	 * 전주차의 년도를 구한다.<br>
	 * 
	 * @return String
	 * @throws DAOException
	 */
	public String searchPrevYearPrd() throws DAOException {
		String result = "";
		DBRowSet dbRowSet = null;
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
				velParam.put("methodname", "searchPrevWkPrd");
				
				dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
				if (dbRowSet != null) {
					while (dbRowSet.next()) {
						result = dbRowSet.getString("cost_yr");
					}
				}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;		
	}
	
	
	/**
	 * Simulation number의 설명을 조회한다.
	 * 
	 * @param code
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchSimList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		String[] p_code = (code+" ").split("[|]");	
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
			if(code != null){
				param.put("slan_cd"    ,p_code[0]);
				param.put("sim_dept_cd"    ,p_code[1].trim());
				velParam.put("methodname", "searchSimList");
			}			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
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
	 * Simulation dept code를 조회한다.
	 * 
	 * @param code
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchSimDeptList(String code) throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
			if(code != null){
				param.put("code"    ,code);
			}			
			velParam.put("methodname", "searchSimDeptList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);				
				
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
		return dRs;
	}

	/**
	 * S.Lane의 목록을 가져온다.<br>
	 * COA_SIM_INFO, COA_LANE_RGST
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchSimSLaneList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {
			velParam.put("methodname", "searchSimSLaneList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
			} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
		
	}
	
	
	/**
	 * Vessel콤보의 목록을 가져온다.<br>
	 * COA_VSL_RGST
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchSimVesselList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter		
		
		try {
			velParam.put("methodname", "searchSimVesselList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
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
	 * OP 계정코드를 조회한다.<br>
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchSimOpAcct() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter		
		
		try {
			velParam.put("methodname", "searchSimOpAcct");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
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
	 * Simulation에서 사용한 vessel 목록을 가져온다.<br>
	 * COA_SIM_VSL_SET_INFO
	 * 
	 * @param code
	 *            String
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchSimVessel(String code) throws DAOException {
		
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		try {
				String[] codevalue = code.split("[|]");
				param.put("sim_dt"    ,codevalue[0].trim());
				param.put("sim_no"    ,codevalue[1].trim());
				velParam.put("methodname", "searchSimVessel");
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
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
	 * Vessel Class 콤보의 목록을 가져온다.<br>
	 * COA_VSL_RGST
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchSimVslClssList() throws DAOException {
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체	
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter		
		
		try {
			velParam.put("methodname", "searchSimVslClssList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), null, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
	}
	

	/**
	 * Simulation number의 설명을 조회한다.
	 * 
	 * @param vo
	 * @return List<SearchSimNoDescVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSimNoDescVO> searchSimNoDesc(SearchConditionVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSimNoDescVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();				
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSimNoDescRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSimNoDescVO .class);
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
	 * ESM_COA_9000 : BKG 소급 리스트 조회<br>
	 *
	 * @param BkgSokeupVO bkgSokeupVO
	 * @return DBRowSet
	 * @throws DAOException
	 * @author SJH.20140818.ADD
	 */
	public DBRowSet searchBkgSokeupStatus(BkgSokeupVO bkgSokeupVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(bkgSokeupVO != null){
				Map<String, String> mapVO = bkgSokeupVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);					
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchBkgSokeupStatusRSQL(), param, velParam);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * ESM_COA_9000 소급 대상 정보 업데이트<br>
	 * @return String
	 * @throws DAOException
	 * @throws Exception
	 * @author SJH.20140818.ADD
	 */
	public String checkMaxBatSeq() throws DAOException, Exception {
		String result = null;
		DBRowSet dbRowSet = null;
		
		try {
				dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOCheckMaxBatSeqRSQL(), null, null);
				if (dbRowSet != null) {
					while (dbRowSet.next()) {
						result = dbRowSet.getString("max_seq");
					}
				}				
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return result;
	}
	
	/**
	 * ESM_COA_9000 소급 히스토리<br>
	 * 
	 * 
	 * @param List<BkgSokeupVO> bkgSokeupVoList
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 * @author SJH.20140818.ADD
	 */
	 public int[] addBkgSokeupHistory(List<BkgSokeupVO> bkgSokeupVoList) throws DAOException, Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(bkgSokeupVoList.size() > 0){	
					insCnt = sqlExe.executeBatch((ISQLTemplate)new CommonDBDAOAddBkgSokeupHistoryCSQL(), bkgSokeupVoList,null);
					
			
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");				
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	 }	
	 
	/**
	 * ESM_COA_9000 소급 대상 정보 업데이트<br>
	 * @param List<BkgSokeupVO> bkgSokeupVoList
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 * @author SJH.20140818.ADD
	 */
	@SuppressWarnings("unchecked")
	public int addBkgSokeupCalc(List<BkgSokeupVO> bkgSokeupVoList) throws DAOException, Exception {
		int insCnt = 0;
		List colNmList = new ArrayList();
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if(bkgSokeupVoList!=null && bkgSokeupVoList.size()>0){
				for(int j=0 ; j<bkgSokeupVoList.size() ; j++){
					colNmList.add(bkgSokeupVoList.get(j).getBkgNo());
				}
				param.put("max_seq", bkgSokeupVoList.get(0).getMaxSeq());
				velParam.put("expVal", colNmList);
				insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new CommonDBDAOAddBkgSokeupCalcCSQL(), param, velParam);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}	
	
	/**
	 * 소급코드리스트 를 가져온다. - ESM_COA_9000에서 사용<br>
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 * @author SJH.20140818.ADD
	 */
	public DBRowSet searchSokeupCodeList() throws DAOException { 
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {						
			velParam.put("methodname", "searchSokeupCodeList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
    }
	
	/**
	 * 소급코드리스트 를 가져온다. - ESM_COA_9000에서 사용<br>
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 * @author SJH.20140818.ADD
	 */
	public DBRowSet searchSvcScpCodeList() throws DAOException { 
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity parameter
		
		try {						
			velParam.put("methodname", "searchSvcScpCodeList");
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return dRs;
    }

	/**
	 * [ESM_COA_4004]
	 * Mass Calculation Batch List 조회<br>
	 *
	 * @param SearchConditionVO searchVO
	 * @param CommonCoaRsVO commonCoaRsVO 
	 * @return CommonCoaRsVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public CommonCoaRsVO searchBatchManagement(SearchConditionVO searchVO, CommonCoaRsVO commonCoaRsVO) throws DAOException {
    	DBRowSet dbRowset = null;
        CommonCoaRsVO retVO = null;
        
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
        try{
            if( searchVO != null ) {
            	Map<String, String> mapVO= searchVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
            	
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchBatchManagementListRSQL(), param, velParam);
	            retVO = new CommonCoaRsVO();
	            retVO.setDbRowset(dbRowset);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            log.error("err " + se.toString(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            log.error("err " + ex.toString(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return retVO;
	 }	 

	/**
	 * [ESM_COA_4004]
	 * Simulation Batch List 조회<br>
	 *
	 * @param SearchConditionVO searchVO
	 * @param CommonCoaRsVO commonCoaRsVO 
	 * @return CommonCoaRsVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public CommonCoaRsVO searchSimBatchManagement(SearchConditionVO searchVO, CommonCoaRsVO commonCoaRsVO) throws DAOException {
    	DBRowSet dbRowset = null;
        CommonCoaRsVO retVO = null;       
        
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
        try{
            if( searchVO != null ) {
            	Map<String, String> mapVO= searchVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.debug("========== mapVO : "+mapVO);
            	
	            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSimBatchManagementListRSQL(), param, velParam);
	            retVO = new CommonCoaRsVO();
	            retVO.setDbRowset(dbRowset);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            log.error("err " + se.toString(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            log.error("err " + ex.toString(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return retVO;
	 }
	 

	/**
	 * Location Code 목록을 가져온다.<br>
	 * view : coa_location_v(mdm_location, mdm_eq_orz_cht)
	 * 
	 * @param code
	 *            String
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchLocListAll(String code) throws DAOException {
		
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity paramete
		
		try {
			param.put("param0"    ,code.toUpperCase());
			velParam.put("param0"    ,code.toUpperCase());		
			velParam.put("methodname", "searchLocListAll");
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
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
	 * EqTpCD 별 Cntr Tpsz Code 목록을 가져온다.<br>
	 * view : coa_location_v(mdm_location, mdm_eq_orz_cht)
	 * 
	 * @param code
	 *            String
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchCntrTpszCdList(String code) throws DAOException {
		
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity paramete
		
		try {
			param.put("param0"    ,code.toUpperCase());
			velParam.put("param0"    ,code.toUpperCase());		
			velParam.put("methodname", "searchCntrTpszCdList");
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
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
	 * Target YRMON 에 대해 AverageCost 배치가 실행 되었는지 확인한다.
	 * 
	 * @param String fTargetYrMon 
	 * @param String fCostTypeCd
	 * @return List<CoaUtCostCreStsVO>
	 * @throws DAOException
	 */
	public List<CoaUtCostCreStsVO> searchCostStatus(String fTargetYrMon, String fCostTypeCd) throws DAOException {
        DBRowSet dbRowset = null;
        List<CoaUtCostCreStsVO> list = null;
      //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		param.put("f_target_yrmon", fTargetYrMon);
		param.put("f_cost_type", fCostTypeCd);
        try{
	        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchCostStatusRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, CoaUtCostCreStsVO.class);        		
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            log.error("err " + se.toString(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            log.error("err " + ex.toString(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }
	
	/**
	 * Average Cost BATCH 가 실행중인지를 check 한다.
	 * @param AverageCostVO averageCostVO
	 * @return List<CoaUtCostCreStsVO>
	 * @throws DAOException
	 */
	public List<CoaUtCostCreStsVO> checkAverageCostCreateBatchStatus(AverageCostVO averageCostVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<CoaUtCostCreStsVO> list = null;
      //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        try{
        	if(averageCostVO != null){
        		Map<String, String> mapVO = averageCostVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
        	}
	        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOCheckAverageCostCreateBatchStatusRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, CoaUtCostCreStsVO.class);        		
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            log.error("err " + se.toString(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            log.error("err " + ex.toString(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }
	
	/**
	 * TS Allocation BATCH status 를 생성한다. <br>
	 * 
	 * @param AverageCostVO averageCostVO
	 * @throws DAOException
	 */
	public void modifyAverageCostStatus(AverageCostVO averageCostVO) throws DAOException {
      //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
        try{
        	if(averageCostVO != null){
        		Map<String, String> mapVO = averageCostVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
        	}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CommonDBDAOModifyAverageCostStatusRSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            log.error("err " + se.toString(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            log.error("err " + ex.toString(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }
	
	/**
	 * ESM_COA_0183 : CREATE 된 기간 조회
	 *
	 * @param AverageCostVO averageCostVO
	 * @return String
	 * @throws EventException
	 */
	public String searchAverageCostParam(AverageCostVO averageCostVO) throws DAOException {
		
		String retVal = "";
		DBRowSet dbRowset = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(averageCostVO != null){
        		Map<String, String> mapVO = averageCostVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
        	}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CommonDBDAOSearchAverageCostParamRSQL(), param, velParam);

			if(dbRowset.getRowCount() > 0) {
				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return retVal;
	}	
	
	/**
	 * Avg Agent Commission Account Code 목록을 가져온다.<br>
	 * 2017.01.11 Add
	 * 
	 * @param code String
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchAcmAccountTypeList(String code) throws DAOException {
		
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity paramete
		
		try {
			param.put("code"    ,code.toUpperCase());
			velParam.put("code"    ,code.toUpperCase());		
			velParam.put("methodname", "searchAcmAccountTypeList");
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
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
	 * Avg Agent Commission Bound 목록을 가져온다.<br>
	 * 2017.01.11 Add
	 * 
	 * @param code String
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchAcmBoundList(String code) throws DAOException {
		
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity paramete
		
		try {
			param.put("code"    ,code.toUpperCase());
			velParam.put("code"    ,code.toUpperCase());		
			velParam.put("methodname", "searchAcmBoundList");
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
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
	 * Avg Agent Commission Cost Code 목록을 가져온다.<br>
	 * 2017.01.11 Add
	 * 
	 * @param code String
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchAcmCostList(String code) throws DAOException {
		
		DBRowSet dRs = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
		Map<String, Object> velParam = new HashMap<String, Object>();//velocity paramete
		
		try {
			param.put("code"    ,code.toUpperCase());
			velParam.put("code"    ,code.toUpperCase());		
			velParam.put("methodname", "searchAcmCostList");
			
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOGetCodeSelectRSQL(), param, velParam);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return dRs;
	}
}
