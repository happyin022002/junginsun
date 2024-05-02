/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TrsCommonDBDAO.java
*@FileTitle : Common
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.04
*@LastModifier : 최 선
*@LastVersion : 1.9
* 2011.02.10 민정호
* 1.0 Creation
* ----------------------------------------------------------
* History
* 1.0 2011.02.10 민정호 [CHM-201108602] [TRS]미주지역 Appt./Deli. time update 기능 추가
* 1.1 2011.02.18 손은주 [CHM-201108834-01][TRS] Rail performance Report 부분의 주 단위 data 조회기능 추가 요청- 월별 주차별 검색기간 추가
* 1.2 2011.03.14 손은주 [CHM-201109256][TRS] Actual customer 상의 중복 Default 지정 Block 요청 - 미사용 import 삭제
* 1.3 2011.03.28 손은주 [CHM-201109560-01] Split 04-Intra - Europe Business 관련 VAT 기능 개발 - 대륙코드 조회
* 1.4 2011.06.27 손은주 [CHM-201111573-01][TRS] S/O history function 추가 요청
* 1.5 2011.08.31 유선오 [CHM-201111573-01][TRS] OTHER S/O Creation 화면상 오류 수정요청  
* 1.6 2011.09.07 유선오 [CHM-201111573-01][TRS] OTHER S/O Creation 화면상 오류 수정요청(R4J 수정사항 조치)
* 1.7 2011.10.19 유선오 [CHM-201111573-01][TRS] OTHER S/O Creation 화면상 오류 수정요청
* 1.8 2011.11.17 변종건 [CHM-201114528-01] TRS 시스템 담당자용 버튼 개발
* 1.9 2012.01.04 최 선   [CHM-201108834][TRS] Rail performance Report 부분의 주 단위 data 조회기능 추가 요청- 월별 주차별 검색기간 추가 (조회 방법 보완)
* 1.10 2012.01.06 김종호 [CHM-201109410] [TRS] CNTR No. 유효성에 대한 Validation 절차 추가요청
* 1.17 2012.04.12 김인수 [CHM-201216040] [TRS] US rail S/O 에 대한 S/O history function 연결 요청
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.trscommon.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.common.fileattach.vo.TrsFileVO;
import com.hanjin.apps.alps.esd.trs.common.trscommon.basic.TrsCommonBCImpl;
import com.hanjin.apps.alps.esd.trs.common.trscommon.event.EsdTrs0999Event;
import com.hanjin.apps.alps.esd.trs.common.trscommon.vo.TrsSOHistoryVO;
import com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.TrsTrspSvcOrdVO;
/**
 * ALPS TrsCommonDBDAO <br>
 * - ALPS-Common system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Min Jung Ho
 * @see TrsCommonBCImpl 참조
 * @since J2EE 1.6
 */
