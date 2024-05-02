/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AocCommonDBDAO.java
*@FileTitle : Common
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
* 1.0 Creation
* ----------------------------------------------------------
* History
* 2012.10.04 변종건 [CHM-201220395] Add-on Tariff Management 개선 프로젝트
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.common.aoccommon.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.aoc.common.aoccommon.basic.AocCommonBCImpl;
import com.hanjin.apps.alps.esd.aoc.common.aoccommon.event.EsdAoc0999Event;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
/**
 * ALPS AocCommonDBDAO <br>
 * - ALPS-Common system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see AocCommonBCImpl 참조
 * @since J2EE 1.6
 */
public class AocCommonDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 3924224922840941072L;
	
	
	/**
	 * 월별,주차별 검색기간 조회 이벤트 처리.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchPeriod(EsdAoc0999Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			if ("M".equals(event.getFChkPrd())){
				param.put("fm_month", event.getFYear() + event.getIFmWm());
				param.put("to_month", event.getFYear() + event.getIToWm());
				dbRowset = new SQLExecuter("DEFAULT").executeQuery(new AocCommonDBDAOSearchPeriodMonthRSQL(), param,param);
			}else{
				param.put("f_fm_yr", event.getFYear());
				param.put("f_to_yr", event.getFYear());
				param.put("f_fm_wk", event.getIFmWm());
				param.put("f_to_wk", event.getIToWm());
			
				dbRowset = new SQLExecuter("DEFAULT").executeQuery(new AocCommonDBDAOSearchPeriodWeekRSQL(), param,param);				
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		
		return dbRowset;
	}
	
	/**
	 * RHQ Office 조회<br>
	 * 
	 * @param ofcCd
	 * @return
	 * @throws DAOException
	 */
	public String searchRHQOfficeCode(String ofcCd) throws DAOException {
		 DBRowSet dbRowset = null;
		 
		 String rhqCd = "";
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
//		 Map<String, Object> velParam = new HashMap<String, Object>();
		
		 try{
			 if(ofcCd != null){				 
				 param.put("ofc_cd", ofcCd);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AocCommonDBDAOSearchRHQOfficeCodeRSQL(), param, null);
				
			 // to Get Office-Level From DBRowSet
			 if ( dbRowset!=null && dbRowset.next() ){
				 rhqCd = dbRowset.getString(1);
			 }
			 dbRowset = null;
		 
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return rhqCd;
	}
	
	/**
	 * Country Code Verify<br>
	 * 
	 * @param cntCd
	 * @return
	 * @throws DAOException
	 */
	public String verifyCountryCode(String cntCd) throws DAOException {
		 DBRowSet dbRowset = null;
		 String errFlg = "";
		 List<String> cntCds = new ArrayList<String>();
		 
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		
		 try{
			 String dupFlg = "";
			 String[] cntCdTmpArr =  cntCd.split(",");
			 String[] cntCdArr = new String[cntCdTmpArr.length];
			 
			 int kdx = 0;
			 if(cntCdTmpArr != null){
				 //Checking Duplication
				 for(int idx=0;idx<cntCdTmpArr.length-1;idx++){
					 dupFlg = "N";
					 for(int jdx=idx+1;jdx<cntCdTmpArr.length;jdx++){
						 if( cntCdTmpArr[idx].equals(cntCdTmpArr[jdx]) ){
							 dupFlg = "Y";
						 }
					 }
					 if( "N".equals(dupFlg) ){
						 cntCdArr[kdx] = cntCdTmpArr[idx];
						 kdx++;
					 }
				 }
				 cntCdArr[kdx] = cntCdTmpArr[cntCdTmpArr.length-1];
				 
				 
				 for(int idx=0;idx<cntCdArr.length;idx++){
					 if( !"".equals(cntCdArr[idx]) && cntCdArr[idx] != null ){
						 cntCds.add(cntCdArr[idx].toString());
					 }
				 }
				 
				 if(cntCds.size()>0){
					 velParam.put("cnt_cd_arr", cntCds);						
				 }
			 }
			 
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AocCommonDBDAOVerifyCountryCodeRSQL(), null, velParam);
			 if(dbRowset.next()){
				 errFlg = dbRowset.getString("ERR_FLG");
			 }
		 
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return errFlg;
	}
	
	/**
	 * SingleTransportationSOManage의 조회 된 데이타 모델을 DB에 반영한다.<br>
	 * Office의 Sub Office 조회
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public String[] searchSubOfficeSOManageList(EsdAoc0999Event event) throws DAOException {
		String[] sResult = null;
		DBRowSet dbRowset = null;
		ArrayList<String> tmpList = new ArrayList<String>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
//			String so_office = event.getCtrl_so_office();
//			ArrayList<String> arr_so_office = new ArrayList<String>();
//			arr_so_office = this.seperationParameter(so_office, ","); 
			param.put("so_office", event.getCtrl_so_office());

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AocCommonDBDAOSearchSubOfficeSOManageListRSQL(), param, null);
			
            while ( dbRowset.next() ) {
            	tmpList.add(dbRowset.getString("OFC_CD"));
            }
            
			if(!tmpList.isEmpty()) {
            	sResult = (String[])tmpList.toArray(new String[0]);
            }

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sResult;
	}
	
//	/**
//	 * 여러개의 parameter를 나누어주는 메소드
//	 * Detail Inquity Popup<br>
//	 * 
//	 * @param sparameter
//	 * @param sSeperate
//	 * @return
//	 */
//	public ArrayList<String> seperationParameter(String sparameter, String sSeperate) {
//		ArrayList<String> arrlist = null;
//		StringTokenizer st  = null;
//		int j = 0;
//		if( !sparameter.equals("") ) {
//			arrlist = new ArrayList<String>();
//			st = new StringTokenizer(sparameter, sSeperate);
//			while( st.hasMoreTokens() ) {
//				arrlist.add(j++, st.nextToken());
//			}
//		}
//		return arrlist;
//	}
	
}