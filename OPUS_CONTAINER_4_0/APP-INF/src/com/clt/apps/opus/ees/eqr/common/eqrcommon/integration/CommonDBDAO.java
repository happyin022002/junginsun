/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonDBDAO.java
*@FileTitle : EQR Common Module
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.common.eqrcommon.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.eqr.common.Constants;
import com.clt.apps.opus.ees.eqr.common.Utils;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.basic.CommonBCImpl;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.event.EesCommonEvent;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.CommonVO;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.EesCommonConditionVO;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.EqrWkPrdVO;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.EqrCommonVO;
import com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.integration.CodSimulateDBDAOCreateManualRepoPlanIdCSQL;
import com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.integration.CodSimulateDBDAODuplicateCreateRepoPlanCheckCSQL;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.EqrEqRepoPlnVO;



/**
 *  CommonDBDAO <br>
 * - -Common system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Chae Change Ho
 * @see CommonBCImpl 참조
 * @since J2EE 1.6
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
	 * ecc code를 검색해서 and ecc_cd in () 형식 스트링으로 리턴
	 * 
	 * @param loctype
	 * @param location
	 * @return CommonVO getResultString()
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CommonVO convertECCInfo(String loctype, String location) throws DAOException {
		CommonVO retVO = new CommonVO();
		StringBuffer rtrStr = new StringBuffer();
		int i = 0;
		DBRowSet dbRowset = null;
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List locationArr = Utils.replaceStrToList(location);
		velParam.put("loctype", loctype);
		velParam.put("locationArr", locationArr);
	  	try {
	  		dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOConvertECCInfoRSQL(), null, velParam);
	      	
	      	// RETURN 값으로 돌려줄 ECC CODE WHERE CONDITION 구문
	      	if(location.equals("")) {
	      		rtrStr.append("AND 1=1 ");   //LOCATION 입력업이 LOCTYPE 을 선택했을 경우.
	      	}else {
		      	while(dbRowset.next()) {
		      		rtrStr.append(((i == 0) ? "" : ",") + dbRowset.getString("ECC_CD")); 
		      		i++;
		      	}	
		      	
		      	if(rtrStr.toString().equals("")){
		      		rtrStr.append("''");
		      	}
	      	}
	      	retVO.setResultSB(rtrStr);

	  	}catch(SQLException se) {
	  		log.error(se.getMessage(), se);
	      	throw new DAOException(new ErrorHandler(se).getMessage());
	  	}catch(DAOException de) {
	  		log.error(de.getMessage(), de);
	      	throw de;
	  	}catch(Exception e) {
	  		log.error(e.getMessage(), e);
	      	throw new DAOException(e.getMessage());
	  	}
	  	return retVO;
	}

	/**
	 * ecc code를 검색해서 string으로 리턴<br>
	 * - EES_EQR_105 참조..<br>
	 * 
	 * @author ChungEunHo
	 * @see loctype   = location type
	 *      condition = location 
	 * @since J2EE 1.6
	 * @param loctype
	 * @param location
	 * @return CommonVO getResultString()
	 * @exception DAOException
	 */		
	@SuppressWarnings("unchecked")
	public CommonVO convertECCInfoString(String loctype, String location) throws DAOException {
		CommonVO retVO = new CommonVO();
		StringBuffer rtrStr = new StringBuffer();
		int i = 0;
		DBRowSet dbRowset = null;
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List locationArr = Utils.replaceStrToList(location);
		velParam.put("loctype", loctype);
		velParam.put("locationArr", locationArr);
	    	       
	  	try {
	  		dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOConvertECCInfoStringRSQL(), null, velParam);
	      	
	      	// RETURN 값으로 돌려줄 ECC CODE STRING 구문  	    
	      	while (dbRowset.next()) {
	    		rtrStr.append(((i == 0) ? "" : ",") + dbRowset.getString ("ECC_CD"));
	    		i++;
	      	}

	      	if(rtrStr.toString().equals("")){
	      		rtrStr.append("''");
	      	}
	      	retVO.setResultSB(rtrStr);

	  }catch(SQLException se) {
	      log.error(se.getMessage(), se);
	      throw new DAOException(new ErrorHandler(se).getMessage());
	  }catch(DAOException de) {
	      log.error(de.getMessage(), de);
	      throw de;
	  }catch(Exception e) {
	      log.error(e.getMessage(), e);
	      throw new DAOException(e.getMessage());
	  }
	  return retVO;
	  
	}

	/**
	 * yard code의 해당 ECC를 검색하여 리턴
	 * 
	 * @param yard_code
	 * @param column_name
	 * @return CommonVO getResultString()
	 * @exception DAOException
	 */
	public CommonVO convertYardToECC(String yard_code, String column_name) throws DAOException {
		CommonVO retVO = new CommonVO();  
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

	  	// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
	  	StringBuffer rtrStr= new StringBuffer();
	  	int i 		 = 0;
	  	
	  	try {
	  		param.put("yard_code",yard_code);
	  		velParam.put("column_name",column_name);
	  		dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOConvertYardToECCRSQL(), param, velParam);
		    while(dbRowset.next()) {
		      	rtrStr.append(((i == 0) ? "" : ",") + dbRowset.getString(column_name)); 
		      	i++;
		   	}		      

	      	if(rtrStr.toString().equals("")){
	      		rtrStr.append("''");
	      	}
		    retVO.setResultSB(rtrStr);

	  	}catch(SQLException se) {
	  		log.error(se.getMessage(), se);
	      	throw new DAOException(new ErrorHandler(se).getMessage());
	  	}catch(DAOException de) {
	  		log.error(de.getMessage(), de);
	      	throw de;
	  	}catch(Exception e) {
	  		log.error(e.getMessage(), e);
	      	throw new DAOException(e.getMessage());
	  	}
	  	return retVO;
	}
	/**
	 * Table 내에 최근 update된 사용자와 날짜를 조회한다..<br>
	 * 
	 * @param table String
	 * @param condition String
	 * @return CommonVO  getResultStrArray()
	 * @exception DAOException
	 */
	 public CommonVO searchMaxInfo(String table, String condition) throws DAOException {
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		String maxInfo[] = new String[2];
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		
		try{
			velParam.put("table_name", table);
			velParam.put("condition", condition);
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOSearchMaxInfoRSQL(), null, velParam);
			if (dbRowset.next()) {
				maxInfo[0] = dbRowset.getString("MAX_USRID");
				maxInfo[1] = dbRowset.getString("MAX_UPDATE");
			}else{
				maxInfo[0] = "";
				maxInfo[1] = "";
			}
			retVO.setResultStrArray(maxInfo);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVO;
	}

	/**
	 * SCNR_ID 기준으로 해서 REMARK 정보와 기타 정보를 가져온다. 
	 * 
	 * @param scnr_id
	 * @return scnridReMark
	 * @exception DAOException
	 */	
	public CommonVO scnridReMarkSearch(String scnr_id) throws DAOException {
		CommonVO retVO = new CommonVO();  
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			param.put("scnr_id", scnr_id);
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOSearchScnrIdRemarkRSQL(), param, null);
			retVO.setDbRowset(dbRowset);
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
	 * repoidReMark 조회
	 * 
	 * @param repo_id
	 * @return repoidReMark
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EqrEqRepoPlnVO> repoidReMarkSearch(String repo_id) throws DAOException {
		 
		DBRowSet dbRowset = null;
		List<EqrEqRepoPlnVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			param.put("repo_id",repo_id);
			
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAORepoidReMarkSearchRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EqrEqRepoPlnVO .class);
			
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

	/**
	 * EQR_EQ_REPO_PLN 의 fromToRepoPLnId 조회
	 * 
	 * @param repo_id
	 * @return CommonVO getResultString()
	 * @exception DAOException
	 */
	public CommonVO fromToRepoPlnId(String repo_id) throws DAOException {
		CommonVO retVO = new CommonVO();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		
		String result = "";
		StringBuffer resultBuf = new StringBuffer();		
		String repo_pln_id = repo_id.substring(0,10);
		
		try {
			param.put("repo_pln_id",repo_pln_id);
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOFromToRepoPlnIdRSQL(), param, null);
			
			while (dbRowset.next()){
				resultBuf.append(dbRowset.getString("REPO_PLN_ID")+",");
				result = resultBuf.toString().substring(0,resultBuf.toString().length()-1);
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

	/**
	 * EQR_EQ_REPO_PLN SIM_PLN_ID 값에 따른 SCNR_ID , REPO_PLN_ID 리스트 조회
	 * 
	 * @param repo_id
	 * @return CommonVO getResultStrArray()
	 * @exception DAOException
	 */	
	public CommonVO scnrIdList(String repo_id) throws DAOException {
		CommonVO retVO = new CommonVO();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		String[] result = new String[2];
		
		int j= 0;
		
		try {
			param.put("repo_id",repo_id);
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOScnrIdListRSQL(), param, null);
			StringBuffer scnIdList = new StringBuffer();
			StringBuffer repoPlnIdList = new StringBuffer();
			
			while (dbRowset.next()){
				scnIdList.append(((j == 0) ? "" : ",") + dbRowset.getString ("SCNR_ID"));
				repoPlnIdList.append(((j == 0) ? "" : ",") + dbRowset.getString("REPO_PLN_ID"));
				j++;
			}
			
			result[0] = scnIdList.toString();
			result[1] = repoPlnIdList.toString();
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
	 * EQR_SCNR_MST ADFflag 조회
	 * 
	 * @param scnr_id String
	 * @return CommonVO  getResultString()
	 * @exception DAOException
	 */
	public CommonVO searchADRflg(String scnr_id) throws DAOException {
		CommonVO retVO = new CommonVO();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		
		try {
			param.put("scnr_id",scnr_id);
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOSearchADRflgRSQL(), param, null);
			if (dbRowset.next()) {
				retVO.setResultString(dbRowset.getString("ADRflg"));
			} 
			
			return retVO;
			
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
	}

	/**
	 * plan_ID 기준으로 해서 9주차 수정가능 주차를 콤마구분으로 만든값 Max wk Str
	 * 
	 * @param YYYYWW
	 * @param WeeklyGap
	 * @return CommonVO getResultStrArray()
	 * @exception DAOException
	 */
	public CommonVO weewklyMaxWkStr(String YYYYWW ,int WeeklyGap) throws DAOException {
		CommonVO retVO = new CommonVO();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		String[] result = new String[1];
		
		int j= 0;
		StringBuffer inStr = new StringBuffer();	
		
		try {
			param.put("yyyy",YYYYWW.substring(0,4));
			param.put("next_yyyy",Integer.toString(Integer.parseInt(YYYYWW.substring(0,4)) + 1));
			param.put("yyyyww",YYYYWW);
			param.put("WeeklyGap", WeeklyGap);
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOWeewklyMaxWkStrRSQL(), param, null);
			
			while (dbRowset.next()){
				inStr.append(((j == 0) ? "" : ",") + dbRowset.getString ("MAXWKSTR"));
				j++;
			}
			result[0] = inStr.toString().replaceAll("-","");
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
	 * SCNR_ID 기준으로 해서 MonthGap 후의 년 월 을 구한다.
	 * 
	 * @param YYYYWW
	 * @param WeeklyGap
	 * @return CommonVO getResultStrArray()
	 * @exception DAOException
	 */
	public CommonVO weewklyConvertMonth(String YYYYWW ,int WeeklyGap) throws DAOException {
		
		CommonVO retVO = new CommonVO();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		String[] result = new String[6];
		
		int j= 0;
		
		try {
			param.put("yyyy",YYYYWW.substring(0,4));
			param.put("next_yyyy",Integer.toString(Integer.parseInt(YYYYWW.substring(0,4)) + 1));
			param.put("yyyyww",YYYYWW);
			param.put("WeeklyGap", WeeklyGap);
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOWeewklyConvertMonthRSQL(), param, null);
			
			
			while (dbRowset.next()){
				result[j++] = dbRowset.getString("PLN_YR");
				result[j++] = dbRowset.getString("PLN_WK");
				result[j++] = dbRowset.getString("PLN_MON");
			}
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
	 * Table 내에 최근 update된 사용자와 날짜를 조회한다..<br>
	 * 
	 * @param year String
	 * @return CommonVO getList()
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public CommonVO searchWeek(String year) throws DAOException {
		DBRowSet dbRowset = null;
		List  countWeek = new ArrayList();;
	
		CommonVO retVO = new CommonVO();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		
		try{
			param.put("pln_yr", year);
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOSearchWeekRSQL(), param, null);
			while(dbRowset.next()) {
				countWeek.add(dbRowset.getString(1));
			}
			retVO.setList(countWeek);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVO;
	} 

	/** 
	 * 시작월-종료월 간의 월정보 조회
	 * 
	 * @param info String[]
	 * @return CommonVO getResultStrArray()
	 * @exception DAOException
	 */
	public CommonVO titleMaxMonth(String[] info) throws DAOException {
		CommonVO retVO = new CommonVO();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		String[] result = new String[2];
		String st_year   = info[0];
		String st_month  = info[2];		
		String end_year  = info[3];
		String end_month = info[5];
		
		StringBuffer inStr = new StringBuffer();
	  	StringBuffer inStr1= new StringBuffer();
		
		int j= 0;
				
		try {
			param.put("st_year_month", st_year+st_month);
			param.put("end_year_month", end_year+end_month);
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOTitleMaxMonthRSQL(), param, null);
			
			while(dbRowset.next()) {
				inStr.append(((j == 0) ? "" : ",") + dbRowset.getString ("YEAR_MONTH"));
				inStr1.append(((j == 0) ? "" : "|") + dbRowset.getString ("YEAR_MONTH"));
				j++;
			}
			
			result[0] = inStr.toString().replaceAll("-","");
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
	 * 시작주-종료주 간의 주차, 월정보 조회
	 * 
	 * @param info String[]
	 * @return CommonVO getResultStrArray()
	 * @exception DAOException
	 */
	public CommonVO titleMaxWeek(String[] info) throws DAOException {
		
		CommonVO retVO = new CommonVO();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		String[] result = new String[3];
		String st_year = info[0];
		String st_weekly = info[1];
		
		String end_year = info[3];
		String end_weekly = info[4];
		
		StringBuffer inStr = new StringBuffer();	
		StringBuffer inStr1= new StringBuffer();	
		StringBuffer inStr2= new StringBuffer();	
		
		int j= 0;
		try {
			param.put("st_year_weekly", st_year+st_weekly);
			param.put("end_year_weekly", end_year +end_weekly);
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOTitleMaxWeekRSQL(), param, null);
			
			while(dbRowset.next()){
				inStr.append(((j == 0) ? "" : ",") + dbRowset.getString ("YEAR_WEEK"));
				inStr1.append(((j == 0) ? "" : "|") + dbRowset.getString ("YEAR_WEEK")+"W");
				inStr2.append(((j == 0) ? "" : ",") + dbRowset.getString("YEAR_MON"));
				j++;
			}
			
			result[0] = inStr.toString().replaceAll("-","");
			result[1] = inStr1.toString();
			result[2] = inStr2.toString();
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
	 * 해당주차의 월 갯수를 구한다.
	 * 
	 * @param info
	 * @return CommonVO getResultString()
	 * @exception DAOException
	 */
	public CommonVO monthCount(String[] info) throws DAOException {
		
		CommonVO retVO = new CommonVO();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		String st_year = info[0];
		String st_weekly = info[1];
		
		String end_year = info[3];
		String end_weekly = info[4];
		
		StringBuffer inStr = new StringBuffer();
	  
		int j= 0;
		
		
		try {

			param.put("st_year_weekly", st_year+st_weekly);
			param.put("end_year_weekly", end_year +end_weekly);
			
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOMonthCountRSQL(), param, null);
			
			while (dbRowset.next()){
				inStr.append(((j == 0) ? "" : ",") + dbRowset.getString ("MONTH_COUNT"));
				j++;
			}
			retVO.setResultSB(inStr);

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
	 * 특정 ECC Code가 EQR_ECC_MST 테이블에서 사용상태인 ecc 인지 확인<br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return CommonVO getResultString()
	 * @exception DAOException
	 */
	public CommonVO checkEccCode(EesCommonConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		String re_ecc_cd ="";
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("ecc_cd", conditionVO.getEcccd());
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOCheckEccCodeRSQL(), param, null);
			for (int i=0; i<dbRowset.getRowCount(); i++) { 
				 if (dbRowset.next()) {
					 re_ecc_cd = dbRowset.getString("ECC_CD");
				 	}
				}
			retVO.setResultString(re_ecc_cd);
			//log.debug("======ECC" + re_ecc_cd);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVO;
	} 

	/**
	 * EQR_ECC_MST 테이블에서 ECC, LCC, RCC, CNT 가 각각 타입별로 존재하는지 여부 확인
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return CommonVO
	 * @exception DAOException
	 */
	public CommonVO checkLocCode(EesCommonConditionVO conditionVO) throws DAOException {
		
		
		CommonVO retVO = new CommonVO();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	    String type = "";
	    String  result = "";
	    
	    if(conditionVO.getType().equals("R"))    		type="RCC_CD";
	    else if(conditionVO.getType().equals("L"))	type="LCC_CD";
	    else if(conditionVO.getType().equals("E"))   	type="ECC_CD";
	    else if(conditionVO.getType().equals("C"))   	type="CNT_CD";
	    
	    try {
	    	velParam.put("type", type);
	    	param.put("loc_cd", conditionVO.getLocCd());
	        
	    	dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOCheckLocCodeRSQL(), param, velParam);
			
			while(dbRowset.next()){
				//result = true;
				result = dbRowset.getString("LOC_CD");
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

	/**
	 * EQR_ECC_MST 테이블에서 ECC, LCC, RCC, CNT 가 각각 타입별로 GROUP별로 존재하는지 여부 확인
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return CommonVO getResultString()
	 * @exception DAOException
	 */
	public CommonVO checkLocCodeWithMaster(EesCommonConditionVO conditionVO) throws DAOException {
		
		CommonVO retVO = new CommonVO();
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
	    String  result = "";
	    
	    String type ="";
	    String mtype ="";
	    
	    if(conditionVO.getType().equals("R"))    		type="RCC_CD";
	    else if(conditionVO.getType().equals("L"))	type="LCC_CD";
	    else if(conditionVO.getType().equals("E"))   	type="ECC_CD";
	    else if(conditionVO.getType().equals("C"))   	type="CNT_CD";
	    
	    if(conditionVO.getMtype().equals("R"))    	mtype="RCC_CD";
	    else if(conditionVO.getMtype().equals("L"))  	mtype="LCC_CD";
	    else if(conditionVO.getMtype().equals("E"))  	mtype="ECC_CD";
	    else if(conditionVO.getMtype().equals("C"))  	mtype="CNT_CD";
	     

			
	    try {
	    	velParam.put("type", type);
	    	velParam.put("mtype", mtype);
	    	param.put("mloc_cd", conditionVO.getMlocCd());
	    	param.put("loc_cd", conditionVO.getLocCd());
	        
	    	dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOCheckLocCodeWithMasterRSQL(), param, velParam);			
			
			while(dbRowset.next()){
				//result = true;
				result = dbRowset.getString("LOC_CD");
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

	/**
	 * ScenarioDefaultManage의 수정 된 데이타 모델을 EQR_SCNR_MST 테이블에 반영한다.
	 * 
	 * @param scnrId
	 * @param scnrRmk
	 * @param usrId
	 * @return CommonVO isResultBoolean()
	 * @exception DAOException
	 */
	public CommonVO modifyScnrRmk(String scnrId, String scnrRmk, String usrId) throws DAOException {
		
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		long resultCount = 0;         // UPDATE 결과가 정상인지를 판별하기 위한 변수		
		try {
			// 쿼리에 변수 세팅. 
			param.put("scnr_rmk", scnrRmk);
			param.put("upd_usr_id", usrId);
			param.put("scnr_id", scnrId);
			
			resultCount =  new SQLExecuter(strDs).executeUpdate((ISQLTemplate)new CommonDBDAOModifyScnrRmkUSQL(), param, null);
			if (resultCount < 1) {
				// 데이터 반영에 실패하였습니다.
				throw new DAOException(new ErrorHandler("COM11001").getMessage());
			}else{
				retVO.setResultBoolean(true);
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
	 * ScenarioDefaultManage의 수정 된 데이타 모델을 EQR_EQ_REPO_PLN 테이블에 반영한다
	 * 
	 * @param repoId
	 * @param repoRmk
	 * @param usrId
	 * @return CommonVO getResultBoolean()
	 * @exception DAOException
	 */
	public CommonVO modifyRepoRmk(String repoId, String repoRmk, String usrId) throws DAOException {
		
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		long resultCount = 0;           // UPDATE 결과가 정상인지를 판별하기 위한 변수		

		try {
			// 쿼리에 변수 세팅. 
			param.put("repo_pln_rmk", repoRmk);
			param.put("upd_usr_id", usrId);
			param.put("repo_pln_id", repoId);
			
			resultCount =  new SQLExecuter(strDs).executeUpdate((ISQLTemplate)new CommonDBDAOModifyRepoRmkUSQL(), param, null);
			if (resultCount < 1) {
				// 데이터 반영에 실패하였습니다.
				throw new DAOException(new ErrorHandler("COM11001").getMessage());
			}else{
				retVO.setResultBoolean(true);
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
	 * EQR_WK_PRD 의 PLN_WK 의 기준년도(-1)의  최소값과 최대값 조회
	 * 
	 * @param curYear
	 * @return CommonVO getResultStrArray()
	 * @exception DAOException
	 */
	public CommonVO minMax01(String curYear) throws DAOException {
		
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String[] result = new String[2];	
		
		try {
			String tmpYear = (Integer.parseInt(curYear) -1)+"";
			param.put("curYear",curYear);
			param.put("tmpYear",tmpYear);
			velParam.put("curYear",curYear);
			velParam.put("tmpYear",tmpYear);
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOMinMax01RSQL(), param, velParam);
			
			while (dbRowset.next()){
				 result[0] = dbRowset.getString ("MINVAL");
				 result[1] = dbRowset.getString ("MAXVAL");
			}
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
	 * EQR_WK_PRD 의 PLN_WK 의 기준년도(+1)의  최소값과 최대값 조회
	 * 
	 * @param curYear
	 * @return CommonVO getResultStrArray()
	 * @exception DAOException
	 */
	public CommonVO maxMin52(String curYear) throws DAOException {
		
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String[] result = new String[2];		
		
		try {
			String tmpYear = (Integer.parseInt(curYear) +1)+"";
			param.put("curYear",curYear);
			param.put("tmpYear",tmpYear);
			velParam.put("curYear",curYear);
			velParam.put("tmpYear",tmpYear);
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOMaxMin52RSQL(), param, velParam);
			while (dbRowset.next()){
				result[0] = dbRowset.getString ("MAXVAL");
				result[1] = dbRowset.getString ("MINVAL");
			}
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
	 * 특정년도의 최대,최소 주차 정보를 01, 52 형태로 리턴
	 * 
	 * @author 
	 * @param curYear
	 * @return CommonVO getResultStrArray()
	 * @exception DAOException
	 */
	public CommonVO getMinMaxWeek(String curYear) throws DAOException {
		
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();	
		String[] result = new String[2];
		
		try {
			param.put("curYear",curYear);
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOGetMinMaxWeekRSQL(), param, null);
			while (dbRowset.next()){
				result[0] = dbRowset.getString ("MAXVAL");
			 	result[1] = dbRowset.getString ("MINVAL");
			}
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
		
		
		try {
			param.put("locyard", locyard);
			param.put("ecc", ecc);
			velParam.put("ecc", JSPUtil.getNull(ecc));
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOSearchLocYardExistRSQL(), param, velParam);
			
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

	/**
	 * LOC Yard 가 사용해도 되는것인지 확인
	 * 
	 * @param locyard
	 * @return CommonVO getResultString()
	 * @exception DAOException
	 */
	public CommonVO searchLocYardCompanyExist(String locyard) throws DAOException {
		
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		String result   = "";
		
		try {
			param.put("locyard", locyard);
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOSearchLocYardCompanyExistRSQL(), param, null);
			
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

	/**
	 * LOC Yard combo box 정보를 검색<br>
	 * 
	 * @param locyard_searchword
	 * @return CommonVO getResultStrArray()
	 * @see EesCommonEvent
	 * @exception DAOException	 
	*/
	public CommonVO searchLocYardInfo(String locyard_searchword) throws DAOException {
		
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();

		String[] result     = new String[2];
		StringBuffer inStr  = new StringBuffer();	
		StringBuffer inStr1	= new StringBuffer();
		int j			= 0;
		
		// 5개 이상인 경우 잘라서 표현
		if(locyard_searchword.length() > 5) {			
			locyard_searchword = locyard_searchword.substring(0,5);
		}

		
		try {
			velParam.put("locyard_searchword", locyard_searchword);
			
			velParam.put("loc_type", "LCC");
			param.put("loc_type", "LCC");
			
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOSearchLocYardInfoRSQL(), param, velParam);
			
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
	 * LOC Yard combo box 정보를 검색<br>
	 * 
	 * @param locyard_searchword
	 * @return CommonVO getResultStrArray()
	 * @see EesCommonEvent
	 * @exception DAOException	 
	*/
	public CommonVO searchEccYardInfo(String locyard_searchword) throws DAOException {
		
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();

		String[] result     = new String[2];
		StringBuffer inStr  = new StringBuffer();	
		StringBuffer inStr1	= new StringBuffer();
		int j			= 0;
		
		// 5개 이상인 경우 잘라서 표현
		if(locyard_searchword.length() > 5) {			
			locyard_searchword = locyard_searchword.substring(0,5);
		}

		
		try {
			velParam.put("locyard_searchword", locyard_searchword);
			
			velParam.put("loc_type", "ECC");
			param.put("loc_type", "ECC");
			
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOSearchLocYardInfoRSQL(), param, velParam);
			
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
	 * LOC Yard combo box 정보를 검색<br>
	 * 
	 * @param locyard_searchword
	 * @return CommonVO getResultStrArray()
	 * @see EesCommonEvent
	 * @exception DAOException	 
	*/
	public CommonVO searchLocByYardInfo(String locyard_searchword) throws DAOException {
		
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();

		String[] result     = new String[2];
		StringBuffer inStr  = new StringBuffer();	
		StringBuffer inStr1	= new StringBuffer();
		int j			= 0;
		// 5개 이상인 경우 잘라서 표현
		if(locyard_searchword.length() > 5) {			
			locyard_searchword = locyard_searchword.substring(0,5);
		}

		
		try {
			velParam.put("loc_cd", locyard_searchword);
			param.put("loc_cd", locyard_searchword);
			
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOSearchLocYardByLocRSQL(), param, velParam);
			
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
	 * LOC Yard (INLAND+VESSEL) combo box 정보를 검색<br>
	 * 
	 * @param locyard_searchword
	 * @return CommonVO getResultStrArray()
	 * @see EesCommonEvent
	 * @exception DAOException	 
	*/
	public CommonVO searchLocYardCompanyInfo(String locyard_searchword) throws DAOException {
		
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
			param.put("locyard_searchword", locyard_searchword + "%");
			param.put("delt_flg", delt_flg);
			
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOSearchLocYardCompanyInfoRSQL(), param, null);
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
		Map<String, Object> velParam = new HashMap<String, Object>();
		String[] result     = new String[2];
		StringBuffer inStr  = new StringBuffer();	
		StringBuffer inStr1	= new StringBuffer();
		List searchwordArr = null;
		int j			= 0;
		String delt_flg = "Y";
		String[] arr_loc_cd = locyard_searchword.split(",");
		String all_locyard_searchword = locyard_searchword;
		
		// 5개 이상인 경우 잘라서 표현
		if(locyard_searchword.length() > 5) {			
			locyard_searchword = locyard_searchword.substring(0,5);
		}
		
		try {
			param.put("locyard_searchword", locyard_searchword + "%");
			param.put("delt_flg", delt_flg);
			searchwordArr = Utils.replaceStrToList(all_locyard_searchword);
			if(arr_loc_cd.length >0) {
				
				velParam.put("searchwordArr", searchwordArr);
				
				dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOSearchLocYardVesselAllInfoRSQL(), param, velParam);
			}else{
				dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOSearchLocYardVesselInfoRSQL(), param, null);
			}
			
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
	 * PRD_MATRIX 에서 FDR 만 검색
	 * INLAND(WATER)의 EXECUTE ROW 생성하면서 YARD 정보를 검색(VVD 없는 경우)
	 * INLAND(WATER)(080) = 'W'
	 * COMBINED(108)      = 'W'
	 * 
	 * @param ecc
	 * @return CommonVO  getResultString()
	 * @exception DAOException
	 */
	public CommonVO searchLocYardInitialInfo(String ecc) throws DAOException {
		
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		
		Map<String, Object> param = new HashMap<String, Object>();    //query parameter		
		Map<String, Object> velParam = new HashMap<String, Object>(); //velocity parameter
		
		String[] result     = new String[2];
		StringBuffer inStr  = new StringBuffer();
		
		int j			= 0;
		
		try {
					
			param.put("ecc", ecc);
			param.put("vsl", "FDR");  // FDR만 검색 (하드코딩)
			
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOSearchLocYardInitialInfoRSQL(), param, velParam);

			while(dbRowset.next()) {
				inStr.append(((j == 0) ? "" : "|") + dbRowset.getString("LOC_YARD"));   
				j++;
			}			
			
			result[0] = inStr.toString();
			result[1] = "";			 // 꼭 필요함(impl에서 판단할때 필요함)		
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
	 * VSL, INLAND(WATER)의 EXECUTE ROW 생성하면서 YARD 정보를 검색
	 * item --> VSL(059)           = 'V'
	 *          INLAND(WATER)(080) = 'W' + VVD 입력한 경우
	 *          COMBINED(108)      = 'V'
	 *          COMBINED(108)      = 'W' + VVD 입력한 경우
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
	 * VSL, INLAND(WATER)의 EXECUTE ROW 생성하면서 YARD 정보를 검색
	 * @param ecc
	 * @param vslCd
	 * @param skdVoyNo
	 * @param skdDirCd
	 * @return CommonVO
	 * @throws DAOException
	 */
	public CommonVO searchWaterLocVesselYardInitialInfo(String ecc, String vslCd, String skdVoyNo, String skdDirCd) throws DAOException {
		
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

			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOSearchWaterLocVesselYardInitialInfoRSQL(), param, velParam);

			// row가 몇개인지확인 (1개이면  CODE 만 가져감, 2개이상이면 CODE-NAME, CODE 로 가져감)
			// 1개는 dtData, 2개 이상은 dtCombo형식으로 표현함(중요)
			rowcount = dbRowset.getRowCount(); 
			inStr.append("");
			inStr1.append("");
			if(rowcount > 1) { // 검색결과 2개 이상
				while(dbRowset.next()) {
					inStr.append( ((j == 0) ? "" : "|") + dbRowset.getString("YD_CD").replaceAll("&","&amp;")+" \t " + dbRowset.getString("YD_NM").replaceAll("&","&amp;"));   // NAME
					inStr1.append(((j == 0) ? "" : "|") + dbRowset.getString("YD_CD")); 
					j++;
				}
			}else { // 검색결과 1 이거나 없거나
				while(dbRowset.next()) {
					inStr.append(((j == 0) ? "" : "|") + dbRowset.getString("YD_CD").replaceAll("&","&amp;")+" \t " + dbRowset.getString("YD_NM").replaceAll("&","&amp;")); 
					inStr1.append(((j == 0) ? "" : "|") + dbRowset.getString("YD_CD"));       
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
	 * VSL, INLAND(WATER)의 EXECUTE ROW 생성하면서 YARD 정보를 검색
	 * item --> VSL(059)           = 'V'
	 *          INLAND(WATER)(080) = 'W' + VVD 입력한 경우
	 *          COMBINED(108)      = 'V'
	 *          COMBINED(108)      = 'W' + VVD 입력한 경우
	 * @param ecc
	 * @param vslCd
	 * @param skdVoyNo
	 * @param skdDirCd
	 * @return CommonVO
	 * @throws DAOException
	 */
	public CommonVO searchLocVesselYardDischargelInfo(String ecc, String vslCd, String skdVoyNo, String skdDirCd) throws DAOException {
		
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

			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOSearchLocDischargeYardInitialInfoRSQL(), param, velParam);

			// row가 몇개인지확인 (1개이면  CODE 만 가져감, 2개이상이면 CODE-NAME, CODE 로 가져감)
			// 1개는 dtData, 2개 이상은 dtCombo형식으로 표현함(중요)
			rowcount = dbRowset.getRowCount(); 
			
			if(rowcount > 1) { // 검색결과 2개 이상
				while(dbRowset.next()) {
					inStr.append( ((j == 0) ? "" : "|") + dbRowset.getString("YD_CD").substring(4).replaceAll("&","&amp;")+" \t " + dbRowset.getString("VSL_ETB_DT").replaceAll("&","&amp;"));   // NAME
					inStr1.append(((j == 0) ? "" : "|") + dbRowset.getString("YD_CD"));                                                               // CODE 
					j++;
				}
			}else { // 검색결과 1 이거나 없거나
				while(dbRowset.next()) {
					inStr.append(((j == 0) ? "" : "|") + dbRowset.getString("YD_CD").substring(4).replaceAll("&","&amp;")+" \t " + dbRowset.getString("VSL_ETB_DT").replaceAll("&","&amp;"));    
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
	 * VSL, INLAND(WATER)의 EXECUTE ROW 생성하면서 YARD 정보를 검색
	 
	 * @param fm_ecc
	 * @param to_ecc
	 * @param vslCd
	 * @param skdVoyNo
	 * @param skdDirCd
	 * @return CommonVO
	 * @throws DAOException
	 */
	public CommonVO searchWaterLocVesselYardDischargelInfo(String fm_ecc, String to_ecc, String vslCd, String skdVoyNo, String skdDirCd) throws DAOException {
		
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
			
    		param.put("fm_ecc", fm_ecc);
    		param.put("to_ecc", to_ecc);
			param.put("vslCd", vslCd);
			param.put("skdVoyNo", skdVoyNo);
			param.put("skdDirCd", skdDirCd);

			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOSearchWaterLocDischargeYardInitialInfoRSQL(), param, velParam);

			// row가 몇개인지확인 (1개이면  CODE 만 가져감, 2개이상이면 CODE-NAME, CODE 로 가져감)
			// 1개는 dtData, 2개 이상은 dtCombo형식으로 표현함(중요)
			rowcount = dbRowset.getRowCount(); 
			inStr.append("");
			inStr1.append("");
			if(rowcount > 1) { // 검색결과 2개 이상
				while(dbRowset.next()) {
					inStr.append( ((j == 0) ? "" : "|") + dbRowset.getString("YD_CD").replaceAll("&","&amp;")+" \t " + dbRowset.getString("YD_NM").replaceAll("&","&amp;"));   // NAME
					inStr1.append(((j == 0) ? "" : "|") + dbRowset.getString("YD_CD"));        
					j++;
				}
			}else { // 검색결과 1 이거나 없거나
				while(dbRowset.next()) {
					inStr.append(((j == 0) ? "" : "|") + dbRowset.getString("YD_CD").replaceAll("&","&amp;")+" \t " + dbRowset.getString("YD_NM").replaceAll("&","&amp;"));
					inStr1.append(((j == 0) ? "" : "|") + dbRowset.getString("YD_CD"));       
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
	 * 임대사  Yard combo box 정보를 검색<br>
	 * EES_EQR_059 TAB3
	 * @param conditionVO EesCommonConditionVO
	 * @return CommonVO
	 * @see EesCommonEvent
	 * @exception DAOException	 
	*/
	public CommonVO searchLseCoYardInfo(EesCommonConditionVO conditionVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		String[] result     = new String[2];
		StringBuffer inStr  = new StringBuffer();	
		StringBuffer inStr1	= new StringBuffer();
		
		int j			= 0;
		String delt_flg = "Y";
		
		String locyard_vndr_seq = conditionVO.getLocyardVndrSeq();
		String locyard_searchword = conditionVO.getLocyardSearchword();
		
		
		try {
			param.put("locyard_vndr_seq", locyard_vndr_seq);
			param.put("locyard_searchword", locyard_searchword+"%");
			param.put("delt_flg", delt_flg);
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOSearchLseCoYardInfoRSQL(), param, null);
			
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
	 * LOC Yard, ECC combo box 정보를 검색<br>
	 * 
	 * @param locyard String
	 * @param ecc String
	 * @return CommonVO getResultStrArray()
	 * @exception DAOException
	*/
	public CommonVO searchLocYardEccInfo(String locyard, String ecc) throws DAOException {
		
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String[] result = new String[2];
		StringBuffer inStr  = new StringBuffer();	
		StringBuffer inStr1	= new StringBuffer();
		int j			= 0;
		
		try {
			param.put("ecc", ecc);
			param.put("locyard", locyard);
			velParam.put("ecc", JSPUtil.getNull(ecc));
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOSearchLocYardEccInfoRSQL(), param, velParam);
			
			while(dbRowset.next()) {
				inStr.append(((j == 0) ? "" : "|") + dbRowset.getString("YD_CD"));
				inStr1.append(((j == 0) ? "" : "|") + dbRowset.getString("ECC_CD"));				
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
	 * LOC Yard, ECC combo box 정보를 검색<br>
	 * 
	 * @param locyard String
	 * @param ecc String
	 * @param loc_cd String
	 * @param account SignOnUserAccount
	 * @return CommonVO getResultStrArray()
	 * @exception DAOException
	*/
	public CommonVO searchEqrLocYardEccInfo(String locyard, String ecc, String loc_cd, SignOnUserAccount account) throws DAOException {
		
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String[] result = new String[2];
		StringBuffer inStr  = new StringBuffer();	
		StringBuffer inStr1	= new StringBuffer();
		int j			= 0;
		
		try {
			String offCd = account.getOfc_cd();
			
			param.put("loc_cd", loc_cd);
			param.put("ecc", ecc);
			param.put("locyard", locyard);
			param.put("off_cd", offCd);
			velParam.put("locyard", JSPUtil.getNull(locyard));
			velParam.put("loc_cd", JSPUtil.getNull(loc_cd));
			velParam.put("ecc", JSPUtil.getNull(ecc));
			velParam.put("off_cd", JSPUtil.getNull(offCd));
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOSearchEqrLocYardEccInfoRSQL(), param, velParam);
			
			while(dbRowset.next()) {
				inStr.append(((j == 0) ? "" : "|") + dbRowset.getString("YD_CD"));
				inStr1.append(((j == 0) ? "" : "|") + dbRowset.getString("ECC_CD"));				
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
	 * Yard INfo Search<br>
	 * @param locfmyard String
	 * @param loctoyard String
	 * @param account SignOnUserAccount
	 * @return strYardInfo
	 * @exception DAOException
	 */
	public String searchYardInfo(String locfmyard, String loctoyard, SignOnUserAccount account)  throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String strYardInfo = "";
		try{
			param.put("locfmyard", locfmyard);
			param.put("loctoyard", loctoyard);
			velParam.put("locfmyard", JSPUtil.getNull(locfmyard));
			velParam.put("loctoyard", JSPUtil.getNull(loctoyard));
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchEqrLocYardLccInfoRSQL(), param, velParam);
            while(dbRowset.next()){
            	strYardInfo = dbRowset.getString(1);
            }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strYardInfo;
	}
	
	
	/**
	 * Vendor combo box 정보를 검색<br>
	 * 
	 * @param vendor_searchword String
	 * @return CommonVO getResultStrArray()
	 * @exception DAOException
	*/
	public CommonVO searchVendorInfo(String vendor_searchword) throws DAOException {
		
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String[] result = new String[2];
		StringBuffer inStr  = new StringBuffer();	
		StringBuffer inStr1	= new StringBuffer();
		int j			= 0;
		
		try {
			velParam.put("vendor_searchword", JSPUtil.getNull(vendor_searchword));
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOSearchVendorInfoRSQL(), null, velParam);
			while (dbRowset.next()){

				inStr.append(((j == 0) ? "" : "|") + dbRowset.getString ("VNDR_ABBR_NM").replaceAll("&","&amp;")+"\t" + dbRowset.getString("VNDR_CNT_CD")+ dbRowset.getString("VNDR_SEQ"));
				inStr1.append(((j == 0) ? "" : "|") + dbRowset.getString ("VNDR_CNT_CD") + dbRowset.getString("VNDR_SEQ"));
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
	 * Vendor 정보를 vendor seq 정보로 검색 (excel load 의 경우 사용)<br>
	 * 
	 * @param seq_searchword String
	 * @return CommonVO getResultStrArray()
	 * @exception DAOException
	*/
	public CommonVO searchVendorInfoBySeq(String seq_searchword) throws DAOException {
		
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		int j			= 0;
		
		String[] result = new String[3];

		StringBuffer inStr1	= new StringBuffer();
		StringBuffer inStr2	= new StringBuffer();
		StringBuffer inStr3	= new StringBuffer();

		
		try {
			param.put("seq_searchword", seq_searchword);
			
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOSearchVendorInfoBySeqRSQL(), param, null);
			
			while(dbRowset.next()){
				inStr1.append(((j == 0) ? "" : "|") + dbRowset.getString("VNDR_ABBR_NM"));
//				inStr2.append(((j == 0) ? "" : "|") + dbRowset.getString("VNDR_SEQ").trim());
//				inStr3.append(((j == 0) ? "" : "|") + dbRowset.getString("VNDR_CNT_CD").trim());
				inStr2.append(((j == 0) ? "" : "|") + dbRowset.getString("VNDR_SEQ"));
				inStr3.append(((j == 0) ? "" : "|") + dbRowset.getString("VNDR_CNT_CD"));
				
				break;
			}
			
			result[0] = inStr1.toString(); 
			result[1] = inStr2.toString(); 
			result[2] = inStr3.toString(); 
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
	 * VVD combo box 정보를 검색<br>
	 * 
	 * @param EesCommonConditionVO conditionVO
	 * @see EesCommonEvent
	 * @return CommonVO getResultStrArray()
	 * @exception DAOException
	 * @
	*/
	public CommonVO searchVvdInfo(EesCommonConditionVO conditionVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		String[] result = new String[1];
		StringBuffer inStr = new StringBuffer();	
		int j			= 0;
		
		try {
			param.put("vvd_repoplan_id", conditionVO.getVvdRepoplanid());
			param.put("vvd_plnyrwk", conditionVO.getVvdPlnyrwk());
			param.put("vvd_searchword", conditionVO.getVvdSearchword());
			
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOSearchVvdInfoRSQL(), param, null);
			while (dbRowset.next()){
//				inStr.append(((j == 0) ? "" : "|") + rs.getString ("VVD").trim());
				inStr.append(((j == 0) ? "" : "|") + dbRowset.getString ("VVD"));
				j++;
			}
			result[0] = inStr.toString();
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
	 * vvd combo box 정보를 검색
	 * Execute Plan Inland에서 Fixed Plan에서 Row Add 버튼 클릭시 To LOC(ECC), ETA Week 에 해당하는 정보를 검색
	 * 
	 * @param fm_loc
	 * @param to_loc
	 * @param eta_week
	 * @return CommonVO getResultStrArray()
	 * @see EesCommonEvent
	 * @exception DAOException	 
	*/
	public CommonVO searchVvdInlandInfo(String fm_loc, String to_loc, String eta_week) throws DAOException {
		
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		String[] result     = new String[6];
		StringBuffer inStr  = new StringBuffer();	
		StringBuffer inStr1	= new StringBuffer();
		
		int j			= 0;
		try {
			param.put("fm_loc", fm_loc);
			param.put("to_loc", to_loc);
			param.put("eta_week", eta_week);
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOSearchVvdInlandInfoRSQL(), param, null);
			while(dbRowset.next()) {
				inStr.append( 
							  ((j == 0) ? "" : "|") + dbRowset.getString("VVD").replaceAll("&","&amp;")      +" \t " 
								                    + dbRowset.getString("SLAN_CD").replaceAll("&","&amp;")  +" \t "
								                    + dbRowset.getString("FM_ETD_DT").replaceAll("&","&amp;")+" \t "
								                    + dbRowset.getString("TO_ETA_DT").replaceAll("&","&amp;")+" \t "
								                    + dbRowset.getString("FM_YD_CD").replaceAll("&","&amp;") +" \t "
								                    + dbRowset.getString("TO_YD_CD").replaceAll("&","&amp;")
					        );   // NAME
				
				inStr1.append(
						      ((j == 0) ? "" : "|") + dbRowset.getString("VVD").replaceAll("&","&amp;")      +"\t" 
						      						+ dbRowset.getString("SLAN_CD").replaceAll("&","&amp;")  +"\t"
						      						+ dbRowset.getString("FM_ETD_DT").replaceAll("&","&amp;")+"\t"
						      						+ dbRowset.getString("TO_ETA_DT").replaceAll("&","&amp;")+"\t"
						      						+ dbRowset.getString("FM_YD_CD").replaceAll("&","&amp;") +"\t"
						      						+ dbRowset.getString("TO_YD_CD").replaceAll("&","&amp;")						
				             );     // CODE
				
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
	 * vvd, lane 정보를 검색(execute plan INLAND WATER(080) 에서 사용) 
	 * division : etd - vsl_etd_dt 검색
	 *            eta - vsl_eta_dt 검색
	 * 
	 * @param division String
	 * @param vvd_searchword String
	 * @param ecc_cd String
	 * @param pln_yrwk String	 * 
	 * @return CommonVO getResultStrArray()
	 * @exception DAOException	 
	*/
	public CommonVO searchVvdExist(String division,  String vvd_searchword, String ecc_cd, String pln_yrwk) throws DAOException {
		
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String[] result     = new String[3];
		StringBuffer inStr  = new StringBuffer();	
		StringBuffer inStr1	= new StringBuffer();
		StringBuffer inStr2	= new StringBuffer();
		int j			= 0;
		
		String vsl_cd     = "";
		String skd_voy_no = "";
		String skd_dir_cd = "";
		
		try {
			vsl_cd     = vvd_searchword.substring(0,4);
			skd_voy_no = vvd_searchword.substring(4,8);
			skd_dir_cd = vvd_searchword.substring(8,9);	

			param.put("vsl_cd", vsl_cd);
			param.put("skd_voy_no", skd_voy_no);
			param.put("skd_dir_cd", skd_dir_cd);
			param.put("ecc_cd", ecc_cd);
			param.put("pln_yrwk", pln_yrwk);
			velParam.put("division", division);
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOSearchVvdExistRSQL(), param, velParam);
			
			while(dbRowset.next()) {
				inStr.append( ((j == 0) ? "" : "|") + dbRowset.getString("VVD").replaceAll("&","&amp;"));   // VVD CODE
				inStr1.append(((j == 0) ? "" : "|") + dbRowset.getString("SLAN_CD"));                   // SLAN CODE
				inStr2.append(((j == 0) ? "" : "|") + dbRowset.getString("VSL_DT"));                        // ETA, ETD
				j++;
			}
			
			result[0] = inStr.toString();
			result[1] = inStr1.toString();
			result[2] = inStr2.toString();
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
	 * WATER에서 사용가능한 VVD인지 확인
	 * BSA가 있는 VVD는 WATER에서 사용 불가함.
	 * @param scnrid   
	 * @param vvd_searchword
	 * 
	 * @return CommonVO getResultString()
	 * @see EesCommonEvent
	 * @exception DAOException	 
	*/
	public CommonVO checkVvdWater(String scnrid,  String vvd_searchword) throws DAOException {
		
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		String result    = "";
		int count        = 0;
		
		String vsl_cd     = "";
		String skd_voy_no = "";
		String skd_dir_cd = "";
		
		try {
			
			
			vsl_cd     = vvd_searchword.substring(0,4);
			skd_voy_no = vvd_searchword.substring(4,8);
			skd_dir_cd = vvd_searchword.substring(8,9);			

			param.put("scnrid", scnrid);
			param.put("vsl_cd", vsl_cd);
			param.put("skd_voy_no", skd_voy_no);
			param.put("skd_dir_cd", skd_dir_cd);

			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOCheckVvdWaterRSQL(), param, null);
			while(dbRowset.next()) {
				count = dbRowset.getInt("RESULT");   // VVD CODE
			}
			
			if(count > 0) result = "FALSE";
			else          result = "TRUE";
			
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

	/**
	 * Week에 해당하는 ScnrId 정보를 검색<br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return CommonVO getResultString()
	 * @exception DAOException
	*/
	public CommonVO searchWeekScnrId(EesCommonConditionVO conditionVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String plnyrwk = "";
		StringBuffer inStr = new StringBuffer();	
		int j			= 0;
		plnyrwk = conditionVO.getFmYr()+conditionVO.getFmWk();
		
	    
		try {
			velParam.put("gubun",conditionVO.getGubun());
			param.put("plnyrwk", plnyrwk);
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOSearchWeekScnrIdRSQL(), param, velParam);
			while (dbRowset.next()){
//				inStr.append(((j == 0) ? "" : "|") + rs.getString ("SCNR_ID").trim());
				inStr.append(((j == 0) ? "" : "|") + dbRowset.getString ("SCNR_ID"));
				j++;
			}
			retVO.setResultSB(inStr);

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

	/** ECC CODE 의 국가코드와 국가명을 검색
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return CommonVO
	 * @exception DAOException
	 */
	public CommonVO searchCountryInfo(EesCommonConditionVO conditionVO) throws DAOException {
		
		
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		int j = 0;
		StringBuffer inStr  = new StringBuffer();
		StringBuffer inStr1 = new StringBuffer();
		
		String[] country = new String[2];
	
		try {
			param.put("country",conditionVO.getCountry()+'%');
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOSearchCountryInfoRSQL(), param, null);
			
			while (dbRowset.next()) {
				inStr.append(((j == 0) ? "" : "*") + dbRowset.getString("TITLE").replaceAll("&","&amp;"));
//				inStr1.append(((j == 0) ? "" : "*") + rs.getString("cnt_cd").trim());
				inStr1.append(((j == 0) ? "" : "*") + dbRowset.getString("CNT_CD"));
				j++;
			} 
			if(conditionVO.getCountry().toUpperCase().equals("H")){
				inStr.append(((j == 0) ? "" : "*") + "HK|HONGKONG");
				inStr1.append(((j == 0) ? "" : "*") + "HK");
			}
			
			country[0] = inStr.toString();
			country[1] = inStr1.toString();
			retVO.setResultStrArray(country);

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
	 * present Week & GapWeek 정보를 검색<br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return CommonVO getResultStrArray()
	 * @see EesCommonEvent
	 * @exception DAOException
	*/
	public CommonVO searchCheckPeriod(EesCommonConditionVO conditionVO) throws DAOException {
		return searchCheckPeriod(conditionVO ,conditionVO.getGubun());
	}			
	
	/**
	 * edit Week & GapWeek 정보를 검색<br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @param gubun String :  E(edit week)
	 * @return CommonVO
	 * @exception DAOException
	*/
	public CommonVO searchCheckPeriod(EesCommonConditionVO conditionVO, String gubun) throws DAOException {
		DBRowSet dbRowset = null;
		DBRowSet dbRowset2 = null;
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//query parameter
		Map<String, Object> param2 = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String[] result = new String[4];
		
		StringBuffer inStr = new StringBuffer();
		StringBuffer inStr2= new StringBuffer();
		
		
		int j= 0;
		int j2= 0;
		
		
		try {
			SQLExecuter sQLExecuter = new SQLExecuter(strDs);
			if(gubun != null && gubun.equals("Load")){
				param.put("month", conditionVO.getGapmonth());
				param.put("check_pln_yrwk", "");
				param2.put("month", conditionVO.getEditmonth());
				param2.put("check_pln_yrwk", "");
				velParam.put("gubun",gubun);
				velParam.put("check_gubun","Load");
				dbRowset = sQLExecuter.executeQuery((ISQLTemplate)new CommonDBDAOSearchCheckPeriodRSQL(), param, velParam);
				dbRowset2 = sQLExecuter.executeQuery((ISQLTemplate)new CommonDBDAOSearchCheckPeriodRSQL(), param2, velParam);
				
				 while (dbRowset.next()){
					 inStr.append(((j == 0) ? "" : ",") + dbRowset.getString ("PLN_YRWK"));
					 j++;
				 }
				 while (dbRowset2.next()){
					 inStr2.append(((j2 == 0) ? "" : ",") + dbRowset2.getString ("PLN_YRWK"));
					 j2++;
				 }
//				 log.debug("\n inStr ----------------- "+inStr);
//				 log.debug("\n inStr2 ---------------- "+inStr2);
				
				 result[0] = inStr.toString();
				 result[1] = inStr2.toString();
				 retVO.setResultStrArray(result);
			}else{
				if(gubun != null) velParam.put("gubun",gubun);
				velParam.put("check_gubun","Load"); 
				param.put("month", conditionVO.getGapmonth());
				param.put("check_pln_yrwk", conditionVO.getFmYr()+conditionVO.getFmWk());
				dbRowset = sQLExecuter.executeQuery((ISQLTemplate)new CommonDBDAOSearchCheckPeriodRSQL(), param, velParam);
				 while (dbRowset.next()){
					 inStr2.append(((j == 0) ? "" : ",") + dbRowset.getString ("PLN_YRWK"));
					 j++;
				 }
				result[0] = "";
				result[1] = inStr2.toString();
				retVO.setResultStrArray(result);
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
	 * edit Week & GapWeek 정보를 검색(Fm To At 화면.)<br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return  CommonVO getresultStrArray()
	 * @see EesCommonEvent
	 * @exception DAOException
	*/
	public CommonVO searchCheckPeriodOpt(EesCommonConditionVO conditionVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		String[] result = new String[4];
		
		StringBuffer inStr2 = new StringBuffer();
		StringBuffer inStr3 = new StringBuffer();
		StringBuffer inStr4 = new StringBuffer();
		
		int j= 0;
		
		try {
			//화면(EES_EQR_037)에서 fm주차 도는 to주차를 빈값으로 만드는 경우가 있어 아래와같이 수정함.(yangjr)
			//select 된 row 수가 12 건으로 항상 맞아야한다.
			param.put("yrwk_01", (conditionVO.getFmYrwk().equals("")) ? conditionVO.getToYrwk() : conditionVO.getFmYrwk());
			param.put("yrwk_02", (conditionVO.getToYrwk().equals("")) ? conditionVO.getFmYrwk() : conditionVO.getToYrwk());
			param.put("yrwk_03", conditionVO.getAtYrwk());
			param.put("month", conditionVO.getEditmonth());
			
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOSearchCheckPeriodOptRSQL(), param, null);
			
			int tmpInt = Integer.valueOf(conditionVO.getEditmonth()).intValue();
//			log.debug("\n tmpInt ------------------ "+tmpInt);
			
			 while (dbRowset.next()){
				 if(j < tmpInt){
					 inStr2.append(((j == 0) ? "" : ",") + dbRowset.getString ("PLN_YRWK"));
				 }
				 if(j >= tmpInt && j < tmpInt*2){
					 inStr3.append(((j == tmpInt) ? "" : ",") + dbRowset.getString ("PLN_YRWK"));
				 }
				 if(j >= tmpInt*2){
					 inStr4.append(((j == tmpInt*2) ? "" : ",") + dbRowset.getString ("PLN_YRWK"));
				 }
				 j++;
				 
			 }
			
			 result[0] = "";
			 result[1] = inStr2.toString();
			 result[2] = inStr3.toString();
			 result[3] = inStr4.toString();
//			 log.debug("\n inStr2 = "+inStr2);
//			 log.debug("\n inStr3 = "+inStr3);
//			 log.debug("\n inStr4 = "+inStr4);
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
	 *  eqr_wk_prd 의 기준 주차 값에 해당하는 wk_st_dt  값 조회
	 *  
	 * @param yyyyww String
	 * @return CommonVO getResultString()
	 * @exception DAOException
	 */
	public CommonVO searchWeekToDate(String yyyyww) throws DAOException {
		
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		
		String stdt = "";	
		
		try {
			param.put("yyyyww",yyyyww);
			
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOSearchWeekToDateRSQL(), param, null);
			
			if (dbRowset.next()) {
				stdt = dbRowset.getString(1);
			}			 
			retVO.setResultString(stdt); 			
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
	 * EQR_WK_PRD 의 WK_END_DT 조회
	 * 
	 * @param yyyyww String
	 * @return CommonVO getResultString()
	 * @exception DAOException
	 */
	public CommonVO searchWeekEndDate(String yyyyww) throws DAOException {
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		String eddt = "";
		
		try {
			param.put("yyyyww",yyyyww);
			
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOSearchWeekEndDateRSQL(), param, null);
			
			if (dbRowset.next()) {
				eddt = dbRowset.getString(1);
			}			 
			 			
			retVO.setResultString(eddt);
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
	 * 
	 * @param yyyyww String
	 * @param gapmonth String
	 * @return CommonVO getResultString()
	 * @exception DAOException
	 */
	public CommonVO searchWeekStartDate(String yyyyww, String gapmonth) throws DAOException {		
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();		
		String stdt = "";	
		
		try {
			param.put("gapmonth",gapmonth);
			param.put("yyyyww",yyyyww);
			
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOSearchWeekStartDateRSQL(), param, null);
			if (dbRowset.next()) {
				stdt = dbRowset.getString(1);
			}			 
			retVO.setResultString(stdt); 
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
	 * day정보를 week로 변경
	 * 
	 * @param date String
	 * @return CommonVO getResultString()
	 * @exception DAOException
	 */
	public CommonVO convertDayWeekly(String date) throws DAOException {		
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();		
		String week    = "";
		
		try {
			param.put("date", date);
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOConvertDayWeeklyRSQL(), param, null);
			
			if (dbRowset.next()) {
				week = dbRowset.getString(1);
			}			 
			retVO.setResultString(week);
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
	 * execution plan 에서 plan 의 yrwk이 현재 local 의 yrwk 보다 작으면 edit 불가.(SAVE Button과 기타 수정버튼에 적용됨)
	 * @param yyyyww String
	 * @param localDate String
	 * @return CommonVO getResultString()
	 * @exception DAOException
	 */
	public CommonVO exePlnEditFlg(String yyyyww, String localDate) throws DAOException {
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		String exePlnEditFlg = "";	
		
		try {
			param.put("yyyyww", yyyyww);
			param.put("localDate", localDate);
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOExePlnEditFlgRSQL(), param, null);
			
			if (dbRowset.next()) {
				exePlnEditFlg = dbRowset.getString(1);
			}			 
			retVO.setResultString(exePlnEditFlg); 	
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
	 * execution plan 에서 plan 의 yrwk이 현재 local 의 yrwk 보다 한주이상 작으면edit 불가.(VD Add 버튼에 적용됨)
	 * local week 가 plan week보다 한주 작은것 까지는 수정을 허용
	 * 059 VD ADD에 적용함.
	 * 
	 * @param yyyyww
	 * @param localDate
	 * @return CommonVO getResultString()
	 * @exception DAOException
	 */
	public CommonVO exePlnEditFlgPrevOneWeek(String yyyyww, String localDate) throws DAOException {
		
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		String exePlnEditFlg = "";	
		
		try {
			param.put("yyyyww", yyyyww);
			param.put("localDate", localDate);
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOExePlnEditFlgPrevOneWeekRSQL(), param, null);
		
			if (dbRowset.next()) {
				exePlnEditFlg = dbRowset.getString(1);
			}			 
			retVO.setResultString(exePlnEditFlg); 	
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
	 * 주차를 넣어서 해당되는 일주일 년월일을 가져온다. 
	 * @param conditionVO EesCommonConditionVO
	 * @return CommonVO getResultString()
	 * @exception DAOException
	 */	
	public CommonVO searchBetweenWeek(EesCommonConditionVO conditionVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		int j= 0;
				
		try {
			param.put("weekly_searchWord", conditionVO.getWeeklySearchword());
			
			
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOSearchBetweenWeekRSQL(), param, null);
			
			StringBuffer weekList = new StringBuffer();
			
			while (dbRowset.next()){
				weekList.append(((j == 0) ? "" : ",") + dbRowset.getString ("DAY"));
				j++;
			}
			retVO.setResultSB(weekList);
		
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

	/** 기존 REPO_PLN_ID의 특성을 찾아 온다.  
	 * @param repo_plan_id  String
	 * @return CommonVO getResultStrArray()
	 * @exception DAOException
	 */
	public CommonVO searchOldRepoPlantype(String repo_plan_id) throws DAOException {
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		String[] returnStr= new String[4]; 
		
		try{
			param.put("repo_plan_id", repo_plan_id);
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOSearchOldRepoPlantypeRSQL(), param, null);
		
			 
			while (dbRowset.next()){
	//			 returnStr[0]= rs.getString("INCL_ONH_FLG").trim();
	//			 returnStr[1]= rs.getString("INCL_OFFH_FLG").trim();
	//			 returnStr[2]= rs.getString("INCL_CNTR_TPSZ_CTNT").trim();
	//			 returnStr[3]= rs.getString("DURATION").trim();
				 returnStr[0]= dbRowset.getString("INCL_ONH_FLG");
				 returnStr[1]= dbRowset.getString("INCL_OFFH_FLG");
				 returnStr[2]= dbRowset.getString("INCL_CNTR_TPSZ_CTNT");
				 returnStr[3]= dbRowset.getString("DURATION");
			}
			retVO.setResultStrArray(returnStr);
		
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

	/** 새로운 시나리오를 생성한다. 
	 * @param scnr_id String
	 * @return CommonVO getResultString()
	 * @exception DAOException
	 */
	
	public CommonVO  createNewScnarioId(String scnr_id) throws DAOException {
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		String  new_Scnr_id = "";
		String  scnr_max    = "";
		
		try{
			param.put("scnr_id",scnr_id);
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOCreateNewScnarioIdRSQL(), param, null);
			 
			if (dbRowset.next()){
				  
				scnr_max =  Utils.fill(String.valueOf(dbRowset.getInt("SCNR_MAX")), 3, "0", "left");
				new_Scnr_id = scnr_id.substring(0,11)+ scnr_max;  //새로운 시나리오 아이디  생성 
			  
//				log.debug("new_Scnr_id =========>" + new_Scnr_id);
			}
			retVO.setResultString(new_Scnr_id);	
			
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

	/** 새로운 REPO_PLN_ID를 생성한다. 
	 * @param repo_plan_id String
	 * @return CommonVO getResultString()
	 * @exception DAOException
	 */
	public CommonVO  createNewRepoPlanId(String repo_plan_id) throws DAOException {
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		String  new_Repo_id = "";
		String  repo_max     = "";  // repo_pln_id의 max값을 구한다. 
		
		try{
			param.put("repo_plan_id",repo_plan_id);
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOCreateNewRepoPlanIdRSQL(), param, null);
			
			if (dbRowset.next()){
				repo_max = Utils.fill(String.valueOf(dbRowset.getInt("REPO_MAX")), 3, "0", "left");
				new_Repo_id = repo_plan_id.substring(0,11) + repo_max;  //새로운 REPO_PLN_ID 생성 
			}
			
			retVO.setResultString(new_Repo_id);	
			
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
	 * week date period (start date, to date) 검색
	 * 
	 * @param week
	 * @param division
	 * @return CommonVO getResultStrArray()
	 * @exception DAOException
	 */
	public CommonVO searchWeekDatePeriod(String week, String division) throws DAOException {
		
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String fromToDate[] = new String[2];
		
		try {
			param.put("week", week);
			velParam.put("division", division);
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOSearchWeekDatePeriodRSQL(), param, velParam);
			
			if (dbRowset.next()) {
				fromToDate[0] = dbRowset.getString("WK_ST_DT");
				fromToDate[1] = dbRowset.getString("WK_END_DT");
			} 
			retVO.setResultStrArray(fromToDate);
			
			
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
	 * search eta date 검색
	 * INLAND(080), ON-OFF HIRE(081) 에서 사용함 
	 * item=R, fryard cnt=US||CA && toyard cnt= US||CA 인 경우는 다른 조회쿼리를 사용함. 
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return CommonVO getResultString()
	 * @exception DAOException
	 */
	public CommonVO searchEtaDate(EesCommonConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String etaDate = null;  //return value
		
		String searchword = conditionVO.getSearchetaSearchword();  // ETD 정보
		String fryard     = conditionVO.getSearchetaFryard();      // FROM YARD
		String toyard     = conditionVO.getSearchetaToyard();      // TO YARD
		String item       = conditionVO.getSearchetaItem();        // TRSP MODE
		String railMode   = "N";                              // Y : item=R, fryard cnt=US||CA && toyard cnt= US||CA 인 경우 
		                                                      // N : 나머지
		String fryard_cnt = "";                               // FROM YARD COUNTRY CODE
		String toyard_cnt = "";                               // TO   YARD COUNTRY CODE
		
		// item=R, fryard cnt=US||CA && toyard cnt= US||CA 인 경우는 다른 조회쿼리를 사용함. 
		if(item.equals("R")) {
			fryard_cnt = getYardCNTCode(fryard).getResultString();
			toyard_cnt = getYardCNTCode(toyard).getResultString();
			
			if((fryard_cnt.equals("US") || fryard_cnt.equals("CA")) && (toyard_cnt.equals("US") || toyard_cnt.equals("CA"))) {
				railMode   = "Y";  // RAIL-US 쿼리로 ETA 조회함
			}
		}
		
//		log.debug("-- item 			 : " + item);
//		log.debug("-- fryard_cnt 	 : " + fryard_cnt);
//		log.debug("-- itemtoyard_cnt : " + toyard_cnt);
//		log.debug("-- railMode 		 : " + railMode);
			
		
		try {
			param.put("etd", searchword);
			param.put("fryard", fryard);
			param.put("toyard", toyard);
			param.put("item", item);
			velParam.put("railMode", railMode);
			velParam.put("item", item);
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOSearchEtaDateRSQL(), param, velParam);
			
			if (dbRowset.next()) {
				etaDate = dbRowset.getString("ETA");
			} 			
			
			if(etaDate != null) retVO.setResultString(etaDate);
			return retVO;
			
						
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
	}	

	/**
	 * search eta date 검색
	 * INLAND(080), ON-OFF HIRE(081) 에서 사용함 
	 * item=R, fryard cnt=US||CA && toyard cnt= US||CA 인 경우는 다른 조회쿼리를 사용함. 
	 * 
	 * @param etd
	 * @param fryard
	 * @param toyard
	 * @param item
	 * @return CommonVO getResultString()
	 * @exception DAOException
	 */
	public CommonVO searchEtaDate(String etd, String fryard, String toyard, String item) throws DAOException {
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		
		String etaDate = null;  //return value		
		String railMode   = "N";                              // Y : item=R, fryard cnt=US||CA && toyard cnt= US||CA 인 경우 
		                                                      // N : 나머지
		String fryard_cnt = "";                               // FROM YARD COUNTRY CODE
		String toyard_cnt = "";                               // TO   YARD COUNTRY CODE
		
		// item=R, fryard cnt=US||CA && toyard cnt= US||CA 인 경우는 다른 조회쿼리를 사용함. 
		if(item.equals("R")) {
			fryard_cnt = getYardCNTCode(fryard).getResultString();
			toyard_cnt = getYardCNTCode(toyard).getResultString();
			
			if((fryard_cnt.equals("US") || fryard_cnt.equals("CA")) && (toyard_cnt.equals("US") || toyard_cnt.equals("CA"))) {
				railMode   = "Y";  // RAIL-US 쿼리로 ETA 조회함
			}
		}
		
//		log.debug("-- item 			 : " + item);
//		log.debug("-- fryard_cnt 	 : " + fryard_cnt);
//		log.debug("-- itemtoyard_cnt : " + toyard_cnt);
//		log.debug("-- railMode 		 : " + railMode);
		
		
		try {
			param.put("etd", etd);
			param.put("fryard", fryard);
			param.put("toyard", toyard);
			param.put("item", item);
			velParam.put("railMode", railMode);
			velParam.put("item", item);
			
			
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOSearchEtaDateRSQL(), param, velParam);
			
			if (dbRowset.next()) {
				etaDate = dbRowset.getString("ETA");
			} 
			
			if(etaDate==null || etaDate.equals("")) {
				etaDate = "";
			}
			retVO.setResultString(etaDate);
			
			
						
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
	 * Yard Code의 Country code 를 검색해 옵니다. 
	 * 
	 * @param  yard_code
	 * @return CommonVO  getResultString()
	 * @exception DAOException
	 */	
	public CommonVO getYardCNTCode(String yard_code) throws DAOException {
		
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		StringBuffer inStr  = new StringBuffer();
		int j = 0;
		
		try {
			param.put("yard_code", yard_code.substring(0,5));
			
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOGetYardCNTCodeRSQL(), param, null);
			while(dbRowset.next()) {
				inStr.append(((j == 0) ? "" : ",") + dbRowset.getString("CNT_CD")); 
				j++;
			}		
			retVO.setResultSB(inStr);
//			log.debug("\n ------------------- tpsz initial returnStr : " +inStr.toString());
		
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
	 * user 별 office code의 해당 지역정보(location information)
	 * level : R --> RCC_CD
	 *         L --> LCC_CD
	 *         
	 * @param ofc_cd
	 * @param level
	 * @return CommonVO  getResultString()
	 * @exception DAOException
	 */
	public CommonVO getUserLocInfo(String ofc_cd, String level) throws DAOException {
		
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String result 	     = "";
		
		String columnName = "";
		
		if(level.equals("R")) columnName = "RCC_CD";
		else                  columnName = "LCC_CD";
		
		try {
			param.put("ofc_cd", ofc_cd);
			velParam.put("columnName", columnName);
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOGetUserLocInfoRSQL(), param, velParam);
			while (dbRowset.next()){
				result = dbRowset.getString (1);
				break;
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

	/**
	 * 주차를 넣어서 해당되는 일주일 년월일을 가져온다. 
	 * Search next week repo plan id (sysdate+7)
	 * 리턴 값의 getResultStrArray() 사용
	 * 
	 * @return CommonVO 
	 * @exception DAOException
	 */	
	public CommonVO searchMaxRepoPlanId() throws DAOException {
		
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		
		String[] returnStr = new String[2];
		
		try {
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOSearchMaxRepoPlanIdRSQL(), null, null);
			
			while(dbRowset.next()) {
				 if(dbRowset.getString("WEEK")==null || dbRowset.getString("SEQ")==null) {
					 returnStr[0] = "";
					 returnStr[1] = "";
				 }else {
					 returnStr[0]= dbRowset.getString("WEEK");
					 returnStr[1]= dbRowset.getString("SEQ");
				 }	 
				 
			}			
			retVO.setResultStrArray(returnStr);
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
	 * COM_INTG_CD_DTL 테이블의 type size initial 코드 정보를 조회합니다.
	 * 
	 * @return CommonVO 
	 * @exception DAOException
	 */	
	public CommonVO getTpszInitial() throws DAOException {
		
		//EES_COMMONEvent event=(EES_COMMONEvent)et;
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		
		StringBuffer inStr  = new StringBuffer();
		int j = 0;
		
		try {
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOGetTpszInitialRSQL(), null, null);
			
			
			while(dbRowset.next()) {
				inStr.append(((j == 0) ? "" : ",") + dbRowset.getString("INTG_CD_VAL_CTNT")); 
				j++;
			}		
			
			retVO.setResultSB(inStr);
			
//			log.debug("\n ------------------- tpsz initial returnStr : " +inStr.toString());
		
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
	 * COM_INTG_CD_DTL 테이블의 type size initial 코드 정보를 조회합니다.
	 * 
	 * @return CommonVO 
	 * @exception DAOException
	 */	
	public CommonVO getTpszDefault() throws DAOException {
		
		//EES_COMMONEvent event=(EES_COMMONEvent)et;
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		
		StringBuffer inStr  = new StringBuffer();
		int j = 0;
		
		try {
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOGetTpszDefaultRSQL(), null, null);
			
			
			while(dbRowset.next()) {
				inStr.append(((j == 0) ? "" : ",") + dbRowset.getString("INTG_CD_VAL_CTNT")); 
				j++;
			}		
			
			retVO.setResultSB(inStr);
			
//			log.debug("\n ------------------- tpsz initial returnStr : " +inStr.toString());
		
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
	 * EQR_VSL_LODG_DCHG_PLN 테이블의 중복여부 확인
	 * 
	 * @param  conditionVO EesCommonConditionVO
	 * @return CommonVO 
	 * @exception DAOException
	 */	
	public CommonVO searchDuplicatCheckPod(EesCommonConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		String inStr  = "";
		int j = 0;
		
		try {
			param.put("pod_repo_pln_id", conditionVO.getPodRepoPlnId());
			param.put("pod_wk", conditionVO.getPodWk());
			param.put("pod_lane", conditionVO.getPodLane());
			param.put("pod_vvd", conditionVO.getPodVvd());
			param.put("pod_pol", conditionVO.getPodPol());
			param.put("pod_etd", conditionVO.getPodEtd());
			param.put("pod_pod", conditionVO.getPodPod());
			param.put("pod_etb", conditionVO.getPodEta());
			
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOSearchDuplicatCheckPodRSQL(), param, null);
			
			if (dbRowset.next()) {
				j = dbRowset.getInt("CHECKCOUNT");
				
				if (j > 0 ){
					inStr = "F";
				}
			}		
			retVO.setResultString(inStr);		
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

	/** CSRNO : N200806030017 의거 추가 
	 * present Week & GapWeek 정보를 검색<br>
	 * 현재 주차 보다 -8주차 정보를 가져오기 위해서 
	 * @param conditionVO EesCommonConditionVO
	 * @return CommonVO getResultStrArray()
	 * @see EesCommonEvent
	 * @exception DAOException
	*/
	public CommonVO searchBeforeCheckPeriod(EesCommonConditionVO conditionVO) throws DAOException {
		return searchBeforeCheckPeriod(conditionVO,conditionVO.getGubun());
	}			
	
	/**
	 * edit Week & GapWeek 정보를 검색<br>
	 * 현재 주차 보다 -8주차 정보를 가져오기 위해서 
	 * @param conditionVO EesCommonConditionVO
	 * @param gubun :  E(edit week)
	 * @return CommonVO getResultStrArray()
	 * @see EesCommonEvent
	 * @exception DAOException
	*/
	public CommonVO searchBeforeCheckPeriod(EesCommonConditionVO conditionVO, String gubun) throws DAOException {		
		DBRowSet dbRowset = null;
		DBRowSet dbRowset2 = null;
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//query parameter
		Map<String, Object> param2 = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String[] result = new String[4];		
		StringBuffer inStr = new StringBuffer();
		StringBuffer inStr2= new StringBuffer();
		
		int j= 0;
		int j2= 0;
		
		try {
			SQLExecuter sQLExecuter = new SQLExecuter(strDs);
			if(gubun != null && gubun.equals("Match")){
				param.put("month", conditionVO.getGapmonth());
				param.put("check_pln_yrwk", "");
				param2.put("month", conditionVO.getEditmonth());
				param2.put("check_pln_yrwk", "");
				velParam.put("gubun", gubun);
				velParam.put("check_gubun","Match");
				dbRowset = sQLExecuter.executeQuery((ISQLTemplate)new CommonDBDAOSearchBeforeCheckPeriodRSQL(), param, velParam);
				dbRowset2 = sQLExecuter.executeQuery((ISQLTemplate)new CommonDBDAOSearchBeforeCheckPeriodRSQL(), param2, velParam);
				while (dbRowset.next()){
					 inStr.append(((j == 0) ? "" : ",") + dbRowset.getString ("PLN_YRWK"));
					 j++;
				}
				while (dbRowset2.next()){
					 inStr2.append(((j2 == 0) ? "" : ",") + dbRowset2.getString ("PLN_YRWK"));
					 j2++;
				}
				result[0] = inStr.toString();
				result[1] = inStr2.toString();
				retVO.setResultStrArray(result);
			}else{
				param.put("month", conditionVO.getEditmonth());
				param.put("check_pln_yrwk", conditionVO.getFmYr()+conditionVO.getFmWk());
				if(gubun != null) velParam.put("gubun", gubun);
				velParam.put("check_gubun","Match");
				dbRowset = sQLExecuter.executeQuery((ISQLTemplate)new CommonDBDAOSearchBeforeCheckPeriodRSQL(), param, velParam);
				while (dbRowset.next()){
					 inStr2.append(((j == 0) ? "" : ",") + dbRowset.getString ("PLN_YRWK"));
					 j++;
				}
				
				result[0] = "";
				result[1] = inStr2.toString();
				retVO.setResultStrArray(result);
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
	 * vessel schedule 정보 조회
	 * @param conditionVO EesCommonConditionVO
	 * @return  CommonVO  getResultStrArray()
	 * @see EesCommonEvent
	 * @exception DAOException
	*/
	public CommonVO searchVesselScheduleCheck(EesCommonConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		String[] result = new String[4];
		try {
			param.put("vsl_cd", conditionVO.getVslCd());
			param.put("skd_voy_no", conditionVO.getSkdVoyNo());
			param.put("skd_dir_cd", conditionVO.getSkdDirCd());
			param.put("vsl_port_cd", conditionVO.getVslPortCd());
			param.put("slan_cd", conditionVO.getSlanCd());
			param.put("fm_wk", conditionVO.getFmWk());
			param.put("to_wk", conditionVO.getToWk());
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOSearchVesselScheduleCheckRSQL(), param, null);
			while (dbRowset.next()){
				result[0] = dbRowset.getString("VPS_ETA_DT");
				result[1] = dbRowset.getString("VPS_ETB_DT");
				result[2] = dbRowset.getString("VPS_ETD_DT");
				result[3] = dbRowset.getString("YD_CD");
			}
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
	 * 신규프로젝트 No: S2Q-09P-004
	 * 해당 VVD에 대한 BayPort List 
	 * @param conditionVO EesCommonConditionVO
	 * @return  CommonVO  getResultStrArray()
	 * @see EesCommonEvent
	 * @exception DAOException
	*/
	public CommonVO searchBayPort(EesCommonConditionVO conditionVO) throws DAOException {		
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		String[] result= new String[2];
		String vvd = conditionVO.getVvd();
		int j= 0;
		StringBuffer portStr	= new StringBuffer();
		StringBuffer seqStr		= new StringBuffer();
		
		try {
			param.put("vvd_04", vvd.substring(0,4));
			param.put("vvd_48", vvd.substring(4,8));
			param.put("vvd_89", vvd.substring(8,9));
			
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOSearchBayPortRSQL(), param, null);
			while (dbRowset.next()){
				portStr.append( ((j == 0) ? "" : "*") + dbRowset.getString("NAME").replaceAll("&","&amp;"));
				seqStr.append( ((j == 0) ? "" : "*") + dbRowset.getString("CODE").replaceAll("&","&amp;"));
				j++;
			}
			 
			result[0] = portStr.toString();
			result[1] = seqStr.toString();
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
	 * CSR No: N200904200110
	 * 해당 VVD에 대한 Lane
	 * @param conditionVO EesCommonConditionVO
	 * @return CommonVO getResultStrArray()
	 * @see EesCommonEvent
	 * @exception DAOException
	*/
	public CommonVO searchLane(EesCommonConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		String[] result= new String[2];
		
		try {
			param.put("vsl_cd", conditionVO.getVslCd());
			param.put("skd_voy_no", conditionVO.getSkdVoyNo());
			param.put("skd_dir_cd", conditionVO.getSkdDirCd());
			param.put("fr_yyyy_week", conditionVO.getFrYyyy()+conditionVO.getFrWeek());
			param.put("to_yyyy_week", conditionVO.getToYyyy()+conditionVO.getToWeek());
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOSearchLaneRSQL(), param, null);	
			while (dbRowset.next()){
				result[0] =  dbRowset.getString("COMPANY");
				result[1] =  dbRowset.getString("VSL_SLAN_CD");
			}
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
	 * CSR No: N200904200110
	 * 해당 VVD에 대한 기존에 존재하는지 체크
	 * @param conditionVO EesCommonConditionVO
	 * @return CommonVO getResultString()
	 * @see EesCommonEvent
	 * @exception DAOException
	*/
	public CommonVO searchCheckEqrScnrVsl(EesCommonConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		String result= "";
		
		
		try {
			param.put("scnr_id", conditionVO.getScnrId());
			param.put("vsl_cd", conditionVO.getVslCd());
			param.put("skd_voy_no", conditionVO.getSkdVoyNo());
			param.put("skd_dir_cd", conditionVO.getSkdDirCd());
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOSearchCheckEqrScnrVslRSQL(), param, null);
			while (dbRowset.next()){
				result =  dbRowset.getString("CHECK_YN");
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
	
	/**
	 * REPO_PLN_ID, PLN_YRWK 를 기준으로 대상 테이블의 Next PLN_SEQ 를 취득한다.
	 * 
	 * @param tableName
	 * @param repoPlnId
	 * @param plnYrwk
	 * @return CommonVO getResultString()
	 * @see EesCommonEvent
	 * @exception DAOException
	*/
	public CommonVO getNextPlnSeq(String tableName, String repoPlnId, String plnYrwk) throws DAOException {
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String result= "";
		
		try {
			velParam.put("table", tableName);
			param.put("repo_pln_id", repoPlnId);
			param.put("pln_yrwk", plnYrwk);
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOGetNextPlnSeqRSQL(), param, velParam);
			while (dbRowset.next()){
				result =  dbRowset.getString("NEXT_PLN_SEQ");
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
	
	/**
	 * 특정 user가 059,080,081,083 에서 전주차 접근권한을 가진유저인지 확인
	 * EQR_EXE_PLN_USR 테이블에 존재하는 user id 는 위의 화면에서 전주차 접근 가능함
	 * 
	 * @param userid
	 * @return CommonVO getResultString()
	 * @exception DAOException
	 */
	public CommonVO checkFullAccessUser(String userid) throws DAOException {
		
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		Map<String, Object> param = new HashMap<String, Object>();
		
		String result = "FALSE";
		int j        = 0;
		
		try {
			param.put("userid", userid); // userid 검색정보
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOCheckFullAccessUserRSQL(), param, null);
		
			if (dbRowset.next()) {
				j = dbRowset.getInt("CHECKCOUNT");
				
				if (j > 0) result = "TRUE"; // F059,080,081,083 에서 전주차 접근권한을 가진유저를 의미함
				
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
	
	 /**
	 * USR_ID를 기준으로 COM_USER 테이블에서 USR_NM, OFC_CD를 취득한다.
	 * 
	 * @param usrId String
	 * @return CommonVO
	 * @exception DAOException
	 */
	public CommonVO getUserInfo(String usrId) throws DAOException {
		DBRowSet dbRowset = null;
		CommonVO retVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("usr_id", usrId);
			dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOGetUserInfoRSQL(), param, null);
			
			retVO.setDbRowset(dbRowset);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return retVO;
	}
	
	/**
	 * plan 주차의 row 존재확인
	 * 
	 * @param repoPlanId String
	 * @return CommonVO
	 * @exception DAOException
	 */
	
	public CommonVO checkRepoPlanIdRow(String repoPlanId) throws DAOException {
		DBRowSet dbRowSet = null;
		CommonVO resultVO = new CommonVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		boolean resultBoolean = false;
		
		try{
			param.put("repo_plan_id",repoPlanId);
			dbRowSet = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOChcekRepoPlanIdRowRSQL(), param, null);
			 
			if (dbRowSet.next()) {
				int rowCnt  =  dbRowSet.getInt("ROW_CNT");

				if (rowCnt == 0) {
					resultBoolean = true;
				} else {
					resultBoolean = false;
				}
			}
			
			resultVO.setResultBoolean(resultBoolean);
			
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
		
		return resultVO;
	}
	
	/**
	 * EQR Week 연도별 조회
	 * 
	 * @param plnYr String
	 * @return List<EqrWkPrdVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EqrWkPrdVO> searchEqrWkPrd(String plnYr) throws DAOException {
		 
		DBRowSet dbRowset = null;
		List<EqrWkPrdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		try {
			param.put("pln_yr", plnYr);
			velParam.put("pln_yr", plnYr);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchEqrWkPrdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EqrWkPrdVO.class);
			
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
	
	/**
	 * EQR Week 등록 이전의 연도와 주차 여부 체크
	 * 
	 * @param List<EqrWkPrdVO> eqrWkPrdList
	 * @exception DAOException
	 */
	public void searchDuplicateCheckEqrWkPrd(List<EqrWkPrdVO> eqrWkPrdList) throws DAOException {
		int result=0;
		DBRowSet dbRowSet = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			log.info("Check");
			if(eqrWkPrdList!=null && !eqrWkPrdList.isEmpty()){
				for(int i=0;i<eqrWkPrdList.size();i++){
					EqrWkPrdVO eqrWkPrdVO = eqrWkPrdList.get(i);
					param.put("pln_yr",eqrWkPrdVO.getPlnYr());
					param.put("pln_wk",eqrWkPrdVO.getPlnWk());
					dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchDuplicateCheckEqrWkPrdRSQL(), param, null);
					 
					if (dbRowSet.next()) {
						result = dbRowSet.getInt("CNT");
						if(result>0){
							throw new DAOException("Plan Year and Week are duplicated. Year : "+eqrWkPrdVO.getPlnYr() +", Week : "+eqrWkPrdVO.getPlnWk());
						}
					}
				}
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
		
	}
	
	/**
	 * EQR Week 등록
	 * 
	 * @param List<EqrWkPrdVO> eqrWkPrdList
	 * @throws DAOException
	 */
	public void addEqrWkPrd(List<EqrWkPrdVO> eqrWkPrdList) throws DAOException,Exception {
		try {
			log.info("ADD");
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(eqrWkPrdList != null && !eqrWkPrdList.isEmpty()){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CommonDBDAOAddEqrWkPrdCSQL(), eqrWkPrdList, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * EQR Week 수정
	 * 
	 * @param List<EqrWkPrdVO> eqrWkPrdList
	 * @throws DAOException
	 */
	public void modifyEqrWkPrd(List<EqrWkPrdVO> eqrWkPrdList) throws DAOException,Exception {
		try {
			log.info("MODIFY");
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(eqrWkPrdList!=null && !eqrWkPrdList.isEmpty()){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CommonDBDAOModifyEqrWkPrdUSQL(), eqrWkPrdList, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * EQR Week 삭제
	 * 
	 * @param List<EqrWkPrdVO> eqrWkPrdList
	 * @throws DAOException
	 */
	public void removeEqrWkPrd(List<EqrWkPrdVO> eqrWkPrdList) throws DAOException,Exception {
		try {
			log.info("Remove");
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(eqrWkPrdList != null && !eqrWkPrdList.isEmpty()){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CommonDBDAORemoveEqrWkPrdDSQL(), eqrWkPrdList, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to remove No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 강제로 Plan ID를 생성을 한다.<br>
	 * 
	 * @exception DAOException
	 */
	public void makeNextWeekRepoPlanId() throws DAOException,Exception {
		DBRowSet dbRowSet = null;
		
		String yyyyww = "";
		String seq    = "0001";
		String repo_pln_Id = null;
		String scnr_id     = null;
		int cnt = 0;

		//velocity parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOsearchNextWeekRSQL(), null, null);
			if (dbRowSet.next()) {
				yyyyww = dbRowSet.getString(1);
			}	
			
			repo_pln_Id = Constants.REPO_WORD + yyyyww + Constants.REPO_WEEK + seq;
			scnr_id     = Constants.SCNR_WORD + yyyyww + Constants.SCNR_WEEK + seq;
			
			param.put("repo_pln_id", repo_pln_Id);
			param.put("scnr_id"    , scnr_id);

			cnt  = checkDupNextWeekRepoPlan(param, velParam);
			if(cnt < 1){
				//createNextWeekRepoPlanId(param, velParam);
				SQLExecuter sqlExe = new SQLExecuter("");
				int updCnt = 0;
			    updCnt = sqlExe.executeUpdate((ISQLTemplate)new CommonDBDAOcreateNextWeekRepoPlanIdCSQL(), param, null);
					if(updCnt == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No SQL");				

			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * check duplicate repo plan id.<br>
	 * 
	 * @param param Map<String, Object>
	 * @param velparam Map<String, Object>
	 * @return resultCnt
	 * @exception DAOException
	 */
	public int checkDupNextWeekRepoPlan(Map<String, Object> param , Map<String, Object> velparam) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		int resultCnt = 0;
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOcheckDupNextWeekRepoPlanIdRSQL(), param, velparam);
			
			while (dbRowset.next()) {
				resultCnt = dbRowset.getInt("CNT");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return resultCnt;
	}	
	
	
	
	/**
	 * Trade 조회
	 * 
	 * @return List<CommonVO>
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
	
	
	/**
	 * TpSz 조회
	 * 
	 * @param valueField
	 * @param textField
	 * @param mainCode
	 * @param orderByField
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet getTpSzCodeCombo(String mainCode, String orderByField, String delOptions) throws DAOException {
		DBRowSet dbRowset = null; 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	  	
	  	try {
	  		param.put("main_code",mainCode);
	  		velParam.put("main_code",mainCode);
	  		
	  		param.put("del_option",delOptions);
	  		velParam.put("del_option",delOptions);
	  		dbRowset = new SQLExecuter(strDs).executeQuery((ISQLTemplate)new CommonDBDAOGetTpSzComboRSQL(), param, velParam);
		   
	  	}catch(SQLException se) {
	  		log.error(se.getMessage(), se);
	      	throw new DAOException(new ErrorHandler(se).getMessage());
	  	}catch(DAOException de) {
	  		log.error(de.getMessage(), de);
	      	throw de;
	  	}catch(Exception e) {
	  		log.error(e.getMessage(), e);
	      	throw new DAOException(e.getMessage());
	  	}
	  	return dbRowset;
	}
	
	
	/**
	 * 
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked" })
	public List<EqrCommonVO> searchEqrSubContinentList() throws DAOException {
		 
		DBRowSet dbRowset = null;
		List<EqrCommonVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		try {
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchSubContinentRSQL(), param, velParam);
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
	
	/**
	 * Yard INfo Search<br>
	 * @param locfmyard String
	 * @param loctoyard String
	 * @param account SignOnUserAccount
	 * @return strYardInfo
	 * @exception DAOException
	 */
	public String searchYardTrwInfo(String locfmyard, String loctoyard, SignOnUserAccount account)  throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String strYardInfo = "";
		try{
			param.put("locfmyard", locfmyard);
			param.put("loctoyard", loctoyard);
			velParam.put("locfmyard", JSPUtil.getNull(locfmyard));
			velParam.put("loctoyard", JSPUtil.getNull(loctoyard));
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonDBDAOSearchEqrLocYardTrwLccInfoRSQL(), param, velParam);
            while(dbRowset.next()){
            	strYardInfo = dbRowset.getString(1);
            }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strYardInfo;
	}
}