public class TrsCommonDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 3924224922840941072L;
	/**
	 * Office Change시 변경된 국가코드를 조회한다.<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchContiCd(EsdTrs0999Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("OFC_CD", 	event.getOfcCd());
		
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new TrsCommonDBDAOSearchContiCdRSQL(), param,param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;
	}	
	
	/**
	 * Office Change시 변경된 국가코드를 조회한다.<br>
	 * N200905040013 2009-05-11: Office Change 개념의 모듈적용
	 * 
	 * @param office_cd
	 * @return
	 * @throws DAOException
	 */
	public String searchContiCd(String office_cd) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		String cnt_cd	= "";

		param.put("OFC_CD", office_cd);

		try {
				dRs = new SQLExecuter("DEFAULT").executeQuery(new TrsCommonDBDAOSearchContiCdRSQL(), param,param);

	            if (dRs.next())
	            	cnt_cd = dRs.getString("CNT_CD");
	            else
	            	throw new DAOException(new ErrorHandler("TPB00061").getMessage());

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return cnt_cd;
	}	
	
	/**
	 * 월별,주차별 검색기간 조회 이벤트 처리.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchPeriod(EsdTrs0999Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		FormCommand formcommand = event.getFormCommand();
		
		try{
			if(formcommand.isCommand(FormCommand.SEARCH02)){
				if ("M".equals(event.getFChkPrd())){
					param.put("fm_month", event.getFFmMon());
					param.put("to_month", event.getFToMon());
					dbRowset = new SQLExecuter("DEFAULT").executeQuery(new TrsCommonDBDAOSearchPeriodMonthRSQL(), param,param);
				}else{
					param.put("f_fm_yr", event.getFFmWk().substring(0, 4));
					param.put("f_to_yr", event.getFToWk().substring(0, 4));
					param.put("f_fm_wk", event.getFFmWk().substring(4));
					param.put("f_to_wk", event.getFToWk().substring(4));
				
					dbRowset = new SQLExecuter("DEFAULT").executeQuery(new TrsCommonDBDAOSearchPeriodWeekRSQL(), param,param);				
				}
			} else if(formcommand.isCommand(FormCommand.SEARCH08)){
				if ("M".equals(event.getFChkPrd())){
					param.put("fm_month", event.getFYear() + event.getIFmWm());
					param.put("to_month", event.getFYear() + event.getIToWm());
					dbRowset = new SQLExecuter("DEFAULT").executeQuery(new TrsCommonDBDAOSearchPeriodMonthRSQL(), param,param);
				}else{
					param.put("f_fm_yr", event.getFYear());
					param.put("f_to_yr", event.getFYear());
					param.put("f_fm_wk", event.getIFmWm());
					param.put("f_to_wk", event.getIToWm());
				
					dbRowset = new SQLExecuter("DEFAULT").executeQuery(new TrsCommonDBDAOSearchPeriodWeekRSQL(), param,param);				
				}
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
	 * Office의 대륙코드를 조회한다.<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchContiCode(EsdTrs0999Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("OFC_CD", 	event.getOfcCd());
		
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new TrsCommonDBDAOSearchContiCodeRSQL(), param,param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;
	}
	
	/**
	 * TRS CY/DOOR S/O와 관련된 각 이벤트 별로 S/O HISTORY를 입력<br>
	 *
	 * @param soHisVo TrsSOHistoryVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void multiSoHistory(TrsSOHistoryVO soHisVo) throws DAOException,Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		int insCnt  = 0;

		try {
			log.debug("@@@@@@TrsCommonDBDAO : start");

			Map<String, String> paramVo = soHisVo.getColumnValues();
			param.putAll(paramVo);
			
			log.debug("@@@@@@TrsCommonDBDAO : param.getRoutRplnFlg = "+param.get("rout_rpln_flg"));
			log.debug("@@@@@@TrsCommonDBDAO : soHisVo.getRoutRplnFlg() = "+soHisVo.getRoutRplnFlg());
			
			if (soHisVo.getSrcCd() != null && soHisVo.getSrcCd().equals("USRAIL")) {
				if("IS".equals(soHisVo.getTrspSoEvntCd()) || "IX".equals(soHisVo.getTrspSoEvntCd()) || "ID".equals(soHisVo.getTrspSoEvntCd()) || ("II".equals(soHisVo.getTrspSoEvntCd()) )){
					log.debug("@@@@@@TrsCommonDBDAO : if : IX, ID, II => TrsCommonDBDAOAddRailInvHistoryCSQL");
					insCnt = new SQLExecuter("DEFAULT").executeUpdate(new TrsCommonDBDAOAddRailInvHistoryCSQL(), param, param);
				} else if( "WI".equals(soHisVo.getTrspSoEvntCd()) || "WC".equals(soHisVo.getTrspSoEvntCd())){
					log.debug("@@@@@@TrsCommonDBDAO : else if : WI, WC => TrsCommonDBDAOAdd404EDIHistoryCSQL");
					insCnt = new SQLExecuter("DEFAULT").executeUpdate(new TrsCommonDBDAOAdd404EDIHistoryCSQL(), param, param);
				} else {
					log.debug("@@@@@@TrsCommonDBDAO : else => TrsCommonDBDAOAddRailSOHistoryCSQL");
					insCnt = new SQLExecuter("DEFAULT").executeUpdate(new TrsCommonDBDAOAddRailSOHistoryCSQL(), param, param);
				}
			} else {
				if( "IX".equals(soHisVo.getTrspSoEvntCd()) || "ID".equals(soHisVo.getTrspSoEvntCd()) || ("II".equals(soHisVo.getTrspSoEvntCd()) && "".equals(soHisVo.getTrspSoOfcCtyCd()))){
					log.debug("@@@@@@TrsCommonDBDAO : if : IX, ID, II => TrsCommonDBDAOMultiSOHistory3CSQL");
					insCnt = new SQLExecuter("DEFAULT").executeUpdate(new TrsCommonDBDAOMultiSOHistory3CSQL(), param, param);
				}else if( "WI".equals(soHisVo.getTrspSoEvntCd()) || "WC".equals(soHisVo.getTrspSoEvntCd())){
					log.debug("@@@@@@TrsCommonDBDAO : else if : WI, WC => TrsCommonDBDAOMultiSOHistory2CSQL");
					insCnt = new SQLExecuter("DEFAULT").executeUpdate(new TrsCommonDBDAOMultiSOHistory2CSQL(), param, param);
				}else{
					log.debug("@@@@@@TrsCommonDBDAO : else => TrsCommonDBDAOMultiSOHistoryCSQL");
					insCnt = new SQLExecuter("DEFAULT").executeUpdate(new TrsCommonDBDAOMultiSOHistoryCSQL(), param, param);
				}
				if(insCnt == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to insert SQL");
				}	
			}
			log.debug("insCnt = " + insCnt);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}

	}
	
	/**
	 * TRS CY/DOOR S/O와 관련된 각 이벤트 별로 S/O HISTORY를 입력<br>
	 *
	 * @param soHisVo SingleTransportationVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void multiSceSoHistory(SingleTransportationVO soHisVo) throws DAOException,Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		int insCnt  = 0;
		try {	
			Map<String, String> paramVo = soHisVo.getColumnValues();
			param.putAll(paramVo);

			insCnt = new SQLExecuter("DEFAULT").executeUpdate(new TrsCommonDBDAOMultiSceSoHistoryCSQL(), param, param);

			if(insCnt == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}

	}
	/**
	 *Other S/O에서 Commodity Code를 조회한다<br>
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchCmdtCd(EsdTrs0999Event event) throws DAOException {
		DBRowSet dRs = null;
		
		Map<String, Object> param = new HashMap<String, Object>();		
		String cmdt_cd = event.getCmdtCd();
		param.put("cmdt_cd", cmdt_cd);
		
		try {
			dRs = new SQLExecuter("").executeQuery(new TrsCommonDBDAOSearchCommodityRSQL(), param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;
	}
	
	/**
	  *Other S/O에서 Customer Code를 조회한다<br>
	  * @param event
	  * @return
	  * @throws DAOException
	*/
	public DBRowSet searchCustCd(EsdTrs0999Event event) throws DAOException{
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		
		String cust_cd = event.getCustCd();
		param.put("cust_cd", cust_cd);
		
		try {
			dRs = new SQLExecuter("").executeQuery(new TrsCommonDBDAOSearchCustomerCodeRSQL(), param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;
	}
	
	/**
	 * TRS 버튼 권한 조회<br>
	 * @param usrId
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchBtnAuthority(String usrId) throws DAOException{
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("usr_id", usrId);
		
		try {
			dRs = new SQLExecuter("").executeQuery(new TrsCommonDBDAOSearchBtnAuthorityRSQL(), param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;
	}
	
	/**
	 * 컨테이너 유효성을 검사한다<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchCntrEqNo(EsdTrs0999Event event) throws DAOException {
		
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		TrsTrspSvcOrdVO[] model = event.getTrsTrspSvcOrdVOS();
		List<String> eqNo = new ArrayList();   
		for(int i=0;i<model.length;i++){   
			eqNo.add(model[i].getEqNo());   
		}   
		
		param.put("eqNo", eqNo);
		param.put("row", event.getRow());
				
		try {
			dRs = new SQLExecuter("").executeQuery(new TrsCommonDBDAOSearchCntrEqNoRSQL(), param,param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;
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
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TrsCommonDBDAOSearchRHQOfficeCodeRSQL(), param, null);
				
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
			 
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TrsCommonDBDAOVerifyCountryCodeRSQL(), null, velParam);
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
	 * Agreement Number Verify<br>
	 * 
	 * @param agmt_no
	 * @return
	 * @throws DAOException
	 */
	public String searchTrsAgmtNoData(String agmt_no) throws DAOException {
		 DBRowSet dbRowset = null;
		 String errFlg = "";

		 Map<String, Object> velParam = new HashMap<String, Object>();
		
		 try{
			 velParam.put("amtNo", agmt_no);						
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TrsCommonDBDAOVerifyAgreementNoRSQL(), velParam, velParam);
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
	 * Local Time Search<br>
	 * 
	 * @param event EsdTrs0999Event
	 * @return String
	 * @throws DAOException
	 */
	public String searchLocalTime(EsdTrs0999Event event) throws DAOException {
		 DBRowSet dbRowset = null;
		 String rtnVal = "";

		 Map<String, Object> velParam = new HashMap<String, Object>();
		
		 try{
			 velParam.put("ofc_cd", event.getOfcCd());						
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TrsCommonDBDAOSearchLocalTimeRSQL(), velParam, velParam);
			 if(dbRowset.next()){
				 rtnVal = dbRowset.getString("LOCL_DT_TM");
			 }
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return rtnVal;
	}
	
	/**
	 * Container type - Active<br>
	 * 
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchMdmCntrTpActive() throws DAOException {
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체		
		DBRowSet dRs = null;
		try{
	        dRs = new SQLExecuter("").executeQuery(new TrsCommonDBDAOSearchMdmCntrTpActiveRSQL(), null, null);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dRs;
	}
	
	/**
	 * 해당 오피스가 Multi More Candidate 필수 대상 인지 확인 (미국, 캐나다)
	 * 
	 * @param office_cd
	 * @return
	 * @throws DAOException
	 */
	public String searchMltMorOnyFlg(String office_cd) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		String mlt_mor_ony_flg	= "";

		param.put("OFC_CD", office_cd);

		try {
				dRs = new SQLExecuter("DEFAULT").executeQuery(new TrsCommonDBDAOSearchMltMorOnyFlgRSQL(), param,param);

	            if (dRs.next())
	            	mlt_mor_ony_flg = dRs.getString("MLT_MOR_ONY_FLG");
	            else
	            	mlt_mor_ony_flg = "";

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return mlt_mor_ony_flg;
	}
	
	
	 public List<TrsFileVO> searchTrsFile(TrsFileVO trsFileVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<TrsFileVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(trsFileVO != null){
				 Map<String, String> mapVO = trsFileVO.getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TrsCommonDBDAOFileAttachAutoAttachFileRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, TrsFileVO.class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }
	 
	 
	 @SuppressWarnings("unchecked")
	 public String makeTrsFileNo(TrsFileVO trsFileVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 String atchFileLnkId = "";

		 Map<String, Object> param = new HashMap<String, Object>();

		 try{
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TrsCommonDBDAOAutoFileNoRSQL(), param, param);
			 if(dbRowset.next()){
				 atchFileLnkId = dbRowset.getString("atch_file_lnk_id");
			 }
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return atchFileLnkId;
	 }
	 
	 @SuppressWarnings("unchecked")
	 public void removeTrsFile(TrsFileVO trsFileVO) throws DAOException {
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 if(trsFileVO != null){
				 //query parameter
				 Map<String, String> param = trsFileVO.getColumnValues();

				 int result = sqlExe.executeUpdate((ISQLTemplate) new TrsCommonDBDAORemoveAttachFileDSQL() , param, null);
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to update SQL");
			 } 
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	 }
	 
	 @SuppressWarnings("unchecked")
	 public void addTrsFile(TrsFileVO trsFileVO) throws DAOException {
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 if(trsFileVO != null){
				 //query parameter
				 Map<String, String> param = trsFileVO.getColumnValues();

				 int result = sqlExe.executeUpdate((ISQLTemplate) new TrsCommonDBDAOAddFileCSQL() , param, null);
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to update SQL");
			 } 
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	 }
	 
	 @SuppressWarnings("unchecked")
	 public List<TrsFileVO> searchTrsFileAll(TrsFileVO trsFileVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<TrsFileVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
			 if(trsFileVO != null){
				 Map<String, String> mapVO = trsFileVO.getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TrsCommonDBDAOsearchFileAllRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, TrsFileVO.class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }	 
	 
	 //mook 추가 작업
	 @SuppressWarnings("unchecked")
	 public void changeTrs0087File(TrsFileVO trsFileVO) throws DAOException {
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 if(trsFileVO != null){
				 //query parameter
				 Map<String, String> param = trsFileVO.getColumnValues();

//				 int result = sqlExe.executeUpdate((ISQLTemplate) new TrsCommonDBDAORemoveAttachFileDSQL() , param, null);
				 int result = sqlExe.executeUpdate((ISQLTemplate) new TrsCommonDBDAOChangeAttachFileUSQL() , param, null);
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to update SQL");
			 } 
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	 }
	
}