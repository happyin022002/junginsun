/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SurplusAreaDBDAO.java
*@FileTitle : Inventory Simulation - Surplus Area
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.30 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.surplusarea.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.hanjin.apps.alps.ees.eqr.cntrcommon.Utils;
import com.hanjin.apps.alps.ees.eqr.cntrcommon.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.surplusarea.basic.SurplusAreaBCImpl;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.surplusarea.vo.PortSurplusAreaConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.surplusarea.vo.SurplusAreaConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.surplusarea.vo.SurplusAreaVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS SurplusAreaDBDAO <br>
 * - ALPS - Inventory Simulation Surplus Area system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see SurplusAreaBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class SurplusAreaDBDAO extends DBDAOSupport {
	
	 /**
	 * Surplus Area 의 시트 헤더 타이틀 조회
	 * 
	 * @param SurplusAreaConditionVO surplusAreaConditionVO
	 * @return String[]
	 * @exception DAOException
	 */
	public String searchSurplusAreaTitleData(SurplusAreaConditionVO surplusAreaConditionVO)  throws DAOException {
		DBRowSet dbRowset = null;
		StringBuffer rptTtl = new StringBuffer();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int i = 0;
		try{
			Map<String, String> mapVO = surplusAreaConditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SurplusAreaDBDAOSearchSurplusAreaTitleRSQL(), param, velParam);
           while(dbRowset.next()){
           	rptTtl.append(((i == 0) ? "" : ",") + dbRowset.getString ("WEEK"));
           	i++;
           }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rptTtl.toString();
	}	
	
	 /**
	 * Surplus Area - History 시트를 조회한다.<br>
	 * 
	 * @param SurplusAreaConditionVO surplusAreaConditionVO
	 * @param String rptTtl
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	public CommonRsVO searchSurplusAreaData(SurplusAreaConditionVO surplusAreaConditionVO, String rptTtl) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(surplusAreaConditionVO != null){ 
				Map<String, String> mapVO = surplusAreaConditionVO .getColumnValues();
			
				List<String> arrweek = Utils.replaceStrToList(rptTtl);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("arrweek", arrweek);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SurplusAreaDBDAOSearchSurplusAreaRSQL(), param, velParam);
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
	 * 현재시각 기준으로 기본 주차 ( 과거 3주 ~ 미래 3주 , 총 7주차 )가져오기
	 * 
	 * @return String[]
	 * @exception DAOException
	 */
	public String searchCurrSevenWeeksData()  throws DAOException {
		DBRowSet dbRowset = null;
		StringBuffer rptTtl = new StringBuffer();
		int i = 0;
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SurplusAreaDBDAOSearchCurrSevenWeeksRSQL(), null, null);
           while(dbRowset.next()){
           	rptTtl.append(((i == 0) ? "" : ",") + dbRowset.getString ("WEEK"));
           	i++;
           }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rptTtl.toString();
	}		

	/**
	 * 로그인 유저의 수정 권한 조회<br>
	 * 
	 * @param String ofc_cd
	 * @return String
	 * @exception EventException
	 */	
	public String checkYardSurplusAreaAuthData(String ofc_cd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		String authChk = "";
		try{
			if(ofc_cd != null){ 
				param.put("ofc_cd", ofc_cd);
			
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SurplusAreaDBDAOCheckYardSurplusAreaAuthRSQL(), param, null);
				
				while (dbRowset.next()){
					authChk = dbRowset.getString ("AUTH_CHK");
					break;
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return authChk;
	}		

	/**
	 * LOC Code 유효성 조회 (RCC_CD 반환)<br>
	 * 
	 * @param String loc_grp_cd
	 * @param String loc_cd
	 * @return String
	 * @exception EventException
	 */	
	public String checkRccCodeIs(String loc_grp_cd, String loc_cd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String locChk = "";
		try{
			if(loc_grp_cd != null && loc_cd != null){ 
				velParam.put("loc_grp_cd", loc_grp_cd);
				param.put("loc_cd", loc_cd);
			
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SurplusAreaDBDAOCheckRccCodeIsRSQL(), param, velParam);
				
				while (dbRowset.next()){
					locChk = dbRowset.getString ("RCC_CHK");
					break;
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return locChk;
	}		
	
	 /**
	 * Surplus Area - Yard 시트를 조회한다.<br>
	 * 
	 * @param SurplusAreaConditionVO surplusAreaConditionVO
	 * @param String rptTtl
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	public CommonRsVO searchYardSurplusAreaData(SurplusAreaConditionVO surplusAreaConditionVO, String rptTtl) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(surplusAreaConditionVO != null){ 
				Map<String, String> mapVO = surplusAreaConditionVO .getColumnValues();
			
				List<String> arrweek  = Utils.replaceStrToList(rptTtl); // 전체 주차  (7개)
				List<String> arrweek1 = new ArrayList<String>();        // 과거 주차 (3개)
				List<String> arrweek2 = new ArrayList<String>();        // 현재,미래 주차 (4개)
				List<String> arrweek3 = new ArrayList<String>();        // 과거 주차 (3개) 뒤집어서
				
				for(int i=0; i<arrweek.size(); i++){
					if(Integer.parseInt(arrweek.get(i)) <  Integer.parseInt(surplusAreaConditionVO.getCurrYrwk())){
						arrweek1.add(arrweek.get(i));
						arrweek3.add(arrweek.get(i));
					}else if(Integer.parseInt(arrweek.get(i)) >=  Integer.parseInt(surplusAreaConditionVO.getCurrYrwk())){
						arrweek2.add(arrweek.get(i));
					}
				}
				
				// 2015.02.25 CHM-201534210 EQR 소스 보안
				if (arrweek3.size()>0){
					java.util.Collections.reverse(arrweek3); //뒤집기
				}
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("arrweek",  arrweek);
				velParam.put("arrweek1", arrweek1);
				velParam.put("arrweek2", arrweek2);
				velParam.put("arrweek3", arrweek3);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SurplusAreaDBDAOSearchYardSurplusAreaRSQL(), param, velParam);
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
	 * Surplus Area - Yard 의 manual 데이터를 입력/수정<br>
	 * EQR_CTRL_INVT_SIM
	 * 
	 * @param List<SurplusAreaVO> surplusAreaVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyYardSurplusAreaData(List<SurplusAreaVO> surplusAreaVOs) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(surplusAreaVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SurplusAreaDBDAOModifyYardSurplusAreaUSQL(), surplusAreaVOs, null);
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
	}	
	
	 /**
	 * Surplus Area - Yard 의 manual 데이터를 입력/수정<br>
	 * EQR_CTRL_INVT_SIM_QTY
	 * 
	 * @param List<SurplusAreaVO> surplusAreaVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyYardSurplusAreaQtyData(List<SurplusAreaVO> surplusAreaVOs) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(surplusAreaVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SurplusAreaDBDAOModifyYardSurplusAreaQtyUSQL(), surplusAreaVOs, null);
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
	}		

	 /**
	 * Surplus Area - Yard 의 BKG for OP Ref 팝업 데이터를 조회한다.<br>
	 * 
	 * @param SurplusAreaConditionVO surplusAreaConditionVO
	 * @param String rptTtl
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	public CommonRsVO searchBkgSurplusAreaData(SurplusAreaConditionVO surplusAreaConditionVO, String rptTtl) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(surplusAreaConditionVO != null){ 
				Map<String, String> mapVO = surplusAreaConditionVO .getColumnValues();
			
				List<String> arrweek = Utils.replaceStrToList(rptTtl);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("arrweek", arrweek);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SurplusAreaDBDAOSearchBkgSurplusAreaRSQL(), param, velParam);
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
	 * 로그인 유저의 수정 권한 조회<br>
	 * 
	 * @param String ofc_cd
	 * @return String
	 * @exception EventException
	 */	
	public String checkPortSurplusAreaAuthData(String ofc_cd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		String authChk = "";
		try{
			if(ofc_cd != null){ 
				param.put("ofc_cd", ofc_cd);
			
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SurplusAreaDBDAOCheckPortSurplusAreaAuthRSQL(), param, null);
				
				while (dbRowset.next()){
					authChk = dbRowset.getString ("AUTH_CHK");
					break;
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return authChk;
	}		
	
	 /**
	 * Surplus Area - Port 시트를 조회한다.<br>
	 * 
	 * @param PortSurplusAreaConditionVO portSurplusAreaConditionVO
	 * @param String rptTtl
	 * @return List<CommonRsVO>
	 * @exception DAOException
	 */
	public List<CommonRsVO> searchPortSurplusAreaData(PortSurplusAreaConditionVO portSurplusAreaConditionVO, String rptTtl) throws DAOException {
		DBRowSet dbRowset1 = null;
		DBRowSet dbRowset2 = null;
		List<CommonRsVO> commonRsVOs = new ArrayList<CommonRsVO>();
		CommonRsVO commonRsVO1 = new CommonRsVO();
		CommonRsVO commonRsVO2 = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(portSurplusAreaConditionVO != null){ 
				Map<String, String> mapVO = portSurplusAreaConditionVO .getColumnValues();
			
				List<String> arrweek  = Utils.replaceStrToList(rptTtl); // 전체 주차  (7개)
				List<String> arrweek1 = new ArrayList<String>();        // 과거 주차  (3개)
				List<String> arrweek2 = new ArrayList<String>();        // 현재,미래 주차 (4개)
				
				List<String> arr_lane = Utils.replaceStrToList(portSurplusAreaConditionVO.getLane());         // 조회조건 lane
				List<String> arr_subtrade = Utils.replaceStrToList(portSurplusAreaConditionVO.getSubtrade()); // 조회조건 subtrade
				List<String> arr_trade = Utils.replaceStrToList(portSurplusAreaConditionVO.getTrade());       // 조회조건 trade
				
				
				for(int i=0; i<arrweek.size(); i++){
					if(Integer.parseInt(arrweek.get(i)) <  Integer.parseInt(portSurplusAreaConditionVO.getCurrYrwk())){
						arrweek1.add(arrweek.get(i));
					}else if(Integer.parseInt(arrweek.get(i)) >=  Integer.parseInt(portSurplusAreaConditionVO.getCurrYrwk())){
						arrweek2.add(arrweek.get(i));
					}
				}
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				velParam.put("arrweek",  arrweek);
				velParam.put("arrweek1", arrweek1);
				velParam.put("arrweek2", arrweek2);
				velParam.put("arr_lane",     arr_lane);
				velParam.put("arr_subtrade", arr_subtrade);
				velParam.put("arr_trade",    arr_trade);
			}
			dbRowset1 = new SQLExecuter("").executeQuery((ISQLTemplate)new SurplusAreaDBDAOSearchVvdSurplusAreaRSQL(), param, velParam);
			commonRsVO1.setDbRowset(dbRowset1);
			
			dbRowset2 = new SQLExecuter("").executeQuery((ISQLTemplate)new SurplusAreaDBDAOSearchPortSurplusAreaRSQL(), param, velParam);
			commonRsVO2.setDbRowset(dbRowset2);
			
			commonRsVOs.add(commonRsVO1);
			commonRsVOs.add(commonRsVO2);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonRsVOs;
	}		

	 /**
	 * Surplus Area - Port 의 manual 데이터를 입력/수정<br>
	 * EQR_CTRL_INVT_SIM
	 * 
	 * @param List<SurplusAreaVO> surplusAreaVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyPortSurplusAreaData(List<SurplusAreaVO> surplusAreaVOs) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(surplusAreaVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SurplusAreaDBDAOModifyPortSurplusAreaUSQL(), surplusAreaVOs, null);
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
	}	
	
	 /**
	 * Surplus Area - Port 의 manual 데이터를 입력/수정<br>
	 * EQR_CTRL_INVT_SIM_QTY
	 * 
	 * @param List<SurplusAreaVO> surplusAreaVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyPortSurplusAreaQtyData(List<SurplusAreaVO> surplusAreaVOs) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(surplusAreaVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SurplusAreaDBDAOModifyPortSurplusAreaQtyUSQL(), surplusAreaVOs, null);
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
	}			

	/**
	 *  Sub-Conti 콤보 리스트 조회<br>
	 * @param portSurplusAreaConditionVO
	 * @return CommonRsVO
	 * @throws DAOException
	 */
	public CommonRsVO searchSubcontiListData(PortSurplusAreaConditionVO portSurplusAreaConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();

		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (portSurplusAreaConditionVO!=null){
				param.put("trade", JSPUtil.getNull(portSurplusAreaConditionVO.getTrade()));
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SurplusAreaDBDAOSearchSubcontiListRSQL(), param, param);
				commonRsVO.setDbRowset(dbRowset);
			}
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
	 * (Port & Yard Simulation용) User의 Office level을 체크
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchOfcLvl(String ofcCd)  throws DAOException {
		DBRowSet dbRowset = null;
		String levelCd = "";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("ofc_cd", ofcCd);
			velParam.put("ofc_cd", ofcCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SurplusAreaDBDAOSearchOfcLvlRSQL(), param, velParam);
            if (dbRowset.next()){
            	levelCd = dbRowset.getString(1);
            }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return levelCd;
	}
}