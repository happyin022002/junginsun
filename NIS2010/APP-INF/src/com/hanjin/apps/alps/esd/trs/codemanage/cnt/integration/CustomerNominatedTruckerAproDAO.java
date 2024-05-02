/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomerNominatedTruckerAproDAO.java
*@FileTitle : CNT(Customer Nominated Trucker) Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.17
*@LastModifier : 김도현
*@LastVersion : 1.1
* 2014.05.28 김도현
* 1.0 최초 생성
-----------------------------------------------------------
* History
=========================================================*/

package com.hanjin.apps.alps.esd.trs.codemanage.cnt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esd.trs.codemanage.cnt.event.EsdTrs0086Event;
import com.hanjin.apps.alps.esd.trs.codemanage.cnt.event.EsdTrs0087Event;
import com.hanjin.apps.alps.esd.trs.codemanage.cnt.vo.SearchCntApprovalVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * CNT(Customer Nominated Trucker) Approval 에 대한 DB 처리를 담당<br>
 * - CNT(Customer Nominated Trucker) Approval Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Approval
 * @see CustomerNominatedTruckerAproBCImpl 참조
 * @since J2EE 1.6
 */
public class CustomerNominatedTruckerAproDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;
	/**
	 * CNT(Customer Nominated Trucker) Approval 조회
	 * 
	 * @param event EsdTrs0086Event
	 * @param account SignOnUserAccount
	 * @return dRs
	 * @throws DAOException
	 */
	public DBRowSet searchCntApproval(EsdTrs0087Event event, SignOnUserAccount account) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		
		List<String> arr_DispStsCd = new ArrayList();
		arr_DispStsCd = this.seperationParameter(event.getsDispDtsCd(), ","); 

		param.put("s_disp_sts_cd", 	arr_DispStsCd);
		param.put("s_dt_div_cd", 	event.getsDtDivCd()  );
		param.put("s_fm_dt", 		event.getsFmDt().replaceAll("-", "")    );
		param.put("s_to_dt", 		event.getsToDt().replaceAll("-", "")    );
		param.put("s_eff_dt", 		event.getsEffDt().replaceAll("-", "")    );
		param.put("s_ctrt_no", 		event.getsCtrtNo()   );
		param.put("s_cust_seq", 	event.getsCustSeq()  );
		param.put("s_vndr_seq", 	event.getS_vndr_seq());
		param.put("s_cnt_tp_cd", 	event.getsCntTpCd()  );
		param.put("s_dor_nod_cd", 	event.getsDorNodCd() );
		
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new CustomerNominatedTruckerAproDAOSearchCntApprovalRSQL(), param,param);
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
	 * CNT(Customer Nominated Trucker) Approval - Approval Status 조회
	 * 
	 * @param event EsdTrs0086Event
	 * @return dbRowset
	 * @throws DAOException
	 */
	public DBRowSet searchDtAproDiv(EsdTrs0087Event event) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			CustomerNominatedTruckerAproDAOSearchDtAproDivRSQL template = new CustomerNominatedTruckerAproDAOSearchDtAproDivRSQL();
			dbRowset = sqlExe.executeQuery(template, param, param);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}	

	
	/**
	 * 여러개의 parameter를 나누어주는 메소드
	 * Detail Inquity Popup<br>
	 * 
	 * @param String sparameter
	 * @param String sSeperate
	 * @return ArrayList<String>
	 * @throws 
	 */
	public ArrayList seperationParameter(String sparameter, String sSeperate) {
		ArrayList arrlist = null;
		StringTokenizer st  = null;
		int j = 0;
		if( !sparameter.equals("") ) {
			arrlist = new ArrayList();
			st = new StringTokenizer(sparameter, sSeperate);
			while( st.hasMoreTokens() ) {
				arrlist.add(j++, st.nextToken());
			}
		}
		return arrlist;
	}
	
	/**
	 * CNT(Customer Nominated Trucker) Approval - Save - DB에 반영한다.(변경)<br>
	 *
	 * @param event EsdTrs0086Event
	 * @param account SignOnUserAccount
	 * @throws DAOException
	 */
	public void updateCntAproSave(EsdTrs0087Event event, SignOnUserAccount account) throws DAOException {
		try {
			int insCnt = 0;
			SearchCntApprovalVO[] models = event.getSearchCntApprovalVOs();
			Map<String,Object> param = new HashMap<String,Object>();

			param.put("apro_ofc_cd"	, account.getOfc_cd());
			param.put("apro_usr_id"	, account.getUsr_id());
			param.put("cre_usr_id"	, account.getUsr_id()); 
    		for(int f=0; models != null && f < models.length; f++) {
				param.put("hjs_trkr_agmt_no"			, models[f].getHjsTrkrAgmtNo()); 
				param.put("hjs_trkr_bzc_amt"			, models[f].getHjsTrkrBzcAmt()); 
				param.put("hjs_trkr_fuel_amt"			, models[f].getHjsTrkrFuelAmt()); 
				param.put("hjs_cust_nomi_trkr_agmt_no"	, models[f].getHjsCustNomiTrkrAgmtNo()); 
				param.put("apro_his_desc"				, models[f].getAproHisDesc()); 
				param.put("apro_no"						, models[f].getAproNo()); 
				
				insCnt =	new SQLExecuter().executeUpdate(new CustomerNominatedTruckerAproDAOUpdateCntAproSaveUSQL(), param, param);
				if(insCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update " + " SQL");						
    			
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
	 * CNT(Customer Nominated Trucker) Approval - Reject - DB에 반영한다.(변경)<br>
	 *
	 * @param event EsdTrs0086Event
	 * @param account SignOnUserAccount
	 * @throws DAOException
	 */
	public void updateCntRjct(EsdTrs0087Event event, SignOnUserAccount account) throws DAOException {
		try {
			int insCnt = 0;
			SearchCntApprovalVO[] models = event.getSearchCntApprovalVOs();
			Map<String,Object> param = new HashMap<String,Object>();

			param.put("apro_ofc_cd"	, account.getOfc_cd());
			param.put("apro_usr_id"	, account.getUsr_id());
			param.put("cre_ofc_cd" 	, account.getOfc_cd());
			param.put("cre_usr_id"	, account.getUsr_id()); 
    		for(int f=0; models != null && f < models.length; f++) {
    			if (models[f].getSel().length() > 0) {
    				if (models[f].getSel().equals("1")) {  
    					param.put("hjs_trkr_agmt_no"			, models[f].getHjsTrkrAgmtNo()); 
    					param.put("hjs_trkr_bzc_amt"			, models[f].getHjsTrkrBzcAmt()); 
    					param.put("hjs_trkr_fuel_amt"			, models[f].getHjsTrkrFuelAmt()); 
    					param.put("hjs_cust_nomi_trkr_agmt_no"	, models[f].getHjsCustNomiTrkrAgmtNo()); 
    					param.put("apro_his_desc"				, models[f].getAproHisDesc()); 
    					param.put("apro_no"						, models[f].getAproNo()); 

						insCnt =	new SQLExecuter().executeUpdate(new CustomerNominatedTruckerAproDAOUpdateCntRjctUSQL(), param, param);
						if(insCnt == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to update " + " SQL");						
				    	}
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
	 * CNT(Customer Nominated Trucker) Approval - Approval - DB에 반영한다.(변경)<br>
	 *
	 * @param event EsdTrs0086Event
	 * @param account SignOnUserAccount
	 * @throws DAOException
	 */
	public void updateCntApro(EsdTrs0087Event event, SignOnUserAccount account) throws DAOException {
		try {
			int insCnt = 0;
			SearchCntApprovalVO[] models = event.getSearchCntApprovalVOs();
			Map<String,Object> param = new HashMap<String,Object>();

			param.put("apro_ofc_cd"	, account.getOfc_cd());
			param.put("apro_usr_id"	, account.getUsr_id());
			param.put("cre_ofc_cd" 	, account.getOfc_cd());
			param.put("cre_usr_id"	, account.getUsr_id()); 
    		for(int f=0; models != null && f < models.length; f++) {
    			if (models[f].getSel().length() > 0) {
    				if (models[f].getSel().equals("1")) {
    					if(models[f].getIbflag().equals("I")){
    						Map<String, String> paramVo = models[f].getColumnValues();
    						param.putAll(paramVo);
	
							insCnt =	new SQLExecuter().executeUpdate(new CustomerNominatedTruckerAproDAOCreateCntAproCSQL(), param, param);
							if(insCnt == Statement.EXECUTE_FAILED){
								throw new DAOException("Fail to Insert " + " SQL");						
					    	}
    					
    					}else if(models[f].getIbflag().equals("U")){
	    					param.put("hjs_trkr_agmt_no"			, models[f].getHjsTrkrAgmtNo()); 
	    					param.put("org_nod_cd"					, models[f].getFmNodCd()+models[f].getFmNodYard());
	    					param.put("mty_pkup_rtn_yd_cd"			, models[f].getToNodCd()+models[f].getToNodYard());
	    					param.put("hjs_trkr_bzc_amt"			, models[f].getHjsTrkrBzcAmt()); 
	    					param.put("hjs_trkr_fuel_amt"			, models[f].getHjsTrkrFuelAmt()); 
	    					param.put("hjs_cust_nomi_trkr_agmt_no"	, models[f].getHjsCustNomiTrkrAgmtNo()); 
	    					param.put("apro_his_desc"				, models[f].getAproHisDesc()); 
	    					param.put("apro_no"						, models[f].getAproNo());
	    					param.put("cust_nomi_trkr_ind_cd"		, models[f].getCustNomiTrkrIndCd()); 
	
							insCnt =	new SQLExecuter().executeUpdate(new CustomerNominatedTruckerAproDAOUpdateCntAproUSQL(), param, param);
							if(insCnt == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to update " + " SQL");						
					    	}
	    				}
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
	 * CNT(Customer Nominated Trucker) Approval - Save - DB에 반영한다.(변경)<br>
	 *
	 * @param event EsdTrs0086Event
	 * @param account SignOnUserAccount
	 * @throws DAOException
	 */
	public void saveCntApro(EsdTrs0087Event event, SignOnUserAccount account) throws DAOException {
		try {
			int insCnt = 0;
			String dupFlg = "Y";
			
			SearchCntApprovalVO[] models = event.getSearchCntApprovalVOs();
			Map<String,Object> param = new HashMap<String,Object>();

			param.put("apro_ofc_cd"	, account.getOfc_cd());
			param.put("apro_usr_id"	, account.getUsr_id());
			param.put("cre_ofc_cd" 	, account.getOfc_cd());
			param.put("cre_usr_id"	, account.getUsr_id()); 
    		for(int f=0; models != null && f < models.length; f++) {
    			if (models[f].getSel().length() > 0) {
    				if (models[f].getSel().equals("1")) {
    					if(models[f].getIbflag().equals("I")){
    						Map<String, String> paramVo = models[f].getColumnValues();
    						param.putAll(paramVo);
    						
    						param.put("org_nod_cd"			, param.get("fm_nod_cd"));
    						param.put("org_nod_yard"		, param.get("fm_nod_yard"));
    						param.put("dest_nod_cd"			, param.get("dor_nod_cd"));
    						param.put("dest_nod_yard"		, param.get("dor_nod_yard"));
    						
    						StringBuffer sbMtyPkupRtnYdCd = new StringBuffer();
    						sbMtyPkupRtnYdCd.append(param.get("to_nod_cd"));
    						sbMtyPkupRtnYdCd.append(param.get("to_nod_yard"));
    						param.put("mty_pkup_rtn_yd_cd"	, sbMtyPkupRtnYdCd.toString());
    						
    						param.put("ctrt_cust_cd"		, param.get("ctrt_cust_cnt_cd"));

    						log.debug("param"+param);

    						DBRowSet dbRowset0 = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CustomerNominatedTruckerRgstDAOSearchCntRgstDupChkRSQL(),param,param);
    						if (dbRowset0.next()) {
    							dupFlg = dbRowset0.getString("DUP_FLG");
    						}
    						
    						if(!dupFlg.equals("N")){
    							throw new DAOException((new ErrorHandler("TRS50118",new String[]{""})).getMessage());
    						}
	
							insCnt =	new SQLExecuter().executeUpdate(new CustomerNominatedTruckerAproDAOSaveCntAproCSQL(), param, param);
							if(insCnt == Statement.EXECUTE_FAILED){
								throw new DAOException("Fail to Insert " + " SQL");						
					    	}
    					
    					}else if(models[f].getIbflag().equals("U")){
    						param.put("disp_sts_cd"					, models[f].getDispStsCd());
    						param.put("hjs_trkr_agmt_no"			, models[f].getHjsTrkrAgmtNo()); 
	    					param.put("org_nod_cd"					, models[f].getFmNodCd()+models[f].getFmNodYard());
	    					param.put("mty_pkup_rtn_yd_cd"			, models[f].getToNodCd()+models[f].getToNodYard());
	    					param.put("hjs_trkr_bzc_amt"			, models[f].getHjsTrkrBzcAmt()); 
	    					param.put("hjs_trkr_fuel_amt"			, models[f].getHjsTrkrFuelAmt()); 
	    					param.put("hjs_cust_nomi_trkr_agmt_no"	, models[f].getHjsCustNomiTrkrAgmtNo()); 
	    					param.put("apro_his_desc"				, models[f].getAproHisDesc()); 
	    					param.put("apro_no"						, models[f].getAproNo());
	    					param.put("cust_nomi_trkr_ind_cd"		, models[f].getCustNomiTrkrIndCd());
	    					
//	    					DBRowSet dbRowset0 = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CustomerNominatedTruckerRgstDAOSearchCntRgstDupChkRSQL(),param,param);
//    						if (dbRowset0.next()) {
//    							dupFlg = dbRowset0.getString("DUP_FLG");
//    						}
//    						
//    						if(dupFlg.equals("Y")){
//    							throw new DAOException((new ErrorHandler("TRS50118",new String[]{""})).getMessage());
//    						}
	
							insCnt =	new SQLExecuter().executeUpdate(new CustomerNominatedTruckerAproDAOSaveCntAproUSQL(), param, param);
							if(insCnt == Statement.EXECUTE_FAILED)
								throw new DAOException("Fail to update " + " SQL");						
					    	}
	    				}
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
	 * CNT(Customer Nominated Trucker) Approval - Cancel - DB에 반영한다.(변경)<br>
	 *
	 * @param event EsdTrs0087Event
	 * @param account SignOnUserAccount
	 * @throws DAOException
	 */
	public void updateCntCxl(EsdTrs0087Event event, SignOnUserAccount account) throws DAOException {
		try {
			int insCnt = 0;
			SearchCntApprovalVO[] models = event.getSearchCntApprovalVOs();
			Map<String,Object> param = new HashMap<String,Object>();

			param.put("apro_ofc_cd"	, account.getOfc_cd());
			param.put("apro_usr_id"	, account.getUsr_id());
			param.put("cre_ofc_cd" 	, account.getOfc_cd());
			param.put("cre_usr_id"	, account.getUsr_id()); 
    		for(int f=0; models != null && f < models.length; f++) {
    			if (models[f].getSel().length() > 0) {
    				if (models[f].getSel().equals("1")) {
    					param.put("hjs_trkr_agmt_no"			, models[f].getHjsTrkrAgmtNo()); 
    					param.put("hjs_trkr_bzc_amt"			, models[f].getHjsTrkrBzcAmt()); 
    					param.put("hjs_trkr_fuel_amt"			, models[f].getHjsTrkrFuelAmt()); 
    					param.put("hjs_cust_nomi_trkr_agmt_no"	, models[f].getHjsCustNomiTrkrAgmtNo()); 
    					param.put("apro_his_desc"				, models[f].getAproHisDesc()); 
    					param.put("apro_no"						, models[f].getAproNo()); 

						insCnt =	new SQLExecuter().executeUpdate(new CustomerNominatedTruckerAproDAOUpdateCntCxlUSQL(), param, param);
						if(insCnt == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to update " + " SQL");						
				    	}
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
	 * CNT(Customer Nominated Trucker) Registration 화면의 Destination을 조회하는 이벤트 처리<br>
	 *
	 * @param event EsdTrs0087Event
	 * @return DBRowSet
	 * @throws DAOException
	 */	
	public DBRowSet searchMtRtnYdNm(EsdTrs0087Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		
		param.put("rtn_yard", 	event.getTo_nod_cd()+event.getTo_nod_yard()  );
		
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new CustomerNominatedTruckerAproDAOSearchMtRtnYdNmRSQL(), param,param);
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
	 * CNT(Customer Nominated Trucker) Registration 화면의 AGMT No를 조회하는 이벤트 처리<br>
	 *
	 * @param event EsdTrs0087Event
	 * @return DBRowSet
	 * @throws DAOException
	 */	
	public DBRowSet searchAgmtNo(EsdTrs0087Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		
		
		param.put("vndr_seq",event.getVndr_seq());
		param.put("io_bnd_cd",event.getIo_bnd_cd());
		param.put("fm_nod",event.getFm_nod_cd()+event.getFm_nod_yard());
		param.put("dor_nod",event.getDor_nod_cd()+event.getDor_nod_yard());
		param.put("to_nod",event.getTo_nod_cd()+event.getTo_nod_yard());
		
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new CustomerNominatedTruckerAproDAOSearchAgmtNoRSQL(), param,param);
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
	 * CNT(Customer Nominated Trucker) Approval S/P 화면의 Vendor 조회하는 이벤트 처리<br>
	 * 
	 * @param event
	 * @return String
	 * @throws DAOException
	 */
	public String searchCntVendorCheck(EsdTrs0087Event event) throws DAOException {
		
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		String rtn_val = "";
		
		try{
			param.put("vndr_seq", event.getVndr_seq());
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(new CustomerNominatedTruckerAproDAOSearchCntVendorCheckRSQL(), param, param);
			while(dbRowset.next()){
				rtn_val = dbRowset.getString("VNDR_NM");
			}
				
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				throw new DAOException(new ErrorHandler(e).getMessage());
			}
			return rtn_val;
	}
	
	/**
	 * Grid Door Yard 변경시 Yard name 조회<br>
	 * @param event
	 * @return dbRowset
	 * @throws DAOException
	 */
	public DBRowSet searchCntAproDorYdNm(EsdTrs0087Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("dor_nod_cd", event.getDor_nod_cd());

		try{
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CustomerNominatedTruckerAproDAOSearchCntAproDorYdNmRSQL(), param, param);
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
	 * CNT(Customer Nominated Trucker) Approval - Delete - DB에 반영한다.(변경)<br>
	 *
	 * @param event EsdTrs0087Event
	 * @param account SignOnUserAccount
	 * @throws DAOException
	 */
	public void updateCntDel(EsdTrs0087Event event, SignOnUserAccount account) throws DAOException {
		try {
			int insCnt = 0;
			SearchCntApprovalVO[] models = event.getSearchCntApprovalVOs();
			Map<String,Object> param = new HashMap<String,Object>();

			param.put("apro_ofc_cd"	, account.getOfc_cd());
			param.put("apro_usr_id"	, account.getUsr_id());
			param.put("cre_ofc_cd" 	, account.getOfc_cd());
			param.put("cre_usr_id"	, account.getUsr_id()); 
    		for(int f=0; models != null && f < models.length; f++) {
    			if (models[f].getSel().length() > 0) {
    				if (models[f].getSel().equals("1")) {
    					param.put("hjs_trkr_agmt_no"			, models[f].getHjsTrkrAgmtNo()); 
    					param.put("hjs_trkr_bzc_amt"			, models[f].getHjsTrkrBzcAmt()); 
    					param.put("hjs_trkr_fuel_amt"			, models[f].getHjsTrkrFuelAmt()); 
    					param.put("hjs_cust_nomi_trkr_agmt_no"	, models[f].getHjsCustNomiTrkrAgmtNo()); 
    					param.put("apro_his_desc"				, models[f].getAproHisDesc()); 
    					param.put("apro_no"						, models[f].getAproNo()); 

						insCnt =	new SQLExecuter().executeUpdate(new CustomerNominatedTruckerAproDAOUpdateCntDelUSQL(), param, param);
						if(insCnt == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to update " + " SQL");						
				    	}
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
	 * Grid Door Yard 변경시 Location name 조회<br>
	 * @param event
	 * @return dbRowset
	 * @throws DAOException
	 */
	public DBRowSet searchCntAproDorLocNm(EsdTrs0087Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("dor_nod_cd", event.getDor_nod_cd());

		try{
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CustomerNominatedTruckerAproDAOSearchCntAproDorLocNmRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}
}

